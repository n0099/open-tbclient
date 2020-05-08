package com.baidu.tbadk.mvc.f;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
import com.baidu.tieba.tbadkCore.r;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements r {
    protected List<D> dataList;
    protected final TbPageContext<?> ecN;
    protected final ViewEventCenter ecO;
    private NoDataView ecQ;
    private FrameLayout ecR;
    private NoDataViewFactory.d ecS;
    private NoDataViewFactory.c ecT;
    private NoDataViewFactory.b ecU;
    private FrameLayout.LayoutParams ecV;
    protected S ecj;
    protected final List<H> ecL = new ArrayList();
    protected final SparseArray<H> ecM = new SparseArray<>();
    protected boolean ecP = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.ecN = tbPageContext;
        this.ecO = viewEventCenter;
    }

    public void aT(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void ah(D d) {
        if (d != null && this.dataList != null) {
            this.dataList.remove(d);
            notifyDataSetChanged();
        }
    }

    public void aU(List<D> list) {
        aV(list);
        notifyDataSetChanged();
    }

    public void ai(D d) {
        H h;
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.ecM.get(this.dataList.indexOf(d))) != null) {
            h.aj(d);
        }
    }

    protected void aV(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.clear();
            this.dataList.addAll(list);
            this.ecM.clear();
        }
    }

    public List<D> getDataList() {
        return this.dataList == null ? new ArrayList() : new ArrayList(this.dataList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dataList == null) {
            return 0;
        }
        if (this.dataList.size() == 0 && this.ecP) {
            return 1;
        }
        return this.dataList.size();
    }

    public int aYZ() {
        if (this.dataList == null) {
            return 0;
        }
        return this.dataList.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.dataList != null && this.dataList.size() != 0 && i >= 0 && i < this.dataList.size()) {
            return this.dataList.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dataList != null && this.dataList.size() != 0 && i >= 0 && i < this.dataList.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.ecL.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.ecL.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.ecQ != null) {
            this.ecQ.onChangeSkinType(this.ecN, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.ecM.indexOfValue(a) >= 0) {
            this.ecM.remove(a.getPosition());
        }
        this.ecM.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.ecN.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.ecN, inflate, this.ecO);
                h.b(this.ecN, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.ecL.add(h);
                return h;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (IllegalArgumentException e2) {
                throw e2;
            } catch (InstantiationException e3) {
                throw new RuntimeException(e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException(e4);
            } catch (SecurityException e5) {
                throw e5;
            } catch (InvocationTargetException e6) {
                throw new RuntimeException(e6);
            }
        }
        return (H) view.getTag();
    }

    private final void a(H h, int i) {
        D item = getItem(i);
        if (item != null) {
            h.position = i;
            h.a(item, this.ecj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aZa() {
        if (this.ecR != null && this.ecQ != null) {
            this.ecR.removeView(this.ecQ);
            this.ecQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aZb() {
        if (this.ecR == null) {
            this.ecR = new FrameLayout(this.ecN.getPageActivity());
        }
        if (this.ecQ == null) {
            this.ecQ = NoDataViewFactory.a(this.ecN.getPageActivity(), this.ecR, this.ecT, this.ecS, this.ecU);
        }
        this.ecQ.setVisibility(0);
        if (this.ecV != null) {
            this.ecQ.setLayoutParams(this.ecV);
        }
        this.ecR.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.ecQ.onChangeSkinType(this.ecN, TbadkCoreApplication.getInst().getSkinType());
        return this.ecR;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.ecT = cVar;
        this.ecS = dVar;
        this.ecU = bVar;
        this.ecV = layoutParams;
        if (this.ecQ != null) {
            this.ecQ.setTextOption(dVar);
            this.ecQ.setImgOption(cVar);
            this.ecQ.setButtonOption(bVar);
            if (layoutParams != null) {
                this.ecQ.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean FP() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

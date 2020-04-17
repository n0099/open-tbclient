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
    protected final TbPageContext<?> ecI;
    protected final ViewEventCenter ecJ;
    private NoDataView ecL;
    private FrameLayout ecM;
    private NoDataViewFactory.d ecN;
    private NoDataViewFactory.c ecO;
    private NoDataViewFactory.b ecP;
    private FrameLayout.LayoutParams ecQ;
    protected S ece;
    protected final List<H> ecG = new ArrayList();
    protected final SparseArray<H> ecH = new SparseArray<>();
    protected boolean ecK = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.ecI = tbPageContext;
        this.ecJ = viewEventCenter;
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

    public void ag(D d) {
        if (d != null && this.dataList != null) {
            this.dataList.remove(d);
            notifyDataSetChanged();
        }
    }

    public void aU(List<D> list) {
        aV(list);
        notifyDataSetChanged();
    }

    public void ah(D d) {
        H h;
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.ecH.get(this.dataList.indexOf(d))) != null) {
            h.ai(d);
        }
    }

    protected void aV(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.clear();
            this.dataList.addAll(list);
            this.ecH.clear();
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
        if (this.dataList.size() == 0 && this.ecK) {
            return 1;
        }
        return this.dataList.size();
    }

    public int aZb() {
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
        int size = this.ecG.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.ecG.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.ecL != null) {
            this.ecL.onChangeSkinType(this.ecI, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.ecH.indexOfValue(a) >= 0) {
            this.ecH.remove(a.getPosition());
        }
        this.ecH.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.ecI.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.ecI, inflate, this.ecJ);
                h.b(this.ecI, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.ecG.add(h);
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
            h.a(item, this.ece);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aZc() {
        if (this.ecM != null && this.ecL != null) {
            this.ecM.removeView(this.ecL);
            this.ecL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aZd() {
        if (this.ecM == null) {
            this.ecM = new FrameLayout(this.ecI.getPageActivity());
        }
        if (this.ecL == null) {
            this.ecL = NoDataViewFactory.a(this.ecI.getPageActivity(), this.ecM, this.ecO, this.ecN, this.ecP);
        }
        this.ecL.setVisibility(0);
        if (this.ecQ != null) {
            this.ecL.setLayoutParams(this.ecQ);
        }
        this.ecM.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.ecL.onChangeSkinType(this.ecI, TbadkCoreApplication.getInst().getSkinType());
        return this.ecM;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.ecO = cVar;
        this.ecN = dVar;
        this.ecP = bVar;
        this.ecQ = layoutParams;
        if (this.ecL != null) {
            this.ecL.setTextOption(dVar);
            this.ecL.setImgOption(cVar);
            this.ecL.setButtonOption(bVar);
            if (layoutParams != null) {
                this.ecL.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean FQ() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

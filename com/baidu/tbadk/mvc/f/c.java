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
import com.baidu.tieba.tbadkCore.s;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements s {
    protected List<D> dataList;
    protected final TbPageContext<?> eTI;
    protected final ViewEventCenter eTJ;
    private NoDataView eTL;
    private FrameLayout eTM;
    private NoDataViewFactory.d eTN;
    private NoDataViewFactory.c eTO;
    private NoDataViewFactory.b eTP;
    private FrameLayout.LayoutParams eTQ;
    protected S eTe;
    protected final List<H> eTG = new ArrayList();
    protected final SparseArray<H> eTH = new SparseArray<>();
    protected boolean eTK = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.eTI = tbPageContext;
        this.eTJ = viewEventCenter;
    }

    public void bi(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void ap(D d) {
        if (d != null && this.dataList != null) {
            this.dataList.remove(d);
            notifyDataSetChanged();
        }
    }

    public void bj(List<D> list) {
        bk(list);
        notifyDataSetChanged();
    }

    public void aq(D d) {
        H h;
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.eTH.get(this.dataList.indexOf(d))) != null) {
            h.ar(d);
        }
    }

    protected void bk(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.clear();
            this.dataList.addAll(list);
            this.eTH.clear();
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
        if (this.dataList.size() == 0 && this.eTK) {
            return 1;
        }
        return this.dataList.size();
    }

    public int buR() {
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

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.eTG.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.eTG.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.eTL != null) {
            this.eTL.onChangeSkinType(this.eTI, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.eTH.indexOfValue(a) >= 0) {
            this.eTH.remove(a.getPosition());
        }
        this.eTH.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.eTI.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.eTI, inflate, this.eTJ);
                h.b(this.eTI, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.eTG.add(h);
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
            h.a(item, this.eTe);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void buS() {
        if (this.eTM != null && this.eTL != null) {
            this.eTM.removeView(this.eTL);
            this.eTL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View buT() {
        if (this.eTM == null) {
            this.eTM = new FrameLayout(this.eTI.getPageActivity());
        }
        if (this.eTL == null) {
            this.eTL = NoDataViewFactory.a(this.eTI.getPageActivity(), this.eTM, this.eTO, this.eTN, this.eTP);
        }
        this.eTL.setVisibility(0);
        if (this.eTQ != null) {
            this.eTL.setLayoutParams(this.eTQ);
        }
        this.eTM.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.eTL.onChangeSkinType(this.eTI, TbadkCoreApplication.getInst().getSkinType());
        return this.eTM;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.eTO = cVar;
        this.eTN = dVar;
        this.eTP = bVar;
        this.eTQ = layoutParams;
        if (this.eTL != null) {
            this.eTL.setTextOption(dVar);
            this.eTL.setImgOption(cVar);
            this.eTL.setButtonOption(bVar);
            if (layoutParams != null) {
                this.eTL.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean buU() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

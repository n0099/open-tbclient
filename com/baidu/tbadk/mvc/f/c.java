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
import com.baidu.tieba.tbadkCore.t;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements t {
    protected List<D> dataList;
    protected final TbPageContext<?> fKL;
    protected final ViewEventCenter fKM;
    private NoDataView fKO;
    private FrameLayout fKP;
    private NoDataViewFactory.d fKQ;
    private NoDataViewFactory.c fKR;
    private NoDataViewFactory.b fKS;
    private FrameLayout.LayoutParams fKT;
    protected S fKi;
    protected final List<H> fKJ = new ArrayList();
    protected final SparseArray<H> fKK = new SparseArray<>();
    protected boolean fKN = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.fKL = tbPageContext;
        this.fKM = viewEventCenter;
    }

    public void bM(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void au(D d) {
        if (d != null && this.dataList != null) {
            this.dataList.remove(d);
            notifyDataSetChanged();
        }
    }

    public void bN(List<D> list) {
        bO(list);
        notifyDataSetChanged();
    }

    public void av(D d) {
        H h;
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.fKK.get(this.dataList.indexOf(d))) != null) {
            h.aw(d);
        }
    }

    protected void bO(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.clear();
            this.dataList.addAll(list);
            this.fKK.clear();
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
        if (this.dataList.size() == 0 && this.fKN) {
            return 1;
        }
        return this.dataList.size();
    }

    public int bHg() {
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

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.fKJ.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.fKJ.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.fKO != null) {
            this.fKO.onChangeSkinType(this.fKL, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a2 = a(view, cls, i2);
        if (this.fKK.indexOfValue(a2) >= 0) {
            this.fKK.remove(a2.getPosition());
        }
        this.fKK.put(i, a2);
        a(a2, i);
        return a2.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.fKL.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.fKL, inflate, this.fKM);
                h.b(this.fKL, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.fKJ.add(h);
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
            h.a(item, this.fKi);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bHh() {
        if (this.fKP != null && this.fKO != null) {
            this.fKP.removeView(this.fKO);
            this.fKO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bHi() {
        if (this.fKP == null) {
            this.fKP = new FrameLayout(this.fKL.getPageActivity());
        }
        if (this.fKO == null) {
            this.fKO = NoDataViewFactory.a(this.fKL.getPageActivity(), this.fKP, this.fKR, this.fKQ, this.fKS);
        }
        this.fKO.setVisibility(0);
        if (this.fKT != null) {
            this.fKO.setLayoutParams(this.fKT);
        }
        this.fKP.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fKO.onChangeSkinType(this.fKL, TbadkCoreApplication.getInst().getSkinType());
        return this.fKP;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.fKR = cVar;
        this.fKQ = dVar;
        this.fKS = bVar;
        this.fKT = layoutParams;
        if (this.fKO != null) {
            this.fKO.setTextOption(dVar);
            this.fKO.setImgOption(cVar);
            this.fKO.setButtonOption(bVar);
            if (layoutParams != null) {
                this.fKO.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isDataEmpty() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

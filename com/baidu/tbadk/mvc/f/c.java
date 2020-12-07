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
    protected S fAC;
    protected final TbPageContext<?> fBf;
    protected final ViewEventCenter fBg;
    private NoDataView fBi;
    private FrameLayout fBj;
    private NoDataViewFactory.d fBk;
    private NoDataViewFactory.c fBl;
    private NoDataViewFactory.b fBm;
    private FrameLayout.LayoutParams fBn;
    protected final List<H> fBd = new ArrayList();
    protected final SparseArray<H> fBe = new SparseArray<>();
    protected boolean fBh = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.fBf = tbPageContext;
        this.fBg = viewEventCenter;
    }

    public void bF(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void as(D d) {
        if (d != null && this.dataList != null) {
            this.dataList.remove(d);
            notifyDataSetChanged();
        }
    }

    public void bG(List<D> list) {
        bH(list);
        notifyDataSetChanged();
    }

    public void at(D d) {
        H h;
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.fBe.get(this.dataList.indexOf(d))) != null) {
            h.au(d);
        }
    }

    protected void bH(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.clear();
            this.dataList.addAll(list);
            this.fBe.clear();
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
        if (this.dataList.size() == 0 && this.fBh) {
            return 1;
        }
        return this.dataList.size();
    }

    public int bEL() {
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
        int size = this.fBd.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.fBd.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.fBi != null) {
            this.fBi.onChangeSkinType(this.fBf, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a2 = a(view, cls, i2);
        if (this.fBe.indexOfValue(a2) >= 0) {
            this.fBe.remove(a2.getPosition());
        }
        this.fBe.put(i, a2);
        a(a2, i);
        return a2.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.fBf.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.fBf, inflate, this.fBg);
                h.b(this.fBf, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.fBd.add(h);
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
            h.a(item, this.fAC);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bEM() {
        if (this.fBj != null && this.fBi != null) {
            this.fBj.removeView(this.fBi);
            this.fBi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bEN() {
        if (this.fBj == null) {
            this.fBj = new FrameLayout(this.fBf.getPageActivity());
        }
        if (this.fBi == null) {
            this.fBi = NoDataViewFactory.a(this.fBf.getPageActivity(), this.fBj, this.fBl, this.fBk, this.fBm);
        }
        this.fBi.setVisibility(0);
        if (this.fBn != null) {
            this.fBi.setLayoutParams(this.fBn);
        }
        this.fBj.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fBi.onChangeSkinType(this.fBf, TbadkCoreApplication.getInst().getSkinType());
        return this.fBj;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.fBl = cVar;
        this.fBk = dVar;
        this.fBm = bVar;
        this.fBn = layoutParams;
        if (this.fBi != null) {
            this.fBi.setTextOption(dVar);
            this.fBi.setImgOption(cVar);
            this.fBi.setButtonOption(bVar);
            if (layoutParams != null) {
                this.fBi.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bEO() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

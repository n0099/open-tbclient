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
import com.baidu.tieba.tbadkCore.o;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements o {
    protected List<D> aom;
    protected S baL;
    private NoDataViewFactory.d bbA;
    private NoDataViewFactory.c bbB;
    private NoDataViewFactory.b bbC;
    private FrameLayout.LayoutParams bbD;
    protected final TbPageContext<?> bbv;
    protected final ViewEventCenter bbw;
    private NoDataView bby;
    private FrameLayout bbz;
    protected final List<H> bbt = new ArrayList();
    protected final SparseArray<H> bbu = new SparseArray<>();
    protected boolean bbx = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.bbv = tbPageContext;
        this.bbw = viewEventCenter;
    }

    public void Q(List<D> list) {
        if (list != null) {
            if (this.aom == null) {
                this.aom = new ArrayList();
            }
            this.aom.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void J(D d) {
        if (d != null && this.aom != null) {
            this.aom.remove(d);
            notifyDataSetChanged();
        }
    }

    public void R(List<D> list) {
        S(list);
        notifyDataSetChanged();
    }

    public void K(D d) {
        H h;
        if (d != null && this.aom != null && this.aom.contains(d) && (h = this.bbu.get(this.aom.indexOf(d))) != null) {
            h.L(d);
        }
    }

    protected void S(List<D> list) {
        if (list != null) {
            if (this.aom == null) {
                this.aom = new ArrayList();
            }
            this.aom.clear();
            this.aom.addAll(list);
            this.bbu.clear();
        }
    }

    public List<D> getDataList() {
        return this.aom == null ? new ArrayList() : new ArrayList(this.aom);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aom == null) {
            return 0;
        }
        if (this.aom.size() == 0 && this.bbx) {
            return 1;
        }
        return this.aom.size();
    }

    public int ND() {
        if (this.aom == null) {
            return 0;
        }
        return this.aom.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.aom != null && this.aom.size() != 0 && i >= 0 && i < this.aom.size()) {
            return this.aom.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aom != null && this.aom.size() != 0 && i >= 0 && i < this.aom.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.bbt.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.bbt.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.bby != null) {
            this.bby.onChangeSkinType(this.bbv, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.bbu.indexOfValue(a) >= 0) {
            this.bbu.remove(a.getPosition());
        }
        this.bbu.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.bbv.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.bbv, inflate, this.bbw);
                h.b(this.bbv, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.bbt.add(h);
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
            h.a(item, this.baL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void NE() {
        if (this.bbz != null && this.bby != null) {
            this.bbz.removeView(this.bby);
            this.bby = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View NF() {
        if (this.bbz == null) {
            this.bbz = new FrameLayout(this.bbv.getPageActivity());
        }
        if (this.bby == null) {
            this.bby = NoDataViewFactory.a(this.bbv.getPageActivity(), this.bbz, this.bbB, this.bbA, this.bbC);
        }
        this.bby.setVisibility(0);
        if (this.bbD != null) {
            this.bby.setLayoutParams(this.bbD);
        }
        this.bbz.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.bby.onChangeSkinType(this.bbv, TbadkCoreApplication.getInst().getSkinType());
        return this.bbz;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.bbB = cVar;
        this.bbA = dVar;
        this.bbC = bVar;
        this.bbD = layoutParams;
        if (this.bby != null) {
            this.bby.setTextOption(dVar);
            this.bby.setImgOption(cVar);
            this.bby.setButtonOption(bVar);
            if (layoutParams != null) {
                this.bby.setLayoutParams(layoutParams);
            }
        }
    }

    public void cH(boolean z) {
        this.bbx = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean NG() {
        return this.aom != null && this.aom.size() == 0;
    }
}

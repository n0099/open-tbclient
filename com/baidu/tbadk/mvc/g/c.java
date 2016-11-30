package com.baidu.tbadk.mvc.g;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.w;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.g.a;
import com.baidu.tieba.tbadkCore.s;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements s {
    protected S aAk;
    protected List<D> aBc;
    protected final TbPageContext<?> aBf;
    protected final ViewEventCenter aBg;
    private w aBi;
    private FrameLayout aBj;
    private NoDataViewFactory.d aBk;
    private NoDataViewFactory.c aBl;
    private NoDataViewFactory.b aBm;
    private FrameLayout.LayoutParams aBn;
    protected final List<H> aBd = new ArrayList();
    protected final SparseArray<H> aBe = new SparseArray<>();
    protected boolean aBh = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aBf = tbPageContext;
        this.aBg = viewEventCenter;
    }

    public void z(List<D> list) {
        if (list != null) {
            if (this.aBc == null) {
                this.aBc = new ArrayList();
            }
            this.aBc.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void C(D d) {
        if (d != null && this.aBc != null) {
            this.aBc.remove(d);
            notifyDataSetChanged();
        }
    }

    public void A(List<D> list) {
        B(list);
        notifyDataSetChanged();
    }

    public void a(S s) {
        b(s);
        notifyDataSetChanged();
    }

    public void D(D d) {
        H h;
        if (d != null && this.aBc != null && this.aBc.contains(d) && (h = this.aBe.get(this.aBc.indexOf(d))) != null) {
            h.E(d);
        }
    }

    protected void B(List<D> list) {
        if (list != null) {
            if (this.aBc == null) {
                this.aBc = new ArrayList();
            }
            this.aBc.clear();
            this.aBc.addAll(list);
            this.aBe.clear();
        }
    }

    protected void b(S s) {
        this.aAk = s;
    }

    public List<D> Fy() {
        return this.aBc == null ? new ArrayList() : new ArrayList(this.aBc);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aBc == null) {
            return 0;
        }
        if (this.aBc.size() == 0 && this.aBh) {
            return 1;
        }
        return this.aBc.size();
    }

    public int Fz() {
        if (this.aBc == null) {
            return 0;
        }
        return this.aBc.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.aBc != null && this.aBc.size() != 0 && i >= 0 && i < this.aBc.size()) {
            return this.aBc.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aBc != null && this.aBc.size() != 0 && i >= 0 && i < this.aBc.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.aBd.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aBd.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.aBi != null) {
            this.aBi.onChangeSkinType(this.aBf, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aBe.indexOfValue(a) >= 0) {
            this.aBe.remove(a.getPosition());
        }
        this.aBe.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aBf.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aBf, inflate, this.aBg);
                h.a(this.aBf, TbadkCoreApplication.m9getInst().getSkinType());
                inflate.setTag(h);
                this.aBd.add(h);
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
            h.a(item, this.aAk);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FA() {
        if (this.aBj != null && this.aBi != null) {
            this.aBj.removeView(this.aBi);
            this.aBi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View FB() {
        if (this.aBj == null) {
            this.aBj = new FrameLayout(this.aBf.getPageActivity());
        }
        if (this.aBi == null) {
            this.aBi = NoDataViewFactory.a(this.aBf.getPageActivity(), this.aBj, this.aBl, this.aBk, this.aBm);
        }
        this.aBi.setVisibility(0);
        if (this.aBn != null) {
            this.aBi.setLayoutParams(this.aBn);
        }
        this.aBj.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aBi.onChangeSkinType(this.aBf, TbadkCoreApplication.m9getInst().getSkinType());
        return this.aBj;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aBl = cVar;
        this.aBk = dVar;
        this.aBm = bVar;
        this.aBn = layoutParams;
        if (this.aBi != null) {
            this.aBi.setTextOption(dVar);
            this.aBi.setImgOption(cVar);
            this.aBi.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aBi.setLayoutParams(layoutParams);
            }
        }
    }

    public void bT(boolean z) {
        this.aBh = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean FC() {
        return this.aBc != null && this.aBc.size() == 0;
    }
}

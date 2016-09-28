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
import com.baidu.tbadk.core.view.v;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.g.a;
import com.baidu.tieba.tbadkCore.s;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements s {
    protected List<D> aAk;
    protected final TbPageContext<?> aAn;
    protected final ViewEventCenter aAo;
    private v aAq;
    private FrameLayout aAr;
    private NoDataViewFactory.d aAs;
    private NoDataViewFactory.c aAt;
    private NoDataViewFactory.b aAu;
    private FrameLayout.LayoutParams aAv;
    protected S azs;
    protected final List<H> aAl = new ArrayList();
    protected final SparseArray<H> aAm = new SparseArray<>();
    protected boolean aAp = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aAn = tbPageContext;
        this.aAo = viewEventCenter;
    }

    public void z(List<D> list) {
        if (list != null) {
            if (this.aAk == null) {
                this.aAk = new ArrayList();
            }
            this.aAk.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void C(D d) {
        if (d != null && this.aAk != null) {
            this.aAk.remove(d);
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
        if (d != null && this.aAk != null && this.aAk.contains(d) && (h = this.aAm.get(this.aAk.indexOf(d))) != null) {
            h.E(d);
        }
    }

    protected void B(List<D> list) {
        if (list != null) {
            if (this.aAk == null) {
                this.aAk = new ArrayList();
            }
            this.aAk.clear();
            this.aAk.addAll(list);
            this.aAm.clear();
        }
    }

    protected void b(S s) {
        this.azs = s;
    }

    public List<D> Ft() {
        return this.aAk == null ? new ArrayList() : new ArrayList(this.aAk);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aAk == null) {
            return 0;
        }
        if (this.aAk.size() == 0 && this.aAp) {
            return 1;
        }
        return this.aAk.size();
    }

    public int Fu() {
        if (this.aAk == null) {
            return 0;
        }
        return this.aAk.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.aAk != null && this.aAk.size() != 0 && i >= 0 && i < this.aAk.size()) {
            return this.aAk.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aAk != null && this.aAk.size() != 0 && i >= 0 && i < this.aAk.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.aAl.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aAl.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.aAq != null) {
            this.aAq.onChangeSkinType(this.aAn, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aAm.indexOfValue(a) >= 0) {
            this.aAm.remove(a.getPosition());
        }
        this.aAm.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aAn.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aAn, inflate, this.aAo);
                h.a(this.aAn, TbadkCoreApplication.m9getInst().getSkinType());
                inflate.setTag(h);
                this.aAl.add(h);
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
            h.a(item, this.azs);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fv() {
        if (this.aAr != null && this.aAq != null) {
            this.aAr.removeView(this.aAq);
            this.aAq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Fw() {
        if (this.aAr == null) {
            this.aAr = new FrameLayout(this.aAn.getPageActivity());
        }
        if (this.aAq == null) {
            this.aAq = NoDataViewFactory.a(this.aAn.getPageActivity(), this.aAr, this.aAt, this.aAs, this.aAu);
        }
        this.aAq.setVisibility(0);
        if (this.aAv != null) {
            this.aAq.setLayoutParams(this.aAv);
        }
        this.aAr.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aAq.onChangeSkinType(this.aAn, TbadkCoreApplication.m9getInst().getSkinType());
        return this.aAr;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aAt = cVar;
        this.aAs = dVar;
        this.aAu = bVar;
        this.aAv = layoutParams;
        if (this.aAq != null) {
            this.aAq.setTextOption(dVar);
            this.aAq.setImgOption(cVar);
            this.aAq.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aAq.setLayoutParams(layoutParams);
            }
        }
    }

    public void bP(boolean z) {
        this.aAp = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Fx() {
        return this.aAk != null && this.aAk.size() == 0;
    }
}

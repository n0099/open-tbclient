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
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.g.a;
import com.baidu.tieba.tbadkCore.s;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements s {
    protected S ayu;
    protected List<D> azm;
    protected final TbPageContext<?> azp;
    protected final ViewEventCenter azq;
    private o azs;
    private FrameLayout azt;
    private NoDataViewFactory.d azu;
    private NoDataViewFactory.c azv;
    private NoDataViewFactory.b azw;
    private FrameLayout.LayoutParams azx;
    protected final List<H> azn = new ArrayList();
    protected final SparseArray<H> azo = new SparseArray<>();
    protected boolean azr = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.azp = tbPageContext;
        this.azq = viewEventCenter;
    }

    public void v(List<D> list) {
        if (list != null) {
            if (this.azm == null) {
                this.azm = new ArrayList();
            }
            this.azm.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void z(D d) {
        if (d != null && this.azm != null) {
            this.azm.remove(d);
            notifyDataSetChanged();
        }
    }

    public void w(List<D> list) {
        x(list);
        notifyDataSetChanged();
    }

    public void a(S s) {
        b(s);
        notifyDataSetChanged();
    }

    public void A(D d) {
        H h;
        if (d != null && this.azm != null && this.azm.contains(d) && (h = this.azo.get(this.azm.indexOf(d))) != null) {
            h.B(d);
        }
    }

    protected void x(List<D> list) {
        if (list != null) {
            if (this.azm == null) {
                this.azm = new ArrayList();
            }
            this.azm.clear();
            this.azm.addAll(list);
            this.azo.clear();
        }
    }

    protected void b(S s) {
        this.ayu = s;
    }

    public List<D> Fm() {
        return this.azm == null ? new ArrayList() : new ArrayList(this.azm);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.azm == null) {
            return 0;
        }
        if (this.azm.size() == 0 && this.azr) {
            return 1;
        }
        return this.azm.size();
    }

    public int Fn() {
        if (this.azm == null) {
            return 0;
        }
        return this.azm.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.azm != null && this.azm.size() != 0 && i >= 0 && i < this.azm.size()) {
            return this.azm.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.azm != null && this.azm.size() != 0 && i >= 0 && i < this.azm.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.azn.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.azn.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.azs != null) {
            this.azs.onChangeSkinType(this.azp, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.azo.indexOfValue(a) >= 0) {
            this.azo.remove(a.getPosition());
        }
        this.azo.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.azp.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.azp, inflate, this.azq);
                h.a(this.azp, TbadkCoreApplication.m411getInst().getSkinType());
                inflate.setTag(h);
                this.azn.add(h);
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
            h.a(item, this.ayu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fo() {
        if (this.azt != null && this.azs != null) {
            this.azt.removeView(this.azs);
            this.azs = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Fp() {
        if (this.azt == null) {
            this.azt = new FrameLayout(this.azp.getPageActivity());
        }
        if (this.azs == null) {
            this.azs = NoDataViewFactory.a(this.azp.getPageActivity(), this.azt, this.azv, this.azu, this.azw);
        }
        this.azs.setVisibility(0);
        if (this.azx != null) {
            this.azs.setLayoutParams(this.azx);
        }
        this.azt.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.azs.onChangeSkinType(this.azp, TbadkCoreApplication.m411getInst().getSkinType());
        return this.azt;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.azv = cVar;
        this.azu = dVar;
        this.azw = bVar;
        this.azx = layoutParams;
        if (this.azs != null) {
            this.azs.setTextOption(dVar);
            this.azs.setImgOption(cVar);
            this.azs.setButtonOption(bVar);
            if (layoutParams != null) {
                this.azs.setLayoutParams(layoutParams);
            }
        }
    }

    public void bB(boolean z) {
        this.azr = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Fq() {
        return this.azm != null && this.azm.size() == 0;
    }
}

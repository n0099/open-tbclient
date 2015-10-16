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
import com.baidu.tbadk.core.view.m;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.g.a;
import com.baidu.tieba.tbadkCore.s;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements s {
    protected S avf;
    protected List<D> awa;
    protected final TbPageContext<?> awd;
    protected final ViewEventCenter awe;
    private m awg;
    private FrameLayout awh;
    private NoDataViewFactory.d awi;
    private NoDataViewFactory.c awj;
    private NoDataViewFactory.b awk;
    private FrameLayout.LayoutParams awl;
    protected final List<H> awb = new ArrayList();
    protected final SparseArray<H> awc = new SparseArray<>();
    protected boolean awf = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.awd = tbPageContext;
        this.awe = viewEventCenter;
    }

    public void q(List<D> list) {
        if (list != null) {
            if (this.awa == null) {
                this.awa = new ArrayList();
            }
            this.awa.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void z(D d) {
        if (d != null && this.awa != null) {
            this.awa.remove(d);
            notifyDataSetChanged();
        }
    }

    public void r(List<D> list) {
        s(list);
        notifyDataSetChanged();
    }

    public void a(S s) {
        b(s);
        notifyDataSetChanged();
    }

    public void A(D d) {
        H h;
        if (d != null && this.awa != null && this.awa.contains(d) && (h = this.awc.get(this.awa.indexOf(d))) != null) {
            h.B(d);
        }
    }

    protected void s(List<D> list) {
        if (list != null) {
            if (this.awa == null) {
                this.awa = new ArrayList();
            }
            this.awa.clear();
            this.awa.addAll(list);
            this.awc.clear();
        }
    }

    protected void b(S s) {
        this.avf = s;
    }

    public List<D> Dm() {
        return this.awa == null ? new ArrayList() : new ArrayList(this.awa);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.awa == null) {
            return 0;
        }
        if (this.awa.size() == 0 && this.awf) {
            return 1;
        }
        return this.awa.size();
    }

    public int Dn() {
        if (this.awa == null) {
            return 0;
        }
        return this.awa.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.awa != null && this.awa.size() != 0 && i >= 0 && i < this.awa.size()) {
            return this.awa.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.awa != null && this.awa.size() != 0 && i >= 0 && i < this.awa.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.awb.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.awb.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.awg != null) {
            this.awg.onChangeSkinType(this.awd, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.awc.indexOfValue(a) >= 0) {
            this.awc.remove(a.getPosition());
        }
        this.awc.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.awd.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.awd, inflate, this.awe);
                h.a(this.awd, TbadkCoreApplication.m411getInst().getSkinType());
                inflate.setTag(h);
                this.awb.add(h);
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
            h.a(item, this.avf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Do() {
        if (this.awh != null && this.awg != null) {
            this.awh.removeView(this.awg);
            this.awg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View createNoDataView() {
        if (this.awh == null) {
            this.awh = new FrameLayout(this.awd.getPageActivity());
        }
        if (this.awg == null) {
            this.awg = NoDataViewFactory.a(this.awd.getPageActivity(), this.awh, this.awj, this.awi, this.awk);
        }
        this.awg.setVisibility(0);
        if (this.awl != null) {
            this.awg.setLayoutParams(this.awl);
        }
        this.awh.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.awg.onChangeSkinType(this.awd, TbadkCoreApplication.m411getInst().getSkinType());
        return this.awh;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.awj = cVar;
        this.awi = dVar;
        this.awk = bVar;
        this.awl = layoutParams;
        if (this.awg != null) {
            this.awg.setTextOption(dVar);
            this.awg.setImgOption(cVar);
            this.awg.setButtonOption(bVar);
            if (layoutParams != null) {
                this.awg.setLayoutParams(layoutParams);
            }
        }
    }

    public void bo(boolean z) {
        this.awf = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Dp() {
        return this.awa != null && this.awa.size() == 0;
    }
}

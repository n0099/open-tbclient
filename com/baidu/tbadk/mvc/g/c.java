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
    protected List<D> avZ;
    protected S ave;
    protected final TbPageContext<?> awc;
    protected final ViewEventCenter awd;
    private m awf;
    private FrameLayout awg;
    private NoDataViewFactory.d awh;
    private NoDataViewFactory.c awi;
    private NoDataViewFactory.b awj;
    private FrameLayout.LayoutParams awk;
    protected final List<H> awa = new ArrayList();
    protected final SparseArray<H> awb = new SparseArray<>();
    protected boolean awe = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.awc = tbPageContext;
        this.awd = viewEventCenter;
    }

    public void q(List<D> list) {
        if (list != null) {
            if (this.avZ == null) {
                this.avZ = new ArrayList();
            }
            this.avZ.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void z(D d) {
        if (d != null && this.avZ != null) {
            this.avZ.remove(d);
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
        if (d != null && this.avZ != null && this.avZ.contains(d) && (h = this.awb.get(this.avZ.indexOf(d))) != null) {
            h.B(d);
        }
    }

    protected void s(List<D> list) {
        if (list != null) {
            if (this.avZ == null) {
                this.avZ = new ArrayList();
            }
            this.avZ.clear();
            this.avZ.addAll(list);
            this.awb.clear();
        }
    }

    protected void b(S s) {
        this.ave = s;
    }

    public List<D> Dm() {
        return this.avZ == null ? new ArrayList() : new ArrayList(this.avZ);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.avZ == null) {
            return 0;
        }
        if (this.avZ.size() == 0 && this.awe) {
            return 1;
        }
        return this.avZ.size();
    }

    public int Dn() {
        if (this.avZ == null) {
            return 0;
        }
        return this.avZ.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.avZ != null && this.avZ.size() != 0 && i >= 0 && i < this.avZ.size()) {
            return this.avZ.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.avZ != null && this.avZ.size() != 0 && i >= 0 && i < this.avZ.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.awa.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.awa.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.awf != null) {
            this.awf.onChangeSkinType(this.awc, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.awb.indexOfValue(a) >= 0) {
            this.awb.remove(a.getPosition());
        }
        this.awb.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.awc.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.awc, inflate, this.awd);
                h.a(this.awc, TbadkCoreApplication.m411getInst().getSkinType());
                inflate.setTag(h);
                this.awa.add(h);
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
            h.a(item, this.ave);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Do() {
        if (this.awg != null && this.awf != null) {
            this.awg.removeView(this.awf);
            this.awf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View createNoDataView() {
        if (this.awg == null) {
            this.awg = new FrameLayout(this.awc.getPageActivity());
        }
        if (this.awf == null) {
            this.awf = NoDataViewFactory.a(this.awc.getPageActivity(), this.awg, this.awi, this.awh, this.awj);
        }
        this.awf.setVisibility(0);
        if (this.awk != null) {
            this.awf.setLayoutParams(this.awk);
        }
        this.awg.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.awf.onChangeSkinType(this.awc, TbadkCoreApplication.m411getInst().getSkinType());
        return this.awg;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.awi = cVar;
        this.awh = dVar;
        this.awj = bVar;
        this.awk = layoutParams;
        if (this.awf != null) {
            this.awf.setTextOption(dVar);
            this.awf.setImgOption(cVar);
            this.awf.setButtonOption(bVar);
            if (layoutParams != null) {
                this.awf.setLayoutParams(layoutParams);
            }
        }
    }

    public void bo(boolean z) {
        this.awe = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Dp() {
        return this.avZ != null && this.avZ.size() == 0;
    }
}

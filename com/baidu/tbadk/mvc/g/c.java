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
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.g.a;
import com.baidu.tieba.tbadkCore.s;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements s {
    protected List<D> avW;
    protected final TbPageContext<?> avZ;
    protected S avd;
    protected final ViewEventCenter awa;
    private q awc;
    private FrameLayout awd;
    private NoDataViewFactory.d awe;
    private NoDataViewFactory.c awf;
    private NoDataViewFactory.b awg;
    private FrameLayout.LayoutParams awh;
    protected final List<H> avX = new ArrayList();
    protected final SparseArray<H> avY = new SparseArray<>();
    protected boolean awb = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.avZ = tbPageContext;
        this.awa = viewEventCenter;
    }

    public void y(List<D> list) {
        if (list != null) {
            if (this.avW == null) {
                this.avW = new ArrayList();
            }
            this.avW.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void z(D d) {
        if (d != null && this.avW != null) {
            this.avW.remove(d);
            notifyDataSetChanged();
        }
    }

    public void z(List<D> list) {
        A((List) list);
        notifyDataSetChanged();
    }

    public void a(S s) {
        b(s);
        notifyDataSetChanged();
    }

    public void A(D d) {
        H h;
        if (d != null && this.avW != null && this.avW.contains(d) && (h = this.avY.get(this.avW.indexOf(d))) != null) {
            h.B(d);
        }
    }

    protected void A(List<D> list) {
        if (list != null) {
            if (this.avW == null) {
                this.avW = new ArrayList();
            }
            this.avW.clear();
            this.avW.addAll(list);
            this.avY.clear();
        }
    }

    protected void b(S s) {
        this.avd = s;
    }

    public List<D> DR() {
        return this.avW == null ? new ArrayList() : new ArrayList(this.avW);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.avW == null) {
            return 0;
        }
        if (this.avW.size() == 0 && this.awb) {
            return 1;
        }
        return this.avW.size();
    }

    public int DS() {
        if (this.avW == null) {
            return 0;
        }
        return this.avW.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.avW != null && this.avW.size() != 0 && i >= 0 && i < this.avW.size()) {
            return this.avW.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.avW != null && this.avW.size() != 0 && i >= 0 && i < this.avW.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.avX.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.avX.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.awc != null) {
            this.awc.onChangeSkinType(this.avZ, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.avY.indexOfValue(a) >= 0) {
            this.avY.remove(a.getPosition());
        }
        this.avY.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.avZ.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.avZ, inflate, this.awa);
                h.a(this.avZ, TbadkCoreApplication.m11getInst().getSkinType());
                inflate.setTag(h);
                this.avX.add(h);
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
            h.a(item, this.avd);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DT() {
        if (this.awd != null && this.awc != null) {
            this.awd.removeView(this.awc);
            this.awc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View DU() {
        if (this.awd == null) {
            this.awd = new FrameLayout(this.avZ.getPageActivity());
        }
        if (this.awc == null) {
            this.awc = NoDataViewFactory.a(this.avZ.getPageActivity(), this.awd, this.awf, this.awe, this.awg);
        }
        this.awc.setVisibility(0);
        if (this.awh != null) {
            this.awc.setLayoutParams(this.awh);
        }
        this.awd.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.awc.onChangeSkinType(this.avZ, TbadkCoreApplication.m11getInst().getSkinType());
        return this.awd;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.awf = cVar;
        this.awe = dVar;
        this.awg = bVar;
        this.awh = layoutParams;
        if (this.awc != null) {
            this.awc.setTextOption(dVar);
            this.awc.setImgOption(cVar);
            this.awc.setButtonOption(bVar);
            if (layoutParams != null) {
                this.awc.setLayoutParams(layoutParams);
            }
        }
    }

    public void bM(boolean z) {
        this.awb = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean DV() {
        return this.avW != null && this.avW.size() == 0;
    }
}

package com.baidu.tbadk.mvc.j;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.core.view.z;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.e.c;
import com.baidu.tbadk.mvc.j.a;
import com.baidu.tieba.tbadkCore.y;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b<D, S extends com.baidu.tbadk.mvc.e.c, H extends a<D, S>> extends BaseAdapter implements y {
    protected S adY;
    protected List<D> afk;
    protected final TbPageContext<?> afn;
    protected final ViewEventCenter afo;
    private x afq;
    private FrameLayout afr;
    private ab afs;
    private aa aft;
    private z afu;
    private FrameLayout.LayoutParams afv;
    protected final List<H> afl = new ArrayList();
    protected final SparseArray<H> afm = new SparseArray<>();
    protected boolean afp = true;

    public b(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.afn = tbPageContext;
        this.afo = viewEventCenter;
    }

    public void w(D d) {
        if (d != null && this.afk != null) {
            this.afk.remove(d);
            notifyDataSetChanged();
        }
    }

    public void w(List<D> list) {
        x((List) list);
        notifyDataSetChanged();
    }

    public void c(S s) {
        d(s);
        notifyDataSetChanged();
    }

    public void x(D d) {
        H h;
        if (d != null && this.afk != null && this.afk.contains(d) && (h = this.afm.get(this.afk.indexOf(d))) != null) {
            h.y(d);
        }
    }

    protected void x(List<D> list) {
        if (list != null) {
            if (this.afk == null) {
                this.afk = new ArrayList();
            }
            this.afk.clear();
            this.afk.addAll(list);
            this.afm.clear();
        }
    }

    protected void d(S s) {
        this.adY = s;
    }

    public List<D> yG() {
        return this.afk == null ? new ArrayList() : new ArrayList(this.afk);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.afk == null) {
            return 0;
        }
        if (this.afk.size() == 0 && this.afp) {
            return 1;
        }
        return this.afk.size();
    }

    public int yH() {
        if (this.afk == null) {
            return 0;
        }
        return this.afk.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.afk != null && this.afk.size() != 0 && i >= 0 && i < this.afk.size()) {
            return this.afk.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.afk != null && this.afk.size() != 0 && i >= 0 && i < this.afk.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.afl.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.afl.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.afq != null) {
            this.afq.onChangeSkinType(this.afn, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.afm.indexOfValue(a) >= 0) {
            this.afm.remove(a.getPosition());
        }
        this.afm.put(i, a);
        a((b<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.afn.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.afn, inflate, this.afo);
                h.a(this.afn, TbadkCoreApplication.m255getInst().getSkinType());
                inflate.setTag(h);
                this.afl.add(h);
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
            h.a(item, this.adY);
        }
    }

    public void ky() {
        if (this.afq != null) {
            this.afq.f(this.afn);
        }
    }

    public void onActivityStop() {
        if (this.afq != null) {
            this.afq.onActivityStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yI() {
        if (this.afr != null && this.afq != null) {
            this.afr.removeView(this.afq);
            this.afq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View yJ() {
        if (this.afr == null) {
            this.afr = new FrameLayout(this.afn.getPageActivity());
        }
        if (this.afq == null) {
            this.afq = NoDataViewFactory.a(this.afn.getPageActivity(), this.afr, this.aft, this.afs, this.afu);
        }
        this.afq.setVisibility(0);
        if (this.afv != null) {
            this.afq.setLayoutParams(this.afv);
        }
        this.afr.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.afq.onChangeSkinType(this.afn, TbadkCoreApplication.m255getInst().getSkinType());
        return this.afr;
    }

    public void a(aa aaVar, ab abVar, z zVar, FrameLayout.LayoutParams layoutParams) {
        this.aft = aaVar;
        this.afs = abVar;
        this.afu = zVar;
        this.afv = layoutParams;
        if (this.afq != null) {
            this.afq.setTextOption(abVar);
            this.afq.setImgOption(aaVar);
            this.afq.setButtonOption(zVar);
            if (layoutParams != null) {
                this.afq.setLayoutParams(layoutParams);
            }
        }
    }

    public void aX(boolean z) {
        this.afp = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean yK() {
        return this.afk != null && this.afk.size() == 0;
    }
}

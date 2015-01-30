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
    protected S aeb;
    protected List<D> afn;
    protected final TbPageContext<?> afq;
    protected final ViewEventCenter afr;
    private x aft;
    private FrameLayout afu;
    private ab afv;
    private aa afw;
    private z afx;
    private FrameLayout.LayoutParams afy;
    protected final List<H> afo = new ArrayList();
    protected final SparseArray<H> afp = new SparseArray<>();
    protected boolean afs = true;

    public b(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.afq = tbPageContext;
        this.afr = viewEventCenter;
    }

    public void w(D d) {
        if (d != null && this.afn != null) {
            this.afn.remove(d);
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
        if (d != null && this.afn != null && this.afn.contains(d) && (h = this.afp.get(this.afn.indexOf(d))) != null) {
            h.y(d);
        }
    }

    protected void x(List<D> list) {
        if (list != null) {
            if (this.afn == null) {
                this.afn = new ArrayList();
            }
            this.afn.clear();
            this.afn.addAll(list);
            this.afp.clear();
        }
    }

    protected void d(S s) {
        this.aeb = s;
    }

    public List<D> yM() {
        return this.afn == null ? new ArrayList() : new ArrayList(this.afn);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.afn == null) {
            return 0;
        }
        if (this.afn.size() == 0 && this.afs) {
            return 1;
        }
        return this.afn.size();
    }

    public int yN() {
        if (this.afn == null) {
            return 0;
        }
        return this.afn.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.afn != null && this.afn.size() != 0 && i >= 0 && i < this.afn.size()) {
            return this.afn.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.afn != null && this.afn.size() != 0 && i >= 0 && i < this.afn.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.afo.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.afo.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.aft != null) {
            this.aft.onChangeSkinType(this.afq, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.afp.indexOfValue(a) >= 0) {
            this.afp.remove(a.getPosition());
        }
        this.afp.put(i, a);
        a((b<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.afq.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.afq, inflate, this.afr);
                h.a(this.afq, TbadkCoreApplication.m255getInst().getSkinType());
                inflate.setTag(h);
                this.afo.add(h);
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
            h.a(item, this.aeb);
        }
    }

    public void kF() {
        if (this.aft != null) {
            this.aft.f(this.afq);
        }
    }

    public void onActivityStop() {
        if (this.aft != null) {
            this.aft.onActivityStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yO() {
        if (this.afu != null && this.aft != null) {
            this.afu.removeView(this.aft);
            this.aft = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View yP() {
        if (this.afu == null) {
            this.afu = new FrameLayout(this.afq.getPageActivity());
        }
        if (this.aft == null) {
            this.aft = NoDataViewFactory.a(this.afq.getPageActivity(), this.afu, this.afw, this.afv, this.afx);
        }
        this.aft.setVisibility(0);
        if (this.afy != null) {
            this.aft.setLayoutParams(this.afy);
        }
        this.afu.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aft.onChangeSkinType(this.afq, TbadkCoreApplication.m255getInst().getSkinType());
        return this.afu;
    }

    public void a(aa aaVar, ab abVar, z zVar, FrameLayout.LayoutParams layoutParams) {
        this.afw = aaVar;
        this.afv = abVar;
        this.afx = zVar;
        this.afy = layoutParams;
        if (this.aft != null) {
            this.aft.setTextOption(abVar);
            this.aft.setImgOption(aaVar);
            this.aft.setButtonOption(zVar);
            if (layoutParams != null) {
                this.aft.setLayoutParams(layoutParams);
            }
        }
    }

    public void aX(boolean z) {
        this.afs = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean yQ() {
        return this.afn != null && this.afn.size() == 0;
    }
}

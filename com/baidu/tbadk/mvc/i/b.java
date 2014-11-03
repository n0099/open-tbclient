package com.baidu.tbadk.mvc.i;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.e.c;
import com.baidu.tbadk.mvc.i.a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b<D, S extends com.baidu.tbadk.mvc.e.c, H extends a<D, S>> extends BaseAdapter implements com.baidu.tbadk.e.a {
    protected S Xv;
    protected List<D> Yh;
    protected final Activity Yk;
    protected final ViewEventCenter Yl;
    private o Yn;
    private FrameLayout Yo;
    private s Yp;
    private r Yq;
    private q Yr;
    private FrameLayout.LayoutParams Ys;
    protected final List<H> Yi = new ArrayList();
    protected final SparseArray<H> Yj = new SparseArray<>();
    protected boolean Ym = true;

    public b(Activity activity, ViewEventCenter viewEventCenter) {
        this.Yk = activity;
        this.Yl = viewEventCenter;
    }

    public void r(List<D> list) {
        s(list);
        notifyDataSetChanged();
    }

    protected void s(List<D> list) {
        if (list != null) {
            if (this.Yh == null) {
                this.Yh = new ArrayList();
            }
            this.Yh.clear();
            this.Yh.addAll(list);
            this.Yj.clear();
        }
    }

    public List<D> um() {
        return this.Yh == null ? new ArrayList() : new ArrayList(this.Yh);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Yh == null) {
            return 0;
        }
        if (this.Yh.size() == 0 && this.Ym) {
            return 1;
        }
        return this.Yh.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.Yh != null && this.Yh.size() != 0 && i >= 0 && i < this.Yh.size()) {
            return this.Yh.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Yh != null && this.Yh.size() != 0 && i >= 0 && i < this.Yh.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tbadk.e.a
    public boolean dg(int i) {
        int size = this.Yi.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.Yi.get(i2);
            if (h != null) {
                h.dg(i);
            }
        }
        if (this.Yn != null) {
            this.Yn.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        this.Yj.remove(a.getPosition());
        this.Yj.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.Yk.getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(View.class, ViewEventCenter.class).newInstance(inflate, this.Yl);
                inflate.setTag(h);
                this.Yi.add(h);
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
            h.a(item, this.Xv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View un() {
        if (this.Yo == null) {
            this.Yo = new FrameLayout(this.Yk);
        }
        if (this.Yn == null) {
            this.Yn = NoDataViewFactory.a(this.Yk, this.Yo, this.Yq, this.Yp, this.Yr);
        }
        this.Yn.setVisibility(0);
        if (this.Ys != null) {
            this.Yn.setLayoutParams(this.Ys);
        }
        this.Yo.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.Yn.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
        return this.Yo;
    }

    public void a(r rVar, s sVar, q qVar, FrameLayout.LayoutParams layoutParams) {
        this.Yq = rVar;
        this.Yp = sVar;
        this.Yr = qVar;
        this.Ys = layoutParams;
    }

    public void aH(boolean z) {
        this.Ym = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean uo() {
        return this.Yh != null && this.Yh.size() == 0;
    }
}

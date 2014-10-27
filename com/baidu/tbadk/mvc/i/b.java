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
    protected S Xr;
    protected List<D> Yd;
    protected final Activity Yg;
    protected final ViewEventCenter Yh;
    private o Yj;
    private FrameLayout Yk;
    private s Yl;
    private r Ym;
    private q Yn;
    private FrameLayout.LayoutParams Yo;
    protected final List<H> Ye = new ArrayList();
    protected final SparseArray<H> Yf = new SparseArray<>();
    protected boolean Yi = true;

    public b(Activity activity, ViewEventCenter viewEventCenter) {
        this.Yg = activity;
        this.Yh = viewEventCenter;
    }

    public void r(List<D> list) {
        s(list);
        notifyDataSetChanged();
    }

    protected void s(List<D> list) {
        if (list != null) {
            if (this.Yd == null) {
                this.Yd = new ArrayList();
            }
            this.Yd.clear();
            this.Yd.addAll(list);
            this.Yf.clear();
        }
    }

    public List<D> uk() {
        return this.Yd == null ? new ArrayList() : new ArrayList(this.Yd);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Yd == null) {
            return 0;
        }
        if (this.Yd.size() == 0 && this.Yi) {
            return 1;
        }
        return this.Yd.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.Yd != null && this.Yd.size() != 0 && i >= 0 && i < this.Yd.size()) {
            return this.Yd.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Yd != null && this.Yd.size() != 0 && i >= 0 && i < this.Yd.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tbadk.e.a
    public boolean dg(int i) {
        int size = this.Ye.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.Ye.get(i2);
            if (h != null) {
                h.dg(i);
            }
        }
        if (this.Yj != null) {
            this.Yj.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        this.Yf.remove(a.getPosition());
        this.Yf.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.Yg.getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(View.class, ViewEventCenter.class).newInstance(inflate, this.Yh);
                inflate.setTag(h);
                this.Ye.add(h);
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
            h.a(item, this.Xr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View ul() {
        if (this.Yk == null) {
            this.Yk = new FrameLayout(this.Yg);
        }
        if (this.Yj == null) {
            this.Yj = NoDataViewFactory.a(this.Yg, this.Yk, this.Ym, this.Yl, this.Yn);
        }
        this.Yj.setVisibility(0);
        if (this.Yo != null) {
            this.Yj.setLayoutParams(this.Yo);
        }
        this.Yk.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.Yj.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
        return this.Yk;
    }

    public void a(r rVar, s sVar, q qVar, FrameLayout.LayoutParams layoutParams) {
        this.Ym = rVar;
        this.Yl = sVar;
        this.Yn = qVar;
        this.Yo = layoutParams;
    }

    public void aH(boolean z) {
        this.Yi = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean um() {
        return this.Yd != null && this.Yd.size() == 0;
    }
}

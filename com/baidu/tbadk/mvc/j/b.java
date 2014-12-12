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
    protected S adE;
    protected List<D> aeQ;
    protected final TbPageContext<?> aeT;
    protected final ViewEventCenter aeU;
    private x aeW;
    private FrameLayout aeX;
    private ab aeY;
    private aa aeZ;
    private z afa;
    private FrameLayout.LayoutParams afb;
    protected final List<H> aeR = new ArrayList();
    protected final SparseArray<H> aeS = new SparseArray<>();
    protected boolean aeV = true;

    public b(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aeT = tbPageContext;
        this.aeU = viewEventCenter;
    }

    public void w(D d) {
        if (d != null && this.aeQ != null) {
            this.aeQ.remove(d);
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
        if (d != null && this.aeQ != null && this.aeQ.contains(d) && (h = this.aeS.get(this.aeQ.indexOf(d))) != null) {
            h.y(d);
        }
    }

    protected void x(List<D> list) {
        if (list != null) {
            if (this.aeQ == null) {
                this.aeQ = new ArrayList();
            }
            this.aeQ.clear();
            this.aeQ.addAll(list);
            this.aeS.clear();
        }
    }

    protected void d(S s) {
        this.adE = s;
    }

    public List<D> yw() {
        return this.aeQ == null ? new ArrayList() : new ArrayList(this.aeQ);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aeQ == null) {
            return 0;
        }
        if (this.aeQ.size() == 0 && this.aeV) {
            return 1;
        }
        return this.aeQ.size();
    }

    public int yx() {
        if (this.aeQ == null) {
            return 0;
        }
        return this.aeQ.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.aeQ != null && this.aeQ.size() != 0 && i >= 0 && i < this.aeQ.size()) {
            return this.aeQ.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aeQ != null && this.aeQ.size() != 0 && i >= 0 && i < this.aeQ.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.aeR.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aeR.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.aeW != null) {
            this.aeW.onChangeSkinType(this.aeT, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aeS.indexOfValue(a) >= 0) {
            this.aeS.remove(a.getPosition());
        }
        this.aeS.put(i, a);
        a((b<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aeT.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aeT, inflate, this.aeU);
                h.a(this.aeT, TbadkCoreApplication.m255getInst().getSkinType());
                inflate.setTag(h);
                this.aeR.add(h);
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
            h.a(item, this.adE);
        }
    }

    public void kF() {
        if (this.aeW != null) {
            this.aeW.f(this.aeT);
        }
    }

    public void onActivityStop() {
        if (this.aeW != null) {
            this.aeW.onActivityStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yy() {
        if (this.aeX != null && this.aeW != null) {
            this.aeX.removeView(this.aeW);
            this.aeW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View yz() {
        if (this.aeX == null) {
            this.aeX = new FrameLayout(this.aeT.getPageActivity());
        }
        if (this.aeW == null) {
            this.aeW = NoDataViewFactory.a(this.aeT.getPageActivity(), this.aeX, this.aeZ, this.aeY, this.afa);
        }
        this.aeW.setVisibility(0);
        if (this.afb != null) {
            this.aeW.setLayoutParams(this.afb);
        }
        this.aeX.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aeW.onChangeSkinType(this.aeT, TbadkCoreApplication.m255getInst().getSkinType());
        return this.aeX;
    }

    public void a(aa aaVar, ab abVar, z zVar, FrameLayout.LayoutParams layoutParams) {
        this.aeZ = aaVar;
        this.aeY = abVar;
        this.afa = zVar;
        this.afb = layoutParams;
        if (this.aeW != null) {
            this.aeW.setTextOption(abVar);
            this.aeW.setImgOption(aaVar);
            this.aeW.setButtonOption(zVar);
            if (layoutParams != null) {
                this.aeW.setLayoutParams(layoutParams);
            }
        }
    }

    public void aV(boolean z) {
        this.aeV = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean yA() {
        return this.aeQ != null && this.aeQ.size() == 0;
    }
}

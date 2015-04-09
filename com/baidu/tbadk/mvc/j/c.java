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
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.core.view.u;
import com.baidu.tbadk.core.view.v;
import com.baidu.tbadk.core.view.w;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.e.c;
import com.baidu.tbadk.mvc.j.a;
import com.baidu.tieba.tbadkCore.ab;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.e.c, H extends a<D, S>> extends BaseAdapter implements ab {
    protected S amA;
    protected List<D> anO;
    protected final TbPageContext<?> anR;
    protected final ViewEventCenter anS;
    private s anU;
    private FrameLayout anV;
    private w anW;
    private v anX;
    private u anY;
    private FrameLayout.LayoutParams anZ;
    protected final List<H> anP = new ArrayList();
    protected final SparseArray<H> anQ = new SparseArray<>();
    protected boolean anT = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.anR = tbPageContext;
        this.anS = viewEventCenter;
    }

    public void q(List<D> list) {
        if (list != null) {
            if (this.anO == null) {
                this.anO = new ArrayList();
            }
            this.anO.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void x(D d) {
        if (d != null && this.anO != null) {
            this.anO.remove(d);
            notifyDataSetChanged();
        }
    }

    public void r(List<D> list) {
        s(list);
        notifyDataSetChanged();
    }

    public void c(S s) {
        d(s);
        notifyDataSetChanged();
    }

    public void y(D d) {
        H h;
        if (d != null && this.anO != null && this.anO.contains(d) && (h = this.anQ.get(this.anO.indexOf(d))) != null) {
            h.A(d);
        }
    }

    public H z(D d) {
        if (d == null || this.anO == null || !this.anO.contains(d)) {
            return null;
        }
        return this.anQ.get(this.anO.indexOf(d));
    }

    protected void s(List<D> list) {
        if (list != null) {
            if (this.anO == null) {
                this.anO = new ArrayList();
            }
            this.anO.clear();
            this.anO.addAll(list);
            this.anQ.clear();
        }
    }

    protected void d(S s) {
        this.amA = s;
    }

    public List<D> Ca() {
        return this.anO == null ? new ArrayList() : new ArrayList(this.anO);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anO == null) {
            return 0;
        }
        if (this.anO.size() == 0 && this.anT) {
            return 1;
        }
        return this.anO.size();
    }

    public int Cb() {
        if (this.anO == null) {
            return 0;
        }
        return this.anO.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.anO != null && this.anO.size() != 0 && i >= 0 && i < this.anO.size()) {
            return this.anO.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.anO != null && this.anO.size() != 0 && i >= 0 && i < this.anO.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.anP.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.anP.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.anU != null) {
            this.anU.onChangeSkinType(this.anR, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.anQ.indexOfValue(a) >= 0) {
            this.anQ.remove(a.getPosition());
        }
        this.anQ.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.anR.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.anR, inflate, this.anS);
                h.a(this.anR, TbadkCoreApplication.m411getInst().getSkinType());
                inflate.setTag(h);
                this.anP.add(h);
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
            h.a(item, this.amA);
        }
    }

    public void or() {
        if (this.anU != null) {
            this.anU.e(this.anR);
        }
    }

    public void onActivityStop() {
        if (this.anU != null) {
            this.anU.onActivityStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cc() {
        if (this.anV != null && this.anU != null) {
            this.anV.removeView(this.anU);
            this.anU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Cd() {
        if (this.anV == null) {
            this.anV = new FrameLayout(this.anR.getPageActivity());
        }
        if (this.anU == null) {
            this.anU = NoDataViewFactory.a(this.anR.getPageActivity(), this.anV, this.anX, this.anW, this.anY);
        }
        this.anU.setVisibility(0);
        if (this.anZ != null) {
            this.anU.setLayoutParams(this.anZ);
        }
        this.anV.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.anU.onChangeSkinType(this.anR, TbadkCoreApplication.m411getInst().getSkinType());
        return this.anV;
    }

    public void a(v vVar, w wVar, u uVar, FrameLayout.LayoutParams layoutParams) {
        this.anX = vVar;
        this.anW = wVar;
        this.anY = uVar;
        this.anZ = layoutParams;
        if (this.anU != null) {
            this.anU.setTextOption(wVar);
            this.anU.setImgOption(vVar);
            this.anU.setButtonOption(uVar);
            if (layoutParams != null) {
                this.anU.setLayoutParams(layoutParams);
            }
        }
    }

    public void bb(boolean z) {
        this.anT = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ce() {
        return this.anO != null && this.anO.size() == 0;
    }
}

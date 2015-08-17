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
import com.baidu.tbadk.core.view.u;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.g.a;
import com.baidu.tieba.tbadkCore.r;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements r {
    protected S auX;
    protected List<D> avS;
    protected final TbPageContext<?> avV;
    protected final ViewEventCenter avW;
    private u avY;
    private FrameLayout avZ;
    private NoDataViewFactory.d awa;
    private NoDataViewFactory.c awb;
    private NoDataViewFactory.b awc;
    private FrameLayout.LayoutParams awd;
    protected final List<H> avT = new ArrayList();
    protected final SparseArray<H> avU = new SparseArray<>();
    protected boolean avX = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.avV = tbPageContext;
        this.avW = viewEventCenter;
    }

    public void q(List<D> list) {
        if (list != null) {
            if (this.avS == null) {
                this.avS = new ArrayList();
            }
            this.avS.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void y(D d) {
        if (d != null && this.avS != null) {
            this.avS.remove(d);
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

    public void z(D d) {
        H h;
        if (d != null && this.avS != null && this.avS.contains(d) && (h = this.avU.get(this.avS.indexOf(d))) != null) {
            h.A(d);
        }
    }

    protected void s(List<D> list) {
        if (list != null) {
            if (this.avS == null) {
                this.avS = new ArrayList();
            }
            this.avS.clear();
            this.avS.addAll(list);
            this.avU.clear();
        }
    }

    protected void b(S s) {
        this.auX = s;
    }

    public List<D> Dp() {
        return this.avS == null ? new ArrayList() : new ArrayList(this.avS);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.avS == null) {
            return 0;
        }
        if (this.avS.size() == 0 && this.avX) {
            return 1;
        }
        return this.avS.size();
    }

    public int Dq() {
        if (this.avS == null) {
            return 0;
        }
        return this.avS.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.avS != null && this.avS.size() != 0 && i >= 0 && i < this.avS.size()) {
            return this.avS.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.avS != null && this.avS.size() != 0 && i >= 0 && i < this.avS.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.avT.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.avT.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.avY != null) {
            this.avY.onChangeSkinType(this.avV, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.avU.indexOfValue(a) >= 0) {
            this.avU.remove(a.getPosition());
        }
        this.avU.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.avV.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.avV, inflate, this.avW);
                h.a(this.avV, TbadkCoreApplication.m411getInst().getSkinType());
                inflate.setTag(h);
                this.avT.add(h);
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
            h.a(item, this.auX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dr() {
        if (this.avZ != null && this.avY != null) {
            this.avZ.removeView(this.avY);
            this.avY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View createNoDataView() {
        if (this.avZ == null) {
            this.avZ = new FrameLayout(this.avV.getPageActivity());
        }
        if (this.avY == null) {
            this.avY = NoDataViewFactory.a(this.avV.getPageActivity(), this.avZ, this.awb, this.awa, this.awc);
        }
        this.avY.setVisibility(0);
        if (this.awd != null) {
            this.avY.setLayoutParams(this.awd);
        }
        this.avZ.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.avY.onChangeSkinType(this.avV, TbadkCoreApplication.m411getInst().getSkinType());
        return this.avZ;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.awb = cVar;
        this.awa = dVar;
        this.awc = bVar;
        this.awd = layoutParams;
        if (this.avY != null) {
            this.avY.setTextOption(dVar);
            this.avY.setImgOption(cVar);
            this.avY.setButtonOption(bVar);
            if (layoutParams != null) {
                this.avY.setLayoutParams(layoutParams);
            }
        }
    }

    public void bj(boolean z) {
        this.avX = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ds() {
        return this.avS != null && this.avS.size() == 0;
    }
}

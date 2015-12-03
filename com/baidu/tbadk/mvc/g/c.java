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
import com.baidu.tbadk.core.view.n;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.g.a;
import com.baidu.tieba.tbadkCore.t;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements t {
    protected S avX;
    protected List<D> awS;
    protected final TbPageContext<?> awV;
    protected final ViewEventCenter awW;
    private n awY;
    private FrameLayout awZ;
    private NoDataViewFactory.d axa;
    private NoDataViewFactory.c axb;
    private NoDataViewFactory.b axc;
    private FrameLayout.LayoutParams axd;
    protected final List<H> awT = new ArrayList();
    protected final SparseArray<H> awU = new SparseArray<>();
    protected boolean awX = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.awV = tbPageContext;
        this.awW = viewEventCenter;
    }

    public void q(List<D> list) {
        if (list != null) {
            if (this.awS == null) {
                this.awS = new ArrayList();
            }
            this.awS.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void z(D d) {
        if (d != null && this.awS != null) {
            this.awS.remove(d);
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
        if (d != null && this.awS != null && this.awS.contains(d) && (h = this.awU.get(this.awS.indexOf(d))) != null) {
            h.B(d);
        }
    }

    protected void s(List<D> list) {
        if (list != null) {
            if (this.awS == null) {
                this.awS = new ArrayList();
            }
            this.awS.clear();
            this.awS.addAll(list);
            this.awU.clear();
        }
    }

    protected void b(S s) {
        this.avX = s;
    }

    public List<D> Ed() {
        return this.awS == null ? new ArrayList() : new ArrayList(this.awS);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.awS == null) {
            return 0;
        }
        if (this.awS.size() == 0 && this.awX) {
            return 1;
        }
        return this.awS.size();
    }

    public int Ee() {
        if (this.awS == null) {
            return 0;
        }
        return this.awS.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.awS != null && this.awS.size() != 0 && i >= 0 && i < this.awS.size()) {
            return this.awS.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.awS != null && this.awS.size() != 0 && i >= 0 && i < this.awS.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.awT.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.awT.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.awY != null) {
            this.awY.onChangeSkinType(this.awV, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.awU.indexOfValue(a) >= 0) {
            this.awU.remove(a.getPosition());
        }
        this.awU.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.awV.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.awV, inflate, this.awW);
                h.a(this.awV, TbadkCoreApplication.m411getInst().getSkinType());
                inflate.setTag(h);
                this.awT.add(h);
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
            h.a(item, this.avX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ef() {
        if (this.awZ != null && this.awY != null) {
            this.awZ.removeView(this.awY);
            this.awY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View createNoDataView() {
        if (this.awZ == null) {
            this.awZ = new FrameLayout(this.awV.getPageActivity());
        }
        if (this.awY == null) {
            this.awY = NoDataViewFactory.a(this.awV.getPageActivity(), this.awZ, this.axb, this.axa, this.axc);
        }
        this.awY.setVisibility(0);
        if (this.axd != null) {
            this.awY.setLayoutParams(this.axd);
        }
        this.awZ.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.awY.onChangeSkinType(this.awV, TbadkCoreApplication.m411getInst().getSkinType());
        return this.awZ;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.axb = cVar;
        this.axa = dVar;
        this.axc = bVar;
        this.axd = layoutParams;
        if (this.awY != null) {
            this.awY.setTextOption(dVar);
            this.awY.setImgOption(cVar);
            this.awY.setButtonOption(bVar);
            if (layoutParams != null) {
                this.awY.setLayoutParams(layoutParams);
            }
        }
    }

    public void bz(boolean z) {
        this.awX = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Eg() {
        return this.awS != null && this.awS.size() == 0;
    }
}

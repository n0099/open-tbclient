package com.baidu.tbadk.mvc.f;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
import com.baidu.tieba.tbadkCore.o;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements o {
    protected final TbPageContext<?> aST;
    protected final ViewEventCenter aSU;
    private NoDataView aSW;
    private FrameLayout aSX;
    private NoDataViewFactory.d aSY;
    private NoDataViewFactory.c aSZ;
    protected S aSj;
    private NoDataViewFactory.b aTa;
    private FrameLayout.LayoutParams aTb;
    protected List<D> agd;
    protected final List<H> aSR = new ArrayList();
    protected final SparseArray<H> aSS = new SparseArray<>();
    protected boolean aSV = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aST = tbPageContext;
        this.aSU = viewEventCenter;
    }

    public void H(List<D> list) {
        if (list != null) {
            if (this.agd == null) {
                this.agd = new ArrayList();
            }
            this.agd.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void E(D d) {
        if (d != null && this.agd != null) {
            this.agd.remove(d);
            notifyDataSetChanged();
        }
    }

    public void I(List<D> list) {
        J(list);
        notifyDataSetChanged();
    }

    public void F(D d) {
        H h;
        if (d != null && this.agd != null && this.agd.contains(d) && (h = this.aSS.get(this.agd.indexOf(d))) != null) {
            h.G(d);
        }
    }

    protected void J(List<D> list) {
        if (list != null) {
            if (this.agd == null) {
                this.agd = new ArrayList();
            }
            this.agd.clear();
            this.agd.addAll(list);
            this.aSS.clear();
        }
    }

    public List<D> getDataList() {
        return this.agd == null ? new ArrayList() : new ArrayList(this.agd);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.agd == null) {
            return 0;
        }
        if (this.agd.size() == 0 && this.aSV) {
            return 1;
        }
        return this.agd.size();
    }

    public int Kc() {
        if (this.agd == null) {
            return 0;
        }
        return this.agd.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.agd != null && this.agd.size() != 0 && i >= 0 && i < this.agd.size()) {
            return this.agd.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.agd != null && this.agd.size() != 0 && i >= 0 && i < this.agd.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aSR.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aSR.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aSW != null) {
            this.aSW.onChangeSkinType(this.aST, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aSS.indexOfValue(a) >= 0) {
            this.aSS.remove(a.getPosition());
        }
        this.aSS.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aST.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aST, inflate, this.aSU);
                h.b(this.aST, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aSR.add(h);
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
            h.a(item, this.aSj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Kd() {
        if (this.aSX != null && this.aSW != null) {
            this.aSX.removeView(this.aSW);
            this.aSW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Ke() {
        if (this.aSX == null) {
            this.aSX = new FrameLayout(this.aST.getPageActivity());
        }
        if (this.aSW == null) {
            this.aSW = NoDataViewFactory.a(this.aST.getPageActivity(), this.aSX, this.aSZ, this.aSY, this.aTa);
        }
        this.aSW.setVisibility(0);
        if (this.aTb != null) {
            this.aSW.setLayoutParams(this.aTb);
        }
        this.aSX.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aSW.onChangeSkinType(this.aST, TbadkCoreApplication.getInst().getSkinType());
        return this.aSX;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aSZ = cVar;
        this.aSY = dVar;
        this.aTa = bVar;
        this.aTb = layoutParams;
        if (this.aSW != null) {
            this.aSW.setTextOption(dVar);
            this.aSW.setImgOption(cVar);
            this.aSW.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aSW.setLayoutParams(layoutParams);
            }
        }
    }

    public void bU(boolean z) {
        this.aSV = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Kf() {
        return this.agd != null && this.agd.size() == 0;
    }
}

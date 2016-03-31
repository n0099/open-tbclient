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
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.g.a;
import com.baidu.tieba.tbadkCore.s;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements s {
    private FrameLayout aAa;
    private NoDataViewFactory.d aAb;
    private NoDataViewFactory.c aAc;
    private NoDataViewFactory.b aAd;
    private FrameLayout.LayoutParams aAe;
    protected List<D> azT;
    protected final TbPageContext<?> azW;
    protected final ViewEventCenter azX;
    private p azZ;
    protected S azb;
    protected final List<H> azU = new ArrayList();
    protected final SparseArray<H> azV = new SparseArray<>();
    protected boolean azY = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.azW = tbPageContext;
        this.azX = viewEventCenter;
    }

    public void w(List<D> list) {
        if (list != null) {
            if (this.azT == null) {
                this.azT = new ArrayList();
            }
            this.azT.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void z(D d) {
        if (d != null && this.azT != null) {
            this.azT.remove(d);
            notifyDataSetChanged();
        }
    }

    public void x(List<D> list) {
        y(list);
        notifyDataSetChanged();
    }

    public void a(S s) {
        b(s);
        notifyDataSetChanged();
    }

    public void A(D d) {
        H h;
        if (d != null && this.azT != null && this.azT.contains(d) && (h = this.azV.get(this.azT.indexOf(d))) != null) {
            h.B(d);
        }
    }

    protected void y(List<D> list) {
        if (list != null) {
            if (this.azT == null) {
                this.azT = new ArrayList();
            }
            this.azT.clear();
            this.azT.addAll(list);
            this.azV.clear();
        }
    }

    protected void b(S s) {
        this.azb = s;
    }

    public List<D> FZ() {
        return this.azT == null ? new ArrayList() : new ArrayList(this.azT);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.azT == null) {
            return 0;
        }
        if (this.azT.size() == 0 && this.azY) {
            return 1;
        }
        return this.azT.size();
    }

    public int Ga() {
        if (this.azT == null) {
            return 0;
        }
        return this.azT.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.azT != null && this.azT.size() != 0 && i >= 0 && i < this.azT.size()) {
            return this.azT.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.azT != null && this.azT.size() != 0 && i >= 0 && i < this.azT.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.azU.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.azU.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.azZ != null) {
            this.azZ.onChangeSkinType(this.azW, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.azV.indexOfValue(a) >= 0) {
            this.azV.remove(a.getPosition());
        }
        this.azV.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.azW.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.azW, inflate, this.azX);
                h.a(this.azW, TbadkCoreApplication.m411getInst().getSkinType());
                inflate.setTag(h);
                this.azU.add(h);
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
            h.a(item, this.azb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Gb() {
        if (this.aAa != null && this.azZ != null) {
            this.aAa.removeView(this.azZ);
            this.azZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Gc() {
        if (this.aAa == null) {
            this.aAa = new FrameLayout(this.azW.getPageActivity());
        }
        if (this.azZ == null) {
            this.azZ = NoDataViewFactory.a(this.azW.getPageActivity(), this.aAa, this.aAc, this.aAb, this.aAd);
        }
        this.azZ.setVisibility(0);
        if (this.aAe != null) {
            this.azZ.setLayoutParams(this.aAe);
        }
        this.aAa.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.azZ.onChangeSkinType(this.azW, TbadkCoreApplication.m411getInst().getSkinType());
        return this.aAa;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aAc = cVar;
        this.aAb = dVar;
        this.aAd = bVar;
        this.aAe = layoutParams;
        if (this.azZ != null) {
            this.azZ.setTextOption(dVar);
            this.azZ.setImgOption(cVar);
            this.azZ.setButtonOption(bVar);
            if (layoutParams != null) {
                this.azZ.setLayoutParams(layoutParams);
            }
        }
    }

    public void bG(boolean z) {
        this.azY = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Gd() {
        return this.azT != null && this.azT.size() == 0;
    }
}

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
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.g.a;
import com.baidu.tieba.tbadkCore.t;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements t {
    protected S awI;
    protected List<D> axA;
    protected final TbPageContext<?> axD;
    protected final ViewEventCenter axE;
    private q axG;
    private FrameLayout axH;
    private NoDataViewFactory.d axI;
    private NoDataViewFactory.c axJ;
    private NoDataViewFactory.b axK;
    private FrameLayout.LayoutParams axL;
    protected final List<H> axB = new ArrayList();
    protected final SparseArray<H> axC = new SparseArray<>();
    protected boolean axF = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.axD = tbPageContext;
        this.axE = viewEventCenter;
    }

    public void z(List<D> list) {
        if (list != null) {
            if (this.axA == null) {
                this.axA = new ArrayList();
            }
            this.axA.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void C(D d) {
        if (d != null && this.axA != null) {
            this.axA.remove(d);
            notifyDataSetChanged();
        }
    }

    public void A(List<D> list) {
        B(list);
        notifyDataSetChanged();
    }

    public void a(S s) {
        b(s);
        notifyDataSetChanged();
    }

    public void D(D d) {
        H h;
        if (d != null && this.axA != null && this.axA.contains(d) && (h = this.axC.get(this.axA.indexOf(d))) != null) {
            h.E(d);
        }
    }

    protected void B(List<D> list) {
        if (list != null) {
            if (this.axA == null) {
                this.axA = new ArrayList();
            }
            this.axA.clear();
            this.axA.addAll(list);
            this.axC.clear();
        }
    }

    protected void b(S s) {
        this.awI = s;
    }

    public List<D> Ea() {
        return this.axA == null ? new ArrayList() : new ArrayList(this.axA);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.axA == null) {
            return 0;
        }
        if (this.axA.size() == 0 && this.axF) {
            return 1;
        }
        return this.axA.size();
    }

    public int Eb() {
        if (this.axA == null) {
            return 0;
        }
        return this.axA.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.axA != null && this.axA.size() != 0 && i >= 0 && i < this.axA.size()) {
            return this.axA.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.axA != null && this.axA.size() != 0 && i >= 0 && i < this.axA.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.axB.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.axB.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.axG != null) {
            this.axG.onChangeSkinType(this.axD, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.axC.indexOfValue(a) >= 0) {
            this.axC.remove(a.getPosition());
        }
        this.axC.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.axD.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.axD, inflate, this.axE);
                h.a(this.axD, TbadkCoreApplication.m10getInst().getSkinType());
                inflate.setTag(h);
                this.axB.add(h);
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
            h.a(item, this.awI);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ec() {
        if (this.axH != null && this.axG != null) {
            this.axH.removeView(this.axG);
            this.axG = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Ed() {
        if (this.axH == null) {
            this.axH = new FrameLayout(this.axD.getPageActivity());
        }
        if (this.axG == null) {
            this.axG = NoDataViewFactory.a(this.axD.getPageActivity(), this.axH, this.axJ, this.axI, this.axK);
        }
        this.axG.setVisibility(0);
        if (this.axL != null) {
            this.axG.setLayoutParams(this.axL);
        }
        this.axH.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.axG.onChangeSkinType(this.axD, TbadkCoreApplication.m10getInst().getSkinType());
        return this.axH;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.axJ = cVar;
        this.axI = dVar;
        this.axK = bVar;
        this.axL = layoutParams;
        if (this.axG != null) {
            this.axG.setTextOption(dVar);
            this.axG.setImgOption(cVar);
            this.axG.setButtonOption(bVar);
            if (layoutParams != null) {
                this.axG.setLayoutParams(layoutParams);
            }
        }
    }

    public void bO(boolean z) {
        this.axF = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ee() {
        return this.axA != null && this.axA.size() == 0;
    }
}

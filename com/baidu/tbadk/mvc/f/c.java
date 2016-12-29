package com.baidu.tbadk.mvc.f;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.w;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
import com.baidu.tieba.tbadkCore.r;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements r {
    protected final ViewEventCenter aAA;
    private w aAC;
    private FrameLayout aAD;
    private NoDataViewFactory.d aAE;
    private NoDataViewFactory.c aAF;
    private NoDataViewFactory.b aAG;
    private FrameLayout.LayoutParams aAH;
    protected List<D> aAw;
    protected final TbPageContext<?> aAz;
    protected S azH;
    protected final List<H> aAx = new ArrayList();
    protected final SparseArray<H> aAy = new SparseArray<>();
    protected boolean aAB = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aAz = tbPageContext;
        this.aAA = viewEventCenter;
    }

    public void z(List<D> list) {
        if (list != null) {
            if (this.aAw == null) {
                this.aAw = new ArrayList();
            }
            this.aAw.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void C(D d) {
        if (d != null && this.aAw != null) {
            this.aAw.remove(d);
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
        if (d != null && this.aAw != null && this.aAw.contains(d) && (h = this.aAy.get(this.aAw.indexOf(d))) != null) {
            h.E(d);
        }
    }

    protected void B(List<D> list) {
        if (list != null) {
            if (this.aAw == null) {
                this.aAw = new ArrayList();
            }
            this.aAw.clear();
            this.aAw.addAll(list);
            this.aAy.clear();
        }
    }

    protected void b(S s) {
        this.azH = s;
    }

    public List<D> getDataList() {
        return this.aAw == null ? new ArrayList() : new ArrayList(this.aAw);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aAw == null) {
            return 0;
        }
        if (this.aAw.size() == 0 && this.aAB) {
            return 1;
        }
        return this.aAw.size();
    }

    public int EZ() {
        if (this.aAw == null) {
            return 0;
        }
        return this.aAw.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.aAw != null && this.aAw.size() != 0 && i >= 0 && i < this.aAw.size()) {
            return this.aAw.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aAw != null && this.aAw.size() != 0 && i >= 0 && i < this.aAw.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.aAx.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aAx.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.aAC != null) {
            this.aAC.onChangeSkinType(this.aAz, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aAy.indexOfValue(a) >= 0) {
            this.aAy.remove(a.getPosition());
        }
        this.aAy.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aAz.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aAz, inflate, this.aAA);
                h.a(this.aAz, TbadkCoreApplication.m9getInst().getSkinType());
                inflate.setTag(h);
                this.aAx.add(h);
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
            h.a(item, this.azH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fa() {
        if (this.aAD != null && this.aAC != null) {
            this.aAD.removeView(this.aAC);
            this.aAC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Fb() {
        if (this.aAD == null) {
            this.aAD = new FrameLayout(this.aAz.getPageActivity());
        }
        if (this.aAC == null) {
            this.aAC = NoDataViewFactory.a(this.aAz.getPageActivity(), this.aAD, this.aAF, this.aAE, this.aAG);
        }
        this.aAC.setVisibility(0);
        if (this.aAH != null) {
            this.aAC.setLayoutParams(this.aAH);
        }
        this.aAD.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aAC.onChangeSkinType(this.aAz, TbadkCoreApplication.m9getInst().getSkinType());
        return this.aAD;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aAF = cVar;
        this.aAE = dVar;
        this.aAG = bVar;
        this.aAH = layoutParams;
        if (this.aAC != null) {
            this.aAC.setTextOption(dVar);
            this.aAC.setImgOption(cVar);
            this.aAC.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aAC.setLayoutParams(layoutParams);
            }
        }
    }

    public void bS(boolean z) {
        this.aAB = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Fc() {
        return this.aAw != null && this.aAw.size() == 0;
    }
}

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
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.g.a;
import com.baidu.tieba.tbadkCore.t;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements t {
    protected S axB;
    protected final ViewEventCenter ayA;
    private o ayC;
    private FrameLayout ayD;
    private NoDataViewFactory.d ayE;
    private NoDataViewFactory.c ayF;
    private NoDataViewFactory.b ayG;
    private FrameLayout.LayoutParams ayH;
    protected List<D> ayw;
    protected final TbPageContext<?> ayz;
    protected final List<H> ayx = new ArrayList();
    protected final SparseArray<H> ayy = new SparseArray<>();
    protected boolean ayB = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.ayz = tbPageContext;
        this.ayA = viewEventCenter;
    }

    public void r(List<D> list) {
        if (list != null) {
            if (this.ayw == null) {
                this.ayw = new ArrayList();
            }
            this.ayw.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void z(D d) {
        if (d != null && this.ayw != null) {
            this.ayw.remove(d);
            notifyDataSetChanged();
        }
    }

    public void s(List<D> list) {
        t(list);
        notifyDataSetChanged();
    }

    public void a(S s) {
        b(s);
        notifyDataSetChanged();
    }

    public void A(D d) {
        H h;
        if (d != null && this.ayw != null && this.ayw.contains(d) && (h = this.ayy.get(this.ayw.indexOf(d))) != null) {
            h.B(d);
        }
    }

    protected void t(List<D> list) {
        if (list != null) {
            if (this.ayw == null) {
                this.ayw = new ArrayList();
            }
            this.ayw.clear();
            this.ayw.addAll(list);
            this.ayy.clear();
        }
    }

    protected void b(S s) {
        this.axB = s;
    }

    public List<D> DS() {
        return this.ayw == null ? new ArrayList() : new ArrayList(this.ayw);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ayw == null) {
            return 0;
        }
        if (this.ayw.size() == 0 && this.ayB) {
            return 1;
        }
        return this.ayw.size();
    }

    public int DT() {
        if (this.ayw == null) {
            return 0;
        }
        return this.ayw.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.ayw != null && this.ayw.size() != 0 && i >= 0 && i < this.ayw.size()) {
            return this.ayw.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.ayw != null && this.ayw.size() != 0 && i >= 0 && i < this.ayw.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.ayx.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.ayx.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.ayC != null) {
            this.ayC.onChangeSkinType(this.ayz, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.ayy.indexOfValue(a) >= 0) {
            this.ayy.remove(a.getPosition());
        }
        this.ayy.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.ayz.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.ayz, inflate, this.ayA);
                h.a(this.ayz, TbadkCoreApplication.m411getInst().getSkinType());
                inflate.setTag(h);
                this.ayx.add(h);
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
            h.a(item, this.axB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DU() {
        if (this.ayD != null && this.ayC != null) {
            this.ayD.removeView(this.ayC);
            this.ayC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View createNoDataView() {
        if (this.ayD == null) {
            this.ayD = new FrameLayout(this.ayz.getPageActivity());
        }
        if (this.ayC == null) {
            this.ayC = NoDataViewFactory.a(this.ayz.getPageActivity(), this.ayD, this.ayF, this.ayE, this.ayG);
        }
        this.ayC.setVisibility(0);
        if (this.ayH != null) {
            this.ayC.setLayoutParams(this.ayH);
        }
        this.ayD.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.ayC.onChangeSkinType(this.ayz, TbadkCoreApplication.m411getInst().getSkinType());
        return this.ayD;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.ayF = cVar;
        this.ayE = dVar;
        this.ayG = bVar;
        this.ayH = layoutParams;
        if (this.ayC != null) {
            this.ayC.setTextOption(dVar);
            this.ayC.setImgOption(cVar);
            this.ayC.setButtonOption(bVar);
            if (layoutParams != null) {
                this.ayC.setLayoutParams(layoutParams);
            }
        }
    }

    public void bz(boolean z) {
        this.ayB = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean DV() {
        return this.ayw != null && this.ayw.size() == 0;
    }
}

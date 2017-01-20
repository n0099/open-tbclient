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
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
import com.baidu.tieba.tbadkCore.q;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements q {
    protected S ayC;
    private FrameLayout.LayoutParams azA;
    protected List<D> azp;
    protected final TbPageContext<?> azs;
    protected final ViewEventCenter azt;
    private x azv;
    private FrameLayout azw;
    private NoDataViewFactory.d azx;
    private NoDataViewFactory.c azy;
    private NoDataViewFactory.b azz;
    protected final List<H> azq = new ArrayList();
    protected final SparseArray<H> azr = new SparseArray<>();
    protected boolean azu = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.azs = tbPageContext;
        this.azt = viewEventCenter;
    }

    public void x(List<D> list) {
        if (list != null) {
            if (this.azp == null) {
                this.azp = new ArrayList();
            }
            this.azp.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void C(D d) {
        if (d != null && this.azp != null) {
            this.azp.remove(d);
            notifyDataSetChanged();
        }
    }

    public void y(List<D> list) {
        z(list);
        notifyDataSetChanged();
    }

    public void a(S s) {
        b(s);
        notifyDataSetChanged();
    }

    public void D(D d) {
        H h;
        if (d != null && this.azp != null && this.azp.contains(d) && (h = this.azr.get(this.azp.indexOf(d))) != null) {
            h.E(d);
        }
    }

    protected void z(List<D> list) {
        if (list != null) {
            if (this.azp == null) {
                this.azp = new ArrayList();
            }
            this.azp.clear();
            this.azp.addAll(list);
            this.azr.clear();
        }
    }

    protected void b(S s) {
        this.ayC = s;
    }

    public List<D> getDataList() {
        return this.azp == null ? new ArrayList() : new ArrayList(this.azp);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.azp == null) {
            return 0;
        }
        if (this.azp.size() == 0 && this.azu) {
            return 1;
        }
        return this.azp.size();
    }

    public int ET() {
        if (this.azp == null) {
            return 0;
        }
        return this.azp.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.azp != null && this.azp.size() != 0 && i >= 0 && i < this.azp.size()) {
            return this.azp.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.azp != null && this.azp.size() != 0 && i >= 0 && i < this.azp.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.azq.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.azq.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.azv != null) {
            this.azv.onChangeSkinType(this.azs, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.azr.indexOfValue(a) >= 0) {
            this.azr.remove(a.getPosition());
        }
        this.azr.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.azs.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.azs, inflate, this.azt);
                h.a(this.azs, TbadkCoreApplication.m9getInst().getSkinType());
                inflate.setTag(h);
                this.azq.add(h);
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
            h.a(item, this.ayC);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EU() {
        if (this.azw != null && this.azv != null) {
            this.azw.removeView(this.azv);
            this.azv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View EV() {
        if (this.azw == null) {
            this.azw = new FrameLayout(this.azs.getPageActivity());
        }
        if (this.azv == null) {
            this.azv = NoDataViewFactory.a(this.azs.getPageActivity(), this.azw, this.azy, this.azx, this.azz);
        }
        this.azv.setVisibility(0);
        if (this.azA != null) {
            this.azv.setLayoutParams(this.azA);
        }
        this.azw.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.azv.onChangeSkinType(this.azs, TbadkCoreApplication.m9getInst().getSkinType());
        return this.azw;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.azy = cVar;
        this.azx = dVar;
        this.azz = bVar;
        this.azA = layoutParams;
        if (this.azv != null) {
            this.azv.setTextOption(dVar);
            this.azv.setImgOption(cVar);
            this.azv.setButtonOption(bVar);
            if (layoutParams != null) {
                this.azv.setLayoutParams(layoutParams);
            }
        }
    }

    public void bS(boolean z) {
        this.azu = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean EW() {
        return this.azp != null && this.azp.size() == 0;
    }
}

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
    protected List<D> bze;
    protected S coH;
    private NoDataViewFactory.b cpA;
    private FrameLayout.LayoutParams cpB;
    protected final TbPageContext<?> cps;
    protected final ViewEventCenter cpt;
    private NoDataView cpw;
    private FrameLayout cpx;
    private NoDataViewFactory.d cpy;
    private NoDataViewFactory.c cpz;
    protected final List<H> cpq = new ArrayList();
    protected final SparseArray<H> cpr = new SparseArray<>();
    protected boolean cpv = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.cps = tbPageContext;
        this.cpt = viewEventCenter;
    }

    public void ad(List<D> list) {
        if (list != null) {
            if (this.bze == null) {
                this.bze = new ArrayList();
            }
            this.bze.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void ad(D d) {
        if (d != null && this.bze != null) {
            this.bze.remove(d);
            notifyDataSetChanged();
        }
    }

    public void ae(List<D> list) {
        af(list);
        notifyDataSetChanged();
    }

    public void ae(D d) {
        H h;
        if (d != null && this.bze != null && this.bze.contains(d) && (h = this.cpr.get(this.bze.indexOf(d))) != null) {
            h.af(d);
        }
    }

    protected void af(List<D> list) {
        if (list != null) {
            if (this.bze == null) {
                this.bze = new ArrayList();
            }
            this.bze.clear();
            this.bze.addAll(list);
            this.cpr.clear();
        }
    }

    public List<D> getDataList() {
        return this.bze == null ? new ArrayList() : new ArrayList(this.bze);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bze == null) {
            return 0;
        }
        if (this.bze.size() == 0 && this.cpv) {
            return 1;
        }
        return this.bze.size();
    }

    public int aoG() {
        if (this.bze == null) {
            return 0;
        }
        return this.bze.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.bze != null && this.bze.size() != 0 && i >= 0 && i < this.bze.size()) {
            return this.bze.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bze != null && this.bze.size() != 0 && i >= 0 && i < this.bze.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.cpq.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.cpq.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.cpw != null) {
            this.cpw.onChangeSkinType(this.cps, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.cpr.indexOfValue(a) >= 0) {
            this.cpr.remove(a.getPosition());
        }
        this.cpr.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.cps.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.cps, inflate, this.cpt);
                h.b(this.cps, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.cpq.add(h);
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
            h.a(item, this.coH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoH() {
        if (this.cpx != null && this.cpw != null) {
            this.cpx.removeView(this.cpw);
            this.cpw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aoI() {
        if (this.cpx == null) {
            this.cpx = new FrameLayout(this.cps.getPageActivity());
        }
        if (this.cpw == null) {
            this.cpw = NoDataViewFactory.a(this.cps.getPageActivity(), this.cpx, this.cpz, this.cpy, this.cpA);
        }
        this.cpw.setVisibility(0);
        if (this.cpB != null) {
            this.cpw.setLayoutParams(this.cpB);
        }
        this.cpx.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.cpw.onChangeSkinType(this.cps, TbadkCoreApplication.getInst().getSkinType());
        return this.cpx;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.cpz = cVar;
        this.cpy = dVar;
        this.cpA = bVar;
        this.cpB = layoutParams;
        if (this.cpw != null) {
            this.cpw.setTextOption(dVar);
            this.cpw.setImgOption(cVar);
            this.cpw.setButtonOption(bVar);
            if (layoutParams != null) {
                this.cpw.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aoJ() {
        return this.bze != null && this.bze.size() == 0;
    }
}

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
    protected List<D> arN;
    protected final TbPageContext<?> beX;
    protected final ViewEventCenter beY;
    protected S bem;
    private NoDataView bfa;
    private FrameLayout bfc;
    private NoDataViewFactory.d bfd;
    private NoDataViewFactory.c bfe;
    private NoDataViewFactory.b bff;
    private FrameLayout.LayoutParams bfg;
    protected final List<H> beV = new ArrayList();
    protected final SparseArray<H> beW = new SparseArray<>();
    protected boolean beZ = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.beX = tbPageContext;
        this.beY = viewEventCenter;
    }

    public void Q(List<D> list) {
        if (list != null) {
            if (this.arN == null) {
                this.arN = new ArrayList();
            }
            this.arN.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void J(D d) {
        if (d != null && this.arN != null) {
            this.arN.remove(d);
            notifyDataSetChanged();
        }
    }

    public void R(List<D> list) {
        S(list);
        notifyDataSetChanged();
    }

    public void K(D d) {
        H h;
        if (d != null && this.arN != null && this.arN.contains(d) && (h = this.beW.get(this.arN.indexOf(d))) != null) {
            h.L(d);
        }
    }

    protected void S(List<D> list) {
        if (list != null) {
            if (this.arN == null) {
                this.arN = new ArrayList();
            }
            this.arN.clear();
            this.arN.addAll(list);
            this.beW.clear();
        }
    }

    public List<D> getDataList() {
        return this.arN == null ? new ArrayList() : new ArrayList(this.arN);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.arN == null) {
            return 0;
        }
        if (this.arN.size() == 0 && this.beZ) {
            return 1;
        }
        return this.arN.size();
    }

    public int OI() {
        if (this.arN == null) {
            return 0;
        }
        return this.arN.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.arN != null && this.arN.size() != 0 && i >= 0 && i < this.arN.size()) {
            return this.arN.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.arN != null && this.arN.size() != 0 && i >= 0 && i < this.arN.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.beV.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.beV.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.bfa != null) {
            this.bfa.onChangeSkinType(this.beX, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.beW.indexOfValue(a) >= 0) {
            this.beW.remove(a.getPosition());
        }
        this.beW.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.beX.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.beX, inflate, this.beY);
                h.b(this.beX, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.beV.add(h);
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
            h.a(item, this.bem);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void OJ() {
        if (this.bfc != null && this.bfa != null) {
            this.bfc.removeView(this.bfa);
            this.bfa = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View OK() {
        if (this.bfc == null) {
            this.bfc = new FrameLayout(this.beX.getPageActivity());
        }
        if (this.bfa == null) {
            this.bfa = NoDataViewFactory.a(this.beX.getPageActivity(), this.bfc, this.bfe, this.bfd, this.bff);
        }
        this.bfa.setVisibility(0);
        if (this.bfg != null) {
            this.bfa.setLayoutParams(this.bfg);
        }
        this.bfc.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.bfa.onChangeSkinType(this.beX, TbadkCoreApplication.getInst().getSkinType());
        return this.bfc;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.bfe = cVar;
        this.bfd = dVar;
        this.bff = bVar;
        this.bfg = layoutParams;
        if (this.bfa != null) {
            this.bfa.setTextOption(dVar);
            this.bfa.setImgOption(cVar);
            this.bfa.setButtonOption(bVar);
            if (layoutParams != null) {
                this.bfa.setLayoutParams(layoutParams);
            }
        }
    }

    public void cI(boolean z) {
        this.beZ = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean OL() {
        return this.arN != null && this.arN.size() == 0;
    }
}

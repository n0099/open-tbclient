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
    protected final TbPageContext<?> beU;
    protected final ViewEventCenter beV;
    private NoDataView beX;
    private FrameLayout beY;
    private NoDataViewFactory.d beZ;
    protected S bej;
    private NoDataViewFactory.c bfa;
    private NoDataViewFactory.b bfc;
    private FrameLayout.LayoutParams bfd;
    protected final List<H> beS = new ArrayList();
    protected final SparseArray<H> beT = new SparseArray<>();
    protected boolean beW = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.beU = tbPageContext;
        this.beV = viewEventCenter;
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
        if (d != null && this.arN != null && this.arN.contains(d) && (h = this.beT.get(this.arN.indexOf(d))) != null) {
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
            this.beT.clear();
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
        if (this.arN.size() == 0 && this.beW) {
            return 1;
        }
        return this.arN.size();
    }

    public int OH() {
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
        int size = this.beS.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.beS.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.beX != null) {
            this.beX.onChangeSkinType(this.beU, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.beT.indexOfValue(a) >= 0) {
            this.beT.remove(a.getPosition());
        }
        this.beT.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.beU.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.beU, inflate, this.beV);
                h.b(this.beU, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.beS.add(h);
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
            h.a(item, this.bej);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void OI() {
        if (this.beY != null && this.beX != null) {
            this.beY.removeView(this.beX);
            this.beX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View OJ() {
        if (this.beY == null) {
            this.beY = new FrameLayout(this.beU.getPageActivity());
        }
        if (this.beX == null) {
            this.beX = NoDataViewFactory.a(this.beU.getPageActivity(), this.beY, this.bfa, this.beZ, this.bfc);
        }
        this.beX.setVisibility(0);
        if (this.bfd != null) {
            this.beX.setLayoutParams(this.bfd);
        }
        this.beY.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.beX.onChangeSkinType(this.beU, TbadkCoreApplication.getInst().getSkinType());
        return this.beY;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.bfa = cVar;
        this.beZ = dVar;
        this.bfc = bVar;
        this.bfd = layoutParams;
        if (this.beX != null) {
            this.beX.setTextOption(dVar);
            this.beX.setImgOption(cVar);
            this.beX.setButtonOption(bVar);
            if (layoutParams != null) {
                this.beX.setLayoutParams(layoutParams);
            }
        }
    }

    public void cI(boolean z) {
        this.beW = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean OK() {
        return this.arN != null && this.arN.size() == 0;
    }
}

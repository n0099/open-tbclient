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
    protected S aZX;
    protected List<D> anz;
    protected final TbPageContext<?> baI;
    protected final ViewEventCenter baJ;
    private NoDataView baL;
    private FrameLayout baM;
    private NoDataViewFactory.d baN;
    private NoDataViewFactory.c baO;
    private NoDataViewFactory.b baP;
    private FrameLayout.LayoutParams baQ;
    protected final List<H> baG = new ArrayList();
    protected final SparseArray<H> baH = new SparseArray<>();
    protected boolean baK = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.baI = tbPageContext;
        this.baJ = viewEventCenter;
    }

    public void R(List<D> list) {
        if (list != null) {
            if (this.anz == null) {
                this.anz = new ArrayList();
            }
            this.anz.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void J(D d) {
        if (d != null && this.anz != null) {
            this.anz.remove(d);
            notifyDataSetChanged();
        }
    }

    public void S(List<D> list) {
        T(list);
        notifyDataSetChanged();
    }

    public void K(D d) {
        H h;
        if (d != null && this.anz != null && this.anz.contains(d) && (h = this.baH.get(this.anz.indexOf(d))) != null) {
            h.L(d);
        }
    }

    protected void T(List<D> list) {
        if (list != null) {
            if (this.anz == null) {
                this.anz = new ArrayList();
            }
            this.anz.clear();
            this.anz.addAll(list);
            this.baH.clear();
        }
    }

    public List<D> getDataList() {
        return this.anz == null ? new ArrayList() : new ArrayList(this.anz);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anz == null) {
            return 0;
        }
        if (this.anz.size() == 0 && this.baK) {
            return 1;
        }
        return this.anz.size();
    }

    public int Nu() {
        if (this.anz == null) {
            return 0;
        }
        return this.anz.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.anz != null && this.anz.size() != 0 && i >= 0 && i < this.anz.size()) {
            return this.anz.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.anz != null && this.anz.size() != 0 && i >= 0 && i < this.anz.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.baG.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.baG.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.baL != null) {
            this.baL.onChangeSkinType(this.baI, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.baH.indexOfValue(a) >= 0) {
            this.baH.remove(a.getPosition());
        }
        this.baH.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.baI.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.baI, inflate, this.baJ);
                h.b(this.baI, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.baG.add(h);
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
            h.a(item, this.aZX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Nv() {
        if (this.baM != null && this.baL != null) {
            this.baM.removeView(this.baL);
            this.baL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Nw() {
        if (this.baM == null) {
            this.baM = new FrameLayout(this.baI.getPageActivity());
        }
        if (this.baL == null) {
            this.baL = NoDataViewFactory.a(this.baI.getPageActivity(), this.baM, this.baO, this.baN, this.baP);
        }
        this.baL.setVisibility(0);
        if (this.baQ != null) {
            this.baL.setLayoutParams(this.baQ);
        }
        this.baM.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.baL.onChangeSkinType(this.baI, TbadkCoreApplication.getInst().getSkinType());
        return this.baM;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.baO = cVar;
        this.baN = dVar;
        this.baP = bVar;
        this.baQ = layoutParams;
        if (this.baL != null) {
            this.baL.setTextOption(dVar);
            this.baL.setImgOption(cVar);
            this.baL.setButtonOption(bVar);
            if (layoutParams != null) {
                this.baL.setLayoutParams(layoutParams);
            }
        }
    }

    public void cq(boolean z) {
        this.baK = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Nx() {
        return this.anz != null && this.anz.size() == 0;
    }
}

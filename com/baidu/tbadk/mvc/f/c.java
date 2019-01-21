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
    protected List<D> asq;
    protected S beY;
    protected final TbPageContext<?> bfJ;
    protected final ViewEventCenter bfK;
    private NoDataView bfM;
    private FrameLayout bfN;
    private NoDataViewFactory.d bfO;
    private NoDataViewFactory.c bfP;
    private NoDataViewFactory.b bfQ;
    private FrameLayout.LayoutParams bfR;
    protected final List<H> bfH = new ArrayList();
    protected final SparseArray<H> bfI = new SparseArray<>();
    protected boolean bfL = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.bfJ = tbPageContext;
        this.bfK = viewEventCenter;
    }

    public void R(List<D> list) {
        if (list != null) {
            if (this.asq == null) {
                this.asq = new ArrayList();
            }
            this.asq.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void J(D d) {
        if (d != null && this.asq != null) {
            this.asq.remove(d);
            notifyDataSetChanged();
        }
    }

    public void S(List<D> list) {
        T(list);
        notifyDataSetChanged();
    }

    public void K(D d) {
        H h;
        if (d != null && this.asq != null && this.asq.contains(d) && (h = this.bfI.get(this.asq.indexOf(d))) != null) {
            h.L(d);
        }
    }

    protected void T(List<D> list) {
        if (list != null) {
            if (this.asq == null) {
                this.asq = new ArrayList();
            }
            this.asq.clear();
            this.asq.addAll(list);
            this.bfI.clear();
        }
    }

    public List<D> getDataList() {
        return this.asq == null ? new ArrayList() : new ArrayList(this.asq);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.asq == null) {
            return 0;
        }
        if (this.asq.size() == 0 && this.bfL) {
            return 1;
        }
        return this.asq.size();
    }

    public int Pa() {
        if (this.asq == null) {
            return 0;
        }
        return this.asq.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.asq != null && this.asq.size() != 0 && i >= 0 && i < this.asq.size()) {
            return this.asq.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.asq != null && this.asq.size() != 0 && i >= 0 && i < this.asq.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.bfH.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.bfH.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.bfM != null) {
            this.bfM.onChangeSkinType(this.bfJ, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.bfI.indexOfValue(a) >= 0) {
            this.bfI.remove(a.getPosition());
        }
        this.bfI.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.bfJ.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.bfJ, inflate, this.bfK);
                h.b(this.bfJ, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.bfH.add(h);
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
            h.a(item, this.beY);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Pb() {
        if (this.bfN != null && this.bfM != null) {
            this.bfN.removeView(this.bfM);
            this.bfM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Pc() {
        if (this.bfN == null) {
            this.bfN = new FrameLayout(this.bfJ.getPageActivity());
        }
        if (this.bfM == null) {
            this.bfM = NoDataViewFactory.a(this.bfJ.getPageActivity(), this.bfN, this.bfP, this.bfO, this.bfQ);
        }
        this.bfM.setVisibility(0);
        if (this.bfR != null) {
            this.bfM.setLayoutParams(this.bfR);
        }
        this.bfN.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.bfM.onChangeSkinType(this.bfJ, TbadkCoreApplication.getInst().getSkinType());
        return this.bfN;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.bfP = cVar;
        this.bfO = dVar;
        this.bfQ = bVar;
        this.bfR = layoutParams;
        if (this.bfM != null) {
            this.bfM.setTextOption(dVar);
            this.bfM.setImgOption(cVar);
            this.bfM.setButtonOption(bVar);
            if (layoutParams != null) {
                this.bfM.setLayoutParams(layoutParams);
            }
        }
    }

    public void cL(boolean z) {
        this.bfL = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Pd() {
        return this.asq != null && this.asq.size() == 0;
    }
}

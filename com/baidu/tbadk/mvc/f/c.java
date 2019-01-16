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
    protected List<D> asp;
    protected S beX;
    protected final TbPageContext<?> bfI;
    protected final ViewEventCenter bfJ;
    private NoDataView bfL;
    private FrameLayout bfM;
    private NoDataViewFactory.d bfN;
    private NoDataViewFactory.c bfO;
    private NoDataViewFactory.b bfP;
    private FrameLayout.LayoutParams bfQ;
    protected final List<H> bfG = new ArrayList();
    protected final SparseArray<H> bfH = new SparseArray<>();
    protected boolean bfK = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.bfI = tbPageContext;
        this.bfJ = viewEventCenter;
    }

    public void R(List<D> list) {
        if (list != null) {
            if (this.asp == null) {
                this.asp = new ArrayList();
            }
            this.asp.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void J(D d) {
        if (d != null && this.asp != null) {
            this.asp.remove(d);
            notifyDataSetChanged();
        }
    }

    public void S(List<D> list) {
        T(list);
        notifyDataSetChanged();
    }

    public void K(D d) {
        H h;
        if (d != null && this.asp != null && this.asp.contains(d) && (h = this.bfH.get(this.asp.indexOf(d))) != null) {
            h.L(d);
        }
    }

    protected void T(List<D> list) {
        if (list != null) {
            if (this.asp == null) {
                this.asp = new ArrayList();
            }
            this.asp.clear();
            this.asp.addAll(list);
            this.bfH.clear();
        }
    }

    public List<D> getDataList() {
        return this.asp == null ? new ArrayList() : new ArrayList(this.asp);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.asp == null) {
            return 0;
        }
        if (this.asp.size() == 0 && this.bfK) {
            return 1;
        }
        return this.asp.size();
    }

    public int Pa() {
        if (this.asp == null) {
            return 0;
        }
        return this.asp.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.asp != null && this.asp.size() != 0 && i >= 0 && i < this.asp.size()) {
            return this.asp.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.asp != null && this.asp.size() != 0 && i >= 0 && i < this.asp.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.bfG.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.bfG.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.bfL != null) {
            this.bfL.onChangeSkinType(this.bfI, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.bfH.indexOfValue(a) >= 0) {
            this.bfH.remove(a.getPosition());
        }
        this.bfH.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.bfI.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.bfI, inflate, this.bfJ);
                h.b(this.bfI, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.bfG.add(h);
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
            h.a(item, this.beX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Pb() {
        if (this.bfM != null && this.bfL != null) {
            this.bfM.removeView(this.bfL);
            this.bfL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Pc() {
        if (this.bfM == null) {
            this.bfM = new FrameLayout(this.bfI.getPageActivity());
        }
        if (this.bfL == null) {
            this.bfL = NoDataViewFactory.a(this.bfI.getPageActivity(), this.bfM, this.bfO, this.bfN, this.bfP);
        }
        this.bfL.setVisibility(0);
        if (this.bfQ != null) {
            this.bfL.setLayoutParams(this.bfQ);
        }
        this.bfM.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.bfL.onChangeSkinType(this.bfI, TbadkCoreApplication.getInst().getSkinType());
        return this.bfM;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.bfO = cVar;
        this.bfN = dVar;
        this.bfP = bVar;
        this.bfQ = layoutParams;
        if (this.bfL != null) {
            this.bfL.setTextOption(dVar);
            this.bfL.setImgOption(cVar);
            this.bfL.setButtonOption(bVar);
            if (layoutParams != null) {
                this.bfL.setLayoutParams(layoutParams);
            }
        }
    }

    public void cL(boolean z) {
        this.bfK = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Pd() {
        return this.asp != null && this.asp.size() == 0;
    }
}

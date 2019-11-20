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
import com.baidu.tieba.tbadkCore.q;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements q {
    protected List<D> bYP;
    protected S cJL;
    private NoDataView cKA;
    private FrameLayout cKB;
    private NoDataViewFactory.d cKC;
    private NoDataViewFactory.c cKD;
    private NoDataViewFactory.b cKE;
    private FrameLayout.LayoutParams cKF;
    protected final TbPageContext<?> cKx;
    protected final ViewEventCenter cKy;
    protected final List<H> cKv = new ArrayList();
    protected final SparseArray<H> cKw = new SparseArray<>();
    protected boolean cKz = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.cKx = tbPageContext;
        this.cKy = viewEventCenter;
    }

    public void aE(List<D> list) {
        if (list != null) {
            if (this.bYP == null) {
                this.bYP = new ArrayList();
            }
            this.bYP.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void Z(D d) {
        if (d != null && this.bYP != null) {
            this.bYP.remove(d);
            notifyDataSetChanged();
        }
    }

    public void aF(List<D> list) {
        aG(list);
        notifyDataSetChanged();
    }

    public void aa(D d) {
        H h;
        if (d != null && this.bYP != null && this.bYP.contains(d) && (h = this.cKw.get(this.bYP.indexOf(d))) != null) {
            h.ab(d);
        }
    }

    protected void aG(List<D> list) {
        if (list != null) {
            if (this.bYP == null) {
                this.bYP = new ArrayList();
            }
            this.bYP.clear();
            this.bYP.addAll(list);
            this.cKw.clear();
        }
    }

    public List<D> getDataList() {
        return this.bYP == null ? new ArrayList() : new ArrayList(this.bYP);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bYP == null) {
            return 0;
        }
        if (this.bYP.size() == 0 && this.cKz) {
            return 1;
        }
        return this.bYP.size();
    }

    public int aws() {
        if (this.bYP == null) {
            return 0;
        }
        return this.bYP.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.bYP != null && this.bYP.size() != 0 && i >= 0 && i < this.bYP.size()) {
            return this.bYP.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bYP != null && this.bYP.size() != 0 && i >= 0 && i < this.bYP.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.cKv.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.cKv.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.cKA != null) {
            this.cKA.onChangeSkinType(this.cKx, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.cKw.indexOfValue(a) >= 0) {
            this.cKw.remove(a.getPosition());
        }
        this.cKw.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.cKx.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.cKx, inflate, this.cKy);
                h.b(this.cKx, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.cKv.add(h);
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
            h.a(item, this.cJL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awt() {
        if (this.cKB != null && this.cKA != null) {
            this.cKB.removeView(this.cKA);
            this.cKA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View awu() {
        if (this.cKB == null) {
            this.cKB = new FrameLayout(this.cKx.getPageActivity());
        }
        if (this.cKA == null) {
            this.cKA = NoDataViewFactory.a(this.cKx.getPageActivity(), this.cKB, this.cKD, this.cKC, this.cKE);
        }
        this.cKA.setVisibility(0);
        if (this.cKF != null) {
            this.cKA.setLayoutParams(this.cKF);
        }
        this.cKB.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.cKA.onChangeSkinType(this.cKx, TbadkCoreApplication.getInst().getSkinType());
        return this.cKB;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.cKD = cVar;
        this.cKC = dVar;
        this.cKE = bVar;
        this.cKF = layoutParams;
        if (this.cKA != null) {
            this.cKA.setTextOption(dVar);
            this.cKA.setImgOption(cVar);
            this.cKA.setButtonOption(bVar);
            if (layoutParams != null) {
                this.cKA.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean we() {
        return this.bYP != null && this.bYP.size() == 0;
    }
}

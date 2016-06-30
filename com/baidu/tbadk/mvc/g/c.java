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
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.g.a;
import com.baidu.tieba.tbadkCore.t;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements t {
    protected S avT;
    protected List<D> awM;
    protected final TbPageContext<?> awP;
    protected final ViewEventCenter awQ;
    private q awS;
    private FrameLayout awT;
    private NoDataViewFactory.d awU;
    private NoDataViewFactory.c awV;
    private NoDataViewFactory.b awW;
    private FrameLayout.LayoutParams awX;
    protected final List<H> awN = new ArrayList();
    protected final SparseArray<H> awO = new SparseArray<>();
    protected boolean awR = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.awP = tbPageContext;
        this.awQ = viewEventCenter;
    }

    public void z(List<D> list) {
        if (list != null) {
            if (this.awM == null) {
                this.awM = new ArrayList();
            }
            this.awM.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void z(D d) {
        if (d != null && this.awM != null) {
            this.awM.remove(d);
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

    public void A(D d) {
        H h;
        if (d != null && this.awM != null && this.awM.contains(d) && (h = this.awO.get(this.awM.indexOf(d))) != null) {
            h.B(d);
        }
    }

    protected void B(List<D> list) {
        if (list != null) {
            if (this.awM == null) {
                this.awM = new ArrayList();
            }
            this.awM.clear();
            this.awM.addAll(list);
            this.awO.clear();
        }
    }

    protected void b(S s) {
        this.avT = s;
    }

    public List<D> Eb() {
        return this.awM == null ? new ArrayList() : new ArrayList(this.awM);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.awM == null) {
            return 0;
        }
        if (this.awM.size() == 0 && this.awR) {
            return 1;
        }
        return this.awM.size();
    }

    public int Ec() {
        if (this.awM == null) {
            return 0;
        }
        return this.awM.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.awM != null && this.awM.size() != 0 && i >= 0 && i < this.awM.size()) {
            return this.awM.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.awM != null && this.awM.size() != 0 && i >= 0 && i < this.awM.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.awN.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.awN.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.awS != null) {
            this.awS.onChangeSkinType(this.awP, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.awO.indexOfValue(a) >= 0) {
            this.awO.remove(a.getPosition());
        }
        this.awO.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.awP.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.awP, inflate, this.awQ);
                h.a(this.awP, TbadkCoreApplication.m9getInst().getSkinType());
                inflate.setTag(h);
                this.awN.add(h);
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
            h.a(item, this.avT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ed() {
        if (this.awT != null && this.awS != null) {
            this.awT.removeView(this.awS);
            this.awS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Ee() {
        if (this.awT == null) {
            this.awT = new FrameLayout(this.awP.getPageActivity());
        }
        if (this.awS == null) {
            this.awS = NoDataViewFactory.a(this.awP.getPageActivity(), this.awT, this.awV, this.awU, this.awW);
        }
        this.awS.setVisibility(0);
        if (this.awX != null) {
            this.awS.setLayoutParams(this.awX);
        }
        this.awT.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.awS.onChangeSkinType(this.awP, TbadkCoreApplication.m9getInst().getSkinType());
        return this.awT;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.awV = cVar;
        this.awU = dVar;
        this.awW = bVar;
        this.awX = layoutParams;
        if (this.awS != null) {
            this.awS.setTextOption(dVar);
            this.awS.setImgOption(cVar);
            this.awS.setButtonOption(bVar);
            if (layoutParams != null) {
                this.awS.setLayoutParams(layoutParams);
            }
        }
    }

    public void bL(boolean z) {
        this.awR = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ef() {
        return this.awM != null && this.awM.size() == 0;
    }
}

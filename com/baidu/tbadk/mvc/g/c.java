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
import com.baidu.tbadk.core.view.m;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.g.a;
import com.baidu.tieba.tbadkCore.s;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements s {
    protected S atT;
    protected List<D> auO;
    protected final TbPageContext<?> auR;
    protected final ViewEventCenter auS;
    private m auU;
    private FrameLayout auV;
    private NoDataViewFactory.d auW;
    private NoDataViewFactory.c auX;
    private NoDataViewFactory.b auY;
    private FrameLayout.LayoutParams auZ;
    protected final List<H> auP = new ArrayList();
    protected final SparseArray<H> auQ = new SparseArray<>();
    protected boolean auT = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.auR = tbPageContext;
        this.auS = viewEventCenter;
    }

    public void r(List<D> list) {
        if (list != null) {
            if (this.auO == null) {
                this.auO = new ArrayList();
            }
            this.auO.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void z(D d) {
        if (d != null && this.auO != null) {
            this.auO.remove(d);
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
        if (d != null && this.auO != null && this.auO.contains(d) && (h = this.auQ.get(this.auO.indexOf(d))) != null) {
            h.B(d);
        }
    }

    protected void t(List<D> list) {
        if (list != null) {
            if (this.auO == null) {
                this.auO = new ArrayList();
            }
            this.auO.clear();
            this.auO.addAll(list);
            this.auQ.clear();
        }
    }

    protected void b(S s) {
        this.atT = s;
    }

    public List<D> Dc() {
        return this.auO == null ? new ArrayList() : new ArrayList(this.auO);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auO == null) {
            return 0;
        }
        if (this.auO.size() == 0 && this.auT) {
            return 1;
        }
        return this.auO.size();
    }

    public int Dd() {
        if (this.auO == null) {
            return 0;
        }
        return this.auO.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.auO != null && this.auO.size() != 0 && i >= 0 && i < this.auO.size()) {
            return this.auO.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.auO != null && this.auO.size() != 0 && i >= 0 && i < this.auO.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.auP.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.auP.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.auU != null) {
            this.auU.onChangeSkinType(this.auR, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.auQ.indexOfValue(a) >= 0) {
            this.auQ.remove(a.getPosition());
        }
        this.auQ.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.auR.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.auR, inflate, this.auS);
                h.a(this.auR, TbadkCoreApplication.m411getInst().getSkinType());
                inflate.setTag(h);
                this.auP.add(h);
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
            h.a(item, this.atT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void De() {
        if (this.auV != null && this.auU != null) {
            this.auV.removeView(this.auU);
            this.auU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View createNoDataView() {
        if (this.auV == null) {
            this.auV = new FrameLayout(this.auR.getPageActivity());
        }
        if (this.auU == null) {
            this.auU = NoDataViewFactory.a(this.auR.getPageActivity(), this.auV, this.auX, this.auW, this.auY);
        }
        this.auU.setVisibility(0);
        if (this.auZ != null) {
            this.auU.setLayoutParams(this.auZ);
        }
        this.auV.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.auU.onChangeSkinType(this.auR, TbadkCoreApplication.m411getInst().getSkinType());
        return this.auV;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.auX = cVar;
        this.auW = dVar;
        this.auY = bVar;
        this.auZ = layoutParams;
        if (this.auU != null) {
            this.auU.setTextOption(dVar);
            this.auU.setImgOption(cVar);
            this.auU.setButtonOption(bVar);
            if (layoutParams != null) {
                this.auU.setLayoutParams(layoutParams);
            }
        }
    }

    public void br(boolean z) {
        this.auT = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Df() {
        return this.auO != null && this.auO.size() == 0;
    }
}

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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
import com.baidu.tieba.tbadkCore.o;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements o {
    protected List<D> aNc;
    protected S byy;
    protected final TbPageContext<?> bzj;
    protected final ViewEventCenter bzk;
    private h bzm;
    private FrameLayout bzn;
    private NoDataViewFactory.d bzo;
    private NoDataViewFactory.c bzp;
    private NoDataViewFactory.b bzq;
    private FrameLayout.LayoutParams bzr;
    protected final List<H> bzh = new ArrayList();
    protected final SparseArray<H> bzi = new SparseArray<>();
    protected boolean bzl = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.bzj = tbPageContext;
        this.bzk = viewEventCenter;
    }

    public void M(List<D> list) {
        if (list != null) {
            if (this.aNc == null) {
                this.aNc = new ArrayList();
            }
            this.aNc.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void aG(D d) {
        if (d != null && this.aNc != null) {
            this.aNc.remove(d);
            notifyDataSetChanged();
        }
    }

    public void N(List<D> list) {
        O(list);
        notifyDataSetChanged();
    }

    public void aH(D d) {
        H h;
        if (d != null && this.aNc != null && this.aNc.contains(d) && (h = this.bzi.get(this.aNc.indexOf(d))) != null) {
            h.aI(d);
        }
    }

    protected void O(List<D> list) {
        if (list != null) {
            if (this.aNc == null) {
                this.aNc = new ArrayList();
            }
            this.aNc.clear();
            this.aNc.addAll(list);
            this.bzi.clear();
        }
    }

    public List<D> getDataList() {
        return this.aNc == null ? new ArrayList() : new ArrayList(this.aNc);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aNc == null) {
            return 0;
        }
        if (this.aNc.size() == 0 && this.bzl) {
            return 1;
        }
        return this.aNc.size();
    }

    public int NH() {
        if (this.aNc == null) {
            return 0;
        }
        return this.aNc.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.aNc != null && this.aNc.size() != 0 && i >= 0 && i < this.aNc.size()) {
            return this.aNc.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aNc != null && this.aNc.size() != 0 && i >= 0 && i < this.aNc.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.bzh.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.bzh.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.bzm != null) {
            this.bzm.onChangeSkinType(this.bzj, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.bzi.indexOfValue(a) >= 0) {
            this.bzi.remove(a.getPosition());
        }
        this.bzi.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.bzj.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.bzj, inflate, this.bzk);
                h.b(this.bzj, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.bzh.add(h);
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
            h.a(item, this.byy);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void NI() {
        if (this.bzn != null && this.bzm != null) {
            this.bzn.removeView(this.bzm);
            this.bzm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View NJ() {
        if (this.bzn == null) {
            this.bzn = new FrameLayout(this.bzj.getPageActivity());
        }
        if (this.bzm == null) {
            this.bzm = NoDataViewFactory.a(this.bzj.getPageActivity(), this.bzn, this.bzp, this.bzo, this.bzq);
        }
        this.bzm.setVisibility(0);
        if (this.bzr != null) {
            this.bzm.setLayoutParams(this.bzr);
        }
        this.bzn.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.bzm.onChangeSkinType(this.bzj, TbadkCoreApplication.getInst().getSkinType());
        return this.bzn;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.bzp = cVar;
        this.bzo = dVar;
        this.bzq = bVar;
        this.bzr = layoutParams;
        if (this.bzm != null) {
            this.bzm.setTextOption(dVar);
            this.bzm.setImgOption(cVar);
            this.bzm.setButtonOption(bVar);
            if (layoutParams != null) {
                this.bzm.setLayoutParams(layoutParams);
            }
        }
    }

    public void cx(boolean z) {
        this.bzl = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean NK() {
        return this.aNc != null && this.aNc.size() == 0;
    }
}

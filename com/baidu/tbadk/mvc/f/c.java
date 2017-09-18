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
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
import com.baidu.tieba.tbadkCore.l;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements l {
    protected List<D> WP;
    protected S aHt;
    protected final TbPageContext<?> aIi;
    protected final ViewEventCenter aIj;
    private j aIl;
    private FrameLayout aIm;
    private NoDataViewFactory.d aIn;
    private NoDataViewFactory.c aIo;
    private NoDataViewFactory.b aIp;
    private FrameLayout.LayoutParams aIq;
    protected final List<H> aIg = new ArrayList();
    protected final SparseArray<H> aIh = new SparseArray<>();
    protected boolean aIk = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aIi = tbPageContext;
        this.aIj = viewEventCenter;
    }

    public void C(List<D> list) {
        if (list != null) {
            if (this.WP == null) {
                this.WP = new ArrayList();
            }
            this.WP.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void B(D d) {
        if (d != null && this.WP != null) {
            this.WP.remove(d);
            notifyDataSetChanged();
        }
    }

    public void D(List<D> list) {
        E(list);
        notifyDataSetChanged();
    }

    public void C(D d) {
        H h;
        if (d != null && this.WP != null && this.WP.contains(d) && (h = this.aIh.get(this.WP.indexOf(d))) != null) {
            h.D(d);
        }
    }

    protected void E(List<D> list) {
        if (list != null) {
            if (this.WP == null) {
                this.WP = new ArrayList();
            }
            this.WP.clear();
            this.WP.addAll(list);
            this.aIh.clear();
        }
    }

    public List<D> getDataList() {
        return this.WP == null ? new ArrayList() : new ArrayList(this.WP);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.WP == null) {
            return 0;
        }
        if (this.WP.size() == 0 && this.aIk) {
            return 1;
        }
        return this.WP.size();
    }

    public int FH() {
        if (this.WP == null) {
            return 0;
        }
        return this.WP.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.WP != null && this.WP.size() != 0 && i >= 0 && i < this.WP.size()) {
            return this.WP.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.WP != null && this.WP.size() != 0 && i >= 0 && i < this.WP.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aIg.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aIg.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aIl != null) {
            this.aIl.onChangeSkinType(this.aIi, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aIh.indexOfValue(a) >= 0) {
            this.aIh.remove(a.getPosition());
        }
        this.aIh.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aIi.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aIi, inflate, this.aIj);
                h.b(this.aIi, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aIg.add(h);
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
            h.a(item, this.aHt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FI() {
        if (this.aIm != null && this.aIl != null) {
            this.aIm.removeView(this.aIl);
            this.aIl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View FJ() {
        if (this.aIm == null) {
            this.aIm = new FrameLayout(this.aIi.getPageActivity());
        }
        if (this.aIl == null) {
            this.aIl = NoDataViewFactory.a(this.aIi.getPageActivity(), this.aIm, this.aIo, this.aIn, this.aIp);
        }
        this.aIl.setVisibility(0);
        if (this.aIq != null) {
            this.aIl.setLayoutParams(this.aIq);
        }
        this.aIm.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aIl.onChangeSkinType(this.aIi, TbadkCoreApplication.getInst().getSkinType());
        return this.aIm;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aIo = cVar;
        this.aIn = dVar;
        this.aIp = bVar;
        this.aIq = layoutParams;
        if (this.aIl != null) {
            this.aIl.setTextOption(dVar);
            this.aIl.setImgOption(cVar);
            this.aIl.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aIl.setLayoutParams(layoutParams);
            }
        }
    }

    public void bX(boolean z) {
        this.aIk = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean FK() {
        return this.WP != null && this.WP.size() == 0;
    }
}

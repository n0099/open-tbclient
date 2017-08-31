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
    protected S aHw;
    protected final TbPageContext<?> aIl;
    protected final ViewEventCenter aIm;
    private j aIo;
    private FrameLayout aIp;
    private NoDataViewFactory.d aIq;
    private NoDataViewFactory.c aIr;
    private NoDataViewFactory.b aIs;
    private FrameLayout.LayoutParams aIt;
    protected final List<H> aIj = new ArrayList();
    protected final SparseArray<H> aIk = new SparseArray<>();
    protected boolean aIn = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aIl = tbPageContext;
        this.aIm = viewEventCenter;
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
        if (d != null && this.WP != null && this.WP.contains(d) && (h = this.aIk.get(this.WP.indexOf(d))) != null) {
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
            this.aIk.clear();
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
        if (this.WP.size() == 0 && this.aIn) {
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
        int size = this.aIj.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aIj.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aIo != null) {
            this.aIo.onChangeSkinType(this.aIl, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aIk.indexOfValue(a) >= 0) {
            this.aIk.remove(a.getPosition());
        }
        this.aIk.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aIl.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aIl, inflate, this.aIm);
                h.b(this.aIl, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aIj.add(h);
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
            h.a(item, this.aHw);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FI() {
        if (this.aIp != null && this.aIo != null) {
            this.aIp.removeView(this.aIo);
            this.aIo = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View FJ() {
        if (this.aIp == null) {
            this.aIp = new FrameLayout(this.aIl.getPageActivity());
        }
        if (this.aIo == null) {
            this.aIo = NoDataViewFactory.a(this.aIl.getPageActivity(), this.aIp, this.aIr, this.aIq, this.aIs);
        }
        this.aIo.setVisibility(0);
        if (this.aIt != null) {
            this.aIo.setLayoutParams(this.aIt);
        }
        this.aIp.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aIo.onChangeSkinType(this.aIl, TbadkCoreApplication.getInst().getSkinType());
        return this.aIp;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aIr = cVar;
        this.aIq = dVar;
        this.aIs = bVar;
        this.aIt = layoutParams;
        if (this.aIo != null) {
            this.aIo.setTextOption(dVar);
            this.aIo.setImgOption(cVar);
            this.aIo.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aIo.setLayoutParams(layoutParams);
            }
        }
    }

    public void bX(boolean z) {
        this.aIn = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean FK() {
        return this.WP != null && this.WP.size() == 0;
    }
}

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
    protected S aVy;
    protected final TbPageContext<?> aWi;
    protected final ViewEventCenter aWj;
    private NoDataView aWl;
    private FrameLayout aWm;
    private NoDataViewFactory.d aWn;
    private NoDataViewFactory.c aWo;
    private NoDataViewFactory.b aWp;
    private FrameLayout.LayoutParams aWq;
    protected List<D> aiE;
    protected final List<H> aWg = new ArrayList();
    protected final SparseArray<H> aWh = new SparseArray<>();
    protected boolean aWk = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aWi = tbPageContext;
        this.aWj = viewEventCenter;
    }

    public void I(List<D> list) {
        if (list != null) {
            if (this.aiE == null) {
                this.aiE = new ArrayList();
            }
            this.aiE.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void F(D d) {
        if (d != null && this.aiE != null) {
            this.aiE.remove(d);
            notifyDataSetChanged();
        }
    }

    public void J(List<D> list) {
        K(list);
        notifyDataSetChanged();
    }

    public void G(D d) {
        H h;
        if (d != null && this.aiE != null && this.aiE.contains(d) && (h = this.aWh.get(this.aiE.indexOf(d))) != null) {
            h.H(d);
        }
    }

    protected void K(List<D> list) {
        if (list != null) {
            if (this.aiE == null) {
                this.aiE = new ArrayList();
            }
            this.aiE.clear();
            this.aiE.addAll(list);
            this.aWh.clear();
        }
    }

    public List<D> getDataList() {
        return this.aiE == null ? new ArrayList() : new ArrayList(this.aiE);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aiE == null) {
            return 0;
        }
        if (this.aiE.size() == 0 && this.aWk) {
            return 1;
        }
        return this.aiE.size();
    }

    public int Lw() {
        if (this.aiE == null) {
            return 0;
        }
        return this.aiE.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.aiE != null && this.aiE.size() != 0 && i >= 0 && i < this.aiE.size()) {
            return this.aiE.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aiE != null && this.aiE.size() != 0 && i >= 0 && i < this.aiE.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aWg.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aWg.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aWl != null) {
            this.aWl.onChangeSkinType(this.aWi, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aWh.indexOfValue(a) >= 0) {
            this.aWh.remove(a.getPosition());
        }
        this.aWh.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aWi.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aWi, inflate, this.aWj);
                h.b(this.aWi, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aWg.add(h);
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
            h.a(item, this.aVy);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Lx() {
        if (this.aWm != null && this.aWl != null) {
            this.aWm.removeView(this.aWl);
            this.aWl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Ly() {
        if (this.aWm == null) {
            this.aWm = new FrameLayout(this.aWi.getPageActivity());
        }
        if (this.aWl == null) {
            this.aWl = NoDataViewFactory.a(this.aWi.getPageActivity(), this.aWm, this.aWo, this.aWn, this.aWp);
        }
        this.aWl.setVisibility(0);
        if (this.aWq != null) {
            this.aWl.setLayoutParams(this.aWq);
        }
        this.aWm.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aWl.onChangeSkinType(this.aWi, TbadkCoreApplication.getInst().getSkinType());
        return this.aWm;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aWo = cVar;
        this.aWn = dVar;
        this.aWp = bVar;
        this.aWq = layoutParams;
        if (this.aWl != null) {
            this.aWl.setTextOption(dVar);
            this.aWl.setImgOption(cVar);
            this.aWl.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aWl.setLayoutParams(layoutParams);
            }
        }
    }

    public void ch(boolean z) {
        this.aWk = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Lz() {
        return this.aiE != null && this.aiE.size() == 0;
    }
}

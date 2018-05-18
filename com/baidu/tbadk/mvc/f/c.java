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
    protected List<D> Yt;
    protected S aIM;
    private FrameLayout aJA;
    private NoDataViewFactory.d aJB;
    private NoDataViewFactory.c aJC;
    private NoDataViewFactory.b aJD;
    private FrameLayout.LayoutParams aJE;
    protected final TbPageContext<?> aJw;
    protected final ViewEventCenter aJx;
    private NoDataView aJz;
    protected final List<H> aJu = new ArrayList();
    protected final SparseArray<H> aJv = new SparseArray<>();
    protected boolean aJy = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aJw = tbPageContext;
        this.aJx = viewEventCenter;
    }

    public void E(List<D> list) {
        if (list != null) {
            if (this.Yt == null) {
                this.Yt = new ArrayList();
            }
            this.Yt.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void B(D d) {
        if (d != null && this.Yt != null) {
            this.Yt.remove(d);
            notifyDataSetChanged();
        }
    }

    public void F(List<D> list) {
        G(list);
        notifyDataSetChanged();
    }

    public void C(D d) {
        H h;
        if (d != null && this.Yt != null && this.Yt.contains(d) && (h = this.aJv.get(this.Yt.indexOf(d))) != null) {
            h.D(d);
        }
    }

    protected void G(List<D> list) {
        if (list != null) {
            if (this.Yt == null) {
                this.Yt = new ArrayList();
            }
            this.Yt.clear();
            this.Yt.addAll(list);
            this.aJv.clear();
        }
    }

    public List<D> getDataList() {
        return this.Yt == null ? new ArrayList() : new ArrayList(this.Yt);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Yt == null) {
            return 0;
        }
        if (this.Yt.size() == 0 && this.aJy) {
            return 1;
        }
        return this.Yt.size();
    }

    public int Gh() {
        if (this.Yt == null) {
            return 0;
        }
        return this.Yt.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.Yt != null && this.Yt.size() != 0 && i >= 0 && i < this.Yt.size()) {
            return this.Yt.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Yt != null && this.Yt.size() != 0 && i >= 0 && i < this.Yt.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aJu.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aJu.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aJz != null) {
            this.aJz.onChangeSkinType(this.aJw, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view2, int i, Class<?> cls, int i2) {
        H a = a(view2, cls, i2);
        if (this.aJv.indexOfValue(a) >= 0) {
            this.aJv.remove(a.getPosition());
        }
        this.aJv.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view2, Class<?> cls, int i) {
        if (view2 == null || view2.getTag() == null) {
            View inflate = this.aJw.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aJw, inflate, this.aJx);
                h.b(this.aJw, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aJu.add(h);
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
        return (H) view2.getTag();
    }

    private final void a(H h, int i) {
        D item = getItem(i);
        if (item != null) {
            h.position = i;
            h.a(item, this.aIM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Gi() {
        if (this.aJA != null && this.aJz != null) {
            this.aJA.removeView(this.aJz);
            this.aJz = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Gj() {
        if (this.aJA == null) {
            this.aJA = new FrameLayout(this.aJw.getPageActivity());
        }
        if (this.aJz == null) {
            this.aJz = NoDataViewFactory.a(this.aJw.getPageActivity(), this.aJA, this.aJC, this.aJB, this.aJD);
        }
        this.aJz.setVisibility(0);
        if (this.aJE != null) {
            this.aJz.setLayoutParams(this.aJE);
        }
        this.aJA.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aJz.onChangeSkinType(this.aJw, TbadkCoreApplication.getInst().getSkinType());
        return this.aJA;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aJC = cVar;
        this.aJB = dVar;
        this.aJD = bVar;
        this.aJE = layoutParams;
        if (this.aJz != null) {
            this.aJz.setTextOption(dVar);
            this.aJz.setImgOption(cVar);
            this.aJz.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aJz.setLayoutParams(layoutParams);
            }
        }
    }

    public void bP(boolean z) {
        this.aJy = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Gk() {
        return this.Yt != null && this.Yt.size() == 0;
    }
}

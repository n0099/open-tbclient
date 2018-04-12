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
    protected S aIL;
    private NoDataViewFactory.d aJA;
    private NoDataViewFactory.c aJB;
    private NoDataViewFactory.b aJC;
    private FrameLayout.LayoutParams aJD;
    protected final TbPageContext<?> aJv;
    protected final ViewEventCenter aJw;
    private NoDataView aJy;
    private FrameLayout aJz;
    protected final List<H> aJt = new ArrayList();
    protected final SparseArray<H> aJu = new SparseArray<>();
    protected boolean aJx = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aJv = tbPageContext;
        this.aJw = viewEventCenter;
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
        if (d != null && this.Yt != null && this.Yt.contains(d) && (h = this.aJu.get(this.Yt.indexOf(d))) != null) {
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
            this.aJu.clear();
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
        if (this.Yt.size() == 0 && this.aJx) {
            return 1;
        }
        return this.Yt.size();
    }

    public int Gj() {
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
        int size = this.aJt.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aJt.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aJy != null) {
            this.aJy.onChangeSkinType(this.aJv, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view2, int i, Class<?> cls, int i2) {
        H a = a(view2, cls, i2);
        if (this.aJu.indexOfValue(a) >= 0) {
            this.aJu.remove(a.getPosition());
        }
        this.aJu.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view2, Class<?> cls, int i) {
        if (view2 == null || view2.getTag() == null) {
            View inflate = this.aJv.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aJv, inflate, this.aJw);
                h.b(this.aJv, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aJt.add(h);
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
            h.a(item, this.aIL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Gk() {
        if (this.aJz != null && this.aJy != null) {
            this.aJz.removeView(this.aJy);
            this.aJy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Gl() {
        if (this.aJz == null) {
            this.aJz = new FrameLayout(this.aJv.getPageActivity());
        }
        if (this.aJy == null) {
            this.aJy = NoDataViewFactory.a(this.aJv.getPageActivity(), this.aJz, this.aJB, this.aJA, this.aJC);
        }
        this.aJy.setVisibility(0);
        if (this.aJD != null) {
            this.aJy.setLayoutParams(this.aJD);
        }
        this.aJz.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aJy.onChangeSkinType(this.aJv, TbadkCoreApplication.getInst().getSkinType());
        return this.aJz;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aJB = cVar;
        this.aJA = dVar;
        this.aJC = bVar;
        this.aJD = layoutParams;
        if (this.aJy != null) {
            this.aJy.setTextOption(dVar);
            this.aJy.setImgOption(cVar);
            this.aJy.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aJy.setLayoutParams(layoutParams);
            }
        }
    }

    public void bP(boolean z) {
        this.aJx = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Gm() {
        return this.Yt != null && this.Yt.size() == 0;
    }
}

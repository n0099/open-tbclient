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
    protected List<D> aLG;
    protected final TbPageContext<?> bwT;
    protected final ViewEventCenter bwU;
    private h bwW;
    private FrameLayout bwX;
    private NoDataViewFactory.d bwY;
    private NoDataViewFactory.c bwZ;
    protected S bwf;
    private NoDataViewFactory.b bxa;
    private FrameLayout.LayoutParams bxb;
    protected final List<H> bwR = new ArrayList();
    protected final SparseArray<H> bwS = new SparseArray<>();
    protected boolean bwV = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.bwT = tbPageContext;
        this.bwU = viewEventCenter;
    }

    public void K(List<D> list) {
        if (list != null) {
            if (this.aLG == null) {
                this.aLG = new ArrayList();
            }
            this.aLG.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void aG(D d) {
        if (d != null && this.aLG != null) {
            this.aLG.remove(d);
            notifyDataSetChanged();
        }
    }

    public void L(List<D> list) {
        M(list);
        notifyDataSetChanged();
    }

    public void aH(D d) {
        H h;
        if (d != null && this.aLG != null && this.aLG.contains(d) && (h = this.bwS.get(this.aLG.indexOf(d))) != null) {
            h.aI(d);
        }
    }

    protected void M(List<D> list) {
        if (list != null) {
            if (this.aLG == null) {
                this.aLG = new ArrayList();
            }
            this.aLG.clear();
            this.aLG.addAll(list);
            this.bwS.clear();
        }
    }

    public List<D> getDataList() {
        return this.aLG == null ? new ArrayList() : new ArrayList(this.aLG);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aLG == null) {
            return 0;
        }
        if (this.aLG.size() == 0 && this.bwV) {
            return 1;
        }
        return this.aLG.size();
    }

    public int MZ() {
        if (this.aLG == null) {
            return 0;
        }
        return this.aLG.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.aLG != null && this.aLG.size() != 0 && i >= 0 && i < this.aLG.size()) {
            return this.aLG.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aLG != null && this.aLG.size() != 0 && i >= 0 && i < this.aLG.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.bwR.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.bwR.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.bwW != null) {
            this.bwW.onChangeSkinType(this.bwT, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.bwS.indexOfValue(a) >= 0) {
            this.bwS.remove(a.getPosition());
        }
        this.bwS.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.bwT.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.bwT, inflate, this.bwU);
                h.b(this.bwT, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.bwR.add(h);
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
            h.a(item, this.bwf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Na() {
        if (this.bwX != null && this.bwW != null) {
            this.bwX.removeView(this.bwW);
            this.bwW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Nb() {
        if (this.bwX == null) {
            this.bwX = new FrameLayout(this.bwT.getPageActivity());
        }
        if (this.bwW == null) {
            this.bwW = NoDataViewFactory.a(this.bwT.getPageActivity(), this.bwX, this.bwZ, this.bwY, this.bxa);
        }
        this.bwW.setVisibility(0);
        if (this.bxb != null) {
            this.bwW.setLayoutParams(this.bxb);
        }
        this.bwX.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.bwW.onChangeSkinType(this.bwT, TbadkCoreApplication.getInst().getSkinType());
        return this.bwX;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.bwZ = cVar;
        this.bwY = dVar;
        this.bxa = bVar;
        this.bxb = layoutParams;
        if (this.bwW != null) {
            this.bwW.setTextOption(dVar);
            this.bwW.setImgOption(cVar);
            this.bwW.setButtonOption(bVar);
            if (layoutParams != null) {
                this.bwW.setLayoutParams(layoutParams);
            }
        }
    }

    public void cs(boolean z) {
        this.bwV = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Nc() {
        return this.aLG != null && this.aLG.size() == 0;
    }
}

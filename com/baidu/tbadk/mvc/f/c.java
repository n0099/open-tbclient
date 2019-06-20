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
    protected List<D> bGw;
    protected S cwS;
    protected final TbPageContext<?> cxD;
    protected final ViewEventCenter cxE;
    private NoDataView cxG;
    private FrameLayout cxH;
    private NoDataViewFactory.d cxI;
    private NoDataViewFactory.c cxJ;
    private NoDataViewFactory.b cxK;
    private FrameLayout.LayoutParams cxL;
    protected final List<H> cxB = new ArrayList();
    protected final SparseArray<H> cxC = new SparseArray<>();
    protected boolean cxF = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.cxD = tbPageContext;
        this.cxE = viewEventCenter;
    }

    public void ak(List<D> list) {
        if (list != null) {
            if (this.bGw == null) {
                this.bGw = new ArrayList();
            }
            this.bGw.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void ad(D d) {
        if (d != null && this.bGw != null) {
            this.bGw.remove(d);
            notifyDataSetChanged();
        }
    }

    public void al(List<D> list) {
        am(list);
        notifyDataSetChanged();
    }

    public void ae(D d) {
        H h;
        if (d != null && this.bGw != null && this.bGw.contains(d) && (h = this.cxC.get(this.bGw.indexOf(d))) != null) {
            h.af(d);
        }
    }

    protected void am(List<D> list) {
        if (list != null) {
            if (this.bGw == null) {
                this.bGw = new ArrayList();
            }
            this.bGw.clear();
            this.bGw.addAll(list);
            this.cxC.clear();
        }
    }

    public List<D> getDataList() {
        return this.bGw == null ? new ArrayList() : new ArrayList(this.bGw);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bGw == null) {
            return 0;
        }
        if (this.bGw.size() == 0 && this.cxF) {
            return 1;
        }
        return this.bGw.size();
    }

    public int atG() {
        if (this.bGw == null) {
            return 0;
        }
        return this.bGw.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.bGw != null && this.bGw.size() != 0 && i >= 0 && i < this.bGw.size()) {
            return this.bGw.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bGw != null && this.bGw.size() != 0 && i >= 0 && i < this.bGw.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.cxB.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.cxB.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.cxG != null) {
            this.cxG.onChangeSkinType(this.cxD, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.cxC.indexOfValue(a) >= 0) {
            this.cxC.remove(a.getPosition());
        }
        this.cxC.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.cxD.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.cxD, inflate, this.cxE);
                h.b(this.cxD, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.cxB.add(h);
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
            h.a(item, this.cwS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void atH() {
        if (this.cxH != null && this.cxG != null) {
            this.cxH.removeView(this.cxG);
            this.cxG = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View atI() {
        if (this.cxH == null) {
            this.cxH = new FrameLayout(this.cxD.getPageActivity());
        }
        if (this.cxG == null) {
            this.cxG = NoDataViewFactory.a(this.cxD.getPageActivity(), this.cxH, this.cxJ, this.cxI, this.cxK);
        }
        this.cxG.setVisibility(0);
        if (this.cxL != null) {
            this.cxG.setLayoutParams(this.cxL);
        }
        this.cxH.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.cxG.onChangeSkinType(this.cxD, TbadkCoreApplication.getInst().getSkinType());
        return this.cxH;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.cxJ = cVar;
        this.cxI = dVar;
        this.cxK = bVar;
        this.cxL = layoutParams;
        if (this.cxG != null) {
            this.cxG.setTextOption(dVar);
            this.cxG.setImgOption(cVar);
            this.cxG.setButtonOption(bVar);
            if (layoutParams != null) {
                this.cxG.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean atJ() {
        return this.bGw != null && this.bGw.size() == 0;
    }
}

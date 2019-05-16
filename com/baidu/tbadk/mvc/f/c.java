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
    protected List<D> bGv;
    protected S cwR;
    protected final TbPageContext<?> cxC;
    protected final ViewEventCenter cxD;
    private NoDataView cxF;
    private FrameLayout cxG;
    private NoDataViewFactory.d cxH;
    private NoDataViewFactory.c cxI;
    private NoDataViewFactory.b cxJ;
    private FrameLayout.LayoutParams cxK;
    protected final List<H> cxA = new ArrayList();
    protected final SparseArray<H> cxB = new SparseArray<>();
    protected boolean cxE = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.cxC = tbPageContext;
        this.cxD = viewEventCenter;
    }

    public void ak(List<D> list) {
        if (list != null) {
            if (this.bGv == null) {
                this.bGv = new ArrayList();
            }
            this.bGv.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void ad(D d) {
        if (d != null && this.bGv != null) {
            this.bGv.remove(d);
            notifyDataSetChanged();
        }
    }

    public void al(List<D> list) {
        am(list);
        notifyDataSetChanged();
    }

    public void ae(D d) {
        H h;
        if (d != null && this.bGv != null && this.bGv.contains(d) && (h = this.cxB.get(this.bGv.indexOf(d))) != null) {
            h.af(d);
        }
    }

    protected void am(List<D> list) {
        if (list != null) {
            if (this.bGv == null) {
                this.bGv = new ArrayList();
            }
            this.bGv.clear();
            this.bGv.addAll(list);
            this.cxB.clear();
        }
    }

    public List<D> getDataList() {
        return this.bGv == null ? new ArrayList() : new ArrayList(this.bGv);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bGv == null) {
            return 0;
        }
        if (this.bGv.size() == 0 && this.cxE) {
            return 1;
        }
        return this.bGv.size();
    }

    public int atG() {
        if (this.bGv == null) {
            return 0;
        }
        return this.bGv.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.bGv != null && this.bGv.size() != 0 && i >= 0 && i < this.bGv.size()) {
            return this.bGv.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bGv != null && this.bGv.size() != 0 && i >= 0 && i < this.bGv.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.cxA.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.cxA.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.cxF != null) {
            this.cxF.onChangeSkinType(this.cxC, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.cxB.indexOfValue(a) >= 0) {
            this.cxB.remove(a.getPosition());
        }
        this.cxB.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.cxC.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.cxC, inflate, this.cxD);
                h.b(this.cxC, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.cxA.add(h);
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
            h.a(item, this.cwR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void atH() {
        if (this.cxG != null && this.cxF != null) {
            this.cxG.removeView(this.cxF);
            this.cxF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View atI() {
        if (this.cxG == null) {
            this.cxG = new FrameLayout(this.cxC.getPageActivity());
        }
        if (this.cxF == null) {
            this.cxF = NoDataViewFactory.a(this.cxC.getPageActivity(), this.cxG, this.cxI, this.cxH, this.cxJ);
        }
        this.cxF.setVisibility(0);
        if (this.cxK != null) {
            this.cxF.setLayoutParams(this.cxK);
        }
        this.cxG.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.cxF.onChangeSkinType(this.cxC, TbadkCoreApplication.getInst().getSkinType());
        return this.cxG;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.cxI = cVar;
        this.cxH = dVar;
        this.cxJ = bVar;
        this.cxK = layoutParams;
        if (this.cxF != null) {
            this.cxF.setTextOption(dVar);
            this.cxF.setImgOption(cVar);
            this.cxF.setButtonOption(bVar);
            if (layoutParams != null) {
                this.cxF.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean atJ() {
        return this.bGv != null && this.bGv.size() == 0;
    }
}

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
    protected final TbPageContext<?> aRX;
    protected final ViewEventCenter aRY;
    protected S aRn;
    private NoDataView aSa;
    private FrameLayout aSb;
    private NoDataViewFactory.d aSc;
    private NoDataViewFactory.c aSd;
    private NoDataViewFactory.b aSe;
    private FrameLayout.LayoutParams aSf;
    protected List<D> agv;
    protected final List<H> aRV = new ArrayList();
    protected final SparseArray<H> aRW = new SparseArray<>();
    protected boolean aRZ = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aRX = tbPageContext;
        this.aRY = viewEventCenter;
    }

    public void H(List<D> list) {
        if (list != null) {
            if (this.agv == null) {
                this.agv = new ArrayList();
            }
            this.agv.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void E(D d) {
        if (d != null && this.agv != null) {
            this.agv.remove(d);
            notifyDataSetChanged();
        }
    }

    public void I(List<D> list) {
        J(list);
        notifyDataSetChanged();
    }

    public void F(D d) {
        H h;
        if (d != null && this.agv != null && this.agv.contains(d) && (h = this.aRW.get(this.agv.indexOf(d))) != null) {
            h.G(d);
        }
    }

    protected void J(List<D> list) {
        if (list != null) {
            if (this.agv == null) {
                this.agv = new ArrayList();
            }
            this.agv.clear();
            this.agv.addAll(list);
            this.aRW.clear();
        }
    }

    public List<D> getDataList() {
        return this.agv == null ? new ArrayList() : new ArrayList(this.agv);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.agv == null) {
            return 0;
        }
        if (this.agv.size() == 0 && this.aRZ) {
            return 1;
        }
        return this.agv.size();
    }

    public int JP() {
        if (this.agv == null) {
            return 0;
        }
        return this.agv.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.agv != null && this.agv.size() != 0 && i >= 0 && i < this.agv.size()) {
            return this.agv.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.agv != null && this.agv.size() != 0 && i >= 0 && i < this.agv.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aRV.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aRV.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aSa != null) {
            this.aSa.onChangeSkinType(this.aRX, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aRW.indexOfValue(a) >= 0) {
            this.aRW.remove(a.getPosition());
        }
        this.aRW.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aRX.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aRX, inflate, this.aRY);
                h.b(this.aRX, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aRV.add(h);
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
            h.a(item, this.aRn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void JQ() {
        if (this.aSb != null && this.aSa != null) {
            this.aSb.removeView(this.aSa);
            this.aSa = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View JR() {
        if (this.aSb == null) {
            this.aSb = new FrameLayout(this.aRX.getPageActivity());
        }
        if (this.aSa == null) {
            this.aSa = NoDataViewFactory.a(this.aRX.getPageActivity(), this.aSb, this.aSd, this.aSc, this.aSe);
        }
        this.aSa.setVisibility(0);
        if (this.aSf != null) {
            this.aSa.setLayoutParams(this.aSf);
        }
        this.aSb.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aSa.onChangeSkinType(this.aRX, TbadkCoreApplication.getInst().getSkinType());
        return this.aSb;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aSd = cVar;
        this.aSc = dVar;
        this.aSe = bVar;
        this.aSf = layoutParams;
        if (this.aSa != null) {
            this.aSa.setTextOption(dVar);
            this.aSa.setImgOption(cVar);
            this.aSa.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aSa.setLayoutParams(layoutParams);
            }
        }
    }

    public void bT(boolean z) {
        this.aRZ = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean JS() {
        return this.agv != null && this.agv.size() == 0;
    }
}

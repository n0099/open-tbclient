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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
import com.baidu.tieba.tbadkCore.n;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements n {
    protected List<D> Xm;
    protected final TbPageContext<?> aIW;
    protected final ViewEventCenter aIX;
    private g aIZ;
    protected S aIi;
    private FrameLayout aJa;
    private NoDataViewFactory.d aJb;
    private NoDataViewFactory.c aJc;
    private NoDataViewFactory.b aJd;
    private FrameLayout.LayoutParams aJe;
    protected final List<H> aIU = new ArrayList();
    protected final SparseArray<H> aIV = new SparseArray<>();
    protected boolean aIY = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aIW = tbPageContext;
        this.aIX = viewEventCenter;
    }

    public void D(List<D> list) {
        if (list != null) {
            if (this.Xm == null) {
                this.Xm = new ArrayList();
            }
            this.Xm.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void B(D d) {
        if (d != null && this.Xm != null) {
            this.Xm.remove(d);
            notifyDataSetChanged();
        }
    }

    public void E(List<D> list) {
        F(list);
        notifyDataSetChanged();
    }

    public void C(D d) {
        H h;
        if (d != null && this.Xm != null && this.Xm.contains(d) && (h = this.aIV.get(this.Xm.indexOf(d))) != null) {
            h.D(d);
        }
    }

    protected void F(List<D> list) {
        if (list != null) {
            if (this.Xm == null) {
                this.Xm = new ArrayList();
            }
            this.Xm.clear();
            this.Xm.addAll(list);
            this.aIV.clear();
        }
    }

    public List<D> getDataList() {
        return this.Xm == null ? new ArrayList() : new ArrayList(this.Xm);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xm == null) {
            return 0;
        }
        if (this.Xm.size() == 0 && this.aIY) {
            return 1;
        }
        return this.Xm.size();
    }

    public int FM() {
        if (this.Xm == null) {
            return 0;
        }
        return this.Xm.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.Xm != null && this.Xm.size() != 0 && i >= 0 && i < this.Xm.size()) {
            return this.Xm.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xm != null && this.Xm.size() != 0 && i >= 0 && i < this.Xm.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aIU.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aIU.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aIZ != null) {
            this.aIZ.onChangeSkinType(this.aIW, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aIV.indexOfValue(a) >= 0) {
            this.aIV.remove(a.getPosition());
        }
        this.aIV.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aIW.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aIW, inflate, this.aIX);
                h.b(this.aIW, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aIU.add(h);
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
            h.a(item, this.aIi);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FN() {
        if (this.aJa != null && this.aIZ != null) {
            this.aJa.removeView(this.aIZ);
            this.aIZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View FO() {
        if (this.aJa == null) {
            this.aJa = new FrameLayout(this.aIW.getPageActivity());
        }
        if (this.aIZ == null) {
            this.aIZ = NoDataViewFactory.a(this.aIW.getPageActivity(), this.aJa, this.aJc, this.aJb, this.aJd);
        }
        this.aIZ.setVisibility(0);
        if (this.aJe != null) {
            this.aIZ.setLayoutParams(this.aJe);
        }
        this.aJa.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aIZ.onChangeSkinType(this.aIW, TbadkCoreApplication.getInst().getSkinType());
        return this.aJa;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aJc = cVar;
        this.aJb = dVar;
        this.aJd = bVar;
        this.aJe = layoutParams;
        if (this.aIZ != null) {
            this.aIZ.setTextOption(dVar);
            this.aIZ.setImgOption(cVar);
            this.aIZ.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aIZ.setLayoutParams(layoutParams);
            }
        }
    }

    public void bR(boolean z) {
        this.aIY = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean FP() {
        return this.Xm != null && this.Xm.size() == 0;
    }
}

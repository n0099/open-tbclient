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
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
import com.baidu.tieba.tbadkCore.q;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements q {
    protected List<D> aEY;
    protected S aEl;
    protected final TbPageContext<?> aFb;
    protected final ViewEventCenter aFc;
    private y aFe;
    private FrameLayout aFf;
    private NoDataViewFactory.d aFg;
    private NoDataViewFactory.c aFh;
    private NoDataViewFactory.b aFi;
    private FrameLayout.LayoutParams aFj;
    protected final List<H> aEZ = new ArrayList();
    protected final SparseArray<H> aFa = new SparseArray<>();
    protected boolean aFd = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aFb = tbPageContext;
        this.aFc = viewEventCenter;
    }

    public void v(List<D> list) {
        if (list != null) {
            if (this.aEY == null) {
                this.aEY = new ArrayList();
            }
            this.aEY.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void C(D d) {
        if (d != null && this.aEY != null) {
            this.aEY.remove(d);
            notifyDataSetChanged();
        }
    }

    public void w(List<D> list) {
        x(list);
        notifyDataSetChanged();
    }

    public void D(D d) {
        H h;
        if (d != null && this.aEY != null && this.aEY.contains(d) && (h = this.aFa.get(this.aEY.indexOf(d))) != null) {
            h.E(d);
        }
    }

    protected void x(List<D> list) {
        if (list != null) {
            if (this.aEY == null) {
                this.aEY = new ArrayList();
            }
            this.aEY.clear();
            this.aEY.addAll(list);
            this.aFa.clear();
        }
    }

    public List<D> getDataList() {
        return this.aEY == null ? new ArrayList() : new ArrayList(this.aEY);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aEY == null) {
            return 0;
        }
        if (this.aEY.size() == 0 && this.aFd) {
            return 1;
        }
        return this.aEY.size();
    }

    public int FQ() {
        if (this.aEY == null) {
            return 0;
        }
        return this.aEY.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.aEY != null && this.aEY.size() != 0 && i >= 0 && i < this.aEY.size()) {
            return this.aEY.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aEY != null && this.aEY.size() != 0 && i >= 0 && i < this.aEY.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aEZ.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aEZ.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aFe != null) {
            this.aFe.onChangeSkinType(this.aFb, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aFa.indexOfValue(a) >= 0) {
            this.aFa.remove(a.getPosition());
        }
        this.aFa.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aFb.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aFb, inflate, this.aFc);
                h.b(this.aFb, TbadkCoreApplication.m9getInst().getSkinType());
                inflate.setTag(h);
                this.aEZ.add(h);
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
            h.a(item, this.aEl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FR() {
        if (this.aFf != null && this.aFe != null) {
            this.aFf.removeView(this.aFe);
            this.aFe = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View FS() {
        if (this.aFf == null) {
            this.aFf = new FrameLayout(this.aFb.getPageActivity());
        }
        if (this.aFe == null) {
            this.aFe = NoDataViewFactory.a(this.aFb.getPageActivity(), this.aFf, this.aFh, this.aFg, this.aFi);
        }
        this.aFe.setVisibility(0);
        if (this.aFj != null) {
            this.aFe.setLayoutParams(this.aFj);
        }
        this.aFf.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aFe.onChangeSkinType(this.aFb, TbadkCoreApplication.m9getInst().getSkinType());
        return this.aFf;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aFh = cVar;
        this.aFg = dVar;
        this.aFi = bVar;
        this.aFj = layoutParams;
        if (this.aFe != null) {
            this.aFe.setTextOption(dVar);
            this.aFe.setImgOption(cVar);
            this.aFe.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aFe.setLayoutParams(layoutParams);
            }
        }
    }

    public void bU(boolean z) {
        this.aFd = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean FT() {
        return this.aEY != null && this.aEY.size() == 0;
    }
}

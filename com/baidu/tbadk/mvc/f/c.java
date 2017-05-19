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
    protected List<D> Wd;
    protected S aEs;
    protected final TbPageContext<?> aFh;
    protected final ViewEventCenter aFi;
    private y aFk;
    private FrameLayout aFl;
    private NoDataViewFactory.d aFm;
    private NoDataViewFactory.c aFn;
    private NoDataViewFactory.b aFo;
    private FrameLayout.LayoutParams aFp;
    protected final List<H> aFf = new ArrayList();
    protected final SparseArray<H> aFg = new SparseArray<>();
    protected boolean aFj = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aFh = tbPageContext;
        this.aFi = viewEventCenter;
    }

    public void w(List<D> list) {
        if (list != null) {
            if (this.Wd == null) {
                this.Wd = new ArrayList();
            }
            this.Wd.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void C(D d) {
        if (d != null && this.Wd != null) {
            this.Wd.remove(d);
            notifyDataSetChanged();
        }
    }

    public void x(List<D> list) {
        y(list);
        notifyDataSetChanged();
    }

    public void D(D d) {
        H h;
        if (d != null && this.Wd != null && this.Wd.contains(d) && (h = this.aFg.get(this.Wd.indexOf(d))) != null) {
            h.E(d);
        }
    }

    protected void y(List<D> list) {
        if (list != null) {
            if (this.Wd == null) {
                this.Wd = new ArrayList();
            }
            this.Wd.clear();
            this.Wd.addAll(list);
            this.aFg.clear();
        }
    }

    public List<D> getDataList() {
        return this.Wd == null ? new ArrayList() : new ArrayList(this.Wd);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Wd == null) {
            return 0;
        }
        if (this.Wd.size() == 0 && this.aFj) {
            return 1;
        }
        return this.Wd.size();
    }

    public int EU() {
        if (this.Wd == null) {
            return 0;
        }
        return this.Wd.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.Wd != null && this.Wd.size() != 0 && i >= 0 && i < this.Wd.size()) {
            return this.Wd.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Wd != null && this.Wd.size() != 0 && i >= 0 && i < this.Wd.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aFf.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aFf.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aFk != null) {
            this.aFk.onChangeSkinType(this.aFh, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aFg.indexOfValue(a) >= 0) {
            this.aFg.remove(a.getPosition());
        }
        this.aFg.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aFh.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aFh, inflate, this.aFi);
                h.b(this.aFh, TbadkCoreApplication.m9getInst().getSkinType());
                inflate.setTag(h);
                this.aFf.add(h);
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
            h.a(item, this.aEs);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EV() {
        if (this.aFl != null && this.aFk != null) {
            this.aFl.removeView(this.aFk);
            this.aFk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View EW() {
        if (this.aFl == null) {
            this.aFl = new FrameLayout(this.aFh.getPageActivity());
        }
        if (this.aFk == null) {
            this.aFk = NoDataViewFactory.a(this.aFh.getPageActivity(), this.aFl, this.aFn, this.aFm, this.aFo);
        }
        this.aFk.setVisibility(0);
        if (this.aFp != null) {
            this.aFk.setLayoutParams(this.aFp);
        }
        this.aFl.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aFk.onChangeSkinType(this.aFh, TbadkCoreApplication.m9getInst().getSkinType());
        return this.aFl;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aFn = cVar;
        this.aFm = dVar;
        this.aFo = bVar;
        this.aFp = layoutParams;
        if (this.aFk != null) {
            this.aFk.setTextOption(dVar);
            this.aFk.setImgOption(cVar);
            this.aFk.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aFk.setLayoutParams(layoutParams);
            }
        }
    }

    public void bV(boolean z) {
        this.aFj = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean EX() {
        return this.Wd != null && this.Wd.size() == 0;
    }
}

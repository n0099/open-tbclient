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
    protected S aEn;
    protected List<D> aFa;
    protected final TbPageContext<?> aFd;
    protected final ViewEventCenter aFe;
    private y aFg;
    private FrameLayout aFh;
    private NoDataViewFactory.d aFi;
    private NoDataViewFactory.c aFj;
    private NoDataViewFactory.b aFk;
    private FrameLayout.LayoutParams aFl;
    protected final List<H> aFb = new ArrayList();
    protected final SparseArray<H> aFc = new SparseArray<>();
    protected boolean aFf = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aFd = tbPageContext;
        this.aFe = viewEventCenter;
    }

    public void v(List<D> list) {
        if (list != null) {
            if (this.aFa == null) {
                this.aFa = new ArrayList();
            }
            this.aFa.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void C(D d) {
        if (d != null && this.aFa != null) {
            this.aFa.remove(d);
            notifyDataSetChanged();
        }
    }

    public void w(List<D> list) {
        x(list);
        notifyDataSetChanged();
    }

    public void D(D d) {
        H h;
        if (d != null && this.aFa != null && this.aFa.contains(d) && (h = this.aFc.get(this.aFa.indexOf(d))) != null) {
            h.E(d);
        }
    }

    protected void x(List<D> list) {
        if (list != null) {
            if (this.aFa == null) {
                this.aFa = new ArrayList();
            }
            this.aFa.clear();
            this.aFa.addAll(list);
            this.aFc.clear();
        }
    }

    public List<D> getDataList() {
        return this.aFa == null ? new ArrayList() : new ArrayList(this.aFa);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFa == null) {
            return 0;
        }
        if (this.aFa.size() == 0 && this.aFf) {
            return 1;
        }
        return this.aFa.size();
    }

    public int FQ() {
        if (this.aFa == null) {
            return 0;
        }
        return this.aFa.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.aFa != null && this.aFa.size() != 0 && i >= 0 && i < this.aFa.size()) {
            return this.aFa.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aFa != null && this.aFa.size() != 0 && i >= 0 && i < this.aFa.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aFb.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aFb.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aFg != null) {
            this.aFg.onChangeSkinType(this.aFd, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aFc.indexOfValue(a) >= 0) {
            this.aFc.remove(a.getPosition());
        }
        this.aFc.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aFd.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aFd, inflate, this.aFe);
                h.b(this.aFd, TbadkCoreApplication.m9getInst().getSkinType());
                inflate.setTag(h);
                this.aFb.add(h);
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
            h.a(item, this.aEn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FR() {
        if (this.aFh != null && this.aFg != null) {
            this.aFh.removeView(this.aFg);
            this.aFg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View FS() {
        if (this.aFh == null) {
            this.aFh = new FrameLayout(this.aFd.getPageActivity());
        }
        if (this.aFg == null) {
            this.aFg = NoDataViewFactory.a(this.aFd.getPageActivity(), this.aFh, this.aFj, this.aFi, this.aFk);
        }
        this.aFg.setVisibility(0);
        if (this.aFl != null) {
            this.aFg.setLayoutParams(this.aFl);
        }
        this.aFh.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aFg.onChangeSkinType(this.aFd, TbadkCoreApplication.m9getInst().getSkinType());
        return this.aFh;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aFj = cVar;
        this.aFi = dVar;
        this.aFk = bVar;
        this.aFl = layoutParams;
        if (this.aFg != null) {
            this.aFg.setTextOption(dVar);
            this.aFg.setImgOption(cVar);
            this.aFg.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aFg.setLayoutParams(layoutParams);
            }
        }
    }

    public void bU(boolean z) {
        this.aFf = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean FT() {
        return this.aFa != null && this.aFa.size() == 0;
    }
}

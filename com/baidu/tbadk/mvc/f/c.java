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
import com.baidu.tieba.tbadkCore.s;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements s {
    protected List<D> dataList;
    protected S fnL;
    protected final TbPageContext<?> fop;
    protected final ViewEventCenter foq;
    private NoDataView fos;
    private FrameLayout fot;
    private NoDataViewFactory.d fou;
    private NoDataViewFactory.c fov;
    private NoDataViewFactory.b fow;
    private FrameLayout.LayoutParams fox;
    protected final List<H> fon = new ArrayList();
    protected final SparseArray<H> foo = new SparseArray<>();

    /* renamed from: for  reason: not valid java name */
    protected boolean f2for = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.fop = tbPageContext;
        this.foq = viewEventCenter;
    }

    public void bu(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void as(D d) {
        if (d != null && this.dataList != null) {
            this.dataList.remove(d);
            notifyDataSetChanged();
        }
    }

    public void bv(List<D> list) {
        bw(list);
        notifyDataSetChanged();
    }

    public void at(D d) {
        H h;
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.foo.get(this.dataList.indexOf(d))) != null) {
            h.au(d);
        }
    }

    protected void bw(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.clear();
            this.dataList.addAll(list);
            this.foo.clear();
        }
    }

    public List<D> getDataList() {
        return this.dataList == null ? new ArrayList() : new ArrayList(this.dataList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dataList == null) {
            return 0;
        }
        if (this.dataList.size() == 0 && this.f2for) {
            return 1;
        }
        return this.dataList.size();
    }

    public int bzu() {
        if (this.dataList == null) {
            return 0;
        }
        return this.dataList.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.dataList != null && this.dataList.size() != 0 && i >= 0 && i < this.dataList.size()) {
            return this.dataList.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dataList != null && this.dataList.size() != 0 && i >= 0 && i < this.dataList.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.fon.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.fon.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.fos != null) {
            this.fos.onChangeSkinType(this.fop, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a2 = a(view, cls, i2);
        if (this.foo.indexOfValue(a2) >= 0) {
            this.foo.remove(a2.getPosition());
        }
        this.foo.put(i, a2);
        a(a2, i);
        return a2.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.fop.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.fop, inflate, this.foq);
                h.b(this.fop, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.fon.add(h);
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
            h.a(item, this.fnL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bzv() {
        if (this.fot != null && this.fos != null) {
            this.fot.removeView(this.fos);
            this.fos = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bzw() {
        if (this.fot == null) {
            this.fot = new FrameLayout(this.fop.getPageActivity());
        }
        if (this.fos == null) {
            this.fos = NoDataViewFactory.a(this.fop.getPageActivity(), this.fot, this.fov, this.fou, this.fow);
        }
        this.fos.setVisibility(0);
        if (this.fox != null) {
            this.fos.setLayoutParams(this.fox);
        }
        this.fot.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fos.onChangeSkinType(this.fop, TbadkCoreApplication.getInst().getSkinType());
        return this.fot;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.fov = cVar;
        this.fou = dVar;
        this.fow = bVar;
        this.fox = layoutParams;
        if (this.fos != null) {
            this.fos.setTextOption(dVar);
            this.fos.setImgOption(cVar);
            this.fos.setButtonOption(bVar);
            if (layoutParams != null) {
                this.fos.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bzx() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

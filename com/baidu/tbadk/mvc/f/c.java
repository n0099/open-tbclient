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
    protected S ftG;
    protected final TbPageContext<?> fuk;
    protected final ViewEventCenter ful;
    private NoDataView fun;
    private FrameLayout fuo;
    private NoDataViewFactory.d fup;
    private NoDataViewFactory.c fuq;
    private NoDataViewFactory.b fur;
    private FrameLayout.LayoutParams fus;
    protected final List<H> fui = new ArrayList();
    protected final SparseArray<H> fuj = new SparseArray<>();
    protected boolean fum = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.fuk = tbPageContext;
        this.ful = viewEventCenter;
    }

    public void bB(List<D> list) {
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

    public void bC(List<D> list) {
        bD(list);
        notifyDataSetChanged();
    }

    public void at(D d) {
        H h;
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.fuj.get(this.dataList.indexOf(d))) != null) {
            h.au(d);
        }
    }

    protected void bD(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.clear();
            this.dataList.addAll(list);
            this.fuj.clear();
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
        if (this.dataList.size() == 0 && this.fum) {
            return 1;
        }
        return this.dataList.size();
    }

    public int bBT() {
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
        int size = this.fui.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.fui.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.fun != null) {
            this.fun.onChangeSkinType(this.fuk, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a2 = a(view, cls, i2);
        if (this.fuj.indexOfValue(a2) >= 0) {
            this.fuj.remove(a2.getPosition());
        }
        this.fuj.put(i, a2);
        a(a2, i);
        return a2.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.fuk.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.fuk, inflate, this.ful);
                h.b(this.fuk, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.fui.add(h);
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
            h.a(item, this.ftG);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bBU() {
        if (this.fuo != null && this.fun != null) {
            this.fuo.removeView(this.fun);
            this.fun = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bBV() {
        if (this.fuo == null) {
            this.fuo = new FrameLayout(this.fuk.getPageActivity());
        }
        if (this.fun == null) {
            this.fun = NoDataViewFactory.a(this.fuk.getPageActivity(), this.fuo, this.fuq, this.fup, this.fur);
        }
        this.fun.setVisibility(0);
        if (this.fus != null) {
            this.fun.setLayoutParams(this.fus);
        }
        this.fuo.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fun.onChangeSkinType(this.fuk, TbadkCoreApplication.getInst().getSkinType());
        return this.fuo;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.fuq = cVar;
        this.fup = dVar;
        this.fur = bVar;
        this.fus = layoutParams;
        if (this.fun != null) {
            this.fun.setTextOption(dVar);
            this.fun.setImgOption(cVar);
            this.fun.setButtonOption(bVar);
            if (layoutParams != null) {
                this.fun.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bBW() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

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
import com.baidu.tieba.tbadkCore.r;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements r {
    protected List<D> dataList;
    protected final TbPageContext<?> eqZ;
    protected S eqv;
    protected final ViewEventCenter era;
    private NoDataView erc;
    private FrameLayout erd;
    private NoDataViewFactory.d ere;
    private NoDataViewFactory.c erf;
    private NoDataViewFactory.b erg;
    private FrameLayout.LayoutParams erh;
    protected final List<H> eqX = new ArrayList();
    protected final SparseArray<H> eqY = new SparseArray<>();
    protected boolean erb = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.eqZ = tbPageContext;
        this.era = viewEventCenter;
    }

    public void aO(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void al(D d) {
        if (d != null && this.dataList != null) {
            this.dataList.remove(d);
            notifyDataSetChanged();
        }
    }

    public void aP(List<D> list) {
        aQ(list);
        notifyDataSetChanged();
    }

    public void am(D d) {
        H h;
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.eqY.get(this.dataList.indexOf(d))) != null) {
            h.an(d);
        }
    }

    protected void aQ(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.clear();
            this.dataList.addAll(list);
            this.eqY.clear();
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
        if (this.dataList.size() == 0 && this.erb) {
            return 1;
        }
        return this.dataList.size();
    }

    public int bfk() {
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

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.eqX.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.eqX.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.erc != null) {
            this.erc.onChangeSkinType(this.eqZ, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.eqY.indexOfValue(a) >= 0) {
            this.eqY.remove(a.getPosition());
        }
        this.eqY.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.eqZ.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.eqZ, inflate, this.era);
                h.b(this.eqZ, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.eqX.add(h);
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
            h.a(item, this.eqv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bfl() {
        if (this.erd != null && this.erc != null) {
            this.erd.removeView(this.erc);
            this.erc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bfm() {
        if (this.erd == null) {
            this.erd = new FrameLayout(this.eqZ.getPageActivity());
        }
        if (this.erc == null) {
            this.erc = NoDataViewFactory.a(this.eqZ.getPageActivity(), this.erd, this.erf, this.ere, this.erg);
        }
        this.erc.setVisibility(0);
        if (this.erh != null) {
            this.erc.setLayoutParams(this.erh);
        }
        this.erd.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.erc.onChangeSkinType(this.eqZ, TbadkCoreApplication.getInst().getSkinType());
        return this.erd;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.erf = cVar;
        this.ere = dVar;
        this.erg = bVar;
        this.erh = layoutParams;
        if (this.erc != null) {
            this.erc.setTextOption(dVar);
            this.erc.setImgOption(cVar);
            this.erc.setButtonOption(bVar);
            if (layoutParams != null) {
                this.erc.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean HG() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

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
import com.baidu.tieba.tbadkCore.t;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements t {
    protected List<D> dataList;
    protected S fFB;
    protected final TbPageContext<?> fGe;
    protected final ViewEventCenter fGf;
    private NoDataView fGh;
    private FrameLayout fGi;
    private NoDataViewFactory.d fGj;
    private NoDataViewFactory.c fGk;
    private NoDataViewFactory.b fGl;
    private FrameLayout.LayoutParams fGm;
    protected final List<H> fGc = new ArrayList();
    protected final SparseArray<H> fGd = new SparseArray<>();
    protected boolean fGg = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.fGe = tbPageContext;
        this.fGf = viewEventCenter;
    }

    public void bM(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void au(D d) {
        if (d != null && this.dataList != null) {
            this.dataList.remove(d);
            notifyDataSetChanged();
        }
    }

    public void bN(List<D> list) {
        bO(list);
        notifyDataSetChanged();
    }

    public void av(D d) {
        H h;
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.fGd.get(this.dataList.indexOf(d))) != null) {
            h.aw(d);
        }
    }

    protected void bO(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.clear();
            this.dataList.addAll(list);
            this.fGd.clear();
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
        if (this.dataList.size() == 0 && this.fGg) {
            return 1;
        }
        return this.dataList.size();
    }

    public int bDn() {
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

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.fGc.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.fGc.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.fGh != null) {
            this.fGh.onChangeSkinType(this.fGe, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a2 = a(view, cls, i2);
        if (this.fGd.indexOfValue(a2) >= 0) {
            this.fGd.remove(a2.getPosition());
        }
        this.fGd.put(i, a2);
        a(a2, i);
        return a2.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.fGe.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.fGe, inflate, this.fGf);
                h.b(this.fGe, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.fGc.add(h);
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
            h.a(item, this.fFB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bDo() {
        if (this.fGi != null && this.fGh != null) {
            this.fGi.removeView(this.fGh);
            this.fGh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bDp() {
        if (this.fGi == null) {
            this.fGi = new FrameLayout(this.fGe.getPageActivity());
        }
        if (this.fGh == null) {
            this.fGh = NoDataViewFactory.a(this.fGe.getPageActivity(), this.fGi, this.fGk, this.fGj, this.fGl);
        }
        this.fGh.setVisibility(0);
        if (this.fGm != null) {
            this.fGh.setLayoutParams(this.fGm);
        }
        this.fGi.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fGh.onChangeSkinType(this.fGe, TbadkCoreApplication.getInst().getSkinType());
        return this.fGi;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.fGk = cVar;
        this.fGj = dVar;
        this.fGl = bVar;
        this.fGm = layoutParams;
        if (this.fGh != null) {
            this.fGh.setTextOption(dVar);
            this.fGh.setImgOption(cVar);
            this.fGh.setButtonOption(bVar);
            if (layoutParams != null) {
                this.fGh.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isDataEmpty() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

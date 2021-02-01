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
    protected S fHN;
    protected final TbPageContext<?> fIq;
    protected final ViewEventCenter fIr;
    private NoDataView fIt;
    private FrameLayout fIu;
    private NoDataViewFactory.d fIv;
    private NoDataViewFactory.c fIw;
    private NoDataViewFactory.b fIx;
    private FrameLayout.LayoutParams fIy;
    protected final List<H> fIo = new ArrayList();
    protected final SparseArray<H> fIp = new SparseArray<>();
    protected boolean fIs = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.fIq = tbPageContext;
        this.fIr = viewEventCenter;
    }

    public void bH(List<D> list) {
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

    public void bI(List<D> list) {
        bJ(list);
        notifyDataSetChanged();
    }

    public void av(D d) {
        H h;
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.fIp.get(this.dataList.indexOf(d))) != null) {
            h.aw(d);
        }
    }

    protected void bJ(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.clear();
            this.dataList.addAll(list);
            this.fIp.clear();
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
        if (this.dataList.size() == 0 && this.fIs) {
            return 1;
        }
        return this.dataList.size();
    }

    public int bDF() {
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
        int size = this.fIo.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.fIo.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.fIt != null) {
            this.fIt.onChangeSkinType(this.fIq, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a2 = a(view, cls, i2);
        if (this.fIp.indexOfValue(a2) >= 0) {
            this.fIp.remove(a2.getPosition());
        }
        this.fIp.put(i, a2);
        a(a2, i);
        return a2.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.fIq.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.fIq, inflate, this.fIr);
                h.b(this.fIq, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.fIo.add(h);
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
            h.a(item, this.fHN);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bDG() {
        if (this.fIu != null && this.fIt != null) {
            this.fIu.removeView(this.fIt);
            this.fIt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bDH() {
        if (this.fIu == null) {
            this.fIu = new FrameLayout(this.fIq.getPageActivity());
        }
        if (this.fIt == null) {
            this.fIt = NoDataViewFactory.a(this.fIq.getPageActivity(), this.fIu, this.fIw, this.fIv, this.fIx);
        }
        this.fIt.setVisibility(0);
        if (this.fIy != null) {
            this.fIt.setLayoutParams(this.fIy);
        }
        this.fIu.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fIt.onChangeSkinType(this.fIq, TbadkCoreApplication.getInst().getSkinType());
        return this.fIu;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.fIw = cVar;
        this.fIv = dVar;
        this.fIx = bVar;
        this.fIy = layoutParams;
        if (this.fIt != null) {
            this.fIt.setTextOption(dVar);
            this.fIt.setImgOption(cVar);
            this.fIt.setButtonOption(bVar);
            if (layoutParams != null) {
                this.fIt.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isDataEmpty() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

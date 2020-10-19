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
    protected final TbPageContext<?> ffQ;
    protected final ViewEventCenter ffR;
    private NoDataView ffT;
    private FrameLayout ffU;
    private NoDataViewFactory.d ffV;
    private NoDataViewFactory.c ffW;
    private NoDataViewFactory.b ffX;
    private FrameLayout.LayoutParams ffY;
    protected S ffm;
    protected final List<H> ffO = new ArrayList();
    protected final SparseArray<H> ffP = new SparseArray<>();
    protected boolean ffS = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.ffQ = tbPageContext;
        this.ffR = viewEventCenter;
    }

    public void bl(List<D> list) {
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

    public void bm(List<D> list) {
        bn(list);
        notifyDataSetChanged();
    }

    public void at(D d) {
        H h;
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.ffP.get(this.dataList.indexOf(d))) != null) {
            h.au(d);
        }
    }

    protected void bn(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.clear();
            this.dataList.addAll(list);
            this.ffP.clear();
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
        if (this.dataList.size() == 0 && this.ffS) {
            return 1;
        }
        return this.dataList.size();
    }

    public int bxB() {
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
        int size = this.ffO.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.ffO.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.ffT != null) {
            this.ffT.onChangeSkinType(this.ffQ, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a2 = a(view, cls, i2);
        if (this.ffP.indexOfValue(a2) >= 0) {
            this.ffP.remove(a2.getPosition());
        }
        this.ffP.put(i, a2);
        a(a2, i);
        return a2.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.ffQ.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.ffQ, inflate, this.ffR);
                h.b(this.ffQ, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.ffO.add(h);
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
            h.a(item, this.ffm);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxC() {
        if (this.ffU != null && this.ffT != null) {
            this.ffU.removeView(this.ffT);
            this.ffT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bxD() {
        if (this.ffU == null) {
            this.ffU = new FrameLayout(this.ffQ.getPageActivity());
        }
        if (this.ffT == null) {
            this.ffT = NoDataViewFactory.a(this.ffQ.getPageActivity(), this.ffU, this.ffW, this.ffV, this.ffX);
        }
        this.ffT.setVisibility(0);
        if (this.ffY != null) {
            this.ffT.setLayoutParams(this.ffY);
        }
        this.ffU.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.ffT.onChangeSkinType(this.ffQ, TbadkCoreApplication.getInst().getSkinType());
        return this.ffU;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.ffW = cVar;
        this.ffV = dVar;
        this.ffX = bVar;
        this.ffY = layoutParams;
        if (this.ffT != null) {
            this.ffT.setTextOption(dVar);
            this.ffT.setImgOption(cVar);
            this.ffT.setButtonOption(bVar);
            if (layoutParams != null) {
                this.ffT.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bxE() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

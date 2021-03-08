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
    protected final TbPageContext<?> fJP;
    protected final ViewEventCenter fJQ;
    private NoDataView fJS;
    private FrameLayout fJT;
    private NoDataViewFactory.d fJU;
    private NoDataViewFactory.c fJV;
    private NoDataViewFactory.b fJW;
    private FrameLayout.LayoutParams fJX;
    protected S fJm;
    protected final List<H> fJN = new ArrayList();
    protected final SparseArray<H> fJO = new SparseArray<>();
    protected boolean fJR = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.fJP = tbPageContext;
        this.fJQ = viewEventCenter;
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

    public void aw(D d) {
        if (d != null && this.dataList != null) {
            this.dataList.remove(d);
            notifyDataSetChanged();
        }
    }

    public void bI(List<D> list) {
        bJ(list);
        notifyDataSetChanged();
    }

    public void ax(D d) {
        H h;
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.fJO.get(this.dataList.indexOf(d))) != null) {
            h.ay(d);
        }
    }

    protected void bJ(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.clear();
            this.dataList.addAll(list);
            this.fJO.clear();
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
        if (this.dataList.size() == 0 && this.fJR) {
            return 1;
        }
        return this.dataList.size();
    }

    public int bDI() {
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
        int size = this.fJN.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.fJN.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.fJS != null) {
            this.fJS.onChangeSkinType(this.fJP, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a2 = a(view, cls, i2);
        if (this.fJO.indexOfValue(a2) >= 0) {
            this.fJO.remove(a2.getPosition());
        }
        this.fJO.put(i, a2);
        a(a2, i);
        return a2.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.fJP.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.fJP, inflate, this.fJQ);
                h.b(this.fJP, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.fJN.add(h);
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
            h.a(item, this.fJm);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bDJ() {
        if (this.fJT != null && this.fJS != null) {
            this.fJT.removeView(this.fJS);
            this.fJS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bDK() {
        if (this.fJT == null) {
            this.fJT = new FrameLayout(this.fJP.getPageActivity());
        }
        if (this.fJS == null) {
            this.fJS = NoDataViewFactory.a(this.fJP.getPageActivity(), this.fJT, this.fJV, this.fJU, this.fJW);
        }
        this.fJS.setVisibility(0);
        if (this.fJX != null) {
            this.fJS.setLayoutParams(this.fJX);
        }
        this.fJT.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fJS.onChangeSkinType(this.fJP, TbadkCoreApplication.getInst().getSkinType());
        return this.fJT;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.fJV = cVar;
        this.fJU = dVar;
        this.fJW = bVar;
        this.fJX = layoutParams;
        if (this.fJS != null) {
            this.fJS.setTextOption(dVar);
            this.fJS.setImgOption(cVar);
            this.fJS.setButtonOption(bVar);
            if (layoutParams != null) {
                this.fJS.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isDataEmpty() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

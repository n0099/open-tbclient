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
import com.baidu.tieba.tbadkCore.q;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements q {
    protected List<D> dataList;
    protected S dxP;
    protected final TbPageContext<?> dyA;
    protected final ViewEventCenter dyB;
    private NoDataView dyD;
    private FrameLayout dyE;
    private NoDataViewFactory.d dyF;
    private NoDataViewFactory.c dyG;
    private NoDataViewFactory.b dyH;
    private FrameLayout.LayoutParams dyI;
    protected final List<H> dyy = new ArrayList();
    protected final SparseArray<H> dyz = new SparseArray<>();
    protected boolean dyC = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.dyA = tbPageContext;
        this.dyB = viewEventCenter;
    }

    public void aJ(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void ae(D d) {
        if (d != null && this.dataList != null) {
            this.dataList.remove(d);
            notifyDataSetChanged();
        }
    }

    public void aK(List<D> list) {
        aL(list);
        notifyDataSetChanged();
    }

    public void af(D d) {
        H h;
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.dyz.get(this.dataList.indexOf(d))) != null) {
            h.ag(d);
        }
    }

    protected void aL(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.clear();
            this.dataList.addAll(list);
            this.dyz.clear();
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
        if (this.dataList.size() == 0 && this.dyC) {
            return 1;
        }
        return this.dataList.size();
    }

    public int aOv() {
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

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.dyy.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.dyy.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.dyD != null) {
            this.dyD.onChangeSkinType(this.dyA, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.dyz.indexOfValue(a) >= 0) {
            this.dyz.remove(a.getPosition());
        }
        this.dyz.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.dyA.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.dyA, inflate, this.dyB);
                h.b(this.dyA, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.dyy.add(h);
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
            h.a(item, this.dxP);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aOw() {
        if (this.dyE != null && this.dyD != null) {
            this.dyE.removeView(this.dyD);
            this.dyD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aOx() {
        if (this.dyE == null) {
            this.dyE = new FrameLayout(this.dyA.getPageActivity());
        }
        if (this.dyD == null) {
            this.dyD = NoDataViewFactory.a(this.dyA.getPageActivity(), this.dyE, this.dyG, this.dyF, this.dyH);
        }
        this.dyD.setVisibility(0);
        if (this.dyI != null) {
            this.dyD.setLayoutParams(this.dyI);
        }
        this.dyE.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.dyD.onChangeSkinType(this.dyA, TbadkCoreApplication.getInst().getSkinType());
        return this.dyE;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.dyG = cVar;
        this.dyF = dVar;
        this.dyH = bVar;
        this.dyI = layoutParams;
        if (this.dyD != null) {
            this.dyD.setTextOption(dVar);
            this.dyD.setImgOption(cVar);
            this.dyD.setButtonOption(bVar);
            if (layoutParams != null) {
                this.dyD.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ys() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

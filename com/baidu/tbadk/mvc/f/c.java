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
    protected final TbPageContext<?> dCO;
    protected final ViewEventCenter dCP;
    private NoDataView dCR;
    private FrameLayout dCS;
    private NoDataViewFactory.d dCT;
    private NoDataViewFactory.c dCU;
    private NoDataViewFactory.b dCV;
    private FrameLayout.LayoutParams dCW;
    protected S dCg;
    protected List<D> dataList;
    protected final List<H> dCM = new ArrayList();
    protected final SparseArray<H> dCN = new SparseArray<>();
    protected boolean dCQ = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.dCO = tbPageContext;
        this.dCP = viewEventCenter;
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

    public void ag(D d) {
        if (d != null && this.dataList != null) {
            this.dataList.remove(d);
            notifyDataSetChanged();
        }
    }

    public void aK(List<D> list) {
        aL(list);
        notifyDataSetChanged();
    }

    public void ah(D d) {
        H h;
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.dCN.get(this.dataList.indexOf(d))) != null) {
            h.ai(d);
        }
    }

    protected void aL(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.clear();
            this.dataList.addAll(list);
            this.dCN.clear();
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
        if (this.dataList.size() == 0 && this.dCQ) {
            return 1;
        }
        return this.dataList.size();
    }

    public int aQN() {
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
        int size = this.dCM.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.dCM.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.dCR != null) {
            this.dCR.onChangeSkinType(this.dCO, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.dCN.indexOfValue(a) >= 0) {
            this.dCN.remove(a.getPosition());
        }
        this.dCN.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.dCO.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.dCO, inflate, this.dCP);
                h.b(this.dCO, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.dCM.add(h);
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
            h.a(item, this.dCg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aQO() {
        if (this.dCS != null && this.dCR != null) {
            this.dCS.removeView(this.dCR);
            this.dCR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aQP() {
        if (this.dCS == null) {
            this.dCS = new FrameLayout(this.dCO.getPageActivity());
        }
        if (this.dCR == null) {
            this.dCR = NoDataViewFactory.a(this.dCO.getPageActivity(), this.dCS, this.dCU, this.dCT, this.dCV);
        }
        this.dCR.setVisibility(0);
        if (this.dCW != null) {
            this.dCR.setLayoutParams(this.dCW);
        }
        this.dCS.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.dCR.onChangeSkinType(this.dCO, TbadkCoreApplication.getInst().getSkinType());
        return this.dCS;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.dCU = cVar;
        this.dCT = dVar;
        this.dCV = bVar;
        this.dCW = layoutParams;
        if (this.dCR != null) {
            this.dCR.setTextOption(dVar);
            this.dCR.setImgOption(cVar);
            this.dCR.setButtonOption(bVar);
            if (layoutParams != null) {
                this.dCR.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean AL() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

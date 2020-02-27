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
    protected S dBS;
    protected final TbPageContext<?> dCA;
    protected final ViewEventCenter dCB;
    private NoDataView dCD;
    private FrameLayout dCE;
    private NoDataViewFactory.d dCF;
    private NoDataViewFactory.c dCG;
    private NoDataViewFactory.b dCH;
    private FrameLayout.LayoutParams dCI;
    protected List<D> dataList;
    protected final List<H> dCy = new ArrayList();
    protected final SparseArray<H> dCz = new SparseArray<>();
    protected boolean dCC = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.dCA = tbPageContext;
        this.dCB = viewEventCenter;
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
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.dCz.get(this.dataList.indexOf(d))) != null) {
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
            this.dCz.clear();
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
        if (this.dataList.size() == 0 && this.dCC) {
            return 1;
        }
        return this.dataList.size();
    }

    public int aQK() {
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
        int size = this.dCy.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.dCy.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.dCD != null) {
            this.dCD.onChangeSkinType(this.dCA, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.dCz.indexOfValue(a) >= 0) {
            this.dCz.remove(a.getPosition());
        }
        this.dCz.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.dCA.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.dCA, inflate, this.dCB);
                h.b(this.dCA, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.dCy.add(h);
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
            h.a(item, this.dBS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aQL() {
        if (this.dCE != null && this.dCD != null) {
            this.dCE.removeView(this.dCD);
            this.dCD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aQM() {
        if (this.dCE == null) {
            this.dCE = new FrameLayout(this.dCA.getPageActivity());
        }
        if (this.dCD == null) {
            this.dCD = NoDataViewFactory.a(this.dCA.getPageActivity(), this.dCE, this.dCG, this.dCF, this.dCH);
        }
        this.dCD.setVisibility(0);
        if (this.dCI != null) {
            this.dCD.setLayoutParams(this.dCI);
        }
        this.dCE.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.dCD.onChangeSkinType(this.dCA, TbadkCoreApplication.getInst().getSkinType());
        return this.dCE;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.dCG = cVar;
        this.dCF = dVar;
        this.dCH = bVar;
        this.dCI = layoutParams;
        if (this.dCD != null) {
            this.dCD.setTextOption(dVar);
            this.dCD.setImgOption(cVar);
            this.dCD.setButtonOption(bVar);
            if (layoutParams != null) {
                this.dCD.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean AJ() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

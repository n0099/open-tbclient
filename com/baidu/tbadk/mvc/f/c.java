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
    protected S dCt;
    protected final TbPageContext<?> dDb;
    protected final ViewEventCenter dDc;
    private NoDataView dDe;
    private FrameLayout dDf;
    private NoDataViewFactory.d dDg;
    private NoDataViewFactory.c dDh;
    private NoDataViewFactory.b dDi;
    private FrameLayout.LayoutParams dDj;
    protected List<D> dataList;
    protected final List<H> dCZ = new ArrayList();
    protected final SparseArray<H> dDa = new SparseArray<>();
    protected boolean dDd = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.dDb = tbPageContext;
        this.dDc = viewEventCenter;
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
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.dDa.get(this.dataList.indexOf(d))) != null) {
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
            this.dDa.clear();
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
        if (this.dataList.size() == 0 && this.dDd) {
            return 1;
        }
        return this.dataList.size();
    }

    public int aQR() {
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
        int size = this.dCZ.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.dCZ.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.dDe != null) {
            this.dDe.onChangeSkinType(this.dDb, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.dDa.indexOfValue(a) >= 0) {
            this.dDa.remove(a.getPosition());
        }
        this.dDa.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.dDb.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.dDb, inflate, this.dDc);
                h.b(this.dDb, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.dCZ.add(h);
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
            h.a(item, this.dCt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aQS() {
        if (this.dDf != null && this.dDe != null) {
            this.dDf.removeView(this.dDe);
            this.dDe = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aQT() {
        if (this.dDf == null) {
            this.dDf = new FrameLayout(this.dDb.getPageActivity());
        }
        if (this.dDe == null) {
            this.dDe = NoDataViewFactory.a(this.dDb.getPageActivity(), this.dDf, this.dDh, this.dDg, this.dDi);
        }
        this.dDe.setVisibility(0);
        if (this.dDj != null) {
            this.dDe.setLayoutParams(this.dDj);
        }
        this.dDf.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.dDe.onChangeSkinType(this.dDb, TbadkCoreApplication.getInst().getSkinType());
        return this.dDf;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.dDh = cVar;
        this.dDg = dVar;
        this.dDi = bVar;
        this.dDj = layoutParams;
        if (this.dDe != null) {
            this.dDe.setTextOption(dVar);
            this.dDe.setImgOption(cVar);
            this.dDe.setButtonOption(bVar);
            if (layoutParams != null) {
                this.dDe.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean AS() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

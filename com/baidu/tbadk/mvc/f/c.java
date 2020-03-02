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
    protected S dBT;
    protected final TbPageContext<?> dCB;
    protected final ViewEventCenter dCC;
    private NoDataView dCE;
    private FrameLayout dCF;
    private NoDataViewFactory.d dCG;
    private NoDataViewFactory.c dCH;
    private NoDataViewFactory.b dCI;
    private FrameLayout.LayoutParams dCJ;
    protected List<D> dataList;
    protected final List<H> dCz = new ArrayList();
    protected final SparseArray<H> dCA = new SparseArray<>();
    protected boolean dCD = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.dCB = tbPageContext;
        this.dCC = viewEventCenter;
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
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.dCA.get(this.dataList.indexOf(d))) != null) {
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
            this.dCA.clear();
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
        if (this.dataList.size() == 0 && this.dCD) {
            return 1;
        }
        return this.dataList.size();
    }

    public int aQM() {
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
        int size = this.dCz.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.dCz.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.dCE != null) {
            this.dCE.onChangeSkinType(this.dCB, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.dCA.indexOfValue(a) >= 0) {
            this.dCA.remove(a.getPosition());
        }
        this.dCA.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.dCB.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.dCB, inflate, this.dCC);
                h.b(this.dCB, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.dCz.add(h);
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
            h.a(item, this.dBT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aQN() {
        if (this.dCF != null && this.dCE != null) {
            this.dCF.removeView(this.dCE);
            this.dCE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aQO() {
        if (this.dCF == null) {
            this.dCF = new FrameLayout(this.dCB.getPageActivity());
        }
        if (this.dCE == null) {
            this.dCE = NoDataViewFactory.a(this.dCB.getPageActivity(), this.dCF, this.dCH, this.dCG, this.dCI);
        }
        this.dCE.setVisibility(0);
        if (this.dCJ != null) {
            this.dCE.setLayoutParams(this.dCJ);
        }
        this.dCF.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.dCE.onChangeSkinType(this.dCB, TbadkCoreApplication.getInst().getSkinType());
        return this.dCF;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.dCH = cVar;
        this.dCG = dVar;
        this.dCI = bVar;
        this.dCJ = layoutParams;
        if (this.dCE != null) {
            this.dCE.setTextOption(dVar);
            this.dCE.setImgOption(cVar);
            this.dCE.setButtonOption(bVar);
            if (layoutParams != null) {
                this.dCE.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean AL() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

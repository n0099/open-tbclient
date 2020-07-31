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
    protected S eFD;
    protected final TbPageContext<?> eGh;
    protected final ViewEventCenter eGi;
    private NoDataView eGk;
    private FrameLayout eGl;
    private NoDataViewFactory.d eGm;
    private NoDataViewFactory.c eGn;
    private NoDataViewFactory.b eGo;
    private FrameLayout.LayoutParams eGp;
    protected final List<H> eGf = new ArrayList();
    protected final SparseArray<H> eGg = new SparseArray<>();
    protected boolean eGj = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.eGh = tbPageContext;
        this.eGi = viewEventCenter;
    }

    public void be(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void am(D d) {
        if (d != null && this.dataList != null) {
            this.dataList.remove(d);
            notifyDataSetChanged();
        }
    }

    public void bf(List<D> list) {
        bg(list);
        notifyDataSetChanged();
    }

    public void an(D d) {
        H h;
        if (d != null && this.dataList != null && this.dataList.contains(d) && (h = this.eGg.get(this.dataList.indexOf(d))) != null) {
            h.ao(d);
        }
    }

    protected void bg(List<D> list) {
        if (list != null) {
            if (this.dataList == null) {
                this.dataList = new ArrayList();
            }
            this.dataList.clear();
            this.dataList.addAll(list);
            this.eGg.clear();
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
        if (this.dataList.size() == 0 && this.eGj) {
            return 1;
        }
        return this.dataList.size();
    }

    public int bla() {
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
        int size = this.eGf.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.eGf.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.eGk != null) {
            this.eGk.onChangeSkinType(this.eGh, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.eGg.indexOfValue(a) >= 0) {
            this.eGg.remove(a.getPosition());
        }
        this.eGg.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.eGh.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.eGh, inflate, this.eGi);
                h.b(this.eGh, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.eGf.add(h);
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
            h.a(item, this.eFD);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void blb() {
        if (this.eGl != null && this.eGk != null) {
            this.eGl.removeView(this.eGk);
            this.eGk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View blc() {
        if (this.eGl == null) {
            this.eGl = new FrameLayout(this.eGh.getPageActivity());
        }
        if (this.eGk == null) {
            this.eGk = NoDataViewFactory.a(this.eGh.getPageActivity(), this.eGl, this.eGn, this.eGm, this.eGo);
        }
        this.eGk.setVisibility(0);
        if (this.eGp != null) {
            this.eGk.setLayoutParams(this.eGp);
        }
        this.eGl.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.eGk.onChangeSkinType(this.eGh, TbadkCoreApplication.getInst().getSkinType());
        return this.eGl;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.eGn = cVar;
        this.eGm = dVar;
        this.eGo = bVar;
        this.eGp = layoutParams;
        if (this.eGk != null) {
            this.eGk.setTextOption(dVar);
            this.eGk.setImgOption(cVar);
            this.eGk.setButtonOption(bVar);
            if (layoutParams != null) {
                this.eGk.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean IZ() {
        return this.dataList != null && this.dataList.size() == 0;
    }
}

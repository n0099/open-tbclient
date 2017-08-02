package com.baidu.tbadk.mvc.f;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
import com.baidu.tieba.tbadkCore.l;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements l {
    protected List<D> Wh;
    protected S aGB;
    protected final TbPageContext<?> aHq;
    protected final ViewEventCenter aHr;
    private j aHt;
    private FrameLayout aHu;
    private NoDataViewFactory.d aHv;
    private NoDataViewFactory.c aHw;
    private NoDataViewFactory.b aHx;
    private FrameLayout.LayoutParams aHy;
    protected final List<H> aHo = new ArrayList();
    protected final SparseArray<H> aHp = new SparseArray<>();
    protected boolean aHs = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aHq = tbPageContext;
        this.aHr = viewEventCenter;
    }

    public void C(List<D> list) {
        if (list != null) {
            if (this.Wh == null) {
                this.Wh = new ArrayList();
            }
            this.Wh.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void C(D d) {
        if (d != null && this.Wh != null) {
            this.Wh.remove(d);
            notifyDataSetChanged();
        }
    }

    public void D(List<D> list) {
        E(list);
        notifyDataSetChanged();
    }

    public void D(D d) {
        H h;
        if (d != null && this.Wh != null && this.Wh.contains(d) && (h = this.aHp.get(this.Wh.indexOf(d))) != null) {
            h.E(d);
        }
    }

    protected void E(List<D> list) {
        if (list != null) {
            if (this.Wh == null) {
                this.Wh = new ArrayList();
            }
            this.Wh.clear();
            this.Wh.addAll(list);
            this.aHp.clear();
        }
    }

    public List<D> getDataList() {
        return this.Wh == null ? new ArrayList() : new ArrayList(this.Wh);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Wh == null) {
            return 0;
        }
        if (this.Wh.size() == 0 && this.aHs) {
            return 1;
        }
        return this.Wh.size();
    }

    public int FB() {
        if (this.Wh == null) {
            return 0;
        }
        return this.Wh.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.Wh != null && this.Wh.size() != 0 && i >= 0 && i < this.Wh.size()) {
            return this.Wh.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Wh != null && this.Wh.size() != 0 && i >= 0 && i < this.Wh.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aHo.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aHo.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aHt != null) {
            this.aHt.onChangeSkinType(this.aHq, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aHp.indexOfValue(a) >= 0) {
            this.aHp.remove(a.getPosition());
        }
        this.aHp.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aHq.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aHq, inflate, this.aHr);
                h.b(this.aHq, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aHo.add(h);
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
            h.a(item, this.aGB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FC() {
        if (this.aHu != null && this.aHt != null) {
            this.aHu.removeView(this.aHt);
            this.aHt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View FD() {
        if (this.aHu == null) {
            this.aHu = new FrameLayout(this.aHq.getPageActivity());
        }
        if (this.aHt == null) {
            this.aHt = NoDataViewFactory.a(this.aHq.getPageActivity(), this.aHu, this.aHw, this.aHv, this.aHx);
        }
        this.aHt.setVisibility(0);
        if (this.aHy != null) {
            this.aHt.setLayoutParams(this.aHy);
        }
        this.aHu.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aHt.onChangeSkinType(this.aHq, TbadkCoreApplication.getInst().getSkinType());
        return this.aHu;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aHw = cVar;
        this.aHv = dVar;
        this.aHx = bVar;
        this.aHy = layoutParams;
        if (this.aHt != null) {
            this.aHt.setTextOption(dVar);
            this.aHt.setImgOption(cVar);
            this.aHt.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aHt.setLayoutParams(layoutParams);
            }
        }
    }

    public void bX(boolean z) {
        this.aHs = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean FE() {
        return this.Wh != null && this.Wh.size() == 0;
    }
}

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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
import com.baidu.tieba.tbadkCore.m;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements m {
    protected List<D> WW;
    protected S aHr;
    protected final TbPageContext<?> aIg;
    protected final ViewEventCenter aIh;
    private f aIj;
    private FrameLayout aIk;
    private NoDataViewFactory.d aIl;
    private NoDataViewFactory.c aIm;
    private NoDataViewFactory.b aIn;
    private FrameLayout.LayoutParams aIo;
    protected final List<H> aIe = new ArrayList();
    protected final SparseArray<H> aIf = new SparseArray<>();
    protected boolean aIi = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aIg = tbPageContext;
        this.aIh = viewEventCenter;
    }

    public void C(List<D> list) {
        if (list != null) {
            if (this.WW == null) {
                this.WW = new ArrayList();
            }
            this.WW.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void B(D d) {
        if (d != null && this.WW != null) {
            this.WW.remove(d);
            notifyDataSetChanged();
        }
    }

    public void D(List<D> list) {
        E(list);
        notifyDataSetChanged();
    }

    public void C(D d) {
        H h;
        if (d != null && this.WW != null && this.WW.contains(d) && (h = this.aIf.get(this.WW.indexOf(d))) != null) {
            h.D(d);
        }
    }

    protected void E(List<D> list) {
        if (list != null) {
            if (this.WW == null) {
                this.WW = new ArrayList();
            }
            this.WW.clear();
            this.WW.addAll(list);
            this.aIf.clear();
        }
    }

    public List<D> getDataList() {
        return this.WW == null ? new ArrayList() : new ArrayList(this.WW);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.WW == null) {
            return 0;
        }
        if (this.WW.size() == 0 && this.aIi) {
            return 1;
        }
        return this.WW.size();
    }

    public int Fs() {
        if (this.WW == null) {
            return 0;
        }
        return this.WW.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.WW != null && this.WW.size() != 0 && i >= 0 && i < this.WW.size()) {
            return this.WW.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.WW != null && this.WW.size() != 0 && i >= 0 && i < this.WW.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.m
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aIe.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aIe.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aIj != null) {
            this.aIj.onChangeSkinType(this.aIg, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aIf.indexOfValue(a) >= 0) {
            this.aIf.remove(a.getPosition());
        }
        this.aIf.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aIg.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aIg, inflate, this.aIh);
                h.b(this.aIg, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aIe.add(h);
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
            h.a(item, this.aHr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ft() {
        if (this.aIk != null && this.aIj != null) {
            this.aIk.removeView(this.aIj);
            this.aIj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Fu() {
        if (this.aIk == null) {
            this.aIk = new FrameLayout(this.aIg.getPageActivity());
        }
        if (this.aIj == null) {
            this.aIj = NoDataViewFactory.a(this.aIg.getPageActivity(), this.aIk, this.aIm, this.aIl, this.aIn);
        }
        this.aIj.setVisibility(0);
        if (this.aIo != null) {
            this.aIj.setLayoutParams(this.aIo);
        }
        this.aIk.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aIj.onChangeSkinType(this.aIg, TbadkCoreApplication.getInst().getSkinType());
        return this.aIk;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aIm = cVar;
        this.aIl = dVar;
        this.aIn = bVar;
        this.aIo = layoutParams;
        if (this.aIj != null) {
            this.aIj.setTextOption(dVar);
            this.aIj.setImgOption(cVar);
            this.aIj.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aIj.setLayoutParams(layoutParams);
            }
        }
    }

    public void bQ(boolean z) {
        this.aIi = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Fv() {
        return this.WW != null && this.WW.size() == 0;
    }
}

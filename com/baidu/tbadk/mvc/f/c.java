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
    protected S aHz;
    protected final TbPageContext<?> aIo;
    protected final ViewEventCenter aIp;
    private f aIr;
    private FrameLayout aIs;
    private NoDataViewFactory.d aIt;
    private NoDataViewFactory.c aIu;
    private NoDataViewFactory.b aIv;
    private FrameLayout.LayoutParams aIw;
    protected final List<H> aIm = new ArrayList();
    protected final SparseArray<H> aIn = new SparseArray<>();
    protected boolean aIq = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aIo = tbPageContext;
        this.aIp = viewEventCenter;
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
        if (d != null && this.WW != null && this.WW.contains(d) && (h = this.aIn.get(this.WW.indexOf(d))) != null) {
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
            this.aIn.clear();
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
        if (this.WW.size() == 0 && this.aIq) {
            return 1;
        }
        return this.WW.size();
    }

    public int FE() {
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
        int size = this.aIm.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aIm.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aIr != null) {
            this.aIr.onChangeSkinType(this.aIo, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aIn.indexOfValue(a) >= 0) {
            this.aIn.remove(a.getPosition());
        }
        this.aIn.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aIo.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aIo, inflate, this.aIp);
                h.b(this.aIo, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aIm.add(h);
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
            h.a(item, this.aHz);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FF() {
        if (this.aIs != null && this.aIr != null) {
            this.aIs.removeView(this.aIr);
            this.aIr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View FG() {
        if (this.aIs == null) {
            this.aIs = new FrameLayout(this.aIo.getPageActivity());
        }
        if (this.aIr == null) {
            this.aIr = NoDataViewFactory.a(this.aIo.getPageActivity(), this.aIs, this.aIu, this.aIt, this.aIv);
        }
        this.aIr.setVisibility(0);
        if (this.aIw != null) {
            this.aIr.setLayoutParams(this.aIw);
        }
        this.aIs.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aIr.onChangeSkinType(this.aIo, TbadkCoreApplication.getInst().getSkinType());
        return this.aIs;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aIu = cVar;
        this.aIt = dVar;
        this.aIv = bVar;
        this.aIw = layoutParams;
        if (this.aIr != null) {
            this.aIr.setTextOption(dVar);
            this.aIr.setImgOption(cVar);
            this.aIr.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aIr.setLayoutParams(layoutParams);
            }
        }
    }

    public void bR(boolean z) {
        this.aIq = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean FH() {
        return this.WW != null && this.WW.size() == 0;
    }
}

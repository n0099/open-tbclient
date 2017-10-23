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
import com.baidu.tieba.tbadkCore.l;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements l {
    protected List<D> WE;
    protected S aGH;
    private FrameLayout aHA;
    private NoDataViewFactory.d aHB;
    private NoDataViewFactory.c aHC;
    private NoDataViewFactory.b aHD;
    private FrameLayout.LayoutParams aHE;
    protected final TbPageContext<?> aHw;
    protected final ViewEventCenter aHx;
    private f aHz;
    protected final List<H> aHu = new ArrayList();
    protected final SparseArray<H> aHv = new SparseArray<>();
    protected boolean aHy = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aHw = tbPageContext;
        this.aHx = viewEventCenter;
    }

    public void B(List<D> list) {
        if (list != null) {
            if (this.WE == null) {
                this.WE = new ArrayList();
            }
            this.WE.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void B(D d) {
        if (d != null && this.WE != null) {
            this.WE.remove(d);
            notifyDataSetChanged();
        }
    }

    public void C(List<D> list) {
        D(list);
        notifyDataSetChanged();
    }

    public void C(D d) {
        H h;
        if (d != null && this.WE != null && this.WE.contains(d) && (h = this.aHv.get(this.WE.indexOf(d))) != null) {
            h.D(d);
        }
    }

    protected void D(List<D> list) {
        if (list != null) {
            if (this.WE == null) {
                this.WE = new ArrayList();
            }
            this.WE.clear();
            this.WE.addAll(list);
            this.aHv.clear();
        }
    }

    public List<D> getDataList() {
        return this.WE == null ? new ArrayList() : new ArrayList(this.WE);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.WE == null) {
            return 0;
        }
        if (this.WE.size() == 0 && this.aHy) {
            return 1;
        }
        return this.WE.size();
    }

    public int Fg() {
        if (this.WE == null) {
            return 0;
        }
        return this.WE.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.WE != null && this.WE.size() != 0 && i >= 0 && i < this.WE.size()) {
            return this.WE.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.WE != null && this.WE.size() != 0 && i >= 0 && i < this.WE.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aHu.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aHu.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aHz != null) {
            this.aHz.onChangeSkinType(this.aHw, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aHv.indexOfValue(a) >= 0) {
            this.aHv.remove(a.getPosition());
        }
        this.aHv.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aHw.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aHw, inflate, this.aHx);
                h.b(this.aHw, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aHu.add(h);
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
            h.a(item, this.aGH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fh() {
        if (this.aHA != null && this.aHz != null) {
            this.aHA.removeView(this.aHz);
            this.aHz = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Fi() {
        if (this.aHA == null) {
            this.aHA = new FrameLayout(this.aHw.getPageActivity());
        }
        if (this.aHz == null) {
            this.aHz = NoDataViewFactory.a(this.aHw.getPageActivity(), this.aHA, this.aHC, this.aHB, this.aHD);
        }
        this.aHz.setVisibility(0);
        if (this.aHE != null) {
            this.aHz.setLayoutParams(this.aHE);
        }
        this.aHA.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aHz.onChangeSkinType(this.aHw, TbadkCoreApplication.getInst().getSkinType());
        return this.aHA;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aHC = cVar;
        this.aHB = dVar;
        this.aHD = bVar;
        this.aHE = layoutParams;
        if (this.aHz != null) {
            this.aHz.setTextOption(dVar);
            this.aHz.setImgOption(cVar);
            this.aHz.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aHz.setLayoutParams(layoutParams);
            }
        }
    }

    public void bV(boolean z) {
        this.aHy = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Fj() {
        return this.WE != null && this.WE.size() == 0;
    }
}

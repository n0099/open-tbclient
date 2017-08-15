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
    protected List<D> XF;
    protected S aHR;
    protected final TbPageContext<?> aIG;
    protected final ViewEventCenter aIH;
    private j aIJ;
    private FrameLayout aIK;
    private NoDataViewFactory.d aIL;
    private NoDataViewFactory.c aIM;
    private NoDataViewFactory.b aIN;
    private FrameLayout.LayoutParams aIO;
    protected final List<H> aIE = new ArrayList();
    protected final SparseArray<H> aIF = new SparseArray<>();
    protected boolean aII = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aIG = tbPageContext;
        this.aIH = viewEventCenter;
    }

    public void C(List<D> list) {
        if (list != null) {
            if (this.XF == null) {
                this.XF = new ArrayList();
            }
            this.XF.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void C(D d) {
        if (d != null && this.XF != null) {
            this.XF.remove(d);
            notifyDataSetChanged();
        }
    }

    public void D(List<D> list) {
        E(list);
        notifyDataSetChanged();
    }

    public void D(D d) {
        H h;
        if (d != null && this.XF != null && this.XF.contains(d) && (h = this.aIF.get(this.XF.indexOf(d))) != null) {
            h.E(d);
        }
    }

    protected void E(List<D> list) {
        if (list != null) {
            if (this.XF == null) {
                this.XF = new ArrayList();
            }
            this.XF.clear();
            this.XF.addAll(list);
            this.aIF.clear();
        }
    }

    public List<D> getDataList() {
        return this.XF == null ? new ArrayList() : new ArrayList(this.XF);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.XF == null) {
            return 0;
        }
        if (this.XF.size() == 0 && this.aII) {
            return 1;
        }
        return this.XF.size();
    }

    public int FJ() {
        if (this.XF == null) {
            return 0;
        }
        return this.XF.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.XF != null && this.XF.size() != 0 && i >= 0 && i < this.XF.size()) {
            return this.XF.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.XF != null && this.XF.size() != 0 && i >= 0 && i < this.XF.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aIE.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aIE.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aIJ != null) {
            this.aIJ.onChangeSkinType(this.aIG, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aIF.indexOfValue(a) >= 0) {
            this.aIF.remove(a.getPosition());
        }
        this.aIF.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aIG.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aIG, inflate, this.aIH);
                h.b(this.aIG, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aIE.add(h);
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
            h.a(item, this.aHR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FK() {
        if (this.aIK != null && this.aIJ != null) {
            this.aIK.removeView(this.aIJ);
            this.aIJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View FL() {
        if (this.aIK == null) {
            this.aIK = new FrameLayout(this.aIG.getPageActivity());
        }
        if (this.aIJ == null) {
            this.aIJ = NoDataViewFactory.a(this.aIG.getPageActivity(), this.aIK, this.aIM, this.aIL, this.aIN);
        }
        this.aIJ.setVisibility(0);
        if (this.aIO != null) {
            this.aIJ.setLayoutParams(this.aIO);
        }
        this.aIK.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aIJ.onChangeSkinType(this.aIG, TbadkCoreApplication.getInst().getSkinType());
        return this.aIK;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aIM = cVar;
        this.aIL = dVar;
        this.aIN = bVar;
        this.aIO = layoutParams;
        if (this.aIJ != null) {
            this.aIJ.setTextOption(dVar);
            this.aIJ.setImgOption(cVar);
            this.aIJ.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aIJ.setLayoutParams(layoutParams);
            }
        }
    }

    public void bX(boolean z) {
        this.aII = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean FM() {
        return this.XF != null && this.XF.size() == 0;
    }
}

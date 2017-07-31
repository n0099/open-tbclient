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
    protected List<D> XD;
    protected S aHQ;
    protected final TbPageContext<?> aIF;
    protected final ViewEventCenter aIG;
    private j aII;
    private FrameLayout aIJ;
    private NoDataViewFactory.d aIK;
    private NoDataViewFactory.c aIL;
    private NoDataViewFactory.b aIM;
    private FrameLayout.LayoutParams aIN;
    protected final List<H> aID = new ArrayList();
    protected final SparseArray<H> aIE = new SparseArray<>();
    protected boolean aIH = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aIF = tbPageContext;
        this.aIG = viewEventCenter;
    }

    public void C(List<D> list) {
        if (list != null) {
            if (this.XD == null) {
                this.XD = new ArrayList();
            }
            this.XD.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void C(D d) {
        if (d != null && this.XD != null) {
            this.XD.remove(d);
            notifyDataSetChanged();
        }
    }

    public void D(List<D> list) {
        E(list);
        notifyDataSetChanged();
    }

    public void D(D d) {
        H h;
        if (d != null && this.XD != null && this.XD.contains(d) && (h = this.aIE.get(this.XD.indexOf(d))) != null) {
            h.E(d);
        }
    }

    protected void E(List<D> list) {
        if (list != null) {
            if (this.XD == null) {
                this.XD = new ArrayList();
            }
            this.XD.clear();
            this.XD.addAll(list);
            this.aIE.clear();
        }
    }

    public List<D> getDataList() {
        return this.XD == null ? new ArrayList() : new ArrayList(this.XD);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.XD == null) {
            return 0;
        }
        if (this.XD.size() == 0 && this.aIH) {
            return 1;
        }
        return this.XD.size();
    }

    public int FJ() {
        if (this.XD == null) {
            return 0;
        }
        return this.XD.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.XD != null && this.XD.size() != 0 && i >= 0 && i < this.XD.size()) {
            return this.XD.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.XD != null && this.XD.size() != 0 && i >= 0 && i < this.XD.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aID.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aID.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aII != null) {
            this.aII.onChangeSkinType(this.aIF, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aIE.indexOfValue(a) >= 0) {
            this.aIE.remove(a.getPosition());
        }
        this.aIE.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aIF.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aIF, inflate, this.aIG);
                h.b(this.aIF, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aID.add(h);
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
            h.a(item, this.aHQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FK() {
        if (this.aIJ != null && this.aII != null) {
            this.aIJ.removeView(this.aII);
            this.aII = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View FL() {
        if (this.aIJ == null) {
            this.aIJ = new FrameLayout(this.aIF.getPageActivity());
        }
        if (this.aII == null) {
            this.aII = NoDataViewFactory.a(this.aIF.getPageActivity(), this.aIJ, this.aIL, this.aIK, this.aIM);
        }
        this.aII.setVisibility(0);
        if (this.aIN != null) {
            this.aII.setLayoutParams(this.aIN);
        }
        this.aIJ.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aII.onChangeSkinType(this.aIF, TbadkCoreApplication.getInst().getSkinType());
        return this.aIJ;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aIL = cVar;
        this.aIK = dVar;
        this.aIM = bVar;
        this.aIN = layoutParams;
        if (this.aII != null) {
            this.aII.setTextOption(dVar);
            this.aII.setImgOption(cVar);
            this.aII.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aII.setLayoutParams(layoutParams);
            }
        }
    }

    public void bX(boolean z) {
        this.aIH = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean FM() {
        return this.XD != null && this.XD.size() == 0;
    }
}

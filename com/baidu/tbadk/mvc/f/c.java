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
    protected List<D> XG;
    protected S aHS;
    protected final TbPageContext<?> aIH;
    protected final ViewEventCenter aII;
    private j aIK;
    private FrameLayout aIL;
    private NoDataViewFactory.d aIM;
    private NoDataViewFactory.c aIN;
    private NoDataViewFactory.b aIO;
    private FrameLayout.LayoutParams aIP;
    protected final List<H> aIF = new ArrayList();
    protected final SparseArray<H> aIG = new SparseArray<>();
    protected boolean aIJ = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aIH = tbPageContext;
        this.aII = viewEventCenter;
    }

    public void C(List<D> list) {
        if (list != null) {
            if (this.XG == null) {
                this.XG = new ArrayList();
            }
            this.XG.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void C(D d) {
        if (d != null && this.XG != null) {
            this.XG.remove(d);
            notifyDataSetChanged();
        }
    }

    public void D(List<D> list) {
        E(list);
        notifyDataSetChanged();
    }

    public void D(D d) {
        H h;
        if (d != null && this.XG != null && this.XG.contains(d) && (h = this.aIG.get(this.XG.indexOf(d))) != null) {
            h.E(d);
        }
    }

    protected void E(List<D> list) {
        if (list != null) {
            if (this.XG == null) {
                this.XG = new ArrayList();
            }
            this.XG.clear();
            this.XG.addAll(list);
            this.aIG.clear();
        }
    }

    public List<D> getDataList() {
        return this.XG == null ? new ArrayList() : new ArrayList(this.XG);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.XG == null) {
            return 0;
        }
        if (this.XG.size() == 0 && this.aIJ) {
            return 1;
        }
        return this.XG.size();
    }

    public int FJ() {
        if (this.XG == null) {
            return 0;
        }
        return this.XG.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.XG != null && this.XG.size() != 0 && i >= 0 && i < this.XG.size()) {
            return this.XG.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.XG != null && this.XG.size() != 0 && i >= 0 && i < this.XG.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aIF.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aIF.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aIK != null) {
            this.aIK.onChangeSkinType(this.aIH, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aIG.indexOfValue(a) >= 0) {
            this.aIG.remove(a.getPosition());
        }
        this.aIG.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aIH.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aIH, inflate, this.aII);
                h.b(this.aIH, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aIF.add(h);
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
            h.a(item, this.aHS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FK() {
        if (this.aIL != null && this.aIK != null) {
            this.aIL.removeView(this.aIK);
            this.aIK = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View FL() {
        if (this.aIL == null) {
            this.aIL = new FrameLayout(this.aIH.getPageActivity());
        }
        if (this.aIK == null) {
            this.aIK = NoDataViewFactory.a(this.aIH.getPageActivity(), this.aIL, this.aIN, this.aIM, this.aIO);
        }
        this.aIK.setVisibility(0);
        if (this.aIP != null) {
            this.aIK.setLayoutParams(this.aIP);
        }
        this.aIL.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aIK.onChangeSkinType(this.aIH, TbadkCoreApplication.getInst().getSkinType());
        return this.aIL;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aIN = cVar;
        this.aIM = dVar;
        this.aIO = bVar;
        this.aIP = layoutParams;
        if (this.aIK != null) {
            this.aIK.setTextOption(dVar);
            this.aIK.setImgOption(cVar);
            this.aIK.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aIK.setLayoutParams(layoutParams);
            }
        }
    }

    public void bX(boolean z) {
        this.aIJ = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean FM() {
        return this.XG != null && this.XG.size() == 0;
    }
}

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
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
import com.baidu.tieba.tbadkCore.q;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements q {
    protected S aDV;
    protected List<D> aEI;
    protected final TbPageContext<?> aEL;
    protected final ViewEventCenter aEM;
    private y aEO;
    private FrameLayout aEP;
    private NoDataViewFactory.d aEQ;
    private NoDataViewFactory.c aER;
    private NoDataViewFactory.b aES;
    private FrameLayout.LayoutParams aET;
    protected final List<H> aEJ = new ArrayList();
    protected final SparseArray<H> aEK = new SparseArray<>();
    protected boolean aEN = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aEL = tbPageContext;
        this.aEM = viewEventCenter;
    }

    public void v(List<D> list) {
        if (list != null) {
            if (this.aEI == null) {
                this.aEI = new ArrayList();
            }
            this.aEI.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void C(D d) {
        if (d != null && this.aEI != null) {
            this.aEI.remove(d);
            notifyDataSetChanged();
        }
    }

    public void w(List<D> list) {
        x(list);
        notifyDataSetChanged();
    }

    public void D(D d) {
        H h;
        if (d != null && this.aEI != null && this.aEI.contains(d) && (h = this.aEK.get(this.aEI.indexOf(d))) != null) {
            h.E(d);
        }
    }

    protected void x(List<D> list) {
        if (list != null) {
            if (this.aEI == null) {
                this.aEI = new ArrayList();
            }
            this.aEI.clear();
            this.aEI.addAll(list);
            this.aEK.clear();
        }
    }

    public List<D> getDataList() {
        return this.aEI == null ? new ArrayList() : new ArrayList(this.aEI);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aEI == null) {
            return 0;
        }
        if (this.aEI.size() == 0 && this.aEN) {
            return 1;
        }
        return this.aEI.size();
    }

    public int Fs() {
        if (this.aEI == null) {
            return 0;
        }
        return this.aEI.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.aEI != null && this.aEI.size() != 0 && i >= 0 && i < this.aEI.size()) {
            return this.aEI.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aEI != null && this.aEI.size() != 0 && i >= 0 && i < this.aEI.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aEJ.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aEJ.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aEO != null) {
            this.aEO.onChangeSkinType(this.aEL, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aEK.indexOfValue(a) >= 0) {
            this.aEK.remove(a.getPosition());
        }
        this.aEK.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aEL.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aEL, inflate, this.aEM);
                h.b(this.aEL, TbadkCoreApplication.m9getInst().getSkinType());
                inflate.setTag(h);
                this.aEJ.add(h);
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
            h.a(item, this.aDV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ft() {
        if (this.aEP != null && this.aEO != null) {
            this.aEP.removeView(this.aEO);
            this.aEO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Fu() {
        if (this.aEP == null) {
            this.aEP = new FrameLayout(this.aEL.getPageActivity());
        }
        if (this.aEO == null) {
            this.aEO = NoDataViewFactory.a(this.aEL.getPageActivity(), this.aEP, this.aER, this.aEQ, this.aES);
        }
        this.aEO.setVisibility(0);
        if (this.aET != null) {
            this.aEO.setLayoutParams(this.aET);
        }
        this.aEP.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aEO.onChangeSkinType(this.aEL, TbadkCoreApplication.m9getInst().getSkinType());
        return this.aEP;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aER = cVar;
        this.aEQ = dVar;
        this.aES = bVar;
        this.aET = layoutParams;
        if (this.aEO != null) {
            this.aEO.setTextOption(dVar);
            this.aEO.setImgOption(cVar);
            this.aEO.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aEO.setLayoutParams(layoutParams);
            }
        }
    }

    public void bS(boolean z) {
        this.aEN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Fv() {
        return this.aEI != null && this.aEI.size() == 0;
    }
}

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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
import com.baidu.tieba.tbadkCore.o;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements o {
    protected List<D> aMR;
    protected final TbPageContext<?> byW;
    protected final ViewEventCenter byX;
    private h byZ;
    protected S byl;
    private FrameLayout bza;
    private NoDataViewFactory.d bzb;
    private NoDataViewFactory.c bzc;
    private NoDataViewFactory.b bzd;
    private FrameLayout.LayoutParams bze;
    protected final List<H> byU = new ArrayList();
    protected final SparseArray<H> byV = new SparseArray<>();
    protected boolean byY = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.byW = tbPageContext;
        this.byX = viewEventCenter;
    }

    public void M(List<D> list) {
        if (list != null) {
            if (this.aMR == null) {
                this.aMR = new ArrayList();
            }
            this.aMR.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void aG(D d) {
        if (d != null && this.aMR != null) {
            this.aMR.remove(d);
            notifyDataSetChanged();
        }
    }

    public void N(List<D> list) {
        O(list);
        notifyDataSetChanged();
    }

    public void aH(D d) {
        H h;
        if (d != null && this.aMR != null && this.aMR.contains(d) && (h = this.byV.get(this.aMR.indexOf(d))) != null) {
            h.aI(d);
        }
    }

    protected void O(List<D> list) {
        if (list != null) {
            if (this.aMR == null) {
                this.aMR = new ArrayList();
            }
            this.aMR.clear();
            this.aMR.addAll(list);
            this.byV.clear();
        }
    }

    public List<D> getDataList() {
        return this.aMR == null ? new ArrayList() : new ArrayList(this.aMR);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aMR == null) {
            return 0;
        }
        if (this.aMR.size() == 0 && this.byY) {
            return 1;
        }
        return this.aMR.size();
    }

    public int NG() {
        if (this.aMR == null) {
            return 0;
        }
        return this.aMR.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.aMR != null && this.aMR.size() != 0 && i >= 0 && i < this.aMR.size()) {
            return this.aMR.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aMR != null && this.aMR.size() != 0 && i >= 0 && i < this.aMR.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.byU.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.byU.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.byZ != null) {
            this.byZ.onChangeSkinType(this.byW, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.byV.indexOfValue(a) >= 0) {
            this.byV.remove(a.getPosition());
        }
        this.byV.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.byW.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.byW, inflate, this.byX);
                h.b(this.byW, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.byU.add(h);
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
            h.a(item, this.byl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void NH() {
        if (this.bza != null && this.byZ != null) {
            this.bza.removeView(this.byZ);
            this.byZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View NI() {
        if (this.bza == null) {
            this.bza = new FrameLayout(this.byW.getPageActivity());
        }
        if (this.byZ == null) {
            this.byZ = NoDataViewFactory.a(this.byW.getPageActivity(), this.bza, this.bzc, this.bzb, this.bzd);
        }
        this.byZ.setVisibility(0);
        if (this.bze != null) {
            this.byZ.setLayoutParams(this.bze);
        }
        this.bza.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.byZ.onChangeSkinType(this.byW, TbadkCoreApplication.getInst().getSkinType());
        return this.bza;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.bzc = cVar;
        this.bzb = dVar;
        this.bzd = bVar;
        this.bze = layoutParams;
        if (this.byZ != null) {
            this.byZ.setTextOption(dVar);
            this.byZ.setImgOption(cVar);
            this.byZ.setButtonOption(bVar);
            if (layoutParams != null) {
                this.byZ.setLayoutParams(layoutParams);
            }
        }
    }

    public void cx(boolean z) {
        this.byY = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean NJ() {
        return this.aMR != null && this.aMR.size() == 0;
    }
}

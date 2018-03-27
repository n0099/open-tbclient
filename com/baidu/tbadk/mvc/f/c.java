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
import com.baidu.tieba.tbadkCore.p;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements p {
    protected List<D> aMS;
    protected final TbPageContext<?> byZ;
    protected S byo;
    protected final ViewEventCenter bza;
    private h bzc;
    private FrameLayout bzd;
    private NoDataViewFactory.d bze;
    private NoDataViewFactory.c bzf;
    private NoDataViewFactory.b bzg;
    private FrameLayout.LayoutParams bzh;
    protected final List<H> byX = new ArrayList();
    protected final SparseArray<H> byY = new SparseArray<>();
    protected boolean bzb = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.byZ = tbPageContext;
        this.bza = viewEventCenter;
    }

    public void M(List<D> list) {
        if (list != null) {
            if (this.aMS == null) {
                this.aMS = new ArrayList();
            }
            this.aMS.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void aG(D d) {
        if (d != null && this.aMS != null) {
            this.aMS.remove(d);
            notifyDataSetChanged();
        }
    }

    public void N(List<D> list) {
        O(list);
        notifyDataSetChanged();
    }

    public void aH(D d) {
        H h;
        if (d != null && this.aMS != null && this.aMS.contains(d) && (h = this.byY.get(this.aMS.indexOf(d))) != null) {
            h.aI(d);
        }
    }

    protected void O(List<D> list) {
        if (list != null) {
            if (this.aMS == null) {
                this.aMS = new ArrayList();
            }
            this.aMS.clear();
            this.aMS.addAll(list);
            this.byY.clear();
        }
    }

    public List<D> getDataList() {
        return this.aMS == null ? new ArrayList() : new ArrayList(this.aMS);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aMS == null) {
            return 0;
        }
        if (this.aMS.size() == 0 && this.bzb) {
            return 1;
        }
        return this.aMS.size();
    }

    public int NH() {
        if (this.aMS == null) {
            return 0;
        }
        return this.aMS.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.aMS != null && this.aMS.size() != 0 && i >= 0 && i < this.aMS.size()) {
            return this.aMS.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aMS != null && this.aMS.size() != 0 && i >= 0 && i < this.aMS.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.byX.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.byX.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.bzc != null) {
            this.bzc.onChangeSkinType(this.byZ, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.byY.indexOfValue(a) >= 0) {
            this.byY.remove(a.getPosition());
        }
        this.byY.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.byZ.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.byZ, inflate, this.bza);
                h.b(this.byZ, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.byX.add(h);
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
            h.a(item, this.byo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void NI() {
        if (this.bzd != null && this.bzc != null) {
            this.bzd.removeView(this.bzc);
            this.bzc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View NJ() {
        if (this.bzd == null) {
            this.bzd = new FrameLayout(this.byZ.getPageActivity());
        }
        if (this.bzc == null) {
            this.bzc = NoDataViewFactory.a(this.byZ.getPageActivity(), this.bzd, this.bzf, this.bze, this.bzg);
        }
        this.bzc.setVisibility(0);
        if (this.bzh != null) {
            this.bzc.setLayoutParams(this.bzh);
        }
        this.bzd.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.bzc.onChangeSkinType(this.byZ, TbadkCoreApplication.getInst().getSkinType());
        return this.bzd;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.bzf = cVar;
        this.bze = dVar;
        this.bzg = bVar;
        this.bzh = layoutParams;
        if (this.bzc != null) {
            this.bzc.setTextOption(dVar);
            this.bzc.setImgOption(cVar);
            this.bzc.setButtonOption(bVar);
            if (layoutParams != null) {
                this.bzc.setLayoutParams(layoutParams);
            }
        }
    }

    public void cx(boolean z) {
        this.bzb = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean NK() {
        return this.aMS != null && this.aMS.size() == 0;
    }
}

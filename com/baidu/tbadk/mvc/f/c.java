package com.baidu.tbadk.mvc.f;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
import com.baidu.tieba.tbadkCore.q;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements q {
    protected List<D> bHx;
    protected final TbPageContext<?> cyZ;
    protected S cyo;
    protected final ViewEventCenter cza;
    private NoDataView czc;
    private FrameLayout czd;
    private NoDataViewFactory.d cze;
    private NoDataViewFactory.c czf;
    private NoDataViewFactory.b czg;
    private FrameLayout.LayoutParams czh;
    protected final List<H> cyX = new ArrayList();
    protected final SparseArray<H> cyY = new SparseArray<>();
    protected boolean czb = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.cyZ = tbPageContext;
        this.cza = viewEventCenter;
    }

    public void ak(List<D> list) {
        if (list != null) {
            if (this.bHx == null) {
                this.bHx = new ArrayList();
            }
            this.bHx.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void ad(D d) {
        if (d != null && this.bHx != null) {
            this.bHx.remove(d);
            notifyDataSetChanged();
        }
    }

    public void al(List<D> list) {
        am(list);
        notifyDataSetChanged();
    }

    public void ae(D d) {
        H h;
        if (d != null && this.bHx != null && this.bHx.contains(d) && (h = this.cyY.get(this.bHx.indexOf(d))) != null) {
            h.af(d);
        }
    }

    protected void am(List<D> list) {
        if (list != null) {
            if (this.bHx == null) {
                this.bHx = new ArrayList();
            }
            this.bHx.clear();
            this.bHx.addAll(list);
            this.cyY.clear();
        }
    }

    public List<D> getDataList() {
        return this.bHx == null ? new ArrayList() : new ArrayList(this.bHx);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bHx == null) {
            return 0;
        }
        if (this.bHx.size() == 0 && this.czb) {
            return 1;
        }
        return this.bHx.size();
    }

    public int auQ() {
        if (this.bHx == null) {
            return 0;
        }
        return this.bHx.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.bHx != null && this.bHx.size() != 0 && i >= 0 && i < this.bHx.size()) {
            return this.bHx.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bHx != null && this.bHx.size() != 0 && i >= 0 && i < this.bHx.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.cyX.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.cyX.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.czc != null) {
            this.czc.onChangeSkinType(this.cyZ, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.cyY.indexOfValue(a) >= 0) {
            this.cyY.remove(a.getPosition());
        }
        this.cyY.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.cyZ.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.cyZ, inflate, this.cza);
                h.b(this.cyZ, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.cyX.add(h);
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
            h.a(item, this.cyo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void auR() {
        if (this.czd != null && this.czc != null) {
            this.czd.removeView(this.czc);
            this.czc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View auS() {
        if (this.czd == null) {
            this.czd = new FrameLayout(this.cyZ.getPageActivity());
        }
        if (this.czc == null) {
            this.czc = NoDataViewFactory.a(this.cyZ.getPageActivity(), this.czd, this.czf, this.cze, this.czg);
        }
        this.czc.setVisibility(0);
        if (this.czh != null) {
            this.czc.setLayoutParams(this.czh);
        }
        this.czd.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.czc.onChangeSkinType(this.cyZ, TbadkCoreApplication.getInst().getSkinType());
        return this.czd;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.czf = cVar;
        this.cze = dVar;
        this.czg = bVar;
        this.czh = layoutParams;
        if (this.czc != null) {
            this.czc.setTextOption(dVar);
            this.czc.setImgOption(cVar);
            this.czc.setButtonOption(bVar);
            if (layoutParams != null) {
                this.czc.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean auT() {
        return this.bHx != null && this.bHx.size() == 0;
    }
}

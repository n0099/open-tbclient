package com.baidu.tbadk.mvc.j;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.core.view.z;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.e.c;
import com.baidu.tbadk.mvc.j.a;
import com.baidu.tieba.tbadkCore.ab;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.e.c, H extends a<D, S>> extends BaseAdapter implements ab {
    protected S anD;
    protected List<D> aoR;
    protected final TbPageContext<?> aoU;
    protected final ViewEventCenter aoV;
    private x aoX;
    private FrameLayout aoY;
    private com.baidu.tbadk.core.view.ab aoZ;
    private aa apa;
    private z apb;
    private FrameLayout.LayoutParams apc;
    protected final List<H> aoS = new ArrayList();
    protected final SparseArray<H> aoT = new SparseArray<>();
    protected boolean aoW = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aoU = tbPageContext;
        this.aoV = viewEventCenter;
    }

    public void r(List<D> list) {
        if (list != null) {
            if (this.aoR == null) {
                this.aoR = new ArrayList();
            }
            this.aoR.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void x(D d) {
        if (d != null && this.aoR != null) {
            this.aoR.remove(d);
            notifyDataSetChanged();
        }
    }

    public void s(List<D> list) {
        t(list);
        notifyDataSetChanged();
    }

    public void c(S s) {
        d(s);
        notifyDataSetChanged();
    }

    public void y(D d) {
        H h;
        if (d != null && this.aoR != null && this.aoR.contains(d) && (h = this.aoT.get(this.aoR.indexOf(d))) != null) {
            h.z(d);
        }
    }

    protected void t(List<D> list) {
        if (list != null) {
            if (this.aoR == null) {
                this.aoR = new ArrayList();
            }
            this.aoR.clear();
            this.aoR.addAll(list);
            this.aoT.clear();
        }
    }

    protected void d(S s) {
        this.anD = s;
    }

    public List<D> CM() {
        return this.aoR == null ? new ArrayList() : new ArrayList(this.aoR);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aoR == null) {
            return 0;
        }
        if (this.aoR.size() == 0 && this.aoW) {
            return 1;
        }
        return this.aoR.size();
    }

    public int CN() {
        if (this.aoR == null) {
            return 0;
        }
        return this.aoR.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.aoR != null && this.aoR.size() != 0 && i >= 0 && i < this.aoR.size()) {
            return this.aoR.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aoR != null && this.aoR.size() != 0 && i >= 0 && i < this.aoR.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.aoS.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aoS.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.aoX != null) {
            this.aoX.onChangeSkinType(this.aoU, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aoT.indexOfValue(a) >= 0) {
            this.aoT.remove(a.getPosition());
        }
        this.aoT.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aoU.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aoU, inflate, this.aoV);
                h.a(this.aoU, TbadkCoreApplication.m411getInst().getSkinType());
                inflate.setTag(h);
                this.aoS.add(h);
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
            h.a(item, this.anD);
        }
    }

    public void oH() {
        if (this.aoX != null) {
            this.aoX.e(this.aoU);
        }
    }

    public void onActivityStop() {
        if (this.aoX != null) {
            this.aoX.onActivityStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CO() {
        if (this.aoY != null && this.aoX != null) {
            this.aoY.removeView(this.aoX);
            this.aoX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View createNoDataView() {
        if (this.aoY == null) {
            this.aoY = new FrameLayout(this.aoU.getPageActivity());
        }
        if (this.aoX == null) {
            this.aoX = NoDataViewFactory.a(this.aoU.getPageActivity(), this.aoY, this.apa, this.aoZ, this.apb);
        }
        this.aoX.setVisibility(0);
        if (this.apc != null) {
            this.aoX.setLayoutParams(this.apc);
        }
        this.aoY.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aoX.onChangeSkinType(this.aoU, TbadkCoreApplication.m411getInst().getSkinType());
        return this.aoY;
    }

    public void a(aa aaVar, com.baidu.tbadk.core.view.ab abVar, z zVar, FrameLayout.LayoutParams layoutParams) {
        this.apa = aaVar;
        this.aoZ = abVar;
        this.apb = zVar;
        this.apc = layoutParams;
        if (this.aoX != null) {
            this.aoX.setTextOption(abVar);
            this.aoX.setImgOption(aaVar);
            this.aoX.setButtonOption(zVar);
            if (layoutParams != null) {
                this.aoX.setLayoutParams(layoutParams);
            }
        }
    }

    public void bi(boolean z) {
        this.aoW = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean CP() {
        return this.aoR != null && this.aoR.size() == 0;
    }
}

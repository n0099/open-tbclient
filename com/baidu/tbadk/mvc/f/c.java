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
import com.baidu.tieba.tbadkCore.o;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements o {
    protected List<D> bzj;
    protected S coJ;
    private NoDataViewFactory.d cpA;
    private NoDataViewFactory.c cpB;
    private NoDataViewFactory.b cpC;
    private FrameLayout.LayoutParams cpD;
    protected final TbPageContext<?> cpv;
    protected final ViewEventCenter cpw;
    private NoDataView cpy;
    private FrameLayout cpz;
    protected final List<H> cps = new ArrayList();
    protected final SparseArray<H> cpt = new SparseArray<>();
    protected boolean cpx = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.cpv = tbPageContext;
        this.cpw = viewEventCenter;
    }

    public void ad(List<D> list) {
        if (list != null) {
            if (this.bzj == null) {
                this.bzj = new ArrayList();
            }
            this.bzj.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void ab(D d) {
        if (d != null && this.bzj != null) {
            this.bzj.remove(d);
            notifyDataSetChanged();
        }
    }

    public void ae(List<D> list) {
        af(list);
        notifyDataSetChanged();
    }

    public void ac(D d) {
        H h;
        if (d != null && this.bzj != null && this.bzj.contains(d) && (h = this.cpt.get(this.bzj.indexOf(d))) != null) {
            h.ad(d);
        }
    }

    protected void af(List<D> list) {
        if (list != null) {
            if (this.bzj == null) {
                this.bzj = new ArrayList();
            }
            this.bzj.clear();
            this.bzj.addAll(list);
            this.cpt.clear();
        }
    }

    public List<D> getDataList() {
        return this.bzj == null ? new ArrayList() : new ArrayList(this.bzj);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bzj == null) {
            return 0;
        }
        if (this.bzj.size() == 0 && this.cpx) {
            return 1;
        }
        return this.bzj.size();
    }

    public int aoC() {
        if (this.bzj == null) {
            return 0;
        }
        return this.bzj.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.bzj != null && this.bzj.size() != 0 && i >= 0 && i < this.bzj.size()) {
            return this.bzj.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bzj != null && this.bzj.size() != 0 && i >= 0 && i < this.bzj.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.cps.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.cps.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.cpy != null) {
            this.cpy.onChangeSkinType(this.cpv, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.cpt.indexOfValue(a) >= 0) {
            this.cpt.remove(a.getPosition());
        }
        this.cpt.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.cpv.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.cpv, inflate, this.cpw);
                h.b(this.cpv, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.cps.add(h);
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
            h.a(item, this.coJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoD() {
        if (this.cpz != null && this.cpy != null) {
            this.cpz.removeView(this.cpy);
            this.cpy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aoE() {
        if (this.cpz == null) {
            this.cpz = new FrameLayout(this.cpv.getPageActivity());
        }
        if (this.cpy == null) {
            this.cpy = NoDataViewFactory.a(this.cpv.getPageActivity(), this.cpz, this.cpB, this.cpA, this.cpC);
        }
        this.cpy.setVisibility(0);
        if (this.cpD != null) {
            this.cpy.setLayoutParams(this.cpD);
        }
        this.cpz.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.cpy.onChangeSkinType(this.cpv, TbadkCoreApplication.getInst().getSkinType());
        return this.cpz;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.cpB = cVar;
        this.cpA = dVar;
        this.cpC = bVar;
        this.cpD = layoutParams;
        if (this.cpy != null) {
            this.cpy.setTextOption(dVar);
            this.cpy.setImgOption(cVar);
            this.cpy.setButtonOption(bVar);
            if (layoutParams != null) {
                this.cpy.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aoF() {
        return this.bzj != null && this.bzj.size() == 0;
    }
}

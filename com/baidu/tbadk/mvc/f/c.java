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
    protected List<D> bzk;
    protected S coK;
    private FrameLayout cpA;
    private NoDataViewFactory.d cpB;
    private NoDataViewFactory.c cpC;
    private NoDataViewFactory.b cpD;
    private FrameLayout.LayoutParams cpE;
    protected final TbPageContext<?> cpw;
    protected final ViewEventCenter cpx;
    private NoDataView cpz;
    protected final List<H> cpt = new ArrayList();
    protected final SparseArray<H> cpv = new SparseArray<>();
    protected boolean cpy = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.cpw = tbPageContext;
        this.cpx = viewEventCenter;
    }

    public void ad(List<D> list) {
        if (list != null) {
            if (this.bzk == null) {
                this.bzk = new ArrayList();
            }
            this.bzk.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void ab(D d) {
        if (d != null && this.bzk != null) {
            this.bzk.remove(d);
            notifyDataSetChanged();
        }
    }

    public void ae(List<D> list) {
        af(list);
        notifyDataSetChanged();
    }

    public void ac(D d) {
        H h;
        if (d != null && this.bzk != null && this.bzk.contains(d) && (h = this.cpv.get(this.bzk.indexOf(d))) != null) {
            h.ad(d);
        }
    }

    protected void af(List<D> list) {
        if (list != null) {
            if (this.bzk == null) {
                this.bzk = new ArrayList();
            }
            this.bzk.clear();
            this.bzk.addAll(list);
            this.cpv.clear();
        }
    }

    public List<D> getDataList() {
        return this.bzk == null ? new ArrayList() : new ArrayList(this.bzk);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bzk == null) {
            return 0;
        }
        if (this.bzk.size() == 0 && this.cpy) {
            return 1;
        }
        return this.bzk.size();
    }

    public int aoC() {
        if (this.bzk == null) {
            return 0;
        }
        return this.bzk.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.bzk != null && this.bzk.size() != 0 && i >= 0 && i < this.bzk.size()) {
            return this.bzk.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bzk != null && this.bzk.size() != 0 && i >= 0 && i < this.bzk.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.cpt.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.cpt.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.cpz != null) {
            this.cpz.onChangeSkinType(this.cpw, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.cpv.indexOfValue(a) >= 0) {
            this.cpv.remove(a.getPosition());
        }
        this.cpv.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.cpw.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.cpw, inflate, this.cpx);
                h.b(this.cpw, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.cpt.add(h);
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
            h.a(item, this.coK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoD() {
        if (this.cpA != null && this.cpz != null) {
            this.cpA.removeView(this.cpz);
            this.cpz = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aoE() {
        if (this.cpA == null) {
            this.cpA = new FrameLayout(this.cpw.getPageActivity());
        }
        if (this.cpz == null) {
            this.cpz = NoDataViewFactory.a(this.cpw.getPageActivity(), this.cpA, this.cpC, this.cpB, this.cpD);
        }
        this.cpz.setVisibility(0);
        if (this.cpE != null) {
            this.cpz.setLayoutParams(this.cpE);
        }
        this.cpA.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.cpz.onChangeSkinType(this.cpw, TbadkCoreApplication.getInst().getSkinType());
        return this.cpA;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.cpC = cVar;
        this.cpB = dVar;
        this.cpD = bVar;
        this.cpE = layoutParams;
        if (this.cpz != null) {
            this.cpz.setTextOption(dVar);
            this.cpz.setImgOption(cVar);
            this.cpz.setButtonOption(bVar);
            if (layoutParams != null) {
                this.cpz.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aoF() {
        return this.bzk != null && this.bzk.size() == 0;
    }
}

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
    protected List<D> cLa;
    protected S dxH;
    private FrameLayout.LayoutParams dyA;
    protected final TbPageContext<?> dys;
    protected final ViewEventCenter dyt;
    private NoDataView dyv;
    private FrameLayout dyw;
    private NoDataViewFactory.d dyx;
    private NoDataViewFactory.c dyy;
    private NoDataViewFactory.b dyz;
    protected final List<H> dyq = new ArrayList();
    protected final SparseArray<H> dyr = new SparseArray<>();
    protected boolean dyu = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.dys = tbPageContext;
        this.dyt = viewEventCenter;
    }

    public void aK(List<D> list) {
        if (list != null) {
            if (this.cLa == null) {
                this.cLa = new ArrayList();
            }
            this.cLa.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void ae(D d) {
        if (d != null && this.cLa != null) {
            this.cLa.remove(d);
            notifyDataSetChanged();
        }
    }

    public void aL(List<D> list) {
        aM(list);
        notifyDataSetChanged();
    }

    public void af(D d) {
        H h;
        if (d != null && this.cLa != null && this.cLa.contains(d) && (h = this.dyr.get(this.cLa.indexOf(d))) != null) {
            h.ag(d);
        }
    }

    protected void aM(List<D> list) {
        if (list != null) {
            if (this.cLa == null) {
                this.cLa = new ArrayList();
            }
            this.cLa.clear();
            this.cLa.addAll(list);
            this.dyr.clear();
        }
    }

    public List<D> getDataList() {
        return this.cLa == null ? new ArrayList() : new ArrayList(this.cLa);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cLa == null) {
            return 0;
        }
        if (this.cLa.size() == 0 && this.dyu) {
            return 1;
        }
        return this.cLa.size();
    }

    public int aOc() {
        if (this.cLa == null) {
            return 0;
        }
        return this.cLa.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.cLa != null && this.cLa.size() != 0 && i >= 0 && i < this.cLa.size()) {
            return this.cLa.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.cLa != null && this.cLa.size() != 0 && i >= 0 && i < this.cLa.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.dyq.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.dyq.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.dyv != null) {
            this.dyv.onChangeSkinType(this.dys, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.dyr.indexOfValue(a) >= 0) {
            this.dyr.remove(a.getPosition());
        }
        this.dyr.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.dys.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.dys, inflate, this.dyt);
                h.b(this.dys, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.dyq.add(h);
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
            h.a(item, this.dxH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aOd() {
        if (this.dyw != null && this.dyv != null) {
            this.dyw.removeView(this.dyv);
            this.dyv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aOe() {
        if (this.dyw == null) {
            this.dyw = new FrameLayout(this.dys.getPageActivity());
        }
        if (this.dyv == null) {
            this.dyv = NoDataViewFactory.a(this.dys.getPageActivity(), this.dyw, this.dyy, this.dyx, this.dyz);
        }
        this.dyv.setVisibility(0);
        if (this.dyA != null) {
            this.dyv.setLayoutParams(this.dyA);
        }
        this.dyw.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.dyv.onChangeSkinType(this.dys, TbadkCoreApplication.getInst().getSkinType());
        return this.dyw;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.dyy = cVar;
        this.dyx = dVar;
        this.dyz = bVar;
        this.dyA = layoutParams;
        if (this.dyv != null) {
            this.dyv.setTextOption(dVar);
            this.dyv.setImgOption(cVar);
            this.dyv.setButtonOption(bVar);
            if (layoutParams != null) {
                this.dyv.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean yc() {
        return this.cLa != null && this.cLa.size() == 0;
    }
}

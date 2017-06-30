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
    protected List<D> VR;
    protected S aFt;
    protected final TbPageContext<?> aGi;
    protected final ViewEventCenter aGj;
    private y aGl;
    private FrameLayout aGm;
    private NoDataViewFactory.d aGn;
    private NoDataViewFactory.c aGo;
    private NoDataViewFactory.b aGp;
    private FrameLayout.LayoutParams aGq;
    protected final List<H> aGg = new ArrayList();
    protected final SparseArray<H> aGh = new SparseArray<>();
    protected boolean aGk = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aGi = tbPageContext;
        this.aGj = viewEventCenter;
    }

    public void y(List<D> list) {
        if (list != null) {
            if (this.VR == null) {
                this.VR = new ArrayList();
            }
            this.VR.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void C(D d) {
        if (d != null && this.VR != null) {
            this.VR.remove(d);
            notifyDataSetChanged();
        }
    }

    public void z(List<D> list) {
        A(list);
        notifyDataSetChanged();
    }

    public void D(D d) {
        H h;
        if (d != null && this.VR != null && this.VR.contains(d) && (h = this.aGh.get(this.VR.indexOf(d))) != null) {
            h.E(d);
        }
    }

    protected void A(List<D> list) {
        if (list != null) {
            if (this.VR == null) {
                this.VR = new ArrayList();
            }
            this.VR.clear();
            this.VR.addAll(list);
            this.aGh.clear();
        }
    }

    public List<D> getDataList() {
        return this.VR == null ? new ArrayList() : new ArrayList(this.VR);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.VR == null) {
            return 0;
        }
        if (this.VR.size() == 0 && this.aGk) {
            return 1;
        }
        return this.VR.size();
    }

    public int Fl() {
        if (this.VR == null) {
            return 0;
        }
        return this.VR.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.VR != null && this.VR.size() != 0 && i >= 0 && i < this.VR.size()) {
            return this.VR.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.VR != null && this.VR.size() != 0 && i >= 0 && i < this.VR.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aGg.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aGg.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aGl != null) {
            this.aGl.onChangeSkinType(this.aGi, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aGh.indexOfValue(a) >= 0) {
            this.aGh.remove(a.getPosition());
        }
        this.aGh.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aGi.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aGi, inflate, this.aGj);
                h.b(this.aGi, TbadkCoreApplication.m9getInst().getSkinType());
                inflate.setTag(h);
                this.aGg.add(h);
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
            h.a(item, this.aFt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fm() {
        if (this.aGm != null && this.aGl != null) {
            this.aGm.removeView(this.aGl);
            this.aGl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Fn() {
        if (this.aGm == null) {
            this.aGm = new FrameLayout(this.aGi.getPageActivity());
        }
        if (this.aGl == null) {
            this.aGl = NoDataViewFactory.a(this.aGi.getPageActivity(), this.aGm, this.aGo, this.aGn, this.aGp);
        }
        this.aGl.setVisibility(0);
        if (this.aGq != null) {
            this.aGl.setLayoutParams(this.aGq);
        }
        this.aGm.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aGl.onChangeSkinType(this.aGi, TbadkCoreApplication.m9getInst().getSkinType());
        return this.aGm;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aGo = cVar;
        this.aGn = dVar;
        this.aGp = bVar;
        this.aGq = layoutParams;
        if (this.aGl != null) {
            this.aGl.setTextOption(dVar);
            this.aGl.setImgOption(cVar);
            this.aGl.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aGl.setLayoutParams(layoutParams);
            }
        }
    }

    public void bU(boolean z) {
        this.aGk = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Fo() {
        return this.VR != null && this.VR.size() == 0;
    }
}

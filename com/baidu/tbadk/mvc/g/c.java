package com.baidu.tbadk.mvc.g;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.g.a;
import com.baidu.tieba.tbadkCore.s;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements s {
    protected List<D> aAH;
    protected final TbPageContext<?> aAK;
    protected final ViewEventCenter aAL;
    private q aAN;
    private FrameLayout aAO;
    private NoDataViewFactory.d aAP;
    private NoDataViewFactory.c aAQ;
    private NoDataViewFactory.b aAR;
    private FrameLayout.LayoutParams aAS;
    protected S azP;
    protected final List<H> aAI = new ArrayList();
    protected final SparseArray<H> aAJ = new SparseArray<>();
    protected boolean aAM = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aAK = tbPageContext;
        this.aAL = viewEventCenter;
    }

    public void z(List<D> list) {
        if (list != null) {
            if (this.aAH == null) {
                this.aAH = new ArrayList();
            }
            this.aAH.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void C(D d) {
        if (d != null && this.aAH != null) {
            this.aAH.remove(d);
            notifyDataSetChanged();
        }
    }

    public void A(List<D> list) {
        B(list);
        notifyDataSetChanged();
    }

    public void a(S s) {
        b(s);
        notifyDataSetChanged();
    }

    public void D(D d) {
        H h;
        if (d != null && this.aAH != null && this.aAH.contains(d) && (h = this.aAJ.get(this.aAH.indexOf(d))) != null) {
            h.E(d);
        }
    }

    protected void B(List<D> list) {
        if (list != null) {
            if (this.aAH == null) {
                this.aAH = new ArrayList();
            }
            this.aAH.clear();
            this.aAH.addAll(list);
            this.aAJ.clear();
        }
    }

    protected void b(S s) {
        this.azP = s;
    }

    public List<D> Fu() {
        return this.aAH == null ? new ArrayList() : new ArrayList(this.aAH);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aAH == null) {
            return 0;
        }
        if (this.aAH.size() == 0 && this.aAM) {
            return 1;
        }
        return this.aAH.size();
    }

    public int Fv() {
        if (this.aAH == null) {
            return 0;
        }
        return this.aAH.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.aAH != null && this.aAH.size() != 0 && i >= 0 && i < this.aAH.size()) {
            return this.aAH.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aAH != null && this.aAH.size() != 0 && i >= 0 && i < this.aAH.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.aAI.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aAI.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.aAN != null) {
            this.aAN.onChangeSkinType(this.aAK, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aAJ.indexOfValue(a) >= 0) {
            this.aAJ.remove(a.getPosition());
        }
        this.aAJ.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aAK.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aAK, inflate, this.aAL);
                h.a(this.aAK, TbadkCoreApplication.m9getInst().getSkinType());
                inflate.setTag(h);
                this.aAI.add(h);
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
            h.a(item, this.azP);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fw() {
        if (this.aAO != null && this.aAN != null) {
            this.aAO.removeView(this.aAN);
            this.aAN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Fx() {
        if (this.aAO == null) {
            this.aAO = new FrameLayout(this.aAK.getPageActivity());
        }
        if (this.aAN == null) {
            this.aAN = NoDataViewFactory.a(this.aAK.getPageActivity(), this.aAO, this.aAQ, this.aAP, this.aAR);
        }
        this.aAN.setVisibility(0);
        if (this.aAS != null) {
            this.aAN.setLayoutParams(this.aAS);
        }
        this.aAO.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aAN.onChangeSkinType(this.aAK, TbadkCoreApplication.m9getInst().getSkinType());
        return this.aAO;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aAQ = cVar;
        this.aAP = dVar;
        this.aAR = bVar;
        this.aAS = layoutParams;
        if (this.aAN != null) {
            this.aAN.setTextOption(dVar);
            this.aAN.setImgOption(cVar);
            this.aAN.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aAN.setLayoutParams(layoutParams);
            }
        }
    }

    public void bQ(boolean z) {
        this.aAM = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Fy() {
        return this.aAH != null && this.aAH.size() == 0;
    }
}

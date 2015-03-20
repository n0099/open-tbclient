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
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.core.view.u;
import com.baidu.tbadk.core.view.v;
import com.baidu.tbadk.core.view.w;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.e.c;
import com.baidu.tbadk.mvc.j.a;
import com.baidu.tieba.tbadkCore.ab;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.e.c, H extends a<D, S>> extends BaseAdapter implements ab {
    protected S ams;
    protected List<D> anG;
    protected final TbPageContext<?> anJ;
    protected final ViewEventCenter anK;
    private s anM;
    private FrameLayout anN;
    private w anO;
    private v anP;
    private u anQ;
    private FrameLayout.LayoutParams anR;
    protected final List<H> anH = new ArrayList();
    protected final SparseArray<H> anI = new SparseArray<>();
    protected boolean anL = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.anJ = tbPageContext;
        this.anK = viewEventCenter;
    }

    public void q(List<D> list) {
        if (list != null) {
            if (this.anG == null) {
                this.anG = new ArrayList();
            }
            this.anG.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void x(D d) {
        if (d != null && this.anG != null) {
            this.anG.remove(d);
            notifyDataSetChanged();
        }
    }

    public void r(List<D> list) {
        s(list);
        notifyDataSetChanged();
    }

    public void c(S s) {
        d(s);
        notifyDataSetChanged();
    }

    public void y(D d) {
        H h;
        if (d != null && this.anG != null && this.anG.contains(d) && (h = this.anI.get(this.anG.indexOf(d))) != null) {
            h.A(d);
        }
    }

    public H z(D d) {
        if (d == null || this.anG == null || !this.anG.contains(d)) {
            return null;
        }
        return this.anI.get(this.anG.indexOf(d));
    }

    protected void s(List<D> list) {
        if (list != null) {
            if (this.anG == null) {
                this.anG = new ArrayList();
            }
            this.anG.clear();
            this.anG.addAll(list);
            this.anI.clear();
        }
    }

    protected void d(S s) {
        this.ams = s;
    }

    public List<D> BU() {
        return this.anG == null ? new ArrayList() : new ArrayList(this.anG);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anG == null) {
            return 0;
        }
        if (this.anG.size() == 0 && this.anL) {
            return 1;
        }
        return this.anG.size();
    }

    public int BV() {
        if (this.anG == null) {
            return 0;
        }
        return this.anG.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.anG != null && this.anG.size() != 0 && i >= 0 && i < this.anG.size()) {
            return this.anG.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.anG != null && this.anG.size() != 0 && i >= 0 && i < this.anG.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        int size = this.anH.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.anH.get(i2);
            if (h != null) {
                h.a(tbPageContext, i);
            }
        }
        if (this.anM != null) {
            this.anM.onChangeSkinType(this.anJ, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.anI.indexOfValue(a) >= 0) {
            this.anI.remove(a.getPosition());
        }
        this.anI.put(i, a);
        a((c<D, S, H>) a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.anJ.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.anJ, inflate, this.anK);
                h.a(this.anJ, TbadkCoreApplication.m411getInst().getSkinType());
                inflate.setTag(h);
                this.anH.add(h);
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
            h.a(item, this.ams);
        }
    }

    public void or() {
        if (this.anM != null) {
            this.anM.e(this.anJ);
        }
    }

    public void onActivityStop() {
        if (this.anM != null) {
            this.anM.onActivityStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BW() {
        if (this.anN != null && this.anM != null) {
            this.anN.removeView(this.anM);
            this.anM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View BX() {
        if (this.anN == null) {
            this.anN = new FrameLayout(this.anJ.getPageActivity());
        }
        if (this.anM == null) {
            this.anM = NoDataViewFactory.a(this.anJ.getPageActivity(), this.anN, this.anP, this.anO, this.anQ);
        }
        this.anM.setVisibility(0);
        if (this.anR != null) {
            this.anM.setLayoutParams(this.anR);
        }
        this.anN.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.anM.onChangeSkinType(this.anJ, TbadkCoreApplication.m411getInst().getSkinType());
        return this.anN;
    }

    public void a(v vVar, w wVar, u uVar, FrameLayout.LayoutParams layoutParams) {
        this.anP = vVar;
        this.anO = wVar;
        this.anQ = uVar;
        this.anR = layoutParams;
        if (this.anM != null) {
            this.anM.setTextOption(wVar);
            this.anM.setImgOption(vVar);
            this.anM.setButtonOption(uVar);
            if (layoutParams != null) {
                this.anM.setLayoutParams(layoutParams);
            }
        }
    }

    public void bb(boolean z) {
        this.anL = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean BY() {
        return this.anG != null && this.anG.size() == 0;
    }
}

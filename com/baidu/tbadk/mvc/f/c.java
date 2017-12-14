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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
import com.baidu.tieba.tbadkCore.n;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements n {
    protected List<D> Xj;
    protected final TbPageContext<?> aIT;
    protected final ViewEventCenter aIU;
    private g aIW;
    private FrameLayout aIX;
    private NoDataViewFactory.d aIY;
    private NoDataViewFactory.c aIZ;
    protected S aIf;
    private NoDataViewFactory.b aJa;
    private FrameLayout.LayoutParams aJb;
    protected final List<H> aIR = new ArrayList();
    protected final SparseArray<H> aIS = new SparseArray<>();
    protected boolean aIV = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aIT = tbPageContext;
        this.aIU = viewEventCenter;
    }

    public void D(List<D> list) {
        if (list != null) {
            if (this.Xj == null) {
                this.Xj = new ArrayList();
            }
            this.Xj.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void B(D d) {
        if (d != null && this.Xj != null) {
            this.Xj.remove(d);
            notifyDataSetChanged();
        }
    }

    public void E(List<D> list) {
        F(list);
        notifyDataSetChanged();
    }

    public void C(D d) {
        H h;
        if (d != null && this.Xj != null && this.Xj.contains(d) && (h = this.aIS.get(this.Xj.indexOf(d))) != null) {
            h.D(d);
        }
    }

    protected void F(List<D> list) {
        if (list != null) {
            if (this.Xj == null) {
                this.Xj = new ArrayList();
            }
            this.Xj.clear();
            this.Xj.addAll(list);
            this.aIS.clear();
        }
    }

    public List<D> getDataList() {
        return this.Xj == null ? new ArrayList() : new ArrayList(this.Xj);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xj == null) {
            return 0;
        }
        if (this.Xj.size() == 0 && this.aIV) {
            return 1;
        }
        return this.Xj.size();
    }

    public int FM() {
        if (this.Xj == null) {
            return 0;
        }
        return this.Xj.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.Xj != null && this.Xj.size() != 0 && i >= 0 && i < this.Xj.size()) {
            return this.Xj.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xj != null && this.Xj.size() != 0 && i >= 0 && i < this.Xj.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aIR.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aIR.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aIW != null) {
            this.aIW.onChangeSkinType(this.aIT, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aIS.indexOfValue(a) >= 0) {
            this.aIS.remove(a.getPosition());
        }
        this.aIS.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aIT.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aIT, inflate, this.aIU);
                h.b(this.aIT, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aIR.add(h);
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
            h.a(item, this.aIf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FN() {
        if (this.aIX != null && this.aIW != null) {
            this.aIX.removeView(this.aIW);
            this.aIW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View FO() {
        if (this.aIX == null) {
            this.aIX = new FrameLayout(this.aIT.getPageActivity());
        }
        if (this.aIW == null) {
            this.aIW = NoDataViewFactory.a(this.aIT.getPageActivity(), this.aIX, this.aIZ, this.aIY, this.aJa);
        }
        this.aIW.setVisibility(0);
        if (this.aJb != null) {
            this.aIW.setLayoutParams(this.aJb);
        }
        this.aIX.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aIW.onChangeSkinType(this.aIT, TbadkCoreApplication.getInst().getSkinType());
        return this.aIX;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aIZ = cVar;
        this.aIY = dVar;
        this.aJa = bVar;
        this.aJb = layoutParams;
        if (this.aIW != null) {
            this.aIW.setTextOption(dVar);
            this.aIW.setImgOption(cVar);
            this.aIW.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aIW.setLayoutParams(layoutParams);
            }
        }
    }

    public void bR(boolean z) {
        this.aIV = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean FP() {
        return this.Xj != null && this.Xj.size() == 0;
    }
}

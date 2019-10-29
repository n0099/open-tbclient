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
    protected List<D> bZG;
    protected S cKC;
    protected final TbPageContext<?> cLo;
    protected final ViewEventCenter cLp;
    private NoDataView cLr;
    private FrameLayout cLs;
    private NoDataViewFactory.d cLt;
    private NoDataViewFactory.c cLu;
    private NoDataViewFactory.b cLv;
    private FrameLayout.LayoutParams cLw;
    protected final List<H> cLm = new ArrayList();
    protected final SparseArray<H> cLn = new SparseArray<>();
    protected boolean cLq = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.cLo = tbPageContext;
        this.cLp = viewEventCenter;
    }

    public void aE(List<D> list) {
        if (list != null) {
            if (this.bZG == null) {
                this.bZG = new ArrayList();
            }
            this.bZG.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void Z(D d) {
        if (d != null && this.bZG != null) {
            this.bZG.remove(d);
            notifyDataSetChanged();
        }
    }

    public void aF(List<D> list) {
        aG(list);
        notifyDataSetChanged();
    }

    public void aa(D d) {
        H h;
        if (d != null && this.bZG != null && this.bZG.contains(d) && (h = this.cLn.get(this.bZG.indexOf(d))) != null) {
            h.ab(d);
        }
    }

    protected void aG(List<D> list) {
        if (list != null) {
            if (this.bZG == null) {
                this.bZG = new ArrayList();
            }
            this.bZG.clear();
            this.bZG.addAll(list);
            this.cLn.clear();
        }
    }

    public List<D> getDataList() {
        return this.bZG == null ? new ArrayList() : new ArrayList(this.bZG);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bZG == null) {
            return 0;
        }
        if (this.bZG.size() == 0 && this.cLq) {
            return 1;
        }
        return this.bZG.size();
    }

    public int awu() {
        if (this.bZG == null) {
            return 0;
        }
        return this.bZG.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.bZG != null && this.bZG.size() != 0 && i >= 0 && i < this.bZG.size()) {
            return this.bZG.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bZG != null && this.bZG.size() != 0 && i >= 0 && i < this.bZG.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.cLm.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.cLm.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.cLr != null) {
            this.cLr.onChangeSkinType(this.cLo, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.cLn.indexOfValue(a) >= 0) {
            this.cLn.remove(a.getPosition());
        }
        this.cLn.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.cLo.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.cLo, inflate, this.cLp);
                h.b(this.cLo, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.cLm.add(h);
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
            h.a(item, this.cKC);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awv() {
        if (this.cLs != null && this.cLr != null) {
            this.cLs.removeView(this.cLr);
            this.cLr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aww() {
        if (this.cLs == null) {
            this.cLs = new FrameLayout(this.cLo.getPageActivity());
        }
        if (this.cLr == null) {
            this.cLr = NoDataViewFactory.a(this.cLo.getPageActivity(), this.cLs, this.cLu, this.cLt, this.cLv);
        }
        this.cLr.setVisibility(0);
        if (this.cLw != null) {
            this.cLr.setLayoutParams(this.cLw);
        }
        this.cLs.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.cLr.onChangeSkinType(this.cLo, TbadkCoreApplication.getInst().getSkinType());
        return this.cLs;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.cLu = cVar;
        this.cLt = dVar;
        this.cLv = bVar;
        this.cLw = layoutParams;
        if (this.cLr != null) {
            this.cLr.setTextOption(dVar);
            this.cLr.setImgOption(cVar);
            this.cLr.setButtonOption(bVar);
            if (layoutParams != null) {
                this.cLr.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean wd() {
        return this.bZG != null && this.bZG.size() == 0;
    }
}

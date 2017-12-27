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
import com.baidu.tieba.tbadkCore.o;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements o {
    protected List<D> aLK;
    protected S bvW;
    protected final TbPageContext<?> bwK;
    protected final ViewEventCenter bwL;
    private g bwN;
    private FrameLayout bwO;
    private NoDataViewFactory.d bwP;
    private NoDataViewFactory.c bwQ;
    private NoDataViewFactory.b bwR;
    private FrameLayout.LayoutParams bwS;
    protected final List<H> bwI = new ArrayList();
    protected final SparseArray<H> bwJ = new SparseArray<>();
    protected boolean bwM = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.bwK = tbPageContext;
        this.bwL = viewEventCenter;
    }

    public void M(List<D> list) {
        if (list != null) {
            if (this.aLK == null) {
                this.aLK = new ArrayList();
            }
            this.aLK.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void aG(D d) {
        if (d != null && this.aLK != null) {
            this.aLK.remove(d);
            notifyDataSetChanged();
        }
    }

    public void N(List<D> list) {
        O(list);
        notifyDataSetChanged();
    }

    public void aH(D d) {
        H h;
        if (d != null && this.aLK != null && this.aLK.contains(d) && (h = this.bwJ.get(this.aLK.indexOf(d))) != null) {
            h.aI(d);
        }
    }

    protected void O(List<D> list) {
        if (list != null) {
            if (this.aLK == null) {
                this.aLK = new ArrayList();
            }
            this.aLK.clear();
            this.aLK.addAll(list);
            this.bwJ.clear();
        }
    }

    public List<D> getDataList() {
        return this.aLK == null ? new ArrayList() : new ArrayList(this.aLK);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aLK == null) {
            return 0;
        }
        if (this.aLK.size() == 0 && this.bwM) {
            return 1;
        }
        return this.aLK.size();
    }

    public int Nl() {
        if (this.aLK == null) {
            return 0;
        }
        return this.aLK.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.aLK != null && this.aLK.size() != 0 && i >= 0 && i < this.aLK.size()) {
            return this.aLK.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aLK != null && this.aLK.size() != 0 && i >= 0 && i < this.aLK.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.bwI.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.bwI.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.bwN != null) {
            this.bwN.onChangeSkinType(this.bwK, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.bwJ.indexOfValue(a) >= 0) {
            this.bwJ.remove(a.getPosition());
        }
        this.bwJ.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.bwK.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.bwK, inflate, this.bwL);
                h.b(this.bwK, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.bwI.add(h);
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
            h.a(item, this.bvW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Nm() {
        if (this.bwO != null && this.bwN != null) {
            this.bwO.removeView(this.bwN);
            this.bwN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Nn() {
        if (this.bwO == null) {
            this.bwO = new FrameLayout(this.bwK.getPageActivity());
        }
        if (this.bwN == null) {
            this.bwN = NoDataViewFactory.a(this.bwK.getPageActivity(), this.bwO, this.bwQ, this.bwP, this.bwR);
        }
        this.bwN.setVisibility(0);
        if (this.bwS != null) {
            this.bwN.setLayoutParams(this.bwS);
        }
        this.bwO.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.bwN.onChangeSkinType(this.bwK, TbadkCoreApplication.getInst().getSkinType());
        return this.bwO;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.bwQ = cVar;
        this.bwP = dVar;
        this.bwR = bVar;
        this.bwS = layoutParams;
        if (this.bwN != null) {
            this.bwN.setTextOption(dVar);
            this.bwN.setImgOption(cVar);
            this.bwN.setButtonOption(bVar);
            if (layoutParams != null) {
                this.bwN.setLayoutParams(layoutParams);
            }
        }
    }

    public void cu(boolean z) {
        this.bwM = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean No() {
        return this.aLK != null && this.aLK.size() == 0;
    }
}

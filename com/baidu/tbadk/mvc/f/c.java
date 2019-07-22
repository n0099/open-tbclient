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
    protected List<D> bHw;
    protected final TbPageContext<?> cyS;
    protected final ViewEventCenter cyT;
    private NoDataView cyV;
    private FrameLayout cyW;
    private NoDataViewFactory.d cyX;
    private NoDataViewFactory.c cyY;
    private NoDataViewFactory.b cyZ;
    protected S cyh;
    private FrameLayout.LayoutParams cza;
    protected final List<H> cyQ = new ArrayList();
    protected final SparseArray<H> cyR = new SparseArray<>();
    protected boolean cyU = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.cyS = tbPageContext;
        this.cyT = viewEventCenter;
    }

    public void ak(List<D> list) {
        if (list != null) {
            if (this.bHw == null) {
                this.bHw = new ArrayList();
            }
            this.bHw.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void ad(D d) {
        if (d != null && this.bHw != null) {
            this.bHw.remove(d);
            notifyDataSetChanged();
        }
    }

    public void al(List<D> list) {
        am(list);
        notifyDataSetChanged();
    }

    public void ae(D d) {
        H h;
        if (d != null && this.bHw != null && this.bHw.contains(d) && (h = this.cyR.get(this.bHw.indexOf(d))) != null) {
            h.af(d);
        }
    }

    protected void am(List<D> list) {
        if (list != null) {
            if (this.bHw == null) {
                this.bHw = new ArrayList();
            }
            this.bHw.clear();
            this.bHw.addAll(list);
            this.cyR.clear();
        }
    }

    public List<D> getDataList() {
        return this.bHw == null ? new ArrayList() : new ArrayList(this.bHw);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bHw == null) {
            return 0;
        }
        if (this.bHw.size() == 0 && this.cyU) {
            return 1;
        }
        return this.bHw.size();
    }

    public int auO() {
        if (this.bHw == null) {
            return 0;
        }
        return this.bHw.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.bHw != null && this.bHw.size() != 0 && i >= 0 && i < this.bHw.size()) {
            return this.bHw.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bHw != null && this.bHw.size() != 0 && i >= 0 && i < this.bHw.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.cyQ.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.cyQ.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.cyV != null) {
            this.cyV.onChangeSkinType(this.cyS, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.cyR.indexOfValue(a) >= 0) {
            this.cyR.remove(a.getPosition());
        }
        this.cyR.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.cyS.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.cyS, inflate, this.cyT);
                h.b(this.cyS, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.cyQ.add(h);
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
            h.a(item, this.cyh);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void auP() {
        if (this.cyW != null && this.cyV != null) {
            this.cyW.removeView(this.cyV);
            this.cyV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View auQ() {
        if (this.cyW == null) {
            this.cyW = new FrameLayout(this.cyS.getPageActivity());
        }
        if (this.cyV == null) {
            this.cyV = NoDataViewFactory.a(this.cyS.getPageActivity(), this.cyW, this.cyY, this.cyX, this.cyZ);
        }
        this.cyV.setVisibility(0);
        if (this.cza != null) {
            this.cyV.setLayoutParams(this.cza);
        }
        this.cyW.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.cyV.onChangeSkinType(this.cyS, TbadkCoreApplication.getInst().getSkinType());
        return this.cyW;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.cyY = cVar;
        this.cyX = dVar;
        this.cyZ = bVar;
        this.cza = layoutParams;
        if (this.cyV != null) {
            this.cyV.setTextOption(dVar);
            this.cyV.setImgOption(cVar);
            this.cyV.setButtonOption(bVar);
            if (layoutParams != null) {
                this.cyV.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean auR() {
        return this.bHw != null && this.bHw.size() == 0;
    }
}

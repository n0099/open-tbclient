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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
import com.baidu.tieba.tbadkCore.l;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements l {
    protected List<D> WQ;
    protected S aGU;
    protected final TbPageContext<?> aHJ;
    protected final ViewEventCenter aHK;
    private f aHM;
    private FrameLayout aHN;
    private NoDataViewFactory.d aHO;
    private NoDataViewFactory.c aHP;
    private NoDataViewFactory.b aHQ;
    private FrameLayout.LayoutParams aHR;
    protected final List<H> aHH = new ArrayList();
    protected final SparseArray<H> aHI = new SparseArray<>();
    protected boolean aHL = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aHJ = tbPageContext;
        this.aHK = viewEventCenter;
    }

    public void B(List<D> list) {
        if (list != null) {
            if (this.WQ == null) {
                this.WQ = new ArrayList();
            }
            this.WQ.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void B(D d) {
        if (d != null && this.WQ != null) {
            this.WQ.remove(d);
            notifyDataSetChanged();
        }
    }

    public void C(List<D> list) {
        D(list);
        notifyDataSetChanged();
    }

    public void C(D d) {
        H h;
        if (d != null && this.WQ != null && this.WQ.contains(d) && (h = this.aHI.get(this.WQ.indexOf(d))) != null) {
            h.D(d);
        }
    }

    protected void D(List<D> list) {
        if (list != null) {
            if (this.WQ == null) {
                this.WQ = new ArrayList();
            }
            this.WQ.clear();
            this.WQ.addAll(list);
            this.aHI.clear();
        }
    }

    public List<D> getDataList() {
        return this.WQ == null ? new ArrayList() : new ArrayList(this.WQ);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.WQ == null) {
            return 0;
        }
        if (this.WQ.size() == 0 && this.aHL) {
            return 1;
        }
        return this.WQ.size();
    }

    public int Fm() {
        if (this.WQ == null) {
            return 0;
        }
        return this.WQ.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.WQ != null && this.WQ.size() != 0 && i >= 0 && i < this.WQ.size()) {
            return this.WQ.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.WQ != null && this.WQ.size() != 0 && i >= 0 && i < this.WQ.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aHH.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aHH.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aHM != null) {
            this.aHM.onChangeSkinType(this.aHJ, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aHI.indexOfValue(a) >= 0) {
            this.aHI.remove(a.getPosition());
        }
        this.aHI.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aHJ.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aHJ, inflate, this.aHK);
                h.b(this.aHJ, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aHH.add(h);
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
            h.a(item, this.aGU);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fn() {
        if (this.aHN != null && this.aHM != null) {
            this.aHN.removeView(this.aHM);
            this.aHM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Fo() {
        if (this.aHN == null) {
            this.aHN = new FrameLayout(this.aHJ.getPageActivity());
        }
        if (this.aHM == null) {
            this.aHM = NoDataViewFactory.a(this.aHJ.getPageActivity(), this.aHN, this.aHP, this.aHO, this.aHQ);
        }
        this.aHM.setVisibility(0);
        if (this.aHR != null) {
            this.aHM.setLayoutParams(this.aHR);
        }
        this.aHN.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aHM.onChangeSkinType(this.aHJ, TbadkCoreApplication.getInst().getSkinType());
        return this.aHN;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aHP = cVar;
        this.aHO = dVar;
        this.aHQ = bVar;
        this.aHR = layoutParams;
        if (this.aHM != null) {
            this.aHM.setTextOption(dVar);
            this.aHM.setImgOption(cVar);
            this.aHM.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aHM.setLayoutParams(layoutParams);
            }
        }
    }

    public void bW(boolean z) {
        this.aHL = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Fp() {
        return this.WQ != null && this.WQ.size() == 0;
    }
}

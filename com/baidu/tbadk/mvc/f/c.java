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
import com.baidu.tieba.tbadkCore.n;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends BaseAdapter implements n {
    protected List<D> Xp;
    protected final TbPageContext<?> aIP;
    protected final ViewEventCenter aIQ;
    private f aIS;
    private FrameLayout aIT;
    private NoDataViewFactory.d aIU;
    private NoDataViewFactory.c aIV;
    private NoDataViewFactory.b aIW;
    private FrameLayout.LayoutParams aIX;
    protected S aIb;
    protected final List<H> aIN = new ArrayList();
    protected final SparseArray<H> aIO = new SparseArray<>();
    protected boolean aIR = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aIP = tbPageContext;
        this.aIQ = viewEventCenter;
    }

    public void D(List<D> list) {
        if (list != null) {
            if (this.Xp == null) {
                this.Xp = new ArrayList();
            }
            this.Xp.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void B(D d) {
        if (d != null && this.Xp != null) {
            this.Xp.remove(d);
            notifyDataSetChanged();
        }
    }

    public void E(List<D> list) {
        F(list);
        notifyDataSetChanged();
    }

    public void C(D d) {
        H h;
        if (d != null && this.Xp != null && this.Xp.contains(d) && (h = this.aIO.get(this.Xp.indexOf(d))) != null) {
            h.D(d);
        }
    }

    protected void F(List<D> list) {
        if (list != null) {
            if (this.Xp == null) {
                this.Xp = new ArrayList();
            }
            this.Xp.clear();
            this.Xp.addAll(list);
            this.aIO.clear();
        }
    }

    public List<D> getDataList() {
        return this.Xp == null ? new ArrayList() : new ArrayList(this.Xp);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xp == null) {
            return 0;
        }
        if (this.Xp.size() == 0 && this.aIR) {
            return 1;
        }
        return this.Xp.size();
    }

    public int FL() {
        if (this.Xp == null) {
            return 0;
        }
        return this.Xp.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.Xp != null && this.Xp.size() != 0 && i >= 0 && i < this.Xp.size()) {
            return this.Xp.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xp != null && this.Xp.size() != 0 && i >= 0 && i < this.Xp.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.aIN.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aIN.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aIS != null) {
            this.aIS.onChangeSkinType(this.aIP, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aIO.indexOfValue(a) >= 0) {
            this.aIO.remove(a.getPosition());
        }
        this.aIO.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aIP.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aIP, inflate, this.aIQ);
                h.b(this.aIP, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.aIN.add(h);
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
            h.a(item, this.aIb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FM() {
        if (this.aIT != null && this.aIS != null) {
            this.aIT.removeView(this.aIS);
            this.aIS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View FN() {
        if (this.aIT == null) {
            this.aIT = new FrameLayout(this.aIP.getPageActivity());
        }
        if (this.aIS == null) {
            this.aIS = NoDataViewFactory.a(this.aIP.getPageActivity(), this.aIT, this.aIV, this.aIU, this.aIW);
        }
        this.aIS.setVisibility(0);
        if (this.aIX != null) {
            this.aIS.setLayoutParams(this.aIX);
        }
        this.aIT.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aIS.onChangeSkinType(this.aIP, TbadkCoreApplication.getInst().getSkinType());
        return this.aIT;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aIV = cVar;
        this.aIU = dVar;
        this.aIW = bVar;
        this.aIX = layoutParams;
        if (this.aIS != null) {
            this.aIS.setTextOption(dVar);
            this.aIS.setImgOption(cVar);
            this.aIS.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aIS.setLayoutParams(layoutParams);
            }
        }
    }

    public void bQ(boolean z) {
        this.aIR = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean FO() {
        return this.Xp != null && this.Xp.size() == 0;
    }
}

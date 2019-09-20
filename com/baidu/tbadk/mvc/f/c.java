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
    protected List<D> bHV;
    private NoDataViewFactory.d cAa;
    private NoDataViewFactory.c cAb;
    private NoDataViewFactory.b cAc;
    private FrameLayout.LayoutParams cAd;
    protected final TbPageContext<?> czV;
    protected final ViewEventCenter czW;
    private NoDataView czY;
    private FrameLayout czZ;
    protected S czk;
    protected final List<H> czT = new ArrayList();
    protected final SparseArray<H> czU = new SparseArray<>();
    protected boolean czX = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.czV = tbPageContext;
        this.czW = viewEventCenter;
    }

    public void ak(List<D> list) {
        if (list != null) {
            if (this.bHV == null) {
                this.bHV = new ArrayList();
            }
            this.bHV.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void ad(D d) {
        if (d != null && this.bHV != null) {
            this.bHV.remove(d);
            notifyDataSetChanged();
        }
    }

    public void al(List<D> list) {
        am(list);
        notifyDataSetChanged();
    }

    public void ae(D d) {
        H h;
        if (d != null && this.bHV != null && this.bHV.contains(d) && (h = this.czU.get(this.bHV.indexOf(d))) != null) {
            h.af(d);
        }
    }

    protected void am(List<D> list) {
        if (list != null) {
            if (this.bHV == null) {
                this.bHV = new ArrayList();
            }
            this.bHV.clear();
            this.bHV.addAll(list);
            this.czU.clear();
        }
    }

    public List<D> getDataList() {
        return this.bHV == null ? new ArrayList() : new ArrayList(this.bHV);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bHV == null) {
            return 0;
        }
        if (this.bHV.size() == 0 && this.czX) {
            return 1;
        }
        return this.bHV.size();
    }

    public int avc() {
        if (this.bHV == null) {
            return 0;
        }
        return this.bHV.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        if (this.bHV != null && this.bHV.size() != 0 && i >= 0 && i < this.bHV.size()) {
            return this.bHV.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bHV != null && this.bHV.size() != 0 && i >= 0 && i < this.bHV.size()) {
            return i;
        }
        return 0L;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        int size = this.czT.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.czT.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.czY != null) {
            this.czY.onChangeSkinType(this.czV, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.czU.indexOfValue(a) >= 0) {
            this.czU.remove(a.getPosition());
        }
        this.czU.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.czV.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.czV, inflate, this.czW);
                h.b(this.czV, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h);
                this.czT.add(h);
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
            h.a(item, this.czk);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avd() {
        if (this.czZ != null && this.czY != null) {
            this.czZ.removeView(this.czY);
            this.czY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View ave() {
        if (this.czZ == null) {
            this.czZ = new FrameLayout(this.czV.getPageActivity());
        }
        if (this.czY == null) {
            this.czY = NoDataViewFactory.a(this.czV.getPageActivity(), this.czZ, this.cAb, this.cAa, this.cAc);
        }
        this.czY.setVisibility(0);
        if (this.cAd != null) {
            this.czY.setLayoutParams(this.cAd);
        }
        this.czZ.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.czY.onChangeSkinType(this.czV, TbadkCoreApplication.getInst().getSkinType());
        return this.czZ;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.cAb = cVar;
        this.cAa = dVar;
        this.cAc = bVar;
        this.cAd = layoutParams;
        if (this.czY != null) {
            this.czY.setTextOption(dVar);
            this.czY.setImgOption(cVar);
            this.czY.setButtonOption(bVar);
            if (layoutParams != null) {
                this.czY.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean avf() {
        return this.bHV != null && this.bHV.size() == 0;
    }
}

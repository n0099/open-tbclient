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
    protected final TbPageContext<?> aEU;
    protected final ViewEventCenter aEV;
    private y aEX;
    private FrameLayout aEY;
    private NoDataViewFactory.d aEZ;
    protected S aEf;
    private NoDataViewFactory.c aFa;
    private NoDataViewFactory.b aFb;
    private FrameLayout.LayoutParams aFc;
    protected final List<H> aES = new ArrayList();
    protected final SparseArray<H> aET = new SparseArray<>();
    protected boolean aEW = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aEU = tbPageContext;
        this.aEV = viewEventCenter;
    }

    public void w(List<D> list) {
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

    public void x(List<D> list) {
        y(list);
        notifyDataSetChanged();
    }

    public void D(D d) {
        H h;
        if (d != null && this.VR != null && this.VR.contains(d) && (h = this.aET.get(this.VR.indexOf(d))) != null) {
            h.E(d);
        }
    }

    protected void y(List<D> list) {
        if (list != null) {
            if (this.VR == null) {
                this.VR = new ArrayList();
            }
            this.VR.clear();
            this.VR.addAll(list);
            this.aET.clear();
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
        if (this.VR.size() == 0 && this.aEW) {
            return 1;
        }
        return this.VR.size();
    }

    public int EO() {
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
        int size = this.aES.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h = this.aES.get(i2);
            if (h != null) {
                h.b(tbPageContext, i);
            }
        }
        if (this.aEX != null) {
            this.aEX.onChangeSkinType(this.aEU, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View a(View view, int i, Class<?> cls, int i2) {
        H a = a(view, cls, i2);
        if (this.aET.indexOfValue(a) >= 0) {
            this.aET.remove(a.getPosition());
        }
        this.aET.put(i, a);
        a(a, i);
        return a.getRootView();
    }

    private final H a(View view, Class<?> cls, int i) {
        if (view == null || view.getTag() == null) {
            View inflate = this.aEU.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.aEU, inflate, this.aEV);
                h.b(this.aEU, TbadkCoreApplication.m9getInst().getSkinType());
                inflate.setTag(h);
                this.aES.add(h);
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
            h.a(item, this.aEf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EP() {
        if (this.aEY != null && this.aEX != null) {
            this.aEY.removeView(this.aEX);
            this.aEX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View EQ() {
        if (this.aEY == null) {
            this.aEY = new FrameLayout(this.aEU.getPageActivity());
        }
        if (this.aEX == null) {
            this.aEX = NoDataViewFactory.a(this.aEU.getPageActivity(), this.aEY, this.aFa, this.aEZ, this.aFb);
        }
        this.aEX.setVisibility(0);
        if (this.aFc != null) {
            this.aEX.setLayoutParams(this.aFc);
        }
        this.aEY.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.aEX.onChangeSkinType(this.aEU, TbadkCoreApplication.m9getInst().getSkinType());
        return this.aEY;
    }

    public void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar, FrameLayout.LayoutParams layoutParams) {
        this.aFa = cVar;
        this.aEZ = dVar;
        this.aFb = bVar;
        this.aFc = layoutParams;
        if (this.aEX != null) {
            this.aEX.setTextOption(dVar);
            this.aEX.setImgOption(cVar);
            this.aEX.setButtonOption(bVar);
            if (layoutParams != null) {
                this.aEX.setLayoutParams(layoutParams);
            }
        }
    }

    public void bS(boolean z) {
        this.aEW = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ER() {
        return this.VR != null && this.VR.size() == 0;
    }
}

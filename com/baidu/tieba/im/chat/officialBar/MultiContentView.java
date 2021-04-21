package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.e.k.b;
import d.b.j0.e1.f.j.c;
import d.b.j0.e1.l.c.a;
import java.util.List;
/* loaded from: classes4.dex */
public class MultiContentView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17476e;

    /* renamed from: f  reason: collision with root package name */
    public View f17477f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f17478g;

    /* renamed from: h  reason: collision with root package name */
    public b<MultiImageTextTopView> f17479h;
    public b<MultiImageTextBottomView> i;
    public b<SingleImageTextView> j;
    public d.b.c.e.h.b k;
    public int l;
    public boolean m;
    public String n;
    public int o;

    /* loaded from: classes4.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view2 instanceof MultiImageTextTopView) {
                MultiContentView.this.f17479h.e((MultiImageTextTopView) view2);
            } else if (view2 instanceof MultiImageTextBottomView) {
                MultiContentView.this.i.e((MultiImageTextBottomView) view2);
            } else if (view2 instanceof SingleImageTextView) {
                MultiContentView.this.j.e((SingleImageTextView) view2);
            }
        }
    }

    public MultiContentView(Context context) {
        super(context);
        this.k = null;
        this.m = true;
        this.o = 2;
        this.f17476e = context;
        g();
    }

    private MultiImageTextBottomView getBottomView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!this.m) {
            skinType = 0;
        }
        int i = this.o;
        if (i == 2) {
            SkinManager.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_bottom_bg, skinType);
        } else if (i == 1) {
            SkinManager.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.g(this.m);
        return commonBottomView;
    }

    private MultiImageTextBottomView getCommonBottomView() {
        b<MultiImageTextBottomView> bVar = this.i;
        MultiImageTextBottomView b2 = bVar != null ? bVar.b() : null;
        if (b2 == null || b2.getParent() != null) {
            b2 = new MultiImageTextBottomView(this.f17476e);
        }
        b2.setOnItemViewLongClickListener(this.k);
        b2.setPosition(this.l);
        return b2;
    }

    private MultiImageTextBottomView getMidView() {
        MultiImageTextBottomView commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!this.m) {
            skinType = 0;
        }
        int i = this.o;
        if (i == 2) {
            SkinManager.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_mid_bg, skinType);
        } else if (i == 1) {
            SkinManager.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.g(this.m);
        return commonBottomView;
    }

    private SingleImageTextView getSingleView() {
        b<SingleImageTextView> bVar = this.j;
        SingleImageTextView b2 = bVar != null ? bVar.b() : null;
        if (b2 == null || b2.getParent() == null) {
            b2 = new SingleImageTextView(this.f17476e);
        }
        b2.setOnItemViewLongClickListener(this.k);
        b2.setPosition(this.l);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!this.m) {
            skinType = 0;
        }
        int i = this.o;
        if (i == 2) {
            SkinManager.setBackgroundResource(b2, R.drawable.selector_history_multi_single_bg, skinType);
        } else if (i == 1) {
            SkinManager.setBackgroundResource(b2, R.drawable.selector_history_multi_single_bg, skinType);
        }
        b2.f(this.m);
        return b2;
    }

    private MultiImageTextTopView getTopView() {
        b<MultiImageTextTopView> bVar = this.f17479h;
        MultiImageTextTopView b2 = bVar != null ? bVar.b() : null;
        if (b2 == null || b2.getParent() != null) {
            b2 = new MultiImageTextTopView(this.f17476e);
        }
        b2.setOnItemViewLongClickListener(this.k);
        b2.setPosition(this.l);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!this.m) {
            skinType = 0;
        }
        int i = this.o;
        if (i == 2) {
            SkinManager.setBackgroundResource(b2, R.drawable.selector_history_multi_top_bg, skinType);
        } else if (i == 1) {
            SkinManager.setBackgroundResource(b2, R.drawable.selector_history_multi_top_bg, skinType);
        }
        b2.e(this.m);
        return b2;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.f17478g.addView(view);
    }

    public final void d(TbPageContext<?> tbPageContext, a.C1289a c1289a, MultiImageTextBottomView multiImageTextBottomView, View view) {
        if (c1289a == null || multiImageTextBottomView == null) {
            return;
        }
        multiImageTextBottomView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.f17476e.getResources().getDimension(R.dimen.ds132)));
        multiImageTextBottomView.setData(tbPageContext, c1289a, view, this.o);
        this.f17478g.addView(multiImageTextBottomView);
    }

    public final void e(TbPageContext<?> tbPageContext, a.C1289a c1289a, SingleImageTextView singleImageTextView, View view) {
        if (c1289a == null || singleImageTextView == null) {
            return;
        }
        singleImageTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        singleImageTextView.setTime(this.n);
        singleImageTextView.setData(tbPageContext, c1289a, view, this.o);
        this.f17478g.addView(singleImageTextView);
    }

    public final void f(TbPageContext<?> tbPageContext, a.C1289a c1289a, MultiImageTextTopView multiImageTextTopView, View view) {
        if (c1289a == null || multiImageTextTopView == null) {
            return;
        }
        multiImageTextTopView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        multiImageTextTopView.setTime(this.n);
        multiImageTextTopView.setData(tbPageContext, c1289a, view, this.o);
        this.f17478g.addView(multiImageTextTopView);
    }

    public final void g() {
        View inflate = View.inflate(this.f17476e, R.layout.msg_multi_pic_text_content_view, this);
        this.f17477f = inflate;
        this.f17478g = (LinearLayout) inflate.findViewById(R.id.view_container);
        c cVar = new c();
        this.f17479h = cVar.f(this.f17476e);
        this.i = cVar.d(this.f17476e);
        this.j = cVar.e(this.f17476e);
        this.f17478g.setOnHierarchyChangeListener(new a());
    }

    public void setData(TbPageContext<?> tbPageContext, List<a.C1289a> list, View view) {
        this.f17478g.removeAllViews();
        if (list == null || list.size() == 0) {
            return;
        }
        int size = list.size();
        if (size == 1) {
            e(tbPageContext, list.get(0), getSingleView(), view);
            return;
        }
        String str = "";
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                if (list.get(i) != null) {
                    str = list.get(i).f55855f;
                }
                f(tbPageContext, list.get(i), getTopView(), view);
            } else if (i == size - 1) {
                MultiImageTextBottomView bottomView = getBottomView();
                if (bottomView != null) {
                    bottomView.setStPosition(i);
                    bottomView.setTaskInfo(str);
                }
                d(tbPageContext, list.get(i), bottomView, view);
            } else {
                MultiImageTextBottomView midView = getMidView();
                if (midView != null) {
                    midView.setStPosition(i);
                    midView.setTaskInfo(str);
                }
                d(tbPageContext, list.get(i), midView, view);
            }
        }
    }

    public void setNeedNightMode(boolean z) {
        this.m = z;
    }

    public void setOnItemViewLongClickListener(d.b.c.e.h.b bVar) {
        this.k = bVar;
    }

    public void setPosition(int i) {
        this.l = i;
    }

    public void setTime(String str) {
        this.n = str;
    }

    public void setType(int i) {
        this.o = i;
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = null;
        this.m = true;
        this.o = 2;
        this.f17476e = context;
        g();
    }
}

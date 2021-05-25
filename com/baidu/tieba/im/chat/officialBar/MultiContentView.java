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
import d.a.c.e.k.b;
import d.a.n0.f1.f.j.c;
import d.a.n0.f1.l.c.a;
import java.util.List;
/* loaded from: classes4.dex */
public class MultiContentView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17011e;

    /* renamed from: f  reason: collision with root package name */
    public View f17012f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f17013g;

    /* renamed from: h  reason: collision with root package name */
    public b<MultiImageTextTopView> f17014h;

    /* renamed from: i  reason: collision with root package name */
    public b<MultiImageTextBottomView> f17015i;
    public b<SingleImageTextView> j;
    public d.a.c.e.h.b k;
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
                MultiContentView.this.f17014h.e((MultiImageTextTopView) view2);
            } else if (view2 instanceof MultiImageTextBottomView) {
                MultiContentView.this.f17015i.e((MultiImageTextBottomView) view2);
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
        this.f17011e = context;
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
        int i2 = this.o;
        if (i2 == 2) {
            SkinManager.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_bottom_bg, skinType);
        } else if (i2 == 1) {
            SkinManager.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_bottom_bg, skinType);
        }
        commonBottomView.g(this.m);
        return commonBottomView;
    }

    private MultiImageTextBottomView getCommonBottomView() {
        b<MultiImageTextBottomView> bVar = this.f17015i;
        MultiImageTextBottomView b2 = bVar != null ? bVar.b() : null;
        if (b2 == null || b2.getParent() != null) {
            b2 = new MultiImageTextBottomView(this.f17011e);
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
        int i2 = this.o;
        if (i2 == 2) {
            SkinManager.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_mid_bg, skinType);
        } else if (i2 == 1) {
            SkinManager.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_mid_bg, skinType);
        }
        commonBottomView.g(this.m);
        return commonBottomView;
    }

    private SingleImageTextView getSingleView() {
        b<SingleImageTextView> bVar = this.j;
        SingleImageTextView b2 = bVar != null ? bVar.b() : null;
        if (b2 == null || b2.getParent() == null) {
            b2 = new SingleImageTextView(this.f17011e);
        }
        b2.setOnItemViewLongClickListener(this.k);
        b2.setPosition(this.l);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!this.m) {
            skinType = 0;
        }
        int i2 = this.o;
        if (i2 == 2) {
            SkinManager.setBackgroundResource(b2, R.drawable.selector_history_multi_single_bg, skinType);
        } else if (i2 == 1) {
            SkinManager.setBackgroundResource(b2, R.drawable.selector_history_multi_single_bg, skinType);
        }
        b2.f(this.m);
        return b2;
    }

    private MultiImageTextTopView getTopView() {
        b<MultiImageTextTopView> bVar = this.f17014h;
        MultiImageTextTopView b2 = bVar != null ? bVar.b() : null;
        if (b2 == null || b2.getParent() != null) {
            b2 = new MultiImageTextTopView(this.f17011e);
        }
        b2.setOnItemViewLongClickListener(this.k);
        b2.setPosition(this.l);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!this.m) {
            skinType = 0;
        }
        int i2 = this.o;
        if (i2 == 2) {
            SkinManager.setBackgroundResource(b2, R.drawable.selector_history_multi_top_bg, skinType);
        } else if (i2 == 1) {
            SkinManager.setBackgroundResource(b2, R.drawable.selector_history_multi_top_bg, skinType);
        }
        b2.e(this.m);
        return b2;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.f17013g.addView(view);
    }

    public final void d(TbPageContext<?> tbPageContext, a.C1318a c1318a, MultiImageTextBottomView multiImageTextBottomView, View view) {
        if (c1318a == null || multiImageTextBottomView == null) {
            return;
        }
        multiImageTextBottomView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.f17011e.getResources().getDimension(R.dimen.ds132)));
        multiImageTextBottomView.setData(tbPageContext, c1318a, view, this.o);
        this.f17013g.addView(multiImageTextBottomView);
    }

    public final void e(TbPageContext<?> tbPageContext, a.C1318a c1318a, SingleImageTextView singleImageTextView, View view) {
        if (c1318a == null || singleImageTextView == null) {
            return;
        }
        singleImageTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        singleImageTextView.setTime(this.n);
        singleImageTextView.setData(tbPageContext, c1318a, view, this.o);
        this.f17013g.addView(singleImageTextView);
    }

    public final void f(TbPageContext<?> tbPageContext, a.C1318a c1318a, MultiImageTextTopView multiImageTextTopView, View view) {
        if (c1318a == null || multiImageTextTopView == null) {
            return;
        }
        multiImageTextTopView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        multiImageTextTopView.setTime(this.n);
        multiImageTextTopView.setData(tbPageContext, c1318a, view, this.o);
        this.f17013g.addView(multiImageTextTopView);
    }

    public final void g() {
        View inflate = View.inflate(this.f17011e, R.layout.msg_multi_pic_text_content_view, this);
        this.f17012f = inflate;
        this.f17013g = (LinearLayout) inflate.findViewById(R.id.view_container);
        c cVar = new c();
        this.f17014h = cVar.f(this.f17011e);
        this.f17015i = cVar.d(this.f17011e);
        this.j = cVar.e(this.f17011e);
        this.f17013g.setOnHierarchyChangeListener(new a());
    }

    public void setData(TbPageContext<?> tbPageContext, List<a.C1318a> list, View view) {
        this.f17013g.removeAllViews();
        if (list == null || list.size() == 0) {
            return;
        }
        int size = list.size();
        if (size == 1) {
            e(tbPageContext, list.get(0), getSingleView(), view);
            return;
        }
        String str = "";
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 == 0) {
                if (list.get(i2) != null) {
                    str = list.get(i2).f54612f;
                }
                f(tbPageContext, list.get(i2), getTopView(), view);
            } else if (i2 == size - 1) {
                MultiImageTextBottomView bottomView = getBottomView();
                if (bottomView != null) {
                    bottomView.setStPosition(i2);
                    bottomView.setTaskInfo(str);
                }
                d(tbPageContext, list.get(i2), bottomView, view);
            } else {
                MultiImageTextBottomView midView = getMidView();
                if (midView != null) {
                    midView.setStPosition(i2);
                    midView.setTaskInfo(str);
                }
                d(tbPageContext, list.get(i2), midView, view);
            }
        }
    }

    public void setNeedNightMode(boolean z) {
        this.m = z;
    }

    public void setOnItemViewLongClickListener(d.a.c.e.h.b bVar) {
        this.k = bVar;
    }

    public void setPosition(int i2) {
        this.l = i2;
    }

    public void setTime(String str) {
        this.n = str;
    }

    public void setType(int i2) {
        this.o = i2;
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = null;
        this.m = true;
        this.o = 2;
        this.f17011e = context;
        g();
    }
}

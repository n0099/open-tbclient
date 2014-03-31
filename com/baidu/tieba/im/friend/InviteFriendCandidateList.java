package com.baidu.tieba.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalScrollView {
    private Context a;
    private LinearLayout b;
    private int c;
    private int d;
    private int e;
    private com.baidu.tbadk.editortool.aa f;
    private int g;
    private HeadImageView h;
    private m i;
    private View.OnClickListener j;

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.g = 4;
        this.j = new l(this);
        this.a = context;
        c();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.g = 4;
        this.j = new l(this);
        this.a = context;
        c();
    }

    public final void a(int i) {
        this.g = i;
    }

    public final void a(m mVar) {
        this.i = mVar;
    }

    private void c() {
        this.c = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.invite_friend_candidate_item_width);
        this.d = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.invite_friend_candidate_item_height);
        this.e = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.invite_friend_candidate_item_margin);
        this.b = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.b.setLayoutParams(layoutParams);
        this.b.setHorizontalScrollBarEnabled(true);
        this.b.setOrientation(0);
        d();
        addView(this.b);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.h == null) {
            this.h = g();
            this.h.setDrawBorder(false);
        }
        this.h.setImageBitmap(com.baidu.tbadk.core.util.g.a(f() ? com.baidu.tieba.im.g.icon_add_pop_1 : com.baidu.tieba.im.g.icon_add_pop));
        this.b.addView(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        int childCount = this.b.getChildCount();
        return childCount > 0 && this.b.getChildAt(childCount + (-1)) == this.h;
    }

    public final void a(com.baidu.tbadk.editortool.aa aaVar) {
        this.f = aaVar;
    }

    public final void a(com.baidu.tieba.im.data.c cVar) {
        if (b() < this.g) {
            HeadImageView g = g();
            g.setIsRound(true);
            if (this.f != null) {
                com.baidu.tbadk.editortool.aa aaVar = this.f;
                com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(cVar.c());
                if (b != null) {
                    b.a(g);
                } else {
                    g.setTag(cVar.c());
                    g.setImageBitmap(com.baidu.tbadk.core.util.g.a(f() ? com.baidu.tieba.im.g.icon_add_pop_1 : com.baidu.tieba.im.g.icon_add_pop));
                }
            }
            if (e()) {
                g.setTag(cVar);
                g.setOnClickListener(this.j);
                this.b.addView(g, b());
                scrollTo(b() * (this.c + this.e), 0);
            }
            if (b() < this.g || !e()) {
                return;
            }
            this.b.removeView(this.h);
        }
    }

    public final boolean b(com.baidu.tieba.im.data.c cVar) {
        Object tag;
        int childCount = this.b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.b.getChildAt(i);
            if (childAt != this.h && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tieba.im.data.c) && ((com.baidu.tieba.im.data.c) tag).a(cVar)) {
                cVar.setChecked(true);
                childAt.setTag(cVar);
                return true;
            }
        }
        return false;
    }

    public final String a() {
        Object tag;
        int childCount = this.b.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.b.getChildAt(i);
            if (childAt != this.h && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tieba.im.data.c)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tieba.im.data.c) tag).a());
            }
        }
        return sb.toString();
    }

    private static boolean f() {
        return TbadkApplication.j().l() == 1;
    }

    public final void c(com.baidu.tieba.im.data.c cVar) {
        View findViewWithTag = this.b.findViewWithTag(cVar);
        if (findViewWithTag != null) {
            this.b.removeView(findViewWithTag);
            if (!e()) {
                d();
            }
        }
    }

    private HeadImageView g() {
        HeadImageView headImageView = new HeadImageView(this.a);
        headImageView.setIsRound(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.c, this.d);
        layoutParams.setMargins(this.e, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public final int b() {
        return e() ? this.b.getChildCount() - 1 : this.b.getChildCount();
    }
}

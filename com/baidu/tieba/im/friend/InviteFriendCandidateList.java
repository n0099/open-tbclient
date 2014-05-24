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
    private com.baidu.tbadk.editortool.ab f;
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

    public void a(int i) {
        this.g = i;
    }

    public void a(m mVar) {
        this.i = mVar;
    }

    private void c() {
        this.c = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_width);
        this.d = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height);
        this.e = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_margin);
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
            this.h = h();
            this.h.setDrawBorder(false);
        }
        this.h.setImageBitmap(com.baidu.tbadk.core.util.g.a(g() ? com.baidu.tieba.u.icon_add_pop_1 : com.baidu.tieba.u.icon_add_pop));
        this.b.addView(this.h);
    }

    private void e() {
        if (f()) {
            this.b.removeView(this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        int childCount = this.b.getChildCount();
        return childCount > 0 && this.b.getChildAt(childCount + (-1)) == this.h;
    }

    public void a(com.baidu.tbadk.editortool.ab abVar) {
        this.f = abVar;
    }

    public void a(com.baidu.tieba.im.data.e eVar) {
        if (b() < this.g) {
            HeadImageView h = h();
            h.setIsRound(true);
            if (this.f != null) {
                com.baidu.adp.widget.a.a c = this.f.c(eVar.c());
                if (c != null) {
                    c.a(h);
                } else {
                    h.setTag(eVar.c());
                    h.setImageBitmap(com.baidu.tbadk.core.util.g.a(g() ? com.baidu.tieba.u.icon_add_pop_1 : com.baidu.tieba.u.icon_add_pop));
                }
            }
            if (f()) {
                h.setTag(eVar);
                h.setOnClickListener(this.j);
                this.b.addView(h, b());
                scrollTo(b() * (this.c + this.e), 0);
            }
            if (b() >= this.g) {
                e();
            }
        }
    }

    public boolean b(com.baidu.tieba.im.data.e eVar) {
        Object tag;
        int childCount = this.b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.b.getChildAt(i);
            if (childAt != this.h && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tieba.im.data.e) && ((com.baidu.tieba.im.data.e) tag).a(eVar)) {
                eVar.setChecked(true);
                childAt.setTag(eVar);
                return true;
            }
        }
        return false;
    }

    public String a() {
        Object tag;
        int childCount = this.b.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.b.getChildAt(i);
            if (childAt != this.h && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tieba.im.data.e)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tieba.im.data.e) tag).a());
            }
        }
        return sb.toString();
    }

    private boolean g() {
        return TbadkApplication.m252getInst().getSkinType() == 1;
    }

    public void c(com.baidu.tieba.im.data.e eVar) {
        View findViewWithTag = this.b.findViewWithTag(eVar);
        if (findViewWithTag != null) {
            this.b.removeView(findViewWithTag);
            if (!f()) {
                d();
            }
        }
    }

    private HeadImageView h() {
        HeadImageView headImageView = new HeadImageView(this.a);
        headImageView.setIsRound(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.c, this.d);
        layoutParams.setMargins(this.e, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int b() {
        return f() ? this.b.getChildCount() - 1 : this.b.getChildCount();
    }
}

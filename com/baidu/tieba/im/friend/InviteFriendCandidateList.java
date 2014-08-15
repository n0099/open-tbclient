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
    private int f;
    private HeadImageView g;
    private j h;
    private View.OnClickListener i;

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = 4;
        this.i = new i(this);
        this.a = context;
        c();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = 4;
        this.i = new i(this);
        this.a = context;
        c();
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(j jVar) {
        this.h = jVar;
    }

    private void c() {
        this.c = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.invite_friend_candidate_item_width);
        this.d = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.invite_friend_candidate_item_height);
        this.e = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.invite_friend_candidate_item_margin);
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
        if (this.g == null) {
            this.g = h();
            this.g.setDrawBorder(false);
        }
        this.g.setImageBitmap(com.baidu.tbadk.core.util.d.a(g() ? com.baidu.tieba.t.icon_add_pop_1 : com.baidu.tieba.t.icon_add_pop));
        this.b.addView(this.g);
    }

    private void e() {
        if (f()) {
            this.b.removeView(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        int childCount = this.b.getChildCount();
        return childCount > 0 && this.b.getChildAt(childCount + (-1)) == this.g;
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (b() < this.f) {
            HeadImageView h = h();
            h.setIsRound(false);
            h.a(bVar.d(), 12, false);
            if (f()) {
                h.setTag(bVar);
                h.setOnClickListener(this.i);
                this.b.addView(h, b());
                scrollTo(b() * (this.c + this.e), 0);
            }
            if (b() >= this.f) {
                e();
            }
        }
    }

    public boolean b(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        Object tag;
        int childCount = this.b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.b.getChildAt(i);
            if (childAt != this.g && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.b) && ((com.baidu.tbadk.coreExtra.relationship.b) tag).equals(bVar)) {
                bVar.setChecked(true);
                childAt.setTag(bVar);
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
            if (childAt != this.g && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.b)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.b) tag).c());
            }
        }
        return sb.toString();
    }

    private boolean g() {
        return TbadkApplication.m252getInst().getSkinType() == 1;
    }

    public void c(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        View findViewWithTag = this.b.findViewWithTag(bVar);
        if (findViewWithTag != null) {
            this.b.removeView(findViewWithTag);
            if (!f()) {
                d();
            }
        }
    }

    private HeadImageView h() {
        HeadImageView headImageView = new HeadImageView(this.a);
        headImageView.setIsRound(false);
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

package com.baidu.tieba.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalScrollView {
    private Context a;
    private LinearLayout b;
    private int c;
    private int d;
    private int e;
    private com.baidu.tieba.util.i f;
    private int g;
    private HeadImageView h;
    private j i;
    private View.OnClickListener j;

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.g = 4;
        this.j = new i(this);
        this.a = context;
        a();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.g = 4;
        this.j = new i(this);
        this.a = context;
        a();
    }

    public void setMaxCount(int i) {
        this.g = i;
    }

    public void setItemOPerationHandler(j jVar) {
        this.i = jVar;
    }

    private void a() {
        this.c = this.a.getResources().getDimensionPixelSize(R.dimen.invite_friend_candidate_item_width);
        this.d = this.a.getResources().getDimensionPixelSize(R.dimen.invite_friend_candidate_item_height);
        this.e = this.a.getResources().getDimensionPixelSize(R.dimen.invite_friend_candidate_item_margin);
        this.b = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.b.setLayoutParams(layoutParams);
        this.b.setHorizontalScrollBarEnabled(true);
        this.b.setOrientation(0);
        b();
        addView(this.b);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.h == null) {
            this.h = e();
            this.h.setDrawBorder(false);
        }
        this.h.setImageBitmap(com.baidu.tieba.util.n.a(d() ? R.drawable.icon_add_pop_1 : R.drawable.icon_add_pop));
        this.b.addView(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        int childCount = this.b.getChildCount();
        return childCount > 0 && this.b.getChildAt(childCount + (-1)) == this.h;
    }

    public void setImageLoader(com.baidu.tieba.util.i iVar) {
        this.f = iVar;
    }

    public final void a(com.baidu.tieba.im.data.d dVar) {
        if (getItemLength() < this.g) {
            HeadImageView e = e();
            e.setIsRound(true);
            if (this.f != null) {
                com.baidu.tieba.util.i iVar = this.f;
                com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(dVar.c());
                if (b != null) {
                    b.a(e);
                } else {
                    e.setTag(dVar.c());
                    e.setImageBitmap(com.baidu.tieba.util.n.a(d() ? R.drawable.icon_add_pop_1 : R.drawable.icon_add_pop));
                }
            }
            if (c()) {
                e.setTag(dVar);
                e.setOnClickListener(this.j);
                this.b.addView(e, getItemLength());
                scrollTo(getItemLength() * (this.c + this.e), 0);
            }
            if (getItemLength() < this.g || !c()) {
                return;
            }
            this.b.removeView(this.h);
        }
    }

    public final boolean b(com.baidu.tieba.im.data.d dVar) {
        Object tag;
        int childCount = this.b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.b.getChildAt(i);
            if (childAt != this.h && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tieba.im.data.d) && ((com.baidu.tieba.im.data.d) tag).a(dVar)) {
                dVar.setChecked(true);
                childAt.setTag(dVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.b.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.b.getChildAt(i);
            if (childAt != this.h && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tieba.im.data.d)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tieba.im.data.d) tag).a());
            }
        }
        return sb.toString();
    }

    private static boolean d() {
        return TiebaApplication.g().ae() == 1;
    }

    public final void c(com.baidu.tieba.im.data.d dVar) {
        View findViewWithTag = this.b.findViewWithTag(dVar);
        if (findViewWithTag != null) {
            this.b.removeView(findViewWithTag);
            if (!c()) {
                b();
            }
        }
    }

    private HeadImageView e() {
        HeadImageView headImageView = new HeadImageView(this.a);
        headImageView.setIsRound(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.c, this.d);
        layoutParams.setMargins(this.e, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return c() ? this.b.getChildCount() - 1 : this.b.getChildCount();
    }
}

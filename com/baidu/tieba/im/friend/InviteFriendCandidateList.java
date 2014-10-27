package com.baidu.tieba.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalScrollView {
    private int CG;
    private View.OnClickListener aGz;
    private int aVA;
    private int aVB;
    private int aVC;
    private HeadImageView aVD;
    private j aVE;
    private Context mContext;
    private LinearLayout mLayout;

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.CG = -1;
        this.aVA = -1;
        this.aVB = -1;
        this.aVC = 4;
        this.aGz = new i(this);
        this.mContext = context;
        ny();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.CG = -1;
        this.aVA = -1;
        this.aVB = -1;
        this.aVC = 4;
        this.aGz = new i(this);
        this.mContext = context;
        ny();
    }

    public void setMaxCount(int i) {
        this.aVC = i;
    }

    public void a(j jVar) {
        this.aVE = jVar;
    }

    private void ny() {
        this.CG = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_width);
        this.aVA = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height);
        this.aVB = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_margin);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        MW();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MW() {
        if (this.aVD == null) {
            this.aVD = Na();
            this.aVD.setDrawBorder(false);
        }
        this.aVD.setImageBitmap(aw.bA(com.baidu.tieba.u.icon_add_pop));
        this.mLayout.addView(this.aVD);
    }

    private void MX() {
        if (MY()) {
            this.mLayout.removeView(this.aVD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MY() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.aVD;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (getItemLength() < this.aVC) {
            HeadImageView Na = Na();
            Na.setIsRound(false);
            Na.c(bVar.getUserPortrait(), 12, false);
            if (MY()) {
                Na.setTag(bVar);
                Na.setOnClickListener(this.aGz);
                this.mLayout.addView(Na, getItemLength());
                scrollTo(getItemLength() * (this.CG + this.aVB), 0);
            }
            if (getItemLength() >= this.aVC) {
                MX();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.aVD && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.b) && ((com.baidu.tbadk.coreExtra.relationship.b) tag).equals(bVar)) {
                bVar.setChecked(true);
                childAt.setTag(bVar);
                return true;
            }
        }
        return false;
    }

    public String MZ() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.aVD && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.b)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.b) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        View findViewWithTag = this.mLayout.findViewWithTag(bVar);
        if (findViewWithTag != null) {
            this.mLayout.removeView(findViewWithTag);
            if (!MY()) {
                MW();
            }
        }
    }

    private HeadImageView Na() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.CG, this.aVA);
        layoutParams.setMargins(this.aVB, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return MY() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}

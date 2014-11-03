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
    private int CH;
    private View.OnClickListener aGJ;
    private int aVO;
    private int aVP;
    private int aVQ;
    private HeadImageView aVR;
    private j aVS;
    private Context mContext;
    private LinearLayout mLayout;

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.CH = -1;
        this.aVO = -1;
        this.aVP = -1;
        this.aVQ = 4;
        this.aGJ = new i(this);
        this.mContext = context;
        ny();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.CH = -1;
        this.aVO = -1;
        this.aVP = -1;
        this.aVQ = 4;
        this.aGJ = new i(this);
        this.mContext = context;
        ny();
    }

    public void setMaxCount(int i) {
        this.aVQ = i;
    }

    public void a(j jVar) {
        this.aVS = jVar;
    }

    private void ny() {
        this.CH = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_width);
        this.aVO = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height);
        this.aVP = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_margin);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        Na();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Na() {
        if (this.aVR == null) {
            this.aVR = Ne();
            this.aVR.setDrawBorder(false);
        }
        this.aVR.setImageBitmap(aw.bA(com.baidu.tieba.u.icon_add_pop));
        this.mLayout.addView(this.aVR);
    }

    private void Nb() {
        if (Nc()) {
            this.mLayout.removeView(this.aVR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Nc() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.aVR;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (getItemLength() < this.aVQ) {
            HeadImageView Ne = Ne();
            Ne.setIsRound(false);
            Ne.c(bVar.getUserPortrait(), 12, false);
            if (Nc()) {
                Ne.setTag(bVar);
                Ne.setOnClickListener(this.aGJ);
                this.mLayout.addView(Ne, getItemLength());
                scrollTo(getItemLength() * (this.CH + this.aVP), 0);
            }
            if (getItemLength() >= this.aVQ) {
                Nb();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.aVR && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.b) && ((com.baidu.tbadk.coreExtra.relationship.b) tag).equals(bVar)) {
                bVar.setChecked(true);
                childAt.setTag(bVar);
                return true;
            }
        }
        return false;
    }

    public String Nd() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.aVR && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.b)) {
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
            if (!Nc()) {
                Na();
            }
        }
    }

    private HeadImageView Ne() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.CH, this.aVO);
        layoutParams.setMargins(this.aVP, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return Nc() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}

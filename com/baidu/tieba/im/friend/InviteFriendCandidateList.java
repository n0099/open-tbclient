package com.baidu.tieba.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalScrollView {
    private int Hb;
    private View.OnClickListener bam;
    private int bbB;
    private int bbC;
    private int bbD;
    private HeadImageView bbE;
    private j bbF;
    private Context mContext;
    private LinearLayout mLayout;

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.Hb = -1;
        this.bbB = -1;
        this.bbC = -1;
        this.bbD = 4;
        this.bam = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hb = -1;
        this.bbB = -1;
        this.bbC = -1;
        this.bbD = 4;
        this.bam = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.bbD = i;
    }

    public void a(j jVar) {
        this.bbF = jVar;
    }

    private void initialize() {
        this.Hb = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_width);
        this.bbB = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_height);
        this.bbC = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_margin);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        OH();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OH() {
        if (this.bbE == null) {
            this.bbE = OL();
            this.bbE.setDrawBorder(false);
        }
        this.bbE.setImageBitmap(bc.ce(com.baidu.tieba.v.icon_add_pop));
        this.mLayout.addView(this.bbE);
    }

    private void OI() {
        if (OJ()) {
            this.mLayout.removeView(this.bbE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OJ() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.bbE;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (getItemLength() < this.bbD) {
            HeadImageView OL = OL();
            OL.setIsRound(false);
            OL.d(bVar.getUserPortrait(), 12, false);
            if (OJ()) {
                OL.setTag(bVar);
                OL.setOnClickListener(this.bam);
                this.mLayout.addView(OL, getItemLength());
                scrollTo(getItemLength() * (this.Hb + this.bbC), 0);
            }
            if (getItemLength() >= this.bbD) {
                OI();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.bbE && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.b) && ((com.baidu.tbadk.coreExtra.relationship.b) tag).equals(bVar)) {
                bVar.setChecked(true);
                childAt.setTag(bVar);
                return true;
            }
        }
        return false;
    }

    public String OK() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.bbE && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.b)) {
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
            if (!OJ()) {
                OH();
            }
        }
    }

    private HeadImageView OL() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Hb, this.bbB);
        layoutParams.setMargins(this.bbC, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return OJ() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}

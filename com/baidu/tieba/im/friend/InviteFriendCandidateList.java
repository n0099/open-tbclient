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
    private int GY;
    private View.OnClickListener bal;
    private int bbA;
    private int bbB;
    private int bbC;
    private HeadImageView bbD;
    private j bbE;
    private Context mContext;
    private LinearLayout mLayout;

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.GY = -1;
        this.bbA = -1;
        this.bbB = -1;
        this.bbC = 4;
        this.bal = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GY = -1;
        this.bbA = -1;
        this.bbB = -1;
        this.bbC = 4;
        this.bal = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.bbC = i;
    }

    public void a(j jVar) {
        this.bbE = jVar;
    }

    private void initialize() {
        this.GY = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_width);
        this.bbA = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_height);
        this.bbB = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_margin);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        OC();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OC() {
        if (this.bbD == null) {
            this.bbD = OG();
            this.bbD.setDrawBorder(false);
        }
        this.bbD.setImageBitmap(bc.ce(com.baidu.tieba.v.icon_add_pop));
        this.mLayout.addView(this.bbD);
    }

    private void OD() {
        if (OE()) {
            this.mLayout.removeView(this.bbD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OE() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.bbD;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (getItemLength() < this.bbC) {
            HeadImageView OG = OG();
            OG.setIsRound(false);
            OG.d(bVar.getUserPortrait(), 12, false);
            if (OE()) {
                OG.setTag(bVar);
                OG.setOnClickListener(this.bal);
                this.mLayout.addView(OG, getItemLength());
                scrollTo(getItemLength() * (this.GY + this.bbB), 0);
            }
            if (getItemLength() >= this.bbC) {
                OD();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.bbD && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.b) && ((com.baidu.tbadk.coreExtra.relationship.b) tag).equals(bVar)) {
                bVar.setChecked(true);
                childAt.setTag(bVar);
                return true;
            }
        }
        return false;
    }

    public String OF() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.bbD && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.b)) {
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
            if (!OE()) {
                OC();
            }
        }
    }

    private HeadImageView OG() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.GY, this.bbA);
        layoutParams.setMargins(this.bbB, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return OE() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}

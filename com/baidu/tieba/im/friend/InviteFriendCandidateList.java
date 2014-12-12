package com.baidu.tieba.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalScrollView {
    private int GS;
    private View.OnClickListener aYQ;
    private int bae;
    private int baf;
    private int bag;
    private HeadImageView bah;
    private j bai;
    private Context mContext;
    private LinearLayout mLayout;

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.GS = -1;
        this.bae = -1;
        this.baf = -1;
        this.bag = 4;
        this.aYQ = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GS = -1;
        this.bae = -1;
        this.baf = -1;
        this.bag = 4;
        this.aYQ = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.bag = i;
    }

    public void a(j jVar) {
        this.bai = jVar;
    }

    private void initialize() {
        this.GS = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_width);
        this.bae = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_height);
        this.baf = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_margin);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        Ol();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ol() {
        if (this.bah == null) {
            this.bah = Op();
            this.bah.setDrawBorder(false);
        }
        this.bah.setImageBitmap(ax.bX(com.baidu.tieba.v.icon_add_pop));
        this.mLayout.addView(this.bah);
    }

    private void Om() {
        if (On()) {
            this.mLayout.removeView(this.bah);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean On() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.bah;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (getItemLength() < this.bag) {
            HeadImageView Op = Op();
            Op.setIsRound(false);
            Op.d(bVar.getUserPortrait(), 12, false);
            if (On()) {
                Op.setTag(bVar);
                Op.setOnClickListener(this.aYQ);
                this.mLayout.addView(Op, getItemLength());
                scrollTo(getItemLength() * (this.GS + this.baf), 0);
            }
            if (getItemLength() >= this.bag) {
                Om();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.bah && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.b) && ((com.baidu.tbadk.coreExtra.relationship.b) tag).equals(bVar)) {
                bVar.setChecked(true);
                childAt.setTag(bVar);
                return true;
            }
        }
        return false;
    }

    public String Oo() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.bah && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.b)) {
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
            if (!On()) {
                Ol();
            }
        }
    }

    private HeadImageView Op() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.GS, this.bae);
        layoutParams.setMargins(this.baf, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return On() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}

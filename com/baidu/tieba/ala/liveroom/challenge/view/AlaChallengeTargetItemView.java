package com.baidu.tieba.ala.liveroom.challenge.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class AlaChallengeTargetItemView extends RelativeLayout implements View.OnClickListener {
    private HeadImageView aEh;
    private AlaChallengeTargetItemActionView gNA;
    private GradientDrawable gNB;
    private a gNC;
    private View gNy;
    private View gNz;
    private TextView gtr;
    private TextView gts;

    /* loaded from: classes4.dex */
    public interface a {
        void bUH();

        void bUI();
    }

    public AlaChallengeTargetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gNC = aVar;
    }

    public void setData(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.aEh.startLoad(dVar.portrait, 12, false, false);
            this.gtr.setText(!TextUtils.isEmpty(dVar.userName) ? Html.fromHtml(dVar.userName) : "");
            this.gts.setText(getResources().getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
            if (dVar.liveStatus == 1) {
                this.gNz.setBackgroundDrawable(getLivingAnimDrawable());
                if (dVar.aGk == 2) {
                    this.gNA.setStyle(2);
                    return;
                } else if (dVar.aGl == 1) {
                    this.gNA.setStyle(4);
                    return;
                } else {
                    this.gNA.setStyle(1);
                    return;
                }
            }
            this.gNz.setBackgroundColor(0);
            this.gNA.setStyle(3);
        }
    }

    public void setActionEnabled(boolean z) {
        if (this.gNA != null) {
            this.gNA.setEnabled(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gNC != null) {
            if (view == this.gNy) {
                this.gNC.bUH();
            } else if (view == this.gNA) {
                this.gNC.bUI();
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, getResources().getDimensionPixelOffset(a.e.sdk_ds24), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_target_item, (ViewGroup) this, true);
        this.gNy = findViewById(a.g.layout_challenge_latest_item_avatar);
        this.gNz = findViewById(a.g.anim_challenge_latest_item_avatar);
        this.aEh = (HeadImageView) findViewById(a.g.iv_challenge_latest_item_avatar);
        this.gtr = (TextView) findViewById(a.g.tv_challenge_latest_item_name);
        this.gts = (TextView) findViewById(a.g.tv_challenge_latest_item_value);
        this.gNA = (AlaChallengeTargetItemActionView) findViewById(a.g.tv_challenge_latest_item_action);
        this.aEh.setAutoChangeStyle(false);
        this.aEh.setDrawBorder(false);
        this.aEh.setIsRound(true);
        this.gNy.setOnClickListener(this);
        this.gNA.setOnClickListener(this);
    }

    private Drawable getLivingAnimDrawable() {
        if (this.gNB == null) {
            this.gNB = new GradientDrawable();
            this.gNB.setShape(1);
            this.gNB.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_latest_primary));
        }
        return this.gNB;
    }
}

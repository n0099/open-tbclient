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
    private HeadImageView aDu;
    private TextView gIP;
    private TextView gIQ;
    private View heX;
    private View heY;
    private AlaChallengeTargetItemActionView heZ;
    private GradientDrawable hfa;
    private a hfb;

    /* loaded from: classes4.dex */
    public interface a {
        void bZB();

        void bZC();
    }

    public AlaChallengeTargetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.hfb = aVar;
    }

    public void setData(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.aDu.startLoad(dVar.portrait, 12, false, false);
            this.gIP.setText(!TextUtils.isEmpty(dVar.userName) ? Html.fromHtml(dVar.userName) : "");
            this.gIQ.setText(getResources().getString(a.h.sdk_charm_name, String.valueOf(dVar.charmCount)));
            if (dVar.liveStatus == 1) {
                this.heY.setBackgroundDrawable(getLivingAnimDrawable());
                if (dVar.aFx == 2) {
                    this.heZ.setStyle(2);
                    return;
                } else if (dVar.aFy == 1) {
                    this.heZ.setStyle(4);
                    return;
                } else {
                    this.heZ.setStyle(1);
                    return;
                }
            }
            this.heY.setBackgroundColor(0);
            this.heZ.setStyle(3);
        }
    }

    public void setActionEnabled(boolean z) {
        if (this.heZ != null) {
            this.heZ.setEnabled(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hfb != null) {
            if (view == this.heX) {
                this.hfb.bZB();
            } else if (view == this.heZ) {
                this.hfb.bZC();
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, getResources().getDimensionPixelOffset(a.d.sdk_ds24), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_target_item, (ViewGroup) this, true);
        this.heX = findViewById(a.f.layout_challenge_latest_item_avatar);
        this.heY = findViewById(a.f.anim_challenge_latest_item_avatar);
        this.aDu = (HeadImageView) findViewById(a.f.iv_challenge_latest_item_avatar);
        this.gIP = (TextView) findViewById(a.f.tv_challenge_latest_item_name);
        this.gIQ = (TextView) findViewById(a.f.tv_challenge_latest_item_value);
        this.heZ = (AlaChallengeTargetItemActionView) findViewById(a.f.tv_challenge_latest_item_action);
        this.aDu.setAutoChangeStyle(false);
        this.aDu.setDrawBorder(false);
        this.aDu.setIsRound(true);
        this.heX.setOnClickListener(this);
        this.heZ.setOnClickListener(this);
    }

    private Drawable getLivingAnimDrawable() {
        if (this.hfa == null) {
            this.hfa = new GradientDrawable();
            this.hfa.setShape(1);
            this.hfa.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_latest_primary));
        }
        return this.hfa;
    }
}

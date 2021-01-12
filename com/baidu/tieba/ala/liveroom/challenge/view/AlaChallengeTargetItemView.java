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
/* loaded from: classes10.dex */
public class AlaChallengeTargetItemView extends RelativeLayout implements View.OnClickListener {
    private HeadImageView aBE;
    private TextView beR;
    private TextView gZj;
    private View hvW;
    private View hvX;
    private AlaChallengeTargetItemActionView hvY;
    private GradientDrawable hvZ;
    private a hwa;

    /* loaded from: classes10.dex */
    public interface a {
        void ccw();

        void ccx();
    }

    public AlaChallengeTargetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.hwa = aVar;
    }

    public void setData(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.aBE.startLoad(dVar.portrait, 12, false, false);
            this.beR.setText(!TextUtils.isEmpty(dVar.userName) ? Html.fromHtml(dVar.userName) : "");
            this.gZj.setText(getResources().getString(a.h.sdk_charm_name, String.valueOf(dVar.charmCount)));
            if (dVar.liveStatus == 1) {
                this.hvX.setBackgroundDrawable(getLivingAnimDrawable());
                if (dVar.aDO == 2) {
                    this.hvY.setStyle(2);
                    return;
                } else if (dVar.aDP == 1) {
                    this.hvY.setStyle(4);
                    return;
                } else {
                    this.hvY.setStyle(1);
                    return;
                }
            }
            this.hvX.setBackgroundColor(0);
            this.hvY.setStyle(3);
        }
    }

    public void setActionEnabled(boolean z) {
        if (this.hvY != null) {
            this.hvY.setEnabled(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hwa != null) {
            if (view == this.hvW) {
                this.hwa.ccw();
            } else if (view == this.hvY) {
                this.hwa.ccx();
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, getResources().getDimensionPixelOffset(a.d.sdk_ds24), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_target_item, (ViewGroup) this, true);
        this.hvW = findViewById(a.f.layout_challenge_latest_item_avatar);
        this.hvX = findViewById(a.f.anim_challenge_latest_item_avatar);
        this.aBE = (HeadImageView) findViewById(a.f.iv_challenge_latest_item_avatar);
        this.beR = (TextView) findViewById(a.f.tv_challenge_latest_item_name);
        this.gZj = (TextView) findViewById(a.f.tv_challenge_latest_item_value);
        this.hvY = (AlaChallengeTargetItemActionView) findViewById(a.f.tv_challenge_latest_item_action);
        this.aBE.setAutoChangeStyle(false);
        this.aBE.setDrawBorder(false);
        this.aBE.setIsRound(true);
        this.hvW.setOnClickListener(this);
        this.hvY.setOnClickListener(this);
    }

    private Drawable getLivingAnimDrawable() {
        if (this.hvZ == null) {
            this.hvZ = new GradientDrawable();
            this.hvZ.setShape(1);
            this.hvZ.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_latest_primary));
        }
        return this.hvZ;
    }
}

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
/* loaded from: classes11.dex */
public class AlaChallengeTargetItemView extends RelativeLayout implements View.OnClickListener {
    private HeadImageView aDr;
    private TextView bhZ;
    private View hAg;
    private View hAh;
    private AlaChallengeTargetItemActionView hAi;
    private GradientDrawable hAj;
    private a hAk;
    private TextView hbT;

    /* loaded from: classes11.dex */
    public interface a {
        void cdr();

        void cds();
    }

    public AlaChallengeTargetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.hAk = aVar;
    }

    public void setData(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.aDr.startLoad(dVar.portrait, 12, false, false);
            this.bhZ.setText(!TextUtils.isEmpty(dVar.userName) ? Html.fromHtml(dVar.userName) : "");
            this.hbT.setText(getResources().getString(a.h.sdk_charm_name, String.valueOf(dVar.charmCount)));
            if (dVar.liveStatus == 1) {
                this.hAh.setBackgroundDrawable(getLivingAnimDrawable());
                if (dVar.aFB == 2) {
                    this.hAi.setStyle(2);
                    return;
                } else if (dVar.aFC == 1) {
                    this.hAi.setStyle(4);
                    return;
                } else {
                    this.hAi.setStyle(1);
                    return;
                }
            }
            this.hAh.setBackgroundColor(0);
            this.hAi.setStyle(3);
        }
    }

    public void setActionEnabled(boolean z) {
        if (this.hAi != null) {
            this.hAi.setEnabled(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hAk != null) {
            if (view == this.hAg) {
                this.hAk.cdr();
            } else if (view == this.hAi) {
                this.hAk.cds();
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, getResources().getDimensionPixelOffset(a.d.sdk_ds24), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_target_item, (ViewGroup) this, true);
        this.hAg = findViewById(a.f.layout_challenge_latest_item_avatar);
        this.hAh = findViewById(a.f.anim_challenge_latest_item_avatar);
        this.aDr = (HeadImageView) findViewById(a.f.iv_challenge_latest_item_avatar);
        this.bhZ = (TextView) findViewById(a.f.tv_challenge_latest_item_name);
        this.hbT = (TextView) findViewById(a.f.tv_challenge_latest_item_value);
        this.hAi = (AlaChallengeTargetItemActionView) findViewById(a.f.tv_challenge_latest_item_action);
        this.aDr.setAutoChangeStyle(false);
        this.aDr.setDrawBorder(false);
        this.aDr.setIsRound(true);
        this.hAg.setOnClickListener(this);
        this.hAi.setOnClickListener(this);
    }

    private Drawable getLivingAnimDrawable() {
        if (this.hAj == null) {
            this.hAj = new GradientDrawable();
            this.hAj.setShape(1);
            this.hAj.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_latest_primary));
        }
        return this.hAj;
    }
}

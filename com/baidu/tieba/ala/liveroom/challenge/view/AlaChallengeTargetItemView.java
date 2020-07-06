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
/* loaded from: classes3.dex */
public class AlaChallengeTargetItemView extends RelativeLayout implements View.OnClickListener {
    private HeadImageView aIh;
    private TextView fMu;
    private TextView fMv;
    private View geC;
    private View geD;
    private AlaChallengeTargetItemActionView geE;
    private GradientDrawable geF;
    private a geG;

    /* loaded from: classes3.dex */
    public interface a {
        void bDe();

        void bDf();
    }

    public AlaChallengeTargetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.geG = aVar;
    }

    public void setData(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.aIh.startLoad(dVar.portrait, 12, false, false);
            this.fMu.setText(!TextUtils.isEmpty(dVar.userName) ? Html.fromHtml(dVar.userName) : "");
            this.fMv.setText(getResources().getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
            if (dVar.liveStatus == 1) {
                this.geD.setBackgroundDrawable(getLivingAnimDrawable());
                if (dVar.awo == 2) {
                    this.geE.setStyle(2);
                    return;
                } else {
                    this.geE.setStyle(1);
                    return;
                }
            }
            this.geD.setBackgroundColor(0);
            this.geE.setStyle(3);
        }
    }

    public void setActionEnabled(boolean z) {
        if (this.geE != null) {
            this.geE.setEnabled(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.geG != null) {
            if (view == this.geC) {
                this.geG.bDe();
            } else if (view == this.geE) {
                this.geG.bDf();
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, getResources().getDimensionPixelOffset(a.e.sdk_ds24), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_target_item, (ViewGroup) this, true);
        this.geC = findViewById(a.g.layout_challenge_latest_item_avatar);
        this.geD = findViewById(a.g.anim_challenge_latest_item_avatar);
        this.aIh = (HeadImageView) findViewById(a.g.iv_challenge_latest_item_avatar);
        this.fMu = (TextView) findViewById(a.g.tv_challenge_latest_item_name);
        this.fMv = (TextView) findViewById(a.g.tv_challenge_latest_item_value);
        this.geE = (AlaChallengeTargetItemActionView) findViewById(a.g.tv_challenge_latest_item_action);
        this.aIh.setAutoChangeStyle(false);
        this.aIh.setDrawBorder(false);
        this.aIh.setIsRound(true);
        this.geC.setOnClickListener(this);
        this.geE.setOnClickListener(this);
    }

    private Drawable getLivingAnimDrawable() {
        if (this.geF == null) {
            this.geF = new GradientDrawable();
            this.geF.setShape(1);
            this.geF.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_latest_primary));
        }
        return this.geF;
    }
}

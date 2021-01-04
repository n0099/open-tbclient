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
    private HeadImageView aGr;
    private TextView bjI;
    private View hAC;
    private View hAD;
    private AlaChallengeTargetItemActionView hAE;
    private GradientDrawable hAF;
    private a hAG;
    private TextView hdP;

    /* loaded from: classes11.dex */
    public interface a {
        void cgn();

        void cgo();
    }

    public AlaChallengeTargetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.hAG = aVar;
    }

    public void setData(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.aGr.startLoad(dVar.portrait, 12, false, false);
            this.bjI.setText(!TextUtils.isEmpty(dVar.userName) ? Html.fromHtml(dVar.userName) : "");
            this.hdP.setText(getResources().getString(a.h.sdk_charm_name, String.valueOf(dVar.charmCount)));
            if (dVar.liveStatus == 1) {
                this.hAD.setBackgroundDrawable(getLivingAnimDrawable());
                if (dVar.aIB == 2) {
                    this.hAE.setStyle(2);
                    return;
                } else if (dVar.aIC == 1) {
                    this.hAE.setStyle(4);
                    return;
                } else {
                    this.hAE.setStyle(1);
                    return;
                }
            }
            this.hAD.setBackgroundColor(0);
            this.hAE.setStyle(3);
        }
    }

    public void setActionEnabled(boolean z) {
        if (this.hAE != null) {
            this.hAE.setEnabled(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hAG != null) {
            if (view == this.hAC) {
                this.hAG.cgn();
            } else if (view == this.hAE) {
                this.hAG.cgo();
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, getResources().getDimensionPixelOffset(a.d.sdk_ds24), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_target_item, (ViewGroup) this, true);
        this.hAC = findViewById(a.f.layout_challenge_latest_item_avatar);
        this.hAD = findViewById(a.f.anim_challenge_latest_item_avatar);
        this.aGr = (HeadImageView) findViewById(a.f.iv_challenge_latest_item_avatar);
        this.bjI = (TextView) findViewById(a.f.tv_challenge_latest_item_name);
        this.hdP = (TextView) findViewById(a.f.tv_challenge_latest_item_value);
        this.hAE = (AlaChallengeTargetItemActionView) findViewById(a.f.tv_challenge_latest_item_action);
        this.aGr.setAutoChangeStyle(false);
        this.aGr.setDrawBorder(false);
        this.aGr.setIsRound(true);
        this.hAC.setOnClickListener(this);
        this.hAE.setOnClickListener(this);
    }

    private Drawable getLivingAnimDrawable() {
        if (this.hAF == null) {
            this.hAF = new GradientDrawable();
            this.hAF.setShape(1);
            this.hAF.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_latest_primary));
        }
        return this.hAF;
    }
}

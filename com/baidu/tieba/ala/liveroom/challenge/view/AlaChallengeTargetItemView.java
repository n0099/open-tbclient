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
    private HeadImageView aGa;
    private TextView bhZ;
    private TextView gSa;
    private View hoF;
    private View hoG;
    private AlaChallengeTargetItemActionView hoH;
    private GradientDrawable hoI;
    private a hoJ;

    /* loaded from: classes4.dex */
    public interface a {
        void cdw();

        void cdx();
    }

    public AlaChallengeTargetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.hoJ = aVar;
    }

    public void setData(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.aGa.startLoad(dVar.portrait, 12, false, false);
            this.bhZ.setText(!TextUtils.isEmpty(dVar.userName) ? Html.fromHtml(dVar.userName) : "");
            this.gSa.setText(getResources().getString(a.h.sdk_charm_name, String.valueOf(dVar.charmCount)));
            if (dVar.liveStatus == 1) {
                this.hoG.setBackgroundDrawable(getLivingAnimDrawable());
                if (dVar.aIf == 2) {
                    this.hoH.setStyle(2);
                    return;
                } else if (dVar.aIg == 1) {
                    this.hoH.setStyle(4);
                    return;
                } else {
                    this.hoH.setStyle(1);
                    return;
                }
            }
            this.hoG.setBackgroundColor(0);
            this.hoH.setStyle(3);
        }
    }

    public void setActionEnabled(boolean z) {
        if (this.hoH != null) {
            this.hoH.setEnabled(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hoJ != null) {
            if (view == this.hoF) {
                this.hoJ.cdw();
            } else if (view == this.hoH) {
                this.hoJ.cdx();
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, getResources().getDimensionPixelOffset(a.d.sdk_ds24), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_target_item, (ViewGroup) this, true);
        this.hoF = findViewById(a.f.layout_challenge_latest_item_avatar);
        this.hoG = findViewById(a.f.anim_challenge_latest_item_avatar);
        this.aGa = (HeadImageView) findViewById(a.f.iv_challenge_latest_item_avatar);
        this.bhZ = (TextView) findViewById(a.f.tv_challenge_latest_item_name);
        this.gSa = (TextView) findViewById(a.f.tv_challenge_latest_item_value);
        this.hoH = (AlaChallengeTargetItemActionView) findViewById(a.f.tv_challenge_latest_item_action);
        this.aGa.setAutoChangeStyle(false);
        this.aGa.setDrawBorder(false);
        this.aGa.setIsRound(true);
        this.hoF.setOnClickListener(this);
        this.hoH.setOnClickListener(this);
    }

    private Drawable getLivingAnimDrawable() {
        if (this.hoI == null) {
            this.hoI = new GradientDrawable();
            this.hoI.setShape(1);
            this.hoI.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_latest_primary));
        }
        return this.hoI;
    }
}

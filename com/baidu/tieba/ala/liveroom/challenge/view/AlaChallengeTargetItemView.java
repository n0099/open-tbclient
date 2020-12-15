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
    private TextView gSc;
    private View hoH;
    private View hoI;
    private AlaChallengeTargetItemActionView hoJ;
    private GradientDrawable hoK;
    private a hoL;

    /* loaded from: classes4.dex */
    public interface a {
        void cdx();

        void cdy();
    }

    public AlaChallengeTargetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.hoL = aVar;
    }

    public void setData(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.aGa.startLoad(dVar.portrait, 12, false, false);
            this.bhZ.setText(!TextUtils.isEmpty(dVar.userName) ? Html.fromHtml(dVar.userName) : "");
            this.gSc.setText(getResources().getString(a.h.sdk_charm_name, String.valueOf(dVar.charmCount)));
            if (dVar.liveStatus == 1) {
                this.hoI.setBackgroundDrawable(getLivingAnimDrawable());
                if (dVar.aIf == 2) {
                    this.hoJ.setStyle(2);
                    return;
                } else if (dVar.aIg == 1) {
                    this.hoJ.setStyle(4);
                    return;
                } else {
                    this.hoJ.setStyle(1);
                    return;
                }
            }
            this.hoI.setBackgroundColor(0);
            this.hoJ.setStyle(3);
        }
    }

    public void setActionEnabled(boolean z) {
        if (this.hoJ != null) {
            this.hoJ.setEnabled(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hoL != null) {
            if (view == this.hoH) {
                this.hoL.cdx();
            } else if (view == this.hoJ) {
                this.hoL.cdy();
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, getResources().getDimensionPixelOffset(a.d.sdk_ds24), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_target_item, (ViewGroup) this, true);
        this.hoH = findViewById(a.f.layout_challenge_latest_item_avatar);
        this.hoI = findViewById(a.f.anim_challenge_latest_item_avatar);
        this.aGa = (HeadImageView) findViewById(a.f.iv_challenge_latest_item_avatar);
        this.bhZ = (TextView) findViewById(a.f.tv_challenge_latest_item_name);
        this.gSc = (TextView) findViewById(a.f.tv_challenge_latest_item_value);
        this.hoJ = (AlaChallengeTargetItemActionView) findViewById(a.f.tv_challenge_latest_item_action);
        this.aGa.setAutoChangeStyle(false);
        this.aGa.setDrawBorder(false);
        this.aGa.setIsRound(true);
        this.hoH.setOnClickListener(this);
        this.hoJ.setOnClickListener(this);
    }

    private Drawable getLivingAnimDrawable() {
        if (this.hoK == null) {
            this.hoK = new GradientDrawable();
            this.hoK.setShape(1);
            this.hoK.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_latest_primary));
        }
        return this.hoK;
    }
}

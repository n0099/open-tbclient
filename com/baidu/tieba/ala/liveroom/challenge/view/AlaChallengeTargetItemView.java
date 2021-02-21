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
    private View hAu;
    private View hAv;
    private AlaChallengeTargetItemActionView hAw;
    private GradientDrawable hAx;
    private a hAy;
    private TextView hch;

    /* loaded from: classes11.dex */
    public interface a {
        void cdy();

        void cdz();
    }

    public AlaChallengeTargetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.hAy = aVar;
    }

    public void setData(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.aDr.startLoad(dVar.portrait, 12, false, false);
            this.bhZ.setText(!TextUtils.isEmpty(dVar.userName) ? Html.fromHtml(dVar.userName) : "");
            this.hch.setText(getResources().getString(a.h.sdk_charm_name, String.valueOf(dVar.charmCount)));
            if (dVar.liveStatus == 1) {
                this.hAv.setBackgroundDrawable(getLivingAnimDrawable());
                if (dVar.aFB == 2) {
                    this.hAw.setStyle(2);
                    return;
                } else if (dVar.aFC == 1) {
                    this.hAw.setStyle(4);
                    return;
                } else {
                    this.hAw.setStyle(1);
                    return;
                }
            }
            this.hAv.setBackgroundColor(0);
            this.hAw.setStyle(3);
        }
    }

    public void setActionEnabled(boolean z) {
        if (this.hAw != null) {
            this.hAw.setEnabled(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hAy != null) {
            if (view == this.hAu) {
                this.hAy.cdy();
            } else if (view == this.hAw) {
                this.hAy.cdz();
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, getResources().getDimensionPixelOffset(a.d.sdk_ds24), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_target_item, (ViewGroup) this, true);
        this.hAu = findViewById(a.f.layout_challenge_latest_item_avatar);
        this.hAv = findViewById(a.f.anim_challenge_latest_item_avatar);
        this.aDr = (HeadImageView) findViewById(a.f.iv_challenge_latest_item_avatar);
        this.bhZ = (TextView) findViewById(a.f.tv_challenge_latest_item_name);
        this.hch = (TextView) findViewById(a.f.tv_challenge_latest_item_value);
        this.hAw = (AlaChallengeTargetItemActionView) findViewById(a.f.tv_challenge_latest_item_action);
        this.aDr.setAutoChangeStyle(false);
        this.aDr.setDrawBorder(false);
        this.aDr.setIsRound(true);
        this.hAu.setOnClickListener(this);
        this.hAw.setOnClickListener(this);
    }

    private Drawable getLivingAnimDrawable() {
        if (this.hAx == null) {
            this.hAx = new GradientDrawable();
            this.hAx.setShape(1);
            this.hAx.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_latest_primary));
        }
        return this.hAx;
    }
}

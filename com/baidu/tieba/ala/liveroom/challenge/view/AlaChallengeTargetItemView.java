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
    private HeadImageView avs;
    private TextView fRO;
    private TextView fRP;
    private View gjK;
    private View gjL;
    private AlaChallengeTargetItemActionView gjM;
    private GradientDrawable gjN;
    private a gjO;

    /* loaded from: classes4.dex */
    public interface a {
        void bGp();

        void bGq();
    }

    public AlaChallengeTargetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gjO = aVar;
    }

    public void setData(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.avs.startLoad(dVar.portrait, 12, false, false);
            this.fRO.setText(!TextUtils.isEmpty(dVar.userName) ? Html.fromHtml(dVar.userName) : "");
            this.fRP.setText(getResources().getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
            if (dVar.liveStatus == 1) {
                this.gjL.setBackgroundDrawable(getLivingAnimDrawable());
                if (dVar.axt == 2) {
                    this.gjM.setStyle(2);
                    return;
                } else {
                    this.gjM.setStyle(1);
                    return;
                }
            }
            this.gjL.setBackgroundColor(0);
            this.gjM.setStyle(3);
        }
    }

    public void setActionEnabled(boolean z) {
        if (this.gjM != null) {
            this.gjM.setEnabled(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gjO != null) {
            if (view == this.gjK) {
                this.gjO.bGp();
            } else if (view == this.gjM) {
                this.gjO.bGq();
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, getResources().getDimensionPixelOffset(a.e.sdk_ds24), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_target_item, (ViewGroup) this, true);
        this.gjK = findViewById(a.g.layout_challenge_latest_item_avatar);
        this.gjL = findViewById(a.g.anim_challenge_latest_item_avatar);
        this.avs = (HeadImageView) findViewById(a.g.iv_challenge_latest_item_avatar);
        this.fRO = (TextView) findViewById(a.g.tv_challenge_latest_item_name);
        this.fRP = (TextView) findViewById(a.g.tv_challenge_latest_item_value);
        this.gjM = (AlaChallengeTargetItemActionView) findViewById(a.g.tv_challenge_latest_item_action);
        this.avs.setAutoChangeStyle(false);
        this.avs.setDrawBorder(false);
        this.avs.setIsRound(true);
        this.gjK.setOnClickListener(this);
        this.gjM.setOnClickListener(this);
    }

    private Drawable getLivingAnimDrawable() {
        if (this.gjN == null) {
            this.gjN = new GradientDrawable();
            this.gjN.setShape(1);
            this.gjN.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_latest_primary));
        }
        return this.gjN;
    }
}

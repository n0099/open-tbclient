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
/* loaded from: classes7.dex */
public class AlaChallengeTargetItemView extends RelativeLayout implements View.OnClickListener {
    private HeadImageView aAu;
    private TextView gdM;
    private TextView gdN;
    private View gvQ;
    private View gvR;
    private AlaChallengeTargetItemActionView gvS;
    private GradientDrawable gvT;
    private a gvU;

    /* loaded from: classes7.dex */
    public interface a {
        void bPU();

        void bPV();
    }

    public AlaChallengeTargetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gvU = aVar;
    }

    public void setData(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.aAu.startLoad(dVar.portrait, 12, false, false);
            this.gdM.setText(!TextUtils.isEmpty(dVar.userName) ? Html.fromHtml(dVar.userName) : "");
            this.gdN.setText(getResources().getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
            if (dVar.liveStatus == 1) {
                this.gvR.setBackgroundDrawable(getLivingAnimDrawable());
                if (dVar.aCv == 2) {
                    this.gvS.setStyle(2);
                    return;
                } else {
                    this.gvS.setStyle(1);
                    return;
                }
            }
            this.gvR.setBackgroundColor(0);
            this.gvS.setStyle(3);
        }
    }

    public void setActionEnabled(boolean z) {
        if (this.gvS != null) {
            this.gvS.setEnabled(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gvU != null) {
            if (view == this.gvQ) {
                this.gvU.bPU();
            } else if (view == this.gvS) {
                this.gvU.bPV();
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, getResources().getDimensionPixelOffset(a.e.sdk_ds24), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_target_item, (ViewGroup) this, true);
        this.gvQ = findViewById(a.g.layout_challenge_latest_item_avatar);
        this.gvR = findViewById(a.g.anim_challenge_latest_item_avatar);
        this.aAu = (HeadImageView) findViewById(a.g.iv_challenge_latest_item_avatar);
        this.gdM = (TextView) findViewById(a.g.tv_challenge_latest_item_name);
        this.gdN = (TextView) findViewById(a.g.tv_challenge_latest_item_value);
        this.gvS = (AlaChallengeTargetItemActionView) findViewById(a.g.tv_challenge_latest_item_action);
        this.aAu.setAutoChangeStyle(false);
        this.aAu.setDrawBorder(false);
        this.aAu.setIsRound(true);
        this.gvQ.setOnClickListener(this);
        this.gvS.setOnClickListener(this);
    }

    private Drawable getLivingAnimDrawable() {
        if (this.gvT == null) {
            this.gvT = new GradientDrawable();
            this.gvT.setShape(1);
            this.gvT.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_latest_primary));
        }
        return this.gvT;
    }
}

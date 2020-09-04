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
    private HeadImageView aAw;
    private TextView gdQ;
    private TextView gdR;
    private View gvU;
    private View gvV;
    private AlaChallengeTargetItemActionView gvW;
    private GradientDrawable gvX;
    private a gvY;

    /* loaded from: classes7.dex */
    public interface a {
        void bPV();

        void bPW();
    }

    public AlaChallengeTargetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gvY = aVar;
    }

    public void setData(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.aAw.startLoad(dVar.portrait, 12, false, false);
            this.gdQ.setText(!TextUtils.isEmpty(dVar.userName) ? Html.fromHtml(dVar.userName) : "");
            this.gdR.setText(getResources().getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
            if (dVar.liveStatus == 1) {
                this.gvV.setBackgroundDrawable(getLivingAnimDrawable());
                if (dVar.aCx == 2) {
                    this.gvW.setStyle(2);
                    return;
                } else {
                    this.gvW.setStyle(1);
                    return;
                }
            }
            this.gvV.setBackgroundColor(0);
            this.gvW.setStyle(3);
        }
    }

    public void setActionEnabled(boolean z) {
        if (this.gvW != null) {
            this.gvW.setEnabled(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gvY != null) {
            if (view == this.gvU) {
                this.gvY.bPV();
            } else if (view == this.gvW) {
                this.gvY.bPW();
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, getResources().getDimensionPixelOffset(a.e.sdk_ds24), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_target_item, (ViewGroup) this, true);
        this.gvU = findViewById(a.g.layout_challenge_latest_item_avatar);
        this.gvV = findViewById(a.g.anim_challenge_latest_item_avatar);
        this.aAw = (HeadImageView) findViewById(a.g.iv_challenge_latest_item_avatar);
        this.gdQ = (TextView) findViewById(a.g.tv_challenge_latest_item_name);
        this.gdR = (TextView) findViewById(a.g.tv_challenge_latest_item_value);
        this.gvW = (AlaChallengeTargetItemActionView) findViewById(a.g.tv_challenge_latest_item_action);
        this.aAw.setAutoChangeStyle(false);
        this.aAw.setDrawBorder(false);
        this.aAw.setIsRound(true);
        this.gvU.setOnClickListener(this);
        this.gvW.setOnClickListener(this);
    }

    private Drawable getLivingAnimDrawable() {
        if (this.gvX == null) {
            this.gvX = new GradientDrawable();
            this.gvX.setShape(1);
            this.gvX.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_latest_primary));
        }
        return this.gvX;
    }
}

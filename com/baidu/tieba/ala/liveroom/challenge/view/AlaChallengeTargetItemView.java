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
    private HeadImageView aER;
    private TextView bjB;
    private View hCd;
    private View hCe;
    private AlaChallengeTargetItemActionView hCf;
    private GradientDrawable hCg;
    private a hCh;
    private TextView hdQ;

    /* loaded from: classes10.dex */
    public interface a {
        void cdE();

        void cdF();
    }

    public AlaChallengeTargetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.hCh = aVar;
    }

    public void setData(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.aER.startLoad(dVar.portrait, 12, false, false);
            this.bjB.setText(!TextUtils.isEmpty(dVar.userName) ? Html.fromHtml(dVar.userName) : "");
            this.hdQ.setText(getResources().getString(a.h.sdk_charm_name, String.valueOf(dVar.charmCount)));
            if (dVar.liveStatus == 1) {
                this.hCe.setBackgroundDrawable(getLivingAnimDrawable());
                if (dVar.aHb == 2) {
                    this.hCf.setStyle(2);
                    return;
                } else if (dVar.aHc == 1) {
                    this.hCf.setStyle(4);
                    return;
                } else {
                    this.hCf.setStyle(1);
                    return;
                }
            }
            this.hCe.setBackgroundColor(0);
            this.hCf.setStyle(3);
        }
    }

    public void setActionEnabled(boolean z) {
        if (this.hCf != null) {
            this.hCf.setEnabled(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hCh != null) {
            if (view == this.hCd) {
                this.hCh.cdE();
            } else if (view == this.hCf) {
                this.hCh.cdF();
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, getResources().getDimensionPixelOffset(a.d.sdk_ds24), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_target_item, (ViewGroup) this, true);
        this.hCd = findViewById(a.f.layout_challenge_latest_item_avatar);
        this.hCe = findViewById(a.f.anim_challenge_latest_item_avatar);
        this.aER = (HeadImageView) findViewById(a.f.iv_challenge_latest_item_avatar);
        this.bjB = (TextView) findViewById(a.f.tv_challenge_latest_item_name);
        this.hdQ = (TextView) findViewById(a.f.tv_challenge_latest_item_value);
        this.hCf = (AlaChallengeTargetItemActionView) findViewById(a.f.tv_challenge_latest_item_action);
        this.aER.setAutoChangeStyle(false);
        this.aER.setDrawBorder(false);
        this.aER.setIsRound(true);
        this.hCd.setOnClickListener(this);
        this.hCf.setOnClickListener(this);
    }

    private Drawable getLivingAnimDrawable() {
        if (this.hCg == null) {
            this.hCg = new GradientDrawable();
            this.hCg.setShape(1);
            this.hCg.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_latest_primary));
        }
        return this.hCg;
    }
}

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
    private HeadImageView aFf;
    private TextView gJi;
    private TextView gJj;
    private View hfq;
    private View hfr;
    private AlaChallengeTargetItemActionView hfs;
    private GradientDrawable hft;
    private a hfu;

    /* loaded from: classes4.dex */
    public interface a {
        void cai();

        void caj();
    }

    public AlaChallengeTargetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.hfu = aVar;
    }

    public void setData(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.aFf.startLoad(dVar.portrait, 12, false, false);
            this.gJi.setText(!TextUtils.isEmpty(dVar.userName) ? Html.fromHtml(dVar.userName) : "");
            this.gJj.setText(getResources().getString(a.h.sdk_charm_name, String.valueOf(dVar.charmCount)));
            if (dVar.liveStatus == 1) {
                this.hfr.setBackgroundDrawable(getLivingAnimDrawable());
                if (dVar.aHi == 2) {
                    this.hfs.setStyle(2);
                    return;
                } else if (dVar.aHj == 1) {
                    this.hfs.setStyle(4);
                    return;
                } else {
                    this.hfs.setStyle(1);
                    return;
                }
            }
            this.hfr.setBackgroundColor(0);
            this.hfs.setStyle(3);
        }
    }

    public void setActionEnabled(boolean z) {
        if (this.hfs != null) {
            this.hfs.setEnabled(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hfu != null) {
            if (view == this.hfq) {
                this.hfu.cai();
            } else if (view == this.hfs) {
                this.hfu.caj();
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, getResources().getDimensionPixelOffset(a.d.sdk_ds24), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_target_item, (ViewGroup) this, true);
        this.hfq = findViewById(a.f.layout_challenge_latest_item_avatar);
        this.hfr = findViewById(a.f.anim_challenge_latest_item_avatar);
        this.aFf = (HeadImageView) findViewById(a.f.iv_challenge_latest_item_avatar);
        this.gJi = (TextView) findViewById(a.f.tv_challenge_latest_item_name);
        this.gJj = (TextView) findViewById(a.f.tv_challenge_latest_item_value);
        this.hfs = (AlaChallengeTargetItemActionView) findViewById(a.f.tv_challenge_latest_item_action);
        this.aFf.setAutoChangeStyle(false);
        this.aFf.setDrawBorder(false);
        this.aFf.setIsRound(true);
        this.hfq.setOnClickListener(this);
        this.hfs.setOnClickListener(this);
    }

    private Drawable getLivingAnimDrawable() {
        if (this.hft == null) {
            this.hft = new GradientDrawable();
            this.hft.setShape(1);
            this.hft.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_latest_primary));
        }
        return this.hft;
    }
}

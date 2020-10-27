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
    private HeadImageView aEp;
    private TextView gDv;
    private TextView gDw;
    private View gZm;
    private View gZn;
    private AlaChallengeTargetItemActionView gZo;
    private GradientDrawable gZp;
    private a gZq;

    /* loaded from: classes4.dex */
    public interface a {
        void bXG();

        void bXH();
    }

    public AlaChallengeTargetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gZq = aVar;
    }

    public void setData(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.aEp.startLoad(dVar.portrait, 12, false, false);
            this.gDv.setText(!TextUtils.isEmpty(dVar.userName) ? Html.fromHtml(dVar.userName) : "");
            this.gDw.setText(getResources().getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
            if (dVar.liveStatus == 1) {
                this.gZn.setBackgroundDrawable(getLivingAnimDrawable());
                if (dVar.aGs == 2) {
                    this.gZo.setStyle(2);
                    return;
                } else if (dVar.aGt == 1) {
                    this.gZo.setStyle(4);
                    return;
                } else {
                    this.gZo.setStyle(1);
                    return;
                }
            }
            this.gZn.setBackgroundColor(0);
            this.gZo.setStyle(3);
        }
    }

    public void setActionEnabled(boolean z) {
        if (this.gZo != null) {
            this.gZo.setEnabled(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gZq != null) {
            if (view == this.gZm) {
                this.gZq.bXG();
            } else if (view == this.gZo) {
                this.gZq.bXH();
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, getResources().getDimensionPixelOffset(a.e.sdk_ds24), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_target_item, (ViewGroup) this, true);
        this.gZm = findViewById(a.g.layout_challenge_latest_item_avatar);
        this.gZn = findViewById(a.g.anim_challenge_latest_item_avatar);
        this.aEp = (HeadImageView) findViewById(a.g.iv_challenge_latest_item_avatar);
        this.gDv = (TextView) findViewById(a.g.tv_challenge_latest_item_name);
        this.gDw = (TextView) findViewById(a.g.tv_challenge_latest_item_value);
        this.gZo = (AlaChallengeTargetItemActionView) findViewById(a.g.tv_challenge_latest_item_action);
        this.aEp.setAutoChangeStyle(false);
        this.aEp.setDrawBorder(false);
        this.aEp.setIsRound(true);
        this.gZm.setOnClickListener(this);
        this.gZo.setOnClickListener(this);
    }

    private Drawable getLivingAnimDrawable() {
        if (this.gZp == null) {
            this.gZp = new GradientDrawable();
            this.gZp.setShape(1);
            this.gZp.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_latest_primary));
        }
        return this.gZp;
    }
}

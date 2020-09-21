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
    private HeadImageView aBc;
    private TextView ghc;
    private TextView ghd;
    private View gzf;
    private View gzg;
    private AlaChallengeTargetItemActionView gzh;
    private GradientDrawable gzi;
    private a gzj;

    /* loaded from: classes4.dex */
    public interface a {
        void bRn();

        void bRo();
    }

    public AlaChallengeTargetItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gzj = aVar;
    }

    public void setData(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.aBc.startLoad(dVar.portrait, 12, false, false);
            this.ghc.setText(!TextUtils.isEmpty(dVar.userName) ? Html.fromHtml(dVar.userName) : "");
            this.ghd.setText(getResources().getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
            if (dVar.liveStatus == 1) {
                this.gzg.setBackgroundDrawable(getLivingAnimDrawable());
                if (dVar.aDg == 2) {
                    this.gzh.setStyle(2);
                    return;
                } else if (dVar.aDh == 1) {
                    this.gzh.setStyle(4);
                    return;
                } else {
                    this.gzh.setStyle(1);
                    return;
                }
            }
            this.gzg.setBackgroundColor(0);
            this.gzh.setStyle(3);
        }
    }

    public void setActionEnabled(boolean z) {
        if (this.gzh != null) {
            this.gzh.setEnabled(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gzj != null) {
            if (view == this.gzf) {
                this.gzj.bRn();
            } else if (view == this.gzh) {
                this.gzj.bRo();
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, getResources().getDimensionPixelOffset(a.e.sdk_ds24), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_target_item, (ViewGroup) this, true);
        this.gzf = findViewById(a.g.layout_challenge_latest_item_avatar);
        this.gzg = findViewById(a.g.anim_challenge_latest_item_avatar);
        this.aBc = (HeadImageView) findViewById(a.g.iv_challenge_latest_item_avatar);
        this.ghc = (TextView) findViewById(a.g.tv_challenge_latest_item_name);
        this.ghd = (TextView) findViewById(a.g.tv_challenge_latest_item_value);
        this.gzh = (AlaChallengeTargetItemActionView) findViewById(a.g.tv_challenge_latest_item_action);
        this.aBc.setAutoChangeStyle(false);
        this.aBc.setDrawBorder(false);
        this.aBc.setIsRound(true);
        this.gzf.setOnClickListener(this);
        this.gzh.setOnClickListener(this);
    }

    private Drawable getLivingAnimDrawable() {
        if (this.gzi == null) {
            this.gzi = new GradientDrawable();
            this.gzi.setShape(1);
            this.gzi.setStroke((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_latest_primary));
        }
        return this.gzi;
    }
}

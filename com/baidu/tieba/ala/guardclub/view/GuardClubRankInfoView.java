package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class GuardClubRankInfoView extends RelativeLayout {
    private HeadImageView aBc;
    private TextView aBe;
    private TextView ghc;
    private TextView ghp;
    private TextView ghq;
    private a ghr;

    /* loaded from: classes4.dex */
    public interface a {
        void bLO();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.ghr = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.ghp.setText(str);
        this.aBc.startLoad(str2, 12, false, false);
        this.ghc.setText(str3);
        this.aBe.setText(str4);
        this.ghq.setVisibility(z ? 0 : 4);
        if (hz(str)) {
            this.ghp.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        } else {
            this.ghp.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
        }
    }

    private boolean hz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aBc != null) {
            this.aBc.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_rank_info, (ViewGroup) this, true);
        this.ghp = (TextView) findViewById(a.g.tv_rank);
        this.aBc = (HeadImageView) findViewById(a.g.iv_avatar);
        this.ghc = (TextView) findViewById(a.g.tv_name);
        this.aBe = (TextView) findViewById(a.g.tv_content);
        this.ghq = (TextView) findViewById(a.g.tv_hit);
        this.aBc.setIsRound(true);
        this.aBc.setAutoChangeStyle(false);
        this.aBc.setDefaultBgResource(a.f.sdk_default_avatar);
        this.ghq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.ghr != null) {
                    GuardClubRankInfoView.this.ghr.bLO();
                }
            }
        });
    }
}

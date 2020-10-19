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
    private HeadImageView aEh;
    private TextView aEj;
    private TextView gtE;
    private TextView gtF;
    private a gtG;
    private TextView gtr;

    /* loaded from: classes4.dex */
    public interface a {
        void bOy();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gtG = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.gtE.setText(str);
        this.aEh.startLoad(str2, 12, false, false);
        this.gtr.setText(str3);
        this.aEj.setText(str4);
        this.gtF.setVisibility(z ? 0 : 4);
        if (hQ(str)) {
            this.gtE.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        } else {
            this.gtE.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
        }
    }

    private boolean hQ(String str) {
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
        if (this.aEh != null) {
            this.aEh.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_rank_info, (ViewGroup) this, true);
        this.gtE = (TextView) findViewById(a.g.tv_rank);
        this.aEh = (HeadImageView) findViewById(a.g.iv_avatar);
        this.gtr = (TextView) findViewById(a.g.tv_name);
        this.aEj = (TextView) findViewById(a.g.tv_content);
        this.gtF = (TextView) findViewById(a.g.tv_hit);
        this.aEh.setIsRound(true);
        this.aEh.setAutoChangeStyle(false);
        this.aEh.setDefaultBgResource(a.f.sdk_default_avatar);
        this.gtF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.gtG != null) {
                    GuardClubRankInfoView.this.gtG.bOy();
                }
            }
        });
    }
}

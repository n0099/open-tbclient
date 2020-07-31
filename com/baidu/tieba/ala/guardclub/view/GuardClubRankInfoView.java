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
    private HeadImageView avs;
    private TextView avu;
    private TextView fRO;
    private TextView fSb;
    private TextView fSc;
    private a fSd;

    /* loaded from: classes4.dex */
    public interface a {
        void bBj();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.fSd = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.fSb.setText(str);
        this.avs.startLoad(str2, 12, false, false);
        this.fRO.setText(str3);
        this.avu.setText(str4);
        this.fSc.setVisibility(z ? 0 : 4);
        if (fO(str)) {
            this.fSb.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        } else {
            this.fSb.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
        }
    }

    private boolean fO(String str) {
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
        if (this.avs != null) {
            this.avs.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_rank_info, (ViewGroup) this, true);
        this.fSb = (TextView) findViewById(a.g.tv_rank);
        this.avs = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fRO = (TextView) findViewById(a.g.tv_name);
        this.avu = (TextView) findViewById(a.g.tv_content);
        this.fSc = (TextView) findViewById(a.g.tv_hit);
        this.avs.setIsRound(true);
        this.avs.setAutoChangeStyle(false);
        this.avs.setDefaultBgResource(a.f.sdk_default_avatar);
        this.fSc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.fSd != null) {
                    GuardClubRankInfoView.this.fSd.bBj();
                }
            }
        });
    }
}

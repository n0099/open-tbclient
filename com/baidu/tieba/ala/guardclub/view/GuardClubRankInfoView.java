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
/* loaded from: classes3.dex */
public class GuardClubRankInfoView extends RelativeLayout {
    private HeadImageView aIh;
    private TextView aWB;
    private TextView fMH;
    private TextView fMI;
    private a fMJ;
    private TextView fMu;

    /* loaded from: classes3.dex */
    public interface a {
        void bxU();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.fMJ = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.fMH.setText(str);
        this.aIh.startLoad(str2, 12, false, false);
        this.fMu.setText(str3);
        this.aWB.setText(str4);
        this.fMI.setVisibility(z ? 0 : 4);
        if (fQ(str)) {
            this.fMH.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        } else {
            this.fMH.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
        }
    }

    private boolean fQ(String str) {
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
        if (this.aIh != null) {
            this.aIh.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_rank_info, (ViewGroup) this, true);
        this.fMH = (TextView) findViewById(a.g.tv_rank);
        this.aIh = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fMu = (TextView) findViewById(a.g.tv_name);
        this.aWB = (TextView) findViewById(a.g.tv_content);
        this.fMI = (TextView) findViewById(a.g.tv_hit);
        this.aIh.setIsRound(true);
        this.aIh.setAutoChangeStyle(false);
        this.aIh.setDefaultBgResource(a.f.sdk_default_avatar);
        this.fMI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.fMJ != null) {
                    GuardClubRankInfoView.this.fMJ.bxU();
                }
            }
        });
    }
}

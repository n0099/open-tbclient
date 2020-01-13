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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class GuardClubRankInfoView extends RelativeLayout {
    private HeadImageView afA;
    private TextView aqn;
    private TextView eEG;
    private TextView eEH;
    private a eEI;
    private TextView eEt;

    /* loaded from: classes2.dex */
    public interface a {
        void bdA();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.eEI = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.eEG.setText(str);
        this.afA.startLoad(str2, 12, false, false);
        this.eEt.setText(str3);
        this.aqn.setText(str4);
        this.eEH.setVisibility(z ? 0 : 4);
        if (dP(str)) {
            this.eEG.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        } else {
            this.eEG.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
        }
    }

    private boolean dP(String str) {
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
        if (this.afA != null) {
            this.afA.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_rank_info, (ViewGroup) this, true);
        this.eEG = (TextView) findViewById(a.g.tv_rank);
        this.afA = (HeadImageView) findViewById(a.g.iv_avatar);
        this.eEt = (TextView) findViewById(a.g.tv_name);
        this.aqn = (TextView) findViewById(a.g.tv_content);
        this.eEH = (TextView) findViewById(a.g.tv_hit);
        this.afA.setIsRound(true);
        this.afA.setAutoChangeStyle(false);
        this.afA.setDefaultBgResource(a.f.sdk_default_avatar);
        this.eEH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.eEI != null) {
                    GuardClubRankInfoView.this.eEI.bdA();
                }
            }
        });
    }
}

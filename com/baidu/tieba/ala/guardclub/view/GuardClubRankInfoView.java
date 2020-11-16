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
    private HeadImageView aDu;
    private TextView aDw;
    private TextView gIP;
    private TextView gJc;
    private TextView gJd;
    private a gJe;

    /* loaded from: classes4.dex */
    public interface a {
        void bSV();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gJe = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.gJc.setText(str);
        this.aDu.startLoad(str2, 12, false, false);
        this.gIP.setText(str3);
        this.aDw.setText(str4);
        this.gJd.setVisibility(z ? 0 : 4);
        if (iu(str)) {
            this.gJc.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_fontsize40));
        } else {
            this.gJc.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
        }
    }

    private boolean iu(String str) {
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
        if (this.aDu != null) {
            this.aDu.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_rank_info, (ViewGroup) this, true);
        this.gJc = (TextView) findViewById(a.f.tv_rank);
        this.aDu = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gIP = (TextView) findViewById(a.f.tv_name);
        this.aDw = (TextView) findViewById(a.f.tv_content);
        this.gJd = (TextView) findViewById(a.f.tv_hit);
        this.aDu.setIsRound(true);
        this.aDu.setAutoChangeStyle(false);
        this.aDu.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gJd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.gJe != null) {
                    GuardClubRankInfoView.this.gJe.bSV();
                }
            }
        });
    }
}

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
    private HeadImageView aEp;
    private TextView aEr;
    private TextView gDI;
    private TextView gDJ;
    private a gDK;
    private TextView gDv;

    /* loaded from: classes4.dex */
    public interface a {
        void bRd();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gDK = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.gDI.setText(str);
        this.aEp.startLoad(str2, 12, false, false);
        this.gDv.setText(str3);
        this.aEr.setText(str4);
        this.gDJ.setVisibility(z ? 0 : 4);
        if (ih(str)) {
            this.gDI.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        } else {
            this.gDI.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
        }
    }

    private boolean ih(String str) {
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
        if (this.aEp != null) {
            this.aEp.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_rank_info, (ViewGroup) this, true);
        this.gDI = (TextView) findViewById(a.g.tv_rank);
        this.aEp = (HeadImageView) findViewById(a.g.iv_avatar);
        this.gDv = (TextView) findViewById(a.g.tv_name);
        this.aEr = (TextView) findViewById(a.g.tv_content);
        this.gDJ = (TextView) findViewById(a.g.tv_hit);
        this.aEp.setIsRound(true);
        this.aEp.setAutoChangeStyle(false);
        this.aEp.setDefaultBgResource(a.f.sdk_default_avatar);
        this.gDJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.gDK != null) {
                    GuardClubRankInfoView.this.gDK.bRd();
                }
            }
        });
    }
}

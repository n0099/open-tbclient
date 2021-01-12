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
/* loaded from: classes10.dex */
public class GuardClubRankInfoView extends RelativeLayout {
    private HeadImageView aBE;
    private TextView aBG;
    private TextView beR;
    private TextView gZv;
    private TextView gZw;
    private a gZx;

    /* loaded from: classes10.dex */
    public interface a {
        void bVu();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gZx = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.gZv.setText(str);
        this.aBE.startLoad(str2, 12, false, false);
        this.beR.setText(str3);
        this.aBG.setText(str4);
        this.gZw.setVisibility(z ? 0 : 4);
        if (hC(str)) {
            this.gZv.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_fontsize40));
        } else {
            this.gZv.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
        }
    }

    private boolean hC(String str) {
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
        if (this.aBE != null) {
            this.aBE.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_rank_info, (ViewGroup) this, true);
        this.gZv = (TextView) findViewById(a.f.tv_rank);
        this.aBE = (HeadImageView) findViewById(a.f.iv_avatar);
        this.beR = (TextView) findViewById(a.f.tv_name);
        this.aBG = (TextView) findViewById(a.f.tv_content);
        this.gZw = (TextView) findViewById(a.f.tv_hit);
        this.aBE.setIsRound(true);
        this.aBE.setAutoChangeStyle(false);
        this.aBE.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gZw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.gZx != null) {
                    GuardClubRankInfoView.this.gZx.bVu();
                }
            }
        });
    }
}

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
    private HeadImageView aER;
    private TextView aET;
    private TextView bjB;
    private TextView hec;
    private TextView hed;
    private a hee;

    /* loaded from: classes10.dex */
    public interface a {
        void bWl();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.hee = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.hec.setText(str);
        this.aER.startLoad(str2, 12, false, false);
        this.bjB.setText(str3);
        this.aET.setText(str4);
        this.hed.setVisibility(z ? 0 : 4);
        if (isNumeric(str)) {
            this.hec.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_fontsize40));
        } else {
            this.hec.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
        }
    }

    private boolean isNumeric(String str) {
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
        if (this.aER != null) {
            this.aER.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_rank_info, (ViewGroup) this, true);
        this.hec = (TextView) findViewById(a.f.tv_rank);
        this.aER = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bjB = (TextView) findViewById(a.f.tv_name);
        this.aET = (TextView) findViewById(a.f.tv_content);
        this.hed = (TextView) findViewById(a.f.tv_hit);
        this.aER.setIsRound(true);
        this.aER.setAutoChangeStyle(false);
        this.aER.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hed.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.hee != null) {
                    GuardClubRankInfoView.this.hee.bWl();
                }
            }
        });
    }
}

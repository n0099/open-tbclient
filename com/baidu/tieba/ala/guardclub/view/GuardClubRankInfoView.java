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
/* loaded from: classes7.dex */
public class GuardClubRankInfoView extends RelativeLayout {
    private HeadImageView aAu;
    private TextView aAw;
    private TextView gdM;
    private TextView gdZ;
    private TextView gea;
    private a geb;

    /* loaded from: classes7.dex */
    public interface a {
        void bKD();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.geb = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.gdZ.setText(str);
        this.aAu.startLoad(str2, 12, false, false);
        this.gdM.setText(str3);
        this.aAw.setText(str4);
        this.gea.setVisibility(z ? 0 : 4);
        if (hi(str)) {
            this.gdZ.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        } else {
            this.gdZ.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
        }
    }

    private boolean hi(String str) {
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
        if (this.aAu != null) {
            this.aAu.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_rank_info, (ViewGroup) this, true);
        this.gdZ = (TextView) findViewById(a.g.tv_rank);
        this.aAu = (HeadImageView) findViewById(a.g.iv_avatar);
        this.gdM = (TextView) findViewById(a.g.tv_name);
        this.aAw = (TextView) findViewById(a.g.tv_content);
        this.gea = (TextView) findViewById(a.g.tv_hit);
        this.aAu.setIsRound(true);
        this.aAu.setAutoChangeStyle(false);
        this.aAu.setDefaultBgResource(a.f.sdk_default_avatar);
        this.gea.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.geb != null) {
                    GuardClubRankInfoView.this.geb.bKD();
                }
            }
        });
    }
}

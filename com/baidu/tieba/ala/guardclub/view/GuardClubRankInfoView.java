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
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class GuardClubRankInfoView extends RelativeLayout {
    private HeadImageView ahS;
    private TextView aui;
    private TextView eIX;
    private TextView eJk;
    private TextView eJl;
    private a eJm;

    /* loaded from: classes3.dex */
    public interface a {
        void bfQ();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.eJm = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.eJk.setText(str);
        this.ahS.startLoad(str2, 12, false, false);
        this.eIX.setText(str3);
        this.aui.setText(str4);
        this.eJl.setVisibility(z ? 0 : 4);
        if (ed(str)) {
            this.eJk.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        } else {
            this.eJk.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
        }
    }

    private boolean ed(String str) {
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
        if (this.ahS != null) {
            this.ahS.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_rank_info, (ViewGroup) this, true);
        this.eJk = (TextView) findViewById(a.g.tv_rank);
        this.ahS = (HeadImageView) findViewById(a.g.iv_avatar);
        this.eIX = (TextView) findViewById(a.g.tv_name);
        this.aui = (TextView) findViewById(a.g.tv_content);
        this.eJl = (TextView) findViewById(a.g.tv_hit);
        this.ahS.setIsRound(true);
        this.ahS.setAutoChangeStyle(false);
        this.ahS.setDefaultBgResource(a.f.sdk_default_avatar);
        this.eJl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.eJm != null) {
                    GuardClubRankInfoView.this.eJm.bfQ();
                }
            }
        });
    }
}

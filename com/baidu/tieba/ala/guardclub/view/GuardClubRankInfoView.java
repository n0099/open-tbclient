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
    private HeadImageView aAw;
    private TextView aAy;
    private TextView gdQ;
    private TextView ged;
    private TextView gee;
    private a gef;

    /* loaded from: classes7.dex */
    public interface a {
        void bKE();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gef = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.ged.setText(str);
        this.aAw.startLoad(str2, 12, false, false);
        this.gdQ.setText(str3);
        this.aAy.setText(str4);
        this.gee.setVisibility(z ? 0 : 4);
        if (hj(str)) {
            this.ged.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        } else {
            this.ged.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
        }
    }

    private boolean hj(String str) {
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
        if (this.aAw != null) {
            this.aAw.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_rank_info, (ViewGroup) this, true);
        this.ged = (TextView) findViewById(a.g.tv_rank);
        this.aAw = (HeadImageView) findViewById(a.g.iv_avatar);
        this.gdQ = (TextView) findViewById(a.g.tv_name);
        this.aAy = (TextView) findViewById(a.g.tv_content);
        this.gee = (TextView) findViewById(a.g.tv_hit);
        this.aAw.setIsRound(true);
        this.aAw.setAutoChangeStyle(false);
        this.aAw.setDefaultBgResource(a.f.sdk_default_avatar);
        this.gee.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.gef != null) {
                    GuardClubRankInfoView.this.gef.bKE();
                }
            }
        });
    }
}

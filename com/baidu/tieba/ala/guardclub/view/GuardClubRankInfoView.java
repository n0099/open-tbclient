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
    private HeadImageView ahI;
    private TextView atY;
    private TextView eIB;
    private TextView eIO;
    private TextView eIP;
    private a eIQ;

    /* loaded from: classes3.dex */
    public interface a {
        void bfL();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.eIQ = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.eIO.setText(str);
        this.ahI.startLoad(str2, 12, false, false);
        this.eIB.setText(str3);
        this.atY.setText(str4);
        this.eIP.setVisibility(z ? 0 : 4);
        if (ee(str)) {
            this.eIO.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        } else {
            this.eIO.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
        }
    }

    private boolean ee(String str) {
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
        if (this.ahI != null) {
            this.ahI.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_rank_info, (ViewGroup) this, true);
        this.eIO = (TextView) findViewById(a.g.tv_rank);
        this.ahI = (HeadImageView) findViewById(a.g.iv_avatar);
        this.eIB = (TextView) findViewById(a.g.tv_name);
        this.atY = (TextView) findViewById(a.g.tv_content);
        this.eIP = (TextView) findViewById(a.g.tv_hit);
        this.ahI.setIsRound(true);
        this.ahI.setAutoChangeStyle(false);
        this.ahI.setDefaultBgResource(a.f.sdk_default_avatar);
        this.eIP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.eIQ != null) {
                    GuardClubRankInfoView.this.eIQ.bfL();
                }
            }
        });
    }
}

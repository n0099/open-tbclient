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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes6.dex */
public class GuardClubRankInfoView extends RelativeLayout {
    private HeadImageView Xy;
    private TextView ahP;
    private TextView dPT;
    private TextView dQg;
    private TextView dQh;
    private a dQi;

    /* loaded from: classes6.dex */
    public interface a {
        void aLY();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.dQi = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.dQg.setText(str);
        this.Xy.startLoad(str2, 12, false, false);
        this.dPT.setText(str3);
        this.ahP.setText(str4);
        this.dQh.setVisibility(z ? 0 : 4);
        if (cU(str)) {
            this.dQg.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        } else {
            this.dQg.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
        }
    }

    private boolean cU(String str) {
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
        if (this.Xy != null) {
            this.Xy.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_rank_info, (ViewGroup) this, true);
        this.dQg = (TextView) findViewById(a.g.tv_rank);
        this.Xy = (HeadImageView) findViewById(a.g.iv_avatar);
        this.dPT = (TextView) findViewById(a.g.tv_name);
        this.ahP = (TextView) findViewById(a.g.tv_content);
        this.dQh = (TextView) findViewById(a.g.tv_hit);
        this.Xy.setIsRound(true);
        this.Xy.setAutoChangeStyle(false);
        this.Xy.setDefaultBgResource(a.f.sdk_default_avatar);
        this.dQh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.dQi != null) {
                    GuardClubRankInfoView.this.dQi.aLY();
                }
            }
        });
    }
}

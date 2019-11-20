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
    private HeadImageView Xg;
    private TextView ahx;
    private TextView dPc;
    private TextView dPp;
    private TextView dPq;
    private a dPr;

    /* loaded from: classes6.dex */
    public interface a {
        void aLW();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.dPr = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.dPp.setText(str);
        this.Xg.startLoad(str2, 12, false, false);
        this.dPc.setText(str3);
        this.ahx.setText(str4);
        this.dPq.setVisibility(z ? 0 : 4);
        if (cU(str)) {
            this.dPp.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        } else {
            this.dPp.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
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
        if (this.Xg != null) {
            this.Xg.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_rank_info, (ViewGroup) this, true);
        this.dPp = (TextView) findViewById(a.g.tv_rank);
        this.Xg = (HeadImageView) findViewById(a.g.iv_avatar);
        this.dPc = (TextView) findViewById(a.g.tv_name);
        this.ahx = (TextView) findViewById(a.g.tv_content);
        this.dPq = (TextView) findViewById(a.g.tv_hit);
        this.Xg.setIsRound(true);
        this.Xg.setAutoChangeStyle(false);
        this.Xg.setDefaultBgResource(a.f.sdk_default_avatar);
        this.dPq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.dPr != null) {
                    GuardClubRankInfoView.this.dPr.aLW();
                }
            }
        });
    }
}

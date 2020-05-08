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
    private HeadImageView aAs;
    private TextView aNN;
    private TextView fnG;
    private TextView fnH;
    private a fnI;
    private TextView fnt;

    /* loaded from: classes3.dex */
    public interface a {
        void bpf();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.fnI = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.fnG.setText(str);
        this.aAs.startLoad(str2, 12, false, false);
        this.fnt.setText(str3);
        this.aNN.setText(str4);
        this.fnH.setVisibility(z ? 0 : 4);
        if (eW(str)) {
            this.fnG.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        } else {
            this.fnG.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
        }
    }

    private boolean eW(String str) {
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
        if (this.aAs != null) {
            this.aAs.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_rank_info, (ViewGroup) this, true);
        this.fnG = (TextView) findViewById(a.g.tv_rank);
        this.aAs = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fnt = (TextView) findViewById(a.g.tv_name);
        this.aNN = (TextView) findViewById(a.g.tv_content);
        this.fnH = (TextView) findViewById(a.g.tv_hit);
        this.aAs.setIsRound(true);
        this.aAs.setAutoChangeStyle(false);
        this.aAs.setDefaultBgResource(a.f.sdk_default_avatar);
        this.fnH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.fnI != null) {
                    GuardClubRankInfoView.this.fnI.bpf();
                }
            }
        });
    }
}

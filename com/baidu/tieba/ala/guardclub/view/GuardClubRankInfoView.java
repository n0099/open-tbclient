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
    private HeadImageView aFL;
    private TextView aTU;
    private TextView fBa;
    private TextView fBn;
    private TextView fBo;
    private a fBp;

    /* loaded from: classes3.dex */
    public interface a {
        void buW();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.fBp = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.fBn.setText(str);
        this.aFL.startLoad(str2, 12, false, false);
        this.fBa.setText(str3);
        this.aTU.setText(str4);
        this.fBo.setVisibility(z ? 0 : 4);
        if (fI(str)) {
            this.fBn.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        } else {
            this.fBn.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
        }
    }

    private boolean fI(String str) {
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
        if (this.aFL != null) {
            this.aFL.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_rank_info, (ViewGroup) this, true);
        this.fBn = (TextView) findViewById(a.g.tv_rank);
        this.aFL = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fBa = (TextView) findViewById(a.g.tv_name);
        this.aTU = (TextView) findViewById(a.g.tv_content);
        this.fBo = (TextView) findViewById(a.g.tv_hit);
        this.aFL.setIsRound(true);
        this.aFL.setAutoChangeStyle(false);
        this.aFL.setDefaultBgResource(a.f.sdk_default_avatar);
        this.fBo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.fBp != null) {
                    GuardClubRankInfoView.this.fBp.buW();
                }
            }
        });
    }
}

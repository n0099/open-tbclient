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
/* loaded from: classes4.dex */
public class GuardClubRankInfoView extends RelativeLayout {
    private HeadImageView aFf;
    private TextView aFh;
    private TextView gJi;
    private TextView gJv;
    private TextView gJw;
    private a gJx;

    /* loaded from: classes4.dex */
    public interface a {
        void bTC();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gJx = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.gJv.setText(str);
        this.aFf.startLoad(str2, 12, false, false);
        this.gJi.setText(str3);
        this.aFh.setText(str4);
        this.gJw.setVisibility(z ? 0 : 4);
        if (iA(str)) {
            this.gJv.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_fontsize40));
        } else {
            this.gJv.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
        }
    }

    private boolean iA(String str) {
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
        if (this.aFf != null) {
            this.aFf.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_rank_info, (ViewGroup) this, true);
        this.gJv = (TextView) findViewById(a.f.tv_rank);
        this.aFf = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gJi = (TextView) findViewById(a.f.tv_name);
        this.aFh = (TextView) findViewById(a.f.tv_content);
        this.gJw = (TextView) findViewById(a.f.tv_hit);
        this.aFf.setIsRound(true);
        this.aFf.setAutoChangeStyle(false);
        this.aFf.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gJw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.gJx != null) {
                    GuardClubRankInfoView.this.gJx.bTC();
                }
            }
        });
    }
}

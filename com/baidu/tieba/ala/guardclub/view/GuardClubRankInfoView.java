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
    private HeadImageView aGa;
    private TextView aGc;
    private TextView bhZ;
    private TextView gSm;
    private TextView gSn;
    private a gSo;

    /* loaded from: classes4.dex */
    public interface a {
        void bWF();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gSo = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.gSm.setText(str);
        this.aGa.startLoad(str2, 12, false, false);
        this.bhZ.setText(str3);
        this.aGc.setText(str4);
        this.gSn.setVisibility(z ? 0 : 4);
        if (iY(str)) {
            this.gSm.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_fontsize40));
        } else {
            this.gSm.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
        }
    }

    private boolean iY(String str) {
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
        if (this.aGa != null) {
            this.aGa.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_rank_info, (ViewGroup) this, true);
        this.gSm = (TextView) findViewById(a.f.tv_rank);
        this.aGa = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bhZ = (TextView) findViewById(a.f.tv_name);
        this.aGc = (TextView) findViewById(a.f.tv_content);
        this.gSn = (TextView) findViewById(a.f.tv_hit);
        this.aGa.setIsRound(true);
        this.aGa.setAutoChangeStyle(false);
        this.aGa.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gSn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.gSo != null) {
                    GuardClubRankInfoView.this.gSo.bWF();
                }
            }
        });
    }
}

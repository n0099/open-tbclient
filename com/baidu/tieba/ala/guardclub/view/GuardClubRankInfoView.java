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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class GuardClubRankInfoView extends RelativeLayout {
    private HeadImageView aeR;
    private TextView apB;
    private TextView eDi;
    private TextView eDv;
    private TextView eDw;
    private a eDx;

    /* loaded from: classes2.dex */
    public interface a {
        void bdf();
    }

    public GuardClubRankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.eDx = aVar;
    }

    public void setData(String str, String str2, String str3, String str4, boolean z) {
        this.eDv.setText(str);
        this.aeR.startLoad(str2, 12, false, false);
        this.eDi.setText(str3);
        this.apB.setText(str4);
        this.eDw.setVisibility(z ? 0 : 4);
        if (dN(str)) {
            this.eDv.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        } else {
            this.eDv.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
        }
    }

    private boolean dN(String str) {
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
        if (this.aeR != null) {
            this.aeR.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(Color.parseColor("#FF201443"));
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, 0, 0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_rank_info, (ViewGroup) this, true);
        this.eDv = (TextView) findViewById(a.g.tv_rank);
        this.aeR = (HeadImageView) findViewById(a.g.iv_avatar);
        this.eDi = (TextView) findViewById(a.g.tv_name);
        this.apB = (TextView) findViewById(a.g.tv_content);
        this.eDw = (TextView) findViewById(a.g.tv_hit);
        this.aeR.setIsRound(true);
        this.aeR.setAutoChangeStyle(false);
        this.aeR.setDefaultBgResource(a.f.sdk_default_avatar);
        this.eDw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GuardClubRankInfoView.this.eDx != null) {
                    GuardClubRankInfoView.this.eDx.bdf();
                }
            }
        });
    }
}

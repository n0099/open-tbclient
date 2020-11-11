package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class GuardClubInfoHeaderView extends LinearLayout {
    public TextView aFA;
    public TextView gGf;
    public HeadImageView gIK;
    public TbImageView gIL;
    public ImageView gIM;
    public ImageView gIN;
    public TextView gIO;
    public ProgressBar gIP;
    public TextView gIQ;
    public LinearLayout gIR;
    public TextView gIS;
    public TextView gIT;
    public LinearLayout gIU;
    public TextView gIV;
    public TextView gxm;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.aFA.setTypeface(Typeface.defaultFromStyle(0));
                this.gGf.setTypeface(Typeface.defaultFromStyle(0));
                this.gIQ.setTextColor(getResources().getColor(a.c.sdk_white_alpha60));
                this.gIT.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.gxm.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.e.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds30), getResources().getDimensionPixelOffset(a.d.sdk_ds32), getResources().getDimensionPixelOffset(a.d.sdk_ds56), getResources().getDimensionPixelOffset(a.d.sdk_ds30));
                this.aFA.setTypeface(Typeface.defaultFromStyle(1));
                this.gGf.setTypeface(Typeface.defaultFromStyle(1));
                this.gIQ.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
                this.gIT.setTextColor(-11337753);
                this.gxm.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.gIK = (HeadImageView) findViewById(a.f.header_imageView);
        this.gIL = (TbImageView) findViewById(a.f.headwear_imageView);
        this.aFA = (TextView) findViewById(a.f.name_textView);
        this.gGf = (TextView) findViewById(a.f.nameSuffix_textView);
        this.gIM = (ImageView) findViewById(a.f.edit_imageView);
        this.gIN = (ImageView) findViewById(a.f.explain_imageView);
        this.gIO = (TextView) findViewById(a.f.score_textView);
        this.gIP = (ProgressBar) findViewById(a.f.score_progressBar);
        this.gIQ = (TextView) findViewById(a.f.next_textView);
        this.gIR = (LinearLayout) findViewById(a.f.memberNum_layout);
        this.gIS = (TextView) findViewById(a.f.memberNumTitle_textView);
        this.gIT = (TextView) findViewById(a.f.memberNum_textView);
        this.gIU = (LinearLayout) findViewById(a.f.rank_layout);
        this.gIV = (TextView) findViewById(a.f.rankTitle_textView);
        this.gxm = (TextView) findViewById(a.f.rank_textView);
    }
}

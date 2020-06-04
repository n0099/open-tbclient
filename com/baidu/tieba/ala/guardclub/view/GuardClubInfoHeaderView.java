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
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class GuardClubInfoHeaderView extends LinearLayout {
    public TextView aVs;
    public HeadImageView fAM;
    public TbImageView fAN;
    public ImageView fAO;
    public ImageView fAP;
    public TextView fAQ;
    public ProgressBar fAR;
    public TextView fAS;
    public LinearLayout fAT;
    public TextView fAU;
    public TextView fAV;
    public LinearLayout fAW;
    public TextView fAX;
    public TextView fqb;
    public TextView fyb;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.aVs.setTypeface(Typeface.defaultFromStyle(0));
                this.fyb.setTypeface(Typeface.defaultFromStyle(0));
                this.fAS.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.fAV.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.fqb.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.aVs.setTypeface(Typeface.defaultFromStyle(1));
                this.fyb.setTypeface(Typeface.defaultFromStyle(1));
                this.fAS.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.fAV.setTextColor(-11337753);
                this.fqb.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.fAM = (HeadImageView) findViewById(a.g.header_imageView);
        this.fAN = (TbImageView) findViewById(a.g.headwear_imageView);
        this.aVs = (TextView) findViewById(a.g.name_textView);
        this.fyb = (TextView) findViewById(a.g.nameSuffix_textView);
        this.fAO = (ImageView) findViewById(a.g.edit_imageView);
        this.fAP = (ImageView) findViewById(a.g.explain_imageView);
        this.fAQ = (TextView) findViewById(a.g.score_textView);
        this.fAR = (ProgressBar) findViewById(a.g.score_progressBar);
        this.fAS = (TextView) findViewById(a.g.next_textView);
        this.fAT = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.fAU = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.fAV = (TextView) findViewById(a.g.memberNum_textView);
        this.fAW = (LinearLayout) findViewById(a.g.rank_layout);
        this.fAX = (TextView) findViewById(a.g.rankTitle_textView);
        this.fqb = (TextView) findViewById(a.g.rank_textView);
    }
}

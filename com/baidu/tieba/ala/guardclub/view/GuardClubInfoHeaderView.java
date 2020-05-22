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
    public HeadImageView fAB;
    public TbImageView fAC;
    public ImageView fAD;
    public ImageView fAE;
    public TextView fAF;
    public ProgressBar fAG;
    public TextView fAH;
    public LinearLayout fAI;
    public TextView fAJ;
    public TextView fAK;
    public LinearLayout fAL;
    public TextView fAM;
    public TextView fpQ;
    public TextView fxQ;

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
                this.fxQ.setTypeface(Typeface.defaultFromStyle(0));
                this.fAH.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.fAK.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.fpQ.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.aVs.setTypeface(Typeface.defaultFromStyle(1));
                this.fxQ.setTypeface(Typeface.defaultFromStyle(1));
                this.fAH.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.fAK.setTextColor(-11337753);
                this.fpQ.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.fAB = (HeadImageView) findViewById(a.g.header_imageView);
        this.fAC = (TbImageView) findViewById(a.g.headwear_imageView);
        this.aVs = (TextView) findViewById(a.g.name_textView);
        this.fxQ = (TextView) findViewById(a.g.nameSuffix_textView);
        this.fAD = (ImageView) findViewById(a.g.edit_imageView);
        this.fAE = (ImageView) findViewById(a.g.explain_imageView);
        this.fAF = (TextView) findViewById(a.g.score_textView);
        this.fAG = (ProgressBar) findViewById(a.g.score_progressBar);
        this.fAH = (TextView) findViewById(a.g.next_textView);
        this.fAI = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.fAJ = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.fAK = (TextView) findViewById(a.g.memberNum_textView);
        this.fAL = (LinearLayout) findViewById(a.g.rank_layout);
        this.fAM = (TextView) findViewById(a.g.rankTitle_textView);
        this.fpQ = (TextView) findViewById(a.g.rank_textView);
    }
}

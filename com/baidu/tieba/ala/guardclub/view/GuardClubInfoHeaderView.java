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
    public TextView aPd;
    public TextView fci;
    public TextView fkf;
    public HeadImageView fmP;
    public TbImageView fmQ;
    public ImageView fmR;
    public ImageView fmS;
    public TextView fmT;
    public ProgressBar fmU;
    public TextView fmV;
    public LinearLayout fmW;
    public TextView fmX;
    public TextView fmY;
    public LinearLayout fmZ;
    public TextView fna;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.aPd.setTypeface(Typeface.defaultFromStyle(0));
                this.fkf.setTypeface(Typeface.defaultFromStyle(0));
                this.fmV.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.fmY.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.fci.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.aPd.setTypeface(Typeface.defaultFromStyle(1));
                this.fkf.setTypeface(Typeface.defaultFromStyle(1));
                this.fmV.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.fmY.setTextColor(-11337753);
                this.fci.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.fmP = (HeadImageView) findViewById(a.g.header_imageView);
        this.fmQ = (TbImageView) findViewById(a.g.headwear_imageView);
        this.aPd = (TextView) findViewById(a.g.name_textView);
        this.fkf = (TextView) findViewById(a.g.nameSuffix_textView);
        this.fmR = (ImageView) findViewById(a.g.edit_imageView);
        this.fmS = (ImageView) findViewById(a.g.explain_imageView);
        this.fmT = (TextView) findViewById(a.g.score_textView);
        this.fmU = (ProgressBar) findViewById(a.g.score_progressBar);
        this.fmV = (TextView) findViewById(a.g.next_textView);
        this.fmW = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.fmX = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.fmY = (TextView) findViewById(a.g.memberNum_textView);
        this.fmZ = (LinearLayout) findViewById(a.g.rank_layout);
        this.fna = (TextView) findViewById(a.g.rankTitle_textView);
        this.fci = (TextView) findViewById(a.g.rank_textView);
    }
}

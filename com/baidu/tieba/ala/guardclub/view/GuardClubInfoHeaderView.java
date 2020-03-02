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
    public TextView avp;
    public TextView eFb;
    public TextView eGy;
    public HeadImageView eHP;
    public TbImageView eHQ;
    public ImageView eHR;
    public ImageView eHS;
    public TextView eHT;
    public ProgressBar eHU;
    public TextView eHV;
    public LinearLayout eHW;
    public TextView eHX;
    public TextView eHY;
    public LinearLayout eHZ;
    public TextView eIa;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.avp.setTypeface(Typeface.defaultFromStyle(0));
                this.eFb.setTypeface(Typeface.defaultFromStyle(0));
                this.eHV.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.eHY.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.eGy.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.avp.setTypeface(Typeface.defaultFromStyle(1));
                this.eFb.setTypeface(Typeface.defaultFromStyle(1));
                this.eHV.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.eHY.setTextColor(-11337753);
                this.eGy.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.eHP = (HeadImageView) findViewById(a.g.header_imageView);
        this.eHQ = (TbImageView) findViewById(a.g.headwear_imageView);
        this.avp = (TextView) findViewById(a.g.name_textView);
        this.eFb = (TextView) findViewById(a.g.nameSuffix_textView);
        this.eHR = (ImageView) findViewById(a.g.edit_imageView);
        this.eHS = (ImageView) findViewById(a.g.explain_imageView);
        this.eHT = (TextView) findViewById(a.g.score_textView);
        this.eHU = (ProgressBar) findViewById(a.g.score_progressBar);
        this.eHV = (TextView) findViewById(a.g.next_textView);
        this.eHW = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.eHX = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.eHY = (TextView) findViewById(a.g.memberNum_textView);
        this.eHZ = (LinearLayout) findViewById(a.g.rank_layout);
        this.eIa = (TextView) findViewById(a.g.rankTitle_textView);
        this.eGy = (TextView) findViewById(a.g.rank_textView);
    }
}

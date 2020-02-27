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
    public TextView eFa;
    public TextView eGx;
    public HeadImageView eHO;
    public TbImageView eHP;
    public ImageView eHQ;
    public ImageView eHR;
    public TextView eHS;
    public ProgressBar eHT;
    public TextView eHU;
    public LinearLayout eHV;
    public TextView eHW;
    public TextView eHX;
    public LinearLayout eHY;
    public TextView eHZ;

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
                this.eFa.setTypeface(Typeface.defaultFromStyle(0));
                this.eHU.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.eHX.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.eGx.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.avp.setTypeface(Typeface.defaultFromStyle(1));
                this.eFa.setTypeface(Typeface.defaultFromStyle(1));
                this.eHU.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.eHX.setTextColor(-11337753);
                this.eGx.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.eHO = (HeadImageView) findViewById(a.g.header_imageView);
        this.eHP = (TbImageView) findViewById(a.g.headwear_imageView);
        this.avp = (TextView) findViewById(a.g.name_textView);
        this.eFa = (TextView) findViewById(a.g.nameSuffix_textView);
        this.eHQ = (ImageView) findViewById(a.g.edit_imageView);
        this.eHR = (ImageView) findViewById(a.g.explain_imageView);
        this.eHS = (TextView) findViewById(a.g.score_textView);
        this.eHT = (ProgressBar) findViewById(a.g.score_progressBar);
        this.eHU = (TextView) findViewById(a.g.next_textView);
        this.eHV = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.eHW = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.eHX = (TextView) findViewById(a.g.memberNum_textView);
        this.eHY = (LinearLayout) findViewById(a.g.rank_layout);
        this.eHZ = (TextView) findViewById(a.g.rankTitle_textView);
        this.eGx = (TextView) findViewById(a.g.rank_textView);
    }
}

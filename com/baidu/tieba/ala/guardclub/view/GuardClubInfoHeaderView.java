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
    public TextView aEC;
    public TextView ghv;
    public TextView gqm;
    public HeadImageView gsS;
    public TbImageView gsT;
    public ImageView gsU;
    public ImageView gsV;
    public TextView gsW;
    public ProgressBar gsX;
    public TextView gsY;
    public LinearLayout gsZ;
    public TextView gta;
    public TextView gtb;
    public LinearLayout gtc;
    public TextView gtd;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.aEC.setTypeface(Typeface.defaultFromStyle(0));
                this.gqm.setTypeface(Typeface.defaultFromStyle(0));
                this.gsY.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.gtb.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.ghv.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.aEC.setTypeface(Typeface.defaultFromStyle(1));
                this.gqm.setTypeface(Typeface.defaultFromStyle(1));
                this.gsY.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.gtb.setTextColor(-11337753);
                this.ghv.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.gsS = (HeadImageView) findViewById(a.g.header_imageView);
        this.gsT = (TbImageView) findViewById(a.g.headwear_imageView);
        this.aEC = (TextView) findViewById(a.g.name_textView);
        this.gqm = (TextView) findViewById(a.g.nameSuffix_textView);
        this.gsU = (ImageView) findViewById(a.g.edit_imageView);
        this.gsV = (ImageView) findViewById(a.g.explain_imageView);
        this.gsW = (TextView) findViewById(a.g.score_textView);
        this.gsX = (ProgressBar) findViewById(a.g.score_progressBar);
        this.gsY = (TextView) findViewById(a.g.next_textView);
        this.gsZ = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.gta = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.gtb = (TextView) findViewById(a.g.memberNum_textView);
        this.gtc = (LinearLayout) findViewById(a.g.rank_layout);
        this.gtd = (TextView) findViewById(a.g.rankTitle_textView);
        this.ghv = (TextView) findViewById(a.g.rank_textView);
    }
}

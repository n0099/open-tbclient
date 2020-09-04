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
/* loaded from: classes7.dex */
public class GuardClubInfoHeaderView extends LinearLayout {
    public TextView aAR;
    public TextView fRR;
    public TextView gaJ;
    public TextView gdA;
    public LinearLayout gdB;
    public TextView gdC;
    public HeadImageView gdr;
    public TbImageView gds;
    public ImageView gdt;
    public ImageView gdu;
    public TextView gdv;
    public ProgressBar gdw;
    public TextView gdx;
    public LinearLayout gdy;
    public TextView gdz;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.aAR.setTypeface(Typeface.defaultFromStyle(0));
                this.gaJ.setTypeface(Typeface.defaultFromStyle(0));
                this.gdx.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.gdA.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.fRR.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.aAR.setTypeface(Typeface.defaultFromStyle(1));
                this.gaJ.setTypeface(Typeface.defaultFromStyle(1));
                this.gdx.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.gdA.setTextColor(-11337753);
                this.fRR.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.gdr = (HeadImageView) findViewById(a.g.header_imageView);
        this.gds = (TbImageView) findViewById(a.g.headwear_imageView);
        this.aAR = (TextView) findViewById(a.g.name_textView);
        this.gaJ = (TextView) findViewById(a.g.nameSuffix_textView);
        this.gdt = (ImageView) findViewById(a.g.edit_imageView);
        this.gdu = (ImageView) findViewById(a.g.explain_imageView);
        this.gdv = (TextView) findViewById(a.g.score_textView);
        this.gdw = (ProgressBar) findViewById(a.g.score_progressBar);
        this.gdx = (TextView) findViewById(a.g.next_textView);
        this.gdy = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.gdz = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.gdA = (TextView) findViewById(a.g.memberNum_textView);
        this.gdB = (LinearLayout) findViewById(a.g.rank_layout);
        this.gdC = (TextView) findViewById(a.g.rankTitle_textView);
        this.fRR = (TextView) findViewById(a.g.rank_textView);
    }
}

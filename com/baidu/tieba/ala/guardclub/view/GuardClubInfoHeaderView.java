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
    public TextView avN;
    public TextView fGw;
    public TextView fOG;
    public TextView fRA;
    public HeadImageView fRp;
    public TbImageView fRq;
    public ImageView fRr;
    public ImageView fRs;
    public TextView fRt;
    public ProgressBar fRu;
    public TextView fRv;
    public LinearLayout fRw;
    public TextView fRx;
    public TextView fRy;
    public LinearLayout fRz;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.avN.setTypeface(Typeface.defaultFromStyle(0));
                this.fOG.setTypeface(Typeface.defaultFromStyle(0));
                this.fRv.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.fRy.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.fGw.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.avN.setTypeface(Typeface.defaultFromStyle(1));
                this.fOG.setTypeface(Typeface.defaultFromStyle(1));
                this.fRv.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.fRy.setTextColor(-11337753);
                this.fGw.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.fRp = (HeadImageView) findViewById(a.g.header_imageView);
        this.fRq = (TbImageView) findViewById(a.g.headwear_imageView);
        this.avN = (TextView) findViewById(a.g.name_textView);
        this.fOG = (TextView) findViewById(a.g.nameSuffix_textView);
        this.fRr = (ImageView) findViewById(a.g.edit_imageView);
        this.fRs = (ImageView) findViewById(a.g.explain_imageView);
        this.fRt = (TextView) findViewById(a.g.score_textView);
        this.fRu = (ProgressBar) findViewById(a.g.score_progressBar);
        this.fRv = (TextView) findViewById(a.g.next_textView);
        this.fRw = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.fRx = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.fRy = (TextView) findViewById(a.g.memberNum_textView);
        this.fRz = (LinearLayout) findViewById(a.g.rank_layout);
        this.fRA = (TextView) findViewById(a.g.rankTitle_textView);
        this.fGw = (TextView) findViewById(a.g.rank_textView);
    }
}

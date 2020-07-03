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
/* loaded from: classes3.dex */
public class GuardClubInfoHeaderView extends LinearLayout {
    public TextView aXZ;
    public TextView fBm;
    public TextView fJl;
    public HeadImageView fLV;
    public TbImageView fLW;
    public ImageView fLX;
    public ImageView fLY;
    public TextView fLZ;
    public ProgressBar fMa;
    public TextView fMb;
    public LinearLayout fMc;
    public TextView fMd;
    public TextView fMe;
    public LinearLayout fMf;
    public TextView fMg;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.aXZ.setTypeface(Typeface.defaultFromStyle(0));
                this.fJl.setTypeface(Typeface.defaultFromStyle(0));
                this.fMb.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.fMe.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.fBm.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.aXZ.setTypeface(Typeface.defaultFromStyle(1));
                this.fJl.setTypeface(Typeface.defaultFromStyle(1));
                this.fMb.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.fMe.setTextColor(-11337753);
                this.fBm.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.fLV = (HeadImageView) findViewById(a.g.header_imageView);
        this.fLW = (TbImageView) findViewById(a.g.headwear_imageView);
        this.aXZ = (TextView) findViewById(a.g.name_textView);
        this.fJl = (TextView) findViewById(a.g.nameSuffix_textView);
        this.fLX = (ImageView) findViewById(a.g.edit_imageView);
        this.fLY = (ImageView) findViewById(a.g.explain_imageView);
        this.fLZ = (TextView) findViewById(a.g.score_textView);
        this.fMa = (ProgressBar) findViewById(a.g.score_progressBar);
        this.fMb = (TextView) findViewById(a.g.next_textView);
        this.fMc = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.fMd = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.fMe = (TextView) findViewById(a.g.memberNum_textView);
        this.fMf = (LinearLayout) findViewById(a.g.rank_layout);
        this.fMg = (TextView) findViewById(a.g.rankTitle_textView);
        this.fBm = (TextView) findViewById(a.g.rank_textView);
    }
}

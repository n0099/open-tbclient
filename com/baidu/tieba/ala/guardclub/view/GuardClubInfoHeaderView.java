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
    public TextView aPj;
    public TextView fcn;
    public TextView fkk;
    public HeadImageView fmU;
    public TbImageView fmV;
    public ImageView fmW;
    public ImageView fmX;
    public TextView fmY;
    public ProgressBar fmZ;
    public TextView fna;
    public LinearLayout fnb;
    public TextView fnc;
    public TextView fnd;
    public LinearLayout fne;
    public TextView fnf;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.aPj.setTypeface(Typeface.defaultFromStyle(0));
                this.fkk.setTypeface(Typeface.defaultFromStyle(0));
                this.fna.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.fnd.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.fcn.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.aPj.setTypeface(Typeface.defaultFromStyle(1));
                this.fkk.setTypeface(Typeface.defaultFromStyle(1));
                this.fna.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.fnd.setTextColor(-11337753);
                this.fcn.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.fmU = (HeadImageView) findViewById(a.g.header_imageView);
        this.fmV = (TbImageView) findViewById(a.g.headwear_imageView);
        this.aPj = (TextView) findViewById(a.g.name_textView);
        this.fkk = (TextView) findViewById(a.g.nameSuffix_textView);
        this.fmW = (ImageView) findViewById(a.g.edit_imageView);
        this.fmX = (ImageView) findViewById(a.g.explain_imageView);
        this.fmY = (TextView) findViewById(a.g.score_textView);
        this.fmZ = (ProgressBar) findViewById(a.g.score_progressBar);
        this.fna = (TextView) findViewById(a.g.next_textView);
        this.fnb = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.fnc = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.fnd = (TextView) findViewById(a.g.memberNum_textView);
        this.fne = (LinearLayout) findViewById(a.g.rank_layout);
        this.fnf = (TextView) findViewById(a.g.rankTitle_textView);
        this.fcn = (TextView) findViewById(a.g.rank_textView);
    }
}

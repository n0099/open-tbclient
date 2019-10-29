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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes6.dex */
public class GuardClubInfoHeaderView extends LinearLayout {
    public TextView dMf;
    public TextView dMg;
    public TextView dNH;
    public TextView dPA;
    public LinearLayout dPB;
    public TextView dPC;
    public TextView dPD;
    public LinearLayout dPE;
    public TextView dPF;
    public HeadImageView dPu;
    public TbImageView dPv;
    public ImageView dPw;
    public ImageView dPx;
    public TextView dPy;
    public ProgressBar dPz;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.dMf.setTypeface(Typeface.defaultFromStyle(0));
                this.dMg.setTypeface(Typeface.defaultFromStyle(0));
                this.dPA.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.dPD.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.dNH.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.dMf.setTypeface(Typeface.defaultFromStyle(1));
                this.dMg.setTypeface(Typeface.defaultFromStyle(1));
                this.dPA.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.dPD.setTextColor(-11337753);
                this.dNH.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.dPu = (HeadImageView) findViewById(a.g.header_imageView);
        this.dPv = (TbImageView) findViewById(a.g.headwear_imageView);
        this.dMf = (TextView) findViewById(a.g.name_textView);
        this.dMg = (TextView) findViewById(a.g.nameSuffix_textView);
        this.dPw = (ImageView) findViewById(a.g.edit_imageView);
        this.dPx = (ImageView) findViewById(a.g.explain_imageView);
        this.dPy = (TextView) findViewById(a.g.score_textView);
        this.dPz = (ProgressBar) findViewById(a.g.score_progressBar);
        this.dPA = (TextView) findViewById(a.g.next_textView);
        this.dPB = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.dPC = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.dPD = (TextView) findViewById(a.g.memberNum_textView);
        this.dPE = (LinearLayout) findViewById(a.g.rank_layout);
        this.dPF = (TextView) findViewById(a.g.rankTitle_textView);
        this.dNH = (TextView) findViewById(a.g.rank_textView);
    }
}

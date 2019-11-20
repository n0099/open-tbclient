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
    public TextView dLo;
    public TextView dLp;
    public TextView dMQ;
    public HeadImageView dOD;
    public TbImageView dOE;
    public ImageView dOF;
    public ImageView dOG;
    public TextView dOH;
    public ProgressBar dOI;
    public TextView dOJ;
    public LinearLayout dOK;
    public TextView dOL;
    public TextView dOM;
    public LinearLayout dON;
    public TextView dOO;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.dLo.setTypeface(Typeface.defaultFromStyle(0));
                this.dLp.setTypeface(Typeface.defaultFromStyle(0));
                this.dOJ.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.dOM.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.dMQ.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.dLo.setTypeface(Typeface.defaultFromStyle(1));
                this.dLp.setTypeface(Typeface.defaultFromStyle(1));
                this.dOJ.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.dOM.setTextColor(-11337753);
                this.dMQ.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.dOD = (HeadImageView) findViewById(a.g.header_imageView);
        this.dOE = (TbImageView) findViewById(a.g.headwear_imageView);
        this.dLo = (TextView) findViewById(a.g.name_textView);
        this.dLp = (TextView) findViewById(a.g.nameSuffix_textView);
        this.dOF = (ImageView) findViewById(a.g.edit_imageView);
        this.dOG = (ImageView) findViewById(a.g.explain_imageView);
        this.dOH = (TextView) findViewById(a.g.score_textView);
        this.dOI = (ProgressBar) findViewById(a.g.score_progressBar);
        this.dOJ = (TextView) findViewById(a.g.next_textView);
        this.dOK = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.dOL = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.dOM = (TextView) findViewById(a.g.memberNum_textView);
        this.dON = (LinearLayout) findViewById(a.g.rank_layout);
        this.dOO = (TextView) findViewById(a.g.rankTitle_textView);
        this.dMQ = (TextView) findViewById(a.g.rank_textView);
    }
}

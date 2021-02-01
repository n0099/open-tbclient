package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes11.dex */
public class GuardClubInfoHeaderView extends LinearLayout {
    public TextView aDM;
    public TextView gPr;
    public TextView gYM;
    public TextView hbA;
    public TextView hbB;
    public LinearLayout hbC;
    public TextView hbD;
    public View hbE;
    public TextView hbF;
    public ImageView hbG;
    public HeadImageView hbr;
    public TbImageView hbs;
    public ImageView hbt;
    public ImageView hbu;
    public ImageView hbv;
    public TextView hbw;
    public ProgressBar hbx;
    public TextView hby;
    public LinearLayout hbz;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                if (this.aDM != null) {
                    this.aDM.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.gYM != null) {
                    this.gYM.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.hby != null) {
                    this.hby.setTextColor(getResources().getColor(a.c.sdk_white_alpha60));
                }
                if (this.hbB != null) {
                    this.hbB.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                }
                if (this.gPr != null) {
                    this.gPr.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                }
                if (this.hbv != null) {
                    this.hbv.setVisibility(0);
                    return;
                }
                return;
            case 1:
                setBackgroundResource(a.e.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds30), getResources().getDimensionPixelOffset(a.d.sdk_ds32), getResources().getDimensionPixelOffset(a.d.sdk_ds56), getResources().getDimensionPixelOffset(a.d.sdk_ds30));
                if (this.aDM != null) {
                    this.aDM.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (this.gYM != null) {
                    this.gYM.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (this.hby != null) {
                    this.hby.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
                }
                if (this.hbB != null) {
                    this.hbB.setTextColor(-11337753);
                }
                if (this.gPr != null) {
                    this.gPr.setTextColor(-11337753);
                }
                if (this.hbu != null) {
                    this.hbu.setVisibility(0);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.hbr = (HeadImageView) findViewById(a.f.header_imageView);
        this.hbs = (TbImageView) findViewById(a.f.headwear_imageView);
        this.aDM = (TextView) findViewById(a.f.name_textView);
        this.gYM = (TextView) findViewById(a.f.nameSuffix_textView);
        this.hbt = (ImageView) findViewById(a.f.edit_imageView);
        this.hbu = (ImageView) findViewById(a.f.explain_imageView_left);
        this.hbv = (ImageView) findViewById(a.f.explain_imageView_right);
        this.hbw = (TextView) findViewById(a.f.score_textView);
        this.hbx = (ProgressBar) findViewById(a.f.score_progressBar);
        this.hby = (TextView) findViewById(a.f.next_textView);
        this.hbz = (LinearLayout) findViewById(a.f.memberNum_layout);
        this.hbA = (TextView) findViewById(a.f.memberNumTitle_textView);
        this.hbB = (TextView) findViewById(a.f.memberNum_textView);
        this.hbC = (LinearLayout) findViewById(a.f.rank_layout);
        this.hbD = (TextView) findViewById(a.f.rankTitle_textView);
        this.gPr = (TextView) findViewById(a.f.rank_textView);
        this.hbE = findViewById(a.f.modify_clubname);
        this.hbG = (ImageView) findViewById(a.f.rename_pen);
        this.hbF = (TextView) findViewById(a.f.rename_text);
    }
}

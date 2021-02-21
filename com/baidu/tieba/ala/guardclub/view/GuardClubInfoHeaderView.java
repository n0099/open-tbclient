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
    public TextView gPF;
    public TextView gZa;
    public HeadImageView hbF;
    public TbImageView hbG;
    public ImageView hbH;
    public ImageView hbI;
    public ImageView hbJ;
    public TextView hbK;
    public ProgressBar hbL;
    public TextView hbM;
    public LinearLayout hbN;
    public TextView hbO;
    public TextView hbP;
    public LinearLayout hbQ;
    public TextView hbR;
    public View hbS;
    public TextView hbT;
    public ImageView hbU;

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
                if (this.gZa != null) {
                    this.gZa.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.hbM != null) {
                    this.hbM.setTextColor(getResources().getColor(a.c.sdk_white_alpha60));
                }
                if (this.hbP != null) {
                    this.hbP.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                }
                if (this.gPF != null) {
                    this.gPF.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                }
                if (this.hbJ != null) {
                    this.hbJ.setVisibility(0);
                    return;
                }
                return;
            case 1:
                setBackgroundResource(a.e.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds30), getResources().getDimensionPixelOffset(a.d.sdk_ds32), getResources().getDimensionPixelOffset(a.d.sdk_ds56), getResources().getDimensionPixelOffset(a.d.sdk_ds30));
                if (this.aDM != null) {
                    this.aDM.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (this.gZa != null) {
                    this.gZa.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (this.hbM != null) {
                    this.hbM.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
                }
                if (this.hbP != null) {
                    this.hbP.setTextColor(-11337753);
                }
                if (this.gPF != null) {
                    this.gPF.setTextColor(-11337753);
                }
                if (this.hbI != null) {
                    this.hbI.setVisibility(0);
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
        this.hbF = (HeadImageView) findViewById(a.f.header_imageView);
        this.hbG = (TbImageView) findViewById(a.f.headwear_imageView);
        this.aDM = (TextView) findViewById(a.f.name_textView);
        this.gZa = (TextView) findViewById(a.f.nameSuffix_textView);
        this.hbH = (ImageView) findViewById(a.f.edit_imageView);
        this.hbI = (ImageView) findViewById(a.f.explain_imageView_left);
        this.hbJ = (ImageView) findViewById(a.f.explain_imageView_right);
        this.hbK = (TextView) findViewById(a.f.score_textView);
        this.hbL = (ProgressBar) findViewById(a.f.score_progressBar);
        this.hbM = (TextView) findViewById(a.f.next_textView);
        this.hbN = (LinearLayout) findViewById(a.f.memberNum_layout);
        this.hbO = (TextView) findViewById(a.f.memberNumTitle_textView);
        this.hbP = (TextView) findViewById(a.f.memberNum_textView);
        this.hbQ = (LinearLayout) findViewById(a.f.rank_layout);
        this.hbR = (TextView) findViewById(a.f.rankTitle_textView);
        this.gPF = (TextView) findViewById(a.f.rank_textView);
        this.hbS = findViewById(a.f.modify_clubname);
        this.hbU = (ImageView) findViewById(a.f.rename_pen);
        this.hbT = (TextView) findViewById(a.f.rename_text);
    }
}

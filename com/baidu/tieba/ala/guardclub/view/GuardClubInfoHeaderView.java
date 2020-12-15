package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
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
    public TextView aGv;
    public TextView gFG;
    public TextView gOV;
    public HeadImageView gRA;
    public TbImageView gRB;
    public ImageView gRC;
    public ImageView gRD;
    public ImageView gRE;
    public TextView gRF;
    public ProgressBar gRG;
    public TextView gRH;
    public LinearLayout gRI;
    public TextView gRJ;
    public TextView gRK;
    public LinearLayout gRL;
    public TextView gRM;
    public View gRN;
    public TextView gRO;
    public ImageView gRP;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                if (this.aGv != null) {
                    this.aGv.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.gOV != null) {
                    this.gOV.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.gRH != null) {
                    this.gRH.setTextColor(getResources().getColor(a.c.sdk_white_alpha60));
                }
                if (this.gRK != null) {
                    this.gRK.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                }
                if (this.gFG != null) {
                    this.gFG.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                }
                if (this.gRE != null) {
                    this.gRE.setVisibility(0);
                    return;
                }
                return;
            case 1:
                setBackgroundResource(a.e.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds30), getResources().getDimensionPixelOffset(a.d.sdk_ds32), getResources().getDimensionPixelOffset(a.d.sdk_ds56), getResources().getDimensionPixelOffset(a.d.sdk_ds30));
                if (this.aGv != null) {
                    this.aGv.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (this.gOV != null) {
                    this.gOV.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (this.gRH != null) {
                    this.gRH.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
                }
                if (this.gRK != null) {
                    this.gRK.setTextColor(-11337753);
                }
                if (this.gFG != null) {
                    this.gFG.setTextColor(-11337753);
                }
                if (this.gRD != null) {
                    this.gRD.setVisibility(0);
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
        this.gRA = (HeadImageView) findViewById(a.f.header_imageView);
        this.gRB = (TbImageView) findViewById(a.f.headwear_imageView);
        this.aGv = (TextView) findViewById(a.f.name_textView);
        this.gOV = (TextView) findViewById(a.f.nameSuffix_textView);
        this.gRC = (ImageView) findViewById(a.f.edit_imageView);
        this.gRD = (ImageView) findViewById(a.f.explain_imageView_left);
        this.gRE = (ImageView) findViewById(a.f.explain_imageView_right);
        this.gRF = (TextView) findViewById(a.f.score_textView);
        this.gRG = (ProgressBar) findViewById(a.f.score_progressBar);
        this.gRH = (TextView) findViewById(a.f.next_textView);
        this.gRI = (LinearLayout) findViewById(a.f.memberNum_layout);
        this.gRJ = (TextView) findViewById(a.f.memberNumTitle_textView);
        this.gRK = (TextView) findViewById(a.f.memberNum_textView);
        this.gRL = (LinearLayout) findViewById(a.f.rank_layout);
        this.gRM = (TextView) findViewById(a.f.rankTitle_textView);
        this.gFG = (TextView) findViewById(a.f.rank_textView);
        this.gRN = findViewById(a.f.modify_clubname);
        this.gRP = (ImageView) findViewById(a.f.rename_pen);
        this.gRO = (TextView) findViewById(a.f.rename_text);
    }
}

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
    public TextView gFE;
    public TextView gOT;
    public ImageView gRA;
    public ImageView gRB;
    public ImageView gRC;
    public TextView gRD;
    public ProgressBar gRE;
    public TextView gRF;
    public LinearLayout gRG;
    public TextView gRH;
    public TextView gRI;
    public LinearLayout gRJ;
    public TextView gRK;
    public View gRL;
    public TextView gRM;
    public ImageView gRN;
    public HeadImageView gRy;
    public TbImageView gRz;

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
                if (this.gOT != null) {
                    this.gOT.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.gRF != null) {
                    this.gRF.setTextColor(getResources().getColor(a.c.sdk_white_alpha60));
                }
                if (this.gRI != null) {
                    this.gRI.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                }
                if (this.gFE != null) {
                    this.gFE.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                }
                if (this.gRC != null) {
                    this.gRC.setVisibility(0);
                    return;
                }
                return;
            case 1:
                setBackgroundResource(a.e.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds30), getResources().getDimensionPixelOffset(a.d.sdk_ds32), getResources().getDimensionPixelOffset(a.d.sdk_ds56), getResources().getDimensionPixelOffset(a.d.sdk_ds30));
                if (this.aGv != null) {
                    this.aGv.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (this.gOT != null) {
                    this.gOT.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (this.gRF != null) {
                    this.gRF.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
                }
                if (this.gRI != null) {
                    this.gRI.setTextColor(-11337753);
                }
                if (this.gFE != null) {
                    this.gFE.setTextColor(-11337753);
                }
                if (this.gRB != null) {
                    this.gRB.setVisibility(0);
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
        this.gRy = (HeadImageView) findViewById(a.f.header_imageView);
        this.gRz = (TbImageView) findViewById(a.f.headwear_imageView);
        this.aGv = (TextView) findViewById(a.f.name_textView);
        this.gOT = (TextView) findViewById(a.f.nameSuffix_textView);
        this.gRA = (ImageView) findViewById(a.f.edit_imageView);
        this.gRB = (ImageView) findViewById(a.f.explain_imageView_left);
        this.gRC = (ImageView) findViewById(a.f.explain_imageView_right);
        this.gRD = (TextView) findViewById(a.f.score_textView);
        this.gRE = (ProgressBar) findViewById(a.f.score_progressBar);
        this.gRF = (TextView) findViewById(a.f.next_textView);
        this.gRG = (LinearLayout) findViewById(a.f.memberNum_layout);
        this.gRH = (TextView) findViewById(a.f.memberNumTitle_textView);
        this.gRI = (TextView) findViewById(a.f.memberNum_textView);
        this.gRJ = (LinearLayout) findViewById(a.f.rank_layout);
        this.gRK = (TextView) findViewById(a.f.rankTitle_textView);
        this.gFE = (TextView) findViewById(a.f.rank_textView);
        this.gRL = findViewById(a.f.modify_clubname);
        this.gRN = (ImageView) findViewById(a.f.rename_pen);
        this.gRM = (TextView) findViewById(a.f.rename_text);
    }
}

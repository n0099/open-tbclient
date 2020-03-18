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
    public TextView avA;
    public TextView eFK;
    public TextView eHh;
    public ImageView eIA;
    public ImageView eIB;
    public TextView eIC;
    public ProgressBar eID;
    public TextView eIE;
    public LinearLayout eIF;
    public TextView eIG;
    public TextView eIH;
    public LinearLayout eII;
    public TextView eIJ;
    public HeadImageView eIy;
    public TbImageView eIz;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.avA.setTypeface(Typeface.defaultFromStyle(0));
                this.eFK.setTypeface(Typeface.defaultFromStyle(0));
                this.eIE.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.eIH.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.eHh.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.avA.setTypeface(Typeface.defaultFromStyle(1));
                this.eFK.setTypeface(Typeface.defaultFromStyle(1));
                this.eIE.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.eIH.setTextColor(-11337753);
                this.eHh.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.eIy = (HeadImageView) findViewById(a.g.header_imageView);
        this.eIz = (TbImageView) findViewById(a.g.headwear_imageView);
        this.avA = (TextView) findViewById(a.g.name_textView);
        this.eFK = (TextView) findViewById(a.g.nameSuffix_textView);
        this.eIA = (ImageView) findViewById(a.g.edit_imageView);
        this.eIB = (ImageView) findViewById(a.g.explain_imageView);
        this.eIC = (TextView) findViewById(a.g.score_textView);
        this.eID = (ProgressBar) findViewById(a.g.score_progressBar);
        this.eIE = (TextView) findViewById(a.g.next_textView);
        this.eIF = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.eIG = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.eIH = (TextView) findViewById(a.g.memberNum_textView);
        this.eII = (LinearLayout) findViewById(a.g.rank_layout);
        this.eIJ = (TextView) findViewById(a.g.rankTitle_textView);
        this.eHh = (TextView) findViewById(a.g.rank_textView);
    }
}

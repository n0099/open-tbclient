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
/* loaded from: classes10.dex */
public class GuardClubInfoHeaderView extends LinearLayout {
    public TextView aFm;
    public TextView gRo;
    public TextView haJ;
    public TextView hdA;
    public View hdB;
    public TextView hdC;
    public ImageView hdD;
    public HeadImageView hdo;
    public TbImageView hdp;
    public ImageView hdq;
    public ImageView hdr;
    public ImageView hds;
    public TextView hdt;
    public ProgressBar hdu;
    public TextView hdv;
    public LinearLayout hdw;
    public TextView hdx;
    public TextView hdy;
    public LinearLayout hdz;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                if (this.aFm != null) {
                    this.aFm.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.haJ != null) {
                    this.haJ.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.hdv != null) {
                    this.hdv.setTextColor(getResources().getColor(a.c.sdk_white_alpha60));
                }
                if (this.hdy != null) {
                    this.hdy.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                }
                if (this.gRo != null) {
                    this.gRo.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                }
                if (this.hds != null) {
                    this.hds.setVisibility(0);
                    return;
                }
                return;
            case 1:
                setBackgroundResource(a.e.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds30), getResources().getDimensionPixelOffset(a.d.sdk_ds32), getResources().getDimensionPixelOffset(a.d.sdk_ds56), getResources().getDimensionPixelOffset(a.d.sdk_ds30));
                if (this.aFm != null) {
                    this.aFm.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (this.haJ != null) {
                    this.haJ.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (this.hdv != null) {
                    this.hdv.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
                }
                if (this.hdy != null) {
                    this.hdy.setTextColor(-11337753);
                }
                if (this.gRo != null) {
                    this.gRo.setTextColor(-11337753);
                }
                if (this.hdr != null) {
                    this.hdr.setVisibility(0);
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
        this.hdo = (HeadImageView) findViewById(a.f.header_imageView);
        this.hdp = (TbImageView) findViewById(a.f.headwear_imageView);
        this.aFm = (TextView) findViewById(a.f.name_textView);
        this.haJ = (TextView) findViewById(a.f.nameSuffix_textView);
        this.hdq = (ImageView) findViewById(a.f.edit_imageView);
        this.hdr = (ImageView) findViewById(a.f.explain_imageView_left);
        this.hds = (ImageView) findViewById(a.f.explain_imageView_right);
        this.hdt = (TextView) findViewById(a.f.score_textView);
        this.hdu = (ProgressBar) findViewById(a.f.score_progressBar);
        this.hdv = (TextView) findViewById(a.f.next_textView);
        this.hdw = (LinearLayout) findViewById(a.f.memberNum_layout);
        this.hdx = (TextView) findViewById(a.f.memberNumTitle_textView);
        this.hdy = (TextView) findViewById(a.f.memberNum_textView);
        this.hdz = (LinearLayout) findViewById(a.f.rank_layout);
        this.hdA = (TextView) findViewById(a.f.rankTitle_textView);
        this.gRo = (TextView) findViewById(a.f.rank_textView);
        this.hdB = findViewById(a.f.modify_clubname);
        this.hdD = (ImageView) findViewById(a.f.rename_pen);
        this.hdC = (TextView) findViewById(a.f.rename_text);
    }
}

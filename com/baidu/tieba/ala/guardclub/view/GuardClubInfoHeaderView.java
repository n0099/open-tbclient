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
    public TextView avq;
    public TextView eFo;
    public TextView eGL;
    public HeadImageView eIc;
    public TbImageView eId;
    public ImageView eIe;
    public ImageView eIf;
    public TextView eIg;
    public ProgressBar eIh;
    public TextView eIi;
    public LinearLayout eIj;
    public TextView eIk;
    public TextView eIl;
    public LinearLayout eIm;
    public TextView eIn;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.avq.setTypeface(Typeface.defaultFromStyle(0));
                this.eFo.setTypeface(Typeface.defaultFromStyle(0));
                this.eIi.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.eIl.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.eGL.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.avq.setTypeface(Typeface.defaultFromStyle(1));
                this.eFo.setTypeface(Typeface.defaultFromStyle(1));
                this.eIi.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.eIl.setTextColor(-11337753);
                this.eGL.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.eIc = (HeadImageView) findViewById(a.g.header_imageView);
        this.eId = (TbImageView) findViewById(a.g.headwear_imageView);
        this.avq = (TextView) findViewById(a.g.name_textView);
        this.eFo = (TextView) findViewById(a.g.nameSuffix_textView);
        this.eIe = (ImageView) findViewById(a.g.edit_imageView);
        this.eIf = (ImageView) findViewById(a.g.explain_imageView);
        this.eIg = (TextView) findViewById(a.g.score_textView);
        this.eIh = (ProgressBar) findViewById(a.g.score_progressBar);
        this.eIi = (TextView) findViewById(a.g.next_textView);
        this.eIj = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.eIk = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.eIl = (TextView) findViewById(a.g.memberNum_textView);
        this.eIm = (LinearLayout) findViewById(a.g.rank_layout);
        this.eIn = (TextView) findViewById(a.g.rankTitle_textView);
        this.eGL = (TextView) findViewById(a.g.rank_textView);
    }
}

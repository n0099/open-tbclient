package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes3.dex */
public class CharmItemView extends LinearLayout {
    public TextView aVs;
    public TextView fqb;
    public ImageView fqc;
    public HeadImageView fqd;
    public TbImageView fqe;
    public ALALevelView fqf;
    public TextView fqg;

    public CharmItemView(Context context) {
        this(context, null);
    }

    public CharmItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(int i, int i2, String str, String str2, long j, long j2) {
        float dimensionPixelSize;
        if (i == 2 && i2 >= 1 && i2 <= 3 && j > 0) {
            this.fqb.setTextColor(-838860801);
            this.fqe.setVisibility(0);
        } else {
            this.fqb.setTextColor(1728053247);
            this.fqe.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.fqb.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.fqb.setVisibility(0);
            this.fqc.setVisibility(8);
        } else {
            this.fqb.setVisibility(8);
            this.fqc.setVisibility(0);
        }
        if (this.fqb.getText() != null) {
            TextView textView = this.fqb;
            if (this.fqb.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        k.a(this.fqd, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.fqe.setImageResource(a.f.pic_live_list_top1);
                    break;
                case 2:
                    this.fqe.setImageResource(a.f.pic_live_list_top2);
                    break;
                case 3:
                    this.fqe.setImageResource(a.f.pic_live_list_top3);
                    break;
            }
        }
        this.aVs.setText(str);
        switch (i) {
            case 1:
                this.fqg.setText(String.format(getResources().getString(a.i.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.fqg.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.fqg.setText("");
                    return;
                }
            default:
                return;
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.sdk_charm_item, (ViewGroup) this, true);
        setOrientation(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds8);
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds18), dimensionPixelOffset, getResources().getDimensionPixelOffset(a.e.sdk_ds36), dimensionPixelOffset);
        zb();
        initView();
    }

    private void zb() {
        this.fqb = (TextView) findViewById(a.g.tv_rank);
        this.fqc = (ImageView) findViewById(a.g.iv_rank);
        this.fqd = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fqe = (TbImageView) findViewById(a.g.iv_pendant);
        this.fqf = (ALALevelView) findViewById(a.g.level);
        this.aVs = (TextView) findViewById(a.g.tv_name);
        this.fqg = (TextView) findViewById(a.g.tv_value);
    }

    private void initView() {
        this.fqd.setAutoChangeStyle(false);
        this.fqd.setDrawBorder(false);
        this.fqd.setIsRound(true);
        this.fqe.setDefaultBgResource(a.d.sdk_transparent);
        this.fqe.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }
}

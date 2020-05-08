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
    public TextView aPj;
    public TextView fcn;
    public ImageView fco;
    public HeadImageView fcp;
    public TbImageView fcq;
    public ALALevelView fcr;
    public TextView fcs;

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
            this.fcn.setTextColor(-838860801);
            this.fcq.setVisibility(0);
        } else {
            this.fcn.setTextColor(1728053247);
            this.fcq.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.fcn.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.fcn.setVisibility(0);
            this.fco.setVisibility(8);
        } else {
            this.fcn.setVisibility(8);
            this.fco.setVisibility(0);
        }
        if (this.fcn.getText() != null) {
            TextView textView = this.fcn;
            if (this.fcn.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        k.a(this.fcp, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.fcq.setImageResource(a.f.pic_live_list_top1);
                    break;
                case 2:
                    this.fcq.setImageResource(a.f.pic_live_list_top2);
                    break;
                case 3:
                    this.fcq.setImageResource(a.f.pic_live_list_top3);
                    break;
            }
        }
        this.aPj.setText(str);
        switch (i) {
            case 1:
                this.fcs.setText(String.format(getResources().getString(a.i.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.fcs.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.fcs.setText("");
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
        xN();
        initView();
    }

    private void xN() {
        this.fcn = (TextView) findViewById(a.g.tv_rank);
        this.fco = (ImageView) findViewById(a.g.iv_rank);
        this.fcp = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fcq = (TbImageView) findViewById(a.g.iv_pendant);
        this.fcr = (ALALevelView) findViewById(a.g.level);
        this.aPj = (TextView) findViewById(a.g.tv_name);
        this.fcs = (TextView) findViewById(a.g.tv_value);
    }

    private void initView() {
        this.fcp.setAutoChangeStyle(false);
        this.fcp.setDrawBorder(false);
        this.fcp.setIsRound(true);
        this.fcq.setDefaultBgResource(a.d.sdk_transparent);
        this.fcq.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }
}

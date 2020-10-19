package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.l;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes4.dex */
public class CharmItemView extends LinearLayout {
    public TextView aEC;
    public TextView ghA;
    public TextView ghv;
    public ImageView ghw;
    public HeadImageView ghx;
    public TbImageView ghy;
    public ALALevelView ghz;

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
            this.ghv.setTextColor(-838860801);
            this.ghy.setVisibility(0);
        } else {
            this.ghv.setTextColor(1728053247);
            this.ghy.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.ghv.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.ghv.setVisibility(0);
            this.ghw.setVisibility(8);
        } else {
            this.ghv.setVisibility(8);
            this.ghw.setVisibility(0);
        }
        if (this.ghv.getText() != null) {
            TextView textView = this.ghv;
            if (this.ghv.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        l.a(this.ghx, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.ghy.setImageResource(a.f.pic_live_list_top1);
                    break;
                case 2:
                    this.ghy.setImageResource(a.f.pic_live_list_top2);
                    break;
                case 3:
                    this.ghy.setImageResource(a.f.pic_live_list_top3);
                    break;
            }
        }
        this.aEC.setText(str);
        switch (i) {
            case 1:
                this.ghA.setText(String.format(getResources().getString(a.i.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.ghA.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.ghA.setText("");
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
        Hc();
        initView();
    }

    private void Hc() {
        this.ghv = (TextView) findViewById(a.g.tv_rank);
        this.ghw = (ImageView) findViewById(a.g.iv_rank);
        this.ghx = (HeadImageView) findViewById(a.g.iv_avatar);
        this.ghy = (TbImageView) findViewById(a.g.iv_pendant);
        this.ghz = (ALALevelView) findViewById(a.g.level);
        this.aEC = (TextView) findViewById(a.g.tv_name);
        this.ghA = (TextView) findViewById(a.g.tv_value);
    }

    private void initView() {
        this.ghx.setAutoChangeStyle(false);
        this.ghx.setDrawBorder(false);
        this.ghx.setIsRound(true);
        this.ghy.setDefaultBgResource(a.d.sdk_transparent);
        this.ghy.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }
}

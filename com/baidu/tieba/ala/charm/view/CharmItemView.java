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
    public TextView aFA;
    public TextView gxm;
    public ImageView gxn;
    public HeadImageView gxo;
    public TbImageView gxp;
    public ALALevelView gxq;
    public TextView gxr;

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
            this.gxm.setTextColor(-838860801);
            this.gxp.setVisibility(0);
        } else {
            this.gxm.setTextColor(1728053247);
            this.gxp.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.gxm.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.gxm.setVisibility(0);
            this.gxn.setVisibility(8);
        } else {
            this.gxm.setVisibility(8);
            this.gxn.setVisibility(0);
        }
        if (this.gxm.getText() != null) {
            TextView textView = this.gxm;
            if (this.gxm.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        l.a(this.gxo, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.gxp.setImageResource(a.e.pic_live_list_top1);
                    break;
                case 2:
                    this.gxp.setImageResource(a.e.pic_live_list_top2);
                    break;
                case 3:
                    this.gxp.setImageResource(a.e.pic_live_list_top3);
                    break;
            }
        }
        this.aFA.setText(str);
        switch (i) {
            case 1:
                this.gxr.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.gxr.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.gxr.setText("");
                    return;
                }
            default:
                return;
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.sdk_charm_item, (ViewGroup) this, true);
        setOrientation(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds8);
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds18), dimensionPixelOffset, getResources().getDimensionPixelOffset(a.d.sdk_ds36), dimensionPixelOffset);
        HZ();
        initView();
    }

    private void HZ() {
        this.gxm = (TextView) findViewById(a.f.tv_rank);
        this.gxn = (ImageView) findViewById(a.f.iv_rank);
        this.gxo = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gxp = (TbImageView) findViewById(a.f.iv_pendant);
        this.gxq = (ALALevelView) findViewById(a.f.level);
        this.aFA = (TextView) findViewById(a.f.tv_name);
        this.gxr = (TextView) findViewById(a.f.tv_value);
    }

    private void initView() {
        this.gxo.setAutoChangeStyle(false);
        this.gxo.setDrawBorder(false);
        this.gxo.setIsRound(true);
        this.gxp.setDefaultBgResource(a.c.sdk_transparent);
        this.gxp.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}

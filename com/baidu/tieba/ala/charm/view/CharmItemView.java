package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.m;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes10.dex */
public class CharmItemView extends LinearLayout {
    public TextView aBZ;
    public TextView gML;
    public ImageView gMM;
    public HeadImageView gMN;
    public TbImageView gMO;
    public ALALevelView gMP;
    public TextView gMQ;

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
            this.gML.setTextColor(-838860801);
            this.gMO.setVisibility(0);
        } else {
            this.gML.setTextColor(1728053247);
            this.gMO.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.gML.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.gML.setVisibility(0);
            this.gMM.setVisibility(8);
        } else {
            this.gML.setVisibility(8);
            this.gMM.setVisibility(0);
        }
        if (this.gML.getText() != null) {
            TextView textView = this.gML;
            if (this.gML.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        m.a(this.gMN, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.gMO.setImageResource(a.e.pic_live_list_top1);
                    break;
                case 2:
                    this.gMO.setImageResource(a.e.pic_live_list_top2);
                    break;
                case 3:
                    this.gMO.setImageResource(a.e.pic_live_list_top3);
                    break;
            }
        }
        this.aBZ.setText(str);
        switch (i) {
            case 1:
                this.gMQ.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.gMQ.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.gMQ.setText("");
                    return;
                }
            default:
                return;
        }
    }

    protected void init() {
        LayoutInflater.from(getContext()).inflate(a.g.sdk_charm_item, (ViewGroup) this, true);
        setOrientation(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds8);
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds18), dimensionPixelOffset, getResources().getDimensionPixelOffset(a.d.sdk_ds36), dimensionPixelOffset);
        EO();
        initView();
    }

    protected void EO() {
        this.gML = (TextView) findViewById(a.f.tv_rank);
        this.gMM = (ImageView) findViewById(a.f.iv_rank);
        this.gMN = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gMO = (TbImageView) findViewById(a.f.iv_pendant);
        this.gMP = (ALALevelView) findViewById(a.f.level);
        this.aBZ = (TextView) findViewById(a.f.tv_name);
        this.gMQ = (TextView) findViewById(a.f.tv_value);
    }

    protected void initView() {
        this.gMN.setAutoChangeStyle(false);
        this.gMN.setDrawBorder(false);
        this.gMN.setIsRound(true);
        this.gMO.setDefaultBgResource(a.c.sdk_transparent);
        this.gMO.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}

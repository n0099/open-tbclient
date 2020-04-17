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
    public TextView aPd;
    public TextView fci;
    public ImageView fcj;
    public HeadImageView fck;
    public TbImageView fcl;
    public ALALevelView fcm;
    public TextView fcn;

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
            this.fci.setTextColor(-838860801);
            this.fcl.setVisibility(0);
        } else {
            this.fci.setTextColor(1728053247);
            this.fcl.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.fci.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.fci.setVisibility(0);
            this.fcj.setVisibility(8);
        } else {
            this.fci.setVisibility(8);
            this.fcj.setVisibility(0);
        }
        if (this.fci.getText() != null) {
            TextView textView = this.fci;
            if (this.fci.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        k.a(this.fck, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.fcl.setImageResource(a.f.pic_live_list_top1);
                    break;
                case 2:
                    this.fcl.setImageResource(a.f.pic_live_list_top2);
                    break;
                case 3:
                    this.fcl.setImageResource(a.f.pic_live_list_top3);
                    break;
            }
        }
        this.aPd.setText(str);
        switch (i) {
            case 1:
                this.fcn.setText(String.format(getResources().getString(a.i.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.fcn.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.fcn.setText("");
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
        xO();
        initView();
    }

    private void xO() {
        this.fci = (TextView) findViewById(a.g.tv_rank);
        this.fcj = (ImageView) findViewById(a.g.iv_rank);
        this.fck = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fcl = (TbImageView) findViewById(a.g.iv_pendant);
        this.fcm = (ALALevelView) findViewById(a.g.level);
        this.aPd = (TextView) findViewById(a.g.tv_name);
        this.fcn = (TextView) findViewById(a.g.tv_value);
    }

    private void initView() {
        this.fck.setAutoChangeStyle(false);
        this.fck.setDrawBorder(false);
        this.fck.setIsRound(true);
        this.fcl.setDefaultBgResource(a.d.sdk_transparent);
        this.fcl.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }
}

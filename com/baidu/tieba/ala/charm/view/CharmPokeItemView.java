package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.m;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes11.dex */
public class CharmPokeItemView extends LinearLayout {
    public TextView aDM;
    public TextView gPr;
    public ImageView gPs;
    public HeadImageView gPt;
    public TbImageView gPu;
    public ALALevelView gPv;
    public TextView gPw;
    public TextView gPx;

    public CharmPokeItemView(Context context) {
        this(context, null);
    }

    public CharmPokeItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(int i, int i2, String str, String str2, long j, long j2, int i3, final long j3, final String str3) {
        float dimensionPixelSize;
        this.gPr.setVisibility(8);
        this.gPs.setVisibility(8);
        this.gPu.setVisibility(0);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.gPs.setVisibility(0);
                    this.gPs.setBackgroundResource(a.e.sdk_icon_live_list_first);
                    this.gPu.setImageResource(a.e.pic_live_list_top1);
                    break;
                case 2:
                    this.gPs.setVisibility(0);
                    this.gPs.setBackgroundResource(a.e.sdk_icon_live_list_second);
                    this.gPu.setImageResource(a.e.pic_live_list_top2);
                    break;
                case 3:
                    this.gPs.setVisibility(0);
                    this.gPs.setBackgroundResource(a.e.sdk_icon_live_list_third);
                    this.gPu.setImageResource(a.e.pic_live_list_top3);
                    break;
                default:
                    this.gPr.setVisibility(0);
                    this.gPr.setTextColor(1728053247);
                    this.gPr.setText(i2 + "");
                    this.gPu.setVisibility(8);
                    if (this.gPr.getText() != null) {
                        TextView textView = this.gPr;
                        if (this.gPr.getText().length() > 3) {
                            dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize24);
                        } else {
                            dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize36);
                        }
                        textView.setTextSize(0, dimensionPixelSize);
                        break;
                    }
                    break;
            }
        } else {
            this.gPu.setVisibility(8);
            this.gPs.setBackgroundResource(a.e.sdk_charm_no_listed);
            this.gPs.setVisibility(0);
        }
        m.a(this.gPt, str2, true, false);
        this.aDM.setText(str);
        switch (i) {
            case 1:
                this.gPw.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                break;
            case 2:
                this.gPw.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                break;
        }
        if (i3 == 0) {
            this.gPx.setVisibility(8);
            return;
        }
        if (i3 == 1) {
            this.gPx.setEnabled(false);
            this.gPx.setText(getResources().getString(a.h.sdk_poke_had_poked));
        }
        if (i3 == 2) {
            this.gPx.setEnabled(true);
            this.gPx.setText(getResources().getString(a.h.sdk_poke_not_poke));
        }
        this.gPx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.CharmPokeItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913267, ""));
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_HOST_POKE));
                HttpMessage httpMessage = new HttpMessage(1021227);
                httpMessage.addParam("poke_user_id", j3);
                httpMessage.addParam("live_id", str3);
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        });
    }

    protected final void init() {
        LayoutInflater.from(getContext()).inflate(a.g.sdk_charm_poke_item, (ViewGroup) this, true);
        setOrientation(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds8);
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds18), dimensionPixelOffset, getResources().getDimensionPixelOffset(a.d.sdk_ds36), dimensionPixelOffset);
        Ge();
        initView();
    }

    protected void Ge() {
        this.gPr = (TextView) findViewById(a.f.tv_rank);
        this.gPs = (ImageView) findViewById(a.f.iv_rank);
        this.gPt = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gPu = (TbImageView) findViewById(a.f.iv_pendant);
        this.gPv = (ALALevelView) findViewById(a.f.level);
        this.aDM = (TextView) findViewById(a.f.tv_name);
        this.gPw = (TextView) findViewById(a.f.tv_value);
        this.gPx = (TextView) findViewById(a.f.poke);
    }

    protected void initView() {
        this.gPt.setAutoChangeStyle(false);
        this.gPt.setDrawBorder(false);
        this.gPt.setIsRound(true);
        this.gPu.setDefaultBgResource(a.c.sdk_transparent);
        this.gPu.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}

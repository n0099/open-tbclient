package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.baidu.live.utils.l;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes4.dex */
public class CharmPokeItemView extends LinearLayout {
    public TextView aGv;
    public TextView gFG;
    public ImageView gFH;
    public HeadImageView gFI;
    public TbImageView gFJ;
    public ALALevelView gFK;
    public TextView gFL;
    public TextView gFM;

    public CharmPokeItemView(Context context) {
        this(context, null);
    }

    public CharmPokeItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(int i, int i2, String str, String str2, long j, long j2, int i3, final long j3, final String str3) {
        float dimensionPixelSize;
        this.gFG.setVisibility(8);
        this.gFH.setVisibility(8);
        this.gFJ.setVisibility(0);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.gFH.setVisibility(0);
                    this.gFH.setBackgroundResource(a.e.sdk_icon_live_list_first);
                    this.gFJ.setImageResource(a.e.pic_live_list_top1);
                    break;
                case 2:
                    this.gFH.setVisibility(0);
                    this.gFH.setBackgroundResource(a.e.sdk_icon_live_list_second);
                    this.gFJ.setImageResource(a.e.pic_live_list_top2);
                    break;
                case 3:
                    this.gFH.setVisibility(0);
                    this.gFH.setBackgroundResource(a.e.sdk_icon_live_list_third);
                    this.gFJ.setImageResource(a.e.pic_live_list_top3);
                    break;
                default:
                    this.gFG.setVisibility(0);
                    this.gFG.setTextColor(1728053247);
                    this.gFG.setText(i2 + "");
                    this.gFJ.setVisibility(8);
                    if (this.gFG.getText() != null) {
                        TextView textView = this.gFG;
                        if (this.gFG.getText().length() > 3) {
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
            this.gFJ.setVisibility(8);
            this.gFH.setBackgroundResource(a.e.sdk_charm_no_listed);
            this.gFH.setVisibility(0);
        }
        l.a(this.gFI, str2, true, false);
        this.aGv.setText(str);
        switch (i) {
            case 1:
                this.gFL.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                break;
            case 2:
                this.gFL.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                break;
        }
        if (i3 == 0) {
            this.gFM.setVisibility(8);
            return;
        }
        if (i3 == 1) {
            this.gFM.setEnabled(false);
            this.gFM.setText(getResources().getString(a.h.sdk_poke_had_poked));
        }
        if (i3 == 2) {
            this.gFM.setEnabled(true);
            this.gFM.setText(getResources().getString(a.h.sdk_poke_not_poke));
        }
        this.gFM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.CharmPokeItemView.1
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

    protected void init() {
        LayoutInflater.from(getContext()).inflate(a.g.sdk_charm_poke_item, (ViewGroup) this, true);
        setOrientation(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds8);
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds18), dimensionPixelOffset, getResources().getDimensionPixelOffset(a.d.sdk_ds36), dimensionPixelOffset);
        Jh();
        initView();
    }

    protected void Jh() {
        this.gFG = (TextView) findViewById(a.f.tv_rank);
        this.gFH = (ImageView) findViewById(a.f.iv_rank);
        this.gFI = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gFJ = (TbImageView) findViewById(a.f.iv_pendant);
        this.gFK = (ALALevelView) findViewById(a.f.level);
        this.aGv = (TextView) findViewById(a.f.tv_name);
        this.gFL = (TextView) findViewById(a.f.tv_value);
        this.gFM = (TextView) findViewById(a.f.poke);
    }

    protected void initView() {
        this.gFI.setAutoChangeStyle(false);
        this.gFI.setDrawBorder(false);
        this.gFI.setIsRound(true);
        this.gFJ.setDefaultBgResource(a.c.sdk_transparent);
        this.gFJ.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}

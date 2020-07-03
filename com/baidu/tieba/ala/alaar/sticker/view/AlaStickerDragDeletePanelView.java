package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes3.dex */
public class AlaStickerDragDeletePanelView extends RelativeLayout {
    private RelativeLayout fjb;
    private View fjc;
    private ImageView fjd;
    private TextView fje;
    private TextView fjf;
    private View fjg;
    private View fjh;
    private View fji;

    public AlaStickerDragDeletePanelView(Context context) {
        super(context);
        init(context);
    }

    public AlaStickerDragDeletePanelView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AlaStickerDragDeletePanelView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(getContext()).inflate(a.h.ala_sticker_delete_panel, this);
        this.fjb = (RelativeLayout) findViewById(a.g.delete_panel_top);
        this.fjc = findViewById(a.g.delete_panel_top_bg);
        this.fjg = findViewById(a.g.delete_panel_delete_info);
        this.fjd = (ImageView) findViewById(a.g.delete_panel_delete_img);
        this.fje = (TextView) findViewById(a.g.delete_panel_delete_text);
        this.fjh = findViewById(a.g.delete_panel_im);
        this.fji = findViewById(a.g.delete_panel_im_right);
        this.fjf = (TextView) findViewById(a.g.delete_panel_bottom);
    }

    public void jr(boolean z) {
        if (z) {
            this.fjc.setBackgroundResource(a.d.color_live_sticker_red_40);
            this.fjd.setBackgroundResource(a.f.icon_live_paste_delete_on_n);
            this.fje.setText(a.i.ala_live_sticker_delete);
            return;
        }
        this.fjc.setBackgroundResource(a.d.color_live_sticker_red_50);
        this.fjd.setBackgroundResource(a.f.icon_live_paste_delete_n);
        this.fje.setText(a.i.ala_live_sticker_delete_move);
    }

    public void setTopDeletePanelHeight(int i) {
        if (i > getResources().getDimensionPixelOffset(a.e.sdk_ds30)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fjb.getLayoutParams();
            layoutParams.height = i;
            this.fjb.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fjb.getLayoutParams();
            layoutParams2.height = getTopDeletePanelHeight();
            this.fjb.setLayoutParams(layoutParams2);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fjg.getLayoutParams();
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds40);
            this.fjg.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fjg.getLayoutParams();
        layoutParams4.addRule(15);
        this.fjg.setLayoutParams(layoutParams4);
    }

    public int getTopDeletePanelBottom() {
        return this.fjb.getBottom();
    }

    public void setDeleteBottomHeight(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fjf.getLayoutParams();
            layoutParams.height = i;
            this.fjf.setLayoutParams(layoutParams);
        }
    }

    public int getTopDeletePanelHeight() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds184);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return getResources().getDimensionPixelOffset(a.e.sdk_ds184) + UtilHelper.getImmersiveStickyBarHeight();
        }
        return dimensionPixelOffset;
    }

    public void setImMsgViewSize(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fjh.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.fjh.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fji.getLayoutParams();
        layoutParams2.width = BdUtilHelper.getEquipmentWidth(getContext()) - i;
        layoutParams2.height = i2;
        this.fji.setLayoutParams(layoutParams2);
    }
}

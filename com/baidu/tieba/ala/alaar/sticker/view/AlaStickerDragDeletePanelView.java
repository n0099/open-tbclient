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
/* loaded from: classes4.dex */
public class AlaStickerDragDeletePanelView extends RelativeLayout {
    private RelativeLayout fPe;
    private View fPf;
    private ImageView fPg;
    private TextView fPh;
    private TextView fPi;
    private View fPj;
    private View fPk;
    private View fPl;

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
        this.fPe = (RelativeLayout) findViewById(a.g.delete_panel_top);
        this.fPf = findViewById(a.g.delete_panel_top_bg);
        this.fPj = findViewById(a.g.delete_panel_delete_info);
        this.fPg = (ImageView) findViewById(a.g.delete_panel_delete_img);
        this.fPh = (TextView) findViewById(a.g.delete_panel_delete_text);
        this.fPk = findViewById(a.g.delete_panel_im);
        this.fPl = findViewById(a.g.delete_panel_im_right);
        this.fPi = (TextView) findViewById(a.g.delete_panel_bottom);
    }

    public void kV(boolean z) {
        if (z) {
            this.fPf.setBackgroundResource(a.d.color_live_sticker_red_40);
            this.fPg.setBackgroundResource(a.f.icon_live_paste_delete_on_n);
            this.fPh.setText(a.i.ala_live_sticker_delete);
            return;
        }
        this.fPf.setBackgroundResource(a.d.color_live_sticker_red_50);
        this.fPg.setBackgroundResource(a.f.icon_live_paste_delete_n);
        this.fPh.setText(a.i.ala_live_sticker_delete_move);
    }

    public void setTopDeletePanelHeight(int i) {
        if (i > getResources().getDimensionPixelOffset(a.e.sdk_ds30)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fPe.getLayoutParams();
            layoutParams.height = i;
            this.fPe.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fPe.getLayoutParams();
            layoutParams2.height = getTopDeletePanelHeight();
            this.fPe.setLayoutParams(layoutParams2);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fPj.getLayoutParams();
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds40);
            this.fPj.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fPj.getLayoutParams();
        layoutParams4.addRule(15);
        this.fPj.setLayoutParams(layoutParams4);
    }

    public int getTopDeletePanelBottom() {
        return this.fPe.getBottom();
    }

    public void setDeleteBottomHeight(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fPi.getLayoutParams();
            layoutParams.height = i;
            this.fPi.setLayoutParams(layoutParams);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fPk.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.fPk.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fPl.getLayoutParams();
        layoutParams2.width = BdUtilHelper.getEquipmentWidth(getContext()) - i;
        layoutParams2.height = i2;
        this.fPl.setLayoutParams(layoutParams2);
    }
}

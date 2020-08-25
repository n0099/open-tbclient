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
/* loaded from: classes7.dex */
public class AlaStickerDragDeletePanelView extends RelativeLayout {
    private RelativeLayout fzF;
    private View fzG;
    private ImageView fzH;
    private TextView fzI;
    private TextView fzJ;
    private View fzK;
    private View fzL;
    private View fzM;

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
        this.fzF = (RelativeLayout) findViewById(a.g.delete_panel_top);
        this.fzG = findViewById(a.g.delete_panel_top_bg);
        this.fzK = findViewById(a.g.delete_panel_delete_info);
        this.fzH = (ImageView) findViewById(a.g.delete_panel_delete_img);
        this.fzI = (TextView) findViewById(a.g.delete_panel_delete_text);
        this.fzL = findViewById(a.g.delete_panel_im);
        this.fzM = findViewById(a.g.delete_panel_im_right);
        this.fzJ = (TextView) findViewById(a.g.delete_panel_bottom);
    }

    public void kt(boolean z) {
        if (z) {
            this.fzG.setBackgroundResource(a.d.color_live_sticker_red_40);
            this.fzH.setBackgroundResource(a.f.icon_live_paste_delete_on_n);
            this.fzI.setText(a.i.ala_live_sticker_delete);
            return;
        }
        this.fzG.setBackgroundResource(a.d.color_live_sticker_red_50);
        this.fzH.setBackgroundResource(a.f.icon_live_paste_delete_n);
        this.fzI.setText(a.i.ala_live_sticker_delete_move);
    }

    public void setTopDeletePanelHeight(int i) {
        if (i > getResources().getDimensionPixelOffset(a.e.sdk_ds30)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzF.getLayoutParams();
            layoutParams.height = i;
            this.fzF.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fzF.getLayoutParams();
            layoutParams2.height = getTopDeletePanelHeight();
            this.fzF.setLayoutParams(layoutParams2);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fzK.getLayoutParams();
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds40);
            this.fzK.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fzK.getLayoutParams();
        layoutParams4.addRule(15);
        this.fzK.setLayoutParams(layoutParams4);
    }

    public int getTopDeletePanelBottom() {
        return this.fzF.getBottom();
    }

    public void setDeleteBottomHeight(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzJ.getLayoutParams();
            layoutParams.height = i;
            this.fzJ.setLayoutParams(layoutParams);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzL.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.fzL.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fzM.getLayoutParams();
        layoutParams2.width = BdUtilHelper.getEquipmentWidth(getContext()) - i;
        layoutParams2.height = i2;
        this.fzM.setLayoutParams(layoutParams2);
    }
}

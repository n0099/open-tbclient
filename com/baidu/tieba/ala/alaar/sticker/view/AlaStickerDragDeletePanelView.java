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
    private RelativeLayout fzJ;
    private View fzK;
    private ImageView fzL;
    private TextView fzM;
    private TextView fzN;
    private View fzO;
    private View fzP;
    private View fzQ;

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
        this.fzJ = (RelativeLayout) findViewById(a.g.delete_panel_top);
        this.fzK = findViewById(a.g.delete_panel_top_bg);
        this.fzO = findViewById(a.g.delete_panel_delete_info);
        this.fzL = (ImageView) findViewById(a.g.delete_panel_delete_img);
        this.fzM = (TextView) findViewById(a.g.delete_panel_delete_text);
        this.fzP = findViewById(a.g.delete_panel_im);
        this.fzQ = findViewById(a.g.delete_panel_im_right);
        this.fzN = (TextView) findViewById(a.g.delete_panel_bottom);
    }

    public void kv(boolean z) {
        if (z) {
            this.fzK.setBackgroundResource(a.d.color_live_sticker_red_40);
            this.fzL.setBackgroundResource(a.f.icon_live_paste_delete_on_n);
            this.fzM.setText(a.i.ala_live_sticker_delete);
            return;
        }
        this.fzK.setBackgroundResource(a.d.color_live_sticker_red_50);
        this.fzL.setBackgroundResource(a.f.icon_live_paste_delete_n);
        this.fzM.setText(a.i.ala_live_sticker_delete_move);
    }

    public void setTopDeletePanelHeight(int i) {
        if (i > getResources().getDimensionPixelOffset(a.e.sdk_ds30)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzJ.getLayoutParams();
            layoutParams.height = i;
            this.fzJ.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fzJ.getLayoutParams();
            layoutParams2.height = getTopDeletePanelHeight();
            this.fzJ.setLayoutParams(layoutParams2);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fzO.getLayoutParams();
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds40);
            this.fzO.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fzO.getLayoutParams();
        layoutParams4.addRule(15);
        this.fzO.setLayoutParams(layoutParams4);
    }

    public int getTopDeletePanelBottom() {
        return this.fzJ.getBottom();
    }

    public void setDeleteBottomHeight(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzN.getLayoutParams();
            layoutParams.height = i;
            this.fzN.setLayoutParams(layoutParams);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzP.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.fzP.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fzQ.getLayoutParams();
        layoutParams2.width = BdUtilHelper.getEquipmentWidth(getContext()) - i;
        layoutParams2.height = i2;
        this.fzQ.setLayoutParams(layoutParams2);
    }
}

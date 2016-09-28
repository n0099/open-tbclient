package com.baidu.tieba.graffiti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.util.Error;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.p;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements View.OnClickListener {
    static final int cwI = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds150);
    static final int cwJ = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds30);
    private com.baidu.tbadk.widget.richText.f aIj;
    private boolean aJj;
    private View bGK;
    private final View.OnLongClickListener bIY;
    private RelativeLayout.LayoutParams cwK;
    private RelativeLayout.LayoutParams cwL;
    private TbImageView cwM;
    private View cwN;
    private TextView cwO;
    private boolean cwP;
    private final com.baidu.tbadk.util.e<Error> cwQ;
    public final View.OnClickListener cwR;

    public e(Context context) {
        super(context);
        this.cwK = new RelativeLayout.LayoutParams(-2, -2);
        this.cwL = new RelativeLayout.LayoutParams(-1, -2);
        this.cwM = null;
        this.bGK = null;
        this.cwN = null;
        this.cwO = null;
        this.aJj = true;
        this.cwP = false;
        this.bIY = new f(this);
        this.cwQ = new g(this);
        this.cwR = new h(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(r.h.tb_richtext_graffitiview, this);
        this.bGK = inflate.findViewById(r.g.root_layout);
        this.cwM = (TbImageView) inflate.findViewById(r.g.graffiti_image);
        this.cwM.setGifIconSupport(false);
        this.cwN = inflate.findViewById(r.g.save_layout);
        this.cwO = (TextView) inflate.findViewById(r.g.tv_save);
        this.cwM.setDrawBorder(true);
        this.cwM.setBorderColor(av.getColor(r.d.cp_bg_line_k));
        this.cwM.setBorderWidth(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1));
        this.cwM.setFocusable(false);
        this.cwN.setClickable(true);
        this.cwM.setOnClickListener(this.cwR);
        this.cwM.setGifIconSupport(false);
        this.cwM.setAdjustViewBounds(false);
        this.cwO.setClickable(true);
        this.cwO.setOnClickListener(this);
        this.cwO.setLongClickable(true);
        this.cwO.setOnLongClickListener(this.bIY);
    }

    public void a(com.baidu.tbadk.widget.richText.f fVar, int i, String str, int i2, int i3, boolean z) {
        if (fVar == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aIj = fVar;
        a(fVar, i, i2, i3);
        if (!d.ajV() || !z) {
            this.cwN.setVisibility(8);
            this.bGK.setLayoutParams(this.cwK);
        } else {
            this.cwN.setVisibility(0);
            this.bGK.setLayoutParams(this.cwL);
        }
        boolean oN = l.oH().oN();
        this.cwM.setDefaultBgResource(r.d.cp_bg_line_c);
        if (oN) {
            this.cwM.setInterceptOnClick(false);
            this.cwM.setDefaultResource(r.f.transparent_bg);
        } else {
            this.cwM.setDefaultResource(r.f.icon_click);
            this.cwM.setInterceptOnClick(true);
        }
        this.cwM.c(fVar.url, 17, false);
        this.cwM.setTag(fVar.url);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void a(com.baidu.tbadk.widget.richText.f fVar, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (fVar != null && (layoutParams = this.cwM.getLayoutParams()) != null && i2 > cwI) {
            int i4 = fVar.width;
            int i5 = (i2 - cwI) - cwJ;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.cwM.setLayoutParams(layoutParams);
            }
            this.cwN.setPadding(Math.min(i3, ((i2 - cwI) - i5) / 2), 0, 0, 0);
        }
    }

    public void k(boolean z, boolean z2) {
        if (this.aJj != z) {
            this.aJj = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.cwM;
    }

    public View getSaveBtn() {
        return this.cwN;
    }

    public void onChangeSkinType(int i) {
        av.c(this.cwO, r.d.cp_link_tip_a, 1);
        av.k(this.cwO, r.f.btn_tuya_save_n);
    }

    public void reset() {
        this.aIj = null;
        this.cwM.setImageResource(0);
        this.cwN.setBackgroundResource(0);
        this.cwO.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        ajW();
        if (view == this.cwO && this.aIj != null && bm.ak(getContext()) && !com.baidu.tbadk.util.d.isFastDoubleClick() && !this.cwP) {
            this.cwP = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
            if (runTask != null && (pVar = (p) runTask.getData()) != null) {
                pVar.b(this.aIj.url, this.cwQ);
            }
            TiebaStatic.log(new ax("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajW() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.f.b<View> createGraffitiViewPool(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new i(context), i, 0);
    }
}

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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.util.Error;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.o;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements View.OnClickListener {
    static final int cBS = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds150);
    static final int cBT = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds30);
    private com.baidu.tbadk.widget.richText.f aIZ;
    private boolean aKc;
    private View bJE;
    private final View.OnLongClickListener bLR;
    private RelativeLayout.LayoutParams cBU;
    private RelativeLayout.LayoutParams cBV;
    private TbImageView cBW;
    private View cBX;
    private TextView cBY;
    private boolean cBZ;
    private final com.baidu.tbadk.util.e<Error> cCa;
    public final View.OnClickListener cCb;

    public e(Context context) {
        super(context);
        this.cBU = new RelativeLayout.LayoutParams(-2, -2);
        this.cBV = new RelativeLayout.LayoutParams(-1, -2);
        this.cBW = null;
        this.bJE = null;
        this.cBX = null;
        this.cBY = null;
        this.aKc = true;
        this.cBZ = false;
        this.bLR = new f(this);
        this.cCa = new g(this);
        this.cCb = new h(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(r.h.tb_richtext_graffitiview, this);
        this.bJE = inflate.findViewById(r.g.root_layout);
        this.cBW = (TbImageView) inflate.findViewById(r.g.graffiti_image);
        this.cBW.setGifIconSupport(false);
        this.cBX = inflate.findViewById(r.g.save_layout);
        this.cBY = (TextView) inflate.findViewById(r.g.tv_save);
        this.cBW.setDrawBorder(true);
        this.cBW.setBorderColor(at.getColor(r.d.cp_bg_line_k));
        this.cBW.setBorderWidth(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1));
        this.cBW.setFocusable(false);
        this.cBX.setClickable(true);
        this.cBW.setOnClickListener(this.cCb);
        this.cBW.setGifIconSupport(false);
        this.cBW.setAdjustViewBounds(false);
        this.cBY.setClickable(true);
        this.cBY.setOnClickListener(this);
        this.cBY.setLongClickable(true);
        this.cBY.setOnLongClickListener(this.bLR);
    }

    public void a(com.baidu.tbadk.widget.richText.f fVar, int i, String str, int i2, int i3, boolean z) {
        if (fVar == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aIZ = fVar;
        a(fVar, i, i2, i3);
        if (!d.alQ() || !z) {
            this.cBX.setVisibility(8);
            this.bJE.setLayoutParams(this.cBU);
        } else {
            this.cBX.setVisibility(0);
            this.bJE.setLayoutParams(this.cBV);
        }
        boolean oP = l.oJ().oP();
        this.cBW.setDefaultBgResource(r.d.cp_bg_line_c);
        if (oP) {
            this.cBW.setInterceptOnClick(false);
            this.cBW.setDefaultResource(r.f.transparent_bg);
        } else {
            this.cBW.setDefaultResource(r.f.icon_click);
            this.cBW.setInterceptOnClick(true);
        }
        this.cBW.c(fVar.url, 17, false);
        this.cBW.setTag(fVar.url);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void a(com.baidu.tbadk.widget.richText.f fVar, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (fVar != null && (layoutParams = this.cBW.getLayoutParams()) != null && i2 > cBS) {
            int i4 = fVar.width;
            int i5 = (i2 - cBS) - cBT;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.cBW.setLayoutParams(layoutParams);
            }
            this.cBX.setPadding(Math.min(i3, ((i2 - cBS) - i5) / 2), 0, 0, 0);
        }
    }

    public void j(boolean z, boolean z2) {
        if (this.aKc != z) {
            this.aKc = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.cBW;
    }

    public View getSaveBtn() {
        return this.cBX;
    }

    public void onChangeSkinType(int i) {
        at.c(this.cBY, r.d.cp_link_tip_a, 1);
        at.k(this.cBY, r.f.btn_tuya_save_n);
    }

    public void reset() {
        this.aIZ = null;
        this.cBW.setImageResource(0);
        this.cBX.setBackgroundResource(0);
        this.cBY.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        alR();
        if (view == this.cBY && this.aIZ != null && bk.ak(getContext()) && !com.baidu.tbadk.util.d.isFastDoubleClick() && !this.cBZ) {
            this.cBZ = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, o.class);
            if (runTask != null && (oVar = (o) runTask.getData()) != null) {
                oVar.b(this.aIZ.url, this.cCa);
            }
            TiebaStatic.log(new av("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alR() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.f.b<View> createGraffitiViewPool(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new i(context), i, 0);
    }
}

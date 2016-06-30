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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.util.Error;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.util.p;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements View.OnClickListener {
    static final int ciF = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst(), u.e.ds150);
    static final int ciG = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst(), u.e.ds30);
    private com.baidu.tbadk.widget.richText.f aEJ;
    private boolean aFH;
    private View bsX;
    private final View.OnLongClickListener bvu;
    private RelativeLayout.LayoutParams ciH;
    private RelativeLayout.LayoutParams ciI;
    private TbImageView ciJ;
    private View ciK;
    private TextView ciL;
    private boolean ciM;
    private final com.baidu.tbadk.util.e<Error> ciN;
    public final View.OnClickListener ciO;

    public e(Context context) {
        super(context);
        this.ciH = new RelativeLayout.LayoutParams(-2, -2);
        this.ciI = new RelativeLayout.LayoutParams(-1, -2);
        this.ciJ = null;
        this.bsX = null;
        this.ciK = null;
        this.ciL = null;
        this.aFH = true;
        this.ciM = false;
        this.bvu = new f(this);
        this.ciN = new g(this);
        this.ciO = new h(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(u.h.tb_richtext_graffitiview, this);
        this.bsX = inflate.findViewById(u.g.root_layout);
        this.ciJ = (TbImageView) inflate.findViewById(u.g.graffiti_image);
        this.ciJ.setGifIconSupport(false);
        this.ciK = inflate.findViewById(u.g.save_layout);
        this.ciL = (TextView) inflate.findViewById(u.g.tv_save);
        this.ciJ.setDrawBorder(true);
        this.ciJ.setBorderColor(av.getColor(u.d.cp_bg_line_k));
        this.ciJ.setBorderWidth(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds1));
        this.ciJ.setFocusable(false);
        this.ciK.setClickable(true);
        this.ciJ.setOnClickListener(this.ciO);
        this.ciJ.setGifIconSupport(false);
        this.ciJ.setAdjustViewBounds(false);
        this.ciL.setClickable(true);
        this.ciL.setOnClickListener(this);
        this.ciL.setLongClickable(true);
        this.ciL.setOnLongClickListener(this.bvu);
    }

    public void a(com.baidu.tbadk.widget.richText.f fVar, int i, String str, int i2, int i3, boolean z) {
        if (fVar == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aEJ = fVar;
        a(fVar, i, i2, i3);
        if (!d.aet() || !z) {
            this.ciK.setVisibility(8);
            this.bsX.setLayoutParams(this.ciH);
        } else {
            this.ciK.setVisibility(0);
            this.bsX.setLayoutParams(this.ciI);
        }
        boolean oc = l.nW().oc();
        this.ciJ.setDefaultBgResource(u.d.cp_bg_line_c);
        if (oc) {
            this.ciJ.setInterceptOnClick(false);
            this.ciJ.setDefaultResource(u.f.transparent_bg);
        } else {
            this.ciJ.setDefaultResource(u.f.icon_click);
            this.ciJ.setInterceptOnClick(true);
        }
        this.ciJ.c(fVar.url, 17, false);
        this.ciJ.setTag(fVar.url);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void a(com.baidu.tbadk.widget.richText.f fVar, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (fVar != null && (layoutParams = this.ciJ.getLayoutParams()) != null && i2 > ciF) {
            int i4 = fVar.width;
            int i5 = (i2 - ciF) - ciG;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.ciJ.setLayoutParams(layoutParams);
            }
            this.ciK.setPadding(Math.min(i3, ((i2 - ciF) - i5) / 2), 0, 0, 0);
        }
    }

    public void i(boolean z, boolean z2) {
        if (this.aFH != z) {
            this.aFH = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.ciJ;
    }

    public View getSaveBtn() {
        return this.ciK;
    }

    public void onChangeSkinType(int i) {
        av.c(this.ciL, u.d.cp_link_tip_a, 1);
        av.k(this.ciL, u.f.btn_tuya_save_n);
    }

    public void reset() {
        this.aEJ = null;
        this.ciJ.setImageResource(0);
        this.ciK.setBackgroundResource(0);
        this.ciL.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        aeu();
        if (view == this.ciL && this.aEJ != null && bn.ab(getContext()) && !com.baidu.tbadk.util.d.isFastDoubleClick() && !this.ciM) {
            this.ciM = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
            if (runTask != null && (pVar = (p) runTask.getData()) != null) {
                pVar.b(this.aEJ.url, this.ciN);
            }
            TiebaStatic.log(new ay("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeu() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.f.b<View> createGraffitiViewPool(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new i(context), i, 0);
    }
}

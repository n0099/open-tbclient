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
    static final int ckS = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst(), u.e.ds150);
    static final int ckT = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst(), u.e.ds30);
    private com.baidu.tbadk.widget.richText.f aFA;
    private boolean aGy;
    private View bvm;
    private final View.OnLongClickListener bxI;
    private RelativeLayout.LayoutParams ckU;
    private RelativeLayout.LayoutParams ckV;
    private TbImageView ckW;
    private View ckX;
    private TextView ckY;
    private boolean ckZ;
    private final com.baidu.tbadk.util.e<Error> cla;
    public final View.OnClickListener clb;

    public e(Context context) {
        super(context);
        this.ckU = new RelativeLayout.LayoutParams(-2, -2);
        this.ckV = new RelativeLayout.LayoutParams(-1, -2);
        this.ckW = null;
        this.bvm = null;
        this.ckX = null;
        this.ckY = null;
        this.aGy = true;
        this.ckZ = false;
        this.bxI = new f(this);
        this.cla = new g(this);
        this.clb = new h(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(u.h.tb_richtext_graffitiview, this);
        this.bvm = inflate.findViewById(u.g.root_layout);
        this.ckW = (TbImageView) inflate.findViewById(u.g.graffiti_image);
        this.ckW.setGifIconSupport(false);
        this.ckX = inflate.findViewById(u.g.save_layout);
        this.ckY = (TextView) inflate.findViewById(u.g.tv_save);
        this.ckW.setDrawBorder(true);
        this.ckW.setBorderColor(av.getColor(u.d.cp_bg_line_k));
        this.ckW.setBorderWidth(TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds1));
        this.ckW.setFocusable(false);
        this.ckX.setClickable(true);
        this.ckW.setOnClickListener(this.clb);
        this.ckW.setGifIconSupport(false);
        this.ckW.setAdjustViewBounds(false);
        this.ckY.setClickable(true);
        this.ckY.setOnClickListener(this);
        this.ckY.setLongClickable(true);
        this.ckY.setOnLongClickListener(this.bxI);
    }

    public void a(com.baidu.tbadk.widget.richText.f fVar, int i, String str, int i2, int i3, boolean z) {
        if (fVar == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aFA = fVar;
        a(fVar, i, i2, i3);
        if (!d.aeW() || !z) {
            this.ckX.setVisibility(8);
            this.bvm.setLayoutParams(this.ckU);
        } else {
            this.ckX.setVisibility(0);
            this.bvm.setLayoutParams(this.ckV);
        }
        boolean nR = l.nL().nR();
        this.ckW.setDefaultBgResource(u.d.cp_bg_line_c);
        if (nR) {
            this.ckW.setInterceptOnClick(false);
            this.ckW.setDefaultResource(u.f.transparent_bg);
        } else {
            this.ckW.setDefaultResource(u.f.icon_click);
            this.ckW.setInterceptOnClick(true);
        }
        this.ckW.c(fVar.url, 17, false);
        this.ckW.setTag(fVar.url);
        onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
    }

    private void a(com.baidu.tbadk.widget.richText.f fVar, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (fVar != null && (layoutParams = this.ckW.getLayoutParams()) != null && i2 > ckS) {
            int i4 = fVar.width;
            int i5 = (i2 - ckS) - ckT;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.ckW.setLayoutParams(layoutParams);
            }
            this.ckX.setPadding(Math.min(i3, ((i2 - ckS) - i5) / 2), 0, 0, 0);
        }
    }

    public void i(boolean z, boolean z2) {
        if (this.aGy != z) {
            this.aGy = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.ckW;
    }

    public View getSaveBtn() {
        return this.ckX;
    }

    public void onChangeSkinType(int i) {
        av.c(this.ckY, u.d.cp_link_tip_a, 1);
        av.k(this.ckY, u.f.btn_tuya_save_n);
    }

    public void reset() {
        this.aFA = null;
        this.ckW.setImageResource(0);
        this.ckX.setBackgroundResource(0);
        this.ckY.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        aeX();
        if (view == this.ckY && this.aFA != null && bn.ab(getContext()) && !com.baidu.tbadk.util.d.isFastDoubleClick() && !this.ckZ) {
            this.ckZ = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
            if (runTask != null && (pVar = (p) runTask.getData()) != null) {
                pVar.b(this.aFA.url, this.cla);
            }
            TiebaStatic.log(new ay("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeX() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.f.b<View> createGraffitiViewPool(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new i(context), i, 0);
    }
}

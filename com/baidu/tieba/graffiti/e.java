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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.util.Error;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.p;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements View.OnClickListener {
    static final int bKA = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst(), t.e.ds150);
    static final int bKB = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst(), t.e.ds30);
    private com.baidu.tbadk.widget.richText.f aEi;
    private boolean aFg;
    private View aXb;
    private final View.OnLongClickListener aZy;
    private RelativeLayout.LayoutParams bKC;
    private RelativeLayout.LayoutParams bKD;
    private TbImageView bKE;
    private View bKF;
    private TextView bKG;
    private boolean bKH;
    private final com.baidu.tbadk.util.e<Error> bKI;
    public final View.OnClickListener bKJ;

    public e(Context context) {
        super(context);
        this.bKC = new RelativeLayout.LayoutParams(-2, -2);
        this.bKD = new RelativeLayout.LayoutParams(-1, -2);
        this.bKE = null;
        this.aXb = null;
        this.bKF = null;
        this.bKG = null;
        this.aFg = true;
        this.bKH = false;
        this.aZy = new f(this);
        this.bKI = new g(this);
        this.bKJ = new h(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(t.h.tb_richtext_graffitiview, this);
        this.aXb = inflate.findViewById(t.g.root_layout);
        this.bKE = (TbImageView) inflate.findViewById(t.g.graffiti_image);
        this.bKE.setGifIconSupport(false);
        this.bKF = inflate.findViewById(t.g.save_layout);
        this.bKG = (TextView) inflate.findViewById(t.g.tv_save);
        this.bKE.setDrawBorder(true);
        this.bKE.setBorderColor(at.getColor(t.d.black));
        this.bKE.setBorderWidth(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds1));
        this.bKE.setFocusable(false);
        this.bKF.setClickable(true);
        this.bKE.setOnClickListener(this.bKJ);
        this.bKE.setGifIconSupport(false);
        this.bKE.setAdjustViewBounds(false);
        this.bKG.setClickable(true);
        this.bKG.setOnClickListener(this);
        this.bKG.setLongClickable(true);
        this.bKG.setOnLongClickListener(this.aZy);
    }

    public void a(com.baidu.tbadk.widget.richText.f fVar, int i, String str, int i2, int i3, boolean z) {
        if (fVar == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aEi = fVar;
        a(fVar, i, i2, i3);
        if (!d.Yb() || !z) {
            this.bKF.setVisibility(8);
            this.aXb.setLayoutParams(this.bKC);
        } else {
            this.bKF.setVisibility(0);
            this.aXb.setLayoutParams(this.bKD);
        }
        boolean oh = l.ob().oh();
        this.bKE.setDefaultBgResource(t.d.cp_bg_line_c);
        if (oh) {
            this.bKE.setInterceptOnClick(false);
            this.bKE.setDefaultResource(t.f.transparent_bg);
        } else {
            this.bKE.setDefaultResource(t.f.icon_click);
            this.bKE.setInterceptOnClick(true);
        }
        this.bKE.c(fVar.url, 17, false);
        this.bKE.setTag(fVar.url);
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
    }

    private void a(com.baidu.tbadk.widget.richText.f fVar, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (fVar != null && (layoutParams = this.bKE.getLayoutParams()) != null && i2 > bKA) {
            int i4 = fVar.width;
            int i5 = (i2 - bKA) - bKB;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.bKE.setLayoutParams(layoutParams);
            }
            this.bKF.setPadding(Math.min(i3, ((i2 - bKA) - i5) / 2), 0, 0, 0);
        }
    }

    public void h(boolean z, boolean z2) {
        if (this.aFg != z) {
            this.aFg = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.bKE;
    }

    public View getSaveBtn() {
        return this.bKF;
    }

    public void onChangeSkinType(int i) {
        at.c(this.bKG, t.d.cp_link_tip_a, 1);
        at.k(this.bKG, t.f.btn_tuya_save_n);
    }

    public void reset() {
        this.aEi = null;
        this.bKE.setImageResource(0);
        this.bKF.setBackgroundResource(0);
        this.bKG.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        Yc();
        if (view == this.bKG && this.aEi != null && bl.ac(getContext()) && !com.baidu.tbadk.util.d.isFastDoubleClick() && !this.bKH) {
            this.bKH = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
            if (runTask != null && (pVar = (p) runTask.getData()) != null) {
                pVar.b(this.aEi.url, this.bKI);
            }
            TiebaStatic.log(new aw("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yc() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.f.b<View> createGraffitiViewPool(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new i(context), i, 0);
    }
}

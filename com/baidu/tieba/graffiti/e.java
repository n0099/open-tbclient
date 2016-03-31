package com.baidu.tieba.graffiti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
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
    static final int bKw = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds150);
    static final int bKx = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds30);
    private com.baidu.tbadk.widget.richText.f aIj;
    private boolean aJe;
    private TextView bKA;
    private boolean bKB;
    private final com.baidu.tbadk.util.e<Error> bKC;
    public final View.OnClickListener bKD;
    private TbImageView bKy;
    private View bKz;
    private final View.OnLongClickListener bdQ;

    public e(Context context) {
        super(context);
        this.bKy = null;
        this.bKz = null;
        this.bKA = null;
        this.aJe = true;
        this.bKB = false;
        this.bdQ = new f(this);
        this.bKC = new g(this);
        this.bKD = new h(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(t.h.tb_richtext_graffitiview, this);
        this.bKy = (TbImageView) inflate.findViewById(t.g.graffiti_image);
        this.bKy.setGifIconSupport(false);
        this.bKz = inflate.findViewById(t.g.save_layout);
        this.bKA = (TextView) inflate.findViewById(t.g.tv_save);
        this.bKy.setFocusable(false);
        this.bKz.setClickable(true);
        this.bKy.setOnClickListener(this.bKD);
        this.bKy.setGifIconSupport(false);
        this.bKy.setAdjustViewBounds(false);
        this.bKA.setClickable(true);
        this.bKA.setOnClickListener(this);
        this.bKA.setLongClickable(true);
        this.bKA.setOnLongClickListener(this.bdQ);
    }

    public void a(com.baidu.tbadk.widget.richText.f fVar, int i, String str, int i2, int i3) {
        if (fVar == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aIj = fVar;
        a(fVar, i, i2, i3);
        if (d.Yf()) {
            this.bKz.setVisibility(0);
        } else {
            this.bKz.setVisibility(8);
        }
        boolean qK = l.qE().qK();
        this.bKy.setDefaultBgResource(t.d.cp_bg_line_c);
        if (qK) {
            this.bKy.setInterceptOnClick(false);
            this.bKy.setDefaultResource(t.f.transparent_bg);
        } else {
            this.bKy.setDefaultResource(t.f.icon_click);
            this.bKy.setInterceptOnClick(true);
        }
        this.bKy.c(fVar.url, 17, false);
        this.bKy.setTag(fVar.url);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void a(com.baidu.tbadk.widget.richText.f fVar, int i, int i2, int i3) {
        LinearLayout.LayoutParams layoutParams;
        if (fVar != null && (layoutParams = (LinearLayout.LayoutParams) this.bKy.getLayoutParams()) != null && i2 > bKw) {
            int i4 = fVar.width;
            int i5 = (i2 - bKw) - bKx;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.bKy.setLayoutParams(layoutParams);
            }
            this.bKz.setPadding(Math.min(i3, ((i2 - bKw) - i5) / 2), 0, 0, 0);
        }
    }

    public void h(boolean z, boolean z2) {
        if (this.aJe != z) {
            this.aJe = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.bKy;
    }

    public View getSaveBtn() {
        return this.bKz;
    }

    public void onChangeSkinType(int i) {
        at.b(this.bKA, t.d.cp_link_tip_a, 1);
        at.k(this.bKA, t.f.btn_tuya_save_n);
    }

    public void reset() {
        this.aIj = null;
        this.bKy.setImageResource(0);
        this.bKz.setBackgroundResource(0);
        this.bKA.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        Yg();
        if (view == this.bKA && this.aIj != null && bl.ad(getContext()) && !com.baidu.tbadk.util.d.isFastDoubleClick() && !this.bKB) {
            this.bKB = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
            if (runTask != null && (pVar = (p) runTask.getData()) != null) {
                pVar.b(this.aIj.url, this.bKC);
            }
            TiebaStatic.log(new aw("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yg() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.f.b<View> j(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new i(context), i, 0);
    }
}

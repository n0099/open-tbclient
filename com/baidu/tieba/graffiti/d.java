package com.baidu.tieba.graffiti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.util.Error;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextGraffitiInfo;
import com.baidu.tieba.tbadkCore.util.o;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d extends RelativeLayout implements View.OnClickListener {
    static final int cpN = k.g(TbadkCoreApplication.m9getInst(), w.f.ds150);
    static final int cpO = k.g(TbadkCoreApplication.m9getInst(), w.f.ds30);
    private TbRichTextGraffitiInfo aMU;
    private boolean aNP;
    private View bGK;
    private final View.OnLongClickListener bIW;
    private RelativeLayout.LayoutParams cpP;
    private RelativeLayout.LayoutParams cpQ;
    private TbImageView cpR;
    private View cpS;
    private TextView cpT;
    private boolean cpU;
    private final com.baidu.tbadk.util.e<Error> cpV;
    public final View.OnClickListener cpW;

    public d(Context context) {
        super(context);
        this.cpP = new RelativeLayout.LayoutParams(-2, -2);
        this.cpQ = new RelativeLayout.LayoutParams(-1, -2);
        this.cpR = null;
        this.bGK = null;
        this.cpS = null;
        this.cpT = null;
        this.aNP = true;
        this.cpU = false;
        this.bIW = new e(this);
        this.cpV = new f(this);
        this.cpW = new g(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.tb_richtext_graffitiview, this);
        this.bGK = inflate.findViewById(w.h.root_layout);
        this.cpR = (TbImageView) inflate.findViewById(w.h.graffiti_image);
        this.cpR.setGifIconSupport(false);
        this.cpS = inflate.findViewById(w.h.save_layout);
        this.cpT = (TextView) inflate.findViewById(w.h.tv_save);
        this.cpR.setDrawBorder(true);
        this.cpR.setBorderColor(aq.getColor(w.e.cp_bg_line_k));
        this.cpR.setBorderWidth(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1));
        this.cpR.setFocusable(false);
        this.cpS.setClickable(true);
        this.cpR.setOnClickListener(this.cpW);
        this.cpR.setGifIconSupport(false);
        this.cpR.setAdjustViewBounds(false);
        this.cpT.setClickable(true);
        this.cpT.setOnClickListener(this);
        this.cpT.setLongClickable(true);
        this.cpT.setOnLongClickListener(this.bIW);
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str, int i2, int i3, boolean z) {
        if (tbRichTextGraffitiInfo == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aMU = tbRichTextGraffitiInfo;
        a(tbRichTextGraffitiInfo, i, i2, i3);
        if (!c.ahE() || !z) {
            this.cpS.setVisibility(8);
            this.bGK.setLayoutParams(this.cpP);
        } else {
            this.cpS.setVisibility(0);
            this.bGK.setLayoutParams(this.cpQ);
        }
        boolean pu = com.baidu.tbadk.core.q.po().pu();
        this.cpR.setDefaultBgResource(w.e.cp_bg_line_c);
        if (pu) {
            this.cpR.setInterceptOnClick(false);
            this.cpR.setDefaultResource(w.g.transparent_bg);
        } else {
            this.cpR.setDefaultResource(w.g.icon_click);
            this.cpR.setInterceptOnClick(true);
        }
        this.cpR.c(tbRichTextGraffitiInfo.url, 17, false);
        this.cpR.setTag(tbRichTextGraffitiInfo.url);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (tbRichTextGraffitiInfo != null && (layoutParams = this.cpR.getLayoutParams()) != null && i2 > cpN) {
            int i4 = tbRichTextGraffitiInfo.width;
            int i5 = (i2 - cpN) - cpO;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.cpR.setLayoutParams(layoutParams);
            }
            this.cpS.setPadding(Math.min(i3, ((i2 - cpN) - i5) / 2), 0, 0, 0);
        }
    }

    public void j(boolean z, boolean z2) {
        if (this.aNP != z) {
            this.aNP = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.cpR;
    }

    public View getSaveBtn() {
        return this.cpS;
    }

    public void onChangeSkinType(int i) {
        aq.c(this.cpT, w.e.cp_link_tip_a, 1);
        aq.j(this.cpT, w.g.btn_tuya_save_n);
    }

    public void reset() {
        this.aMU = null;
        this.cpR.setImageResource(0);
        this.cpS.setBackgroundResource(0);
        this.cpT.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        ahF();
        if (view == this.cpT && this.aMU != null && bg.aK(getContext()) && !com.baidu.tbadk.util.d.isFastDoubleClick() && !this.cpU) {
            this.cpU = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, o.class);
            if (runTask != null && (oVar = (o) runTask.getData()) != null) {
                oVar.b(this.aMU.url, this.cpV);
            }
            TiebaStatic.log(new as("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahF() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.e.b<View> o(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new h(context), i, 0);
    }
}

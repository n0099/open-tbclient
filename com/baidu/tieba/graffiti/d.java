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
import com.baidu.tbadk.core.l;
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
    static final int coW = k.g(TbadkCoreApplication.m9getInst(), w.f.ds150);
    static final int coX = k.g(TbadkCoreApplication.m9getInst(), w.f.ds30);
    private TbRichTextGraffitiInfo aMC;
    private boolean aNx;
    private View bEA;
    private final View.OnLongClickListener bGM;
    private RelativeLayout.LayoutParams coY;
    private RelativeLayout.LayoutParams coZ;
    private TbImageView cpa;
    private View cpb;
    private TextView cpc;
    private boolean cpd;
    private final com.baidu.tbadk.util.e<Error> cpe;
    public final View.OnClickListener cpf;

    public d(Context context) {
        super(context);
        this.coY = new RelativeLayout.LayoutParams(-2, -2);
        this.coZ = new RelativeLayout.LayoutParams(-1, -2);
        this.cpa = null;
        this.bEA = null;
        this.cpb = null;
        this.cpc = null;
        this.aNx = true;
        this.cpd = false;
        this.bGM = new e(this);
        this.cpe = new f(this);
        this.cpf = new g(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.tb_richtext_graffitiview, this);
        this.bEA = inflate.findViewById(w.h.root_layout);
        this.cpa = (TbImageView) inflate.findViewById(w.h.graffiti_image);
        this.cpa.setGifIconSupport(false);
        this.cpb = inflate.findViewById(w.h.save_layout);
        this.cpc = (TextView) inflate.findViewById(w.h.tv_save);
        this.cpa.setDrawBorder(true);
        this.cpa.setBorderColor(aq.getColor(w.e.cp_bg_line_k));
        this.cpa.setBorderWidth(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1));
        this.cpa.setFocusable(false);
        this.cpb.setClickable(true);
        this.cpa.setOnClickListener(this.cpf);
        this.cpa.setGifIconSupport(false);
        this.cpa.setAdjustViewBounds(false);
        this.cpc.setClickable(true);
        this.cpc.setOnClickListener(this);
        this.cpc.setLongClickable(true);
        this.cpc.setOnLongClickListener(this.bGM);
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str, int i2, int i3, boolean z) {
        if (tbRichTextGraffitiInfo == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aMC = tbRichTextGraffitiInfo;
        a(tbRichTextGraffitiInfo, i, i2, i3);
        if (!c.agJ() || !z) {
            this.cpb.setVisibility(8);
            this.bEA.setLayoutParams(this.coY);
        } else {
            this.cpb.setVisibility(0);
            this.bEA.setLayoutParams(this.coZ);
        }
        boolean oW = l.oQ().oW();
        this.cpa.setDefaultBgResource(w.e.cp_bg_line_c);
        if (oW) {
            this.cpa.setInterceptOnClick(false);
            this.cpa.setDefaultResource(w.g.transparent_bg);
        } else {
            this.cpa.setDefaultResource(w.g.icon_click);
            this.cpa.setInterceptOnClick(true);
        }
        this.cpa.c(tbRichTextGraffitiInfo.url, 17, false);
        this.cpa.setTag(tbRichTextGraffitiInfo.url);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (tbRichTextGraffitiInfo != null && (layoutParams = this.cpa.getLayoutParams()) != null && i2 > coW) {
            int i4 = tbRichTextGraffitiInfo.width;
            int i5 = (i2 - coW) - coX;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.cpa.setLayoutParams(layoutParams);
            }
            this.cpb.setPadding(Math.min(i3, ((i2 - coW) - i5) / 2), 0, 0, 0);
        }
    }

    public void j(boolean z, boolean z2) {
        if (this.aNx != z) {
            this.aNx = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.cpa;
    }

    public View getSaveBtn() {
        return this.cpb;
    }

    public void onChangeSkinType(int i) {
        aq.c(this.cpc, w.e.cp_link_tip_a, 1);
        aq.j(this.cpc, w.g.btn_tuya_save_n);
    }

    public void reset() {
        this.aMC = null;
        this.cpa.setImageResource(0);
        this.cpb.setBackgroundResource(0);
        this.cpc.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        agK();
        if (view == this.cpc && this.aMC != null && bg.aI(getContext()) && !com.baidu.tbadk.util.d.isFastDoubleClick() && !this.cpd) {
            this.cpd = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, o.class);
            if (runTask != null && (oVar = (o) runTask.getData()) != null) {
                oVar.b(this.aMC.url, this.cpe);
            }
            TiebaStatic.log(new as("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agK() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.e.b<View> o(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new h(context), i, 0);
    }
}

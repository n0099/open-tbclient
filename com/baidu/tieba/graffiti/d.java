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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.util.Error;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextGraffitiInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.o;
/* loaded from: classes.dex */
public class d extends RelativeLayout implements View.OnClickListener {
    static final int cny = k.e(TbadkCoreApplication.m9getInst(), r.f.ds150);
    static final int cnz = k.e(TbadkCoreApplication.m9getInst(), r.f.ds30);
    private TbRichTextGraffitiInfo aHe;
    private boolean aIa;
    private View bxu;
    private final View.OnLongClickListener bzG;
    private RelativeLayout.LayoutParams cnA;
    private RelativeLayout.LayoutParams cnB;
    private TbImageView cnC;
    private View cnD;
    private TextView cnE;
    private boolean cnF;
    private final com.baidu.tbadk.util.e<Error> cnG;
    public final View.OnClickListener cnH;

    public d(Context context) {
        super(context);
        this.cnA = new RelativeLayout.LayoutParams(-2, -2);
        this.cnB = new RelativeLayout.LayoutParams(-1, -2);
        this.cnC = null;
        this.bxu = null;
        this.cnD = null;
        this.cnE = null;
        this.aIa = true;
        this.cnF = false;
        this.bzG = new e(this);
        this.cnG = new f(this);
        this.cnH = new g(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(r.j.tb_richtext_graffitiview, this);
        this.bxu = inflate.findViewById(r.h.root_layout);
        this.cnC = (TbImageView) inflate.findViewById(r.h.graffiti_image);
        this.cnC.setGifIconSupport(false);
        this.cnD = inflate.findViewById(r.h.save_layout);
        this.cnE = (TextView) inflate.findViewById(r.h.tv_save);
        this.cnC.setDrawBorder(true);
        this.cnC.setBorderColor(ap.getColor(r.e.cp_bg_line_k));
        this.cnC.setBorderWidth(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds1));
        this.cnC.setFocusable(false);
        this.cnD.setClickable(true);
        this.cnC.setOnClickListener(this.cnH);
        this.cnC.setGifIconSupport(false);
        this.cnC.setAdjustViewBounds(false);
        this.cnE.setClickable(true);
        this.cnE.setOnClickListener(this);
        this.cnE.setLongClickable(true);
        this.cnE.setOnLongClickListener(this.bzG);
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str, int i2, int i3, boolean z) {
        if (tbRichTextGraffitiInfo == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aHe = tbRichTextGraffitiInfo;
        a(tbRichTextGraffitiInfo, i, i2, i3);
        if (!c.ahy() || !z) {
            this.cnD.setVisibility(8);
            this.bxu.setLayoutParams(this.cnA);
        } else {
            this.cnD.setVisibility(0);
            this.bxu.setLayoutParams(this.cnB);
        }
        boolean oI = l.oC().oI();
        this.cnC.setDefaultBgResource(r.e.cp_bg_line_c);
        if (oI) {
            this.cnC.setInterceptOnClick(false);
            this.cnC.setDefaultResource(r.g.transparent_bg);
        } else {
            this.cnC.setDefaultResource(r.g.icon_click);
            this.cnC.setInterceptOnClick(true);
        }
        this.cnC.c(tbRichTextGraffitiInfo.url, 17, false);
        this.cnC.setTag(tbRichTextGraffitiInfo.url);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (tbRichTextGraffitiInfo != null && (layoutParams = this.cnC.getLayoutParams()) != null && i2 > cny) {
            int i4 = tbRichTextGraffitiInfo.width;
            int i5 = (i2 - cny) - cnz;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.cnC.setLayoutParams(layoutParams);
            }
            this.cnD.setPadding(Math.min(i3, ((i2 - cny) - i5) / 2), 0, 0, 0);
        }
    }

    public void j(boolean z, boolean z2) {
        if (this.aIa != z) {
            this.aIa = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.cnC;
    }

    public View getSaveBtn() {
        return this.cnD;
    }

    public void onChangeSkinType(int i) {
        ap.c(this.cnE, r.e.cp_link_tip_a, 1);
        ap.j((View) this.cnE, r.g.btn_tuya_save_n);
    }

    public void reset() {
        this.aHe = null;
        this.cnC.setImageResource(0);
        this.cnD.setBackgroundResource(0);
        this.cnE.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        ahz();
        if (view == this.cnE && this.aHe != null && bf.ak(getContext()) && !com.baidu.tbadk.util.d.isFastDoubleClick() && !this.cnF) {
            this.cnF = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, o.class);
            if (runTask != null && (oVar = (o) runTask.getData()) != null) {
                oVar.b(this.aHe.url, this.cnG);
            }
            TiebaStatic.log(new ar("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahz() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.e.b<View> m(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new h(context), i, 0);
    }
}

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
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.util.Error;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextGraffitiInfo;
import com.baidu.tieba.tbadkCore.util.o;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d extends RelativeLayout implements View.OnClickListener {
    static final int cti = k.g(TbadkCoreApplication.m9getInst(), w.f.ds150);
    static final int ctj = k.g(TbadkCoreApplication.m9getInst(), w.f.ds30);
    private TbRichTextGraffitiInfo aNi;
    private boolean aOf;
    private RelativeLayout.LayoutParams ctk;
    private RelativeLayout.LayoutParams ctl;
    private TbImageView ctm;
    private View ctn;
    private View cto;
    private TextView ctp;
    private boolean ctq;
    private final View.OnLongClickListener ctr;
    private final com.baidu.tbadk.util.f<Error> cts;
    public final View.OnClickListener ctt;

    public d(Context context) {
        super(context);
        this.ctk = new RelativeLayout.LayoutParams(-2, -2);
        this.ctl = new RelativeLayout.LayoutParams(-1, -2);
        this.ctm = null;
        this.ctn = null;
        this.cto = null;
        this.ctp = null;
        this.aOf = true;
        this.ctq = false;
        this.ctr = new e(this);
        this.cts = new f(this);
        this.ctt = new g(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.tb_richtext_graffitiview, this);
        this.ctn = inflate.findViewById(w.h.root_layout);
        this.ctm = (TbImageView) inflate.findViewById(w.h.graffiti_image);
        this.ctm.setGifIconSupport(false);
        this.cto = inflate.findViewById(w.h.save_layout);
        this.ctp = (TextView) inflate.findViewById(w.h.tv_save);
        this.ctm.setDrawBorder(true);
        this.ctm.setBorderColor(aq.getColor(w.e.cp_bg_line_k));
        this.ctm.setBorderWidth(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1));
        this.ctm.setFocusable(false);
        this.cto.setClickable(true);
        this.ctm.setOnClickListener(this.ctt);
        this.ctm.setGifIconSupport(false);
        this.ctm.setAdjustViewBounds(false);
        this.ctp.setClickable(true);
        this.ctp.setOnClickListener(this);
        this.ctp.setLongClickable(true);
        this.ctp.setOnLongClickListener(this.ctr);
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str, int i2, int i3, boolean z) {
        if (tbRichTextGraffitiInfo == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aNi = tbRichTextGraffitiInfo;
        a(tbRichTextGraffitiInfo, i, i2, i3);
        if (!c.agC() || !z) {
            this.cto.setVisibility(8);
            this.ctn.setLayoutParams(this.ctk);
        } else {
            this.cto.setVisibility(0);
            this.ctn.setLayoutParams(this.ctl);
        }
        boolean oT = com.baidu.tbadk.core.r.oN().oT();
        this.ctm.setDefaultBgResource(w.e.cp_bg_line_c);
        if (oT) {
            this.ctm.setInterceptOnClick(false);
            this.ctm.setDefaultResource(w.g.transparent_bg);
        } else {
            this.ctm.setDefaultResource(w.g.icon_click);
            this.ctm.setInterceptOnClick(true);
        }
        this.ctm.c(tbRichTextGraffitiInfo.url, 17, false);
        this.ctm.setTag(tbRichTextGraffitiInfo.url);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (tbRichTextGraffitiInfo != null && (layoutParams = this.ctm.getLayoutParams()) != null && i2 > cti) {
            int i4 = tbRichTextGraffitiInfo.width;
            int i5 = (i2 - cti) - ctj;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.ctm.setLayoutParams(layoutParams);
            }
            this.cto.setPadding(Math.min(i3, ((i2 - cti) - i5) / 2), 0, 0, 0);
        }
    }

    public void j(boolean z, boolean z2) {
        if (this.aOf != z) {
            this.aOf = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.ctm;
    }

    public View getSaveBtn() {
        return this.cto;
    }

    public void onChangeSkinType(int i) {
        aq.c(this.ctp, w.e.cp_link_tip_a, 1);
        aq.j(this.ctp, w.g.btn_tuya_save_n);
    }

    public void reset() {
        this.aNi = null;
        this.ctm.setImageResource(0);
        this.cto.setBackgroundResource(0);
        this.ctp.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        agD();
        if (view == this.ctp && this.aNi != null && bh.aN(getContext()) && !com.baidu.tbadk.util.e.isFastDoubleClick() && !this.ctq) {
            this.ctq = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, o.class);
            if (runTask != null && (oVar = (o) runTask.getData()) != null) {
                oVar.b(this.aNi.url, this.cts);
            }
            TiebaStatic.log(new as("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agD() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.e.b<View> o(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new h(context), i, 0);
    }
}

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
    static final int cnw = k.g(TbadkCoreApplication.m9getInst(), w.f.ds150);
    static final int cnx = k.g(TbadkCoreApplication.m9getInst(), w.f.ds30);
    private TbRichTextGraffitiInfo aMS;
    private boolean aNN;
    private View bEt;
    private final View.OnLongClickListener bGF;
    private TbImageView cnA;
    private View cnB;
    private TextView cnC;
    private boolean cnD;
    private final com.baidu.tbadk.util.e<Error> cnE;
    public final View.OnClickListener cnF;
    private RelativeLayout.LayoutParams cny;
    private RelativeLayout.LayoutParams cnz;

    public d(Context context) {
        super(context);
        this.cny = new RelativeLayout.LayoutParams(-2, -2);
        this.cnz = new RelativeLayout.LayoutParams(-1, -2);
        this.cnA = null;
        this.bEt = null;
        this.cnB = null;
        this.cnC = null;
        this.aNN = true;
        this.cnD = false;
        this.bGF = new e(this);
        this.cnE = new f(this);
        this.cnF = new g(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.tb_richtext_graffitiview, this);
        this.bEt = inflate.findViewById(w.h.root_layout);
        this.cnA = (TbImageView) inflate.findViewById(w.h.graffiti_image);
        this.cnA.setGifIconSupport(false);
        this.cnB = inflate.findViewById(w.h.save_layout);
        this.cnC = (TextView) inflate.findViewById(w.h.tv_save);
        this.cnA.setDrawBorder(true);
        this.cnA.setBorderColor(aq.getColor(w.e.cp_bg_line_k));
        this.cnA.setBorderWidth(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1));
        this.cnA.setFocusable(false);
        this.cnB.setClickable(true);
        this.cnA.setOnClickListener(this.cnF);
        this.cnA.setGifIconSupport(false);
        this.cnA.setAdjustViewBounds(false);
        this.cnC.setClickable(true);
        this.cnC.setOnClickListener(this);
        this.cnC.setLongClickable(true);
        this.cnC.setOnLongClickListener(this.bGF);
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str, int i2, int i3, boolean z) {
        if (tbRichTextGraffitiInfo == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aMS = tbRichTextGraffitiInfo;
        a(tbRichTextGraffitiInfo, i, i2, i3);
        if (!c.agD() || !z) {
            this.cnB.setVisibility(8);
            this.bEt.setLayoutParams(this.cny);
        } else {
            this.cnB.setVisibility(0);
            this.bEt.setLayoutParams(this.cnz);
        }
        boolean pu = com.baidu.tbadk.core.q.po().pu();
        this.cnA.setDefaultBgResource(w.e.cp_bg_line_c);
        if (pu) {
            this.cnA.setInterceptOnClick(false);
            this.cnA.setDefaultResource(w.g.transparent_bg);
        } else {
            this.cnA.setDefaultResource(w.g.icon_click);
            this.cnA.setInterceptOnClick(true);
        }
        this.cnA.c(tbRichTextGraffitiInfo.url, 17, false);
        this.cnA.setTag(tbRichTextGraffitiInfo.url);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (tbRichTextGraffitiInfo != null && (layoutParams = this.cnA.getLayoutParams()) != null && i2 > cnw) {
            int i4 = tbRichTextGraffitiInfo.width;
            int i5 = (i2 - cnw) - cnx;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.cnA.setLayoutParams(layoutParams);
            }
            this.cnB.setPadding(Math.min(i3, ((i2 - cnw) - i5) / 2), 0, 0, 0);
        }
    }

    public void j(boolean z, boolean z2) {
        if (this.aNN != z) {
            this.aNN = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.cnA;
    }

    public View getSaveBtn() {
        return this.cnB;
    }

    public void onChangeSkinType(int i) {
        aq.c(this.cnC, w.e.cp_link_tip_a, 1);
        aq.j(this.cnC, w.g.btn_tuya_save_n);
    }

    public void reset() {
        this.aMS = null;
        this.cnA.setImageResource(0);
        this.cnB.setBackgroundResource(0);
        this.cnC.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        agE();
        if (view == this.cnC && this.aMS != null && bg.aK(getContext()) && !com.baidu.tbadk.util.d.isFastDoubleClick() && !this.cnD) {
            this.cnD = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, o.class);
            if (runTask != null && (oVar = (o) runTask.getData()) != null) {
                oVar.b(this.aMS.url, this.cnE);
            }
            TiebaStatic.log(new as("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agE() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.e.b<View> o(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new h(context), i, 0);
    }
}

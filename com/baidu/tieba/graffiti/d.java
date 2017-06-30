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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.util.Error;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextGraffitiInfo;
import com.baidu.tieba.tbadkCore.util.o;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d extends RelativeLayout implements View.OnClickListener {
    static final int cAV = k.g(TbadkCoreApplication.m9getInst(), w.f.ds150);
    static final int cAW = k.g(TbadkCoreApplication.m9getInst(), w.f.ds30);
    private TbRichTextGraffitiInfo aOx;
    private boolean aPv;
    private RelativeLayout.LayoutParams cAX;
    private RelativeLayout.LayoutParams cAY;
    private TbImageView cAZ;
    private View cBa;
    private View cBb;
    private TextView cBc;
    private boolean cBd;
    private final View.OnLongClickListener cBe;
    private final com.baidu.tbadk.util.g<Error> cBf;
    public final View.OnClickListener cBg;

    public d(Context context) {
        super(context);
        this.cAX = new RelativeLayout.LayoutParams(-2, -2);
        this.cAY = new RelativeLayout.LayoutParams(-1, -2);
        this.cAZ = null;
        this.cBa = null;
        this.cBb = null;
        this.cBc = null;
        this.aPv = true;
        this.cBd = false;
        this.cBe = new e(this);
        this.cBf = new f(this);
        this.cBg = new g(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.tb_richtext_graffitiview, this);
        this.cBa = inflate.findViewById(w.h.root_layout);
        this.cAZ = (TbImageView) inflate.findViewById(w.h.graffiti_image);
        this.cAZ.setGifIconSupport(false);
        this.cBb = inflate.findViewById(w.h.save_layout);
        this.cBc = (TextView) inflate.findViewById(w.h.tv_save);
        this.cAZ.setDrawBorder(true);
        this.cAZ.setBorderColor(as.getColor(w.e.cp_bg_line_k));
        this.cAZ.setBorderWidth(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1));
        this.cAZ.setFocusable(false);
        this.cBb.setClickable(true);
        this.cAZ.setOnClickListener(this.cBg);
        this.cAZ.setGifIconSupport(false);
        this.cAZ.setAdjustViewBounds(false);
        this.cBc.setClickable(true);
        this.cBc.setOnClickListener(this);
        this.cBc.setLongClickable(true);
        this.cBc.setOnLongClickListener(this.cBe);
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str, int i2, int i3, boolean z) {
        if (tbRichTextGraffitiInfo == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aOx = tbRichTextGraffitiInfo;
        a(tbRichTextGraffitiInfo, i, i2, i3);
        if (!c.akm() || !z) {
            this.cBb.setVisibility(8);
            this.cBa.setLayoutParams(this.cAX);
        } else {
            this.cBb.setVisibility(0);
            this.cBa.setLayoutParams(this.cAY);
        }
        boolean oQ = com.baidu.tbadk.core.r.oK().oQ();
        this.cAZ.setDefaultBgResource(w.e.cp_bg_line_c);
        if (oQ) {
            this.cAZ.setInterceptOnClick(false);
            this.cAZ.setDefaultResource(w.g.transparent_bg);
        } else {
            this.cAZ.setDefaultResource(w.g.icon_click);
            this.cAZ.setInterceptOnClick(true);
        }
        this.cAZ.c(tbRichTextGraffitiInfo.url, 17, false);
        this.cAZ.setTag(tbRichTextGraffitiInfo.url);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (tbRichTextGraffitiInfo != null && (layoutParams = this.cAZ.getLayoutParams()) != null && i2 > cAV) {
            int i4 = tbRichTextGraffitiInfo.width;
            int i5 = (i2 - cAV) - cAW;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.cAZ.setLayoutParams(layoutParams);
            }
            this.cBb.setPadding(Math.min(i3, ((i2 - cAV) - i5) / 2), 0, 0, 0);
        }
    }

    public void k(boolean z, boolean z2) {
        if (this.aPv != z) {
            this.aPv = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.cAZ;
    }

    public View getSaveBtn() {
        return this.cBb;
    }

    public void onChangeSkinType(int i) {
        as.c(this.cBc, w.e.cp_link_tip_a, 1);
        as.j(this.cBc, w.g.btn_tuya_save_n);
    }

    public void reset() {
        this.aOx = null;
        this.cAZ.setImageResource(0);
        this.cBb.setBackgroundResource(0);
        this.cBc.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        akn();
        if (view == this.cBc && this.aOx != null && bl.aN(getContext()) && !com.baidu.tbadk.util.f.isFastDoubleClick() && !this.cBd) {
            this.cBd = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, o.class);
            if (runTask != null && (oVar = (o) runTask.getData()) != null) {
                oVar.b(this.aOx.url, this.cBf);
            }
            TiebaStatic.log(new au("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akn() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.e.b<View> p(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new h(context), i, 0);
    }
}

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
    static final int cmK = k.g(TbadkCoreApplication.m9getInst(), w.f.ds150);
    static final int cmL = k.g(TbadkCoreApplication.m9getInst(), w.f.ds30);
    private TbRichTextGraffitiInfo aNl;
    private boolean aOh;
    private RelativeLayout.LayoutParams cmM;
    private RelativeLayout.LayoutParams cmN;
    private TbImageView cmO;
    private View cmP;
    private View cmQ;
    private TextView cmR;
    private boolean cmS;
    private final View.OnLongClickListener cmT;
    private final com.baidu.tbadk.util.f<Error> cmU;
    public final View.OnClickListener cmV;

    public d(Context context) {
        super(context);
        this.cmM = new RelativeLayout.LayoutParams(-2, -2);
        this.cmN = new RelativeLayout.LayoutParams(-1, -2);
        this.cmO = null;
        this.cmP = null;
        this.cmQ = null;
        this.cmR = null;
        this.aOh = true;
        this.cmS = false;
        this.cmT = new e(this);
        this.cmU = new f(this);
        this.cmV = new g(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.tb_richtext_graffitiview, this);
        this.cmP = inflate.findViewById(w.h.root_layout);
        this.cmO = (TbImageView) inflate.findViewById(w.h.graffiti_image);
        this.cmO.setGifIconSupport(false);
        this.cmQ = inflate.findViewById(w.h.save_layout);
        this.cmR = (TextView) inflate.findViewById(w.h.tv_save);
        this.cmO.setDrawBorder(true);
        this.cmO.setBorderColor(aq.getColor(w.e.cp_bg_line_k));
        this.cmO.setBorderWidth(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1));
        this.cmO.setFocusable(false);
        this.cmQ.setClickable(true);
        this.cmO.setOnClickListener(this.cmV);
        this.cmO.setGifIconSupport(false);
        this.cmO.setAdjustViewBounds(false);
        this.cmR.setClickable(true);
        this.cmR.setOnClickListener(this);
        this.cmR.setLongClickable(true);
        this.cmR.setOnLongClickListener(this.cmT);
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str, int i2, int i3, boolean z) {
        if (tbRichTextGraffitiInfo == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aNl = tbRichTextGraffitiInfo;
        a(tbRichTextGraffitiInfo, i, i2, i3);
        if (!c.afn() || !z) {
            this.cmQ.setVisibility(8);
            this.cmP.setLayoutParams(this.cmM);
        } else {
            this.cmQ.setVisibility(0);
            this.cmP.setLayoutParams(this.cmN);
        }
        boolean pb = com.baidu.tbadk.core.r.oV().pb();
        this.cmO.setDefaultBgResource(w.e.cp_bg_line_c);
        if (pb) {
            this.cmO.setInterceptOnClick(false);
            this.cmO.setDefaultResource(w.g.transparent_bg);
        } else {
            this.cmO.setDefaultResource(w.g.icon_click);
            this.cmO.setInterceptOnClick(true);
        }
        this.cmO.c(tbRichTextGraffitiInfo.url, 17, false);
        this.cmO.setTag(tbRichTextGraffitiInfo.url);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (tbRichTextGraffitiInfo != null && (layoutParams = this.cmO.getLayoutParams()) != null && i2 > cmK) {
            int i4 = tbRichTextGraffitiInfo.width;
            int i5 = (i2 - cmK) - cmL;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.cmO.setLayoutParams(layoutParams);
            }
            this.cmQ.setPadding(Math.min(i3, ((i2 - cmK) - i5) / 2), 0, 0, 0);
        }
    }

    public void j(boolean z, boolean z2) {
        if (this.aOh != z) {
            this.aOh = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.cmO;
    }

    public View getSaveBtn() {
        return this.cmQ;
    }

    public void onChangeSkinType(int i) {
        aq.c(this.cmR, w.e.cp_link_tip_a, 1);
        aq.j(this.cmR, w.g.btn_tuya_save_n);
    }

    public void reset() {
        this.aNl = null;
        this.cmO.setImageResource(0);
        this.cmQ.setBackgroundResource(0);
        this.cmR.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        afo();
        if (view == this.cmR && this.aNl != null && bg.aN(getContext()) && !com.baidu.tbadk.util.e.isFastDoubleClick() && !this.cmS) {
            this.cmS = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, o.class);
            if (runTask != null && (oVar = (o) runTask.getData()) != null) {
                oVar.b(this.aNl.url, this.cmU);
            }
            TiebaStatic.log(new as("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afo() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.e.b<View> o(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new h(context), i, 0);
    }
}

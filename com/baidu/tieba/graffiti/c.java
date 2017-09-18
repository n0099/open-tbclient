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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.util.Error;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextGraffitiInfo;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends RelativeLayout implements View.OnClickListener {
    static final int cSJ = k.f(TbadkCoreApplication.getInst(), d.f.ds150);
    static final int cSK = k.f(TbadkCoreApplication.getInst(), d.f.ds30);
    private TbRichTextGraffitiInfo aQB;
    private boolean aRz;
    private RelativeLayout.LayoutParams cSL;
    private RelativeLayout.LayoutParams cSM;
    private TbImageView cSN;
    private View cSO;
    private View cSP;
    private TextView cSQ;
    private boolean cSR;
    private final View.OnLongClickListener cSS;
    private final com.baidu.tbadk.util.g<Error> cST;
    public final View.OnClickListener cSU;

    public c(Context context) {
        super(context);
        this.cSL = new RelativeLayout.LayoutParams(-2, -2);
        this.cSM = new RelativeLayout.LayoutParams(-1, -2);
        this.cSN = null;
        this.cSO = null;
        this.cSP = null;
        this.cSQ = null;
        this.aRz = true;
        this.cSR = false;
        this.cSS = new View.OnLongClickListener() { // from class: com.baidu.tieba.graffiti.c.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                c.this.aot();
                return true;
            }
        };
        this.cST = new com.baidu.tbadk.util.g<Error>() { // from class: com.baidu.tieba.graffiti.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: a */
            public void E(Error error) {
                c.this.cSR = false;
                if (error != null && error.getCode() == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS, new d(null, 3)));
                    k.showToast(c.this.getContext(), c.this.getContext().getString(d.l.save_success));
                } else if (error != null && error.getCode() == -1132) {
                    k.showToast(c.this.getContext(), c.this.getContext().getString(d.l.graffiti_save_full));
                } else {
                    k.showToast(c.this.getContext(), c.this.getContext().getString(d.l.save_fail));
                }
            }
        };
        this.cSU = new View.OnClickListener() { // from class: com.baidu.tieba.graffiti.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aot();
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.tb_richtext_graffitiview, this);
        this.cSO = inflate.findViewById(d.h.root_layout);
        this.cSN = (TbImageView) inflate.findViewById(d.h.graffiti_image);
        this.cSN.setGifIconSupport(false);
        this.cSP = inflate.findViewById(d.h.save_layout);
        this.cSQ = (TextView) inflate.findViewById(d.h.tv_save);
        this.cSN.setDrawBorder(true);
        this.cSN.setBorderColor(aj.getColor(d.e.cp_bg_line_k));
        this.cSN.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1));
        this.cSN.setFocusable(false);
        this.cSP.setClickable(true);
        this.cSN.setOnClickListener(this.cSU);
        this.cSN.setGifIconSupport(false);
        this.cSN.setAdjustViewBounds(false);
        this.cSQ.setClickable(true);
        this.cSQ.setOnClickListener(this);
        this.cSQ.setLongClickable(true);
        this.cSQ.setOnLongClickListener(this.cSS);
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str, int i2, int i3, boolean z) {
        if (tbRichTextGraffitiInfo == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aQB = tbRichTextGraffitiInfo;
        a(tbRichTextGraffitiInfo, i, i2, i3);
        if (!b.aos() || !z) {
            this.cSP.setVisibility(8);
            this.cSO.setLayoutParams(this.cSL);
        } else {
            this.cSP.setVisibility(0);
            this.cSO.setLayoutParams(this.cSM);
        }
        boolean oY = com.baidu.tbadk.core.h.oS().oY();
        this.cSN.setDefaultBgResource(d.e.cp_bg_line_c);
        if (oY) {
            this.cSN.setInterceptOnClick(false);
            this.cSN.setDefaultResource(d.g.transparent_bg);
        } else {
            this.cSN.setDefaultResource(d.g.icon_click);
            this.cSN.setInterceptOnClick(true);
        }
        this.cSN.c(tbRichTextGraffitiInfo.url, 17, false);
        this.cSN.setTag(tbRichTextGraffitiInfo.url);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (tbRichTextGraffitiInfo != null && (layoutParams = this.cSN.getLayoutParams()) != null && i2 > cSJ) {
            int i4 = tbRichTextGraffitiInfo.width;
            int i5 = (i2 - cSJ) - cSK;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.cSN.setLayoutParams(layoutParams);
            }
            this.cSP.setPadding(Math.min(i3, ((i2 - cSJ) - i5) / 2), 0, 0, 0);
        }
    }

    public void l(boolean z, boolean z2) {
        if (this.aRz != z) {
            this.aRz = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.cSN;
    }

    public View getSaveBtn() {
        return this.cSP;
    }

    public void onChangeSkinType(int i) {
        aj.c(this.cSQ, d.e.cp_link_tip_a, 1);
        aj.j(this.cSQ, d.g.btn_tuya_save_n);
    }

    public void reset() {
        this.aQB = null;
        this.cSN.setImageResource(0);
        this.cSP.setBackgroundResource(0);
        this.cSQ.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.util.d dVar;
        aot();
        if (view == this.cSQ && this.aQB != null && ax.aU(getContext()) && !com.baidu.tbadk.util.f.isFastDoubleClick() && !this.cSR) {
            this.cSR = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, com.baidu.tieba.tbadkCore.util.d.class);
            if (runTask != null && (dVar = (com.baidu.tieba.tbadkCore.util.d) runTask.getData()) != null) {
                dVar.b(this.aQB.url, this.cST);
            }
            TiebaStatic.log(new ak("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aot() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.e.b<View> p(final Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.graffiti.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aou */
            public View fJ() {
                return new c(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aA */
            public void n(View view) {
                ((c) view).reset();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aB */
            public View o(View view) {
                return view;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aC */
            public View p(View view) {
                ((c) view).reset();
                return view;
            }
        }, i, 0);
    }
}

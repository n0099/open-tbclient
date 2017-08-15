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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.util.Error;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextGraffitiInfo;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends RelativeLayout implements View.OnClickListener {
    static final int cLy = k.g(TbadkCoreApplication.getInst(), d.f.ds150);
    static final int cLz = k.g(TbadkCoreApplication.getInst(), d.f.ds30);
    private TbRichTextGraffitiInfo aQU;
    private boolean aRR;
    private RelativeLayout.LayoutParams cLA;
    private RelativeLayout.LayoutParams cLB;
    private TbImageView cLC;
    private View cLD;
    private View cLE;
    private TextView cLF;
    private boolean cLG;
    private final View.OnLongClickListener cLH;
    private final com.baidu.tbadk.util.g<Error> cLI;
    public final View.OnClickListener cLJ;

    public c(Context context) {
        super(context);
        this.cLA = new RelativeLayout.LayoutParams(-2, -2);
        this.cLB = new RelativeLayout.LayoutParams(-1, -2);
        this.cLC = null;
        this.cLD = null;
        this.cLE = null;
        this.cLF = null;
        this.aRR = true;
        this.cLG = false;
        this.cLH = new View.OnLongClickListener() { // from class: com.baidu.tieba.graffiti.c.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                c.this.amG();
                return true;
            }
        };
        this.cLI = new com.baidu.tbadk.util.g<Error>() { // from class: com.baidu.tieba.graffiti.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: a */
            public void F(Error error) {
                c.this.cLG = false;
                if (error != null && error.getCode() == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS, new d(null, 3)));
                    k.showToast(c.this.getContext(), c.this.getContext().getString(d.l.save_success));
                } else if (error != null && error.getCode() == -1132) {
                    k.showToast(c.this.getContext(), c.this.getContext().getString(d.l.graffiti_save_full));
                } else {
                    k.showToast(c.this.getContext(), c.this.getContext().getString(d.l.save_error));
                }
            }
        };
        this.cLJ = new View.OnClickListener() { // from class: com.baidu.tieba.graffiti.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.amG();
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.tb_richtext_graffitiview, this);
        this.cLD = inflate.findViewById(d.h.root_layout);
        this.cLC = (TbImageView) inflate.findViewById(d.h.graffiti_image);
        this.cLC.setGifIconSupport(false);
        this.cLE = inflate.findViewById(d.h.save_layout);
        this.cLF = (TextView) inflate.findViewById(d.h.tv_save);
        this.cLC.setDrawBorder(true);
        this.cLC.setBorderColor(ai.getColor(d.e.cp_bg_line_k));
        this.cLC.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1));
        this.cLC.setFocusable(false);
        this.cLE.setClickable(true);
        this.cLC.setOnClickListener(this.cLJ);
        this.cLC.setGifIconSupport(false);
        this.cLC.setAdjustViewBounds(false);
        this.cLF.setClickable(true);
        this.cLF.setOnClickListener(this);
        this.cLF.setLongClickable(true);
        this.cLF.setOnLongClickListener(this.cLH);
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str, int i2, int i3, boolean z) {
        if (tbRichTextGraffitiInfo == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aQU = tbRichTextGraffitiInfo;
        a(tbRichTextGraffitiInfo, i, i2, i3);
        if (!b.amF() || !z) {
            this.cLE.setVisibility(8);
            this.cLD.setLayoutParams(this.cLA);
        } else {
            this.cLE.setVisibility(0);
            this.cLD.setLayoutParams(this.cLB);
        }
        boolean pd = com.baidu.tbadk.core.h.oX().pd();
        this.cLC.setDefaultBgResource(d.e.cp_bg_line_c);
        if (pd) {
            this.cLC.setInterceptOnClick(false);
            this.cLC.setDefaultResource(d.g.transparent_bg);
        } else {
            this.cLC.setDefaultResource(d.g.icon_click);
            this.cLC.setInterceptOnClick(true);
        }
        this.cLC.c(tbRichTextGraffitiInfo.url, 17, false);
        this.cLC.setTag(tbRichTextGraffitiInfo.url);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (tbRichTextGraffitiInfo != null && (layoutParams = this.cLC.getLayoutParams()) != null && i2 > cLy) {
            int i4 = tbRichTextGraffitiInfo.width;
            int i5 = (i2 - cLy) - cLz;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.cLC.setLayoutParams(layoutParams);
            }
            this.cLE.setPadding(Math.min(i3, ((i2 - cLy) - i5) / 2), 0, 0, 0);
        }
    }

    public void k(boolean z, boolean z2) {
        if (this.aRR != z) {
            this.aRR = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.cLC;
    }

    public View getSaveBtn() {
        return this.cLE;
    }

    public void onChangeSkinType(int i) {
        ai.c(this.cLF, d.e.cp_link_tip_a, 1);
        ai.j(this.cLF, d.g.btn_tuya_save_n);
    }

    public void reset() {
        this.aQU = null;
        this.cLC.setImageResource(0);
        this.cLE.setBackgroundResource(0);
        this.cLF.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.util.d dVar;
        amG();
        if (view == this.cLF && this.aQU != null && aw.aO(getContext()) && !com.baidu.tbadk.util.f.isFastDoubleClick() && !this.cLG) {
            this.cLG = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, com.baidu.tieba.tbadkCore.util.d.class);
            if (runTask != null && (dVar = (com.baidu.tieba.tbadkCore.util.d) runTask.getData()) != null) {
                dVar.b(this.aQU.url, this.cLI);
            }
            TiebaStatic.log(new aj("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amG() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.e.b<View> p(final Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.graffiti.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: amH */
            public View fT() {
                return new c(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: at */
            public void o(View view) {
                ((c) view).reset();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: au */
            public View p(View view) {
                return view;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: av */
            public View q(View view) {
                ((c) view).reset();
                return view;
            }
        }, i, 0);
    }
}

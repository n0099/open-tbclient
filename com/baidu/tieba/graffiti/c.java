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
    static final int cIg = k.g(TbadkCoreApplication.getInst(), d.f.ds150);
    static final int cIh = k.g(TbadkCoreApplication.getInst(), d.f.ds30);
    private TbRichTextGraffitiInfo aPG;
    private boolean aQE;
    private RelativeLayout.LayoutParams cIi;
    private RelativeLayout.LayoutParams cIj;
    private TbImageView cIk;
    private View cIl;
    private View cIm;
    private TextView cIn;
    private boolean cIo;
    private final View.OnLongClickListener cIp;
    private final com.baidu.tbadk.util.g<Error> cIq;
    public final View.OnClickListener cIr;

    public c(Context context) {
        super(context);
        this.cIi = new RelativeLayout.LayoutParams(-2, -2);
        this.cIj = new RelativeLayout.LayoutParams(-1, -2);
        this.cIk = null;
        this.cIl = null;
        this.cIm = null;
        this.cIn = null;
        this.aQE = true;
        this.cIo = false;
        this.cIp = new View.OnLongClickListener() { // from class: com.baidu.tieba.graffiti.c.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                c.this.alN();
                return true;
            }
        };
        this.cIq = new com.baidu.tbadk.util.g<Error>() { // from class: com.baidu.tieba.graffiti.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: a */
            public void F(Error error) {
                c.this.cIo = false;
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
        this.cIr = new View.OnClickListener() { // from class: com.baidu.tieba.graffiti.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.alN();
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.tb_richtext_graffitiview, this);
        this.cIl = inflate.findViewById(d.h.root_layout);
        this.cIk = (TbImageView) inflate.findViewById(d.h.graffiti_image);
        this.cIk.setGifIconSupport(false);
        this.cIm = inflate.findViewById(d.h.save_layout);
        this.cIn = (TextView) inflate.findViewById(d.h.tv_save);
        this.cIk.setDrawBorder(true);
        this.cIk.setBorderColor(ai.getColor(d.e.cp_bg_line_k));
        this.cIk.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1));
        this.cIk.setFocusable(false);
        this.cIm.setClickable(true);
        this.cIk.setOnClickListener(this.cIr);
        this.cIk.setGifIconSupport(false);
        this.cIk.setAdjustViewBounds(false);
        this.cIn.setClickable(true);
        this.cIn.setOnClickListener(this);
        this.cIn.setLongClickable(true);
        this.cIn.setOnLongClickListener(this.cIp);
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str, int i2, int i3, boolean z) {
        if (tbRichTextGraffitiInfo == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aPG = tbRichTextGraffitiInfo;
        a(tbRichTextGraffitiInfo, i, i2, i3);
        if (!b.alM() || !z) {
            this.cIm.setVisibility(8);
            this.cIl.setLayoutParams(this.cIi);
        } else {
            this.cIm.setVisibility(0);
            this.cIl.setLayoutParams(this.cIj);
        }
        boolean oT = com.baidu.tbadk.core.h.oN().oT();
        this.cIk.setDefaultBgResource(d.e.cp_bg_line_c);
        if (oT) {
            this.cIk.setInterceptOnClick(false);
            this.cIk.setDefaultResource(d.g.transparent_bg);
        } else {
            this.cIk.setDefaultResource(d.g.icon_click);
            this.cIk.setInterceptOnClick(true);
        }
        this.cIk.c(tbRichTextGraffitiInfo.url, 17, false);
        this.cIk.setTag(tbRichTextGraffitiInfo.url);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (tbRichTextGraffitiInfo != null && (layoutParams = this.cIk.getLayoutParams()) != null && i2 > cIg) {
            int i4 = tbRichTextGraffitiInfo.width;
            int i5 = (i2 - cIg) - cIh;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.cIk.setLayoutParams(layoutParams);
            }
            this.cIm.setPadding(Math.min(i3, ((i2 - cIg) - i5) / 2), 0, 0, 0);
        }
    }

    public void k(boolean z, boolean z2) {
        if (this.aQE != z) {
            this.aQE = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.cIk;
    }

    public View getSaveBtn() {
        return this.cIm;
    }

    public void onChangeSkinType(int i) {
        ai.c(this.cIn, d.e.cp_link_tip_a, 1);
        ai.j(this.cIn, d.g.btn_tuya_save_n);
    }

    public void reset() {
        this.aPG = null;
        this.cIk.setImageResource(0);
        this.cIm.setBackgroundResource(0);
        this.cIn.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.util.d dVar;
        alN();
        if (view == this.cIn && this.aPG != null && aw.aN(getContext()) && !com.baidu.tbadk.util.f.isFastDoubleClick() && !this.cIo) {
            this.cIo = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, com.baidu.tieba.tbadkCore.util.d.class);
            if (runTask != null && (dVar = (com.baidu.tieba.tbadkCore.util.d) runTask.getData()) != null) {
                dVar.b(this.aPG.url, this.cIq);
            }
            TiebaStatic.log(new aj("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alN() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.e.b<View> p(final Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.graffiti.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: alO */
            public View fI() {
                return new c(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ar */
            public void o(View view) {
                ((c) view).reset();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: as */
            public View p(View view) {
                return view;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: at */
            public View q(View view) {
                ((c) view).reset();
                return view;
            }
        }, i, 0);
    }
}

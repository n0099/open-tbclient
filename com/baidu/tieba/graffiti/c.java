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
    static final int cJB = k.g(TbadkCoreApplication.getInst(), d.f.ds150);
    static final int cJC = k.g(TbadkCoreApplication.getInst(), d.f.ds30);
    private TbRichTextGraffitiInfo aQT;
    private boolean aRQ;
    private RelativeLayout.LayoutParams cJD;
    private RelativeLayout.LayoutParams cJE;
    private TbImageView cJF;
    private View cJG;
    private View cJH;
    private TextView cJI;
    private boolean cJJ;
    private final View.OnLongClickListener cJK;
    private final com.baidu.tbadk.util.g<Error> cJL;
    public final View.OnClickListener cJM;

    public c(Context context) {
        super(context);
        this.cJD = new RelativeLayout.LayoutParams(-2, -2);
        this.cJE = new RelativeLayout.LayoutParams(-1, -2);
        this.cJF = null;
        this.cJG = null;
        this.cJH = null;
        this.cJI = null;
        this.aRQ = true;
        this.cJJ = false;
        this.cJK = new View.OnLongClickListener() { // from class: com.baidu.tieba.graffiti.c.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                c.this.ama();
                return true;
            }
        };
        this.cJL = new com.baidu.tbadk.util.g<Error>() { // from class: com.baidu.tieba.graffiti.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: a */
            public void F(Error error) {
                c.this.cJJ = false;
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
        this.cJM = new View.OnClickListener() { // from class: com.baidu.tieba.graffiti.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.ama();
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.tb_richtext_graffitiview, this);
        this.cJG = inflate.findViewById(d.h.root_layout);
        this.cJF = (TbImageView) inflate.findViewById(d.h.graffiti_image);
        this.cJF.setGifIconSupport(false);
        this.cJH = inflate.findViewById(d.h.save_layout);
        this.cJI = (TextView) inflate.findViewById(d.h.tv_save);
        this.cJF.setDrawBorder(true);
        this.cJF.setBorderColor(ai.getColor(d.e.cp_bg_line_k));
        this.cJF.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1));
        this.cJF.setFocusable(false);
        this.cJH.setClickable(true);
        this.cJF.setOnClickListener(this.cJM);
        this.cJF.setGifIconSupport(false);
        this.cJF.setAdjustViewBounds(false);
        this.cJI.setClickable(true);
        this.cJI.setOnClickListener(this);
        this.cJI.setLongClickable(true);
        this.cJI.setOnLongClickListener(this.cJK);
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str, int i2, int i3, boolean z) {
        if (tbRichTextGraffitiInfo == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aQT = tbRichTextGraffitiInfo;
        a(tbRichTextGraffitiInfo, i, i2, i3);
        if (!b.alZ() || !z) {
            this.cJH.setVisibility(8);
            this.cJG.setLayoutParams(this.cJD);
        } else {
            this.cJH.setVisibility(0);
            this.cJG.setLayoutParams(this.cJE);
        }
        boolean pd = com.baidu.tbadk.core.h.oX().pd();
        this.cJF.setDefaultBgResource(d.e.cp_bg_line_c);
        if (pd) {
            this.cJF.setInterceptOnClick(false);
            this.cJF.setDefaultResource(d.g.transparent_bg);
        } else {
            this.cJF.setDefaultResource(d.g.icon_click);
            this.cJF.setInterceptOnClick(true);
        }
        this.cJF.c(tbRichTextGraffitiInfo.url, 17, false);
        this.cJF.setTag(tbRichTextGraffitiInfo.url);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (tbRichTextGraffitiInfo != null && (layoutParams = this.cJF.getLayoutParams()) != null && i2 > cJB) {
            int i4 = tbRichTextGraffitiInfo.width;
            int i5 = (i2 - cJB) - cJC;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.cJF.setLayoutParams(layoutParams);
            }
            this.cJH.setPadding(Math.min(i3, ((i2 - cJB) - i5) / 2), 0, 0, 0);
        }
    }

    public void k(boolean z, boolean z2) {
        if (this.aRQ != z) {
            this.aRQ = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.cJF;
    }

    public View getSaveBtn() {
        return this.cJH;
    }

    public void onChangeSkinType(int i) {
        ai.c(this.cJI, d.e.cp_link_tip_a, 1);
        ai.j(this.cJI, d.g.btn_tuya_save_n);
    }

    public void reset() {
        this.aQT = null;
        this.cJF.setImageResource(0);
        this.cJH.setBackgroundResource(0);
        this.cJI.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.util.d dVar;
        ama();
        if (view == this.cJI && this.aQT != null && aw.aO(getContext()) && !com.baidu.tbadk.util.f.isFastDoubleClick() && !this.cJJ) {
            this.cJJ = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, com.baidu.tieba.tbadkCore.util.d.class);
            if (runTask != null && (dVar = (com.baidu.tieba.tbadkCore.util.d) runTask.getData()) != null) {
                dVar.b(this.aQT.url, this.cJL);
            }
            TiebaStatic.log(new aj("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ama() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.e.b<View> p(final Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.graffiti.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: amb */
            public View fT() {
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

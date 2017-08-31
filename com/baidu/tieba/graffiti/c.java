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
    static final int cRP = k.g(TbadkCoreApplication.getInst(), d.f.ds150);
    static final int cRQ = k.g(TbadkCoreApplication.getInst(), d.f.ds30);
    private TbRichTextGraffitiInfo aQE;
    private boolean aRC;
    private RelativeLayout.LayoutParams cRR;
    private RelativeLayout.LayoutParams cRS;
    private TbImageView cRT;
    private View cRU;
    private View cRV;
    private TextView cRW;
    private boolean cRX;
    private final View.OnLongClickListener cRY;
    private final com.baidu.tbadk.util.g<Error> cRZ;
    public final View.OnClickListener cSa;

    public c(Context context) {
        super(context);
        this.cRR = new RelativeLayout.LayoutParams(-2, -2);
        this.cRS = new RelativeLayout.LayoutParams(-1, -2);
        this.cRT = null;
        this.cRU = null;
        this.cRV = null;
        this.cRW = null;
        this.aRC = true;
        this.cRX = false;
        this.cRY = new View.OnLongClickListener() { // from class: com.baidu.tieba.graffiti.c.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                c.this.aoi();
                return true;
            }
        };
        this.cRZ = new com.baidu.tbadk.util.g<Error>() { // from class: com.baidu.tieba.graffiti.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: a */
            public void E(Error error) {
                c.this.cRX = false;
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
        this.cSa = new View.OnClickListener() { // from class: com.baidu.tieba.graffiti.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aoi();
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.tb_richtext_graffitiview, this);
        this.cRU = inflate.findViewById(d.h.root_layout);
        this.cRT = (TbImageView) inflate.findViewById(d.h.graffiti_image);
        this.cRT.setGifIconSupport(false);
        this.cRV = inflate.findViewById(d.h.save_layout);
        this.cRW = (TextView) inflate.findViewById(d.h.tv_save);
        this.cRT.setDrawBorder(true);
        this.cRT.setBorderColor(aj.getColor(d.e.cp_bg_line_k));
        this.cRT.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1));
        this.cRT.setFocusable(false);
        this.cRV.setClickable(true);
        this.cRT.setOnClickListener(this.cSa);
        this.cRT.setGifIconSupport(false);
        this.cRT.setAdjustViewBounds(false);
        this.cRW.setClickable(true);
        this.cRW.setOnClickListener(this);
        this.cRW.setLongClickable(true);
        this.cRW.setOnLongClickListener(this.cRY);
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str, int i2, int i3, boolean z) {
        if (tbRichTextGraffitiInfo == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aQE = tbRichTextGraffitiInfo;
        a(tbRichTextGraffitiInfo, i, i2, i3);
        if (!b.aoh() || !z) {
            this.cRV.setVisibility(8);
            this.cRU.setLayoutParams(this.cRR);
        } else {
            this.cRV.setVisibility(0);
            this.cRU.setLayoutParams(this.cRS);
        }
        boolean oY = com.baidu.tbadk.core.h.oS().oY();
        this.cRT.setDefaultBgResource(d.e.cp_bg_line_c);
        if (oY) {
            this.cRT.setInterceptOnClick(false);
            this.cRT.setDefaultResource(d.g.transparent_bg);
        } else {
            this.cRT.setDefaultResource(d.g.icon_click);
            this.cRT.setInterceptOnClick(true);
        }
        this.cRT.c(tbRichTextGraffitiInfo.url, 17, false);
        this.cRT.setTag(tbRichTextGraffitiInfo.url);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (tbRichTextGraffitiInfo != null && (layoutParams = this.cRT.getLayoutParams()) != null && i2 > cRP) {
            int i4 = tbRichTextGraffitiInfo.width;
            int i5 = (i2 - cRP) - cRQ;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.cRT.setLayoutParams(layoutParams);
            }
            this.cRV.setPadding(Math.min(i3, ((i2 - cRP) - i5) / 2), 0, 0, 0);
        }
    }

    public void l(boolean z, boolean z2) {
        if (this.aRC != z) {
            this.aRC = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.cRT;
    }

    public View getSaveBtn() {
        return this.cRV;
    }

    public void onChangeSkinType(int i) {
        aj.c(this.cRW, d.e.cp_link_tip_a, 1);
        aj.j(this.cRW, d.g.btn_tuya_save_n);
    }

    public void reset() {
        this.aQE = null;
        this.cRT.setImageResource(0);
        this.cRV.setBackgroundResource(0);
        this.cRW.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.util.d dVar;
        aoi();
        if (view == this.cRW && this.aQE != null && ax.aT(getContext()) && !com.baidu.tbadk.util.f.isFastDoubleClick() && !this.cRX) {
            this.cRX = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, com.baidu.tieba.tbadkCore.util.d.class);
            if (runTask != null && (dVar = (com.baidu.tieba.tbadkCore.util.d) runTask.getData()) != null) {
                dVar.b(this.aQE.url, this.cRZ);
            }
            TiebaStatic.log(new ak("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoi() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.e.b<View> q(final Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.graffiti.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aoj */
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

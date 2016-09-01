package com.baidu.tieba.graffiti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.util.Error;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.p;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements View.OnClickListener {
    static final int cwd = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.ds150);
    static final int cwe = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.ds30);
    private com.baidu.tbadk.widget.richText.f aIK;
    private boolean aJK;
    private View bGz;
    private final View.OnLongClickListener bIX;
    private RelativeLayout.LayoutParams cwf;
    private RelativeLayout.LayoutParams cwg;
    private TbImageView cwh;
    private View cwi;
    private TextView cwj;
    private boolean cwk;
    private final com.baidu.tbadk.util.e<Error> cwl;
    public final View.OnClickListener cwm;

    public e(Context context) {
        super(context);
        this.cwf = new RelativeLayout.LayoutParams(-2, -2);
        this.cwg = new RelativeLayout.LayoutParams(-1, -2);
        this.cwh = null;
        this.bGz = null;
        this.cwi = null;
        this.cwj = null;
        this.aJK = true;
        this.cwk = false;
        this.bIX = new f(this);
        this.cwl = new g(this);
        this.cwm = new h(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(t.h.tb_richtext_graffitiview, this);
        this.bGz = inflate.findViewById(t.g.root_layout);
        this.cwh = (TbImageView) inflate.findViewById(t.g.graffiti_image);
        this.cwh.setGifIconSupport(false);
        this.cwi = inflate.findViewById(t.g.save_layout);
        this.cwj = (TextView) inflate.findViewById(t.g.tv_save);
        this.cwh.setDrawBorder(true);
        this.cwh.setBorderColor(av.getColor(t.d.cp_bg_line_k));
        this.cwh.setBorderWidth(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds1));
        this.cwh.setFocusable(false);
        this.cwi.setClickable(true);
        this.cwh.setOnClickListener(this.cwm);
        this.cwh.setGifIconSupport(false);
        this.cwh.setAdjustViewBounds(false);
        this.cwj.setClickable(true);
        this.cwj.setOnClickListener(this);
        this.cwj.setLongClickable(true);
        this.cwj.setOnLongClickListener(this.bIX);
    }

    public void a(com.baidu.tbadk.widget.richText.f fVar, int i, String str, int i2, int i3, boolean z) {
        if (fVar == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aIK = fVar;
        a(fVar, i, i2, i3);
        if (!d.ajH() || !z) {
            this.cwi.setVisibility(8);
            this.bGz.setLayoutParams(this.cwf);
        } else {
            this.cwi.setVisibility(0);
            this.bGz.setLayoutParams(this.cwg);
        }
        boolean oM = l.oG().oM();
        this.cwh.setDefaultBgResource(t.d.cp_bg_line_c);
        if (oM) {
            this.cwh.setInterceptOnClick(false);
            this.cwh.setDefaultResource(t.f.transparent_bg);
        } else {
            this.cwh.setDefaultResource(t.f.icon_click);
            this.cwh.setInterceptOnClick(true);
        }
        this.cwh.c(fVar.url, 17, false);
        this.cwh.setTag(fVar.url);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void a(com.baidu.tbadk.widget.richText.f fVar, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (fVar != null && (layoutParams = this.cwh.getLayoutParams()) != null && i2 > cwd) {
            int i4 = fVar.width;
            int i5 = (i2 - cwd) - cwe;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.cwh.setLayoutParams(layoutParams);
            }
            this.cwi.setPadding(Math.min(i3, ((i2 - cwd) - i5) / 2), 0, 0, 0);
        }
    }

    public void k(boolean z, boolean z2) {
        if (this.aJK != z) {
            this.aJK = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.cwh;
    }

    public View getSaveBtn() {
        return this.cwi;
    }

    public void onChangeSkinType(int i) {
        av.c(this.cwj, t.d.cp_link_tip_a, 1);
        av.k(this.cwj, t.f.btn_tuya_save_n);
    }

    public void reset() {
        this.aIK = null;
        this.cwh.setImageResource(0);
        this.cwi.setBackgroundResource(0);
        this.cwj.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        ajI();
        if (view == this.cwj && this.aIK != null && bn.al(getContext()) && !com.baidu.tbadk.util.d.isFastDoubleClick() && !this.cwk) {
            this.cwk = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
            if (runTask != null && (pVar = (p) runTask.getData()) != null) {
                pVar.b(this.aIK.url, this.cwl);
            }
            TiebaStatic.log(new ay("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajI() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.f.b<View> createGraffitiViewPool(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new i(context), i, 0);
    }
}

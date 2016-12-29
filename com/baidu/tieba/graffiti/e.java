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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.util.Error;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.o;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements View.OnClickListener {
    static final int chf = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds150);
    static final int chg = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds30);
    private com.baidu.tbadk.widget.richText.f aIs;
    private boolean aJt;
    private View bpI;
    private final View.OnLongClickListener brV;
    private RelativeLayout.LayoutParams chh;
    private RelativeLayout.LayoutParams chi;
    private TbImageView chj;
    private View chk;
    private TextView chl;
    private boolean chm;
    private final com.baidu.tbadk.util.e<Error> chn;
    public final View.OnClickListener cho;

    public e(Context context) {
        super(context);
        this.chh = new RelativeLayout.LayoutParams(-2, -2);
        this.chi = new RelativeLayout.LayoutParams(-1, -2);
        this.chj = null;
        this.bpI = null;
        this.chk = null;
        this.chl = null;
        this.aJt = true;
        this.chm = false;
        this.brV = new f(this);
        this.chn = new g(this);
        this.cho = new h(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(r.h.tb_richtext_graffitiview, this);
        this.bpI = inflate.findViewById(r.g.root_layout);
        this.chj = (TbImageView) inflate.findViewById(r.g.graffiti_image);
        this.chj.setGifIconSupport(false);
        this.chk = inflate.findViewById(r.g.save_layout);
        this.chl = (TextView) inflate.findViewById(r.g.tv_save);
        this.chj.setDrawBorder(true);
        this.chj.setBorderColor(ar.getColor(r.d.cp_bg_line_k));
        this.chj.setBorderWidth(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1));
        this.chj.setFocusable(false);
        this.chk.setClickable(true);
        this.chj.setOnClickListener(this.cho);
        this.chj.setGifIconSupport(false);
        this.chj.setAdjustViewBounds(false);
        this.chl.setClickable(true);
        this.chl.setOnClickListener(this);
        this.chl.setLongClickable(true);
        this.chl.setOnLongClickListener(this.brV);
    }

    public void a(com.baidu.tbadk.widget.richText.f fVar, int i, String str, int i2, int i3, boolean z) {
        if (fVar == null) {
            setVisibility(8);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aIs = fVar;
        a(fVar, i, i2, i3);
        if (!d.agr() || !z) {
            this.chk.setVisibility(8);
            this.bpI.setLayoutParams(this.chh);
        } else {
            this.chk.setVisibility(0);
            this.bpI.setLayoutParams(this.chi);
        }
        boolean oP = l.oJ().oP();
        this.chj.setDefaultBgResource(r.d.cp_bg_line_c);
        if (oP) {
            this.chj.setInterceptOnClick(false);
            this.chj.setDefaultResource(r.f.transparent_bg);
        } else {
            this.chj.setDefaultResource(r.f.icon_click);
            this.chj.setInterceptOnClick(true);
        }
        this.chj.c(fVar.url, 17, false);
        this.chj.setTag(fVar.url);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void a(com.baidu.tbadk.widget.richText.f fVar, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (fVar != null && (layoutParams = this.chj.getLayoutParams()) != null && i2 > chf) {
            int i4 = fVar.width;
            int i5 = (i2 - chf) - chg;
            if (i5 <= 0 || i4 <= i5) {
                i5 = i4;
            }
            if (layoutParams.width != i5 || layoutParams.height != i5) {
                layoutParams.width = i5;
                layoutParams.height = i5;
                this.chj.setLayoutParams(layoutParams);
            }
            this.chk.setPadding(Math.min(i3, ((i2 - chf) - i5) / 2), 0, 0, 0);
        }
    }

    public void j(boolean z, boolean z2) {
        if (this.aJt != z) {
            this.aJt = z;
            if (z2) {
                requestLayout();
            }
        }
    }

    public TbImageView getGraffitiImageView() {
        return this.chj;
    }

    public View getSaveBtn() {
        return this.chk;
    }

    public void onChangeSkinType(int i) {
        ar.c(this.chl, r.d.cp_link_tip_a, 1);
        ar.k(this.chl, r.f.btn_tuya_save_n);
    }

    public void reset() {
        this.aIs = null;
        this.chj.setImageResource(0);
        this.chk.setBackgroundResource(0);
        this.chl.setBackgroundResource(0);
        setTag(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        ags();
        if (view == this.chl && this.aIs != null && bh.ai(getContext()) && !com.baidu.tbadk.util.d.isFastDoubleClick() && !this.chm) {
            this.chm = true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, o.class);
            if (runTask != null && (oVar = (o) runTask.getData()) != null) {
                oVar.b(this.aIs.url, this.chn);
            }
            TiebaStatic.log(new at("c10964"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ags() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }

    public static com.baidu.adp.lib.f.b<View> l(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new i(context), i, 0);
    }
}

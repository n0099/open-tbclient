package com.baidu.tieba.homepage.mygod.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.mygod.data.a> {
    private TbPageContext<?> Gf;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.flow.a.a> WP;
    private CoverFlowView<com.baidu.tbadk.core.flow.a.a> bQm;
    private String cpA;
    private String cpB;
    private com.baidu.tieba.homepage.mygod.data.a cpC;
    private final float cpD;
    private final CustomMessageListener cpE;
    private final CustomMessageListener cpF;
    private View.OnClickListener cpG;
    private View.OnClickListener cpH;
    private LinearLayout cps;
    private LinearLayout cpt;
    private TextView cpu;
    private TextView cpv;
    private ImageView cpw;
    private ImageView cpx;
    private View cpy;
    private View cpz;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.Gf = null;
        this.bQm = null;
        this.cps = null;
        this.cpt = null;
        this.cpu = null;
        this.cpv = null;
        this.cpw = null;
        this.cpx = null;
        this.cpy = null;
        this.cpz = null;
        this.cpA = null;
        this.cpB = null;
        this.cpC = null;
        this.cpD = 3.5294118f;
        this.cpE = new b(this, CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
        this.cpF = new c(this, CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
        this.WP = new d(this);
        this.cpG = new e(this);
        this.cpH = new f(this);
        this.Gf = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view;
        if (this.Gf != null && (view = getView()) != null) {
            this.cpu = (TextView) view.findViewById(r.g.textview_rank);
            this.cpv = (TextView) view.findViewById(r.g.textview_good);
            this.cpw = (ImageView) view.findViewById(r.g.image_rank);
            this.cpx = (ImageView) view.findViewById(r.g.image_good);
            this.cpy = view.findViewById(r.g.god_banner_bottom_margin);
            this.cpz = view.findViewById(r.g.middle_separate_line);
            this.bQm = (CoverFlowView) view.findViewById(r.g.god_banner_coverflowview);
            g gVar = new g(this);
            this.bQm.setDisableParentEvent(false);
            this.bQm.setCoverFlowFactory(gVar);
            this.bQm.setCallback(this.WP);
            this.cps = (LinearLayout) view.findViewById(r.g.layout_rank);
            this.cps.setOnClickListener(this.cpG);
            this.cpt = (LinearLayout) view.findViewById(r.g.layout_good);
            this.cpt.setOnClickListener(this.cpH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jK(String str) {
        if (TextUtils.isEmpty(str)) {
            k.showToast(this.Gf.getPageActivity(), r.j.url_is_null);
        } else {
            bc.vz().a(this.Gf, "", new String[]{str}, false, null, true);
        }
    }

    public void wN() {
        if (this.bQm != null) {
            this.bQm.tr();
        }
    }

    public void wM() {
        if (this.bQm != null) {
            this.bQm.tq();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.god_banner;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.homepage.mygod.data.a aVar) {
        if (aVar != null && aVar != this.cpC) {
            this.bQm.setData(aVar.aiN());
            this.cpA = aVar.aiL();
            this.cpB = aVar.aiM();
            this.cpC = aVar;
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ar.k(this.cpy, r.d.cp_bg_line_c);
            ar.k(this.cpz, r.d.cp_bg_line_a);
            ar.c(this.cpu, r.d.cp_cont_b, 1);
            ar.c(this.cpv, r.d.cp_cont_b, 1);
            ar.c(this.cpw, r.f.icon_god_rank);
            ar.c(this.cpx, r.f.icon_god_good);
        }
        this.mSkinType = i;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cpE.setTag(bdUniqueId);
            this.cpF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cpE);
            MessageManager.getInstance().registerListener(this.cpF);
        }
    }
}

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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.mygod.data.a> {
    private TbPageContext<?> Fp;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.flow.a.a> Wf;
    private CoverFlowView<com.baidu.tbadk.core.flow.a.a> bWQ;
    private View cwA;
    private String cwB;
    private String cwC;
    private com.baidu.tieba.homepage.mygod.data.a cwD;
    private final CustomMessageListener cwE;
    private final CustomMessageListener cwF;
    private View.OnClickListener cwG;
    private View.OnClickListener cwH;
    private LinearLayout cwt;
    private LinearLayout cwu;
    private TextView cwv;
    private TextView cww;
    private ImageView cwx;
    private ImageView cwy;
    private View cwz;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.Fp = null;
        this.bWQ = null;
        this.cwt = null;
        this.cwu = null;
        this.cwv = null;
        this.cww = null;
        this.cwx = null;
        this.cwy = null;
        this.cwz = null;
        this.cwA = null;
        this.cwB = null;
        this.cwC = null;
        this.cwD = null;
        this.cwE = new b(this, CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
        this.cwF = new c(this, CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
        this.Wf = new d(this);
        this.cwG = new e(this);
        this.cwH = new f(this);
        this.Fp = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view;
        if (this.Fp != null && (view = getView()) != null) {
            this.cwv = (TextView) view.findViewById(r.h.textview_rank);
            this.cww = (TextView) view.findViewById(r.h.textview_good);
            this.cwx = (ImageView) view.findViewById(r.h.image_rank);
            this.cwy = (ImageView) view.findViewById(r.h.image_good);
            this.cwz = view.findViewById(r.h.god_banner_bottom_margin);
            this.cwA = view.findViewById(r.h.middle_separate_line);
            this.bWQ = (CoverFlowView) view.findViewById(r.h.god_banner_coverflowview);
            g gVar = new g(this);
            this.bWQ.setDisableParentEvent(false);
            this.bWQ.setCoverFlowFactory(gVar);
            this.bWQ.setCallback(this.Wf);
            this.cwt = (LinearLayout) view.findViewById(r.h.layout_rank);
            this.cwt.setOnClickListener(this.cwG);
            this.cwu = (LinearLayout) view.findViewById(r.h.layout_good);
            this.cwu.setOnClickListener(this.cwH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jY(String str) {
        if (TextUtils.isEmpty(str)) {
            k.showToast(this.Fp.getPageActivity(), r.l.url_is_null);
        } else {
            ba.vt().a(this.Fp, "", new String[]{str}, false, null, true);
        }
    }

    public void wH() {
        if (this.bWQ != null) {
            this.bWQ.tl();
        }
    }

    public void wG() {
        if (this.bWQ != null) {
            this.bWQ.tk();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.god_banner;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.homepage.mygod.data.a aVar) {
        if (aVar != null && aVar != this.cwD) {
            this.bWQ.setData(aVar.ajV());
            this.cwB = aVar.ajT();
            this.cwC = aVar.ajU();
            this.cwD = aVar;
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.j(this.cwz, r.e.cp_bg_line_c);
            ap.j(this.cwA, r.e.cp_bg_line_a);
            ap.c(this.cwv, r.e.cp_cont_b, 1);
            ap.c(this.cww, r.e.cp_cont_b, 1);
            ap.c(this.cwx, r.g.icon_god_rank);
            ap.c(this.cwy, r.g.icon_god_good);
        }
        this.mSkinType = i;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cwE.setTag(bdUniqueId);
            this.cwF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cwE);
            MessageManager.getInstance().registerListener(this.cwF);
        }
    }
}

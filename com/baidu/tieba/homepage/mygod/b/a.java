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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.mygod.data.a> {
    private TbPageContext<?> aaX;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.flow.a.a> abI;
    private CoverFlowView<com.baidu.tbadk.core.flow.a.a> ccP;
    private String cwA;
    private String cwB;
    private com.baidu.tieba.homepage.mygod.data.a cwC;
    private final CustomMessageListener cwD;
    private final CustomMessageListener cwE;
    private View.OnClickListener cwF;
    private View.OnClickListener cwG;
    private LinearLayout cws;
    private LinearLayout cwt;
    private TextView cwu;
    private TextView cwv;
    private ImageView cww;
    private ImageView cwx;
    private View cwy;
    private View cwz;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aaX = null;
        this.ccP = null;
        this.cws = null;
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
        this.cwD = new b(this, CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
        this.cwE = new c(this, CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
        this.abI = new d(this);
        this.cwF = new e(this);
        this.cwG = new f(this);
        this.aaX = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view;
        if (this.aaX != null && (view = getView()) != null) {
            this.cwu = (TextView) view.findViewById(w.h.textview_rank);
            this.cwv = (TextView) view.findViewById(w.h.textview_good);
            this.cww = (ImageView) view.findViewById(w.h.image_rank);
            this.cwx = (ImageView) view.findViewById(w.h.image_good);
            this.cwy = view.findViewById(w.h.god_banner_bottom_margin);
            this.cwz = view.findViewById(w.h.middle_separate_line);
            this.ccP = (CoverFlowView) view.findViewById(w.h.god_banner_coverflowview);
            g gVar = new g(this);
            this.ccP.setDisableParentEvent(false);
            this.ccP.setCoverFlowFactory(gVar);
            this.ccP.setCallback(this.abI);
            this.cws = (LinearLayout) view.findViewById(w.h.layout_rank);
            this.cws.setOnClickListener(this.cwF);
            this.cwt = (LinearLayout) view.findViewById(w.h.layout_good);
            this.cwt.setOnClickListener(this.cwG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jE(String str) {
        if (TextUtils.isEmpty(str)) {
            k.showToast(this.aaX.getPageActivity(), w.l.url_is_null);
        } else {
            bb.wn().a(this.aaX, "", new String[]{str}, false, null, true);
        }
    }

    public void xA() {
        if (this.ccP != null) {
            this.ccP.uf();
        }
    }

    public void xz() {
        if (this.ccP != null) {
            this.ccP.ue();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.god_banner;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.homepage.mygod.data.a aVar) {
        if (aVar != null && aVar != this.cwC) {
            this.ccP.setData(aVar.ajb());
            this.cwA = aVar.aiZ();
            this.cwB = aVar.aja();
            this.cwC = aVar;
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.cwy, w.e.cp_bg_line_c);
            aq.j(this.cwz, w.e.cp_bg_line_a);
            aq.c(this.cwu, w.e.cp_cont_b, 1);
            aq.c(this.cwv, w.e.cp_cont_b, 1);
            aq.c(this.cww, w.g.icon_god_rank);
            aq.c(this.cwx, w.g.icon_god_good);
        }
        this.mSkinType = i;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cwD.setTag(bdUniqueId);
            this.cwE.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cwD);
            MessageManager.getInstance().registerListener(this.cwE);
        }
    }
}

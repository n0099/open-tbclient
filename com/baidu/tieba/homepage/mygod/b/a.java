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
    private TbPageContext<?> aaI;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.flow.a.a> abt;
    private CoverFlowView<com.baidu.tbadk.core.flow.a.a> ceo;
    private LinearLayout cxS;
    private LinearLayout cxT;
    private TextView cxU;
    private TextView cxV;
    private ImageView cxW;
    private ImageView cxX;
    private View cxY;
    private View cxZ;
    private String cya;
    private String cyb;
    private com.baidu.tieba.homepage.mygod.data.a cyc;
    private final CustomMessageListener cyd;
    private final CustomMessageListener cye;
    private View.OnClickListener cyf;
    private View.OnClickListener cyg;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aaI = null;
        this.ceo = null;
        this.cxS = null;
        this.cxT = null;
        this.cxU = null;
        this.cxV = null;
        this.cxW = null;
        this.cxX = null;
        this.cxY = null;
        this.cxZ = null;
        this.cya = null;
        this.cyb = null;
        this.cyc = null;
        this.cyd = new b(this, CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
        this.cye = new c(this, CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
        this.abt = new d(this);
        this.cyf = new e(this);
        this.cyg = new f(this);
        this.aaI = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view;
        if (this.aaI != null && (view = getView()) != null) {
            this.cxU = (TextView) view.findViewById(w.h.textview_rank);
            this.cxV = (TextView) view.findViewById(w.h.textview_good);
            this.cxW = (ImageView) view.findViewById(w.h.image_rank);
            this.cxX = (ImageView) view.findViewById(w.h.image_good);
            this.cxY = view.findViewById(w.h.god_banner_bottom_margin);
            this.cxZ = view.findViewById(w.h.middle_separate_line);
            this.ceo = (CoverFlowView) view.findViewById(w.h.god_banner_coverflowview);
            g gVar = new g(this);
            this.ceo.setDisableParentEvent(false);
            this.ceo.setCoverFlowFactory(gVar);
            this.ceo.setCallback(this.abt);
            this.cxS = (LinearLayout) view.findViewById(w.h.layout_rank);
            this.cxS.setOnClickListener(this.cyf);
            this.cxT = (LinearLayout) view.findViewById(w.h.layout_good);
            this.cxT.setOnClickListener(this.cyg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jz(String str) {
        if (TextUtils.isEmpty(str)) {
            k.showToast(this.aaI.getPageActivity(), w.l.url_is_null);
        } else {
            bb.vQ().a(this.aaI, "", new String[]{str}, false, null, true);
        }
    }

    public void xe() {
        if (this.ceo != null) {
            this.ceo.tI();
        }
    }

    public void xd() {
        if (this.ceo != null) {
            this.ceo.tH();
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
        if (aVar != null && aVar != this.cyc) {
            this.ceo.setData(aVar.ajh());
            this.cya = aVar.ajf();
            this.cyb = aVar.ajg();
            this.cyc = aVar;
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.cxY, w.e.cp_bg_line_c);
            aq.j(this.cxZ, w.e.cp_bg_line_a);
            aq.c(this.cxU, w.e.cp_cont_b, 1);
            aq.c(this.cxV, w.e.cp_cont_b, 1);
            aq.c(this.cxW, w.g.icon_god_rank);
            aq.c(this.cxX, w.g.icon_god_good);
        }
        this.mSkinType = i;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cyd.setTag(bdUniqueId);
            this.cye.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cyd);
            MessageManager.getInstance().registerListener(this.cye);
        }
    }
}

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
    private TbPageContext<?> aaY;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.flow.a.a> abJ;
    private CoverFlowView<com.baidu.tbadk.core.flow.a.a> cfg;
    private LinearLayout cyJ;
    private LinearLayout cyK;
    private TextView cyL;
    private TextView cyM;
    private ImageView cyN;
    private ImageView cyO;
    private View cyP;
    private View cyQ;
    private String cyR;
    private String cyS;
    private com.baidu.tieba.homepage.mygod.data.a cyT;
    private final CustomMessageListener cyU;
    private final CustomMessageListener cyV;
    private View.OnClickListener cyW;
    private View.OnClickListener cyX;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aaY = null;
        this.cfg = null;
        this.cyJ = null;
        this.cyK = null;
        this.cyL = null;
        this.cyM = null;
        this.cyN = null;
        this.cyO = null;
        this.cyP = null;
        this.cyQ = null;
        this.cyR = null;
        this.cyS = null;
        this.cyT = null;
        this.cyU = new b(this, CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
        this.cyV = new c(this, CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
        this.abJ = new d(this);
        this.cyW = new e(this);
        this.cyX = new f(this);
        this.aaY = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view;
        if (this.aaY != null && (view = getView()) != null) {
            this.cyL = (TextView) view.findViewById(w.h.textview_rank);
            this.cyM = (TextView) view.findViewById(w.h.textview_good);
            this.cyN = (ImageView) view.findViewById(w.h.image_rank);
            this.cyO = (ImageView) view.findViewById(w.h.image_good);
            this.cyP = view.findViewById(w.h.god_banner_bottom_margin);
            this.cyQ = view.findViewById(w.h.middle_separate_line);
            this.cfg = (CoverFlowView) view.findViewById(w.h.god_banner_coverflowview);
            g gVar = new g(this);
            this.cfg.setDisableParentEvent(false);
            this.cfg.setCoverFlowFactory(gVar);
            this.cfg.setCallback(this.abJ);
            this.cyJ = (LinearLayout) view.findViewById(w.h.layout_rank);
            this.cyJ.setOnClickListener(this.cyW);
            this.cyK = (LinearLayout) view.findViewById(w.h.layout_good);
            this.cyK.setOnClickListener(this.cyX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jF(String str) {
        if (TextUtils.isEmpty(str)) {
            k.showToast(this.aaY.getPageActivity(), w.l.url_is_null);
        } else {
            bb.wn().a(this.aaY, "", new String[]{str}, false, null, true);
        }
    }

    public void xA() {
        if (this.cfg != null) {
            this.cfg.uf();
        }
    }

    public void xz() {
        if (this.cfg != null) {
            this.cfg.ue();
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
        if (aVar != null && aVar != this.cyT) {
            this.cfg.setData(aVar.akc());
            this.cyR = aVar.aka();
            this.cyS = aVar.akb();
            this.cyT = aVar;
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.cyP, w.e.cp_bg_line_c);
            aq.j(this.cyQ, w.e.cp_bg_line_a);
            aq.c(this.cyL, w.e.cp_cont_b, 1);
            aq.c(this.cyM, w.e.cp_cont_b, 1);
            aq.c(this.cyN, w.g.icon_god_rank);
            aq.c(this.cyO, w.g.icon_god_good);
        }
        this.mSkinType = i;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cyU.setTag(bdUniqueId);
            this.cyV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cyU);
            MessageManager.getInstance().registerListener(this.cyV);
        }
    }
}

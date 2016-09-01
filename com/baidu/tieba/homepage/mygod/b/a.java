package com.baidu.tieba.homepage.mygod.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.mygod.data.a> {
    private TbPageContext<?> Gd;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.flow.a.a> WK;
    private CoverFlowView<com.baidu.tbadk.core.flow.a.a> bzS;
    private LinearLayout cEg;
    private LinearLayout cEh;
    private TextView cEi;
    private TextView cEj;
    private ImageView cEk;
    private ImageView cEl;
    private View cEm;
    private View cEn;
    private String cEo;
    private String cEp;
    private com.baidu.tieba.homepage.mygod.data.a cEq;
    private final float cEr;
    private final CustomMessageListener cEs;
    private final CustomMessageListener cEt;
    private View.OnClickListener cEu;
    private View.OnClickListener cEv;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.Gd = null;
        this.bzS = null;
        this.cEg = null;
        this.cEh = null;
        this.cEi = null;
        this.cEj = null;
        this.cEk = null;
        this.cEl = null;
        this.cEm = null;
        this.cEn = null;
        this.cEo = null;
        this.cEp = null;
        this.cEq = null;
        this.cEr = 3.5294118f;
        this.cEs = new b(this, CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
        this.cEt = new c(this, CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
        this.WK = new d(this);
        this.cEu = new e(this);
        this.cEv = new f(this);
        this.Gd = tbPageContext;
        initUI();
        registerListener();
    }

    private void registerListener() {
        getTbPageContext().registerListener(this.cEs);
        getTbPageContext().registerListener(this.cEt);
    }

    private void initUI() {
        View view;
        if (this.Gd != null && (view = getView()) != null) {
            this.cEi = (TextView) view.findViewById(t.g.textview_rank);
            this.cEj = (TextView) view.findViewById(t.g.textview_good);
            this.cEk = (ImageView) view.findViewById(t.g.image_rank);
            this.cEl = (ImageView) view.findViewById(t.g.image_good);
            this.cEm = view.findViewById(t.g.god_banner_bottom_margin);
            this.cEn = view.findViewById(t.g.middle_separate_line);
            this.bzS = (CoverFlowView) view.findViewById(t.g.god_banner_coverflowview);
            g gVar = new g(this);
            this.bzS.setDisableParentEvent(false);
            this.bzS.setCoverFlowFactory(gVar);
            this.bzS.setCallback(this.WK);
            this.cEg = (LinearLayout) view.findViewById(t.g.layout_rank);
            this.cEg.setOnClickListener(this.cEu);
            this.cEh = (LinearLayout) view.findViewById(t.g.layout_good);
            this.cEh.setOnClickListener(this.cEv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kO(String str) {
        if (TextUtils.isEmpty(str)) {
            k.showToast(this.Gd.getPageActivity(), t.j.url_is_null);
        } else {
            bi.vx().a(this.Gd, "", new String[]{str}, false, null, true);
        }
    }

    public void wS() {
        if (this.bzS != null) {
            this.bzS.tn();
        }
    }

    public void wR() {
        if (this.bzS != null) {
            this.bzS.tm();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.god_banner;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.homepage.mygod.data.a aVar) {
        if (aVar != null && aVar != this.cEq) {
            this.bzS.setData(aVar.ame());
            this.cEo = aVar.amc();
            this.cEp = aVar.amd();
            this.cEq = aVar;
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(this.cEm, t.d.cp_bg_line_c);
            av.k(this.cEn, t.d.cp_bg_line_a);
            av.c(this.cEi, t.d.cp_cont_b, 1);
            av.c(this.cEj, t.d.cp_cont_b, 1);
            av.c(this.cEk, t.f.icon_god_rank);
            av.c(this.cEl, t.f.icon_god_good);
        }
        this.mSkinType = i;
    }
}

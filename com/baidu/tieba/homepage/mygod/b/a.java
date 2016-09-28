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
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.mygod.data.a> {
    private TbPageContext<?> Gd;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.flow.a.a> WX;
    private CoverFlowView<com.baidu.tbadk.core.flow.a.a> bAe;
    private LinearLayout cEK;
    private LinearLayout cEL;
    private TextView cEM;
    private TextView cEN;
    private ImageView cEO;
    private ImageView cEP;
    private View cEQ;
    private View cER;
    private String cES;
    private String cET;
    private com.baidu.tieba.homepage.mygod.data.a cEU;
    private final float cEV;
    private final CustomMessageListener cEW;
    private final CustomMessageListener cEX;
    private View.OnClickListener cEY;
    private View.OnClickListener cEZ;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.Gd = null;
        this.bAe = null;
        this.cEK = null;
        this.cEL = null;
        this.cEM = null;
        this.cEN = null;
        this.cEO = null;
        this.cEP = null;
        this.cEQ = null;
        this.cER = null;
        this.cES = null;
        this.cET = null;
        this.cEU = null;
        this.cEV = 3.5294118f;
        this.cEW = new b(this, CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
        this.cEX = new c(this, CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
        this.WX = new d(this);
        this.cEY = new e(this);
        this.cEZ = new f(this);
        this.Gd = tbPageContext;
        initUI();
        registerListener();
    }

    private void registerListener() {
        getTbPageContext().registerListener(this.cEW);
        getTbPageContext().registerListener(this.cEX);
    }

    private void initUI() {
        View view;
        if (this.Gd != null && (view = getView()) != null) {
            this.cEM = (TextView) view.findViewById(r.g.textview_rank);
            this.cEN = (TextView) view.findViewById(r.g.textview_good);
            this.cEO = (ImageView) view.findViewById(r.g.image_rank);
            this.cEP = (ImageView) view.findViewById(r.g.image_good);
            this.cEQ = view.findViewById(r.g.god_banner_bottom_margin);
            this.cER = view.findViewById(r.g.middle_separate_line);
            this.bAe = (CoverFlowView) view.findViewById(r.g.god_banner_coverflowview);
            g gVar = new g(this);
            this.bAe.setDisableParentEvent(false);
            this.bAe.setCoverFlowFactory(gVar);
            this.bAe.setCallback(this.WX);
            this.cEK = (LinearLayout) view.findViewById(r.g.layout_rank);
            this.cEK.setOnClickListener(this.cEY);
            this.cEL = (LinearLayout) view.findViewById(r.g.layout_good);
            this.cEL.setOnClickListener(this.cEZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kV(String str) {
        if (TextUtils.isEmpty(str)) {
            k.showToast(this.Gd.getPageActivity(), r.j.url_is_null);
        } else {
            bh.vL().a(this.Gd, "", new String[]{str}, false, null, true);
        }
    }

    public void wU() {
        if (this.bAe != null) {
            this.bAe.tC();
        }
    }

    public void wT() {
        if (this.bAe != null) {
            this.bAe.tB();
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
        if (aVar != null && aVar != this.cEU) {
            this.bAe.setData(aVar.ams());
            this.cES = aVar.amq();
            this.cET = aVar.amr();
            this.cEU = aVar;
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(this.cEQ, r.d.cp_bg_line_c);
            av.k(this.cER, r.d.cp_bg_line_a);
            av.c(this.cEM, r.d.cp_cont_b, 1);
            av.c(this.cEN, r.d.cp_cont_b, 1);
            av.c(this.cEO, r.f.icon_god_rank);
            av.c(this.cEP, r.f.icon_god_good);
        }
        this.mSkinType = i;
    }
}

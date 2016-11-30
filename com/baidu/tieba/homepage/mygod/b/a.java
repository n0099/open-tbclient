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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.mygod.data.a> {
    private TbPageContext<?> Gf;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.flow.a.a> Xv;
    private CoverFlowView<com.baidu.tbadk.core.flow.a.a> bCZ;
    private LinearLayout cJX;
    private LinearLayout cJY;
    private TextView cJZ;
    private TextView cKa;
    private ImageView cKb;
    private ImageView cKc;
    private View cKd;
    private View cKe;
    private String cKf;
    private String cKg;
    private com.baidu.tieba.homepage.mygod.data.a cKh;
    private final float cKi;
    private final CustomMessageListener cKj;
    private final CustomMessageListener cKk;
    private View.OnClickListener cKl;
    private View.OnClickListener cKm;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.Gf = null;
        this.bCZ = null;
        this.cJX = null;
        this.cJY = null;
        this.cJZ = null;
        this.cKa = null;
        this.cKb = null;
        this.cKc = null;
        this.cKd = null;
        this.cKe = null;
        this.cKf = null;
        this.cKg = null;
        this.cKh = null;
        this.cKi = 3.5294118f;
        this.cKj = new b(this, CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
        this.cKk = new c(this, CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
        this.Xv = new d(this);
        this.cKl = new e(this);
        this.cKm = new f(this);
        this.Gf = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view;
        if (this.Gf != null && (view = getView()) != null) {
            this.cJZ = (TextView) view.findViewById(r.g.textview_rank);
            this.cKa = (TextView) view.findViewById(r.g.textview_good);
            this.cKb = (ImageView) view.findViewById(r.g.image_rank);
            this.cKc = (ImageView) view.findViewById(r.g.image_good);
            this.cKd = view.findViewById(r.g.god_banner_bottom_margin);
            this.cKe = view.findViewById(r.g.middle_separate_line);
            this.bCZ = (CoverFlowView) view.findViewById(r.g.god_banner_coverflowview);
            g gVar = new g(this);
            this.bCZ.setDisableParentEvent(false);
            this.bCZ.setCoverFlowFactory(gVar);
            this.bCZ.setCallback(this.Xv);
            this.cJX = (LinearLayout) view.findViewById(r.g.layout_rank);
            this.cJX.setOnClickListener(this.cKl);
            this.cJY = (LinearLayout) view.findViewById(r.g.layout_good);
            this.cJY.setOnClickListener(this.cKm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lg(String str) {
        if (TextUtils.isEmpty(str)) {
            k.showToast(this.Gf.getPageActivity(), r.j.url_is_null);
        } else {
            bf.vP().a(this.Gf, "", new String[]{str}, false, null, true);
        }
    }

    public void xa() {
        if (this.bCZ != null) {
            this.bCZ.tG();
        }
    }

    public void wZ() {
        if (this.bCZ != null) {
            this.bCZ.tF();
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
        if (aVar != null && aVar != this.cKh) {
            this.bCZ.setData(aVar.aon());
            this.cKf = aVar.aol();
            this.cKg = aVar.aom();
            this.cKh = aVar;
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            at.k(this.cKd, r.d.cp_bg_line_c);
            at.k(this.cKe, r.d.cp_bg_line_a);
            at.c(this.cJZ, r.d.cp_cont_b, 1);
            at.c(this.cKa, r.d.cp_cont_b, 1);
            at.c(this.cKb, r.f.icon_god_rank);
            at.c(this.cKc, r.f.icon_god_good);
        }
        this.mSkinType = i;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cKj.setTag(bdUniqueId);
            this.cKk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cKj);
            MessageManager.getInstance().registerListener(this.cKk);
        }
    }
}

package com.baidu.tieba.card;

import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarFolderFirstDirActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.core.view.viewpager.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.a.e;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class cg extends com.baidu.tieba.card.a<com.baidu.tieba.card.a.e> implements BdBaseViewPager.a {
    private View aLn;
    public View aRy;
    private String aSM;
    private ViewPager aUZ;
    private com.baidu.tbadk.core.view.viewpager.b aVa;
    private a aVb;
    private View aVc;
    private TextView aVd;
    private TextView aVe;
    private com.baidu.tieba.card.a.e aVf;
    private int aVg;
    private IndicatorView ain;

    public void he(String str) {
        this.aSM = str;
    }

    public cg(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aVg = 0;
        this.aSM = null;
        w(getView());
    }

    private void w(View view) {
        this.aUZ = (ViewPager) view.findViewById(t.g.card_banner_viewpager);
        this.ain = (IndicatorView) view.findViewById(t.g.card_banner_indicator);
        this.aVd = (TextView) view.findViewById(t.g.card_banner_title);
        this.aVe = (TextView) view.findViewById(t.g.card_banner_tag);
        this.aVc = view.findViewById(t.g.card_banner_bottom_layout);
        this.aRy = view.findViewById(t.g.divider_card);
        this.aLn = view.findViewById(t.g.divider_line);
        this.aVa = new com.baidu.tbadk.core.view.viewpager.b(getContext(), this.aUZ, this.ain, null);
        this.aVb = new a(Lb(), com.baidu.tbadk.core.view.viewpager.a.a.aiH);
        this.aVa.setMaxScrollCountLimit(5);
        this.aVa.setAutoScrollIntervalTime(4500L);
        this.aVa.a(getContext(), this.aVb);
        this.aVa.setOnPageChangeListener(new ch(this));
        this.aVd.setOnClickListener(this);
        this.aVe.setOnClickListener(this);
        this.aVb.setOnItemClickListener(new ci(this));
    }

    public void setAutoScrollIntervalTime(long j) {
        this.aVa.setAutoScrollIntervalTime(j);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void xO() {
        this.aVa.xO();
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void xP() {
        this.aVa.xP();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u uVar;
        if ((view == this.aVd || view == this.aVe) && this.aUZ != null && this.aVf != null && this.aVf.FZ() != null && (uVar = (com.baidu.adp.widget.ListView.u) com.baidu.tbadk.core.util.y.b(this.aVf.FZ(), this.aVg)) != null && (uVar instanceof e.a)) {
            a((e.a) uVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.a aVar) {
        if (aVar != null) {
            if (aVar.type == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(getContext(), "")));
                return;
            }
            if (!TextUtils.isEmpty(aVar.link)) {
                com.baidu.tbadk.core.util.bg.wM().c(Lb(), new String[]{aVar.link});
            }
            if (!TextUtils.isEmpty(this.aSM)) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw(this.aSM).r("obj_locate", this.aVg).ac("obj_source", aVar.url));
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.ain.setSelector(com.baidu.tbadk.core.util.at.getDrawable(t.f.dot_live_s));
            this.ain.setDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.dot_live_n));
            com.baidu.tbadk.core.util.at.l(this.aRy, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.l(this.aLn, t.d.cp_bg_line_c);
            com.baidu.tbadk.i.a.a(Lb(), this.aVc);
            this.mSkinType = i;
        }
        this.aVa.de(i);
    }

    @Override // com.baidu.tieba.card.a
    public int Le() {
        return t.h.card_banner_flow;
    }

    public void a(com.baidu.tieba.card.a.e eVar) {
        if (eVar == null || eVar.FZ() == null || eVar.FZ().isEmpty()) {
            getView().setVisibility(8);
            return;
        }
        this.aVf = eVar;
        this.aVb.au(this.aVf.LK());
        getView().setVisibility(0);
        this.aUZ.removeAllViews();
        List<com.baidu.adp.widget.ListView.u> FZ = eVar.FZ();
        if (FZ.size() > 5) {
            FZ = FZ.subList(0, 5);
        }
        this.aVa.setDatas(FZ);
        d(Lb(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i) {
        if (this.aVf != null && this.aVf.FZ() != null && !this.aVf.FZ().isEmpty()) {
            List<com.baidu.adp.widget.ListView.u> FZ = this.aVf.FZ();
            com.baidu.adp.widget.ListView.u uVar = (com.baidu.adp.widget.ListView.u) com.baidu.tbadk.core.util.y.b(FZ, i);
            if (uVar != null && (uVar instanceof e.a)) {
                this.aVa.setMaxScrollCountLimit(FZ.size());
                e.a aVar = (e.a) uVar;
                this.aVd.setText(aVar.title);
                if (aVar.type == 2) {
                    this.aVe.setVisibility(8);
                } else if (!TextUtils.isEmpty(aVar.tag)) {
                    this.aVe.setVisibility(0);
                    this.aVe.setText(com.baidu.tbadk.core.util.ay.c(aVar.tag, 4, null));
                } else {
                    this.aVe.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.tbadk.core.view.viewpager.e<e.a, C0061a> {
        private long aVi;
        private TbPageContext<?> mTbPageContext;

        public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
            super(tbPageContext.getPageActivity(), bdUniqueId);
            this.mTbPageContext = tbPageContext;
        }

        public void au(long j) {
            this.aVi = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x002b: IGET  (r2v1 long A[REMOVE]) = (r4v0 'this' com.baidu.tieba.card.cg$a A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.cg.a.aVi long)] */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.tbadk.core.view.viewpager.e
        public View a(ViewGroup viewGroup, C0061a c0061a, e.a aVar) {
            c0061a.aVj.c(aVar.getImageUrl(), 10, false);
            c0061a.aVj.setContentDescription(aVar.title);
            if (aVar.type == 2) {
                com.baidu.tbadk.core.util.at.k(c0061a.aVm, t.f.pic_shuiyin_ba);
                c0061a.aVk.setVisibility(0);
                c0061a.aVl.setText(new StringBuilder().append(this.aVi).toString());
            } else {
                c0061a.aVk.setVisibility(8);
            }
            return c0061a.getView();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.tbadk.core.view.viewpager.e
        public void a(int i, C0061a c0061a, e.a aVar) {
            com.baidu.tbadk.core.util.at.k(c0061a.aVm, t.f.pic_shuiyin_ba);
            com.baidu.tbadk.core.util.at.k(c0061a.aVl, t.f.btn_batuijian_input);
            com.baidu.tbadk.i.a.a(this.mTbPageContext, c0061a.aVk);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.view.viewpager.e
        /* renamed from: e */
        public C0061a d(ViewGroup viewGroup) {
            return new C0061a(LayoutInflater.from(this.mContext).inflate(t.h.card_banner_flowview_item, (ViewGroup) null, false));
        }

        /* renamed from: com.baidu.tieba.card.cg$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0061a extends a.C0044a {
            public TbImageView aVj;
            public View aVk;
            public TextView aVl;
            public TextView aVm;

            public C0061a(View view) {
                super(view);
                this.aVj = (TbImageView) view.findViewById(t.g.card_banner_iv);
                this.aVk = view.findViewById(t.g.card_banner_bar_num_layout);
                this.aVl = (TextView) view.findViewById(t.g.card_banner_bar_num);
                this.aVm = (TextView) view.findViewById(t.g.card_banner_logo);
            }
        }
    }
}

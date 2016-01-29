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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.core.view.viewpager.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.a.e;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class ay extends com.baidu.tieba.card.a<com.baidu.tieba.card.a.e> implements BdBaseViewPager.a {
    private View aIr;
    public View aOJ;
    private String aPR;
    private ViewPager aRr;
    private com.baidu.tbadk.core.view.viewpager.b aRs;
    private a aRt;
    private View aRu;
    private TextView aRv;
    private TextView aRw;
    private com.baidu.tieba.card.a.e aRx;
    private int aRy;
    private IndicatorView ahX;

    public void gR(String str) {
        this.aPR = str;
    }

    public ay(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aRy = 0;
        this.aPR = null;
        w(getView());
    }

    private void w(View view) {
        this.aRr = (ViewPager) view.findViewById(t.g.card_banner_viewpager);
        this.ahX = (IndicatorView) view.findViewById(t.g.card_banner_indicator);
        this.aRv = (TextView) view.findViewById(t.g.card_banner_title);
        this.aRw = (TextView) view.findViewById(t.g.card_banner_tag);
        this.aRu = view.findViewById(t.g.card_banner_bottom_layout);
        this.aOJ = view.findViewById(t.g.divider_card);
        this.aIr = view.findViewById(t.g.divider_line);
        this.aRs = new com.baidu.tbadk.core.view.viewpager.b(getContext(), this.aRr, this.ahX, null);
        this.aRt = new a(JK(), com.baidu.tbadk.core.view.viewpager.a.a.air);
        this.aRs.dn(5);
        this.aRs.H(4500L);
        this.aRs.a(getContext(), this.aRt);
        this.aRs.setOnPageChangeListener(new az(this));
        this.aRv.setOnClickListener(this);
        this.aRw.setOnClickListener(this);
        this.aRt.a(new ba(this));
    }

    public void H(long j) {
        this.aRs.H(j);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void xo() {
        this.aRs.xo();
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void xp() {
        this.aRs.xp();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u uVar;
        if ((view == this.aRv || view == this.aRw) && this.aRr != null && this.aRx != null && this.aRx.Fm() != null && (uVar = (com.baidu.adp.widget.ListView.u) com.baidu.tbadk.core.util.x.b(this.aRx.Fm(), this.aRy)) != null && (uVar instanceof e.a)) {
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
                be.wt().c(JK(), new String[]{aVar.link});
            }
            if (!TextUtils.isEmpty(this.aPR)) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au(this.aPR).r("obj_locate", this.aRy).aa("obj_source", aVar.url));
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.ahX.setSelector(com.baidu.tbadk.core.util.ar.getDrawable(t.f.dot_live_s));
            this.ahX.setDrawable(com.baidu.tbadk.core.util.ar.getDrawable(t.f.dot_live_n));
            com.baidu.tbadk.core.util.ar.l(this.aOJ, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.l(this.aIr, t.d.cp_bg_line_c);
            com.baidu.tbadk.i.a.a(JK(), this.aRu);
            this.mSkinType = i;
        }
        this.aRs.db(i);
    }

    @Override // com.baidu.tieba.card.a
    public int JM() {
        return t.h.card_banner_flow;
    }

    public void a(com.baidu.tieba.card.a.e eVar) {
        if (eVar == null || eVar.Fm() == null || eVar.Fm().isEmpty()) {
            getView().setVisibility(8);
            return;
        }
        this.aRx = eVar;
        this.aRt.aq(this.aRx.Kq());
        getView().setVisibility(0);
        this.aRr.removeAllViews();
        List<com.baidu.adp.widget.ListView.u> Fm = eVar.Fm();
        if (Fm.size() > 5) {
            Fm = Fm.subList(0, 5);
        }
        this.aRs.setDatas(Fm);
        d(JK(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i) {
        if (this.aRx != null && this.aRx.Fm() != null && !this.aRx.Fm().isEmpty()) {
            List<com.baidu.adp.widget.ListView.u> Fm = this.aRx.Fm();
            com.baidu.adp.widget.ListView.u uVar = (com.baidu.adp.widget.ListView.u) com.baidu.tbadk.core.util.x.b(Fm, i);
            if (uVar != null && (uVar instanceof e.a)) {
                this.aRs.dn(Fm.size());
                e.a aVar = (e.a) uVar;
                this.aRv.setText(aVar.title);
                if (aVar.type == 2) {
                    this.aRw.setVisibility(8);
                } else if (!TextUtils.isEmpty(aVar.tag)) {
                    this.aRw.setVisibility(0);
                    this.aRw.setText(com.baidu.tbadk.core.util.aw.d(aVar.tag, 4, null));
                } else {
                    this.aRw.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.tbadk.core.view.viewpager.e<e.a, C0060a> {
        private long aRA;
        private TbPageContext<?> mTbPageContext;

        public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
            super(tbPageContext.getPageActivity(), bdUniqueId);
            this.mTbPageContext = tbPageContext;
        }

        public void aq(long j) {
            this.aRA = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0024: IGET  (r2v1 long A[REMOVE]) = (r4v0 'this' com.baidu.tieba.card.ay$a A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.ay.a.aRA long)] */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.tbadk.core.view.viewpager.e
        public View a(ViewGroup viewGroup, C0060a c0060a, e.a aVar) {
            c0060a.aRB.d(aVar.getImageUrl(), 10, false);
            if (aVar.type == 2) {
                com.baidu.tbadk.core.util.ar.k(c0060a.aRE, t.f.pic_shuiyin_ba);
                c0060a.aRC.setVisibility(0);
                c0060a.aRD.setText(new StringBuilder().append(this.aRA).toString());
            } else {
                c0060a.aRC.setVisibility(8);
            }
            return c0060a.getView();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.tbadk.core.view.viewpager.e
        public void a(int i, C0060a c0060a, e.a aVar) {
            com.baidu.tbadk.core.util.ar.k(c0060a.aRE, t.f.pic_shuiyin_ba);
            com.baidu.tbadk.core.util.ar.k(c0060a.aRD, t.f.btn_batuijian_input);
            com.baidu.tbadk.i.a.a(this.mTbPageContext, c0060a.aRC);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.view.viewpager.e
        /* renamed from: e */
        public C0060a d(ViewGroup viewGroup) {
            return new C0060a(LayoutInflater.from(this.mContext).inflate(t.h.card_banner_flowview_item, (ViewGroup) null, false));
        }

        /* renamed from: com.baidu.tieba.card.ay$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0060a extends a.C0044a {
            public TbImageView aRB;
            public View aRC;
            public TextView aRD;
            public TextView aRE;

            public C0060a(View view) {
                super(view);
                this.aRB = (TbImageView) view.findViewById(t.g.card_banner_iv);
                this.aRC = view.findViewById(t.g.card_banner_bar_num_layout);
                this.aRD = (TextView) view.findViewById(t.g.card_banner_bar_num);
                this.aRE = (TextView) view.findViewById(t.g.card_banner_logo);
            }
        }
    }
}

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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.core.view.viewpager.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.a.d;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class an extends com.baidu.tieba.card.a<com.baidu.tieba.card.a.d> implements BdBaseViewPager.a {
    private View aHp;
    private String aNO;
    public View aNv;
    private int aPA;
    private ViewPager aPu;
    private a aPv;
    private View aPw;
    private TextView aPx;
    private TextView aPy;
    private com.baidu.tieba.card.a.d aPz;
    private com.baidu.tbadk.core.view.viewpager.d ahi;
    private IndicatorView ahm;

    public void gL(String str) {
        this.aNO = str;
    }

    public an(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aPA = 0;
        this.aNO = null;
        j(getView());
    }

    private void j(View view) {
        this.aPu = (ViewPager) view.findViewById(n.g.card_banner_viewpager);
        this.ahm = (IndicatorView) view.findViewById(n.g.card_banner_indicator);
        this.aPx = (TextView) view.findViewById(n.g.card_banner_title);
        this.aPy = (TextView) view.findViewById(n.g.card_banner_tag);
        this.aPw = view.findViewById(n.g.card_banner_bottom_layout);
        this.aNv = view.findViewById(n.g.divider_card);
        this.aHp = view.findViewById(n.g.divider_line);
        this.ahi = new com.baidu.tbadk.core.view.viewpager.d(getContext(), this.aPu, this.ahm, null);
        this.aPv = new a(Ie(), com.baidu.tbadk.core.view.viewpager.a.a.ahG);
        this.ahi.setMaxScrollCountLimit(5);
        this.ahi.setAutoScrollIntervalTime(4500L);
        this.ahi.a(getContext(), this.aPv);
        this.ahi.setOnPageChangeListener(new ao(this));
        this.aPx.setOnClickListener(this);
        this.aPy.setOnClickListener(this);
        this.aPv.a(new ap(this));
    }

    public void setAutoScrollIntervalTime(long j) {
        this.ahi.setAutoScrollIntervalTime(j);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void wa() {
        this.ahi.wa();
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void wb() {
        this.ahi.wb();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u uVar;
        if ((view == this.aPx || view == this.aPy) && this.aPu != null && this.aPz != null && this.aPz.DS() != null && (uVar = (com.baidu.adp.widget.ListView.u) com.baidu.tbadk.core.util.y.b(this.aPz.DS(), this.aPA)) != null && (uVar instanceof d.a)) {
            a((d.a) uVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar != null) {
            if (aVar.type == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(getContext(), "")));
                return;
            }
            if (!TextUtils.isEmpty(aVar.link)) {
                bf.vn().b(Ie(), new String[]{aVar.link});
            }
            if (!TextUtils.isEmpty(this.aNO)) {
                TiebaStatic.log(new av(this.aNO).r("obj_locate", this.aPA).aa("obj_source", aVar.url));
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.ahm.setSelector(as.getDrawable(n.f.dot_live_s));
            this.ahm.setDrawable(as.getDrawable(n.f.dot_live_n));
            as.j(this.aNv, n.d.cp_bg_line_c);
            as.j(this.aHp, n.d.cp_bg_line_c);
            com.baidu.tbadk.i.a.a(Ie(), this.aPw);
            this.mSkinType = i;
        }
        this.ahi.cK(i);
    }

    @Override // com.baidu.tieba.card.a
    public int Ig() {
        return n.h.card_banner_flow;
    }

    public void a(com.baidu.tieba.card.a.d dVar) {
        if (dVar == null || dVar.DS() == null || dVar.DS().isEmpty()) {
            getView().setVisibility(8);
            return;
        }
        this.aPz = dVar;
        this.aPv.an(this.aPz.Ix());
        getView().setVisibility(0);
        this.aPu.removeAllViews();
        List<com.baidu.adp.widget.ListView.u> DS = dVar.DS();
        if (DS.size() > 5) {
            DS = DS.subList(0, 5);
        }
        this.ahi.setDatas(DS);
        onChangeSkinType(Ie(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i) {
        if (this.aPz != null && this.aPz.DS() != null && !this.aPz.DS().isEmpty()) {
            List<com.baidu.adp.widget.ListView.u> DS = this.aPz.DS();
            com.baidu.adp.widget.ListView.u uVar = (com.baidu.adp.widget.ListView.u) com.baidu.tbadk.core.util.y.b(DS, i);
            if (uVar != null && (uVar instanceof d.a)) {
                this.ahi.setMaxScrollCountLimit(DS.size());
                d.a aVar = (d.a) uVar;
                this.aPx.setText(aVar.title);
                if (aVar.type == 2) {
                    this.aPy.setVisibility(8);
                } else if (!TextUtils.isEmpty(aVar.tag)) {
                    this.aPy.setVisibility(0);
                    this.aPy.setText(ax.d(aVar.tag, 4, null));
                } else {
                    this.aPy.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.tbadk.core.view.viewpager.g<d.a, C0058a> {
        private long aPC;
        private TbPageContext<?> mTbPageContext;

        public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
            super(tbPageContext.getPageActivity(), bdUniqueId);
            this.mTbPageContext = tbPageContext;
        }

        public void an(long j) {
            this.aPC = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0024: IGET  (r2v1 long A[REMOVE]) = (r4v0 'this' com.baidu.tieba.card.an$a A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.an.a.aPC long)] */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.tbadk.core.view.viewpager.g
        public View a(ViewGroup viewGroup, C0058a c0058a, d.a aVar) {
            c0058a.aPD.d(aVar.getImageUrl(), 10, false);
            if (aVar.type == 2) {
                as.i((View) c0058a.aPG, n.f.pic_shuiyin_ba);
                c0058a.aPE.setVisibility(0);
                c0058a.aPF.setText(new StringBuilder().append(this.aPC).toString());
            } else {
                c0058a.aPE.setVisibility(8);
            }
            return c0058a.getView();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.tbadk.core.view.viewpager.g
        public void a(int i, C0058a c0058a, d.a aVar) {
            as.i((View) c0058a.aPG, n.f.pic_shuiyin_ba);
            as.i((View) c0058a.aPF, n.f.btn_batuijian_input);
            com.baidu.tbadk.i.a.a(this.mTbPageContext, c0058a.aPE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.view.viewpager.g
        /* renamed from: d */
        public C0058a c(ViewGroup viewGroup) {
            return new C0058a(LayoutInflater.from(this.mContext).inflate(n.h.card_banner_flowview_item, (ViewGroup) null, false));
        }

        /* renamed from: com.baidu.tieba.card.an$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0058a extends a.C0043a {
            public TbImageView aPD;
            public View aPE;
            public TextView aPF;
            public TextView aPG;

            public C0058a(View view) {
                super(view);
                this.aPD = (TbImageView) view.findViewById(n.g.card_banner_iv);
                this.aPE = view.findViewById(n.g.card_banner_bar_num_layout);
                this.aPF = (TextView) view.findViewById(n.g.card_banner_bar_num);
                this.aPG = (TextView) view.findViewById(n.g.card_banner_logo);
            }
        }
    }
}

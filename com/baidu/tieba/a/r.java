package com.baidu.tieba.a;

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
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarFolderFirstDirActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.core.view.viewpager.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.a.a.c;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.a.a<com.baidu.tieba.a.a.c> implements BdBaseViewPager.a {
    private View aFP;
    public View aLW;
    private com.baidu.tieba.a.a.c aMA;
    private int aMB;
    private String aMn;
    private a aMw;
    private View aMx;
    private TextView aMy;
    private TextView aMz;
    private ViewPager agA;
    private com.baidu.tbadk.core.view.viewpager.d agb;
    private IndicatorView agf;

    public void gC(String str) {
        this.aMn = str;
    }

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aMB = 0;
        this.aMn = null;
        j(getView());
    }

    private void j(View view) {
        this.agA = (ViewPager) view.findViewById(n.f.card_banner_viewpager);
        this.agf = (IndicatorView) view.findViewById(n.f.card_banner_indicator);
        this.aMy = (TextView) view.findViewById(n.f.card_banner_title);
        this.aMz = (TextView) view.findViewById(n.f.card_banner_tag);
        this.aMx = view.findViewById(n.f.card_banner_bottom_layout);
        this.aLW = view.findViewById(n.f.divider_card);
        this.aFP = view.findViewById(n.f.divider_line);
        this.agb = new com.baidu.tbadk.core.view.viewpager.d(getContext(), this.agA, this.agf, null);
        this.aMw = new a(Io(), com.baidu.tbadk.core.view.viewpager.a.a.agz);
        this.agb.setMaxScrollCountLimit(5);
        this.agb.setAutoScrollIntervalTime(4500L);
        this.agb.a(getContext(), this.aMw);
        this.agb.setOnPageChangeListener(new s(this));
        this.aMy.setOnClickListener(this);
        this.aMz.setOnClickListener(this);
        this.aMw.setOnItemClickListener(new t(this));
    }

    public void setAutoScrollIntervalTime(long j) {
        this.agb.setAutoScrollIntervalTime(j);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void wp() {
        this.agb.wp();
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void wq() {
        this.agb.wq();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u uVar;
        if ((view == this.aMy || view == this.aMz) && this.agA != null && this.aMA != null && this.aMA.Ed() != null && (uVar = (u) y.b(this.aMA.Ed(), this.aMB)) != null && (uVar instanceof c.a)) {
            a((c.a) uVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar) {
        if (aVar != null) {
            if (aVar.type == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(getContext(), "")));
                return;
            }
            if (!TextUtils.isEmpty(aVar.link)) {
                bf.vD().b(Io(), new String[]{aVar.link});
            }
            if (!TextUtils.isEmpty(this.aMn)) {
                TiebaStatic.log(new av(this.aMn).r("obj_locate", this.aMB).ab("obj_source", aVar.url));
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.agf.setSelector(as.getDrawable(n.e.dot_live_s));
            this.agf.setDrawable(as.getDrawable(n.e.dot_live_n));
            as.j(this.aLW, n.c.cp_bg_line_c);
            as.j(this.aFP, n.c.cp_bg_line_c);
            com.baidu.tbadk.i.a.a(Io(), this.aMx);
            this.mSkinType = i;
        }
        this.agb.cZ(i);
    }

    @Override // com.baidu.tieba.a.a
    public int Ip() {
        return n.g.card_banner_flow;
    }

    public void a(com.baidu.tieba.a.a.c cVar) {
        if (cVar == null || cVar.Ed() == null || cVar.Ed().isEmpty()) {
            getView().setVisibility(8);
            return;
        }
        this.aMA = cVar;
        this.aMw.am(this.aMA.Iu());
        getView().setVisibility(0);
        this.agA.removeAllViews();
        List<u> Ed = cVar.Ed();
        if (Ed.size() > 5) {
            Ed = Ed.subList(0, 5);
        }
        this.agb.setDatas(Ed);
        onChangeSkinType(Io(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i) {
        if (this.aMA != null && this.aMA.Ed() != null && !this.aMA.Ed().isEmpty()) {
            List<u> Ed = this.aMA.Ed();
            u uVar = (u) y.b(Ed, i);
            if (uVar != null && (uVar instanceof c.a)) {
                this.agb.setMaxScrollCountLimit(Ed.size());
                c.a aVar = (c.a) uVar;
                this.aMy.setText(aVar.title);
                if (aVar.type == 2) {
                    this.aMz.setVisibility(8);
                } else if (!TextUtils.isEmpty(aVar.tag)) {
                    this.aMz.setVisibility(0);
                    this.aMz.setText(ax.d(aVar.tag, 4, null));
                } else {
                    this.aMz.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.tbadk.core.view.viewpager.g<c.a, C0057a> {
        private long aMD;
        private TbPageContext<?> mTbPageContext;

        public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
            super(tbPageContext.getPageActivity(), bdUniqueId);
            this.mTbPageContext = tbPageContext;
        }

        public void am(long j) {
            this.aMD = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0024: IGET  (r2v1 long A[REMOVE]) = (r4v0 'this' com.baidu.tieba.a.r$a A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.a.r.a.aMD long)] */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.tbadk.core.view.viewpager.g
        public View a(ViewGroup viewGroup, C0057a c0057a, c.a aVar) {
            c0057a.agC.d(aVar.getImageUrl(), 10, false);
            if (aVar.type == 2) {
                as.i((View) c0057a.aMG, n.e.pic_shuiyin_ba);
                c0057a.aME.setVisibility(0);
                c0057a.aMF.setText(new StringBuilder().append(this.aMD).toString());
            } else {
                c0057a.aME.setVisibility(8);
            }
            return c0057a.getView();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.tbadk.core.view.viewpager.g
        public void a(int i, C0057a c0057a, c.a aVar) {
            as.i((View) c0057a.aMG, n.e.pic_shuiyin_ba);
            as.i((View) c0057a.aMF, n.e.btn_batuijian_input);
            com.baidu.tbadk.i.a.a(this.mTbPageContext, c0057a.aME);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.view.viewpager.g
        /* renamed from: e */
        public C0057a c(ViewGroup viewGroup) {
            return new C0057a(LayoutInflater.from(this.mContext).inflate(n.g.card_banner_flowview_item, (ViewGroup) null, false));
        }

        /* renamed from: com.baidu.tieba.a.r$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0057a extends a.C0043a {
            public View aME;
            public TextView aMF;
            public TextView aMG;
            public TbImageView agC;

            public C0057a(View view) {
                super(view);
                this.agC = (TbImageView) view.findViewById(n.f.card_banner_iv);
                this.aME = view.findViewById(n.f.card_banner_bar_num_layout);
                this.aMF = (TextView) view.findViewById(n.f.card_banner_bar_num);
                this.aMG = (TextView) view.findViewById(n.f.card_banner_logo);
            }
        }
    }
}

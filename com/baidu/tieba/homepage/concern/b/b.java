package com.baidu.tieba.homepage.concern.b;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.a.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes22.dex */
public class b extends BdBaseViewPagerAdapter.a implements View.OnClickListener {
    private byte jwO;
    public FollowUserButton[] jxA;
    private final int[] jxB;
    private final int[] jxC;
    private e jxn;
    private LikeModel jxo;
    private ad jxp;
    private a jxq;
    private com.baidu.tbadk.core.view.commonBtn.b jxr;
    private com.baidu.tbadk.core.view.commonBtn.b jxs;
    public TextView jxt;
    public BarImageView[] jxu;
    public TextView[] jxv;
    public TextView[] jxw;
    public TextView[] jxx;
    public TextView[] jxy;
    public TextView[] jxz;
    private boolean loading;
    private TbPageContext<?> pageContext;

    public b(View view, TbPageContext<?> tbPageContext, byte b) {
        super(view);
        this.loading = false;
        this.jxr = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jxs = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jxu = new BarImageView[3];
        this.jxv = new TextView[3];
        this.jxw = new TextView[3];
        this.jxx = new TextView[3];
        this.jxy = new TextView[3];
        this.jxz = new TextView[3];
        this.jxA = new FollowUserButton[3];
        this.jxB = new int[]{R.id.recommend_bar_info_1, R.id.recommend_bar_info_2, R.id.recommend_bar_info_3};
        this.jxC = new int[]{R.color.cp_cont_h, R.color.cp_link_tip_d, R.color.cp_other_f};
        this.pageContext = tbPageContext;
        this.jwO = b;
        al(view);
    }

    private void al(View view) {
        this.jxt = (TextView) view.findViewById(R.id.recommend_bar_item_title);
        this.jxr.qk(R.color.cp_cont_d);
        this.jxr.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jxs.qi(R.color.cp_link_tip_a);
        this.jxs.qd(UtilHelper.getDimenPixelSize(R.dimen.tbds23));
        this.jxs.a(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jxs.qh(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
        for (int i = 0; i < 3; i++) {
            View findViewById = view.findViewById(this.jxB[i]);
            findViewById.setTag(Integer.valueOf(i));
            findViewById.setOnClickListener(this);
            this.jxu[i] = (BarImageView) findViewById.findViewById(R.id.recommend_bar_icon);
            this.jxv[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_title_index);
            this.jxw[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_name);
            this.jxx[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_desc);
            this.jxy[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_concern_info);
            this.jxz[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_thread_info);
            this.jxA[i] = (FollowUserButton) findViewById.findViewById(R.id.recommend_bar_concern_btn);
            this.jxA[i].setOnClickListener(this);
            this.jxv[i].setText(String.valueOf(i + 1));
            this.jxu[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jxu[i].setShowInnerBorder(true);
            this.jxu[i].setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.jxu[i].setShowOval(true);
            this.jxu[i].setPlaceHolder(2);
            this.jxu[i].setShowOuterBorder(false);
            this.jxu[i].setStrokeColorResId(R.color.cp_border_a);
        }
        onSkinTypeChanged(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void onSkinTypeChanged(int i) {
        if (this.ajq != i) {
            this.ajq = i;
            ap.setViewTextColor(this.jxt, R.color.cp_cont_c);
            for (int i2 = 0; i2 < 3; i2++) {
                if (this.jxv[i2].getVisibility() == 0) {
                    ap.setViewTextColor(this.jxv[i2], R.color.cp_cont_a);
                    com.baidu.tbadk.core.util.e.a.brO().pk(this.jxC[i2]).pp(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8)).bk(this.jxv[i2]);
                }
                this.jxA[i2].onChangeSkinType(i);
                ap.setViewTextColor(this.jxw[i2], R.color.cp_cont_b);
                ap.setViewTextColor(this.jxx[i2], R.color.cp_cont_d);
                ap.setViewTextColor(this.jxy[i2], R.color.cp_cont_d);
                ap.setViewTextColor(this.jxz[i2], R.color.cp_cont_d);
            }
        }
    }

    public void qS(boolean z) {
        this.jxt.setVisibility(z ? 0 : 8);
    }

    public e cJf() {
        return this.jxn;
    }

    public void W(int i, boolean z) {
        if (this.jxn != null) {
            if (z) {
                a(this.jxA[i], true);
                this.jxn.jxc[i].qP(true);
                return;
            }
            a(this.jxA[i], false);
            this.jxn.jxc[i].qP(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void a(q qVar) {
        if (qVar instanceof e) {
            this.jxn = (e) qVar;
            this.jxt.setText(this.jxn.jxa);
            for (int i = 0; i < 3; i++) {
                this.jxu[i].startLoad(this.jxn.jxc[i].cIZ(), 10, false);
                this.jxw[i].setText(this.jxn.jxc[i].cJa());
                this.jxz[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_thread, new Object[]{at.dy(this.jxn.jxc[i].cJd())}));
                this.jxy[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_concern, new Object[]{at.dy(this.jxn.jxc[i].cJc())}));
                this.jxA[i].setTag(Integer.valueOf(i));
                a(this.jxA[i], this.jxn.jxc[i].cJe());
                this.jxv[i].setVisibility(this.jxn.jxb ? 0 : 8);
                ((LinearLayout.LayoutParams) this.jxw[i].getLayoutParams()).leftMargin = l.getDimens(this.pageContext.getPageActivity(), this.jxn.jxb ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.jxn.jxc[i].getSlogan()) && d.bib()) {
                    this.jxx[i].setText(this.jxn.jxc[i].getSlogan());
                } else if (!StringUtils.isNull(this.jxn.jxc[i].cJb()) && d.bic()) {
                    this.jxx[i].setText(this.jxn.jxc[i].cJb());
                } else {
                    this.jxx[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_desc));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jxn != null && view != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            e.a aVar = this.jxn.jxc[intValue];
            if (view instanceof TBSpecificationBtn) {
                if (aVar.cJe()) {
                    b(aVar, this.jxA[intValue]);
                    return;
                }
                a(aVar, this.jxA[intValue]);
                aq al = new aq("c13644").w("fid", aVar.getForumId()).dR("uid", TbadkApplication.getCurrentAccount()).al("obj_locate", this.jwO);
                if (!StringUtils.isNull(this.jxn.jxa)) {
                    al = al.dR("obj_name", this.jxn.jxa);
                }
                TiebaStatic.log(al);
            } else if (id == R.id.recommend_bar_info_1 || id == R.id.recommend_bar_info_2 || id == R.id.recommend_bar_info_3) {
                FrsActivityConfig callFrom = new FrsActivityConfig(this.pageContext.getPageActivity()).createNormalCfg(aVar.cJa(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
                if (d.bic()) {
                    Intent intent = callFrom.getIntent();
                    if (aVar.crk() != 0 && intent != null) {
                        intent.putExtra("transition_type", 0);
                        intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.crk());
                    }
                }
                this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                aq al2 = new aq("c13988").w("fid", aVar.getForumId()).dR("uid", TbadkApplication.getCurrentAccount()).al("obj_locate", this.jwO);
                if (!StringUtils.isNull(this.jxn.jxa)) {
                    al2 = al2.dR("obj_name", this.jxn.jxa);
                }
                TiebaStatic.log(al2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FollowUserButton followUserButton, boolean z) {
        if (followUserButton != null) {
            followUserButton.setConfig(z ? this.jxr : this.jxs);
            followUserButton.setText(TbadkCoreApplication.getInst().getString(z ? R.string.followed : R.string.attention));
            followUserButton.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void a(e.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cJa()) && aVar.getForumId() > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.jxq == null) {
                    this.jxq = new a();
                }
                if (this.jxo == null) {
                    this.jxo = new LikeModel(this.pageContext);
                    this.jxo.setLoadDataCallBack(this.jxq);
                }
                this.jxq.a(followUserButton, aVar);
                if (at.isForumName(aVar.cJa())) {
                    this.loading = true;
                    this.jxo.dJs();
                    this.jxo.gp(aVar.cJa(), String.valueOf(aVar.getForumId()));
                }
            }
        }
    }

    private void b(e.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cJa()) && aVar.getForumId() > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.jxq == null) {
                    this.jxq = new a();
                }
                if (this.jxp == null) {
                    this.jxp = new ad();
                    this.jxp.a(this.jxq);
                }
                this.jxq.a(followUserButton, aVar);
                this.loading = true;
                this.jxp.O(aVar.cJa(), aVar.getForumId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a extends com.baidu.adp.base.d implements ad.a {
        private e.a jxD;
        private FollowUserButton jxE;

        private a() {
        }

        public void a(FollowUserButton followUserButton, e.a aVar) {
            this.jxD = aVar;
            this.jxE = followUserButton;
        }

        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            b.this.loading = false;
            if (b.this.jxo.getErrorCode() == 22) {
                l.showToast(b.this.pageContext.getPageActivity(), b.this.pageContext.getString(R.string.had_liked_forum));
            } else if (obj != null) {
                if (b.this.jxo.getErrorCode() != 0) {
                    l.showToast(b.this.pageContext.getPageActivity(), b.this.jxo.getErrorString());
                    return;
                }
                b.this.a(this.jxE, true);
                this.jxD.qP(true);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void C(String str, long j) {
            b.this.loading = false;
            b.this.a(this.jxE, false);
            this.jxD.qP(false);
        }

        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void D(String str, long j) {
            b.this.loading = false;
        }
    }
}

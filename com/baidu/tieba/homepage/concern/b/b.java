package com.baidu.tieba.homepage.concern.b;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.a.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes2.dex */
public class b extends BdBaseViewPagerAdapter.a implements View.OnClickListener {
    private byte kbH;
    private d kcg;
    private LikeModel kch;
    private ae kci;
    private a kcj;
    private com.baidu.tbadk.core.view.commonBtn.b kck;
    private com.baidu.tbadk.core.view.commonBtn.b kcl;
    public TextView kcm;
    public BarImageView[] kcn;
    public TextView[] kco;
    public TextView[] kcp;
    public TextView[] kcq;
    public TextView[] kcr;
    public TextView[] kcs;
    public FollowUserButton[] kct;
    private final int[] kcu;
    private final int[] kcv;
    private boolean loading;
    private TbPageContext<?> pageContext;

    public b(View view, TbPageContext<?> tbPageContext, byte b2) {
        super(view);
        this.loading = false;
        this.kck = new com.baidu.tbadk.core.view.commonBtn.b();
        this.kcl = new com.baidu.tbadk.core.view.commonBtn.b();
        this.kcn = new BarImageView[3];
        this.kco = new TextView[3];
        this.kcp = new TextView[3];
        this.kcq = new TextView[3];
        this.kcr = new TextView[3];
        this.kcs = new TextView[3];
        this.kct = new FollowUserButton[3];
        this.kcu = new int[]{R.id.recommend_bar_info_1, R.id.recommend_bar_info_2, R.id.recommend_bar_info_3};
        this.kcv = new int[]{R.color.CAM_X0301, R.color.CAM_X0305, R.color.CAM_X0312};
        this.pageContext = tbPageContext;
        this.kbH = b2;
        am(view);
    }

    private void am(View view) {
        this.kcm = (TextView) view.findViewById(R.id.recommend_bar_item_title);
        this.kck.pT(R.color.CAM_X0109);
        this.kck.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.kcl.pR(R.color.CAM_X0304);
        this.kcl.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.kcl.pQ(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
        for (int i = 0; i < 3; i++) {
            View findViewById = view.findViewById(this.kcu[i]);
            findViewById.setTag(Integer.valueOf(i));
            findViewById.setOnClickListener(this);
            this.kcn[i] = (BarImageView) findViewById.findViewById(R.id.recommend_bar_icon);
            this.kco[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_title_index);
            this.kcp[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_name);
            this.kcq[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_desc);
            this.kcr[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_concern_info);
            this.kcs[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_thread_info);
            this.kct[i] = (FollowUserButton) findViewById.findViewById(R.id.recommend_bar_concern_btn);
            this.kct[i].setOnClickListener(this);
            this.kco[i].setText(String.valueOf(i + 1));
            this.kcn[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.kcn[i].setShowInnerBorder(true);
            this.kcn[i].setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.kcn[i].setShowOval(true);
            this.kcn[i].setPlaceHolder(2);
            this.kcn[i].setShowOuterBorder(false);
            this.kcn[i].setStrokeColorResId(R.color.CAM_X0401);
        }
        onSkinTypeChanged(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void onSkinTypeChanged(int i) {
        if (this.ajU != i) {
            this.ajU = i;
            ap.setViewTextColor(this.kcm, R.color.CAM_X0108);
            for (int i2 = 0; i2 < 3; i2++) {
                if (this.kco[i2].getVisibility() == 0) {
                    ap.setViewTextColor(this.kco[i2], R.color.CAM_X0101);
                    com.baidu.tbadk.core.util.f.a.btv().oP(this.kcv[i2]).oV(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8)).bv(this.kco[i2]);
                }
                this.kct[i2].onChangeSkinType(i);
                ap.setViewTextColor(this.kcp[i2], R.color.CAM_X0105);
                ap.setViewTextColor(this.kcq[i2], R.color.CAM_X0109);
                ap.setViewTextColor(this.kcr[i2], R.color.CAM_X0109);
                ap.setViewTextColor(this.kcs[i2], R.color.CAM_X0109);
            }
        }
    }

    public void sb(boolean z) {
        this.kcm.setVisibility(z ? 0 : 8);
    }

    public d cPs() {
        return this.kcg;
    }

    public void W(int i, boolean z) {
        if (this.kcg != null) {
            if (z) {
                a(this.kct[i], true);
                this.kcg.kbV[i].rY(true);
                return;
            }
            a(this.kct[i], false);
            this.kcg.kbV[i].rY(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void a(n nVar) {
        if (nVar instanceof d) {
            this.kcg = (d) nVar;
            this.kcm.setText(this.kcg.kbT);
            for (int i = 0; i < 3; i++) {
                this.kcn[i].startLoad(this.kcg.kbV[i].cPm(), 10, false);
                this.kcp[i].setText(this.kcg.kbV[i].cPn());
                this.kcs[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_thread, new Object[]{au.ed(this.kcg.kbV[i].cPq())}));
                this.kcr[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_concern, new Object[]{au.ed(this.kcg.kbV[i].cPp())}));
                this.kct[i].setTag(Integer.valueOf(i));
                a(this.kct[i], this.kcg.kbV[i].cPr());
                this.kco[i].setVisibility(this.kcg.kbU ? 0 : 8);
                ((LinearLayout.LayoutParams) this.kcp[i].getLayoutParams()).leftMargin = l.getDimens(this.pageContext.getPageActivity(), this.kcg.kbU ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.kcg.kbV[i].getSlogan()) && com.baidu.tbadk.a.d.bje()) {
                    this.kcq[i].setText(this.kcg.kbV[i].getSlogan());
                } else if (!StringUtils.isNull(this.kcg.kbV[i].cPo()) && com.baidu.tbadk.a.d.bjf()) {
                    this.kcq[i].setText(this.kcg.kbV[i].cPo());
                } else {
                    this.kcq[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_desc));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kcg != null && view != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            d.a aVar = this.kcg.kbV[intValue];
            if (view instanceof TBSpecificationBtn) {
                if (aVar.cPr()) {
                    b(aVar, this.kct[intValue]);
                    return;
                }
                a(aVar, this.kct[intValue]);
                ar ap = new ar("c13644").v("fid", aVar.getForumId()).dR("uid", TbadkApplication.getCurrentAccount()).ap("obj_locate", this.kbH);
                if (!StringUtils.isNull(this.kcg.kbT)) {
                    ap = ap.dR("obj_name", this.kcg.kbT);
                }
                TiebaStatic.log(ap);
            } else if (id == R.id.recommend_bar_info_1 || id == R.id.recommend_bar_info_2 || id == R.id.recommend_bar_info_3) {
                FrsActivityConfig callFrom = new FrsActivityConfig(this.pageContext.getPageActivity()).createNormalCfg(aVar.cPn(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
                if (com.baidu.tbadk.a.d.bjf()) {
                    Intent intent = callFrom.getIntent();
                    if (aVar.cvx() != 0 && intent != null) {
                        intent.putExtra("transition_type", 0);
                        intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.cvx());
                    }
                }
                this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                ar ap2 = new ar("c13988").v("fid", aVar.getForumId()).dR("uid", TbadkApplication.getCurrentAccount()).ap("obj_locate", this.kbH);
                if (!StringUtils.isNull(this.kcg.kbT)) {
                    ap2 = ap2.dR("obj_name", this.kcg.kbT);
                }
                TiebaStatic.log(ap2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FollowUserButton followUserButton, boolean z) {
        if (followUserButton != null) {
            followUserButton.setConfig(z ? this.kck : this.kcl);
            followUserButton.setText(TbadkCoreApplication.getInst().getString(z ? R.string.followed : R.string.attention));
            followUserButton.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void a(d.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cPn()) && aVar.getForumId() > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.kcj == null) {
                    this.kcj = new a();
                }
                if (this.kch == null) {
                    this.kch = new LikeModel(this.pageContext);
                    this.kch.setLoadDataCallBack(this.kcj);
                }
                this.kcj.a(followUserButton, aVar);
                if (au.isForumName(aVar.cPn())) {
                    this.loading = true;
                    this.kch.dMV();
                    this.kch.gy(aVar.cPn(), String.valueOf(aVar.getForumId()));
                }
            }
        }
    }

    private void b(d.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cPn()) && aVar.getForumId() > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.kcj == null) {
                    this.kcj = new a();
                }
                if (this.kci == null) {
                    this.kci = new ae();
                    this.kci.a(this.kcj);
                }
                this.kcj.a(followUserButton, aVar);
                this.loading = true;
                this.kci.O(aVar.cPn(), aVar.getForumId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends e implements ae.a {
        private d.a kcw;
        private FollowUserButton kcx;

        private a() {
        }

        public void a(FollowUserButton followUserButton, d.a aVar) {
            this.kcw = aVar;
            this.kcx = followUserButton;
        }

        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            b.this.loading = false;
            if (b.this.kch.getErrorCode() == 22) {
                l.showToast(b.this.pageContext.getPageActivity(), b.this.pageContext.getString(R.string.had_liked_forum));
            } else if (obj != null) {
                if (b.this.kch.getErrorCode() != 0) {
                    l.showToast(b.this.pageContext.getPageActivity(), b.this.kch.getErrorString());
                    return;
                }
                b.this.a(this.kcx, true);
                this.kcw.rY(true);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void B(String str, long j) {
            b.this.loading = false;
            b.this.a(this.kcx, false);
            this.kcw.rY(false);
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            b.this.loading = false;
        }
    }
}

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
    private byte jqR;
    public TextView[] jrA;
    public TextView[] jrB;
    public TextView[] jrC;
    public FollowUserButton[] jrD;
    private final int[] jrE;
    private final int[] jrF;
    private e jrq;
    private LikeModel jrr;
    private ad jrs;
    private a jrt;
    private com.baidu.tbadk.core.view.commonBtn.b jru;
    private com.baidu.tbadk.core.view.commonBtn.b jrv;
    public TextView jrw;
    public BarImageView[] jrx;
    public TextView[] jry;
    public TextView[] jrz;
    private boolean loading;
    private TbPageContext<?> pageContext;

    public b(View view, TbPageContext<?> tbPageContext, byte b) {
        super(view);
        this.loading = false;
        this.jru = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jrv = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jrx = new BarImageView[3];
        this.jry = new TextView[3];
        this.jrz = new TextView[3];
        this.jrA = new TextView[3];
        this.jrB = new TextView[3];
        this.jrC = new TextView[3];
        this.jrD = new FollowUserButton[3];
        this.jrE = new int[]{R.id.recommend_bar_info_1, R.id.recommend_bar_info_2, R.id.recommend_bar_info_3};
        this.jrF = new int[]{R.color.cp_cont_h, R.color.cp_link_tip_d, R.color.cp_other_f};
        this.pageContext = tbPageContext;
        this.jqR = b;
        ah(view);
    }

    private void ah(View view) {
        this.jrw = (TextView) view.findViewById(R.id.recommend_bar_item_title);
        this.jru.qa(R.color.cp_cont_d);
        this.jru.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jrv.pY(R.color.cp_link_tip_a);
        this.jrv.pT(UtilHelper.getDimenPixelSize(R.dimen.tbds23));
        this.jrv.a(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jrv.pX(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
        for (int i = 0; i < 3; i++) {
            View findViewById = view.findViewById(this.jrE[i]);
            findViewById.setTag(Integer.valueOf(i));
            findViewById.setOnClickListener(this);
            this.jrx[i] = (BarImageView) findViewById.findViewById(R.id.recommend_bar_icon);
            this.jry[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_title_index);
            this.jrz[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_name);
            this.jrA[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_desc);
            this.jrB[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_concern_info);
            this.jrC[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_thread_info);
            this.jrD[i] = (FollowUserButton) findViewById.findViewById(R.id.recommend_bar_concern_btn);
            this.jrD[i].setOnClickListener(this);
            this.jry[i].setText(String.valueOf(i + 1));
            this.jrx[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jrx[i].setShowInnerBorder(true);
            this.jrx[i].setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.jrx[i].setShowOval(true);
            this.jrx[i].setPlaceHolder(2);
            this.jrx[i].setShowOuterBorder(false);
            this.jrx[i].setStrokeColorResId(R.color.cp_border_a);
        }
        onSkinTypeChanged(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void onSkinTypeChanged(int i) {
        if (this.ajq != i) {
            this.ajq = i;
            ap.setViewTextColor(this.jrw, R.color.cp_cont_c);
            for (int i2 = 0; i2 < 3; i2++) {
                if (this.jry[i2].getVisibility() == 0) {
                    ap.setViewTextColor(this.jry[i2], R.color.cp_cont_a);
                    com.baidu.tbadk.core.util.e.a.bpo().pa(this.jrF[i2]).pe(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8)).bg(this.jry[i2]);
                }
                this.jrD[i2].onChangeSkinType(i);
                ap.setViewTextColor(this.jrz[i2], R.color.cp_cont_b);
                ap.setViewTextColor(this.jrA[i2], R.color.cp_cont_d);
                ap.setViewTextColor(this.jrB[i2], R.color.cp_cont_d);
                ap.setViewTextColor(this.jrC[i2], R.color.cp_cont_d);
            }
        }
    }

    public void qJ(boolean z) {
        this.jrw.setVisibility(z ? 0 : 8);
    }

    public e cGE() {
        return this.jrq;
    }

    public void W(int i, boolean z) {
        if (this.jrq != null) {
            if (z) {
                a(this.jrD[i], true);
                this.jrq.jrf[i].qG(true);
                return;
            }
            a(this.jrD[i], false);
            this.jrq.jrf[i].qG(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void a(q qVar) {
        if (qVar instanceof e) {
            this.jrq = (e) qVar;
            this.jrw.setText(this.jrq.jrd);
            for (int i = 0; i < 3; i++) {
                this.jrx[i].startLoad(this.jrq.jrf[i].cGy(), 10, false);
                this.jrz[i].setText(this.jrq.jrf[i].cGz());
                this.jrC[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_thread, new Object[]{at.dc(this.jrq.jrf[i].cGC())}));
                this.jrB[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_concern, new Object[]{at.dc(this.jrq.jrf[i].cGB())}));
                this.jrD[i].setTag(Integer.valueOf(i));
                a(this.jrD[i], this.jrq.jrf[i].cGD());
                this.jry[i].setVisibility(this.jrq.jre ? 0 : 8);
                ((LinearLayout.LayoutParams) this.jrz[i].getLayoutParams()).leftMargin = l.getDimens(this.pageContext.getPageActivity(), this.jrq.jre ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.jrq.jrf[i].getSlogan()) && d.bfB()) {
                    this.jrA[i].setText(this.jrq.jrf[i].getSlogan());
                } else if (!StringUtils.isNull(this.jrq.jrf[i].cGA()) && d.bfC()) {
                    this.jrA[i].setText(this.jrq.jrf[i].cGA());
                } else {
                    this.jrA[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_desc));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jrq != null && view != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            e.a aVar = this.jrq.jrf[intValue];
            if (view instanceof TBSpecificationBtn) {
                if (aVar.cGD()) {
                    b(aVar, this.jrD[intValue]);
                    return;
                }
                a(aVar, this.jrD[intValue]);
                aq aj = new aq("c13644").w("fid", aVar.getForumId()).dR("uid", TbadkApplication.getCurrentAccount()).aj("obj_locate", this.jqR);
                if (!StringUtils.isNull(this.jrq.jrd)) {
                    aj = aj.dR("obj_name", this.jrq.jrd);
                }
                TiebaStatic.log(aj);
            } else if (id == R.id.recommend_bar_info_1 || id == R.id.recommend_bar_info_2 || id == R.id.recommend_bar_info_3) {
                FrsActivityConfig callFrom = new FrsActivityConfig(this.pageContext.getPageActivity()).createNormalCfg(aVar.cGz(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
                if (d.bfC()) {
                    Intent intent = callFrom.getIntent();
                    if (aVar.coJ() != 0 && intent != null) {
                        intent.putExtra("transition_type", 0);
                        intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.coJ());
                    }
                }
                this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                aq aj2 = new aq("c13988").w("fid", aVar.getForumId()).dR("uid", TbadkApplication.getCurrentAccount()).aj("obj_locate", this.jqR);
                if (!StringUtils.isNull(this.jrq.jrd)) {
                    aj2 = aj2.dR("obj_name", this.jrq.jrd);
                }
                TiebaStatic.log(aj2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FollowUserButton followUserButton, boolean z) {
        if (followUserButton != null) {
            followUserButton.setConfig(z ? this.jru : this.jrv);
            followUserButton.setText(TbadkCoreApplication.getInst().getString(z ? R.string.followed : R.string.attention));
            followUserButton.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void a(e.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cGz()) && aVar.getForumId() > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.jrt == null) {
                    this.jrt = new a();
                }
                if (this.jrr == null) {
                    this.jrr = new LikeModel(this.pageContext);
                    this.jrr.setLoadDataCallBack(this.jrt);
                }
                this.jrt.a(followUserButton, aVar);
                if (at.isForumName(aVar.cGz())) {
                    this.loading = true;
                    this.jrr.dGQ();
                    this.jrr.gp(aVar.cGz(), String.valueOf(aVar.getForumId()));
                }
            }
        }
    }

    private void b(e.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cGz()) && aVar.getForumId() > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.jrt == null) {
                    this.jrt = new a();
                }
                if (this.jrs == null) {
                    this.jrs = new ad();
                    this.jrs.a(this.jrt);
                }
                this.jrt.a(followUserButton, aVar);
                this.loading = true;
                this.jrs.O(aVar.cGz(), aVar.getForumId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a extends com.baidu.adp.base.d implements ad.a {
        private e.a jrG;
        private FollowUserButton jrH;

        private a() {
        }

        public void a(FollowUserButton followUserButton, e.a aVar) {
            this.jrG = aVar;
            this.jrH = followUserButton;
        }

        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            b.this.loading = false;
            if (b.this.jrr.getErrorCode() == 22) {
                l.showToast(b.this.pageContext.getPageActivity(), b.this.pageContext.getString(R.string.had_liked_forum));
            } else if (obj != null) {
                if (b.this.jrr.getErrorCode() != 0) {
                    l.showToast(b.this.pageContext.getPageActivity(), b.this.jrr.getErrorString());
                    return;
                }
                b.this.a(this.jrH, true);
                this.jrG.qG(true);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void C(String str, long j) {
            b.this.loading = false;
            b.this.a(this.jrH, false);
            this.jrG.qG(false);
        }

        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void D(String str, long j) {
            b.this.loading = false;
        }
    }
}

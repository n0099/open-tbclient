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
    private e jeS;
    private LikeModel jeT;
    private ad jeU;
    private a jeV;
    private com.baidu.tbadk.core.view.commonBtn.b jeW;
    private com.baidu.tbadk.core.view.commonBtn.b jeX;
    public TextView jeY;
    public BarImageView[] jeZ;
    private byte jet;
    public TextView[] jfa;
    public TextView[] jfb;
    public TextView[] jfc;
    public TextView[] jfd;
    public TextView[] jfe;
    public FollowUserButton[] jff;
    private final int[] jfg;
    private final int[] jfh;
    private boolean loading;
    private TbPageContext<?> pageContext;

    public b(View view, TbPageContext<?> tbPageContext, byte b) {
        super(view);
        this.loading = false;
        this.jeW = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jeX = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jeZ = new BarImageView[3];
        this.jfa = new TextView[3];
        this.jfb = new TextView[3];
        this.jfc = new TextView[3];
        this.jfd = new TextView[3];
        this.jfe = new TextView[3];
        this.jff = new FollowUserButton[3];
        this.jfg = new int[]{R.id.recommend_bar_info_1, R.id.recommend_bar_info_2, R.id.recommend_bar_info_3};
        this.jfh = new int[]{R.color.cp_cont_h, R.color.cp_link_tip_d, R.color.cp_other_f};
        this.pageContext = tbPageContext;
        this.jet = b;
        an(view);
    }

    private void an(View view) {
        this.jeY = (TextView) view.findViewById(R.id.recommend_bar_item_title);
        this.jeW.pP(R.color.cp_cont_d);
        this.jeW.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jeX.pN(R.color.cp_link_tip_a);
        this.jeX.pI(UtilHelper.getDimenPixelSize(R.dimen.tbds23));
        this.jeX.a(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jeX.pM(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
        for (int i = 0; i < 3; i++) {
            View findViewById = view.findViewById(this.jfg[i]);
            findViewById.setTag(Integer.valueOf(i));
            findViewById.setOnClickListener(this);
            this.jeZ[i] = (BarImageView) findViewById.findViewById(R.id.recommend_bar_icon);
            this.jfa[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_title_index);
            this.jfb[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_name);
            this.jfc[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_desc);
            this.jfd[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_concern_info);
            this.jfe[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_thread_info);
            this.jff[i] = (FollowUserButton) findViewById.findViewById(R.id.recommend_bar_concern_btn);
            this.jff[i].setOnClickListener(this);
            this.jfa[i].setText(String.valueOf(i + 1));
            this.jeZ[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jeZ[i].setShowInnerBorder(true);
            this.jeZ[i].setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.jeZ[i].setShowOval(true);
            this.jeZ[i].setPlaceHolder(2);
            this.jeZ[i].setShowOuterBorder(false);
            this.jeZ[i].setStrokeColorResId(R.color.cp_border_a);
        }
        onSkinTypeChanged(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void onSkinTypeChanged(int i) {
        if (this.ajp != i) {
            this.ajp = i;
            ap.setViewTextColor(this.jeY, R.color.cp_cont_c);
            for (int i2 = 0; i2 < 3; i2++) {
                if (this.jfa[i2].getVisibility() == 0) {
                    ap.setViewTextColor(this.jfa[i2], R.color.cp_cont_a);
                    com.baidu.tbadk.core.util.e.a.bnv().oP(this.jfh[i2]).oT(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8)).bf(this.jfa[i2]);
                }
                this.jff[i2].onChangeSkinType(i);
                ap.setViewTextColor(this.jfb[i2], R.color.cp_cont_b);
                ap.setViewTextColor(this.jfc[i2], R.color.cp_cont_d);
                ap.setViewTextColor(this.jfd[i2], R.color.cp_cont_d);
                ap.setViewTextColor(this.jfe[i2], R.color.cp_cont_d);
            }
        }
    }

    public void qr(boolean z) {
        this.jeY.setVisibility(z ? 0 : 8);
    }

    public e cDx() {
        return this.jeS;
    }

    public void W(int i, boolean z) {
        if (this.jeS != null) {
            if (z) {
                a(this.jff[i], true);
                this.jeS.jeH[i].qo(true);
                return;
            }
            a(this.jff[i], false);
            this.jeS.jeH[i].qo(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void a(q qVar) {
        if (qVar instanceof e) {
            this.jeS = (e) qVar;
            this.jeY.setText(this.jeS.jeF);
            for (int i = 0; i < 3; i++) {
                this.jeZ[i].startLoad(this.jeS.jeH[i].cDr(), 10, false);
                this.jfb[i].setText(this.jeS.jeH[i].cDs());
                this.jfe[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_thread, new Object[]{at.da(this.jeS.jeH[i].cDv())}));
                this.jfd[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_concern, new Object[]{at.da(this.jeS.jeH[i].cDu())}));
                this.jff[i].setTag(Integer.valueOf(i));
                a(this.jff[i], this.jeS.jeH[i].cDw());
                this.jfa[i].setVisibility(this.jeS.jeG ? 0 : 8);
                ((LinearLayout.LayoutParams) this.jfb[i].getLayoutParams()).leftMargin = l.getDimens(this.pageContext.getPageActivity(), this.jeS.jeG ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.jeS.jeH[i].getSlogan()) && d.bdI()) {
                    this.jfc[i].setText(this.jeS.jeH[i].getSlogan());
                } else if (!StringUtils.isNull(this.jeS.jeH[i].cDt()) && d.bdJ()) {
                    this.jfc[i].setText(this.jeS.jeH[i].cDt());
                } else {
                    this.jfc[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_desc));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jeS != null && view != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            e.a aVar = this.jeS.jeH[intValue];
            if (view instanceof TBSpecificationBtn) {
                if (aVar.cDw()) {
                    b(aVar, this.jff[intValue]);
                    return;
                }
                a(aVar, this.jff[intValue]);
                aq aj = new aq("c13644").u("fid", aVar.getForumId()).dK("uid", TbadkApplication.getCurrentAccount()).aj("obj_locate", this.jet);
                if (!StringUtils.isNull(this.jeS.jeF)) {
                    aj = aj.dK("obj_name", this.jeS.jeF);
                }
                TiebaStatic.log(aj);
            } else if (id == R.id.recommend_bar_info_1 || id == R.id.recommend_bar_info_2 || id == R.id.recommend_bar_info_3) {
                FrsActivityConfig callFrom = new FrsActivityConfig(this.pageContext.getPageActivity()).createNormalCfg(aVar.cDs(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
                if (d.bdJ()) {
                    Intent intent = callFrom.getIntent();
                    if (aVar.clC() != 0 && intent != null) {
                        intent.putExtra("transition_type", 0);
                        intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.clC());
                    }
                }
                this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                aq aj2 = new aq("c13988").u("fid", aVar.getForumId()).dK("uid", TbadkApplication.getCurrentAccount()).aj("obj_locate", this.jet);
                if (!StringUtils.isNull(this.jeS.jeF)) {
                    aj2 = aj2.dK("obj_name", this.jeS.jeF);
                }
                TiebaStatic.log(aj2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FollowUserButton followUserButton, boolean z) {
        if (followUserButton != null) {
            followUserButton.setConfig(z ? this.jeW : this.jeX);
            followUserButton.setText(TbadkCoreApplication.getInst().getString(z ? R.string.followed : R.string.attention));
            followUserButton.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void a(e.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cDs()) && aVar.getForumId() > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.jeV == null) {
                    this.jeV = new a();
                }
                if (this.jeT == null) {
                    this.jeT = new LikeModel(this.pageContext);
                    this.jeT.setLoadDataCallBack(this.jeV);
                }
                this.jeV.a(followUserButton, aVar);
                if (at.isForumName(aVar.cDs())) {
                    this.loading = true;
                    this.jeT.dDI();
                    this.jeT.gk(aVar.cDs(), String.valueOf(aVar.getForumId()));
                }
            }
        }
    }

    private void b(e.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cDs()) && aVar.getForumId() > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.jeV == null) {
                    this.jeV = new a();
                }
                if (this.jeU == null) {
                    this.jeU = new ad();
                    this.jeU.a(this.jeV);
                }
                this.jeV.a(followUserButton, aVar);
                this.loading = true;
                this.jeU.L(aVar.cDs(), aVar.getForumId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a extends com.baidu.adp.base.d implements ad.a {
        private e.a jfi;
        private FollowUserButton jfj;

        private a() {
        }

        public void a(FollowUserButton followUserButton, e.a aVar) {
            this.jfi = aVar;
            this.jfj = followUserButton;
        }

        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            b.this.loading = false;
            if (b.this.jeT.getErrorCode() == 22) {
                l.showToast(b.this.pageContext.getPageActivity(), b.this.pageContext.getString(R.string.had_liked_forum));
            } else if (obj != null) {
                if (b.this.jeT.getErrorCode() != 0) {
                    l.showToast(b.this.pageContext.getPageActivity(), b.this.jeT.getErrorString());
                    return;
                }
                b.this.a(this.jfj, true);
                this.jfi.qo(true);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void z(String str, long j) {
            b.this.loading = false;
            b.this.a(this.jfj, false);
            this.jfi.qo(false);
        }

        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void A(String str, long j) {
            b.this.loading = false;
        }
    }
}

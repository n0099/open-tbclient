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
    private d kbS;
    private LikeModel kbT;
    private ae kbU;
    private a kbV;
    private com.baidu.tbadk.core.view.commonBtn.b kbW;
    private com.baidu.tbadk.core.view.commonBtn.b kbX;
    public TextView kbY;
    public BarImageView[] kbZ;
    private byte kbt;
    public TextView[] kca;
    public TextView[] kcb;
    public TextView[] kcc;
    public TextView[] kcd;
    public TextView[] kce;
    public FollowUserButton[] kcf;
    private final int[] kcg;
    private final int[] kch;
    private boolean loading;
    private TbPageContext<?> pageContext;

    public b(View view, TbPageContext<?> tbPageContext, byte b2) {
        super(view);
        this.loading = false;
        this.kbW = new com.baidu.tbadk.core.view.commonBtn.b();
        this.kbX = new com.baidu.tbadk.core.view.commonBtn.b();
        this.kbZ = new BarImageView[3];
        this.kca = new TextView[3];
        this.kcb = new TextView[3];
        this.kcc = new TextView[3];
        this.kcd = new TextView[3];
        this.kce = new TextView[3];
        this.kcf = new FollowUserButton[3];
        this.kcg = new int[]{R.id.recommend_bar_info_1, R.id.recommend_bar_info_2, R.id.recommend_bar_info_3};
        this.kch = new int[]{R.color.CAM_X0301, R.color.CAM_X0305, R.color.CAM_X0312};
        this.pageContext = tbPageContext;
        this.kbt = b2;
        am(view);
    }

    private void am(View view) {
        this.kbY = (TextView) view.findViewById(R.id.recommend_bar_item_title);
        this.kbW.pT(R.color.CAM_X0109);
        this.kbW.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.kbX.pR(R.color.CAM_X0304);
        this.kbX.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.kbX.pQ(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
        for (int i = 0; i < 3; i++) {
            View findViewById = view.findViewById(this.kcg[i]);
            findViewById.setTag(Integer.valueOf(i));
            findViewById.setOnClickListener(this);
            this.kbZ[i] = (BarImageView) findViewById.findViewById(R.id.recommend_bar_icon);
            this.kca[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_title_index);
            this.kcb[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_name);
            this.kcc[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_desc);
            this.kcd[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_concern_info);
            this.kce[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_thread_info);
            this.kcf[i] = (FollowUserButton) findViewById.findViewById(R.id.recommend_bar_concern_btn);
            this.kcf[i].setOnClickListener(this);
            this.kca[i].setText(String.valueOf(i + 1));
            this.kbZ[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.kbZ[i].setShowInnerBorder(true);
            this.kbZ[i].setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.kbZ[i].setShowOval(true);
            this.kbZ[i].setPlaceHolder(2);
            this.kbZ[i].setShowOuterBorder(false);
            this.kbZ[i].setStrokeColorResId(R.color.CAM_X0401);
        }
        onSkinTypeChanged(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void onSkinTypeChanged(int i) {
        if (this.ajU != i) {
            this.ajU = i;
            ap.setViewTextColor(this.kbY, R.color.CAM_X0108);
            for (int i2 = 0; i2 < 3; i2++) {
                if (this.kca[i2].getVisibility() == 0) {
                    ap.setViewTextColor(this.kca[i2], R.color.CAM_X0101);
                    com.baidu.tbadk.core.util.f.a.btv().oP(this.kch[i2]).oV(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8)).bv(this.kca[i2]);
                }
                this.kcf[i2].onChangeSkinType(i);
                ap.setViewTextColor(this.kcb[i2], R.color.CAM_X0105);
                ap.setViewTextColor(this.kcc[i2], R.color.CAM_X0109);
                ap.setViewTextColor(this.kcd[i2], R.color.CAM_X0109);
                ap.setViewTextColor(this.kce[i2], R.color.CAM_X0109);
            }
        }
    }

    public void sb(boolean z) {
        this.kbY.setVisibility(z ? 0 : 8);
    }

    public d cPl() {
        return this.kbS;
    }

    public void W(int i, boolean z) {
        if (this.kbS != null) {
            if (z) {
                a(this.kcf[i], true);
                this.kbS.kbH[i].rY(true);
                return;
            }
            a(this.kcf[i], false);
            this.kbS.kbH[i].rY(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void a(n nVar) {
        if (nVar instanceof d) {
            this.kbS = (d) nVar;
            this.kbY.setText(this.kbS.kbF);
            for (int i = 0; i < 3; i++) {
                this.kbZ[i].startLoad(this.kbS.kbH[i].cPf(), 10, false);
                this.kcb[i].setText(this.kbS.kbH[i].cPg());
                this.kce[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_thread, new Object[]{au.ed(this.kbS.kbH[i].cPj())}));
                this.kcd[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_concern, new Object[]{au.ed(this.kbS.kbH[i].cPi())}));
                this.kcf[i].setTag(Integer.valueOf(i));
                a(this.kcf[i], this.kbS.kbH[i].cPk());
                this.kca[i].setVisibility(this.kbS.kbG ? 0 : 8);
                ((LinearLayout.LayoutParams) this.kcb[i].getLayoutParams()).leftMargin = l.getDimens(this.pageContext.getPageActivity(), this.kbS.kbG ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.kbS.kbH[i].getSlogan()) && com.baidu.tbadk.a.d.bje()) {
                    this.kcc[i].setText(this.kbS.kbH[i].getSlogan());
                } else if (!StringUtils.isNull(this.kbS.kbH[i].cPh()) && com.baidu.tbadk.a.d.bjf()) {
                    this.kcc[i].setText(this.kbS.kbH[i].cPh());
                } else {
                    this.kcc[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_desc));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kbS != null && view != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            d.a aVar = this.kbS.kbH[intValue];
            if (view instanceof TBSpecificationBtn) {
                if (aVar.cPk()) {
                    b(aVar, this.kcf[intValue]);
                    return;
                }
                a(aVar, this.kcf[intValue]);
                ar ap = new ar("c13644").v("fid", aVar.getForumId()).dR("uid", TbadkApplication.getCurrentAccount()).ap("obj_locate", this.kbt);
                if (!StringUtils.isNull(this.kbS.kbF)) {
                    ap = ap.dR("obj_name", this.kbS.kbF);
                }
                TiebaStatic.log(ap);
            } else if (id == R.id.recommend_bar_info_1 || id == R.id.recommend_bar_info_2 || id == R.id.recommend_bar_info_3) {
                FrsActivityConfig callFrom = new FrsActivityConfig(this.pageContext.getPageActivity()).createNormalCfg(aVar.cPg(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
                if (com.baidu.tbadk.a.d.bjf()) {
                    Intent intent = callFrom.getIntent();
                    if (aVar.cvq() != 0 && intent != null) {
                        intent.putExtra("transition_type", 0);
                        intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.cvq());
                    }
                }
                this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                ar ap2 = new ar("c13988").v("fid", aVar.getForumId()).dR("uid", TbadkApplication.getCurrentAccount()).ap("obj_locate", this.kbt);
                if (!StringUtils.isNull(this.kbS.kbF)) {
                    ap2 = ap2.dR("obj_name", this.kbS.kbF);
                }
                TiebaStatic.log(ap2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FollowUserButton followUserButton, boolean z) {
        if (followUserButton != null) {
            followUserButton.setConfig(z ? this.kbW : this.kbX);
            followUserButton.setText(TbadkCoreApplication.getInst().getString(z ? R.string.followed : R.string.attention));
            followUserButton.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void a(d.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cPg()) && aVar.getForumId() > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.kbV == null) {
                    this.kbV = new a();
                }
                if (this.kbT == null) {
                    this.kbT = new LikeModel(this.pageContext);
                    this.kbT.setLoadDataCallBack(this.kbV);
                }
                this.kbV.a(followUserButton, aVar);
                if (au.isForumName(aVar.cPg())) {
                    this.loading = true;
                    this.kbT.dMN();
                    this.kbT.gw(aVar.cPg(), String.valueOf(aVar.getForumId()));
                }
            }
        }
    }

    private void b(d.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cPg()) && aVar.getForumId() > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.kbV == null) {
                    this.kbV = new a();
                }
                if (this.kbU == null) {
                    this.kbU = new ae();
                    this.kbU.a(this.kbV);
                }
                this.kbV.a(followUserButton, aVar);
                this.loading = true;
                this.kbU.O(aVar.cPg(), aVar.getForumId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends e implements ae.a {
        private d.a kci;
        private FollowUserButton kcj;

        private a() {
        }

        public void a(FollowUserButton followUserButton, d.a aVar) {
            this.kci = aVar;
            this.kcj = followUserButton;
        }

        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            b.this.loading = false;
            if (b.this.kbT.getErrorCode() == 22) {
                l.showToast(b.this.pageContext.getPageActivity(), b.this.pageContext.getString(R.string.had_liked_forum));
            } else if (obj != null) {
                if (b.this.kbT.getErrorCode() != 0) {
                    l.showToast(b.this.pageContext.getPageActivity(), b.this.kbT.getErrorString());
                    return;
                }
                b.this.a(this.kcj, true);
                this.kci.rY(true);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void B(String str, long j) {
            b.this.loading = false;
            b.this.a(this.kcj, false);
            this.kci.rY(false);
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            b.this.loading = false;
        }
    }
}

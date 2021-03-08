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
    private byte kdJ;
    private d kei;
    private LikeModel kej;
    private ae kek;
    private a kel;
    private com.baidu.tbadk.core.view.commonBtn.b kem;
    private com.baidu.tbadk.core.view.commonBtn.b ken;
    public TextView keo;
    public BarImageView[] kep;
    public TextView[] keq;
    public TextView[] ker;
    public TextView[] kes;
    public TextView[] ket;
    public TextView[] keu;
    public FollowUserButton[] kev;
    private final int[] kew;
    private final int[] kex;
    private boolean loading;
    private TbPageContext<?> pageContext;

    public b(View view, TbPageContext<?> tbPageContext, byte b) {
        super(view);
        this.loading = false;
        this.kem = new com.baidu.tbadk.core.view.commonBtn.b();
        this.ken = new com.baidu.tbadk.core.view.commonBtn.b();
        this.kep = new BarImageView[3];
        this.keq = new TextView[3];
        this.ker = new TextView[3];
        this.kes = new TextView[3];
        this.ket = new TextView[3];
        this.keu = new TextView[3];
        this.kev = new FollowUserButton[3];
        this.kew = new int[]{R.id.recommend_bar_info_1, R.id.recommend_bar_info_2, R.id.recommend_bar_info_3};
        this.kex = new int[]{R.color.CAM_X0301, R.color.CAM_X0305, R.color.CAM_X0312};
        this.pageContext = tbPageContext;
        this.kdJ = b;
        am(view);
    }

    private void am(View view) {
        this.keo = (TextView) view.findViewById(R.id.recommend_bar_item_title);
        this.kem.pU(R.color.CAM_X0109);
        this.kem.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.ken.pS(R.color.CAM_X0304);
        this.ken.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.ken.pR(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
        for (int i = 0; i < 3; i++) {
            View findViewById = view.findViewById(this.kew[i]);
            findViewById.setTag(Integer.valueOf(i));
            findViewById.setOnClickListener(this);
            this.kep[i] = (BarImageView) findViewById.findViewById(R.id.recommend_bar_icon);
            this.keq[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_title_index);
            this.ker[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_name);
            this.kes[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_desc);
            this.ket[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_concern_info);
            this.keu[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_thread_info);
            this.kev[i] = (FollowUserButton) findViewById.findViewById(R.id.recommend_bar_concern_btn);
            this.kev[i].setOnClickListener(this);
            this.keq[i].setText(String.valueOf(i + 1));
            this.kep[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.kep[i].setShowInnerBorder(true);
            this.kep[i].setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.kep[i].setShowOval(true);
            this.kep[i].setPlaceHolder(2);
            this.kep[i].setShowOuterBorder(false);
            this.kep[i].setStrokeColorResId(R.color.CAM_X0401);
        }
        onSkinTypeChanged(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void onSkinTypeChanged(int i) {
        if (this.aln != i) {
            this.aln = i;
            ap.setViewTextColor(this.keo, R.color.CAM_X0108);
            for (int i2 = 0; i2 < 3; i2++) {
                if (this.keq[i2].getVisibility() == 0) {
                    ap.setViewTextColor(this.keq[i2], R.color.CAM_X0101);
                    com.baidu.tbadk.core.util.f.a.bty().oQ(this.kex[i2]).oW(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8)).bv(this.keq[i2]);
                }
                this.kev[i2].onChangeSkinType(i);
                ap.setViewTextColor(this.ker[i2], R.color.CAM_X0105);
                ap.setViewTextColor(this.kes[i2], R.color.CAM_X0109);
                ap.setViewTextColor(this.ket[i2], R.color.CAM_X0109);
                ap.setViewTextColor(this.keu[i2], R.color.CAM_X0109);
            }
        }
    }

    public void sb(boolean z) {
        this.keo.setVisibility(z ? 0 : 8);
    }

    public d cPz() {
        return this.kei;
    }

    public void W(int i, boolean z) {
        if (this.kei != null) {
            if (z) {
                a(this.kev[i], true);
                this.kei.kdX[i].rY(true);
                return;
            }
            a(this.kev[i], false);
            this.kei.kdX[i].rY(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void a(n nVar) {
        if (nVar instanceof d) {
            this.kei = (d) nVar;
            this.keo.setText(this.kei.kdV);
            for (int i = 0; i < 3; i++) {
                this.kep[i].startLoad(this.kei.kdX[i].cPt(), 10, false);
                this.ker[i].setText(this.kei.kdX[i].cPu());
                this.keu[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_thread, new Object[]{au.ed(this.kei.kdX[i].cPx())}));
                this.ket[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_concern, new Object[]{au.ed(this.kei.kdX[i].cPw())}));
                this.kev[i].setTag(Integer.valueOf(i));
                a(this.kev[i], this.kei.kdX[i].cPy());
                this.keq[i].setVisibility(this.kei.kdW ? 0 : 8);
                ((LinearLayout.LayoutParams) this.ker[i].getLayoutParams()).leftMargin = l.getDimens(this.pageContext.getPageActivity(), this.kei.kdW ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.kei.kdX[i].getSlogan()) && com.baidu.tbadk.a.d.bjg()) {
                    this.kes[i].setText(this.kei.kdX[i].getSlogan());
                } else if (!StringUtils.isNull(this.kei.kdX[i].cPv()) && com.baidu.tbadk.a.d.bjh()) {
                    this.kes[i].setText(this.kei.kdX[i].cPv());
                } else {
                    this.kes[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_desc));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kei != null && view != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            d.a aVar = this.kei.kdX[intValue];
            if (view instanceof TBSpecificationBtn) {
                if (aVar.cPy()) {
                    b(aVar, this.kev[intValue]);
                    return;
                }
                a(aVar, this.kev[intValue]);
                ar aq = new ar("c13644").v("fid", aVar.getForumId()).dR("uid", TbadkApplication.getCurrentAccount()).aq("obj_locate", this.kdJ);
                if (!StringUtils.isNull(this.kei.kdV)) {
                    aq = aq.dR("obj_name", this.kei.kdV);
                }
                TiebaStatic.log(aq);
            } else if (id == R.id.recommend_bar_info_1 || id == R.id.recommend_bar_info_2 || id == R.id.recommend_bar_info_3) {
                FrsActivityConfig callFrom = new FrsActivityConfig(this.pageContext.getPageActivity()).createNormalCfg(aVar.cPu(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
                if (com.baidu.tbadk.a.d.bjh()) {
                    Intent intent = callFrom.getIntent();
                    if (aVar.cvD() != 0 && intent != null) {
                        intent.putExtra("transition_type", 0);
                        intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.cvD());
                    }
                }
                this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                ar aq2 = new ar("c13988").v("fid", aVar.getForumId()).dR("uid", TbadkApplication.getCurrentAccount()).aq("obj_locate", this.kdJ);
                if (!StringUtils.isNull(this.kei.kdV)) {
                    aq2 = aq2.dR("obj_name", this.kei.kdV);
                }
                TiebaStatic.log(aq2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FollowUserButton followUserButton, boolean z) {
        if (followUserButton != null) {
            followUserButton.setConfig(z ? this.kem : this.ken);
            followUserButton.setText(TbadkCoreApplication.getInst().getString(z ? R.string.followed : R.string.attention));
            followUserButton.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void a(d.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cPu()) && aVar.getForumId() > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.kel == null) {
                    this.kel = new a();
                }
                if (this.kej == null) {
                    this.kej = new LikeModel(this.pageContext);
                    this.kej.setLoadDataCallBack(this.kel);
                }
                this.kel.a(followUserButton, aVar);
                if (au.isForumName(aVar.cPu())) {
                    this.loading = true;
                    this.kej.dNd();
                    this.kej.gy(aVar.cPu(), String.valueOf(aVar.getForumId()));
                }
            }
        }
    }

    private void b(d.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cPu()) && aVar.getForumId() > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.kel == null) {
                    this.kel = new a();
                }
                if (this.kek == null) {
                    this.kek = new ae();
                    this.kek.a(this.kel);
                }
                this.kel.a(followUserButton, aVar);
                this.loading = true;
                this.kek.O(aVar.cPu(), aVar.getForumId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends e implements ae.a {
        private FollowUserButton keA;
        private d.a kez;

        private a() {
        }

        public void a(FollowUserButton followUserButton, d.a aVar) {
            this.kez = aVar;
            this.keA = followUserButton;
        }

        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            b.this.loading = false;
            if (b.this.kej.getErrorCode() == 22) {
                l.showToast(b.this.pageContext.getPageActivity(), b.this.pageContext.getString(R.string.had_liked_forum));
            } else if (obj != null) {
                if (b.this.kej.getErrorCode() != 0) {
                    l.showToast(b.this.pageContext.getPageActivity(), b.this.kej.getErrorString());
                    return;
                }
                b.this.a(this.keA, true);
                this.kez.rY(true);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void B(String str, long j) {
            b.this.loading = false;
            b.this.a(this.keA, false);
            this.kez.rY(false);
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            b.this.loading = false;
        }
    }
}

package com.baidu.tieba.homepage.concern.b;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
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
/* loaded from: classes22.dex */
public class b extends BdBaseViewPagerAdapter.a implements View.OnClickListener {
    private d jLG;
    private LikeModel jLH;
    private ae jLI;
    private a jLJ;
    private com.baidu.tbadk.core.view.commonBtn.b jLK;
    private com.baidu.tbadk.core.view.commonBtn.b jLL;
    public TextView jLM;
    public BarImageView[] jLN;
    public TextView[] jLO;
    public TextView[] jLP;
    public TextView[] jLQ;
    public TextView[] jLR;
    public TextView[] jLS;
    public FollowUserButton[] jLT;
    private final int[] jLU;
    private final int[] jLV;
    private byte jLh;
    private boolean loading;
    private TbPageContext<?> pageContext;

    public b(View view, TbPageContext<?> tbPageContext, byte b) {
        super(view);
        this.loading = false;
        this.jLK = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jLL = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jLN = new BarImageView[3];
        this.jLO = new TextView[3];
        this.jLP = new TextView[3];
        this.jLQ = new TextView[3];
        this.jLR = new TextView[3];
        this.jLS = new TextView[3];
        this.jLT = new FollowUserButton[3];
        this.jLU = new int[]{R.id.recommend_bar_info_1, R.id.recommend_bar_info_2, R.id.recommend_bar_info_3};
        this.jLV = new int[]{R.color.CAM_X0301, R.color.CAM_X0305, R.color.CAM_X0312};
        this.pageContext = tbPageContext;
        this.jLh = b;
        an(view);
    }

    private void an(View view) {
        this.jLM = (TextView) view.findViewById(R.id.recommend_bar_item_title);
        this.jLK.rj(R.color.CAM_X0109);
        this.jLK.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jLL.rh(R.color.CAM_X0304);
        this.jLL.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jLL.rg(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
        for (int i = 0; i < 3; i++) {
            View findViewById = view.findViewById(this.jLU[i]);
            findViewById.setTag(Integer.valueOf(i));
            findViewById.setOnClickListener(this);
            this.jLN[i] = (BarImageView) findViewById.findViewById(R.id.recommend_bar_icon);
            this.jLO[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_title_index);
            this.jLP[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_name);
            this.jLQ[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_desc);
            this.jLR[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_concern_info);
            this.jLS[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_thread_info);
            this.jLT[i] = (FollowUserButton) findViewById.findViewById(R.id.recommend_bar_concern_btn);
            this.jLT[i].setOnClickListener(this);
            this.jLO[i].setText(String.valueOf(i + 1));
            this.jLN[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jLN[i].setShowInnerBorder(true);
            this.jLN[i].setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.jLN[i].setShowOval(true);
            this.jLN[i].setPlaceHolder(2);
            this.jLN[i].setShowOuterBorder(false);
            this.jLN[i].setStrokeColorResId(R.color.CAM_X0401);
            if (com.baidu.tbadk.a.d.bkA()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jLN[i].getLayoutParams();
                marginLayoutParams.leftMargin = l.getDimens(this.pageContext.getPageActivity(), R.dimen.M_W_X007);
                this.jLN[i].setLayoutParams(marginLayoutParams);
            }
        }
        if (com.baidu.tbadk.a.d.bkA()) {
            this.jLM.setPadding(l.getDimens(this.pageContext.getPageActivity(), R.dimen.M_W_X007), 0, 0, 0);
        }
        onSkinTypeChanged(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void onSkinTypeChanged(int i) {
        if (this.aku != i) {
            this.aku = i;
            ap.setViewTextColor(this.jLM, R.color.CAM_X0108);
            for (int i2 = 0; i2 < 3; i2++) {
                if (this.jLO[i2].getVisibility() == 0) {
                    ap.setViewTextColor(this.jLO[i2], R.color.CAM_X0101);
                    com.baidu.tbadk.core.util.e.a.buz().qg(this.jLV[i2]).qm(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8)).bq(this.jLO[i2]);
                }
                this.jLT[i2].onChangeSkinType(i);
                ap.setViewTextColor(this.jLP[i2], R.color.CAM_X0105);
                ap.setViewTextColor(this.jLQ[i2], R.color.CAM_X0109);
                ap.setViewTextColor(this.jLR[i2], R.color.CAM_X0109);
                ap.setViewTextColor(this.jLS[i2], R.color.CAM_X0109);
            }
        }
    }

    public void rw(boolean z) {
        this.jLM.setVisibility(z ? 0 : 8);
    }

    public d cNZ() {
        return this.jLG;
    }

    public void W(int i, boolean z) {
        if (this.jLG != null) {
            if (z) {
                a(this.jLT[i], true);
                this.jLG.jLv[i].rt(true);
                return;
            }
            a(this.jLT[i], false);
            this.jLG.jLv[i].rt(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void a(q qVar) {
        if (qVar instanceof d) {
            this.jLG = (d) qVar;
            this.jLM.setText(this.jLG.jLt);
            for (int i = 0; i < 3; i++) {
                this.jLN[i].startLoad(this.jLG.jLv[i].cNT(), 10, false);
                this.jLP[i].setText(this.jLG.jLv[i].cNU());
                this.jLS[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_thread, new Object[]{au.dX(this.jLG.jLv[i].cNX())}));
                this.jLR[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_concern, new Object[]{au.dX(this.jLG.jLv[i].cNW())}));
                this.jLT[i].setTag(Integer.valueOf(i));
                a(this.jLT[i], this.jLG.jLv[i].cNY());
                this.jLO[i].setVisibility(this.jLG.jLu ? 0 : 8);
                ((LinearLayout.LayoutParams) this.jLP[i].getLayoutParams()).leftMargin = l.getDimens(this.pageContext.getPageActivity(), this.jLG.jLu ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.jLG.jLv[i].getSlogan()) && com.baidu.tbadk.a.d.bkx()) {
                    this.jLQ[i].setText(this.jLG.jLv[i].getSlogan());
                } else if (!StringUtils.isNull(this.jLG.jLv[i].cNV()) && com.baidu.tbadk.a.d.bky()) {
                    this.jLQ[i].setText(this.jLG.jLv[i].cNV());
                } else {
                    this.jLQ[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_desc));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jLG != null && view != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            d.a aVar = this.jLG.jLv[intValue];
            if (view instanceof TBSpecificationBtn) {
                if (aVar.cNY()) {
                    b(aVar, this.jLT[intValue]);
                    return;
                }
                a(aVar, this.jLT[intValue]);
                ar al = new ar("c13644").w("fid", aVar.getForumId()).dY("uid", TbadkApplication.getCurrentAccount()).al("obj_locate", this.jLh);
                if (!StringUtils.isNull(this.jLG.jLt)) {
                    al = al.dY("obj_name", this.jLG.jLt);
                }
                TiebaStatic.log(al);
            } else if (id == R.id.recommend_bar_info_1 || id == R.id.recommend_bar_info_2 || id == R.id.recommend_bar_info_3) {
                FrsActivityConfig callFrom = new FrsActivityConfig(this.pageContext.getPageActivity()).createNormalCfg(aVar.cNU(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
                if (com.baidu.tbadk.a.d.bky()) {
                    Intent intent = callFrom.getIntent();
                    if (aVar.cvb() != 0 && intent != null) {
                        intent.putExtra("transition_type", 0);
                        intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.cvb());
                    }
                }
                this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                ar al2 = new ar("c13988").w("fid", aVar.getForumId()).dY("uid", TbadkApplication.getCurrentAccount()).al("obj_locate", this.jLh);
                if (!StringUtils.isNull(this.jLG.jLt)) {
                    al2 = al2.dY("obj_name", this.jLG.jLt);
                }
                TiebaStatic.log(al2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FollowUserButton followUserButton, boolean z) {
        if (followUserButton != null) {
            followUserButton.setConfig(z ? this.jLK : this.jLL);
            followUserButton.setText(TbadkCoreApplication.getInst().getString(z ? R.string.followed : R.string.attention));
            followUserButton.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void a(d.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cNU()) && aVar.getForumId() > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.jLJ == null) {
                    this.jLJ = new a();
                }
                if (this.jLH == null) {
                    this.jLH = new LikeModel(this.pageContext);
                    this.jLH.setLoadDataCallBack(this.jLJ);
                }
                this.jLJ.a(followUserButton, aVar);
                if (au.isForumName(aVar.cNU())) {
                    this.loading = true;
                    this.jLH.dOA();
                    this.jLH.gu(aVar.cNU(), String.valueOf(aVar.getForumId()));
                }
            }
        }
    }

    private void b(d.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cNU()) && aVar.getForumId() > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.jLJ == null) {
                    this.jLJ = new a();
                }
                if (this.jLI == null) {
                    this.jLI = new ae();
                    this.jLI.a(this.jLJ);
                }
                this.jLJ.a(followUserButton, aVar);
                this.loading = true;
                this.jLI.O(aVar.cNU(), aVar.getForumId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a extends com.baidu.adp.base.d implements ae.a {
        private d.a jLW;
        private FollowUserButton jLX;

        private a() {
        }

        public void a(FollowUserButton followUserButton, d.a aVar) {
            this.jLW = aVar;
            this.jLX = followUserButton;
        }

        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            b.this.loading = false;
            if (b.this.jLH.getErrorCode() == 22) {
                l.showToast(b.this.pageContext.getPageActivity(), b.this.pageContext.getString(R.string.had_liked_forum));
            } else if (obj != null) {
                if (b.this.jLH.getErrorCode() != 0) {
                    l.showToast(b.this.pageContext.getPageActivity(), b.this.jLH.getErrorString());
                    return;
                }
                b.this.a(this.jLX, true);
                this.jLW.rt(true);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            b.this.loading = false;
            b.this.a(this.jLX, false);
            this.jLW.rt(false);
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void D(String str, long j) {
            b.this.loading = false;
        }
    }
}

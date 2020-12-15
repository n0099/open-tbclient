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
    private d jLI;
    private LikeModel jLJ;
    private ae jLK;
    private a jLL;
    private com.baidu.tbadk.core.view.commonBtn.b jLM;
    private com.baidu.tbadk.core.view.commonBtn.b jLN;
    public TextView jLO;
    public BarImageView[] jLP;
    public TextView[] jLQ;
    public TextView[] jLR;
    public TextView[] jLS;
    public TextView[] jLT;
    public TextView[] jLU;
    public FollowUserButton[] jLV;
    private final int[] jLW;
    private final int[] jLX;
    private byte jLj;
    private boolean loading;
    private TbPageContext<?> pageContext;

    public b(View view, TbPageContext<?> tbPageContext, byte b) {
        super(view);
        this.loading = false;
        this.jLM = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jLN = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jLP = new BarImageView[3];
        this.jLQ = new TextView[3];
        this.jLR = new TextView[3];
        this.jLS = new TextView[3];
        this.jLT = new TextView[3];
        this.jLU = new TextView[3];
        this.jLV = new FollowUserButton[3];
        this.jLW = new int[]{R.id.recommend_bar_info_1, R.id.recommend_bar_info_2, R.id.recommend_bar_info_3};
        this.jLX = new int[]{R.color.CAM_X0301, R.color.CAM_X0305, R.color.CAM_X0312};
        this.pageContext = tbPageContext;
        this.jLj = b;
        an(view);
    }

    private void an(View view) {
        this.jLO = (TextView) view.findViewById(R.id.recommend_bar_item_title);
        this.jLM.rj(R.color.CAM_X0109);
        this.jLM.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jLN.rh(R.color.CAM_X0304);
        this.jLN.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jLN.rg(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
        for (int i = 0; i < 3; i++) {
            View findViewById = view.findViewById(this.jLW[i]);
            findViewById.setTag(Integer.valueOf(i));
            findViewById.setOnClickListener(this);
            this.jLP[i] = (BarImageView) findViewById.findViewById(R.id.recommend_bar_icon);
            this.jLQ[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_title_index);
            this.jLR[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_name);
            this.jLS[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_desc);
            this.jLT[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_concern_info);
            this.jLU[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_thread_info);
            this.jLV[i] = (FollowUserButton) findViewById.findViewById(R.id.recommend_bar_concern_btn);
            this.jLV[i].setOnClickListener(this);
            this.jLQ[i].setText(String.valueOf(i + 1));
            this.jLP[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jLP[i].setShowInnerBorder(true);
            this.jLP[i].setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.jLP[i].setShowOval(true);
            this.jLP[i].setPlaceHolder(2);
            this.jLP[i].setShowOuterBorder(false);
            this.jLP[i].setStrokeColorResId(R.color.CAM_X0401);
            if (com.baidu.tbadk.a.d.bkA()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jLP[i].getLayoutParams();
                marginLayoutParams.leftMargin = l.getDimens(this.pageContext.getPageActivity(), R.dimen.M_W_X007);
                this.jLP[i].setLayoutParams(marginLayoutParams);
            }
        }
        if (com.baidu.tbadk.a.d.bkA()) {
            this.jLO.setPadding(l.getDimens(this.pageContext.getPageActivity(), R.dimen.M_W_X007), 0, 0, 0);
        }
        onSkinTypeChanged(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void onSkinTypeChanged(int i) {
        if (this.aku != i) {
            this.aku = i;
            ap.setViewTextColor(this.jLO, R.color.CAM_X0108);
            for (int i2 = 0; i2 < 3; i2++) {
                if (this.jLQ[i2].getVisibility() == 0) {
                    ap.setViewTextColor(this.jLQ[i2], R.color.CAM_X0101);
                    com.baidu.tbadk.core.util.e.a.buz().qg(this.jLX[i2]).qm(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8)).bq(this.jLQ[i2]);
                }
                this.jLV[i2].onChangeSkinType(i);
                ap.setViewTextColor(this.jLR[i2], R.color.CAM_X0105);
                ap.setViewTextColor(this.jLS[i2], R.color.CAM_X0109);
                ap.setViewTextColor(this.jLT[i2], R.color.CAM_X0109);
                ap.setViewTextColor(this.jLU[i2], R.color.CAM_X0109);
            }
        }
    }

    public void rw(boolean z) {
        this.jLO.setVisibility(z ? 0 : 8);
    }

    public d cOa() {
        return this.jLI;
    }

    public void W(int i, boolean z) {
        if (this.jLI != null) {
            if (z) {
                a(this.jLV[i], true);
                this.jLI.jLx[i].rt(true);
                return;
            }
            a(this.jLV[i], false);
            this.jLI.jLx[i].rt(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void a(q qVar) {
        if (qVar instanceof d) {
            this.jLI = (d) qVar;
            this.jLO.setText(this.jLI.jLv);
            for (int i = 0; i < 3; i++) {
                this.jLP[i].startLoad(this.jLI.jLx[i].cNU(), 10, false);
                this.jLR[i].setText(this.jLI.jLx[i].cNV());
                this.jLU[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_thread, new Object[]{au.dX(this.jLI.jLx[i].cNY())}));
                this.jLT[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_concern, new Object[]{au.dX(this.jLI.jLx[i].cNX())}));
                this.jLV[i].setTag(Integer.valueOf(i));
                a(this.jLV[i], this.jLI.jLx[i].cNZ());
                this.jLQ[i].setVisibility(this.jLI.jLw ? 0 : 8);
                ((LinearLayout.LayoutParams) this.jLR[i].getLayoutParams()).leftMargin = l.getDimens(this.pageContext.getPageActivity(), this.jLI.jLw ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.jLI.jLx[i].getSlogan()) && com.baidu.tbadk.a.d.bkx()) {
                    this.jLS[i].setText(this.jLI.jLx[i].getSlogan());
                } else if (!StringUtils.isNull(this.jLI.jLx[i].cNW()) && com.baidu.tbadk.a.d.bky()) {
                    this.jLS[i].setText(this.jLI.jLx[i].cNW());
                } else {
                    this.jLS[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_desc));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jLI != null && view != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            d.a aVar = this.jLI.jLx[intValue];
            if (view instanceof TBSpecificationBtn) {
                if (aVar.cNZ()) {
                    b(aVar, this.jLV[intValue]);
                    return;
                }
                a(aVar, this.jLV[intValue]);
                ar al = new ar("c13644").w("fid", aVar.getForumId()).dY("uid", TbadkApplication.getCurrentAccount()).al("obj_locate", this.jLj);
                if (!StringUtils.isNull(this.jLI.jLv)) {
                    al = al.dY("obj_name", this.jLI.jLv);
                }
                TiebaStatic.log(al);
            } else if (id == R.id.recommend_bar_info_1 || id == R.id.recommend_bar_info_2 || id == R.id.recommend_bar_info_3) {
                FrsActivityConfig callFrom = new FrsActivityConfig(this.pageContext.getPageActivity()).createNormalCfg(aVar.cNV(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
                if (com.baidu.tbadk.a.d.bky()) {
                    Intent intent = callFrom.getIntent();
                    if (aVar.cvc() != 0 && intent != null) {
                        intent.putExtra("transition_type", 0);
                        intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.cvc());
                    }
                }
                this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                ar al2 = new ar("c13988").w("fid", aVar.getForumId()).dY("uid", TbadkApplication.getCurrentAccount()).al("obj_locate", this.jLj);
                if (!StringUtils.isNull(this.jLI.jLv)) {
                    al2 = al2.dY("obj_name", this.jLI.jLv);
                }
                TiebaStatic.log(al2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FollowUserButton followUserButton, boolean z) {
        if (followUserButton != null) {
            followUserButton.setConfig(z ? this.jLM : this.jLN);
            followUserButton.setText(TbadkCoreApplication.getInst().getString(z ? R.string.followed : R.string.attention));
            followUserButton.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void a(d.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cNV()) && aVar.getForumId() > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.jLL == null) {
                    this.jLL = new a();
                }
                if (this.jLJ == null) {
                    this.jLJ = new LikeModel(this.pageContext);
                    this.jLJ.setLoadDataCallBack(this.jLL);
                }
                this.jLL.a(followUserButton, aVar);
                if (au.isForumName(aVar.cNV())) {
                    this.loading = true;
                    this.jLJ.dOB();
                    this.jLJ.gu(aVar.cNV(), String.valueOf(aVar.getForumId()));
                }
            }
        }
    }

    private void b(d.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cNV()) && aVar.getForumId() > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.jLL == null) {
                    this.jLL = new a();
                }
                if (this.jLK == null) {
                    this.jLK = new ae();
                    this.jLK.a(this.jLL);
                }
                this.jLL.a(followUserButton, aVar);
                this.loading = true;
                this.jLK.O(aVar.cNV(), aVar.getForumId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a extends com.baidu.adp.base.d implements ae.a {
        private d.a jLY;
        private FollowUserButton jLZ;

        private a() {
        }

        public void a(FollowUserButton followUserButton, d.a aVar) {
            this.jLY = aVar;
            this.jLZ = followUserButton;
        }

        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            b.this.loading = false;
            if (b.this.jLJ.getErrorCode() == 22) {
                l.showToast(b.this.pageContext.getPageActivity(), b.this.pageContext.getString(R.string.had_liked_forum));
            } else if (obj != null) {
                if (b.this.jLJ.getErrorCode() != 0) {
                    l.showToast(b.this.pageContext.getPageActivity(), b.this.jLJ.getErrorString());
                    return;
                }
                b.this.a(this.jLZ, true);
                this.jLY.rt(true);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            b.this.loading = false;
            b.this.a(this.jLZ, false);
            this.jLY.rt(false);
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void D(String str, long j) {
            b.this.loading = false;
        }
    }
}

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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
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
    private byte jTS;
    public TextView[] jUA;
    public TextView[] jUB;
    public TextView[] jUC;
    public TextView[] jUD;
    public FollowUserButton[] jUE;
    private final int[] jUF;
    private final int[] jUG;
    private d jUr;
    private LikeModel jUs;
    private ae jUt;
    private a jUu;
    private com.baidu.tbadk.core.view.commonBtn.b jUv;
    private com.baidu.tbadk.core.view.commonBtn.b jUw;
    public TextView jUx;
    public BarImageView[] jUy;
    public TextView[] jUz;
    private boolean loading;
    private TbPageContext<?> pageContext;

    public b(View view, TbPageContext<?> tbPageContext, byte b2) {
        super(view);
        this.loading = false;
        this.jUv = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jUw = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jUy = new BarImageView[3];
        this.jUz = new TextView[3];
        this.jUA = new TextView[3];
        this.jUB = new TextView[3];
        this.jUC = new TextView[3];
        this.jUD = new TextView[3];
        this.jUE = new FollowUserButton[3];
        this.jUF = new int[]{R.id.recommend_bar_info_1, R.id.recommend_bar_info_2, R.id.recommend_bar_info_3};
        this.jUG = new int[]{R.color.CAM_X0301, R.color.CAM_X0305, R.color.CAM_X0312};
        this.pageContext = tbPageContext;
        this.jTS = b2;
        ap(view);
    }

    private void ap(View view) {
        this.jUx = (TextView) view.findViewById(R.id.recommend_bar_item_title);
        this.jUv.pO(R.color.CAM_X0109);
        this.jUv.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jUw.pM(R.color.CAM_X0304);
        this.jUw.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jUw.pL(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
        for (int i = 0; i < 3; i++) {
            View findViewById = view.findViewById(this.jUF[i]);
            findViewById.setTag(Integer.valueOf(i));
            findViewById.setOnClickListener(this);
            this.jUy[i] = (BarImageView) findViewById.findViewById(R.id.recommend_bar_icon);
            this.jUz[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_title_index);
            this.jUA[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_name);
            this.jUB[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_desc);
            this.jUC[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_concern_info);
            this.jUD[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_thread_info);
            this.jUE[i] = (FollowUserButton) findViewById.findViewById(R.id.recommend_bar_concern_btn);
            this.jUE[i].setOnClickListener(this);
            this.jUz[i].setText(String.valueOf(i + 1));
            this.jUy[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jUy[i].setShowInnerBorder(true);
            this.jUy[i].setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.jUy[i].setShowOval(true);
            this.jUy[i].setPlaceHolder(2);
            this.jUy[i].setShowOuterBorder(false);
            this.jUy[i].setStrokeColorResId(R.color.CAM_X0401);
        }
        onSkinTypeChanged(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void onSkinTypeChanged(int i) {
        if (this.akf != i) {
            this.akf = i;
            ao.setViewTextColor(this.jUx, R.color.CAM_X0108);
            for (int i2 = 0; i2 < 3; i2++) {
                if (this.jUz[i2].getVisibility() == 0) {
                    ao.setViewTextColor(this.jUz[i2], R.color.CAM_X0101);
                    com.baidu.tbadk.core.util.f.a.btb().oK(this.jUG[i2]).oQ(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8)).bz(this.jUz[i2]);
                }
                this.jUE[i2].onChangeSkinType(i);
                ao.setViewTextColor(this.jUA[i2], R.color.CAM_X0105);
                ao.setViewTextColor(this.jUB[i2], R.color.CAM_X0109);
                ao.setViewTextColor(this.jUC[i2], R.color.CAM_X0109);
                ao.setViewTextColor(this.jUD[i2], R.color.CAM_X0109);
            }
        }
    }

    public void rP(boolean z) {
        this.jUx.setVisibility(z ? 0 : 8);
    }

    public d cNp() {
        return this.jUr;
    }

    public void W(int i, boolean z) {
        if (this.jUr != null) {
            if (z) {
                a(this.jUE[i], true);
                this.jUr.jUg[i].rM(true);
                return;
            }
            a(this.jUE[i], false);
            this.jUr.jUg[i].rM(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void a(n nVar) {
        if (nVar instanceof d) {
            this.jUr = (d) nVar;
            this.jUx.setText(this.jUr.jUe);
            for (int i = 0; i < 3; i++) {
                this.jUy[i].startLoad(this.jUr.jUg[i].cNj(), 10, false);
                this.jUA[i].setText(this.jUr.jUg[i].cNk());
                this.jUD[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_thread, new Object[]{at.dX(this.jUr.jUg[i].cNn())}));
                this.jUC[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_concern, new Object[]{at.dX(this.jUr.jUg[i].cNm())}));
                this.jUE[i].setTag(Integer.valueOf(i));
                a(this.jUE[i], this.jUr.jUg[i].cNo());
                this.jUz[i].setVisibility(this.jUr.jUf ? 0 : 8);
                ((LinearLayout.LayoutParams) this.jUA[i].getLayoutParams()).leftMargin = l.getDimens(this.pageContext.getPageActivity(), this.jUr.jUf ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.jUr.jUg[i].getSlogan()) && com.baidu.tbadk.a.d.biS()) {
                    this.jUB[i].setText(this.jUr.jUg[i].getSlogan());
                } else if (!StringUtils.isNull(this.jUr.jUg[i].cNl()) && com.baidu.tbadk.a.d.biT()) {
                    this.jUB[i].setText(this.jUr.jUg[i].cNl());
                } else {
                    this.jUB[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_desc));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jUr != null && view != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            d.a aVar = this.jUr.jUg[intValue];
            if (view instanceof TBSpecificationBtn) {
                if (aVar.cNo()) {
                    b(aVar, this.jUE[intValue]);
                    return;
                }
                a(aVar, this.jUE[intValue]);
                aq an = new aq("c13644").w("fid", aVar.getForumId()).dW("uid", TbadkApplication.getCurrentAccount()).an("obj_locate", this.jTS);
                if (!StringUtils.isNull(this.jUr.jUe)) {
                    an = an.dW("obj_name", this.jUr.jUe);
                }
                TiebaStatic.log(an);
            } else if (id == R.id.recommend_bar_info_1 || id == R.id.recommend_bar_info_2 || id == R.id.recommend_bar_info_3) {
                FrsActivityConfig callFrom = new FrsActivityConfig(this.pageContext.getPageActivity()).createNormalCfg(aVar.cNk(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
                if (com.baidu.tbadk.a.d.biT()) {
                    Intent intent = callFrom.getIntent();
                    if (aVar.cue() != 0 && intent != null) {
                        intent.putExtra("transition_type", 0);
                        intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.cue());
                    }
                }
                this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                aq an2 = new aq("c13988").w("fid", aVar.getForumId()).dW("uid", TbadkApplication.getCurrentAccount()).an("obj_locate", this.jTS);
                if (!StringUtils.isNull(this.jUr.jUe)) {
                    an2 = an2.dW("obj_name", this.jUr.jUe);
                }
                TiebaStatic.log(an2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FollowUserButton followUserButton, boolean z) {
        if (followUserButton != null) {
            followUserButton.setConfig(z ? this.jUv : this.jUw);
            followUserButton.setText(TbadkCoreApplication.getInst().getString(z ? R.string.followed : R.string.attention));
            followUserButton.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void a(d.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cNk()) && aVar.getForumId() > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.jUu == null) {
                    this.jUu = new a();
                }
                if (this.jUs == null) {
                    this.jUs = new LikeModel(this.pageContext);
                    this.jUs.setLoadDataCallBack(this.jUu);
                }
                this.jUu.a(followUserButton, aVar);
                if (at.isForumName(aVar.cNk())) {
                    this.loading = true;
                    this.jUs.dKC();
                    this.jUs.gq(aVar.cNk(), String.valueOf(aVar.getForumId()));
                }
            }
        }
    }

    private void b(d.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cNk()) && aVar.getForumId() > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.jUu == null) {
                    this.jUu = new a();
                }
                if (this.jUt == null) {
                    this.jUt = new ae();
                    this.jUt.a(this.jUu);
                }
                this.jUu.a(followUserButton, aVar);
                this.loading = true;
                this.jUt.P(aVar.cNk(), aVar.getForumId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends e implements ae.a {
        private d.a jUH;
        private FollowUserButton jUI;

        private a() {
        }

        public void a(FollowUserButton followUserButton, d.a aVar) {
            this.jUH = aVar;
            this.jUI = followUserButton;
        }

        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            b.this.loading = false;
            if (b.this.jUs.getErrorCode() == 22) {
                l.showToast(b.this.pageContext.getPageActivity(), b.this.pageContext.getString(R.string.had_liked_forum));
            } else if (obj != null) {
                if (b.this.jUs.getErrorCode() != 0) {
                    l.showToast(b.this.pageContext.getPageActivity(), b.this.jUs.getErrorString());
                    return;
                }
                b.this.a(this.jUI, true);
                this.jUH.rM(true);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            b.this.loading = false;
            b.this.a(this.jUI, false);
            this.jUH.rM(false);
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void D(String str, long j) {
            b.this.loading = false;
        }
    }
}

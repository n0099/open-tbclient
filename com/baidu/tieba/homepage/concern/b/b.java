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
    private d jYW;
    private LikeModel jYX;
    private ae jYY;
    private a jYZ;
    private byte jYx;
    private com.baidu.tbadk.core.view.commonBtn.b jZa;
    private com.baidu.tbadk.core.view.commonBtn.b jZb;
    public TextView jZc;
    public BarImageView[] jZd;
    public TextView[] jZe;
    public TextView[] jZf;
    public TextView[] jZg;
    public TextView[] jZh;
    public TextView[] jZi;
    public FollowUserButton[] jZj;
    private final int[] jZk;
    private final int[] jZl;
    private boolean loading;
    private TbPageContext<?> pageContext;

    public b(View view, TbPageContext<?> tbPageContext, byte b2) {
        super(view);
        this.loading = false;
        this.jZa = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jZb = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jZd = new BarImageView[3];
        this.jZe = new TextView[3];
        this.jZf = new TextView[3];
        this.jZg = new TextView[3];
        this.jZh = new TextView[3];
        this.jZi = new TextView[3];
        this.jZj = new FollowUserButton[3];
        this.jZk = new int[]{R.id.recommend_bar_info_1, R.id.recommend_bar_info_2, R.id.recommend_bar_info_3};
        this.jZl = new int[]{R.color.CAM_X0301, R.color.CAM_X0305, R.color.CAM_X0312};
        this.pageContext = tbPageContext;
        this.jYx = b2;
        ap(view);
    }

    private void ap(View view) {
        this.jZc = (TextView) view.findViewById(R.id.recommend_bar_item_title);
        this.jZa.ru(R.color.CAM_X0109);
        this.jZa.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jZb.rs(R.color.CAM_X0304);
        this.jZb.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jZb.rr(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
        for (int i = 0; i < 3; i++) {
            View findViewById = view.findViewById(this.jZk[i]);
            findViewById.setTag(Integer.valueOf(i));
            findViewById.setOnClickListener(this);
            this.jZd[i] = (BarImageView) findViewById.findViewById(R.id.recommend_bar_icon);
            this.jZe[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_title_index);
            this.jZf[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_name);
            this.jZg[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_desc);
            this.jZh[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_concern_info);
            this.jZi[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_thread_info);
            this.jZj[i] = (FollowUserButton) findViewById.findViewById(R.id.recommend_bar_concern_btn);
            this.jZj[i].setOnClickListener(this);
            this.jZe[i].setText(String.valueOf(i + 1));
            this.jZd[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jZd[i].setShowInnerBorder(true);
            this.jZd[i].setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.jZd[i].setShowOval(true);
            this.jZd[i].setPlaceHolder(2);
            this.jZd[i].setShowOuterBorder(false);
            this.jZd[i].setStrokeColorResId(R.color.CAM_X0401);
        }
        onSkinTypeChanged(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void onSkinTypeChanged(int i) {
        if (this.akW != i) {
            this.akW = i;
            ao.setViewTextColor(this.jZc, R.color.CAM_X0108);
            for (int i2 = 0; i2 < 3; i2++) {
                if (this.jZe[i2].getVisibility() == 0) {
                    ao.setViewTextColor(this.jZe[i2], R.color.CAM_X0101);
                    com.baidu.tbadk.core.util.f.a.bwV().qr(this.jZl[i2]).qx(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8)).bz(this.jZe[i2]);
                }
                this.jZj[i2].onChangeSkinType(i);
                ao.setViewTextColor(this.jZf[i2], R.color.CAM_X0105);
                ao.setViewTextColor(this.jZg[i2], R.color.CAM_X0109);
                ao.setViewTextColor(this.jZh[i2], R.color.CAM_X0109);
                ao.setViewTextColor(this.jZi[i2], R.color.CAM_X0109);
            }
        }
    }

    public void rT(boolean z) {
        this.jZc.setVisibility(z ? 0 : 8);
    }

    public d cRh() {
        return this.jYW;
    }

    public void W(int i, boolean z) {
        if (this.jYW != null) {
            if (z) {
                a(this.jZj[i], true);
                this.jYW.jYL[i].rQ(true);
                return;
            }
            a(this.jZj[i], false);
            this.jYW.jYL[i].rQ(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void a(n nVar) {
        if (nVar instanceof d) {
            this.jYW = (d) nVar;
            this.jZc.setText(this.jYW.jYJ);
            for (int i = 0; i < 3; i++) {
                this.jZd[i].startLoad(this.jYW.jYL[i].cRb(), 10, false);
                this.jZf[i].setText(this.jYW.jYL[i].cRc());
                this.jZi[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_thread, new Object[]{at.dX(this.jYW.jYL[i].cRf())}));
                this.jZh[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_concern, new Object[]{at.dX(this.jYW.jYL[i].cRe())}));
                this.jZj[i].setTag(Integer.valueOf(i));
                a(this.jZj[i], this.jYW.jYL[i].cRg());
                this.jZe[i].setVisibility(this.jYW.jYK ? 0 : 8);
                ((LinearLayout.LayoutParams) this.jZf[i].getLayoutParams()).leftMargin = l.getDimens(this.pageContext.getPageActivity(), this.jYW.jYK ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.jYW.jYL[i].getSlogan()) && com.baidu.tbadk.a.d.bmM()) {
                    this.jZg[i].setText(this.jYW.jYL[i].getSlogan());
                } else if (!StringUtils.isNull(this.jYW.jYL[i].cRd()) && com.baidu.tbadk.a.d.bmN()) {
                    this.jZg[i].setText(this.jYW.jYL[i].cRd());
                } else {
                    this.jZg[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_desc));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jYW != null && view != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            d.a aVar = this.jYW.jYL[intValue];
            if (view instanceof TBSpecificationBtn) {
                if (aVar.cRg()) {
                    b(aVar, this.jZj[intValue]);
                    return;
                }
                a(aVar, this.jZj[intValue]);
                aq an = new aq("c13644").w("fid", aVar.getForumId()).dX("uid", TbadkApplication.getCurrentAccount()).an("obj_locate", this.jYx);
                if (!StringUtils.isNull(this.jYW.jYJ)) {
                    an = an.dX("obj_name", this.jYW.jYJ);
                }
                TiebaStatic.log(an);
            } else if (id == R.id.recommend_bar_info_1 || id == R.id.recommend_bar_info_2 || id == R.id.recommend_bar_info_3) {
                FrsActivityConfig callFrom = new FrsActivityConfig(this.pageContext.getPageActivity()).createNormalCfg(aVar.cRc(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
                if (com.baidu.tbadk.a.d.bmN()) {
                    Intent intent = callFrom.getIntent();
                    if (aVar.cxW() != 0 && intent != null) {
                        intent.putExtra("transition_type", 0);
                        intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.cxW());
                    }
                }
                this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                aq an2 = new aq("c13988").w("fid", aVar.getForumId()).dX("uid", TbadkApplication.getCurrentAccount()).an("obj_locate", this.jYx);
                if (!StringUtils.isNull(this.jYW.jYJ)) {
                    an2 = an2.dX("obj_name", this.jYW.jYJ);
                }
                TiebaStatic.log(an2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FollowUserButton followUserButton, boolean z) {
        if (followUserButton != null) {
            followUserButton.setConfig(z ? this.jZa : this.jZb);
            followUserButton.setText(TbadkCoreApplication.getInst().getString(z ? R.string.followed : R.string.attention));
            followUserButton.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void a(d.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cRc()) && aVar.getForumId() > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.jYZ == null) {
                    this.jYZ = new a();
                }
                if (this.jYX == null) {
                    this.jYX = new LikeModel(this.pageContext);
                    this.jYX.setLoadDataCallBack(this.jYZ);
                }
                this.jYZ.a(followUserButton, aVar);
                if (at.isForumName(aVar.cRc())) {
                    this.loading = true;
                    this.jYX.dOu();
                    this.jYX.gr(aVar.cRc(), String.valueOf(aVar.getForumId()));
                }
            }
        }
    }

    private void b(d.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cRc()) && aVar.getForumId() > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.jYZ == null) {
                    this.jYZ = new a();
                }
                if (this.jYY == null) {
                    this.jYY = new ae();
                    this.jYY.a(this.jYZ);
                }
                this.jYZ.a(followUserButton, aVar);
                this.loading = true;
                this.jYY.P(aVar.cRc(), aVar.getForumId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends e implements ae.a {
        private d.a jZm;
        private FollowUserButton jZn;

        private a() {
        }

        public void a(FollowUserButton followUserButton, d.a aVar) {
            this.jZm = aVar;
            this.jZn = followUserButton;
        }

        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            b.this.loading = false;
            if (b.this.jYX.getErrorCode() == 22) {
                l.showToast(b.this.pageContext.getPageActivity(), b.this.pageContext.getString(R.string.had_liked_forum));
            } else if (obj != null) {
                if (b.this.jYX.getErrorCode() != 0) {
                    l.showToast(b.this.pageContext.getPageActivity(), b.this.jYX.getErrorString());
                    return;
                }
                b.this.a(this.jZn, true);
                this.jZm.rQ(true);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            b.this.loading = false;
            b.this.a(this.jZn, false);
            this.jZm.rQ(false);
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void D(String str, long j) {
            b.this.loading = false;
        }
    }
}

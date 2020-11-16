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
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes21.dex */
public class b extends BdBaseViewPagerAdapter.a implements View.OnClickListener {
    private byte jxF;
    private d jye;
    private LikeModel jyf;
    private ad jyg;
    private a jyh;
    private com.baidu.tbadk.core.view.commonBtn.b jyi;
    private com.baidu.tbadk.core.view.commonBtn.b jyj;
    public TextView jyk;
    public BarImageView[] jyl;
    public TextView[] jym;
    public TextView[] jyn;
    public TextView[] jyo;
    public TextView[] jyp;
    public TextView[] jyq;
    public FollowUserButton[] jyr;
    private final int[] jys;
    private final int[] jyt;
    private boolean loading;
    private TbPageContext<?> pageContext;

    public b(View view, TbPageContext<?> tbPageContext, byte b) {
        super(view);
        this.loading = false;
        this.jyi = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jyj = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jyl = new BarImageView[3];
        this.jym = new TextView[3];
        this.jyn = new TextView[3];
        this.jyo = new TextView[3];
        this.jyp = new TextView[3];
        this.jyq = new TextView[3];
        this.jyr = new FollowUserButton[3];
        this.jys = new int[]{R.id.recommend_bar_info_1, R.id.recommend_bar_info_2, R.id.recommend_bar_info_3};
        this.jyt = new int[]{R.color.CAM_X0301, R.color.CAM_X0305, R.color.CAM_X0312};
        this.pageContext = tbPageContext;
        this.jxF = b;
        al(view);
    }

    private void al(View view) {
        this.jyk = (TextView) view.findViewById(R.id.recommend_bar_item_title);
        this.jyi.qI(R.color.CAM_X0109);
        this.jyi.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jyj.qG(R.color.CAM_X0304);
        this.jyj.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jyj.qF(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
        for (int i = 0; i < 3; i++) {
            View findViewById = view.findViewById(this.jys[i]);
            findViewById.setTag(Integer.valueOf(i));
            findViewById.setOnClickListener(this);
            this.jyl[i] = (BarImageView) findViewById.findViewById(R.id.recommend_bar_icon);
            this.jym[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_title_index);
            this.jyn[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_name);
            this.jyo[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_desc);
            this.jyp[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_concern_info);
            this.jyq[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_thread_info);
            this.jyr[i] = (FollowUserButton) findViewById.findViewById(R.id.recommend_bar_concern_btn);
            this.jyr[i].setOnClickListener(this);
            this.jym[i].setText(String.valueOf(i + 1));
            this.jyl[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jyl[i].setShowInnerBorder(true);
            this.jyl[i].setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.jyl[i].setShowOval(true);
            this.jyl[i].setPlaceHolder(2);
            this.jyl[i].setShowOuterBorder(false);
            this.jyl[i].setStrokeColorResId(R.color.CAM_X0401);
            if (com.baidu.tbadk.a.d.bhw()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jyl[i].getLayoutParams();
                marginLayoutParams.leftMargin = l.getDimens(this.pageContext.getPageActivity(), R.dimen.M_W_X007);
                this.jyl[i].setLayoutParams(marginLayoutParams);
            }
        }
        if (com.baidu.tbadk.a.d.bhw()) {
            this.jyk.setPadding(l.getDimens(this.pageContext.getPageActivity(), R.dimen.M_W_X007), 0, 0, 0);
        }
        onSkinTypeChanged(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void onSkinTypeChanged(int i) {
        if (this.ajv != i) {
            this.ajv = i;
            ap.setViewTextColor(this.jyk, R.color.CAM_X0108);
            for (int i2 = 0; i2 < 3; i2++) {
                if (this.jym[i2].getVisibility() == 0) {
                    ap.setViewTextColor(this.jym[i2], R.color.CAM_X0101);
                    com.baidu.tbadk.core.util.e.a.brc().pG(this.jyt[i2]).pM(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8)).bn(this.jym[i2]);
                }
                this.jyr[i2].onChangeSkinType(i);
                ap.setViewTextColor(this.jyn[i2], R.color.CAM_X0105);
                ap.setViewTextColor(this.jyo[i2], R.color.CAM_X0109);
                ap.setViewTextColor(this.jyp[i2], R.color.CAM_X0109);
                ap.setViewTextColor(this.jyq[i2], R.color.CAM_X0109);
            }
        }
    }

    public void qV(boolean z) {
        this.jyk.setVisibility(z ? 0 : 8);
    }

    public d cIK() {
        return this.jye;
    }

    public void W(int i, boolean z) {
        if (this.jye != null) {
            if (z) {
                a(this.jyr[i], true);
                this.jye.jxT[i].qS(true);
                return;
            }
            a(this.jyr[i], false);
            this.jye.jxT[i].qS(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void a(q qVar) {
        if (qVar instanceof d) {
            this.jye = (d) qVar;
            this.jyk.setText(this.jye.jxR);
            for (int i = 0; i < 3; i++) {
                this.jyl[i].startLoad(this.jye.jxT[i].cIE(), 10, false);
                this.jyn[i].setText(this.jye.jxT[i].cIF());
                this.jyq[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_thread, new Object[]{au.dy(this.jye.jxT[i].cII())}));
                this.jyp[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_concern, new Object[]{au.dy(this.jye.jxT[i].cIH())}));
                this.jyr[i].setTag(Integer.valueOf(i));
                a(this.jyr[i], this.jye.jxT[i].cIJ());
                this.jym[i].setVisibility(this.jye.jxS ? 0 : 8);
                ((LinearLayout.LayoutParams) this.jyn[i].getLayoutParams()).leftMargin = l.getDimens(this.pageContext.getPageActivity(), this.jye.jxS ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.jye.jxT[i].getSlogan()) && com.baidu.tbadk.a.d.bht()) {
                    this.jyo[i].setText(this.jye.jxT[i].getSlogan());
                } else if (!StringUtils.isNull(this.jye.jxT[i].cIG()) && com.baidu.tbadk.a.d.bhu()) {
                    this.jyo[i].setText(this.jye.jxT[i].cIG());
                } else {
                    this.jyo[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_desc));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jye != null && view != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            d.a aVar = this.jye.jxT[intValue];
            if (view instanceof TBSpecificationBtn) {
                if (aVar.cIJ()) {
                    b(aVar, this.jyr[intValue]);
                    return;
                }
                a(aVar, this.jyr[intValue]);
                ar ak = new ar("c13644").w("fid", aVar.getForumId()).dR("uid", TbadkApplication.getCurrentAccount()).ak("obj_locate", this.jxF);
                if (!StringUtils.isNull(this.jye.jxR)) {
                    ak = ak.dR("obj_name", this.jye.jxR);
                }
                TiebaStatic.log(ak);
            } else if (id == R.id.recommend_bar_info_1 || id == R.id.recommend_bar_info_2 || id == R.id.recommend_bar_info_3) {
                FrsActivityConfig callFrom = new FrsActivityConfig(this.pageContext.getPageActivity()).createNormalCfg(aVar.cIF(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
                if (com.baidu.tbadk.a.d.bhu()) {
                    Intent intent = callFrom.getIntent();
                    if (aVar.cqN() != 0 && intent != null) {
                        intent.putExtra("transition_type", 0);
                        intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.cqN());
                    }
                }
                this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                ar ak2 = new ar("c13988").w("fid", aVar.getForumId()).dR("uid", TbadkApplication.getCurrentAccount()).ak("obj_locate", this.jxF);
                if (!StringUtils.isNull(this.jye.jxR)) {
                    ak2 = ak2.dR("obj_name", this.jye.jxR);
                }
                TiebaStatic.log(ak2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FollowUserButton followUserButton, boolean z) {
        if (followUserButton != null) {
            followUserButton.setConfig(z ? this.jyi : this.jyj);
            followUserButton.setText(TbadkCoreApplication.getInst().getString(z ? R.string.followed : R.string.attention));
            followUserButton.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void a(d.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cIF()) && aVar.getForumId() > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.jyh == null) {
                    this.jyh = new a();
                }
                if (this.jyf == null) {
                    this.jyf = new LikeModel(this.pageContext);
                    this.jyf.setLoadDataCallBack(this.jyh);
                }
                this.jyh.a(followUserButton, aVar);
                if (au.isForumName(aVar.cIF())) {
                    this.loading = true;
                    this.jyf.dJj();
                    this.jyf.gp(aVar.cIF(), String.valueOf(aVar.getForumId()));
                }
            }
        }
    }

    private void b(d.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.cIF()) && aVar.getForumId() > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.jyh == null) {
                    this.jyh = new a();
                }
                if (this.jyg == null) {
                    this.jyg = new ad();
                    this.jyg.a(this.jyh);
                }
                this.jyh.a(followUserButton, aVar);
                this.loading = true;
                this.jyg.O(aVar.cIF(), aVar.getForumId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends com.baidu.adp.base.d implements ad.a {
        private d.a jyu;
        private FollowUserButton jyv;

        private a() {
        }

        public void a(FollowUserButton followUserButton, d.a aVar) {
            this.jyu = aVar;
            this.jyv = followUserButton;
        }

        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            b.this.loading = false;
            if (b.this.jyf.getErrorCode() == 22) {
                l.showToast(b.this.pageContext.getPageActivity(), b.this.pageContext.getString(R.string.had_liked_forum));
            } else if (obj != null) {
                if (b.this.jyf.getErrorCode() != 0) {
                    l.showToast(b.this.pageContext.getPageActivity(), b.this.jyf.getErrorString());
                    return;
                }
                b.this.a(this.jyv, true);
                this.jyu.qS(true);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void C(String str, long j) {
            b.this.loading = false;
            b.this.a(this.jyv, false);
            this.jyu.qS(false);
        }

        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void D(String str, long j) {
            b.this.loading = false;
        }
    }
}

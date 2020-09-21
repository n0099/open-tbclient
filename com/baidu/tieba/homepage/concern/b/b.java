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
/* loaded from: classes21.dex */
public class b extends BdBaseViewPagerAdapter.a implements View.OnClickListener {
    private e iPY;
    private LikeModel iPZ;
    private byte iPz;
    private ad iQa;
    private a iQb;
    private com.baidu.tbadk.core.view.commonBtn.b iQc;
    private com.baidu.tbadk.core.view.commonBtn.b iQd;
    public TextView iQe;
    public BarImageView[] iQf;
    public TextView[] iQg;
    public TextView[] iQh;
    public TextView[] iQi;
    public TextView[] iQj;
    public TextView[] iQk;
    public FollowUserButton[] iQl;
    private final int[] iQm;
    private final int[] iQn;
    private boolean loading;
    private TbPageContext<?> pageContext;

    public b(View view, TbPageContext<?> tbPageContext, byte b) {
        super(view);
        this.loading = false;
        this.iQc = new com.baidu.tbadk.core.view.commonBtn.b();
        this.iQd = new com.baidu.tbadk.core.view.commonBtn.b();
        this.iQf = new BarImageView[3];
        this.iQg = new TextView[3];
        this.iQh = new TextView[3];
        this.iQi = new TextView[3];
        this.iQj = new TextView[3];
        this.iQk = new TextView[3];
        this.iQl = new FollowUserButton[3];
        this.iQm = new int[]{R.id.recommend_bar_info_1, R.id.recommend_bar_info_2, R.id.recommend_bar_info_3};
        this.iQn = new int[]{R.color.cp_cont_h, R.color.cp_link_tip_d, R.color.cp_other_f};
        this.pageContext = tbPageContext;
        this.iPz = b;
        am(view);
    }

    private void am(View view) {
        this.iQe = (TextView) view.findViewById(R.id.recommend_bar_item_title);
        this.iQc.pr(R.color.cp_cont_d);
        this.iQc.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.iQd.pp(R.color.cp_link_tip_a);
        this.iQd.pj(UtilHelper.getDimenPixelSize(R.dimen.tbds23));
        this.iQd.a(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.iQd.po(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
        for (int i = 0; i < 3; i++) {
            View findViewById = view.findViewById(this.iQm[i]);
            findViewById.setTag(Integer.valueOf(i));
            findViewById.setOnClickListener(this);
            this.iQf[i] = (BarImageView) findViewById.findViewById(R.id.recommend_bar_icon);
            this.iQg[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_title_index);
            this.iQh[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_name);
            this.iQi[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_desc);
            this.iQj[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_concern_info);
            this.iQk[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_thread_info);
            this.iQl[i] = (FollowUserButton) findViewById.findViewById(R.id.recommend_bar_concern_btn);
            this.iQl[i].setOnClickListener(this);
            this.iQg[i].setText(String.valueOf(i + 1));
            this.iQf[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.iQf[i].setShowInnerBorder(true);
            this.iQf[i].setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.iQf[i].setShowOval(true);
            this.iQf[i].setPlaceHolder(2);
            this.iQf[i].setShowOuterBorder(false);
            this.iQf[i].setStrokeColorResId(R.color.cp_border_a);
        }
        onSkinTypeChanged(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void onSkinTypeChanged(int i) {
        if (this.aiX != i) {
            this.aiX = i;
            ap.setViewTextColor(this.iQe, R.color.cp_cont_c);
            for (int i2 = 0; i2 < 3; i2++) {
                if (this.iQg[i2].getVisibility() == 0) {
                    ap.setViewTextColor(this.iQg[i2], R.color.cp_cont_a);
                    com.baidu.tbadk.core.util.e.a.bkL().or(this.iQn[i2]).ov(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8)).bb(this.iQg[i2]);
                }
                this.iQl[i2].onChangeSkinType(i);
                ap.setViewTextColor(this.iQh[i2], R.color.cp_cont_b);
                ap.setViewTextColor(this.iQi[i2], R.color.cp_cont_d);
                ap.setViewTextColor(this.iQj[i2], R.color.cp_cont_d);
                ap.setViewTextColor(this.iQk[i2], R.color.cp_cont_d);
            }
        }
    }

    public void pL(boolean z) {
        this.iQe.setVisibility(z ? 0 : 8);
    }

    public e czT() {
        return this.iPY;
    }

    public void U(int i, boolean z) {
        if (this.iPY != null) {
            if (z) {
                a(this.iQl[i], true);
                this.iPY.iPN[i].pI(true);
                return;
            }
            a(this.iQl[i], false);
            this.iPY.iPN[i].pI(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void a(q qVar) {
        if (qVar instanceof e) {
            this.iPY = (e) qVar;
            this.iQe.setText(this.iPY.iPL);
            for (int i = 0; i < 3; i++) {
                this.iQf[i].startLoad(this.iPY.iPN[i].czN(), 10, false);
                this.iQh[i].setText(this.iPY.iPN[i].czO());
                this.iQk[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_thread, new Object[]{at.cS(this.iPY.iPN[i].czR())}));
                this.iQj[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_concern, new Object[]{at.cS(this.iPY.iPN[i].czQ())}));
                this.iQl[i].setTag(Integer.valueOf(i));
                a(this.iQl[i], this.iPY.iPN[i].czS());
                this.iQg[i].setVisibility(this.iPY.iPM ? 0 : 8);
                ((LinearLayout.LayoutParams) this.iQh[i].getLayoutParams()).leftMargin = l.getDimens(this.pageContext.getPageActivity(), this.iPY.iPM ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.iPY.iPN[i].getSlogan()) && d.bba()) {
                    this.iQi[i].setText(this.iPY.iPN[i].getSlogan());
                } else if (!StringUtils.isNull(this.iPY.iPN[i].czP()) && d.bbb()) {
                    this.iQi[i].setText(this.iPY.iPN[i].czP());
                } else {
                    this.iQi[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_desc));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iPY != null && view != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            e.a aVar = this.iPY.iPN[intValue];
            if (view instanceof TBSpecificationBtn) {
                if (aVar.czS()) {
                    b(aVar, this.iQl[intValue]);
                    return;
                }
                a(aVar, this.iQl[intValue]);
                aq ai = new aq("c13644").u("fid", aVar.getForumId()).dF("uid", TbadkApplication.getCurrentAccount()).ai("obj_locate", this.iPz);
                if (!StringUtils.isNull(this.iPY.iPL)) {
                    ai = ai.dF("obj_name", this.iPY.iPL);
                }
                TiebaStatic.log(ai);
            } else if (id == R.id.recommend_bar_info_1 || id == R.id.recommend_bar_info_2 || id == R.id.recommend_bar_info_3) {
                FrsActivityConfig callFrom = new FrsActivityConfig(this.pageContext.getPageActivity()).createNormalCfg(aVar.czO(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
                if (d.bbb()) {
                    Intent intent = callFrom.getIntent();
                    if (aVar.cig() != 0 && intent != null) {
                        intent.putExtra("transition_type", 0);
                        intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.cig());
                    }
                }
                this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                aq ai2 = new aq("c13988").u("fid", aVar.getForumId()).dF("uid", TbadkApplication.getCurrentAccount()).ai("obj_locate", this.iPz);
                if (!StringUtils.isNull(this.iPY.iPL)) {
                    ai2 = ai2.dF("obj_name", this.iPY.iPL);
                }
                TiebaStatic.log(ai2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FollowUserButton followUserButton, boolean z) {
        if (followUserButton != null) {
            followUserButton.setConfig(z ? this.iQc : this.iQd);
            followUserButton.setText(TbadkCoreApplication.getInst().getString(z ? R.string.followed : R.string.attention));
            followUserButton.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void a(e.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.czO()) && aVar.getForumId() > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.iQb == null) {
                    this.iQb = new a();
                }
                if (this.iPZ == null) {
                    this.iPZ = new LikeModel(this.pageContext);
                    this.iPZ.setLoadDataCallBack(this.iQb);
                }
                this.iQb.a(followUserButton, aVar);
                if (at.isForumName(aVar.czO())) {
                    this.loading = true;
                    this.iPZ.dzW();
                    this.iPZ.gd(aVar.czO(), String.valueOf(aVar.getForumId()));
                }
            }
        }
    }

    private void b(e.a aVar, FollowUserButton followUserButton) {
        if (!this.loading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (aVar != null && !StringUtils.isNull(aVar.czO()) && aVar.getForumId() > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.iQb == null) {
                    this.iQb = new a();
                }
                if (this.iQa == null) {
                    this.iQa = new ad();
                    this.iQa.a(this.iQb);
                }
                this.iQb.a(followUserButton, aVar);
                this.loading = true;
                this.iQa.L(aVar.czO(), aVar.getForumId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends com.baidu.adp.base.d implements ad.a {
        private e.a iQo;
        private FollowUserButton iQp;

        private a() {
        }

        public void a(FollowUserButton followUserButton, e.a aVar) {
            this.iQo = aVar;
            this.iQp = followUserButton;
        }

        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            b.this.loading = false;
            if (b.this.iPZ.getErrorCode() == 22) {
                l.showToast(b.this.pageContext.getPageActivity(), b.this.pageContext.getString(R.string.had_liked_forum));
            } else if (obj != null) {
                if (b.this.iPZ.getErrorCode() != 0) {
                    l.showToast(b.this.pageContext.getPageActivity(), b.this.iPZ.getErrorString());
                    return;
                }
                b.this.a(this.iQp, true);
                this.iQo.pI(true);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void z(String str, long j) {
            b.this.loading = false;
            b.this.a(this.iQp, false);
            this.iQo.pI(false);
        }

        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void A(String str, long j) {
            b.this.loading = false;
        }
    }
}

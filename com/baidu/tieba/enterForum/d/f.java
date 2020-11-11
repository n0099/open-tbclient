package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ad;
/* loaded from: classes22.dex */
public class f {
    private boolean aiL;
    private BarImageView aiN;
    private TextView aiP;
    private TextView aiQ;
    private bi aiU;
    private LikeModel eZA;
    private TextView isJ;
    private TextView isK;
    private TBSpecificationBtn isL;
    private ad isN;
    private TbPageContext<?> mTbPageContext;
    private View mView;
    private String attention = TbadkCoreApplication.getInst().getString(R.string.attention);
    private String isM = TbadkCoreApplication.getInst().getString(R.string.thread_str);

    public f(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.aiN = (BarImageView) this.mView.findViewById(R.id.bar_image);
        this.aiP = (TextView) this.mView.findViewById(R.id.bar_name);
        this.aiQ = (TextView) this.mView.findViewById(R.id.desc);
        this.isJ = (TextView) this.mView.findViewById(R.id.follow_text);
        this.isK = (TextView) this.mView.findViewById(R.id.tiezi_text);
        this.isL = (TBSpecificationBtn) this.mView.findViewById(R.id.forum_like_button);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.ctN();
            }
        });
        this.isL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq aqVar = new aq("c13644");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.w("fid", f.this.aiU.getForumId());
                aqVar.al("obj_locate", 1);
                aqVar.al(TiebaInitialize.Params.OBJ_TO, f.this.aiU.isLike() ? 2 : 1);
                TiebaStatic.log(aqVar);
                if (f.this.aiU.isLike()) {
                    f.this.ctP();
                } else {
                    f.this.ctO();
                }
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bi biVar) {
        if (biVar != null) {
            this.aiU = biVar;
            this.aiN.setShowOval(true);
            this.aiN.setShowOuterBorder(false);
            this.aiN.setShowInnerBorder(true);
            this.aiN.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.aiN.setStrokeColorResId(R.color.cp_border_a);
            this.aiN.startLoad(biVar.getAvatar(), 10, false);
            String forumName = biVar.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            this.aiP.setText(forumName);
            this.isJ.setText(this.attention + " " + at.dA(biVar.blE()));
            this.isK.setText(this.isM + " " + at.dA(biVar.blF()));
            String bka = biVar.bka();
            if (at.isEmpty(bka)) {
                if (this.aiQ.getVisibility() != 8) {
                    this.aiQ.setVisibility(8);
                    if (this.aiP.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.aiP.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                        this.aiP.requestLayout();
                    }
                }
            } else {
                if (this.aiQ.getVisibility() != 0) {
                    this.aiQ.setVisibility(0);
                    if (this.aiP.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.aiP.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                        this.aiP.requestLayout();
                    }
                }
                this.aiQ.setText(bka);
            }
            oW(this.aiU.isLike());
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.aiP, R.color.cp_cont_b);
        ap.setViewTextColor(this.isJ, R.color.cp_cont_d);
        ap.setViewTextColor(this.isK, R.color.cp_cont_d);
        ap.setViewTextColor(this.aiQ, R.color.cp_cont_d);
    }

    public void oW(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.qi(R.color.cp_link_tip_a);
            this.isL.setConfig(bVar);
            this.isL.setText(this.attention);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.qk(R.color.cp_cont_d);
            this.isL.setConfig(bVar2);
            this.isL.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.aiU.setLike(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctN() {
        if (this.aiU != null) {
            String forumName = this.aiU.getForumName();
            if (at.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                aq aqVar = new aq("c13643");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.w("fid", this.aiU.getForumId());
                aqVar.al("obj_locate", 1);
                aqVar.al("obj_type", this.aiL ? 4 : 1);
                TiebaStatic.log(aqVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctO() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.aiU != null && !StringUtils.isNull(this.aiU.getForumName()) && this.aiU.getForumId() > 0) {
            if (!bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.eZA == null) {
                this.eZA = new LikeModel(this.mTbPageContext);
            }
            this.eZA.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.d.f.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (f.this.eZA.getErrorCode() == 22) {
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (f.this.eZA.getErrorCode() != 0) {
                            l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.eZA.getErrorString());
                            return;
                        }
                        f.this.oW(true);
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.attention_success));
                    }
                }
            });
            if (at.isForumName(this.aiU.getForumName())) {
                this.eZA.dJs();
                this.eZA.gp(this.aiU.getForumName(), String.valueOf(this.aiU.getForumId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctP() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.aiU != null && !StringUtils.isNull(this.aiU.getForumName()) && this.aiU.getForumId() > 0) {
            if (!bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.isN == null) {
                this.isN = new ad();
            }
            this.isN.a(new ad.a() { // from class: com.baidu.tieba.enterForum.d.f.4
                @Override // com.baidu.tieba.tbadkCore.ad.a
                public void C(String str, long j) {
                    f.this.oW(false);
                    l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.un_attention_success));
                }

                @Override // com.baidu.tieba.tbadkCore.ad.a
                public void D(String str, long j) {
                }
            });
            this.isN.O(this.aiU.getForumName(), this.aiU.getForumId());
        }
    }

    public void setHasLikeForum(boolean z) {
        this.aiL = z;
    }
}

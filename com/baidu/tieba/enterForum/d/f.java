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
    private boolean aiK;
    private BarImageView aiM;
    private TextView aiO;
    private TextView aiP;
    private bi aiT;
    private LikeModel eLp;
    private TextView iak;
    private TextView ial;
    private TBSpecificationBtn iam;
    private ad iao;
    private TbPageContext<?> mTbPageContext;
    private View mView;
    private String attention = TbadkCoreApplication.getInst().getString(R.string.attention);
    private String ian = TbadkCoreApplication.getInst().getString(R.string.thread_str);

    public f(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.aiM = (BarImageView) this.mView.findViewById(R.id.bar_image);
        this.aiO = (TextView) this.mView.findViewById(R.id.bar_name);
        this.aiP = (TextView) this.mView.findViewById(R.id.desc);
        this.iak = (TextView) this.mView.findViewById(R.id.follow_text);
        this.ial = (TextView) this.mView.findViewById(R.id.tiezi_text);
        this.iam = (TBSpecificationBtn) this.mView.findViewById(R.id.forum_like_button);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cof();
            }
        });
        this.iam.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq aqVar = new aq("c13644");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.u("fid", f.this.aiT.getForumId());
                aqVar.aj("obj_locate", 1);
                aqVar.aj(TiebaInitialize.Params.OBJ_TO, f.this.aiT.isLike() ? 2 : 1);
                TiebaStatic.log(aqVar);
                if (f.this.aiT.isLike()) {
                    f.this.coh();
                } else {
                    f.this.cog();
                }
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bi biVar) {
        if (biVar != null) {
            this.aiT = biVar;
            this.aiM.setShowOval(true);
            this.aiM.setShowOuterBorder(false);
            this.aiM.setShowInnerBorder(true);
            this.aiM.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.aiM.setStrokeColorResId(R.color.cp_border_a);
            this.aiM.startLoad(biVar.getAvatar(), 10, false);
            String forumName = biVar.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            this.aiO.setText(forumName);
            this.iak.setText(this.attention + " " + at.dc(biVar.bhl()));
            this.ial.setText(this.ian + " " + at.dc(biVar.bhm()));
            String bfH = biVar.bfH();
            if (at.isEmpty(bfH)) {
                if (this.aiP.getVisibility() != 8) {
                    this.aiP.setVisibility(8);
                    if (this.aiO.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.aiO.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                        this.aiO.requestLayout();
                    }
                }
            } else {
                if (this.aiP.getVisibility() != 0) {
                    this.aiP.setVisibility(0);
                    if (this.aiO.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.aiO.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                        this.aiO.requestLayout();
                    }
                }
                this.aiP.setText(bfH);
            }
            ov(this.aiT.isLike());
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.aiO, R.color.cp_cont_b);
        ap.setViewTextColor(this.iak, R.color.cp_cont_d);
        ap.setViewTextColor(this.ial, R.color.cp_cont_d);
        ap.setViewTextColor(this.aiP, R.color.cp_cont_d);
    }

    public void ov(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pN(R.color.cp_link_tip_a);
            this.iam.setConfig(bVar);
            this.iam.setText(this.attention);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pP(R.color.cp_cont_d);
            this.iam.setConfig(bVar2);
            this.iam.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.aiT.setLike(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cof() {
        if (this.aiT != null) {
            String forumName = this.aiT.getForumName();
            if (at.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                aq aqVar = new aq("c13643");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.u("fid", this.aiT.getForumId());
                aqVar.aj("obj_locate", 1);
                aqVar.aj("obj_type", this.aiK ? 4 : 1);
                TiebaStatic.log(aqVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cog() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.aiT != null && !StringUtils.isNull(this.aiT.getForumName()) && this.aiT.getForumId() > 0) {
            if (!bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.eLp == null) {
                this.eLp = new LikeModel(this.mTbPageContext);
            }
            this.eLp.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.d.f.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (f.this.eLp.getErrorCode() == 22) {
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (f.this.eLp.getErrorCode() != 0) {
                            l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.eLp.getErrorString());
                            return;
                        }
                        f.this.ov(true);
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.attention_success));
                    }
                }
            });
            if (at.isForumName(this.aiT.getForumName())) {
                this.eLp.dDI();
                this.eLp.gk(this.aiT.getForumName(), String.valueOf(this.aiT.getForumId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coh() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.aiT != null && !StringUtils.isNull(this.aiT.getForumName()) && this.aiT.getForumId() > 0) {
            if (!bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.iao == null) {
                this.iao = new ad();
            }
            this.iao.a(new ad.a() { // from class: com.baidu.tieba.enterForum.d.f.4
                @Override // com.baidu.tieba.tbadkCore.ad.a
                public void z(String str, long j) {
                    f.this.ov(false);
                    l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.un_attention_success));
                }

                @Override // com.baidu.tieba.tbadkCore.ad.a
                public void A(String str, long j) {
                }
            });
            this.iao.L(this.aiT.getForumName(), this.aiT.getForumId());
        }
    }

    public void setHasLikeForum(boolean z) {
        this.aiK = z;
    }
}

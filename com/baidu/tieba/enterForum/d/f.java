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
/* loaded from: classes21.dex */
public class f {
    private bi aiB;
    private boolean ais;
    private BarImageView aiu;
    private TextView aiw;
    private TextView aix;
    private LikeModel ezi;
    private TextView hLp;
    private TextView hLq;
    private TBSpecificationBtn hLr;
    private ad hLt;
    private TbPageContext<?> mTbPageContext;
    private View mView;
    private String attention = TbadkCoreApplication.getInst().getString(R.string.attention);
    private String hLs = TbadkCoreApplication.getInst().getString(R.string.thread_str);

    public f(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.aiu = (BarImageView) this.mView.findViewById(R.id.bar_image);
        this.aiw = (TextView) this.mView.findViewById(R.id.bar_name);
        this.aix = (TextView) this.mView.findViewById(R.id.desc);
        this.hLp = (TextView) this.mView.findViewById(R.id.follow_text);
        this.hLq = (TextView) this.mView.findViewById(R.id.tiezi_text);
        this.hLr = (TBSpecificationBtn) this.mView.findViewById(R.id.forum_like_button);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.ckJ();
            }
        });
        this.hLr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq aqVar = new aq("c13644");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.u("fid", f.this.aiB.getForumId());
                aqVar.ai("obj_locate", 1);
                aqVar.ai(TiebaInitialize.Params.OBJ_TO, f.this.aiB.isLike() ? 2 : 1);
                TiebaStatic.log(aqVar);
                if (f.this.aiB.isLike()) {
                    f.this.ckL();
                } else {
                    f.this.ckK();
                }
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bi biVar) {
        if (biVar != null) {
            this.aiB = biVar;
            this.aiu.setShowOval(true);
            this.aiu.setShowOuterBorder(false);
            this.aiu.setShowInnerBorder(true);
            this.aiu.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.aiu.setStrokeColorResId(R.color.cp_border_a);
            this.aiu.startLoad(biVar.getAvatar(), 10, false);
            String forumName = biVar.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            this.aiw.setText(forumName);
            this.hLp.setText(this.attention + " " + at.cU(biVar.beC()));
            this.hLq.setText(this.hLs + " " + at.cU(biVar.beD()));
            String bcZ = biVar.bcZ();
            if (at.isEmpty(bcZ)) {
                if (this.aix.getVisibility() != 8) {
                    this.aix.setVisibility(8);
                    if (this.aiw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.aiw.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                        this.aiw.requestLayout();
                    }
                }
            } else {
                if (this.aix.getVisibility() != 0) {
                    this.aix.setVisibility(0);
                    if (this.aiw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.aiw.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                        this.aiw.requestLayout();
                    }
                }
                this.aix.setText(bcZ);
            }
            nQ(this.aiB.isLike());
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.aiw, R.color.cp_cont_b);
        ap.setViewTextColor(this.hLp, R.color.cp_cont_d);
        ap.setViewTextColor(this.hLq, R.color.cp_cont_d);
        ap.setViewTextColor(this.aix, R.color.cp_cont_d);
    }

    public void nQ(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pp(R.color.cp_link_tip_a);
            this.hLr.setConfig(bVar);
            this.hLr.setText(this.attention);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pr(R.color.cp_cont_d);
            this.hLr.setConfig(bVar2);
            this.hLr.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.aiB.setLike(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckJ() {
        if (this.aiB != null) {
            String forumName = this.aiB.getForumName();
            if (at.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                aq aqVar = new aq("c13643");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.u("fid", this.aiB.getForumId());
                aqVar.ai("obj_locate", 1);
                aqVar.ai("obj_type", this.ais ? 4 : 1);
                TiebaStatic.log(aqVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckK() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.aiB != null && !StringUtils.isNull(this.aiB.getForumName()) && this.aiB.getForumId() > 0) {
            if (!bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.ezi == null) {
                this.ezi = new LikeModel(this.mTbPageContext);
            }
            this.ezi.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.d.f.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (f.this.ezi.getErrorCode() == 22) {
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (f.this.ezi.getErrorCode() != 0) {
                            l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.ezi.getErrorString());
                            return;
                        }
                        f.this.nQ(true);
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.attention_success));
                    }
                }
            });
            if (at.isForumName(this.aiB.getForumName())) {
                this.ezi.dzW();
                this.ezi.gd(this.aiB.getForumName(), String.valueOf(this.aiB.getForumId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckL() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.aiB != null && !StringUtils.isNull(this.aiB.getForumName()) && this.aiB.getForumId() > 0) {
            if (!bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.hLt == null) {
                this.hLt = new ad();
            }
            this.hLt.a(new ad.a() { // from class: com.baidu.tieba.enterForum.d.f.4
                @Override // com.baidu.tieba.tbadkCore.ad.a
                public void z(String str, long j) {
                    f.this.nQ(false);
                    l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.un_attention_success));
                }

                @Override // com.baidu.tieba.tbadkCore.ad.a
                public void A(String str, long j) {
                }
            });
            this.hLt.L(this.aiB.getForumName(), this.aiB.getForumId());
        }
    }

    public void setHasLikeForum(boolean z) {
        this.ais = z;
    }
}

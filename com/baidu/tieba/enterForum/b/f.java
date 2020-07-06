package com.baidu.tieba.enterForum.b;

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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ac;
/* loaded from: classes9.dex */
public class f {
    private boolean agV;
    private BarImageView agX;
    private TextView agZ;
    private TextView aha;
    private bg ahe;
    private LikeModel egK;
    private TextView hlE;
    private TextView hlF;
    private TBSpecificationBtn hlG;
    private ac hlI;
    private TbPageContext<?> mTbPageContext;
    private View mView;
    private String attention = TbadkCoreApplication.getInst().getString(R.string.attention);
    private String hlH = TbadkCoreApplication.getInst().getString(R.string.thread_str);

    public f(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.agX = (BarImageView) this.mView.findViewById(R.id.bar_image);
        this.agZ = (TextView) this.mView.findViewById(R.id.bar_name);
        this.aha = (TextView) this.mView.findViewById(R.id.desc);
        this.hlE = (TextView) this.mView.findViewById(R.id.follow_text);
        this.hlF = (TextView) this.mView.findViewById(R.id.tiezi_text);
        this.hlG = (TBSpecificationBtn) this.mView.findViewById(R.id.forum_like_button);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bTN();
            }
        });
        this.hlG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ao aoVar = new ao("c13644");
                aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                aoVar.s("fid", f.this.ahe.getForumId());
                aoVar.ag("obj_locate", 1);
                aoVar.ag(TiebaInitialize.Params.OBJ_TO, f.this.ahe.isLike() ? 2 : 1);
                TiebaStatic.log(aoVar);
                if (f.this.ahe.isLike()) {
                    f.this.bTP();
                } else {
                    f.this.bTO();
                }
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bg bgVar) {
        if (bgVar != null) {
            this.ahe = bgVar;
            this.agX.setShowOval(true);
            this.agX.setShowOuterBorder(false);
            this.agX.setShowInnerBorder(true);
            this.agX.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.agX.setStrokeColorResId(R.color.cp_border_a);
            this.agX.startLoad(bgVar.getAvatar(), 10, false);
            String forumName = bgVar.getForumName();
            if (ar.isEmpty(forumName)) {
                forumName = "";
            }
            this.agZ.setText(forumName);
            this.hlE.setText(this.attention + " " + ar.cp(bgVar.aRt()));
            this.hlF.setText(this.hlH + " " + ar.cp(bgVar.aRu()));
            String aPT = bgVar.aPT();
            if (ar.isEmpty(aPT)) {
                if (this.aha.getVisibility() != 8) {
                    this.aha.setVisibility(8);
                    if (this.agZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.agZ.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                        this.agZ.requestLayout();
                    }
                }
            } else {
                if (this.aha.getVisibility() != 0) {
                    this.aha.setVisibility(0);
                    if (this.agZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.agZ.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                        this.agZ.requestLayout();
                    }
                }
                this.aha.setText(aPT);
            }
            mz(this.ahe.isLike());
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        an.setViewTextColor(this.agZ, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hlE, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.hlF, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.aha, (int) R.color.cp_cont_d);
    }

    public void mz(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.mC(R.color.cp_link_tip_a);
            this.hlG.setConfig(cVar);
            this.hlG.setText(this.attention);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.mE(R.color.cp_cont_d);
            this.hlG.setConfig(cVar2);
            this.hlG.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.ahe.setLike(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTN() {
        if (this.ahe != null) {
            String forumName = this.ahe.getForumName();
            if (ar.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                ao aoVar = new ao("c13643");
                aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                aoVar.s("fid", this.ahe.getForumId());
                aoVar.ag("obj_locate", 1);
                aoVar.ag("obj_type", this.agV ? 4 : 1);
                TiebaStatic.log(aoVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTO() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.ahe != null && !StringUtils.isNull(this.ahe.getForumName()) && this.ahe.getForumId() > 0) {
            if (!be.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.egK == null) {
                this.egK = new LikeModel(this.mTbPageContext);
            }
            this.egK.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.b.f.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (f.this.egK.getErrorCode() == 22) {
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (f.this.egK.getErrorCode() != 0) {
                            l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.egK.getErrorString());
                            return;
                        }
                        f.this.mz(true);
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.attention_success));
                    }
                }
            });
            if (ar.isForumName(this.ahe.getForumName())) {
                this.egK.dhs();
                this.egK.fx(this.ahe.getForumName(), String.valueOf(this.ahe.getForumId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTP() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.ahe != null && !StringUtils.isNull(this.ahe.getForumName()) && this.ahe.getForumId() > 0) {
            if (!be.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.hlI == null) {
                this.hlI = new ac();
            }
            this.hlI.a(new ac.a() { // from class: com.baidu.tieba.enterForum.b.f.4
                @Override // com.baidu.tieba.tbadkCore.ac.a
                public void z(String str, long j) {
                    f.this.mz(false);
                    l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.un_attention_success));
                }

                @Override // com.baidu.tieba.tbadkCore.ac.a
                public void A(String str, long j) {
                }
            });
            this.hlI.K(this.ahe.getForumName(), this.ahe.getForumId());
        }
    }

    public void setHasLikeForum(boolean z) {
        this.agV = z;
    }
}

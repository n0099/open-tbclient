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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.k;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ac;
/* loaded from: classes9.dex */
public class f {
    private TextView aJn;
    private TextView dVS;
    private LikeModel dYI;
    private boolean gNU;
    private BarImageView gNV;
    private k gOa;
    private TextView gZh;
    private TextView gZi;
    private TBSpecificationBtn gZj;
    private ac gZl;
    private TbPageContext<?> mTbPageContext;
    private View mView;
    private String attention = TbadkCoreApplication.getInst().getString(R.string.attention);
    private String gZk = TbadkCoreApplication.getInst().getString(R.string.thread_str);

    public f(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.gNV = (BarImageView) this.mView.findViewById(R.id.bar_image);
        this.dVS = (TextView) this.mView.findViewById(R.id.bar_name);
        this.aJn = (TextView) this.mView.findViewById(R.id.desc);
        this.gZh = (TextView) this.mView.findViewById(R.id.follow_text);
        this.gZi = (TextView) this.mView.findViewById(R.id.tiezi_text);
        this.gZj = (TBSpecificationBtn) this.mView.findViewById(R.id.forum_like_button);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bQO();
            }
        });
        this.gZj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                an anVar = new an("c13644");
                anVar.s("uid", TbadkApplication.getCurrentAccountId());
                anVar.s("fid", f.this.gOa.getForumId());
                anVar.ag("obj_locate", 1);
                anVar.ag(TiebaInitialize.Params.OBJ_TO, f.this.gOa.isLike() ? 2 : 1);
                TiebaStatic.log(anVar);
                if (f.this.gOa.isLike()) {
                    f.this.bQQ();
                } else {
                    f.this.bQP();
                }
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(k kVar) {
        if (kVar != null) {
            this.gOa = kVar;
            this.gNV.setShowOval(true);
            this.gNV.setShowOuterBorder(false);
            this.gNV.setShowInnerBorder(true);
            this.gNV.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.gNV.setStrokeColorResId(R.color.cp_border_a);
            this.gNV.startLoad(kVar.getAvatar(), 10, false);
            String forumName = kVar.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            this.dVS.setText(forumName);
            this.gZh.setText(this.attention + " " + aq.cn(kVar.bOo()));
            this.gZi.setText(this.gZk + " " + aq.cn(kVar.bOp()));
            String aOj = kVar.aOj();
            if (aq.isEmpty(aOj)) {
                if (this.aJn.getVisibility() != 8) {
                    this.aJn.setVisibility(8);
                    if (this.dVS.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.dVS.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                        this.dVS.requestLayout();
                    }
                }
            } else {
                if (this.aJn.getVisibility() != 0) {
                    this.aJn.setVisibility(0);
                    if (this.dVS.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.dVS.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                        this.dVS.requestLayout();
                    }
                }
                this.aJn.setText(aOj);
            }
            mo(this.gOa.isLike());
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.dVS, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gZh, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gZi, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.aJn, (int) R.color.cp_cont_d);
    }

    public void mo(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.mi(R.color.cp_link_tip_a);
            this.gZj.setConfig(cVar);
            this.gZj.setText(this.attention);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.mk(R.color.cp_cont_d);
            this.gZj.setConfig(cVar2);
            this.gZj.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.gOa.setLike(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQO() {
        if (this.gOa != null) {
            String forumName = this.gOa.getForumName();
            if (aq.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                an anVar = new an("c13643");
                anVar.s("uid", TbadkApplication.getCurrentAccountId());
                anVar.s("fid", this.gOa.getForumId());
                anVar.ag("obj_locate", 1);
                anVar.ag("obj_type", this.gNU ? 4 : 1);
                TiebaStatic.log(anVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQP() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.gOa != null && !StringUtils.isNull(this.gOa.getForumName()) && this.gOa.getForumId() > 0) {
            if (!bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.dYI == null) {
                this.dYI = new LikeModel(this.mTbPageContext);
            }
            this.dYI.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.b.f.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (f.this.dYI.getErrorCode() == 22) {
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (f.this.dYI.getErrorCode() != 0) {
                            l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.dYI.getErrorString());
                            return;
                        }
                        f.this.mo(true);
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.attention_success));
                    }
                }
            });
            if (aq.isForumName(this.gOa.getForumName())) {
                this.dYI.dcN();
                this.dYI.fq(this.gOa.getForumName(), String.valueOf(this.gOa.getForumId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQQ() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.gOa != null && !StringUtils.isNull(this.gOa.getForumName()) && this.gOa.getForumId() > 0) {
            if (!bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.gZl == null) {
                this.gZl = new ac();
            }
            this.gZl.a(new ac.a() { // from class: com.baidu.tieba.enterForum.b.f.4
                @Override // com.baidu.tieba.tbadkCore.ac.a
                public void z(String str, long j) {
                    f.this.mo(false);
                    l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.un_attention_success));
                }

                @Override // com.baidu.tieba.tbadkCore.ac.a
                public void A(String str, long j) {
                }
            });
            this.gZl.K(this.gOa.getForumName(), this.gOa.getForumId());
        }
    }

    public void setHasLikeForum(boolean z) {
        this.gNU = z;
    }
}

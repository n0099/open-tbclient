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
    private TextView aDO;
    private TextView dHD;
    private LikeModel dKs;
    private TextView gKv;
    private TextView gKw;
    private TBSpecificationBtn gKx;
    private ac gKz;
    private boolean gzk;
    private BarImageView gzl;
    private k gzq;
    private TbPageContext<?> mTbPageContext;
    private View mView;
    private String attention = TbadkCoreApplication.getInst().getString(R.string.attention);
    private String gKy = TbadkCoreApplication.getInst().getString(R.string.thread_str);

    public f(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.gzl = (BarImageView) this.mView.findViewById(R.id.bar_image);
        this.dHD = (TextView) this.mView.findViewById(R.id.bar_name);
        this.aDO = (TextView) this.mView.findViewById(R.id.desc);
        this.gKv = (TextView) this.mView.findViewById(R.id.follow_text);
        this.gKw = (TextView) this.mView.findViewById(R.id.tiezi_text);
        this.gKx = (TBSpecificationBtn) this.mView.findViewById(R.id.forum_like_button);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bKs();
            }
        });
        this.gKx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                an anVar = new an("c13644");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.t("fid", f.this.gzq.getForumId());
                anVar.af("obj_locate", 1);
                anVar.af(TiebaInitialize.Params.OBJ_TO, f.this.gzq.isLike() ? 2 : 1);
                TiebaStatic.log(anVar);
                if (f.this.gzq.isLike()) {
                    f.this.bKu();
                } else {
                    f.this.bKt();
                }
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(k kVar) {
        if (kVar != null) {
            this.gzq = kVar;
            this.gzl.setShowOval(true);
            this.gzl.setShowOuterBorder(false);
            this.gzl.setShowInnerBorder(true);
            this.gzl.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.gzl.setStrokeColorResId(R.color.cp_border_a);
            this.gzl.startLoad(kVar.getAvatar(), 10, false);
            String forumName = kVar.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            this.dHD.setText(forumName);
            this.gKv.setText(this.attention + " " + aq.cl(kVar.bHU()));
            this.gKw.setText(this.gKy + " " + aq.cl(kVar.bHV()));
            String aIv = kVar.aIv();
            if (aq.isEmpty(aIv)) {
                if (this.aDO.getVisibility() != 8) {
                    this.aDO.setVisibility(8);
                    if (this.dHD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.dHD.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                        this.dHD.requestLayout();
                    }
                }
            } else {
                if (this.aDO.getVisibility() != 0) {
                    this.aDO.setVisibility(0);
                    if (this.dHD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.dHD.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                        this.dHD.requestLayout();
                    }
                }
                this.aDO.setText(aIv);
            }
            lT(this.gzq.isLike());
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.dHD, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gKv, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gKw, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.aDO, (int) R.color.cp_cont_d);
    }

    public void lT(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.lG(R.color.cp_link_tip_a);
            this.gKx.setConfig(cVar);
            this.gKx.setText(this.attention);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.lI(R.color.cp_cont_d);
            this.gKx.setConfig(cVar2);
            this.gKx.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.gzq.setLike(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKs() {
        if (this.gzq != null) {
            String forumName = this.gzq.getForumName();
            if (aq.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                an anVar = new an("c13643");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.t("fid", this.gzq.getForumId());
                anVar.af("obj_locate", 1);
                anVar.af("obj_type", this.gzk ? 4 : 1);
                TiebaStatic.log(anVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKt() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.gzq != null && !StringUtils.isNull(this.gzq.getForumName()) && this.gzq.getForumId() > 0) {
            if (!bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.dKs == null) {
                this.dKs = new LikeModel(this.mTbPageContext);
            }
            this.dKs.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.b.f.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (f.this.dKs.getErrorCode() == 22) {
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (f.this.dKs.getErrorCode() != 0) {
                            l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.dKs.getErrorString());
                            return;
                        }
                        f.this.lT(true);
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.attention_success));
                    }
                }
            });
            if (aq.isForumName(this.gzq.getForumName())) {
                this.dKs.cVI();
                this.dKs.eP(this.gzq.getForumName(), String.valueOf(this.gzq.getForumId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKu() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.gzq != null && !StringUtils.isNull(this.gzq.getForumName()) && this.gzq.getForumId() > 0) {
            if (!bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.gKz == null) {
                this.gKz = new ac();
            }
            this.gKz.a(new ac.a() { // from class: com.baidu.tieba.enterForum.b.f.4
                @Override // com.baidu.tieba.tbadkCore.ac.a
                public void A(String str, long j) {
                    f.this.lT(false);
                    l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.un_attention_success));
                }

                @Override // com.baidu.tieba.tbadkCore.ac.a
                public void B(String str, long j) {
                }
            });
            this.gKz.L(this.gzq.getForumName(), this.gzq.getForumId());
        }
    }

    public void setHasLikeForum(boolean z) {
        this.gzk = z;
    }
}

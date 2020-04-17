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
    private TextView aDI;
    private TextView dHz;
    private LikeModel dKo;
    private TextView gKp;
    private TextView gKq;
    private TBSpecificationBtn gKr;
    private ac gKt;
    private boolean gze;
    private BarImageView gzf;
    private k gzk;
    private TbPageContext<?> mTbPageContext;
    private View mView;
    private String attention = TbadkCoreApplication.getInst().getString(R.string.attention);
    private String gKs = TbadkCoreApplication.getInst().getString(R.string.thread_str);

    public f(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.gzf = (BarImageView) this.mView.findViewById(R.id.bar_image);
        this.dHz = (TextView) this.mView.findViewById(R.id.bar_name);
        this.aDI = (TextView) this.mView.findViewById(R.id.desc);
        this.gKp = (TextView) this.mView.findViewById(R.id.follow_text);
        this.gKq = (TextView) this.mView.findViewById(R.id.tiezi_text);
        this.gKr = (TBSpecificationBtn) this.mView.findViewById(R.id.forum_like_button);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bKu();
            }
        });
        this.gKr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                an anVar = new an("c13644");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.t("fid", f.this.gzk.getForumId());
                anVar.af("obj_locate", 1);
                anVar.af(TiebaInitialize.Params.OBJ_TO, f.this.gzk.isLike() ? 2 : 1);
                TiebaStatic.log(anVar);
                if (f.this.gzk.isLike()) {
                    f.this.bKw();
                } else {
                    f.this.bKv();
                }
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(k kVar) {
        if (kVar != null) {
            this.gzk = kVar;
            this.gzf.setShowOval(true);
            this.gzf.setShowOuterBorder(false);
            this.gzf.setShowInnerBorder(true);
            this.gzf.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.gzf.setStrokeColorResId(R.color.cp_border_a);
            this.gzf.startLoad(kVar.getAvatar(), 10, false);
            String forumName = kVar.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            this.dHz.setText(forumName);
            this.gKp.setText(this.attention + " " + aq.cl(kVar.bHW()));
            this.gKq.setText(this.gKs + " " + aq.cl(kVar.bHX()));
            String aIx = kVar.aIx();
            if (aq.isEmpty(aIx)) {
                if (this.aDI.getVisibility() != 8) {
                    this.aDI.setVisibility(8);
                    if (this.dHz.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.dHz.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                        this.dHz.requestLayout();
                    }
                }
            } else {
                if (this.aDI.getVisibility() != 0) {
                    this.aDI.setVisibility(0);
                    if (this.dHz.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.dHz.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                        this.dHz.requestLayout();
                    }
                }
                this.aDI.setText(aIx);
            }
            lT(this.gzk.isLike());
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.dHz, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gKp, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gKq, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.aDI, (int) R.color.cp_cont_d);
    }

    public void lT(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.lG(R.color.cp_link_tip_a);
            this.gKr.setConfig(cVar);
            this.gKr.setText(this.attention);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.lI(R.color.cp_cont_d);
            this.gKr.setConfig(cVar2);
            this.gKr.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.gzk.setLike(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKu() {
        if (this.gzk != null) {
            String forumName = this.gzk.getForumName();
            if (aq.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                an anVar = new an("c13643");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.t("fid", this.gzk.getForumId());
                anVar.af("obj_locate", 1);
                anVar.af("obj_type", this.gze ? 4 : 1);
                TiebaStatic.log(anVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKv() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.gzk != null && !StringUtils.isNull(this.gzk.getForumName()) && this.gzk.getForumId() > 0) {
            if (!bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.dKo == null) {
                this.dKo = new LikeModel(this.mTbPageContext);
            }
            this.dKo.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.b.f.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (f.this.dKo.getErrorCode() == 22) {
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (f.this.dKo.getErrorCode() != 0) {
                            l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.dKo.getErrorString());
                            return;
                        }
                        f.this.lT(true);
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.attention_success));
                    }
                }
            });
            if (aq.isForumName(this.gzk.getForumName())) {
                this.dKo.cVL();
                this.dKo.eP(this.gzk.getForumName(), String.valueOf(this.gzk.getForumId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKw() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.gzk != null && !StringUtils.isNull(this.gzk.getForumName()) && this.gzk.getForumId() > 0) {
            if (!bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.gKt == null) {
                this.gKt = new ac();
            }
            this.gKt.a(new ac.a() { // from class: com.baidu.tieba.enterForum.b.f.4
                @Override // com.baidu.tieba.tbadkCore.ac.a
                public void A(String str, long j) {
                    f.this.lT(false);
                    l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.un_attention_success));
                }

                @Override // com.baidu.tieba.tbadkCore.ac.a
                public void B(String str, long j) {
                }
            });
            this.gKt.L(this.gzk.getForumName(), this.gzk.getForumId());
        }
    }

    public void setHasLikeForum(boolean z) {
        this.gze = z;
    }
}

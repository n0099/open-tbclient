package com.baidu.tieba.enterForum.c;

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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ac;
/* loaded from: classes16.dex */
public class f {
    private boolean agM;
    private BarImageView agO;
    private TextView agQ;
    private TextView agR;
    private bh agV;
    private LikeModel emT;
    private TextView hrq;
    private TextView hrr;
    private TBSpecificationBtn hrs;
    private ac hru;
    private TbPageContext<?> mTbPageContext;
    private View mView;
    private String attention = TbadkCoreApplication.getInst().getString(R.string.attention);
    private String hrt = TbadkCoreApplication.getInst().getString(R.string.thread_str);

    public f(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.agO = (BarImageView) this.mView.findViewById(R.id.bar_image);
        this.agQ = (TextView) this.mView.findViewById(R.id.bar_name);
        this.agR = (TextView) this.mView.findViewById(R.id.desc);
        this.hrq = (TextView) this.mView.findViewById(R.id.follow_text);
        this.hrr = (TextView) this.mView.findViewById(R.id.tiezi_text);
        this.hrs = (TBSpecificationBtn) this.mView.findViewById(R.id.forum_like_button);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bXg();
            }
        });
        this.hrs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap apVar = new ap("c13644");
                apVar.t("uid", TbadkApplication.getCurrentAccountId());
                apVar.t("fid", f.this.agV.getForumId());
                apVar.ah("obj_locate", 1);
                apVar.ah(TiebaInitialize.Params.OBJ_TO, f.this.agV.isLike() ? 2 : 1);
                TiebaStatic.log(apVar);
                if (f.this.agV.isLike()) {
                    f.this.bXi();
                } else {
                    f.this.bXh();
                }
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bh bhVar) {
        if (bhVar != null) {
            this.agV = bhVar;
            this.agO.setShowOval(true);
            this.agO.setShowOuterBorder(false);
            this.agO.setShowInnerBorder(true);
            this.agO.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.agO.setStrokeColorResId(R.color.cp_border_a);
            this.agO.startLoad(bhVar.getAvatar(), 10, false);
            String forumName = bhVar.getForumName();
            if (as.isEmpty(forumName)) {
                forumName = "";
            }
            this.agQ.setText(forumName);
            this.hrq.setText(this.attention + " " + as.cI(bhVar.aVp()));
            this.hrr.setText(this.hrt + " " + as.cI(bhVar.aVq()));
            String aTO = bhVar.aTO();
            if (as.isEmpty(aTO)) {
                if (this.agR.getVisibility() != 8) {
                    this.agR.setVisibility(8);
                    if (this.agQ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.agQ.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                        this.agQ.requestLayout();
                    }
                }
            } else {
                if (this.agR.getVisibility() != 0) {
                    this.agR.setVisibility(0);
                    if (this.agQ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.agQ.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                        this.agQ.requestLayout();
                    }
                }
                this.agR.setText(aTO);
            }
            ne(this.agV.isLike());
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.agQ, R.color.cp_cont_b);
        ao.setViewTextColor(this.hrq, R.color.cp_cont_d);
        ao.setViewTextColor(this.hrr, R.color.cp_cont_d);
        ao.setViewTextColor(this.agR, R.color.cp_cont_d);
    }

    public void ne(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.mV(R.color.cp_link_tip_a);
            this.hrs.setConfig(cVar);
            this.hrs.setText(this.attention);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.mX(R.color.cp_cont_d);
            this.hrs.setConfig(cVar2);
            this.hrs.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.agV.setLike(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXg() {
        if (this.agV != null) {
            String forumName = this.agV.getForumName();
            if (as.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                ap apVar = new ap("c13643");
                apVar.t("uid", TbadkApplication.getCurrentAccountId());
                apVar.t("fid", this.agV.getForumId());
                apVar.ah("obj_locate", 1);
                apVar.ah("obj_type", this.agM ? 4 : 1);
                TiebaStatic.log(apVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXh() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.agV != null && !StringUtils.isNull(this.agV.getForumName()) && this.agV.getForumId() > 0) {
            if (!bf.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.emT == null) {
                this.emT = new LikeModel(this.mTbPageContext);
            }
            this.emT.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.c.f.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (f.this.emT.getErrorCode() == 22) {
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (f.this.emT.getErrorCode() != 0) {
                            l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.emT.getErrorString());
                            return;
                        }
                        f.this.ne(true);
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.attention_success));
                    }
                }
            });
            if (as.isForumName(this.agV.getForumName())) {
                this.emT.dkB();
                this.emT.fz(this.agV.getForumName(), String.valueOf(this.agV.getForumId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXi() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.agV != null && !StringUtils.isNull(this.agV.getForumName()) && this.agV.getForumId() > 0) {
            if (!bf.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.hru == null) {
                this.hru = new ac();
            }
            this.hru.a(new ac.a() { // from class: com.baidu.tieba.enterForum.c.f.4
                @Override // com.baidu.tieba.tbadkCore.ac.a
                public void x(String str, long j) {
                    f.this.ne(false);
                    l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.un_attention_success));
                }

                @Override // com.baidu.tieba.tbadkCore.ac.a
                public void y(String str, long j) {
                }
            });
            this.hru.J(this.agV.getForumName(), this.agV.getForumId());
        }
    }

    public void setHasLikeForum(boolean z) {
        this.agM = z;
    }
}

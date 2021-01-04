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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ae;
/* loaded from: classes2.dex */
public class f {
    private bl akA;
    private boolean akr;
    private BarImageView akt;
    private TextView akv;
    private TextView akw;
    private LikeModel fpO;
    private TextView iQD;
    private TextView iQE;
    private TBSpecificationBtn iQF;
    private ae iQH;
    private TbPageContext<?> mTbPageContext;
    private View mView;
    private String attention = TbadkCoreApplication.getInst().getString(R.string.attention);
    private String iQG = TbadkCoreApplication.getInst().getString(R.string.thread_str);

    public f(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.akt = (BarImageView) this.mView.findViewById(R.id.bar_image);
        this.akv = (TextView) this.mView.findViewById(R.id.bar_name);
        this.akw = (TextView) this.mView.findViewById(R.id.desc);
        this.iQD = (TextView) this.mView.findViewById(R.id.follow_text);
        this.iQE = (TextView) this.mView.findViewById(R.id.tiezi_text);
        this.iQF = (TBSpecificationBtn) this.mView.findViewById(R.id.forum_like_button);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cAz();
            }
        });
        this.iQF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq aqVar = new aq("c13644");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.w("fid", f.this.akA.getForumId());
                aqVar.an("obj_locate", 1);
                aqVar.an(TiebaInitialize.Params.OBJ_TO, f.this.akA.isLike() ? 2 : 1);
                TiebaStatic.log(aqVar);
                if (f.this.akA.isLike()) {
                    f.this.cAB();
                } else {
                    f.this.cAA();
                }
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bl blVar) {
        if (blVar != null) {
            this.akA = blVar;
            this.akt.setShowOval(true);
            this.akt.setShowOuterBorder(false);
            this.akt.setShowInnerBorder(true);
            this.akt.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.akt.setStrokeColorResId(R.color.CAM_X0401);
            this.akt.startLoad(blVar.getAvatar(), 10, false);
            String forumName = blVar.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            this.akv.setText(forumName);
            this.iQD.setText(this.attention + " " + at.dZ(blVar.bqu()));
            this.iQE.setText(this.iQG + " " + at.dZ(blVar.bqv()));
            String boP = blVar.boP();
            if (at.isEmpty(boP)) {
                if (this.akw.getVisibility() != 8) {
                    this.akw.setVisibility(8);
                    if (this.akv.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.akv.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                        this.akv.requestLayout();
                    }
                }
            } else {
                if (this.akw.getVisibility() != 0) {
                    this.akw.setVisibility(0);
                    if (this.akv.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.akv.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                        this.akv.requestLayout();
                    }
                }
                this.akw.setText(boP);
            }
            pS(this.akA.isLike());
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.akv, R.color.CAM_X0105);
        ao.setViewTextColor(this.iQD, R.color.CAM_X0109);
        ao.setViewTextColor(this.iQE, R.color.CAM_X0109);
        ao.setViewTextColor(this.akw, R.color.CAM_X0109);
    }

    public void pS(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.rs(R.color.CAM_X0302);
            this.iQF.setConfig(bVar);
            this.iQF.setText(this.attention);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.ru(R.color.CAM_X0109);
            this.iQF.setConfig(bVar2);
            this.iQF.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.akA.setLike(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAz() {
        if (this.akA != null) {
            String forumName = this.akA.getForumName();
            if (at.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                aq aqVar = new aq("c13643");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.w("fid", this.akA.getForumId());
                aqVar.an("obj_locate", 1);
                aqVar.an("obj_type", this.akr ? 4 : 1);
                TiebaStatic.log(aqVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAA() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.akA != null && !StringUtils.isNull(this.akA.getForumName()) && this.akA.getForumId() > 0) {
            if (!bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.fpO == null) {
                this.fpO = new LikeModel(this.mTbPageContext);
            }
            this.fpO.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.enterForum.c.f.3
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (f.this.fpO.getErrorCode() == 22) {
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (f.this.fpO.getErrorCode() != 0) {
                            l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.fpO.getErrorString());
                            return;
                        }
                        f.this.pS(true);
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.attention_success));
                    }
                }
            });
            if (at.isForumName(this.akA.getForumName())) {
                this.fpO.dOt();
                this.fpO.gr(this.akA.getForumName(), String.valueOf(this.akA.getForumId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAB() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.akA != null && !StringUtils.isNull(this.akA.getForumName()) && this.akA.getForumId() > 0) {
            if (!bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.iQH == null) {
                this.iQH = new ae();
            }
            this.iQH.a(new ae.a() { // from class: com.baidu.tieba.enterForum.c.f.4
                @Override // com.baidu.tieba.tbadkCore.ae.a
                public void C(String str, long j) {
                    f.this.pS(false);
                    l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.un_attention_success));
                }

                @Override // com.baidu.tieba.tbadkCore.ae.a
                public void D(String str, long j) {
                }
            });
            this.iQH.P(this.akA.getForumName(), this.akA.getForumId());
        }
    }

    public void setHasLikeForum(boolean z) {
        this.akr = z;
    }
}

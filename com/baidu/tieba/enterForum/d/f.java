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
/* loaded from: classes16.dex */
public class f {
    private boolean ahX;
    private BarImageView ahZ;
    private TextView aib;
    private TextView aic;
    private bi aih;
    private LikeModel exb;
    private TextView hEn;
    private TextView hEo;
    private TBSpecificationBtn hEp;
    private ad hEr;
    private TbPageContext<?> mTbPageContext;
    private View mView;
    private String attention = TbadkCoreApplication.getInst().getString(R.string.attention);
    private String hEq = TbadkCoreApplication.getInst().getString(R.string.thread_str);

    public f(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.ahZ = (BarImageView) this.mView.findViewById(R.id.bar_image);
        this.aib = (TextView) this.mView.findViewById(R.id.bar_name);
        this.aic = (TextView) this.mView.findViewById(R.id.desc);
        this.hEn = (TextView) this.mView.findViewById(R.id.follow_text);
        this.hEo = (TextView) this.mView.findViewById(R.id.tiezi_text);
        this.hEp = (TBSpecificationBtn) this.mView.findViewById(R.id.forum_like_button);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.chu();
            }
        });
        this.hEp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq aqVar = new aq("c13644");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.u("fid", f.this.aih.getForumId());
                aqVar.ai("obj_locate", 1);
                aqVar.ai(TiebaInitialize.Params.OBJ_TO, f.this.aih.isLike() ? 2 : 1);
                TiebaStatic.log(aqVar);
                if (f.this.aih.isLike()) {
                    f.this.chw();
                } else {
                    f.this.chv();
                }
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bi biVar) {
        if (biVar != null) {
            this.aih = biVar;
            this.ahZ.setShowOval(true);
            this.ahZ.setShowOuterBorder(false);
            this.ahZ.setShowInnerBorder(true);
            this.ahZ.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.ahZ.setStrokeColorResId(R.color.cp_border_a);
            this.ahZ.startLoad(biVar.getAvatar(), 10, false);
            String forumName = biVar.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            this.aib.setText(forumName);
            this.hEn.setText(this.attention + " " + at.cT(biVar.bdI()));
            this.hEo.setText(this.hEq + " " + at.cT(biVar.bdJ()));
            String bcf = biVar.bcf();
            if (at.isEmpty(bcf)) {
                if (this.aic.getVisibility() != 8) {
                    this.aic.setVisibility(8);
                    if (this.aib.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.aib.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                        this.aib.requestLayout();
                    }
                }
            } else {
                if (this.aic.getVisibility() != 0) {
                    this.aic.setVisibility(0);
                    if (this.aib.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.aib.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                        this.aib.requestLayout();
                    }
                }
                this.aic.setText(bcf);
            }
            nK(this.aih.isLike());
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.aib, R.color.cp_cont_b);
        ap.setViewTextColor(this.hEn, R.color.cp_cont_d);
        ap.setViewTextColor(this.hEo, R.color.cp_cont_d);
        ap.setViewTextColor(this.aic, R.color.cp_cont_d);
    }

    public void nK(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pb(R.color.cp_link_tip_a);
            this.hEp.setConfig(bVar);
            this.hEp.setText(this.attention);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pd(R.color.cp_cont_d);
            this.hEp.setConfig(bVar2);
            this.hEp.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.aih.setLike(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chu() {
        if (this.aih != null) {
            String forumName = this.aih.getForumName();
            if (at.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                aq aqVar = new aq("c13643");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.u("fid", this.aih.getForumId());
                aqVar.ai("obj_locate", 1);
                aqVar.ai("obj_type", this.ahX ? 4 : 1);
                TiebaStatic.log(aqVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chv() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.aih != null && !StringUtils.isNull(this.aih.getForumName()) && this.aih.getForumId() > 0) {
            if (!bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.exb == null) {
                this.exb = new LikeModel(this.mTbPageContext);
            }
            this.exb.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.d.f.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (f.this.exb.getErrorCode() == 22) {
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (f.this.exb.getErrorCode() != 0) {
                            l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.exb.getErrorString());
                            return;
                        }
                        f.this.nK(true);
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.attention_success));
                    }
                }
            });
            if (at.isForumName(this.aih.getForumName())) {
                this.exb.dwd();
                this.exb.fR(this.aih.getForumName(), String.valueOf(this.aih.getForumId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chw() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.aih != null && !StringUtils.isNull(this.aih.getForumName()) && this.aih.getForumId() > 0) {
            if (!bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.hEr == null) {
                this.hEr = new ad();
            }
            this.hEr.a(new ad.a() { // from class: com.baidu.tieba.enterForum.d.f.4
                @Override // com.baidu.tieba.tbadkCore.ad.a
                public void y(String str, long j) {
                    f.this.nK(false);
                    l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.un_attention_success));
                }

                @Override // com.baidu.tieba.tbadkCore.ad.a
                public void z(String str, long j) {
                }
            });
            this.hEr.K(this.aih.getForumName(), this.aih.getForumId());
        }
    }

    public void setHasLikeForum(boolean z) {
        this.ahX = z;
    }
}

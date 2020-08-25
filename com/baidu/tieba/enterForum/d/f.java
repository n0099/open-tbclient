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
    private boolean ahV;
    private BarImageView ahX;
    private TextView ahZ;
    private TextView aia;
    private bi aif;
    private LikeModel ewX;
    private TextView hEh;
    private TextView hEi;
    private TBSpecificationBtn hEj;
    private ad hEl;
    private TbPageContext<?> mTbPageContext;
    private View mView;
    private String attention = TbadkCoreApplication.getInst().getString(R.string.attention);
    private String hEk = TbadkCoreApplication.getInst().getString(R.string.thread_str);

    public f(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.ahX = (BarImageView) this.mView.findViewById(R.id.bar_image);
        this.ahZ = (TextView) this.mView.findViewById(R.id.bar_name);
        this.aia = (TextView) this.mView.findViewById(R.id.desc);
        this.hEh = (TextView) this.mView.findViewById(R.id.follow_text);
        this.hEi = (TextView) this.mView.findViewById(R.id.tiezi_text);
        this.hEj = (TBSpecificationBtn) this.mView.findViewById(R.id.forum_like_button);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cht();
            }
        });
        this.hEj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq aqVar = new aq("c13644");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.u("fid", f.this.aif.getForumId());
                aqVar.ai("obj_locate", 1);
                aqVar.ai(TiebaInitialize.Params.OBJ_TO, f.this.aif.isLike() ? 2 : 1);
                TiebaStatic.log(aqVar);
                if (f.this.aif.isLike()) {
                    f.this.chv();
                } else {
                    f.this.chu();
                }
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bi biVar) {
        if (biVar != null) {
            this.aif = biVar;
            this.ahX.setShowOval(true);
            this.ahX.setShowOuterBorder(false);
            this.ahX.setShowInnerBorder(true);
            this.ahX.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.ahX.setStrokeColorResId(R.color.cp_border_a);
            this.ahX.startLoad(biVar.getAvatar(), 10, false);
            String forumName = biVar.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            this.ahZ.setText(forumName);
            this.hEh.setText(this.attention + " " + at.cT(biVar.bdI()));
            this.hEi.setText(this.hEk + " " + at.cT(biVar.bdJ()));
            String bcf = biVar.bcf();
            if (at.isEmpty(bcf)) {
                if (this.aia.getVisibility() != 8) {
                    this.aia.setVisibility(8);
                    if (this.ahZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.ahZ.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                        this.ahZ.requestLayout();
                    }
                }
            } else {
                if (this.aia.getVisibility() != 0) {
                    this.aia.setVisibility(0);
                    if (this.ahZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.ahZ.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                        this.ahZ.requestLayout();
                    }
                }
                this.aia.setText(bcf);
            }
            nI(this.aif.isLike());
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.ahZ, R.color.cp_cont_b);
        ap.setViewTextColor(this.hEh, R.color.cp_cont_d);
        ap.setViewTextColor(this.hEi, R.color.cp_cont_d);
        ap.setViewTextColor(this.aia, R.color.cp_cont_d);
    }

    public void nI(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pb(R.color.cp_link_tip_a);
            this.hEj.setConfig(bVar);
            this.hEj.setText(this.attention);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pd(R.color.cp_cont_d);
            this.hEj.setConfig(bVar2);
            this.hEj.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.aif.setLike(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cht() {
        if (this.aif != null) {
            String forumName = this.aif.getForumName();
            if (at.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                aq aqVar = new aq("c13643");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.u("fid", this.aif.getForumId());
                aqVar.ai("obj_locate", 1);
                aqVar.ai("obj_type", this.ahV ? 4 : 1);
                TiebaStatic.log(aqVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chu() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.aif != null && !StringUtils.isNull(this.aif.getForumName()) && this.aif.getForumId() > 0) {
            if (!bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.ewX == null) {
                this.ewX = new LikeModel(this.mTbPageContext);
            }
            this.ewX.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.d.f.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (f.this.ewX.getErrorCode() == 22) {
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (f.this.ewX.getErrorCode() != 0) {
                            l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.ewX.getErrorString());
                            return;
                        }
                        f.this.nI(true);
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.attention_success));
                    }
                }
            });
            if (at.isForumName(this.aif.getForumName())) {
                this.ewX.dvY();
                this.ewX.fQ(this.aif.getForumName(), String.valueOf(this.aif.getForumId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chv() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.aif != null && !StringUtils.isNull(this.aif.getForumName()) && this.aif.getForumId() > 0) {
            if (!bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.hEl == null) {
                this.hEl = new ad();
            }
            this.hEl.a(new ad.a() { // from class: com.baidu.tieba.enterForum.d.f.4
                @Override // com.baidu.tieba.tbadkCore.ad.a
                public void y(String str, long j) {
                    f.this.nI(false);
                    l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.un_attention_success));
                }

                @Override // com.baidu.tieba.tbadkCore.ad.a
                public void z(String str, long j) {
                }
            });
            this.hEl.K(this.aif.getForumName(), this.aif.getForumId());
        }
    }

    public void setHasLikeForum(boolean z) {
        this.ahV = z;
    }
}

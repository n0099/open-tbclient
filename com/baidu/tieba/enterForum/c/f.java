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
    private boolean ajA;
    private BarImageView ajC;
    private TextView ajE;
    private TextView ajF;
    private bl ajJ;
    private LikeModel fle;
    private TextView iLW;
    private TextView iLX;
    private TBSpecificationBtn iLY;
    private ae iMa;
    private TbPageContext<?> mTbPageContext;
    private View mView;
    private String attention = TbadkCoreApplication.getInst().getString(R.string.attention);
    private String iLZ = TbadkCoreApplication.getInst().getString(R.string.thread_str);

    public f(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.ajC = (BarImageView) this.mView.findViewById(R.id.bar_image);
        this.ajE = (TextView) this.mView.findViewById(R.id.bar_name);
        this.ajF = (TextView) this.mView.findViewById(R.id.desc);
        this.iLW = (TextView) this.mView.findViewById(R.id.follow_text);
        this.iLX = (TextView) this.mView.findViewById(R.id.tiezi_text);
        this.iLY = (TBSpecificationBtn) this.mView.findViewById(R.id.forum_like_button);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cwI();
            }
        });
        this.iLY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq aqVar = new aq("c13644");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.w("fid", f.this.ajJ.getForumId());
                aqVar.an("obj_locate", 1);
                aqVar.an(TiebaInitialize.Params.OBJ_TO, f.this.ajJ.isLike() ? 2 : 1);
                TiebaStatic.log(aqVar);
                if (f.this.ajJ.isLike()) {
                    f.this.cwK();
                } else {
                    f.this.cwJ();
                }
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bl blVar) {
        if (blVar != null) {
            this.ajJ = blVar;
            this.ajC.setShowOval(true);
            this.ajC.setShowOuterBorder(false);
            this.ajC.setShowInnerBorder(true);
            this.ajC.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.ajC.setStrokeColorResId(R.color.CAM_X0401);
            this.ajC.startLoad(blVar.getAvatar(), 10, false);
            String forumName = blVar.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            this.ajE.setText(forumName);
            this.iLW.setText(this.attention + " " + at.dZ(blVar.bmB()));
            this.iLX.setText(this.iLZ + " " + at.dZ(blVar.bmC()));
            String bkW = blVar.bkW();
            if (at.isEmpty(bkW)) {
                if (this.ajF.getVisibility() != 8) {
                    this.ajF.setVisibility(8);
                    if (this.ajE.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.ajE.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                        this.ajE.requestLayout();
                    }
                }
            } else {
                if (this.ajF.getVisibility() != 0) {
                    this.ajF.setVisibility(0);
                    if (this.ajE.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.ajE.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                        this.ajE.requestLayout();
                    }
                }
                this.ajF.setText(bkW);
            }
            pO(this.ajJ.isLike());
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.ajE, R.color.CAM_X0105);
        ao.setViewTextColor(this.iLW, R.color.CAM_X0109);
        ao.setViewTextColor(this.iLX, R.color.CAM_X0109);
        ao.setViewTextColor(this.ajF, R.color.CAM_X0109);
    }

    public void pO(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pM(R.color.CAM_X0302);
            this.iLY.setConfig(bVar);
            this.iLY.setText(this.attention);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pO(R.color.CAM_X0109);
            this.iLY.setConfig(bVar2);
            this.iLY.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.ajJ.setLike(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwI() {
        if (this.ajJ != null) {
            String forumName = this.ajJ.getForumName();
            if (at.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                aq aqVar = new aq("c13643");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.w("fid", this.ajJ.getForumId());
                aqVar.an("obj_locate", 1);
                aqVar.an("obj_type", this.ajA ? 4 : 1);
                TiebaStatic.log(aqVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwJ() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.ajJ != null && !StringUtils.isNull(this.ajJ.getForumName()) && this.ajJ.getForumId() > 0) {
            if (!bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.fle == null) {
                this.fle = new LikeModel(this.mTbPageContext);
            }
            this.fle.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.enterForum.c.f.3
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (f.this.fle.getErrorCode() == 22) {
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (f.this.fle.getErrorCode() != 0) {
                            l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.fle.getErrorString());
                            return;
                        }
                        f.this.pO(true);
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.attention_success));
                    }
                }
            });
            if (at.isForumName(this.ajJ.getForumName())) {
                this.fle.dKC();
                this.fle.gq(this.ajJ.getForumName(), String.valueOf(this.ajJ.getForumId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwK() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.ajJ != null && !StringUtils.isNull(this.ajJ.getForumName()) && this.ajJ.getForumId() > 0) {
            if (!bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.iMa == null) {
                this.iMa = new ae();
            }
            this.iMa.a(new ae.a() { // from class: com.baidu.tieba.enterForum.c.f.4
                @Override // com.baidu.tieba.tbadkCore.ae.a
                public void C(String str, long j) {
                    f.this.pO(false);
                    l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.un_attention_success));
                }

                @Override // com.baidu.tieba.tbadkCore.ae.a
                public void D(String str, long j) {
                }
            });
            this.iMa.P(this.ajJ.getForumName(), this.ajJ.getForumId());
        }
    }

    public void setHasLikeForum(boolean z) {
        this.ajA = z;
    }
}

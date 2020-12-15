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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ae;
/* loaded from: classes22.dex */
public class f {
    private boolean ajP;
    private BarImageView ajR;
    private TextView ajT;
    private TextView ajU;
    private bk ajY;
    private LikeModel fgf;
    private TextView iEr;
    private TextView iEs;
    private TBSpecificationBtn iEt;
    private ae iEv;
    private TbPageContext<?> mTbPageContext;
    private View mView;
    private String attention = TbadkCoreApplication.getInst().getString(R.string.attention);
    private String iEu = TbadkCoreApplication.getInst().getString(R.string.thread_str);

    public f(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.ajR = (BarImageView) this.mView.findViewById(R.id.bar_image);
        this.ajT = (TextView) this.mView.findViewById(R.id.bar_name);
        this.ajU = (TextView) this.mView.findViewById(R.id.desc);
        this.iEr = (TextView) this.mView.findViewById(R.id.follow_text);
        this.iEs = (TextView) this.mView.findViewById(R.id.tiezi_text);
        this.iEt = (TBSpecificationBtn) this.mView.findViewById(R.id.forum_like_button);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cxG();
            }
        });
        this.iEt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar arVar = new ar("c13644");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.w("fid", f.this.ajY.getForumId());
                arVar.al("obj_locate", 1);
                arVar.al(TiebaInitialize.Params.OBJ_TO, f.this.ajY.isLike() ? 2 : 1);
                TiebaStatic.log(arVar);
                if (f.this.ajY.isLike()) {
                    f.this.cxI();
                } else {
                    f.this.cxH();
                }
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bk bkVar) {
        if (bkVar != null) {
            this.ajY = bkVar;
            this.ajR.setShowOval(true);
            this.ajR.setShowOuterBorder(false);
            this.ajR.setShowInnerBorder(true);
            this.ajR.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.ajR.setStrokeColorResId(R.color.CAM_X0401);
            this.ajR.startLoad(bkVar.getAvatar(), 10, false);
            String forumName = bkVar.getForumName();
            if (au.isEmpty(forumName)) {
                forumName = "";
            }
            this.ajT.setText(forumName);
            this.iEr.setText(this.attention + " " + au.dZ(bkVar.bnT()));
            this.iEs.setText(this.iEu + " " + au.dZ(bkVar.bnU()));
            String bmo = bkVar.bmo();
            if (au.isEmpty(bmo)) {
                if (this.ajU.getVisibility() != 8) {
                    this.ajU.setVisibility(8);
                    if (this.ajT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.ajT.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                        this.ajT.requestLayout();
                    }
                }
            } else {
                if (this.ajU.getVisibility() != 0) {
                    this.ajU.setVisibility(0);
                    if (this.ajT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.ajT.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                        this.ajT.requestLayout();
                    }
                }
                this.ajU.setText(bmo);
            }
            pv(this.ajY.isLike());
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.ajT, R.color.CAM_X0105);
        ap.setViewTextColor(this.iEr, R.color.CAM_X0109);
        ap.setViewTextColor(this.iEs, R.color.CAM_X0109);
        ap.setViewTextColor(this.ajU, R.color.CAM_X0109);
    }

    public void pv(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.rh(R.color.CAM_X0302);
            this.iEt.setConfig(bVar);
            this.iEt.setText(this.attention);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.rj(R.color.CAM_X0109);
            this.iEt.setConfig(bVar2);
            this.iEt.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.ajY.setLike(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxG() {
        if (this.ajY != null) {
            String forumName = this.ajY.getForumName();
            if (au.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                ar arVar = new ar("c13643");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.w("fid", this.ajY.getForumId());
                arVar.al("obj_locate", 1);
                arVar.al("obj_type", this.ajP ? 4 : 1);
                TiebaStatic.log(arVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxH() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.ajY != null && !StringUtils.isNull(this.ajY.getForumName()) && this.ajY.getForumId() > 0) {
            if (!bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.fgf == null) {
                this.fgf = new LikeModel(this.mTbPageContext);
            }
            this.fgf.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.d.f.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (f.this.fgf.getErrorCode() == 22) {
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (f.this.fgf.getErrorCode() != 0) {
                            l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.fgf.getErrorString());
                            return;
                        }
                        f.this.pv(true);
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.attention_success));
                    }
                }
            });
            if (au.isForumName(this.ajY.getForumName())) {
                this.fgf.dOB();
                this.fgf.gu(this.ajY.getForumName(), String.valueOf(this.ajY.getForumId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxI() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.ajY != null && !StringUtils.isNull(this.ajY.getForumName()) && this.ajY.getForumId() > 0) {
            if (!bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.iEv == null) {
                this.iEv = new ae();
            }
            this.iEv.a(new ae.a() { // from class: com.baidu.tieba.enterForum.d.f.4
                @Override // com.baidu.tieba.tbadkCore.ae.a
                public void C(String str, long j) {
                    f.this.pv(false);
                    l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.un_attention_success));
                }

                @Override // com.baidu.tieba.tbadkCore.ae.a
                public void D(String str, long j) {
                }
            });
            this.iEv.O(this.ajY.getForumName(), this.ajY.getForumId());
        }
    }

    public void setHasLikeForum(boolean z) {
        this.ajP = z;
    }
}

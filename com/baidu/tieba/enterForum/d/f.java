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
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tieba.tbadkCore.ad;
/* loaded from: classes21.dex */
public class f {
    private boolean aiQ;
    private BarImageView aiS;
    private TextView aiU;
    private TextView aiV;
    private bj aiZ;
    private LikeModel eYI;
    private ad itB;
    private TextView itx;
    private TextView ity;
    private TBSpecificationBtn itz;
    private TbPageContext<?> mTbPageContext;
    private View mView;
    private String attention = TbadkCoreApplication.getInst().getString(R.string.attention);
    private String itA = TbadkCoreApplication.getInst().getString(R.string.thread_str);

    public f(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.aiS = (BarImageView) this.mView.findViewById(R.id.bar_image);
        this.aiU = (TextView) this.mView.findViewById(R.id.bar_name);
        this.aiV = (TextView) this.mView.findViewById(R.id.desc);
        this.itx = (TextView) this.mView.findViewById(R.id.follow_text);
        this.ity = (TextView) this.mView.findViewById(R.id.tiezi_text);
        this.itz = (TBSpecificationBtn) this.mView.findViewById(R.id.forum_like_button);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.ctq();
            }
        });
        this.itz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar arVar = new ar("c13644");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.w("fid", f.this.aiZ.getForumId());
                arVar.ak("obj_locate", 1);
                arVar.ak(TiebaInitialize.Params.OBJ_TO, f.this.aiZ.isLike() ? 2 : 1);
                TiebaStatic.log(arVar);
                if (f.this.aiZ.isLike()) {
                    f.this.cts();
                } else {
                    f.this.ctr();
                }
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bj bjVar) {
        if (bjVar != null) {
            this.aiZ = bjVar;
            this.aiS.setShowOval(true);
            this.aiS.setShowOuterBorder(false);
            this.aiS.setShowInnerBorder(true);
            this.aiS.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.aiS.setStrokeColorResId(R.color.CAM_X0401);
            this.aiS.startLoad(bjVar.getAvatar(), 10, false);
            String forumName = bjVar.getForumName();
            if (au.isEmpty(forumName)) {
                forumName = "";
            }
            this.aiU.setText(forumName);
            this.itx.setText(this.attention + " " + au.dA(bjVar.bkG()));
            this.ity.setText(this.itA + " " + au.dA(bjVar.bkH()));
            String bje = bjVar.bje();
            if (au.isEmpty(bje)) {
                if (this.aiV.getVisibility() != 8) {
                    this.aiV.setVisibility(8);
                    if (this.aiU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.aiU.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                        this.aiU.requestLayout();
                    }
                }
            } else {
                if (this.aiV.getVisibility() != 0) {
                    this.aiV.setVisibility(0);
                    if (this.aiU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.aiU.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                        this.aiU.requestLayout();
                    }
                }
                this.aiV.setText(bje);
            }
            oZ(this.aiZ.isLike());
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.aiU, R.color.CAM_X0105);
        ap.setViewTextColor(this.itx, R.color.CAM_X0109);
        ap.setViewTextColor(this.ity, R.color.CAM_X0109);
        ap.setViewTextColor(this.aiV, R.color.CAM_X0109);
    }

    public void oZ(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.qG(R.color.CAM_X0302);
            this.itz.setConfig(bVar);
            this.itz.setText(this.attention);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.qI(R.color.CAM_X0109);
            this.itz.setConfig(bVar2);
            this.itz.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.aiZ.setLike(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctq() {
        if (this.aiZ != null) {
            String forumName = this.aiZ.getForumName();
            if (au.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                ar arVar = new ar("c13643");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.w("fid", this.aiZ.getForumId());
                arVar.ak("obj_locate", 1);
                arVar.ak("obj_type", this.aiQ ? 4 : 1);
                TiebaStatic.log(arVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctr() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.aiZ != null && !StringUtils.isNull(this.aiZ.getForumName()) && this.aiZ.getForumId() > 0) {
            if (!bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.eYI == null) {
                this.eYI = new LikeModel(this.mTbPageContext);
            }
            this.eYI.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.d.f.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (f.this.eYI.getErrorCode() == 22) {
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (f.this.eYI.getErrorCode() != 0) {
                            l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.eYI.getErrorString());
                            return;
                        }
                        f.this.oZ(true);
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.attention_success));
                    }
                }
            });
            if (au.isForumName(this.aiZ.getForumName())) {
                this.eYI.dJj();
                this.eYI.gp(this.aiZ.getForumName(), String.valueOf(this.aiZ.getForumId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cts() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.aiZ != null && !StringUtils.isNull(this.aiZ.getForumName()) && this.aiZ.getForumId() > 0) {
            if (!bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.itB == null) {
                this.itB = new ad();
            }
            this.itB.a(new ad.a() { // from class: com.baidu.tieba.enterForum.d.f.4
                @Override // com.baidu.tieba.tbadkCore.ad.a
                public void C(String str, long j) {
                    f.this.oZ(false);
                    l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.un_attention_success));
                }

                @Override // com.baidu.tieba.tbadkCore.ad.a
                public void D(String str, long j) {
                }
            });
            this.itB.O(this.aiZ.getForumName(), this.aiZ.getForumId());
        }
    }

    public void setHasLikeForum(boolean z) {
        this.aiQ = z;
    }
}

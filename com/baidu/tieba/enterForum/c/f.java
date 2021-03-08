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
import com.baidu.tbadk.core.data.bn;
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
/* loaded from: classes2.dex */
public class f {
    private boolean akH;
    private BarImageView akJ;
    private TextView akL;
    private TextView akM;
    private bn akQ;
    private LikeModel foW;
    private TextView iTB;
    private TextView iTC;
    private TBSpecificationBtn iTD;
    private ae iTF;
    private TbPageContext<?> mTbPageContext;
    private View mView;
    private String attention = TbadkCoreApplication.getInst().getString(R.string.attention);
    private String iTE = TbadkCoreApplication.getInst().getString(R.string.thread_str);

    public f(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.akJ = (BarImageView) this.mView.findViewById(R.id.bar_image);
        this.akL = (TextView) this.mView.findViewById(R.id.bar_name);
        this.akM = (TextView) this.mView.findViewById(R.id.desc);
        this.iTB = (TextView) this.mView.findViewById(R.id.follow_text);
        this.iTC = (TextView) this.mView.findViewById(R.id.tiezi_text);
        this.iTD = (TBSpecificationBtn) this.mView.findViewById(R.id.forum_like_button);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cyh();
            }
        });
        this.iTD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar arVar = new ar("c13644");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.v("fid", f.this.akQ.getForumId());
                arVar.aq("obj_locate", 1);
                arVar.aq(TiebaInitialize.Params.OBJ_TO, f.this.akQ.isLike() ? 2 : 1);
                TiebaStatic.log(arVar);
                if (f.this.akQ.isLike()) {
                    f.this.cyj();
                } else {
                    f.this.cyi();
                }
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bn bnVar) {
        if (bnVar != null) {
            this.akQ = bnVar;
            this.akJ.setShowOval(true);
            this.akJ.setShowOuterBorder(false);
            this.akJ.setShowInnerBorder(true);
            this.akJ.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.akJ.setStrokeColorResId(R.color.CAM_X0401);
            this.akJ.startLoad(bnVar.getAvatar(), 10, false);
            String forumName = bnVar.getForumName();
            if (au.isEmpty(forumName)) {
                forumName = "";
            }
            this.akL.setText(forumName);
            this.iTB.setText(this.attention + " " + au.ef(bnVar.bmW()));
            this.iTC.setText(this.iTE + " " + au.ef(bnVar.bmX()));
            String blq = bnVar.blq();
            if (au.isEmpty(blq)) {
                if (this.akM.getVisibility() != 8) {
                    this.akM.setVisibility(8);
                    if (this.akL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.akL.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                        this.akL.requestLayout();
                    }
                }
            } else {
                if (this.akM.getVisibility() != 0) {
                    this.akM.setVisibility(0);
                    if (this.akL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.akL.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                        this.akL.requestLayout();
                    }
                }
                this.akM.setText(blq);
            }
            pY(this.akQ.isLike());
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.akL, R.color.CAM_X0105);
        ap.setViewTextColor(this.iTB, R.color.CAM_X0109);
        ap.setViewTextColor(this.iTC, R.color.CAM_X0109);
        ap.setViewTextColor(this.akM, R.color.CAM_X0109);
    }

    public void pY(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pS(R.color.CAM_X0302);
            this.iTD.setConfig(bVar);
            this.iTD.setText(this.attention);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pU(R.color.CAM_X0109);
            this.iTD.setConfig(bVar2);
            this.iTD.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.akQ.setLike(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyh() {
        if (this.akQ != null) {
            String forumName = this.akQ.getForumName();
            if (au.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                ar arVar = new ar("c13643");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.v("fid", this.akQ.getForumId());
                arVar.aq("obj_locate", 1);
                arVar.aq("obj_type", this.akH ? 4 : 1);
                TiebaStatic.log(arVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyi() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.akQ != null && !StringUtils.isNull(this.akQ.getForumName()) && this.akQ.getForumId() > 0) {
            if (!bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.foW == null) {
                this.foW = new LikeModel(this.mTbPageContext);
            }
            this.foW.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.enterForum.c.f.3
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (f.this.foW.getErrorCode() == 22) {
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (f.this.foW.getErrorCode() != 0) {
                            l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.foW.getErrorString());
                            return;
                        }
                        f.this.pY(true);
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.attention_success));
                    }
                }
            });
            if (au.isForumName(this.akQ.getForumName())) {
                this.foW.dNd();
                this.foW.gy(this.akQ.getForumName(), String.valueOf(this.akQ.getForumId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyj() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.akQ != null && !StringUtils.isNull(this.akQ.getForumName()) && this.akQ.getForumId() > 0) {
            if (!bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.iTF == null) {
                this.iTF = new ae();
            }
            this.iTF.a(new ae.a() { // from class: com.baidu.tieba.enterForum.c.f.4
                @Override // com.baidu.tieba.tbadkCore.ae.a
                public void B(String str, long j) {
                    f.this.pY(false);
                    l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.un_attention_success));
                }

                @Override // com.baidu.tieba.tbadkCore.ae.a
                public void C(String str, long j) {
                }
            });
            this.iTF.O(this.akQ.getForumName(), this.akQ.getForumId());
        }
    }

    public void setHasLikeForum(boolean z) {
        this.akH = z;
    }
}

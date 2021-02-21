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
    private boolean ajp;
    private BarImageView ajr;
    private TextView ajt;
    private TextView aju;
    private bn ajy;
    private LikeModel fnw;
    private TextView iRS;
    private TextView iRT;
    private TBSpecificationBtn iRU;
    private ae iRW;
    private TbPageContext<?> mTbPageContext;
    private View mView;
    private String attention = TbadkCoreApplication.getInst().getString(R.string.attention);
    private String iRV = TbadkCoreApplication.getInst().getString(R.string.thread_str);

    public f(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.ajr = (BarImageView) this.mView.findViewById(R.id.bar_image);
        this.ajt = (TextView) this.mView.findViewById(R.id.bar_name);
        this.aju = (TextView) this.mView.findViewById(R.id.desc);
        this.iRS = (TextView) this.mView.findViewById(R.id.follow_text);
        this.iRT = (TextView) this.mView.findViewById(R.id.tiezi_text);
        this.iRU = (TBSpecificationBtn) this.mView.findViewById(R.id.forum_like_button);
        this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cyb();
            }
        });
        this.iRU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar arVar = new ar("c13644");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.v("fid", f.this.ajy.getForumId());
                arVar.ap("obj_locate", 1);
                arVar.ap(TiebaInitialize.Params.OBJ_TO, f.this.ajy.isLike() ? 2 : 1);
                TiebaStatic.log(arVar);
                if (f.this.ajy.isLike()) {
                    f.this.cyd();
                } else {
                    f.this.cyc();
                }
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bn bnVar) {
        if (bnVar != null) {
            this.ajy = bnVar;
            this.ajr.setShowOval(true);
            this.ajr.setShowOuterBorder(false);
            this.ajr.setShowInnerBorder(true);
            this.ajr.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.ajr.setStrokeColorResId(R.color.CAM_X0401);
            this.ajr.startLoad(bnVar.getAvatar(), 10, false);
            String forumName = bnVar.getForumName();
            if (au.isEmpty(forumName)) {
                forumName = "";
            }
            this.ajt.setText(forumName);
            this.iRS.setText(this.attention + " " + au.ef(bnVar.bmU()));
            this.iRT.setText(this.iRV + " " + au.ef(bnVar.bmV()));
            String blo = bnVar.blo();
            if (au.isEmpty(blo)) {
                if (this.aju.getVisibility() != 8) {
                    this.aju.setVisibility(8);
                    if (this.ajt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.ajt.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                        this.ajt.requestLayout();
                    }
                }
            } else {
                if (this.aju.getVisibility() != 0) {
                    this.aju.setVisibility(0);
                    if (this.ajt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.ajt.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                        this.ajt.requestLayout();
                    }
                }
                this.aju.setText(blo);
            }
            pY(this.ajy.isLike());
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.ajt, R.color.CAM_X0105);
        ap.setViewTextColor(this.iRS, R.color.CAM_X0109);
        ap.setViewTextColor(this.iRT, R.color.CAM_X0109);
        ap.setViewTextColor(this.aju, R.color.CAM_X0109);
    }

    public void pY(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pR(R.color.CAM_X0302);
            this.iRU.setConfig(bVar);
            this.iRU.setText(this.attention);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pT(R.color.CAM_X0109);
            this.iRU.setConfig(bVar2);
            this.iRU.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.ajy.setLike(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyb() {
        if (this.ajy != null) {
            String forumName = this.ajy.getForumName();
            if (au.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                ar arVar = new ar("c13643");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.v("fid", this.ajy.getForumId());
                arVar.ap("obj_locate", 1);
                arVar.ap("obj_type", this.ajp ? 4 : 1);
                TiebaStatic.log(arVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyc() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.ajy != null && !StringUtils.isNull(this.ajy.getForumName()) && this.ajy.getForumId() > 0) {
            if (!bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.fnw == null) {
                this.fnw = new LikeModel(this.mTbPageContext);
            }
            this.fnw.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.enterForum.c.f.3
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (f.this.fnw.getErrorCode() == 22) {
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (f.this.fnw.getErrorCode() != 0) {
                            l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.fnw.getErrorString());
                            return;
                        }
                        f.this.pY(true);
                        l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.attention_success));
                    }
                }
            });
            if (au.isForumName(this.ajy.getForumName())) {
                this.fnw.dMV();
                this.fnw.gy(this.ajy.getForumName(), String.valueOf(this.ajy.getForumId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyd() {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (this.ajy != null && !StringUtils.isNull(this.ajy.getForumName()) && this.ajy.getForumId() > 0) {
            if (!bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.iRW == null) {
                this.iRW = new ae();
            }
            this.iRW.a(new ae.a() { // from class: com.baidu.tieba.enterForum.c.f.4
                @Override // com.baidu.tieba.tbadkCore.ae.a
                public void B(String str, long j) {
                    f.this.pY(false);
                    l.showToast(f.this.mTbPageContext.getPageActivity(), f.this.mTbPageContext.getString(R.string.un_attention_success));
                }

                @Override // com.baidu.tieba.tbadkCore.ae.a
                public void C(String str, long j) {
                }
            });
            this.iRW.O(this.ajy.getForumName(), this.ajy.getForumId());
        }
    }

    public void setHasLikeForum(boolean z) {
        this.ajp = z;
    }
}

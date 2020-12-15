package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.recommend.b.c> {
    private TbPageContext eNx;
    private LikeModel fgf;
    private RecommendForumItemView izX;
    private RecommendForumItemView izY;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eNx = tbPageContext;
        initUI();
        this.izX.setForumItemClickListener(new RecommendForumItemView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.b.1
            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void d(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.a(bVar, b.this.izX);
            }

            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void e(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.c(bVar);
            }
        });
        this.izY.setForumItemClickListener(new RecommendForumItemView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.b.2
            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void d(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.a(bVar, b.this.izY);
            }

            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void e(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.c(bVar);
            }
        });
    }

    private void initUI() {
        View view = getView();
        this.izX = (RecommendForumItemView) view.findViewById(R.id.reommend_forum_one);
        this.izY = (RecommendForumItemView) view.findViewById(R.id.reommend_forum_two);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        this.izX.onChangeSkinType();
        this.izY.onChangeSkinType();
        ap.setBackgroundColor(getView(), R.color.CAM_X0205);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.c cVar) {
        if (cVar != null) {
            onChangeSkinType(this.eNx, this.mSkinType);
            if (cVar.iyO != null) {
                this.izX.setVisibility(0);
                this.izX.f(cVar.iyO);
            } else {
                this.izX.setVisibility(4);
            }
            if (cVar.iyP != null) {
                this.izY.setVisibility(0);
                this.izY.f(cVar.iyP);
                return;
            }
            this.izY.setVisibility(4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        if (this.fgf != null) {
            this.fgf.dOB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.enterForum.recommend.b.b bVar, final RecommendForumItemView recommendForumItemView) {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (bVar != null && !StringUtils.isNull(bVar.forumName) && bVar.forumId > 0) {
            if (!bh.checkUpIsLogin(getContext())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.fgf == null) {
                this.fgf = new LikeModel(this.eNx);
            }
            this.fgf.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.recommend.view.b.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (b.this.fgf.getErrorCode() == 22) {
                        l.showToast(b.this.eNx.getPageActivity(), b.this.eNx.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (b.this.fgf.getErrorCode() != 0) {
                            l.showToast(b.this.eNx.getPageActivity(), b.this.fgf.getErrorString());
                            return;
                        }
                        if (recommendForumItemView == b.this.izX) {
                            b.this.izX.pv(true);
                        } else {
                            b.this.izY.pv(true);
                        }
                        l.showToast(b.this.eNx.getPageActivity(), b.this.eNx.getString(R.string.attention_success));
                    }
                }
            });
            if (au.isForumName(bVar.forumName)) {
                this.fgf.gu(bVar.forumName, String.valueOf(bVar.forumId));
            }
            a(bVar, "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        this.eNx.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eNx.getPageActivity()).createNormalCfg(bVar.forumName, FrsActivityConfig.FRS_FROM_TAB_RECOMMEND_FORUM).setCallFrom(11)));
        a(bVar, "2");
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.b bVar, String str) {
        if (bVar != null) {
            ar arVar = new ar("c13375");
            arVar.dY("obj_type", String.valueOf(bVar.iyM));
            arVar.w("fid", bVar.forumId);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.dY("obj_locate", str);
            TiebaStatic.log(arVar);
        }
    }
}

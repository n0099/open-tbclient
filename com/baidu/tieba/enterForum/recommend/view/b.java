package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import com.baidu.adp.base.e;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.recommend.b.c> {
    private TbPageContext eXu;
    private LikeModel fpO;
    private RecommendForumItemView iMk;
    private RecommendForumItemView iMl;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eXu = tbPageContext;
        initUI();
        this.iMk.setForumItemClickListener(new RecommendForumItemView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.b.1
            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void d(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.a(bVar, b.this.iMk);
            }

            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void e(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.c(bVar);
            }
        });
        this.iMl.setForumItemClickListener(new RecommendForumItemView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.b.2
            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void d(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.a(bVar, b.this.iMl);
            }

            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void e(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.c(bVar);
            }
        });
    }

    private void initUI() {
        View view = getView();
        this.iMk = (RecommendForumItemView) view.findViewById(R.id.reommend_forum_one);
        this.iMl = (RecommendForumItemView) view.findViewById(R.id.reommend_forum_two);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        this.iMk.onChangeSkinType();
        this.iMl.onChangeSkinType();
        ao.setBackgroundColor(getView(), R.color.CAM_X0205);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.c cVar) {
        if (cVar != null) {
            onChangeSkinType(this.eXu, this.mSkinType);
            if (cVar.iLb != null) {
                this.iMk.setVisibility(0);
                this.iMk.f(cVar.iLb);
            } else {
                this.iMk.setVisibility(4);
            }
            if (cVar.iLc != null) {
                this.iMl.setVisibility(0);
                this.iMl.f(cVar.iLc);
                return;
            }
            this.iMl.setVisibility(4);
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
        if (this.fpO != null) {
            this.fpO.dOt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.enterForum.recommend.b.b bVar, final RecommendForumItemView recommendForumItemView) {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (bVar != null && !StringUtils.isNull(bVar.forumName) && bVar.forumId > 0) {
            if (!bg.checkUpIsLogin(getContext())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.fpO == null) {
                this.fpO = new LikeModel(this.eXu);
            }
            this.fpO.setLoadDataCallBack(new e() { // from class: com.baidu.tieba.enterForum.recommend.view.b.3
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (b.this.fpO.getErrorCode() == 22) {
                        l.showToast(b.this.eXu.getPageActivity(), b.this.eXu.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (b.this.fpO.getErrorCode() != 0) {
                            l.showToast(b.this.eXu.getPageActivity(), b.this.fpO.getErrorString());
                            return;
                        }
                        if (recommendForumItemView == b.this.iMk) {
                            b.this.iMk.pS(true);
                        } else {
                            b.this.iMl.pS(true);
                        }
                        l.showToast(b.this.eXu.getPageActivity(), b.this.eXu.getString(R.string.attention_success));
                    }
                }
            });
            if (at.isForumName(bVar.forumName)) {
                this.fpO.gr(bVar.forumName, String.valueOf(bVar.forumId));
            }
            a(bVar, "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eXu.getPageActivity()).createNormalCfg(bVar.forumName, FrsActivityConfig.FRS_FROM_TAB_RECOMMEND_FORUM).setCallFrom(11)));
        a(bVar, "2");
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.b bVar, String str) {
        if (bVar != null) {
            aq aqVar = new aq("c13375");
            aqVar.dX("obj_type", String.valueOf(bVar.iKZ));
            aqVar.w("fid", bVar.forumId);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.dX("obj_locate", str);
            TiebaStatic.log(aqVar);
        }
    }
}

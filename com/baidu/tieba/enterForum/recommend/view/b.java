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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes21.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.recommend.b.c> {
    private TbPageContext ehG;
    private LikeModel ezi;
    private RecommendForumItemView hGV;
    private RecommendForumItemView hGW;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ehG = tbPageContext;
        initUI();
        this.hGV.setForumItemClickListener(new RecommendForumItemView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.b.1
            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void d(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.a(bVar, b.this.hGV);
            }

            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void e(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.c(bVar);
            }
        });
        this.hGW.setForumItemClickListener(new RecommendForumItemView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.b.2
            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void d(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.a(bVar, b.this.hGW);
            }

            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void e(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.c(bVar);
            }
        });
    }

    private void initUI() {
        View view = getView();
        this.hGV = (RecommendForumItemView) view.findViewById(R.id.reommend_forum_one);
        this.hGW = (RecommendForumItemView) view.findViewById(R.id.reommend_forum_two);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        this.hGV.onChangeSkinType();
        this.hGW.onChangeSkinType();
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.c cVar) {
        if (cVar != null) {
            onChangeSkinType(this.ehG, this.mSkinType);
            if (cVar.hFM != null) {
                this.hGV.setVisibility(0);
                this.hGV.f(cVar.hFM);
            } else {
                this.hGV.setVisibility(4);
            }
            if (cVar.hFN != null) {
                this.hGW.setVisibility(0);
                this.hGW.f(cVar.hFN);
                return;
            }
            this.hGW.setVisibility(4);
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
        if (this.ezi != null) {
            this.ezi.dzW();
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
            if (this.ezi == null) {
                this.ezi = new LikeModel(this.ehG);
            }
            this.ezi.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.recommend.view.b.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (b.this.ezi.getErrorCode() == 22) {
                        l.showToast(b.this.ehG.getPageActivity(), b.this.ehG.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (b.this.ezi.getErrorCode() != 0) {
                            l.showToast(b.this.ehG.getPageActivity(), b.this.ezi.getErrorString());
                            return;
                        }
                        if (recommendForumItemView == b.this.hGV) {
                            b.this.hGV.nQ(true);
                        } else {
                            b.this.hGW.nQ(true);
                        }
                        l.showToast(b.this.ehG.getPageActivity(), b.this.ehG.getString(R.string.attention_success));
                    }
                }
            });
            if (at.isForumName(bVar.forumName)) {
                this.ezi.gd(bVar.forumName, String.valueOf(bVar.forumId));
            }
            a(bVar, "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        this.ehG.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ehG.getPageActivity()).createNormalCfg(bVar.forumName, FrsActivityConfig.FRS_FROM_TAB_RECOMMEND_FORUM).setCallFrom(11)));
        a(bVar, "2");
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.b bVar, String str) {
        if (bVar != null) {
            aq aqVar = new aq("c13375");
            aqVar.dF("obj_type", String.valueOf(bVar.hFK));
            aqVar.u("fid", bVar.forumId);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.dF("obj_locate", str);
            TiebaStatic.log(aqVar);
        }
    }
}

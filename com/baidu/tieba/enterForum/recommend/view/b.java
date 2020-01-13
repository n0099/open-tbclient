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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes7.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.enterForum.recommend.b.c> {
    private TbPageContext cRe;
    private LikeModel dfN;
    private RecommendForumItemView fWb;
    private RecommendForumItemView fWc;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cRe = tbPageContext;
        initUI();
        this.fWb.setForumItemClickListener(new RecommendForumItemView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.b.1
            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void d(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.a(bVar, b.this.fWb);
            }

            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void e(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.c(bVar);
            }
        });
        this.fWc.setForumItemClickListener(new RecommendForumItemView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.b.2
            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void d(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.a(bVar, b.this.fWc);
            }

            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void e(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.c(bVar);
            }
        });
    }

    private void initUI() {
        View view = getView();
        this.fWb = (RecommendForumItemView) view.findViewById(R.id.reommend_forum_one);
        this.fWc = (RecommendForumItemView) view.findViewById(R.id.reommend_forum_two);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        this.fWb.onChangeSkinType();
        this.fWc.onChangeSkinType();
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.enterForum.recommend.b.c cVar) {
        if (cVar != null) {
            onChangeSkinType(this.cRe, this.mSkinType);
            if (cVar.fUT != null) {
                this.fWb.setVisibility(0);
                this.fWb.f(cVar.fUT);
            } else {
                this.fWb.setVisibility(4);
            }
            if (cVar.fUU != null) {
                this.fWc.setVisibility(0);
                this.fWc.f(cVar.fUU);
                return;
            }
            this.fWc.setVisibility(4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.recommend_forum_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        if (this.dfN != null) {
            this.dfN.cIM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.enterForum.recommend.b.b bVar, final RecommendForumItemView recommendForumItemView) {
        if (!l.isNetOk()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (bVar != null && !StringUtils.isNull(bVar.forumName) && bVar.forumId > 0) {
            if (!bc.checkUpIsLogin(getContext())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                return;
            }
            if (this.dfN == null) {
                this.dfN = new LikeModel(this.cRe);
            }
            this.dfN.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.recommend.view.b.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (b.this.dfN.getErrorCode() == 22) {
                        l.showToast(b.this.cRe.getPageActivity(), b.this.cRe.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (b.this.dfN.getErrorCode() != 0) {
                            l.showToast(b.this.cRe.getPageActivity(), b.this.dfN.getErrorString());
                            return;
                        }
                        if (recommendForumItemView == b.this.fWb) {
                            b.this.fWb.kI(true);
                        } else {
                            b.this.fWc.kI(true);
                        }
                        l.showToast(b.this.cRe.getPageActivity(), b.this.cRe.getString(R.string.attention_success));
                    }
                }
            });
            if (aq.isForumName(bVar.forumName)) {
                this.dfN.et(bVar.forumName, String.valueOf(bVar.forumId));
            }
            a(bVar, "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        this.cRe.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cRe.getPageActivity()).createNormalCfg(bVar.forumName, FrsActivityConfig.FRS_FROM_TAB_RECOMMEND_FORUM).setCallFrom(11)));
        a(bVar, "2");
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.b bVar, String str) {
        if (bVar != null) {
            an anVar = new an("c13375");
            anVar.cp("obj_type", String.valueOf(bVar.fUR));
            anVar.s("fid", bVar.forumId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.cp("obj_locate", str);
            TiebaStatic.log(anVar);
        }
    }
}

package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.enterForum.recommend.b.c> {
    private LikeModel ccn;
    private RecommendForumItemView eVA;
    private RecommendForumItemView eVB;
    private TbPageContext mContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mContext = tbPageContext;
        initUI();
        this.eVA.setForumItemClickListener(new RecommendForumItemView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.b.1
            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void d(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.a(bVar, b.this.eVA);
            }

            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void e(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.c(bVar);
            }
        });
        this.eVB.setForumItemClickListener(new RecommendForumItemView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.b.2
            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void d(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.a(bVar, b.this.eVB);
            }

            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void e(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.c(bVar);
            }
        });
    }

    private void initUI() {
        View view = getView();
        this.eVA = (RecommendForumItemView) view.findViewById(R.id.reommend_forum_one);
        this.eVB = (RecommendForumItemView) view.findViewById(R.id.reommend_forum_two);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        this.eVA.onChangeSkinType();
        this.eVB.onChangeSkinType();
        al.l(getView(), R.color.cp_bg_line_c);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.enterForum.recommend.b.c cVar) {
        if (cVar != null) {
            onChangeSkinType(this.mContext, this.mSkinType);
            if (cVar.eUr != null) {
                this.eVA.setVisibility(0);
                this.eVA.f(cVar.eUr);
            } else {
                this.eVA.setVisibility(4);
            }
            if (cVar.eUs != null) {
                this.eVB.setVisibility(0);
                this.eVB.f(cVar.eUs);
                return;
            }
            this.eVB.setVisibility(4);
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
        if (this.ccn != null) {
            this.ccn.clL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.enterForum.recommend.b.b bVar, final RecommendForumItemView recommendForumItemView) {
        if (!l.ki()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (bVar != null && !StringUtils.isNull(bVar.forumName) && bVar.forumId > 0) {
            if (!bc.cE(getContext())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.ccn == null) {
                this.ccn = new LikeModel(this.mContext);
            }
            this.ccn.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.recommend.view.b.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (b.this.ccn.getErrorCode() == 22) {
                        l.showToast(b.this.mContext.getPageActivity(), b.this.mContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (b.this.ccn.getErrorCode() != 0) {
                            l.showToast(b.this.mContext.getPageActivity(), b.this.ccn.getErrorString());
                            return;
                        }
                        if (recommendForumItemView == b.this.eVA) {
                            b.this.eVA.jj(true);
                        } else {
                            b.this.eVB.jj(true);
                        }
                        l.showToast(b.this.mContext.getPageActivity(), b.this.mContext.getString(R.string.attention_success));
                    }
                }
            });
            if (ap.bf(bVar.forumName)) {
                this.ccn.ek(bVar.forumName, String.valueOf(bVar.forumId));
            }
            a(bVar, "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        this.mContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext.getPageActivity()).createNormalCfg(bVar.forumName, FrsActivityConfig.FRS_FROM_TAB_RECOMMEND_FORUM).setCallFrom(11)));
        a(bVar, "2");
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.b bVar, String str) {
        if (bVar != null) {
            am amVar = new am("c13375");
            amVar.bT("obj_type", String.valueOf(bVar.eUp));
            amVar.l("fid", bVar.forumId);
            amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.bT("obj_locate", str);
            TiebaStatic.log(amVar);
        }
    }
}

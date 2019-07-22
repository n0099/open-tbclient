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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.enterForum.recommend.b.c> {
    private LikeModel cdr;
    private RecommendForumItemView faB;
    private RecommendForumItemView faC;
    private TbPageContext mContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mContext = tbPageContext;
        initUI();
        this.faB.setForumItemClickListener(new RecommendForumItemView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.b.1
            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void d(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.a(bVar, b.this.faB);
            }

            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void e(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.c(bVar);
            }
        });
        this.faC.setForumItemClickListener(new RecommendForumItemView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.b.2
            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void d(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.a(bVar, b.this.faC);
            }

            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void e(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.c(bVar);
            }
        });
    }

    private void initUI() {
        View view = getView();
        this.faB = (RecommendForumItemView) view.findViewById(R.id.reommend_forum_one);
        this.faC = (RecommendForumItemView) view.findViewById(R.id.reommend_forum_two);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        this.faB.onChangeSkinType();
        this.faC.onChangeSkinType();
        am.l(getView(), R.color.cp_bg_line_c);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.enterForum.recommend.b.c cVar) {
        if (cVar != null) {
            onChangeSkinType(this.mContext, this.mSkinType);
            if (cVar.eZs != null) {
                this.faB.setVisibility(0);
                this.faB.f(cVar.eZs);
            } else {
                this.faB.setVisibility(4);
            }
            if (cVar.eZt != null) {
                this.faC.setVisibility(0);
                this.faC.f(cVar.eZt);
                return;
            }
            this.faC.setVisibility(4);
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
        if (this.cdr != null) {
            this.cdr.coE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.enterForum.recommend.b.b bVar, final RecommendForumItemView recommendForumItemView) {
        if (!l.kt()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
        } else if (bVar != null && !StringUtils.isNull(bVar.forumName) && bVar.forumId > 0) {
            if (!bd.cF(getContext())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.cdr == null) {
                this.cdr = new LikeModel(this.mContext);
            }
            this.cdr.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.recommend.view.b.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (b.this.cdr.getErrorCode() == 22) {
                        l.showToast(b.this.mContext.getPageActivity(), b.this.mContext.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (b.this.cdr.getErrorCode() != 0) {
                            l.showToast(b.this.mContext.getPageActivity(), b.this.cdr.getErrorString());
                            return;
                        }
                        if (recommendForumItemView == b.this.faB) {
                            b.this.faB.jt(true);
                        } else {
                            b.this.faC.jt(true);
                        }
                        l.showToast(b.this.mContext.getPageActivity(), b.this.mContext.getString(R.string.attention_success));
                    }
                }
            });
            if (aq.bg(bVar.forumName)) {
                this.cdr.el(bVar.forumName, String.valueOf(bVar.forumId));
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
            an anVar = new an("c13375");
            anVar.bT("obj_type", String.valueOf(bVar.eZq));
            anVar.l("fid", bVar.forumId);
            anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.bT("obj_locate", str);
            TiebaStatic.log(anVar);
        }
    }
}

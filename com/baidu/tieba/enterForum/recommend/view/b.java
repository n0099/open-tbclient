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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.enterForum.recommend.b.c> {
    private LikeModel bUs;
    private RecommendForumItemView eFE;
    private RecommendForumItemView eFF;
    private TbPageContext mContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mContext = tbPageContext;
        initUI();
        this.eFE.setForumItemClickListener(new RecommendForumItemView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.b.1
            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void d(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.a(bVar, b.this.eFE);
            }

            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void e(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.c(bVar);
            }
        });
        this.eFF.setForumItemClickListener(new RecommendForumItemView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.b.2
            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void d(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.a(bVar, b.this.eFF);
            }

            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void e(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.c(bVar);
            }
        });
    }

    private void initUI() {
        View view = getView();
        this.eFE = (RecommendForumItemView) view.findViewById(d.g.reommend_forum_one);
        this.eFF = (RecommendForumItemView) view.findViewById(d.g.reommend_forum_two);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        this.eFE.onChangeSkinType();
        this.eFF.onChangeSkinType();
        al.l(getView(), d.C0277d.cp_bg_line_c);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.enterForum.recommend.b.c cVar) {
        if (cVar != null) {
            onChangeSkinType(this.mContext, this.mSkinType);
            if (cVar.eEv != null) {
                this.eFE.setVisibility(0);
                this.eFE.f(cVar.eEv);
            } else {
                this.eFE.setVisibility(4);
            }
            if (cVar.eEw != null) {
                this.eFF.setVisibility(0);
                this.eFF.f(cVar.eEw);
                return;
            }
            this.eFF.setVisibility(4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.recommend_forum_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        if (this.bUs != null) {
            this.bUs.cdE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.enterForum.recommend.b.b bVar, final RecommendForumItemView recommendForumItemView) {
        if (!l.lo()) {
            UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(d.j.neterror));
        } else if (bVar != null && !StringUtils.isNull(bVar.forumName) && bVar.forumId > 0) {
            if (!bc.cZ(getContext())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.bUs == null) {
                this.bUs = new LikeModel(this.mContext);
            }
            this.bUs.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.recommend.view.b.3
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (b.this.bUs.getErrorCode() == 22) {
                        l.showToast(b.this.mContext.getPageActivity(), b.this.mContext.getString(d.j.had_liked_forum));
                    } else if (obj != null) {
                        if (b.this.bUs.getErrorCode() != 0) {
                            l.showToast(b.this.mContext.getPageActivity(), b.this.bUs.getErrorString());
                            return;
                        }
                        if (recommendForumItemView == b.this.eFE) {
                            b.this.eFE.iC(true);
                        } else {
                            b.this.eFF.iC(true);
                        }
                        l.showToast(b.this.mContext.getPageActivity(), b.this.mContext.getString(d.j.attention_success));
                    }
                }
            });
            if (ap.bv(bVar.forumName)) {
                this.bUs.dW(bVar.forumName, String.valueOf(bVar.forumId));
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
            amVar.bJ("obj_type", String.valueOf(bVar.eEt));
            amVar.k(ImageViewerConfig.FORUM_ID, bVar.forumId);
            amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
            amVar.bJ("obj_locate", str);
            TiebaStatic.log(amVar);
        }
    }
}

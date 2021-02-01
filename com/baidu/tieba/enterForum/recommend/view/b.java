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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.recommend.b.c> {
    private TbPageContext eUY;
    private LikeModel fnw;
    private RecommendForumItemView iNl;
    private RecommendForumItemView iNm;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eUY = tbPageContext;
        initUI();
        this.iNl.setForumItemClickListener(new RecommendForumItemView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.b.1
            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void d(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.a(bVar, b.this.iNl);
            }

            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void e(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.c(bVar);
            }
        });
        this.iNm.setForumItemClickListener(new RecommendForumItemView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.b.2
            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void d(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.a(bVar, b.this.iNm);
            }

            @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
            public void e(com.baidu.tieba.enterForum.recommend.b.b bVar) {
                b.this.c(bVar);
            }
        });
    }

    private void initUI() {
        View view = getView();
        this.iNl = (RecommendForumItemView) view.findViewById(R.id.reommend_forum_one);
        this.iNm = (RecommendForumItemView) view.findViewById(R.id.reommend_forum_two);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        this.iNl.onChangeSkinType();
        this.iNm.onChangeSkinType();
        ap.setBackgroundColor(getView(), R.color.CAM_X0205);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.c cVar) {
        if (cVar != null) {
            onChangeSkinType(this.eUY, this.mSkinType);
            if (cVar.iMd != null) {
                this.iNl.setVisibility(0);
                this.iNl.f(cVar.iMd);
            } else {
                this.iNl.setVisibility(4);
            }
            if (cVar.iMe != null) {
                this.iNm.setVisibility(0);
                this.iNm.f(cVar.iMe);
                return;
            }
            this.iNm.setVisibility(4);
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
        if (this.fnw != null) {
            this.fnw.dMN();
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
            if (this.fnw == null) {
                this.fnw = new LikeModel(this.eUY);
            }
            this.fnw.setLoadDataCallBack(new e() { // from class: com.baidu.tieba.enterForum.recommend.view.b.3
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (b.this.fnw.getErrorCode() == 22) {
                        l.showToast(b.this.eUY.getPageActivity(), b.this.eUY.getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (b.this.fnw.getErrorCode() != 0) {
                            l.showToast(b.this.eUY.getPageActivity(), b.this.fnw.getErrorString());
                            return;
                        }
                        if (recommendForumItemView == b.this.iNl) {
                            b.this.iNl.pY(true);
                        } else {
                            b.this.iNm.pY(true);
                        }
                        l.showToast(b.this.eUY.getPageActivity(), b.this.eUY.getString(R.string.attention_success));
                    }
                }
            });
            if (au.isForumName(bVar.forumName)) {
                this.fnw.gw(bVar.forumName, String.valueOf(bVar.forumId));
            }
            a(bVar, "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eUY.getPageActivity()).createNormalCfg(bVar.forumName, FrsActivityConfig.FRS_FROM_TAB_RECOMMEND_FORUM).setCallFrom(11)));
        a(bVar, "2");
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.b bVar, String str) {
        if (bVar != null) {
            ar arVar = new ar("c13375");
            arVar.dR("obj_type", String.valueOf(bVar.iMb));
            arVar.v("fid", bVar.forumId);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.dR("obj_locate", str);
            TiebaStatic.log(arVar);
        }
    }
}

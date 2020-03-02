package com.baidu.tieba.enterForum.recommend.view;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes9.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private ForumTestView fYi;
    private com.baidu.tieba.c.d fYj;
    private boolean fYk;
    private CustomMessageListener fYl;
    private CustomMessageListener fYm;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fYk = true;
        this.fYl = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.bzi();
                }
            }
        };
        this.fYm = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.fYi == null || RecommendForumHeaderView.this.fYi.getVisibility() == 8) {
                        RecommendForumHeaderView.this.fYk = false;
                    } else {
                        RecommendForumHeaderView.this.bzh();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.recom_forum_header_layout, (ViewGroup) this, true);
        this.fYi = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.fYi.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.fYi != null) {
            this.fYi.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (v.isEmpty(list)) {
            this.fYi.setVisibility(8);
            return;
        }
        this.fYi.setVisibility(0);
        this.fYi.setData(list);
        if (!this.fYk) {
            bzh();
            this.fYk = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.fYi != null) {
                this.fYi.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.fYi && this.fYj != null) {
            bzi();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.fYm);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzh() {
        if (this.fYj == null) {
            this.fYj = new com.baidu.tieba.c.d(this.mPageContext, this.fYi);
            this.fYj.ck(R.drawable.bg_tip_blue_up);
            this.fYj.cj(32);
            this.fYj.setUseDirectOffset(true);
            this.fYj.cl(3000);
            this.fYj.setYOffset(0);
            this.fYj.c(this);
            this.fYj.aj(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void bzi() {
        if (this.fYj != null) {
            this.fYj.zz();
        }
    }

    public void bzj() {
        MessageManager.getInstance().unRegisterListener(this.fYl);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fYi != null) {
            this.fYi.setPageId(bdUniqueId);
        }
        this.fYm.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fYm);
        this.fYl.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fYl);
    }
}

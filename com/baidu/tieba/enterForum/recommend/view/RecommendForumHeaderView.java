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
/* loaded from: classes4.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private ForumTestView fet;
    private com.baidu.tieba.c.d feu;
    private boolean fev;
    private CustomMessageListener few;
    private CustomMessageListener fex;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fev = true;
        this.few = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.bfh();
                }
            }
        };
        this.fex = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.fet == null || RecommendForumHeaderView.this.fet.getVisibility() == 8) {
                        RecommendForumHeaderView.this.fev = false;
                    } else {
                        RecommendForumHeaderView.this.bfg();
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
        this.fet = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.fet.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.fex);
        MessageManager.getInstance().registerListener(this.few);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.fet != null) {
            this.fet.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (v.isEmpty(list)) {
            this.fet.setVisibility(8);
            return;
        }
        this.fet.setVisibility(0);
        this.fet.setData(list);
        if (!this.fev) {
            bfg();
            this.fev = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.fet != null) {
                this.fet.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.fet && this.feu != null) {
            bfh();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.fex);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfg() {
        if (this.feu == null) {
            this.feu = new com.baidu.tieba.c.d(this.mPageContext, this.fet);
            this.feu.bB(R.drawable.bg_tip_blue_up);
            this.feu.bA(32);
            this.feu.setUseDirectOffset(true);
            this.feu.bC(3000);
            this.feu.setYOffset(0);
            this.feu.c(this);
            this.feu.R(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void bfh() {
        if (this.feu != null) {
            this.feu.uQ();
        }
    }

    public void bfi() {
        MessageManager.getInstance().unRegisterListener(this.few);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fet != null) {
            this.fet.setPageId(bdUniqueId);
        }
    }
}

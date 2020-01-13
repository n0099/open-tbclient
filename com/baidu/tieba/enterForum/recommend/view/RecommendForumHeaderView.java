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
/* loaded from: classes7.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private ForumTestView fWf;
    private com.baidu.tieba.c.d fWg;
    private boolean fWh;
    private CustomMessageListener fWi;
    private CustomMessageListener fWj;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fWh = true;
        this.fWi = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.bxE();
                }
            }
        };
        this.fWj = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.fWf == null || RecommendForumHeaderView.this.fWf.getVisibility() == 8) {
                        RecommendForumHeaderView.this.fWh = false;
                    } else {
                        RecommendForumHeaderView.this.bxD();
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
        this.fWf = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.fWf.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.fWf != null) {
            this.fWf.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (v.isEmpty(list)) {
            this.fWf.setVisibility(8);
            return;
        }
        this.fWf.setVisibility(0);
        this.fWf.setData(list);
        if (!this.fWh) {
            bxD();
            this.fWh = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.fWf != null) {
                this.fWf.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.fWf && this.fWg != null) {
            bxE();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.fWj);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxD() {
        if (this.fWg == null) {
            this.fWg = new com.baidu.tieba.c.d(this.mPageContext, this.fWf);
            this.fWg.bU(R.drawable.bg_tip_blue_up);
            this.fWg.bT(32);
            this.fWg.setUseDirectOffset(true);
            this.fWg.bV(3000);
            this.fWg.setYOffset(0);
            this.fWg.c(this);
            this.fWg.Y(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void bxE() {
        if (this.fWg != null) {
            this.fWg.xg();
        }
    }

    public void bxF() {
        MessageManager.getInstance().unRegisterListener(this.fWi);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fWf != null) {
            this.fWf.setPageId(bdUniqueId);
        }
        this.fWj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fWj);
        this.fWi.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fWi);
    }
}

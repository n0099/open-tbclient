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
    private ForumTestView gFO;
    private com.baidu.tieba.c.d gFP;
    private boolean gFQ;
    private CustomMessageListener gFR;
    private CustomMessageListener gFS;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gFQ = true;
        this.gFR = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.bJq();
                }
            }
        };
        this.gFS = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.gFO == null || RecommendForumHeaderView.this.gFO.getVisibility() == 8) {
                        RecommendForumHeaderView.this.gFQ = false;
                    } else {
                        RecommendForumHeaderView.this.bJp();
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
        this.gFO = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.gFO.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.gFO != null) {
            this.gFO.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (v.isEmpty(list)) {
            this.gFO.setVisibility(8);
            return;
        }
        this.gFO.setVisibility(0);
        this.gFO.setData(list);
        if (!this.gFQ) {
            bJp();
            this.gFQ = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.gFO != null) {
                this.gFO.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.gFO && this.gFP != null) {
            bJq();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.gFS);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJp() {
        if (this.gFP == null) {
            this.gFP = new com.baidu.tieba.c.d(this.mPageContext, this.gFO);
            this.gFP.cz(R.drawable.bg_tip_blue_up);
            this.gFP.cy(32);
            this.gFP.setUseDirectOffset(true);
            this.gFP.cA(3000);
            this.gFP.setYOffset(0);
            this.gFP.c(this);
            this.gFP.al(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void bJq() {
        if (this.gFP != null) {
            this.gFP.ED();
        }
    }

    public void bJr() {
        MessageManager.getInstance().unRegisterListener(this.gFR);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.gFO != null) {
            this.gFO.setPageId(bdUniqueId);
        }
        this.gFS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gFS);
        this.gFR.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gFR);
    }
}

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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.c.e;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes16.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private ForumTestView hzR;
    private e hzS;
    private boolean hzT;
    private CustomMessageListener hzU;
    private CustomMessageListener hzV;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.hzT = true;
        this.hzU = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.cgt();
                }
            }
        };
        this.hzV = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.hzR == null || RecommendForumHeaderView.this.hzR.getVisibility() == 8) {
                        RecommendForumHeaderView.this.hzT = false;
                    } else {
                        RecommendForumHeaderView.this.cgs();
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
        this.hzR = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.hzR.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.hzR != null) {
            this.hzR.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (y.isEmpty(list)) {
            this.hzR.setVisibility(8);
            return;
        }
        this.hzR.setVisibility(0);
        this.hzR.setData(list);
        if (!this.hzT) {
            cgs();
            this.hzT = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.hzR != null) {
                this.hzR.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.hzR && this.hzS != null) {
            cgt();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.hzV);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgs() {
        if (this.hzS == null) {
            this.hzS = new e(this.mPageContext, this.hzR);
            this.hzS.eL(R.drawable.bg_tip_blue_up);
            this.hzS.eK(32);
            this.hzS.setUseDirectOffset(true);
            this.hzS.eM(3000);
            this.hzS.setYOffset(0);
            this.hzS.c(this);
            this.hzS.aG(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void cgt() {
        if (this.hzS != null) {
            this.hzS.NG();
        }
    }

    public void cgu() {
        MessageManager.getInstance().unRegisterListener(this.hzU);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hzR != null) {
            this.hzR.setPageId(bdUniqueId);
        }
        this.hzV.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hzV);
        this.hzU.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hzU);
    }
}

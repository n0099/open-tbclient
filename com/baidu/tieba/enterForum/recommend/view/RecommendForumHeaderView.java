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
/* loaded from: classes6.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private ForumTestView fSW;
    private com.baidu.tieba.c.d fSX;
    private boolean fSY;
    private CustomMessageListener fSZ;
    private CustomMessageListener fTa;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fSY = true;
        this.fSZ = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.bwC();
                }
            }
        };
        this.fTa = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.fSW == null || RecommendForumHeaderView.this.fSW.getVisibility() == 8) {
                        RecommendForumHeaderView.this.fSY = false;
                    } else {
                        RecommendForumHeaderView.this.bwB();
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
        this.fSW = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.fSW.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.fSW != null) {
            this.fSW.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (v.isEmpty(list)) {
            this.fSW.setVisibility(8);
            return;
        }
        this.fSW.setVisibility(0);
        this.fSW.setData(list);
        if (!this.fSY) {
            bwB();
            this.fSY = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.fSW != null) {
                this.fSW.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.fSW && this.fSX != null) {
            bwC();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.fTa);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwB() {
        if (this.fSX == null) {
            this.fSX = new com.baidu.tieba.c.d(this.mPageContext, this.fSW);
            this.fSX.bT(R.drawable.bg_tip_blue_up);
            this.fSX.bS(32);
            this.fSX.setUseDirectOffset(true);
            this.fSX.bU(3000);
            this.fSX.setYOffset(0);
            this.fSX.c(this);
            this.fSX.Z(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void bwC() {
        if (this.fSX != null) {
            this.fSX.wP();
        }
    }

    public void bwD() {
        MessageManager.getInstance().unRegisterListener(this.fSZ);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fSW != null) {
            this.fSW.setPageId(bdUniqueId);
        }
        this.fTa.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fTa);
        this.fSZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fSZ);
    }
}

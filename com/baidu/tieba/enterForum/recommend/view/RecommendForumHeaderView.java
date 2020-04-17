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
    private ForumTestView gFI;
    private com.baidu.tieba.c.d gFJ;
    private boolean gFK;
    private CustomMessageListener gFL;
    private CustomMessageListener gFM;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gFK = true;
        this.gFL = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.bJr();
                }
            }
        };
        this.gFM = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.gFI == null || RecommendForumHeaderView.this.gFI.getVisibility() == 8) {
                        RecommendForumHeaderView.this.gFK = false;
                    } else {
                        RecommendForumHeaderView.this.bJq();
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
        this.gFI = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.gFI.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.gFI != null) {
            this.gFI.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (v.isEmpty(list)) {
            this.gFI.setVisibility(8);
            return;
        }
        this.gFI.setVisibility(0);
        this.gFI.setData(list);
        if (!this.gFK) {
            bJq();
            this.gFK = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.gFI != null) {
                this.gFI.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.gFI && this.gFJ != null) {
            bJr();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.gFM);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJq() {
        if (this.gFJ == null) {
            this.gFJ = new com.baidu.tieba.c.d(this.mPageContext, this.gFI);
            this.gFJ.cz(R.drawable.bg_tip_blue_up);
            this.gFJ.cy(32);
            this.gFJ.setUseDirectOffset(true);
            this.gFJ.cA(3000);
            this.gFJ.setYOffset(0);
            this.gFJ.c(this);
            this.gFJ.al(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void bJr() {
        if (this.gFJ != null) {
            this.gFJ.EE();
        }
    }

    public void bJs() {
        MessageManager.getInstance().unRegisterListener(this.gFL);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.gFI != null) {
            this.gFI.setPageId(bdUniqueId);
        }
        this.gFM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gFM);
        this.gFL.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gFL);
    }
}

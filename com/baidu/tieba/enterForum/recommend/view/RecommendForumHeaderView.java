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
    private ForumTestView gUH;
    private com.baidu.tieba.c.d gUI;
    private boolean gUJ;
    private CustomMessageListener gUK;
    private CustomMessageListener gUL;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gUJ = true;
        this.gUK = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.bPL();
                }
            }
        };
        this.gUL = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.gUH == null || RecommendForumHeaderView.this.gUH.getVisibility() == 8) {
                        RecommendForumHeaderView.this.gUJ = false;
                    } else {
                        RecommendForumHeaderView.this.bPK();
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
        this.gUH = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.gUH.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.gUH != null) {
            this.gUH.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (v.isEmpty(list)) {
            this.gUH.setVisibility(8);
            return;
        }
        this.gUH.setVisibility(0);
        this.gUH.setData(list);
        if (!this.gUJ) {
            bPK();
            this.gUJ = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.gUH != null) {
                this.gUH.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.gUH && this.gUI != null) {
            bPL();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.gUL);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPK() {
        if (this.gUI == null) {
            this.gUI = new com.baidu.tieba.c.d(this.mPageContext, this.gUH);
            this.gUI.cI(R.drawable.bg_tip_blue_up);
            this.gUI.cH(32);
            this.gUI.setUseDirectOffset(true);
            this.gUI.cJ(3000);
            this.gUI.setYOffset(0);
            this.gUI.c(this);
            this.gUI.aA(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void bPL() {
        if (this.gUI != null) {
            this.gUI.Gu();
        }
    }

    public void bPM() {
        MessageManager.getInstance().unRegisterListener(this.gUK);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.gUH != null) {
            this.gUH.setPageId(bdUniqueId);
        }
        this.gUL.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gUL);
        this.gUK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gUK);
    }
}

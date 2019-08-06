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
    private ForumTestView faT;
    private com.baidu.tieba.c.d faU;
    private boolean faV;
    private CustomMessageListener faW;
    private CustomMessageListener faX;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.faV = true;
        this.faW = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.bgJ();
                }
            }
        };
        this.faX = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.faT == null || RecommendForumHeaderView.this.faT.getVisibility() == 8) {
                        RecommendForumHeaderView.this.faV = false;
                    } else {
                        RecommendForumHeaderView.this.bgI();
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
        this.faT = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.faT.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.faX);
        MessageManager.getInstance().registerListener(this.faW);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.faT != null) {
            this.faT.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (v.aa(list)) {
            this.faT.setVisibility(8);
            return;
        }
        this.faT.setVisibility(0);
        this.faT.setData(list);
        if (!this.faV) {
            bgI();
            this.faV = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.faT != null) {
                this.faT.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.faT && this.faU != null) {
            bgJ();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.faX);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgI() {
        if (this.faU == null) {
            this.faU = new com.baidu.tieba.c.d(this.mPageContext, this.faT);
            this.faU.qc(R.drawable.bg_tip_blue_up);
            this.faU.qb(32);
            this.faU.S(true);
            this.faU.qd(3000);
            this.faU.setYOffset(0);
            this.faU.q(this);
            this.faU.cI(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void bgJ() {
        if (this.faU != null) {
            this.faU.bbB();
        }
    }

    public void bgK() {
        MessageManager.getInstance().unRegisterListener(this.faW);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.faT != null) {
            this.faT.setPageId(bdUniqueId);
        }
    }
}

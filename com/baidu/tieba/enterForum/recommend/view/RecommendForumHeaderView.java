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
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private ForumHeaderView eVD;
    private ForumTestView eVE;
    private com.baidu.tieba.c.d eVF;
    private boolean eVG;
    private CustomMessageListener eVH;
    private CustomMessageListener eVI;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.eVG = true;
        this.eVH = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.beA();
                }
            }
        };
        this.eVI = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.eVE == null || RecommendForumHeaderView.this.eVE.getVisibility() == 8) {
                        RecommendForumHeaderView.this.eVG = false;
                    } else {
                        RecommendForumHeaderView.this.bez();
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
        this.eVD = (ForumHeaderView) findViewById(R.id.recommend_forum_header_serch_view);
        this.eVE = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.eVE.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.eVI);
        MessageManager.getInstance().registerListener(this.eVH);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.eVE != null) {
            this.eVE.setOnSecectedListener(aVar);
        }
    }

    public void setSearchHint(String str) {
        if (this.eVD != null) {
            this.eVD.setSearchHint(str);
        }
    }

    public void setData(List<f> list) {
        if (v.aa(list)) {
            this.eVE.setVisibility(8);
            return;
        }
        this.eVE.setVisibility(0);
        this.eVE.setData(list);
        if (!this.eVG) {
            bez();
            this.eVG = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.eVD != null) {
                this.eVD.onChangeSkinType();
            }
            if (this.eVE != null) {
                this.eVE.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.eVE && this.eVF != null) {
            beA();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.eVI);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bez() {
        if (this.eVF == null) {
            this.eVF = new com.baidu.tieba.c.d(this.mPageContext, this.eVE);
            this.eVF.pK(R.drawable.bg_tip_blue_up);
            this.eVF.pJ(32);
            this.eVF.S(true);
            this.eVF.pL(3000);
            this.eVF.setYOffset(0);
            this.eVF.q(this);
            this.eVF.cH(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void beA() {
        if (this.eVF != null) {
            this.eVF.aZx();
        }
    }

    public void beB() {
        MessageManager.getInstance().unRegisterListener(this.eVH);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.eVE != null) {
            this.eVE.setPageId(bdUniqueId);
        }
    }
}

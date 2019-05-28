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
    private ForumHeaderView eVE;
    private ForumTestView eVF;
    private com.baidu.tieba.c.d eVG;
    private boolean eVH;
    private CustomMessageListener eVI;
    private CustomMessageListener eVJ;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.eVH = true;
        this.eVI = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.beD();
                }
            }
        };
        this.eVJ = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.eVF == null || RecommendForumHeaderView.this.eVF.getVisibility() == 8) {
                        RecommendForumHeaderView.this.eVH = false;
                    } else {
                        RecommendForumHeaderView.this.beC();
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
        this.eVE = (ForumHeaderView) findViewById(R.id.recommend_forum_header_serch_view);
        this.eVF = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.eVF.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.eVJ);
        MessageManager.getInstance().registerListener(this.eVI);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.eVF != null) {
            this.eVF.setOnSecectedListener(aVar);
        }
    }

    public void setSearchHint(String str) {
        if (this.eVE != null) {
            this.eVE.setSearchHint(str);
        }
    }

    public void setData(List<f> list) {
        if (v.aa(list)) {
            this.eVF.setVisibility(8);
            return;
        }
        this.eVF.setVisibility(0);
        this.eVF.setData(list);
        if (!this.eVH) {
            beC();
            this.eVH = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.eVE != null) {
                this.eVE.onChangeSkinType();
            }
            if (this.eVF != null) {
                this.eVF.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.eVF && this.eVG != null) {
            beD();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.eVJ);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beC() {
        if (this.eVG == null) {
            this.eVG = new com.baidu.tieba.c.d(this.mPageContext, this.eVF);
            this.eVG.pK(R.drawable.bg_tip_blue_up);
            this.eVG.pJ(32);
            this.eVG.S(true);
            this.eVG.pL(3000);
            this.eVG.setYOffset(0);
            this.eVG.q(this);
            this.eVG.cH(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void beD() {
        if (this.eVG != null) {
            this.eVG.aZA();
        }
    }

    public void beE() {
        MessageManager.getInstance().unRegisterListener(this.eVI);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.eVF != null) {
            this.eVF.setPageId(bdUniqueId);
        }
    }
}

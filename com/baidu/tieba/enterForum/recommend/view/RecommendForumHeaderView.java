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
import com.baidu.tieba.d.e;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes22.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private ForumTestView iAb;
    private e iAc;
    private boolean iAd;
    private CustomMessageListener iAe;
    private CustomMessageListener iAf;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.iAd = true;
        this.iAe = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.cwI();
                }
            }
        };
        this.iAf = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.iAb == null || RecommendForumHeaderView.this.iAb.getVisibility() == 8) {
                        RecommendForumHeaderView.this.iAd = false;
                    } else {
                        RecommendForumHeaderView.this.cwH();
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
        this.iAb = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.iAb.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.iAb != null) {
            this.iAb.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (y.isEmpty(list)) {
            this.iAb.setVisibility(8);
            return;
        }
        this.iAb.setVisibility(0);
        this.iAb.setData(list);
        if (!this.iAd) {
            cwH();
            this.iAd = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iAb != null) {
                this.iAb.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.iAb && this.iAc != null) {
            cwI();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.iAf);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwH() {
        if (this.iAc == null) {
            this.iAc = new e(this.mPageContext, this.iAb);
            this.iAc.fO(R.drawable.bg_tip_blue_up);
            this.iAc.fN(32);
            this.iAc.setUseDirectOffset(true);
            this.iAc.fP(3000);
            this.iAc.setYOffset(0);
            this.iAc.d(this);
            this.iAc.aP(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void cwI() {
        if (this.iAc != null) {
            this.iAc.UG();
        }
    }

    public void cwJ() {
        MessageManager.getInstance().unRegisterListener(this.iAe);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.iAb != null) {
            this.iAb.setPageId(bdUniqueId);
        }
        this.iAf.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iAf);
        this.iAe.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iAe);
    }
}

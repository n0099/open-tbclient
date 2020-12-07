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
    private e iAa;
    private boolean iAb;
    private CustomMessageListener iAc;
    private CustomMessageListener iAd;
    private ForumTestView izZ;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.iAb = true;
        this.iAc = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.cwH();
                }
            }
        };
        this.iAd = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.izZ == null || RecommendForumHeaderView.this.izZ.getVisibility() == 8) {
                        RecommendForumHeaderView.this.iAb = false;
                    } else {
                        RecommendForumHeaderView.this.cwG();
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
        this.izZ = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.izZ.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.izZ != null) {
            this.izZ.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (y.isEmpty(list)) {
            this.izZ.setVisibility(8);
            return;
        }
        this.izZ.setVisibility(0);
        this.izZ.setData(list);
        if (!this.iAb) {
            cwG();
            this.iAb = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.izZ != null) {
                this.izZ.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.izZ && this.iAa != null) {
            cwH();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.iAd);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwG() {
        if (this.iAa == null) {
            this.iAa = new e(this.mPageContext, this.izZ);
            this.iAa.fO(R.drawable.bg_tip_blue_up);
            this.iAa.fN(32);
            this.iAa.setUseDirectOffset(true);
            this.iAa.fP(3000);
            this.iAa.setYOffset(0);
            this.iAa.d(this);
            this.iAa.aP(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void cwH() {
        if (this.iAa != null) {
            this.iAa.UG();
        }
    }

    public void cwI() {
        MessageManager.getInstance().unRegisterListener(this.iAc);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.izZ != null) {
            this.izZ.setPageId(bdUniqueId);
        }
        this.iAd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iAd);
        this.iAc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iAc);
    }
}

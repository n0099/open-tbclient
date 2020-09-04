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
    private CustomMessageListener hAa;
    private CustomMessageListener hAb;
    private ForumTestView hzX;
    private e hzY;
    private boolean hzZ;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.hzZ = true;
        this.hAa = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.cgu();
                }
            }
        };
        this.hAb = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.hzX == null || RecommendForumHeaderView.this.hzX.getVisibility() == 8) {
                        RecommendForumHeaderView.this.hzZ = false;
                    } else {
                        RecommendForumHeaderView.this.cgt();
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
        this.hzX = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.hzX.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.hzX != null) {
            this.hzX.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (y.isEmpty(list)) {
            this.hzX.setVisibility(8);
            return;
        }
        this.hzX.setVisibility(0);
        this.hzX.setData(list);
        if (!this.hzZ) {
            cgt();
            this.hzZ = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.hzX != null) {
                this.hzX.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.hzX && this.hzY != null) {
            cgu();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.hAb);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgt() {
        if (this.hzY == null) {
            this.hzY = new e(this.mPageContext, this.hzX);
            this.hzY.eL(R.drawable.bg_tip_blue_up);
            this.hzY.eK(32);
            this.hzY.setUseDirectOffset(true);
            this.hzY.eM(3000);
            this.hzY.setYOffset(0);
            this.hzY.c(this);
            this.hzY.aG(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void cgu() {
        if (this.hzY != null) {
            this.hzY.NG();
        }
    }

    public void cgv() {
        MessageManager.getInstance().unRegisterListener(this.hAa);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hzX != null) {
            this.hzX.setPageId(bdUniqueId);
        }
        this.hAb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hAb);
        this.hAa.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hAa);
    }
}

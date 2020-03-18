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
    private ForumTestView fZd;
    private com.baidu.tieba.c.d fZe;
    private boolean fZf;
    private CustomMessageListener fZg;
    private CustomMessageListener fZh;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fZf = true;
        this.fZg = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.bzp();
                }
            }
        };
        this.fZh = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.fZd == null || RecommendForumHeaderView.this.fZd.getVisibility() == 8) {
                        RecommendForumHeaderView.this.fZf = false;
                    } else {
                        RecommendForumHeaderView.this.bzo();
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
        this.fZd = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.fZd.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.fZd != null) {
            this.fZd.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (v.isEmpty(list)) {
            this.fZd.setVisibility(8);
            return;
        }
        this.fZd.setVisibility(0);
        this.fZd.setData(list);
        if (!this.fZf) {
            bzo();
            this.fZf = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.fZd != null) {
                this.fZd.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.fZd && this.fZe != null) {
            bzp();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.fZh);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzo() {
        if (this.fZe == null) {
            this.fZe = new com.baidu.tieba.c.d(this.mPageContext, this.fZd);
            this.fZe.ck(R.drawable.bg_tip_blue_up);
            this.fZe.cj(32);
            this.fZe.setUseDirectOffset(true);
            this.fZe.cl(3000);
            this.fZe.setYOffset(0);
            this.fZe.c(this);
            this.fZe.ai(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void bzp() {
        if (this.fZe != null) {
            this.fZe.zG();
        }
    }

    public void bzq() {
        MessageManager.getInstance().unRegisterListener(this.fZg);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fZd != null) {
            this.fZd.setPageId(bdUniqueId);
        }
        this.fZh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fZh);
        this.fZg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fZg);
    }
}

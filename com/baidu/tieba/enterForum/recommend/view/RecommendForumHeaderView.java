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
    private ForumTestView fYg;
    private com.baidu.tieba.c.d fYh;
    private boolean fYi;
    private CustomMessageListener fYj;
    private CustomMessageListener fYk;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fYi = true;
        this.fYj = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.bzg();
                }
            }
        };
        this.fYk = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.fYg == null || RecommendForumHeaderView.this.fYg.getVisibility() == 8) {
                        RecommendForumHeaderView.this.fYi = false;
                    } else {
                        RecommendForumHeaderView.this.bzf();
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
        this.fYg = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.fYg.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.fYg != null) {
            this.fYg.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (v.isEmpty(list)) {
            this.fYg.setVisibility(8);
            return;
        }
        this.fYg.setVisibility(0);
        this.fYg.setData(list);
        if (!this.fYi) {
            bzf();
            this.fYi = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.fYg != null) {
                this.fYg.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.fYg && this.fYh != null) {
            bzg();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.fYk);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzf() {
        if (this.fYh == null) {
            this.fYh = new com.baidu.tieba.c.d(this.mPageContext, this.fYg);
            this.fYh.ck(R.drawable.bg_tip_blue_up);
            this.fYh.cj(32);
            this.fYh.setUseDirectOffset(true);
            this.fYh.cl(3000);
            this.fYh.setYOffset(0);
            this.fYh.c(this);
            this.fYh.aj(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void bzg() {
        if (this.fYh != null) {
            this.fYh.zx();
        }
    }

    public void bzh() {
        MessageManager.getInstance().unRegisterListener(this.fYj);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fYg != null) {
            this.fYg.setPageId(bdUniqueId);
        }
        this.fYk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fYk);
        this.fYj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fYj);
    }
}

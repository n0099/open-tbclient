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
    private ForumTestView fYv;
    private com.baidu.tieba.c.d fYw;
    private boolean fYx;
    private CustomMessageListener fYy;
    private CustomMessageListener fYz;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fYx = true;
        this.fYy = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.bzj();
                }
            }
        };
        this.fYz = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.fYv == null || RecommendForumHeaderView.this.fYv.getVisibility() == 8) {
                        RecommendForumHeaderView.this.fYx = false;
                    } else {
                        RecommendForumHeaderView.this.bzi();
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
        this.fYv = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.fYv.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.fYv != null) {
            this.fYv.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (v.isEmpty(list)) {
            this.fYv.setVisibility(8);
            return;
        }
        this.fYv.setVisibility(0);
        this.fYv.setData(list);
        if (!this.fYx) {
            bzi();
            this.fYx = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.fYv != null) {
                this.fYv.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.fYv && this.fYw != null) {
            bzj();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.fYz);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzi() {
        if (this.fYw == null) {
            this.fYw = new com.baidu.tieba.c.d(this.mPageContext, this.fYv);
            this.fYw.ck(R.drawable.bg_tip_blue_up);
            this.fYw.cj(32);
            this.fYw.setUseDirectOffset(true);
            this.fYw.cl(3000);
            this.fYw.setYOffset(0);
            this.fYw.c(this);
            this.fYw.aj(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void bzj() {
        if (this.fYw != null) {
            this.fYw.zz();
        }
    }

    public void bzk() {
        MessageManager.getInstance().unRegisterListener(this.fYy);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fYv != null) {
            this.fYv.setPageId(bdUniqueId);
        }
        this.fYz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fYz);
        this.fYy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fYy);
    }
}

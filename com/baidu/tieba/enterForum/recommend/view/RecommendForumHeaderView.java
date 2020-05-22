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
    private CustomMessageListener gUA;
    private ForumTestView gUw;
    private com.baidu.tieba.c.d gUx;
    private boolean gUy;
    private CustomMessageListener gUz;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gUy = true;
        this.gUz = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.bPJ();
                }
            }
        };
        this.gUA = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.gUw == null || RecommendForumHeaderView.this.gUw.getVisibility() == 8) {
                        RecommendForumHeaderView.this.gUy = false;
                    } else {
                        RecommendForumHeaderView.this.bPI();
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
        this.gUw = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.gUw.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.gUw != null) {
            this.gUw.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (v.isEmpty(list)) {
            this.gUw.setVisibility(8);
            return;
        }
        this.gUw.setVisibility(0);
        this.gUw.setData(list);
        if (!this.gUy) {
            bPI();
            this.gUy = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.gUw != null) {
                this.gUw.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.gUw && this.gUx != null) {
            bPJ();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.gUA);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPI() {
        if (this.gUx == null) {
            this.gUx = new com.baidu.tieba.c.d(this.mPageContext, this.gUw);
            this.gUx.cG(R.drawable.bg_tip_blue_up);
            this.gUx.cF(32);
            this.gUx.setUseDirectOffset(true);
            this.gUx.cH(3000);
            this.gUx.setYOffset(0);
            this.gUx.c(this);
            this.gUx.aA(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void bPJ() {
        if (this.gUx != null) {
            this.gUx.Gu();
        }
    }

    public void bPK() {
        MessageManager.getInstance().unRegisterListener(this.gUz);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.gUw != null) {
            this.gUw.setPageId(bdUniqueId);
        }
        this.gUA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gUA);
        this.gUz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gUz);
    }
}

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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.c.e;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes16.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private ForumTestView hna;
    private e hnb;
    private boolean hnc;
    private CustomMessageListener hnd;
    private CustomMessageListener hne;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.hnc = true;
        this.hnd = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.bWg();
                }
            }
        };
        this.hne = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.hna == null || RecommendForumHeaderView.this.hna.getVisibility() == 8) {
                        RecommendForumHeaderView.this.hnc = false;
                    } else {
                        RecommendForumHeaderView.this.bWf();
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
        this.hna = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.hna.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.hna != null) {
            this.hna.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (x.isEmpty(list)) {
            this.hna.setVisibility(8);
            return;
        }
        this.hna.setVisibility(0);
        this.hna.setData(list);
        if (!this.hnc) {
            bWf();
            this.hnc = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.hna != null) {
                this.hna.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.hna && this.hnb != null) {
            bWg();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.hne);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWf() {
        if (this.hnb == null) {
            this.hnb = new e(this.mPageContext, this.hna);
            this.hnb.cS(R.drawable.bg_tip_blue_up);
            this.hnb.cR(32);
            this.hnb.setUseDirectOffset(true);
            this.hnb.cT(3000);
            this.hnb.setYOffset(0);
            this.hnb.c(this);
            this.hnb.aC(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void bWg() {
        if (this.hnb != null) {
            this.hnb.HN();
        }
    }

    public void bWh() {
        MessageManager.getInstance().unRegisterListener(this.hnd);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hna != null) {
            this.hna.setPageId(bdUniqueId);
        }
        this.hne.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hne);
        this.hnd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hnd);
    }
}

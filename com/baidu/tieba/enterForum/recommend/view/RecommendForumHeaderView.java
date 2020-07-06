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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.c.e;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes9.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private ForumTestView hhq;
    private e hhr;
    private boolean hhs;
    private CustomMessageListener hht;
    private CustomMessageListener hhu;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.hhs = true;
        this.hht = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.bSP();
                }
            }
        };
        this.hhu = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.hhq == null || RecommendForumHeaderView.this.hhq.getVisibility() == 8) {
                        RecommendForumHeaderView.this.hhs = false;
                    } else {
                        RecommendForumHeaderView.this.bSO();
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
        this.hhq = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.hhq.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.hhq != null) {
            this.hhq.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (w.isEmpty(list)) {
            this.hhq.setVisibility(8);
            return;
        }
        this.hhq.setVisibility(0);
        this.hhq.setData(list);
        if (!this.hhs) {
            bSO();
            this.hhs = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.hhq != null) {
                this.hhq.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.hhq && this.hhr != null) {
            bSP();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.hhu);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSO() {
        if (this.hhr == null) {
            this.hhr = new e(this.mPageContext, this.hhq);
            this.hhr.cS(R.drawable.bg_tip_blue_up);
            this.hhr.cR(32);
            this.hhr.setUseDirectOffset(true);
            this.hhr.cT(3000);
            this.hhr.setYOffset(0);
            this.hhr.c(this);
            this.hhr.aC(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void bSP() {
        if (this.hhr != null) {
            this.hhr.HH();
        }
    }

    public void bSQ() {
        MessageManager.getInstance().unRegisterListener(this.hht);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hhq != null) {
            this.hhq.setPageId(bdUniqueId);
        }
        this.hhu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hhu);
        this.hht.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hht);
    }
}

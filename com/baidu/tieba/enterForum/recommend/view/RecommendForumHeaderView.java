package com.baidu.tieba.enterForum.recommend.view;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private ForumHeaderView eFX;
    private ForumTestView eFY;
    private com.baidu.tieba.c.d eFZ;
    private boolean eGa;
    private CustomMessageListener eGb;
    private CustomMessageListener eGc;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.eGa = true;
        this.eGb = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.aXp();
                }
            }
        };
        this.eGc = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.eFY == null || RecommendForumHeaderView.this.eFY.getVisibility() == 8) {
                        RecommendForumHeaderView.this.eGa = false;
                    } else {
                        RecommendForumHeaderView.this.aXo();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(d.h.recom_forum_header_layout, (ViewGroup) this, true);
        this.eFX = (ForumHeaderView) findViewById(d.g.recommend_forum_header_serch_view);
        this.eFY = (ForumTestView) findViewById(d.g.recommend_forum_header_test_view);
        this.eFY.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.eGc);
        MessageManager.getInstance().registerListener(this.eGb);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.eFY != null) {
            this.eFY.setOnSecectedListener(aVar);
        }
    }

    public void setSearchHint(String str) {
        if (this.eFX != null) {
            this.eFX.setSearchHint(str);
        }
    }

    public void setData(List<f> list) {
        if (v.T(list)) {
            this.eFY.setVisibility(8);
            return;
        }
        this.eFY.setVisibility(0);
        this.eFY.setData(list);
        if (!this.eGa) {
            aXo();
            this.eGa = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.eFX != null) {
                this.eFX.onChangeSkinType();
            }
            if (this.eFY != null) {
                this.eFY.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.eFY && this.eFZ != null) {
            aXp();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.eGc);
        MessageManager.getInstance().unRegisterListener(this.eGb);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXo() {
        if (this.eFZ == null) {
            this.eFZ = new com.baidu.tieba.c.d(this.mPageContext, this.eFY);
            this.eFZ.oK(d.f.bg_tip_blue_up);
            this.eFZ.oJ(32);
            this.eFZ.aa(true);
            this.eFZ.oL(3000);
            this.eFZ.setYOffset(0);
            this.eFZ.o(this);
            this.eFZ.cu(getContext().getString(d.j.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void aXp() {
        if (this.eFZ != null) {
            this.eFZ.aSr();
        }
    }
}

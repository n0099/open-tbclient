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
    private ForumHeaderView eFI;
    private ForumTestView eFJ;
    private com.baidu.tieba.c.d eFK;
    private boolean eFL;
    private CustomMessageListener eFM;
    private CustomMessageListener eFN;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.eFL = true;
        this.eFM = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.aXn();
                }
            }
        };
        this.eFN = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.eFJ == null || RecommendForumHeaderView.this.eFJ.getVisibility() == 8) {
                        RecommendForumHeaderView.this.eFL = false;
                    } else {
                        RecommendForumHeaderView.this.aXm();
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
        this.eFI = (ForumHeaderView) findViewById(d.g.recommend_forum_header_serch_view);
        this.eFJ = (ForumTestView) findViewById(d.g.recommend_forum_header_test_view);
        this.eFJ.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.eFN);
        MessageManager.getInstance().registerListener(this.eFM);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.eFJ != null) {
            this.eFJ.setOnSecectedListener(aVar);
        }
    }

    public void setSearchHint(String str) {
        if (this.eFI != null) {
            this.eFI.setSearchHint(str);
        }
    }

    public void setData(List<f> list) {
        if (v.T(list)) {
            this.eFJ.setVisibility(8);
            return;
        }
        this.eFJ.setVisibility(0);
        this.eFJ.setData(list);
        if (!this.eFL) {
            aXm();
            this.eFL = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.eFI != null) {
                this.eFI.onChangeSkinType();
            }
            if (this.eFJ != null) {
                this.eFJ.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.eFJ && this.eFK != null) {
            aXn();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.eFN);
        MessageManager.getInstance().unRegisterListener(this.eFM);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXm() {
        if (this.eFK == null) {
            this.eFK = new com.baidu.tieba.c.d(this.mPageContext, this.eFJ);
            this.eFK.oG(d.f.bg_tip_blue_up);
            this.eFK.oF(32);
            this.eFK.aa(true);
            this.eFK.oH(3000);
            this.eFK.setYOffset(0);
            this.eFK.o(this);
            this.eFK.cv(getContext().getString(d.j.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void aXn() {
        if (this.eFK != null) {
            this.eFK.aSp();
        }
    }
}

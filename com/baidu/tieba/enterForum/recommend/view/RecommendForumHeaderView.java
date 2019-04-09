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
    private ForumHeaderView eFJ;
    private ForumTestView eFK;
    private com.baidu.tieba.c.d eFL;
    private boolean eFM;
    private CustomMessageListener eFN;
    private CustomMessageListener eFO;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.eFM = true;
        this.eFN = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.aXn();
                }
            }
        };
        this.eFO = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.eFK == null || RecommendForumHeaderView.this.eFK.getVisibility() == 8) {
                        RecommendForumHeaderView.this.eFM = false;
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
        this.eFJ = (ForumHeaderView) findViewById(d.g.recommend_forum_header_serch_view);
        this.eFK = (ForumTestView) findViewById(d.g.recommend_forum_header_test_view);
        this.eFK.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.eFO);
        MessageManager.getInstance().registerListener(this.eFN);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.eFK != null) {
            this.eFK.setOnSecectedListener(aVar);
        }
    }

    public void setSearchHint(String str) {
        if (this.eFJ != null) {
            this.eFJ.setSearchHint(str);
        }
    }

    public void setData(List<f> list) {
        if (v.T(list)) {
            this.eFK.setVisibility(8);
            return;
        }
        this.eFK.setVisibility(0);
        this.eFK.setData(list);
        if (!this.eFM) {
            aXm();
            this.eFM = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.eFJ != null) {
                this.eFJ.onChangeSkinType();
            }
            if (this.eFK != null) {
                this.eFK.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.eFK && this.eFL != null) {
            aXn();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.eFO);
        MessageManager.getInstance().unRegisterListener(this.eFN);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXm() {
        if (this.eFL == null) {
            this.eFL = new com.baidu.tieba.c.d(this.mPageContext, this.eFK);
            this.eFL.oG(d.f.bg_tip_blue_up);
            this.eFL.oF(32);
            this.eFL.aa(true);
            this.eFL.oH(3000);
            this.eFL.setYOffset(0);
            this.eFL.o(this);
            this.eFL.cv(getContext().getString(d.j.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void aXn() {
        if (this.eFL != null) {
            this.eFL.aSp();
        }
    }
}

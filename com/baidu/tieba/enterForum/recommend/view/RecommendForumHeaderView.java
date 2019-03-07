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
    private ForumHeaderView eGb;
    private ForumTestView eGc;
    private com.baidu.tieba.c.d eGd;
    private boolean eGe;
    private CustomMessageListener eGf;
    private CustomMessageListener eGg;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.eGe = true;
        this.eGf = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.aXp();
                }
            }
        };
        this.eGg = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.eGc == null || RecommendForumHeaderView.this.eGc.getVisibility() == 8) {
                        RecommendForumHeaderView.this.eGe = false;
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
        this.eGb = (ForumHeaderView) findViewById(d.g.recommend_forum_header_serch_view);
        this.eGc = (ForumTestView) findViewById(d.g.recommend_forum_header_test_view);
        this.eGc.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.eGg);
        MessageManager.getInstance().registerListener(this.eGf);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.eGc != null) {
            this.eGc.setOnSecectedListener(aVar);
        }
    }

    public void setSearchHint(String str) {
        if (this.eGb != null) {
            this.eGb.setSearchHint(str);
        }
    }

    public void setData(List<f> list) {
        if (v.T(list)) {
            this.eGc.setVisibility(8);
            return;
        }
        this.eGc.setVisibility(0);
        this.eGc.setData(list);
        if (!this.eGe) {
            aXo();
            this.eGe = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.eGb != null) {
                this.eGb.onChangeSkinType();
            }
            if (this.eGc != null) {
                this.eGc.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.eGc && this.eGd != null) {
            aXp();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.eGg);
        MessageManager.getInstance().unRegisterListener(this.eGf);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXo() {
        if (this.eGd == null) {
            this.eGd = new com.baidu.tieba.c.d(this.mPageContext, this.eGc);
            this.eGd.oK(d.f.bg_tip_blue_up);
            this.eGd.oJ(32);
            this.eGd.aa(true);
            this.eGd.oL(3000);
            this.eGd.setYOffset(0);
            this.eGd.o(this);
            this.eGd.cu(getContext().getString(d.j.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void aXp() {
        if (this.eGd != null) {
            this.eGd.aSr();
        }
    }
}

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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.c.e;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes2.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private ForumTestView iPm;
    private e iPn;
    private boolean iPo;
    private CustomMessageListener iPp;
    private CustomMessageListener iPq;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.iPo = true;
        this.iPp = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.cxj();
                }
            }
        };
        this.iPq = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.iPm == null || RecommendForumHeaderView.this.iPm.getVisibility() == 8) {
                        RecommendForumHeaderView.this.iPo = false;
                    } else {
                        RecommendForumHeaderView.this.cxi();
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
        this.iPm = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.iPm.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.iPm != null) {
            this.iPm.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (y.isEmpty(list)) {
            this.iPm.setVisibility(8);
            return;
        }
        this.iPm.setVisibility(0);
        this.iPm.setData(list);
        if (!this.iPo) {
            cxi();
            this.iPo = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iPm != null) {
                this.iPm.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.iPm && this.iPn != null) {
            cxj();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.iPq);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxi() {
        if (this.iPn == null) {
            this.iPn = new e(this.mPageContext, this.iPm);
            this.iPn.eo(R.drawable.bg_tip_blue_up);
            this.iPn.en(32);
            this.iPn.setUseDirectOffset(true);
            this.iPn.ep(3000);
            this.iPn.setYOffset(0);
            this.iPn.e(this);
            this.iPn.aJ(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void cxj() {
        if (this.iPn != null) {
            this.iPn.TC();
        }
    }

    public void cxk() {
        MessageManager.getInstance().unRegisterListener(this.iPp);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.iPm != null) {
            this.iPm.setPageId(bdUniqueId);
        }
        this.iPq.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iPq);
        this.iPp.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iPp);
    }
}

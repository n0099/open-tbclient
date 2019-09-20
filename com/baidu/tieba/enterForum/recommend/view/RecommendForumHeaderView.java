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
/* loaded from: classes4.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private com.baidu.tieba.c.d fcA;
    private boolean fcB;
    private CustomMessageListener fcC;
    private CustomMessageListener fcD;
    private ForumTestView fcz;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fcB = true;
        this.fcC = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.bhp();
                }
            }
        };
        this.fcD = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.fcz == null || RecommendForumHeaderView.this.fcz.getVisibility() == 8) {
                        RecommendForumHeaderView.this.fcB = false;
                    } else {
                        RecommendForumHeaderView.this.bho();
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
        this.fcz = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.fcz.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.fcD);
        MessageManager.getInstance().registerListener(this.fcC);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.fcz != null) {
            this.fcz.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (v.aa(list)) {
            this.fcz.setVisibility(8);
            return;
        }
        this.fcz.setVisibility(0);
        this.fcz.setData(list);
        if (!this.fcB) {
            bho();
            this.fcB = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.fcz != null) {
                this.fcz.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.fcz && this.fcA != null) {
            bhp();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.fcD);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bho() {
        if (this.fcA == null) {
            this.fcA = new com.baidu.tieba.c.d(this.mPageContext, this.fcz);
            this.fcA.qf(R.drawable.bg_tip_blue_up);
            this.fcA.qe(32);
            this.fcA.S(true);
            this.fcA.qg(3000);
            this.fcA.setYOffset(0);
            this.fcA.q(this);
            this.fcA.cJ(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void bhp() {
        if (this.fcA != null) {
            this.fcA.bcf();
        }
    }

    public void bhq() {
        MessageManager.getInstance().unRegisterListener(this.fcC);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fcz != null) {
            this.fcz.setPageId(bdUniqueId);
        }
    }
}

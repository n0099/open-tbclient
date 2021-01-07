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
/* loaded from: classes2.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private ForumTestView iMo;
    private e iMp;
    private boolean iMq;
    private CustomMessageListener iMr;
    private CustomMessageListener iMs;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.iMq = true;
        this.iMr = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.czC();
                }
            }
        };
        this.iMs = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.iMo == null || RecommendForumHeaderView.this.iMo.getVisibility() == 8) {
                        RecommendForumHeaderView.this.iMq = false;
                    } else {
                        RecommendForumHeaderView.this.czB();
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
        this.iMo = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.iMo.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.iMo != null) {
            this.iMo.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (x.isEmpty(list)) {
            this.iMo.setVisibility(8);
            return;
        }
        this.iMo.setVisibility(0);
        this.iMo.setData(list);
        if (!this.iMq) {
            czB();
            this.iMq = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iMo != null) {
                this.iMo.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.iMo && this.iMp != null) {
            czC();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.iMs);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czB() {
        if (this.iMp == null) {
            this.iMp = new e(this.mPageContext, this.iMo);
            this.iMp.fP(R.drawable.bg_tip_blue_up);
            this.iMp.fO(32);
            this.iMp.setUseDirectOffset(true);
            this.iMp.fQ(3000);
            this.iMp.setYOffset(0);
            this.iMp.e(this);
            this.iMp.aK(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void czC() {
        if (this.iMp != null) {
            this.iMp.VL();
        }
    }

    public void czD() {
        MessageManager.getInstance().unRegisterListener(this.iMr);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.iMo != null) {
            this.iMo.setPageId(bdUniqueId);
        }
        this.iMs.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iMs);
        this.iMr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iMr);
    }
}

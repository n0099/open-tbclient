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
/* loaded from: classes22.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private ForumTestView iot;
    private e iou;
    private boolean iov;
    private CustomMessageListener iow;
    private CustomMessageListener iox;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.iov = true;
        this.iow = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.csP();
                }
            }
        };
        this.iox = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.iot == null || RecommendForumHeaderView.this.iot.getVisibility() == 8) {
                        RecommendForumHeaderView.this.iov = false;
                    } else {
                        RecommendForumHeaderView.this.csO();
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
        this.iot = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.iot.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.iot != null) {
            this.iot.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (y.isEmpty(list)) {
            this.iot.setVisibility(8);
            return;
        }
        this.iot.setVisibility(0);
        this.iot.setData(list);
        if (!this.iov) {
            csO();
            this.iov = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iot != null) {
                this.iot.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.iot && this.iou != null) {
            csP();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.iox);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csO() {
        if (this.iou == null) {
            this.iou = new e(this.mPageContext, this.iot);
            this.iou.fu(R.drawable.bg_tip_blue_up);
            this.iou.ft(32);
            this.iou.setUseDirectOffset(true);
            this.iou.fv(3000);
            this.iou.setYOffset(0);
            this.iou.d(this);
            this.iou.aM(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void csP() {
        if (this.iou != null) {
            this.iou.SR();
        }
    }

    public void csQ() {
        MessageManager.getInstance().unRegisterListener(this.iow);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.iot != null) {
            this.iot.setPageId(bdUniqueId);
        }
        this.iox.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iox);
        this.iow.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iow);
    }
}

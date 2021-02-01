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
    private ForumTestView iNp;
    private e iNq;
    private boolean iNr;
    private CustomMessageListener iNs;
    private CustomMessageListener iNt;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.iNr = true;
        this.iNs = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.cwW();
                }
            }
        };
        this.iNt = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.iNp == null || RecommendForumHeaderView.this.iNp.getVisibility() == 8) {
                        RecommendForumHeaderView.this.iNr = false;
                    } else {
                        RecommendForumHeaderView.this.cwV();
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
        this.iNp = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.iNp.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.iNp != null) {
            this.iNp.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (y.isEmpty(list)) {
            this.iNp.setVisibility(8);
            return;
        }
        this.iNp.setVisibility(0);
        this.iNp.setData(list);
        if (!this.iNr) {
            cwV();
            this.iNr = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iNp != null) {
                this.iNp.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.iNp && this.iNq != null) {
            cwW();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.iNt);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwV() {
        if (this.iNq == null) {
            this.iNq = new e(this.mPageContext, this.iNp);
            this.iNq.en(R.drawable.bg_tip_blue_up);
            this.iNq.em(32);
            this.iNq.setUseDirectOffset(true);
            this.iNq.eo(3000);
            this.iNq.setYOffset(0);
            this.iNq.e(this);
            this.iNq.aJ(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void cwW() {
        if (this.iNq != null) {
            this.iNq.Tz();
        }
    }

    public void cwX() {
        MessageManager.getInstance().unRegisterListener(this.iNs);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.iNp != null) {
            this.iNp.setPageId(bdUniqueId);
        }
        this.iNt.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iNt);
        this.iNs.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iNs);
    }
}

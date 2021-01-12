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
    private ForumTestView iHH;
    private e iHI;
    private boolean iHJ;
    private CustomMessageListener iHK;
    private CustomMessageListener iHL;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.iHJ = true;
        this.iHK = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.cvK();
                }
            }
        };
        this.iHL = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.iHH == null || RecommendForumHeaderView.this.iHH.getVisibility() == 8) {
                        RecommendForumHeaderView.this.iHJ = false;
                    } else {
                        RecommendForumHeaderView.this.cvJ();
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
        this.iHH = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.iHH.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.iHH != null) {
            this.iHH.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (x.isEmpty(list)) {
            this.iHH.setVisibility(8);
            return;
        }
        this.iHH.setVisibility(0);
        this.iHH.setData(list);
        if (!this.iHJ) {
            cvJ();
            this.iHJ = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iHH != null) {
                this.iHH.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.iHH && this.iHI != null) {
            cvK();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.iHL);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvJ() {
        if (this.iHI == null) {
            this.iHI = new e(this.mPageContext, this.iHH);
            this.iHI.ej(R.drawable.bg_tip_blue_up);
            this.iHI.ei(32);
            this.iHI.setUseDirectOffset(true);
            this.iHI.ek(3000);
            this.iHI.setYOffset(0);
            this.iHI.e(this);
            this.iHI.aJ(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void cvK() {
        if (this.iHI != null) {
            this.iHI.RS();
        }
    }

    public void cvL() {
        MessageManager.getInstance().unRegisterListener(this.iHK);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.iHH != null) {
            this.iHH.setPageId(bdUniqueId);
        }
        this.iHL.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iHL);
        this.iHK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iHK);
    }
}

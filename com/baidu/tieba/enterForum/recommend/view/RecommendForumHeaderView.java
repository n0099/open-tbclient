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
    private ForumTestView iND;
    private e iNE;
    private boolean iNF;
    private CustomMessageListener iNG;
    private CustomMessageListener iNH;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.iNF = true;
        this.iNG = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.cxd();
                }
            }
        };
        this.iNH = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.iND == null || RecommendForumHeaderView.this.iND.getVisibility() == 8) {
                        RecommendForumHeaderView.this.iNF = false;
                    } else {
                        RecommendForumHeaderView.this.cxc();
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
        this.iND = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.iND.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.iND != null) {
            this.iND.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (y.isEmpty(list)) {
            this.iND.setVisibility(8);
            return;
        }
        this.iND.setVisibility(0);
        this.iND.setData(list);
        if (!this.iNF) {
            cxc();
            this.iNF = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iND != null) {
                this.iND.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.iND && this.iNE != null) {
            cxd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.iNH);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxc() {
        if (this.iNE == null) {
            this.iNE = new e(this.mPageContext, this.iND);
            this.iNE.en(R.drawable.bg_tip_blue_up);
            this.iNE.em(32);
            this.iNE.setUseDirectOffset(true);
            this.iNE.eo(3000);
            this.iNE.setYOffset(0);
            this.iNE.e(this);
            this.iNE.aJ(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void cxd() {
        if (this.iNE != null) {
            this.iNE.Tz();
        }
    }

    public void cxe() {
        MessageManager.getInstance().unRegisterListener(this.iNG);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.iND != null) {
            this.iND.setPageId(bdUniqueId);
        }
        this.iNH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iNH);
        this.iNG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iNG);
    }
}

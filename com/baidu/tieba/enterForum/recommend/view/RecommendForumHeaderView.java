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
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private ForumHeaderView faF;
    private ForumTestView faG;
    private com.baidu.tieba.c.d faH;
    private boolean faI;
    private CustomMessageListener faJ;
    private CustomMessageListener faK;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.faI = true;
        this.faJ = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.bgG();
                }
            }
        };
        this.faK = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.faG == null || RecommendForumHeaderView.this.faG.getVisibility() == 8) {
                        RecommendForumHeaderView.this.faI = false;
                    } else {
                        RecommendForumHeaderView.this.bgF();
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
        this.faF = (ForumHeaderView) findViewById(R.id.recommend_forum_header_serch_view);
        this.faG = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.faG.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.faK);
        MessageManager.getInstance().registerListener(this.faJ);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.faG != null) {
            this.faG.setOnSecectedListener(aVar);
        }
    }

    public void setSearchHint(String str) {
        if (this.faF != null) {
            this.faF.setSearchHint(str);
        }
    }

    public void setData(List<f> list) {
        if (v.aa(list)) {
            this.faG.setVisibility(8);
            return;
        }
        this.faG.setVisibility(0);
        this.faG.setData(list);
        if (!this.faI) {
            bgF();
            this.faI = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.faF != null) {
                this.faF.onChangeSkinType();
            }
            if (this.faG != null) {
                this.faG.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.faG && this.faH != null) {
            bgG();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.faK);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgF() {
        if (this.faH == null) {
            this.faH = new com.baidu.tieba.c.d(this.mPageContext, this.faG);
            this.faH.qb(R.drawable.bg_tip_blue_up);
            this.faH.qa(32);
            this.faH.S(true);
            this.faH.qc(3000);
            this.faH.setYOffset(0);
            this.faH.q(this);
            this.faH.cI(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void bgG() {
        if (this.faH != null) {
            this.faH.bbz();
        }
    }

    public void bgH() {
        MessageManager.getInstance().unRegisterListener(this.faJ);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.faG != null) {
            this.faG.setPageId(bdUniqueId);
        }
    }
}

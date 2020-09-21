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
/* loaded from: classes21.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private ForumTestView hGZ;
    private e hHa;
    private boolean hHb;
    private CustomMessageListener hHc;
    private CustomMessageListener hHd;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.hHb = true;
        this.hHc = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.cjL();
                }
            }
        };
        this.hHd = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.hGZ == null || RecommendForumHeaderView.this.hGZ.getVisibility() == 8) {
                        RecommendForumHeaderView.this.hHb = false;
                    } else {
                        RecommendForumHeaderView.this.cjK();
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
        this.hGZ = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.hGZ.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.hGZ != null) {
            this.hGZ.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (y.isEmpty(list)) {
            this.hGZ.setVisibility(8);
            return;
        }
        this.hGZ.setVisibility(0);
        this.hGZ.setData(list);
        if (!this.hHb) {
            cjK();
            this.hHb = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.hGZ != null) {
                this.hGZ.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.hGZ && this.hHa != null) {
            cjL();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.hHd);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjK() {
        if (this.hHa == null) {
            this.hHa = new e(this.mPageContext, this.hGZ);
            this.hHa.eW(R.drawable.bg_tip_blue_up);
            this.hHa.eV(32);
            this.hHa.setUseDirectOffset(true);
            this.hHa.eX(3000);
            this.hHa.setYOffset(0);
            this.hHa.c(this);
            this.hHa.aG(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void cjL() {
        if (this.hHa != null) {
            this.hHa.Oj();
        }
    }

    public void cjM() {
        MessageManager.getInstance().unRegisterListener(this.hHc);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.hGZ != null) {
            this.hGZ.setPageId(bdUniqueId);
        }
        this.hHd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hHd);
        this.hHc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hHc);
    }
}

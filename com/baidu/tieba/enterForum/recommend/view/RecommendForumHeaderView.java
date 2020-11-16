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
import com.baidu.tieba.d.e;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes21.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {
    private ForumTestView iph;
    private e ipi;
    private boolean ipj;
    private CustomMessageListener ipk;
    private CustomMessageListener ipl;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.ipj = true;
        this.ipk = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921386) {
                    RecommendForumHeaderView.this.css();
                }
            }
        };
        this.ipl = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendForumHeaderView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921385) {
                    if (RecommendForumHeaderView.this.iph == null || RecommendForumHeaderView.this.iph.getVisibility() == 8) {
                        RecommendForumHeaderView.this.ipj = false;
                    } else {
                        RecommendForumHeaderView.this.csr();
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
        this.iph = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.iph.setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnSecectedListener(ForumTestView.a aVar) {
        if (this.iph != null) {
            this.iph.setOnSecectedListener(aVar);
        }
    }

    public void setData(List<f> list) {
        if (y.isEmpty(list)) {
            this.iph.setVisibility(8);
            return;
        }
        this.iph.setVisibility(0);
        this.iph.setData(list);
        if (!this.ipj) {
            csr();
            this.ipj = true;
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iph != null) {
                this.iph.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.iph && this.ipi != null) {
            css();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.ipl);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csr() {
        if (this.ipi == null) {
            this.ipi = new e(this.mPageContext, this.iph);
            this.ipi.fq(R.drawable.bg_tip_blue_up);
            this.ipi.fp(32);
            this.ipi.setUseDirectOffset(true);
            this.ipi.fr(3000);
            this.ipi.setYOffset(0);
            this.ipi.d(this);
            this.ipi.aL(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void css() {
        if (this.ipi != null) {
            this.ipi.Si();
        }
    }

    public void cst() {
        MessageManager.getInstance().unRegisterListener(this.ipk);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.iph != null) {
            this.iph.setPageId(bdUniqueId);
        }
        this.ipl.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ipl);
        this.ipk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ipk);
    }
}

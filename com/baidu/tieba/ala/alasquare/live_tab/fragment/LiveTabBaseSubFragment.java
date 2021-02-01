package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public abstract class LiveTabBaseSubFragment extends BaseFragment {
    protected String fNd;
    protected LinearLayout gBc;
    private h gBd;
    protected String gBf;
    protected Context mContext;
    public final String gBb = "c13008";
    protected boolean gAy = false;
    protected boolean gBe = false;
    protected CustomMessageListener gBg = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.gBe = false;
            }
        }
    };

    public abstract void Ut();

    public abstract void bRA();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void bRy() {
        this.gBc.setVisibility(0);
        if (this.gBd == null) {
            this.gBd = new h(this.mContext, null);
        }
        this.gBd.hideRefreshButton();
        this.gBd.rn(R.drawable.new_pic_emotion_03);
        this.gBd.Dm(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.gBd.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.gBd.getAttachedView() != null && this.gBd.getAttachedView().getParent() == null) {
            this.gBc.addView(this.gBd.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.gBc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bRz() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.gBe = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gBd != null) {
            this.gBd.onChangeSkinType();
        }
    }

    public void eg(String str, String str2) {
        this.fNd = str;
        this.gBf = str2;
    }

    public boolean blu() {
        return (au.isEmpty(this.fNd) || au.isEmpty(this.gBf)) ? false : true;
    }
}

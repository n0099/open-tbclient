package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public abstract class LiveTabBaseSubFragment extends BaseFragment {
    protected LinearLayout eml;
    private h emm;
    protected String emo;
    protected String emp;
    protected Context mContext;
    protected boolean elK = false;
    protected boolean emn = false;
    protected CustomMessageListener emq = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.emn = false;
            }
        }
    };

    public abstract void AC();

    public abstract void bcD();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiu() {
        this.eml.setVisibility(0);
        if (this.emm == null) {
            this.emm = new h(this.mContext, null);
        }
        this.emm.hideRefreshButton();
        this.emm.mE(R.drawable.new_pic_emotion_03);
        this.emm.vz(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.emm.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.emm.getAttachedView() != null && this.emm.getAttachedView().getParent() == null) {
            this.eml.addView(this.emm.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.eml.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bcC() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.emn = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.emm != null) {
            this.emm.onChangeSkinType();
        }
    }

    public void cP(String str, String str2) {
        this.emo = str;
        this.emp = str2;
    }
}

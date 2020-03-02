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
    protected LinearLayout elY;
    private h elZ;
    protected String emb;
    protected String emc;
    protected Context mContext;
    protected boolean elx = false;
    protected boolean ema = false;
    protected CustomMessageListener emd = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.ema = false;
            }
        }
    };

    public abstract void AC();

    public abstract void bcC();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiu() {
        this.elY.setVisibility(0);
        if (this.elZ == null) {
            this.elZ = new h(this.mContext, null);
        }
        this.elZ.hideRefreshButton();
        this.elZ.mE(R.drawable.new_pic_emotion_03);
        this.elZ.vy(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.elZ.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.elZ.getAttachedView() != null && this.elZ.getAttachedView().getParent() == null) {
            this.elY.addView(this.elZ.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.elY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bcB() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.ema = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.elZ != null) {
            this.elZ.onChangeSkinType();
        }
    }

    public void cP(String str, String str2) {
        this.emb = str;
        this.emc = str2;
    }
}

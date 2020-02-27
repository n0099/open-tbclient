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
    protected LinearLayout elX;
    private h elY;
    protected String ema;
    protected String emb;
    protected Context mContext;
    protected boolean elw = false;
    protected boolean elZ = false;
    protected CustomMessageListener emc = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.elZ = false;
            }
        }
    };

    public abstract void AA();

    public abstract void bcA();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void ais() {
        this.elX.setVisibility(0);
        if (this.elY == null) {
            this.elY = new h(this.mContext, null);
        }
        this.elY.hideRefreshButton();
        this.elY.mE(R.drawable.new_pic_emotion_03);
        this.elY.vy(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.elY.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.elY.getAttachedView() != null && this.elY.getAttachedView().getParent() == null) {
            this.elX.addView(this.elY.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.elX.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bcz() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.elZ = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.elY != null) {
            this.elY.onChangeSkinType();
        }
    }

    public void cP(String str, String str2) {
        this.ema = str;
        this.emb = str2;
    }
}

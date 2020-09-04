package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public abstract class LiveTabBaseSubFragment extends BaseFragment {
    protected String eVx;
    protected LinearLayout fET;
    private h fEU;
    protected String fEW;
    protected Context mContext;
    public final String fES = "c13008";
    protected boolean fEp = false;
    protected boolean fEV = false;
    protected CustomMessageListener fEX = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.fEV = false;
            }
        }
    };

    public abstract void OA();

    public abstract void bGd();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void bGb() {
        this.fET.setVisibility(0);
        if (this.fEU == null) {
            this.fEU = new h(this.mContext, null);
        }
        this.fEU.hideRefreshButton();
        this.fEU.qt(R.drawable.new_pic_emotion_03);
        this.fEU.Co(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.fEU.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.fEU.getAttachedView() != null && this.fEU.getAttachedView().getParent() == null) {
            this.fET.addView(this.fEU.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.fET.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bGc() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.fEV = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fEU != null) {
            this.fEU.onChangeSkinType();
        }
    }

    public void dT(String str, String str2) {
        this.eVx = str;
        this.fEW = str2;
    }

    public boolean bcm() {
        return (at.isEmpty(this.eVx) || at.isEmpty(this.fEW)) ? false : true;
    }
}

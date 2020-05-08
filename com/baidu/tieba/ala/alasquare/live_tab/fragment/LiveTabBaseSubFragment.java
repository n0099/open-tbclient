package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public abstract class LiveTabBaseSubFragment extends BaseFragment {
    protected LinearLayout eQh;
    private h eQi;
    protected String eQk;
    protected String eQl;
    protected Context mContext;
    protected boolean ePF = false;
    protected boolean eQj = false;
    protected CustomMessageListener eQm = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.eQj = false;
            }
        }
    };

    public abstract void FG();

    public abstract void blw();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqE() {
        this.eQh.setVisibility(0);
        if (this.eQi == null) {
            this.eQi = new h(this.mContext, null);
        }
        this.eQi.hideRefreshButton();
        this.eQi.mR(R.drawable.new_pic_emotion_03);
        this.eQi.wR(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.eQi.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.eQi.getAttachedView() != null && this.eQi.getAttachedView().getParent() == null) {
            this.eQh.addView(this.eQi.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.eQh.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void blv() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.eQj = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eQi != null) {
            this.eQi.onChangeSkinType();
        }
    }

    public void da(String str, String str2) {
        this.eQk = str;
        this.eQl = str2;
    }

    public boolean aMs() {
        return (aq.isEmpty(this.eQk) || aq.isEmpty(this.eQl)) ? false : true;
    }
}

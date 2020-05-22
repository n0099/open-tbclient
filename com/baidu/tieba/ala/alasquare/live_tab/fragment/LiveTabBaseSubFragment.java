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
    protected String evm;
    protected LinearLayout fcQ;
    private h fcR;
    protected String fcT;
    protected Context mContext;
    protected boolean fcn = false;
    protected boolean fcS = false;
    protected CustomMessageListener fcU = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.fcS = false;
            }
        }
    };

    public abstract void Ho();

    public abstract void bqU();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqS() {
        this.fcQ.setVisibility(0);
        if (this.fcR == null) {
            this.fcR = new h(this.mContext, null);
        }
        this.fcR.hideRefreshButton();
        this.fcR.nt(R.drawable.new_pic_emotion_03);
        this.fcR.yx(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.fcR.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.fcR.getAttachedView() != null && this.fcR.getAttachedView().getParent() == null) {
            this.fcQ.addView(this.fcR.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.fcQ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqT() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.fcS = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fcR != null) {
            this.fcR.onChangeSkinType();
        }
    }

    public void dy(String str, String str2) {
        this.evm = str;
        this.fcT = str2;
    }

    public boolean aSr() {
        return (aq.isEmpty(this.evm) || aq.isEmpty(this.fcT)) ? false : true;
    }
}

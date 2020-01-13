package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public abstract class LiveTabBaseSubFragment extends BaseFragment {
    protected LinearLayout ehS;
    private h ehT;
    protected Context mContext;
    protected boolean ehq = false;
    protected boolean ehU = false;
    protected CustomMessageListener ehV = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.ehU = false;
            }
        }
    };

    public abstract void bal();

    public abstract void loadData();

    public abstract void yj();

    /* JADX INFO: Access modifiers changed from: protected */
    public void age() {
        this.ehS.setVisibility(0);
        if (this.ehT == null) {
            this.ehT = new h(this.mContext, null);
        }
        this.ehT.hideRefreshButton();
        this.ehT.mn(R.drawable.new_pic_emotion_03);
        this.ehT.vh(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.ehT.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.ehT.getAttachedView() != null && this.ehT.getAttachedView().getParent() == null) {
            this.ehS.addView(this.ehT.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.ehS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bak() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.ehU = true;
    }
}

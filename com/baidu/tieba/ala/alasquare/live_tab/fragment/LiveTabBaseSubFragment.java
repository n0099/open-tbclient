package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public abstract class LiveTabBaseSubFragment extends BaseFragment {
    protected String eKO;
    protected LinearLayout ftw;
    private h ftx;
    protected String ftz;
    protected Context mContext;
    protected boolean fsR = false;
    protected boolean fty = false;
    protected CustomMessageListener ftA = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.fty = false;
            }
        }
    };

    public abstract void IH();

    public abstract void bxd();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxb() {
        this.ftw.setVisibility(0);
        if (this.ftx == null) {
            this.ftx = new h(this.mContext, null);
        }
        this.ftx.hideRefreshButton();
        this.ftx.oi(R.drawable.new_pic_emotion_03);
        this.ftx.zX(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.ftx.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.ftx.getAttachedView() != null && this.ftx.getAttachedView().getParent() == null) {
            this.ftw.addView(this.ftx.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.ftw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxc() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.fty = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ftx != null) {
            this.ftx.onChangeSkinType();
        }
    }

    public void dC(String str, String str2) {
        this.eKO = str;
        this.ftz = str2;
    }

    public boolean aTV() {
        return (as.isEmpty(this.eKO) || as.isEmpty(this.ftz)) ? false : true;
    }
}

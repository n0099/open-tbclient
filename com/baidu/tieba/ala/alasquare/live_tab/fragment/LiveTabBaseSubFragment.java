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
    protected LinearLayout fdb;
    private h fdc;
    protected String fde;
    protected Context mContext;
    protected boolean fcy = false;
    protected boolean fdd = false;
    protected CustomMessageListener fdf = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.fdd = false;
            }
        }
    };

    public abstract void Ho();

    public abstract void bqW();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqU() {
        this.fdb.setVisibility(0);
        if (this.fdc == null) {
            this.fdc = new h(this.mContext, null);
        }
        this.fdc.hideRefreshButton();
        this.fdc.nv(R.drawable.new_pic_emotion_03);
        this.fdc.yx(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.fdc.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.fdc.getAttachedView() != null && this.fdc.getAttachedView().getParent() == null) {
            this.fdb.addView(this.fdc.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.fdb.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqV() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.fdd = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fdc != null) {
            this.fdc.onChangeSkinType();
        }
    }

    public void dy(String str, String str2) {
        this.evm = str;
        this.fde = str2;
    }

    public boolean aSr() {
        return (aq.isEmpty(this.evm) || aq.isEmpty(this.fde)) ? false : true;
    }
}

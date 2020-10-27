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
    protected String fsZ;
    protected LinearLayout get;
    private h geu;
    protected String gew;
    protected Context mContext;
    public final String ges = "c13008";
    protected boolean gdO = false;
    protected boolean gev = false;
    protected CustomMessageListener gex = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.gev = false;
            }
        }
    };

    public abstract void Rd();

    public abstract void bMG();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void bME() {
        this.get.setVisibility(0);
        if (this.geu == null) {
            this.geu = new h(this.mContext, null);
        }
        this.geu.hideRefreshButton();
        this.geu.rt(R.drawable.new_pic_emotion_03);
        this.geu.DP(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.geu.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.geu.getAttachedView() != null && this.geu.getAttachedView().getParent() == null) {
            this.get.addView(this.geu.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.get.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bMF() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.gev = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.geu != null) {
            this.geu.onChangeSkinType();
        }
    }

    public void ei(String str, String str2) {
        this.fsZ = str;
        this.gew = str2;
    }

    public boolean bhI() {
        return (at.isEmpty(this.fsZ) || at.isEmpty(this.gew)) ? false : true;
    }
}

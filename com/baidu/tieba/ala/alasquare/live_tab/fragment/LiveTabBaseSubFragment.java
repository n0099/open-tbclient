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
    protected LinearLayout emC;
    private h emD;
    protected String emF;
    protected String emG;
    protected Context mContext;
    protected boolean ema = false;
    protected boolean emE = false;
    protected CustomMessageListener emH = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.emE = false;
            }
        }
    };

    public abstract void AJ();

    public abstract void bcH();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void aix() {
        this.emC.setVisibility(0);
        if (this.emD == null) {
            this.emD = new h(this.mContext, null);
        }
        this.emD.hideRefreshButton();
        this.emD.mG(R.drawable.new_pic_emotion_03);
        this.emD.vy(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.emD.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.emD.getAttachedView() != null && this.emD.getAttachedView().getParent() == null) {
            this.emC.addView(this.emD.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.emC.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bcG() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.emE = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.emD != null) {
            this.emD.onChangeSkinType();
        }
    }

    public void cO(String str, String str2) {
        this.emF = str;
        this.emG = str2;
    }
}

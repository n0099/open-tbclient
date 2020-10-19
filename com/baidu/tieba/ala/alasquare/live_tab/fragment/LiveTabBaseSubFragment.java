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
    protected LinearLayout fUp;
    private h fUq;
    protected String fUs;
    protected String fkA;
    protected Context mContext;
    public final String fUo = "c13008";
    protected boolean fTL = false;
    protected boolean fUr = false;
    protected CustomMessageListener fUt = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.fUr = false;
            }
        }
    };

    public abstract void Qi();

    public abstract void bKe();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void bKc() {
        this.fUp.setVisibility(0);
        if (this.fUq == null) {
            this.fUq = new h(this.mContext, null);
        }
        this.fUq.hideRefreshButton();
        this.fUq.ri(R.drawable.new_pic_emotion_03);
        this.fUq.Dw(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.fUq.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.fUq.getAttachedView() != null && this.fUq.getAttachedView().getParent() == null) {
            this.fUp.addView(this.fUq.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.fUp.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bKd() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.fUr = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fUq != null) {
            this.fUq.onChangeSkinType();
        }
    }

    public void eb(String str, String str2) {
        this.fkA = str;
        this.fUs = str2;
    }

    public boolean bfP() {
        return (at.isEmpty(this.fkA) || at.isEmpty(this.fUs)) ? false : true;
    }
}

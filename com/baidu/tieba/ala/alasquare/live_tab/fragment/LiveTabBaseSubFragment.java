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
    protected String eVt;
    protected LinearLayout fEP;
    private h fEQ;
    protected String fES;
    protected Context mContext;
    public final String fEO = "c13008";
    protected boolean fEl = false;
    protected boolean fER = false;
    protected CustomMessageListener fET = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.fER = false;
            }
        }
    };

    public abstract void OA();

    public abstract void bGc();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void bGa() {
        this.fEP.setVisibility(0);
        if (this.fEQ == null) {
            this.fEQ = new h(this.mContext, null);
        }
        this.fEQ.hideRefreshButton();
        this.fEQ.qt(R.drawable.new_pic_emotion_03);
        this.fEQ.Cn(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.fEQ.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.fEQ.getAttachedView() != null && this.fEQ.getAttachedView().getParent() == null) {
            this.fEP.addView(this.fEQ.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.fEP.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bGb() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.fER = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fEQ != null) {
            this.fEQ.onChangeSkinType();
        }
    }

    public void dS(String str, String str2) {
        this.eVt = str;
        this.fES = str2;
    }

    public boolean bcm() {
        return (at.isEmpty(this.eVt) || at.isEmpty(this.fES)) ? false : true;
    }
}

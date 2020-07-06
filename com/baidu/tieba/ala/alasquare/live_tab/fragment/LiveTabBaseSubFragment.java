package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public abstract class LiveTabBaseSubFragment extends BaseFragment {
    protected String eEs;
    protected LinearLayout fol;
    private h fom;
    protected String foo;
    protected Context mContext;
    protected boolean fnI = false;
    protected boolean fon = false;
    protected CustomMessageListener fop = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.fon = false;
            }
        }
    };

    public abstract void IB();

    public abstract void btU();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void btS() {
        this.fol.setVisibility(0);
        if (this.fom == null) {
            this.fom = new h(this.mContext, null);
        }
        this.fom.hideRefreshButton();
        this.fom.nQ(R.drawable.new_pic_emotion_03);
        this.fom.yQ(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.fom.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.fom.getAttachedView() != null && this.fom.getAttachedView().getParent() == null) {
            this.fol.addView(this.fom.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.fol.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void btT() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.fon = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fom != null) {
            this.fom.onChangeSkinType();
        }
    }

    public void dC(String str, String str2) {
        this.eEs = str;
        this.foo = str2;
    }

    public boolean aUi() {
        return (ar.isEmpty(this.eEs) || ar.isEmpty(this.foo)) ? false : true;
    }
}

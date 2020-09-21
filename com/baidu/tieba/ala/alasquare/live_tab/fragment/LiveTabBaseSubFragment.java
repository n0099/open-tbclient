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
    protected String eYo;
    protected LinearLayout fIf;
    private h fIg;
    protected String fIi;
    protected Context mContext;
    public final String fIe = "c13008";
    protected boolean fHB = false;
    protected boolean fIh = false;
    protected CustomMessageListener fIj = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.fIh = false;
            }
        }
    };

    public abstract void Pd();

    public abstract void bHt();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void bHr() {
        this.fIf.setVisibility(0);
        if (this.fIg == null) {
            this.fIg = new h(this.mContext, null);
        }
        this.fIg.hideRefreshButton();
        this.fIg.qK(R.drawable.new_pic_emotion_03);
        this.fIg.CK(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.fIg.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.fIg.getAttachedView() != null && this.fIg.getAttachedView().getParent() == null) {
            this.fIf.addView(this.fIg.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.fIf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bHs() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.fIh = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fIg != null) {
            this.fIg.onChangeSkinType();
        }
    }

    public void dV(String str, String str2) {
        this.eYo = str;
        this.fIi = str2;
    }

    public boolean bdg() {
        return (at.isEmpty(this.eYo) || at.isEmpty(this.fIi)) ? false : true;
    }
}

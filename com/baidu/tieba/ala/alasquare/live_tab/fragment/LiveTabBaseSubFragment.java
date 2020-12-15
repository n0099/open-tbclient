package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public abstract class LiveTabBaseSubFragment extends BaseFragment {
    protected String fFV;
    protected LinearLayout gsa;
    private h gsb;
    protected String gsd;
    protected Context mContext;
    public final String grZ = "c13008";
    protected boolean grw = false;
    protected boolean gsc = false;
    protected CustomMessageListener gse = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.gsc = false;
            }
        }
    };

    public abstract void VC();

    public abstract void bSl();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSj() {
        this.gsa.setVisibility(0);
        if (this.gsb == null) {
            this.gsb = new h(this.mContext, null);
        }
        this.gsb.hideRefreshButton();
        this.gsb.sC(R.drawable.new_pic_emotion_03);
        this.gsb.Ek(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.gsb.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.gsb.getAttachedView() != null && this.gsb.getAttachedView().getParent() == null) {
            this.gsa.addView(this.gsb.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.gsa.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSk() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.gsc = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gsb != null) {
            this.gsb.onChangeSkinType();
        }
    }

    public void ek(String str, String str2) {
        this.fFV = str;
        this.gsd = str2;
    }

    public boolean bmu() {
        return (au.isEmpty(this.fFV) || au.isEmpty(this.gsd)) ? false : true;
    }
}

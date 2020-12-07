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
    protected LinearLayout grY;
    private h grZ;
    protected String gsb;
    protected Context mContext;
    public final String grX = "c13008";
    protected boolean gru = false;
    protected boolean gsa = false;
    protected CustomMessageListener gsc = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.gsa = false;
            }
        }
    };

    public abstract void VC();

    public abstract void bSk();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSi() {
        this.grY.setVisibility(0);
        if (this.grZ == null) {
            this.grZ = new h(this.mContext, null);
        }
        this.grZ.hideRefreshButton();
        this.grZ.sC(R.drawable.new_pic_emotion_03);
        this.grZ.Ek(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.grZ.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.grZ.getAttachedView() != null && this.grZ.getAttachedView().getParent() == null) {
            this.grY.addView(this.grZ.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.grY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSj() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.gsa = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.grZ != null) {
            this.grZ.onChangeSkinType();
        }
    }

    public void ek(String str, String str2) {
        this.fFV = str;
        this.gsb = str2;
    }

    public boolean bmu() {
        return (au.isEmpty(this.fFV) || au.isEmpty(this.gsb)) ? false : true;
    }
}

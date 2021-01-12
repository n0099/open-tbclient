package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public abstract class LiveTabBaseSubFragment extends BaseFragment {
    protected String fKR;
    protected LinearLayout gys;
    private h gyt;
    protected String gyv;
    protected Context mContext;
    public final String gyr = "c13008";
    protected boolean gxO = false;
    protected boolean gyu = false;
    protected CustomMessageListener gyw = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.gyu = false;
            }
        }
    };

    public abstract void SM();

    public abstract void bQW();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void bQU() {
        this.gys.setVisibility(0);
        if (this.gyt == null) {
            this.gyt = new h(this.mContext, null);
        }
        this.gyt.hideRefreshButton();
        this.gyt.ri(R.drawable.new_pic_emotion_03);
        this.gyt.CV(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.gyt.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.gyt.getAttachedView() != null && this.gyt.getAttachedView().getParent() == null) {
            this.gys.addView(this.gyt.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.gys.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bQV() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.gyu = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gyt != null) {
            this.gyt.onChangeSkinType();
        }
    }

    public void ei(String str, String str2) {
        this.fKR = str;
        this.gyv = str2;
    }

    public boolean blc() {
        return (at.isEmpty(this.fKR) || at.isEmpty(this.gyv)) ? false : true;
    }
}

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
    protected String fyR;
    protected LinearLayout gki;
    private h gkj;
    protected String gkl;
    protected Context mContext;
    public final String gkh = "c13008";
    protected boolean gjE = false;
    protected boolean gkk = false;
    protected CustomMessageListener gkm = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.gkk = false;
            }
        }
    };

    public abstract void TL();

    public abstract void bPg();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPe() {
        this.gki.setVisibility(0);
        if (this.gkj == null) {
            this.gkj = new h(this.mContext, null);
        }
        this.gkj.hideRefreshButton();
        this.gkj.rD(R.drawable.new_pic_emotion_03);
        this.gkj.Ed(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.gkj.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.gkj.getAttachedView() != null && this.gkj.getAttachedView().getParent() == null) {
            this.gki.addView(this.gkj.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.gki.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPf() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.gkk = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gkj != null) {
            this.gkj.onChangeSkinType();
        }
    }

    public void ei(String str, String str2) {
        this.fyR = str;
        this.gkl = str2;
    }

    public boolean bki() {
        return (at.isEmpty(this.fyR) || at.isEmpty(this.gkl)) ? false : true;
    }
}

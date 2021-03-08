package com.baidu.tieba.faceshop.emotioncenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.a.b;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import com.baidu.tieba.faceshop.emotioncenter.model.EmotionCenterModel;
import com.baidu.tieba.newfaceshop.facemake.e;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class EmotionRecommendFragment extends BaseFragment implements b {
    private com.baidu.tieba.faceshop.emotioncenter.view.a iZR;
    private EmotionCenterModel iZS = null;
    private boolean gEY = true;
    private boolean mHasMore = false;
    private boolean isLoading = false;
    private boolean iZT = false;
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable() && EmotionRecommendFragment.this.iZS != null && EmotionRecommendFragment.this.iZR != null && EmotionRecommendFragment.this.iZR.cAm() != null && EmotionRecommendFragment.this.iZR.cAm().getVisibility() == 0) {
                EmotionRecommendFragment.this.iZS.a(EmotionRecommendFragment.this);
            }
        }
    };
    private CustomMessageListener iZU = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            EmotionPackageData emotionPackageData;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof EmotionPackageData) && (emotionPackageData = (EmotionPackageData) customResponsedMessage.getData()) != null && EmotionRecommendFragment.this.iZR != null) {
                EmotionRecommendFragment.this.iZR.a(emotionPackageData);
            }
        }
    };
    CustomMessageListener iZC = new CustomMessageListener(CmdConfigCustom.CMD_UPLOAD_FACE_GROUP_FINISH) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                if (hashMap == null || hashMap.isEmpty()) {
                    if (EmotionRecommendFragment.this.iZR != null) {
                        EmotionRecommendFragment.this.iZR.cAn();
                    }
                } else if (!hashMap.containsKey("upload_result")) {
                    if (EmotionRecommendFragment.this.iZR != null) {
                        EmotionRecommendFragment.this.iZR.cAn();
                    }
                } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                    if (EmotionRecommendFragment.this.iZR != null) {
                        EmotionRecommendFragment.this.iZR.cAn();
                    }
                } else if (!((Boolean) hashMap.get("upload_result")).booleanValue()) {
                    if (EmotionRecommendFragment.this.iZR != null) {
                        String str = (String) hashMap.get("upload_msg");
                        if (!TextUtils.isEmpty(str)) {
                            l.showLongToast(EmotionRecommendFragment.this.getActivity(), str);
                        } else {
                            l.showLongToast(EmotionRecommendFragment.this.getActivity(), EmotionRecommendFragment.this.getString(R.string.emotion_error_default_net_tip));
                        }
                        EmotionRecommendFragment.this.iZR.cAp();
                    }
                } else {
                    BdToast.b(EmotionRecommendFragment.this.getPageContext().getPageActivity(), EmotionRecommendFragment.this.getPageContext().getPageActivity().getText(R.string.face_group_upload_success)).bqF();
                    if (EmotionRecommendFragment.this.iZR != null) {
                        EmotionRecommendFragment.this.iZR.cAn();
                    }
                }
            }
        }
    };
    private f.c fkY = new f.c() { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (EmotionRecommendFragment.this.iZS != null && !EmotionRecommendFragment.this.isLoading) {
                EmotionRecommendFragment.this.iZS.a(EmotionRecommendFragment.this);
            }
            EmotionRecommendFragment.this.iZR.cAr().cAj();
        }
    };
    private BdListView.e Yb = new BdListView.e() { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (EmotionRecommendFragment.this.iZS != null && !EmotionRecommendFragment.this.isLoading) {
                if (EmotionRecommendFragment.this.mHasMore) {
                    EmotionRecommendFragment.this.iZR.bRE();
                    EmotionRecommendFragment.this.iZS.b(EmotionRecommendFragment.this);
                    return;
                }
                EmotionRecommendFragment.this.iZR.bRD();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        czZ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iZR = new com.baidu.tieba.faceshop.emotioncenter.view.a(getPageContext(), getUniqueId());
        this.iZR.setListPullRefreshListener(this.fkY);
        this.iZR.setOnSrollToBottomListener(this.Yb);
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.iZU);
        if (this.iZS == null) {
            this.iZS = new EmotionCenterModel(getPageContext());
        }
        registerListener(this.iZC);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iZT = arguments.getBoolean("need_check_login");
        }
        if (!this.iZT) {
            if (this.gEY && this.iZS != null) {
                this.iZS.a(this);
                this.isLoading = true;
                this.gEY = false;
            }
        } else if (bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (this.gEY && this.iZS != null) {
                this.iZS.a(this);
                this.isLoading = true;
                this.gEY = false;
            }
        } else {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
            loginActivityConfig.setJumpToAfterDestroy(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
            getPageContext().getPageActivity().finish();
        }
        return this.iZR.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iZR != null) {
            this.iZR.onChangeSkinType(i);
        }
    }

    public int cAg() {
        if (this.iZR == null) {
            return 0;
        }
        return this.iZR.cAq();
    }

    private void czZ() {
        if (e.diT().diV()) {
            if (this.iZR != null) {
                this.iZR.cAo();
            }
        } else if (this.iZR != null) {
            this.iZR.cAn();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void a(EmotionCenterData emotionCenterData) {
        this.isLoading = false;
        this.iZR.completePullRefresh();
        this.iZR.bSE();
        if (emotionCenterData != null) {
            if (!"1".equals(emotionCenterData.has_more)) {
                this.mHasMore = false;
            } else {
                this.mHasMore = true;
            }
            if (!TextUtils.isEmpty(emotionCenterData.activity_url)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER_ADD_FRAGMENT, emotionCenterData.activity_url));
            }
            this.iZR.d(emotionCenterData);
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void b(EmotionCenterData emotionCenterData) {
        this.isLoading = false;
        this.iZR.bSE();
        if (emotionCenterData != null) {
            this.iZR.e(emotionCenterData);
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void c(EmotionCenterData emotionCenterData) {
    }
}

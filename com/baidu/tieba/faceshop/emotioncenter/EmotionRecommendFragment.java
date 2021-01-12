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
import com.baidu.tbadk.core.util.bg;
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
    private com.baidu.tieba.faceshop.emotioncenter.view.a iSn;
    private EmotionCenterModel iSo = null;
    private boolean gAr = true;
    private boolean mHasMore = false;
    private boolean isLoading = false;
    private boolean iSp = false;
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable() && EmotionRecommendFragment.this.iSo != null && EmotionRecommendFragment.this.iSn != null && EmotionRecommendFragment.this.iSn.cyO() != null && EmotionRecommendFragment.this.iSn.cyO().getVisibility() == 0) {
                EmotionRecommendFragment.this.iSo.a(EmotionRecommendFragment.this);
            }
        }
    };
    private CustomMessageListener iSq = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            EmotionPackageData emotionPackageData;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof EmotionPackageData) && (emotionPackageData = (EmotionPackageData) customResponsedMessage.getData()) != null && EmotionRecommendFragment.this.iSn != null) {
                EmotionRecommendFragment.this.iSn.a(emotionPackageData);
            }
        }
    };
    CustomMessageListener iRY = new CustomMessageListener(CmdConfigCustom.CMD_UPLOAD_FACE_GROUP_FINISH) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                if (hashMap == null || hashMap.isEmpty()) {
                    if (EmotionRecommendFragment.this.iSn != null) {
                        EmotionRecommendFragment.this.iSn.cyP();
                    }
                } else if (!hashMap.containsKey("upload_result")) {
                    if (EmotionRecommendFragment.this.iSn != null) {
                        EmotionRecommendFragment.this.iSn.cyP();
                    }
                } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                    if (EmotionRecommendFragment.this.iSn != null) {
                        EmotionRecommendFragment.this.iSn.cyP();
                    }
                } else if (!((Boolean) hashMap.get("upload_result")).booleanValue()) {
                    if (EmotionRecommendFragment.this.iSn != null) {
                        String str = (String) hashMap.get("upload_msg");
                        if (!TextUtils.isEmpty(str)) {
                            l.showLongToast(EmotionRecommendFragment.this.getActivity(), str);
                        } else {
                            l.showLongToast(EmotionRecommendFragment.this.getActivity(), EmotionRecommendFragment.this.getString(R.string.emotion_error_default_net_tip));
                        }
                        EmotionRecommendFragment.this.iSn.cyR();
                    }
                } else {
                    BdToast.b(EmotionRecommendFragment.this.getPageContext().getPageActivity(), EmotionRecommendFragment.this.getPageContext().getPageActivity().getText(R.string.face_group_upload_success)).bqk();
                    if (EmotionRecommendFragment.this.iSn != null) {
                        EmotionRecommendFragment.this.iSn.cyP();
                    }
                }
            }
        }
    };
    private f.c fhg = new f.c() { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (EmotionRecommendFragment.this.iSo != null && !EmotionRecommendFragment.this.isLoading) {
                EmotionRecommendFragment.this.iSo.a(EmotionRecommendFragment.this);
            }
            EmotionRecommendFragment.this.iSn.cyT().cyL();
        }
    };
    private BdListView.e WL = new BdListView.e() { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (EmotionRecommendFragment.this.iSo != null && !EmotionRecommendFragment.this.isLoading) {
                if (EmotionRecommendFragment.this.mHasMore) {
                    EmotionRecommendFragment.this.iSn.bQN();
                    EmotionRecommendFragment.this.iSo.b(EmotionRecommendFragment.this);
                    return;
                }
                EmotionRecommendFragment.this.iSn.bQM();
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
        cyB();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iSn = new com.baidu.tieba.faceshop.emotioncenter.view.a(getPageContext(), getUniqueId());
        this.iSn.setListPullRefreshListener(this.fhg);
        this.iSn.setOnSrollToBottomListener(this.WL);
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.iSq);
        if (this.iSo == null) {
            this.iSo = new EmotionCenterModel(getPageContext());
        }
        registerListener(this.iRY);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iSp = arguments.getBoolean("need_check_login");
        }
        if (!this.iSp) {
            if (this.gAr && this.iSo != null) {
                this.iSo.a(this);
                this.isLoading = true;
                this.gAr = false;
            }
        } else if (bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (this.gAr && this.iSo != null) {
                this.iSo.a(this);
                this.isLoading = true;
                this.gAr = false;
            }
        } else {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
            loginActivityConfig.setJumpToAfterDestroy(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
            getPageContext().getPageActivity().finish();
        }
        return this.iSn.getView();
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
        if (this.iSn != null) {
            this.iSn.onChangeSkinType(i);
        }
    }

    public int cyI() {
        if (this.iSn == null) {
            return 0;
        }
        return this.iSn.cyS();
    }

    private void cyB() {
        if (e.dgC().dgE()) {
            if (this.iSn != null) {
                this.iSn.cyQ();
            }
        } else if (this.iSn != null) {
            this.iSn.cyP();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void a(EmotionCenterData emotionCenterData) {
        this.isLoading = false;
        this.iSn.completePullRefresh();
        this.iSn.bRO();
        if (emotionCenterData != null) {
            if (!"1".equals(emotionCenterData.has_more)) {
                this.mHasMore = false;
            } else {
                this.mHasMore = true;
            }
            if (!TextUtils.isEmpty(emotionCenterData.activity_url)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER_ADD_FRAGMENT, emotionCenterData.activity_url));
            }
            this.iSn.d(emotionCenterData);
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void b(EmotionCenterData emotionCenterData) {
        this.isLoading = false;
        this.iSn.bRO();
        if (emotionCenterData != null) {
            this.iSn.e(emotionCenterData);
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void c(EmotionCenterData emotionCenterData) {
    }
}

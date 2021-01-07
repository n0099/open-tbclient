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
/* loaded from: classes9.dex */
public class EmotionRecommendFragment extends BaseFragment implements b {
    private com.baidu.tieba.faceshop.emotioncenter.view.a iWU;
    private EmotionCenterModel iWV = null;
    private boolean gEY = true;
    private boolean mHasMore = false;
    private boolean isLoading = false;
    private boolean iWW = false;
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable() && EmotionRecommendFragment.this.iWV != null && EmotionRecommendFragment.this.iWU != null && EmotionRecommendFragment.this.iWU.cCG() != null && EmotionRecommendFragment.this.iWU.cCG().getVisibility() == 0) {
                EmotionRecommendFragment.this.iWV.a(EmotionRecommendFragment.this);
            }
        }
    };
    private CustomMessageListener iWX = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            EmotionPackageData emotionPackageData;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof EmotionPackageData) && (emotionPackageData = (EmotionPackageData) customResponsedMessage.getData()) != null && EmotionRecommendFragment.this.iWU != null) {
                EmotionRecommendFragment.this.iWU.a(emotionPackageData);
            }
        }
    };
    CustomMessageListener iWF = new CustomMessageListener(CmdConfigCustom.CMD_UPLOAD_FACE_GROUP_FINISH) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                if (hashMap == null || hashMap.isEmpty()) {
                    if (EmotionRecommendFragment.this.iWU != null) {
                        EmotionRecommendFragment.this.iWU.cCH();
                    }
                } else if (!hashMap.containsKey("upload_result")) {
                    if (EmotionRecommendFragment.this.iWU != null) {
                        EmotionRecommendFragment.this.iWU.cCH();
                    }
                } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                    if (EmotionRecommendFragment.this.iWU != null) {
                        EmotionRecommendFragment.this.iWU.cCH();
                    }
                } else if (!((Boolean) hashMap.get("upload_result")).booleanValue()) {
                    if (EmotionRecommendFragment.this.iWU != null) {
                        String str = (String) hashMap.get("upload_msg");
                        if (!TextUtils.isEmpty(str)) {
                            l.showLongToast(EmotionRecommendFragment.this.getActivity(), str);
                        } else {
                            l.showLongToast(EmotionRecommendFragment.this.getActivity(), EmotionRecommendFragment.this.getString(R.string.emotion_error_default_net_tip));
                        }
                        EmotionRecommendFragment.this.iWU.cCJ();
                    }
                } else {
                    BdToast.b(EmotionRecommendFragment.this.getPageContext().getPageActivity(), EmotionRecommendFragment.this.getPageContext().getPageActivity().getText(R.string.face_group_upload_success)).bue();
                    if (EmotionRecommendFragment.this.iWU != null) {
                        EmotionRecommendFragment.this.iWU.cCH();
                    }
                }
            }
        }
    };
    private f.c flR = new f.c() { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (EmotionRecommendFragment.this.iWV != null && !EmotionRecommendFragment.this.isLoading) {
                EmotionRecommendFragment.this.iWV.a(EmotionRecommendFragment.this);
            }
            EmotionRecommendFragment.this.iWU.cCL().cCD();
        }
    };
    private BdListView.e WN = new BdListView.e() { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (EmotionRecommendFragment.this.iWV != null && !EmotionRecommendFragment.this.isLoading) {
                if (EmotionRecommendFragment.this.mHasMore) {
                    EmotionRecommendFragment.this.iWU.bUF();
                    EmotionRecommendFragment.this.iWV.b(EmotionRecommendFragment.this);
                    return;
                }
                EmotionRecommendFragment.this.iWU.bUE();
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
        cCt();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iWU = new com.baidu.tieba.faceshop.emotioncenter.view.a(getPageContext(), getUniqueId());
        this.iWU.setListPullRefreshListener(this.flR);
        this.iWU.setOnSrollToBottomListener(this.WN);
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.iWX);
        if (this.iWV == null) {
            this.iWV = new EmotionCenterModel(getPageContext());
        }
        registerListener(this.iWF);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iWW = arguments.getBoolean("need_check_login");
        }
        if (!this.iWW) {
            if (this.gEY && this.iWV != null) {
                this.iWV.a(this);
                this.isLoading = true;
                this.gEY = false;
            }
        } else if (bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (this.gEY && this.iWV != null) {
                this.iWV.a(this);
                this.isLoading = true;
                this.gEY = false;
            }
        } else {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
            loginActivityConfig.setJumpToAfterDestroy(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
            getPageContext().getPageActivity().finish();
        }
        return this.iWU.getView();
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
        if (this.iWU != null) {
            this.iWU.onChangeSkinType(i);
        }
    }

    public int cCA() {
        if (this.iWU == null) {
            return 0;
        }
        return this.iWU.cCK();
    }

    private void cCt() {
        if (e.dku().dkw()) {
            if (this.iWU != null) {
                this.iWU.cCI();
            }
        } else if (this.iWU != null) {
            this.iWU.cCH();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void a(EmotionCenterData emotionCenterData) {
        this.isLoading = false;
        this.iWU.completePullRefresh();
        this.iWU.bVG();
        if (emotionCenterData != null) {
            if (!"1".equals(emotionCenterData.has_more)) {
                this.mHasMore = false;
            } else {
                this.mHasMore = true;
            }
            if (!TextUtils.isEmpty(emotionCenterData.activity_url)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER_ADD_FRAGMENT, emotionCenterData.activity_url));
            }
            this.iWU.d(emotionCenterData);
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void b(EmotionCenterData emotionCenterData) {
        this.isLoading = false;
        this.iWU.bVG();
        if (emotionCenterData != null) {
            this.iWU.e(emotionCenterData);
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void c(EmotionCenterData emotionCenterData) {
    }
}

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
/* loaded from: classes9.dex */
public class EmotionRecommendFragment extends BaseFragment implements b {
    private com.baidu.tieba.faceshop.emotioncenter.view.a iYi;
    private EmotionCenterModel iYj = null;
    private boolean gDp = true;
    private boolean mHasMore = false;
    private boolean isLoading = false;
    private boolean iYk = false;
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable() && EmotionRecommendFragment.this.iYj != null && EmotionRecommendFragment.this.iYi != null && EmotionRecommendFragment.this.iYi.cAg() != null && EmotionRecommendFragment.this.iYi.cAg().getVisibility() == 0) {
                EmotionRecommendFragment.this.iYj.a(EmotionRecommendFragment.this);
            }
        }
    };
    private CustomMessageListener iYl = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            EmotionPackageData emotionPackageData;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof EmotionPackageData) && (emotionPackageData = (EmotionPackageData) customResponsedMessage.getData()) != null && EmotionRecommendFragment.this.iYi != null) {
                EmotionRecommendFragment.this.iYi.a(emotionPackageData);
            }
        }
    };
    CustomMessageListener iXT = new CustomMessageListener(CmdConfigCustom.CMD_UPLOAD_FACE_GROUP_FINISH) { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                if (hashMap == null || hashMap.isEmpty()) {
                    if (EmotionRecommendFragment.this.iYi != null) {
                        EmotionRecommendFragment.this.iYi.cAh();
                    }
                } else if (!hashMap.containsKey("upload_result")) {
                    if (EmotionRecommendFragment.this.iYi != null) {
                        EmotionRecommendFragment.this.iYi.cAh();
                    }
                } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                    if (EmotionRecommendFragment.this.iYi != null) {
                        EmotionRecommendFragment.this.iYi.cAh();
                    }
                } else if (!((Boolean) hashMap.get("upload_result")).booleanValue()) {
                    if (EmotionRecommendFragment.this.iYi != null) {
                        String str = (String) hashMap.get("upload_msg");
                        if (!TextUtils.isEmpty(str)) {
                            l.showLongToast(EmotionRecommendFragment.this.getActivity(), str);
                        } else {
                            l.showLongToast(EmotionRecommendFragment.this.getActivity(), EmotionRecommendFragment.this.getString(R.string.emotion_error_default_net_tip));
                        }
                        EmotionRecommendFragment.this.iYi.cAj();
                    }
                } else {
                    BdToast.b(EmotionRecommendFragment.this.getPageContext().getPageActivity(), EmotionRecommendFragment.this.getPageContext().getPageActivity().getText(R.string.face_group_upload_success)).bqD();
                    if (EmotionRecommendFragment.this.iYi != null) {
                        EmotionRecommendFragment.this.iYi.cAh();
                    }
                }
            }
        }
    };
    private f.c fjz = new f.c() { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (EmotionRecommendFragment.this.iYj != null && !EmotionRecommendFragment.this.isLoading) {
                EmotionRecommendFragment.this.iYj.a(EmotionRecommendFragment.this);
            }
            EmotionRecommendFragment.this.iYi.cAl().cAd();
        }
    };
    private BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.faceshop.emotioncenter.EmotionRecommendFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (EmotionRecommendFragment.this.iYj != null && !EmotionRecommendFragment.this.isLoading) {
                if (EmotionRecommendFragment.this.mHasMore) {
                    EmotionRecommendFragment.this.iYi.bRy();
                    EmotionRecommendFragment.this.iYj.b(EmotionRecommendFragment.this);
                    return;
                }
                EmotionRecommendFragment.this.iYi.bRx();
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
        czT();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iYi = new com.baidu.tieba.faceshop.emotioncenter.view.a(getPageContext(), getUniqueId());
        this.iYi.setListPullRefreshListener(this.fjz);
        this.iYi.setOnSrollToBottomListener(this.WH);
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.iYl);
        if (this.iYj == null) {
            this.iYj = new EmotionCenterModel(getPageContext());
        }
        registerListener(this.iXT);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iYk = arguments.getBoolean("need_check_login");
        }
        if (!this.iYk) {
            if (this.gDp && this.iYj != null) {
                this.iYj.a(this);
                this.isLoading = true;
                this.gDp = false;
            }
        } else if (bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (this.gDp && this.iYj != null) {
                this.iYj.a(this);
                this.isLoading = true;
                this.gDp = false;
            }
        } else {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
            loginActivityConfig.setJumpToAfterDestroy(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
            getPageContext().getPageActivity().finish();
        }
        return this.iYi.getView();
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
        if (this.iYi != null) {
            this.iYi.onChangeSkinType(i);
        }
    }

    public int cAa() {
        if (this.iYi == null) {
            return 0;
        }
        return this.iYi.cAk();
    }

    private void czT() {
        if (e.diK().diM()) {
            if (this.iYi != null) {
                this.iYi.cAi();
            }
        } else if (this.iYi != null) {
            this.iYi.cAh();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void a(EmotionCenterData emotionCenterData) {
        this.isLoading = false;
        this.iYi.completePullRefresh();
        this.iYi.bSy();
        if (emotionCenterData != null) {
            if (!"1".equals(emotionCenterData.has_more)) {
                this.mHasMore = false;
            } else {
                this.mHasMore = true;
            }
            if (!TextUtils.isEmpty(emotionCenterData.activity_url)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER_ADD_FRAGMENT, emotionCenterData.activity_url));
            }
            this.iYi.d(emotionCenterData);
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void b(EmotionCenterData emotionCenterData) {
        this.isLoading = false;
        this.iYi.bSy();
        if (emotionCenterData != null) {
            this.iYi.e(emotionCenterData);
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.b
    public void c(EmotionCenterData emotionCenterData) {
    }
}

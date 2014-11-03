package com.baidu.tieba.im.chat.notify;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.model.ImMessageCenterModel;
import com.baidu.tieba.im.view.ShutDownValidateTipView;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseFragment {
    private ShutDownValidateTipView aQF;
    private DialogInterface.OnClickListener aQH;
    private int aQI;
    private RelativeLayout aQK;
    private com.baidu.tbadk.core.view.o ahX;
    private NoNetworkView aoS;
    private com.baidu.tbadk.core.view.d ayo;
    private ImMessageCenterModel aQA = null;
    private FragmentActivity mActivity = null;
    private ImMessageCenterShowItemData aQB = null;
    private BdListView aQC = null;
    private ImMessageCenterListAdapter aQD = null;
    private p aQE = null;
    AlertDialog aQG = null;
    private boolean aQJ = true;
    private final AdapterView.OnItemClickListener aQL = new h(this);
    private final AdapterView.OnItemLongClickListener aQM = new j(this);
    private final com.baidu.adp.widget.ListView.f aQN = new k(this);
    private final CustomMessageListener aQO = new l(this, 0);
    private a aQP = new m(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aQI = -1;
        this.mActivity = getActivity();
        View inflate = layoutInflater.inflate(w.chat_list_activity, viewGroup, false);
        G(inflate);
        TiebaStatic.eventStat(this.mActivity, "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(2016003, this.aQO);
        registerListener(2016000, this.aQO);
        registerListener(2016010, this.aQO);
        registerListener(2016006, this.aQO);
        registerListener(2016011, this.aQO);
        registerListener(2016001, this.aQO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.aQD != null) {
            this.aQD.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.aQO);
    }

    private void initData() {
        this.aQA = new ImMessageCenterModel(this.mActivity);
        cF(com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void G(View view) {
        this.aQK = (RelativeLayout) view.findViewById(v.chat_list);
        this.ahX = NoDataViewFactory.a(this.mActivity, this.aQK, r.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(t.ds80)), s.bL(y.no_recent_chat), null);
        this.aQF = (ShutDownValidateTipView) view.findViewById(v.view_no_validate);
        this.aQF.setVisibility(8);
        this.aQF.setShutDownClickListener(new n(this));
        this.aQC = (BdListView) view.findViewById(v.chat_list_content);
        this.aQC.setDividerHeight(0);
        this.aQE = new p(this.mActivity);
        this.aQE.a(this.aQN);
        this.aQC.setPullRefresh(this.aQE);
        this.aQD = new ImMessageCenterListAdapter(this.mActivity);
        this.aQD.g(this);
        this.aQC.setAdapter((ListAdapter) this.aQD);
        this.aQC.setOnItemClickListener(this.aQL);
        this.aQC.setOnItemLongClickListener(this.aQM);
        this.aQC.hO();
        this.aoS = (NoNetworkView) this.aQK.findViewById(v.view_no_network);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.aQI != i) {
            this.aQI = i;
            if (this.ahX != null) {
                this.ahX.onChangeSkinType(i);
            }
            if (this.aQF != null) {
                this.aQF.onChangeSkinType(i);
            }
            if (this.aQE != null) {
                this.aQE.bM(i);
            }
            if (this.ayo != null) {
                this.ayo.bG(i);
            }
            if (this.aQD != null) {
                this.aQD.notifyDataSetChanged();
            }
            if (this.mActivity != null && (this.mActivity instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.mActivity).getLayoutMode().L(i == 1);
                ((BaseFragmentActivity) this.mActivity).getLayoutMode().h(this.aQK);
            }
            if (this.aoS != null) {
                this.aoS.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.ahX.nv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ayo != null) {
            this.ayo.onStop();
        }
        this.ahX.onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aQH = new o(this, imMessageCenterShowItemData);
        String string = this.mActivity.getString(y.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mActivity);
        builder.setTitle(y.operation);
        builder.setItems(new String[]{string}, this.aQH);
        this.aQG = builder.create();
        this.aQG.setCanceledOnTouchOutside(true);
    }

    public void cD(boolean z) {
        if (z) {
            if (Kp() && this.aQF.getVisibility() != 0) {
                this.aQF.setVisibility(0);
            }
        } else if (this.aQF.getVisibility() != 8) {
            this.aQF.setVisibility(8);
        }
    }

    public void cE(boolean z) {
        if (z) {
            this.ahX.setVisibility(0);
        } else {
            this.ahX.setVisibility(8);
        }
        if (!isAdded()) {
        }
    }

    public boolean Kp() {
        return this.aQJ;
    }

    public void cF(boolean z) {
        this.aQJ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.aQA != null) {
                    this.aQA.insertOrUpdate(data, this.aQP);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.aQA != null) {
                this.aQA.remove(data, this.aQP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.aQA != null) {
                this.aQA.setData(data, this.aQP);
            }
        }
    }
}

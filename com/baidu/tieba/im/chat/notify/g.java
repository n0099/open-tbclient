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
    private ShutDownValidateTipView aQr;
    private DialogInterface.OnClickListener aQt;
    private int aQu;
    private RelativeLayout aQw;
    private com.baidu.tbadk.core.view.o ahO;
    private NoNetworkView aoJ;
    private com.baidu.tbadk.core.view.d ayf;
    private ImMessageCenterModel aQm = null;
    private FragmentActivity mActivity = null;
    private ImMessageCenterShowItemData aQn = null;
    private BdListView aQo = null;
    private ImMessageCenterListAdapter aQp = null;
    private p aQq = null;
    AlertDialog aQs = null;
    private boolean aQv = true;
    private final AdapterView.OnItemClickListener aQx = new h(this);
    private final AdapterView.OnItemLongClickListener aQy = new j(this);
    private final com.baidu.adp.widget.ListView.f aQz = new k(this);
    private final CustomMessageListener aQA = new l(this, 0);
    private a aQB = new m(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aQu = -1;
        this.mActivity = getActivity();
        View inflate = layoutInflater.inflate(w.chat_list_activity, viewGroup, false);
        G(inflate);
        TiebaStatic.eventStat(this.mActivity, "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(2016003, this.aQA);
        registerListener(2016000, this.aQA);
        registerListener(2016010, this.aQA);
        registerListener(2016006, this.aQA);
        registerListener(2016011, this.aQA);
        registerListener(2016001, this.aQA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.aQp != null) {
            this.aQp.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.aQA);
    }

    private void initData() {
        this.aQm = new ImMessageCenterModel(this.mActivity);
        cF(com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void G(View view) {
        this.aQw = (RelativeLayout) view.findViewById(v.chat_list);
        this.ahO = NoDataViewFactory.a(this.mActivity, this.aQw, r.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(t.ds80)), s.bL(y.no_recent_chat), null);
        this.aQr = (ShutDownValidateTipView) view.findViewById(v.view_no_validate);
        this.aQr.setVisibility(8);
        this.aQr.setShutDownClickListener(new n(this));
        this.aQo = (BdListView) view.findViewById(v.chat_list_content);
        this.aQo.setDividerHeight(0);
        this.aQq = new p(this.mActivity);
        this.aQq.a(this.aQz);
        this.aQo.setPullRefresh(this.aQq);
        this.aQp = new ImMessageCenterListAdapter(this.mActivity);
        this.aQp.g(this);
        this.aQo.setAdapter((ListAdapter) this.aQp);
        this.aQo.setOnItemClickListener(this.aQx);
        this.aQo.setOnItemLongClickListener(this.aQy);
        this.aQo.hO();
        this.aoJ = (NoNetworkView) this.aQw.findViewById(v.view_no_network);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.aQu != i) {
            this.aQu = i;
            if (this.ahO != null) {
                this.ahO.onChangeSkinType(i);
            }
            if (this.aQr != null) {
                this.aQr.onChangeSkinType(i);
            }
            if (this.aQq != null) {
                this.aQq.bM(i);
            }
            if (this.ayf != null) {
                this.ayf.bG(i);
            }
            if (this.aQp != null) {
                this.aQp.notifyDataSetChanged();
            }
            if (this.mActivity != null && (this.mActivity instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.mActivity).getLayoutMode().L(i == 1);
                ((BaseFragmentActivity) this.mActivity).getLayoutMode().h(this.aQw);
            }
            if (this.aoJ != null) {
                this.aoJ.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.ahO.nv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ayf != null) {
            this.ayf.onStop();
        }
        this.ahO.onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aQt = new o(this, imMessageCenterShowItemData);
        String string = this.mActivity.getString(y.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mActivity);
        builder.setTitle(y.operation);
        builder.setItems(new String[]{string}, this.aQt);
        this.aQs = builder.create();
        this.aQs.setCanceledOnTouchOutside(true);
    }

    public void cD(boolean z) {
        if (z) {
            if (Kl() && this.aQr.getVisibility() != 0) {
                this.aQr.setVisibility(0);
            }
        } else if (this.aQr.getVisibility() != 8) {
            this.aQr.setVisibility(8);
        }
    }

    public void cE(boolean z) {
        if (z) {
            this.ahO.setVisibility(0);
        } else {
            this.ahO.setVisibility(8);
        }
        if (!isAdded()) {
        }
    }

    public boolean Kl() {
        return this.aQv;
    }

    public void cF(boolean z) {
        this.aQv = z;
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
                if (this.aQm != null) {
                    this.aQm.insertOrUpdate(data, this.aQB);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.aQm != null) {
                this.aQm.remove(data, this.aQB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.aQm != null) {
                this.aQm.setData(data, this.aQB);
            }
        }
    }
}

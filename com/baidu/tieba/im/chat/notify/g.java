package com.baidu.tieba.im.chat.notify;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.model.ImMessageCenterModel;
import com.baidu.tieba.im.view.ShutDownValidateTipView;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseFragment {
    private com.baidu.tbadk.core.view.l aBs;
    private ShutDownValidateTipView aTs;
    private DialogInterface.OnClickListener aTu;
    private int aTv;
    private RelativeLayout aTx;
    private x mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ImMessageCenterModel aTm = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> aTn = null;
    private ImMessageCenterShowItemData aTo = null;
    private BdListView aTp = null;
    private ImMessageCenterListAdapter aTq = null;
    private q aTr = null;
    AlertDialog aTt = null;
    private boolean aTw = true;
    private final AdapterView.OnItemClickListener aTy = new h(this);
    private final AdapterView.OnItemLongClickListener aTz = new j(this);
    private final com.baidu.adp.widget.ListView.g aTA = new k(this);
    private final CustomMessageListener aTB = new l(this, 0);
    private a aTC = new m(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aTv = -1;
        this.aTn = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(com.baidu.tieba.x.chat_list_activity, viewGroup, false);
        t(inflate);
        TiebaStatic.eventStat(this.aTn.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(2016003, this.aTB);
        registerListener(2016000, this.aTB);
        registerListener(2016010, this.aTB);
        registerListener(2016006, this.aTB);
        registerListener(2016011, this.aTB);
        registerListener(2016001, this.aTB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.aTq != null) {
            this.aTq.notifyDataSetChanged();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.aTB);
    }

    private void initData() {
        this.aTm = new ImMessageCenterModel();
        cx(com.baidu.tbadk.core.sharedPref.b.oc().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void t(View view) {
        this.aTx = (RelativeLayout) view.findViewById(w.chat_list);
        this.mNoDataView = NoDataViewFactory.a(this.aTn.getPageContext().getPageActivity(), this.aTx, aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(u.ds80)), ab.cp(z.no_recent_chat), null);
        this.aTs = (ShutDownValidateTipView) view.findViewById(w.view_no_validate);
        this.aTs.setVisibility(8);
        this.aTs.setShutDownClickListener(new n(this));
        this.aTp = (BdListView) view.findViewById(w.chat_list_content);
        this.aTp.setDividerHeight(0);
        this.aTr = new q(getBaseFragmentActivity().getPageContext());
        this.aTr.a(this.aTA);
        this.aTp.setPullRefresh(this.aTr);
        this.aTq = new ImMessageCenterListAdapter(this.aTn.getPageContext().getPageActivity());
        this.aTq.g(this);
        this.aTp.setAdapter((ListAdapter) this.aTq);
        this.aTp.setOnItemClickListener(this.aTy);
        this.aTp.setOnItemLongClickListener(this.aTz);
        this.aTp.jC();
        this.mNoNetworkView = (NoNetworkView) this.aTx.findViewById(w.view_no_network);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.aTv != i) {
            this.aTv = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.aTn.getPageContext(), i);
            }
            if (this.aTs != null) {
                this.aTs.onChangeSkinType(i);
            }
            if (this.aTr != null) {
                this.aTr.cs(i);
            }
            if (this.aBs != null) {
                this.aBs.ck(i);
            }
            if (this.aTq != null) {
                this.aTq.notifyDataSetChanged();
            }
            if (this.aTn != null && (this.aTn instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.aTn).getLayoutMode().ab(i == 1);
                ((BaseFragmentActivity) this.aTn).getLayoutMode().h(this.aTx);
            }
            if (this.mNoNetworkView != null) {
                this.mNoNetworkView.onChangeSkinType(this.aTn.getPageContext(), i);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.mNoDataView.f(this.aTn.getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.aBs != null) {
            this.aBs.onStop();
        }
        this.mNoDataView.onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aTu = new o(this, imMessageCenterShowItemData);
        String string = this.aTn.getPageContext().getPageActivity().getString(z.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.aTn.getPageContext().getPageActivity());
        builder.setTitle(z.operation);
        builder.setItems(new String[]{string}, this.aTu);
        this.aTt = builder.create();
        this.aTt.setCanceledOnTouchOutside(true);
    }

    public void cv(boolean z) {
        if (z) {
            if (KN() && this.aTs.getVisibility() != 0) {
                this.aTs.setVisibility(0);
            }
        } else if (this.aTs.getVisibility() != 8) {
            this.aTs.setVisibility(8);
        }
    }

    public void cw(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
        if (!isAdded()) {
        }
    }

    public boolean KN() {
        return this.aTw;
    }

    public void cx(boolean z) {
        this.aTw = z;
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
                if (this.aTm != null) {
                    this.aTm.insertOrUpdate(data, this.aTC);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.aTm != null) {
                this.aTm.remove(data, this.aTC);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.aTm != null) {
                this.aTm.setData(data, this.aTC);
            }
        }
    }
}

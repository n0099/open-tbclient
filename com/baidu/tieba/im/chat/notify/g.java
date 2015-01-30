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
    private com.baidu.tbadk.core.view.l aBv;
    private ShutDownValidateTipView aTt;
    private DialogInterface.OnClickListener aTv;
    private int aTw;
    private RelativeLayout aTy;
    private x mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ImMessageCenterModel aTn = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> aTo = null;
    private ImMessageCenterShowItemData aTp = null;
    private BdListView aTq = null;
    private ImMessageCenterListAdapter aTr = null;
    private q aTs = null;
    AlertDialog aTu = null;
    private boolean aTx = true;
    private final AdapterView.OnItemClickListener aTz = new h(this);
    private final AdapterView.OnItemLongClickListener aTA = new j(this);
    private final com.baidu.adp.widget.ListView.g aTB = new k(this);
    private final CustomMessageListener aTC = new l(this, 0);
    private a aTD = new m(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aTw = -1;
        this.aTo = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(com.baidu.tieba.x.chat_list_activity, viewGroup, false);
        t(inflate);
        TiebaStatic.eventStat(this.aTo.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(2016003, this.aTC);
        registerListener(2016000, this.aTC);
        registerListener(2016010, this.aTC);
        registerListener(2016006, this.aTC);
        registerListener(2016011, this.aTC);
        registerListener(2016001, this.aTC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.aTr != null) {
            this.aTr.notifyDataSetChanged();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.aTC);
    }

    private void initData() {
        this.aTn = new ImMessageCenterModel();
        cx(com.baidu.tbadk.core.sharedPref.b.oj().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void t(View view) {
        this.aTy = (RelativeLayout) view.findViewById(w.chat_list);
        this.mNoDataView = NoDataViewFactory.a(this.aTo.getPageContext().getPageActivity(), this.aTy, aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(u.ds80)), ab.cp(z.no_recent_chat), null);
        this.aTt = (ShutDownValidateTipView) view.findViewById(w.view_no_validate);
        this.aTt.setVisibility(8);
        this.aTt.setShutDownClickListener(new n(this));
        this.aTq = (BdListView) view.findViewById(w.chat_list_content);
        this.aTq.setDividerHeight(0);
        this.aTs = new q(getBaseFragmentActivity().getPageContext());
        this.aTs.a(this.aTB);
        this.aTq.setPullRefresh(this.aTs);
        this.aTr = new ImMessageCenterListAdapter(this.aTo.getPageContext().getPageActivity());
        this.aTr.g(this);
        this.aTq.setAdapter((ListAdapter) this.aTr);
        this.aTq.setOnItemClickListener(this.aTz);
        this.aTq.setOnItemLongClickListener(this.aTA);
        this.aTq.jJ();
        this.mNoNetworkView = (NoNetworkView) this.aTy.findViewById(w.view_no_network);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.aTw != i) {
            this.aTw = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.aTo.getPageContext(), i);
            }
            if (this.aTt != null) {
                this.aTt.onChangeSkinType(i);
            }
            if (this.aTs != null) {
                this.aTs.cs(i);
            }
            if (this.aBv != null) {
                this.aBv.ck(i);
            }
            if (this.aTr != null) {
                this.aTr.notifyDataSetChanged();
            }
            if (this.aTo != null && (this.aTo instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.aTo).getLayoutMode().ab(i == 1);
                ((BaseFragmentActivity) this.aTo).getLayoutMode().h(this.aTy);
            }
            if (this.mNoNetworkView != null) {
                this.mNoNetworkView.onChangeSkinType(this.aTo.getPageContext(), i);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.mNoDataView.f(this.aTo.getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.aBv != null) {
            this.aBv.onStop();
        }
        this.mNoDataView.onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aTv = new o(this, imMessageCenterShowItemData);
        String string = this.aTo.getPageContext().getPageActivity().getString(z.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.aTo.getPageContext().getPageActivity());
        builder.setTitle(z.operation);
        builder.setItems(new String[]{string}, this.aTv);
        this.aTu = builder.create();
        this.aTu.setCanceledOnTouchOutside(true);
    }

    public void cv(boolean z) {
        if (z) {
            if (KS() && this.aTt.getVisibility() != 0) {
                this.aTt.setVisibility(0);
            }
        } else if (this.aTt.getVisibility() != 8) {
            this.aTt.setVisibility(8);
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

    public boolean KS() {
        return this.aTx;
    }

    public void cx(boolean z) {
        this.aTx = z;
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
                if (this.aTn != null) {
                    this.aTn.insertOrUpdate(data, this.aTD);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.aTn != null) {
                this.aTn.remove(data, this.aTD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.aTn != null) {
                this.aTn.setData(data, this.aTD);
            }
        }
    }
}

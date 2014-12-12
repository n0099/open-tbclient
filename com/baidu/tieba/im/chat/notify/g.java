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
    private com.baidu.tbadk.core.view.l aAt;
    private ShutDownValidateTipView aSk;
    private DialogInterface.OnClickListener aSm;
    private int aSn;
    private x mNoDataView;
    private NoNetworkView mNoNetworkView;
    private RelativeLayout mRoot;
    private ImMessageCenterModel aSe = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> aSf = null;
    private ImMessageCenterShowItemData aSg = null;
    private BdListView aSh = null;
    private ImMessageCenterListAdapter aSi = null;
    private q aSj = null;
    AlertDialog aSl = null;
    private boolean aSo = true;
    private final AdapterView.OnItemClickListener aSp = new h(this);
    private final AdapterView.OnItemLongClickListener aSq = new j(this);
    private final com.baidu.adp.widget.ListView.g aSr = new k(this);
    private final CustomMessageListener aSs = new l(this, 0);
    private a aSt = new m(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aSn = -1;
        this.aSf = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(com.baidu.tieba.x.chat_list_activity, viewGroup, false);
        t(inflate);
        TiebaStatic.eventStat(this.aSf.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(2016003, this.aSs);
        registerListener(2016000, this.aSs);
        registerListener(2016010, this.aSs);
        registerListener(2016006, this.aSs);
        registerListener(2016011, this.aSs);
        registerListener(2016001, this.aSs);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.aSi != null) {
            this.aSi.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.aSs);
    }

    private void initData() {
        this.aSe = new ImMessageCenterModel();
        ct(com.baidu.tbadk.core.sharedPref.b.og().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void t(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(w.chat_list);
        this.mNoDataView = NoDataViewFactory.a(this.aSf.getPageContext().getPageActivity(), this.mRoot, aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(u.ds80)), ab.ci(z.no_recent_chat), null);
        this.aSk = (ShutDownValidateTipView) view.findViewById(w.view_no_validate);
        this.aSk.setVisibility(8);
        this.aSk.setShutDownClickListener(new n(this));
        this.aSh = (BdListView) view.findViewById(w.chat_list_content);
        this.aSh.setDividerHeight(0);
        this.aSj = new q(this.aSf.getPageContext().getPageActivity());
        this.aSj.a(this.aSr);
        this.aSh.setPullRefresh(this.aSj);
        this.aSi = new ImMessageCenterListAdapter(this.aSf.getPageContext().getPageActivity());
        this.aSi.g(this);
        this.aSh.setAdapter((ListAdapter) this.aSi);
        this.aSh.setOnItemClickListener(this.aSp);
        this.aSh.setOnItemLongClickListener(this.aSq);
        this.aSh.jK();
        this.mNoNetworkView = (NoNetworkView) this.mRoot.findViewById(w.view_no_network);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.aSn != i) {
            this.aSn = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.aSf.getPageContext(), i);
            }
            if (this.aSk != null) {
                this.aSk.onChangeSkinType(i);
            }
            if (this.aSj != null) {
                this.aSj.cl(i);
            }
            if (this.aAt != null) {
                this.aAt.cd(i);
            }
            if (this.aSi != null) {
                this.aSi.notifyDataSetChanged();
            }
            if (this.aSf != null && (this.aSf instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.aSf).getLayoutMode().ab(i == 1);
                ((BaseFragmentActivity) this.aSf).getLayoutMode().h(this.mRoot);
            }
            if (this.mNoNetworkView != null) {
                this.mNoNetworkView.onChangeSkinType(this.aSf.getPageContext(), i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.mNoDataView.f(this.aSf.getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.aAt != null) {
            this.aAt.onStop();
        }
        this.mNoDataView.onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aSm = new o(this, imMessageCenterShowItemData);
        String string = this.aSf.getPageContext().getPageActivity().getString(z.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.aSf.getPageContext().getPageActivity());
        builder.setTitle(z.operation);
        builder.setItems(new String[]{string}, this.aSm);
        this.aSl = builder.create();
        this.aSl.setCanceledOnTouchOutside(true);
    }

    public void cr(boolean z) {
        if (z) {
            if (Kx() && this.aSk.getVisibility() != 0) {
                this.aSk.setVisibility(0);
            }
        } else if (this.aSk.getVisibility() != 8) {
            this.aSk.setVisibility(8);
        }
    }

    public void cs(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
        if (!isAdded()) {
        }
    }

    public boolean Kx() {
        return this.aSo;
    }

    public void ct(boolean z) {
        this.aSo = z;
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
                if (this.aSe != null) {
                    this.aSe.insertOrUpdate(data, this.aSt);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.aSe != null) {
                this.aSe.remove(data, this.aSt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.aSe != null) {
                this.aSe.setData(data, this.aSt);
            }
        }
    }
}

package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.p;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.coreExtra.view.EnterGuideCenterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MyGroupFragment extends com.baidu.tbadk.core.d implements View.OnClickListener, AdapterView.OnItemClickListener {
    public boolean c;
    private j d = null;
    public BdListView b = null;
    private q e = null;
    private a f = null;
    private EnterGuideCenterView g = null;
    private View h = null;
    private final com.baidu.adp.framework.listener.b i = new c(this, 0);
    private final com.baidu.adp.framework.listener.b j = new d(this, 0);
    private final com.baidu.adp.framework.listener.b k = new e(this, 0);
    private final CustomMessageListener l = new f(this, 0);
    private final CustomMessageListener m = new g(this, 0);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.d == null) {
            this.d = new j();
            if (getActivity() instanceof BdBaseFragmentActivity) {
                this.d.setUniqueId(((BdBaseFragmentActivity) getActivity()).getUniqueId());
            }
            this.b.d();
        } else if (this.c) {
            this.b.d();
        }
        a();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.k);
        MessageManager.getInstance().unRegisterListener(this.j);
        MessageManager.getInstance().unRegisterListener(this.m);
        MessageManager.getInstance().unRegisterListener(this.i);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_QUERY_GROUP_BY_UID, this.k);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_REQUEST_GROUP_BY_UID_LOCAL, this.l);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_ADD_GROUP, this.j);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_REMOVE_MEMBERS, this.j);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_UPDATE_GROUP, this.j);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_GROUP_MEMBER_CHANGE, this.j);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_DISSMISS_GROUP, this.j);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_UPGRADE_MEMBER_GROUP, this.j);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.i);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.i);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.i);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.i);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.i);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE, this.i);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.m);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.g != null) {
            this.g.b();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.g != null) {
            this.g.c();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(w.my_group_fragment, viewGroup, false);
        this.g = (EnterGuideCenterView) inflate.findViewById(v.lv_guid_center_root);
        this.b = (BdListView) inflate.findViewById(v.my_group_list);
        this.b.a(new h(this), 300L);
        this.e = new q(getActivity());
        this.f = new a(this);
        this.e.a(new i(this));
        this.b.setPullRefresh(this.e);
        this.b.setAdapter((ListAdapter) this.f);
        this.b.setOnItemClickListener(this);
        this.h = inflate.findViewById(v.fragment_parent);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.b != null && this.f != null) {
            ag.a(this.b, this.f.a(), 0, -1);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.f.getItem(i);
        if (item != null) {
            TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new p(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == v.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            if (groupInfoData != null) {
                a(new CustomMessage(2010011, new com.baidu.tbadk.core.atomData.q(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        ((BaseFragmentActivity) getActivity()).a().a(this.h);
        this.e.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && UtilHelper.isNetOk()) {
                    this.c = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

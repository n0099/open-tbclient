package com.baidu.tieba.im.group;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.s;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.hotGroup.HotGroupActivity;
import com.baidu.tieba.im.message.RequestUserPermissionMessage;
import com.baidu.tieba.im.nearbygroups.NearbyGroupsActivity;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.core.d implements com.baidu.tieba.im.a.e {
    public boolean b;
    private q c;
    private com.baidu.tieba.im.a.a d;
    private com.baidu.tieba.im.model.j f;
    private BaseFragmentActivity g;
    private com.baidu.tieba.im.mygroup.j e = null;
    private final CustomMessageListener h = new c(this, 0);
    private final com.baidu.adp.framework.listener.b i = new d(this, 0);
    private final com.baidu.adp.framework.listener.b j = new e(this, 0);
    private final com.baidu.adp.framework.listener.b k = new f(this, 0);
    private final CustomMessageListener l = new g(this, 0);
    private final CustomMessageListener m = new h(this, 0);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        h();
        g();
    }

    private void g() {
        MessageManager.getInstance().registerListener(MessageTypes.CMD_QUERY_GROUP_BY_UID, this.k);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_REQUEST_GROUP_BY_UID_LOCAL, this.l);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_ADD_GROUP, this.j);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_REMOVE_MEMBERS, this.j);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_UPDATE_GROUP, this.j);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_DISSMISS_GROUP, this.j);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_UPGRADE_MEMBER_GROUP, this.j);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_GROUP_MEMBER_CHANGE, this.h);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.h);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.h);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.h);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.h);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.h);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE, this.h);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.m);
    }

    private void h() {
        this.g = (BaseFragmentActivity) getActivity();
        this.c = new q(this.g, this);
        this.c.b().setOnItemClickListener(this);
        this.c.a(new i(this));
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w.group_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        ((BaseFragmentActivity) getActivity()).a().a(i == 1);
        this.c.a(i);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.i);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.d();
        }
        com.baidu.tieba.im.a.a.a = true;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!d_()) {
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void e() {
        super.e();
        MessageManager.getInstance().unRegisterListener(this.i);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_GET_USER_PERMISSION, this.i);
        boolean z = this.d == null || this.e == null;
        if (this.d == null) {
            this.d = new com.baidu.tieba.im.a.a();
            if (getActivity() instanceof BaseFragmentActivity) {
                this.d.setUniqueId(((BaseFragmentActivity) getActivity()).getUniqueId());
            }
            this.d.c();
            this.d.a(this);
        }
        if (this.e == null) {
            this.e = new com.baidu.tieba.im.mygroup.j();
            if (getActivity() instanceof BaseFragmentActivity) {
                this.e.setUniqueId(((BdBaseFragmentActivity) getActivity()).getUniqueId());
            }
        }
        if (this.f == null) {
            this.f = new com.baidu.tieba.im.model.j();
            if (getActivity() instanceof BaseFragmentActivity) {
                this.f.setUniqueId(((BaseFragmentActivity) getActivity()).getUniqueId());
            }
        }
        this.f.registerListener(this.i);
        if (z) {
            this.c.d();
        } else if (this.b) {
            this.c.d();
        }
        if (this.c.a() != null) {
            this.c.a().notifyDataSetChanged();
        }
    }

    private void i() {
        this.f.a(this.f.a());
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == v.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            if (groupInfoData != null) {
                a(new CustomMessage(2010011, new com.baidu.tbadk.core.atomData.q(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        } else if (view.getTag() != null && (view.getTag() instanceof Integer)) {
            switch (((Integer) view.getTag()).intValue()) {
                case 2:
                    TiebaStatic.eventStat(getActivity(), "group_tab_nearby", "onclick", 1, new Object[0]);
                    com.baidu.tieba.im.a.a.a = true;
                    NearbyGroupsActivity.a(getActivity());
                    return;
                case 3:
                    TiebaStatic.eventStat(getActivity(), "group_tab_hotgroup", "onclick", 1, new Object[0]);
                    HotGroupActivity.a(getActivity());
                    return;
                case 4:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new s(this.g)));
                    return;
                case 5:
                    com.baidu.tbadk.core.f.a(this.g, "rand_chat_enter_button");
                    if (!TbadkApplication.isLogin()) {
                        LoginActivity.a((Activity) getActivity(), "", true, 2);
                        return;
                    } else if (j() <= 0) {
                        this.g.a(this.g.getString(y.group_tab_enterchatroom_loading), new j(this));
                        i();
                        return;
                    } else {
                        b(getString(y.group_tab_enterchatroom_freeze, new StringBuilder(String.valueOf(j())).toString()));
                        return;
                    }
                case 6:
                    TiebaStatic.eventStat(getActivity(), "group_tab_addgroup", "onclick", 1, new Object[0]);
                    AddGroupActivity.a(getActivity());
                    return;
                case 7:
                    if (!TbadkApplication.isLogin()) {
                        LoginActivity.a((Activity) getActivity(), "", true, 1);
                        return;
                    }
                    RequestUserPermissionMessage requestUserPermissionMessage = new RequestUserPermissionMessage();
                    requestUserPermissionMessage.setForumId(0L);
                    ((BaseFragmentActivity) getActivity()).a(requestUserPermissionMessage);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.im.a.e
    public void a() {
    }

    @Override // com.baidu.tieba.im.a.e
    public void c(String str) {
        b(str);
    }

    @Override // com.baidu.tieba.im.a.e
    public void f() {
    }

    @Override // com.baidu.tieba.im.a.e
    public void a(int i, int i2, String str, String str2) {
        if (this.c != null) {
            this.c.b(i2);
            this.c.a(str, str2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (this.d != null) {
                    this.d.a();
                    return;
                }
                return;
            case 2:
                if (i2 == -1) {
                    if (j() <= 0) {
                        this.g.a(this.g.getString(y.group_tab_enterchatroom_loading), new k(this));
                        i();
                        return;
                    }
                    b(getString(y.group_tab_enterchatroom_freeze, new StringBuilder(String.valueOf(j())).toString()));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private int j() {
        String[] split;
        String a = com.baidu.tbadk.core.sharedPref.b.a().a("chat_room_cool_down", "");
        if (TextUtils.isEmpty(a) || (split = a.split("_")) == null || split.length != 2) {
            return 0;
        }
        String str = split[0];
        String str2 = split[1];
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount) || !currentAccount.equals(str)) {
            return 0;
        }
        long a2 = com.baidu.adp.lib.f.b.a(str2, 0L) - System.currentTimeMillis();
        if (a2 > 0) {
            int i = (int) ((a2 / 1000) / 60);
            if (i > 0) {
                return i;
            }
            return 1;
        }
        return 0;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.k);
        MessageManager.getInstance().unRegisterListener(this.l);
        MessageManager.getInstance().unRegisterListener(this.j);
        MessageManager.getInstance().unRegisterListener(this.m);
        MessageManager.getInstance().unRegisterListener(this.h);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item;
        if (i > 8 && (item = this.c.a().getItem(i)) != null && (item instanceof GroupInfoData)) {
            GroupInfoData groupInfoData = (GroupInfoData) item;
            TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.p(getActivity(), groupInfoData.getGroupId(), groupInfoData.getName(), groupInfoData.getAuthorId(), "group_lstb")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && UtilHelper.isNetOk()) {
                    this.b = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

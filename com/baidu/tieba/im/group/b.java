package com.baidu.tieba.im.group;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.hotGroup.HotGroupActivity;
import com.baidu.tieba.im.message.bk;
import com.baidu.tieba.im.nearbygroups.NearbyGroupsActivity;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b extends com.baidu.tbadk.core.d implements com.baidu.tieba.im.a.e {
    public boolean a;
    private q b;
    private com.baidu.tieba.im.a.a c;
    private com.baidu.tieba.im.model.j e;
    private com.baidu.tbadk.core.e f;
    private com.baidu.tieba.im.mygroup.j d = null;
    private final com.baidu.adp.framework.c.g g = new c(this, 0);
    private final com.baidu.adp.framework.c.g h = new d(this, 0);
    private final com.baidu.adp.framework.c.g i = new e(this, 0);
    private final com.baidu.adp.framework.c.g j = new f(this, 0);
    private final com.baidu.adp.framework.c.a k = new g(this, 0);
    private final com.baidu.adp.framework.c.a l = new h(this, 0);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f = (com.baidu.tbadk.core.e) getActivity();
        this.b = new q(this.f, this);
        this.b.b().setOnItemClickListener(this);
        this.b.a(new i(this));
        com.baidu.adp.framework.c.a().a(103003, this.j);
        com.baidu.adp.framework.c.a().a(2001106, this.k);
        com.baidu.adp.framework.c.a().a(103101, this.i);
        com.baidu.adp.framework.c.a().a(103112, this.i);
        com.baidu.adp.framework.c.a().a(103102, this.i);
        com.baidu.adp.framework.c.a().a(2001109, this.i);
        com.baidu.adp.framework.c.a().a(103104, this.i);
        com.baidu.adp.framework.c.a().a(103105, this.i);
        com.baidu.adp.framework.c.a().a(2001130, this.g);
        com.baidu.adp.framework.c.a().a(2001132, this.g);
        com.baidu.adp.framework.c.a().a(2001136, this.g);
        com.baidu.adp.framework.c.a().a(2001137, this.g);
        com.baidu.adp.framework.c.a().a(2001134, this.g);
        com.baidu.adp.framework.c.a().a(2001138, this.g);
        com.baidu.adp.framework.c.a().a(2001141, this.l);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.baidu.tieba.im.i.group_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.d
    public final void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ((com.baidu.tbadk.core.e) getActivity()).b().a(i == 1);
        this.b.a(i);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onPause() {
        super.onPause();
        com.baidu.adp.framework.c.a().b(this.h);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.d();
        }
        com.baidu.tieba.im.a.a.a = true;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (!isShow()) {
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void onPrimary() {
        super.onPrimary();
        com.baidu.adp.framework.c.a().b(this.h);
        com.baidu.adp.framework.c.a().a(103008, this.h);
        boolean z = this.c == null || this.d == null;
        if (this.c == null) {
            this.c = new com.baidu.tieba.im.a.a();
            if (getActivity() instanceof com.baidu.tbadk.core.e) {
                this.c.setUniqueId(((com.baidu.tbadk.core.e) getActivity()).a());
            }
            this.c.c();
            this.c.a(this);
        }
        if (this.d == null) {
            this.d = new com.baidu.tieba.im.mygroup.j();
            if (getActivity() instanceof com.baidu.tbadk.core.e) {
                this.d.setUniqueId(((com.baidu.adp.a.c) getActivity()).a());
            }
        }
        if (this.e == null) {
            this.e = new com.baidu.tieba.im.model.j();
            if (getActivity() instanceof com.baidu.tbadk.core.e) {
                this.e.setUniqueId(((com.baidu.tbadk.core.e) getActivity()).a());
            }
        }
        this.e.registerListener(this.h);
        if (z) {
            this.b.d();
        } else if (this.a) {
            this.b.d();
        }
    }

    private void a() {
        this.e.a(this.e.a());
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == com.baidu.tieba.im.h.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            if (groupInfoData != null) {
                sendMessage(new com.baidu.adp.framework.message.a(2008011, new com.baidu.tbadk.core.b.o(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        } else if (view.getTag() != null && (view.getTag() instanceof Integer)) {
            switch (((Integer) view.getTag()).intValue()) {
                case 2:
                    TiebaStatic.a(getActivity(), "group_tab_nearby", "onclick", 1, new Object[0]);
                    com.baidu.tieba.im.a.a.a = true;
                    NearbyGroupsActivity.a(getActivity());
                    return;
                case 3:
                    TiebaStatic.a(getActivity(), "group_tab_hotgroup", "onclick", 1, new Object[0]);
                    HotGroupActivity.a(getActivity());
                    return;
                case 4:
                    com.baidu.tbadk.core.g.a(this.f, "rand_chat_enter_button");
                    if (!TbadkApplication.F()) {
                        LoginActivity.a((Activity) getActivity(), "", true, 2);
                        return;
                    } else if (b() <= 0) {
                        this.f.a(this.f.getString(com.baidu.tieba.im.j.group_tab_enterchatroom_loading), new j(this));
                        a();
                        return;
                    } else {
                        showToast(getString(com.baidu.tieba.im.j.group_tab_enterchatroom_freeze, new StringBuilder(String.valueOf(b())).toString()));
                        return;
                    }
                case 5:
                    TiebaStatic.a(getActivity(), "group_tab_addgroup", "onclick", 1, new Object[0]);
                    AddGroupActivity.a(getActivity());
                    return;
                case 6:
                    if (!TbadkApplication.F()) {
                        LoginActivity.a((Activity) getActivity(), "", true, 1);
                        return;
                    }
                    bk bkVar = new bk();
                    bkVar.b(0L);
                    ((com.baidu.tbadk.core.e) getActivity()).a(bkVar);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.im.a.e
    public final void a(String str) {
        showToast(str);
    }

    @Override // com.baidu.tieba.im.a.e
    public final void a(int i, String str, String str2) {
        if (this.b != null) {
            this.b.b(i);
            this.b.a(str, str2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (this.c != null) {
                    this.c.a();
                    return;
                }
                return;
            case 2:
                if (i2 == -1) {
                    if (b() <= 0) {
                        this.f.a(this.f.getString(com.baidu.tieba.im.j.group_tab_enterchatroom_loading), new k(this));
                        a();
                        return;
                    }
                    showToast(getString(com.baidu.tieba.im.j.group_tab_enterchatroom_freeze, new StringBuilder(String.valueOf(b())).toString()));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static int b() {
        String[] split;
        String a = com.baidu.tbadk.core.sharedPref.b.a().a("chat_room_cool_down", "");
        if (TextUtils.isEmpty(a) || (split = a.split("_")) == null || split.length != 2) {
            return 0;
        }
        String str = split[0];
        String str2 = split[1];
        String E = TbadkApplication.E();
        if (TextUtils.isEmpty(E) || !E.equals(str)) {
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
    public final void onDestroyView() {
        com.baidu.adp.framework.c.a().b(this.j);
        com.baidu.adp.framework.c.a().b(this.k);
        com.baidu.adp.framework.c.a().b(this.i);
        com.baidu.adp.framework.c.a().b(this.l);
        com.baidu.adp.framework.c.a().b(this.g);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item;
        if (i > 7 && (item = this.b.a().getItem(i)) != null && (item instanceof GroupInfoData)) {
            GroupInfoData groupInfoData = (GroupInfoData) item;
            TiebaStatic.a(getActivity(), "my_group_item", "click", 1, new Object[0]);
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.n(getActivity(), groupInfoData.getGroupId(), groupInfoData.getName(), groupInfoData.getAuthorId(), "group_lstb")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(b bVar, GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && UtilHelper.a()) {
                    bVar.a = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.home.EnterForumGuideCenterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.im.message.aa;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.j;
import com.baidu.tieba.k;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.view.ct;
import com.slidingmenu.lib.R;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MyGroupFragment extends j implements View.OnClickListener, AdapterView.OnItemClickListener, com.baidu.tieba.im.messageCenter.g {
    public boolean c;
    private h d;
    public BdListView b = null;
    private ct e = null;
    private a f = null;
    private EnterForumGuideCenterView g = null;
    private View h = null;
    private final com.baidu.tieba.im.messageCenter.g i = new c(this);
    private final com.baidu.tieba.im.messageCenter.g j = new d(this);
    private final com.baidu.tieba.im.messageCenter.g k = new e(this);

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.d == null) {
            this.d = new h();
            this.b.b();
        } else if (this.c) {
            this.b.b();
        }
        a();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.tieba.im.messageCenter.e.a().a(this.k);
        com.baidu.tieba.im.messageCenter.e.a().a(this.j);
        com.baidu.tieba.im.messageCenter.e.a().a(this);
        com.baidu.tieba.im.messageCenter.e.a().a(this.i);
        super.onDestroyView();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.baidu.tieba.im.messageCenter.e.a().a(103003, this.k);
        com.baidu.tieba.im.messageCenter.e.a().a(SapiErrorCode.SAVE_CERT_FAIL, this.k);
        com.baidu.tieba.im.messageCenter.e.a().a(103101, this.j);
        com.baidu.tieba.im.messageCenter.e.a().a(103112, this.j);
        com.baidu.tieba.im.messageCenter.e.a().a(103102, this.j);
        com.baidu.tieba.im.messageCenter.e.a().a(-109, this.j);
        com.baidu.tieba.im.messageCenter.e.a().a(103104, this.j);
        com.baidu.tieba.im.messageCenter.e.a().a(103105, this.j);
        com.baidu.tieba.im.messageCenter.e.a().a(-130, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(-132, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(-136, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(-137, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(-134, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(-138, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(-141, this);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.g != null) {
            this.g.b();
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.g != null) {
            this.g.c();
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.my_group_fragment, viewGroup, false);
        this.g = (EnterForumGuideCenterView) inflate.findViewById(R.id.lv_guid_center_root);
        this.b = (BdListView) inflate.findViewById(R.id.my_group_list);
        this.b.a(new f(this), 300L);
        this.e = new ct(getActivity());
        this.f = new a(this);
        this.e.a(new g(this));
        this.b.setPullRefresh(this.e);
        this.b.setAdapter((ListAdapter) this.f);
        this.b.setOnItemClickListener(this);
        this.h = inflate.findViewById(R.id.fragment_parent);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.b != null && this.f != null) {
            ap.a(this.b, this.f.a(), 0, -1);
        }
    }

    @Override // com.baidu.tieba.j, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.f.getItem(i);
        if (item != null) {
            cb.a(getActivity(), "my_group_item", "click", 1, new Object[0]);
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tieba.a.b(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
        }
    }

    @Override // com.baidu.tieba.j, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.click_head /* 2131100649 */:
                GroupInfoData groupInfoData = null;
                if (view.getTag() instanceof GroupInfoData) {
                    groupInfoData = (GroupInfoData) view.getTag();
                }
                if (groupInfoData != null) {
                    GroupInfoActivity.a(getActivity(), groupInfoData.getGroupId(), 1);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.j
    public void c(int i) {
        super.c(i);
        ((k) getActivity()).a().a(this.h);
        this.e.a(i);
    }

    private void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && UtilHelper.b()) {
                    this.c = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(s sVar) {
        GroupNewsPojo a;
        if (sVar != null && (sVar instanceof aa) && (a = ((aa) sVar).a()) != null && "dismiss_group".equals(a.getCmd())) {
            a(a);
        }
    }
}

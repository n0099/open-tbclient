package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.home.EnterForumGuideCenterView;
import com.baidu.tieba.im.c.l;
import com.baidu.tieba.im.c.m;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.an;
import com.baidu.tieba.util.by;
import com.baidu.tieba.view.cm;
import com.slidingmenu.lib.R;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MyGroupFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener, l {
    public boolean b;
    private h c;
    public BdListView a = null;
    private cm d = null;
    private a e = null;
    private EnterForumGuideCenterView f = null;
    private View g = null;
    private l h = new c(this);
    private com.baidu.tieba.im.messageCenter.g i = new f(this);
    private com.baidu.tieba.im.messageCenter.g Y = new g(this);

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        super.r();
        if (this.c == null) {
            this.c = new h();
            this.a.b();
        } else if (this.b) {
            this.a.b();
        }
        a();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void e() {
        com.baidu.tieba.im.messageCenter.e.a().a(this.Y);
        com.baidu.tieba.im.messageCenter.e.a().a(this.i);
        m.a().a(this.h);
        m.a().a(this);
        super.e();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        com.baidu.tieba.im.messageCenter.e.a().a(103003, this.Y);
        com.baidu.tieba.im.messageCenter.e.a().a(SapiErrorCode.SAVE_CERT_FAIL, this.Y);
        com.baidu.tieba.im.messageCenter.e.a().a(103101, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(103112, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(103102, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(-109, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(103104, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(103105, this.i);
        m.a().a("apply_join_success", this.h);
        m.a().a("kick_out", this.h);
        m.a().a("group_intro_change", this.h);
        m.a().a("group_name_change", this.h);
        m.a().a("group_level_up", this.h);
        m.a().a("group_head_change", this.h);
        m.a().a("dismiss_group", this);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void c_() {
        super.c_();
        if (this.f != null) {
            this.f.b();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d() {
        super.d();
        if (this.f != null) {
            this.f.c();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.my_group_fragment, viewGroup, false);
        this.f = (EnterForumGuideCenterView) inflate.findViewById(R.id.lv_guid_center_root);
        this.a = (BdListView) inflate.findViewById(R.id.my_group_list);
        this.a.a(new d(this), 300L);
        this.d = new cm(i());
        this.e = new a(this);
        this.d.a(new e(this));
        this.a.setPullRefresh(this.d);
        this.a.setAdapter((ListAdapter) this.e);
        this.a.setOnItemClickListener(this);
        this.g = inflate.findViewById(R.id.fragment_parent);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.a != null && this.e != null) {
            an.a(this.a, this.e.a(), 0, -1);
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.e.getItem(i);
        if (item != null) {
            by.a(i(), "my_group_item", "click", 1, new Object[0]);
            GroupChatActivity.a(i(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb");
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.click_head /* 2131100525 */:
                GroupInfoData groupInfoData = null;
                if (view.getTag() instanceof GroupInfoData) {
                    groupInfoData = (GroupInfoData) view.getTag();
                }
                if (groupInfoData != null) {
                    GroupInfoActivity.a(i(), groupInfoData.getGroupId(), 1);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.BaseFragment
    public void d(int i) {
        super.d(i);
        ((BaseFragmentActivity) i()).a().a(this.g);
        this.d.a(i);
    }

    @Override // com.baidu.tieba.im.c.l
    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && "dismiss_group".equals(groupNewsPojo.getCmd())) {
            b(groupNewsPojo);
        }
    }

    private void b(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && UtilHelper.b()) {
                    this.b = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

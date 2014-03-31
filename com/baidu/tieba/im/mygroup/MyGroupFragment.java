package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.b.n;
import com.baidu.tbadk.core.b.o;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.coreExtra.view.EnterGuideCenterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MyGroupFragment extends com.baidu.tbadk.core.d implements View.OnClickListener, AdapterView.OnItemClickListener {
    public boolean b;
    private j c = null;
    public BdListView a = null;
    private q d = null;
    private a e = null;
    private EnterGuideCenterView f = null;
    private View g = null;
    private final com.baidu.adp.framework.c.g h = new c(this, 0);
    private final com.baidu.adp.framework.c.g i = new d(this, 0);
    private final com.baidu.adp.framework.c.g j = new e(this, 0);
    private final com.baidu.adp.framework.c.a k = new f(this, 0);
    private final com.baidu.adp.framework.c.a l = new g(this, 0);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.c == null) {
            this.c = new j();
            if (getActivity() instanceof com.baidu.adp.a.c) {
                this.c.setUniqueId(((com.baidu.adp.a.c) getActivity()).a());
            }
            this.a.c();
        } else if (this.b) {
            this.a.c();
        }
        a();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.baidu.adp.framework.c.a().b(this.j);
        com.baidu.adp.framework.c.a().b(this.i);
        com.baidu.adp.framework.c.a().b(this.l);
        com.baidu.adp.framework.c.a().b(this.h);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.baidu.adp.framework.c.a().a(103003, this.j);
        com.baidu.adp.framework.c.a().a(2001106, this.k);
        com.baidu.adp.framework.c.a().a(103101, this.i);
        com.baidu.adp.framework.c.a().a(103112, this.i);
        com.baidu.adp.framework.c.a().a(103102, this.i);
        com.baidu.adp.framework.c.a().a(2001109, this.i);
        com.baidu.adp.framework.c.a().a(103104, this.i);
        com.baidu.adp.framework.c.a().a(103105, this.i);
        com.baidu.adp.framework.c.a().a(2001130, this.h);
        com.baidu.adp.framework.c.a().a(2001132, this.h);
        com.baidu.adp.framework.c.a().a(2001136, this.h);
        com.baidu.adp.framework.c.a().a(2001137, this.h);
        com.baidu.adp.framework.c.a().a(2001134, this.h);
        com.baidu.adp.framework.c.a().a(2001138, this.h);
        com.baidu.adp.framework.c.a().a(2001141, this.l);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f != null) {
            this.f.a();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.f != null) {
            this.f.b();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.baidu.tieba.im.i.my_group_fragment, viewGroup, false);
        this.f = (EnterGuideCenterView) inflate.findViewById(com.baidu.tieba.im.h.lv_guid_center_root);
        this.a = (BdListView) inflate.findViewById(com.baidu.tieba.im.h.my_group_list);
        this.a.a(new h(this), 300L);
        this.d = new q(getActivity());
        this.e = new a(this);
        this.d.a(new i(this));
        this.a.setPullRefresh(this.d);
        this.a.setAdapter((ListAdapter) this.e);
        this.a.setOnItemClickListener(this);
        this.g = inflate.findViewById(com.baidu.tieba.im.h.fragment_parent);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.a != null && this.e != null) {
            ac.a(this.a, this.e.a(), 0, -1);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.e.getItem(i);
        if (item != null) {
            TiebaStatic.a(getActivity(), "my_group_item", "click", 1, new Object[0]);
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new n(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == com.baidu.tieba.im.h.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            if (groupInfoData != null) {
                sendMessage(new com.baidu.adp.framework.message.a(2008011, new o(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ((com.baidu.tbadk.core.e) getActivity()).b().a(this.g);
        this.d.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(MyGroupFragment myGroupFragment, GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && UtilHelper.a()) {
                    myGroupFragment.b = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

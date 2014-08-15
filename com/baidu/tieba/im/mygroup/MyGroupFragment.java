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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.EnterGuideCenterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MyGroupFragment extends com.baidu.tbadk.core.d implements View.OnClickListener, AdapterView.OnItemClickListener {
    public boolean c;
    private j d = null;
    public BdListView b = null;
    private com.baidu.tbadk.core.view.u e = null;
    private b f = null;
    private EnterGuideCenterView g = null;
    private View h = null;
    private final com.baidu.adp.framework.listener.d i = new d(this, 0);
    private final com.baidu.adp.framework.listener.d j = new e(this, 0);
    private final com.baidu.adp.framework.listener.d k = new f(this, 0);
    private final CustomMessageListener l = new g(this, 0);
    private final CustomMessageListener m = new h(this, 0);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.d == null) {
            this.d = new j(getActivity());
            if (getActivity() instanceof BdBaseFragmentActivity) {
                this.d.setUniqueId(((BdBaseFragmentActivity) getActivity()).getUniqueId());
            }
            this.b.e();
        } else if (this.c) {
            this.b.e();
        }
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
        a(103003, this.k);
        a(2001106, this.l);
        a(103101, this.j);
        a(103112, this.j);
        a(103102, this.j);
        a(2001109, this.j);
        a(103104, this.j);
        a(103105, this.j);
        a(2001130, this.i);
        a(2001132, this.i);
        a(2001136, this.i);
        a(2001137, this.i);
        a(2001134, this.i);
        a(2001138, this.i);
        a(2001141, this.m);
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
        View inflate = layoutInflater.inflate(com.baidu.tieba.v.my_group_fragment, viewGroup, false);
        this.g = (EnterGuideCenterView) inflate.findViewById(com.baidu.tieba.u.lv_guid_center_root);
        this.b = (BdListView) inflate.findViewById(com.baidu.tieba.u.my_group_list);
        this.e = new com.baidu.tbadk.core.view.u(getActivity());
        this.f = new b(this);
        this.e.a(new i(this));
        this.b.setPullRefresh(this.e);
        this.b.setAdapter((ListAdapter) this.f);
        this.b.setOnItemClickListener(this);
        this.h = inflate.findViewById(com.baidu.tieba.u.fragment_parent);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.f.getItem(i);
        if (item != null) {
            TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.x(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == com.baidu.tieba.u.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            if (groupInfoData != null) {
                a(new CustomMessage(2008011, new com.baidu.tbadk.core.atomData.y(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        ((BaseFragmentActivity) getActivity()).c().a(this.h);
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

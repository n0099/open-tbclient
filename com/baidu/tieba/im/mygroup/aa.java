package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.EnterGuideCenterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa extends com.baidu.tbadk.core.d implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView b = null;
    private com.baidu.tbadk.core.view.v d = null;
    private y e = null;
    private EnterGuideCenterView f = null;
    private View g = null;
    private int h = 0;
    private final com.baidu.adp.framework.listener.d i = new ab(this, 0);
    private final com.baidu.adp.framework.listener.d j = new ac(this, 0);
    private final com.baidu.adp.framework.listener.d k = new ad(this, 0);
    private final CustomMessageListener l = new ae(this, 0);
    private final CustomMessageListener m = new af(this, 0);
    public boolean c = false;

    /* JADX INFO: Access modifiers changed from: private */
    public PersonGroupActivity a() {
        FragmentActivity activity = getActivity();
        if (activity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) activity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f != null) {
            this.f.b();
        }
        if (this.c) {
            this.b.e();
        }
        c(TbadkApplication.m252getInst().getSkinType());
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
        if (this.f != null) {
            this.f.b();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.f != null) {
            this.f.c();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.h = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.v.person_group_fragment, viewGroup, false);
        this.f = (EnterGuideCenterView) inflate.findViewById(com.baidu.tieba.u.group_lv_guid_center_root);
        PersonGroupActivity a = a();
        if (a != null && !a.i()) {
            if (this.h == 0) {
                this.f.setTipTextByString(String.format(getString(com.baidu.tieba.x.person_group_no_personal_info), a.h()));
            } else {
                this.f.setTipText(com.baidu.tieba.x.person_group_no_common_info);
            }
        }
        this.b = (BdListView) inflate.findViewById(com.baidu.tieba.u.person_group_list);
        this.d = new com.baidu.tbadk.core.view.v(getActivity());
        this.e = new y(this);
        this.d.a(new ag(this));
        this.b.setPullRefresh(this.d);
        this.b.setAdapter((ListAdapter) this.e);
        this.b.setOnItemClickListener(this);
        this.f.setVisibility(8);
        this.g = inflate.findViewById(com.baidu.tieba.u.group_fragment_parent);
        if (a() != null && this.h == a().g()) {
            this.b.e();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.e.getItem(i);
        PersonGroupActivity a = a();
        if (a != null && !a.a(item) && item != null) {
            if (this.h == 1 || a.i()) {
                if (a.i()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.y(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (a.d(item.getGroupId())) {
                TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.y(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else {
                TiebaStatic.eventStat(getActivity(), "his_group_item", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new com.baidu.tbadk.core.atomData.z(getActivity(), item.getGroupId(), 1)));
            }
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
            PersonGroupActivity a = a();
            if (a != null && !a.a(groupInfoData) && groupInfoData != null) {
                a(new CustomMessage(2008011, new com.baidu.tbadk.core.atomData.z(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        if (this.f != null) {
            if (i == 1) {
                this.f.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_d_1);
            } else {
                this.f.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_d);
            }
        }
        if (isAdded()) {
            ((BaseFragmentActivity) getActivity()).c().a(this.g);
            this.d.a(i);
        }
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

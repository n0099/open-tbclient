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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView bge = null;
    private y Yg = null;
    private l bgf = null;
    private com.baidu.tbadk.core.view.o Yn = null;
    private View bgg = null;
    private int bgh = 0;
    private final com.baidu.adp.framework.listener.e bgi = new o(this, 0);
    private final com.baidu.adp.framework.listener.e bgj = new p(this, 0);
    private final com.baidu.adp.framework.listener.e bgk = new q(this, 0);
    private final CustomMessageListener bgl = new r(this, 0);
    private final CustomMessageListener Sg = new s(this, 0);
    public boolean bcG = false;

    /* JADX INFO: Access modifiers changed from: private */
    public PersonGroupActivity Ra() {
        FragmentActivity activity = getActivity();
        if (activity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) activity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bcG) {
            this.bge.hO();
        }
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.bgk);
        MessageManager.getInstance().unRegisterListener(this.bgj);
        MessageManager.getInstance().unRegisterListener(this.Sg);
        MessageManager.getInstance().unRegisterListener(this.bgi);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.bgk);
        registerListener(2001106, this.bgl);
        registerListener(103101, this.bgj);
        registerListener(103112, this.bgj);
        registerListener(103102, this.bgj);
        registerListener(2001109, this.bgj);
        registerListener(103104, this.bgj);
        registerListener(103105, this.bgj);
        registerListener(2001130, this.bgi);
        registerListener(2001132, this.bgi);
        registerListener(2001136, this.bgi);
        registerListener(2001137, this.bgi);
        registerListener(2001134, this.bgi);
        registerListener(2001138, this.bgi);
        registerListener(2001141, this.Sg);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.Yn != null) {
            this.Yn.nv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.Yn != null) {
            this.Yn.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        com.baidu.tbadk.core.view.s sVar;
        this.bgh = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(w.person_group_fragment, viewGroup, false);
        PersonGroupActivity Ra = Ra();
        if (Ra != null && !Ra.Az()) {
            i = (int) getResources().getDimension(com.baidu.tieba.t.ds80);
            if (this.bgh == 0) {
                sVar = com.baidu.tbadk.core.view.s.cc(String.format(getString(com.baidu.tieba.y.person_group_no_personal_info), Ra.QV()));
            } else {
                sVar = com.baidu.tbadk.core.view.s.cc(getString(com.baidu.tieba.y.person_group_no_common_info));
            }
        } else if (Ra == null || !Ra.Az()) {
            i = 0;
            sVar = null;
        } else {
            i = (int) getResources().getDimension(com.baidu.tieba.t.ds160);
            sVar = com.baidu.tbadk.core.view.s.O(getString(com.baidu.tieba.y.group_no_data_tip), getString(com.baidu.tieba.y.group_no_data_tip_1));
        }
        this.Yn = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, i), sVar, null);
        this.bge = (BdListView) inflate.findViewById(v.person_group_list);
        this.Yg = new y(getActivity());
        this.bgf = new l(this);
        this.Yg.a(new t(this));
        this.bge.setPullRefresh(this.Yg);
        this.bge.setAdapter((ListAdapter) this.bgf);
        this.bge.setOnItemClickListener(this);
        this.Yn.setVisibility(8);
        this.bgg = inflate.findViewById(v.group_fragment_parent);
        if (Ra() != null && this.bgh == Ra().QU()) {
            this.bge.hO();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.bgf.getItem(i);
        PersonGroupActivity Ra = Ra();
        if (Ra != null && !Ra.b(item) && item != null) {
            if (this.bgh == 1 || Ra.Az()) {
                if (Ra.Az()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (Ra.ge(item.getGroupId())) {
                TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else {
                TiebaStatic.eventStat(getActivity(), "his_group_item", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), item.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == v.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            PersonGroupActivity Ra = Ra();
            if (Ra != null && !Ra.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.Yn != null) {
            aw.i(this.Yn, com.baidu.tieba.s.cp_bg_line_d);
        }
        if (isAdded()) {
            ((BaseFragmentActivity) getActivity()).getLayoutMode().h(this.bgg);
            this.Yg.bM(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && com.baidu.adp.lib.util.j.fh()) {
                    this.bcG = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

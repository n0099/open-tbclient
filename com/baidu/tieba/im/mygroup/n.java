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
    public BdListView bfQ = null;
    private y Yc = null;
    private l bfR = null;
    private com.baidu.tbadk.core.view.o Yj = null;
    private View bfS = null;
    private int bfT = 0;
    private final com.baidu.adp.framework.listener.e bfU = new o(this, 0);
    private final com.baidu.adp.framework.listener.e bfV = new p(this, 0);
    private final com.baidu.adp.framework.listener.e bfW = new q(this, 0);
    private final CustomMessageListener bfX = new r(this, 0);
    private final CustomMessageListener Sc = new s(this, 0);
    public boolean bcs = false;

    /* JADX INFO: Access modifiers changed from: private */
    public PersonGroupActivity QX() {
        FragmentActivity activity = getActivity();
        if (activity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) activity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bcs) {
            this.bfQ.hO();
        }
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.bfW);
        MessageManager.getInstance().unRegisterListener(this.bfV);
        MessageManager.getInstance().unRegisterListener(this.Sc);
        MessageManager.getInstance().unRegisterListener(this.bfU);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.bfW);
        registerListener(2001106, this.bfX);
        registerListener(103101, this.bfV);
        registerListener(103112, this.bfV);
        registerListener(103102, this.bfV);
        registerListener(2001109, this.bfV);
        registerListener(103104, this.bfV);
        registerListener(103105, this.bfV);
        registerListener(2001130, this.bfU);
        registerListener(2001132, this.bfU);
        registerListener(2001136, this.bfU);
        registerListener(2001137, this.bfU);
        registerListener(2001134, this.bfU);
        registerListener(2001138, this.bfU);
        registerListener(2001141, this.Sc);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.Yj != null) {
            this.Yj.nv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.Yj != null) {
            this.Yj.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        com.baidu.tbadk.core.view.s sVar;
        this.bfT = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(w.person_group_fragment, viewGroup, false);
        PersonGroupActivity QX = QX();
        if (QX != null && !QX.Ax()) {
            i = (int) getResources().getDimension(com.baidu.tieba.t.ds80);
            if (this.bfT == 0) {
                sVar = com.baidu.tbadk.core.view.s.cc(String.format(getString(com.baidu.tieba.y.person_group_no_personal_info), QX.QS()));
            } else {
                sVar = com.baidu.tbadk.core.view.s.cc(getString(com.baidu.tieba.y.person_group_no_common_info));
            }
        } else if (QX == null || !QX.Ax()) {
            i = 0;
            sVar = null;
        } else {
            i = (int) getResources().getDimension(com.baidu.tieba.t.ds160);
            sVar = com.baidu.tbadk.core.view.s.O(getString(com.baidu.tieba.y.group_no_data_tip), getString(com.baidu.tieba.y.group_no_data_tip_1));
        }
        this.Yj = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, i), sVar, null);
        this.bfQ = (BdListView) inflate.findViewById(v.person_group_list);
        this.Yc = new y(getActivity());
        this.bfR = new l(this);
        this.Yc.a(new t(this));
        this.bfQ.setPullRefresh(this.Yc);
        this.bfQ.setAdapter((ListAdapter) this.bfR);
        this.bfQ.setOnItemClickListener(this);
        this.Yj.setVisibility(8);
        this.bfS = inflate.findViewById(v.group_fragment_parent);
        if (QX() != null && this.bfT == QX().QR()) {
            this.bfQ.hO();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.bfR.getItem(i);
        PersonGroupActivity QX = QX();
        if (QX != null && !QX.b(item) && item != null) {
            if (this.bfT == 1 || QX.Ax()) {
                if (QX.Ax()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (QX.ge(item.getGroupId())) {
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
            PersonGroupActivity QX = QX();
            if (QX != null && !QX.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.Yj != null) {
            aw.i(this.Yj, com.baidu.tieba.s.cp_bg_line_d);
        }
        if (isAdded()) {
            ((BaseFragmentActivity) getActivity()).getLayoutMode().h(this.bfS);
            this.Yc.bM(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && com.baidu.adp.lib.util.j.fh()) {
                    this.bcs = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

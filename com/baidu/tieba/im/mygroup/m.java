package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView bjs = null;
    private ak mPullView = null;
    private k bjt = null;
    private x aeW = null;
    private View bju = null;
    private int bjw = 0;
    private final com.baidu.adp.framework.listener.e bjx = new n(this, 0);
    private final com.baidu.adp.framework.listener.e bjy = new o(this, 0);
    private final com.baidu.adp.framework.listener.e bjz = new p(this, 0);
    private final CustomMessageListener bjA = new q(this, 0);
    private final CustomMessageListener CL = new r(this, 0);
    public boolean bjv = false;

    public PersonGroupActivity RA() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bjv) {
            this.bjs.jK();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.bjz);
        MessageManager.getInstance().unRegisterListener(this.bjy);
        MessageManager.getInstance().unRegisterListener(this.CL);
        MessageManager.getInstance().unRegisterListener(this.bjx);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.bjz);
        registerListener(2001106, this.bjA);
        registerListener(103101, this.bjy);
        registerListener(103112, this.bjy);
        registerListener(103102, this.bjy);
        registerListener(2001109, this.bjy);
        registerListener(103104, this.bjy);
        registerListener(103105, this.bjy);
        registerListener(2001130, this.bjx);
        registerListener(2001132, this.bjx);
        registerListener(2001136, this.bjx);
        registerListener(2001137, this.bjx);
        registerListener(2001134, this.bjx);
        registerListener(2001138, this.bjx);
        registerListener(2001141, this.CL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.aeW != null) {
            this.aeW.f(RA().getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.aeW != null) {
            this.aeW.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        ab abVar;
        this.bjw = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.x.person_group_fragment, viewGroup, false);
        PersonGroupActivity RA = RA();
        if (RA != null && !RA.Rv()) {
            i = (int) getResources().getDimension(u.ds80);
            if (this.bjw == 0) {
                abVar = ab.cU(String.format(getString(z.person_group_no_personal_info), RA.Ru()));
            } else {
                abVar = ab.cU(getString(z.person_group_no_common_info));
            }
        } else if (RA == null || !RA.Rv()) {
            i = 0;
            abVar = null;
        } else {
            i = (int) getResources().getDimension(u.ds160);
            abVar = ab.Z(getString(z.group_no_data_tip), getString(z.group_no_data_tip_1));
        }
        this.aeW = NoDataViewFactory.a(getActivity(), inflate, aa.a(NoDataViewFactory.ImgType.NODATA, i), abVar, null);
        this.bjs = (BdListView) inflate.findViewById(w.person_group_list);
        this.mPullView = new ak(getActivity());
        this.bjt = new k(this);
        this.mPullView.a(new s(this));
        this.bjs.setPullRefresh(this.mPullView);
        this.bjs.setAdapter((ListAdapter) this.bjt);
        this.bjs.setOnItemClickListener(this);
        this.aeW.setVisibility(8);
        this.bju = inflate.findViewById(w.group_fragment_parent);
        if (RA() != null && this.bjw == RA().Rt()) {
            this.bjs.jK();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.bjt.getItem(i);
        PersonGroupActivity RA = RA();
        if (RA != null && !RA.b(item) && item != null) {
            if (this.bjw == 1 || RA.Rv()) {
                if (RA.Rv()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (RA.gn(item.getGroupId())) {
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
        if (view.getId() == w.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            PersonGroupActivity RA = RA();
            if (RA != null && !RA.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aeW != null) {
            ax.j(this.aeW, t.cp_bg_line_d);
        }
        if (isAdded()) {
            RA().getLayoutMode().h(this.bju);
            this.mPullView.cl(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDismissGroup(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && com.baidu.adp.lib.util.i.fg()) {
                    this.bjv = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import d.a.c.e.p.j;
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PersonalGroupFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public BdListView f17320e = null;

    /* renamed from: f  reason: collision with root package name */
    public g f17321f = null;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.f1.n.a f17322g = null;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f17323h = null;

    /* renamed from: i  reason: collision with root package name */
    public View f17324i = null;
    public int k = 0;
    public final d.a.c.c.g.c l = new a(0);
    public final d.a.c.c.g.c m = new c(0);
    public final d.a.c.c.g.c n = new d(0);
    public final CustomMessageListener o = new e(0);
    public final CustomMessageListener p = new f(0);
    public boolean j = false;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.c {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.j = true;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            PersonGroupActivity H0 = PersonalGroupFragment.this.H0();
            if (H0 != null) {
                H0.getMyGroupModel().u();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.c.c.g.c {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            switch (socketResponsedMessage.getCmd()) {
                case 103101:
                case 103102:
                case 103104:
                case 103105:
                case 103112:
                case 2001109:
                    if (!(socketResponsedMessage instanceof ResponsedMessage) || socketResponsedMessage.getError() == 0 || ((socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) && socketResponsedMessage.getError() == 2230110)) {
                        PersonalGroupFragment.this.j = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.a.c.c.g.c {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity H0 = PersonalGroupFragment.this.H0();
            if (PersonalGroupFragment.this.getActivity() == null || PersonalGroupFragment.this.f17320e == null || H0 == null || H0.getMyGroupModel() == null) {
                return;
            }
            if (socketResponsedMessage.getCmd() == 103003) {
                PersonalGroupFragment.this.f17320e.A(0L);
            }
            ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
            if (responseGroupsByUidMessage.getError() != 0) {
                if (responseGroupsByUidMessage.getError() != 0) {
                    PersonalGroupFragment.this.showToast(StringUtils.isNull(responseGroupsByUidMessage.getErrorString()) ? PersonalGroupFragment.this.getResources().getString(R.string.neterror) : responseGroupsByUidMessage.getErrorString());
                    return;
                }
                return;
            }
            List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
            if (PersonalGroupFragment.this.k == 1) {
                groups = responseGroupsByUidMessage.getCommonGroups();
            }
            if (!H0.getIsHost()) {
                H0.setGroups(responseGroupsByUidMessage.getGroups());
                H0.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
            }
            H0.updateTabTitle(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
            if (groups != null) {
                PersonalGroupFragment.this.f17322g.c(groups);
                PersonalGroupFragment.this.f17322g.notifyDataSetChanged();
                if (groups.size() > 0) {
                    PersonalGroupFragment.this.f17323h.setVisibility(8);
                    PersonalGroupFragment personalGroupFragment = PersonalGroupFragment.this;
                    personalGroupFragment.f17320e.removeHeaderView(personalGroupFragment.f17323h);
                } else {
                    PersonalGroupFragment.this.f17323h.setVisibility(0);
                    PersonalGroupFragment personalGroupFragment2 = PersonalGroupFragment.this;
                    personalGroupFragment2.f17320e.removeHeaderView(personalGroupFragment2.f17323h);
                    PersonalGroupFragment personalGroupFragment3 = PersonalGroupFragment.this;
                    personalGroupFragment3.f17320e.addHeaderView(personalGroupFragment3.f17323h);
                }
                PersonalGroupFragment.this.f17320e.setVisibility(0);
            }
            if (socketResponsedMessage.getCmd() == 103003) {
                PersonalGroupFragment.this.j = false;
            } else if (socketResponsedMessage.getCmd() != 2001106 || H0.getMyGroupModel() == null) {
            } else {
                H0.getMyGroupModel().u();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity H0 = PersonalGroupFragment.this.H0();
            if (PersonalGroupFragment.this.getActivity() == null || PersonalGroupFragment.this.f17320e == null || H0 == null || H0.getMyGroupModel() == null) {
                return;
            }
            ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
            if (responseGroupsByUidLocalMessage.getError() != 0) {
                if (responseGroupsByUidLocalMessage.getError() == 0 || TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                    return;
                }
                PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                return;
            }
            if (H0.getIsHost()) {
                List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                if (PersonalGroupFragment.this.k == 1) {
                    groups = responseGroupsByUidLocalMessage.getCommonGroups();
                }
                H0.updateTabTitle(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.f17322g.c(groups);
                    PersonalGroupFragment.this.f17322g.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.f17323h.setVisibility(8);
                        PersonalGroupFragment personalGroupFragment = PersonalGroupFragment.this;
                        personalGroupFragment.f17320e.removeHeaderView(personalGroupFragment.f17323h);
                    } else {
                        PersonalGroupFragment.this.f17323h.setVisibility(0);
                        PersonalGroupFragment personalGroupFragment2 = PersonalGroupFragment.this;
                        personalGroupFragment2.f17320e.removeHeaderView(personalGroupFragment2.f17323h);
                        PersonalGroupFragment personalGroupFragment3 = PersonalGroupFragment.this;
                        personalGroupFragment3.f17320e.addHeaderView(personalGroupFragment3.f17323h);
                    }
                    PersonalGroupFragment.this.f17320e.setVisibility(0);
                }
            }
            if (H0.getMyGroupModel() != null) {
                H0.getMyGroupModel().u();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.I0(p);
            }
        }
    }

    public PersonGroupActivity H0() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    public final void I0(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if (TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP.equals(new JSONObject(groupNewsPojo.getContent()).getString(TbEnum.SystemMessage.KEY_EVENT_ID)) && j.z()) {
                    this.j = true;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.n);
        registerListener(2001106, this.o);
        registerListener(103101, this.m);
        registerListener(103112, this.m);
        registerListener(103102, this.m);
        registerListener(2001109, this.m);
        registerListener(103104, this.m);
        registerListener(103105, this.m);
        registerListener(2001126, this.l);
        registerListener(2001128, this.l);
        registerListener(2001132, this.l);
        registerListener(2001133, this.l);
        registerListener(2001130, this.l);
        registerListener(2001134, this.l);
        registerListener(2001137, this.p);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.n0.f1.n.a aVar = this.f17322g;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
        NoDataView noDataView = this.f17323h;
        if (noDataView != null) {
            SkinManager.setBackgroundColor(noDataView, R.color.CAM_X0201);
        }
        if (isAdded()) {
            H0().getLayoutMode().j(this.f17324i);
            this.f17321f.I(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.click_head) {
            GroupInfoData groupInfoData = view.getTag() instanceof GroupInfoData ? (GroupInfoData) view.getTag() : null;
            PersonGroupActivity H0 = H0();
            if (H0 == null || H0.onGroupSelected(groupInfoData) || groupInfoData == null) {
                return;
            }
            sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.e d2;
        this.k = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(R.layout.person_group_fragment, viewGroup, false);
        PersonGroupActivity H0 = H0();
        if (H0 != null && !H0.getIsHost()) {
            if (this.k == 0) {
                d2 = NoDataViewFactory.e.c(String.format(getString(R.string.person_group_no_personal_info), H0.getUtype()));
            } else {
                d2 = NoDataViewFactory.e.c(getString(R.string.person_group_no_common_info));
            }
        } else {
            d2 = (H0 == null || !H0.getIsHost()) ? null : NoDataViewFactory.e.d(getString(R.string.group_no_data_tip), getString(R.string.group_no_data_tip_1));
        }
        this.f17323h = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), d2, null);
        this.f17320e = (BdListView) inflate.findViewById(R.id.person_group_list);
        this.f17321f = new g(getPageContext());
        this.f17322g = new d.a.n0.f1.n.a(this);
        this.f17321f.a(new b());
        this.f17320e.setPullRefresh(this.f17321f);
        this.f17320e.setAdapter((ListAdapter) this.f17322g);
        this.f17320e.setOnItemClickListener(this);
        this.f17323h.setVisibility(8);
        this.f17320e.removeHeaderView(this.f17323h);
        this.f17324i = inflate.findViewById(R.id.group_fragment_parent);
        if (H0() != null && this.k == H0().getCurrentPageType()) {
            this.f17320e.F();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.n);
        MessageManager.getInstance().unRegisterListener(this.m);
        MessageManager.getInstance().unRegisterListener(this.p);
        MessageManager.getInstance().unRegisterListener(this.l);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        GroupInfoData item = this.f17322g.getItem(i2);
        PersonGroupActivity H0 = H0();
        if (H0 == null || H0.onGroupSelected(item) || item == null) {
            return;
        }
        if (this.k != 1 && !H0.getIsHost()) {
            if (H0.isCommonGroup(item.getGroupId())) {
                TiebaStatic.eventStat(getActivity(), "common_group_item", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
                return;
            }
            TiebaStatic.eventStat(getActivity(), "his_group_item", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), item.getGroupId(), 1)));
            return;
        }
        if (H0.getIsHost()) {
            TiebaStatic.eventStat(getActivity(), "my_group_item", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getActivity(), "common_group_item", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.j) {
            this.f17320e.F();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        NoDataView noDataView = this.f17323h;
        if (noDataView != null) {
            noDataView.d(H0().getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        NoDataView noDataView = this.f17323h;
        if (noDataView != null) {
            noDataView.e();
        }
    }
}

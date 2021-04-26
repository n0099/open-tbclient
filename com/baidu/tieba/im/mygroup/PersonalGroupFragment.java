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
import d.a.i0.r.f0.f;
import d.a.i0.r.f0.g;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PersonalGroupFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public BdListView f18095e = null;

    /* renamed from: f  reason: collision with root package name */
    public g f18096f = null;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.e1.n.a f18097g = null;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f18098h = null;

    /* renamed from: i  reason: collision with root package name */
    public View f18099i = null;
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

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            PersonGroupActivity I0 = PersonalGroupFragment.this.I0();
            if (I0 != null) {
                I0.getMyGroupModel().u();
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
            PersonGroupActivity I0 = PersonalGroupFragment.this.I0();
            if (PersonalGroupFragment.this.getActivity() == null || PersonalGroupFragment.this.f18095e == null || I0 == null || I0.getMyGroupModel() == null) {
                return;
            }
            if (socketResponsedMessage.getCmd() == 103003) {
                PersonalGroupFragment.this.f18095e.A(0L);
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
            if (!I0.getIsHost()) {
                I0.setGroups(responseGroupsByUidMessage.getGroups());
                I0.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
            }
            I0.updateTabTitle(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
            if (groups != null) {
                PersonalGroupFragment.this.f18097g.c(groups);
                PersonalGroupFragment.this.f18097g.notifyDataSetChanged();
                if (groups.size() > 0) {
                    PersonalGroupFragment.this.f18098h.setVisibility(8);
                    PersonalGroupFragment personalGroupFragment = PersonalGroupFragment.this;
                    personalGroupFragment.f18095e.removeHeaderView(personalGroupFragment.f18098h);
                } else {
                    PersonalGroupFragment.this.f18098h.setVisibility(0);
                    PersonalGroupFragment personalGroupFragment2 = PersonalGroupFragment.this;
                    personalGroupFragment2.f18095e.removeHeaderView(personalGroupFragment2.f18098h);
                    PersonalGroupFragment personalGroupFragment3 = PersonalGroupFragment.this;
                    personalGroupFragment3.f18095e.addHeaderView(personalGroupFragment3.f18098h);
                }
                PersonalGroupFragment.this.f18095e.setVisibility(0);
            }
            if (socketResponsedMessage.getCmd() == 103003) {
                PersonalGroupFragment.this.j = false;
            } else if (socketResponsedMessage.getCmd() != 2001106 || I0.getMyGroupModel() == null) {
            } else {
                I0.getMyGroupModel().u();
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
            PersonGroupActivity I0 = PersonalGroupFragment.this.I0();
            if (PersonalGroupFragment.this.getActivity() == null || PersonalGroupFragment.this.f18095e == null || I0 == null || I0.getMyGroupModel() == null) {
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
            if (I0.getIsHost()) {
                List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                if (PersonalGroupFragment.this.k == 1) {
                    groups = responseGroupsByUidLocalMessage.getCommonGroups();
                }
                I0.updateTabTitle(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.f18097g.c(groups);
                    PersonalGroupFragment.this.f18097g.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.f18098h.setVisibility(8);
                        PersonalGroupFragment personalGroupFragment = PersonalGroupFragment.this;
                        personalGroupFragment.f18095e.removeHeaderView(personalGroupFragment.f18098h);
                    } else {
                        PersonalGroupFragment.this.f18098h.setVisibility(0);
                        PersonalGroupFragment personalGroupFragment2 = PersonalGroupFragment.this;
                        personalGroupFragment2.f18095e.removeHeaderView(personalGroupFragment2.f18098h);
                        PersonalGroupFragment personalGroupFragment3 = PersonalGroupFragment.this;
                        personalGroupFragment3.f18095e.addHeaderView(personalGroupFragment3.f18098h);
                    }
                    PersonalGroupFragment.this.f18095e.setVisibility(0);
                }
            }
            if (I0.getMyGroupModel() != null) {
                I0.getMyGroupModel().u();
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
                PersonalGroupFragment.this.J0(p);
            }
        }
    }

    public PersonGroupActivity I0() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    public final void J0(GroupNewsPojo groupNewsPojo) {
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
        d.a.j0.e1.n.a aVar = this.f18097g;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
        NoDataView noDataView = this.f18098h;
        if (noDataView != null) {
            SkinManager.setBackgroundColor(noDataView, R.color.CAM_X0201);
        }
        if (isAdded()) {
            I0().getLayoutMode().j(this.f18099i);
            this.f18096f.I(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.click_head) {
            GroupInfoData groupInfoData = view.getTag() instanceof GroupInfoData ? (GroupInfoData) view.getTag() : null;
            PersonGroupActivity I0 = I0();
            if (I0 == null || I0.onGroupSelected(groupInfoData) || groupInfoData == null) {
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
        PersonGroupActivity I0 = I0();
        if (I0 != null && !I0.getIsHost()) {
            if (this.k == 0) {
                d2 = NoDataViewFactory.e.c(String.format(getString(R.string.person_group_no_personal_info), I0.getUtype()));
            } else {
                d2 = NoDataViewFactory.e.c(getString(R.string.person_group_no_common_info));
            }
        } else {
            d2 = (I0 == null || !I0.getIsHost()) ? null : NoDataViewFactory.e.d(getString(R.string.group_no_data_tip), getString(R.string.group_no_data_tip_1));
        }
        this.f18098h = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), d2, null);
        this.f18095e = (BdListView) inflate.findViewById(R.id.person_group_list);
        this.f18096f = new g(getPageContext());
        this.f18097g = new d.a.j0.e1.n.a(this);
        this.f18096f.a(new b());
        this.f18095e.setPullRefresh(this.f18096f);
        this.f18095e.setAdapter((ListAdapter) this.f18097g);
        this.f18095e.setOnItemClickListener(this);
        this.f18098h.setVisibility(8);
        this.f18095e.removeHeaderView(this.f18098h);
        this.f18099i = inflate.findViewById(R.id.group_fragment_parent);
        if (I0() != null && this.k == I0().getCurrentPageType()) {
            this.f18095e.F();
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
        GroupInfoData item = this.f18097g.getItem(i2);
        PersonGroupActivity I0 = I0();
        if (I0 == null || I0.onGroupSelected(item) || item == null) {
            return;
        }
        if (this.k != 1 && !I0.getIsHost()) {
            if (I0.isCommonGroup(item.getGroupId())) {
                TiebaStatic.eventStat(getActivity(), "common_group_item", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
                return;
            }
            TiebaStatic.eventStat(getActivity(), "his_group_item", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), item.getGroupId(), 1)));
            return;
        }
        if (I0.getIsHost()) {
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
            this.f18095e.F();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        NoDataView noDataView = this.f18098h;
        if (noDataView != null) {
            noDataView.d(I0().getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        NoDataView noDataView = this.f18098h;
        if (noDataView != null) {
            noDataView.e();
        }
    }
}

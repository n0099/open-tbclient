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
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PersonalGroupFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView ewr = null;
    private h mPullView = null;
    private a ews = null;
    private NoDataView aSW = null;
    private View ewt = null;
    private int pageType = 0;
    private final c ewu = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.eaX = true;
        }
    };
    private final c ewv = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.eaX = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c eww = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity aLR = PersonalGroupFragment.this.aLR();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.ewr != null && aLR != null && aLR.aLN() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.ewr.completePullRefreshPostDelayed(2000L);
                }
                ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
                if (responseGroupsByUidMessage.getError() != 0) {
                    if (responseGroupsByUidMessage.getError() != 0) {
                        PersonalGroupFragment.this.showToast(StringUtils.isNull(responseGroupsByUidMessage.getErrorString()) ? PersonalGroupFragment.this.getResources().getString(d.k.neterror) : responseGroupsByUidMessage.getErrorString());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
                if (PersonalGroupFragment.this.pageType == 1) {
                    groups = responseGroupsByUidMessage.getCommonGroups();
                }
                if (!aLR.aLM()) {
                    aLR.setGroups(responseGroupsByUidMessage.getGroups());
                    aLR.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                aLR.bg(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.ews.cu(groups);
                    PersonalGroupFragment.this.ews.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.aSW.setVisibility(8);
                        PersonalGroupFragment.this.ewr.removeHeaderView(PersonalGroupFragment.this.aSW);
                    } else {
                        PersonalGroupFragment.this.aSW.setVisibility(0);
                        PersonalGroupFragment.this.ewr.removeHeaderView(PersonalGroupFragment.this.aSW);
                        PersonalGroupFragment.this.ewr.addHeaderView(PersonalGroupFragment.this.aSW);
                    }
                    PersonalGroupFragment.this.ewr.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.eaX = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && aLR.aLN() != null) {
                    aLR.aLN().update();
                }
            }
        }
    };
    private final CustomMessageListener ewx = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity aLR = PersonalGroupFragment.this.aLR();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.ewr != null && aLR != null && aLR.aLN() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (aLR.aLM()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    aLR.bg(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.ews.cu(groups);
                        PersonalGroupFragment.this.ews.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.aSW.setVisibility(8);
                            PersonalGroupFragment.this.ewr.removeHeaderView(PersonalGroupFragment.this.aSW);
                        } else {
                            PersonalGroupFragment.this.aSW.setVisibility(0);
                            PersonalGroupFragment.this.ewr.removeHeaderView(PersonalGroupFragment.this.aSW);
                            PersonalGroupFragment.this.ewr.addHeaderView(PersonalGroupFragment.this.aSW);
                        }
                        PersonalGroupFragment.this.ewr.setVisibility(0);
                    }
                }
                if (aLR.aLN() != null) {
                    aLR.aLN().update();
                }
            }
        }
    };
    private final CustomMessageListener acM = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean eaX = false;

    public PersonGroupActivity aLR() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eaX) {
            this.ewr.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.eww);
        MessageManager.getInstance().unRegisterListener(this.ewv);
        MessageManager.getInstance().unRegisterListener(this.acM);
        MessageManager.getInstance().unRegisterListener(this.ewu);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.eww);
        registerListener(2001106, this.ewx);
        registerListener(103101, this.ewv);
        registerListener(103112, this.ewv);
        registerListener(103102, this.ewv);
        registerListener(2001109, this.ewv);
        registerListener(103104, this.ewv);
        registerListener(103105, this.ewv);
        registerListener(2001126, this.ewu);
        registerListener(2001128, this.ewu);
        registerListener(2001132, this.ewu);
        registerListener(2001133, this.ewu);
        registerListener(2001130, this.ewu);
        registerListener(2001134, this.ewu);
        registerListener(2001137, this.acM);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.aSW != null) {
            this.aSW.e(aLR().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.aSW != null) {
            this.aSW.onActivityStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d aj;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(d.i.person_group_fragment, viewGroup, false);
        PersonGroupActivity aLR = aLR();
        if (aLR != null && !aLR.aLM()) {
            if (this.pageType == 0) {
                aj = NoDataViewFactory.d.fo(String.format(getString(d.k.person_group_no_personal_info), aLR.aLL()));
            } else {
                aj = NoDataViewFactory.d.fo(getString(d.k.person_group_no_common_info));
            }
        } else {
            aj = (aLR == null || !aLR.aLM()) ? null : NoDataViewFactory.d.aj(getString(d.k.group_no_data_tip), getString(d.k.group_no_data_tip_1));
        }
        this.aSW = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), aj, null);
        this.ewr = (BdListView) inflate.findViewById(d.g.person_group_list);
        this.mPullView = new h(getPageContext());
        this.ews = new a(this);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                PersonGroupActivity aLR2 = PersonalGroupFragment.this.aLR();
                if (aLR2 != null) {
                    aLR2.aLN().update();
                }
            }
        });
        this.ewr.setPullRefresh(this.mPullView);
        this.ewr.setAdapter((ListAdapter) this.ews);
        this.ewr.setOnItemClickListener(this);
        this.aSW.setVisibility(8);
        this.ewr.removeHeaderView(this.aSW);
        this.ewt = inflate.findViewById(d.g.group_fragment_parent);
        if (aLR() != null && this.pageType == aLR().aLK()) {
            this.ewr.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.ews.getItem(i);
        PersonGroupActivity aLR = aLR();
        if (aLR != null && !aLR.b(item) && item != null) {
            if (this.pageType == 1 || aLR.aLM()) {
                if (aLR.aLM()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (aLR.bY(item.getGroupId())) {
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
        if (view.getId() == d.g.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            PersonGroupActivity aLR = aLR();
            if (aLR != null && !aLR.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ews != null) {
            this.ews.notifyDataSetChanged();
        }
        if (this.aSW != null) {
            am.j(this.aSW, d.C0142d.cp_bg_line_d);
        }
        if (isAdded()) {
            aLR().getLayoutMode().onModeChanged(this.ewt);
            this.mPullView.dz(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && j.jD()) {
                    this.eaX = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

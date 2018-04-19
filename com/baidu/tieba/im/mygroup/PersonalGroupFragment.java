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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.core.view.f;
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
    public BdListView egg = null;
    private f mPullView = null;
    private a egh = null;
    private NoDataView aJy = null;
    private View egi = null;
    private int pageType = 0;
    private final c egj = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.dKP = true;
        }
    };
    private final c egk = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.dKP = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c egl = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity aGs = PersonalGroupFragment.this.aGs();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.egg != null && aGs != null && aGs.aGo() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.egg.completePullRefreshPostDelayed(2000L);
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
                if (!aGs.aGn()) {
                    aGs.setGroups(responseGroupsByUidMessage.getGroups());
                    aGs.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                aGs.bg(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.egh.ci(groups);
                    PersonalGroupFragment.this.egh.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.aJy.setVisibility(8);
                        PersonalGroupFragment.this.egg.removeHeaderView(PersonalGroupFragment.this.aJy);
                    } else {
                        PersonalGroupFragment.this.aJy.setVisibility(0);
                        PersonalGroupFragment.this.egg.removeHeaderView(PersonalGroupFragment.this.aJy);
                        PersonalGroupFragment.this.egg.addHeaderView(PersonalGroupFragment.this.aJy);
                    }
                    PersonalGroupFragment.this.egg.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.dKP = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && aGs.aGo() != null) {
                    aGs.aGo().update();
                }
            }
        }
    };
    private final CustomMessageListener egm = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity aGs = PersonalGroupFragment.this.aGs();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.egg != null && aGs != null && aGs.aGo() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (aGs.aGn()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    aGs.bg(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.egh.ci(groups);
                        PersonalGroupFragment.this.egh.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.aJy.setVisibility(8);
                            PersonalGroupFragment.this.egg.removeHeaderView(PersonalGroupFragment.this.aJy);
                        } else {
                            PersonalGroupFragment.this.aJy.setVisibility(0);
                            PersonalGroupFragment.this.egg.removeHeaderView(PersonalGroupFragment.this.aJy);
                            PersonalGroupFragment.this.egg.addHeaderView(PersonalGroupFragment.this.aJy);
                        }
                        PersonalGroupFragment.this.egg.setVisibility(0);
                    }
                }
                if (aGs.aGo() != null) {
                    aGs.aGo().update();
                }
            }
        }
    };
    private final CustomMessageListener UN = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean dKP = false;

    public PersonGroupActivity aGs() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dKP) {
            this.egg.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.egl);
        MessageManager.getInstance().unRegisterListener(this.egk);
        MessageManager.getInstance().unRegisterListener(this.UN);
        MessageManager.getInstance().unRegisterListener(this.egj);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.egl);
        registerListener(2001106, this.egm);
        registerListener(103101, this.egk);
        registerListener(103112, this.egk);
        registerListener(103102, this.egk);
        registerListener(2001109, this.egk);
        registerListener(103104, this.egk);
        registerListener(103105, this.egk);
        registerListener(2001126, this.egj);
        registerListener(2001128, this.egj);
        registerListener(2001132, this.egj);
        registerListener(2001133, this.egj);
        registerListener(2001130, this.egj);
        registerListener(2001134, this.egj);
        registerListener(2001137, this.UN);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.aJy != null) {
            this.aJy.e(aGs().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.aJy != null) {
            this.aJy.onActivityStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d af;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(d.i.person_group_fragment, viewGroup, false);
        PersonGroupActivity aGs = aGs();
        if (aGs != null && !aGs.aGn()) {
            if (this.pageType == 0) {
                af = NoDataViewFactory.d.eL(String.format(getString(d.k.person_group_no_personal_info), aGs.aGm()));
            } else {
                af = NoDataViewFactory.d.eL(getString(d.k.person_group_no_common_info));
            }
        } else {
            af = (aGs == null || !aGs.aGn()) ? null : NoDataViewFactory.d.af(getString(d.k.group_no_data_tip), getString(d.k.group_no_data_tip_1));
        }
        this.aJy = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), af, null);
        this.egg = (BdListView) inflate.findViewById(d.g.person_group_list);
        this.mPullView = new f(getPageContext());
        this.egh = new a(this);
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                PersonGroupActivity aGs2 = PersonalGroupFragment.this.aGs();
                if (aGs2 != null) {
                    aGs2.aGo().update();
                }
            }
        });
        this.egg.setPullRefresh(this.mPullView);
        this.egg.setAdapter((ListAdapter) this.egh);
        this.egg.setOnItemClickListener(this);
        this.aJy.setVisibility(8);
        this.egg.removeHeaderView(this.aJy);
        this.egi = inflate.findViewById(d.g.group_fragment_parent);
        if (aGs() != null && this.pageType == aGs().aGl()) {
            this.egg.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        GroupInfoData item = this.egh.getItem(i);
        PersonGroupActivity aGs = aGs();
        if (aGs != null && !aGs.b(item) && item != null) {
            if (this.pageType == 1 || aGs.aGn()) {
                if (aGs.aGn()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (aGs.bW(item.getGroupId())) {
                TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else {
                TiebaStatic.eventStat(getActivity(), "his_group_item", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), item.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2.getId() == d.g.click_head) {
            GroupInfoData groupInfoData = null;
            if (view2.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view2.getTag();
            }
            PersonGroupActivity aGs = aGs();
            if (aGs != null && !aGs.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.egh != null) {
            this.egh.notifyDataSetChanged();
        }
        if (this.aJy != null) {
            ak.j(this.aJy, d.C0126d.cp_bg_line_d);
        }
        if (isAdded()) {
            aGs().getLayoutMode().u(this.egi);
            this.mPullView.dv(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && j.gP()) {
                    this.dKP = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

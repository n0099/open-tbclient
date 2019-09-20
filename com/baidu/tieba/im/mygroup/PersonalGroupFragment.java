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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
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
    public BdListView gQZ = null;
    private i mPullView = null;
    private a gRa = null;
    private NoDataView czY = null;
    private View gRb = null;
    private int pageType = 0;
    private final c gRc = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalGroupFragment.this.gvT = true;
        }
    };
    private final c gRd = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.3
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
                        PersonalGroupFragment.this.gvT = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final c gRe = new c(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonGroupActivity bGR = PersonalGroupFragment.this.bGR();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.gQZ != null && bGR != null && bGR.bGO() != null) {
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.gQZ.completePullRefreshPostDelayed(0L);
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
                if (PersonalGroupFragment.this.pageType == 1) {
                    groups = responseGroupsByUidMessage.getCommonGroups();
                }
                if (!bGR.bGN()) {
                    bGR.setGroups(responseGroupsByUidMessage.getGroups());
                    bGR.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                bGR.bZ(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    PersonalGroupFragment.this.gRa.dg(groups);
                    PersonalGroupFragment.this.gRa.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        PersonalGroupFragment.this.czY.setVisibility(8);
                        PersonalGroupFragment.this.gQZ.removeHeaderView(PersonalGroupFragment.this.czY);
                    } else {
                        PersonalGroupFragment.this.czY.setVisibility(0);
                        PersonalGroupFragment.this.gQZ.removeHeaderView(PersonalGroupFragment.this.czY);
                        PersonalGroupFragment.this.gQZ.addHeaderView(PersonalGroupFragment.this.czY);
                    }
                    PersonalGroupFragment.this.gQZ.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    PersonalGroupFragment.this.gvT = false;
                } else if (socketResponsedMessage.getCmd() == 2001106 && bGR.bGO() != null) {
                    bGR.bGO().update();
                }
            }
        }
    };
    private final CustomMessageListener gRf = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonGroupActivity bGR = PersonalGroupFragment.this.bGR();
            if (PersonalGroupFragment.this.getActivity() != null && PersonalGroupFragment.this.gQZ != null && bGR != null && bGR.bGO() != null) {
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        PersonalGroupFragment.this.showToast(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (bGR.bGN()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (PersonalGroupFragment.this.pageType == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    bGR.bZ(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        PersonalGroupFragment.this.gRa.dg(groups);
                        PersonalGroupFragment.this.gRa.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            PersonalGroupFragment.this.czY.setVisibility(8);
                            PersonalGroupFragment.this.gQZ.removeHeaderView(PersonalGroupFragment.this.czY);
                        } else {
                            PersonalGroupFragment.this.czY.setVisibility(0);
                            PersonalGroupFragment.this.gQZ.removeHeaderView(PersonalGroupFragment.this.czY);
                            PersonalGroupFragment.this.gQZ.addHeaderView(PersonalGroupFragment.this.czY);
                        }
                        PersonalGroupFragment.this.gQZ.setVisibility(0);
                    }
                }
                if (bGR.bGO() != null) {
                    bGR.bGO().update();
                }
            }
        }
    };
    private final CustomMessageListener bDW = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                PersonalGroupFragment.this.d(p);
            }
        }
    };
    public boolean gvT = false;

    public PersonGroupActivity bGR() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gvT) {
            this.gQZ.startPullRefresh();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.gRe);
        MessageManager.getInstance().unRegisterListener(this.gRd);
        MessageManager.getInstance().unRegisterListener(this.bDW);
        MessageManager.getInstance().unRegisterListener(this.gRc);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.gRe);
        registerListener(2001106, this.gRf);
        registerListener(103101, this.gRd);
        registerListener(103112, this.gRd);
        registerListener(103102, this.gRd);
        registerListener(2001109, this.gRd);
        registerListener(103104, this.gRd);
        registerListener(103105, this.gRd);
        registerListener(2001126, this.gRc);
        registerListener(2001128, this.gRc);
        registerListener(2001132, this.gRc);
        registerListener(2001133, this.gRc);
        registerListener(2001130, this.gRc);
        registerListener(2001134, this.gRc);
        registerListener(2001137, this.bDW);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.czY != null) {
            this.czY.e(bGR().getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.czY != null) {
            this.czY.akI();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NoDataViewFactory.d bX;
        this.pageType = getArguments().getInt("page_type", 0);
        getArguments().getInt("page_size", 1);
        View inflate = layoutInflater.inflate(R.layout.person_group_fragment, viewGroup, false);
        PersonGroupActivity bGR = bGR();
        if (bGR != null && !bGR.bGN()) {
            if (this.pageType == 0) {
                bX = NoDataViewFactory.d.oX(String.format(getString(R.string.person_group_no_personal_info), bGR.bGM()));
            } else {
                bX = NoDataViewFactory.d.oX(getString(R.string.person_group_no_common_info));
            }
        } else {
            bX = (bGR == null || !bGR.bGN()) ? null : NoDataViewFactory.d.bX(getString(R.string.group_no_data_tip), getString(R.string.group_no_data_tip_1));
        }
        this.czY = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), bX, null);
        this.gQZ = (BdListView) inflate.findViewById(R.id.person_group_list);
        this.mPullView = new i(getPageContext());
        this.gRa = new a(this);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.im.mygroup.PersonalGroupFragment.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                PersonGroupActivity bGR2 = PersonalGroupFragment.this.bGR();
                if (bGR2 != null) {
                    bGR2.bGO().update();
                }
            }
        });
        this.gQZ.setPullRefresh(this.mPullView);
        this.gQZ.setAdapter((ListAdapter) this.gRa);
        this.gQZ.setOnItemClickListener(this);
        this.czY.setVisibility(8);
        this.gQZ.removeHeaderView(this.czY);
        this.gRb = inflate.findViewById(R.id.group_fragment_parent);
        if (bGR() != null && this.pageType == bGR().bGL()) {
            this.gQZ.startPullRefresh();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.gRa.getItem(i);
        PersonGroupActivity bGR = bGR();
        if (bGR != null && !bGR.b(item) && item != null) {
            if (this.pageType == 1 || bGR.bGN()) {
                if (bGR.bGN()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (bGR.dK(item.getGroupId())) {
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
        if (view.getId() == R.id.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            PersonGroupActivity bGR = bGR();
            if (bGR != null && !bGR.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gRa != null) {
            this.gRa.notifyDataSetChanged();
        }
        if (this.czY != null) {
            am.l(this.czY, R.color.cp_bg_line_d);
        }
        if (isAdded()) {
            bGR().getLayoutMode().onModeChanged(this.gRb);
            this.mPullView.iY(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && j.kc()) {
                    this.gvT = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

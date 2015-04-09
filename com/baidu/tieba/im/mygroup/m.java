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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.ag;
import com.baidu.tbadk.core.view.v;
import com.baidu.tbadk.core.view.w;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.t;
import com.baidu.tieba.y;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView blT = null;
    private ag mPullView = null;
    private k blU = null;
    private com.baidu.tbadk.core.view.s anU = null;
    private View blV = null;
    private int blX = 0;
    private final com.baidu.adp.framework.listener.e blY = new n(this, 0);
    private final com.baidu.adp.framework.listener.e blZ = new o(this, 0);
    private final com.baidu.adp.framework.listener.e bma = new p(this, 0);
    private final CustomMessageListener bmb = new q(this, 0);
    private final CustomMessageListener Ou = new r(this, 0);
    public boolean blW = false;

    public PersonGroupActivity Tj() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.blW) {
            this.blT.mX();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.bma);
        MessageManager.getInstance().unRegisterListener(this.blZ);
        MessageManager.getInstance().unRegisterListener(this.Ou);
        MessageManager.getInstance().unRegisterListener(this.blY);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.bma);
        registerListener(2001106, this.bmb);
        registerListener(103101, this.blZ);
        registerListener(103112, this.blZ);
        registerListener(103102, this.blZ);
        registerListener(2001109, this.blZ);
        registerListener(103104, this.blZ);
        registerListener(103105, this.blZ);
        registerListener(2001130, this.blY);
        registerListener(2001132, this.blY);
        registerListener(2001136, this.blY);
        registerListener(2001137, this.blY);
        registerListener(2001134, this.blY);
        registerListener(2001138, this.blY);
        registerListener(2001141, this.Ou);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.anU != null) {
            this.anU.e(Tj().getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.anU != null) {
            this.anU.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        w wVar;
        this.blX = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.person_group_fragment, viewGroup, false);
        PersonGroupActivity Tj = Tj();
        if (Tj != null && !Tj.Te()) {
            i = (int) getResources().getDimension(t.ds80);
            if (this.blX == 0) {
                wVar = w.cZ(String.format(getString(y.person_group_no_personal_info), Tj.Td()));
            } else {
                wVar = w.cZ(getString(y.person_group_no_common_info));
            }
        } else if (Tj == null || !Tj.Te()) {
            i = 0;
            wVar = null;
        } else {
            i = (int) getResources().getDimension(t.ds160);
            wVar = w.ac(getString(y.group_no_data_tip), getString(y.group_no_data_tip_1));
        }
        this.anU = NoDataViewFactory.a(getActivity(), inflate, v.a(NoDataViewFactory.ImgType.NODATA, i), wVar, null);
        this.blT = (BdListView) inflate.findViewById(com.baidu.tieba.v.person_group_list);
        this.mPullView = new ag(getPageContext());
        this.blU = new k(this);
        this.mPullView.a(new s(this));
        this.blT.setPullRefresh(this.mPullView);
        this.blT.setAdapter((ListAdapter) this.blU);
        this.blT.setOnItemClickListener(this);
        this.anU.setVisibility(8);
        this.blV = inflate.findViewById(com.baidu.tieba.v.group_fragment_parent);
        if (Tj() != null && this.blX == Tj().Tc()) {
            this.blT.mX();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.blU.getItem(i);
        PersonGroupActivity Tj = Tj();
        if (Tj != null && !Tj.b(item) && item != null) {
            if (this.blX == 1 || Tj.Te()) {
                if (Tj.Te()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (Tj.gj(item.getGroupId())) {
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
        if (view.getId() == com.baidu.tieba.v.click_head) {
            GroupInfoData groupInfoData = null;
            if (view.getTag() instanceof GroupInfoData) {
                groupInfoData = (GroupInfoData) view.getTag();
            }
            PersonGroupActivity Tj = Tj();
            if (Tj != null && !Tj.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.anU != null) {
            ba.j(this.anU, com.baidu.tieba.s.cp_bg_line_d);
        }
        if (isAdded()) {
            Tj().getLayoutMode().h(this.blV);
            this.mPullView.ct(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDismissGroup(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && com.baidu.adp.lib.util.k.iH()) {
                    this.blW = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

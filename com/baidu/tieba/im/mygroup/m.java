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
    public BdListView blD = null;
    private ag mPullView = null;
    private k blE = null;
    private com.baidu.tbadk.core.view.s anM = null;
    private View blF = null;
    private int blH = 0;
    private final com.baidu.adp.framework.listener.e blI = new n(this, 0);
    private final com.baidu.adp.framework.listener.e blJ = new o(this, 0);
    private final com.baidu.adp.framework.listener.e blK = new p(this, 0);
    private final CustomMessageListener blL = new q(this, 0);
    private final CustomMessageListener Os = new r(this, 0);
    public boolean blG = false;

    public PersonGroupActivity SW() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonGroupActivity) {
            return (PersonGroupActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.blG) {
            this.blD.mX();
        }
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        MessageManager.getInstance().unRegisterListener(this.blK);
        MessageManager.getInstance().unRegisterListener(this.blJ);
        MessageManager.getInstance().unRegisterListener(this.Os);
        MessageManager.getInstance().unRegisterListener(this.blI);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(103003, this.blK);
        registerListener(2001106, this.blL);
        registerListener(103101, this.blJ);
        registerListener(103112, this.blJ);
        registerListener(103102, this.blJ);
        registerListener(2001109, this.blJ);
        registerListener(103104, this.blJ);
        registerListener(103105, this.blJ);
        registerListener(2001130, this.blI);
        registerListener(2001132, this.blI);
        registerListener(2001136, this.blI);
        registerListener(2001137, this.blI);
        registerListener(2001134, this.blI);
        registerListener(2001138, this.blI);
        registerListener(2001141, this.Os);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.anM != null) {
            this.anM.e(SW().getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.anM != null) {
            this.anM.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        w wVar;
        this.blH = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.person_group_fragment, viewGroup, false);
        PersonGroupActivity SW = SW();
        if (SW != null && !SW.SR()) {
            i = (int) getResources().getDimension(t.ds80);
            if (this.blH == 0) {
                wVar = w.cZ(String.format(getString(y.person_group_no_personal_info), SW.SQ()));
            } else {
                wVar = w.cZ(getString(y.person_group_no_common_info));
            }
        } else if (SW == null || !SW.SR()) {
            i = 0;
            wVar = null;
        } else {
            i = (int) getResources().getDimension(t.ds160);
            wVar = w.ac(getString(y.group_no_data_tip), getString(y.group_no_data_tip_1));
        }
        this.anM = NoDataViewFactory.a(getActivity(), inflate, v.a(NoDataViewFactory.ImgType.NODATA, i), wVar, null);
        this.blD = (BdListView) inflate.findViewById(com.baidu.tieba.v.person_group_list);
        this.mPullView = new ag(getPageContext());
        this.blE = new k(this);
        this.mPullView.a(new s(this));
        this.blD.setPullRefresh(this.mPullView);
        this.blD.setAdapter((ListAdapter) this.blE);
        this.blD.setOnItemClickListener(this);
        this.anM.setVisibility(8);
        this.blF = inflate.findViewById(com.baidu.tieba.v.group_fragment_parent);
        if (SW() != null && this.blH == SW().SP()) {
            this.blD.mX();
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupInfoData item = this.blE.getItem(i);
        PersonGroupActivity SW = SW();
        if (SW != null && !SW.b(item) && item != null) {
            if (this.blH == 1 || SW.SR()) {
                if (SW.SR()) {
                    TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
                } else {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
            } else if (SW.gh(item.getGroupId())) {
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
            PersonGroupActivity SW = SW();
            if (SW != null && !SW.b(groupInfoData) && groupInfoData != null) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.anM != null) {
            ba.j(this.anM, com.baidu.tieba.s.cp_bg_line_d);
        }
        if (isAdded()) {
            SW().getLayoutMode().h(this.blF);
            this.mPullView.ct(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDismissGroup(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            try {
                if ("107".equals(new JSONObject(groupNewsPojo.getContent()).getString("eventId")) && com.baidu.adp.lib.util.k.iH()) {
                    this.blG = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

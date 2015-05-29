package com.baidu.tieba.addresslist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.aj;
import com.baidu.tbadk.core.view.al;
import com.baidu.tbadk.newFriends.NewFriendsActivityConfig;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tieba.addresslist.view.AssortView;
import java.util.List;
/* loaded from: classes.dex */
public class e extends BaseFragment implements aj, com.baidu.tieba.addresslist.b.b, com.baidu.tieba.addresslist.view.a {
    private View LG;
    private com.baidu.tieba.addresslist.c.a ayX;
    private g ayY;
    private h ayZ;
    private i aza;
    private j azb;
    private long azc;
    private AssortView azd;
    private LinearLayout aze;
    private BdListView azf;
    private com.baidu.tieba.addresslist.a.a azg;
    private TextView azh;
    private ImageView azi;
    private int azj;
    private BaseFragmentActivity azk;
    private com.baidu.tbadk.core.c mLayoutMode;
    private final CustomMessageListener mNetworkChangedMessageListener = new f(this, 2001121);
    private al mPullView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener();
        this.azc = 0L;
        this.ayX = new com.baidu.tieba.addresslist.c.a(getBaseFragmentActivity());
        this.ayX.setUniqueId(getUniqueId());
    }

    private void registerListener() {
        this.ayY = new g(this);
        registerListener(this.ayY);
        this.ayZ = new h(this);
        registerListener(this.ayZ);
        this.aza = new i(this);
        registerListener(this.aza);
        this.azb = new j(this);
        registerListener(this.azb);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.azk = getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        FI();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ayX.b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity != null) {
            this.mLayoutMode = baseFragmentActivity.getLayoutMode();
        }
        return b(layoutInflater);
    }

    private View b(LayoutInflater layoutInflater) {
        this.LG = com.baidu.adp.lib.g.b.hr().inflate(this.azk.getPageContext().getPageActivity(), com.baidu.tieba.r.addresslist_fragment, null);
        this.mPullView = new al(this.azk.getPageContext());
        this.azg = new com.baidu.tieba.addresslist.a.a(TbadkCoreApplication.m411getInst().getApplicationContext(), this.mLayoutMode);
        this.aze = (LinearLayout) com.baidu.adp.lib.g.b.hr().a(this.azk.getBaseContext(), com.baidu.tieba.r.addresslist_search_layout, null, false);
        this.aze.setOnClickListener(this);
        this.azi = (ImageView) this.aze.findViewById(com.baidu.tieba.q.addresslist_search_icon);
        this.azh = (TextView) this.aze.findViewById(com.baidu.tieba.q.addresslist_search_bar);
        this.azf = (BdListView) this.LG.findViewById(com.baidu.tieba.q.addresslist_contacts_list);
        this.azf.setPullRefresh(this.mPullView);
        this.azf.addHeaderView(this.aze);
        this.azf.setAdapter((ListAdapter) this.azg);
        this.azf.setOnItemClickListener(this);
        this.mPullView.a(this);
        this.azd = (AssortView) this.LG.findViewById(com.baidu.tieba.q.addresslist_assortview);
        this.azd.setClickable(true);
        this.azd.setOnTouchListener(this);
        return this.LG;
    }

    private void FH() {
        this.ayX.Gm();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.ayX.a(this);
        FH();
    }

    private void FI() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void u(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.azg.setContacts(list);
        this.azg.ez(this.azj);
        this.azg.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.azd.setVisibility(8);
        } else {
            this.azd.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.addresslist.b.b
    public void v(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        u(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mLayoutMode != null) {
            this.mLayoutMode.ab(i == 1);
            this.mLayoutMode.j(this.LG);
            this.mLayoutMode.j(this.aze);
        }
        ay.i(this.aze, com.baidu.tieba.n.cp_bg_line_d);
        ay.i((View) this.azh, com.baidu.tieba.p.enter_forum_inputbox_top);
        ay.b(this.azh, com.baidu.tieba.n.cp_cont_d, 1);
        ay.i(this.azi, com.baidu.tieba.p.icon_head_bar_search);
        this.mPullView.cy(i);
        this.azg.notifyDataSetChanged();
        this.azd.invalidate();
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.azc) <= 30000) {
            this.azf.completePullRefresh();
        } else if (com.baidu.adp.lib.util.n.isNetOk()) {
            this.azc = System.currentTimeMillis();
            this.ayX.Gc();
        } else {
            this.azf.completePullRefresh();
            showToast(com.baidu.tieba.t.no_network_guide);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.q.addresslist_search_layout) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), QuickSearchActivity.class);
            getActivity().startActivity(intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            sendMessage(new CustomMessage(2002001, new NewFriendsActivityConfig(getActivity())));
            this.azj = 0;
            this.azg.ez(this.azj);
            this.azg.notifyDataSetChanged();
            com.baidu.tbadk.core.k.A(TbadkCoreApplication.m411getInst().getApplicationContext(), "contacts_new");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001189));
        } else if (i == 1) {
            sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            com.baidu.tbadk.core.k.A(TbadkCoreApplication.m411getInst().getApplicationContext(), "contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = this.azg.getItem(i);
            if (item != null && item.getUserId() > 0) {
                if (item.getUserType() == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.getUserPortrait(), 0, 4)));
                    return;
                }
                sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkCoreApplication.m411getInst().getApplicationContext(), String.valueOf(item.getUserId()), item.getUserName())));
            }
        }
    }

    @Override // com.baidu.tieba.addresslist.view.a
    public void fr(String str) {
        int fG;
        List<com.baidu.tbadk.coreExtra.relationship.a> Gl = this.ayX.Gl();
        if (Gl != null && Gl.size() != 0 && (fG = this.ayX.fG(str)) >= 0) {
            this.azf.setSelection(fG + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.a
    public void FJ() {
    }
}

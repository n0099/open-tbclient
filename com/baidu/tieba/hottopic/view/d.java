package com.baidu.tieba.hottopic.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.adapter.l;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.data.k;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends com.baidu.adp.base.c<RelateTopicForumActivity> {
    private BdListView US;
    private NoNetworkView flI;
    private PbListView fnt;
    private RelateTopicForumActivity iHC;
    private l iHD;
    private List<RelateForumItemData> iHE;
    private AdapterView.OnItemClickListener iHF;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.US = null;
        this.iHE = null;
        this.iHF = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RelateForumItemData relateForumItemData;
                if (i >= 0 && (relateForumItemData = (RelateForumItemData) d.this.iHE.get(i)) != null && ar.isForumName(relateForumItemData.forumName)) {
                    if (relateForumItemData.forumId != 0) {
                        TiebaStatic.log(new ao("c10371").dk("fid", String.valueOf(relateForumItemData.forumId)).ag("obj_type", k.iEK).dk("topic_id", d.this.iHC.getTopicId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.iHC.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        };
        this.iHC = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.iHE = list.subList(0, 20);
            } else {
                this.iHE = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.iHC.getLayoutMode().setNightMode(i == 1);
        this.iHC.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.iHC.getPageContext(), i);
        this.flI.onChangeSkinType(this.iHC.getPageContext(), i);
        this.fnt.changeSkin(i);
    }

    private void initView() {
        if (this.iHC != null) {
            this.iHC.setContentView(R.layout.hot_topic_more_activity);
            this.mRootView = this.iHC.findViewById(R.id.topic_list_root_view);
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.hot_topic_list_navigationbar_title);
            this.flI = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.US = (BdListView) this.mRootView.findViewById(R.id.hot_topic_more_list);
            BdListViewHelper.a(this.iHC.getActivity(), this.US, BdListViewHelper.HeadType.DEFAULT);
            this.iHD = new l(this.iHC);
            this.fnt = new PbListView(this.iHC.getPageContext().getPageActivity());
            this.fnt.createView();
            this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.US.setAdapter((ListAdapter) this.iHD);
            this.iHD.b(this.iHE, this.iHC.getTopicId());
            this.US.setOnItemClickListener(this.iHF);
        }
    }

    public void buJ() {
        if (this.US != null && this.fnt != null) {
            this.US.setNextPage(this.fnt);
            this.fnt.endLoadData();
            this.fnt.setText(this.iHC.getResources().getString(R.string.list_no_more));
        }
    }

    public void buK() {
        if (this.US != null && this.fnt != null) {
            this.US.setNextPage(null);
            this.fnt.hideEmptyView();
        }
    }

    public l cmm() {
        return this.iHD;
    }
}

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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
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
/* loaded from: classes15.dex */
public class d extends com.baidu.adp.base.c<RelateTopicForumActivity> {
    private BdListView UL;
    private NoNetworkView fqQ;
    private PbListView fsC;
    private RelateTopicForumActivity iNH;
    private l iNI;
    private List<RelateForumItemData> iNJ;
    private AdapterView.OnItemClickListener iNK;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.UL = null;
        this.iNJ = null;
        this.iNK = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RelateForumItemData relateForumItemData;
                if (i >= 0 && (relateForumItemData = (RelateForumItemData) d.this.iNJ.get(i)) != null && as.isForumName(relateForumItemData.forumName)) {
                    if (relateForumItemData.forumId != 0) {
                        TiebaStatic.log(new ap("c10371").dn("fid", String.valueOf(relateForumItemData.forumId)).ah("obj_type", k.iKO).dn("topic_id", d.this.iNH.getTopicId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.iNH.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        };
        this.iNH = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.iNJ = list.subList(0, 20);
            } else {
                this.iNJ = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.iNH.getLayoutMode().setNightMode(i == 1);
        this.iNH.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.iNH.getPageContext(), i);
        this.fqQ.onChangeSkinType(this.iNH.getPageContext(), i);
        this.fsC.changeSkin(i);
    }

    private void initView() {
        if (this.iNH != null) {
            this.iNH.setContentView(R.layout.hot_topic_more_activity);
            this.mRootView = this.iNH.findViewById(R.id.topic_list_root_view);
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.hot_topic_list_navigationbar_title);
            this.fqQ = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.UL = (BdListView) this.mRootView.findViewById(R.id.hot_topic_more_list);
            BdListViewHelper.a(this.iNH.getActivity(), this.UL, BdListViewHelper.HeadType.DEFAULT);
            this.iNI = new l(this.iNH);
            this.fsC = new PbListView(this.iNH.getPageContext().getPageActivity());
            this.fsC.createView();
            this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.UL.setAdapter((ListAdapter) this.iNI);
            this.iNI.b(this.iNJ, this.iNH.getTopicId());
            this.UL.setOnItemClickListener(this.iNK);
        }
    }

    public void bxT() {
        if (this.UL != null && this.fsC != null) {
            this.UL.setNextPage(this.fsC);
            this.fsC.endLoadData();
            this.fsC.setText(this.iNH.getResources().getString(R.string.list_no_more));
        }
    }

    public void bxU() {
        if (this.UL != null && this.fsC != null) {
            this.UL.setNextPage(null);
            this.fsC.hideEmptyView();
        }
    }

    public l cpN() {
        return this.iNI;
    }
}

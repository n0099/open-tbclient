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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
    private BdListView Vo;
    private NoNetworkView fCm;
    private PbListView fDW;
    private RelateTopicForumActivity jcH;
    private l jcI;
    private List<RelateForumItemData> jcJ;
    private AdapterView.OnItemClickListener jcK;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.Vo = null;
        this.jcJ = null;
        this.jcK = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RelateForumItemData relateForumItemData;
                if (i >= 0 && (relateForumItemData = (RelateForumItemData) d.this.jcJ.get(i)) != null && at.isForumName(relateForumItemData.forumName)) {
                    if (relateForumItemData.forumId != 0) {
                        TiebaStatic.log(new aq("c10371").dD("fid", String.valueOf(relateForumItemData.forumId)).ai("obj_type", k.iZO).dD("topic_id", d.this.jcH.getTopicId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.jcH.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        };
        this.jcH = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.jcJ = list.subList(0, 20);
            } else {
                this.jcJ = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.jcH.getLayoutMode().setNightMode(i == 1);
        this.jcH.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jcH.getPageContext(), i);
        this.fCm.onChangeSkinType(this.jcH.getPageContext(), i);
        this.fDW.changeSkin(i);
    }

    private void initView() {
        if (this.jcH != null) {
            this.jcH.setContentView(R.layout.hot_topic_more_activity);
            this.mRootView = this.jcH.findViewById(R.id.topic_list_root_view);
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.hot_topic_list_navigationbar_title);
            this.fCm = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.Vo = (BdListView) this.mRootView.findViewById(R.id.hot_topic_more_list);
            BdListViewHelper.a(this.jcH.getActivity(), this.Vo, BdListViewHelper.HeadType.DEFAULT);
            this.jcI = new l(this.jcH);
            this.fDW = new PbListView(this.jcH.getPageContext().getPageActivity());
            this.fDW.createView();
            this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.Vo.setAdapter((ListAdapter) this.jcI);
            this.jcI.b(this.jcJ, this.jcH.getTopicId());
            this.Vo.setOnItemClickListener(this.jcK);
        }
    }

    public void bGS() {
        if (this.Vo != null && this.fDW != null) {
            this.Vo.setNextPage(this.fDW);
            this.fDW.endLoadData();
            this.fDW.setText(this.jcH.getResources().getString(R.string.list_no_more));
        }
    }

    public void bGT() {
        if (this.Vo != null && this.fDW != null) {
            this.Vo.setNextPage(null);
            this.fDW.hideEmptyView();
        }
    }

    public l cAF() {
        return this.jcI;
    }
}

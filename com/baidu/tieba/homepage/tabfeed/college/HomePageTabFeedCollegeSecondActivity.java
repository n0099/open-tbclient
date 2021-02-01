package com.baidu.tieba.homepage.tabfeed.college;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.GridSpaceItemDecoration;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import java.util.List;
/* loaded from: classes2.dex */
public class HomePageTabFeedCollegeSecondActivity extends BaseActivity {
    private f<SpecialColumnItemData> kgb = new f<SpecialColumnItemData>() { // from class: com.baidu.tieba.homepage.tabfeed.college.HomePageTabFeedCollegeSecondActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, SpecialColumnItemData specialColumnItemData, int i, long j) {
            if (specialColumnItemData != null) {
                switch (specialColumnItemData.specialType) {
                    case 1:
                    case 2:
                    case 4:
                        HomePageTabFeedCollegeSecondActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(HomePageTabFeedCollegeSecondActivity.this).createNormalCfg(String.valueOf(specialColumnItemData.threadId), null, null)));
                        return;
                    case 3:
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = specialColumnItemData.liveId;
                        HomePageTabFeedCollegeSecondActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HomePageTabFeedCollegeSecondActivity.this, alaLiveInfoCoreData, "active_view_jump_live_room", "", false, "")));
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, SpecialColumnItemData specialColumnItemData, int i, long j) {
            if (specialColumnItemData == null) {
            }
        }
    };
    private BdRecyclerView knm;
    private HomePageTabFeedCollegeSecondListAdapter knn;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activtiy_homepage_tabfeed_colleagsecond_layout);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_college_petrol_station);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.knm = (BdRecyclerView) findViewById(R.id.listview_college_petrol_station);
        SpecialColumnListData specialColumnListData = (SpecialColumnListData) getIntent().getParcelableExtra("data");
        if (specialColumnListData != null) {
            this.mNavigationBar.setCenterTextTitle(specialColumnListData.getTitle());
            final List<SpecialColumnItemData> bRH = specialColumnListData.bRH();
            if (bRH != null && bRH.size() > 0) {
                SpecialColumnItemData specialColumnItemData = bRH.get(0);
                if (specialColumnItemData.specialType == 1 || specialColumnItemData.specialType == 2) {
                    this.knm.setLayoutManager(new LinearLayoutManager(this));
                } else if (specialColumnItemData.specialType == 3 || specialColumnItemData.specialType == 4) {
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
                    gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.baidu.tieba.homepage.tabfeed.college.HomePageTabFeedCollegeSecondActivity.1
                        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                        public int getSpanSize(int i) {
                            return i == bRH.size() ? 2 : 1;
                        }
                    });
                    this.knm.setLayoutManager(gridLayoutManager);
                    int dimens = l.getDimens(this, R.dimen.tbds44);
                    int dimens2 = l.getDimens(this, R.dimen.tbds44);
                    this.knm.addItemDecoration(new GridSpaceItemDecoration(dimens, l.getDimens(this, R.dimen.tbds11), dimens2));
                }
            }
            this.knn = new HomePageTabFeedCollegeSecondListAdapter(this, bRH);
        }
        this.knn.a(this.kgb);
        this.knm.setAdapter(this.knn);
        View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_homepage_tabfeed_footer_view_layout, (ViewGroup) null);
        ap.setViewTextColor(inflate.findViewById(R.id.tv_footer_content), R.color.CAM_X0109, 1);
        this.knm.addFooterView(inflate);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.knn.notifyDataSetChanged();
    }
}

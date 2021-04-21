package com.baidu.tieba.homepage.tabfeed.college;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.GridSpaceItemDecoration;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import d.b.c.e.p.l;
import d.b.i0.m.f;
import java.util.List;
/* loaded from: classes4.dex */
public class HomePageTabFeedCollegeSecondActivity extends BaseActivity {
    public HomePageTabFeedCollegeSecondListAdapter adapter;
    public BdRecyclerView bdRecyclerView;
    public NavigationBar mNavigationBar;
    public f<SpecialColumnItemData> mOnItemClickListener = new b();

    /* loaded from: classes4.dex */
    public class a extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f16999a;

        public a(List list) {
            this.f16999a = list;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return i == this.f16999a.size() ? 2 : 1;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f<SpecialColumnItemData> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.m.f
        /* renamed from: b */
        public void c(View view, SpecialColumnItemData specialColumnItemData, int i, long j) {
            if (specialColumnItemData == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.m.f
        /* renamed from: d */
        public void a(View view, SpecialColumnItemData specialColumnItemData, int i, long j) {
            if (specialColumnItemData == null) {
                return;
            }
            int i2 = specialColumnItemData.specialType;
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = specialColumnItemData.liveId;
                    HomePageTabFeedCollegeSecondActivity.this.sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(HomePageTabFeedCollegeSecondActivity.this, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_ACTIVE_VIEW, "", false, "")));
                    return;
                } else if (i2 != 4) {
                    return;
                }
            }
            HomePageTabFeedCollegeSecondActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(HomePageTabFeedCollegeSecondActivity.this).createNormalCfg(String.valueOf(specialColumnItemData.threadId), null, null)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.adapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activtiy_homepage_tabfeed_colleagsecond_layout);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navi_college_petrol_station);
        this.mNavigationBar = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bdRecyclerView = (BdRecyclerView) findViewById(R.id.listview_college_petrol_station);
        SpecialColumnListData specialColumnListData = (SpecialColumnListData) getIntent().getParcelableExtra("data");
        if (specialColumnListData != null) {
            this.mNavigationBar.setCenterTextTitle(specialColumnListData.B());
            List<SpecialColumnItemData> A = specialColumnListData.A();
            if (A != null && A.size() > 0) {
                int i = A.get(0).specialType;
                if (i == 1 || i == 2) {
                    this.bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                } else if (i == 3 || i == 4) {
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
                    gridLayoutManager.setSpanSizeLookup(new a(A));
                    this.bdRecyclerView.setLayoutManager(gridLayoutManager);
                    int g2 = l.g(this, R.dimen.tbds44);
                    int g3 = l.g(this, R.dimen.tbds44);
                    this.bdRecyclerView.addItemDecoration(new GridSpaceItemDecoration(g2, l.g(this, R.dimen.tbds11), g3));
                }
            }
            this.adapter = new HomePageTabFeedCollegeSecondListAdapter(this, A);
        }
        this.adapter.h(this.mOnItemClickListener);
        this.bdRecyclerView.setAdapter(this.adapter);
        View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_homepage_tabfeed_footer_view_layout, (ViewGroup) null);
        SkinManager.setViewTextColor(inflate.findViewById(R.id.tv_footer_content), R.color.CAM_X0109, 1);
        this.bdRecyclerView.r(inflate);
    }
}

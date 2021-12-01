package com.baidu.tieba.homepage.tabfeed.college;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.l;
import c.a.q0.n.f;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.GridSpaceItemDecoration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes10.dex */
public class HomePageTabFeedCollegeSecondActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedCollegeSecondListAdapter adapter;
    public BdRecyclerView bdRecyclerView;
    public NavigationBar mNavigationBar;
    public f<SpecialColumnItemData> mOnItemClickListener;

    /* loaded from: classes10.dex */
    public class a extends GridLayoutManager.SpanSizeLookup {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondActivity f45393b;

        public a(HomePageTabFeedCollegeSecondActivity homePageTabFeedCollegeSecondActivity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedCollegeSecondActivity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45393b = homePageTabFeedCollegeSecondActivity;
            this.a = list;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? i2 == this.a.size() ? 2 : 1 : invokeI.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b implements f<SpecialColumnItemData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedCollegeSecondActivity f45394e;

        public b(HomePageTabFeedCollegeSecondActivity homePageTabFeedCollegeSecondActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedCollegeSecondActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45394e = homePageTabFeedCollegeSecondActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.n.f
        /* renamed from: b */
        public void c(View view, SpecialColumnItemData specialColumnItemData, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, specialColumnItemData, Integer.valueOf(i2), Long.valueOf(j2)}) != null) || specialColumnItemData == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.n.f
        /* renamed from: d */
        public void a(View view, SpecialColumnItemData specialColumnItemData, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, specialColumnItemData, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || specialColumnItemData == null) {
                return;
            }
            int i3 = specialColumnItemData.specialType;
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = specialColumnItemData.liveId;
                    this.f45394e.sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f45394e, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_ACTIVE_VIEW, "", false, "")));
                    return;
                } else if (i3 != 4) {
                    return;
                }
            }
            this.f45394e.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f45394e).createNormalCfg(String.valueOf(specialColumnItemData.threadId), null, null)));
        }
    }

    public HomePageTabFeedCollegeSecondActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOnItemClickListener = new b(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.adapter.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.activtiy_homepage_tabfeed_colleagsecond_layout);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navi_college_petrol_station);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.showBottomLine();
            this.bdRecyclerView = (BdRecyclerView) findViewById(R.id.listview_college_petrol_station);
            SpecialColumnListData specialColumnListData = (SpecialColumnListData) getIntent().getParcelableExtra("data");
            if (specialColumnListData != null) {
                this.mNavigationBar.setCenterTextTitle(specialColumnListData.getTitle());
                List<SpecialColumnItemData> resultData = specialColumnListData.getResultData();
                if (resultData != null && resultData.size() > 0) {
                    int i2 = resultData.get(0).specialType;
                    if (i2 == 1 || i2 == 2) {
                        this.bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                    } else if (i2 == 3 || i2 == 4) {
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
                        gridLayoutManager.setSpanSizeLookup(new a(this, resultData));
                        this.bdRecyclerView.setLayoutManager(gridLayoutManager);
                        int f2 = l.f(this, R.dimen.tbds44);
                        int f3 = l.f(this, R.dimen.tbds44);
                        this.bdRecyclerView.addItemDecoration(new GridSpaceItemDecoration(f2, l.f(this, R.dimen.tbds11), f3));
                    }
                }
                this.adapter = new HomePageTabFeedCollegeSecondListAdapter(this, resultData);
            }
            this.adapter.setContentOnClickListener(this.mOnItemClickListener);
            this.bdRecyclerView.setAdapter(this.adapter);
            View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_homepage_tabfeed_footer_view_layout, (ViewGroup) null);
            SkinManager.setViewTextColor(inflate.findViewById(R.id.tv_footer_content), R.color.CAM_X0109, 1);
            this.bdRecyclerView.addFooterView(inflate);
        }
    }
}

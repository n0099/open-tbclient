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
import com.repackage.lm4;
import com.repackage.oi;
import java.util.List;
/* loaded from: classes3.dex */
public class HomePageTabFeedCollegeSecondActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedCollegeSecondListAdapter adapter;
    public BdRecyclerView bdRecyclerView;
    public NavigationBar mNavigationBar;
    public lm4<SpecialColumnItemData> mOnItemClickListener;

    /* loaded from: classes3.dex */
    public class a extends GridLayoutManager.SpanSizeLookup {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ HomePageTabFeedCollegeSecondActivity b;

        public a(HomePageTabFeedCollegeSecondActivity homePageTabFeedCollegeSecondActivity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedCollegeSecondActivity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = homePageTabFeedCollegeSecondActivity;
            this.a = list;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i == this.a.size() ? 2 : 1 : invokeI.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements lm4<SpecialColumnItemData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedCollegeSecondActivity a;

        public b(HomePageTabFeedCollegeSecondActivity homePageTabFeedCollegeSecondActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedCollegeSecondActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homePageTabFeedCollegeSecondActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.lm4
        /* renamed from: b */
        public void c(View view2, SpecialColumnItemData specialColumnItemData, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, specialColumnItemData, Integer.valueOf(i), Long.valueOf(j)}) != null) || specialColumnItemData == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.lm4
        /* renamed from: d */
        public void a(View view2, SpecialColumnItemData specialColumnItemData, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, specialColumnItemData, Integer.valueOf(i), Long.valueOf(j)}) == null) || specialColumnItemData == null) {
                return;
            }
            int i2 = specialColumnItemData.specialType;
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = specialColumnItemData.liveId;
                    this.a.sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.a, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_ACTIVE_VIEW, "", false, "")));
                    return;
                } else if (i2 != 4) {
                    return;
                }
            }
            this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a).createNormalCfg(String.valueOf(specialColumnItemData.threadId), null, null)));
        }
    }

    public HomePageTabFeedCollegeSecondActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOnItemClickListener = new b(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            this.adapter.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0063);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0914f4);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.showBottomLine();
            this.bdRecyclerView = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f09127b);
            SpecialColumnListData specialColumnListData = (SpecialColumnListData) getIntent().getParcelableExtra("data");
            if (specialColumnListData != null) {
                this.mNavigationBar.setCenterTextTitle(specialColumnListData.getTitle());
                List<SpecialColumnItemData> resultData = specialColumnListData.getResultData();
                if (resultData != null && resultData.size() > 0) {
                    int i = resultData.get(0).specialType;
                    if (i == 1 || i == 2) {
                        this.bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                    } else if (i == 3 || i == 4) {
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
                        gridLayoutManager.setSpanSizeLookup(new a(this, resultData));
                        this.bdRecyclerView.setLayoutManager(gridLayoutManager);
                        int f = oi.f(this, R.dimen.tbds44);
                        int f2 = oi.f(this, R.dimen.tbds44);
                        this.bdRecyclerView.addItemDecoration(new GridSpaceItemDecoration(f, oi.f(this, R.dimen.tbds11), f2));
                    }
                }
                this.adapter = new HomePageTabFeedCollegeSecondListAdapter(this, resultData);
            }
            this.adapter.i(this.mOnItemClickListener);
            this.bdRecyclerView.setAdapter(this.adapter);
            View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.obfuscated_res_0x7f0d03fc, (ViewGroup) null);
            SkinManager.setViewTextColor(inflate.findViewById(R.id.obfuscated_res_0x7f092190), R.color.CAM_X0109, 1);
            this.bdRecyclerView.r(inflate);
        }
    }
}

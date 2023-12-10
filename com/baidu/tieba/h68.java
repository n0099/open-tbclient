package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.mainTab.FragmentDelegate;
import com.baidu.tbadk.mainTab.FragmentTabStructure;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.h5.FrsTabWebFragment;
import com.baidu.tieba.frs.h5.NewFrsTabWebFragment;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsTabInfo;
/* loaded from: classes6.dex */
public class h68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends FragmentDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;
        public final /* synthetic */ FrsTabInfo b;
        public final /* synthetic */ FrsViewData c;
        public final /* synthetic */ int d;

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(FrsFragment frsFragment, FrsTabInfo frsTabInfo, FrsViewData frsViewData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, frsTabInfo, frsViewData, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
            this.b = frsTabInfo;
            this.c = frsViewData;
            this.d = i;
        }

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public FragmentTabStructure createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                FrsFragment frsFragment = this.a;
                if (frsFragment != null && frsFragment.u2() != null) {
                    frsAllThreadFragment.I2(this.a.u2().Y());
                    this.a.Z5(x88.e(this.b, this.c.showAdsense.intValue()));
                }
                Bundle bundle = new Bundle();
                FrsFragment frsFragment2 = this.a;
                if (frsFragment2 != null) {
                    bundle.putString("forum_id", frsFragment2.w());
                }
                bundle.putInt("tab_id", this.d);
                bundle.putBoolean("isAdded", false);
                frsAllThreadFragment.setArguments(bundle);
                FragmentTabStructure fragmentTabStructure = new FragmentTabStructure();
                fragmentTabStructure.frag = frsAllThreadFragment;
                fragmentTabStructure.type = 1;
                fragmentTabStructure.showIconType = FragmentTabStructure.SHOWTEXT;
                return fragmentTabStructure;
            }
            return (FragmentTabStructure) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends FragmentDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ FrsFragment c;
        public final /* synthetic */ int d;

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public b(FrsTabInfo frsTabInfo, FrsViewData frsViewData, FrsFragment frsFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabInfo, frsViewData, frsFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabInfo;
            this.b = frsViewData;
            this.c = frsFragment;
            this.d = i;
        }

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public FragmentTabStructure createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, x88.e(this.a, this.b.showAdsense.intValue()));
                bundle.putString("name", this.c.v());
                bundle.putString("from", this.c.getFrom());
                bundle.putBoolean("back_special", false);
                bundle.putBoolean(FrsActivityConfig.GOOD, true);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.c.w());
                bundle.putBoolean("isAdded", false);
                frsGoodFragment.setArguments(bundle);
                FragmentTabStructure fragmentTabStructure = new FragmentTabStructure();
                fragmentTabStructure.frag = frsGoodFragment;
                fragmentTabStructure.type = this.d;
                fragmentTabStructure.showIconType = FragmentTabStructure.SHOWTEXT;
                return fragmentTabStructure;
            }
            return (FragmentTabStructure) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends FragmentDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ FrsFragment c;
        public final /* synthetic */ int d;

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public c(FrsTabInfo frsTabInfo, FrsViewData frsViewData, FrsFragment frsFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabInfo, frsViewData, frsFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabInfo;
            this.b = frsViewData;
            this.c = frsFragment;
            this.d = i;
        }

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public FragmentTabStructure createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, x88.e(this.a, this.b.showAdsense.intValue()));
                bundle.putString("name", this.c.v());
                bundle.putString("from", this.c.getFrom());
                bundle.putBoolean("back_special", false);
                bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                bundle.putString("forum_id", this.c.w());
                bundle.putBoolean("isAdded", false);
                frsNewAreaFragment.setArguments(bundle);
                FragmentTabStructure fragmentTabStructure = new FragmentTabStructure();
                fragmentTabStructure.frag = frsNewAreaFragment;
                fragmentTabStructure.type = this.d;
                fragmentTabStructure.showIconType = FragmentTabStructure.SHOWTEXT;
                return fragmentTabStructure;
            }
            return (FragmentTabStructure) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends FragmentDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public d(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public FragmentTabStructure createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsADFragment frsADFragment = new FrsADFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.a.v());
                bundle.putString("from", this.a.getFrom());
                bundle.putString("forum_id", this.a.w());
                bundle.putBoolean("isAdded", false);
                frsADFragment.setArguments(bundle);
                FragmentTabStructure fragmentTabStructure = new FragmentTabStructure();
                fragmentTabStructure.frag = frsADFragment;
                fragmentTabStructure.type = 90;
                fragmentTabStructure.showIconType = FragmentTabStructure.SHOWTEXT;
                return fragmentTabStructure;
            }
            return (FragmentTabStructure) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e extends FragmentDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ FrsFragment c;
        public final /* synthetic */ int d;

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public e(FrsTabInfo frsTabInfo, FrsViewData frsViewData, FrsFragment frsFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabInfo, frsViewData, frsFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabInfo;
            this.b = frsViewData;
            this.c = frsFragment;
            this.d = i;
        }

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public FragmentTabStructure createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, x88.e(this.a, this.b.showAdsense.intValue()));
                bundle.putString("name", this.c.v());
                bundle.putString("from", this.c.getFrom());
                bundle.putString("forum_id", this.c.w());
                bundle.putInt("tab_id", this.d);
                bundle.putInt("tab_type", this.a.tab_type.intValue());
                bundle.putString("tab_name", this.a.tab_name);
                bundle.putInt("is_general_tab", this.a.is_general_tab.intValue());
                bundle.putBoolean("can_auto_play_video", this.b.isFrsVideoAutoPlay);
                boolean z = true;
                if (this.b.needLog != 1) {
                    z = false;
                }
                bundle.putBoolean(DownloadStatisticConstants.UBC_SOURCE_NEED_LOG, z);
                bundle.putBoolean("is_brand_forum", this.b.isBrandForum);
                bundle.putSerializable("view_data", this.b);
                bundle.putBoolean("isAdded", false);
                frsCommonTabFragment.setArguments(bundle);
                FragmentTabStructure fragmentTabStructure = new FragmentTabStructure();
                fragmentTabStructure.frag = frsCommonTabFragment;
                fragmentTabStructure.type = this.d;
                fragmentTabStructure.showIconType = FragmentTabStructure.SHOWTEXT;
                return fragmentTabStructure;
            }
            return (FragmentTabStructure) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f extends FragmentDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabInfo a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ FrsFragment c;
        public final /* synthetic */ int d;

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public f(FrsTabInfo frsTabInfo, FrsViewData frsViewData, FrsFragment frsFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabInfo, frsViewData, frsFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabInfo;
            this.b = frsViewData;
            this.c = frsFragment;
            this.d = i;
        }

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public FragmentTabStructure createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, x88.e(this.a, this.b.showAdsense.intValue()));
                bundle.putString("name", this.c.v());
                bundle.putString("from", this.c.getFrom());
                bundle.putString("forum_id", this.c.w());
                bundle.putInt("tab_id", this.d);
                bundle.putInt("tab_type", this.a.tab_type.intValue());
                bundle.putString("tab_name", this.a.tab_name);
                bundle.putString("tab_url", this.a.tab_url);
                bundle.putInt("is_general_tab", this.a.is_general_tab.intValue());
                bundle.putBoolean("can_auto_play_video", this.b.isFrsVideoAutoPlay);
                boolean z = true;
                if (this.b.needLog != 1) {
                    z = false;
                }
                bundle.putBoolean(DownloadStatisticConstants.UBC_SOURCE_NEED_LOG, z);
                bundle.putBoolean("is_brand_forum", this.b.isBrandForum);
                bundle.putSerializable("view_data", this.b);
                bundle.putBoolean("isAdded", false);
                FragmentTabStructure fragmentTabStructure = new FragmentTabStructure();
                if (mj6.e(this.a.tab_url)) {
                    NewFrsTabWebFragment newFrsTabWebFragment = new NewFrsTabWebFragment();
                    newFrsTabWebFragment.setArguments(bundle);
                    fragmentTabStructure.frag = newFrsTabWebFragment;
                } else {
                    FrsTabWebFragment frsTabWebFragment = new FrsTabWebFragment();
                    frsTabWebFragment.setArguments(bundle);
                    fragmentTabStructure.frag = frsTabWebFragment;
                }
                fragmentTabStructure.type = this.d;
                fragmentTabStructure.showIconType = FragmentTabStructure.SHOWTEXT;
                return fragmentTabStructure;
            }
            return (FragmentTabStructure) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g extends FragmentDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;
        public final /* synthetic */ int b;
        public final /* synthetic */ FrsTabInfo c;
        public final /* synthetic */ FrsViewData d;
        public final /* synthetic */ String e;

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return null;
            }
            return (TbFragmentTabIndicator) invokeL.objValue;
        }

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public g(FrsFragment frsFragment, int i, FrsTabInfo frsTabInfo, FrsViewData frsViewData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i), frsTabInfo, frsViewData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
            this.b = i;
            this.c = frsTabInfo;
            this.d = frsViewData;
            this.e = str;
        }

        @Override // com.baidu.tbadk.mainTab.FragmentDelegate
        public FragmentTabStructure createFragmentTabStructure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsItemTabFragment frsItemTabFragment = new FrsItemTabFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", this.a.v());
                bundle.putString("from", this.a.getFrom());
                bundle.putString("forum_id", this.a.w());
                bundle.putInt("tab_id", this.b);
                bundle.putInt("tab_type", this.c.tab_type.intValue());
                bundle.putString("tab_name", this.c.tab_name);
                bundle.putString("tab_code", this.c.tab_code);
                boolean z = true;
                if (this.d.needLog != 1) {
                    z = false;
                }
                bundle.putBoolean(DownloadStatisticConstants.UBC_SOURCE_NEED_LOG, z);
                bundle.putString("theme_color", this.e);
                bundle.putBoolean("isAdded", false);
                bundle.putInt(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, this.a.F4());
                frsItemTabFragment.setArguments(bundle);
                frsItemTabFragment.M2(this.a.getUniqueId());
                FragmentTabStructure fragmentTabStructure = new FragmentTabStructure();
                fragmentTabStructure.frag = frsItemTabFragment;
                fragmentTabStructure.type = this.b;
                fragmentTabStructure.showIconType = FragmentTabStructure.SHOWTEXT;
                return fragmentTabStructure;
            }
            return (FragmentTabStructure) invokeV.objValue;
        }
    }

    public static FragmentDelegate a(@NonNull FrsTabInfo frsTabInfo, @NonNull FrsFragment frsFragment, @NonNull FrsViewData frsViewData, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, frsTabInfo, frsFragment, frsViewData, str)) == null) {
            int intValue = frsTabInfo.tab_id.intValue();
            if (intValue == 1) {
                return new a(frsFragment, frsTabInfo, frsViewData, intValue);
            }
            if (intValue == 301) {
                return new b(frsTabInfo, frsViewData, frsFragment, intValue);
            }
            if (intValue == 503) {
                return new c(frsTabInfo, frsViewData, frsFragment, intValue);
            }
            if (intValue == 90) {
                return new d(frsFragment);
            }
            if (frsTabInfo.tab_type.intValue() != 91 && intValue != 89 && intValue != 504 && frsTabInfo.tab_type.intValue() != 15 && frsTabInfo.tab_type.intValue() != 16 && frsTabInfo.tab_type.intValue() != 3 && frsTabInfo.tab_type.intValue() != 100) {
                if (frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_type.intValue() == 102) {
                    return new f(frsTabInfo, frsViewData, frsFragment, intValue);
                }
                if (intValue == 506) {
                    return new g(frsFragment, intValue, frsTabInfo, frsViewData, str);
                }
                return null;
            }
            return new e(frsTabInfo, frsViewData, frsFragment, intValue);
        }
        return (FragmentDelegate) invokeLLLL.objValue;
    }
}

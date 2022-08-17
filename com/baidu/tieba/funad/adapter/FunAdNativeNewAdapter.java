package com.baidu.tieba.funad.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.funad.view.FunAbsAdView;
import com.baidu.tieba.funad.view.FunAdNativeCommentView;
import com.baidu.tieba.funad.view.FunAdNativeFrsView;
import com.baidu.tieba.funad.view.FunAdNativePbView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bn;
import com.repackage.fo4;
import com.repackage.ft6;
import com.repackage.ir4;
import com.repackage.on;
import com.repackage.pb8;
import com.repackage.rs6;
import com.repackage.ub8;
import com.repackage.ud5;
import com.repackage.xl5;
import com.repackage.xs6;
import com.repackage.zk8;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class FunAdNativeNewAdapter extends bn<on, FunAdNativeViewHolder> implements ub8, pb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isMulDelete;
    public final BaseFragmentActivity mActivity;
    public String mFromTab;
    public String pageType;
    public String sceneKey;
    public String sid;
    public Set<String> sidSet;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk8 a;
        public final /* synthetic */ FunAdNativeViewHolder b;
        public final /* synthetic */ FunAdNativeNewAdapter c;

        public a(FunAdNativeNewAdapter funAdNativeNewAdapter, zk8 zk8Var, FunAdNativeViewHolder funAdNativeViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdNativeNewAdapter, zk8Var, funAdNativeViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = funAdNativeNewAdapter;
            this.a = zk8Var;
            this.b = funAdNativeViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p(true);
                this.c.notifyDataSetChanged();
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.b.e()).param(TiebaStatic.Params.RESOURCE_ID, this.c.getStatisticResourceId()).param("obj_locate", 0);
                if ("a006".equals(this.b.e())) {
                    param.param(TiebaStatic.Params.OBJ_TO, this.b.c());
                    param.param(TiebaStatic.Params.OBJ_PARAM2, this.b.b());
                }
                TiebaStatic.log(param);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdNativeNewAdapter(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sidSet = new HashSet();
        this.mActivity = baseFragmentActivity;
    }

    private void showVipAdGuideTip(zk8 zk8Var, FunAdNativeViewHolder funAdNativeViewHolder, String str) {
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, zk8Var, funAdNativeViewHolder, str) == null) {
            if ("pb_banner".equals(this.sceneKey)) {
                a2 = zk8Var.a();
            } else {
                a2 = zk8Var.a();
                if (xl5.k().m()) {
                    a2++;
                }
            }
            ft6.e(zk8Var, funAdNativeViewHolder, str, this.pageType, this.mFromTab, a2);
        }
    }

    public String getStatisticResourceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "pb".equals(this.pageType) ? this.mType == AdvertAppInfo.I ? "2" : "1" : "" : (String) invokeV.objValue;
    }

    @Override // com.repackage.pb8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            V v = this.viewholder;
            if (v != 0 && ((FunAdNativeViewHolder) v).d() != null) {
                ((FunAdNativeViewHolder) this.viewholder).d().b();
            }
            for (String str : this.sidSet) {
                rs6.m().c(str);
            }
        }
    }

    @Override // com.repackage.pb8
    public void onPause() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (v = this.viewholder) == 0 || ((FunAdNativeViewHolder) v).d() == null) {
            return;
        }
        ((FunAdNativeViewHolder) this.viewholder).d().b();
    }

    @Override // com.repackage.pb8
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.repackage.ub8
    public void setIsFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // com.repackage.bn
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.isMulDelete = z;
        }
    }

    public void setPageTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mFromTab = str;
        }
    }

    public void setPageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.pageType = str;
        }
    }

    public void setSceneKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.sceneKey = str;
        }
    }

    public void setSid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.sid = str;
        }
    }

    public void updateFontSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    public FunAdNativeViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        FunAbsAdView funAdNativePbView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            BdUniqueId bdUniqueId = this.mType;
            if (bdUniqueId == AdvertAppInfo.I) {
                funAdNativePbView = new FunAdNativeCommentView(this.mActivity);
            } else if (bdUniqueId == AdvertAppInfo.H) {
                funAdNativePbView = new FunAdNativeFrsView(this.mActivity);
            } else {
                funAdNativePbView = new FunAdNativePbView(this.mActivity);
            }
            FunAdNativeViewHolder funAdNativeViewHolder = new FunAdNativeViewHolder(funAdNativePbView, this.mActivity, this.mType);
            funAdNativeViewHolder.l(this.sid);
            funAdNativeViewHolder.k(this.sceneKey);
            return funAdNativeViewHolder;
        }
        return (FunAdNativeViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, on onVar, FunAdNativeViewHolder funAdNativeViewHolder) {
        InterceptResult invokeCommon;
        long j;
        zk8 zk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, onVar, funAdNativeViewHolder})) == null) {
            if (onVar instanceof ir4) {
                ThreadData threadData = ((ir4) onVar).t;
                zk8Var = threadData.funAdData;
                j = threadData.getFid();
            } else if (onVar instanceof ThreadData) {
                ThreadData threadData2 = (ThreadData) onVar;
                zk8Var = threadData2.funAdData;
                j = threadData2.getFid();
            } else {
                j = 0;
                zk8Var = onVar instanceof PostData ? ((PostData) onVar).t0 : null;
            }
            if (zk8Var == null) {
                funAdNativeViewHolder.d().d(8);
                return funAdNativeViewHolder.getView();
            }
            showVipAdGuideTip(zk8Var, funAdNativeViewHolder, String.valueOf(j));
            funAdNativeViewHolder.d().setFunAdMaskViewVisible(this.isMulDelete);
            if (!"personalize".equals(this.pageType) && !AdvertAppInfo.I.equals(this.mType)) {
                this.sid = xs6.e().d(this.sceneKey);
            }
            BdUniqueId bdUniqueId = this.mType;
            if (bdUniqueId == AdvertAppInfo.H) {
                if ("frs".equals(this.pageType)) {
                    rs6.m().K(this.mActivity, this.sid, rs6.b(this.pageType, UbsABTestHelper.isFrsFunAdSdkTest() ? "1" : "0"), String.valueOf(j), ud5.f());
                } else if ("personalize".equals(this.pageType)) {
                    rs6.m().J(this.mActivity, this.sid, rs6.b(this.pageType, UbsABTestHelper.isPersonalizeFunAdABTest() ? "1" : "0"));
                }
            } else if (bdUniqueId == AdvertAppInfo.I) {
                rs6.m().L(this.mActivity, this.sid, rs6.b(this.pageType, UbsABTestHelper.isPbCommentFunAdABTest() ? "1" : "0"), zk8Var.g(), zk8Var.d());
            }
            funAdNativeViewHolder.i(new a(this, zk8Var, funAdNativeViewHolder));
            funAdNativeViewHolder.d().h();
            funAdNativeViewHolder.j(this.pageType);
            funAdNativeViewHolder.d().setCurpage(this.pageType);
            funAdNativeViewHolder.l(this.sid);
            this.sidSet.add(this.sid);
            funAdNativeViewHolder.m(zk8Var, onVar instanceof fo4 ? ((fo4) onVar).position + 1 : -1);
            return funAdNativeViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}

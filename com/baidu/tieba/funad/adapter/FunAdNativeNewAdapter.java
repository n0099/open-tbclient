package com.baidu.tieba.funad.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.dk7;
import com.baidu.tieba.funad.view.FunAbsAdView;
import com.baidu.tieba.funad.view.FunAdNativeCommentView;
import com.baidu.tieba.funad.view.FunAdNativeFrsView;
import com.baidu.tieba.funad.view.FunAdNativePbView;
import com.baidu.tieba.hn;
import com.baidu.tieba.jk7;
import com.baidu.tieba.jw4;
import com.baidu.tieba.kp5;
import com.baidu.tieba.ma9;
import com.baidu.tieba.oz4;
import com.baidu.tieba.ql9;
import com.baidu.tieba.ra9;
import com.baidu.tieba.rk7;
import com.baidu.tieba.sl9;
import com.baidu.tieba.um;
import com.baidu.tieba.yy5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class FunAdNativeNewAdapter extends um<hn, FunAdNativeViewHolder> implements ra9, ma9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isMulDelete;
    public final BaseFragmentActivity mActivity;
    public String mFromTab;
    public String pageType;
    public String sceneKey;
    public String sid;
    public Set<String> sidSet;

    @Override // com.baidu.tieba.ma9
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ra9
    public void setIsFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    public void updateFontSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql9 a;
        public final /* synthetic */ FunAdNativeViewHolder b;
        public final /* synthetic */ FunAdNativeNewAdapter c;

        public a(FunAdNativeNewAdapter funAdNativeNewAdapter, ql9 ql9Var, FunAdNativeViewHolder funAdNativeViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdNativeNewAdapter, ql9Var, funAdNativeViewHolder};
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
            this.a = ql9Var;
            this.b = funAdNativeViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, "delFunAd"));
                this.c.notifyDataSetChanged();
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.b.e()).param("resource_id", this.c.getStatisticResourceId()).param("obj_locate", 0);
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

    private void showVipAdGuideTip(ql9 ql9Var, FunAdNativeViewHolder funAdNativeViewHolder, String str) {
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, ql9Var, funAdNativeViewHolder, str) == null) {
            if ("pb_banner".equals(this.sceneKey)) {
                a2 = ql9Var.a();
            } else {
                a2 = ql9Var.a();
                if (yy5.k().m()) {
                    a2++;
                }
            }
            rk7.e(ql9Var, funAdNativeViewHolder, str, this.pageType, this.mFromTab, a2);
        }
    }

    public String getStatisticResourceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if ("pb".equals(this.pageType)) {
                if (this.mType == AdvertAppInfo.I) {
                    return "2";
                }
                return "1";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ma9
    public void onPause() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (v = this.viewholder) != 0 && ((FunAdNativeViewHolder) v).d() != null) {
            ((FunAdNativeViewHolder) this.viewholder).d().b();
        }
    }

    @Override // com.baidu.tieba.um
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.um
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

    @Override // com.baidu.tieba.ma9
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            V v = this.viewholder;
            if (v != 0 && ((FunAdNativeViewHolder) v).d() != null) {
                ((FunAdNativeViewHolder) this.viewholder).d().b();
            }
            for (String str : this.sidSet) {
                dk7.m().c(str);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.um
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, hn hnVar, FunAdNativeViewHolder funAdNativeViewHolder) {
        InterceptResult invokeCommon;
        ql9 ql9Var;
        long j;
        ql9 ql9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hnVar, funAdNativeViewHolder})) == null) {
            if (hnVar instanceof oz4) {
                ThreadData threadData = ((oz4) hnVar).t;
                ql9Var2 = threadData.funAdData;
                j = threadData.getFid();
            } else if (hnVar instanceof ThreadData) {
                ThreadData threadData2 = (ThreadData) hnVar;
                ql9Var2 = threadData2.funAdData;
                j = threadData2.getFid();
            } else {
                if (hnVar instanceof sl9) {
                    ql9Var = ((sl9) hnVar).w0;
                } else {
                    ql9Var = null;
                }
                j = 0;
                ql9Var2 = ql9Var;
            }
            if (ql9Var2 == null) {
                funAdNativeViewHolder.d().d(8);
                return funAdNativeViewHolder.getView();
            }
            showVipAdGuideTip(ql9Var2, funAdNativeViewHolder, String.valueOf(j));
            funAdNativeViewHolder.d().setFunAdMaskViewVisible(this.isMulDelete);
            if (!"personalize".equals(this.pageType) && !AdvertAppInfo.I.equals(this.mType)) {
                this.sid = jk7.e().d(this.sceneKey);
            }
            BdUniqueId bdUniqueId = this.mType;
            String str = "1";
            if (bdUniqueId == AdvertAppInfo.H) {
                if ("frs".equals(this.pageType)) {
                    if (!UbsABTestHelper.isFrsFunAdSdkTest()) {
                        str = "0";
                    }
                    dk7.m().K(this.mActivity, this.sid, dk7.b(this.pageType, str), String.valueOf(j), kp5.f());
                } else if ("personalize".equals(this.pageType)) {
                    if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                        str = "0";
                    }
                    dk7.m().J(this.mActivity, this.sid, dk7.b(this.pageType, str));
                }
            } else if (bdUniqueId == AdvertAppInfo.I) {
                dk7 m = dk7.m();
                BaseFragmentActivity baseFragmentActivity = this.mActivity;
                String str2 = this.sid;
                String str3 = this.pageType;
                if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
                    str = "0";
                }
                m.L(baseFragmentActivity, str2, dk7.b(str3, str), ql9Var2.g(), ql9Var2.d());
            }
            funAdNativeViewHolder.i(new a(this, ql9Var2, funAdNativeViewHolder));
            funAdNativeViewHolder.d().h();
            funAdNativeViewHolder.j(this.pageType);
            funAdNativeViewHolder.d().setCurpage(this.pageType);
            funAdNativeViewHolder.l(this.sid);
            this.sidSet.add(this.sid);
            int i2 = -1;
            if (hnVar instanceof jw4) {
                i2 = ((jw4) hnVar).position + 1;
            }
            funAdNativeViewHolder.m(ql9Var2, i2);
            return funAdNativeViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}

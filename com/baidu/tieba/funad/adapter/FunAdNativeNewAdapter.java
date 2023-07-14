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
import com.baidu.tieba.ay7;
import com.baidu.tieba.c76;
import com.baidu.tieba.funad.view.FunAbsAdView;
import com.baidu.tieba.funad.view.FunAdNativeCommentView;
import com.baidu.tieba.funad.view.FunAdNativeFrsView;
import com.baidu.tieba.funad.view.FunAdNativePbView;
import com.baidu.tieba.fx5;
import com.baidu.tieba.iy7;
import com.baidu.tieba.ky9;
import com.baidu.tieba.ln;
import com.baidu.tieba.py9;
import com.baidu.tieba.t15;
import com.baidu.tieba.ux7;
import com.baidu.tieba.wca;
import com.baidu.tieba.yca;
import com.baidu.tieba.yn;
import com.baidu.tieba.z45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class FunAdNativeNewAdapter extends ln<yn, FunAdNativeViewHolder> implements py9, ky9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isMulDelete;
    public final BaseFragmentActivity mActivity;
    public String mFromTab;
    public String pageType;
    public String sceneKey;
    public String sid;
    public Set<String> sidSet;

    @Override // com.baidu.tieba.ky9
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.tieba.py9
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wca a;
        public final /* synthetic */ FunAdNativeViewHolder b;
        public final /* synthetic */ FunAdNativeNewAdapter c;

        public a(FunAdNativeNewAdapter funAdNativeNewAdapter, wca wcaVar, FunAdNativeViewHolder funAdNativeViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdNativeNewAdapter, wcaVar, funAdNativeViewHolder};
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
            this.a = wcaVar;
            this.b = funAdNativeViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, "delFunAd"));
                this.c.notifyDataSetChanged();
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.b.f()).param("resource_id", this.c.getStatisticResourceId()).param("obj_locate", 0);
                if ("a006".equals(this.b.f())) {
                    param.param(TiebaStatic.Params.OBJ_TO, this.b.d());
                    param.param(TiebaStatic.Params.OBJ_PARAM2, this.b.c());
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

    private void showVipAdGuideTip(wca wcaVar, FunAdNativeViewHolder funAdNativeViewHolder, String str) {
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, wcaVar, funAdNativeViewHolder, str) == null) {
            if ("pb_banner".equals(this.sceneKey)) {
                a2 = wcaVar.a();
            } else {
                a2 = wcaVar.a();
                if (c76.k().m()) {
                    a2++;
                }
            }
            iy7.e(wcaVar, funAdNativeViewHolder, str, this.pageType, this.mFromTab, a2);
        }
    }

    public String getStatisticResourceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if ("pb".equals(this.pageType)) {
                if (this.mType == AdvertAppInfo.J) {
                    return "2";
                }
                return "1";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ky9
    public void onPause() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (v = this.viewholder) != 0 && ((FunAdNativeViewHolder) v).e() != null) {
            ((FunAdNativeViewHolder) this.viewholder).e().b();
        }
    }

    @Override // com.baidu.tieba.ln
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
    @Override // com.baidu.tieba.ln
    public FunAdNativeViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        FunAbsAdView funAdNativePbView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            BdUniqueId bdUniqueId = this.mType;
            if (bdUniqueId == AdvertAppInfo.J) {
                funAdNativePbView = new FunAdNativeCommentView(this.mActivity);
            } else if (bdUniqueId == AdvertAppInfo.I) {
                funAdNativePbView = new FunAdNativeFrsView(this.mActivity);
            } else {
                funAdNativePbView = new FunAdNativePbView(this.mActivity);
            }
            FunAdNativeViewHolder funAdNativeViewHolder = new FunAdNativeViewHolder(funAdNativePbView, this.mActivity, this.mType);
            funAdNativeViewHolder.m(this.sid);
            funAdNativeViewHolder.l(this.sceneKey);
            return funAdNativeViewHolder;
        }
        return (FunAdNativeViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ky9
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            V v = this.viewholder;
            if (v != 0 && ((FunAdNativeViewHolder) v).e() != null) {
                ((FunAdNativeViewHolder) this.viewholder).e().b();
            }
            for (String str : this.sidSet) {
                ux7.m().c(str);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, yn ynVar, FunAdNativeViewHolder funAdNativeViewHolder) {
        InterceptResult invokeCommon;
        wca wcaVar;
        long j;
        wca wcaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ynVar, funAdNativeViewHolder})) == null) {
            if (ynVar instanceof z45) {
                ThreadData threadData = ((z45) ynVar).t;
                wcaVar2 = threadData.funAdData;
                j = threadData.getFid();
            } else if (ynVar instanceof ThreadData) {
                ThreadData threadData2 = (ThreadData) ynVar;
                wcaVar2 = threadData2.funAdData;
                j = threadData2.getFid();
            } else {
                if (ynVar instanceof yca) {
                    wcaVar = ((yca) ynVar).x0;
                } else {
                    wcaVar = null;
                }
                j = 0;
                wcaVar2 = wcaVar;
            }
            if (wcaVar2 == null) {
                funAdNativeViewHolder.e().d(8);
                return funAdNativeViewHolder.getView();
            }
            showVipAdGuideTip(wcaVar2, funAdNativeViewHolder, String.valueOf(j));
            funAdNativeViewHolder.e().setFunAdMaskViewVisible(this.isMulDelete);
            if (!"personalize".equals(this.pageType) && !AdvertAppInfo.J.equals(this.mType)) {
                this.sid = ay7.e().d(this.sceneKey);
            }
            BdUniqueId bdUniqueId = this.mType;
            String str = "1";
            if (bdUniqueId == AdvertAppInfo.I) {
                if ("frs".equals(this.pageType)) {
                    if (!UbsABTestHelper.isFrsFunAdSdkTest()) {
                        str = "0";
                    }
                    ux7.m().J(this.mActivity, this.sid, ux7.b(this.pageType, str), String.valueOf(j), fx5.f());
                } else if ("personalize".equals(this.pageType)) {
                    if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                        str = "0";
                    }
                    ux7.m().I(this.mActivity, this.sid, ux7.b(this.pageType, str));
                }
            } else if (bdUniqueId == AdvertAppInfo.J) {
                ux7 m = ux7.m();
                BaseFragmentActivity baseFragmentActivity = this.mActivity;
                String str2 = this.sid;
                String str3 = this.pageType;
                if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
                    str = "0";
                }
                m.K(baseFragmentActivity, str2, ux7.b(str3, str), wcaVar2.g(), wcaVar2.d());
            }
            funAdNativeViewHolder.j(new a(this, wcaVar2, funAdNativeViewHolder));
            funAdNativeViewHolder.e().h();
            funAdNativeViewHolder.k(this.pageType);
            funAdNativeViewHolder.e().setCurpage(this.pageType);
            funAdNativeViewHolder.m(this.sid);
            this.sidSet.add(this.sid);
            int i2 = -1;
            if (ynVar instanceof t15) {
                i2 = ((t15) ynVar).position + 1;
            }
            funAdNativeViewHolder.n(wcaVar2, i2);
            return funAdNativeViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}

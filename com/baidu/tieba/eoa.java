package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.Arrays;
import java.util.Set;
/* loaded from: classes4.dex */
public class eoa extends dna<vna> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eoa(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.REWARD), pid);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            vna vnaVar = (vna) obj;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements TTAdNative.RewardVideoAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ eoa c;

        public a(eoa eoaVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eoaVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = eoaVar;
            this.b = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                LogPrinter.e("CSJRewardVideoAd onError code: " + i + ", message: " + str, new Object[0]);
                if (this.a) {
                    return;
                }
                this.c.onError(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, tTRewardVideoAd) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            Set<String> set;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTRewardVideoAd) == null) {
                this.a = true;
                LogPrinter.d();
                vna vnaVar = new vna(tTRewardVideoAd);
                String a = vnaVar.a();
                synchronized (pma.class) {
                    set = pma.b;
                    if (set.isEmpty()) {
                        String string = zna.a.getString("req_id", "");
                        if (string.isEmpty()) {
                            z = true;
                        } else {
                            set.addAll(Arrays.asList(string.split(ParamableElem.DIVIDE_PARAM)));
                        }
                    }
                    z = !set.contains(a);
                }
                if (!z) {
                    this.c.onError("repeat");
                    this.c.getClass();
                    return;
                }
                String a2 = vnaVar.a();
                synchronized (pma.class) {
                    if (set.add(a2)) {
                        StringBuilder sb = new StringBuilder();
                        for (String str : set) {
                            sb.append(str);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        sb.deleteCharAt(sb.length() - 1);
                        zna.a.edit().putString("req_id", sb.toString()).apply();
                    }
                }
                eoa eoaVar = this.c;
                String str2 = this.b;
                eoaVar.getClass();
                ((TTRewardVideoAd) vnaVar.a).setRewardPlayAgainInteractionListener(new lma(eoaVar, vnaVar, str2));
                eoa eoaVar2 = this.c;
                String str3 = this.b;
                eoaVar2.getClass();
                ((TTRewardVideoAd) vnaVar.a).setRewardAdInteractionListener(new nma(eoaVar2, vnaVar, str3));
                this.c.onAdLoaded((eoa) vnaVar);
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            if (this.e == null) {
                this.e = TTAdSdk.getAdManager().createAdNative(context.getApplicationContext());
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            String tid = getTid(valueOf);
            String buildExtra = buildExtra(context, tid, valueOf);
            int i = 1;
            AdSlot.Builder userID = new AdSlot.Builder().setCodeId(this.mPid.pid).setSupportDeepLink(true).setUserID(FunAdSdk.getFunAdConfig().userId);
            if (this.mPid.isHorizontal) {
                i = 2;
            }
            AdSlot build = userID.setOrientation(i).setMediaExtra(buildExtra).build();
            onLoadStart(funAdSlot);
            this.e.loadRewardVideoAd(build, new a(this, tid));
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewGroup, str, obj)) == null) {
            vna vnaVar = (vna) obj;
            onShowStart(vnaVar);
            ((TTRewardVideoAd) vnaVar.a).setDownloadListener(new vma(null));
            ((TTRewardVideoAd) vnaVar.a).showRewardVideoAd(activity);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}

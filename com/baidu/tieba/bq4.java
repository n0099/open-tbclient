package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bq4 {
    public static /* synthetic */ Interceptable $ic;
    public static View.OnClickListener a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && view2.getTag() != null && (view2.getTag() instanceof zp4)) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(view2.getContext(), (int) R.string.no_network_guide);
                    return;
                }
                zp4 zp4Var = (zp4) view2.getTag();
                AlaUserInfoData alaUserInfoData = zp4Var.a;
                if (alaUserInfoData == null) {
                    return;
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                long j = alaUserInfoData.anchor_live;
                if (j != 0) {
                    alaLiveInfoCoreData.liveID = j;
                } else {
                    long j2 = alaUserInfoData.enter_live;
                    if (j2 != 0) {
                        alaLiveInfoCoreData.liveID = j2;
                    } else {
                        long j3 = alaUserInfoData.live_id;
                        if (j3 != 0) {
                            alaLiveInfoCoreData.liveID = j3;
                        } else {
                            return;
                        }
                    }
                }
                int i = zp4Var.b;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (i != 1) {
                    if (i != 2 && i != 3 && i != 4) {
                        if (i != 5) {
                            if (i == 7) {
                                if (alaUserInfoData.ala_id != 0) {
                                    TiebaStatic.log(new StatisticItem("c11855").param("uid", currentAccount).param("click_uid", alaUserInfoData.ala_id).param(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS, alaUserInfoData.live_status));
                                }
                                TiebaStatic.log(new StatisticItem("c12542"));
                                if (zp4Var.c && !StringUtils.isNull(alaUserInfoData.sex)) {
                                    BdToast.makeText(view2.getContext(), String.format(view2.getContext().getString(R.string.person_privacy_toast), alaUserInfoData.sex)).setIcon(BdToast.ToastIcon.FAILURE).show();
                                    return;
                                }
                            }
                        } else {
                            TiebaStatic.log(new StatisticItem("c11852").param("uid", currentAccount));
                        }
                    } else {
                        TiebaStatic.log(new StatisticItem("c11851").param("uid", currentAccount));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c11850").param("uid", currentAccount));
                }
                int i2 = zp4Var.b;
                if (i2 == 5) {
                    str = AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION;
                } else if (i2 == 7) {
                    str = AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY;
                } else {
                    str = AlaLiveRoomActivityConfig.FROM_TYPE_TAIL_LIGHT;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2911003, new AlaLiveRoomActivityConfig(view2.getContext(), alaLiveInfoCoreData, str, null, false, "")));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947653604, "Lcom/baidu/tieba/bq4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947653604, "Lcom/baidu/tieba/bq4;");
                return;
            }
        }
        a = new a();
    }

    public static TextView a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null || MessageManager.getInstance().findTask(2911003) == null) {
                return null;
            }
            TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.ala_tail_view_layout, (ViewGroup) null);
            textView.setOnClickListener(a);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }
}

package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.liveremind.LiveRemindConfig;
import com.baidu.tbadk.data.LiveRemindRecommendData;
import com.baidu.tieba.ba5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class g25 extends b25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g25() {
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

    public static final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            r15.s("homeLiveRemind");
        }
    }

    @Override // com.baidu.tieba.b25
    public void a(Context context, t15 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null && (currentActivity instanceof TbPageContextSupport)) {
                int i = 0;
                LiveRemindRecommendData c = s45.a().c(0);
                HashMap hashMap = new HashMap();
                if (c.getRemindType() == 1) {
                    i = 3;
                } else if (c.getRemindType() == 2) {
                    i = 4;
                } else if (c.getRemindType() == 3) {
                    i = 2;
                }
                String liveIconSrc = c.getLiveIconSrc();
                Intrinsics.checkNotNullExpressionValue(liveIconSrc, "liveRecData.liveIconSrc");
                hashMap.put("view_top_params_key_image_url", liveIconSrc);
                String liveIconScheme = c.getLiveIconScheme();
                Intrinsics.checkNotNullExpressionValue(liveIconScheme, "liveRecData.liveIconScheme");
                hashMap.put("view_top_params_key_schema", liveIconScheme);
                String userName = c.getUserName();
                Intrinsics.checkNotNullExpressionValue(userName, "liveRecData.userName");
                hashMap.put("view_top_params_user_name", userName);
                String desc = c.getDesc();
                Intrinsics.checkNotNullExpressionValue(desc, "liveRecData.desc");
                hashMap.put("view_top_params_key_desc", desc);
                Long roomId = c.getRoomId();
                Intrinsics.checkNotNullExpressionValue(roomId, "liveRecData.roomId");
                hashMap.put("view_top_params_room_id", roomId);
                String btnText = c.getBtnText();
                Intrinsics.checkNotNullExpressionValue(btnText, "liveRecData.btnText");
                hashMap.put("view_top_params_btn_text", btnText);
                String title = c.getTitle();
                Intrinsics.checkNotNullExpressionValue(title, "liveRecData.title");
                hashMap.put("view_top_params_key_title", title);
                String feedId = c.getFeedId();
                Intrinsics.checkNotNullExpressionValue(feedId, "liveRecData.feedId");
                hashMap.put("view_top_params_key_nid", feedId);
                YyExtData yyExtData = c.getYyExtData();
                Intrinsics.checkNotNullExpressionValue(yyExtData, "liveRecData.yyExtData");
                hashMap.put("view_top_params_key_yyext", yyExtData);
                hashMap.put("view_top_params_key_type", Integer.valueOf(i));
                hashMap.put("view_top_params_is_breathe", Boolean.FALSE);
                ca5.d(null, ((TbPageContextSupport) currentActivity).getPageContext(), hashMap, 0L, 4000L, new ba5.h() { // from class: com.baidu.tieba.y15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.ba5.h
                    public final void dismiss() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            g25.b();
                        }
                    }
                });
                t45.b().f(LiveRemindConfig.Scene.LIVE_FLOAT);
                r15.m("homeLiveRemind");
                return;
            }
            r15.s("homeLiveRemind");
        }
    }
}

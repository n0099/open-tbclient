package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.liveremind.LiveRemindConfig;
import com.baidu.tbadk.data.LiveRemindRecommendData;
import com.baidu.tieba.f85;
import com.baidu.tieba.p05;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class eh9 extends p05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity c;
    public LiveRemindRecommendData d;
    public Map<String, Object> e;
    public f85 f;

    /* loaded from: classes4.dex */
    public class a implements f85.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eh9 a;

        public a(eh9 eh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eh9Var;
        }

        @Override // com.baidu.tieba.f85.h
        public void dismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eh9(MainTabActivity mainTabActivity, se9 se9Var) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, se9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = mainTabActivity;
    }

    @Override // com.baidu.tieba.p05
    public void b() {
        f85 f85Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (f85Var = this.f) != null) {
            f85Var.t();
        }
    }

    @Override // com.baidu.tieba.p05
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f = g85.d(null, this.c.getPageContext(), this.e, 0L, 4000L, new a(this));
            a35.b().f(LiveRemindConfig.Scene.LIVE_FLOAT);
        }
    }

    @Override // com.baidu.tieba.p05
    public void d(p05.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (w05.i()) {
                aVar.a(false);
                return;
            }
            LiveRemindRecommendData c = z25.a().c(0);
            this.d = c;
            if (c != null && a35.b().j(LiveRemindConfig.Scene.LIVE_FLOAT)) {
                this.e = new HashMap();
                int i = 3;
                if (this.d.getRemindType() != 1) {
                    if (this.d.getRemindType() == 2) {
                        i = 4;
                    } else if (this.d.getRemindType() == 3) {
                        i = 2;
                    } else {
                        i = 0;
                    }
                }
                this.e.put("view_top_params_key_image_url", this.d.getLiveIconSrc());
                this.e.put("view_top_params_key_schema", this.d.getLiveIconScheme());
                this.e.put("view_top_params_user_name", this.d.getUserName());
                this.e.put("view_top_params_key_desc", this.d.getDesc());
                this.e.put("view_top_params_room_id", this.d.getRoomId());
                this.e.put("view_top_params_btn_text", this.d.getBtnText());
                this.e.put("view_top_params_key_title", this.d.getTitle());
                this.e.put("view_top_params_key_nid", this.d.getFeedId());
                this.e.put("view_top_params_key_yyext", this.d.getYyExtData());
                this.e.put("view_top_params_key_type", Integer.valueOf(i));
                this.e.put("view_top_params_is_breathe", Boolean.FALSE);
                if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !h95.e()) {
                    if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !h95.e()) {
                        aVar.a(true);
                        return;
                    } else {
                        aVar.a(false);
                        return;
                    }
                }
                aVar.a(false);
                return;
            }
            aVar.a(false);
        }
    }
}

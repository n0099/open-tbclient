package com.baidu.tieba.aiapps.apps.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.zm5;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AiAppsShareActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener listener;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AiAppsShareActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AiAppsShareActivity aiAppsShareActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aiAppsShareActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aiAppsShareActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921366, Boolean.FALSE));
                this.a.finish();
            }
        }
    }

    public AiAppsShareActivity() {
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
        this.listener = new a(this, 2921376);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921366, Boolean.valueOf(i2 == -1)));
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            String stringExtra = intent.getStringExtra("options");
            if (StringUtils.isNULL(stringExtra)) {
                finish();
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            zm5 zm5Var = new zm5();
            try {
                zm5Var.p(new JSONObject(stringExtra));
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig(this, zm5Var, false)));
                MessageManager.getInstance().registerListener(this.listener);
                LogUtil.logActivity(this, "onCreate");
            } catch (JSONException unused) {
                finish();
                LogUtil.logActivity(this, "onCreate");
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.listener);
        }
    }
}

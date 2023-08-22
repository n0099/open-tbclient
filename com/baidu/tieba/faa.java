package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class faa extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final caa a;
    @NonNull
    public final daa b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public faa(@NonNull caa caaVar, @NonNull daa daaVar) {
        super(2016311);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {caaVar, daaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = caaVar;
        this.b = daaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str2 = (String) data;
                kia.a("SplashClickListener link:" + str2);
                if (!TextUtils.isEmpty(str2) && !TextUtils.equals("advertevent", Uri.parse(str2).getScheme())) {
                    Intent intent = new Intent();
                    int indexOf = str2.indexOf("&extInfo=");
                    if (indexOf > 0) {
                        str = str2.substring(0, indexOf);
                    } else {
                        str = str2;
                    }
                    String substring = str2.substring(str.length() + 9, str2.length());
                    if (str.startsWith("https://") || str.startsWith("http://")) {
                        intent.putExtra("gd_ad", true);
                        intent.putExtra(MigrateStatisticUtils.EXT_INFO, substring);
                    }
                    if (!this.a.h() && ((StringUtils.isNull(str) || !str.startsWith("bdtiebalive")) && this.a.g() != 2)) {
                        intent.putExtra("class", 30);
                        intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                        intent.putExtra("is_ad", true);
                        TbadkCoreApplication.setIntent(intent);
                    } else {
                        intent.putExtra("class", 30);
                        intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                        intent.putExtra("is_ad", true);
                        UtilHelper.commenDealIntent(this.a.getActivity(), intent);
                    }
                }
                this.a.e();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getActivity().getClass().getSimpleName()).param("obj_param1", 5).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(this.a.d())));
                if (!this.a.d() && !DeviceInfoUtil.isHuaWeiP40Pro()) {
                    SpeedStatsManager.getInstance().setStatsFlag(-1);
                    if (!this.a.h()) {
                        TiebaStatic.log(new StatisticItem("ignore_speed").param("obj_source", "click"));
                        return;
                    }
                    return;
                }
                this.b.a();
            }
        }
    }
}

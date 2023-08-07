package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.view.FriendBotView;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.RobotEntrance;
import tbclient.RobotSkillInfo;
/* loaded from: classes6.dex */
public final class hc9 extends r55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements yc9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        public a(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = str;
        }

        @Override // com.baidu.tieba.yc9
        public void onDismiss() {
            bi9 M5;
            FriendBotView V0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PbFragment X1 = ((PbActivity) this.a).X1();
                if (X1 != null && (M5 = X1.M5()) != null && (V0 = M5.V0()) != null) {
                    V0.x();
                }
                YunDialogManager.unMarkShowingDialogName("pbFriendBotBottomNewSkill");
            }
        }

        @Override // com.baidu.tieba.yc9
        public void onShow() {
            bi9 M5;
            FriendBotView V0;
            bi9 M52;
            FriendBotView V02;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                PbFragment X1 = ((PbActivity) this.a).X1();
                if (X1 != null && (M52 = X1.M5()) != null && (V02 = M52.V0()) != null) {
                    V02.setDynamicLooping(true);
                }
                PbFragment X12 = ((PbActivity) this.a).X1();
                if (X12 != null && (M5 = X12.M5()) != null && (V0 = M5.V0()) != null) {
                    V0.r();
                }
                SharedPrefHelper.getInstance().putString("pb_friend_bot_bottom_new_skill_text", this.b);
                SharedPrefHelper.getInstance().putLong("pb_friend_bot_bottom_click_last_time", System.currentTimeMillis());
            }
        }
    }

    public hc9() {
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

    @Override // com.baidu.tieba.r55
    public void a(Context context, j55 data) {
        List<RobotSkillInfo> list;
        boolean z;
        bi9 M5;
        sd9 r1;
        RobotEntrance K;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if (!(context instanceof PbActivity)) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "pb好朋友bot底部新人设上线引导失败：当前Activity非PbActivity");
                YunDialogManager.unMarkShowingDialogName("pbFriendBotBottomNewSkill");
                return;
            }
            BotEntranceManager c = BotEntranceManager.c.c();
            PbActivity pbActivity = (PbActivity) context;
            PbModel J1 = pbActivity.J1();
            FriendBotView friendBotView = null;
            if (J1 != null && (r1 = J1.r1()) != null && (K = r1.K()) != null) {
                list = K.robot_skill_info;
            } else {
                list = null;
            }
            String j = c.j(list);
            if (j.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                YunDialogManager.unMarkShowingDialogName("pbFriendBotBottomNewSkill");
                return;
            }
            PbFragment X1 = pbActivity.X1();
            if (X1 != null && (M5 = X1.M5()) != null) {
                friendBotView = M5.V0();
            }
            bd9.e(j, friendBotView, (BaseFragmentActivity) context, new a(context, j));
        }
    }
}

package com.baidu.tbadk.coreExtra.util;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.view.PushPermissionDialogViewV2;
import com.baidu.tieba.R;
import com.baidu.tieba.lg5;
import com.baidu.tieba.n3a;
import com.baidu.tieba.o3a;
import com.baidu.tieba.sz4;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.xd5;
import com.baidu.tieba.xe5;
import com.baidu.tieba.yd5;
import com.baidu.tieba.z45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class PushOpenUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PUSH_PERMISSION_DIALOG_AGREE_MESSAGE_BAR = 7;
    public static final int PUSH_PERMISSION_DIALOG_AT_MESSAGE_BAR = 6;
    public static final long PUSH_PERMISSION_DIALOG_DELAY_TIME = 2000;
    public static final int PUSH_PERMISSION_DIALOG_FAN_MESSAGE_BAR = 8;
    public static final int PUSH_PERMISSION_DIALOG_FOLLOW_FRIEND = 10;
    public static final int PUSH_PERMISSION_DIALOG_POST_SUCCESS = 9;
    public static final int PUSH_PERMISSION_DIALOG_SCENE_BAR_SIGN = 4;
    public static final int PUSH_PERMISSION_DIALOG_SCENE_COLD_START = 1;
    public static final int PUSH_PERMISSION_DIALOG_SCENE_FORUM_FOLLOW = 11;
    public static final int PUSH_PERMISSION_DIALOG_SCENE_INTERACTION = 0;
    public static final int PUSH_PERMISSION_DIALOG_SCENE_ONE_KEY_SIGN = 5;
    public static final int PUSH_PERMISSION_DIALOG_SCENE_PERSON_CHAT = 2;
    public static final int PUSH_PERMISSION_DIALOG_SCENE_REPLY_ME = 3;
    public static final String VIEW_PARAMS_KEY_DESC = "view_params_key_desc";
    public static final String VIEW_PARAMS_KEY_SOURCE = "view_params_key_source";
    public static final String VIEW_PARAMS_KEY_STYLE = "view_params_key_style";
    public static final String VIEW_PARAMS_KEY_TITLE = "view_params_key_title";
    public transient /* synthetic */ FieldHolder $fh;

    public static String getSourceFromType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 2 ? "im" : i == 3 ? "reply_message_bar" : i == 6 ? "at_message_bar" : i == 7 ? "agree_message_bar" : i == 8 ? "fan_message_bar" : i == 4 ? "forum_sign" : i == 5 ? "sign" : i == 10 ? "user_follow" : "default" : (String) invokeI.objValue;
    }

    public static int getSourceIdFromType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 2) {
                return 12;
            }
            if (i == 3) {
                return 11;
            }
            if (i == 4) {
                return 2;
            }
            if (i == 5) {
                return 5;
            }
            if (i == 6) {
                return 15;
            }
            if (i == 7) {
                return 14;
            }
            if (i == 8) {
                return 16;
            }
            return i == 10 ? 17 : 0;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lg5 a;

        public a(lg5 lg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lg5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.x();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ z45 c;

        public b(sz4 sz4Var, int i, z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz4Var, Integer.valueOf(i), z45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz4Var;
            this.b = i;
            this.c = z45Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                sz4 sz4Var = this.a;
                if (sz4Var != null) {
                    sz4Var.a();
                }
                PushOpenUtil.logClick(this.b, true);
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ z45 c;

        public c(sz4 sz4Var, int i, z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz4Var, Integer.valueOf(i), z45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz4Var;
            this.b = i;
            this.c = z45Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                sz4 sz4Var = this.a;
                if (sz4Var != null) {
                    sz4Var.onCancelClick();
                }
                PushOpenUtil.logClick(this.b, false);
                this.c.dismiss();
            }
        }
    }

    public PushOpenUtil() {
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

    public static void logClick(int i, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            int sourceIdFromType = getSourceIdFromType(i);
            StatisticItem statisticItem = new StatisticItem("c13673");
            if (z) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            TiebaStatic.log(statisticItem.param("obj_type", i2).param("obj_source", sourceIdFromType));
        }
    }

    public static void logShow(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, null, i) == null) {
            TiebaStatic.log(new StatisticItem("c13674").param("obj_source", getSourceIdFromType(i)));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Map<String, String> readConfig(String str) {
        InterceptResult invokeL;
        char c2;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            HashMap hashMap = new HashMap();
            String string2 = TbadkCoreApplication.getInst().getString(R.string.push_tip_default_title);
            switch (str.hashCode()) {
                case -1130769265:
                    if (str.equals("forum_follow")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -841017829:
                    if (str.equals("forum_sign")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -429621401:
                    if (str.equals("reply_pb")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -426397178:
                    if (str.equals("reply_message_bar")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3364:
                    if (str.equals("im")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2 && c2 != 3) {
                        if (c2 != 4) {
                            string = TbadkCoreApplication.getInst().getString(R.string.push_tip_default_desc);
                        } else {
                            string = TbadkCoreApplication.getInst().getString(R.string.push_tip_default_desc_msg);
                        }
                    } else {
                        string = TbadkCoreApplication.getInst().getString(R.string.push_tip_default_desc_reply);
                    }
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.push_tip_default_desc_bar_sign);
                }
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.push_tip_default_desc_bar_attention);
            }
            xd5 pushStrategyConfig = TbSingleton.getInstance().getPushStrategyConfig();
            if (pushStrategyConfig.d()) {
                yd5 c3 = pushStrategyConfig.c(str);
                if (c3 != null && !TextUtils.isEmpty(c3.c())) {
                    string2 = c3.c();
                }
                if (c3 != null && !TextUtils.isEmpty(c3.b())) {
                    string = c3.b();
                }
            } else {
                n3a g = o3a.e().g(str);
                if (g != null && !TextUtils.isEmpty(g.f())) {
                    string2 = g.f();
                }
                if (g != null && !TextUtils.isEmpty(g.d())) {
                    string = g.d();
                }
            }
            hashMap.put(VIEW_PARAMS_KEY_TITLE, string2);
            hashMap.put(VIEW_PARAMS_KEY_DESC, string);
            hashMap.put(VIEW_PARAMS_KEY_SOURCE, str);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b2, code lost:
        if (com.baidu.tbadk.core.util.TimeHelper.isSameDay(r12, r7) == false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0106 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean shouldShowPushOpenView(Context context, int i) {
        InterceptResult invokeLI;
        int i2;
        Date date;
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, context, i)) == null) {
            xd5 pushStrategyConfig = TbSingleton.getInstance().getPushStrategyConfig();
            if (pushStrategyConfig != null && pushStrategyConfig.d()) {
                i2 = pushStrategyConfig.b();
            } else {
                i2 = 0;
            }
            if (i2 <= 0) {
                i2 = 7;
            }
            Date date2 = new Date(SharedPrefHelper.getInstance().getLong("push_permission_dialog_scene_cold_start_key", 0L));
            Date date3 = new Date(SharedPrefHelper.getInstance().getLong("push_permission_dialog_scene_interaction_key", 0L));
            Date date4 = new Date(SharedPrefHelper.getInstance().getLong("push_permission_dialog_scene_push_sign_key", 0L));
            Date date5 = null;
            if (UbsABTestHelper.isPushPermissionForumFollowTestA() || UbsABTestHelper.isPushPermissionForumFollowTestB()) {
                date5 = new Date(SharedPrefHelper.getInstance().getLong("push_permission_dialog_scene_interaction_forum_follow_key", 0L));
            }
            long currentTimeMillis = System.currentTimeMillis();
            Date date6 = new Date(currentTimeMillis);
            if (i == 11 && date5 != null) {
                if (UbsABTestHelper.isPushPermissionForumFollowTestA() && TimeHelper.getDayDifference(date6, date5) >= i2 && !TimeHelper.isSameDay(date6, date2)) {
                    date = date2;
                } else if (UbsABTestHelper.isPushPermissionForumFollowTestB()) {
                    date = date2;
                    if (TimeHelper.getDayDifference(date6, date5) >= i2) {
                        if (!TimeHelper.isSameDay(date6, date)) {
                        }
                    }
                    z = false;
                    if (i == 0) {
                        z2 = z;
                        str = "push_permission_dialog_scene_cold_start_key";
                        if (TimeHelper.getDayDifference(date6, date3) >= i2 && !TimeHelper.isSameDay(date6, date)) {
                            if (UbsABTestHelper.isPushPermissionForumFollowTestB()) {
                                if (date5 != null && TimeHelper.isSameDay(date6, date5)) {
                                    z7 = false;
                                } else {
                                    z7 = true;
                                }
                                z3 = z7;
                            } else {
                                z3 = true;
                            }
                            if (i != 1) {
                                z4 = z3;
                                if (TimeHelper.getDayDifference(date6, date) >= i2 && !TimeHelper.isSameDay(date6, date3)) {
                                    z5 = true;
                                    if (i == 4 && i != 5) {
                                        z6 = z5;
                                    } else {
                                        z6 = z5;
                                        if (TimeHelper.getDayDifference(date6, date4) >= i2 && !TimeHelper.isSameDay(date6, date4)) {
                                            z6 = true;
                                        }
                                    }
                                    if (z6) {
                                        if (i != 0) {
                                            if (i != 1) {
                                                if (i != 4 && i != 5) {
                                                    if (i == 11) {
                                                        SharedPrefHelper.getInstance().putLong("push_permission_dialog_scene_interaction_forum_follow_key", currentTimeMillis);
                                                    }
                                                } else {
                                                    SharedPrefHelper.getInstance().putLong("push_permission_dialog_scene_push_sign_key", currentTimeMillis);
                                                }
                                            } else {
                                                SharedPrefHelper.getInstance().putLong(str, currentTimeMillis);
                                            }
                                        } else {
                                            SharedPrefHelper.getInstance().putLong("push_permission_dialog_scene_interaction_key", currentTimeMillis);
                                        }
                                    }
                                    return z6;
                                }
                            } else {
                                z4 = z3;
                            }
                            z5 = z4;
                            if (i == 4) {
                            }
                            z6 = z5;
                            if (TimeHelper.getDayDifference(date6, date4) >= i2) {
                                z6 = true;
                            }
                            if (z6) {
                            }
                            return z6;
                        }
                    } else {
                        z2 = z;
                        str = "push_permission_dialog_scene_cold_start_key";
                    }
                    z3 = z2;
                    if (i != 1) {
                    }
                    z5 = z4;
                    if (i == 4) {
                    }
                    z6 = z5;
                    if (TimeHelper.getDayDifference(date6, date4) >= i2) {
                    }
                    if (z6) {
                    }
                    return z6;
                }
                z = true;
                if (i == 0) {
                }
                z3 = z2;
                if (i != 1) {
                }
                z5 = z4;
                if (i == 4) {
                }
                z6 = z5;
                if (TimeHelper.getDayDifference(date6, date4) >= i2) {
                }
                if (z6) {
                }
                return z6;
            }
            date = date2;
            z = false;
            if (i == 0) {
            }
            z3 = z2;
            if (i != 1) {
            }
            z5 = z4;
            if (i == 4) {
            }
            z6 = z5;
            if (TimeHelper.getDayDifference(date6, date4) >= i2) {
            }
            if (z6) {
            }
            return z6;
        }
        return invokeLI.booleanValue;
    }

    public static lg5 showPushOpenFloatView(TbPageContext<?> tbPageContext, Map<String, String> map, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{tbPageContext, map, Long.valueOf(j)})) == null) {
            if (tbPageContext != null && map != null) {
                lg5 lg5Var = new lg5(tbPageContext, map);
                if (j <= 0) {
                    lg5Var.x();
                } else {
                    SafeHandler.getInst().postDelayed(new a(lg5Var), j);
                }
                return lg5Var;
            }
            return null;
        }
        return (lg5) invokeCommon.objValue;
    }

    public static lg5 showPushOpenView(TbPageContext<?> tbPageContext, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{tbPageContext, str, Long.valueOf(j)})) == null) {
            return showPushOpenView(tbPageContext, str, j, null);
        }
        return (lg5) invokeCommon.objValue;
    }

    public static void showPushPermissionDialogV2(TbPageContext<?> tbPageContext, int i, sz4 sz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65547, null, tbPageContext, i, sz4Var) == null) {
            showPushPermissionDialogV2(tbPageContext, tbPageContext.getPageActivity(), i, sz4Var);
        }
    }

    public static lg5 showPushOpenView(TbPageContext<?> tbPageContext, String str, long j, Map<String, String> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{tbPageContext, str, Long.valueOf(j), map})) == null) {
            if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
                return null;
            }
            Map<String, String> readConfig = readConfig(str);
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    readConfig.put(entry.getKey(), entry.getValue());
                }
            }
            boolean areNotificationsEnabled = NotificationManagerCompat.from(tbPageContext.getPageActivity()).areNotificationsEnabled();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1130769265:
                    if (str.equals("forum_follow")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -841017829:
                    if (str.equals("forum_sign")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -485371922:
                    if (str.equals(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -429621401:
                    if (str.equals("reply_pb")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -426397178:
                    if (str.equals("reply_message_bar")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3530173:
                    if (str.equals("sign")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 949444906:
                    if (str.equals("collect")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    boolean A = xe5.d().A();
                    if (areNotificationsEnabled && A) {
                        return null;
                    }
                    return showPushOpenFloatView(tbPageContext, readConfig, j);
                case 1:
                case 2:
                case 3:
                    return null;
                case 4:
                case 5:
                    return showPushOpenFloatView(tbPageContext, readConfig, j);
                case 6:
                    if (areNotificationsEnabled) {
                        return null;
                    }
                    return showPushOpenFloatView(tbPageContext, readConfig, j);
                default:
                    throw new IllegalStateException("Unexpected value: " + str);
            }
        }
        return (lg5) invokeCommon.objValue;
    }

    public static void showPushPermissionDialogV2(TbPageContext<?> tbPageContext, Activity activity, int i, sz4 sz4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLIL(65548, null, tbPageContext, activity, i, sz4Var) == null) && activity != null && tbPageContext != null) {
            z45 z45Var = new z45(activity);
            z45Var.setCancelable(false);
            z45Var.setPositiveButton((String) null, (z45.e) null);
            z45Var.setNegativeButton((String) null, (z45.e) null);
            z45Var.setContentViewSize(7);
            PushPermissionDialogViewV2 pushPermissionDialogViewV2 = new PushPermissionDialogViewV2(activity);
            Map<String, String> readConfig = readConfig(getSourceFromType(i));
            pushPermissionDialogViewV2.setTitle(readConfig.get(VIEW_PARAMS_KEY_TITLE));
            pushPermissionDialogViewV2.setDescription(readConfig.get(VIEW_PARAMS_KEY_DESC));
            z45Var.setContentView(pushPermissionDialogViewV2);
            if (pushPermissionDialogViewV2.getConfirmButton() != null) {
                pushPermissionDialogViewV2.getConfirmButton().setOnClickListener(new b(sz4Var, i, z45Var));
            }
            if (pushPermissionDialogViewV2.getCancelButton() != null) {
                pushPermissionDialogViewV2.getCancelButton().setOnClickListener(new c(sz4Var, i, z45Var));
            }
            z45Var.create(tbPageContext).show();
            logShow(i);
        }
    }

    public static void showPushPermissionSucToast(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65549, null, activity) != null) || activity == null) {
            return;
        }
        View findViewById = activity.findViewById(16908290);
        if (!(findViewById instanceof ViewGroup)) {
            return;
        }
        new BdTopToast(activity, 3000).setIcon(true).setContent(TbadkCoreApplication.getInst().getString(R.string.push_permission_dialog_open_success_toast)).show((ViewGroup) findViewById);
    }
}

package com.baidu.tbadk.coreExtra.util;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.view.PushPermissionDialogViewV2;
import com.baidu.tieba.R;
import com.baidu.tieba.f05;
import com.baidu.tieba.fga;
import com.baidu.tieba.push.PushGuideManager;
import com.baidu.tieba.push.PushSceneItem;
import com.baidu.tieba.vb5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.wu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
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

    public static void showPushPermissionDialogV2(TbPageContext<?> tbPageContext, Activity activity, int i, wu4 wu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65548, null, tbPageContext, activity, i, wu4Var) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vb5 a;

        public a(vb5 vb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vb5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wu4 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ f05 c;

        public b(wu4 wu4Var, String str, f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu4Var, str, f05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wu4Var;
            this.b = str;
            this.c = f05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                wu4 wu4Var = this.a;
                if (wu4Var != null) {
                    wu4Var.a();
                }
                PushOpenUtil.logClick(this.b, true);
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wu4 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ f05 c;

        public c(wu4 wu4Var, String str, f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu4Var, str, f05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wu4Var;
            this.b = str;
            this.c = f05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                wu4 wu4Var = this.a;
                if (wu4Var != null) {
                    wu4Var.onCancelClick();
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

    public static void logClick(@NonNull String str, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, z) == null) {
            int a2 = fga.a(str);
            StatisticItem statisticItem = new StatisticItem("c13673");
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            TiebaStatic.log(statisticItem.param("obj_type", i).param("obj_source", a2));
        }
    }

    public static void logShow(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            TiebaStatic.log(new StatisticItem("c13674").param("obj_source", fga.a(str)));
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
            PushSceneItem l = PushGuideManager.l(str);
            if (l != null && !TextUtils.isEmpty(l.getTitle())) {
                string2 = l.getTitle();
            }
            if (l != null && !TextUtils.isEmpty(l.getText())) {
                string = l.getText();
            }
            hashMap.put(VIEW_PARAMS_KEY_TITLE, string2);
            hashMap.put(VIEW_PARAMS_KEY_DESC, string);
            hashMap.put(VIEW_PARAMS_KEY_SOURCE, str);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0079, code lost:
        if (com.baidu.tbadk.core.util.TimeHelper.isSameDay(r4, r1) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007b, code lost:
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0098, code lost:
        if (com.baidu.tbadk.core.util.TimeHelper.isSameDay(r4, r5) == false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean shouldShowPushOpenView(Context context, int i) {
        InterceptResult invokeLI;
        Date date;
        String str;
        boolean z;
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        String str2;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, context, i)) == null) {
            Date date2 = new Date(SharedPrefHelper.getInstance().getLong("push_permission_dialog_scene_cold_start_key", 0L));
            Date date3 = new Date(SharedPrefHelper.getInstance().getLong("push_permission_dialog_scene_interaction_key", 0L));
            Date date4 = new Date(SharedPrefHelper.getInstance().getLong("push_permission_dialog_scene_push_sign_key", 0L));
            if (!UbsABTestHelper.isPushPermissionForumFollowTestA() && !UbsABTestHelper.isPushPermissionForumFollowTestB()) {
                date = null;
            } else {
                date = new Date(SharedPrefHelper.getInstance().getLong("push_permission_dialog_scene_interaction_forum_follow_key", 0L));
            }
            long currentTimeMillis = System.currentTimeMillis();
            Date date5 = new Date(currentTimeMillis);
            if (i != 11 || date == null) {
                str = "push_permission_dialog_scene_interaction_forum_follow_key";
            } else {
                if (UbsABTestHelper.isPushPermissionForumFollowTestA()) {
                    str = "push_permission_dialog_scene_interaction_forum_follow_key";
                    if (TimeHelper.getDayDifference(date5, date) >= 7) {
                    }
                } else {
                    str = "push_permission_dialog_scene_interaction_forum_follow_key";
                }
                if (UbsABTestHelper.isPushPermissionForumFollowTestB()) {
                    if (TimeHelper.getDayDifference(date5, date) >= 7) {
                        if (!TimeHelper.isSameDay(date5, date2)) {
                        }
                    }
                }
            }
            boolean z6 = false;
            if (i == 0) {
                z = z6;
                if (TimeHelper.getDayDifference(date5, date3) >= 7 && !TimeHelper.isSameDay(date5, date2)) {
                    if (UbsABTestHelper.isPushPermissionForumFollowTestB()) {
                        if (date != null && TimeHelper.isSameDay(date5, date)) {
                            z5 = false;
                        } else {
                            z5 = true;
                        }
                        z2 = z5;
                        i2 = 1;
                        if (i == i2) {
                            long dayDifference = TimeHelper.getDayDifference(date5, date2);
                            z3 = z2;
                            if (dayDifference >= 7 && !TimeHelper.isSameDay(date5, date3)) {
                                z4 = true;
                                if (i != 4 || i == 5) {
                                    str2 = "push_permission_dialog_scene_cold_start_key";
                                    if (TimeHelper.getDayDifference(date5, date4) >= 7 && !TimeHelper.isSameDay(date5, date4)) {
                                        z4 = true;
                                    }
                                } else {
                                    str2 = "push_permission_dialog_scene_cold_start_key";
                                }
                                if (z4) {
                                    if (i != 0) {
                                        if (i != 1) {
                                            if (i != 4 && i != 5) {
                                                if (i == 11) {
                                                    SharedPrefHelper.getInstance().putLong(str, currentTimeMillis);
                                                }
                                            } else {
                                                SharedPrefHelper.getInstance().putLong("push_permission_dialog_scene_push_sign_key", currentTimeMillis);
                                            }
                                        } else {
                                            SharedPrefHelper.getInstance().putLong(str2, currentTimeMillis);
                                        }
                                    } else {
                                        SharedPrefHelper.getInstance().putLong("push_permission_dialog_scene_interaction_key", currentTimeMillis);
                                    }
                                }
                                return z4;
                            }
                        } else {
                            z3 = z2;
                        }
                        z4 = z3;
                        if (i != 4) {
                        }
                        str2 = "push_permission_dialog_scene_cold_start_key";
                        if (TimeHelper.getDayDifference(date5, date4) >= 7) {
                            z4 = true;
                        }
                        if (z4) {
                        }
                        return z4;
                    }
                    i2 = 1;
                    z2 = true;
                    if (i == i2) {
                    }
                    z4 = z3;
                    if (i != 4) {
                    }
                    str2 = "push_permission_dialog_scene_cold_start_key";
                    if (TimeHelper.getDayDifference(date5, date4) >= 7) {
                    }
                    if (z4) {
                    }
                    return z4;
                }
            } else {
                z = z6;
            }
            z2 = z;
            i2 = 1;
            if (i == i2) {
            }
            z4 = z3;
            if (i != 4) {
            }
            str2 = "push_permission_dialog_scene_cold_start_key";
            if (TimeHelper.getDayDifference(date5, date4) >= 7) {
            }
            if (z4) {
            }
            return z4;
        }
        return invokeLI.booleanValue;
    }

    public static vb5 showPushOpenFloatView(TbPageContext<?> tbPageContext, Map<String, String> map, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{tbPageContext, map, Long.valueOf(j)})) == null) {
            if (tbPageContext != null && map != null) {
                vb5 vb5Var = new vb5(tbPageContext, map);
                if (j <= 0) {
                    vb5Var.w();
                } else {
                    SafeHandler.getInst().postDelayed(new a(vb5Var), j);
                }
                return vb5Var;
            }
            return null;
        }
        return (vb5) invokeCommon.objValue;
    }

    public static vb5 showPushOpenView(TbPageContext<?> tbPageContext, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{tbPageContext, str, Long.valueOf(j)})) == null) {
            return showPushOpenView(tbPageContext, str, j, null);
        }
        return (vb5) invokeCommon.objValue;
    }

    public static void showPushPermissionDialogV2(TbPageContext<?> tbPageContext, int i, wu4 wu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65547, null, tbPageContext, i, wu4Var) == null) {
            showPushPermissionDialogV2(tbPageContext, tbPageContext.getPageActivity(), i, wu4Var);
        }
    }

    public static vb5 showPushOpenView(TbPageContext<?> tbPageContext, String str, long j, Map<String, String> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{tbPageContext, str, Long.valueOf(j), map})) == null) {
            if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                Map<String, String> readConfig = readConfig(str);
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        readConfig.put(entry.getKey(), entry.getValue());
                    }
                }
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1130769265:
                        if (str.equals("forum_follow")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -841017829:
                        if (str.equals("forum_sign")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -429621401:
                        if (str.equals("reply_pb")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 949444906:
                        if (str.equals("collect")) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                if (c2 != 0 && c2 != 1 && c2 != 2 && c2 != 3) {
                    throw new IllegalStateException("Unexpected value: " + str);
                }
                return showPushOpenFloatView(tbPageContext, readConfig, j);
            }
            return null;
        }
        return (vb5) invokeCommon.objValue;
    }

    public static void showPushPermissionDialogV2(@NonNull TbPageContext<?> tbPageContext, @NonNull String str, @Nullable wu4 wu4Var) {
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65549, null, tbPageContext, str, wu4Var) != null) || (pageActivity = tbPageContext.getPageActivity()) == null) {
            return;
        }
        f05 f05Var = new f05(pageActivity);
        f05Var.setCancelable(false);
        f05Var.setPositiveButton((String) null, (f05.e) null);
        f05Var.setNegativeButton((String) null, (f05.e) null);
        f05Var.setContentViewSize(7);
        PushPermissionDialogViewV2 pushPermissionDialogViewV2 = new PushPermissionDialogViewV2(pageActivity);
        Map<String, String> readConfig = readConfig(str);
        pushPermissionDialogViewV2.setTitle(readConfig.get(VIEW_PARAMS_KEY_TITLE));
        pushPermissionDialogViewV2.setDescription(readConfig.get(VIEW_PARAMS_KEY_DESC));
        f05Var.setContentView(pushPermissionDialogViewV2);
        if (pushPermissionDialogViewV2.getConfirmButton() != null) {
            pushPermissionDialogViewV2.getConfirmButton().setOnClickListener(new b(wu4Var, str, f05Var));
        }
        if (pushPermissionDialogViewV2.getCancelButton() != null) {
            pushPermissionDialogViewV2.getCancelButton().setOnClickListener(new c(wu4Var, str, f05Var));
        }
        f05Var.create(tbPageContext).show();
        logShow(str);
    }

    public static void showPushPermissionSucToast(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65550, null, activity) != null) || activity == null) {
            return;
        }
        View findViewById = activity.findViewById(16908290);
        if (!(findViewById instanceof ViewGroup)) {
            return;
        }
        new BdTopToast(activity, 3000).setIcon(true).setContent(TbadkCoreApplication.getInst().getString(R.string.push_permission_dialog_open_success_toast)).show((ViewGroup) findViewById);
    }
}

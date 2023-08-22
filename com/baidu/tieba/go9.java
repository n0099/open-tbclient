package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.pb.bot.RequestBotSkillHelper;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbContent;
import tbclient.RobotSkill;
import tbclient.RobotSkillInfo;
/* loaded from: classes6.dex */
public class go9 {
    public static /* synthetic */ Interceptable $ic;
    public static List<zfa> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947800792, "Lcom/baidu/tieba/go9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947800792, "Lcom/baidu/tieba/go9;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(TbPageContext<BaseFragmentActivity> tbPageContext, @NonNull String str, long j, @NonNull String str2, @NonNull String str3, @NonNull String str4, FastRequest.b<Void> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{tbPageContext, str, Long.valueOf(j), str2, str3, str4, bVar}) == null) {
            new RequestBotSkillHelper(tbPageContext).b(new RequestBotSkillHelper.BotRequest(str, j, str2, str3, str4), bVar);
        }
    }

    public static void b(PbModel pbModel, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, pbModel, str) != null) || pbModel == null) {
            return;
        }
        yh9 s1 = pbModel.s1();
        yh9 yh9Var = new yh9();
        ArrayList<zfa> F = yh9Var.F();
        zfa zfaVar = new zfa();
        zfaVar.o1(System.currentTimeMillis());
        ArrayList arrayList = new ArrayList();
        PbContent.Builder builder = new PbContent.Builder();
        List<RobotSkillInfo> list = s1.K().robot_skill_info;
        List<RobotSkill> list2 = s1.K().bottom_bar_robot_skill;
        if (list != null && list2 != null) {
            builder.text = BotEntranceManager.h().c(list, list2).style_conf.android_extra.bot_loading_content;
        }
        if (TextUtils.isEmpty(builder.text)) {
            builder.text = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07f6);
        }
        arrayList.add(builder.build(true));
        zfaVar.k1(new TbRichText(arrayList, pbModel.M1(), false));
        zfaVar.Q0(1);
        if (s1 != null && s1.y() != null) {
            zfaVar.S0(s1.F().size() + 1);
        }
        if (s1 != null && s1.O() != null) {
            yh9Var.R0(s1.O());
            yh9Var.O().setReply_num(yh9Var.O().getReply_num() + 1);
        }
        MetaData metaData = new MetaData();
        UserData V = pbModel.s1().V();
        metaData.setName_show(V.getName_show());
        metaData.setPortrait(V.getPortrait());
        metaData.setUserId(V.getUserId());
        metaData.setLevel_id(V.getLevel_id());
        metaData.setLevelName(V.getLevelName());
        metaData.setIconInfo(V.getIconInfo());
        zfaVar.N0(metaData);
        zfaVar.O0(str);
        F.clear();
        F.add(zfaVar);
        a.add(zfaVar);
        pbModel.D2(yh9Var, 8, false, 0, "", false, 0, 0L, 0L, true);
    }

    public static String c(String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            return ji.c(str + str2 + j);
        }
        return (String) invokeCommon.objValue;
    }

    public static void d(String str, String str2, String str3, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3, i) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (zfa zfaVar : a) {
                if (str.equals(zfaVar.w()) && zfaVar.l() == 1) {
                    ArrayList arrayList = new ArrayList();
                    PbContent.Builder builder = new PbContent.Builder();
                    builder.text = str2;
                    arrayList.add(builder.build(true));
                    zfaVar.k1(new TbRichText(arrayList, "", false));
                    zfaVar.Y0(str3);
                    zfaVar.Q0(i);
                    return;
                }
            }
        }
    }

    public static void e(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            BdToast.makeText(TbadkCoreApplication.getInst().getContext(), str).show();
        }
    }
}

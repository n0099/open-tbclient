package com.baidu.tieba;

import android.app.Activity;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.d55;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cga {
    public static /* synthetic */ Interceptable $ic = null;
    public static String l = "1";
    public static String m = "0";
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public String b;
    public int c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;

    /* loaded from: classes5.dex */
    public interface c {
        void onSuccess();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947675180, "Lcom/baidu/tieba/cga;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947675180, "Lcom/baidu/tieba/cga;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements d55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(cga cgaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cgaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.d55.e
        public void onClick(d55 d55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d55Var) == null) {
                d55Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IntentConfig a;

        public b(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {intentConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = intentConfig;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.a));
            }
        }
    }

    public cga(TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = "write";
        int i3 = 1;
        this.e = 1;
        this.f = 2;
        this.g = 3;
        this.h = 4;
        this.i = 8;
        this.j = 2;
        this.k = 8;
        this.a = tbPageContext;
        this.b = str;
        if (!"main_tab".equals(str)) {
            if ("frs".equals(this.b)) {
                i3 = 2;
            } else {
                i3 = 0;
            }
        }
        this.c = i3;
    }

    public static boolean o(Activity activity, IntentConfig intentConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, activity, intentConfig)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.setOnPermissionsGrantedListener(new b(intentConfig));
            return permissionJudgePolicy.startRequestPermission(activity);
        }
        return invokeLL.booleanValue;
    }

    public final void a(ForumWriteData forumWriteData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, forumWriteData, str) == null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getPageActivity(), "", true, true);
            if (forumWriteData != null) {
                albumFloatActivityConfig.getIntent().putExtra("forum_id", forumWriteData.forumId);
                albumFloatActivityConfig.getIntent().putExtra("forum_name", forumWriteData.forumName);
                albumFloatActivityConfig.setFrsTabInfo(forumWriteData.frsTabInfo);
                albumFloatActivityConfig.setCanChangeBarName(false);
                albumFloatActivityConfig.setBarName(forumWriteData.forumName);
                albumFloatActivityConfig.setBarID(forumWriteData.forumId);
                albumFloatActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
            }
            albumFloatActivityConfig.getIntent().putExtra("from", this.b);
            albumFloatActivityConfig.getIntent().putExtra(BaseWriteConfig.TITLE, str);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(true);
            albumFloatActivityConfig.setCanSelectOnlyVideo(true);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setFromWrite(4);
            albumFloatActivityConfig.setCallFrom("2");
            albumFloatActivityConfig.setStatisticFrom(this.c);
            if (o(this.a.getPageActivity(), albumFloatActivityConfig)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public void e(ForumWriteData forumWriteData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, forumWriteData, str) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getPageActivity(), "", true, true);
        if (forumWriteData != null) {
            albumFloatActivityConfig.getIntent().putExtra("forum_id", forumWriteData.forumId);
            albumFloatActivityConfig.getIntent().putExtra("forum_name", forumWriteData.forumName);
            albumFloatActivityConfig.setFrsTabInfo(forumWriteData.frsTabInfo);
            albumFloatActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
        }
        albumFloatActivityConfig.getIntent().putExtra("from", this.b);
        albumFloatActivityConfig.getIntent().putExtra(BaseWriteConfig.TITLE, str);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(0);
        albumFloatActivityConfig.setCanSelectVideo(false);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(4);
        albumFloatActivityConfig.setCallFrom("2");
        albumFloatActivityConfig.getIntent().putExtra(WriteActivityConfig.RICH_MODE_ENABLE, !this.d);
        albumFloatActivityConfig.setStatisticFrom(this.c);
        if (o(this.a.getPageActivity(), albumFloatActivityConfig)) {
            return;
        }
        f();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    public void b(k9 k9Var, ForumWriteData forumWriteData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k9Var, forumWriteData, str) == null) {
            if (dga.b()) {
                if (forumWriteData != null) {
                    dga.f(k9Var, null, null, forumWriteData.forumId, forumWriteData.forumName, 4, Boolean.FALSE, "", "", "");
                } else {
                    dga.f(k9Var, null, null, null, null, 4, Boolean.TRUE, "", "", "");
                }
                return;
            }
            a(forumWriteData, str);
        }
    }

    public void i(ForumWriteData forumWriteData, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, forumWriteData, i, str) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        int a2 = dga.a();
        if (dga.c(a2)) {
            dga.e(this.a.getPageActivity(), a2, i);
        } else if (dga.b()) {
            if (forumWriteData != null) {
                dga.g(null, null, forumWriteData.forumId, forumWriteData.forumName, i, Boolean.FALSE);
            } else {
                dga.g(null, null, null, null, i, Boolean.TRUE);
            }
        } else {
            a(forumWriteData, str);
        }
        l();
    }

    public final void n(TbPageContext tbPageContext, c cVar, ForumWriteData forumWriteData) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048589, this, tbPageContext, cVar, forumWriteData) != null) || tbPageContext == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
        qf.n().j(false);
        if (forumWriteData != null) {
            String str4 = forumWriteData.forumId;
            String str5 = forumWriteData.forumName;
            str3 = str4;
            str2 = forumWriteData.specialForumType;
            str = str5;
        } else {
            str = null;
            str2 = null;
            str3 = "0";
        }
        if (cVar != null) {
            cVar.onSuccess();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.a.getPageActivity(), str, str3, TbadkCoreApplication.getCurrentAccount(), str2)));
        d();
    }

    public void c(ForumWriteData forumWriteData, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forumWriteData, cVar) == null) {
            if (Build.VERSION.SDK_INT < 24) {
                d55 d55Var = new d55(this.a.getPageActivity());
                d55Var.setAutoNight(false);
                d55Var.setTitle(R.string.obfuscated_res_0x7f0f112d);
                d55Var.setMessage(this.a.getResources().getString(R.string.disallow_open_live_by_android_v7_0));
                d55Var.setTitleShowCenter(true);
                d55Var.setMessageShowCenter(true);
                d55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0b2d, new a(this));
                d55Var.create(this.a).show();
                return;
            }
            n(this.a, cVar, forumWriteData);
        }
    }

    public void g(ForumWriteData forumWriteData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, forumWriteData, str) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumWriteData(forumWriteData).setFrom(this.b).setTitle(str).setCallFrom("2").setStatisticFrom(this.c).setRichModeEnable(!this.d).setRichTextMode(this.d).setFromArticle(l).send();
        h();
    }

    public void j(ForumWriteData forumWriteData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, forumWriteData, str) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumWriteData(forumWriteData).setFrom(this.b).setTitle(str).setCallFrom("2").setStatisticFrom(this.c).setFromArticle(m).send();
        k();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
            if ("main_tab".equals(this.b)) {
                statisticItem.param("obj_locate", this.k);
            } else {
                statisticItem.param("obj_locate", this.j);
            }
            statisticItem.param("obj_type", this.h);
            TiebaStatic.log(statisticItem);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
            if ("main_tab".equals(this.b)) {
                statisticItem.param("obj_locate", this.k);
            } else {
                statisticItem.param("obj_locate", this.j);
            }
            statisticItem.param("obj_type", this.g);
            TiebaStatic.log(statisticItem);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
            if ("main_tab".equals(this.b)) {
                statisticItem.param("obj_locate", this.k);
            } else {
                statisticItem.param("obj_locate", this.j);
            }
            statisticItem.param("obj_type", this.i);
            TiebaStatic.log(statisticItem);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
            if ("main_tab".equals(this.b)) {
                statisticItem.param("obj_locate", this.k);
            } else {
                statisticItem.param("obj_locate", this.j);
            }
            statisticItem.param("obj_type", this.e);
            TiebaStatic.log(statisticItem);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
            if ("main_tab".equals(this.b)) {
                statisticItem.param("obj_locate", this.k);
            } else {
                statisticItem.param("obj_locate", this.j);
            }
            statisticItem.param("obj_type", this.f);
            TiebaStatic.log(statisticItem);
        }
    }

    public void m(ForumWriteData forumWriteData) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, forumWriteData) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumWriteData(forumWriteData).setIsQuestionThread(true).setFrom(this.b).setCallFrom("2").setStatisticFrom(this.c).send();
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
        if (this.c == 1) {
            i = 8;
        } else {
            i = 2;
        }
        TiebaStatic.log(statisticItem.param("obj_locate", i).param("obj_type", 8));
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.d = z;
        }
    }
}

package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.message.ForumGuideHttpResponseMessage;
import com.baidu.tieba.enterForum.message.ForumGuideRequestMessage;
import com.baidu.tieba.enterForum.message.SetLikeForumHttpResponseMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.f05;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingCache;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.p55;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class ay6 implements gj5, do5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p55.g A;
    public EnterForumFragment a;
    public qz6 b;
    public EnterForumModel c;
    public RecentlyVisitedForumModel d;
    public t4b e;
    public boolean f;
    public boolean g;
    public boolean h;
    public String i;
    public BaseFragmentActivity j;
    public long k;
    public boolean l;
    public LikeModel m;
    public ViewEventCenter n;
    public BlueCircleProgressDialog o;
    public int p;
    public uz6 q;
    public boolean r;
    public View s;
    public final uy6 t;
    public boolean u;
    public CustomMessageListener v;
    public NetMessageListener w;
    public NetMessageListener x;
    public w4 y;
    public final EnterForumModel.f z;

    @Override // com.baidu.tieba.gj5
    public void a(BdImage bdImage, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048600, this, bdImage, str, z) != null) || bdImage == null) {
        }
    }

    @Override // com.baidu.tieba.do5
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a implements p55.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay6 a;

        public a(ay6 ay6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay6Var;
        }

        @Override // com.baidu.tieba.p55.g
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                EnterForumDelegateStatic.c.U();
                this.a.c.Z(!StringUtils.isNull(this.a.i));
                this.a.d.loadData();
                this.a.c.l0(true);
                TbadkCoreApplication.getInst().setLikeBarChanged(false);
                this.a.t.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;

        public b(ay6 ay6Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay6Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                if (TextUtils.isEmpty(this.a)) {
                    return null;
                }
                OfficialSettingCache.getInstance().saveAcceptNotify(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a), this.b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ay6 ay6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay6Var, Integer.valueOf(i)};
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
            this.a = ay6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.h = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ay6 ay6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay6Var, Integer.valueOf(i)};
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
            this.a = ay6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.b != null && this.a.b.L()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements CustomMessageTask.CustomRunnable<ay4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay6 a;

        public e(ay6 ay6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<ay4> run(CustomMessage<ay4> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                ay4 ay4Var = new ay4();
                ArrayList arrayList = new ArrayList();
                if (this.a.c != null && this.a.c.S() != null && this.a.c.S().e() != null && ListUtils.getCount(this.a.c.S().e().b()) > 0) {
                    Iterator<rx6> it = this.a.c.S().e().b().iterator();
                    while (it.hasNext()) {
                        rx6 next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(JavaTypesHelper.toLong(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.k());
                            hotTopicBussinessData.setForumAvatar(next.e());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    ay4Var.a(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, ay4Var);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ay6 ay6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay6Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay6Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && (responsedMessage instanceof ForumGuideHttpResponseMessage) && this.a.c.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                this.a.b.M();
                this.a.b.z = true;
                if (responsedMessage.hasError()) {
                    if (!this.a.u && responsedMessage.getError() == -100000303) {
                        if (responsedMessage.getOrginalMessage().getExtra() instanceof ForumGuideRequestMessage) {
                            this.a.c.a0(true, ((ForumGuideRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getSortType().intValue());
                            this.a.u = true;
                            return;
                        }
                        return;
                    } else if (this.a.b.Z()) {
                        this.a.b.F0(this.a.s);
                        return;
                    } else {
                        return;
                    }
                }
                this.a.c.e0((ForumGuideHttpResponseMessage) responsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ay6 ay6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay6Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay6Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Activity currentActivity;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || !(responsedMessage instanceof SetLikeForumHttpResponseMessage) || (currentActivity = TbadkApplication.getInst().getCurrentActivity()) == null) {
                return;
            }
            if (responsedMessage.getError() == 0) {
                new BdTopToast(currentActivity, 2000).setIcon(true).setContent(this.a.j.getActivity().getString(R.string.obfuscated_res_0x7f0f0bce)).show((ViewGroup) currentActivity.findViewById(16908290));
            } else {
                new BdTopToast(currentActivity, 2000).setIcon(false).setContent(responsedMessage.getErrorString()).show((ViewGroup) currentActivity.findViewById(16908290));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rx6 a;
        public final /* synthetic */ ay6 b;

        public h(ay6 ay6Var, rx6 rx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay6Var, rx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ay6Var;
            this.a = rx6Var;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                if (BdUtilHelper.isNetOk()) {
                    new m(this.b, this.a).execute(new rx6[0]);
                } else {
                    this.b.j.showToast(R.string.obfuscated_res_0x7f0f0564);
                }
                TiebaStatic.eventStat(this.b.j.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(ay6 ay6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends w4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay6 a;

        public j(ay6 ay6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay6Var;
        }

        @Override // com.baidu.tieba.w4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.a.m.getErrorCode(), this.a.m.getErrorString())) {
                    AntiHelper.u(this.a.j.getPageContext().getPageActivity(), this.a.m.getErrorString());
                } else if (obj != null) {
                    this.a.c.Z(!StringUtils.isNull(this.a.i));
                } else if (!StringUtils.isNull(this.a.m.getErrorString())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), this.a.m.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements EnterForumModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay6 a;

        public k(ay6 ay6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay6Var;
        }

        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.f
        public void a(EnterForumModel.e eVar) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) && eVar != null && this.a.a != null) {
                if (eVar.c == 1) {
                    this.a.b.M();
                }
                if (eVar.b) {
                    int i = eVar.c;
                    if (i == 1) {
                        this.a.g = true;
                        px6 px6Var = eVar.d;
                        this.a.O(px6Var);
                        if (px6Var.g() > 0) {
                            SharedPrefHelper.getInstance().putInt("key_LIKE_forum_sort_state", px6Var.g());
                            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                            if (px6Var.g() == 2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            sharedPrefHelper.putBoolean("like_forum_sort_level", z);
                        }
                        if (px6Var.e() != null && ListUtils.isNotEmpty(px6Var.e().b())) {
                            ArrayList<rx6> b = px6Var.e().b();
                            StringBuilder sb = new StringBuilder();
                            for (rx6 rx6Var : b) {
                                if (rx6Var != null && StringUtils.isNotNull(rx6Var.k())) {
                                    sb.append(rx6Var.k());
                                    sb.append("、");
                                }
                            }
                            TbLog a = qf.a();
                            a.e(Config.DEVICE_PART, "当前用户关注的吧有：" + sb.toString());
                        }
                    } else if (i == 0 && !this.a.g) {
                        px6 px6Var2 = eVar.d;
                        this.a.c.i0(px6Var2);
                        this.a.O(px6Var2);
                    }
                } else {
                    String str = eVar.a;
                    if (str != null && !str.equals("")) {
                        this.a.j.showToast(eVar.a);
                        this.a.b.h0(hx6.a(2));
                    }
                }
                if (eVar.c == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && this.a.I()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (eVar.c == 1 && this.a.k > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_forum_enter", currentTimeMillis - this.a.k, this.a.c.U() - this.a.k, this.a.c.W(), this.a.c.V(), currentTimeMillis - this.a.c.T());
                    this.a.k = -1L;
                }
                String string = this.a.j.getResources().getString(R.string.obfuscated_res_0x7f0f0683);
                px6 px6Var3 = eVar.d;
                if (px6Var3 != null && px6Var3.d() != null) {
                    HotSearchInfoData d = eVar.d.d();
                    SharedPrefHelper.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(d));
                    if (d != null && d.O() != null) {
                        string = d.O();
                    }
                }
                this.a.V(string);
                px6 px6Var4 = eVar.d;
                if (px6Var4 != null && px6Var4.c() != null) {
                    this.a.b.t0(eVar.d.c());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends BdAsyncTask<rx6, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public rx6 b;
        public final /* synthetic */ ay6 c;

        public l(ay6 ay6Var, rx6 rx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay6Var, rx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ay6Var;
            this.a = null;
            this.b = null;
            this.b = rx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(rx6... rx6VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rx6VarArr)) == null) {
                rx6 rx6Var = this.b;
                if (rx6Var != null) {
                    try {
                        if (rx6Var.getId() != null && rx6Var.k() != null) {
                            if (rx6Var.g() == 0) {
                                this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                            } else {
                                this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                            }
                            this.a.addPostData("forum_id", rx6Var.getId());
                            this.a.getNetContext().getRequest().mIsNeedTbs = true;
                            this.a.postNetData();
                            return null;
                        }
                        return null;
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.a = null;
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.c.W(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((l) str);
                this.c.W(false);
                int g = this.b.g();
                NetWork netWork = this.a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.c.l = true;
                        if (this.c.a.isAdded() && this.c.j != null) {
                            BaseFragmentActivity baseFragmentActivity = this.c.j;
                            Activity activity = this.c.j.getActivity();
                            if (g > 0) {
                                i2 = R.string.obfuscated_res_0x7f0f0689;
                            } else {
                                i2 = R.string.obfuscated_res_0x7f0f0685;
                            }
                            baseFragmentActivity.showToast(activity.getString(i2));
                        }
                        this.c.c.Z(true);
                    } else if (this.c.j == null) {
                    } else {
                        if (!StringUtils.isNull(this.a.getErrorString())) {
                            this.c.j.showToast(this.a.getErrorString());
                        } else if (this.c.a.isAdded()) {
                            BaseFragmentActivity baseFragmentActivity2 = this.c.j;
                            Activity activity2 = this.c.j.getActivity();
                            if (g > 0) {
                                i = R.string.obfuscated_res_0x7f0f0688;
                            } else {
                                i = R.string.obfuscated_res_0x7f0f0684;
                            }
                            baseFragmentActivity2.showToast(activity2.getString(i));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends BdAsyncTask<rx6, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public rx6 b;
        public final /* synthetic */ ay6 c;

        public m(ay6 ay6Var, rx6 rx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay6Var, rx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ay6Var;
            this.a = null;
            this.b = null;
            this.b = rx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(rx6... rx6VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rx6VarArr)) == null) {
                rx6 rx6Var = this.b;
                if (rx6Var != null) {
                    try {
                        if (rx6Var.getId() != null && rx6Var.k() != null) {
                            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                            this.a = netWork;
                            netWork.addPostData("fid", rx6Var.getId());
                            this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, rx6Var.k());
                            this.a.getNetContext().getRequest().mIsNeedTbs = true;
                            this.a.postNetData();
                            return null;
                        }
                        return null;
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.a = null;
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.c.W(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((m) str);
                this.c.W(false);
                NetWork netWork = this.a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.c.l = true;
                        if (this.c.a.isAdded() && this.c.j != null) {
                            this.c.j.showToast(this.c.j.getActivity().getString(R.string.unlike_success));
                        }
                        TbadkCoreApplication.getInst().setLikeBarChanged(true);
                        this.c.S(false, this.b.getId());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.b.getId()));
                        long j = JavaTypesHelper.toLong(this.b.getId(), 0L);
                        if (j > 0) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(j)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.b.k()));
                        }
                        this.c.b.n0(this.b, this.c.c.X());
                        this.c.c.c0(this.b);
                    } else if (this.c.j == null) {
                    } else {
                        if (!StringUtils.isNull(this.a.getErrorString())) {
                            this.c.j.showToast(this.a.getErrorString());
                        } else if (this.c.a.isAdded()) {
                            this.c.j.showToast(this.c.j.getActivity().getString(R.string.obfuscated_res_0x7f0f0564));
                        }
                    }
                }
            }
        }
    }

    public ay6(EnterForumFragment enterForumFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.f = true;
        this.g = false;
        this.k = -1L;
        this.p = 1;
        this.v = new c(this, 2921032);
        this.w = new f(this, CmdConfigHttp.CMD_ENTER_FORUM_DATA, 309683);
        this.x = new g(this, CmdConfigHttp.CMD_SET_LIKE_FORUM, 309685);
        this.y = new j(this);
        this.z = new k(this);
        this.A = new a(this);
        this.a = enterForumFragment;
        this.j = enterForumFragment.getBaseFragmentActivity();
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        this.n = viewEventCenter;
        viewEventCenter.addEventDelegate(this);
        t58.d();
        this.k = System.currentTimeMillis();
        this.f = true;
        this.g = false;
        this.i = "";
        this.c = new EnterForumModel(this.j.getPageContext());
        this.t = new uy6();
        this.d = new RecentlyVisitedForumModel();
        this.m = new LikeModel(this.j.getPageContext());
        this.e = new t4b(this.j.getPageContext());
        this.m.setLoadDataCallBack(this.y);
        this.c.k0(this.z);
        SharedPrefHelper.getInstance().putBoolean("enter_forum_edit_mode", false);
        my6.b().c(this.a.getFragmentActivity(), BdUtilHelper.getStatusBarHeight(this.a.getFragmentActivity()));
        G();
        F();
        Q();
    }

    public void A(boolean z) {
        boolean z2;
        boolean z3;
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && !this.r && this.c != null && this.b != null) {
            String str = this.i;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.i = currentAccount;
            if (this.f) {
                this.f = false;
                z2 = false;
                z3 = true;
            } else {
                if (currentAccount != null && !currentAccount.equals(str)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = false;
            }
            if (TbadkCoreApplication.getInst().getLikeBarChanged()) {
                TbadkCoreApplication.getInst().setLikeBarChanged(false);
                z2 = true;
            }
            if (z) {
                z2 = true;
            }
            if (TbadkCoreApplication.getInst().signedForumCount() > 0) {
                EnterForumModel enterForumModel2 = this.c;
                if (enterForumModel2 != null && enterForumModel2.S() != null && this.c.S().e() != null) {
                    Iterator<rx6> it = this.c.S().e().b().iterator();
                    while (it.hasNext()) {
                        rx6 next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.k())) {
                            next.B(1);
                            int signLevelUpValue = TbadkCoreApplication.getInst().getSignLevelUpValue(next.k());
                            if (signLevelUpValue > 0) {
                                next.C(signLevelUpValue);
                            }
                        }
                    }
                }
                TbadkCoreApplication.getInst().clearSignedForum();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    oxa.g(currentAccount2);
                }
                this.b.c0(this.c.X());
            }
            if (!z3 && !z2) {
                return;
            }
            x();
            uy6 uy6Var = this.t;
            if (uy6Var != null) {
                uy6Var.h();
            }
            if (z2) {
                EnterForumModel enterForumModel3 = this.c;
                if (enterForumModel3 != null) {
                    enterForumModel3.Y(!StringUtils.isNull(this.i));
                }
                this.d.loadData();
            } else if (z3 && (enterForumModel = this.c) != null) {
                enterForumModel.Y(!StringUtils.isNull(this.i));
            }
        }
    }

    public final void S(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048594, this, z, str) == null) {
            new b(this, str, z).execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            qz6 qz6Var = this.b;
            if (qz6Var != null) {
                qz6Var.d0(i2);
            }
            uz6 uz6Var = this.q;
            if (uz6Var != null) {
                uz6Var.r();
            }
        }
    }

    public void T(ox6 ox6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, ox6Var) == null) {
            this.b.q0(ox6Var);
            this.a.N2(ox6Var);
        }
    }

    public void U(BdUniqueId bdUniqueId) {
        qz6 qz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) && (qz6Var = this.b) != null) {
            qz6Var.x0(bdUniqueId);
        }
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            if (this.o == null) {
                H();
            }
            this.o.setDialogVisiable(z);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048606, this, z) == null) && this.b != null && this.a != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(z ? 1 : 0)));
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.b == null) {
            return;
        }
        A(true);
    }

    public qz6 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (qz6) invokeV.objValue;
    }

    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.s;
        }
        return (View) invokeV.objValue;
    }

    public void E() {
        qz6 qz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (qz6Var = this.b) != null) {
            qz6Var.X(this.s);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            R();
            this.a.registerListener(this.w);
            this.a.registerListener(this.x);
            this.a.registerListener(this.v);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.o = new BlueCircleProgressDialog(this.j.getPageContext());
        }
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a.isHidden()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || this.b == null) {
            return;
        }
        A(false);
    }

    public void N() {
        RecentlyVisitedForumModel recentlyVisitedForumModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.a.isAdded() && this.a.isPrimary() && (recentlyVisitedForumModel = this.d) != null) {
                recentlyVisitedForumModel.P();
            }
            qz6 qz6Var = this.b;
            if (qz6Var != null) {
                qz6Var.g0();
            }
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new e(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.a.registerListener(new d(this, 2007010));
        }
    }

    @Override // com.baidu.tieba.do5
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.j.getUniqueId();
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void x() {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (enterForumModel = this.c) != null) {
            enterForumModel.cancelLoadData();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.s = LayoutInflater.from(this.j.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d02d3, (ViewGroup) null);
            qz6 qz6Var = new qz6(this.a, this.s, this.n, this.d, this.c);
            this.b = qz6Var;
            qz6Var.A0(this.t);
            this.b.v0(this.A);
            K(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            x();
            my6.b().a();
            qz6 qz6Var = this.b;
            if (qz6Var != null) {
                qz6Var.e0();
            }
            MessageManager.getInstance().unRegisterTask(2016527);
            RecentlyVisitedForumModel recentlyVisitedForumModel = this.d;
            if (recentlyVisitedForumModel != null) {
                recentlyVisitedForumModel.onDestroy();
            }
            EnterForumModel enterForumModel = this.c;
            if (enterForumModel != null) {
                enterForumModel.onDestroy();
            }
            ViewEventCenter viewEventCenter = this.n;
            if (viewEventCenter != null) {
                viewEventCenter.removeEventDelegate(this);
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            qz6 qz6Var = this.b;
            if (qz6Var != null && qz6Var.Q() != null) {
                this.b.Q().y();
            }
            RecentlyVisitedForumModel recentlyVisitedForumModel = this.d;
            if (recentlyVisitedForumModel != null) {
                recentlyVisitedForumModel.onPause();
            }
            EnterForumModel enterForumModel = this.c;
            if (enterForumModel != null) {
                enterForumModel.onPause();
            }
            qz6 qz6Var2 = this.b;
            if (qz6Var2 != null) {
                qz6Var2.f0();
            }
        }
    }

    public void O(px6 px6Var) {
        qz6 qz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, px6Var) != null) || (qz6Var = this.b) == null) {
            return;
        }
        if (px6Var == null) {
            qz6Var.F0(this.s);
            return;
        }
        tx6 e2 = px6Var.e();
        ArrayList<rx6> arrayList = new ArrayList<>();
        if (e2 != null) {
            arrayList = e2.b();
        }
        y(arrayList, px6Var.f());
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(SharedPrefHelper.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.O() != null) {
            V(hotSearchInfoData.O());
        }
        this.b.i0();
        this.b.h0(px6Var.g());
    }

    public void P(boolean z) {
        qz6 qz6Var;
        EnterForumFragment enterForumFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && (qz6Var = this.b) != null && (enterForumFragment = this.a) != null) {
            if (z) {
                if (enterForumFragment.isPrimary() && this.a.isResumed()) {
                    this.b.G0();
                } else {
                    this.b.M();
                }
            } else {
                qz6Var.M();
            }
            this.b.u0(z);
        }
    }

    public final void V(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, str) != null) || this.a.K2() == null) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.a.K2().h0(str.trim());
        } else {
            this.a.K2().h0(this.j.getActivity().getString(R.string.obfuscated_res_0x7f0f0683));
        }
    }

    public void X(rx6 rx6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, rx6Var) != null) || rx6Var == null) {
            return;
        }
        f05 f05Var = new f05(this.j.getPageContext().getPageActivity());
        f05Var.setMessage(String.format(this.j.getPageContext().getString(R.string.obfuscated_res_0x7f0f02fb), rx6Var.k()));
        f05Var.setPositiveButton(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03dc), new h(this, rx6Var));
        f05Var.setNegativeButton(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03db), new i(this));
        f05Var.setButtonTextColor(R.color.CAM_X0105);
        f05Var.create(this.j.getPageContext());
        f05Var.show();
    }

    @Override // com.baidu.tieba.do5
    public boolean i(eo5 eo5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, eo5Var)) == null) {
            int b2 = eo5Var.b();
            yn5 a2 = eo5Var.a();
            int i2 = 2;
            switch (b2) {
                case 1:
                    if (this.p == 2 || !(a2 instanceof rx6)) {
                        return false;
                    }
                    rx6 rx6Var = (rx6) a2;
                    String k2 = rx6Var.k();
                    if (rd.isForumName(k2)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.j.getPageContext().getPageActivity()).createNormalCfg(k2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        if (eo5Var.c() instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            intent.putExtra("transition_type", 0);
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, rx6Var.f());
                            rx6Var.A(0L);
                        }
                        this.j.sendMessage(new CustomMessage(2003000, callFrom));
                        if (YYLiveUtil.isLiveRoom(k2)) {
                            StatisticItem statisticItem = new StatisticItem("c12888");
                            TiebaStaticHelper.addYYParam(statisticItem);
                            TiebaStatic.log(statisticItem);
                        }
                        StatisticItem param = new StatisticItem("c13368").param("uid", TbadkCoreApplication.getCurrentAccountId());
                        if (this.c.S().g() != 1) {
                            i2 = 1;
                        }
                        TiebaStatic.log(param.param("obj_type", i2).param("fid", rx6Var.getId()));
                        return true;
                    }
                    break;
                case 2:
                    if (this.p == 2) {
                        return false;
                    }
                    if (SharedPrefHelper.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                        return true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                    SharedPrefHelper.getInstance().putBoolean("enter_forum_edit_mode", true);
                    if (this.a.getView() != null && this.a.getView().getParent() != null) {
                        this.a.getView().getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                case 3:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                    SharedPrefHelper.getInstance().putBoolean("enter_forum_edit_mode", false);
                    return true;
                case 4:
                    if (!(a2 instanceof rx6)) {
                        return false;
                    }
                    X((rx6) a2);
                    return true;
                case 6:
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.j.getActivity());
                        return true;
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        TiebaStatic.eventStat(this.j.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                    }
                    TiebaStatic.log(new StatisticItem("find_more_text_click"));
                    return true;
                case 7:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.j.getPageContext().getPageActivity())));
                    if (!TbadkCoreApplication.isLogin()) {
                        TiebaStatic.eventStat(this.j.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                    }
                    TiebaStatic.log(new StatisticItem("c13367").param("obj_location", "1"));
                    return true;
                case 8:
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).param("obj_type", "2").param("obj_locate", 1));
                    this.j.finish();
                    return true;
                case 9:
                    qz6 qz6Var = this.b;
                    if (qz6Var != null) {
                        qz6Var.G0();
                    }
                    return true;
                case 10:
                    this.p = 2;
                    return true;
                case 11:
                    this.p = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                    return true;
                case 12:
                    if (this.p == 2) {
                        return true;
                    }
                    if (this.q == null) {
                        this.q = new uz6(this.j.getPageContext(), this.n);
                    }
                    if (a2 instanceof rx6) {
                        this.q.s((rx6) a2);
                        this.q.l();
                    }
                    return true;
                case 13:
                    if (!(a2 instanceof rx6)) {
                        return false;
                    }
                    rx6 rx6Var2 = (rx6) a2;
                    new l(this, rx6Var2).execute(new rx6[0]);
                    StatisticItem statisticItem2 = new StatisticItem("c13370");
                    if (rx6Var2.g() <= 0) {
                        i2 = 1;
                    }
                    TiebaStatic.log(statisticItem2.param("obj_type", i2).param("fid", rx6Var2.getId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                    return true;
                case 14:
                    UrlManager.getInstance().dealOneLink(this.j.getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "mo/q/priforum/create/info?nomenu=1"});
                    return true;
                case 15:
                    if (!this.e.d() && (a2 instanceof rx6)) {
                        UrlManager.getInstance().dealOneLink(this.j.getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "mo/q/priforum/editinfo?fid=" + ((rx6) a2).getId() + "&nomenu=1"});
                    }
                    return true;
                case 16:
                    T((ox6) eo5Var.d());
                    break;
                case 17:
                    T((ox6) eo5Var.d());
                    break;
                case 18:
                    T((ox6) eo5Var.d());
                    break;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void y(List<rx6> list, xy4 xy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048605, this, list, xy4Var) != null) || list == null) {
            return;
        }
        if (list.size() > 500) {
            list = list.subList(0, 500);
        }
        this.b.l0(this.c.m0(list, ft5.a()), xy4Var, this.c.X());
    }
}

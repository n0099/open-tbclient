package com.baidu.tieba;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.h5.FrsTabWebFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes3.dex */
public class bq6 extends hq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener h;
    public final CustomMessageListener i;
    public final pb j;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bq6 bq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq6Var, Integer.valueOf(i)};
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
            this.a = bq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str) || this.a.b.O0() == null) {
                    return;
                }
                FrsViewData O0 = this.a.b.O0();
                O0.removeThread(str);
                aq6 aq6Var = this.a.g;
                if (aq6Var != null) {
                    aq6Var.k(str);
                }
                this.a.a.F1(O0.getThreadList(), O0);
                if (ql8.i() != null) {
                    ql8.i().n(this.a.b.c(), false);
                }
                if (this.a.b != null) {
                    if (ch6.g()) {
                        BdTopToast bdTopToast = new BdTopToast(this.a.b.getContext());
                        bdTopToast.h(true);
                        bdTopToast.g(this.a.b.getContext().getString(R.string.obfuscated_res_0x7f0f1198));
                        bdTopToast.i((ViewGroup) this.a.b.C3());
                        return;
                    }
                    BdTopToast bdTopToast2 = new BdTopToast(this.a.b.getContext());
                    bdTopToast2.h(true);
                    bdTopToast2.g(this.a.b.getContext().getString(R.string.obfuscated_res_0x7f0f04be));
                    bdTopToast2.i((ViewGroup) this.a.b.C3());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bq6 bq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq6Var, Integer.valueOf(i)};
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
            this.a = bq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ForumManageModel.e eVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e)) {
                bq6 bq6Var = this.a;
                if (bq6Var.b == null || bq6Var.a == null || bq6Var.d == null || (eVar = (ForumManageModel.e) customResponsedMessage.getData()) == null || TextUtils.isEmpty(eVar.a) || this.a.b.O0() == null) {
                    return;
                }
                String str = eVar.a;
                String str2 = eVar.b;
                String str3 = eVar.c;
                if (eVar.d == 4) {
                    FrsViewData O0 = this.a.b.O0();
                    ThreadData threadDataById = O0.getThreadDataById(str);
                    O0.removeThreadData(threadDataById);
                    List<Cdo> topThreadList = O0.getTopThreadList();
                    if (topThreadList == null) {
                        topThreadList = new ArrayList<>();
                    }
                    topThreadList.add(0, threadDataById);
                    this.a.a.F1(O0.getThreadList(), O0);
                    this.a.d.W(O0);
                }
                if (TextUtils.equals(this.a.b.c(), str3)) {
                    ql8.i().n(this.a.b.c(), false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(bq6 bq6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = bq6Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0085  */
        @Override // com.baidu.tieba.pb
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            String errorString;
            int i;
            String errorString2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof RequestGetMyPostNetMessage) {
                    z = ((RequestGetMyPostNetMessage) extra).showErrorToast();
                    JSONObject jSONObject = new JSONObject();
                    if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
                        GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                            errorString2 = this.a.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c59);
                        } else {
                            errorString2 = getMyPostHttpResponseMessage.getErrorString();
                        }
                        if (responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage) {
                            RequestGetMyPostNetMessage requestGetMyPostNetMessage = (RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra();
                            int proZone = requestGetMyPostNetMessage.getProZone();
                            this.a.e(jSONObject, requestGetMyPostNetMessage);
                            i2 = proZone;
                        } else {
                            i2 = 0;
                        }
                        if (z || getMyPostHttpResponseMessage.getError() == 0) {
                            this.a.g(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), i2, jSONObject);
                            return;
                        }
                        return;
                    } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                        GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                            errorString = this.a.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c59);
                        } else {
                            errorString = getMyPostSocketResponseMessage.getErrorString();
                        }
                        if (responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage) {
                            RequestGetMyPostNetMessage requestGetMyPostNetMessage2 = (RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra();
                            int proZone2 = requestGetMyPostNetMessage2.getProZone();
                            this.a.e(jSONObject, requestGetMyPostNetMessage2);
                            i = proZone2;
                        } else {
                            i = 0;
                        }
                        if (z || getMyPostSocketResponseMessage.getError() == 0) {
                            this.a.g(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), i, jSONObject);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            z = true;
            JSONObject jSONObject2 = new JSONObject();
            if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostWriteCallBackData a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ bq6 e;

        public d(bq6 bq6Var, PostWriteCallBackData postWriteCallBackData, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq6Var, postWriteCallBackData, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = bq6Var;
            this.a = postWriteCallBackData;
            this.b = j;
            this.c = j2;
            this.d = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int k = ej.k(TbadkCoreApplication.getInst());
                int i = ej.i(TbadkCoreApplication.getInst());
                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setProZone(this.a.getProZone());
                requestGetMyPostNetMessage.setParams(this.b, this.c, this.d, k, i, f, i2);
                this.e.b.sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bq6(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this, 2921031);
        this.i = new b(this, 2921316);
        c cVar = new c(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.j = cVar;
        cVar.getSocketMessageListener().setSelfListener(true);
        this.j.getHttpMessageListener().setSelfListener(true);
        this.h.setSelfListener(false);
        this.b.registerListener(this.h);
        this.b.registerListener(this.j);
        this.b.registerListener(this.i);
    }

    public final void c(ThreadData threadData, FrsNewAreaFragment frsNewAreaFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, threadData, frsNewAreaFragment) == null) {
            frsNewAreaFragment.S1(threadData);
        }
    }

    public final void d(ws4 ws4Var) {
        FrsViewData O0;
        ArrayList<Cdo> threadList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ws4Var) == null) || (O0 = this.b.O0()) == null) {
            return;
        }
        this.e.J(ws4Var);
        if (this.e.w0()) {
            ArrayList<Cdo> arrayList = new ArrayList<>();
            arrayList.add(ws4Var);
            threadList = this.g.c(false, true, arrayList, null, true, -1, null);
        } else {
            threadList = O0.getThreadList();
        }
        if (threadList != null) {
            O0.setThreadList(threadList);
            O0.checkLiveStageInThreadList();
            this.a.F1(threadList, O0);
        }
    }

    public final JSONObject e(JSONObject jSONObject, RequestGetMyPostNetMessage requestGetMyPostNetMessage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, requestGetMyPostNetMessage)) == null) {
            f(jSONObject, String.valueOf(requestGetMyPostNetMessage.getForumId()), String.valueOf(requestGetMyPostNetMessage.getThreadId()), String.valueOf(requestGetMyPostNetMessage.getPostId()), requestGetMyPostNetMessage.getQType(), requestGetMyPostNetMessage.getFrom(), String.valueOf(requestGetMyPostNetMessage.getCallFrom()));
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final JSONObject f(JSONObject jSONObject, String str, String str2, String str3, int i, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{jSONObject, str, str2, str3, Integer.valueOf(i), str4, str5})) == null) {
            try {
                jSONObject.put("forum_id", str);
                jSONObject.put("thread_id", str2);
                jSONObject.put("post_id", str3);
                jSONObject.put("scr_w", ej.k(TbadkCoreApplication.getInst()));
                jSONObject.put("scr_h", ej.i(TbadkCoreApplication.getInst()));
                jSONObject.put("scr_dip", TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                jSONObject.put("q_type", i);
                jSONObject.put("bfrom", str4);
                jSONObject.put(IntentConfig.CALL_FROM, str5);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public final void g(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2, JSONObject jSONObject) {
        DataRes dataRes;
        User_Info user_Info;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, getMyPostResIdl, Integer.valueOf(i2), jSONObject}) == null) {
            if (i != 0) {
                this.b.showToast(str);
                return;
            }
            FrsViewData O0 = this.b.O0();
            if (O0 == null || O0.getForum() == null || getMyPostResIdl == null || this.a == null || this.e == null || (dataRes = getMyPostResIdl.data) == null || dataRes.thread_info == null) {
                return;
            }
            ws4 ws4Var = new ws4();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            h(builder2, getMyPostResIdl.data.user_info);
            User user = builder.author;
            if (user == null || TextUtils.isEmpty(user.name)) {
                builder.author = builder2.build(true);
            }
            User user2 = builder.author;
            if (user2 != null && (user_Info = getMyPostResIdl.data.user_info) != null && user2.name.equals(user_Info.name)) {
                builder.author = builder2.build(true);
            }
            builder.cheak_repeat = 1;
            builder.fname = O0.getForum().getName();
            builder.fid = Long.valueOf(dh.g(O0.getForum().getId(), 0L));
            ws4Var.parserProtobuf(builder.build(true));
            i(ws4Var, i2, jSONObject);
        }
    }

    public final void h(User.Builder builder, User_Info user_Info) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, builder, user_Info) == null) || user_Info == null) {
            return;
        }
        Long l = user_Info.id;
        builder.id = l;
        builder.gender = user_Info.gender;
        builder.type = user_Info.type;
        builder.name = user_Info.name;
        builder.name_show = user_Info.name_show;
        if (l.longValue() == TbadkCoreApplication.getCurrentAccountId()) {
            builder.portrait = TbadkCoreApplication.getCurrentPortrait();
        } else {
            builder.portrait = user_Info.portrait;
        }
        builder.god_data = user_Info.god_data;
        builder.fans_num = user_Info.fans_num;
        builder.fans_nickname = user_Info.fans_nickname;
        builder.is_bawu = user_Info.is_bawu;
        builder.bawu_type = user_Info.bawu_type;
        builder.new_god_data = user_Info.new_god_data;
        builder.business_account_info = user_Info.business_account_info;
    }

    public final void i(ws4 ws4Var, int i, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, ws4Var, i, jSONObject) == null) {
            if (i == 1) {
                FrsTabViewController.p C = this.b.E3().C();
                if (C != null) {
                    Fragment fragment = C.b;
                    if (fragment instanceof FrsCommonTabFragment) {
                        ((FrsCommonTabFragment) fragment).A1(ws4Var);
                    }
                }
            } else if (i == 2) {
                FrsTabViewController.p J = this.b.E3().J(301);
                if (J == null || !(J.b instanceof FrsGoodFragment)) {
                    return;
                }
                this.c.b(301);
                ((FrsGoodFragment) J.b).R1(ws4Var);
            } else if (ws4Var.getTabId() > 0) {
                FrsTabViewController.p J2 = this.b.E3().J(ws4Var.getTabId());
                if (J2 != null) {
                    Fragment fragment2 = J2.b;
                    if (fragment2 instanceof FrsCommonTabFragment) {
                        ((FrsCommonTabFragment) fragment2).A1(ws4Var);
                    } else if (fragment2 instanceof FrsTabWebFragment) {
                        ((FrsTabWebFragment) fragment2).R1(ws4Var, jSONObject);
                    }
                }
            } else {
                if (!ListUtils.isEmpty(ws4Var.getItemStar())) {
                    ws4Var.insertItemToTitleOrAbstractText();
                }
                FrsTabViewController.p J3 = this.b.E3().J(this.b.E3().F());
                if (J3 != null) {
                    Fragment fragment3 = J3.b;
                    if (fragment3 instanceof FrsNewAreaFragment) {
                        c(ws4Var, (FrsNewAreaFragment) fragment3);
                    } else {
                        d(ws4Var);
                    }
                }
            }
        }
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, postWriteCallBackData) == null) || (frsModelController = this.e) == null) {
            return;
        }
        boolean z = frsModelController.g0() != null && this.e.g0().getIsBrandForum();
        int U = this.e.U();
        if (U == 2 || U == 3 || U == 7 || U == 8 || z) {
            if ((xh6.a().b(1) != null ? this.e.Y() : 0) != 0 || postWriteCallBackData == null) {
                return;
            }
            long g = dh.g(postWriteCallBackData.getPostId(), 0L);
            long g2 = dh.g(postWriteCallBackData.getThreadId(), 0L);
            long g3 = dh.g(this.b.d(), 0L);
            if (g != 0 && g2 != 0 && g3 != 0) {
                gh.a().postDelayed(new d(this, postWriteCallBackData, g2, g, g3), 1000L);
                return;
            }
            WriteData writeData = postWriteCallBackData.writeDataForVideo;
            if (writeData != null) {
                ws4 ws4Var = new ws4();
                ws4Var.parseFromWriteData(writeData);
                JSONObject jSONObject = new JSONObject();
                f(jSONObject, writeData.getForumId(), writeData.getThreadId(), writeData.getRepostId(), TbImageHelper.getInstance().isShowBigImage() ? 2 : 1, "", "0");
                i(ws4Var, writeData.getProZone(), jSONObject);
            }
        }
    }
}

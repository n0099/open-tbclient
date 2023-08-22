package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumHttpResponseMessage;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumRequestMessage;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumSocketResponseMessage;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecentlyVisitedForumData a;
    public boolean b;
    public boolean c;
    public boolean d;
    public f e;
    public boolean f;
    public CustomMessageListener g;
    public CustomMessageListener h;
    public NetMessageListener i;

    /* loaded from: classes5.dex */
    public interface f {
        void a(LinkedList<VisitedForumData> linkedList, boolean z);

        void b(int i);

        void onNotify();
    }

    /* loaded from: classes5.dex */
    public class a extends bx5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a07 a;

        public a(a07 a07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a07Var;
        }

        @Override // com.baidu.tieba.bx5
        public Object doInBackground() {
            InterceptResult invokeV;
            String currentAccount;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                r45.k();
                if (TbadkCoreApplication.getCurrentAccount() == null) {
                    currentAccount = "local";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                ne<String> m = r45.m("tb.recently_visited_forum", currentAccount);
                if (m != null && this.a.a != null) {
                    m.g("recently_visited_forum", OrmObject.jsonStrWithObject(this.a.a));
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, RecentlyVisitedForumData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a07 a;

        public b(a07 a07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(RecentlyVisitedForumData recentlyVisitedForumData) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recentlyVisitedForumData) != null) {
                return;
            }
            this.a.b = false;
            if (recentlyVisitedForumData == null) {
                return;
            }
            this.a.C(recentlyVisitedForumData.getForumData(), true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public RecentlyVisitedForumData doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            RecentlyVisitedForumData recentlyVisitedForumData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                r45.k();
                ne<String> m = r45.m("tb.recently_visited_forum", "local");
                RecentlyVisitedForumData recentlyVisitedForumData2 = null;
                if (m != null && !di.isEmpty(m.get("recently_visited_forum"))) {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(m.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                } else {
                    recentlyVisitedForumData = null;
                }
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    if (m != null) {
                        m.g("recently_visited_forum", "");
                    }
                    r45.k();
                    ne<String> m2 = r45.m("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount());
                    if (m2 != null && !StringUtils.isNull(m2.get("recently_visited_forum"))) {
                        try {
                            recentlyVisitedForumData2 = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(m2.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (recentlyVisitedForumData != null) {
                            recentlyVisitedForumData.mergeForumData(recentlyVisitedForumData2);
                            m2.g("recently_visited_forum", OrmObject.jsonStrWithObject(recentlyVisitedForumData));
                            return recentlyVisitedForumData;
                        }
                        return recentlyVisitedForumData2;
                    }
                    return recentlyVisitedForumData;
                }
                return recentlyVisitedForumData;
            }
            return (RecentlyVisitedForumData) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a07 a07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a07Var, Integer.valueOf(i)};
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
            this.a = a07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                this.a.u((VisitedForumData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a07 a07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a07Var, Integer.valueOf(i)};
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
            this.a = a07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a07 a07Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a07Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = a07Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            this.a.c = false;
            if (responsedMessage == null) {
                return;
            }
            if (!(responsedMessage instanceof RecentlyVisitedForumHttpResponseMessage)) {
                if (!(responsedMessage instanceof RecentlyVisitedForumSocketResponseMessage)) {
                    return;
                }
                this.a.x((RecentlyVisitedForumSocketResponseMessage) responsedMessage);
                return;
            }
            this.a.w((RecentlyVisitedForumHttpResponseMessage) responsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public static a07 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-999215106, "Lcom/baidu/tieba/a07$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-999215106, "Lcom/baidu/tieba/a07$g;");
                    return;
                }
            }
            a = new a07(null);
        }
    }

    public a07() {
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
        this.b = false;
        this.c = false;
        this.g = new c(this, 2016564);
        this.h = new d(this, 2005016);
        this.i = new e(this, CmdConfigHttp.CMD_GET_HISTORY_FORUM, 309601);
        this.a = new RecentlyVisitedForumData();
        y();
        q();
    }

    @NonNull
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder("");
            RecentlyVisitedForumData recentlyVisitedForumData = this.a;
            if (recentlyVisitedForumData == null || ListUtils.isEmpty(recentlyVisitedForumData.getForumData())) {
                return "";
            }
            List trimToSize = ListUtils.trimToSize(this.a.getForumData(), 5);
            int count = ListUtils.getCount(trimToSize);
            for (int i = 0; i < count; i++) {
                VisitedForumData visitedForumData = (VisitedForumData) trimToSize.get(i);
                if (i < count - 1) {
                    sb.append(visitedForumData.getForumId());
                    sb.append(",");
                } else {
                    sb.append(visitedForumData.getForumId());
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder("");
            RecentlyVisitedForumData recentlyVisitedForumData = this.a;
            if (recentlyVisitedForumData == null || ListUtils.isEmpty(recentlyVisitedForumData.getForumData())) {
                return "";
            }
            List trimToSize = ListUtils.trimToSize(this.a.getForumData(), 5);
            int count = ListUtils.getCount(trimToSize);
            for (int i = 0; i < count; i++) {
                VisitedForumData visitedForumData = (VisitedForumData) trimToSize.get(i);
                if (i < count - 1) {
                    sb.append(visitedForumData.getForumName());
                    sb.append(",");
                } else {
                    sb.append(visitedForumData.getForumName());
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ a07(a aVar) {
        this();
    }

    public void A(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.e = fVar;
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f = z;
        }
    }

    public void i(VisitedForumData visitedForumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, visitedForumData) == null) {
            t(visitedForumData);
        }
    }

    public final void t(VisitedForumData visitedForumData) {
        int deleteForumItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, visitedForumData) == null) && visitedForumData != null && (deleteForumItem = this.a.deleteForumItem(visitedForumData)) >= 0) {
            f fVar = this.e;
            if (fVar != null) {
                fVar.b(deleteForumItem);
            }
            z(visitedForumData);
            D();
        }
    }

    public final void w(RecentlyVisitedForumHttpResponseMessage recentlyVisitedForumHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, recentlyVisitedForumHttpResponseMessage) == null) && recentlyVisitedForumHttpResponseMessage != null && recentlyVisitedForumHttpResponseMessage.getForumData() != null) {
            C(recentlyVisitedForumHttpResponseMessage.getForumData(), false);
        }
    }

    public final void x(RecentlyVisitedForumSocketResponseMessage recentlyVisitedForumSocketResponseMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, recentlyVisitedForumSocketResponseMessage) == null) && recentlyVisitedForumSocketResponseMessage != null && recentlyVisitedForumSocketResponseMessage.getForumData() != null) {
            C(recentlyVisitedForumSocketResponseMessage.getForumData(), false);
        }
    }

    public static a07 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return g.a;
        }
        return (a07) invokeV.objValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.b) {
            return;
        }
        fx5.b(new a(this), null);
    }

    public RecentlyVisitedForumData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (RecentlyVisitedForumData) invokeV.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.b = true;
            b bVar = new b(this);
            bVar.setPriority(3);
            bVar.execute(new Void[0]);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.c) {
            return;
        }
        RecentlyVisitedForumRequestMessage recentlyVisitedForumRequestMessage = new RecentlyVisitedForumRequestMessage();
        recentlyVisitedForumRequestMessage.setForumData(this.a.getForumData());
        this.c = MessageManager.getInstance().sendMessage(recentlyVisitedForumRequestMessage);
    }

    public void s() {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (fVar = this.e) != null) {
            fVar.a(this.a.getForumData(), this.d);
        }
    }

    public void v() {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (fVar = this.e) != null) {
            fVar.onNotify();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            MessageManager.getInstance().registerListener(this.i);
            MessageManager.getInstance().registerListener(this.g);
            MessageManager.getInstance().registerListener(this.h);
        }
    }

    public final void C(LinkedList<VisitedForumData> linkedList, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, linkedList, z) != null) || linkedList == null) {
            return;
        }
        this.a.setForumData(linkedList);
        this.a.trimSize(20);
        this.d = z;
        if (this.f) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921504, null));
            this.f = false;
        }
        s();
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            RecentlyVisitedForumData recentlyVisitedForumData = this.a;
            if (recentlyVisitedForumData != null && recentlyVisitedForumData.getForumData() != null && this.a.getForumData().size() >= 1) {
                ArrayList<VisitedForumData> arrayList = new ArrayList(this.a.getForumData());
                JSONArray jSONArray = new JSONArray();
                for (VisitedForumData visitedForumData : arrayList) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("forum_id", JavaTypesHelper.toLong(visitedForumData.getForumId(), 0L));
                        jSONObject.put("visit_time", visitedForumData.getVisitedTime());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public JSONArray o() {
        InterceptResult invokeV;
        Object obj;
        Object obj2;
        Object jsonObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            RecentlyVisitedForumData recentlyVisitedForumData = this.a;
            if (recentlyVisitedForumData != null && recentlyVisitedForumData.getForumData() != null && !ListUtils.isEmpty(this.a.getForumData())) {
                ArrayList<VisitedForumData> arrayList = new ArrayList(this.a.getForumData());
                JSONArray jSONArray = new JSONArray();
                for (VisitedForumData visitedForumData : arrayList) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("forumName", visitedForumData.getForumName());
                        jSONObject.put("forumId", visitedForumData.getForumId());
                        jSONObject.put("avatar", visitedForumData.getForumImageUrl());
                        jSONObject.put("visitTime", visitedForumData.getVisitedTime());
                        String str = "1";
                        if (visitedForumData.isAlaForum()) {
                            obj = "1";
                        } else {
                            obj = "0";
                        }
                        jSONObject.put("isLiveForum", obj);
                        jSONObject.put("level", visitedForumData.getLevel());
                        jSONObject.put("followNumber", visitedForumData.getFollowNumber());
                        if (visitedForumData.isCanPost()) {
                            obj2 = "1";
                        } else {
                            obj2 = "0";
                        }
                        jSONObject.put("isCanPost", obj2);
                        jSONObject.put("blockInfo", visitedForumData.getBlockInfo());
                        if (visitedForumData.getPostPrefix() == null) {
                            jsonObject = "";
                        } else {
                            jsonObject = visitedForumData.getPostPrefix().toJsonObject();
                        }
                        jSONObject.put("postPrefix", jsonObject);
                        JSONArray jSONArray2 = new JSONArray();
                        if (visitedForumData.getTabInfoList() != null && visitedForumData.getTabInfoList().size() > 0) {
                            for (FrsTabItemData frsTabItemData : visitedForumData.getTabInfoList()) {
                                jSONArray2.put(frsTabItemData.toJsonObject());
                            }
                        }
                        jSONObject.put("tabInfoList", jSONArray2);
                        if (!visitedForumData.isIsLike()) {
                            str = "0";
                        }
                        jSONObject.put("isLike", str);
                        jSONObject.put("dayThreadNum", visitedForumData.getDayThreadNum());
                        jSONObject.put("firstCategory", visitedForumData.firstCategory);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }
            return new JSONArray();
        }
        return (JSONArray) invokeV.objValue;
    }

    @Nullable
    public VisitedForumData p(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            RecentlyVisitedForumData j = j();
            if (j != null && !TextUtils.isEmpty(str)) {
                Iterator<VisitedForumData> it = j.getForumData().iterator();
                while (it.hasNext()) {
                    VisitedForumData next = it.next();
                    if (str.equals(next.getForumId())) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (VisitedForumData) invokeL.objValue;
    }

    public final void u(VisitedForumData visitedForumData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, visitedForumData) != null) || visitedForumData == null) {
            return;
        }
        this.a.addForumItem(visitedForumData);
        this.a.trimSize(20);
        s();
        D();
        n().r();
        zk9.a().d(visitedForumData.getForumId());
    }

    public final void z(VisitedForumData visitedForumData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, visitedForumData) != null) || !TbadkCoreApplication.isLogin()) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_HISTORY_FORUM);
        httpMessage.addParam("forum_id", JavaTypesHelper.toLong(visitedForumData.getForumId(), 0L));
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

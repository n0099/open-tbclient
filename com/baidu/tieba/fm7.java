package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.forum.data.ForumTabItem;
import com.baidu.tieba.forum.data.SortItem;
import com.baidu.tieba.forum.data.SubTabItem;
import com.baidu.tieba.forum.model.FrsPageRequestMessage;
import com.baidu.tieba.forum.model.FrsThreadListRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class fm7 extends rl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int t;
    public int u;
    public boolean v;
    public int w;
    public final NetMessageListener x;
    public final NetMessageListener y;

    @Override // com.baidu.tieba.rl7
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "FRS" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fm7 fm7Var) {
            super(CmdConfigHttp.FRS_HTTP_CMD, 301001);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm7Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.I(responsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(fm7 fm7Var) {
            super(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm7Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.I(responsedMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fm7(Context context, BdUniqueId bdUniqueId, Bundle bundle) {
        super(context, bdUniqueId, bundle);
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1], (Bundle) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bdUniqueId, "bdUniqueId");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.w = 1;
        this.x = new a(this);
        this.y = new b(this);
        ForumTabItem forumTabItem = (ForumTabItem) bundle.getParcelable("forum_tab_info");
        if (forumTabItem != null) {
            List<SortItem> sortItemList = forumTabItem.getSortItemList();
            if (sortItemList != null && !sortItemList.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                int i3 = SharedPrefHelper.getInstance().getInt("key_forum_last_sort_type", -1);
                L(i3 == -1 ? forumTabItem.getSortItemList().get(0).getId() : i3);
            }
            List<SubTabItem> subTabList = forumTabItem.getSubTabList();
            if (subTabList != null && !subTabList.isEmpty()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                M(forumTabItem.getSubTabList().get(0).getId());
            }
            this.t = forumTabItem.getTabId() == 301 ? 1 : 0;
        }
        this.x.setTag(bdUniqueId);
        this.x.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.x);
        this.y.setTag(bdUniqueId);
        this.y.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.y);
    }

    @Override // com.baidu.tieba.rl7
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            K(w() + 1);
            FrsPageRequestMessage a2 = zl7.a(p());
            a2.setTag(o());
            a2.setPn(w());
            a2.setRn(90);
            a2.setRnNeed(30);
            a2.setSortType(z());
            a2.setLoadType(2);
            a2.setGood(this.t);
            a2.setCid(A());
            String g = c37.g(b().a, false);
            Intrinsics.checkNotNullExpressionValue(g, "getAdFloorInfo(feedData.dataList, false)");
            a2.setAdFloorInfo(g);
            MessageManager.getInstance().sendMessage(a2);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrsThreadListRequestMessage frsThreadListRequestMessage = new FrsThreadListRequestMessage();
            frsThreadListRequestMessage.setTag(o());
            frsThreadListRequestMessage.setForumId(p().getLong("forum_id"));
            frsThreadListRequestMessage.setThreadIds(O(C()));
            frsThreadListRequestMessage.setNeedAbstract(0);
            String string = p().getString("name");
            if (string == null) {
                string = "";
            }
            frsThreadListRequestMessage.setForumName(string);
            frsThreadListRequestMessage.setPn(w());
            frsThreadListRequestMessage.setSortType(z());
            int i = this.w;
            this.w = i + 1;
            frsThreadListRequestMessage.setRequestTimes(i);
            frsThreadListRequestMessage.setFrsCommonInfo(u());
            frsThreadListRequestMessage.setNewFrs(1);
            frsThreadListRequestMessage.setGood(this.t);
            String g = c37.g(b().a, false);
            Intrinsics.checkNotNullExpressionValue(g, "getAdFloorInfo(feedData.dataList, false)");
            frsThreadListRequestMessage.setAdFloorInfo(g);
            MessageManager.getInstance().sendMessage(frsThreadListRequestMessage);
        }
    }

    @Override // com.baidu.tieba.ec7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || e()) {
            return;
        }
        FrsPageRequestMessage a2 = zl7.a(p());
        a2.setTag(o());
        a2.setSortType(z());
        K(1);
        a2.setPn(w());
        a2.setRn(90);
        a2.setRnNeed(30);
        a2.setGood(this.t);
        a2.setCid(A());
        String g = c37.g(b().a, true);
        Intrinsics.checkNotNullExpressionValue(g, "getAdFloorInfo(feedData.dataList, true)");
        a2.setAdFloorInfo(g);
        MessageManager.getInstance().sendMessage(a2);
        i(true);
        this.u = 0;
        this.v = false;
    }

    public final String O(List<Long> list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            int i = 0;
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.v = true;
                return "";
            }
            int i2 = this.u;
            int i3 = 30;
            if (i2 == 0) {
                if (30 > list.size()) {
                    i3 = list.size();
                    this.v = true;
                }
            } else if (i2 != 1) {
                return "";
            } else {
                int size = list.size();
                this.v = true;
                i3 = size;
                i = 30;
            }
            StringBuilder sb = new StringBuilder();
            while (i < i3) {
                long longValue = list.get(i).longValue();
                if (i == i3 - 1) {
                    sb.append(longValue);
                } else {
                    sb.append(longValue);
                    sb.append(",");
                }
                i++;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
            return sb2;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ec7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.x);
            MessageManager.getInstance().unRegisterListener(this.y);
        }
    }

    @Override // com.baidu.tieba.ec7
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || e()) {
            return;
        }
        if (this.u != 2 && !this.v) {
            P();
            this.u++;
        } else {
            G();
            this.u = 0;
            N(CollectionsKt__CollectionsKt.emptyList());
            this.v = false;
        }
        i(true);
    }

    @Override // com.baidu.tieba.rl7
    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.l(i);
            SharedPrefHelper.getInstance().putInt("key_forum_last_sort_type", i);
        }
    }
}

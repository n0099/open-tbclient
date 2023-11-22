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
/* loaded from: classes6.dex */
public final class ik7 extends uj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int p;
    public int q;
    public boolean r;
    public int s;
    public final NetMessageListener t;
    public final NetMessageListener u;

    /* loaded from: classes6.dex */
    public static final class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ik7 ik7Var) {
            super(CmdConfigHttp.FRS_HTTP_CMD, 301001);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik7Var};
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
            this.a = ik7Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.B(responsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ik7 ik7Var) {
            super(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik7Var};
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
            this.a = ik7Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.B(responsedMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ik7(Context context, BdUniqueId bdUniqueId, Bundle bundle) {
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
        this.s = 1;
        this.t = new a(this);
        this.u = new b(this);
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
                E(i3 == -1 ? forumTabItem.getSortItemList().get(0).getId() : i3);
            }
            List<SubTabItem> subTabList = forumTabItem.getSubTabList();
            if (subTabList != null && !subTabList.isEmpty()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                F(forumTabItem.getSubTabList().get(0).getId());
            }
            this.p = forumTabItem.getTabId() == 301 ? 1 : 0;
        }
        this.t.setTag(bdUniqueId);
        this.t.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.t);
        this.u.setTag(bdUniqueId);
        this.u.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.u);
    }

    public final String H(List<Long> list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            int i = 0;
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.r = true;
                return "";
            }
            int i2 = this.q;
            int i3 = 30;
            if (i2 == 0) {
                if (30 > list.size()) {
                    i3 = list.size();
                    this.r = true;
                }
            } else if (i2 != 1) {
                return "";
            } else {
                int size = list.size();
                this.r = true;
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

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FrsThreadListRequestMessage frsThreadListRequestMessage = new FrsThreadListRequestMessage();
            frsThreadListRequestMessage.setTag(l());
            frsThreadListRequestMessage.setForumId(m().getLong("forum_id"));
            frsThreadListRequestMessage.setThreadIds(H(w()));
            frsThreadListRequestMessage.setNeedAbstract(0);
            String string = m().getString("name");
            if (string == null) {
                string = "";
            }
            frsThreadListRequestMessage.setForumName(string);
            frsThreadListRequestMessage.setPn(r());
            frsThreadListRequestMessage.setSortType(t());
            int i = this.s;
            this.s = i + 1;
            frsThreadListRequestMessage.setRequestTimes(i);
            frsThreadListRequestMessage.setFrsCommonInfo(p());
            frsThreadListRequestMessage.setNewFrs(1);
            frsThreadListRequestMessage.setGood(this.p);
            String g = n27.g(b().a, false);
            Intrinsics.checkNotNullExpressionValue(g, "getAdFloorInfo(feedData.dataList, false)");
            frsThreadListRequestMessage.setAdFloorInfo(g);
            MessageManager.getInstance().sendMessage(frsThreadListRequestMessage);
        }
    }

    @Override // com.baidu.tieba.mb7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || e()) {
            return;
        }
        FrsPageRequestMessage a2 = ck7.a(m());
        a2.setTag(l());
        a2.setSortType(t());
        D(1);
        a2.setPn(r());
        a2.setRn(90);
        a2.setRnNeed(30);
        a2.setGood(this.p);
        a2.setCid(u());
        String g = n27.g(b().a, true);
        Intrinsics.checkNotNullExpressionValue(g, "getAdFloorInfo(feedData.dataList, true)");
        a2.setAdFloorInfo(g);
        MessageManager.getInstance().sendMessage(a2);
        i(true);
        this.q = 0;
        this.r = false;
    }

    @Override // com.baidu.tieba.uj7
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            D(r() + 1);
            FrsPageRequestMessage a2 = ck7.a(m());
            a2.setTag(l());
            a2.setPn(r());
            a2.setRn(90);
            a2.setRnNeed(30);
            a2.setSortType(t());
            a2.setLoadType(2);
            a2.setGood(this.p);
            a2.setCid(u());
            String g = n27.g(b().a, false);
            Intrinsics.checkNotNullExpressionValue(g, "getAdFloorInfo(feedData.dataList, false)");
            a2.setAdFloorInfo(g);
            MessageManager.getInstance().sendMessage(a2);
        }
    }

    @Override // com.baidu.tieba.mb7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.u);
        }
    }

    @Override // com.baidu.tieba.mb7
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || e()) {
            return;
        }
        if (this.q != 2 && !this.r) {
            I();
            this.q++;
        } else {
            z();
            this.q = 0;
            G(CollectionsKt__CollectionsKt.emptyList());
            this.r = false;
        }
        i(true);
    }

    @Override // com.baidu.tieba.uj7
    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.j(i);
            SharedPrefHelper.getInstance().putInt("key_forum_last_sort_type", i);
        }
    }
}

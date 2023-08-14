package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FrsPage.ForumGroup;
import tbclient.FrsPage.GroupFeedCard;
/* loaded from: classes5.dex */
public final class ak7 extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    public static final BdUniqueId d;
    public transient /* synthetic */ FieldHolder $fh;
    public final GroupFeedCard a;
    public final String b;

    @JvmStatic
    public static final void f(ForumGroup forumGroup, List<ym> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, forumGroup, list, str) == null) {
            c.b(forumGroup, list, str);
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        public final BdUniqueId a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (BdUniqueId) invokeV.objValue;
            }
            return ak7.d;
        }

        @JvmStatic
        public final void b(ForumGroup frsForumGroup, List<ym> newList, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsForumGroup, newList, str) == null) {
                Intrinsics.checkNotNullParameter(frsForumGroup, "frsForumGroup");
                Intrinsics.checkNotNullParameter(newList, "newList");
                int i = 0;
                int i2 = 0;
                for (ym ymVar : newList) {
                    Integer num = frsForumGroup.feed_card.index;
                    Intrinsics.checkNotNullExpressionValue(num, "frsForumGroup.feed_card.index");
                    if (i >= num.intValue()) {
                        break;
                    }
                    if (!Intrinsics.areEqual(ymVar.getType(), ThreadData.TYPE_TOP) && !uu5.p(ymVar)) {
                        i++;
                    }
                    i2++;
                }
                if (i2 <= newList.size()) {
                    GroupFeedCard groupFeedCard = frsForumGroup.feed_card;
                    Intrinsics.checkNotNullExpressionValue(groupFeedCard, "frsForumGroup.feed_card");
                    newList.add(i2, new ak7(groupFeedCard, str));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947618140, "Lcom/baidu/tieba/ak7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947618140, "Lcom/baidu/tieba/ak7;");
                return;
            }
        }
        c = new a(null);
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkNotNullExpressionValue(gen, "gen()");
        d = gen;
    }

    public ak7(GroupFeedCard data, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {data, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = data;
        this.b = str;
    }

    public final GroupFeedCard d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (GroupFeedCard) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.ym
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return d;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}

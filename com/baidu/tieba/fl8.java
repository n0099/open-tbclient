package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<b> a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public fl8() {
        this(null, 1, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((List) objArr[0], ((Integer) objArr[1]).intValue(), (DefaultConstructorMarker) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof fl8) && Intrinsics.areEqual(this.a, ((fl8) obj).a);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "ForumSignInConfirmData(forumList=" + this.a + ')';
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public String b;
        public String c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a() {
            this(0L, null, null, 7, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this(((Long) objArr[0]).longValue(), (String) objArr[1], (String) objArr[2], ((Integer) objArr[3]).intValue(), (DefaultConstructorMarker) objArr[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return this.a == aVar.a && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (((com.baidu.tieba.c.a(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return "ChatroomSignInfo(chatroomId=" + this.a + ", jumpScheme=" + this.b + ", guideText=" + this.c + ')';
            }
            return (String) invokeV.objValue;
        }

        public a(long j, String jumpScheme, String guideText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), jumpScheme, guideText};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(jumpScheme, "jumpScheme");
            Intrinsics.checkNotNullParameter(guideText, "guideText");
            this.a = j;
            this.b = jumpScheme;
            this.c = guideText;
        }

        public /* synthetic */ a(long j, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
        }

        public final long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.longValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.c;
            }
            return (String) invokeV.objValue;
        }

        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public final void d(JSONObject json) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, json) == null) {
                Intrinsics.checkNotNullParameter(json, "json");
                this.a = json.optLong("chatroom_id");
                String optString = json.optString("jump_scheme");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"jump_scheme\")");
                this.b = optString;
                String optString2 = json.optString("guide_text");
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"guide_text\")");
                this.c = optString2;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public c b;
        public JSONObject c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b() {
            this(0L, null, null, 7, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this(((Long) objArr[0]).longValue(), (c) objArr[1], (JSONObject) objArr[2], ((Integer) objArr[3]).intValue(), (DefaultConstructorMarker) objArr[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    return this.a == bVar.a && Intrinsics.areEqual(this.b, bVar.b) && Intrinsics.areEqual(this.c, bVar.c);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (((com.baidu.tieba.c.a(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return "ForumItem(id=" + this.a + ", signInInfo=" + this.b + ", originData=" + this.c + ')';
            }
            return (String) invokeV.objValue;
        }

        public b(long j, c signInInfo, JSONObject originData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), signInInfo, originData};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(signInInfo, "signInInfo");
            Intrinsics.checkNotNullParameter(originData, "originData");
            this.a = j;
            this.b = signInInfo;
            this.c = originData;
        }

        public /* synthetic */ b(long j, c cVar, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? new c(null, null, false, 7, null) : cVar, (i & 4) != 0 ? new JSONObject() : jSONObject);
        }

        public final long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.longValue;
        }

        public final c b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return (c) invokeV.objValue;
        }

        public final void c(JSONObject json) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, json) == null) {
                Intrinsics.checkNotNullParameter(json, "json");
                this.c = json;
                this.a = json.optLong("id", 0L);
                JSONObject optJSONObject = json.optJSONObject("sign_in_info");
                if (optJSONObject != null) {
                    this.b.d(optJSONObject);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d a;
        public a b;
        public boolean c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public c() {
            this(null, null, false, 7, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this((d) objArr[0], (a) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Integer) objArr[3]).intValue(), (DefaultConstructorMarker) objArr[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof c) {
                    c cVar = (c) obj;
                    return Intrinsics.areEqual(this.a, cVar.a) && Intrinsics.areEqual(this.b, cVar.b) && this.c == cVar.c;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
                boolean z = this.c;
                int i = z;
                if (z != 0) {
                    i = 1;
                }
                return hashCode + i;
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return "SignInInfo(userInfo=" + this.a + ", chatroomSignInfo=" + this.b + ", hasChatroomSign=" + this.c + ')';
            }
            return (String) invokeV.objValue;
        }

        public c(d userInfo, a chatroomSignInfo, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userInfo, chatroomSignInfo, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            Intrinsics.checkNotNullParameter(chatroomSignInfo, "chatroomSignInfo");
            this.a = userInfo;
            this.b = chatroomSignInfo;
            this.c = z;
        }

        public /* synthetic */ c(d dVar, a aVar, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new d(0, false, 3, null) : dVar, (i & 2) != 0 ? new a(0L, null, null, 7, null) : aVar, (i & 4) != 0 ? false : z);
        }

        public final a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return (a) invokeV.objValue;
        }

        public final boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.c;
            }
            return invokeV.booleanValue;
        }

        public final d c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a;
            }
            return (d) invokeV.objValue;
        }

        public final void d(JSONObject json) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, json) == null) {
                Intrinsics.checkNotNullParameter(json, "json");
                JSONObject optJSONObject = json.optJSONObject(SourceConstant.SOURCE_USER_INFO);
                JSONObject optJSONObject2 = json.optJSONObject("chatroom_sign_info");
                boolean z = false;
                if (json.optInt("has_chatroom_sign", 0) == 1) {
                    z = true;
                }
                this.c = z;
                if (optJSONObject != null) {
                    this.a.c(optJSONObject);
                }
                if (optJSONObject2 != null) {
                    this.b.d(optJSONObject2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public boolean b;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public d() {
            this(0, false, 3, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this(((Integer) objArr[0]).intValue(), ((Boolean) objArr[1]).booleanValue(), ((Integer) objArr[2]).intValue(), (DefaultConstructorMarker) objArr[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof d) {
                    d dVar = (d) obj;
                    return this.a == dVar.a && this.b == dVar.b;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                int i = this.a * 31;
                boolean z = this.b;
                int i2 = z;
                if (z != 0) {
                    i2 = 1;
                }
                return i + i2;
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return "UserInfo(missSignNum=" + this.a + ", isSignInfo=" + this.b + ')';
            }
            return (String) invokeV.objValue;
        }

        public d(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = z;
        }

        public /* synthetic */ d(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z);
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }

        public final boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return invokeV.booleanValue;
        }

        public final void c(JSONObject json) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, json) == null) {
                Intrinsics.checkNotNullParameter(json, "json");
                this.a = json.optInt("miss_sign_num");
                boolean z = true;
                if (json.optInt("is_sign_in") != 1) {
                    z = false;
                }
                this.b = z;
            }
        }
    }

    public fl8(List<b> forumList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(forumList, "forumList");
        this.a = forumList;
    }

    public /* synthetic */ fl8(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    public final List<b> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public final void b(JSONObject json) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            JSONObject optJSONObject = json.optJSONObject("data");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("forum")) != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        b bVar = new b(0L, null, null, 7, null);
                        bVar.c(optJSONObject2);
                        this.a.add(bVar);
                    }
                }
            }
        }
    }
}

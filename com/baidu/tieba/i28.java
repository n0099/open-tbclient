package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class i28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ boolean f;

        public a(ThreadData threadData, long j, String str, String str2, String str3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadData, Long.valueOf(j), str, str2, str3, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadData;
            this.b = j;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageUtils.createAndSendPersonalThreadChatMessage(this.a, this.b, this.c, this.d, this.e, this.f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumData a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ boolean f;

        public b(ForumData forumData, long j, String str, String str2, String str3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumData, Long.valueOf(j), str, str2, str3, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumData;
            this.b = j;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageUtils.createAndSendPersonalForumChatMessage(this.a, this.b, this.c, this.d, this.e, this.f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInfoData a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ boolean f;

        public c(GroupInfoData groupInfoData, long j, String str, String str2, String str3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInfoData, Long.valueOf(j), str, str2, str3, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInfoData;
            this.b = j;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageUtils.createAndSendPersonalGroupChatMessage(this.a, this.b, this.c, this.d, this.e, this.f);
            }
        }
    }

    public static void a(@Nullable ForumData forumData, @Nullable String str, long j, String str2, String str3, String str4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{forumData, str, Long.valueOf(j), str2, str3, str4, Boolean.valueOf(z)}) == null) {
            if (TextUtils.isEmpty(str)) {
                MessageUtils.createAndSendPersonalForumChatMessage(forumData, j, str2, str3, str4, z);
                return;
            }
            MessageUtils.createAndSendPersonalTextChatMessage(str, j, str2, str3, str4, z);
            jg.a().postDelayed(new b(forumData, j, str2, str3, str4, z), 500L);
        }
    }

    public static void b(@Nullable GroupInfoData groupInfoData, @Nullable String str, long j, String str2, String str3, String str4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{groupInfoData, str, Long.valueOf(j), str2, str3, str4, Boolean.valueOf(z)}) == null) {
            if (TextUtils.isEmpty(str)) {
                MessageUtils.createAndSendPersonalGroupChatMessage(groupInfoData, j, str2, str3, str4, z);
                return;
            }
            MessageUtils.createAndSendPersonalTextChatMessage(str, j, str2, str3, str4, z);
            jg.a().postDelayed(new c(groupInfoData, j, str2, str3, str4, z), 500L);
        }
    }

    public static void c(@Nullable ThreadData threadData, @Nullable String str, long j, String str2, String str3, String str4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{threadData, str, Long.valueOf(j), str2, str3, str4, Boolean.valueOf(z)}) == null) {
            if (TextUtils.isEmpty(str)) {
                MessageUtils.createAndSendPersonalThreadChatMessage(threadData, j, str2, str3, str4, z);
                return;
            }
            MessageUtils.createAndSendPersonalTextChatMessage(str, j, str2, str3, str4, z);
            jg.a().postDelayed(new a(threadData, j, str2, str3, str4, z), 500L);
        }
    }

    public static void d(String str, int i, ThreadData threadData, ForumData forumData, GroupInfoData groupInfoData, GroupInfoData groupInfoData2) {
        String str2;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), threadData, forumData, groupInfoData, groupInfoData2}) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_SHARE_CONTENT_TO_CHAT_GROUP);
            String str3 = "";
            if (threadData == null) {
                str2 = "";
            } else {
                str2 = threadData.getId();
            }
            httpMessage.addParam("thread_id", str2);
            if (forumData != null) {
                str3 = forumData.getId();
            }
            httpMessage.addParam("fid", str3);
            httpMessage.addParam(GroupInfoData.SHARE_KEY_TYPE, i);
            if (groupInfoData2 != null) {
                j = groupInfoData2.getGroupId();
            } else {
                j = 0;
            }
            httpMessage.addParam("chatroom_id", j);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void e(String str, @Nullable GroupInfoData groupInfoData, @NonNull ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, groupInfoData, forumData) == null) {
            d(str, 2, null, forumData, null, groupInfoData);
        }
    }

    public static void f(String str, GroupInfoData groupInfoData, @NonNull GroupInfoData groupInfoData2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, str, groupInfoData, groupInfoData2) == null) {
            d(str, 3, null, null, groupInfoData2, groupInfoData);
        }
    }

    public static void g(String str, GroupInfoData groupInfoData, @NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, groupInfoData, threadData) == null) {
            ForumData forumData = new ForumData();
            if (threadData.getForumData() != null) {
                forumData.setId(threadData.getForumData().a);
                forumData.setName(threadData.getForumData().b);
            }
            if (TextUtils.isEmpty(forumData.getId())) {
                forumData.setId(threadData.getFid() + "");
            }
            if (TextUtils.isEmpty(forumData.getName())) {
                forumData.setName(threadData.getForum_name());
            }
            d(str, 1, threadData, forumData, null, groupInfoData);
        }
    }
}

package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.CookieHelper;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.ShareIMCommonCardData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class fp8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
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

    /* loaded from: classes5.dex */
    public class b implements Runnable {
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

    /* loaded from: classes5.dex */
    public class c implements Runnable {
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

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareIMCommonCardData a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ boolean f;

        public d(ShareIMCommonCardData shareIMCommonCardData, long j, String str, String str2, String str3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareIMCommonCardData, Long.valueOf(j), str, str2, str3, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareIMCommonCardData;
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
                MessageUtils.createAndSendPersonalCommonCardChatMessage(this.a, this.b, this.c, this.d, this.e, this.f);
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
            SafeHandler.getInst().postDelayed(new b(forumData, j, str2, str3, str4, z), 500L);
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
            SafeHandler.getInst().postDelayed(new c(groupInfoData, j, str2, str3, str4, z), 500L);
        }
    }

    public static void c(@Nullable ShareIMCommonCardData shareIMCommonCardData, @Nullable String str, long j, String str2, String str3, String str4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{shareIMCommonCardData, str, Long.valueOf(j), str2, str3, str4, Boolean.valueOf(z)}) == null) {
            if (TextUtils.isEmpty(str)) {
                MessageUtils.createAndSendPersonalCommonCardChatMessage(shareIMCommonCardData, j, str2, str3, str4, z);
                return;
            }
            MessageUtils.createAndSendPersonalTextChatMessage(str, j, str2, str3, str4, z);
            SafeHandler.getInst().postDelayed(new d(shareIMCommonCardData, j, str2, str3, str4, z), 500L);
        }
    }

    public static void d(@Nullable ThreadData threadData, @Nullable String str, long j, String str2, String str3, String str4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{threadData, str, Long.valueOf(j), str2, str3, str4, Boolean.valueOf(z)}) == null) {
            if (TextUtils.isEmpty(str)) {
                MessageUtils.createAndSendPersonalThreadChatMessage(threadData, j, str2, str3, str4, z);
                return;
            }
            MessageUtils.createAndSendPersonalTextChatMessage(str, j, str2, str3, str4, z);
            SafeHandler.getInst().postDelayed(new a(threadData, j, str2, str3, str4, z), 500L);
        }
    }

    public static void e(String str, GroupInfoData groupInfoData, @Nullable ShareIMCommonCardData shareIMCommonCardData) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, groupInfoData, shareIMCommonCardData) == null) {
            if (shareIMCommonCardData != null) {
                int shareType = shareIMCommonCardData.getShareType();
                if (shareType != 1) {
                    if (shareType != 2) {
                        if (shareType == 3) {
                            i = 6;
                        }
                    } else {
                        i = 5;
                    }
                } else {
                    i = 4;
                }
                g(str, i, null, null, shareIMCommonCardData, null, groupInfoData);
            }
            i = Integer.MAX_VALUE;
            g(str, i, null, null, shareIMCommonCardData, null, groupInfoData);
        }
    }

    public static void f(String str, int i, ThreadData threadData, ForumData forumData, GroupInfoData groupInfoData, GroupInfoData groupInfoData2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, Integer.valueOf(i), threadData, forumData, groupInfoData, groupInfoData2}) == null) {
            g(str, i, threadData, forumData, null, groupInfoData, groupInfoData2);
        }
    }

    public static void g(String str, int i, ThreadData threadData, ForumData forumData, @Nullable ShareIMCommonCardData shareIMCommonCardData, GroupInfoData groupInfoData, GroupInfoData groupInfoData2) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{str, Integer.valueOf(i), threadData, forumData, shareIMCommonCardData, groupInfoData, groupInfoData2}) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_SHARE_CONTENT_TO_CHAT_GROUP);
            String str8 = "";
            if (threadData == null) {
                str2 = "";
            } else {
                str2 = threadData.getId();
            }
            httpMessage.addParam("thread_id", str2);
            if (forumData == null) {
                str3 = "";
            } else {
                str3 = forumData.getId();
            }
            httpMessage.addParam("fid", str3);
            httpMessage.addParam(GroupInfoData.SHARE_KEY_TYPE, i);
            if (shareIMCommonCardData == null) {
                str4 = "";
            } else {
                str4 = shareIMCommonCardData.getJumpLink();
            }
            httpMessage.addParam("schema", str4);
            if (!ShareIMCommonCardData.isValidAlbum(shareIMCommonCardData)) {
                str5 = "";
            } else {
                str5 = shareIMCommonCardData.getId();
            }
            httpMessage.addParam(GroupInfoData.SHARE_KEY_ALBUM_ID, str5);
            if (!ShareIMCommonCardData.isValidTopic(shareIMCommonCardData)) {
                str6 = "";
            } else {
                str6 = shareIMCommonCardData.getId();
            }
            httpMessage.addParam("topic_id", str6);
            if (!ShareIMCommonCardData.isValidTopic(shareIMCommonCardData)) {
                str7 = "";
            } else {
                str7 = shareIMCommonCardData.getTagName();
            }
            httpMessage.addParam("topic_name", str7);
            if (ShareIMCommonCardData.isValidActive(shareIMCommonCardData)) {
                str8 = shareIMCommonCardData.getId();
            }
            httpMessage.addParam("scene_id", str8);
            long j2 = 0;
            if (groupInfoData != null) {
                j = groupInfoData.getGroupId();
            } else {
                j = 0;
            }
            httpMessage.addParam(GroupInfoData.SHARE_KEY_FROM_GROUP_ID, j);
            if (groupInfoData2 != null) {
                j2 = groupInfoData2.getGroupId();
            }
            httpMessage.addParam("chatroom_id", j2);
            Map<String, String> b2 = CookieHelper.b();
            if (!qn6.b(b2)) {
                for (Map.Entry<String, String> entry : b2.entrySet()) {
                    if (entry != null) {
                        httpMessage.addCookie(entry.getKey(), entry.getValue());
                    }
                }
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void h(String str, @Nullable GroupInfoData groupInfoData, @NonNull ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, groupInfoData, forumData) == null) {
            f(str, 2, null, forumData, null, groupInfoData);
        }
    }

    public static void i(String str, GroupInfoData groupInfoData, @NonNull GroupInfoData groupInfoData2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, groupInfoData, groupInfoData2) == null) {
            f(str, 3, null, null, groupInfoData2, groupInfoData);
        }
    }

    public static void j(String str, GroupInfoData groupInfoData, @NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, str, groupInfoData, threadData) == null) {
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
            f(str, 1, threadData, forumData, null, groupInfoData);
        }
    }
}

package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.imMessageCenter.chatgroup.data.ChatGroupInfo;
import com.baidu.tieba.imMessageCenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.imMessageCenter.chatgroup.message.ChatGroupListResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ek7 extends ck7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b i;
    public boolean j;
    public final HttpMessageListener k;

    /* loaded from: classes4.dex */
    public interface b {
        void a(List list, int i);
    }

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ek7 ek7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ek7Var, Integer.valueOf(i)};
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
            this.a = ek7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if ((httpResponsedMessage instanceof ChatGroupListResponseMessage) && httpResponsedMessage.getCmd() == 1003552) {
                    List data = ((ChatGroupListResponseMessage) httpResponsedMessage).getData();
                    if (this.a.j) {
                        this.a.t(data);
                    }
                    if (this.a.i != null) {
                        this.a.i.a(data, httpResponsedMessage.getError());
                    }
                } else if (this.a.i != null) {
                    this.a.i.a(null, -1);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ek7(@NonNull Context context, b bVar) {
        this(context, bVar, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (b) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ek7(@NonNull Context context, b bVar, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = false;
        this.k = new a(this, CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST);
        this.i = bVar;
        this.j = z;
        u();
        MessageManager.getInstance().registerListener(this.k);
    }

    @Override // com.baidu.tieba.ck7
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.j();
            MessageManager.getInstance().unRegisterListener(this.k);
        }
    }

    public final void t(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        List<ChatRoomInfo> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof ChatGroupInfo) {
                List<ChatRoomInfo> roomInfoList = ((ChatGroupInfo) obj).getRoomInfoList();
                if (!ListUtils.isEmpty(roomInfoList)) {
                    arrayList.addAll(roomInfoList);
                }
            }
        }
        i(arrayList);
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST, TbConfig.SERVER_ADDRESS + TbConfig.GET_CHAT_GROUP_ROOM_LIST);
            tbHttpMessageTask.setResponsedClass(ChatGroupListResponseMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public void v(@Nullable List<Long> list, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, list, str, str2) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST);
            List<ChatRoomInfo> g = g(str, str2);
            if (!ListUtils.isEmpty(list)) {
                String o = o(g, list);
                if (!TextUtils.isEmpty(o)) {
                    httpMessage.addParam("chatroom_new_msg", o);
                }
            }
            httpMessage.addParam("fid", str2);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}

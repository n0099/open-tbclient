package com.baidu.tieba.im.model;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.a28;
import com.baidu.tieba.a9;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedActivity;
import com.baidu.tieba.im.forum.broadcast.data.BroadcastMajorHistoryRequestMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseHttpMajorHistoryMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseSocketMajorHistoryMessage;
import com.baidu.tieba.im.message.LoadOfficialHistoryMessage;
import com.baidu.tieba.im.message.OfficialFeedHeadResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.l18;
import com.baidu.tieba.n18;
import com.baidu.tieba.o18;
import com.baidu.tieba.xo9;
import com.baidu.tieba.z18;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class OfficialBarFeedMsglistModel extends BdBaseModel<OfficialBarFeedActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_FEED_ITEM_COUNT = 80;
    public transient /* synthetic */ FieldHolder $fh;
    public IFeedHeadLoadCallback callback;
    public CustomMessageListener mCustomMessageListener;
    public za netMessageListener;

    /* loaded from: classes4.dex */
    public interface IFeedHeadLoadCallback {
        void onListDataLoad(List<a28> list, List<l18> list2);

        void onReadCountLoad(LongSparseArray<o18> longSparseArray);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    @Deprecated
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficialBarFeedMsglistModel(TbPageContext<OfficialBarFeedActivity> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.callback = null;
        this.mCustomMessageListener = new CustomMessageListener(this, 2001154) { // from class: com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ OfficialBarFeedMsglistModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001154) {
                    this.this$0.processHeadBarInfo(customResponsedMessage);
                }
            }
        };
        this.netMessageListener = new za(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, 309669) { // from class: com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ OfficialBarFeedMsglistModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r9), Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr3 = newInitContext2.callArgs;
                        super(((Integer) objArr3[0]).intValue(), ((Integer) objArr3[1]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.tieba.za
            @RequiresApi(api = 16)
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                n18 n18Var;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                    return;
                }
                LongSparseArray<o18> longSparseArray = null;
                if (responsedMessage instanceof ResponseHttpMajorHistoryMessage) {
                    n18Var = ((ResponseHttpMajorHistoryMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof ResponseSocketMajorHistoryMessage) {
                    n18Var = ((ResponseSocketMajorHistoryMessage) responsedMessage).getData();
                } else {
                    n18Var = null;
                }
                if (n18Var == null) {
                    return;
                }
                List<o18> b = n18Var.b();
                if (b != null && b.size() > 0) {
                    longSparseArray = new LongSparseArray<>(b.size());
                    for (o18 o18Var : b) {
                        longSparseArray.put(o18Var.b(), o18Var);
                    }
                }
                if (this.this$0.callback != null && longSparseArray != null) {
                    this.this$0.callback.onReadCountLoad(longSparseArray);
                }
            }
        };
        registerListener();
        registerTask();
    }

    private void sendReadCountMessage(List<a28> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, this, list) == null) && list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList(list.size());
            for (a28 a28Var : list) {
                if (a28Var.f()) {
                    arrayList.add(Long.valueOf(a28Var.d().h));
                }
            }
            BroadcastMajorHistoryRequestMessage broadcastMajorHistoryRequestMessage = new BroadcastMajorHistoryRequestMessage();
            broadcastMajorHistoryRequestMessage.queryType = 2;
            broadcastMajorHistoryRequestMessage.bcastIds = arrayList;
            sendMessage(broadcastMajorHistoryRequestMessage);
        }
    }

    public void setHeadLoadCallback(IFeedHeadLoadCallback iFeedHeadLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iFeedHeadLoadCallback) == null) {
            this.callback = iFeedHeadLoadCallback;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processHeadBarInfo(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage instanceof OfficialFeedHeadResponsedMessage)) {
            return;
        }
        OfficialFeedHeadResponsedMessage officialFeedHeadResponsedMessage = (OfficialFeedHeadResponsedMessage) customResponsedMessage;
        if (officialFeedHeadResponsedMessage.getData() == null) {
            return;
        }
        List<ChatMessage> list = officialFeedHeadResponsedMessage.getData().b;
        ArrayList arrayList = new ArrayList();
        loop0: for (ChatMessage chatMessage : list) {
            List<z18.a> b = z18.b(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
            if (b != null && b.size() > 0 && (chatMessage instanceof OfficialChatMessage)) {
                for (int i = 0; i < b.size(); i++) {
                    if (arrayList.size() >= 80) {
                        break loop0;
                    }
                    z18.a aVar = b.get(i);
                    a28 a = a28.a(chatMessage, aVar);
                    if (i == 0 && !StringUtils.isNull(aVar.c)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a.h(z);
                    arrayList.add(a);
                }
                continue;
            }
        }
        sendReadCountMessage(arrayList);
        IFeedHeadLoadCallback iFeedHeadLoadCallback = this.callback;
        if (iFeedHeadLoadCallback != null) {
            iFeedHeadLoadCallback.onListDataLoad(arrayList, officialFeedHeadResponsedMessage.getData().a);
        }
    }

    private void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            registerListener(this.mCustomMessageListener);
            registerListener(this.netMessageListener);
        }
    }

    private void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            xo9.h(309669, ResponseSocketMajorHistoryMessage.class, false, false);
            xo9.c(309669, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, TbConfig.URL_FORUM_BROADCAST_HISTORY, ResponseHttpMajorHistoryMessage.class, true, false, true, false);
        }
    }

    private void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mCustomMessageListener);
            MessageManager.getInstance().unRegisterListener(this.netMessageListener);
        }
    }

    private void unRegisterTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            MessageManager.getInstance().unRegisterTask(309669);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cancelMessage();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            cancelMessage();
            unRegisterListener();
            unRegisterTask();
        }
    }

    public void LoadData(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (!z) {
                LinkedList<CustomMessage<?>> findCustomMessage = MessageManager.getInstance().findCustomMessage(getUniqueId());
                if (findCustomMessage == null || findCustomMessage.size() <= 0) {
                    super.sendMessage(new LoadOfficialHistoryMessage(2001154, null));
                    return;
                }
                return;
            }
            super.sendMessage(new LoadOfficialHistoryMessage(2001154, null));
        }
    }
}

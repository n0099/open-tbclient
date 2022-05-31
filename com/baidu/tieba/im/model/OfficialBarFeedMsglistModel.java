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
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedActivity;
import com.baidu.tieba.im.forum.broadcast.data.BroadcastMajorHistoryRequestMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseHttpMajorHistoryMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseSocketMajorHistoryMessage;
import com.baidu.tieba.im.message.LoadOfficialHistoryMessage;
import com.baidu.tieba.im.message.OfficialFeedHeadResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.h47;
import com.repackage.ig8;
import com.repackage.j47;
import com.repackage.k47;
import com.repackage.u47;
import com.repackage.v47;
import com.repackage.wa;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarFeedMsglistModel extends BdBaseModel<OfficialBarFeedActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_FEED_ITEM_COUNT = 80;
    public transient /* synthetic */ FieldHolder $fh;
    public IFeedHeadLoadCallback callback;
    public CustomMessageListener mCustomMessageListener;
    public wa netMessageListener;

    /* loaded from: classes3.dex */
    public interface IFeedHeadLoadCallback {
        void onListDataLoad(List<v47> list, List<h47> list2);

        void onReadCountLoad(LongSparseArray<k47> longSparseArray);
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
                super((b9) newInitContext.callArgs[0]);
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
        this.netMessageListener = new wa(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, 309669) { // from class: com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.2
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

            @Override // com.repackage.wa
            @RequiresApi(api = 16)
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                j47 data;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                    return;
                }
                LongSparseArray<k47> longSparseArray = null;
                if (responsedMessage instanceof ResponseHttpMajorHistoryMessage) {
                    data = ((ResponseHttpMajorHistoryMessage) responsedMessage).getData();
                } else {
                    data = responsedMessage instanceof ResponseSocketMajorHistoryMessage ? ((ResponseSocketMajorHistoryMessage) responsedMessage).getData() : null;
                }
                if (data == null) {
                    return;
                }
                List<k47> b = data.b();
                if (b != null && b.size() > 0) {
                    longSparseArray = new LongSparseArray<>(b.size());
                    for (k47 k47Var : b) {
                        longSparseArray.put(k47Var.b(), k47Var);
                    }
                }
                if (this.this$0.callback == null || longSparseArray == null) {
                    return;
                }
                this.this$0.callback.onReadCountLoad(longSparseArray);
            }
        };
        registerListener();
        registerTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processHeadBarInfo(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof OfficialFeedHeadResponsedMessage)) {
            OfficialFeedHeadResponsedMessage officialFeedHeadResponsedMessage = (OfficialFeedHeadResponsedMessage) customResponsedMessage;
            if (officialFeedHeadResponsedMessage.getData() == null) {
                return;
            }
            List<ChatMessage> list = officialFeedHeadResponsedMessage.getData().b;
            ArrayList arrayList = new ArrayList();
            loop0: for (ChatMessage chatMessage : list) {
                List<u47.a> b = u47.b(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                if (b != null && b.size() > 0 && (chatMessage instanceof OfficialChatMessage)) {
                    int i = 0;
                    while (i < b.size()) {
                        if (arrayList.size() >= 80) {
                            break loop0;
                        }
                        u47.a aVar = b.get(i);
                        v47 a = v47.a(chatMessage, aVar);
                        a.i(i == 0 && !StringUtils.isNull(aVar.c));
                        arrayList.add(a);
                        i++;
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
            ig8.h(309669, ResponseSocketMajorHistoryMessage.class, false, false);
            ig8.c(309669, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, TbConfig.URL_FORUM_BROADCAST_HISTORY, ResponseHttpMajorHistoryMessage.class, true, false, true, false);
        }
    }

    private void sendReadCountMessage(List<v47> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (v47 v47Var : list) {
            if (v47Var.g()) {
                arrayList.add(Long.valueOf(v47Var.d().h));
            }
        }
        BroadcastMajorHistoryRequestMessage broadcastMajorHistoryRequestMessage = new BroadcastMajorHistoryRequestMessage();
        broadcastMajorHistoryRequestMessage.queryType = 2;
        broadcastMajorHistoryRequestMessage.bcastIds = arrayList;
        sendMessage(broadcastMajorHistoryRequestMessage);
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

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            cancelMessage();
            unRegisterListener();
            unRegisterTask();
        }
    }

    public void setHeadLoadCallback(IFeedHeadLoadCallback iFeedHeadLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iFeedHeadLoadCallback) == null) {
            this.callback = iFeedHeadLoadCallback;
        }
    }
}

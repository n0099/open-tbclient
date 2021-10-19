package com.baidu.tieba.flutter.plugin.tiebautility.android;

import android.text.TextUtils;
import c.a.e.e.p.k;
import c.a.r0.a3.a;
import c.a.r0.l1.t.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityMessageAuto;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class UtilityMessage implements TiebaUtilityMessageAuto.HostUtilityMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UtilityMessage() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityMessageAuto.HostUtilityMessage
    public void clearNewMessage(TiebaUtilityMessageAuto.MessageStringParam messageStringParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, messageStringParam) == null) {
            String result = messageStringParam.getResult();
            if (StringUtils.isNull(result)) {
                return;
            }
            if ("bookmarkNum".equals(result)) {
                a.v().L(3, false, true);
            } else if ("fansNum".equals(result)) {
                a.v().L(2, false, true);
            } else if ("giftNum".equals(result)) {
                a.v().L(1, false, true);
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityMessageAuto.HostUtilityMessage
    public void delAllMsgInForumUser(TiebaUtilityMessageAuto.MessageStringParam messageStringParam) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, messageStringParam) == null) || k.isEmpty(messageStringParam.getResult())) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(messageStringParam.getResult(), 4, null, 1)));
        MessageManager.getInstance().sendMessage(new CustomMessage(2001151, messageStringParam.getResult()));
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityMessageAuto.HostUtilityMessage
    public void getIsOfficalForumLetterReminderOpen(TiebaUtilityMessageAuto.MessageStringParam messageStringParam, TiebaUtilityMessageAuto.Result<TiebaUtilityMessageAuto.MessageBoolResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, messageStringParam, result) == null) {
            TiebaUtilityMessageAuto.MessageBoolResult messageBoolResult = new TiebaUtilityMessageAuto.MessageBoolResult();
            OfficialSettingItemData a2 = d.j().a(TbadkCoreApplication.getCurrentAccount(), messageStringParam.getResult());
            if (a2 != null) {
                messageBoolResult.setResult(Boolean.valueOf(a2.isAcceptNotify()));
            } else {
                messageBoolResult.setResult(Boolean.TRUE);
            }
            result.success(messageBoolResult);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityMessageAuto.HostUtilityMessage
    public void readNewMessage(TiebaUtilityMessageAuto.Result<TiebaUtilityMessageAuto.NewMessage> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bookmarkNum", Integer.valueOf(a.v().A() ? 1 : 0));
            hashMap.put("fansNum", Integer.valueOf(a.v().B() ? 1 : 0));
            TiebaUtilityMessageAuto.NewMessage newMessage = new TiebaUtilityMessageAuto.NewMessage();
            newMessage.setResult(hashMap);
            result.success(newMessage);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityMessageAuto.HostUtilityMessage
    public void readVipCenterNewMessage(TiebaUtilityMessageAuto.Result<TiebaUtilityMessageAuto.MessageBoolResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, result) == null) {
            TiebaUtilityMessageAuto.MessageBoolResult messageBoolResult = new TiebaUtilityMessageAuto.MessageBoolResult();
            messageBoolResult.setResult(Boolean.valueOf(a.v().C()));
            result.success(messageBoolResult);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityMessageAuto.HostUtilityMessage
    public void resetFansNumCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityMessageAuto.HostUtilityMessage
    public void setOfficalForumLetterReminderOpen(TiebaUtilityMessageAuto.SetForumBroadcastParam setForumBroadcastParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, setForumBroadcastParam) == null) {
            new BdAsyncTask<Void, Void, Void>(this, setForumBroadcastParam.getForumId(), setForumBroadcastParam.getOpen().booleanValue()) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.UtilityMessage.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UtilityMessage this$0;
                public final /* synthetic */ String val$forumId;
                public final /* synthetic */ boolean val$open;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, Boolean.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$forumId = r7;
                    this.val$open = r8;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                        if (TextUtils.isEmpty(this.val$forumId)) {
                            return null;
                        }
                        d.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.val$forumId), this.val$open);
                        return null;
                    }
                    return (Void) invokeL.objValue;
                }
            }.execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }
}

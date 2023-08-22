package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.SocketMessageListener;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.searchbox.live.game.interfaces.GameService;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class i69 implements GameService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> a;
    public SocketMessageListener b;

    /* loaded from: classes6.dex */
    public class a extends SocketMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameService.MsgSendListener a;
        public final /* synthetic */ i69 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i69 i69Var, int i, GameService.MsgSendListener msgSendListener) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i69Var, Integer.valueOf(i), msgSendListener};
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
            this.b = i69Var;
            this.a = msgSendListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: g */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, socketResponsedMessage) != null) || !(socketResponsedMessage instanceof ResponseCommitPersonalMessage)) {
                return;
            }
            ChatMessage chatMessage = (ChatMessage) ((ResponseCommitPersonalMessage) socketResponsedMessage).getOrginalMessage();
            if (chatMessage instanceof PersonalChatMessage) {
                String valueOf = String.valueOf(chatMessage.getRecordId());
                if (this.b.a.containsKey(valueOf)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("msg_id", this.b.a.get(valueOf));
                    if (socketResponsedMessage.hasError()) {
                        this.a.onFailed(hashMap);
                    } else {
                        this.a.onSuccess(hashMap);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements SapiCallback<CheckUserFaceIdResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameService.GameAuthCallback a;
        public final /* synthetic */ i69 b;

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        public b(i69 i69Var, GameService.GameAuthCallback gameAuthCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i69Var, gameAuthCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i69Var;
            this.a = gameAuthCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(CheckUserFaceIdResult checkUserFaceIdResult) {
            GameService.GameAuthCallback gameAuthCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, checkUserFaceIdResult) == null) && (gameAuthCallback = this.a) != null) {
                gameAuthCallback.onFail(checkUserFaceIdResult.getResultCode(), checkUserFaceIdResult.getResultMsg());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(CheckUserFaceIdResult checkUserFaceIdResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, checkUserFaceIdResult) == null) {
                if (!"advanced_cert_face_match".equals(checkUserFaceIdResult.action) && !"cert_face_match".equals(checkUserFaceIdResult.action)) {
                    this.b.c(this.a);
                    return;
                }
                GameService.GameAuthCallback gameAuthCallback = this.a;
                if (gameAuthCallback != null) {
                    gameAuthCallback.onSuccess();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends AccountRealNameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameService.GameAuthCallback a;

        public c(i69 i69Var, GameService.GameAuthCallback gameAuthCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i69Var, gameAuthCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameAuthCallback;
        }

        @Override // com.baidu.sapi2.callback.AccountRealNameCallback
        public void onFinish(AccountRealNameResult accountRealNameResult) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, accountRealNameResult) == null) {
                super.onFinish(accountRealNameResult);
                if (accountRealNameResult.getResultCode() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    GameService.GameAuthCallback gameAuthCallback = this.a;
                    if (gameAuthCallback != null) {
                        gameAuthCallback.onSuccess();
                        return;
                    }
                    return;
                }
                GameService.GameAuthCallback gameAuthCallback2 = this.a;
                if (gameAuthCallback2 != null) {
                    gameAuthCallback2.onFail(accountRealNameResult.getResultCode(), accountRealNameResult.getResultMsg());
                }
            }
        }
    }

    public i69() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
    }

    @Override // com.baidu.searchbox.live.game.interfaces.GameService
    public void clearCachedHostMsgSendAPI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.clear();
        }
    }

    @Override // com.baidu.searchbox.live.game.interfaces.GameService
    public void releaseHostMsgSendAPI() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.b != null) {
            MessageManager.getInstance().unRegisterListener(this.b);
            this.b = null;
        }
    }

    @Override // com.baidu.searchbox.live.game.interfaces.GameService
    public void initHostMsgSendAPI(@Nullable GameService.MsgSendListener msgSendListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, msgSendListener) != null) || msgSendListener == null) {
            return;
        }
        if (this.b == null) {
            this.b = new a(this, 0, msgSendListener);
        }
        MessageManager.getInstance().registerListener(205001, this.b);
    }

    public final void c(@Nullable GameService.GameAuthCallback gameAuthCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gameAuthCallback) == null) {
            if (SapiAccountManager.getInstance().getSapiConfiguration() == null) {
                if (gameAuthCallback != null) {
                    gameAuthCallback.onFail(-1, "pass没有初始化");
                    return;
                }
                return;
            }
            RealNameDTO realNameDTO = new RealNameDTO();
            realNameDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
            realNameDTO.scene = "baidugame";
            realNameDTO.needCbKey = true;
            PassportSDK.getInstance().loadAccountRealName(TbadkCoreApplication.getInst().getContext(), new c(this, gameAuthCallback), realNameDTO);
        }
    }

    @Override // com.baidu.searchbox.live.game.interfaces.GameService
    public void callHostMsgSendAPI(@Nullable Map<String, String> map) {
        long parseLong;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) && map != null && !map.isEmpty()) {
            String str = map.get("msg_id");
            String str2 = map.get("msg_content");
            String str3 = map.get("receiver_id");
            String str4 = map.get("receiver_name");
            String str5 = map.get("receiver_avatar");
            String str6 = map.get(DI.FOLLOW_STATUS);
            try {
                if (TextUtils.isEmpty(str3)) {
                    parseLong = -1;
                } else {
                    parseLong = Long.parseLong(str3);
                }
                boolean equalsIgnoreCase = "1".equalsIgnoreCase(str6);
                if (parseLong > -1) {
                    this.a.put(String.valueOf(MessageUtils.createAndSendPersonalText(str2, parseLong, str4, str4, str5, equalsIgnoreCase)), str);
                }
            } catch (NumberFormatException unused) {
                if (BdBaseApplication.getInst().isDebugMode()) {
                    BdLog.e("NumberFormatException: parse long");
                }
            }
        }
    }

    @Override // com.baidu.searchbox.live.game.interfaces.GameService
    public void dispatchYYLiveRouter(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) && str != null && context != null) {
            try {
                m39.c(context, "bdtiebalive://video/yylive/router?url=" + URLEncoder.encode(str, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.live.game.interfaces.GameService
    public void logTiebaStatic(@NonNull String str, @NonNull Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, str, map) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                statisticItem.addParam(str2, map.get(str2));
            }
        }
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.searchbox.live.game.interfaces.GameService
    public void doAuth(@NonNull Map<String, String> map, @Nullable GameService.GameAuthCallback gameAuthCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, map, gameAuthCallback) == null) {
            if (SapiAccountManager.getInstance().getSapiConfiguration() == null) {
                if (gameAuthCallback != null) {
                    gameAuthCallback.onFail(-1, "pass没有初始化");
                    return;
                }
                return;
            }
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            HashMap hashMap = new HashMap();
            hashMap.put("scene", "baidugame");
            SapiAccountManager.getInstance().getAccountService().checkUserFaceId(new b(this, gameAuthCallback), session.bduss, hashMap);
        }
    }
}

package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.game.GameShareJsBridge;
import com.baidu.tbadk.game.RequestGameDetailMessage;
import com.baidu.tbadk.game.ResponseGameDetailMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d95 {
    public static /* synthetic */ Interceptable $ic;
    public static d95 d;
    public transient /* synthetic */ FieldHolder $fh;
    public GameInfoData a;
    public String b;
    public final sb c;

    /* loaded from: classes3.dex */
    public class a implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d95 a;

        public a(d95 d95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d95Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(2001261, this.a.e());
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends sb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d95 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d95 d95Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d95Var, Integer.valueOf(i)};
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
            this.a = d95Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseGameDetailMessage) && !socketResponsedMessage.hasError()) {
                ResponseGameDetailMessage responseGameDetailMessage = (ResponseGameDetailMessage) socketResponsedMessage;
                if (!(responseGameDetailMessage.getOrginalMessage() instanceof RequestGameDetailMessage)) {
                    return;
                }
                this.a.a = GameInfoData.fromGameInfo(responseGameDetailMessage.getGameInfo());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947659401, "Lcom/baidu/tieba/d95;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947659401, "Lcom/baidu/tieba/d95;");
                return;
            }
        }
        d = new d95();
    }

    public static d95 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return d;
        }
        return (d95) invokeV.objValue;
    }

    public GameInfoData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            GameInfoData gameInfoData = this.a;
            if (gameInfoData == null) {
                return b();
            }
            return gameInfoData;
        }
        return (GameInfoData) invokeV.objValue;
    }

    public d95() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new b(this, 303009);
        MessageManager.getInstance().registerListener(this.c);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001261, new a(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public final GameInfoData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GameInfoData gameInfoData = new GameInfoData();
            gameInfoData.setGameName(TbadkApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f04aa));
            gameInfoData.setGameLink(this.b);
            gameInfoData.setGameId("default");
            gameInfoData.setIconUrl("default");
            gameInfoData.setIntroduce(TbadkApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f04a9));
            return gameInfoData;
        }
        return (GameInfoData) invokeV.objValue;
    }

    public ShareFromGameCenterMsgData e() {
        InterceptResult invokeV;
        String shareTitle;
        String shareContent;
        String shareImage;
        String shareName;
        String iconUrl;
        String gameId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            GameInfoData c = c();
            ShareFromGameCenterMsgData shareFromGameCenterMsgData = new ShareFromGameCenterMsgData();
            if (StringUtils.isNull(GameShareJsBridge.getInstance().getShareTitle(), true)) {
                shareTitle = c.getGameName();
            } else {
                shareTitle = GameShareJsBridge.getInstance().getShareTitle();
            }
            shareFromGameCenterMsgData.setTitle(shareTitle);
            if (StringUtils.isNull(GameShareJsBridge.getInstance().getShareContent(), true)) {
                shareContent = c.getIntroduce();
            } else {
                shareContent = GameShareJsBridge.getInstance().getShareContent();
            }
            shareFromGameCenterMsgData.setContent(shareContent);
            if (StringUtils.isNull(GameShareJsBridge.getInstance().getShareImage(), true)) {
                shareImage = c.getIconUrl();
            } else {
                shareImage = GameShareJsBridge.getInstance().getShareImage();
            }
            shareFromGameCenterMsgData.setImageUrl(shareImage);
            if (StringUtils.isNull(GameShareJsBridge.getInstance().getShareName(), true)) {
                shareName = c.getGameName();
            } else {
                shareName = GameShareJsBridge.getInstance().getShareName();
            }
            shareFromGameCenterMsgData.setShareSource(shareName);
            if (StringUtils.isNull(GameShareJsBridge.getInstance().getIconUrl(), true)) {
                iconUrl = c.getIconUrl();
            } else {
                iconUrl = GameShareJsBridge.getInstance().getIconUrl();
            }
            shareFromGameCenterMsgData.setShareSourceIcon(iconUrl);
            if (StringUtils.isNull(GameShareJsBridge.getInstance().getGameId(), true)) {
                gameId = c.getGameId();
            } else {
                gameId = GameShareJsBridge.getInstance().getGameId();
            }
            if ("default".equals(gameId)) {
                shareFromGameCenterMsgData.setShareSourceUrl(gameId);
            } else {
                shareFromGameCenterMsgData.setShareSourceUrl("game:detail:TBCGameID=" + gameId);
            }
            String shareContentUrl = GameShareJsBridge.getInstance().getShareContentUrl();
            if (StringUtils.isNull(shareContentUrl)) {
                shareContentUrl = c.getGameLink();
            }
            if (StringUtils.isNull(shareContentUrl, true)) {
                shareContentUrl = "";
            } else if (!shareContentUrl.contains("tbgametype")) {
                shareContentUrl = shareContentUrl + "&tbgametype=1";
            }
            shareFromGameCenterMsgData.setShareUrl(shareContentUrl.toString());
            return shareFromGameCenterMsgData;
        }
        return (ShareFromGameCenterMsgData) invokeV.objValue;
    }
}

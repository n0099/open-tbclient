package com.baidu.tbadk.game;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class a {
    private static a eoi = new a();
    private GameInfoData eoj;
    private final c eok = new c(CmdConfigSocket.CMD_GET_GAME_DETAIL) { // from class: com.baidu.tbadk.game.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseGameDetailMessage) && !socketResponsedMessage.hasError()) {
                ResponseGameDetailMessage responseGameDetailMessage = (ResponseGameDetailMessage) socketResponsedMessage;
                if (responseGameDetailMessage.getOrginalMessage() instanceof RequestGameDetailMessage) {
                    a.this.eoj = GameInfoData.fromGameInfo(responseGameDetailMessage.getGameInfo());
                }
            }
        }
    };
    private String mUrl;

    private a() {
        MessageManager.getInstance().registerListener(this.eok);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tbadk.game.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA, a.this.bel());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static a bei() {
        return eoi;
    }

    private GameInfoData bej() {
        GameInfoData gameInfoData = new GameInfoData();
        gameInfoData.setGameName(TbadkApplication.getInst().getContext().getString(R.string.default_share_to_game_title));
        gameInfoData.setGameLink(this.mUrl);
        gameInfoData.setGameId("default");
        gameInfoData.setIconUrl("default");
        gameInfoData.setIntroduce(TbadkApplication.getInst().getContext().getString(R.string.default_share_to_game_content));
        return gameInfoData;
    }

    public GameInfoData bek() {
        return this.eoj == null ? bej() : this.eoj;
    }

    public ShareFromGameCenterMsgData bel() {
        GameInfoData bek = bek();
        ShareFromGameCenterMsgData shareFromGameCenterMsgData = new ShareFromGameCenterMsgData();
        shareFromGameCenterMsgData.setTitle(StringUtils.isNull(GameShareJsBridge.getInstance().getShareTitle(), true) ? bek.getGameName() : GameShareJsBridge.getInstance().getShareTitle());
        shareFromGameCenterMsgData.setContent(StringUtils.isNull(GameShareJsBridge.getInstance().getShareContent(), true) ? bek.getIntroduce() : GameShareJsBridge.getInstance().getShareContent());
        shareFromGameCenterMsgData.setImageUrl(StringUtils.isNull(GameShareJsBridge.getInstance().getShareImage(), true) ? bek.getIconUrl() : GameShareJsBridge.getInstance().getShareImage());
        shareFromGameCenterMsgData.setShareSource(StringUtils.isNull(GameShareJsBridge.getInstance().getShareName(), true) ? bek.getGameName() : GameShareJsBridge.getInstance().getShareName());
        shareFromGameCenterMsgData.setShareSourceIcon(StringUtils.isNull(GameShareJsBridge.getInstance().getIconUrl(), true) ? bek.getIconUrl() : GameShareJsBridge.getInstance().getIconUrl());
        String gameId = StringUtils.isNull(GameShareJsBridge.getInstance().getGameId(), true) ? bek.getGameId() : GameShareJsBridge.getInstance().getGameId();
        if ("default".equals(gameId)) {
            shareFromGameCenterMsgData.setShareSourceUrl(gameId);
        } else {
            shareFromGameCenterMsgData.setShareSourceUrl("game:detail:TBCGameID=" + gameId);
        }
        String shareContentUrl = GameShareJsBridge.getInstance().getShareContentUrl();
        if (StringUtils.isNull(shareContentUrl)) {
            shareContentUrl = bek.getGameLink();
        }
        if (StringUtils.isNull(shareContentUrl, true)) {
            shareContentUrl = "";
        } else if (!shareContentUrl.contains("tbgametype")) {
            shareContentUrl = shareContentUrl + "&tbgametype=1";
        }
        shareFromGameCenterMsgData.setShareUrl(shareContentUrl.toString());
        return shareFromGameCenterMsgData;
    }
}

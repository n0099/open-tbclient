package com.baidu.tbadk.game;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private static a bvy = new a();
    private final c bvA = new c(303009) { // from class: com.baidu.tbadk.game.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseGameDetailMessage) && !socketResponsedMessage.hasError()) {
                ResponseGameDetailMessage responseGameDetailMessage = (ResponseGameDetailMessage) socketResponsedMessage;
                if (responseGameDetailMessage.getOrginalMessage() instanceof RequestGameDetailMessage) {
                    a.this.bvz = GameInfoData.fromGameInfo(responseGameDetailMessage.getGameInfo());
                }
            }
        }
    };
    private GameInfoData bvz;
    private String mUrl;

    private a() {
        MessageManager.getInstance().registerListener(this.bvA);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001261, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tbadk.game.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(2001261, a.this.Mn());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static a Mk() {
        return bvy;
    }

    private GameInfoData Ml() {
        GameInfoData gameInfoData = new GameInfoData();
        gameInfoData.setGameName(TbadkApplication.getInst().getContext().getString(d.j.default_share_to_game_title));
        gameInfoData.setGameLink(this.mUrl);
        gameInfoData.setGameId("default");
        gameInfoData.setIconUrl("default");
        gameInfoData.setIntroduce(TbadkApplication.getInst().getContext().getString(d.j.default_share_to_game_content));
        return gameInfoData;
    }

    public GameInfoData Mm() {
        return this.bvz == null ? Ml() : this.bvz;
    }

    public ShareFromGameCenterMsgData Mn() {
        GameInfoData Mm = Mm();
        ShareFromGameCenterMsgData shareFromGameCenterMsgData = new ShareFromGameCenterMsgData();
        shareFromGameCenterMsgData.setTitle(StringUtils.isNull(GameShareJsBridge.getInstance().getShareTitle(), true) ? Mm.getGameName() : GameShareJsBridge.getInstance().getShareTitle());
        shareFromGameCenterMsgData.setContent(StringUtils.isNull(GameShareJsBridge.getInstance().getShareContent(), true) ? Mm.getIntroduce() : GameShareJsBridge.getInstance().getShareContent());
        shareFromGameCenterMsgData.setImageUrl(StringUtils.isNull(GameShareJsBridge.getInstance().getShareImage(), true) ? Mm.getIconUrl() : GameShareJsBridge.getInstance().getShareImage());
        shareFromGameCenterMsgData.setShareSource(StringUtils.isNull(GameShareJsBridge.getInstance().getShareName(), true) ? Mm.getGameName() : GameShareJsBridge.getInstance().getShareName());
        shareFromGameCenterMsgData.setShareSourceIcon(StringUtils.isNull(GameShareJsBridge.getInstance().getIconUrl(), true) ? Mm.getIconUrl() : GameShareJsBridge.getInstance().getIconUrl());
        String gameId = StringUtils.isNull(GameShareJsBridge.getInstance().getGameId(), true) ? Mm.getGameId() : GameShareJsBridge.getInstance().getGameId();
        if ("default".equals(gameId)) {
            shareFromGameCenterMsgData.setShareSourceUrl(gameId);
        } else {
            shareFromGameCenterMsgData.setShareSourceUrl("game:detail:TBCGameID=" + gameId);
        }
        String shareContentUrl = GameShareJsBridge.getInstance().getShareContentUrl();
        if (StringUtils.isNull(shareContentUrl)) {
            shareContentUrl = Mm.getGameLink();
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

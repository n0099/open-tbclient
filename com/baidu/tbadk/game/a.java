package com.baidu.tbadk.game;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private static a aCY = new a();
    private GameInfoData aCZ;
    private final e aDa = new b(this, 303009);
    private String mUrl;

    private a() {
        MessageManager.getInstance().registerListener(this.aDa);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA, new c(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static a DO() {
        return aCY;
    }

    private GameInfoData DP() {
        GameInfoData gameInfoData = new GameInfoData();
        gameInfoData.setGameName(TbadkApplication.getInst().getContext().getString(w.l.default_share_to_game_title));
        gameInfoData.setGameLink(this.mUrl);
        gameInfoData.setGameId("default");
        gameInfoData.setIconUrl("default");
        gameInfoData.setIntroduce(TbadkApplication.getInst().getContext().getString(w.l.default_share_to_game_content));
        return gameInfoData;
    }

    public GameInfoData DQ() {
        return this.aCZ == null ? DP() : this.aCZ;
    }

    public ShareFromGameCenterMsgData DR() {
        GameInfoData DQ = DQ();
        ShareFromGameCenterMsgData shareFromGameCenterMsgData = new ShareFromGameCenterMsgData();
        shareFromGameCenterMsgData.setTitle(StringUtils.isNull(GameShareJsBridge.getInstance().getShareTitle(), true) ? DQ.getGameName() : GameShareJsBridge.getInstance().getShareTitle());
        shareFromGameCenterMsgData.setContent(StringUtils.isNull(GameShareJsBridge.getInstance().getShareContent(), true) ? DQ.getIntroduce() : GameShareJsBridge.getInstance().getShareContent());
        shareFromGameCenterMsgData.setImageUrl(StringUtils.isNull(GameShareJsBridge.getInstance().getShareImage(), true) ? DQ.getIconUrl() : GameShareJsBridge.getInstance().getShareImage());
        shareFromGameCenterMsgData.setShareSource(StringUtils.isNull(GameShareJsBridge.getInstance().getShareName(), true) ? DQ.getGameName() : GameShareJsBridge.getInstance().getShareName());
        shareFromGameCenterMsgData.setShareSourceIcon(StringUtils.isNull(GameShareJsBridge.getInstance().getIconUrl(), true) ? DQ.getIconUrl() : GameShareJsBridge.getInstance().getIconUrl());
        String gameId = StringUtils.isNull(GameShareJsBridge.getInstance().getGameId(), true) ? DQ.getGameId() : GameShareJsBridge.getInstance().getGameId();
        if ("default".equals(gameId)) {
            shareFromGameCenterMsgData.setShareSourceUrl(gameId);
        } else {
            shareFromGameCenterMsgData.setShareSourceUrl("game:detail:TBCGameID=" + gameId);
        }
        String shareContentUrl = GameShareJsBridge.getInstance().getShareContentUrl();
        if (StringUtils.isNull(shareContentUrl)) {
            shareContentUrl = DQ.getGameLink();
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

package com.baidu.tbadk.game;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b {
    private static b arK = new b();
    private GameInfoData arL;
    private final com.baidu.adp.framework.listener.e arM = new c(this, 303009);
    private String mUrl;

    private b() {
        MessageManager.getInstance().registerListener(this.arM);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA, new d(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static b BJ() {
        return arK;
    }

    public void al(String str, String str2) {
        this.mUrl = str2;
        this.arL = null;
        if (!TextUtils.isEmpty(str)) {
            RequestGameDetailMessage requestGameDetailMessage = new RequestGameDetailMessage();
            requestGameDetailMessage.setGameId(str);
            MessageManager.getInstance().sendMessage(requestGameDetailMessage);
        }
    }

    private GameInfoData BK() {
        GameInfoData gameInfoData = new GameInfoData();
        gameInfoData.setGameName(TbadkApplication.getInst().getContext().getString(i.h.default_share_to_game_title));
        gameInfoData.setGameLink(this.mUrl);
        gameInfoData.setGameId("default");
        gameInfoData.setIconUrl("default");
        gameInfoData.setIntroduce(TbadkApplication.getInst().getContext().getString(i.h.default_share_to_game_content));
        return gameInfoData;
    }

    public GameInfoData getGameInfoData() {
        return this.arL == null ? BK() : this.arL;
    }

    public ShareFromGameCenterMsgData BL() {
        GameInfoData gameInfoData = getGameInfoData();
        ShareFromGameCenterMsgData shareFromGameCenterMsgData = new ShareFromGameCenterMsgData();
        shareFromGameCenterMsgData.setTitle(StringUtils.isNull(GameShareJsBridge.getInstance().getShareTitle(), true) ? gameInfoData.getGameName() : GameShareJsBridge.getInstance().getShareTitle());
        shareFromGameCenterMsgData.setContent(StringUtils.isNull(GameShareJsBridge.getInstance().getShareContent(), true) ? gameInfoData.getIntroduce() : GameShareJsBridge.getInstance().getShareContent());
        shareFromGameCenterMsgData.setImageUrl(StringUtils.isNull(GameShareJsBridge.getInstance().getShareImage(), true) ? gameInfoData.getIconUrl() : GameShareJsBridge.getInstance().getShareImage());
        shareFromGameCenterMsgData.setShareSource(StringUtils.isNull(GameShareJsBridge.getInstance().getShareName(), true) ? gameInfoData.getGameName() : GameShareJsBridge.getInstance().getShareName());
        shareFromGameCenterMsgData.setShareSourceIcon(StringUtils.isNull(GameShareJsBridge.getInstance().getIconUrl(), true) ? gameInfoData.getIconUrl() : GameShareJsBridge.getInstance().getIconUrl());
        String gameId = StringUtils.isNull(GameShareJsBridge.getInstance().getGameId(), true) ? gameInfoData.getGameId() : GameShareJsBridge.getInstance().getGameId();
        if ("default".equals(gameId)) {
            shareFromGameCenterMsgData.setShareSourceUrl(gameId);
        } else {
            shareFromGameCenterMsgData.setShareSourceUrl("game:detail:TBCGameID=" + gameId);
        }
        String shareContentUrl = GameShareJsBridge.getInstance().getShareContentUrl();
        if (StringUtils.isNull(shareContentUrl)) {
            shareContentUrl = gameInfoData.getGameLink();
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

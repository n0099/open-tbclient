package com.baidu.tbadk.game;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class b {
    private static b Ze = new b();
    private GameInfoData Zf;
    private final com.baidu.adp.framework.listener.e Zg = new c(this, 303009);
    private String mUrl;

    private b() {
        MessageManager.getInstance().registerListener(this.Zg);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001268, new d(this));
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static b vv() {
        return Ze;
    }

    public void ah(String str, String str2) {
        this.mUrl = str2;
        this.Zf = null;
        if (!TextUtils.isEmpty(str)) {
            RequestGameDetailMessage requestGameDetailMessage = new RequestGameDetailMessage();
            requestGameDetailMessage.setGameId(str);
            MessageManager.getInstance().sendMessage(requestGameDetailMessage);
        }
    }

    private GameInfoData vw() {
        GameInfoData gameInfoData = new GameInfoData();
        gameInfoData.setGameName(TbadkApplication.getInst().getContext().getString(z.default_share_to_game_title));
        gameInfoData.setGameLink(this.mUrl);
        gameInfoData.setGameId("default");
        gameInfoData.setIconUrl("default");
        gameInfoData.setIntroduce(TbadkApplication.getInst().getContext().getString(z.default_share_to_game_content));
        return gameInfoData;
    }

    public GameInfoData getGameInfoData() {
        return this.Zf == null ? vw() : this.Zf;
    }

    public ShareFromGameCenterMsgData vx() {
        GameInfoData gameInfoData = getGameInfoData();
        ShareFromGameCenterMsgData shareFromGameCenterMsgData = new ShareFromGameCenterMsgData();
        shareFromGameCenterMsgData.setTitle(GameShareJsBridge.getInstance().getShareTitle() == null ? gameInfoData.getGameName() : GameShareJsBridge.getInstance().getShareTitle());
        shareFromGameCenterMsgData.setContent(GameShareJsBridge.getInstance().getShareContent() == null ? gameInfoData.getIntroduce() : GameShareJsBridge.getInstance().getShareContent());
        shareFromGameCenterMsgData.setImageUrl(GameShareJsBridge.getInstance().getShareImage() == null ? gameInfoData.getIconUrl() : GameShareJsBridge.getInstance().getShareImage());
        shareFromGameCenterMsgData.setShareSource(GameShareJsBridge.getInstance().getShareName() == null ? gameInfoData.getGameName() : GameShareJsBridge.getInstance().getShareName());
        shareFromGameCenterMsgData.setShareSourceIcon(GameShareJsBridge.getInstance().getIconUrl() == null ? gameInfoData.getIconUrl() : GameShareJsBridge.getInstance().getIconUrl());
        String gameId = GameShareJsBridge.getInstance().getGameId() == null ? gameInfoData.getGameId() : GameShareJsBridge.getInstance().getGameId();
        if ("default".equals(gameId)) {
            shareFromGameCenterMsgData.setShareSourceUrl(gameId);
        } else {
            shareFromGameCenterMsgData.setShareSourceUrl("game:detail:TBCGameID=" + gameId);
        }
        String gameLink = gameInfoData.getGameLink();
        if (gameLink == null) {
            gameLink = GameShareJsBridge.getInstance().getShareContentUrl();
        }
        if (gameLink == null) {
            gameLink = "";
        } else if (!gameLink.contains("tbgametype")) {
            gameLink = gameLink + "&tbgametype=1";
        }
        shareFromGameCenterMsgData.setShareUrl(gameLink.toString());
        return shareFromGameCenterMsgData;
    }
}

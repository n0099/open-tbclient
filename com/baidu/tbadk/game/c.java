package com.baidu.tbadk.game;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class c {
    private static c a = new c();
    private b b;
    private String c;
    private final com.baidu.adp.framework.listener.d d = new d(this, 303009);

    private c() {
        MessageManager.getInstance().registerListener(this.d);
    }

    public static c a() {
        return a;
    }

    public void a(String str, String str2) {
        this.c = str2;
        this.b = null;
        if (!TextUtils.isEmpty(str)) {
            RequestGameDetailMessage requestGameDetailMessage = new RequestGameDetailMessage();
            requestGameDetailMessage.setGameId(str);
            MessageManager.getInstance().sendMessage(requestGameDetailMessage);
        }
    }

    private b d() {
        b bVar = new b();
        bVar.b(TbadkApplication.m252getInst().getString(x.default_share_to_game_title));
        bVar.f(this.c);
        bVar.a("default");
        bVar.c("default");
        bVar.l(TbadkApplication.m252getInst().getString(x.default_share_to_game_content));
        return bVar;
    }

    public b b() {
        return this.b == null ? d() : this.b;
    }

    public ShareFromGameCenterMsgData c() {
        b b = b();
        ShareFromGameCenterMsgData shareFromGameCenterMsgData = new ShareFromGameCenterMsgData();
        shareFromGameCenterMsgData.setTitle(b.b());
        shareFromGameCenterMsgData.setContent(b.p());
        shareFromGameCenterMsgData.setImageUrl(b.d());
        shareFromGameCenterMsgData.setShareSource(b.b());
        shareFromGameCenterMsgData.setShareSourceIcon(b.d());
        if ("default".equals(b.a())) {
            shareFromGameCenterMsgData.setShareSourceUrl(b.a());
        } else {
            shareFromGameCenterMsgData.setShareSourceUrl("game:detail:TBCGameID=" + b.a());
        }
        String h = b.h();
        if (h == null) {
            h = "";
        } else if (!h.contains("tbgametype")) {
            h = h + "&tbgametype=1";
        }
        shareFromGameCenterMsgData.setShareUrl(h);
        return shareFromGameCenterMsgData;
    }
}

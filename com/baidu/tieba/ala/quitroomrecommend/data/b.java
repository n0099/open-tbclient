package com.baidu.tieba.ala.quitroomrecommend.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class b extends HttpMessage {
    public int igJ;
    public long igy;
    public long roomId;

    public b() {
        super(1021226);
    }

    public void setParams() {
        addParam("daily_num", this.igJ);
        addParam("room_id", this.roomId);
        addParam("session_id", this.igy);
    }
}

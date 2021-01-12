package com.baidu.tieba.ala.quitroomrecommend.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class b extends HttpMessage {
    public long ibN;
    public int ibY;
    public long roomId;

    public b() {
        super(1021226);
    }

    public void setParams() {
        addParam("daily_num", this.ibY);
        addParam("room_id", this.roomId);
        addParam("session_id", this.ibN);
    }
}

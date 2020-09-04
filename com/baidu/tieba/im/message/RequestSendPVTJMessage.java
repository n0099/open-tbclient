package com.baidu.tieba.im.message;

import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import java.util.HashMap;
import org.json.JSONObject;
import protobuf.LogStat.DataReq;
import protobuf.LogStat.LogStatReqIdl;
/* loaded from: classes.dex */
public class RequestSendPVTJMessage extends TbSocketMessage {
    public static final String TYPE_KD_MREAD = "kd_mread";
    public static final String TYPE_V_MPUSH = "v_mpush";
    public static final String TYPE_V_MREAD = "v_mread";
    private String stExt;
    private String stType;

    public RequestSendPVTJMessage() {
        super(CmdConfigSocket.CMD_SEND_PV_TJ);
    }

    public RequestSendPVTJMessage(String str, String str2) {
        super(CmdConfigSocket.CMD_SEND_PV_TJ);
        this.stType = str;
        this.stExt = str2;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String getStExt() {
        return this.stExt;
    }

    public void setStExt(String str) {
        this.stExt = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.stType = this.stType;
        builder.stExt = this.stExt;
        LogStatReqIdl.Builder builder2 = new LogStatReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    private static String buildExtJson(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("st_param", str);
        hashMap.put("jobid", "0");
        return new JSONObject(hashMap).toString();
    }

    public static void sendOfficialBarPVTJ(String str, String str2) {
        MessageManager.getInstance().sendMessage(new RequestSendPVTJMessage(str, buildExtJson(str2)));
    }
}

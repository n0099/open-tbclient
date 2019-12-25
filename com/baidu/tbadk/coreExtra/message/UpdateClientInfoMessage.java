package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.squareup.wire.ByteString;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import protobuf.UpdateClientInfo.DataReq;
import protobuf.UpdateClientInfo.UpdateClientInfoReqIdl;
/* loaded from: classes.dex */
public class UpdateClientInfoMessage extends TbSocketMessage {
    private String bduss;
    private final Map<String, String> device;
    private int height;
    private double lat;
    private double lng;
    private Integer pub_env;
    private byte[] secretKey;
    private String stoken;
    private int width;

    public UpdateClientInfoMessage() {
        super(1001);
        this.device = new HashMap();
        try {
            if (TbadkCoreApplication.getInst().getLocationShared()) {
                this.lat = b.toDouble(TbadkCoreApplication.getInst().getLocationLat(), 0.0d);
                this.lng = b.toDouble(TbadkCoreApplication.getInst().getLocationLng(), 0.0d);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setPub_env(Integer num) {
        this.pub_env = num;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLng(double d) {
        this.lng = d;
    }

    public void setSecretKey(byte[] bArr) {
        this.secretKey = bArr;
    }

    public void setBduss(String str, String str2) {
        this.bduss = str;
        this.stoken = str2;
    }

    public void addUserInfo(String str, String str2) {
        this.device.put(str, str2);
    }

    public String getDevice() {
        try {
            return new JSONObject(this.device).toString();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return null;
        }
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.bduss = this.bduss;
        builder.device = getDevice();
        builder.stoken = this.stoken;
        builder.secretKey = ByteString.of(this.secretKey);
        builder.height = Integer.valueOf(this.height);
        builder.width = Integer.valueOf(this.width);
        builder.lat = Double.valueOf(this.lat);
        builder.lng = Double.valueOf(this.lng);
        builder.pub_env = this.pub_env;
        UpdateClientInfoReqIdl.Builder builder2 = new UpdateClientInfoReqIdl.Builder();
        builder2.cuid = TbadkCoreApplication.getUniqueIdentifier();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}

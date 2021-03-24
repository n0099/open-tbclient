package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.squareup.wire.ByteString;
import d.b.b.e.m.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import protobuf.UpdateClientInfo.DataReq;
import protobuf.UpdateClientInfo.UpdateClientInfoReqIdl;
/* loaded from: classes3.dex */
public class UpdateClientInfoMessage extends TbSocketMessage {
    public String bduss;
    public final Map<String, String> device;
    public int height;
    public double lat;
    public double lng;
    public Integer pub_env;
    public byte[] secretKey;
    public String stoken;
    public int width;

    public UpdateClientInfoMessage() {
        super(1001);
        this.device = new HashMap();
        try {
            if (TbadkCoreApplication.getInst().getLocationShared()) {
                this.lat = b.b(TbadkCoreApplication.getInst().getLocationLat(), 0.0d);
                this.lng = b.b(TbadkCoreApplication.getInst().getLocationLng(), 0.0d);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void addUserInfo(String str, String str2) {
        this.device.put(str, str2);
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

    public String getDevice() {
        try {
            return new JSONObject(this.device).toString();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return null;
        }
    }

    public void setBduss(String str, String str2) {
        this.bduss = str;
        this.stoken = str2;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setLat(double d2) {
        this.lat = d2;
    }

    public void setLng(double d2) {
        this.lng = d2;
    }

    public void setPub_env(Integer num) {
        this.pub_env = num;
    }

    public void setSecretKey(byte[] bArr) {
        this.secretKey = bArr;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}

package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.lib.h.b;
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
    private int width;

    public UpdateClientInfoMessage() {
        super(1001);
        this.device = new HashMap();
        try {
            if (TbadkCoreApplication.m11getInst().getLocationShared()) {
                this.lat = b.a(TbadkCoreApplication.m11getInst().getLocationLat(), 0.0d);
                this.lng = b.a(TbadkCoreApplication.m11getInst().getLocationLng(), 0.0d);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public Integer getPub_env() {
        return this.pub_env;
    }

    public void setPub_env(Integer num) {
        this.pub_env = num;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLng(double d) {
        this.lng = d;
    }

    public byte[] getSecretKey() {
        return this.secretKey;
    }

    public void setSecretKey(byte[] bArr) {
        this.secretKey = bArr;
    }

    public String getBduss() {
        return this.bduss;
    }

    public void setBduss(String str) {
        this.bduss = str;
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

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.bduss = getBduss();
        builder.device = getDevice();
        builder.secretKey = ByteString.of(getSecretKey());
        builder.height = Integer.valueOf(getHeight());
        builder.width = Integer.valueOf(getWidth());
        builder.lat = Double.valueOf(getLat());
        builder.lng = Double.valueOf(getLng());
        builder.pub_env = getPub_env();
        UpdateClientInfoReqIdl.Builder builder2 = new UpdateClientInfoReqIdl.Builder();
        builder2.cuid = TbadkCoreApplication.getUniqueIdentifier();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}

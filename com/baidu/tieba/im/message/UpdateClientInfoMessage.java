package com.baidu.tieba.im.message;

import com.baidu.gson.Gson;
import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class UpdateClientInfoMessage extends Message implements IDuplicateProcess {
    private String bduss;
    private Map<String, String> device = new HashMap();
    private int height;
    private byte[] secretKey;
    private int width;

    @Override // com.baidu.tieba.im.message.Message
    public Map toMap() {
        Map map = super.toMap();
        if (this.secretKey != null) {
            map.put("secretKey", this.secretKey);
        }
        map.put("device", new Gson().toJson(this.device));
        return map;
    }

    public UpdateClientInfoMessage() {
        setCmd(1001);
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

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public IDuplicateProcess.RemoveState getDuplicateRemoveType() {
        return IDuplicateProcess.RemoveState.REMOVE_ME;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public boolean onDuplicateProcess(Message message) {
        return true;
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
}

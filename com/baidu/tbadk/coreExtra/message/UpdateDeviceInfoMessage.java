package com.baidu.tbadk.coreExtra.message;

import android.os.Build;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import protobuf.UpdateDeviceInfo.DataReq;
import protobuf.UpdateDeviceInfo.UpdateDeviceInfoReqIdl;
/* loaded from: classes.dex */
public class UpdateDeviceInfoMessage extends NetMessage {
    private final Map<String, String> device;

    public UpdateDeviceInfoMessage(int i, int i2) {
        super(i, i2);
        this.device = new HashMap();
        setNetType(NetMessage.NetType.HTTP);
    }

    public UpdateDeviceInfoMessage() {
        super(CmdConfigHttp.CMD_UPDATE_DEVICE_INFO, 1005);
        this.device = new HashMap();
        setNetType(NetMessage.NetType.HTTP);
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

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        addUserInfo("_client_type", "2");
        addUserInfo("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.m255getInst().getImei() != null) {
            addUserInfo("_phone_imei", TbadkCoreApplication.m255getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            addUserInfo("_client_id", clientId);
        }
        addUserInfo("cuid", TbadkCoreApplication.m255getInst().getCuid());
        addUserInfo("model", Build.MODEL);
        addUserInfo("_os_version", Build.VERSION.RELEASE);
        DataReq.Builder builder = new DataReq.Builder();
        builder.cuid = TbadkCoreApplication.m255getInst().getCuid();
        builder.uid = TbadkCoreApplication.getCurrentAccount();
        builder.device = getDevice();
        UpdateDeviceInfoReqIdl.Builder builder2 = new UpdateDeviceInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}

package com.baidu.tieba.ala.liveroom.q;

import android.os.Build;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.message.AlaExceptionHttpResMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.messages.AlaLivePerfResponseMessage;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends BdBaseModel {
    public c() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021048, TbConfig.SERVER_ADDRESS + "ala/sys/gatherData");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaLivePerfResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.live.tieba.f.a.a.a(1021049, "ala/sys/exceptionMonitor", AlaExceptionHttpResMessage.class, false, true, true, true);
    }

    public void a(AlaLiveRecorderPerfData alaLiveRecorderPerfData) {
        if (alaLiveRecorderPerfData != null) {
            HttpMessage httpMessage = new HttpMessage(1021048);
            httpMessage.addParam("_os_version", Build.VERSION.RELEASE);
            httpMessage.addParam(Constants.PHONE_BRAND, Build.BRAND);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", 1);
                jSONObject.put("live_id", alaLiveRecorderPerfData.liveID);
                jSONObject.put("log_id", alaLiveRecorderPerfData.logID);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, alaLiveRecorderPerfData.liveTotalTime);
                jSONObject2.put("pt", alaLiveRecorderPerfData.prepareTime);
                jSONObject2.put("ut", alaLiveRecorderPerfData.updateTime);
                jSONObject2.put("lt", alaLiveRecorderPerfData.linkTime);
                jSONObject2.put(j.g, alaLiveRecorderPerfData.linkCount);
                jSONObject2.put("wt", alaLiveRecorderPerfData.waitTime);
                jSONObject2.put("st", alaLiveRecorderPerfData.showTime);
                jSONObject2.put("et", alaLiveRecorderPerfData.endViewShowTime);
                jSONObject2.put("ls", alaLiveRecorderPerfData.liveType);
                jSONObject2.put("session_line", alaLiveRecorderPerfData.sessionLine);
                jSONObject.put("time", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("success", Integer.valueOf(alaLiveRecorderPerfData.errCode == 0 ? 1 : 0));
                jSONObject3.put(LogConfig.RECONNECT, alaLiveRecorderPerfData.isReShow ? 1 : 0);
                jSONObject3.putOpt(TiebaInitialize.LogFields.REASON, Integer.valueOf(alaLiveRecorderPerfData.errCode));
                jSONObject3.put("sub_reason", alaLiveRecorderPerfData.errSubReason);
                jSONObject3.putOpt("dropc", Long.valueOf(alaLiveRecorderPerfData.dropCount));
                jSONObject3.putOpt("dropi", Long.valueOf(alaLiveRecorderPerfData.dropICount));
                jSONObject3.putOpt("dropp", Long.valueOf(alaLiveRecorderPerfData.dropPCount));
                jSONObject3.putOpt("dropa", Long.valueOf(alaLiveRecorderPerfData.dropACount));
                jSONObject.putOpt("stability", jSONObject3);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putOpt("mem", ci(alaLiveRecorderPerfData.memoryArray));
                jSONObject4.putOpt(com.baidu.fsg.face.base.b.c.i, ci(alaLiveRecorderPerfData.cpuArray));
                jSONObject4.putOpt("bat", String.format("%.2f", Float.valueOf(alaLiveRecorderPerfData.energyUsage)));
                jSONObject4.putOpt("charge", Boolean.valueOf(alaLiveRecorderPerfData.isCharging));
                jSONObject.putOpt("perf", jSONObject4);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.putOpt("df", String.format("%.2f", Float.valueOf(((float) alaLiveRecorderPerfData.dataFlow) / 1024.0f)));
                jSONObject5.putOpt("nf", String.format("%.2f", Float.valueOf(((float) alaLiveRecorderPerfData.netFlow) / 1024.0f)));
                jSONObject5.putOpt("pf", String.format("%.2f", Float.valueOf(((float) alaLiveRecorderPerfData.prictureFlow) / 1024.0f)));
                jSONObject5.putOpt("mf", String.format("%.2f", Float.valueOf(((float) alaLiveRecorderPerfData.mediaFlow) / 1024.0f)));
                jSONObject5.putOpt("if", String.format("%.2f", Float.valueOf(((float) alaLiveRecorderPerfData.IMFlow) / 1024.0f)));
                jSONObject.putOpt("dataflow", jSONObject5);
                httpMessage.addParam("data", jSONObject.toString());
            } catch (Throwable th) {
                BdLog.e(th.getLocalizedMessage());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void release() {
        MessageManager.getInstance().unRegisterTask(1021048);
        MessageManager.getInstance().unRegisterTask(1021049);
    }

    private String ci(List list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            stringBuffer.append(list.get(i));
            stringBuffer.append(',');
        }
        return stringBuffer.toString();
    }
}

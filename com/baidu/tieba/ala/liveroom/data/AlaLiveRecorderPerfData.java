package com.baidu.tieba.ala.liveroom.data;

import com.baidu.live.data.AlaLivePerfBaseData;
import java.io.Serializable;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveRecorderPerfData extends AlaLivePerfBaseData implements Serializable {
    public static final int ERROR_SUB_CANT_START_RECORD = -1;
    public static final int ERROR_SUB_NEED_VERIFY = -2;
    public static final int ERROR_SUB_VEIFY_FAILED = -3;
    private static final long serialVersionUID = 7292167816728256796L;
    public long endTime;
    public long endViewShowTime;
    public int linkCount;
    public long linkTime;
    public long liveTotalTime;
    public long prepareTime;
    public long showTime;
    public long startLiveTime;
    public long startTime;
    public long updateTime;
    public long waitTime;
    public int watchType;
    public boolean isReShow = false;
    public double lostRate = 0.0d;

    @Override // com.baidu.live.data.AlaLivePerfBaseData
    public void reset() {
        super.reset();
        this.lostRate = 0.0d;
    }

    public void parseJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.cpuStatCount = jSONObject.optInt("cpu_stat_count", 0);
            this.cpuAvg = jSONObject.optInt("cpu_avg", 0);
            this.cpuMax = jSONObject.optInt("cpu_max", 0);
            this.cpuMin = jSONObject.optInt("cpu_min", 0);
            this.cpuTotal = jSONObject.optInt("cpu_total", 0);
            this.memStatCount = jSONObject.optInt("mem_stat_count", 0);
            this.memAvg = jSONObject.optInt("mem_avg", 0);
            this.memMax = jSONObject.optInt("mem_max", 0);
            this.memMin = jSONObject.optInt("mem_min", 0);
            this.memTotal = jSONObject.optInt("mem_total", 0);
            this.energyUsage = (float) jSONObject.optDouble("energyUsage");
            this.isCharging = jSONObject.optBoolean("is_charging");
            this.dataFlow = jSONObject.optLong("data_flow");
            this.netFlow = jSONObject.optLong("net_flow");
            this.prictureFlow = jSONObject.optLong("picture_flow");
            this.mediaFlow = jSONObject.optLong("media_flow");
            this.IMFlow = jSONObject.optLong("im_flow");
            this.isSuccess = jSONObject.optBoolean("is_success");
            this.errCode = jSONObject.optInt("err_code");
            this.errSubReason = jSONObject.optInt("err_sub_reason");
            this.dropCount = jSONObject.optLong("drop_count");
            this.dropICount = jSONObject.optLong("drop_icount");
            this.dropPCount = jSONObject.optLong("drop_pcount");
            this.dropACount = jSONObject.optLong("drop_acount");
            this.startTime = jSONObject.optLong("start_time");
            this.startLiveTime = jSONObject.optLong("start_live_time");
            this.endViewShowTime = jSONObject.optLong("end_view_show_time");
            this.liveTotalTime = jSONObject.optLong("live_total_time");
            this.prepareTime = jSONObject.optLong("prepare_time");
            this.updateTime = jSONObject.optLong("update_time");
            this.linkTime = jSONObject.optLong("link_time");
            this.linkCount = jSONObject.optInt("link_count");
            this.waitTime = jSONObject.optLong("wait_time");
            this.showTime = jSONObject.optLong("show_time");
            this.endTime = jSONObject.optLong("end_time");
            this.isReShow = jSONObject.optBoolean("is_reshow");
            this.watchType = jSONObject.optInt("watch_type");
            this.lostRate = jSONObject.optInt("lost_rate");
            if (jSONObject.has("memory_array")) {
                this.memoryArray.clear();
                JSONArray optJSONArray = jSONObject.optJSONArray("memory_array");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.memoryArray.add(Integer.valueOf(String.valueOf(optJSONArray.get(i))));
                }
            }
            if (jSONObject.has("cpu_array")) {
                this.cpuArray.clear();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("cpu_array");
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.memoryArray.add(Integer.valueOf(String.valueOf(optJSONArray2.get(i2))));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getJsonString() {
        JSONObject json = toJson();
        if (json != null) {
            return json.toString();
        }
        return null;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cpu_stat_count", this.cpuStatCount);
            jSONObject.put("cpu_avg", this.cpuAvg);
            jSONObject.put("cpu_max", this.cpuMax);
            jSONObject.put("cpu_min", this.cpuMin);
            jSONObject.put("cpu_total", this.cpuTotal);
            jSONObject.put("mem_stat_count", this.memStatCount);
            jSONObject.put("mem_avg", this.memAvg);
            jSONObject.put("mem_max", this.memMax);
            jSONObject.put("mem_min", this.memMin);
            jSONObject.put("mem_total", this.memTotal);
            jSONObject.put("energyUsage", this.energyUsage);
            jSONObject.put("is_charging", this.isCharging);
            jSONObject.put("data_flow", this.dataFlow);
            jSONObject.put("net_flow", this.netFlow);
            jSONObject.put("picture_flow", this.prictureFlow);
            jSONObject.put("media_flow", this.mediaFlow);
            jSONObject.put("im_flow", this.IMFlow);
            jSONObject.put("is_success", this.isSuccess);
            jSONObject.put("err_code", this.errCode);
            jSONObject.put("err_sub_reason", this.errSubReason);
            jSONObject.put("drop_count", this.dropCount);
            jSONObject.put("drop_icount", this.dropICount);
            jSONObject.put("drop_pcount", this.dropPCount);
            jSONObject.put("drop_acount", this.dropACount);
            jSONObject.put("start_time", this.startTime);
            jSONObject.put("start_live_time", this.startLiveTime);
            jSONObject.put("end_view_show_time", this.endViewShowTime);
            jSONObject.put("live_total_time", this.liveTotalTime);
            jSONObject.put("prepare_time", this.prepareTime);
            jSONObject.put("update_time", this.updateTime);
            jSONObject.put("link_time", this.linkTime);
            jSONObject.put("link_count", this.linkCount);
            jSONObject.put("wait_time", this.waitTime);
            jSONObject.put("show_time", this.showTime);
            jSONObject.put("end_time", this.endTime);
            jSONObject.put("is_reshow", this.isReShow);
            jSONObject.put("watch_type", this.watchType);
            jSONObject.put("lost_rate", this.lostRate);
            if (this.memoryArray != null) {
                jSONObject.put("memory_array", new JSONArray((Collection) this.memoryArray));
            }
            if (this.cpuArray != null) {
                jSONObject.put("cpu_array", new JSONArray((Collection) this.cpuArray));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

package com.baidu.tieba.ala.alaar.a;

import android.content.Context;
import android.util.Log;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.AlaFilterBeautyDataMessage;
import com.baidu.live.ar.j;
import com.baidu.live.d;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.alaar.makeup.a;
import com.baidu.tieba.ala.alaar.makeup.g;
import com.baidu.tieba.ala.alaar.messages.AlaArGradingQualityConfigResponseMessage;
import com.baidu.tieba.ala.alaar.messages.AlaFilterAndBeautyResponseMessage;
import com.baidu.tieba.ala.alaar.sticker.a.d;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends BdBaseModel implements j {
    private AlaFilterAndBeautyData gcg;
    private Context mContext;
    private boolean gch = false;
    private boolean gci = false;
    private HttpMessageListener gbN = new HttpMessageListener(1021163) { // from class: com.baidu.tieba.ala.alaar.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaFilterAndBeautyResponseMessage) {
                AlaFilterAndBeautyResponseMessage alaFilterAndBeautyResponseMessage = (AlaFilterAndBeautyResponseMessage) httpResponsedMessage;
                a.this.gcg = alaFilterAndBeautyResponseMessage.bNi();
                if (a.this.gcg != null) {
                    a.this.gcg.aEe = alaFilterAndBeautyResponseMessage.getOrginalMessage().getTag();
                }
                a.this.a(alaFilterAndBeautyResponseMessage);
            }
        }
    };
    private HttpMessageListener gcj = new HttpMessageListener(1021204) { // from class: com.baidu.tieba.ala.alaar.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof AlaArGradingQualityConfigResponseMessage)) {
                a.this.gci = true;
                if (a.this.gch) {
                    a.this.b(a.this.gcg);
                    return;
                }
                return;
            }
            if (a.isDebug()) {
                Log.d("ArUpdate", " onMessage getArQualityConfig   " + com.baidu.minivideo.arface.b.aad());
            }
            a.this.gci = true;
            if (a.this.gch) {
                if (a.isDebug()) {
                    Log.d("ArUpdate", " onMessage getArQualityConfig   mergeAdjust ");
                }
                a.this.b(a.this.gcg);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        initTasks();
        registerListener();
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    private void initTasks() {
        bNb();
        bNk();
    }

    private void bNb() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021163, TbConfig.SERVER_ADDRESS + "ala/sys/showConf");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaFilterAndBeautyResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        registerListener(this.gbN);
        registerListener(this.gcj);
        g.bMU().init();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gbN);
        MessageManager.getInstance().unRegisterListener(this.gcj);
    }

    @Override // com.baidu.live.ar.j
    public void a(BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(1021163);
        httpMessage.setTag(bdUniqueId);
        httpMessage.addParam("ar_token", d.AZ().getString("sp_ar_filter_and_beauty_token", ""));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void bNk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021204, TbConfig.SERVER_ADDRESS + "ala/sys/getArConfig");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaArGradingQualityConfigResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.ar.j
    public void b(BdUniqueId bdUniqueId) {
        b.bNl().init();
    }

    @Override // com.baidu.live.ar.j
    public void c(BdUniqueId bdUniqueId) {
        g.bMU().a((a.b) null);
    }

    @Override // com.baidu.live.ar.j
    public void destory() {
        unregisterListener();
        g.bMU().onDestroy();
    }

    @Override // com.baidu.live.ar.j
    public AlaFilterAndBeautyData Cy() {
        return this.gcg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaFilterAndBeautyResponseMessage alaFilterAndBeautyResponseMessage) {
        if (alaFilterAndBeautyResponseMessage == null) {
            Log.d("ArUpdate", "@.@ onGetFilterAndBeauty msg == null");
            eV(this.mContext);
            return;
        }
        AlaFilterAndBeautyData bNi = alaFilterAndBeautyResponseMessage.bNi();
        if (bNi == null) {
            bNi = alaFilterAndBeautyResponseMessage.tE(com.baidu.minivideo.arface.a.getVersion());
        } else {
            aB(bNi.aDW, com.baidu.minivideo.arface.a.getVersion());
        }
        if (bNi == null) {
            Log.d("ArUpdate", "@.@ onGetFilterAndBeauty data == null");
            eV(this.mContext);
            return;
        }
        if (isDebug()) {
            Log.d("ArUpdate", " onMessage onGetFilterAndBeauty   ");
        }
        this.gcg = bNi;
        this.gch = true;
        if (this.gci) {
            if (isDebug()) {
                Log.d("ArUpdate", " onMessage onGetFilterAndBeauty   mergeAdjust ");
            }
            b(this.gcg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        if (com.baidu.live.ar.d.a(AlaFilterAndBeautyData.aEd, alaFilterAndBeautyData, com.baidu.minivideo.arface.b.aad(), d.AZ().getBoolean("ar_grading_quality_config_need_update", false))) {
            MessageManager.getInstance().dispatchResponsedMessage(new AlaFilterBeautyDataMessage(2913150, alaFilterAndBeautyData));
            List<com.baidu.live.ar.g> list = alaFilterAndBeautyData.aDZ;
            if (list != null && list.size() > 0) {
                for (com.baidu.live.ar.g gVar : list) {
                    if (gVar != null && !com.baidu.tieba.ala.alaar.sticker.a.d.Ga(gVar.Cu())) {
                        com.baidu.tieba.ala.alaar.sticker.a.d.a(gVar.Cu(), new d.a() { // from class: com.baidu.tieba.ala.alaar.a.a.3
                            @Override // com.baidu.tieba.ala.alaar.sticker.a.d.a
                            public void onStarted() {
                                Log.d("ArUpdate", "onStarted ");
                            }

                            @Override // com.baidu.tieba.ala.alaar.sticker.a.d.a
                            public void onProgress(long j, long j2, int i) {
                                Log.d("ArUpdate", "onProgress ");
                            }

                            @Override // com.baidu.tieba.ala.alaar.sticker.a.d.a
                            public void onCompleted(String str) {
                                Log.d("ArUpdate", "onCompleted filePath:" + str);
                            }

                            @Override // com.baidu.tieba.ala.alaar.sticker.a.d.a
                            public void onFailed(int i, int i2, String str) {
                                Log.e("ArUpdate", "onFailed ");
                            }
                        });
                    }
                }
            }
        }
    }

    public void aB(String str, int i) {
        if (!StringUtils.isNullObject(str)) {
            com.baidu.live.d.AZ().putString("sp_ar_filter_and_beauty_token", str);
        }
        if (i > 0) {
            com.baidu.live.d.AZ().putInt("sp_ar_filter_and_beauty_version", i);
        }
    }

    public boolean eV(Context context) {
        AlaFilterAndBeautyData eW = eW(context);
        eW.aEf = true;
        if (com.baidu.live.ar.d.a(AlaFilterAndBeautyData.aEd, eW, com.baidu.minivideo.arface.b.aad(), com.baidu.live.d.AZ().getBoolean("ar_grading_quality_config_need_update", false))) {
            MessageManager.getInstance().dispatchResponsedMessage(new AlaFilterBeautyDataMessage(2913150, eW));
            return true;
        }
        return false;
    }

    public AlaFilterAndBeautyData eW(Context context) {
        try {
            JSONObject optJSONObject = new JSONObject(L(context, "arLocalBeauty.json")).optJSONObject("data");
            if (optJSONObject == null) {
                return null;
            }
            AlaFilterAndBeautyData alaFilterAndBeautyData = new AlaFilterAndBeautyData();
            alaFilterAndBeautyData.parse(optJSONObject);
            return alaFilterAndBeautyData;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [344=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.io.BufferedReader */
    /* JADX WARN: Multi-variable type inference failed */
    public String L(Context context, String str) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        InputStreamReader inputStreamReader3 = null;
        StringBuilder sb = new StringBuilder();
        try {
            inputStreamReader = new InputStreamReader(context.getAssets().open(str));
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (Exception e) {
                        e = e;
                        inputStreamReader3 = inputStreamReader;
                        inputStreamReader2 = bufferedReader;
                        try {
                            e.printStackTrace();
                            close(inputStreamReader2);
                            close(inputStreamReader3);
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            inputStreamReader = inputStreamReader3;
                            inputStreamReader3 = inputStreamReader2;
                            close(inputStreamReader3);
                            close(inputStreamReader);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamReader3 = bufferedReader;
                        close(inputStreamReader3);
                        close(inputStreamReader);
                        throw th;
                    }
                }
                close(bufferedReader);
                close(inputStreamReader);
            } catch (Exception e2) {
                e = e2;
                inputStreamReader2 = null;
                inputStreamReader3 = inputStreamReader;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e3) {
            e = e3;
            inputStreamReader2 = null;
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
        }
        return sb.toString();
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isDebug() {
        return com.baidu.minivideo.arface.b.isDebug();
    }
}

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
import com.baidu.live.ar.d;
import com.baidu.live.ar.e;
import com.baidu.live.ar.h;
import com.baidu.live.c;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
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
public class a extends BdBaseModel implements h {
    private AlaFilterAndBeautyData fNe;
    private boolean fNf = false;
    private boolean fNg = false;
    private HttpMessageListener fNh = new HttpMessageListener(1021163) { // from class: com.baidu.tieba.ala.alaar.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaFilterAndBeautyResponseMessage) {
                AlaFilterAndBeautyResponseMessage alaFilterAndBeautyResponseMessage = (AlaFilterAndBeautyResponseMessage) httpResponsedMessage;
                a.this.fNe = alaFilterAndBeautyResponseMessage.bIk();
                if (a.this.fNe != null) {
                    a.this.fNe.aDt = alaFilterAndBeautyResponseMessage.getOrginalMessage().getTag();
                }
                a.this.a(alaFilterAndBeautyResponseMessage);
            }
        }
    };
    private HttpMessageListener fNi = new HttpMessageListener(1021204) { // from class: com.baidu.tieba.ala.alaar.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof AlaArGradingQualityConfigResponseMessage)) {
                a.this.fNg = true;
                if (a.this.fNf) {
                    a.this.b(a.this.fNe);
                    return;
                }
                return;
            }
            if (a.isDebug()) {
                Log.d("ArUpdate", " onMessage getArQualityConfig   " + com.baidu.minivideo.arface.b.VK());
            }
            a.this.fNg = true;
            if (a.this.fNf) {
                if (a.isDebug()) {
                    Log.d("ArUpdate", " onMessage getArQualityConfig   mergeAdjust ");
                }
                a.this.b(a.this.fNe);
            }
        }
    };
    private Context mContext;

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
        bIm();
        bIn();
    }

    private void bIm() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021163, TbConfig.SERVER_ADDRESS + "ala/sys/showConf");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaFilterAndBeautyResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        registerListener(this.fNh);
        registerListener(this.fNi);
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fNh);
        MessageManager.getInstance().unRegisterListener(this.fNi);
    }

    @Override // com.baidu.live.ar.h
    public void a(BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(1021163);
        httpMessage.setTag(bdUniqueId);
        httpMessage.addParam("ar_token", c.AZ().getString("sp_ar_filter_and_beauty_token", ""));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void bIn() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021204, TbConfig.SERVER_ADDRESS + "ala/sys/getArConfig");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaArGradingQualityConfigResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.ar.h
    public void b(BdUniqueId bdUniqueId) {
        b.bIo().init();
    }

    @Override // com.baidu.live.ar.h
    public void destory() {
        unregisterListener();
    }

    @Override // com.baidu.live.ar.h
    public AlaFilterAndBeautyData Cf() {
        return this.fNe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaFilterAndBeautyResponseMessage alaFilterAndBeautyResponseMessage) {
        if (alaFilterAndBeautyResponseMessage == null) {
            Log.d("ArUpdate", "@.@ onGetFilterAndBeauty msg == null");
            eU(this.mContext);
            return;
        }
        AlaFilterAndBeautyData bIk = alaFilterAndBeautyResponseMessage.bIk();
        if (bIk == null) {
            bIk = alaFilterAndBeautyResponseMessage.ti(com.baidu.minivideo.arface.a.getVersion());
        } else {
            az(bIk.aDl, com.baidu.minivideo.arface.a.getVersion());
        }
        if (bIk == null) {
            Log.d("ArUpdate", "@.@ onGetFilterAndBeauty data == null");
            eU(this.mContext);
            return;
        }
        if (isDebug()) {
            Log.d("ArUpdate", " onMessage onGetFilterAndBeauty   ");
        }
        this.fNe = bIk;
        this.fNf = true;
        if (this.fNg) {
            if (isDebug()) {
                Log.d("ArUpdate", " onMessage onGetFilterAndBeauty   mergeAdjust ");
            }
            b(this.fNe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        if (d.a(AlaFilterAndBeautyData.aDs, alaFilterAndBeautyData, com.baidu.minivideo.arface.b.VK(), c.AZ().getBoolean("ar_grading_quality_config_need_update", false))) {
            MessageManager.getInstance().dispatchResponsedMessage(new AlaFilterBeautyDataMessage(2913150, alaFilterAndBeautyData));
            List<e> list = alaFilterAndBeautyData.aDo;
            if (list != null && list.size() > 0) {
                for (e eVar : list) {
                    if (eVar != null && !com.baidu.tieba.ala.alaar.sticker.a.d.Fo(eVar.Cb())) {
                        com.baidu.tieba.ala.alaar.sticker.a.d.a(eVar.Cb(), new d.a() { // from class: com.baidu.tieba.ala.alaar.a.a.3
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

    public void az(String str, int i) {
        if (!StringUtils.isNullObject(str)) {
            c.AZ().putString("sp_ar_filter_and_beauty_token", str);
        }
        if (i > 0) {
            c.AZ().putInt("sp_ar_filter_and_beauty_version", i);
        }
    }

    public boolean eU(Context context) {
        AlaFilterAndBeautyData eV = eV(context);
        eV.aDu = true;
        if (com.baidu.live.ar.d.a(AlaFilterAndBeautyData.aDs, eV, com.baidu.minivideo.arface.b.VK(), c.AZ().getBoolean("ar_grading_quality_config_need_update", false))) {
            MessageManager.getInstance().dispatchResponsedMessage(new AlaFilterBeautyDataMessage(2913150, eV));
            return true;
        }
        return false;
    }

    public AlaFilterAndBeautyData eV(Context context) {
        try {
            JSONObject optJSONObject = new JSONObject(K(context, "arLocalBeauty.json")).optJSONObject("data");
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [335=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.io.BufferedReader */
    /* JADX WARN: Multi-variable type inference failed */
    public String K(Context context, String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isDebug() {
        return com.baidu.minivideo.arface.b.isDebug();
    }
}

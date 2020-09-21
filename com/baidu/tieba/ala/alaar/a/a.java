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
    private AlaFilterAndBeautyData fAV;
    private boolean fAW = false;
    private boolean fAX = false;
    private HttpMessageListener fAY = new HttpMessageListener(1021163) { // from class: com.baidu.tieba.ala.alaar.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaFilterAndBeautyResponseMessage) {
                AlaFilterAndBeautyResponseMessage alaFilterAndBeautyResponseMessage = (AlaFilterAndBeautyResponseMessage) httpResponsedMessage;
                a.this.fAV = alaFilterAndBeautyResponseMessage.bFy();
                if (a.this.fAV != null) {
                    a.this.fAV.aAo = alaFilterAndBeautyResponseMessage.getOrginalMessage().getTag();
                }
                a.this.a(alaFilterAndBeautyResponseMessage);
            }
        }
    };
    private HttpMessageListener fAZ = new HttpMessageListener(1021204) { // from class: com.baidu.tieba.ala.alaar.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof AlaArGradingQualityConfigResponseMessage)) {
                a.this.fAX = true;
                if (a.this.fAW) {
                    a.this.b(a.this.fAV);
                    return;
                }
                return;
            }
            a.this.fAX = true;
            if (a.this.fAW) {
                a.this.b(a.this.fAV);
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
        bFA();
        bFB();
    }

    private void bFA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021163, TbConfig.SERVER_ADDRESS + "ala/sys/showConf");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaFilterAndBeautyResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        registerListener(this.fAY);
        registerListener(this.fAZ);
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fAY);
        MessageManager.getInstance().unRegisterListener(this.fAZ);
    }

    @Override // com.baidu.live.ar.h
    public void a(BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(1021163);
        httpMessage.setTag(bdUniqueId);
        httpMessage.addParam("ar_token", c.AR().getString("sp_ar_filter_and_beauty_token", ""));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void bFB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021204, TbConfig.SERVER_ADDRESS + "ala/sys/getArConfig");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaArGradingQualityConfigResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.live.ar.h
    public void b(BdUniqueId bdUniqueId) {
        b.bFC().init();
    }

    @Override // com.baidu.live.ar.h
    public void destory() {
        unregisterListener();
    }

    @Override // com.baidu.live.ar.h
    public AlaFilterAndBeautyData Bi() {
        return this.fAV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaFilterAndBeautyResponseMessage alaFilterAndBeautyResponseMessage) {
        if (alaFilterAndBeautyResponseMessage == null) {
            Log.d("ArUpdate", "@.@ onGetFilterAndBeauty msg == null");
            eN(this.mContext);
            return;
        }
        AlaFilterAndBeautyData bFy = alaFilterAndBeautyResponseMessage.bFy();
        if (bFy == null) {
            bFy = alaFilterAndBeautyResponseMessage.sK(com.baidu.minivideo.arface.a.getVersion());
        } else {
            ay(bFy.aAg, com.baidu.minivideo.arface.a.getVersion());
        }
        if (bFy == null) {
            Log.d("ArUpdate", "@.@ onGetFilterAndBeauty data == null");
            eN(this.mContext);
            return;
        }
        this.fAV = bFy;
        this.fAW = true;
        if (this.fAX) {
            b(this.fAV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        if (d.a(AlaFilterAndBeautyData.aAn, alaFilterAndBeautyData, com.baidu.minivideo.arface.b.TR(), c.AR().getBoolean("ar_grading_quality_config_need_update", false))) {
            MessageManager.getInstance().dispatchResponsedMessage(new AlaFilterBeautyDataMessage(2913150, alaFilterAndBeautyData));
            List<e> list = alaFilterAndBeautyData.aAj;
            if (list != null && list.size() > 0) {
                for (e eVar : list) {
                    if (eVar != null && !com.baidu.tieba.ala.alaar.sticker.a.d.ED(eVar.Be())) {
                        com.baidu.tieba.ala.alaar.sticker.a.d.a(eVar.Be(), new d.a() { // from class: com.baidu.tieba.ala.alaar.a.a.3
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

    public void ay(String str, int i) {
        if (!StringUtils.isNullObject(str)) {
            c.AR().putString("sp_ar_filter_and_beauty_token", str);
        }
        if (i > 0) {
            c.AR().putInt("sp_ar_filter_and_beauty_version", i);
        }
    }

    public boolean eN(Context context) {
        AlaFilterAndBeautyData eO = eO(context);
        eO.aAp = true;
        if (com.baidu.live.ar.d.a(AlaFilterAndBeautyData.aAn, eO, com.baidu.minivideo.arface.b.TR(), c.AR().getBoolean("ar_grading_quality_config_need_update", false))) {
            MessageManager.getInstance().dispatchResponsedMessage(new AlaFilterBeautyDataMessage(2913150, eO));
            return true;
        }
        return false;
    }

    public AlaFilterAndBeautyData eO(Context context) {
        try {
            JSONObject optJSONObject = new JSONObject(aH(context, "arLocalBeauty.json")).optJSONObject("data");
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [333=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.io.BufferedReader */
    /* JADX WARN: Multi-variable type inference failed */
    public String aH(Context context, String str) {
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
}

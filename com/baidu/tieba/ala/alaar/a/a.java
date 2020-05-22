package com.baidu.tieba.ala.alaar.a;

import android.content.Context;
import android.util.Log;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.AlaFilterBeautyDataMessage;
import com.baidu.live.ar.f;
import com.baidu.live.c;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.alaar.messages.AlaFilterAndBeautyResponseMessage;
import com.baidu.tieba.ala.alaar.sticker.a.d;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends BdBaseModel implements f {
    private AlaFilterAndBeautyData eWC;
    private HttpMessageListener eWD = new HttpMessageListener(1021163) { // from class: com.baidu.tieba.ala.alaar.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaFilterAndBeautyResponseMessage) {
                AlaFilterAndBeautyResponseMessage alaFilterAndBeautyResponseMessage = (AlaFilterAndBeautyResponseMessage) httpResponsedMessage;
                a.this.eWC = alaFilterAndBeautyResponseMessage.bpz();
                if (a.this.eWC != null) {
                    a.this.eWC.asO = alaFilterAndBeautyResponseMessage.getOrginalMessage().getTag();
                }
                a.this.a(alaFilterAndBeautyResponseMessage);
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
        bpB();
    }

    private void bpB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021163, TbConfig.SERVER_ADDRESS + "ala/sys/showConf");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaFilterAndBeautyResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        registerListener(this.eWD);
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eWD);
    }

    @Override // com.baidu.live.ar.f
    public void a(BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(1021163);
        httpMessage.setTag(bdUniqueId);
        httpMessage.addParam("ar_token", c.uN().getString("sp_ar_filter_and_beauty_token", ""));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.ar.f
    public void destory() {
        unregisterListener();
    }

    @Override // com.baidu.live.ar.f
    public AlaFilterAndBeautyData va() {
        return this.eWC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaFilterAndBeautyResponseMessage alaFilterAndBeautyResponseMessage) {
        if (alaFilterAndBeautyResponseMessage == null) {
            Log.d("ArUpdate", "@.@ onGetFilterAndBeauty msg == null");
            et(this.mContext);
            return;
        }
        AlaFilterAndBeautyData bpz = alaFilterAndBeautyResponseMessage.bpz();
        if (bpz == null) {
            bpz = alaFilterAndBeautyResponseMessage.pr(com.baidu.minivideo.arface.a.getVersion());
        } else {
            aw(bpz.asH, com.baidu.minivideo.arface.a.getVersion());
        }
        if (bpz == null) {
            Log.d("ArUpdate", "@.@ onGetFilterAndBeauty data == null");
            et(this.mContext);
            return;
        }
        b(bpz);
    }

    private void b(AlaFilterAndBeautyData alaFilterAndBeautyData) {
        if (com.baidu.live.ar.c.a(AlaFilterAndBeautyData.asN, alaFilterAndBeautyData)) {
            if (!d.AH(alaFilterAndBeautyData.asL)) {
                d.a(alaFilterAndBeautyData.asL, new d.a() { // from class: com.baidu.tieba.ala.alaar.a.a.2
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
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, str));
                    }

                    @Override // com.baidu.tieba.ala.alaar.sticker.a.d.a
                    public void onFailed(int i, int i2, String str) {
                        Log.e("ArUpdate", "onFailed ");
                    }
                });
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, d.AK(d.AG(alaFilterAndBeautyData.asL))));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new AlaFilterBeautyDataMessage(2913150, alaFilterAndBeautyData));
        }
    }

    public void aw(String str, int i) {
        if (!StringUtils.isNullObject(str)) {
            c.uN().putString("sp_ar_filter_and_beauty_token", str);
        }
        if (i > 0) {
            c.uN().putInt("sp_ar_filter_and_beauty_version", i);
        }
    }

    public boolean et(Context context) {
        AlaFilterAndBeautyData eu = eu(context);
        eu.asP = true;
        if (com.baidu.live.ar.c.a(AlaFilterAndBeautyData.asN, eu)) {
            MessageManager.getInstance().dispatchResponsedMessage(new AlaFilterBeautyDataMessage(2913150, eu));
            return true;
        }
        return false;
    }

    public AlaFilterAndBeautyData eu(Context context) {
        try {
            JSONObject optJSONObject = new JSONObject(aB(context, "arLocalBeauty.json")).optJSONObject("data");
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [248=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.io.BufferedReader */
    /* JADX WARN: Multi-variable type inference failed */
    public String aB(Context context, String str) {
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

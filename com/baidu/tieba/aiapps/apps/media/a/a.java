package com.baidu.tieba.aiapps.apps.media.a;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.swan.apps.adaptation.a.u;
import com.baidu.swan.apps.media.chooser.c.c;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements u {
    private static BroadcastReceiver dZC = null;
    c dZA;
    CustomMessageListener dZB = new CustomMessageListener(2921365) { // from class: com.baidu.tieba.aiapps.apps.media.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0081  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Intent intent;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Intent) {
                    intent = (Intent) data;
                    if (intent == null) {
                        String stringExtra = intent.getStringExtra("album_result");
                        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                        writeImagesInfo.parseJson(stringExtra);
                        writeImagesInfo.updateQuality();
                        if (a.this.dZA != null) {
                            ArrayList arrayList = new ArrayList();
                            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
                            if (chosedFiles != null && chosedFiles.size() > 0) {
                                for (ImageFileInfo imageFileInfo : chosedFiles) {
                                    if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath())) {
                                        arrayList.add(imageFileInfo.getFilePath());
                                    }
                                }
                                a.this.dZA.V(arrayList);
                            } else {
                                a.this.dZA.iL(UgcUBCUtils.UGC_TIME_CANCEL);
                            }
                        }
                    } else if (a.this.dZA != null) {
                        a.this.dZA.iL(BdStatsConstant.StatsType.ERROR);
                    }
                    e.gy().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.a.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dZA = null;
                            MessageManager.getInstance().unRegisterListener(a.this.dZB);
                        }
                    });
                }
            }
            intent = null;
            if (intent == null) {
            }
            e.gy().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.a.a.1.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dZA = null;
                    MessageManager.getInstance().unRegisterListener(a.this.dZB);
                }
            });
        }
    };

    @Override // com.baidu.swan.apps.adaptation.a.u
    @TargetApi(19)
    public void a(Context context, String[] strArr, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("source", "swan");
                jSONObject.put("from", "");
                jSONObject.put("url", new JSONArray(strArr));
                jSONObject.put("type", "0");
                jSONObject.put("index", String.valueOf(i));
                n(context, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.u
    public void i(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("index");
            JSONArray optJSONArray = jSONObject.optJSONArray("urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                String[] strArr = new String[length];
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        strArr[i] = optString;
                    }
                }
                a(context, strArr, optInt);
            }
        }
    }

    public void n(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            jSONObject.optString("source");
            jSONObject.optString("from");
            jSONObject.optString("type");
            String optString = jSONObject.optString("index");
            JSONArray optJSONArray = jSONObject.optJSONArray("url");
            int i = com.baidu.adp.lib.f.b.toInt(optString, 0);
            int length = optJSONArray.length();
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < length; i2++) {
                String optString2 = optJSONArray.optString(i2);
                if (optString2 != null) {
                    arrayList.add(optString2);
                }
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(context).createConfig(arrayList, i, "", "", "", true, arrayList.size() > 0 ? arrayList.get(0) : "", true, null, true, false, false);
            createConfig.setIsFromAiApp(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
        }
    }
}

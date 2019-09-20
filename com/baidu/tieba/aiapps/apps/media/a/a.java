package com.baidu.tieba.aiapps.apps.media.a;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.swan.apps.scheme.actions.d;
import com.baidu.swan.apps.u.b.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements l {
    private static BroadcastReceiver dgS = null;
    d.a dgQ;
    CustomMessageListener dgR = new CustomMessageListener(2921365) { // from class: com.baidu.tieba.aiapps.apps.media.a.a.2
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
                        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
                        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                        writeImagesInfo.parseJson(stringExtra);
                        writeImagesInfo.updateQuality();
                        if (a.this.dgQ != null) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
                            if (chosedFiles != null && chosedFiles.size() > 0) {
                                for (ImageFileInfo imageFileInfo : chosedFiles) {
                                    if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath())) {
                                        arrayList.add(imageFileInfo.getFilePath());
                                    }
                                }
                                a.this.dgQ.i(arrayList);
                            } else {
                                a.this.dgQ.hf("cancel");
                            }
                        }
                    } else if (a.this.dgQ != null) {
                        a.this.dgQ.hf("error");
                    }
                    e.iK().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.a.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dgQ = null;
                            MessageManager.getInstance().unRegisterListener(a.this.dgR);
                        }
                    });
                }
            }
            intent = null;
            if (intent == null) {
            }
            e.iK().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.a.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dgQ = null;
                    MessageManager.getInstance().unRegisterListener(a.this.dgR);
                }
            });
        }
    };

    @Override // com.baidu.swan.apps.u.b.l
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
                g(context, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.l
    public void a(Context context, int i, d.a aVar) {
        if (aVar != null) {
            b(context, i, aVar);
        }
    }

    public void g(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            jSONObject.optString("source");
            jSONObject.optString("from");
            jSONObject.optString("type");
            String optString = jSONObject.optString("index");
            JSONArray optJSONArray = jSONObject.optJSONArray("url");
            int f = com.baidu.adp.lib.g.b.f(optString, 0);
            int length = optJSONArray.length();
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                String optString2 = optJSONArray.optString(i);
                if (optString2 != null) {
                    arrayList.add(optString2);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, new ImageViewerConfig(context).createConfig(arrayList, f, "", "", "", true, arrayList.size() > 0 ? arrayList.get(0) : "", true, null, true, false, false, -1, true)));
        }
    }

    public void b(Context context, int i, d.a aVar) {
        this.dgQ = aVar;
        if (i < 1) {
            i = 1;
        }
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        if (i < 1) {
            i = 9;
        }
        writeImagesInfo.setMaxImagesAllowed(i);
        writeImagesInfo.setOriginalImg(true);
        writeImagesInfo.setEnableChooseOriginalImg(false);
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(context, writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, AlbumActivityConfig.FROM_AIAPPS);
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        if (dgS == null) {
            dgS = new BroadcastReceiver() { // from class: com.baidu.tieba.aiapps.apps.media.a.a.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921365, intent));
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
            TbadkCoreApplication.getInst().registerReceiver(dgS, intentFilter);
        }
        MessageManager.getInstance().registerListener(this.dgR);
    }
}

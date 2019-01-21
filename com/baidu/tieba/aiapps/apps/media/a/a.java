package com.baidu.tieba.aiapps.apps.media.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.g.e;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppImageIoc;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.ChooseImageAction;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements IAiAppImageIoc {
    private static BroadcastReceiver bJy = null;
    ChooseImageAction.OnImageChooseResultCallback bJw;
    CustomMessageListener bJx = new CustomMessageListener(2921365) { // from class: com.baidu.tieba.aiapps.apps.media.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0086  */
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
                        if (a.this.bJw != null) {
                            ArrayList arrayList = new ArrayList();
                            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
                            if (chosedFiles != null && chosedFiles.size() > 0) {
                                for (ImageFileInfo imageFileInfo : chosedFiles) {
                                    if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath())) {
                                        arrayList.add(imageFileInfo.getFilePath());
                                    }
                                }
                                a.this.bJw.onResult(true, "suc", arrayList);
                            } else {
                                a.this.bJw.onResult(false, AiAppsUBCStatistic.VALUE_CANCEL, null);
                            }
                        }
                    } else if (a.this.bJw != null) {
                        a.this.bJw.onResult(false, AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, null);
                    }
                    e.jG().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.a.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.bJw = null;
                            MessageManager.getInstance().unRegisterListener(a.this.bJx);
                        }
                    });
                }
            }
            intent = null;
            if (intent == null) {
            }
            e.jG().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.a.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bJw = null;
                    MessageManager.getInstance().unRegisterListener(a.this.bJx);
                }
            });
        }
    };

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppImageIoc
    public void launchPictureBrowser(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            jSONObject.optString("source");
            jSONObject.optString("from");
            jSONObject.optString("type");
            String optString = jSONObject.optString("index");
            JSONArray optJSONArray = jSONObject.optJSONArray("url");
            int l = b.l(optString, 0);
            int length = optJSONArray.length();
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                String optString2 = optJSONArray.optString(i);
                if (optString2 != null) {
                    arrayList.add(optString2);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, new ImageViewerConfig(context).createConfig(arrayList, l, "", "", "", true, arrayList.size() > 0 ? arrayList.get(0) : "", true, null, true, false, false, -1, true)));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppImageIoc
    public void chooseImage(Context context, int i, ChooseImageAction.OnImageChooseResultCallback onImageChooseResultCallback) {
        this.bJw = onImageChooseResultCallback;
        if (i < 1) {
            i = 1;
        }
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        if (i < 1) {
            i = 10;
        }
        writeImagesInfo.setMaxImagesAllowed(i);
        writeImagesInfo.setOriginalImg(true);
        writeImagesInfo.setEnableChooseOriginalImg(false);
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(context, writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, AlbumActivityConfig.FROM_AIAPPS);
        albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        if (bJy == null) {
            bJy = new BroadcastReceiver() { // from class: com.baidu.tieba.aiapps.apps.media.a.a.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921365, intent));
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
            TbadkCoreApplication.getInst().registerReceiver(bJy, intentFilter);
        }
        MessageManager.getInstance().registerListener(this.bJx);
    }
}

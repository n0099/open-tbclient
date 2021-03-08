package com.baidu.tieba.faceshop;

import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.newfaceshop.FaceBaseModel;
import com.tencent.open.SocialConstants;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class UserCollectModel extends FaceBaseModel {
    public static final String ALL_DELETE = "all_delete";
    private final HttpMessageListener gKK = new HttpMessageListener(1003339) { // from class: com.baidu.tieba.faceshop.UserCollectModel.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003339 && (httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                JsonHttpResponsedMessage jsonHttpResponsedMessage = (JsonHttpResponsedMessage) httpResponsedMessage;
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.faceshop.UserCollectModel.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UserCollectModel.this.cancelLoadData();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, 2000L);
            }
        }
    };

    public UserCollectModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.gKK.setTag(getUniqueId());
        this.gKK.setSelfListener(true);
        registerListener(this.gKK);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003339, TbConfig.SERVER_ADDRESS + Config.USER_COLLECT_EMOTION_UPDATE);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.gKK);
        MessageManager.getInstance().unRegisterTask(1003339);
        return true;
    }

    public void upload() {
        new Thread(new Runnable() { // from class: com.baidu.tieba.faceshop.UserCollectModel.1
            @Override // java.lang.Runnable
            public void run() {
                List<CollectEmotionData> JP = i.cyR().JP(TbadkCoreApplication.getCurrentAccountForEmotion());
                HashSet hashSet = new HashSet();
                if (JP != null) {
                    JSONArray jSONArray = new JSONArray();
                    try {
                        for (CollectEmotionData collectEmotionData : JP) {
                            if (!com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(collectEmotionData.sharpText) && !hashSet.contains(collectEmotionData.sharpText)) {
                                jSONArray.put(collectEmotionData.toJSON());
                                hashSet.add(collectEmotionData.sharpText);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    HttpMessage httpMessage = new HttpMessage(1003339);
                    if (jSONArray.length() > 0) {
                        httpMessage.addParam(SocialConstants.PARAM_IMAGE, com.baidu.tbadk.browser.c.toURLEncoded(jSONArray.toString()));
                    } else {
                        httpMessage.addParam(SocialConstants.PARAM_IMAGE, UserCollectModel.ALL_DELETE);
                    }
                    httpMessage.addParam("pic_update_time", currentTimeMillis);
                    UserCollectModel.this.sendMessage(httpMessage);
                    com.baidu.tieba.newfaceshop.d.hn(currentTimeMillis);
                }
            }
        }).start();
    }
}

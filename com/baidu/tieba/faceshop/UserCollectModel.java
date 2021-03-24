package com.baidu.tieba.faceshop;

import android.os.Handler;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.newfaceshop.FaceBaseModel;
import com.tencent.open.SocialConstants;
import d.b.h0.a0.d;
import d.b.h0.l.c;
import d.b.i0.l0.g;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class UserCollectModel extends FaceBaseModel {
    public static final String ALL_DELETE = "all_delete";

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f15721e = new b(CmdConfigHttp.CMD_UPLOAD_COLLECT_EMOTION_INFO);

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<CollectEmotionData> n = g.k().n(TbadkCoreApplication.getCurrentAccountForEmotion());
            HashSet hashSet = new HashSet();
            if (n == null) {
                return;
            }
            JSONArray jSONArray = new JSONArray();
            try {
                for (CollectEmotionData collectEmotionData : n) {
                    if (!d.f49682d.equals(collectEmotionData.sharpText) && !hashSet.contains(collectEmotionData.sharpText)) {
                        jSONArray.put(collectEmotionData.toJSON());
                        hashSet.add(collectEmotionData.sharpText);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            long currentTimeMillis = System.currentTimeMillis();
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_UPLOAD_COLLECT_EMOTION_INFO);
            if (jSONArray.length() > 0) {
                httpMessage.addParam(SocialConstants.PARAM_IMAGE, c.o(jSONArray.toString()));
            } else {
                httpMessage.addParam(SocialConstants.PARAM_IMAGE, UserCollectModel.ALL_DELETE);
            }
            httpMessage.addParam("pic_update_time", currentTimeMillis);
            UserCollectModel.this.sendMessage(httpMessage);
            d.b.i0.x1.d.s(currentTimeMillis);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    UserCollectModel.this.cancelLoadData();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003339 && (httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                JsonHttpResponsedMessage jsonHttpResponsedMessage = (JsonHttpResponsedMessage) httpResponsedMessage;
                new Handler().postDelayed(new a(), 2000L);
            }
        }
    }

    public UserCollectModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f15721e.setTag(getUniqueId());
        this.f15721e.setSelfListener(true);
        registerListener(this.f15721e);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.f15721e);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_UPLOAD_COLLECT_EMOTION_INFO);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_UPLOAD_COLLECT_EMOTION_INFO, TbConfig.SERVER_ADDRESS + "c/e/meme/collect");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void s() {
        new Thread(new a()).start();
    }
}

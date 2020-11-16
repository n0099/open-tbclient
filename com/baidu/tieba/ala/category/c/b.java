package com.baidu.tieba.ala.category.c;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.category.b.d;
import com.baidu.tieba.ala.category.message.AlaTagResponseMessage;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    private String bme;
    private a guD;
    private HttpMessageListener guE;
    private HttpMessageListener guF;
    private List<d> gum;
    private String mLiveId;

    /* loaded from: classes4.dex */
    public interface a {
        void aS(int i, String str);

        void bQb();

        void bQc();

        void bQd();
    }

    public b(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.guE = new HttpMessageListener(1021191) { // from class: com.baidu.tieba.ala.category.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaTagResponseMessage) {
                    AlaTagResponseMessage alaTagResponseMessage = (AlaTagResponseMessage) httpResponsedMessage;
                    if (!alaTagResponseMessage.isSuccess() || ListUtils.isEmpty(alaTagResponseMessage.getTagList())) {
                        if (b.this.guD != null) {
                            b.this.guD.aS(alaTagResponseMessage.getError(), alaTagResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    b.this.gum = alaTagResponseMessage.getTagList();
                    if (b.this.guD != null) {
                        b.this.guD.bQb();
                    }
                }
            }
        };
        this.guF = new HttpMessageListener(1021192) { // from class: com.baidu.tieba.ala.category.c.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || !httpResponsedMessage.isSuccess() || httpResponsedMessage.getError() != 0) {
                    if (b.this.guD != null) {
                        b.this.guD.bQd();
                    }
                } else if (b.this.guD != null) {
                    b.this.guD.bQc();
                }
            }
        };
        this.bme = str;
        this.mLiveId = str2;
        registerTask();
        registerListener();
    }

    private void registerTask() {
        bQr();
        bQs();
    }

    private void bQr() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021191, TbConfig.SERVER_ADDRESS + "ala/tag/getAnchorTags");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaTagResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bQs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021192, TbConfig.SERVER_ADDRESS + "ala/tag/addAnchorTags");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        registerListener(this.guE);
        registerListener(this.guF);
    }

    public List<d> getTagList() {
        return this.gum;
    }

    public void bQt() {
        HttpMessage httpMessage = new HttpMessage(1021191);
        httpMessage.addParam("anchor_id", this.bme);
        sendMessage(httpMessage);
    }

    public void ci(List<String> list) {
        if (!ListUtils.isEmpty(list)) {
            JSONArray jSONArray = new JSONArray();
            for (String str : list) {
                if (!StringUtils.isNull(str)) {
                    jSONArray.put(str);
                }
            }
            if (jSONArray.length() > 0) {
                String str2 = null;
                try {
                    str2 = URLEncoder.encode(jSONArray.toString(), "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (!StringUtils.isNull(str2)) {
                    HttpMessage httpMessage = new HttpMessage(1021192);
                    httpMessage.addParam("anchor_id", this.bme);
                    httpMessage.addParam("live_id", this.mLiveId);
                    httpMessage.addParam(CommandMessage.TYPE_TAGS, str2);
                    sendMessage(httpMessage);
                }
            }
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return true;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.guD = aVar;
    }
}

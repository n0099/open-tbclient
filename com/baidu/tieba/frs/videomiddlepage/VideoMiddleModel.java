package com.baidu.tieba.frs.videomiddlepage;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class VideoMiddleModel extends BdBaseModel {
    public static final String TYPE_CALL_FROM_FRS = "client_frs";
    public static final String TYPE_CALL_FROM_INDEX = "client_index";
    public static final String TYPE_CALL_FROM_OTHER = "client_other";
    private final HttpMessageListener dQy;
    private String ehA;
    private a ehz;
    private String mFrom;
    private String mId;
    private boolean mIsLoading;
    private TbPageContext mPageContext;
    private int mPn;
    private String st_type;
    private String yuelaou_locate;

    /* loaded from: classes3.dex */
    public interface a {
        void i(List<com.baidu.tieba.card.data.b> list, boolean z);

        void ol(String str);
    }

    static /* synthetic */ int b(VideoMiddleModel videoMiddleModel) {
        int i = videoMiddleModel.mPn;
        videoMiddleModel.mPn = i - 1;
        return i;
    }

    public VideoMiddleModel(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.ehA = "client_other";
        this.dQy = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003378 || !(httpResponsedMessage instanceof VideoMiddleDataResponseMessage)) {
                    VideoMiddleModel.this.ehz.ol(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR);
                    return;
                }
                VideoMiddleModel.this.mIsLoading = false;
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    VideoMiddleModel.b(VideoMiddleModel.this);
                    String errorString = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = TbadkCoreApplication.getInst().getResources().getString(e.j.error_unkown_try_again);
                    }
                    VideoMiddleModel.this.ehz.ol(errorString);
                    return;
                }
                TbSingleton.getInstance().clearVideoRecord();
                VideoMiddleModel.this.ehz.i(((VideoMiddleDataResponseMessage) httpResponsedMessage).mDataList, ((VideoMiddleDataResponseMessage) httpResponsedMessage).mHasMore);
            }
        };
        this.mPageContext = tbPageContext;
        this.ehz = aVar;
        registerTask();
        this.dQy.setTag(getUniqueId());
        this.dQy.setSelfListener(true);
        registerListener(this.dQy);
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void ok(String str) {
        this.st_type = str;
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION, TbConfig.SERVER_ADDRESS + "c/f/video/getVideoMidPage");
        tbHttpMessageTask.setResponsedClass(VideoMiddleDataResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* loaded from: classes3.dex */
    public static class VideoMiddleDataResponseMessage extends JsonHttpResponsedMessage {
        public List<com.baidu.tieba.card.data.b> mDataList;
        public boolean mHasMore;

        public VideoMiddleDataResponseMessage(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                this.mHasMore = jSONObject.optInt("has_more") == 1;
                String optString = jSONObject.optString("list");
                if (!TextUtils.isEmpty(optString)) {
                    this.mDataList = new ArrayList();
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        com.baidu.tieba.frs.aggregation.g gVar = new com.baidu.tieba.frs.aggregation.g();
                        gVar.parseJson(jSONArray.optString(i2));
                        if (gVar.dQn != null) {
                            this.mDataList.add(gVar);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (TextUtils.isEmpty(this.mId) || this.mIsLoading) {
            return false;
        }
        this.mIsLoading = true;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
        httpMessage.addParam("tid", this.mId);
        httpMessage.addParam("st_type", this.st_type);
        httpMessage.addParam("yuelaou_locate", this.yuelaou_locate);
        int i = this.mPn + 1;
        this.mPn = i;
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("user_view_data", aIx());
        if ("frs".equals(this.mFrom)) {
            this.ehA = "client_frs";
        } else if ("index".equals(this.mFrom)) {
            this.ehA = "client_index";
        } else {
            this.ehA = "client_other";
        }
        httpMessage.addParam(IntentConfig.CALL_FROM, this.ehA);
        sendMessage(httpMessage);
        return true;
    }

    private String aIx() {
        JSONArray jSONArray = new JSONArray();
        LinkedList<com.baidu.tbadk.c.a> videoRecordList = TbSingleton.getInstance().getVideoRecordList();
        if (videoRecordList != null) {
            try {
                if (videoRecordList.size() > 0) {
                    Iterator<com.baidu.tbadk.c.a> it = videoRecordList.iterator();
                    while (it.hasNext()) {
                        com.baidu.tbadk.c.a next = it.next();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("tid", next.getKey());
                        jSONObject.put("duration", next.getValue());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        return jSONArray.toString();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
        return false;
    }

    public int getPageNum() {
        return this.mPn;
    }
}

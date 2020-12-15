package com.baidu.tieba.frs.videomiddlepage;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VideoMiddleModel extends BdBaseModel {
    public static final String TYPE_CALL_FROM_FRS = "client_frs";
    public static final String TYPE_CALL_FROM_INDEX = "client_index";
    public static final String TYPE_CALL_FROM_OTHER = "client_other";
    private final HttpMessageListener jaY;
    private VideoSerializeVideoThreadInfo jzq;
    private a jzr;
    private String jzs;
    private String mFrom;
    private String mId;
    private boolean mIsLoading;
    private TbPageContext mPageContext;
    private int mPn;
    private String st_type;
    private String yuelaou_locate;

    /* loaded from: classes.dex */
    public interface a {
        void o(List<BaseCardInfo> list, boolean z);

        void ws(String str);
    }

    static /* synthetic */ int b(VideoMiddleModel videoMiddleModel) {
        int i = videoMiddleModel.mPn;
        videoMiddleModel.mPn = i - 1;
        return i;
    }

    public VideoMiddleModel(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.jzs = "client_other";
        this.jaY = new HttpMessageListener(1003378) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003378 || !(httpResponsedMessage instanceof VideoMiddleDataResponseMessage)) {
                    if (VideoMiddleModel.this.jzr != null) {
                        VideoMiddleModel.this.jzr.ws(BdStatsConstant.StatsType.ERROR);
                        return;
                    }
                    return;
                }
                VideoMiddleModel.this.mIsLoading = false;
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    VideoMiddleModel.b(VideoMiddleModel.this);
                    String errorString = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = TbadkCoreApplication.getInst().getResources().getString(R.string.error_unkown_try_again);
                    }
                    if (VideoMiddleModel.this.jzr != null) {
                        VideoMiddleModel.this.jzr.ws(errorString);
                        return;
                    }
                    return;
                }
                TbSingleton.getInstance().clearVideoRecord();
                if (VideoMiddleModel.this.jzr != null) {
                    VideoMiddleModel.this.jzr.o(((VideoMiddleDataResponseMessage) httpResponsedMessage).mDataList, ((VideoMiddleDataResponseMessage) httpResponsedMessage).mHasMore);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jzr = aVar;
        registerTask();
        this.jaY.setTag(getUniqueId());
        this.jaY.setSelfListener(true);
        registerListener(this.jaY);
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void KP(String str) {
        this.st_type = str;
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
    }

    public void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.jzq = videoSerializeVideoThreadInfo;
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003378, TbConfig.SERVER_ADDRESS + Config.VIDEO_MIDDLE_AGGREGATION);
        tbHttpMessageTask.setResponsedClass(VideoMiddleDataResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* loaded from: classes.dex */
    public static class VideoMiddleDataResponseMessage extends JsonHttpResponsedMessage {
        public List<BaseCardInfo> mDataList;
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
                        if (gVar.jaF != null) {
                            this.mDataList.add(gVar);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.mIsLoading) {
            return false;
        }
        this.mIsLoading = true;
        HttpMessage httpMessage = new HttpMessage(1003378);
        httpMessage.addParam("tid", this.mId);
        httpMessage.addParam("st_type", this.st_type);
        httpMessage.addParam("yuelaou_locate", this.yuelaou_locate);
        int i = this.mPn + 1;
        this.mPn = i;
        httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, i);
        httpMessage.addParam("user_view_data", cLL());
        if ("frs".equals(this.mFrom)) {
            this.jzs = "client_frs";
        } else if ("index".equals(this.mFrom)) {
            this.jzs = "client_index";
        } else {
            this.jzs = "client_other";
        }
        httpMessage.addParam("call_from", this.jzs);
        this.jzs = "client_index";
        if (this.jzq != null && this.jzq.mBaijiahaoData != null) {
            httpMessage.addParam("ori_ugc_nid", this.jzq.mBaijiahaoData.oriUgcNid);
            httpMessage.addParam("ori_ugc_type", this.jzq.mBaijiahaoData.oriUgcType);
            httpMessage.addParam("ori_ugc_vid", this.jzq.mBaijiahaoData.oriUgcVid);
            httpMessage.addParam("ori_ugc_tid", this.jzq.mBaijiahaoData.oriUgcTid);
        }
        sendMessage(httpMessage);
        return true;
    }

    private String cLL() {
        JSONArray jSONArray = new JSONArray();
        LinkedList<com.baidu.tbadk.d.a> videoRecordList = TbSingleton.getInstance().getVideoRecordList();
        if (videoRecordList != null) {
            try {
                if (videoRecordList.size() > 0) {
                    Iterator<com.baidu.tbadk.d.a> it = videoRecordList.iterator();
                    while (it.hasNext()) {
                        com.baidu.tbadk.d.a next = it.next();
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
        MessageManager.getInstance().unRegisterTask(1003378);
        return false;
    }

    public int getPageNum() {
        return this.mPn;
    }
}

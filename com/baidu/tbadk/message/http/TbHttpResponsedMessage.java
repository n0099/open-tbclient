package com.baidu.tbadk.message.http;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.util.NetWorkState;
import d.b.c.e.j.a.d;
import d.b.c.e.j.a.e;
import d.b.c.e.p.j;
/* loaded from: classes3.dex */
public class TbHttpResponsedMessage extends HttpResponsedMessage {
    public TbHttpResponsedMessage(int i) {
        super(i);
    }

    private int getMode(int i) {
        if (i != 1) {
            if (i == 2) {
                return 2;
            }
            if (i == 3) {
                return 3;
            }
        }
        return 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
    }

    public String getCharset() throws Exception {
        int indexOf;
        String contentType = getContentType();
        if (contentType == null || (indexOf = contentType.indexOf("charset")) == -1) {
            return "utf-8";
        }
        int indexOf2 = contentType.indexOf(32, indexOf);
        if (indexOf2 == -1) {
            return contentType.substring(indexOf + 8);
        }
        return contentType.substring(indexOf + 8, indexOf2);
    }

    @Override // com.baidu.adp.framework.message.HttpResponsedMessage
    public void logStatInBackground(int i, e eVar) {
        if (eVar.d().size() > 0) {
            d dVar = eVar.d().get(eVar.d().size() - 1);
            NetWorkState.mErrorNums.addAndGet(eVar.d().size() - 1);
            NetWorkState.StatisticsData statisticsData = new NetWorkState.StatisticsData();
            statisticsData.mMode = getMode(j.I());
            statisticsData.mSize = dVar.f42276b;
            statisticsData.mTime = dVar.f42280f;
            statisticsData.mTimesNum = dVar.f42279e;
            statisticsData.mMethod = eVar.b().h() != HttpMessageTask.HTTP_METHOD.POST ? 2 : 1;
            NetWorkState.addStatisticsData(statisticsData);
        }
    }

    public String parseToString(byte[] bArr) throws Exception {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, getCharset());
    }
}

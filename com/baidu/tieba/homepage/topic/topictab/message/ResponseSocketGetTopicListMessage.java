package com.baidu.tieba.homepage.topic.topictab.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.squareup.wire.Wire;
import d.b.b.j.e.n;
import d.b.i0.z0.j.b.c.a;
import d.b.i0.z0.j.b.c.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewTopicList.DataRes;
import tbclient.NewTopicList.NewTopicList;
import tbclient.NewTopicList.NewTopicListResIdl;
/* loaded from: classes4.dex */
public class ResponseSocketGetTopicListMessage extends SocketResponsedMessage {
    public List<n> mTopicDataList;

    public ResponseSocketGetTopicListMessage() {
        super(309628);
    }

    public List<n> getTopicDataList() {
        return this.mTopicDataList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        NewTopicListResIdl newTopicListResIdl = (NewTopicListResIdl) new Wire(new Class[0]).parseFrom(bArr, NewTopicListResIdl.class);
        if (newTopicListResIdl == null) {
            return;
        }
        setError(newTopicListResIdl.error.errorno.intValue());
        setErrorString(newTopicListResIdl.error.usermsg);
        if (getError() != 0 || (dataRes = newTopicListResIdl.data) == null || ListUtils.isEmpty(dataRes.topic_list)) {
            return;
        }
        this.mTopicDataList = new ArrayList();
        int i2 = 1;
        for (NewTopicList newTopicList : newTopicListResIdl.data.topic_list) {
            if (newTopicList != null && !StringUtils.isNull(newTopicList.topic_name) && !StringUtils.isNull(newTopicList.topic_desc)) {
                a aVar = new a();
                aVar.S = i2;
                aVar.a0(newTopicList);
                this.mTopicDataList.add(aVar);
                c cVar = new c();
                cVar.f63366e = R.dimen.tbds1;
                cVar.f63367f = R.color.CAM_X0203;
                this.mTopicDataList.add(cVar);
                i2++;
            }
        }
        List<n> list = this.mTopicDataList;
        ((c) ListUtils.getItem(list, list.size() - 1)).f63366e = 0;
    }
}

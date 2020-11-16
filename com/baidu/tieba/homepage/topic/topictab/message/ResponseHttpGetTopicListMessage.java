package com.baidu.tieba.homepage.topic.topictab.message;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.a;
import com.baidu.tieba.homepage.topic.topictab.b.c;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewTopicList.NewTopicList;
import tbclient.NewTopicList.NewTopicListResIdl;
/* loaded from: classes21.dex */
public class ResponseHttpGetTopicListMessage extends TbHttpResponsedMessage {
    private List<q> mTopicDataList;

    public ResponseHttpGetTopicListMessage() {
        super(CmdConfigHttp.CMD_TOPIC_LIST);
    }

    public List<q> getTopicDataList() {
        return this.mTopicDataList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        NewTopicListResIdl newTopicListResIdl = (NewTopicListResIdl) new Wire(new Class[0]).parseFrom(bArr, NewTopicListResIdl.class);
        if (newTopicListResIdl != null) {
            setError(newTopicListResIdl.error.errorno.intValue());
            setErrorString(newTopicListResIdl.error.usermsg);
            if (getError() == 0 && newTopicListResIdl.data != null && !y.isEmpty(newTopicListResIdl.data.topic_list)) {
                this.mTopicDataList = new ArrayList();
                int i2 = 1;
                for (NewTopicList newTopicList : newTopicListResIdl.data.topic_list) {
                    if (newTopicList != null && !StringUtils.isNull(newTopicList.topic_name) && !StringUtils.isNull(newTopicList.topic_desc)) {
                        a aVar = new a();
                        aVar.index = i2;
                        aVar.a(newTopicList);
                        this.mTopicDataList.add(aVar);
                        c cVar = new c();
                        cVar.iob = R.dimen.tbds1;
                        cVar.eHJ = R.color.CAM_X0203;
                        this.mTopicDataList.add(cVar);
                        i2++;
                    }
                }
                ((c) y.getItem(this.mTopicDataList, this.mTopicDataList.size() - 1)).iob = 0;
            }
        }
    }
}

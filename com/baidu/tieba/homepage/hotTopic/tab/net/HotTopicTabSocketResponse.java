package com.baidu.tieba.homepage.hotTopic.tab.net;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.c;
import com.baidu.tieba.homepage.hotTopic.tab.b.d;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
import com.baidu.tieba.homepage.hotTopic.tab.b.f;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.HotThreadList.HotThreadListResIdl;
/* loaded from: classes16.dex */
public class HotTopicTabSocketResponse extends SocketResponsedMessage implements a {
    private List<q> mHotTopicDataList;

    public HotTopicTabSocketResponse() {
        super(309661);
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.net.a
    public List<q> getDataList() {
        return this.mHotTopicDataList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        int i2;
        boolean z = false;
        HotThreadListResIdl hotThreadListResIdl = (HotThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, HotThreadListResIdl.class);
        if (hotThreadListResIdl != null) {
            setError(hotThreadListResIdl.error.errorno.intValue());
            setErrorString(hotThreadListResIdl.error.usermsg);
            if (getError() == 0 && hotThreadListResIdl.data != null) {
                this.mHotTopicDataList = new ArrayList();
                if (!x.isEmpty(hotThreadListResIdl.data.topic_list)) {
                    this.mHotTopicDataList.add(new f(TbadkCoreApplication.getInst().getString(R.string.hot_topic_tab_rank_list_title)));
                    this.mHotTopicDataList.add(new c(hotThreadListResIdl.data.topic_list));
                }
                this.mHotTopicDataList.add(new f(TbadkCoreApplication.getInst().getString(R.string.hot_topic_hot_tie_title)));
                this.mHotTopicDataList.add(new d(TbadkCoreApplication.getInst().getString(R.string.hot_topic_hot_tie_sub_title)));
                if (!x.isEmpty(hotThreadListResIdl.data.thread_info)) {
                    int size = hotThreadListResIdl.data.thread_info.size();
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < size) {
                        if (TextUtils.isEmpty(hotThreadListResIdl.data.thread_info.get(i3).title)) {
                            i2 = i4;
                        } else {
                            this.mHotTopicDataList.add(new e(hotThreadListResIdl.data.thread_info.get(i3), i4));
                            z = true;
                            i2 = i4 + 1;
                        }
                        i3++;
                        z = z;
                        i4 = i2;
                    }
                }
                if (!z) {
                    com.baidu.adp.widget.ListView.x xVar = new com.baidu.adp.widget.ListView.x();
                    xVar.resId = R.drawable.new_pic_emotion_05;
                    this.mHotTopicDataList.add(xVar);
                }
            }
        }
    }
}

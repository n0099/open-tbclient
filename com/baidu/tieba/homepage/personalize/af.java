package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends CustomMessageListener {
    final /* synthetic */ x this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(x xVar, int i) {
        super(i);
        this.this$0 = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        DataRes.Builder builder2;
        List list;
        BdTypeListView bdTypeListView;
        List list2;
        DataRes.Builder builder3;
        DataRes.Builder builder4;
        DataRes.Builder builder5;
        DataRes.Builder builder6;
        DataRes.Builder builder7;
        DataRes.Builder builder8;
        List list3;
        List list4;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        int a;
        BdTypeListView bdTypeListView4;
        com.baidu.tieba.homepage.personalize.b.af afVar;
        com.baidu.tieba.homepage.personalize.b.af afVar2;
        List list5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
            builder = this.this$0.cIV;
            if (builder != null) {
                builder2 = this.this$0.cIV;
                if (com.baidu.tbadk.core.util.z.s(builder2.thread_list) != 0) {
                    list = this.this$0.mDataList;
                    if (com.baidu.tbadk.core.util.z.s(list) != 0) {
                        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
                        if (!StringUtils.isNull(optString)) {
                            bdTypeListView = this.this$0.mListView;
                            if (bdTypeListView != null) {
                                bdTypeListView2 = this.this$0.mListView;
                                if (bdTypeListView2.getAdapter() != null) {
                                    x xVar = this.this$0;
                                    bdTypeListView3 = this.this$0.mListView;
                                    a = xVar.a(optString, bdTypeListView3);
                                    bdTypeListView4 = this.this$0.mListView;
                                    View childAt = bdTypeListView4.getChildAt(a);
                                    if (childAt == null) {
                                        afVar = this.this$0.cIz;
                                        if (afVar != null) {
                                            afVar2 = this.this$0.cIz;
                                            list5 = this.this$0.mDataList;
                                            afVar2.bg(new ArrayList(list5));
                                        }
                                    } else {
                                        this.this$0.ai(childAt);
                                    }
                                }
                            }
                            list2 = this.this$0.mDataList;
                            Iterator it = list2.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) it.next();
                                if (vVar instanceof com.baidu.tieba.card.data.c) {
                                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) vVar;
                                    if (cVar.Mv() != null && cVar.Mv().getTid() != null && cVar.Mv().getTid().equals(optString)) {
                                        it.remove();
                                        list4 = this.this$0.mDataList;
                                        com.baidu.tieba.homepage.personalize.model.c.bi(list4);
                                        break;
                                    }
                                }
                            }
                            builder3 = this.this$0.cIV;
                            if (builder3 != null) {
                                builder4 = this.this$0.cIV;
                                if (builder4.thread_list != null) {
                                    long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        builder5 = this.this$0.cIV;
                                        if (i2 < builder5.thread_list.size()) {
                                            builder6 = this.this$0.cIV;
                                            ThreadInfo threadInfo = builder6.thread_list.get(i2);
                                            if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                                                builder7 = this.this$0.cIV;
                                                builder7.thread_list.remove(i2);
                                                this.this$0.amG();
                                                long longValue = threadInfo.tid.longValue();
                                                builder8 = this.this$0.cIV;
                                                List<ThreadInfo> list6 = builder8.thread_list;
                                                list3 = this.this$0.mDataList;
                                                com.baidu.tieba.homepage.personalize.c.f.a(longValue, i2, list6, list3);
                                                return;
                                            }
                                            i = i2 + 1;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

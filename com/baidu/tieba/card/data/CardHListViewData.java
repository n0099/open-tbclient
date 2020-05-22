package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.GuessLikeThreadInfo;
import tbclient.PbPage.GuessLikeStruct;
/* loaded from: classes8.dex */
public class CardHListViewData extends b implements Serializable {
    private static final int MAX_COUNT = 9;
    private static final int MIN_COUNT = 3;
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private static final long serialVersionUID = 6577771607010727691L;
    public String threadId;
    public String title;
    public boolean showTopDivider = true;
    public boolean showBottomDivider = true;
    private final List<com.baidu.adp.widget.ListView.o> mList = new ArrayList();

    public final List<com.baidu.adp.widget.ListView.o> getDataList() {
        return this.mList;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return TYPE;
    }

    public void parseProtobuf(GuessLikeStruct guessLikeStruct) {
        if (guessLikeStruct != null && v.getCount(guessLikeStruct.thread_list) >= 3) {
            this.title = aq.trim(guessLikeStruct.title);
            List<GuessLikeThreadInfo> list = guessLikeStruct.thread_list;
            if (v.getCount(list) > 9) {
                list = v.subList(list, 0, 9);
            }
            if (!v.isEmpty(list)) {
                this.mList.clear();
                for (GuessLikeThreadInfo guessLikeThreadInfo : list) {
                    if (guessLikeThreadInfo != null && guessLikeThreadInfo.thread_id.longValue() >= 0 && !aq.isEmptyStringAfterTrim(guessLikeThreadInfo.recom_cover) && !aq.isEmptyStringAfterTrim(guessLikeThreadInfo.title)) {
                        CardHListViewNormalItemData cardHListViewNormalItemData = new CardHListViewNormalItemData();
                        cardHListViewNormalItemData.parseProtobuf(guessLikeThreadInfo);
                        this.mList.add(cardHListViewNormalItemData);
                    }
                }
            }
        }
    }
}

package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.GuessLikeThreadInfo;
import tbclient.PbPage.GuessLikeStruct;
/* loaded from: classes.dex */
public class CardHListViewData extends BaseCardInfo implements Serializable {
    private static final int MAX_COUNT = 9;
    private static final int MIN_COUNT = 3;
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private static final long serialVersionUID = 6577771607010727691L;
    public String threadId;
    public String title;
    public boolean showTopDivider = true;
    public boolean showBottomDivider = true;
    private final List<com.baidu.adp.widget.ListView.n> mList = new ArrayList();

    public final List<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.mList;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }

    public void parseProtobuf(GuessLikeStruct guessLikeStruct) {
        if (guessLikeStruct != null && y.getCount(guessLikeStruct.thread_list) >= 3) {
            this.title = au.trim(guessLikeStruct.title);
            List<GuessLikeThreadInfo> list = guessLikeStruct.thread_list;
            if (y.getCount(list) > 9) {
                list = y.subList(list, 0, 9);
            }
            if (!y.isEmpty(list)) {
                this.mList.clear();
                for (GuessLikeThreadInfo guessLikeThreadInfo : list) {
                    if (guessLikeThreadInfo != null && guessLikeThreadInfo.thread_id.longValue() >= 0 && !au.isEmptyStringAfterTrim(guessLikeThreadInfo.recom_cover) && !au.isEmptyStringAfterTrim(guessLikeThreadInfo.title)) {
                        CardHListViewNormalItemData cardHListViewNormalItemData = new CardHListViewNormalItemData();
                        cardHListViewNormalItemData.parseProtobuf(guessLikeThreadInfo);
                        this.mList.add(cardHListViewNormalItemData);
                    }
                }
            }
        }
    }
}

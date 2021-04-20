package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import d.b.c.e.p.k;
import d.b.c.j.e.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.GuessLikeThreadInfo;
import tbclient.PbPage.GuessLikeStruct;
/* loaded from: classes4.dex */
public class CardHListViewData extends BaseCardInfo implements Serializable {
    public static final int MAX_COUNT = 9;
    public static final int MIN_COUNT = 3;
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final long serialVersionUID = 6577771607010727691L;
    public String threadId;
    public String title;
    public boolean showTopDivider = true;
    public boolean showBottomDivider = true;
    public final List<n> mList = new ArrayList();

    public final List<n> getDataList() {
        return this.mList;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return TYPE;
    }

    public void parseProtobuf(GuessLikeStruct guessLikeStruct) {
        if (guessLikeStruct == null || ListUtils.getCount(guessLikeStruct.thread_list) < 3) {
            return;
        }
        this.title = StringHelper.trim(guessLikeStruct.title);
        List<GuessLikeThreadInfo> list = guessLikeStruct.thread_list;
        if (ListUtils.getCount(list) > 9) {
            list = ListUtils.subList(list, 0, 9);
        }
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.mList.clear();
        for (GuessLikeThreadInfo guessLikeThreadInfo : list) {
            if (guessLikeThreadInfo != null && guessLikeThreadInfo.thread_id.longValue() >= 0 && !k.isEmptyStringAfterTrim(guessLikeThreadInfo.recom_cover) && !k.isEmptyStringAfterTrim(guessLikeThreadInfo.title)) {
                CardHListViewNormalItemData cardHListViewNormalItemData = new CardHListViewNormalItemData();
                cardHListViewNormalItemData.parseProtobuf(guessLikeThreadInfo);
                this.mList.add(cardHListViewNormalItemData);
            }
        }
    }
}

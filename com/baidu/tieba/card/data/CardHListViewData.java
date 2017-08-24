package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.GuessLikeThreadInfo;
import tbclient.PbPage.GuessLikeStruct;
/* loaded from: classes.dex */
public class CardHListViewData extends b implements Serializable {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private static final long serialVersionUID = 6577771607010727691L;
    public String threadId;
    public String title;
    public boolean showTopDivider = true;
    public boolean showBottomDivider = true;
    private final List<com.baidu.adp.widget.ListView.f> mList = new ArrayList();

    public final List<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.mList;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public void parseProtobuf(GuessLikeStruct guessLikeStruct) {
        if (guessLikeStruct != null && u.u(guessLikeStruct.thread_list) >= 3) {
            this.title = al.ee(guessLikeStruct.title);
            List<GuessLikeThreadInfo> list = guessLikeStruct.thread_list;
            if (u.u(list) > 9) {
                list = u.a(list, 0, 9);
            }
            if (!u.v(list)) {
                this.mList.clear();
                for (GuessLikeThreadInfo guessLikeThreadInfo : list) {
                    if (guessLikeThreadInfo != null && guessLikeThreadInfo.thread_id.longValue() >= 0 && !al.aQ(guessLikeThreadInfo.recom_cover) && !al.aQ(guessLikeThreadInfo.title)) {
                        CardHListViewNormalItemData cardHListViewNormalItemData = new CardHListViewNormalItemData();
                        cardHListViewNormalItemData.parseProtobuf(guessLikeThreadInfo);
                        this.mList.add(cardHListViewNormalItemData);
                    }
                }
            }
        }
    }
}

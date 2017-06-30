package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.z;
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
    private final List<v> mList = new ArrayList();

    public final List<v> getDataList() {
        return this.mList;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    public void parseProtobuf(GuessLikeStruct guessLikeStruct) {
        if (guessLikeStruct != null && z.s(guessLikeStruct.thread_list) >= 3) {
            this.title = aw.dR(guessLikeStruct.title);
            List<GuessLikeThreadInfo> list = guessLikeStruct.thread_list;
            if (z.s(list) > 9) {
                list = z.a(list, 0, 9);
            }
            if (!z.t(list)) {
                this.mList.clear();
                for (GuessLikeThreadInfo guessLikeThreadInfo : list) {
                    if (guessLikeThreadInfo != null && guessLikeThreadInfo.thread_id.longValue() >= 0 && !aw.aH(guessLikeThreadInfo.recom_cover) && !aw.aH(guessLikeThreadInfo.title)) {
                        CardHListViewNormalItemData cardHListViewNormalItemData = new CardHListViewNormalItemData();
                        cardHListViewNormalItemData.parseProtobuf(guessLikeThreadInfo);
                        this.mList.add(cardHListViewNormalItemData);
                    }
                }
            }
        }
    }
}

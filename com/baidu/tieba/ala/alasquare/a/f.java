package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes9.dex */
public class f extends BaseCardInfo {
    public static final BdUniqueId gwa = BdUniqueId.gen();
    public bz gvQ;
    public int locate;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gwa;
    }

    public aq aA(String str, boolean z) {
        if (this.gvQ == null) {
            return null;
        }
        int i = 1;
        if (this.gvQ.boM()) {
            i = 2;
        } else if (this.gvQ.boQ() != null && this.gvQ.boQ().eSj != 0) {
            i = 3;
        }
        aq dW = new aq(str).dW("obj_id", this.gvQ.getTid()).an("obj_type", i).dW("obj_param1", this.gvQ.mRecomWeight).dW("obj_source", this.gvQ.mRecomSource).an("obj_locate", this.locate).dW("ab_tag", this.gvQ.mRecomAbTag).dW(TiebaInitialize.Params.OBJ_PARAM3, getAspectRatio() > 1.0f ? "1" : "0");
        if (z) {
            dW.dW(TiebaInitialize.Params.OBJ_PARAM2, this.gvQ.bnL() > 0 ? "0" : "1");
        }
        return dW;
    }

    public float getAspectRatio() {
        if (this.gvQ == null || this.gvQ.bnO() == null || this.gvQ.bnO().video_height.intValue() <= 0) {
            return 0.0f;
        }
        return this.gvQ.bnO().video_width.intValue() / this.gvQ.bnO().video_height.intValue();
    }
}

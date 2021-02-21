package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public class f extends BaseCardInfo {
    public static final BdUniqueId gyY = BdUniqueId.gen();
    public cb gyO;
    public int locate;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gyY;
    }

    public ar az(String str, boolean z) {
        if (this.gyO == null) {
            return null;
        }
        int i = 1;
        if (this.gyO.bpe()) {
            i = 2;
        } else if (this.gyO.bpi() != null && this.gyO.bpi().eUx != 0) {
            i = 3;
        }
        ar dR = new ar(str).dR("obj_id", this.gyO.getTid()).ap("obj_type", i).dR("obj_param1", this.gyO.mRecomWeight).dR("obj_source", this.gyO.mRecomSource).ap("obj_locate", this.locate).dR("ab_tag", this.gyO.mRecomAbTag).dR(TiebaInitialize.Params.OBJ_PARAM3, getAspectRatio() > 1.0f ? "1" : "0");
        if (z) {
            dR.dR(TiebaInitialize.Params.OBJ_PARAM2, this.gyO.boe() > 0 ? "0" : "1");
        }
        return dR;
    }

    public float getAspectRatio() {
        if (this.gyO == null || this.gyO.boh() == null || this.gyO.boh().video_height.intValue() <= 0) {
            return 0.0f;
        }
        return this.gyO.boh().video_width.intValue() / this.gyO.boh().video_height.intValue();
    }
}

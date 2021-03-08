package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes9.dex */
public class f extends BaseCardInfo {
    public static final BdUniqueId gAH = BdUniqueId.gen();
    public cb gAx;
    public int locate;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gAH;
    }

    public ar az(String str, boolean z) {
        if (this.gAx == null) {
            return null;
        }
        int i = 1;
        if (this.gAx.bpg()) {
            i = 2;
        } else if (this.gAx.bpk() != null && this.gAx.bpk().eVW != 0) {
            i = 3;
        }
        ar dR = new ar(str).dR("obj_id", this.gAx.getTid()).aq("obj_type", i).dR("obj_param1", this.gAx.mRecomWeight).dR("obj_source", this.gAx.mRecomSource).aq("obj_locate", this.locate).dR("ab_tag", this.gAx.mRecomAbTag).dR(TiebaInitialize.Params.OBJ_PARAM3, getAspectRatio() > 1.0f ? "1" : "0");
        if (z) {
            dR.dR(TiebaInitialize.Params.OBJ_PARAM2, this.gAx.bog() > 0 ? "0" : "1");
        }
        return dR;
    }

    public float getAspectRatio() {
        if (this.gAx == null || this.gAx.boj() == null || this.gAx.boj().video_height.intValue() <= 0) {
            return 0.0f;
        }
        return this.gAx.boj().video_width.intValue() / this.gAx.boj().video_height.intValue();
    }
}

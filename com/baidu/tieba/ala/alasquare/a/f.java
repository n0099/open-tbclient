package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public class f extends BaseCardInfo {
    public static final BdUniqueId gAH = BdUniqueId.gen();
    public bz gAx;
    public int locate;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gAH;
    }

    public aq aA(String str, boolean z) {
        if (this.gAx == null) {
            return null;
        }
        int i = 1;
        if (this.gAx.bsF()) {
            i = 2;
        } else if (this.gAx.bsJ() != null && this.gAx.bsJ().eWU != 0) {
            i = 3;
        }
        aq dX = new aq(str).dX("obj_id", this.gAx.getTid()).an("obj_type", i).dX("obj_param1", this.gAx.mRecomWeight).dX("obj_source", this.gAx.mRecomSource).an("obj_locate", this.locate).dX("ab_tag", this.gAx.mRecomAbTag).dX(TiebaInitialize.Params.OBJ_PARAM3, getAspectRatio() > 1.0f ? "1" : "0");
        if (z) {
            dX.dX(TiebaInitialize.Params.OBJ_PARAM2, this.gAx.brE() > 0 ? "0" : "1");
        }
        return dX;
    }

    public float getAspectRatio() {
        if (this.gAx == null || this.gAx.brH() == null || this.gAx.brH().video_height.intValue() <= 0) {
            return 0.0f;
        }
        return this.gAx.brH().video_width.intValue() / this.gAx.brH().video_height.intValue();
    }
}

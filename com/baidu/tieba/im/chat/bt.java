package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity bPX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(TalkableActivity talkableActivity) {
        this.bPX = talkableActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            if (this.bPX.bPK != null) {
                this.bPX.bPK.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                return;
            }
            return;
        }
        this.bPX.showToast(TbadkCoreApplication.m411getInst().getString(t.j.pic_parser_error));
    }
}

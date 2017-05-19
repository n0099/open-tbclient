package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.base.f {
    final /* synthetic */ TalkableActivity cLa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(TalkableActivity talkableActivity) {
        this.cLa = talkableActivity;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            if (this.cLa.cKN != null) {
                this.cLa.cKN.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                return;
            }
            return;
        }
        this.cLa.showToast(TbadkCoreApplication.m9getInst().getString(w.l.pic_parser_error));
    }
}

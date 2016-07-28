package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity cIT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(TalkableActivity talkableActivity) {
        this.cIT = talkableActivity;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            if (this.cIT.cIG != null) {
                this.cIT.cIG.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                return;
            }
            return;
        }
        this.cIT.showToast(TbadkCoreApplication.m10getInst().getString(u.j.pic_parser_error));
    }
}

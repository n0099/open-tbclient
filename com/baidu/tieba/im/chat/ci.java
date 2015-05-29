package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.model.LocalPicModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci extends com.baidu.adp.base.i {
    final /* synthetic */ TalkableActivity bba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(TalkableActivity talkableActivity) {
        this.bba = talkableActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            if (this.bba.mListModel != null) {
                this.bba.mListModel.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                return;
            }
            return;
        }
        this.bba.showToast(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.pic_parser_error));
    }
}

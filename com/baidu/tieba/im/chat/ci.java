package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.model.LocalPicModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci extends com.baidu.adp.base.i {
    final /* synthetic */ TalkableActivity aYd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(TalkableActivity talkableActivity) {
        this.aYd = talkableActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            if (this.aYd.mListModel != null) {
                this.aYd.mListModel.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                return;
            }
            return;
        }
        this.aYd.showToast(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.pic_parser_error));
    }
}

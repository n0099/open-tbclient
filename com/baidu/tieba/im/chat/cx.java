package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.model.LocalPicModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx extends com.baidu.adp.base.i {
    final /* synthetic */ TalkableActivity aTf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(TalkableActivity talkableActivity) {
        this.aTf = talkableActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            if (this.aTf.mListModel != null) {
                this.aTf.mListModel.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                return;
            }
            return;
        }
        this.aTf.showToast(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.pic_parser_error));
    }
}

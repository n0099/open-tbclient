package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.model.LocalPicModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu extends com.baidu.adp.base.i {
    final /* synthetic */ TalkableActivity aRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(TalkableActivity talkableActivity) {
        this.aRW = talkableActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            if (this.aRW.mListModel != null) {
                this.aRW.mListModel.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                return;
            }
            return;
        }
        this.aRW.showToast(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.pic_parser_error));
    }
}

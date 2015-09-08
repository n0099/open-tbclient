package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import com.baidu.tieba.im.model.LocalPicModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity bpt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(TalkableActivity talkableActivity) {
        this.bpt = talkableActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            if (this.bpt.mListModel != null) {
                this.bpt.mListModel.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                return;
            }
            return;
        }
        this.bpt.showToast(TbadkCoreApplication.m411getInst().getString(i.h.pic_parser_error));
    }
}

package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.model.LocalPicModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.tieba.im.chat.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends com.baidu.adp.base.h {
    final /* synthetic */ TalkableActivity aQq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(TalkableActivity talkableActivity) {
        this.aQq = talkableActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            if (this.aQq.aQe != null) {
                this.aQq.aQe.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                return;
            }
            return;
        }
        this.aQq.showToast(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.pic_parser_error));
    }
}

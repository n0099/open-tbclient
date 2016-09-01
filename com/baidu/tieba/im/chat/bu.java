package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu extends com.baidu.adp.base.g {
    final /* synthetic */ TalkableActivity cUy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(TalkableActivity talkableActivity) {
        this.cUy = talkableActivity;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            if (this.cUy.cUl != null) {
                this.cUy.cUl.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                return;
            }
            return;
        }
        this.cUy.showToast(TbadkCoreApplication.m9getInst().getString(t.j.pic_parser_error));
    }
}

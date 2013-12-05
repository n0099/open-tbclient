package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.QueryGroupCountLocalMessage;
import com.baidu.tieba.im.message.ResponseQueryGroupCountMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public ResponsedMessage a(Message message) {
        ResponseQueryGroupCountMessage responseQueryGroupCountMessage;
        if (message == null || !(message instanceof QueryGroupCountLocalMessage)) {
            return null;
        }
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        byte[] a2 = com.baidu.tieba.b.a.a().r().a("enter_forum_group_info_" + str);
        ResponseQueryGroupCountMessage responseQueryGroupCountMessage2 = new ResponseQueryGroupCountMessage();
        if (a2 != null) {
            try {
                responseQueryGroupCountMessage = (ResponseQueryGroupCountMessage) com.baidu.tieba.im.b.m.a(a2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            responseQueryGroupCountMessage.setCmd(-114);
            return responseQueryGroupCountMessage;
        }
        responseQueryGroupCountMessage = responseQueryGroupCountMessage2;
        responseQueryGroupCountMessage.setCmd(-114);
        return responseQueryGroupCountMessage;
    }
}

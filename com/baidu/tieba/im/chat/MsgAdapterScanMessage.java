package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes3.dex */
public class MsgAdapterScanMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TbPageContext<MsglistActivity<?>> f17762a;

        /* renamed from: b  reason: collision with root package name */
        public List<MsgCommonItemAdapter> f17763b;
    }

    public MsgAdapterScanMessage(a aVar) {
        super(2001275, aVar);
    }
}

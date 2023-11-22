package com.baidu.tieba;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes6.dex */
public interface h1a {
    AbsVideoPbFragment e0();

    void finish();

    TbPageContext getPageContext();

    PbModel i0();

    PbFragment j2();

    PbModel.h m1();

    AbsPbActivity r0();

    void registerListener(MessageListener<?> messageListener);
}

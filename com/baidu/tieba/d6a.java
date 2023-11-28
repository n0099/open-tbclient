package com.baidu.tieba;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes5.dex */
public interface d6a {
    void finish();

    TbPageContext getPageContext();

    AbsVideoPbFragment h0();

    PbModel l0();

    void registerListener(MessageListener<?> messageListener);

    AbsPbActivity u0();

    PbModel.h v1();

    PbFragment v2();
}

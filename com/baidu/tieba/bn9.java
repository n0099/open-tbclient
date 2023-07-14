package com.baidu.tieba;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes5.dex */
public interface bn9 {
    PbModel.h M0();

    AbsVideoPbFragment N();

    PbModel Q();

    AbsPbActivity X();

    void finish();

    TbPageContext getPageContext();

    void registerListener(MessageListener<?> messageListener);

    PbFragment z1();
}

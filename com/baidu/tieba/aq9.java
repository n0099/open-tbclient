package com.baidu.tieba;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes5.dex */
public interface aq9 {
    PbFragment M1();

    AbsVideoPbFragment Q();

    PbModel.h V0();

    PbModel W();

    AbsPbActivity d0();

    void finish();

    TbPageContext getPageContext();

    void registerListener(MessageListener<?> messageListener);
}

package com.baidu.tieba;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes5.dex */
public interface bo9 {
    PbFragment S1();

    AbsVideoPbFragment a0();

    PbModel.h b1();

    PbModel e0();

    void finish();

    TbPageContext getPageContext();

    AbsPbActivity l0();

    void registerListener(MessageListener<?> messageListener);
}

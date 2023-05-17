package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CommitVoteReqMsg extends HttpMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long candidate_uid;
    public long forum_id;
    public int source;
    public long thread_id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommitVoteReqMsg(long j, long j2, long j3, int i) {
        super(CmdConfigHttp.CMD_BAR_VOTE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.candidate_uid = j;
        this.forum_id = j2;
        this.thread_id = j3;
        this.source = i;
        addParam("candidate_uid", j);
        addParam("forum_id", j2);
        addParam("thread_id", j3);
        addParam("source", i);
        addHeader("needSig", "1");
        addParam("check_new_sig", "1");
        addParam(HttpRequest.SUBAPP_TYPE, "tieba");
    }
}

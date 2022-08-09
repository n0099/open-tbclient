package com.baidu.tbadk.mutiprocess.sync;

import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
import com.baidu.tbadk.data.UserGrowthTaskListData;
import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SyncDataEvent extends SerializableEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -4019344353242140288L;
    public transient /* synthetic */ FieldHolder $fh;
    public ABTestExtraData abtestExtraData;
    public String sampleId;
    public String ubsABTest;
    public UserGrowthTaskListData userGrowthTaskListData;

    public SyncDataEvent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setType(1);
    }
}

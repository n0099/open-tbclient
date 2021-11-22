package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import b.a.r0.x0.f1;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class FrsGodViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView locationAddress;
    public TextView mPraiseNum;
    public TextView mReplyNum;
    public TextView mReplyTime;
    public int skinType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsGodViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.skinType = 3;
        this.mReplyTime = (TextView) getView().findViewById(f1.frs_god_lv_reply_time);
        this.mPraiseNum = (TextView) getView().findViewById(f1.frs_god_praise_num);
        this.mReplyNum = (TextView) getView().findViewById(f1.frs_god_reply_num);
        this.locationAddress = (TextView) getView().findViewById(f1.frs_god_item_location_address);
    }
}

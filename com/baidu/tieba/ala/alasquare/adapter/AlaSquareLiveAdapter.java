package com.baidu.tieba.ala.alasquare.adapter;

import android.view.View;
import c.a.e.l.e.a;
import c.a.r0.w.f.a.c;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class AlaSquareLiveAdapter extends a<c, SquareLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class SquareLiveViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.r0.w.f.i.c mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SquareLiveViewHolder(AlaSquareLiveAdapter alaSquareLiveAdapter, c.a.r0.w.f.i.c cVar) {
            super(cVar.j());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareLiveAdapter, cVar};
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
            this.mView = cVar;
        }
    }
}

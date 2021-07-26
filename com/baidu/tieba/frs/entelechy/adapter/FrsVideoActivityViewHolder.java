package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsVideoActivityViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f15618a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f15619b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15620c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f15621d;

    /* renamed from: e  reason: collision with root package name */
    public View f15622e;

    /* renamed from: f  reason: collision with root package name */
    public View f15623f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsVideoActivityViewHolder(View view) {
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
        if (view != null) {
            this.f15618a = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.f15619b = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.f15620c = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.f15621d = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.f15622e = view.findViewById(R.id.top_divider_line);
            this.f15623f = view.findViewById(R.id.bottom_divider_line);
        }
    }
}

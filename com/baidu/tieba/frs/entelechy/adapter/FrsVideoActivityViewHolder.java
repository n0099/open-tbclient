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
    public TextView f15570a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f15571b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15572c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f15573d;

    /* renamed from: e  reason: collision with root package name */
    public View f15574e;

    /* renamed from: f  reason: collision with root package name */
    public View f15575f;

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
            this.f15570a = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.f15571b = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.f15572c = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.f15573d = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.f15574e = view.findViewById(R.id.top_divider_line);
            this.f15575f = view.findViewById(R.id.bottom_divider_line);
        }
    }
}

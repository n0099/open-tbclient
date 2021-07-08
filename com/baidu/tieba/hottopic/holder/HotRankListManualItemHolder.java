package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class HotRankListManualItemHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f17096a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17097b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17098c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17099d;

    /* renamed from: e  reason: collision with root package name */
    public View f17100e;

    /* renamed from: f  reason: collision with root package name */
    public View f17101f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17102g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17103h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotRankListManualItemHolder(View view) {
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
        this.f17096a = 3;
        this.f17097b = null;
        this.f17098c = null;
        this.f17099d = null;
        this.f17100e = null;
        this.f17101f = null;
        this.f17102g = null;
        this.f17103h = null;
        this.f17097b = (TextView) view.findViewById(R.id.topic_module);
        this.f17099d = (TextView) view.findViewById(R.id.topic_desc);
        this.f17098c = (TextView) view.findViewById(R.id.topic_title);
        this.f17102g = (TbImageView) view.findViewById(R.id.topic_pic);
        this.f17100e = view.findViewById(R.id.devide_line_top);
        this.f17101f = view.findViewById(R.id.devide_line_bottom);
        this.f17103h = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}

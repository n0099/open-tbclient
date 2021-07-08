package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class HotTopicPkItemHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f17116a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17117b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17118c;

    /* renamed from: d  reason: collision with root package name */
    public HotTopicPkView f17119d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17120e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17121f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicPkItemHolder(View view) {
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
        this.f17116a = 3;
        b(view);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
            return;
        }
        this.f17117b = (TextView) view.findViewById(R.id.pk_item_theme_title);
        this.f17118c = (TextView) view.findViewById(R.id.pk_topic_title);
        this.f17119d = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
        this.f17120e = (TextView) view.findViewById(R.id.pk_topic_positive);
        this.f17121f = (TextView) view.findViewById(R.id.pk_topic_opposing);
    }
}

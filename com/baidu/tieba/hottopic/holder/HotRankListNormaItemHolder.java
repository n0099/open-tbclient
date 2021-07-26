package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class HotRankListNormaItemHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f17160a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17161b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17162c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17163d;

    /* renamed from: e  reason: collision with root package name */
    public View f17164e;

    /* renamed from: f  reason: collision with root package name */
    public View f17165f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f17166g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17167h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17168i;
    public TextView j;
    public LinearLayout k;
    public LinearLayout l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotRankListNormaItemHolder(View view) {
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
        this.f17160a = 3;
        this.f17161b = null;
        this.f17162c = null;
        this.f17163d = null;
        this.f17164e = null;
        this.f17165f = null;
        this.f17166g = null;
        this.f17167h = null;
        this.f17168i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.f17161b = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.f17162c = (TextView) view.findViewById(R.id.hot_topic_title);
        this.f17163d = (TextView) view.findViewById(R.id.hot_topic_num);
        this.f17164e = view.findViewById(R.id.devide_line_top);
        this.f17165f = view.findViewById(R.id.topic_devide_line_bottom);
        this.f17166g = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.f17167h = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.f17168i = (TextView) view.findViewById(R.id.tip_info_title);
        this.j = (TextView) view.findViewById(R.id.tip_info_rule);
        this.k = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.l = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}

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
    public int f17104a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17105b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17106c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17107d;

    /* renamed from: e  reason: collision with root package name */
    public View f17108e;

    /* renamed from: f  reason: collision with root package name */
    public View f17109f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f17110g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17111h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17112i;
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
        this.f17104a = 3;
        this.f17105b = null;
        this.f17106c = null;
        this.f17107d = null;
        this.f17108e = null;
        this.f17109f = null;
        this.f17110g = null;
        this.f17111h = null;
        this.f17112i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.f17105b = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.f17106c = (TextView) view.findViewById(R.id.hot_topic_title);
        this.f17107d = (TextView) view.findViewById(R.id.hot_topic_num);
        this.f17108e = view.findViewById(R.id.devide_line_top);
        this.f17109f = view.findViewById(R.id.topic_devide_line_bottom);
        this.f17110g = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.f17111h = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.f17112i = (TextView) view.findViewById(R.id.tip_info_title);
        this.j = (TextView) view.findViewById(R.id.tip_info_rule);
        this.k = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.l = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}

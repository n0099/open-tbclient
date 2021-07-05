package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class QualityThreadItemHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f17083a;

    /* renamed from: b  reason: collision with root package name */
    public View f17084b;

    /* renamed from: c  reason: collision with root package name */
    public View f17085c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17086d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f17087e;

    /* renamed from: f  reason: collision with root package name */
    public View f17088f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17089g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17090h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17091i;
    public TextView j;
    public TextView k;
    public TextView l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QualityThreadItemHolder(View view) {
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
        this.f17083a = 3;
        this.f17084b = null;
        this.f17085c = null;
        this.f17086d = null;
        this.f17087e = null;
        this.f17088f = null;
        this.f17089g = null;
        this.f17084b = view;
        b(view);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
            return;
        }
        this.f17085c = view.findViewById(R.id.top_divider_line);
        this.f17086d = (TextView) view.findViewById(R.id.quality_item_theme_title);
        this.f17088f = view.findViewById(R.id.divider_line);
        this.f17087e = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
        this.f17089g = (TbImageView) view.findViewById(R.id.img);
        this.f17090h = (TextView) view.findViewById(R.id.title);
        this.f17091i = (TextView) view.findViewById(R.id.desc);
        this.j = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
        this.k = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
        this.l = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
    }
}

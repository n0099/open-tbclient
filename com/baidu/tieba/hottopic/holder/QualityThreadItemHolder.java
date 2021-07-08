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
/* loaded from: classes4.dex */
public class QualityThreadItemHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f17122a;

    /* renamed from: b  reason: collision with root package name */
    public View f17123b;

    /* renamed from: c  reason: collision with root package name */
    public View f17124c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17125d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f17126e;

    /* renamed from: f  reason: collision with root package name */
    public View f17127f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17128g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17129h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17130i;
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
        this.f17122a = 3;
        this.f17123b = null;
        this.f17124c = null;
        this.f17125d = null;
        this.f17126e = null;
        this.f17127f = null;
        this.f17128g = null;
        this.f17123b = view;
        b(view);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
            return;
        }
        this.f17124c = view.findViewById(R.id.top_divider_line);
        this.f17125d = (TextView) view.findViewById(R.id.quality_item_theme_title);
        this.f17127f = view.findViewById(R.id.divider_line);
        this.f17126e = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
        this.f17128g = (TbImageView) view.findViewById(R.id.img);
        this.f17129h = (TextView) view.findViewById(R.id.title);
        this.f17130i = (TextView) view.findViewById(R.id.desc);
        this.j = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
        this.k = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
        this.l = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
    }
}

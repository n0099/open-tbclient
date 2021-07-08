package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class RelateTopicForumItemHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BarImageView f17131a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17132b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17133c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17134d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17135e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17136f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17137g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17138h;

    /* renamed from: i  reason: collision with root package name */
    public View f17139i;
    public int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelateTopicForumItemHolder(View view) {
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
        this.j = 3;
        this.f17132b = (TextView) view.findViewById(R.id.forum_name);
        this.f17131a = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.f17134d = (TextView) view.findViewById(R.id.member_num_label);
        this.f17133c = (TextView) view.findViewById(R.id.post_num_label);
        this.f17136f = (TextView) view.findViewById(R.id.member_num);
        this.f17135e = (TextView) view.findViewById(R.id.post_num);
        this.f17137g = (TextView) view.findViewById(R.id.forum_content);
        this.f17138h = (TextView) view.findViewById(R.id.forum_add_love);
        this.f17139i = view.findViewById(R.id.forum_item_divider);
    }
}

package com.baidu.tieba.forumMember.manito;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ManitoMemberItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public GodHeadImageView f15273a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15274b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15275c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15276d;

    /* renamed from: e  reason: collision with root package name */
    public View f15277e;

    /* renamed from: f  reason: collision with root package name */
    public int f15278f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManitoMemberItemViewHolder(View view) {
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
        this.f15278f = 3;
        GodHeadImageView godHeadImageView = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.f15273a = godHeadImageView;
        godHeadImageView.setShapeType(0);
        this.f15273a.setShowType(1);
        this.f15273a.setRadius(14);
        this.f15274b = (TextView) view.findViewById(R.id.item_manito_name);
        this.f15275c = (TextView) view.findViewById(R.id.item_manito_intro);
        this.f15276d = (TextView) view.findViewById(R.id.item_manito_fans);
        this.f15277e = view.findViewById(R.id.divider_line);
    }
}

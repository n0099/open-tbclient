package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsMemberHeaderViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f15239a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15240b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f15241c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15242d;

    /* renamed from: e  reason: collision with root package name */
    public View f15243e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f15244f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15245g;

    /* renamed from: h  reason: collision with root package name */
    public NoPressedLinearLayout f15246h;

    /* renamed from: i  reason: collision with root package name */
    public View f15247i;
    public TextView j;
    public ImageView k;
    public ImageView l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsMemberHeaderViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, onClickListener};
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
        this.f15239a = (TextView) view.findViewById(R.id.like_btn);
        this.f15240b = (TextView) view.findViewById(R.id.lever_tip_view);
        this.f15241c = (ImageView) view.findViewById(R.id.header_level_img);
        this.f15242d = (TextView) view.findViewById(R.id.user_level_name);
        this.f15243e = view.findViewById(R.id.header_divider_line2);
        this.f15244f = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.f15245g = (TextView) view.findViewById(R.id.tip_experience_score);
        this.f15246h = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.f15247i = view.findViewById(R.id.header_divider_line3);
        this.j = (TextView) view.findViewById(R.id.tip_experience);
        this.k = (ImageView) view.findViewById(R.id.love_level_top);
        this.l = (ImageView) view.findViewById(R.id.love_level_bg);
        this.f15239a.setOnClickListener(onClickListener);
        this.f15242d.setOnClickListener(onClickListener);
    }
}

package com.baidu.tieba.homepage.topic.local;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import c.a.l.q;
import c.a.o0.r.v.c;
import c.a.p0.q1.l.a.c.b;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.EllipsizeTagTitleView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class LocalChannelTopicHolder extends TypeAdapter.ViewHolder implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConstraintLayout a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f33517b;

    /* renamed from: c  reason: collision with root package name */
    public EllipsizeTagTitleView f33518c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33519d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalChannelTopicHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = (ConstraintLayout) view.findViewById(R.id.obfuscated_res_0x7f092112);
        this.f33517b = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0920f1);
        this.f33518c = (EllipsizeTagTitleView) view.findViewById(R.id.obfuscated_res_0x7f09212c);
        this.f33519d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920de);
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f33517b.setConrers(15);
            this.f33517b.setPlaceHolder(1);
            this.f33517b.J(bVar.f17539d, 10, false);
            this.f33518c.setTitleAndTag(this.itemView.getContext().getString(R.string.obfuscated_res_0x7f0f0a35, bVar.a), bVar.f17538c);
            if (!TextUtils.isEmpty(bVar.f17537b)) {
                this.f33519d.setText(bVar.f17537b);
                this.f33519d.setVisibility(0);
                return;
            }
            this.f33519d.setVisibility(8);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            EllipsizeTagTitleView ellipsizeTagTitleView = this.f33518c;
            if (ellipsizeTagTitleView != null) {
                ellipsizeTagTitleView.onChangeSkinType(tbPageContext, i);
            }
            SkinManager.setViewTextColor(this.f33519d, (int) R.color.CAM_X0109);
            c.d(this.a).i(R.color.CAM_X0201, R.color.CAM_X0202);
        }
    }
}

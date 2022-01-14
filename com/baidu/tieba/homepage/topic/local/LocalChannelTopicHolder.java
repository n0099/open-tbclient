package com.baidu.tieba.homepage.topic.local;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import c.a.l.q;
import c.a.s0.s.u.c;
import c.a.t0.o1.k.a.c.b;
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
/* loaded from: classes12.dex */
public class LocalChannelTopicHolder extends TypeAdapter.ViewHolder implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ConstraintLayout f44485e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f44486f;

    /* renamed from: g  reason: collision with root package name */
    public EllipsizeTagTitleView f44487g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44488h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalChannelTopicHolder(View view) {
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
        this.f44485e = (ConstraintLayout) view.findViewById(R.id.topic_root);
        this.f44486f = (TbImageView) view.findViewById(R.id.topic_image_iv);
        this.f44487g = (EllipsizeTagTitleView) view.findViewById(R.id.topic_title_tv);
        this.f44488h = (TextView) view.findViewById(R.id.topic_desc_tv);
    }

    public void bindData(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f44486f.setConrers(15);
            this.f44486f.setPlaceHolder(1);
            this.f44486f.startLoad(bVar.f20663h, 10, false);
            this.f44487g.setTitleAndTag(this.itemView.getContext().getString(R.string.local_channel_topic_wrap, bVar.f20660e), bVar.f20662g);
            if (!TextUtils.isEmpty(bVar.f20661f)) {
                this.f44488h.setText(bVar.f20661f);
                this.f44488h.setVisibility(0);
                return;
            }
            this.f44488h.setVisibility(8);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            EllipsizeTagTitleView ellipsizeTagTitleView = this.f44487g;
            if (ellipsizeTagTitleView != null) {
                ellipsizeTagTitleView.onChangeSkinType(tbPageContext, i2);
            }
            SkinManager.setViewTextColor(this.f44488h, R.color.CAM_X0109);
            c.d(this.f44485e).i(R.color.CAM_X0201, R.color.CAM_X0202);
        }
    }
}

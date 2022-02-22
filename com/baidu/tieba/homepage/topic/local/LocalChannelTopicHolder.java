package com.baidu.tieba.homepage.topic.local;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import c.a.l.q;
import c.a.t0.s.v.c;
import c.a.u0.p1.l.a.c.b;
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
    public ConstraintLayout f44771e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f44772f;

    /* renamed from: g  reason: collision with root package name */
    public EllipsizeTagTitleView f44773g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44774h;

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
        this.f44771e = (ConstraintLayout) view.findViewById(R.id.topic_root);
        this.f44772f = (TbImageView) view.findViewById(R.id.topic_image_iv);
        this.f44773g = (EllipsizeTagTitleView) view.findViewById(R.id.topic_title_tv);
        this.f44774h = (TextView) view.findViewById(R.id.topic_desc_tv);
    }

    public void bindData(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f44772f.setConrers(15);
            this.f44772f.setPlaceHolder(1);
            this.f44772f.startLoad(bVar.f20870h, 10, false);
            this.f44773g.setTitleAndTag(this.itemView.getContext().getString(R.string.local_channel_topic_wrap, bVar.f20867e), bVar.f20869g);
            if (!TextUtils.isEmpty(bVar.f20868f)) {
                this.f44774h.setText(bVar.f20868f);
                this.f44774h.setVisibility(0);
                return;
            }
            this.f44774h.setVisibility(8);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            EllipsizeTagTitleView ellipsizeTagTitleView = this.f44773g;
            if (ellipsizeTagTitleView != null) {
                ellipsizeTagTitleView.onChangeSkinType(tbPageContext, i2);
            }
            SkinManager.setViewTextColor(this.f44774h, R.color.CAM_X0109);
            c.d(this.f44771e).i(R.color.CAM_X0201, R.color.CAM_X0202);
        }
    }
}

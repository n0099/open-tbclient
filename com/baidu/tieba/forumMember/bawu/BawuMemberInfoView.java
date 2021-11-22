package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.f.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes9.dex */
public class BawuMemberInfoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f49020e;

    /* renamed from: f  reason: collision with root package name */
    public View f49021f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f49022g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49023h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f49024i;
    public TextView j;
    public BawuRoleInfoPub k;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BawuMemberInfoView f49025e;

        public a(BawuMemberInfoView bawuMemberInfoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bawuMemberInfoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49025e = bawuMemberInfoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f49025e.k == null) {
                return;
            }
            MessageManager messageManager = MessageManager.getInstance();
            Context context = this.f49025e.f49020e;
            messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, "" + this.f49025e.k.user_id, this.f49025e.k.user_name)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BawuMemberInfoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49020e = context;
        initView();
    }

    public void fillView(BawuRoleInfoPub bawuRoleInfoPub) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bawuRoleInfoPub) == null) || bawuRoleInfoPub == null) {
            return;
        }
        this.k = bawuRoleInfoPub;
        this.f49022g.startLoad(bawuRoleInfoPub.portrait, 12, false);
        this.f49023h.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
        if (StringUtils.isNull(bawuRoleInfoPub.level_name)) {
            this.j.setVisibility(8);
        } else {
            this.j.setText(bawuRoleInfoPub.level_name);
            this.j.setVisibility(0);
        }
        int smallGradeResourceIdNew = BitmapHelper.getSmallGradeResourceIdNew(bawuRoleInfoPub.user_level.intValue());
        if (smallGradeResourceIdNew == 0) {
            this.f49024i.setVisibility(8);
            return;
        }
        ImageView imageView = this.f49024i;
        imageView.setContentDescription(this.f49020e.getString(R.string.degree) + bawuRoleInfoPub.user_level);
        SkinManager.setImageResource(this.f49024i, smallGradeResourceIdNew);
        this.f49024i.setVisibility(0);
    }

    public ImageView getLevelIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49024i : (ImageView) invokeV.objValue;
    }

    public TextView getLevelNameView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : (TextView) invokeV.objValue;
    }

    public BawuRoleInfoPub getMemberData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (BawuRoleInfoPub) invokeV.objValue;
    }

    public HeadImageView getPhotoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49022g : (HeadImageView) invokeV.objValue;
    }

    public TextView getUserNameView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f49023h : (TextView) invokeV.objValue;
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View inflate = LayoutInflater.from(this.f49020e).inflate(R.layout.bawu_member_info_item_layout, this);
            this.f49021f = inflate;
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.imageview_bawu_member);
            this.f49022g = headImageView;
            headImageView.setIsRound(true);
            this.f49022g.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.f49022g.setBorderWidth(l.g(this.f49020e, R.dimen.ds1));
            this.f49021f.setOnClickListener(new a(this));
            this.f49024i = (ImageView) this.f49021f.findViewById(R.id.imageview_level_icon);
            this.f49023h = (TextView) this.f49021f.findViewById(R.id.textview_user_name);
            this.j = (TextView) this.f49021f.findViewById(R.id.textview_user_level);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BawuMemberInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49020e = context;
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BawuMemberInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f49020e = context;
        initView();
    }
}

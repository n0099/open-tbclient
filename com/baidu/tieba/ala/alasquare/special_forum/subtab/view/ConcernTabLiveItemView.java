package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.r0.b0.b;
import c.a.r0.w.f.g.c.f;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.ala.data.AlaAttentionData;
import com.baidu.ala.view.AlaAttentionManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ConcernTabLiveItemView extends b<f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewHolder m;
    public TbPageContext n;
    public int o;
    public String p;
    public String q;

    /* loaded from: classes7.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View.OnClickListener f49620a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ConcernTabLiveItemView f49621b;
        public TextView bottomText;
        public ConcernTabLiveItemView concernTabLiveItemView;
        public View divider;
        public TextView followBtn;
        public TextView followedBtn;
        public TextView livingTag;
        public TbImageView portraitImg;
        public View root;
        public TextView topText;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ViewHolder f49622e;

            public a(ViewHolder viewHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {viewHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49622e = viewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view.getId() == R.id.follow_btn && (view.getTag() instanceof UserData)) {
                    if (!l.D()) {
                        this.f49622e.f49621b.n.showToast(R.string.neterror);
                        return;
                    }
                    UserData userData = (UserData) view.getTag();
                    AlaAttentionManager.getInstance().updateAttention(String.valueOf(userData.getUserId()), new AlaAttentionData(userData.getPortrait(), String.valueOf(userData.getUserId()), "1", true, null));
                    this.f49622e.f49621b.m.followBtn.setVisibility(8);
                    this.f49622e.f49621b.m.followedBtn.setVisibility(0);
                    TiebaStatic.log(new StatisticItem("c12897"));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ConcernTabLiveItemView concernTabLiveItemView, ConcernTabLiveItemView concernTabLiveItemView2) {
            super(concernTabLiveItemView2.j());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernTabLiveItemView, concernTabLiveItemView2};
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
            this.f49621b = concernTabLiveItemView;
            this.f49620a = new a(this);
            this.concernTabLiveItemView = concernTabLiveItemView2;
            View j2 = concernTabLiveItemView2.j();
            this.root = j2;
            TbImageView tbImageView = (TbImageView) j2.findViewById(R.id.protrait);
            this.portraitImg = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.portraitImg.setIsRound(true);
            this.portraitImg.setAutoChangeStyle(false);
            this.portraitImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.topText = (TextView) this.root.findViewById(R.id.live_title);
            this.livingTag = (TextView) this.root.findViewById(R.id.living_tag);
            this.divider = this.root.findViewById(R.id.devider_line);
            Drawable drawable = SkinManager.getDrawable(concernTabLiveItemView.f15709g.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, concernTabLiveItemView.f15709g.getResources().getDimensionPixelOffset(R.dimen.tbds8), concernTabLiveItemView.f15709g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.livingTag.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bottomText = (TextView) this.root.findViewById(R.id.user_name);
            this.followBtn = (TextView) this.root.findViewById(R.id.follow_btn);
            this.followedBtn = (TextView) this.root.findViewById(R.id.followed_btn);
            this.followBtn.setOnClickListener(this.f49620a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernTabLiveItemView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 28;
        this.p = "";
        this.q = "";
        this.n = tbPageContext;
        this.m = new ViewHolder(this, this);
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.q = str;
        }
    }

    @Override // c.a.r0.b0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.special_bar_concern_live_item : invokeV.intValue;
    }

    @Override // c.a.r0.b0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.m.topText, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m.bottomText, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.m.followedBtn, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.m.followBtn, R.color.common_color_10140);
            SkinManager.setViewTextColor(this.m.livingTag, R.color.CAM_X0109);
            SkinManager.getDrawable(this.f15709g.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f15709g.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.f15709g.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.m.livingTag.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f15709g.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setBackgroundColor(this.m.divider, R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.b0.b
    /* renamed from: s */
    public void k(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            UserData userData = fVar.f25994e;
            if (userData != null) {
                if (!StringUtils.isNull(userData.getPortrait())) {
                    this.m.portraitImg.startLoad(fVar.f25994e.getPortrait(), 12, false);
                }
                if (!StringUtils.isNull(fVar.f25994e.getName_show())) {
                    this.m.topText.setText(fVar.f25994e.getName_show());
                }
                if (fVar.f25996g) {
                    if (fVar.f25994e.hadConcerned()) {
                        this.m.followBtn.setVisibility(8);
                        this.m.followedBtn.setVisibility(0);
                    } else {
                        this.m.followBtn.setVisibility(0);
                        this.m.followedBtn.setVisibility(8);
                    }
                } else {
                    this.m.followBtn.setVisibility(8);
                    this.m.followedBtn.setVisibility(8);
                }
                this.m.followBtn.setTag(fVar.f25994e);
            }
            AlaInfoData alaInfoData = fVar.f25995f;
            if (alaInfoData != null) {
                this.m.root.setTag(alaInfoData);
                if (!StringUtils.isNull(fVar.f25995f.description)) {
                    String str = fVar.f25995f.description;
                    int i2 = this.o;
                    if (fVar.f25996g) {
                        i2 -= 9;
                    }
                    if (k.byteLength(str) > i2) {
                        str = StringHelper.cutChineseAndEnglishWithSuffix(str, i2, "...");
                    }
                    this.m.bottomText.setText(str);
                }
            }
            if (fVar.f25996g) {
                TiebaStatic.log(new StatisticItem("c12895"));
            } else {
                StatisticItem statisticItem = new StatisticItem("c12893");
                statisticItem.addParam("fid", this.p);
                statisticItem.addParam("fname", this.q);
                AlaInfoData alaInfoData2 = fVar.f25995f;
                if (alaInfoData2 != null && alaInfoData2.isLegalYYLiveData()) {
                    AlaInfoData alaInfoData3 = fVar.f25995f;
                    int calculateLiveType = YYLiveUtil.calculateLiveType(alaInfoData3);
                    String str2 = StringUtils.isNull(alaInfoData3.appId) ? null : alaInfoData3.appId;
                    if (alaInfoData3.mYyExtData != null) {
                        str2 = TiebaStatic.YYValues.YY_LIVE;
                    }
                    statisticItem.addParam("obj_param1", calculateLiveType);
                    statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, str2);
                    YYLiveUtil.calculateLiveType(fVar.f25995f);
                    TiebaStaticHelper.addYYParam(statisticItem, fVar.f25995f.mYyExtData);
                }
                TiebaStatic.log(statisticItem);
            }
            this.m.followBtn.setTag(fVar.f25994e);
            l(i(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.p = str;
        }
    }
}

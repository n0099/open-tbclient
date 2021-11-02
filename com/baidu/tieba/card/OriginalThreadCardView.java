package com.baidu.tieba.card;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.f1.n.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaShareInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class OriginalThreadCardView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f47428e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f47429f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f47430g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f47431h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f47432i;
    public LinearLayout j;
    public TextView k;
    public RankStarView l;
    public TextView m;
    public VoteView n;
    public int o;
    public b p;
    public int q;
    public int sourceFormForPb;
    public boolean usePlaceHolder;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OriginalThreadCardView f47433e;

        public a(OriginalThreadCardView originalThreadCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {originalThreadCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47433e = originalThreadCardView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && (view.getTag() instanceof OriginalThreadInfo)) {
                OriginalThreadInfo originalThreadInfo = (OriginalThreadInfo) view.getTag();
                if (originalThreadInfo.f45035a == 4) {
                    this.f47433e.k(originalThreadInfo);
                } else {
                    this.f47433e.j(originalThreadInfo);
                }
                if (this.f47433e.p != null) {
                    this.f47433e.p.a(originalThreadInfo);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(OriginalThreadInfo originalThreadInfo);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1376487750, "Lcom/baidu/tieba/card/OriginalThreadCardView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1376487750, "Lcom/baidu/tieba/card/OriginalThreadCardView;");
                return;
            }
        }
        r = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        s = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
        t = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
        u = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
        v = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OriginalThreadCardView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.usePlaceHolder = true;
        this.q = 3;
        g(context);
    }

    public final void d(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, itemData) == null) {
            if (itemData == null) {
                this.j.setVisibility(8);
                setPadding(0, 0, 0, 0);
                return;
            }
            this.j.setVisibility(0);
            int i2 = s;
            setPadding(i2, i2, i2, t);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            if (this.f47430g.getVisibility() == 0) {
                layoutParams.addRule(3, R.id.imageview_thread_pic);
            } else {
                layoutParams.addRule(3, R.id.textview_thread_abstract);
            }
            this.j.setLayoutParams(layoutParams);
            this.l.setStarSpacing(r);
            int i3 = v;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f47430g.getLayoutParams();
            layoutParams2.width = i3;
            layoutParams2.height = i3;
            this.f47430g.setLayoutParams(layoutParams2);
            this.f47432i.setLayoutParams(layoutParams2);
            int i4 = u;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f47431h.getLayoutParams();
            layoutParams3.leftMargin = (i3 - i4) / 2;
            this.f47431h.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f47429f.getLayoutParams();
            layoutParams4.height = i3;
            this.f47429f.setLayoutParams(layoutParams4);
        }
    }

    public final void e(OriginalThreadInfo.ShareInfo shareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareInfo) == null) {
            ItemData itemData = shareInfo.itemData;
            d(itemData);
            if (itemData != null) {
                this.k.setText(itemData.mTitle);
                this.l.setStarCount(itemData.mStar);
                double d2 = itemData.mScore;
                if (d2 > 0.0d && d2 <= 10.0d) {
                    TextView textView = this.m;
                    textView.setText(itemData.mScore + "");
                } else {
                    this.m.setText(R.string.frs_evaluate_exception);
                }
                if (this.f47430g.getVisibility() == 8) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f47429f.getLayoutParams();
                    layoutParams.height = -2;
                    this.f47429f.setLayoutParams(layoutParams);
                }
            }
            ItemStarData itemStarData = shareInfo.itemStarData;
            if (itemStarData != null) {
                this.f47429f.setText(h(shareInfo.showText, itemStarData), TextView.BufferType.SPANNABLE);
            }
        }
    }

    public final void f(PollData pollData, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{pollData, str, Long.valueOf(j)}) == null) {
            this.n.setVisibility(8);
            if (pollData == null || ListUtils.isEmpty(pollData.getOptions())) {
                return;
            }
            this.n.setVisibility(0);
            this.n.setIsTransmit(true);
            this.n.setData(pollData, str, j);
        }
    }

    public void fillData(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, originalThreadInfo) == null) || originalThreadInfo == null) {
            return;
        }
        int i2 = originalThreadInfo.f45035a;
        if (i2 == 1) {
            this.o = 0;
            this.f47430g.setDefaultResource(R.color.CAM_X0204);
            if (this.usePlaceHolder) {
                this.f47430g.setPlaceHolder(2);
            } else {
                this.f47430g.setDefaultBgResource(R.color.CAM_X0209);
            }
            this.f47430g.setVisibility(0);
            this.f47430g.startLoad(originalThreadInfo.f45037c, 10, false);
        } else if (i2 == 2) {
            this.o = 0;
            this.f47430g.setDefaultResource(R.drawable.icon_card_url_n);
            this.f47430g.setDefaultBgResource(R.color.CAM_X0209);
            this.f47430g.setVisibility(0);
            this.f47430g.startLoad(originalThreadInfo.f45037c, 10, false);
        } else if (i2 == 3) {
            this.o = R.drawable.icon_share_play_n;
            this.f47430g.setDefaultResource(R.color.CAM_X0204);
            this.f47430g.setDefaultBgResource(R.color.CAM_X0209);
            this.f47430g.setVisibility(0);
            this.f47430g.startLoad(originalThreadInfo.f45037c, 10, false);
        } else if (i2 != 4) {
            this.o = 0;
            this.f47430g.setVisibility(8);
        } else {
            this.o = R.drawable.icon_share_card_live;
            this.f47430g.setDefaultResource(R.color.CAM_X0204);
            this.f47430g.setDefaultBgResource(R.color.CAM_X0209);
            this.f47430g.setVisibility(0);
            this.f47430g.startLoad(originalThreadInfo.f45037c, 10, false);
        }
        if (this.o != 0) {
            this.f47431h.setVisibility(0);
            this.f47432i.setVisibility(0);
            SkinManager.setImageResource(this.f47431h, this.o);
        } else {
            this.f47431h.setVisibility(8);
            this.f47432i.setVisibility(8);
        }
        SpannableString b2 = originalThreadInfo.b();
        this.f47429f.setText((b2 == null || b2.length() == 0) ? originalThreadInfo.f45036b : b2);
        if (b2 != null) {
            TiePlusEventController.tryExposeTiePlusLinkEvent(originalThreadInfo.e());
        }
        f(originalThreadInfo.F, originalThreadInfo.f45040f, originalThreadInfo.f45039e);
        setTag(originalThreadInfo);
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, context) == null) || context == null) {
            return;
        }
        this.f47428e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
        this.f47429f = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
        this.f47430g = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
        this.f47431h = (ImageView) inflate.findViewById(R.id.icon_video_type);
        this.f47432i = (ImageView) findViewById(R.id.thread_pic_mask);
        this.f47430g.setLongIconSupport(false);
        this.f47430g.setGifIconSupport(false);
        this.f47430g.setRadius(l.g(context, R.dimen.tbds10));
        this.f47430g.setConrers(5);
        int k = (((l.k(context) - (l.g(context, R.dimen.tbds44) * 2)) - (l.g(getContext(), R.dimen.tbds26) * 2)) - (l.g(getContext(), R.dimen.tbds10) * 4)) / 5;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f47430g.getLayoutParams();
        layoutParams.width = k;
        layoutParams.height = k;
        this.f47430g.setLayoutParams(layoutParams);
        this.f47432i.setLayoutParams(layoutParams);
        int g2 = l.g(context, R.dimen.tbds78);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f47431h.getLayoutParams();
        layoutParams2.leftMargin = (k - g2) / 2;
        this.f47431h.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f47429f.getLayoutParams();
        layoutParams3.height = k;
        this.f47429f.setLayoutParams(layoutParams3);
        this.j = (LinearLayout) findViewById(R.id.add_item);
        TextView textView = (TextView) findViewById(R.id.item_title);
        this.k = textView;
        textView.setMaxWidth(l.p(context)[0] / 2);
        this.l = (RankStarView) findViewById(R.id.item_star);
        this.m = (TextView) findViewById(R.id.item_score);
        VoteView voteView = (VoteView) findViewById(R.id.vote_view);
        this.n = voteView;
        voteView.setBgColor(R.color.CAM_X0207);
        setOnClickListener(new a(this));
    }

    public final SpannableStringBuilder h(String str, ItemStarData itemStarData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, itemStarData)) == null) {
            SpannableStringBuilder d2 = e.d(itemStarData);
            d2.append((CharSequence) str);
            return d2;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final void i(OriginalThreadInfo originalThreadInfo) {
        AlaInfoData alaInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, originalThreadInfo) == null) || originalThreadInfo == null || (alaInfoData = originalThreadInfo.j) == null || alaInfoData.live_status != 1) {
            return;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.j);
        AlaUserInfoData alaUserInfoData = originalThreadInfo.j.user_info;
        if (alaUserInfoData != null) {
            alaLiveInfoCoreData.userName = alaUserInfoData.user_name;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f47428e, alaLiveInfoCoreData, null, "", false, "")));
    }

    public final void j(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, originalThreadInfo) == null) || originalThreadInfo == null) {
            return;
        }
        if (ThreadCardUtils.isUgcThreadType(originalThreadInfo.p)) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f47428e);
            pbActivityConfig.createNormalCfg(originalThreadInfo.f45040f, null, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.f45039e));
            pbActivityConfig.setStartFrom(this.sourceFormForPb);
            pbActivityConfig.setBjhData(originalThreadInfo.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            return;
        }
        PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.f47428e);
        pbActivityConfig2.createNormalCfg(originalThreadInfo.f45040f, originalThreadInfo.n, null);
        pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.f45039e));
        pbActivityConfig2.setStartFrom(this.sourceFormForPb);
        pbActivityConfig2.setBjhData(originalThreadInfo.p);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
    }

    public final void k(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, originalThreadInfo) == null) && originalThreadInfo != null && originalThreadInfo.f45035a == 4) {
            int i2 = originalThreadInfo.k;
            if (i2 == 49 || i2 == 69) {
                i(originalThreadInfo);
            } else if (i2 == 60) {
                AlaInfoData alaInfoData = originalThreadInfo.j;
                if (alaInfoData != null) {
                    if (alaInfoData.live_status == 1) {
                        i(originalThreadInfo);
                        return;
                    }
                    AlaShareInfoData alaShareInfoData = alaInfoData.share_info;
                    if (alaShareInfoData != null && alaShareInfoData.record_tid <= 0) {
                        i(originalThreadInfo);
                        return;
                    } else {
                        j(originalThreadInfo);
                        return;
                    }
                }
                j(originalThreadInfo);
            } else {
                j(originalThreadInfo);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.q == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.q = skinType;
        SkinManager.setViewTextColor(this.f47429f, R.color.CAM_X0107);
        int i2 = this.o;
        if (i2 != 0) {
            SkinManager.setImageResource(this.f47431h, i2);
        }
        setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(this.f47428e, R.dimen.tbds10), SkinManager.getColor(R.color.CAM_X0206)));
        this.j.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(this.f47428e, R.dimen.tbds10), SkinManager.getColor(R.color.CAM_X0205)));
        this.n.onChangeSkinType(skinType);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f47429f, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0109, 1);
        this.l.updateStarDrawable();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    public void setReadState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            SkinManager.setViewTextColor(this.f47429f, z ? R.color.CAM_X0109 : R.color.CAM_X0107);
        }
    }

    public void setSubClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public void setUsePlaceHolder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.usePlaceHolder = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OriginalThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.usePlaceHolder = true;
        this.q = 3;
        g(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.usePlaceHolder = true;
        this.q = 3;
        g(context);
    }

    public void fillData(OriginalThreadInfo.ShareInfo shareInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, shareInfo) == null) || shareInfo == null) {
            return;
        }
        int i2 = shareInfo.showType;
        if (i2 == 1) {
            this.o = 0;
            this.f47430g.setDefaultResource(R.color.CAM_X0204);
            if (this.usePlaceHolder) {
                this.f47430g.setPlaceHolder(2);
            } else {
                this.f47430g.setDefaultBgResource(R.color.CAM_X0209);
            }
            this.f47430g.setVisibility(0);
            this.f47430g.startLoad(shareInfo.showPicUrl, 10, false);
        } else if (i2 == 2) {
            this.o = 0;
            this.f47430g.setDefaultResource(R.drawable.icon_card_url_n);
            this.f47430g.setDefaultBgResource(R.color.CAM_X0209);
            this.f47430g.setVisibility(0);
            this.f47430g.startLoad(shareInfo.showPicUrl, 10, false);
        } else if (i2 == 3) {
            this.o = R.drawable.icon_share_play_n;
            this.f47430g.setDefaultResource(R.color.CAM_X0204);
            this.f47430g.setDefaultBgResource(R.color.CAM_X0209);
            this.f47430g.setVisibility(0);
            this.f47430g.startLoad(shareInfo.showPicUrl, 10, false);
        } else if (i2 != 4) {
            this.o = 0;
            this.f47430g.setVisibility(8);
        } else {
            this.o = R.drawable.icon_share_card_live;
            this.f47430g.setDefaultResource(R.color.CAM_X0204);
            this.f47430g.setDefaultBgResource(R.color.CAM_X0209);
            this.f47430g.setVisibility(0);
            this.f47430g.startLoad(shareInfo.showPicUrl, 10, false);
        }
        if (this.o != 0) {
            this.f47431h.setVisibility(0);
            this.f47432i.setVisibility(0);
            SkinManager.setImageResource(this.f47431h, this.o);
        } else {
            this.f47431h.setVisibility(8);
            this.f47432i.setVisibility(8);
        }
        this.f47429f.setText(shareInfo.showText);
        e(shareInfo);
        this.n.setVisibility(8);
        setTag(shareInfo);
    }
}

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
import c.a.d.f.p.n;
import c.a.s0.g1.n.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
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
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class OriginalThreadCardView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f42334e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42335f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f42336g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f42337h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f42338i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f42339j;
    public TextView k;
    public RankStarView l;
    public TextView m;
    public VoteView n;
    public int o;
    public b p;
    public int q;
    public int sourceFormForPb;
    public String sourceFromForVideoRecommend;
    public boolean usePlaceHolder;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OriginalThreadCardView f42340e;

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
            this.f42340e = originalThreadCardView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && (view.getTag() instanceof OriginalThreadInfo)) {
                OriginalThreadInfo originalThreadInfo = (OriginalThreadInfo) view.getTag();
                if (originalThreadInfo.a == 4) {
                    this.f42340e.m(originalThreadInfo);
                } else if (originalThreadInfo.k == 40) {
                    this.f42340e.l(originalThreadInfo);
                } else {
                    this.f42340e.k(originalThreadInfo);
                }
                if (this.f42340e.p != null) {
                    this.f42340e.p.a(originalThreadInfo);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
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
        r = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        s = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
        t = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
        u = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
        v = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
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
        h(context);
    }

    public final void e(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, itemData) == null) {
            if (itemData == null) {
                this.f42339j.setVisibility(8);
                setPadding(0, 0, 0, 0);
                return;
            }
            this.f42339j.setVisibility(0);
            int i2 = s;
            setPadding(i2, i2, i2, t);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f42339j.getLayoutParams();
            if (this.f42336g.getVisibility() == 0) {
                layoutParams.addRule(3, R.id.imageview_thread_pic);
            } else {
                layoutParams.addRule(3, R.id.textview_thread_abstract);
            }
            this.f42339j.setLayoutParams(layoutParams);
            this.l.setStarSpacing(r);
            int i3 = v;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f42336g.getLayoutParams();
            layoutParams2.width = i3;
            layoutParams2.height = i3;
            this.f42336g.setLayoutParams(layoutParams2);
            this.f42338i.setLayoutParams(layoutParams2);
            int i4 = u;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f42337h.getLayoutParams();
            layoutParams3.leftMargin = (i3 - i4) / 2;
            this.f42337h.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f42335f.getLayoutParams();
            layoutParams4.height = i3;
            this.f42335f.setLayoutParams(layoutParams4);
        }
    }

    public final void f(OriginalThreadInfo.ShareInfo shareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareInfo) == null) {
            ItemData itemData = shareInfo.itemData;
            e(itemData);
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
                if (this.f42336g.getVisibility() == 8) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f42335f.getLayoutParams();
                    layoutParams.height = -2;
                    this.f42335f.setLayoutParams(layoutParams);
                }
            }
            ItemStarData itemStarData = shareInfo.itemStarData;
            if (itemStarData != null) {
                this.f42335f.setText(i(shareInfo.showText, itemStarData), TextView.BufferType.SPANNABLE);
            }
        }
    }

    public void fillData(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, originalThreadInfo) == null) || originalThreadInfo == null) {
            return;
        }
        int i2 = originalThreadInfo.a;
        if (i2 == 1) {
            this.o = 0;
            this.f42336g.setDefaultResource(R.color.CAM_X0204);
            if (this.usePlaceHolder) {
                this.f42336g.setPlaceHolder(2);
            } else {
                this.f42336g.setDefaultBgResource(R.color.CAM_X0209);
            }
            this.f42336g.setVisibility(0);
            this.f42336g.startLoad(originalThreadInfo.f40129c, 10, false);
        } else if (i2 == 2) {
            this.o = 0;
            this.f42336g.setDefaultResource(R.drawable.icon_card_url_n);
            this.f42336g.setDefaultBgResource(R.color.CAM_X0209);
            this.f42336g.setVisibility(0);
            this.f42336g.startLoad(originalThreadInfo.f40129c, 10, false);
        } else if (i2 == 3) {
            this.o = R.drawable.icon_share_play_n;
            this.f42336g.setDefaultResource(R.color.CAM_X0204);
            this.f42336g.setDefaultBgResource(R.color.CAM_X0209);
            this.f42336g.setVisibility(0);
            this.f42336g.startLoad(originalThreadInfo.f40129c, 10, false);
        } else if (i2 != 4) {
            this.o = 0;
            this.f42336g.setVisibility(8);
        } else {
            this.o = R.drawable.icon_share_card_live;
            this.f42336g.setDefaultResource(R.color.CAM_X0204);
            this.f42336g.setDefaultBgResource(R.color.CAM_X0209);
            this.f42336g.setVisibility(0);
            this.f42336g.startLoad(originalThreadInfo.f40129c, 10, false);
        }
        if (this.o != 0) {
            this.f42337h.setVisibility(0);
            this.f42338i.setVisibility(0);
            SkinManager.setImageResource(this.f42337h, this.o);
        } else {
            this.f42337h.setVisibility(8);
            this.f42338i.setVisibility(8);
        }
        SpannableString b2 = originalThreadInfo.b();
        this.f42335f.setText((b2 == null || b2.length() == 0) ? originalThreadInfo.f40128b : b2);
        if (b2 != null) {
            TiePlusEventController.tryExposeTiePlusLinkEvent(originalThreadInfo.f());
        }
        g(originalThreadInfo.G, originalThreadInfo.f40132f, originalThreadInfo.f40131e);
        setTag(originalThreadInfo);
    }

    public final void g(PollData pollData, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{pollData, str, Long.valueOf(j2)}) == null) {
            this.n.setVisibility(8);
            if (pollData == null || ListUtils.isEmpty(pollData.getOptions())) {
                return;
            }
            this.n.setVisibility(0);
            this.n.setIsTransmit(true);
            this.n.setData(pollData, str, j2);
        }
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, context) == null) || context == null) {
            return;
        }
        this.f42334e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
        this.f42335f = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
        this.f42336g = (TbImageView) inflate.findViewById(R.id.imageview_thread_pic);
        this.f42337h = (ImageView) inflate.findViewById(R.id.icon_video_type);
        this.f42338i = (ImageView) findViewById(R.id.thread_pic_mask);
        this.f42336g.setLongIconSupport(false);
        this.f42336g.setGifIconSupport(false);
        this.f42336g.setRadius(n.f(context, R.dimen.tbds10));
        this.f42336g.setConrers(5);
        int k = (((n.k(context) - (n.f(context, R.dimen.tbds44) * 2)) - (n.f(getContext(), R.dimen.tbds26) * 2)) - (n.f(getContext(), R.dimen.tbds10) * 4)) / 5;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f42336g.getLayoutParams();
        layoutParams.width = k;
        layoutParams.height = k;
        this.f42336g.setLayoutParams(layoutParams);
        this.f42338i.setLayoutParams(layoutParams);
        int f2 = n.f(context, R.dimen.tbds78);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f42337h.getLayoutParams();
        layoutParams2.leftMargin = (k - f2) / 2;
        this.f42337h.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f42335f.getLayoutParams();
        layoutParams3.height = k;
        this.f42335f.setLayoutParams(layoutParams3);
        this.f42339j = (LinearLayout) findViewById(R.id.add_item);
        TextView textView = (TextView) findViewById(R.id.item_title);
        this.k = textView;
        textView.setMaxWidth(n.p(context)[0] / 2);
        this.l = (RankStarView) findViewById(R.id.item_star);
        this.m = (TextView) findViewById(R.id.item_score);
        VoteView voteView = (VoteView) findViewById(R.id.vote_view);
        this.n = voteView;
        voteView.setBgColor(R.color.CAM_X0207);
        setOnClickListener(new a(this));
    }

    public final SpannableStringBuilder i(String str, ItemStarData itemStarData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, itemStarData)) == null) {
            SpannableStringBuilder d2 = e.d(itemStarData);
            d2.append((CharSequence) str);
            return d2;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final void j(OriginalThreadInfo originalThreadInfo) {
        AlaInfoData alaInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, originalThreadInfo) == null) || originalThreadInfo == null || (alaInfoData = originalThreadInfo.f40136j) == null || alaInfoData.live_status != 1) {
            return;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.f40136j);
        AlaUserInfoData alaUserInfoData = originalThreadInfo.f40136j.user_info;
        if (alaUserInfoData != null) {
            alaLiveInfoCoreData.userName = alaUserInfoData.user_name;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f42334e, alaLiveInfoCoreData, null, "", false, "")));
    }

    public final void k(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, originalThreadInfo) == null) || originalThreadInfo == null) {
            return;
        }
        if (ThreadCardUtils.isUgcThreadType(originalThreadInfo.p)) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f42334e);
            pbActivityConfig.createNormalCfg(originalThreadInfo.f40132f, null, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.f40131e));
            pbActivityConfig.setStartFrom(this.sourceFormForPb);
            pbActivityConfig.setBjhData(originalThreadInfo.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            return;
        }
        PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.f42334e);
        pbActivityConfig2.createNormalCfg(originalThreadInfo.f40132f, originalThreadInfo.n, null);
        pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.f40131e));
        pbActivityConfig2.setStartFrom(this.sourceFormForPb);
        pbActivityConfig2.setBjhData(originalThreadInfo.p);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
    }

    public final void l(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, originalThreadInfo) == null) || originalThreadInfo == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = originalThreadInfo.f40132f;
        arrayList.add(videoItemData);
        VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(this.f42334e, arrayList, null, this.sourceFromForVideoRecommend);
        videoRecommentPlayActivityConfig.setParamIsVertail(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
    }

    public final void m(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, originalThreadInfo) == null) && originalThreadInfo != null && originalThreadInfo.a == 4) {
            int i2 = originalThreadInfo.k;
            if (i2 == 49 || i2 == 69) {
                j(originalThreadInfo);
            } else if (i2 == 60) {
                AlaInfoData alaInfoData = originalThreadInfo.f40136j;
                if (alaInfoData != null) {
                    if (alaInfoData.live_status == 1) {
                        j(originalThreadInfo);
                        return;
                    }
                    AlaShareInfoData alaShareInfoData = alaInfoData.share_info;
                    if (alaShareInfoData != null && alaShareInfoData.record_tid <= 0) {
                        j(originalThreadInfo);
                        return;
                    } else {
                        k(originalThreadInfo);
                        return;
                    }
                }
                k(originalThreadInfo);
            } else {
                k(originalThreadInfo);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.q == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.q = skinType;
        SkinManager.setViewTextColor(this.f42335f, R.color.CAM_X0107);
        int i2 = this.o;
        if (i2 != 0) {
            SkinManager.setImageResource(this.f42337h, i2);
        }
        setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f42334e, R.dimen.tbds10), SkinManager.getColor(R.color.CAM_X0206)));
        this.f42339j.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f42334e, R.dimen.tbds10), SkinManager.getColor(R.color.CAM_X0205)));
        this.n.onChangeSkinType(skinType);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f42335f, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0109, 1);
        this.l.updateStarDrawable();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    public void setCardFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.sourceFromForVideoRecommend = str;
        }
    }

    public void setReadState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            SkinManager.setViewTextColor(this.f42335f, z ? R.color.CAM_X0109 : R.color.CAM_X0107);
        }
    }

    public void setSubClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public void setUsePlaceHolder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
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
        h(context);
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
        h(context);
    }

    public void fillData(OriginalThreadInfo.ShareInfo shareInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareInfo) == null) || shareInfo == null) {
            return;
        }
        int i2 = shareInfo.showType;
        if (i2 == 1) {
            this.o = 0;
            this.f42336g.setDefaultResource(R.color.CAM_X0204);
            if (this.usePlaceHolder) {
                this.f42336g.setPlaceHolder(2);
            } else {
                this.f42336g.setDefaultBgResource(R.color.CAM_X0209);
            }
            this.f42336g.setVisibility(0);
            this.f42336g.startLoad(shareInfo.showPicUrl, 10, false);
        } else if (i2 == 2) {
            this.o = 0;
            this.f42336g.setDefaultResource(R.drawable.icon_card_url_n);
            this.f42336g.setDefaultBgResource(R.color.CAM_X0209);
            this.f42336g.setVisibility(0);
            this.f42336g.startLoad(shareInfo.showPicUrl, 10, false);
        } else if (i2 == 3) {
            this.o = R.drawable.icon_share_play_n;
            this.f42336g.setDefaultResource(R.color.CAM_X0204);
            this.f42336g.setDefaultBgResource(R.color.CAM_X0209);
            this.f42336g.setVisibility(0);
            this.f42336g.startLoad(shareInfo.showPicUrl, 10, false);
        } else if (i2 != 4) {
            this.o = 0;
            this.f42336g.setVisibility(8);
        } else {
            this.o = R.drawable.icon_share_card_live;
            this.f42336g.setDefaultResource(R.color.CAM_X0204);
            this.f42336g.setDefaultBgResource(R.color.CAM_X0209);
            this.f42336g.setVisibility(0);
            this.f42336g.startLoad(shareInfo.showPicUrl, 10, false);
        }
        if (this.o != 0) {
            this.f42337h.setVisibility(0);
            this.f42338i.setVisibility(0);
            SkinManager.setImageResource(this.f42337h, this.o);
        } else {
            this.f42337h.setVisibility(8);
            this.f42338i.setVisibility(8);
        }
        this.f42335f.setText(shareInfo.showText);
        f(shareInfo);
        this.n.setVisibility(8);
        setTag(shareInfo);
    }
}

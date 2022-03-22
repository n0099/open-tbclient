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
import c.a.o0.e1.n.e;
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
/* loaded from: classes5.dex */
public class OriginalThreadCardView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f31656b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f31657c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f31658d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f31659e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f31660f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f31661g;

    /* renamed from: h  reason: collision with root package name */
    public RankStarView f31662h;
    public TextView i;
    public VoteView j;
    public int k;
    public b l;
    public int m;
    public String n;
    public boolean o;
    public int p;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OriginalThreadCardView a;

        public a(OriginalThreadCardView originalThreadCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {originalThreadCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = originalThreadCardView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && (view.getTag() instanceof OriginalThreadInfo)) {
                OriginalThreadInfo originalThreadInfo = (OriginalThreadInfo) view.getTag();
                if (originalThreadInfo.a == 4) {
                    this.a.o(originalThreadInfo);
                } else if (originalThreadInfo.k == 40) {
                    this.a.n(originalThreadInfo);
                } else {
                    this.a.m(originalThreadInfo);
                }
                if (this.a.l != null) {
                    this.a.l.a(originalThreadInfo);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
        q = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        r = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
        s = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
        t = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
        u = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = true;
        this.p = 3;
        j(context);
    }

    public final void e(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, itemData) == null) {
            if (itemData == null) {
                this.f31660f.setVisibility(8);
                setPadding(0, 0, 0, 0);
                return;
            }
            this.f31660f.setVisibility(0);
            int i = r;
            setPadding(i, i, i, s);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f31660f.getLayoutParams();
            if (this.f31657c.getVisibility() == 0) {
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f090e8f);
            } else {
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f091f74);
            }
            this.f31660f.setLayoutParams(layoutParams);
            this.f31662h.setStarSpacing(q);
            int i2 = u;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f31657c.getLayoutParams();
            layoutParams2.width = i2;
            layoutParams2.height = i2;
            this.f31657c.setLayoutParams(layoutParams2);
            this.f31659e.setLayoutParams(layoutParams2);
            int i3 = t;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f31658d.getLayoutParams();
            layoutParams3.leftMargin = (i2 - i3) / 2;
            this.f31658d.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f31656b.getLayoutParams();
            layoutParams4.height = i2;
            this.f31656b.setLayoutParams(layoutParams4);
        }
    }

    public void f(OriginalThreadInfo.ShareInfo shareInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareInfo) == null) || shareInfo == null) {
            return;
        }
        int i = shareInfo.showType;
        if (i == 1) {
            this.k = 0;
            this.f31657c.setDefaultResource(R.color.CAM_X0204);
            if (this.o) {
                this.f31657c.setPlaceHolder(2);
            } else {
                this.f31657c.setDefaultBgResource(R.color.CAM_X0209);
            }
            this.f31657c.setVisibility(0);
            this.f31657c.J(shareInfo.showPicUrl, 10, false);
        } else if (i == 2) {
            this.k = 0;
            this.f31657c.setDefaultResource(R.drawable.icon_card_url_n);
            this.f31657c.setDefaultBgResource(R.color.CAM_X0209);
            this.f31657c.setVisibility(0);
            this.f31657c.J(shareInfo.showPicUrl, 10, false);
        } else if (i == 3) {
            this.k = R.drawable.icon_share_play_n;
            this.f31657c.setDefaultResource(R.color.CAM_X0204);
            this.f31657c.setDefaultBgResource(R.color.CAM_X0209);
            this.f31657c.setVisibility(0);
            this.f31657c.J(shareInfo.showPicUrl, 10, false);
        } else if (i != 4) {
            this.k = 0;
            this.f31657c.setVisibility(8);
        } else {
            this.k = R.drawable.icon_share_card_live;
            this.f31657c.setDefaultResource(R.color.CAM_X0204);
            this.f31657c.setDefaultBgResource(R.color.CAM_X0209);
            this.f31657c.setVisibility(0);
            this.f31657c.J(shareInfo.showPicUrl, 10, false);
        }
        if (this.k != 0) {
            this.f31658d.setVisibility(0);
            this.f31659e.setVisibility(0);
            SkinManager.setImageResource(this.f31658d, this.k);
        } else {
            this.f31658d.setVisibility(8);
            this.f31659e.setVisibility(8);
        }
        this.f31656b.setText(shareInfo.showText);
        h(shareInfo);
        this.j.setVisibility(8);
        setTag(shareInfo);
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) || originalThreadInfo == null) {
            return;
        }
        int i = originalThreadInfo.a;
        if (i == 1) {
            this.k = 0;
            this.f31657c.setDefaultResource(R.color.CAM_X0204);
            if (this.o) {
                this.f31657c.setPlaceHolder(2);
            } else {
                this.f31657c.setDefaultBgResource(R.color.CAM_X0209);
            }
            this.f31657c.setVisibility(0);
            this.f31657c.J(originalThreadInfo.f29823c, 10, false);
        } else if (i == 2) {
            this.k = 0;
            this.f31657c.setDefaultResource(R.drawable.icon_card_url_n);
            this.f31657c.setDefaultBgResource(R.color.CAM_X0209);
            this.f31657c.setVisibility(0);
            this.f31657c.J(originalThreadInfo.f29823c, 10, false);
        } else if (i == 3) {
            this.k = R.drawable.icon_share_play_n;
            this.f31657c.setDefaultResource(R.color.CAM_X0204);
            this.f31657c.setDefaultBgResource(R.color.CAM_X0209);
            this.f31657c.setVisibility(0);
            this.f31657c.J(originalThreadInfo.f29823c, 10, false);
        } else if (i != 4) {
            this.k = 0;
            this.f31657c.setVisibility(8);
        } else {
            this.k = R.drawable.icon_share_card_live;
            this.f31657c.setDefaultResource(R.color.CAM_X0204);
            this.f31657c.setDefaultBgResource(R.color.CAM_X0209);
            this.f31657c.setVisibility(0);
            this.f31657c.J(originalThreadInfo.f29823c, 10, false);
        }
        if (this.k != 0) {
            this.f31658d.setVisibility(0);
            this.f31659e.setVisibility(0);
            SkinManager.setImageResource(this.f31658d, this.k);
        } else {
            this.f31658d.setVisibility(8);
            this.f31659e.setVisibility(8);
        }
        SpannableString b2 = originalThreadInfo.b();
        this.f31656b.setText((b2 == null || b2.length() == 0) ? originalThreadInfo.f29822b : b2);
        if (b2 != null) {
            TiePlusEventController.h(originalThreadInfo.f());
        }
        i(originalThreadInfo.G, originalThreadInfo.f29826f, originalThreadInfo.f29825e);
        setTag(originalThreadInfo);
    }

    public final void h(OriginalThreadInfo.ShareInfo shareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, shareInfo) == null) {
            ItemData itemData = shareInfo.itemData;
            e(itemData);
            if (itemData != null) {
                this.f31661g.setText(itemData.mTitle);
                this.f31662h.setStarCount(itemData.mStar);
                double d2 = itemData.mScore;
                if (d2 > 0.0d && d2 <= 10.0d) {
                    TextView textView = this.i;
                    textView.setText(itemData.mScore + "");
                } else {
                    this.i.setText(R.string.obfuscated_res_0x7f0f06b7);
                }
                if (this.f31657c.getVisibility() == 8) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f31656b.getLayoutParams();
                    layoutParams.height = -2;
                    this.f31656b.setLayoutParams(layoutParams);
                }
            }
            ItemStarData itemStarData = shareInfo.itemStarData;
            if (itemStarData != null) {
                this.f31656b.setText(k(shareInfo.showText, itemStarData), TextView.BufferType.SPANNABLE);
            }
        }
    }

    public final void i(PollData pollData, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{pollData, str, Long.valueOf(j)}) == null) {
            this.j.setVisibility(8);
            if (pollData == null || ListUtils.isEmpty(pollData.getOptions())) {
                return;
            }
            this.j.setVisibility(0);
            this.j.setIsTransmit(true);
            this.j.setData(pollData, str, j);
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, context) == null) || context == null) {
            return;
        }
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01af, (ViewGroup) this, true);
        this.f31656b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091f74);
        this.f31657c = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090e8f);
        this.f31658d = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090e24);
        this.f31659e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091fc0);
        this.f31657c.setLongIconSupport(false);
        this.f31657c.setGifIconSupport(false);
        this.f31657c.setRadius(n.f(context, R.dimen.tbds10));
        this.f31657c.setConrers(5);
        int k = (((n.k(context) - (n.f(context, R.dimen.tbds44) * 2)) - (n.f(getContext(), R.dimen.tbds26) * 2)) - (n.f(getContext(), R.dimen.tbds10) * 4)) / 5;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f31657c.getLayoutParams();
        layoutParams.width = k;
        layoutParams.height = k;
        this.f31657c.setLayoutParams(layoutParams);
        this.f31659e.setLayoutParams(layoutParams);
        int f2 = n.f(context, R.dimen.tbds78);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f31658d.getLayoutParams();
        layoutParams2.leftMargin = (k - f2) / 2;
        this.f31658d.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f31656b.getLayoutParams();
        layoutParams3.height = k;
        this.f31656b.setLayoutParams(layoutParams3);
        this.f31660f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090113);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090fab);
        this.f31661g = textView;
        textView.setMaxWidth(n.p(context)[0] / 2);
        this.f31662h = (RankStarView) findViewById(R.id.obfuscated_res_0x7f090fa2);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090f9e);
        VoteView voteView = (VoteView) findViewById(R.id.obfuscated_res_0x7f09243d);
        this.j = voteView;
        voteView.setBgColor(R.color.CAM_X0207);
        setOnClickListener(new a(this));
    }

    public final SpannableStringBuilder k(String str, ItemStarData itemStarData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, itemStarData)) == null) {
            SpannableStringBuilder d2 = e.d(itemStarData);
            d2.append((CharSequence) str);
            return d2;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final void l(OriginalThreadInfo originalThreadInfo) {
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.a, alaLiveInfoCoreData, null, "", false, "")));
    }

    public final void m(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, originalThreadInfo) == null) || originalThreadInfo == null) {
            return;
        }
        if (ThreadCardUtils.isUgcThreadType(originalThreadInfo.p)) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a);
            pbActivityConfig.createNormalCfg(originalThreadInfo.f29826f, null, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.f29825e));
            pbActivityConfig.setStartFrom(this.m);
            pbActivityConfig.setBjhData(originalThreadInfo.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            return;
        }
        PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.a);
        pbActivityConfig2.createNormalCfg(originalThreadInfo.f29826f, originalThreadInfo.n, null);
        pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.f29825e));
        pbActivityConfig2.setStartFrom(this.m);
        pbActivityConfig2.setBjhData(originalThreadInfo.p);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
    }

    public final void n(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, originalThreadInfo) == null) || originalThreadInfo == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = originalThreadInfo.f29826f;
        arrayList.add(videoItemData);
        VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(this.a, arrayList, null, this.n);
        videoRecommentPlayActivityConfig.setParamIsVertail(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
    }

    public final void o(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, originalThreadInfo) == null) && originalThreadInfo != null && originalThreadInfo.a == 4) {
            int i = originalThreadInfo.k;
            if (i == 49 || i == 69) {
                l(originalThreadInfo);
            } else if (i == 60) {
                AlaInfoData alaInfoData = originalThreadInfo.j;
                if (alaInfoData != null) {
                    if (alaInfoData.live_status == 1) {
                        l(originalThreadInfo);
                        return;
                    }
                    AlaShareInfoData alaShareInfoData = alaInfoData.share_info;
                    if (alaShareInfoData != null && alaShareInfoData.record_tid <= 0) {
                        l(originalThreadInfo);
                        return;
                    } else {
                        m(originalThreadInfo);
                        return;
                    }
                }
                m(originalThreadInfo);
            } else {
                m(originalThreadInfo);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }

    public void p() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.p == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.p = skinType;
        SkinManager.setViewTextColor(this.f31656b, (int) R.color.CAM_X0107);
        int i = this.k;
        if (i != 0) {
            SkinManager.setImageResource(this.f31658d, i);
        }
        setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.a, R.dimen.tbds10), SkinManager.getColor(R.color.CAM_X0206)));
        this.f31660f.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.a, R.dimen.tbds10), SkinManager.getColor(R.color.CAM_X0205)));
        this.j.C(skinType);
        SkinManager.setViewTextColor(this.f31661g, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f31656b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0109, 1);
        this.f31662h.f();
    }

    public void setCardFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.n = str;
        }
    }

    public void setReadState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            SkinManager.setViewTextColor(this.f31656b, z ? R.color.CAM_X0109 : R.color.CAM_X0107);
        }
    }

    public void setSubClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public void setUsePlaceHolder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.o = z;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.o = true;
        this.p = 3;
        j(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OriginalThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.o = true;
        this.p = 3;
        j(context);
    }
}

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
import com.repackage.ef5;
import com.repackage.oi;
import com.repackage.vr4;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class OriginalThreadCardView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TextView b;
    public TbImageView c;
    public ImageView d;
    public ImageView e;
    public LinearLayout f;
    public TextView g;
    public RankStarView h;
    public TextView i;
    public VoteView j;
    public int k;
    public b l;
    public int m;
    public String n;
    public boolean o;
    public View p;
    public int q;

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && (view2.getTag() instanceof OriginalThreadInfo)) {
                OriginalThreadInfo originalThreadInfo = (OriginalThreadInfo) view2.getTag();
                if (originalThreadInfo.a == 4) {
                    this.a.p(originalThreadInfo);
                } else if (originalThreadInfo.k == 40) {
                    this.a.o(originalThreadInfo);
                } else {
                    this.a.n(originalThreadInfo);
                }
                if (this.a.l != null) {
                    this.a.l.a(originalThreadInfo);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        r = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        s = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
        t = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
        u = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
        v = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
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
        this.q = 3;
        k(context);
    }

    public final void e(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, itemData) == null) {
            if (itemData == null) {
                this.f.setVisibility(8);
                setPadding(0, 0, 0, 0);
                return;
            }
            this.f.setVisibility(0);
            int i = s;
            setPadding(i, i, i, t);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            if (this.c.getVisibility() == 0) {
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f090e8b);
            } else {
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f091f61);
            }
            this.f.setLayoutParams(layoutParams);
            this.h.setStarSpacing(r);
            int i2 = v;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams2.width = i2;
            layoutParams2.height = i2;
            this.c.setLayoutParams(layoutParams2);
            this.e.setLayoutParams(layoutParams2);
            int i3 = u;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
            layoutParams3.leftMargin = (i2 - i3) / 2;
            this.d.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams4.height = i2;
            this.b.setLayoutParams(layoutParams4);
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
            this.c.setDefaultResource(R.color.CAM_X0204);
            if (this.o) {
                this.c.setPlaceHolder(2);
            } else {
                this.c.setDefaultBgResource(R.color.CAM_X0209);
            }
            this.c.setVisibility(0);
            this.c.K(shareInfo.showPicUrl, 10, false);
        } else if (i == 2) {
            this.k = 0;
            this.c.setDefaultResource(R.drawable.icon_card_url_n);
            this.c.setDefaultBgResource(R.color.CAM_X0209);
            this.c.setVisibility(0);
            this.c.K(shareInfo.showPicUrl, 10, false);
        } else if (i == 3) {
            this.k = R.drawable.icon_share_play_n;
            this.c.setDefaultResource(R.color.CAM_X0204);
            this.c.setDefaultBgResource(R.color.CAM_X0209);
            this.c.setVisibility(0);
            this.c.K(shareInfo.showPicUrl, 10, false);
        } else if (i != 4) {
            this.k = 0;
            this.c.setVisibility(8);
        } else {
            this.k = R.drawable.icon_share_card_live;
            this.c.setDefaultResource(R.color.CAM_X0204);
            this.c.setDefaultBgResource(R.color.CAM_X0209);
            this.c.setVisibility(0);
            this.c.K(shareInfo.showPicUrl, 10, false);
        }
        if (this.k != 0) {
            this.d.setVisibility(0);
            this.e.setVisibility(8);
            SkinManager.setImageResource(this.d, this.k);
        } else {
            this.d.setVisibility(8);
            this.e.setVisibility(8);
        }
        this.b.setText(shareInfo.showText);
        i(shareInfo);
        this.j.setVisibility(8);
        setTag(shareInfo);
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            h(originalThreadInfo, null);
        }
    }

    public void h(OriginalThreadInfo originalThreadInfo, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, originalThreadInfo, str) == null) || originalThreadInfo == null) {
            return;
        }
        int i = originalThreadInfo.a;
        if (i == 1) {
            this.k = 0;
            this.c.setDefaultResource(R.color.CAM_X0204);
            if (this.o) {
                this.c.setPlaceHolder(2);
            } else {
                this.c.setDefaultBgResource(R.color.CAM_X0209);
            }
            this.c.setVisibility(0);
            this.c.K(originalThreadInfo.c, 10, false);
        } else if (i == 2) {
            this.k = 0;
            this.c.setDefaultResource(R.drawable.icon_card_url_n);
            this.c.setDefaultBgResource(R.color.CAM_X0209);
            this.c.setVisibility(0);
            this.c.K(originalThreadInfo.c, 10, false);
        } else if (i == 3) {
            this.k = R.drawable.icon_share_play_n;
            this.c.setDefaultResource(R.color.CAM_X0204);
            this.c.setDefaultBgResource(R.color.CAM_X0209);
            this.c.setVisibility(0);
            this.c.K(originalThreadInfo.c, 10, false);
        } else if (i != 4) {
            this.k = 0;
            this.c.setVisibility(8);
        } else {
            this.k = R.drawable.icon_share_card_live;
            this.c.setDefaultResource(R.color.CAM_X0204);
            this.c.setDefaultBgResource(R.color.CAM_X0209);
            this.c.setVisibility(0);
            this.c.K(originalThreadInfo.c, 10, false);
        }
        if (this.k != 0) {
            this.d.setVisibility(0);
            this.e.setVisibility(8);
            SkinManager.setImageResource(this.d, this.k);
        } else {
            this.d.setVisibility(8);
            this.e.setVisibility(8);
        }
        SpannableString b2 = originalThreadInfo.b();
        if (str != null) {
            this.b.setText(str);
        } else {
            this.b.setText((b2 == null || b2.length() == 0) ? originalThreadInfo.b : b2);
        }
        if (b2 != null) {
            TiePlusEventController.p(originalThreadInfo.f());
        }
        j(originalThreadInfo.G, originalThreadInfo.f, originalThreadInfo.e);
        setTag(originalThreadInfo);
    }

    public final void i(OriginalThreadInfo.ShareInfo shareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, shareInfo) == null) {
            ItemData itemData = shareInfo.itemData;
            e(itemData);
            if (itemData != null) {
                this.g.setText(itemData.mTitle);
                this.h.setStarCount(itemData.mStar);
                double d = itemData.mScore;
                if (d > 0.0d && d <= 10.0d) {
                    TextView textView = this.i;
                    textView.setText(itemData.mScore + "");
                } else {
                    this.i.setText(R.string.obfuscated_res_0x7f0f06bc);
                }
                if (this.c.getVisibility() == 8) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
                    layoutParams.height = -2;
                    this.b.setLayoutParams(layoutParams);
                }
            }
            ItemStarData itemStarData = shareInfo.itemStarData;
            if (itemStarData != null) {
                this.b.setText(l(shareInfo.showText, itemStarData), TextView.BufferType.SPANNABLE);
            }
        }
    }

    public final void j(PollData pollData, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{pollData, str, Long.valueOf(j)}) == null) {
            this.j.setVisibility(8);
            if (pollData == null || ListUtils.isEmpty(pollData.getOptions())) {
                return;
            }
            this.j.setVisibility(0);
            this.j.setIsTransmit(true);
            this.j.setData(pollData, str, j);
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, context) == null) || context == null) {
            return;
        }
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01b1, (ViewGroup) this, true);
        this.p = inflate;
        this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091f61);
        this.c = (TbImageView) this.p.findViewById(R.id.obfuscated_res_0x7f090e8b);
        this.d = (ImageView) this.p.findViewById(R.id.obfuscated_res_0x7f090e23);
        this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091fab);
        this.c.setLongIconSupport(false);
        this.c.setGifIconSupport(false);
        this.c.setRadius(oi.f(context, R.dimen.tbds10));
        this.c.setConrers(15);
        this.c.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0706e9));
        this.c.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.c.setBorderSurroundContent(true);
        this.c.setDrawBorder(true);
        int k = (((oi.k(context) - (oi.f(context, R.dimen.tbds44) * 2)) - (oi.f(getContext(), R.dimen.tbds26) * 2)) - (oi.f(getContext(), R.dimen.tbds10) * 4)) / 5;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.width = k;
        layoutParams.height = k;
        this.c.setLayoutParams(layoutParams);
        this.e.setLayoutParams(layoutParams);
        int f = oi.f(context, R.dimen.tbds52);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams2.leftMargin = (k - f) / 2;
        this.d.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams3.height = k;
        this.b.setLayoutParams(layoutParams3);
        this.f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09011c);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090fa6);
        this.g = textView;
        textView.setMaxWidth(oi.p(context)[0] / 2);
        this.h = (RankStarView) findViewById(R.id.obfuscated_res_0x7f090f9d);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090f99);
        VoteView voteView = (VoteView) findViewById(R.id.obfuscated_res_0x7f092419);
        this.j = voteView;
        voteView.setBgColor(R.color.CAM_X0207);
        setOnClickListener(new a(this));
    }

    public final SpannableStringBuilder l(String str, ItemStarData itemStarData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, itemStarData)) == null) {
            SpannableStringBuilder d = ef5.d(itemStarData);
            d.append((CharSequence) str);
            return d;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final void m(OriginalThreadInfo originalThreadInfo) {
        AlaInfoData alaInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, originalThreadInfo) == null) || originalThreadInfo == null || (alaInfoData = originalThreadInfo.j) == null || alaInfoData.live_status != 1) {
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

    public final void n(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, originalThreadInfo) == null) || originalThreadInfo == null) {
            return;
        }
        if (ThreadCardUtils.isUgcThreadType(originalThreadInfo.p)) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a);
            pbActivityConfig.createNormalCfg(originalThreadInfo.f, null, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.e));
            pbActivityConfig.setStartFrom(this.m);
            pbActivityConfig.setBjhData(originalThreadInfo.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            return;
        }
        PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.a);
        pbActivityConfig2.createNormalCfg(originalThreadInfo.f, originalThreadInfo.n, null);
        pbActivityConfig2.setForumId(String.valueOf(originalThreadInfo.e));
        pbActivityConfig2.setStartFrom(this.m);
        pbActivityConfig2.setBjhData(originalThreadInfo.p);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
    }

    public final void o(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, originalThreadInfo) == null) || originalThreadInfo == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = originalThreadInfo.f;
        arrayList.add(videoItemData);
        VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(this.a, arrayList, null, this.n);
        videoRecommentPlayActivityConfig.setParamIsVertail(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }

    public final void p(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, originalThreadInfo) == null) && originalThreadInfo != null && originalThreadInfo.a == 4) {
            int i = originalThreadInfo.k;
            if (i == 49 || i == 69) {
                m(originalThreadInfo);
            } else if (i == 60) {
                AlaInfoData alaInfoData = originalThreadInfo.j;
                if (alaInfoData != null) {
                    if (alaInfoData.live_status == 1) {
                        m(originalThreadInfo);
                        return;
                    }
                    AlaShareInfoData alaShareInfoData = alaInfoData.share_info;
                    if (alaShareInfoData != null && alaShareInfoData.record_tid <= 0) {
                        m(originalThreadInfo);
                        return;
                    } else {
                        n(originalThreadInfo);
                        return;
                    }
                }
                n(originalThreadInfo);
            } else {
                n(originalThreadInfo);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            r(R.color.CAM_X0206, R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public void r(int i, int i2, int i3) {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048590, this, i, i2, i3) == null) || this.q == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.q = skinType;
        SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0107);
        int i4 = this.k;
        if (i4 != 0) {
            SkinManager.setImageResource(this.d, i4);
        }
        setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(oi.f(this.a, R.dimen.tbds10), SkinManager.getColor(i)));
        this.f.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(oi.f(this.a, R.dimen.tbds10), SkinManager.getColor(R.color.CAM_X0205)));
        this.j.C(skinType);
        SkinManager.setViewTextColor(this.g, i2, 1);
        SkinManager.setViewTextColor(this.b, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.i, i3, 1);
        this.h.f();
    }

    public void setCardFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.n = str;
        }
    }

    public void setContainerAndTextBackGroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            View view2 = this.p;
            if (view2 != null) {
                vr4.d(view2).f(i);
            }
            TextView textView = this.b;
            if (textView != null) {
                vr4.d(textView).f(i);
            }
        }
    }

    public void setReadState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            SkinManager.setViewTextColor(this.b, z ? R.color.CAM_X0109 : R.color.CAM_X0107);
        }
    }

    public void setSubClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public void setUsePlaceHolder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
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
        this.q = 3;
        k(context);
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
        this.q = 3;
        k(context);
    }
}

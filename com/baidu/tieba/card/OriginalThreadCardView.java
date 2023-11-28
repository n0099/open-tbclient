package com.baidu.tieba.card;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaShareInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tieba.R;
import com.baidu.tieba.py5;
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
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
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
    public boolean q;
    public int r;

    /* loaded from: classes5.dex */
    public interface b {
        void a(OriginalThreadInfo originalThreadInfo);
    }

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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && !this.a.q && (view2.getTag() instanceof OriginalThreadInfo)) {
                OriginalThreadInfo originalThreadInfo = (OriginalThreadInfo) view2.getTag();
                if (!TextUtils.isEmpty(originalThreadInfo.I)) {
                    UrlManager.getInstance().dealOneLink(originalThreadInfo.I);
                } else {
                    int i = originalThreadInfo.a;
                    if (i != 4) {
                        if (i == 5) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a, Long.toString(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName())));
                        } else if (originalThreadInfo.k == 40) {
                            this.a.q(originalThreadInfo);
                        } else {
                            this.a.p(originalThreadInfo);
                        }
                    } else {
                        this.a.r(originalThreadInfo);
                    }
                }
                if (this.a.l != null) {
                    this.a.l.a(originalThreadInfo);
                }
            }
        }
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
        s = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        t = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
        u = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
        v = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
        w = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
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
        this.q = false;
        this.r = 3;
        m(context);
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
        this.q = false;
        this.r = 3;
        m(context);
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
        this.q = false;
        this.r = 3;
        m(context);
    }

    public final void l(PollData pollData, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{pollData, str, Long.valueOf(j)}) == null) {
            this.j.setVisibility(8);
            if (pollData != null && !ListUtils.isEmpty(pollData.getOptions())) {
                this.j.setVisibility(0);
                this.j.setIsTransmit(true);
                this.j.setData(pollData, str, j);
            }
        }
    }

    public void i(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            j(originalThreadInfo, null);
        }
    }

    public final void q(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, originalThreadInfo) != null) || originalThreadInfo == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = originalThreadInfo.f;
        arrayList.add(videoItemData);
        new VideoRecommentPlayActivityConfig(this.a, arrayList, null, this.n).start();
    }

    public void setCardFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.n = str;
        }
    }

    public void setContainerAndTextBackGroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            View view2 = this.p;
            if (view2 != null) {
                EMManager.from(view2).setBackGroundColor(i);
            }
            TextView textView = this.b;
            if (textView != null) {
                EMManager.from(textView).setBackGroundColor(i);
            }
        }
    }

    public void setReadState(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (z) {
                i = R.color.CAM_X0109;
            } else {
                i = R.color.CAM_X0107;
            }
            SkinManager.setViewTextColor(this.b, i);
        }
    }

    public void setSubClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public void setUsePlaceHolder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.o = z;
        }
    }

    public final SpannableStringBuilder n(String str, ItemStarData itemStarData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, itemStarData)) == null) {
            SpannableStringBuilder d = py5.d(itemStarData);
            d.append((CharSequence) str);
            return d;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }

    public final void g(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, itemData) == null) {
            if (itemData == null) {
                this.f.setVisibility(8);
                setPadding(0, 0, 0, 0);
                return;
            }
            this.f.setVisibility(0);
            int i = t;
            setPadding(i, i, i, u);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            if (this.c.getVisibility() == 0) {
                layoutParams.addRule(3, R.id.imageview_thread_pic);
            } else {
                layoutParams.addRule(3, R.id.textview_thread_abstract);
            }
            this.f.setLayoutParams(layoutParams);
            this.h.setStarSpacing(s);
            int i2 = w;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams2.width = i2;
            layoutParams2.height = i2;
            this.c.setLayoutParams(layoutParams2);
            this.e.setLayoutParams(layoutParams2);
            int i3 = v;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
            layoutParams3.leftMargin = (i2 - i3) / 2;
            this.d.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams4.height = i2;
            this.b.setLayoutParams(layoutParams4);
        }
    }

    public final void k(OriginalThreadInfo.ShareInfo shareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, shareInfo) == null) {
            ItemData itemData = shareInfo.itemData;
            g(itemData);
            if (itemData != null) {
                this.g.setText(itemData.mTitle);
                this.h.setStarCount(itemData.mStar);
                double d = itemData.mScore;
                if (d > 0.0d && d <= 10.0d) {
                    TextView textView = this.i;
                    textView.setText(itemData.mScore + "");
                } else {
                    this.i.setText(R.string.frs_evaluate_exception);
                }
                if (this.c.getVisibility() == 8) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
                    layoutParams.height = -2;
                    this.b.setLayoutParams(layoutParams);
                }
            }
            ItemStarData itemStarData = shareInfo.itemStarData;
            if (itemStarData != null) {
                this.b.setText(n(shareInfo.showText, itemStarData), TextView.BufferType.SPANNABLE);
            }
        }
    }

    public final void p(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, originalThreadInfo) != null) || originalThreadInfo == null) {
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

    public void h(OriginalThreadInfo.ShareInfo shareInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareInfo) != null) || shareInfo == null) {
            return;
        }
        int i = shareInfo.showType;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        this.k = 0;
                        this.c.setVisibility(8);
                    } else {
                        this.k = R.drawable.icon_share_card_live;
                        this.c.setDefaultResource(R.color.CAM_X0204);
                        this.c.setDefaultBgResource(R.color.CAM_X0209);
                        this.c.setVisibility(0);
                        this.c.startLoad(shareInfo.showPicUrl, 10, false);
                    }
                } else {
                    this.k = R.drawable.icon_share_play_n;
                    this.c.setDefaultResource(R.color.CAM_X0204);
                    this.c.setDefaultBgResource(R.color.CAM_X0209);
                    this.c.setVisibility(0);
                    this.c.startLoad(shareInfo.showPicUrl, 10, false);
                }
            } else {
                this.k = 0;
                this.c.setDefaultResource(R.drawable.icon_card_url_n);
                this.c.setDefaultBgResource(R.color.CAM_X0209);
                this.c.setVisibility(0);
                this.c.startLoad(shareInfo.showPicUrl, 10, false);
            }
        } else {
            this.k = 0;
            this.c.setDefaultResource(R.color.CAM_X0204);
            if (this.o) {
                this.c.setPlaceHolder(2);
            } else {
                this.c.setDefaultBgResource(R.color.CAM_X0209);
            }
            this.c.setVisibility(0);
            this.c.startLoad(shareInfo.showPicUrl, 10, false);
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
        k(shareInfo);
        this.j.setVisibility(8);
        setTag(shareInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(OriginalThreadInfo originalThreadInfo, String str) {
        SpannableString c;
        CharSequence charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, originalThreadInfo, str) == null) {
            if (originalThreadInfo != null) {
                this.q = false;
                int i = originalThreadInfo.a;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    this.k = 0;
                                    this.c.setVisibility(8);
                                }
                            } else {
                                this.k = R.drawable.icon_share_card_live;
                                this.c.setDefaultResource(R.color.CAM_X0204);
                                this.c.setDefaultBgResource(R.color.CAM_X0209);
                                this.c.setVisibility(0);
                                this.c.startLoad(originalThreadInfo.c, 10, false);
                            }
                        } else {
                            this.k = R.drawable.icon_share_play_n;
                            this.c.setDefaultResource(R.color.CAM_X0204);
                            this.c.setDefaultBgResource(R.color.CAM_X0209);
                            this.c.setVisibility(0);
                            this.c.startLoad(originalThreadInfo.c, 10, false);
                        }
                    } else {
                        this.k = 0;
                        this.c.setDefaultResource(R.drawable.icon_card_url_n);
                        this.c.setDefaultBgResource(R.color.CAM_X0209);
                        this.c.setVisibility(0);
                        this.c.startLoad(originalThreadInfo.c, 10, false);
                    }
                    if (this.k == 0) {
                        this.d.setVisibility(0);
                        this.e.setVisibility(8);
                        SkinManager.setImageResource(this.d, this.k);
                    } else {
                        this.d.setVisibility(8);
                        this.e.setVisibility(8);
                    }
                    c = originalThreadInfo.c();
                    if (str == null) {
                        this.b.setText(str);
                    } else {
                        TextView textView = this.b;
                        if (c != null && c.length() != 0) {
                            charSequence = c;
                        } else {
                            charSequence = originalThreadInfo.b;
                        }
                        textView.setText(charSequence);
                    }
                    if (c != null) {
                        TiePlusEventController.v(originalThreadInfo.h());
                    }
                    l(originalThreadInfo.G, originalThreadInfo.f, originalThreadInfo.e);
                    setTag(originalThreadInfo);
                    return;
                }
                this.k = 0;
                this.c.setDefaultResource(R.color.CAM_X0204);
                if (this.o) {
                    this.c.setPlaceHolder(2);
                } else {
                    this.c.setDefaultBgResource(R.color.CAM_X0209);
                }
                this.c.setVisibility(0);
                this.c.startLoad(originalThreadInfo.c, 10, false);
                if (this.k == 0) {
                }
                c = originalThreadInfo.c();
                if (str == null) {
                }
                if (c != null) {
                }
                l(originalThreadInfo.G, originalThreadInfo.f, originalThreadInfo.e);
                setTag(originalThreadInfo);
                return;
            }
            this.q = true;
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            if (str != null) {
                this.b.setText(str);
            }
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, context) != null) || context == null) {
            return;
        }
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_original_pb_layout, (ViewGroup) this, true);
        this.p = inflate;
        this.b = (TextView) inflate.findViewById(R.id.textview_thread_abstract);
        this.c = (TbImageView) this.p.findViewById(R.id.imageview_thread_pic);
        this.d = (ImageView) this.p.findViewById(R.id.icon_video_type);
        this.e = (ImageView) findViewById(R.id.thread_pic_mask);
        this.c.setLongIconSupport(false);
        this.c.setGifIconSupport(false);
        this.c.setRadius(BdUtilHelper.getDimens(context, R.dimen.tbds10));
        this.c.setConrers(15);
        this.c.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0708d3));
        this.c.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.c.setBorderSurroundContent(true);
        this.c.setDrawBorder(true);
        int equipmentWidth = (((BdUtilHelper.getEquipmentWidth(context) - (BdUtilHelper.getDimens(context, R.dimen.tbds44) * 2)) - (BdUtilHelper.getDimens(getContext(), R.dimen.tbds26) * 2)) - (BdUtilHelper.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = equipmentWidth;
        this.c.setLayoutParams(layoutParams);
        this.e.setLayoutParams(layoutParams);
        int dimens = BdUtilHelper.getDimens(context, R.dimen.tbds52);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams2.leftMargin = (equipmentWidth - dimens) / 2;
        this.d.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams3.height = equipmentWidth;
        this.b.setLayoutParams(layoutParams3);
        this.f = (LinearLayout) findViewById(R.id.add_item);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091264);
        this.g = textView;
        textView.setMaxWidth(BdUtilHelper.getScreenDimensions(context)[0] / 2);
        this.h = (RankStarView) findViewById(R.id.item_star);
        this.i = (TextView) findViewById(R.id.item_score);
        VoteView voteView = (VoteView) findViewById(R.id.vote_view);
        this.j = voteView;
        voteView.setBgColor(R.color.CAM_X0207);
        setOnClickListener(new a(this));
    }

    public final void o(OriginalThreadInfo originalThreadInfo) {
        AlaInfoData alaInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, originalThreadInfo) == null) && originalThreadInfo != null && (alaInfoData = originalThreadInfo.j) != null && alaInfoData.live_status == 1) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(originalThreadInfo.j);
            AlaUserInfoData alaUserInfoData = originalThreadInfo.j.user_info;
            if (alaUserInfoData != null) {
                alaLiveInfoCoreData.userName = alaUserInfoData.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.a, alaLiveInfoCoreData, null, "", false, "")));
        }
    }

    public final void r(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, originalThreadInfo) == null) && originalThreadInfo != null && originalThreadInfo.a == 4) {
            int i = originalThreadInfo.k;
            if (i != 49 && i != 69) {
                if (i == 60) {
                    AlaInfoData alaInfoData = originalThreadInfo.j;
                    if (alaInfoData != null) {
                        if (alaInfoData.live_status == 1) {
                            o(originalThreadInfo);
                            return;
                        }
                        AlaShareInfoData alaShareInfoData = alaInfoData.share_info;
                        if (alaShareInfoData != null && alaShareInfoData.record_tid <= 0) {
                            o(originalThreadInfo);
                            return;
                        } else {
                            p(originalThreadInfo);
                            return;
                        }
                    }
                    p(originalThreadInfo);
                    return;
                }
                p(originalThreadInfo);
                return;
            }
            o(originalThreadInfo);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            t(R.color.CAM_X0206, R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public void t(int i, int i2, int i3) {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048595, this, i, i2, i3) == null) && this.r != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            this.r = skinType;
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0107);
            int i4 = this.k;
            if (i4 != 0) {
                SkinManager.setImageResource(this.d, i4);
            }
            setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(this.a, R.dimen.tbds10), SkinManager.getColor(i)));
            this.f.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(this.a, R.dimen.tbds10), SkinManager.getColor(R.color.CAM_X0205)));
            this.j.D(skinType);
            SkinManager.setViewTextColor(this.g, i2, 1);
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.i, i3, 1);
            this.h.g();
        }
    }
}

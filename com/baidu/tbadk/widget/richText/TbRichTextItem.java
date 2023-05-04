package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.aw5;
import com.baidu.tieba.bt5;
import com.baidu.tieba.bw5;
import com.baidu.tieba.cw5;
import com.baidu.tieba.dt5;
import com.baidu.tieba.dw5;
import com.baidu.tieba.ew5;
import com.baidu.tieba.gw5;
import com.baidu.tieba.ii;
import com.baidu.tieba.jg5;
import com.baidu.tieba.uc5;
import com.baidu.tieba.un9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
/* loaded from: classes3.dex */
public class TbRichTextItem extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbRichTextCommInfo b;
    public TbRichTextImageInfo c;
    public TbRichTextVoiceInfo d;
    public TbRichTextEmotionInfo e;
    public gw5 f;
    public TbRichTextLinkButtonInfo g;
    public TbRichTextLinkImageInfo h;
    public TbRichTextMemeInfo i;
    public TbRichTextTiebaPlusInfo j;
    public dw5 k;
    public boolean l;

    /* loaded from: classes3.dex */
    public class a extends cw5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String j;
        public final /* synthetic */ TbRichTextItem k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbRichTextItem tbRichTextItem, int i, String str, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextItem, Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = tbRichTextItem;
            this.j = str2;
        }

        @Override // com.baidu.tieba.cw5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setTag(R.id.tag_subpb_ban_display_keyboard, Boolean.TRUE);
                this.k.A0(this.j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends cw5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String j;
        public final /* synthetic */ TbRichTextItem k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TbRichTextItem tbRichTextItem, int i, String str, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextItem, Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = tbRichTextItem;
            this.j = str2;
        }

        @Override // com.baidu.tieba.cw5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setTag(R.id.tag_subpb_ban_display_keyboard, Boolean.TRUE);
                this.k.A0(this.j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends cw5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String j;
        public final /* synthetic */ TbRichTextItem k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TbRichTextItem tbRichTextItem, int i, String str, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextItem, Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = tbRichTextItem;
            this.j = str2;
        }

        @Override // com.baidu.tieba.cw5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.k.b == null) {
                return;
            }
            TbRichTextItem.w0(this.k.b.W(), this.j, this.k.b.getItemForumName(), this.k.b.getLink(), this.k.b.a0());
        }
    }

    public TbRichTextItem() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a == 32 && (tbRichTextCommInfo = this.b) != null) {
                if (tbRichTextCommInfo.V() == 1) {
                    return this.b.Z();
                }
                return this.b.getText();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void A0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !TextUtils.isEmpty(str)) {
            uc5 uc5Var = new uc5();
            uc5Var.a = str;
            uc5Var.b = 0;
            uc5Var.c = "1";
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, uc5Var));
        }
    }

    public final int Y(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num)) == null) {
            return bw5.f(num);
        }
        return invokeL.intValue;
    }

    public final CharSequence Z(ArrayList<aw5> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList)) == null) {
            TbRichTextItem tbRichTextItem = new TbRichTextItem();
            tbRichTextItem.y0(4, new TbRichTextCommInfo("video_icon", " "), null, null, null, null, null);
            return tbRichTextItem.m0(arrayList, null);
        }
        return (CharSequence) invokeL.objValue;
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.a = i;
        }
    }

    public void z0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            this.l = z;
        }
    }

    public static void w0(String str, String str2, String str3, String str4, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i)}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", str2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("obj_type", str);
            statisticItem.param("obj_param1", i);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
            TiebaStatic.log(statisticItem);
            ItemClickJumpUtil.itemClickJump(str3, str, 8, 8, str4);
        }
    }

    public final SpannableString a0() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = this.a;
            if (i == 16 && (tbRichTextCommInfo = this.b) != null) {
                return o0(i, tbRichTextCommInfo.getText(), this.b.getLink(), 0, null);
            }
            return null;
        }
        return (SpannableString) invokeV.objValue;
    }

    public TbRichTextCommInfo b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = this.a;
            if (i != 8 && i != 0) {
                return this.b;
            }
            return null;
        }
        return (TbRichTextCommInfo) invokeV.objValue;
    }

    public TbRichTextEmotionInfo c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == 17) {
                return this.e;
            }
            return null;
        }
        return (TbRichTextEmotionInfo) invokeV.objValue;
    }

    public TbRichTextImageInfo e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == 8) {
                return this.c;
            }
            return null;
        }
        return (TbRichTextImageInfo) invokeV.objValue;
    }

    public dw5 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a == 37) {
                return this.k;
            }
            return null;
        }
        return (dw5) invokeV.objValue;
    }

    public TbRichTextLinkButtonInfo g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.a == 1024) {
                return this.g;
            }
            return null;
        }
        return (TbRichTextLinkButtonInfo) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public TbRichTextLinkImageInfo i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.a == 1280) {
                return this.h;
            }
            return null;
        }
        return (TbRichTextLinkImageInfo) invokeV.objValue;
    }

    public TbRichTextMemeInfo k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.a == 20) {
                return this.i;
            }
            return null;
        }
        return (TbRichTextMemeInfo) invokeV.objValue;
    }

    public TbRichTextTiebaPlusInfo q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            int i = this.a;
            if (i != 36 && i != 35) {
                return null;
            }
            return this.j;
        }
        return (TbRichTextTiebaPlusInfo) invokeV.objValue;
    }

    @Nullable
    public TiebaPlusInfo r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.j;
            if (tbRichTextTiebaPlusInfo != null) {
                return tbRichTextTiebaPlusInfo.X();
            }
            return null;
        }
        return (TiebaPlusInfo) invokeV.objValue;
    }

    public gw5 s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.a != 32) {
                return null;
            }
            return this.f;
        }
        return (gw5) invokeV.objValue;
    }

    public TbRichTextVoiceInfo v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            int i = this.a;
            if (i != 512 && i != 768) {
                return null;
            }
            return this.d;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public final SpannableString d0(ArrayList<aw5> arrayList) {
        InterceptResult invokeL;
        TbRichTextCommInfo tbRichTextCommInfo;
        String str;
        jg5.a f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, arrayList)) == null) {
            if (this.a == 4 && (tbRichTextCommInfo = this.b) != null && tbRichTextCommInfo.getText() != null && this.b.getLink() != null) {
                String text = this.b.getText();
                if (TbFaceManager.i().o(text)) {
                    String j = TbFaceManager.i().j(text);
                    if (!TextUtils.isEmpty(text) && text.startsWith("shoubai_emoji_")) {
                        str = PreferencesUtil.LEFT_MOUNT + j + PreferencesUtil.RIGHT_MOUNT;
                    } else {
                        str = SmallTailInfo.EMOTION_PREFIX + j + SmallTailInfo.EMOTION_SUFFIX;
                    }
                    SpannableString spannableString = new SpannableString(str + " ");
                    aw5 c2 = TbFaceManager.i().c(text);
                    if (arrayList != null) {
                        arrayList.add(c2);
                    }
                    if (TbFaceManager.i().f(text) != null) {
                        int a2 = (int) (f.a() * 0.5d);
                        c2.setBounds(new Rect(0, 0, a2, a2));
                    } else {
                        c2.setBounds(new Rect(0, 0, 0, 0));
                    }
                    spannableString.setSpan(new bt5(c2, 1), 0, str.length(), 33);
                    return spannableString;
                }
            }
            return null;
        }
        return (SpannableString) invokeL.objValue;
    }

    public final SpannableString h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a == 1024 && this.g != null) {
                SpannableString spannableString = new SpannableString("a");
                Drawable a2 = ew5.a(this.g.btn_type);
                a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
                dt5 dt5Var = new dt5(a2);
                dt5Var.d(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070224));
                spannableString.setSpan(dt5Var, 0, 1, 33);
                spannableString.setSpan(new cw5(1024, this.g.link), spannableString.length() - 1, 1, 33);
                return spannableString;
            }
            return null;
        }
        return (SpannableString) invokeV.objValue;
    }

    public final SpannableString j0(String str) {
        InterceptResult invokeL;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            int i = this.a;
            if ((i == 2 || i == 18 || i == 39 || i == 1282) && (tbRichTextCommInfo = this.b) != null) {
                if (tbRichTextCommInfo.V() == 1) {
                    return o0(this.a, this.b.getText(), this.b.Z(), 0, str);
                }
                return n0(this.a, this.b.getText(), this.b.getLink(), this.b.b0(), this.b.a0(), str);
            }
            return null;
        }
        return (SpannableString) invokeL.objValue;
    }

    public final CharSequence u0(ArrayList<aw5> arrayList) {
        InterceptResult invokeL;
        SpannableString o0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, arrayList)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (this.a == 32 && this.b != null) {
                spannableStringBuilder.append((CharSequence) TbadkCoreApplication.getInst().getString(R.string.video_text));
                CharSequence Z = Z(arrayList);
                if (Z != null) {
                    spannableStringBuilder.append(Z);
                }
                if (this.b.V() == 1) {
                    o0 = o0(this.a, this.b.getText(), this.b.Z(), 0, null);
                } else {
                    o0 = o0(this.a, this.b.getText(), this.b.getText(), 0, null);
                }
                if (o0 != null) {
                    spannableStringBuilder.append((CharSequence) o0);
                }
            }
            return spannableStringBuilder;
        }
        return (CharSequence) invokeL.objValue;
    }

    public final SpannableString l0() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        String text;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.a != 256 || (tbRichTextCommInfo = this.b) == null || (text = tbRichTextCommInfo.getText()) == null) {
                return null;
            }
            if (!text.endsWith(" ")) {
                text = text + " ";
            }
            SpannableString spannableString = new SpannableString(text);
            cw5 cw5Var = new cw5(this.a, text);
            cw5Var.k(this.b.getLink());
            spannableString.setSpan(cw5Var, 0, text.length() - 1, 33);
            return spannableString;
        }
        return (SpannableString) invokeV.objValue;
    }

    public final SpannableString p0() {
        InterceptResult invokeV;
        TbRichTextCommInfo tbRichTextCommInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.a == 1 && (tbRichTextCommInfo = this.b) != null) {
                if (this.l) {
                    String replaceAll = tbRichTextCommInfo.getText().replaceAll("\n", "\n\u0000");
                    SpannableString spannableString = new SpannableString(replaceAll);
                    Matcher matcher = Pattern.compile("\n\u0000").matcher(replaceAll);
                    while (matcher.find()) {
                        spannableString.setSpan(new RelativeSizeSpan(1.5f), matcher.start() + 1, matcher.end(), 33);
                    }
                    return spannableString;
                }
                return new SpannableString(this.b.getText());
            }
            return null;
        }
        return (SpannableString) invokeV.objValue;
    }

    public CharSequence m0(ArrayList<aw5> arrayList, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, arrayList, str)) == null) {
            int i = this.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 16) {
                            if (i != 32) {
                                if (i != 39) {
                                    if (i != 128) {
                                        if (i != 256) {
                                            if (i != 1024) {
                                                if (i != 1282) {
                                                    return null;
                                                }
                                                return j0(str);
                                            }
                                            return h0();
                                        }
                                        return l0();
                                    }
                                    return t0(arrayList);
                                }
                                return j0(str);
                            }
                            return u0(arrayList);
                        }
                        return a0();
                    }
                    return d0(arrayList);
                }
                return j0(str);
            }
            return p0();
        }
        return (CharSequence) invokeLL.objValue;
    }

    public final SpannableString n0(int i, String str, String str2, int i2, int i3, String str3) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        SpannableString spannableString;
        cw5 cw5Var;
        TbRichTextCommInfo tbRichTextCommInfo;
        TbRichTextCommInfo tbRichTextCommInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), Integer.valueOf(i3), str3})) == null) {
            if (str != null) {
                if (i == 2 && bw5.A(str, str2)) {
                    z = true;
                } else {
                    z = false;
                }
                if (i == 39) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!str.endsWith(" ")) {
                    str = str + " ";
                }
                if (z) {
                    spannableString = new SpannableString("m" + str);
                } else if (z2) {
                    spannableString = new SpannableString(str + "m");
                } else {
                    spannableString = new SpannableString(str);
                }
                int i4 = this.a;
                if (i4 == 18) {
                    cw5Var = new a(this, i, str2, str2);
                } else if (i4 == 1282) {
                    cw5Var = new b(this, i, str2, str2);
                } else if (i4 == 39) {
                    cw5Var = new c(this, i, str2, str3);
                } else {
                    cw5Var = new cw5(i, str2);
                }
                cw5Var.n(i2);
                cw5Var.m(i3);
                if (this.a == 2 && (tbRichTextCommInfo2 = this.b) != null && !TextUtils.isEmpty(tbRichTextCommInfo2.X())) {
                    cw5Var.l(un9.d(TbadkCoreApplication.getInst(), this.b.X()));
                } else if (i2 == 1) {
                    cw5Var.l(R.color.CAM_X0109);
                } else {
                    cw5Var.l(-1);
                }
                if (z) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(bw5.o(i3), R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    if (this.a == 2 && (tbRichTextCommInfo = this.b) != null && !TextUtils.isEmpty(tbRichTextCommInfo.Y())) {
                        eMRichTextAnyIconSpan.h(this.b.Y());
                    }
                    eMRichTextAnyIconSpan.i(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                    spannableString.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
                    spannableString.setSpan(cw5Var, 1, (str.length() + 1) - 1, 33);
                    return spannableString;
                } else if (z2) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_use_item_n, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan2.i(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                    eMRichTextAnyIconSpan2.l(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
                    spannableString.setSpan(eMRichTextAnyIconSpan2, str.length() - 1, str.length() + 1, 33);
                    spannableString.setSpan(cw5Var, 0, str.length() - 1, 33);
                    if (!TextUtils.isEmpty(str3) && !TextUtils.equals("0", str3)) {
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_EXPOSURE);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("tid", str3);
                        statisticItem.param("obj_locate", 4);
                        TbRichTextCommInfo tbRichTextCommInfo3 = this.b;
                        if (tbRichTextCommInfo3 != null) {
                            statisticItem.param("obj_param1", tbRichTextCommInfo3.a0());
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.b.W());
                        }
                        TiebaStatic.log(statisticItem);
                        return spannableString;
                    }
                    return spannableString;
                } else {
                    spannableString.setSpan(cw5Var, 0, str.length() - 1, 33);
                    return spannableString;
                }
            }
            return null;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final SpannableString o0(int i, String str, String str2, int i2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3})) == null) {
            return n0(i, str, str2, i2, 0, str3);
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public void parserJson(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, jSONObject) == null) {
            try {
                int Y = Y(Integer.valueOf(jSONObject.optInt("type", 0)));
                this.a = Y;
                if (Y == 8) {
                    this.c = new TbRichTextImageInfo(jSONObject);
                } else if (Y == 512) {
                    this.d = new TbRichTextVoiceInfo(jSONObject);
                } else if (Y == 16) {
                    this.b = new TbRichTextCommInfo(jSONObject.optString("text"), jSONObject.optString("uid"));
                } else if (Y == 17) {
                    TbRichTextEmotionInfo tbRichTextEmotionInfo = new TbRichTextEmotionInfo();
                    this.e = tbRichTextEmotionInfo;
                    tbRichTextEmotionInfo.mGifInfo.mSharpText = String.format("#(%s)", jSONObject.optString("c"));
                    this.e.mGifInfo.mDynamicUrl = jSONObject.optString("dynamic");
                    this.e.mGifInfo.mStaticUrl = jSONObject.optString("static");
                    this.e.mType = this.a;
                    this.e.mGifInfo.mGifWidth = jSONObject.optInt("width", 200);
                    this.e.mGifInfo.mGifHeight = jSONObject.optInt("height", 200);
                    this.e.mGifInfo.mPackageName = jSONObject.optString("packet_name", "");
                    this.e.mGifInfo.mIcon = jSONObject.optString("icon");
                    String[] split = this.e.mGifInfo.mDynamicUrl.split("/");
                    int i = 0;
                    for (String str2 : split) {
                        i++;
                        if (str2.equals("faceshop")) {
                            break;
                        }
                    }
                    this.e.mGifInfo.mGid = split[i].split("_")[0];
                } else {
                    if (Y != 36 && Y != 35) {
                        TbRichTextCommInfo tbRichTextCommInfo = new TbRichTextCommInfo(jSONObject);
                        this.b = tbRichTextCommInfo;
                        if (this.a == 4) {
                            String optString = jSONObject.optString("c");
                            if (!TbFaceManager.i().o(this.b.getText())) {
                                this.a = 1;
                                if (StringUtils.isNull(optString)) {
                                    str = PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getString(R.string.editor_express) + PreferencesUtil.RIGHT_MOUNT;
                                } else {
                                    str = PreferencesUtil.LEFT_MOUNT + optString + PreferencesUtil.RIGHT_MOUNT;
                                }
                                this.b.setText(str);
                            } else {
                                this.b.setLink(PreferencesUtil.LEFT_MOUNT + optString + PreferencesUtil.RIGHT_MOUNT);
                            }
                        } else if (this.a == 256) {
                            tbRichTextCommInfo.setLink(jSONObject.optString("phonetype"));
                        }
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("tiebaplus_info");
                    if (optJSONObject != null) {
                        this.j = new TbRichTextTiebaPlusInfo(this.a, optJSONObject);
                    }
                }
                if (this.a != 1 && this.b != null) {
                    this.b.c0();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void x0(PbContent pbContent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, pbContent) == null) {
            try {
                int Y = Y(pbContent.type);
                this.a = Y;
                if (Y != 8) {
                    if (Y != 20) {
                        if (Y != 512) {
                            if (Y != 1024) {
                                if (Y != 1280) {
                                    if (Y != 16) {
                                        if (Y != 17) {
                                            switch (Y) {
                                                case 35:
                                                case 36:
                                                    this.j = new TbRichTextTiebaPlusInfo(Y, pbContent.tiebaplus_info);
                                                    break;
                                                case 37:
                                                    this.k = new dw5(pbContent.item);
                                                    break;
                                                default:
                                                    if (Y == 32) {
                                                        gw5 gw5Var = new gw5();
                                                        this.f = gw5Var;
                                                        gw5Var.g(pbContent);
                                                        if (this.f.f()) {
                                                            break;
                                                        }
                                                    }
                                                    TbRichTextCommInfo tbRichTextCommInfo = new TbRichTextCommInfo(pbContent);
                                                    this.b = tbRichTextCommInfo;
                                                    if (this.a == 4) {
                                                        if (!TbFaceManager.i().o(this.b.getText())) {
                                                            this.a = 1;
                                                            if (StringUtils.isNull(pbContent.c)) {
                                                                str = PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getString(R.string.editor_express) + PreferencesUtil.RIGHT_MOUNT;
                                                            } else {
                                                                str = PreferencesUtil.LEFT_MOUNT + pbContent.c + PreferencesUtil.RIGHT_MOUNT;
                                                            }
                                                            this.b.setText(str);
                                                            break;
                                                        } else {
                                                            this.b.setLink(PreferencesUtil.LEFT_MOUNT + pbContent.c + PreferencesUtil.RIGHT_MOUNT);
                                                            break;
                                                        }
                                                    } else if (this.a == 256) {
                                                        tbRichTextCommInfo.setLink(pbContent.phonetype);
                                                        break;
                                                    }
                                                    break;
                                            }
                                        } else {
                                            TbRichTextEmotionInfo tbRichTextEmotionInfo = new TbRichTextEmotionInfo();
                                            this.e = tbRichTextEmotionInfo;
                                            tbRichTextEmotionInfo.mGifInfo.mSharpText = String.format("#(%s)", pbContent.c);
                                            this.e.mGifInfo.mDynamicUrl = pbContent.dynamic;
                                            this.e.mGifInfo.mStaticUrl = pbContent._static;
                                            this.e.mType = this.a;
                                            this.e.mGifInfo.mGifWidth = pbContent.width.intValue();
                                            this.e.mGifInfo.mGifHeight = pbContent.height.intValue();
                                            this.e.mGifInfo.mPackageName = pbContent.packet_name;
                                            this.e.mGifInfo.mIcon = pbContent._static;
                                            String[] split = this.e.mGifInfo.mDynamicUrl.split("/");
                                            int i = 0;
                                            for (String str2 : split) {
                                                i++;
                                                if (str2.equals("faceshop")) {
                                                    break;
                                                }
                                            }
                                            this.e.mGifInfo.mGid = split[i].split("_")[0];
                                        }
                                    } else {
                                        this.b = new TbRichTextCommInfo(pbContent.text, String.valueOf(pbContent.uid));
                                    }
                                } else {
                                    this.h = new TbRichTextLinkImageInfo(pbContent);
                                }
                            } else {
                                this.g = new TbRichTextLinkButtonInfo(pbContent);
                            }
                        } else {
                            this.d = new TbRichTextVoiceInfo(pbContent);
                        }
                    } else {
                        TbRichTextMemeInfo tbRichTextMemeInfo = new TbRichTextMemeInfo();
                        this.i = tbRichTextMemeInfo;
                        tbRichTextMemeInfo.memeInfo = pbContent.meme_info;
                    }
                } else {
                    this.c = new TbRichTextImageInfo(pbContent);
                }
                if (this.a != 1 && this.b != null) {
                    this.b.c0();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final CharSequence t0(ArrayList<aw5> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, arrayList)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (this.a == 128 && this.b != null) {
                CharSequence Z = Z(arrayList);
                if (Z != null) {
                    spannableStringBuilder.append(Z);
                }
                SpannableString o0 = o0(this.a, this.b.getLink(), this.b.getLink(), 0, null);
                if (o0 != null) {
                    spannableStringBuilder.append((CharSequence) o0);
                }
            }
            return spannableStringBuilder;
        }
        return (CharSequence) invokeL.objValue;
    }

    public void y0(int i, TbRichTextCommInfo tbRichTextCommInfo, TbRichTextImageInfo tbRichTextImageInfo, TbRichTextVoiceInfo tbRichTextVoiceInfo, TbRichTextEmotionInfo tbRichTextEmotionInfo, TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo, TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), tbRichTextCommInfo, tbRichTextImageInfo, tbRichTextVoiceInfo, tbRichTextEmotionInfo, tbRichTextLinkButtonInfo, tbRichTextLinkImageInfo}) == null) {
            this.a = i;
            this.b = tbRichTextCommInfo;
            this.c = tbRichTextImageInfo;
            this.d = tbRichTextVoiceInfo;
            this.e = tbRichTextEmotionInfo;
            this.g = tbRichTextLinkButtonInfo;
            this.h = tbRichTextLinkImageInfo;
        }
    }
}

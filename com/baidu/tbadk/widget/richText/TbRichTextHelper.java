package com.baidu.tbadk.widget.richText;

import android.app.Activity;
import android.graphics.Rect;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.o0.b0.a;
import c.a.o0.s.q.c2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.switchs.WorkIntroSwitch;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tbclient.HeadItem;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
/* loaded from: classes6.dex */
public class TbRichTextHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f48606a;

    /* renamed from: b  reason: collision with root package name */
    public static final i f48607b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends RichTextMaker<c.a.o0.d1.o.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RichTextMaker.IconPos iconPos, int i2, int i3, int i4) {
            super(iconPos, i2, i3, i4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iconPos, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RichTextMaker.IconPos) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextHelper.RichTextMaker
        /* renamed from: c */
        public void b(int i2, @NonNull c.a.o0.d1.o.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                aVar.n(TiePlusStat.StatType.CLICK);
                TiePlusEventController.onEvent(aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends RichTextMaker<c.a.o0.d1.o.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RichTextMaker.IconPos iconPos, int i2, int i3, int i4) {
            super(iconPos, i2, i3, i4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iconPos, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RichTextMaker.IconPos) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextHelper.RichTextMaker
        /* renamed from: c */
        public void b(int i2, @NonNull c.a.o0.d1.o.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                aVar.n(TiePlusStat.StatType.CLICK);
                TiePlusEventController.onEvent(aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends c.a.o0.d1.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i2, String str, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = str2;
        }

        @Override // c.a.o0.d1.m.e, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TbRichTextHelper.z(this.l, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends c.a.o0.d1.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c2 l;
        public final /* synthetic */ String m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i2, String str, c2 c2Var, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, c2Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = c2Var;
            this.m = str2;
        }

        @Override // c.a.o0.d1.m.e, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TbRichTextHelper.w(this.l, this.m);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends c.a.o0.d1.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;
        public final /* synthetic */ c2 m;
        public final /* synthetic */ String n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i2, String str, String str2, c2 c2Var, String str3) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, str2, c2Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = str2;
            this.m = c2Var;
            this.n = str3;
        }

        @Override // c.a.o0.d1.m.e, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TbRichTextHelper.x(this.l, this.m, this.n);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends c.a.o0.d1.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(int i2, String str, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = str2;
        }

        @Override // c.a.o0.d1.m.e, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TbRichTextHelper.y(this.l);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity instanceof TbPageContextSupport) {
                    UrlManager.getInstance().dealOneLink((TbPageContext<?>) ((TbPageContextSupport) currentActivity).getPageContext(), new String[]{TbConfig.URL_WORKS_INFO}, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f48619a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(928026644, "Lcom/baidu/tbadk/widget/richText/TbRichTextHelper$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(928026644, "Lcom/baidu/tbadk/widget/richText/TbRichTextHelper$h;");
                    return;
                }
            }
            int[] iArr = new int[RichTextMaker.IconPos.values().length];
            f48619a = iArr;
            try {
                iArr[RichTextMaker.IconPos.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48619a[RichTextMaker.IconPos.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f48619a[RichTextMaker.IconPos.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SparseArray<RichTextMaker<?>> f48620a;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48620a = new SparseArray<>();
        }

        public <T> RichTextMaker<T> a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (RichTextMaker<T>) this.f48620a.get(i2) : (RichTextMaker) invokeI.objValue;
        }

        public void b(int i2, RichTextMaker<?> richTextMaker) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, richTextMaker) == null) {
                this.f48620a.put(i2, richTextMaker);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1469423720, "Lcom/baidu/tbadk/widget/richText/TbRichTextHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1469423720, "Lcom/baidu/tbadk/widget/richText/TbRichTextHelper;");
                return;
            }
        }
        f48607b = new i();
        u();
        t();
    }

    public static SpannableStringBuilder A(c2 c2Var, List<PbContent> list, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, c2Var, list, str)) == null) ? B(c2Var, list, str, null) : (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static SpannableStringBuilder B(c2 c2Var, List<PbContent> list, String str, @Nullable List<c.a.o0.d1.o.a> list2) {
        InterceptResult invokeLLLL;
        int size;
        Pair<CharSequence, c.a.o0.d1.o.a> p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, c2Var, list, str, list2)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (ListUtils.isEmpty(list)) {
                if (str == null) {
                    str = "";
                }
                spannableStringBuilder.append((CharSequence) str);
            } else if (list != null && (size = list.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    PbContent pbContent = list.get(i2);
                    if (pbContent != null && (!TextUtils.isEmpty(pbContent.text) || !TextUtils.isEmpty(i(pbContent)))) {
                        int f2 = f(pbContent.type.intValue());
                        CharSequence charSequence = null;
                        if ((f2 == 30 || f2 == 31) && (p = p(f2, c2Var, pbContent.tiebaplus_info)) != null) {
                            charSequence = p.first;
                            Preconditions.checkNotNull(list2);
                            list2.add(p.second);
                        }
                        if (charSequence == null) {
                            charSequence = o(c2Var, pbContent);
                        }
                        if (charSequence != null) {
                            spannableStringBuilder.append(charSequence);
                        }
                    }
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLLLL.objValue;
    }

    public static SpannableStringBuilder C(List<PbContent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) ? D(list, "") : (SpannableStringBuilder) invokeL.objValue;
    }

    public static SpannableStringBuilder D(List<PbContent> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) ? A(null, list, str) : (SpannableStringBuilder) invokeLL.objValue;
    }

    public static SpannableStringBuilder E(List<PbContent> list, List<HeadItem> list2, boolean z, @Nullable c2 c2Var, @Nullable List<c.a.o0.d1.o.a> list3) {
        InterceptResult invokeCommon;
        int size;
        Pair<CharSequence, c.a.o0.d1.o.a> p;
        CharSequence charSequence;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{list, list2, Boolean.valueOf(z), c2Var, list3})) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (ListUtils.isEmpty(list)) {
                spannableStringBuilder.append((CharSequence) "");
            } else if (list != null && (size = list.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    PbContent pbContent = list.get(i2);
                    if (pbContent != null && (!TextUtils.isEmpty(pbContent.text) || !TextUtils.isEmpty(i(pbContent)))) {
                        int f2 = f(pbContent.type.intValue());
                        SpannableStringBuilder spannableStringBuilder2 = null;
                        if ((f2 == 30 || f2 == 31) && (p = p(f2, c2Var, pbContent.tiebaplus_info)) != null) {
                            charSequence = p.first;
                            Preconditions.checkNotNull(list3);
                            list3.add(p.second);
                        } else {
                            charSequence = null;
                        }
                        if (charSequence == null) {
                            charSequence = o(null, pbContent);
                        }
                        if (i2 != 0 || list2 == null) {
                            c2 = 65535;
                        } else {
                            spannableStringBuilder2 = e(list2);
                            c2 = f2 == 16 ? (char) 1 : (char) 0;
                        }
                        if (c2 == 65535) {
                            if (charSequence != null) {
                                spannableStringBuilder.append(charSequence);
                            }
                        } else if (c2 == 0) {
                            if (spannableStringBuilder2 != null) {
                                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                            }
                            if (charSequence != null) {
                                spannableStringBuilder.append(charSequence);
                            }
                        } else {
                            if (charSequence != null) {
                                spannableStringBuilder.append(charSequence);
                            }
                            if (spannableStringBuilder2 != null) {
                                if (z) {
                                    spannableStringBuilder.append((CharSequence) StringUtils.LF);
                                }
                                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                            }
                        }
                    }
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public static SpannableStringBuilder d(ItemStarData itemStarData) {
        InterceptResult invokeL;
        List<ItemStarData.SingleItemStar> list;
        int count;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, itemStarData)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (itemStarData == null || (list = itemStarData.list) == null || (count = ListUtils.getCount(list)) == 0) {
                return spannableStringBuilder;
            }
            if (count == 1) {
                try {
                    i3 = Integer.parseInt(((ItemStarData.SingleItemStar) ListUtils.getItem(itemStarData.list, 0)).content);
                } catch (NumberFormatException unused) {
                    i3 = 0;
                }
                spannableStringBuilder.append((CharSequence) q(i3, false));
            } else {
                for (ItemStarData.SingleItemStar singleItemStar : itemStarData.list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(singleItemStar.name);
                    sb.append(": ");
                    sb.append(singleItemStar.type == 1 ? singleItemStar.content : " ");
                    spannableStringBuilder.append((CharSequence) new SpannableString(sb.toString()));
                    if (singleItemStar.type == 2) {
                        try {
                            i2 = Integer.parseInt(singleItemStar.content);
                        } catch (NumberFormatException unused2) {
                            i2 = 0;
                        }
                        spannableStringBuilder.append((CharSequence) q(i2, false));
                    }
                    if (!spannableStringBuilder.toString().endsWith(StringUtils.LF)) {
                        spannableStringBuilder.append((CharSequence) StringUtils.LF);
                    }
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static SpannableStringBuilder e(List<HeadItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, list)) == null) {
            ItemStarData itemStarData = new ItemStarData();
            itemStarData.parseProto(list);
            return d(itemStarData);
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) {
            if (i2 != 13) {
                if (i2 != 14) {
                    if (i2 != 18) {
                        if (i2 != 20) {
                            if (i2 != 27) {
                                if (i2 != 32) {
                                    switch (i2) {
                                        case 0:
                                            return 1;
                                        case 1:
                                            return 2;
                                        case 2:
                                            return 4;
                                        case 3:
                                            return 8;
                                        case 4:
                                            return 16;
                                        case 5:
                                            return 32;
                                        case 6:
                                            return 64;
                                        default:
                                            switch (i2) {
                                                case 8:
                                                    return 128;
                                                case 9:
                                                    return 256;
                                                case 10:
                                                    return 512;
                                                case 11:
                                                    return 17;
                                                default:
                                                    if (c.a.o0.d1.m.h.b(i2)) {
                                                        return i2;
                                                    }
                                                    return 0;
                                            }
                                    }
                                }
                                return 50;
                            }
                            return 39;
                        }
                        return 20;
                    }
                    return 18;
                }
                return 1280;
            }
            return 1024;
        }
        return invokeI.intValue;
    }

    public static void g(StatisticItem statisticItem, c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, statisticItem, c2Var) == null) {
            if (c2Var.A2()) {
                statisticItem.param("obj_type", 2);
            } else if (c2Var.b2()) {
                statisticItem.param("obj_type", 4);
            } else if (c2Var.w1) {
                statisticItem.param("obj_type", 5);
            } else if (c2Var.J1()) {
                statisticItem.param("obj_type", 6);
            } else if (c2Var.K1()) {
                statisticItem.param("obj_type", 7);
            } else if (c2Var.M1()) {
                statisticItem.param("obj_type", 8);
            } else if (c2Var.L1()) {
                statisticItem.param("obj_type", 9);
            } else if (c2Var.getType() == c2.W2) {
                statisticItem.param("obj_type", 1);
            }
        }
    }

    public static SpannableString h(c2 c2Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, c2Var, str, str2)) == null) ? n(c2Var, 16, str, str2) : (SpannableString) invokeLLL.objValue;
    }

    @NonNull
    public static final String i(@NonNull PbContent pbContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, pbContent)) == null) {
            TiebaPlusInfo tiebaPlusInfo = pbContent.tiebaplus_info;
            return tiebaPlusInfo != null ? tiebaPlusInfo.desc : "";
        }
        return (String) invokeL.objValue;
    }

    public static SpannableString j(String str) {
        InterceptResult invokeL;
        int b2;
        String str2;
        a.C0635a c2;
        double d2;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (str == null || (b2 = TbFaceManager.e().b(str)) == 0) {
                return null;
            }
            String f2 = TbFaceManager.e().f(str);
            if (!TextUtils.isEmpty(str) && str.startsWith("shoubai_emoji_")) {
                str2 = PreferencesUtil.LEFT_MOUNT + f2 + PreferencesUtil.RIGHT_MOUNT;
                c2 = TbFaceManager.e().c("image_emoticon");
            } else {
                str2 = SmallTailInfo.EMOTION_PREFIX + f2 + SmallTailInfo.EMOTION_SUFFIX;
                c2 = TbFaceManager.e().c(str);
            }
            SpannableString spannableString = new SpannableString(str2 + " ");
            c.a.o0.d1.m.d dVar = new c.a.o0.d1.m.d(TbadkCoreApplication.getInst().getContext(), b2);
            if (c2 != null) {
                if (str != null && str.startsWith("bearchildren_")) {
                    d2 = 0.25d;
                    a2 = c2.a();
                } else {
                    d2 = 0.4d;
                    a2 = c2.a();
                }
                int i2 = (int) (a2 * d2);
                dVar.setBounds(new Rect(0, 0, i2, i2));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new c.a.o0.d1.b(dVar, 2), 0, str2.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static SpannableString k(c2 c2Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, c2Var, str, str2)) == null) {
            SpannableString n = n(c2Var, 18, str, str2);
            SpecHotTopicHelper.addSpecTopic(c2Var, n, n.toString(), 0);
            return n;
        }
        return (SpannableString) invokeLLL.objValue;
    }

    public static SpannableString l(c2 c2Var, int i2, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{c2Var, Integer.valueOf(i2), str, str2, str3})) == null) ? r(c2Var, i2, str, str2, 0, str3) : (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString m(c2 c2Var, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65554, null, c2Var, str, str2, str3)) == null) ? l(c2Var, 39, str, str2, str3) : (SpannableString) invokeLLLL.objValue;
    }

    public static SpannableString n(c2 c2Var, int i2, String str, String str2) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLILL = interceptable.invokeLILL(65555, null, c2Var, i2, str, str2)) == null) ? r(c2Var, i2, str, str2, 0, null) : (SpannableString) invokeLILL.objValue;
    }

    public static CharSequence o(c2 c2Var, PbContent pbContent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, c2Var, pbContent)) == null) {
            int f2 = f(pbContent.type.intValue());
            if (f2 != 2) {
                if (f2 != 4) {
                    if (f2 != 16) {
                        if (f2 != 18) {
                            if (f2 != 39) {
                                String str = pbContent.text;
                                return new SpannableString(str != null ? str : "");
                            }
                            String str2 = pbContent.text;
                            return m(c2Var, str2, pbContent.item_id + "", pbContent.item_forum_name);
                        }
                        return k(c2Var, pbContent.text, pbContent.link);
                    }
                    return h(c2Var, pbContent.text, String.valueOf(pbContent.uid));
                }
                return j(pbContent.text);
            }
            return n(c2Var, 2, pbContent.text, pbContent.link);
        }
        return (CharSequence) invokeLL.objValue;
    }

    @Nullable
    public static Pair<CharSequence, c.a.o0.d1.o.a> p(int i2, @Nullable c2 c2Var, @Nullable TiebaPlusInfo tiebaPlusInfo) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65557, null, i2, c2Var, tiebaPlusInfo)) == null) {
            if (c2Var == null || tiebaPlusInfo == null || TextUtils.isEmpty(tiebaPlusInfo.desc)) {
                return null;
            }
            c.a.o0.d1.o.a c2 = c.a.o0.d1.o.a.c(i2, tiebaPlusInfo, c2Var);
            return Pair.create(f48607b.a(i2).a(i2, tiebaPlusInfo.desc, c2), c2);
        }
        return (Pair) invokeILL.objValue;
    }

    public static SpannableString q(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 < 0) {
                return null;
            }
            int i3 = i2 > 5 ? 5 : i2;
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds36);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds13);
            SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.item_stars));
            spannableString.setSpan(new c.a.o0.s.f0.r.c(i3, dimenPixelSize, dimenPixelSize2, dimenPixelSize3, 0, z), 0, spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString r(c2 c2Var, int i2, String str, String str2, int i3, String str3) {
        InterceptResult invokeCommon;
        SpannableString spannableString;
        c.a.o0.d1.m.e fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{c2Var, Integer.valueOf(i2), str, str2, Integer.valueOf(i3), str3})) == null) {
            String str4 = str;
            if (str4 != null) {
                boolean z = i2 == 2 && v(str, str2);
                boolean z2 = i2 == 39;
                if (!str4.endsWith(" ")) {
                    str4 = str4 + " ";
                }
                String str5 = str4;
                if (z) {
                    spannableString = new SpannableString("m" + str5);
                } else if (z2) {
                    spannableString = new SpannableString(str5 + "m");
                } else {
                    spannableString = new SpannableString(str5);
                }
                SpannableString spannableString2 = spannableString;
                if (i2 == 18) {
                    fVar = new c(i2, str2, str2);
                } else if (i2 == 16) {
                    fVar = new d(i2, str2, c2Var, str2);
                } else if (i2 == 39) {
                    fVar = new e(i2, str2, str2, c2Var, str3);
                } else {
                    fVar = new f(i2, str2, str2);
                }
                fVar.k(i3);
                if (i3 == 1) {
                    fVar.j(R.color.CAM_X0109);
                } else {
                    fVar.j(-1);
                }
                if (z) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan.b(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                    spannableString2.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
                    spannableString2.setSpan(fVar, 1, (str5.length() + 1) - 1, 33);
                    return spannableString2;
                } else if (z2) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_use_item_n, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan2.e(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
                    spannableString2.setSpan(eMRichTextAnyIconSpan2, str5.length() - 1, str5.length() + 1, 33);
                    spannableString2.setSpan(fVar, 0, str5.length() - 1, 33);
                    if (f48606a != c2Var.q1()) {
                        f48606a = c2Var.q1();
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_EXPOSURE);
                        statisticItem.param("tid", f48606a);
                        statisticItem.param("obj_locate", c2Var.X1 ? 1 : 2);
                        TiebaStatic.log(statisticItem);
                        return spannableString2;
                    }
                    return spannableString2;
                } else {
                    spannableString2.setSpan(fVar, 0, str5.length() - 1, 33);
                    return spannableString2;
                }
            }
            return null;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.works));
            int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i2 = R.color.CAM_X0319;
            int i3 = R.color.CAM_X0101;
            int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
            int g5 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int g6 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            c.a.o0.s.f0.b bVar = new c.a.o0.s.f0.b(g2, -1, i2, g4, i3, g5, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42));
            bVar.b(g3);
            bVar.i(g6);
            bVar.f(true);
            bVar.g(true);
            bVar.d(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7));
            if (WorkIntroSwitch.isOn()) {
                spannableString.setSpan(new g(), 0, spannableString.length(), 33);
            }
            spannableString.setSpan(bVar, 0, spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeV.objValue;
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            f48607b.b(31, new a(RichTextMaker.IconPos.START, R.drawable.icon_pure_post_download16, R.color.CAM_X0304, R.dimen.M_W_X002));
        }
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, null) == null) {
            f48607b.b(30, new b(RichTextMaker.IconPos.START, R.drawable.icon_pure_post_link16, R.color.CAM_X0304, R.dimen.M_W_X002));
        }
    }

    public static boolean v(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, str, str2)) == null) {
            if (k.isEmpty(str) || k.isEmpty(str2)) {
                return false;
            }
            if (UrlManager.getInstance().isUrlValid(str2) && UrlManager.getInstance().isUrlValid(str)) {
                if (str.equals(str2)) {
                    return false;
                }
                List<String> queryParameters = Uri.parse(str2).getQueryParameters("url");
                if (ListUtils.isEmpty(queryParameters)) {
                    return true;
                }
                String str3 = queryParameters.get(0);
                if (!str.equals(str3)) {
                    if (!("http://" + str).equals(str3)) {
                        if (("https://" + str).equals(str3)) {
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void w(c2 c2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, c2Var, str) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (TextUtils.isEmpty(str) || currentActivity == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(currentActivity, str, null)));
            if (c2Var != null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_CLICK);
                if (c2Var.U1()) {
                    statisticItem = new StatisticItem(TbadkCoreStatisticKey.CONCERN_TAB_THREAD_CLICK);
                    statisticItem.param("obj_source", 1);
                    g(statisticItem, c2Var);
                } else if (c2Var.X1) {
                    statisticItem.param("obj_source", 2);
                    if (c2Var.L() != null) {
                        statisticItem.param("obj_type", c2Var.L().oriUgcType);
                    }
                } else {
                    statisticItem.param("obj_source", 3);
                    if (c2Var.L() != null) {
                        statisticItem.param("obj_type", c2Var.L().oriUgcType);
                    }
                }
                statisticItem.param("obj_locate", 5);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public static void x(String str, c2 c2Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65565, null, str, c2Var, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_CLICK);
            statisticItem.param("tid", c2Var.q1());
            statisticItem.param("obj_locate", c2Var.X1 ? 1 : 2);
            statisticItem.param("obj_type", str);
            TiebaStatic.log(statisticItem);
            ItemClickJumpUtil.itemClickJump(str2, str, 8, 8);
        }
    }

    public static void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, str) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (TextUtils.isEmpty(str) || !(currentActivity instanceof TbPageContextSupport)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
        }
    }

    public static void z(String str, c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, null, str, c2Var) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (TextUtils.isEmpty(str) || !(currentActivity instanceof TbPageContextSupport)) {
                return;
            }
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
            c.a.o0.u.l lVar = new c.a.o0.u.l();
            lVar.f14726a = str;
            if (c2Var != null) {
                lVar.f14727b = c2Var.T0();
                lVar.f14728c = c2Var.F0();
            }
            c.a.o0.r0.b.i(lVar);
            UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{lVar.f14726a, lVar.f14728c});
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class RichTextMaker<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public IconPos f48608a;

        /* renamed from: b  reason: collision with root package name */
        public int f48609b;

        /* renamed from: c  reason: collision with root package name */
        public int f48610c;

        /* renamed from: d  reason: collision with root package name */
        public int f48611d;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes6.dex */
        public static final class IconPos {
            public static final /* synthetic */ IconPos[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final IconPos END;
            public static final IconPos NONE;
            public static final IconPos START;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-807607702, "Lcom/baidu/tbadk/widget/richText/TbRichTextHelper$RichTextMaker$IconPos;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-807607702, "Lcom/baidu/tbadk/widget/richText/TbRichTextHelper$RichTextMaker$IconPos;");
                        return;
                    }
                }
                START = new IconPos("START", 0);
                END = new IconPos("END", 1);
                IconPos iconPos = new IconPos("NONE", 2);
                NONE = iconPos;
                $VALUES = new IconPos[]{START, END, iconPos};
            }

            public IconPos(String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static IconPos valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (IconPos) Enum.valueOf(IconPos.class, str) : (IconPos) invokeL.objValue;
            }

            public static IconPos[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (IconPos[]) $VALUES.clone() : (IconPos[]) invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class a extends c.a.o0.d1.m.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int l;
            public final /* synthetic */ Object m;
            public final /* synthetic */ RichTextMaker n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(RichTextMaker richTextMaker, int i2, String str, int i3, Object obj) {
                super(i2, str);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {richTextMaker, Integer.valueOf(i2), str, Integer.valueOf(i3), obj};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.n = richTextMaker;
                this.l = i3;
                this.m = obj;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: com.baidu.tbadk.widget.richText.TbRichTextHelper$RichTextMaker */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.a.o0.d1.m.e, android.text.style.ClickableSpan
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.n.b(this.l, this.m);
                }
            }
        }

        /* loaded from: classes6.dex */
        public static final class b {
            public static /* synthetic */ Interceptable $ic = null;

            /* renamed from: g  reason: collision with root package name */
            public static final int f48612g = 1;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public SpannableString f48613a;

            /* renamed from: b  reason: collision with root package name */
            public int f48614b;

            /* renamed from: c  reason: collision with root package name */
            public int f48615c;

            /* renamed from: d  reason: collision with root package name */
            public int f48616d;

            /* renamed from: e  reason: collision with root package name */
            public int f48617e;

            /* renamed from: f  reason: collision with root package name */
            public int f48618f;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1721645725, "Lcom/baidu/tbadk/widget/richText/TbRichTextHelper$RichTextMaker$b;")) == null) {
                    return;
                }
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1721645725, "Lcom/baidu/tbadk/widget/richText/TbRichTextHelper$RichTextMaker$b;");
                }
            }

            public b(@NonNull SpannableString spannableString, int i2, int i3, int i4, int i5, int i6) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {spannableString, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i7 = newInitContext.flag;
                    if ((i7 & 1) != 0) {
                        int i8 = i7 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
                this.f48613a = spannableString;
                this.f48614b = i2;
                this.f48615c = i3;
                this.f48616d = i4;
                this.f48617e = i5;
                this.f48618f = i6;
            }

            @NonNull
            public static b g(@NonNull String str, @NonNull IconPos iconPos) {
                InterceptResult invokeLL;
                int i2;
                int i3;
                SpannableString spannableString;
                int i4;
                int i5;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, iconPos)) == null) {
                    int length = str.length();
                    int i6 = h.f48619a[iconPos.ordinal()];
                    if (i6 != 1) {
                        if (i6 == 2) {
                            i5 = length - 1;
                            i4 = i5;
                            spannableString = new SpannableString(str + "m");
                            i2 = f48612g + length;
                        } else if (i6 == 3) {
                            spannableString = new SpannableString(str);
                            i4 = length - 1;
                            i5 = 0;
                            i2 = 0;
                        } else {
                            throw new IllegalArgumentException("IconPos 参数异常");
                        }
                        i3 = 0;
                    } else {
                        SpannableString spannableString2 = new SpannableString("m" + str);
                        int i7 = f48612g;
                        i2 = i7;
                        i3 = i2;
                        spannableString = spannableString2;
                        i4 = (length + i7) - 1;
                        i5 = 0;
                    }
                    return new b(spannableString, i5, i2, i3, i4, 33);
                }
                return (b) invokeLL.objValue;
            }
        }

        public RichTextMaker() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48608a = IconPos.NONE;
        }

        @NonNull
        public final SpannableString a(int i2, @NonNull String str, @NonNull T t) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, str, t)) == null) {
                if (!str.endsWith(" ")) {
                    str = str + " ";
                }
                b g2 = b.g(str, this.f48608a);
                if (this.f48608a != IconPos.NONE) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(this.f48609b, this.f48610c, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan.b(this.f48611d);
                    g2.f48613a.setSpan(eMRichTextAnyIconSpan, g2.f48614b, g2.f48615c, g2.f48618f);
                }
                g2.f48613a.setSpan(new a(this, i2, t instanceof String ? (String) t : "", i2, t), g2.f48616d, g2.f48617e, g2.f48618f);
                return g2.f48613a;
            }
            return (SpannableString) invokeILL.objValue;
        }

        public abstract void b(int i2, @NonNull T t);

        public RichTextMaker(@NonNull IconPos iconPos, @DrawableRes int i2, @ColorRes int i3, @DimenRes int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iconPos, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f48608a = iconPos;
            this.f48609b = i2;
            this.f48610c = i3;
            this.f48611d = UtilHelper.getDimenPixelSize(i4);
        }
    }
}

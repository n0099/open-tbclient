package com.baidu.tieba.im.biz.aibot.sugslice;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewSingleClickCompat;
import com.baidu.tieba.R;
import com.baidu.tieba.fia;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.impersonal.databinding.ImSugItemLayoutBinding;
import com.baidu.tieba.tf8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\f\u001a\u00020\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0014J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000bH\u0014J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0015H\u0016J\u0012\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0015H\u0016J\u0010\u0010*\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u000bH\u0014J\b\u0010+\u001a\u00020,H$J\u0018\u0010-\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/sugslice/ImSugAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/tieba/im/biz/aibot/sugslice/SugViewHolder;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "processor", "Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "(Landroid/content/Context;Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;)V", "items", "", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "bindSugData", "", "customAndHandleDefaultBgColor", "", "container", "Landroid/view/View;", "customAndHandleDefaultTextColor", "Landroid/widget/TextView;", "getItemCount", "", "handleItemBackground", "styleConf", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem$StyleConf;", "handleSugText", "iconAutoFitSkinType", "Landroid/net/Uri;", "isForcedCustomization", "isShowRedTip", "item", "loadSugIcon", "Landroid/widget/ImageView;", "onBindViewHolder", "holder", CriusAttrConstants.POSITION, "onClick", "v", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onItemClick", "sourceType", "Lcom/baidu/tieba/im/biz/aibot/sugslice/SugSourceType;", "textColorAutoFitSkinType", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class ImSugAdapter extends RecyclerView.Adapter<SugViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final tf8 b;
    public List<AbilityItem> c;

    public boolean m(View container) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, container)) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean n(TextView container) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, container)) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean s(AbilityItem item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, item)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            return false;
        }
        return invokeL.booleanValue;
    }

    public void y(AbilityItem item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
        }
    }

    public abstract SugSourceType z();

    public ImSugAdapter(Context context, tf8 processor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, processor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(processor, "processor");
        this.a = context;
        this.b = processor;
    }

    public final void t(ImageView imageView, AbilityItem.StyleConf styleConf) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, imageView, styleConf) == null) {
            Uri q = q(styleConf);
            if (q != null) {
                imageView.setVisibility(0);
                Glide.with(this.a).load(q).placeholder((int) R.drawable.pic_use_header_40_n).into(imageView);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public final void A(TextView textView, AbilityItem.StyleConf styleConf) {
        boolean z;
        String contentColor;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, textView, styleConf) == null) {
            boolean z3 = false;
            if (TbadkApplication.getInst().getSkinType() == 4) {
                if (styleConf.getDark() != null) {
                    AbilityItem.Style dark = styleConf.getDark();
                    Intrinsics.checkNotNull(dark);
                    String contentColor2 = dark.getContentColor();
                    if (contentColor2 != null && contentColor2.length() != 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        AbilityItem.Style dark2 = styleConf.getDark();
                        Intrinsics.checkNotNull(dark2);
                        contentColor = dark2.getContentColor();
                    }
                }
                contentColor = null;
            } else {
                if (styleConf.getDay() != null) {
                    AbilityItem.Style day = styleConf.getDay();
                    Intrinsics.checkNotNull(day);
                    String contentColor3 = day.getContentColor();
                    if (contentColor3 != null && contentColor3.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        AbilityItem.Style day2 = styleConf.getDay();
                        Intrinsics.checkNotNull(day2);
                        contentColor = day2.getContentColor();
                    }
                }
                contentColor = null;
            }
            if (!r()) {
                if (!((contentColor == null || contentColor.length() == 0) ? true : true)) {
                    textView.setTextColor(Color.parseColor(contentColor));
                    return;
                }
            }
            if (!n(textView)) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            }
        }
    }

    public final void o(View view2, AbilityItem.StyleConf styleConf) {
        boolean z;
        String backgroundColor;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, styleConf) == null) {
            boolean z3 = false;
            if (TbadkApplication.getInst().getSkinType() == 4) {
                if (styleConf.getDark() != null) {
                    AbilityItem.Style dark = styleConf.getDark();
                    Intrinsics.checkNotNull(dark);
                    String backgroundColor2 = dark.getBackgroundColor();
                    if (backgroundColor2 != null && backgroundColor2.length() != 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        AbilityItem.Style dark2 = styleConf.getDark();
                        Intrinsics.checkNotNull(dark2);
                        backgroundColor = dark2.getBackgroundColor();
                    }
                }
                backgroundColor = null;
            } else {
                if (styleConf.getDay() != null) {
                    AbilityItem.Style day = styleConf.getDay();
                    Intrinsics.checkNotNull(day);
                    String backgroundColor3 = day.getBackgroundColor();
                    if (backgroundColor3 != null && backgroundColor3.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        AbilityItem.Style day2 = styleConf.getDay();
                        Intrinsics.checkNotNull(day2);
                        backgroundColor = day2.getBackgroundColor();
                    }
                }
                backgroundColor = null;
            }
            EMManager corner = EMManager.from(view2).setCorner(R.string.J_X01);
            if (!r()) {
                if (!((backgroundColor == null || backgroundColor.length() == 0) ? true : true)) {
                    corner.setBackGroundColorString(backgroundColor);
                    return;
                }
            }
            if (!m(view2)) {
                corner.setBackGroundRealColor(fia.a(SkinManager.getColor(R.color.CAM_X0611), 0.5f));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<AbilityItem> list = this.c;
            if (list == null) {
                return 0;
            }
            Intrinsics.checkNotNull(list);
            return list.size();
        }
        return invokeV.intValue;
    }

    public final void l(List<AbilityItem> items) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, items) == null) {
            Intrinsics.checkNotNullParameter(items, "items");
            this.c = items;
        }
    }

    public final void p(TextView textView, AbilityItem.StyleConf styleConf) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, textView, styleConf) == null) {
            if (!TextUtils.isEmpty(styleConf.getContent())) {
                textView.setVisibility(0);
                textView.setText(styleConf.getContent());
            } else {
                textView.setVisibility(8);
            }
            A(textView, styleConf);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: x */
    public SugViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, parent, i)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ImSugItemLayoutBinding c = ImSugItemLayoutBinding.c(LayoutInflater.from(this.a), parent, false);
            Intrinsics.checkNotNullExpressionValue(c, "inflate(LayoutInflater.f…(context), parent, false)");
            return new SugViewHolder(c);
        }
        return (SugViewHolder) invokeLI.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, view2) != null) || view2 == null) {
            return;
        }
        Object tag = view2.getTag(R.id.obfuscated_res_0x7f09231d);
        if (tag != null) {
            AbilityItem abilityItem = (AbilityItem) tag;
            Object tag2 = view2.getTag(R.id.obfuscated_res_0x7f09231f);
            if (tag2 != null) {
                int intValue = ((Integer) tag2).intValue();
                y(abilityItem);
                this.b.d(abilityItem, null, z());
                notifyItemChanged(intValue);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.im.lib.socket.msg.data.AbilityItem");
    }

    public final Uri q(AbilityItem.StyleConf styleConf) {
        InterceptResult invokeL;
        boolean z;
        String icon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, styleConf)) == null) {
            boolean z3 = false;
            if (TbadkApplication.getInst().getSkinType() == 4) {
                if (styleConf.getDark() != null) {
                    AbilityItem.Style dark = styleConf.getDark();
                    Intrinsics.checkNotNull(dark);
                    String icon2 = dark.getIcon();
                    if (icon2 != null && icon2.length() != 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        AbilityItem.Style dark2 = styleConf.getDark();
                        Intrinsics.checkNotNull(dark2);
                        icon = dark2.getIcon();
                    }
                }
                icon = null;
            } else {
                if (styleConf.getDay() != null) {
                    AbilityItem.Style day = styleConf.getDay();
                    Intrinsics.checkNotNull(day);
                    String icon3 = day.getIcon();
                    if (icon3 != null && icon3.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        AbilityItem.Style day2 = styleConf.getDay();
                        Intrinsics.checkNotNull(day2);
                        icon = day2.getIcon();
                    }
                }
                icon = null;
            }
            if ((icon == null || icon.length() == 0) ? true : true) {
                return null;
            }
            return Uri.parse(icon);
        }
        return (Uri) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u */
    public void onBindViewHolder(SugViewHolder holder, int i) {
        boolean z;
        AbilityItem.StyleConf styleConf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, holder, i) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            List<AbilityItem> list = this.c;
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            AbilityItem item = (AbilityItem) ListUtils.getItem(this.c, i);
            if (item != null) {
                styleConf = item.getStyleConf();
            } else {
                styleConf = null;
            }
            if (styleConf == null) {
                return;
            }
            ViewSingleClickCompat.setOnClickListener(holder.itemView, this);
            holder.itemView.setTag(R.id.obfuscated_res_0x7f09231f, Integer.valueOf(i));
            holder.itemView.setTag(R.id.obfuscated_res_0x7f09231d, item);
            AbilityItem.StyleConf styleConf2 = item.getStyleConf();
            ImageView a = holder.a();
            Intrinsics.checkNotNull(styleConf2);
            t(a, styleConf2);
            p(holder.b(), styleConf2);
            View view2 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
            o(view2, styleConf2);
            Intrinsics.checkNotNullExpressionValue(item, "item");
            if (s(item)) {
                holder.c().setVisibility(0);
            } else {
                holder.c().setVisibility(8);
            }
        }
    }
}

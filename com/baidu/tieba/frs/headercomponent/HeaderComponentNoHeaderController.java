package com.baidu.tieba.frs.headercomponent;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.core.widget.recommendcard.RecommendCardView;
import com.baidu.tieba.frs.headercomponent.HeaderComponentNoHeaderController;
import com.baidu.tieba.ii;
import com.baidu.tieba.oc7;
import com.baidu.tieba.wk6;
import com.baidu.tieba.xk6;
import com.baidu.tieba.yk6;
import com.baidu.tieba.zt9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FrsPage.LiveFuseForumData;
import tbclient.ThemeColorInfo;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u001a\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016J\u0006\u0010\u0017\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/baidu/tieba/frs/headercomponent/HeaderComponentNoHeaderController;", "Lcom/baidu/tieba/frs/headercomponent/IHeaderCompListener;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "data", "Ltbclient/FrsPage/LiveFuseForumData;", "(Lcom/baidu/tbadk/TbPageContext;Ltbclient/FrsPage/LiveFuseForumData;)V", "recommendCardView", "Lcom/baidu/tieba/core/widget/recommendcard/RecommendCardView;", "getRecommendCardView", "()Lcom/baidu/tieba/core/widget/recommendcard/RecommendCardView;", "recommendCardView$delegate", "Lkotlin/Lazy;", "Landroid/view/View;", "onChangeSkin", "", "onHeaderClicked", "compType", "", "itemData", "headPos", "onItemClicked", "onItemShow", "parseDataAndBind", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HeaderComponentNoHeaderController implements oc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final LiveFuseForumData b;
    public final Lazy c;

    @Override // com.baidu.tieba.oc7
    public void a(int i, LiveFuseForumData liveFuseForumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, liveFuseForumData) == null) {
        }
    }

    @Override // com.baidu.tieba.oc7
    public void b(int i, LiveFuseForumData liveFuseForumData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), liveFuseForumData, Integer.valueOf(i2)}) == null) {
        }
    }

    public HeaderComponentNoHeaderController(TbPageContext<?> pageContext, LiveFuseForumData data) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, data};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = pageContext;
        this.b = data;
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<RecommendCardView>(this) { // from class: com.baidu.tieba.frs.headercomponent.HeaderComponentNoHeaderController$recommendCardView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HeaderComponentNoHeaderController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecommendCardView invoke() {
                InterceptResult invokeV;
                TbPageContext tbPageContext;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (RecommendCardView) invokeV.objValue;
                }
                tbPageContext = this.this$0.a;
                Activity pageActivity = tbPageContext.getPageActivity();
                Intrinsics.checkNotNullExpressionValue(pageActivity, "pageContext.pageActivity");
                return new RecommendCardView(pageActivity, null, 0, 6, null);
            }
        });
    }

    public static final void i(HeaderComponentNoHeaderController this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c(1, this$0.b);
        }
    }

    @Override // com.baidu.tieba.oc7
    public void c(int i, LiveFuseForumData liveFuseForumData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, liveFuseForumData) == null) && liveFuseForumData != null && !TextUtils.isEmpty(liveFuseForumData.schema)) {
            UrlManager.getInstance().dealOneLink(liveFuseForumData.schema);
        }
    }

    public final View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return f();
        }
        return (View) invokeV.objValue;
    }

    public final RecommendCardView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (RecommendCardView) this.c.getValue();
        }
        return (RecommendCardView) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int g = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds146);
            int g2 = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds195);
            String str = this.b.icon_url;
            Intrinsics.checkNotNullExpressionValue(str, "data.icon_url");
            xk6 xk6Var = new xk6(g, g2, str);
            String str2 = this.b.title.get(0);
            Intrinsics.checkNotNullExpressionValue(str2, "data.title[0]");
            List<ThemeColorInfo> list = this.b.label_infos.get(0).labels;
            Intrinsics.checkNotNullExpressionValue(list, "data.label_infos[0].labels");
            yk6 yk6Var = new yk6(str2, list, false, 4, null);
            ThemeColorInfo themeColorInfo = this.b.novel.chapter_bg_color;
            Intrinsics.checkNotNullExpressionValue(themeColorInfo, "data.novel.chapter_bg_color");
            String c = zt9.c(themeColorInfo);
            int g3 = ii.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
            ThemeColorInfo themeColorInfo2 = this.b.novel.new_labels;
            Intrinsics.checkNotNullExpressionValue(themeColorInfo2, "data.novel.new_labels");
            xk6 a = zt9.a(themeColorInfo2);
            ThemeColorInfo themeColorInfo3 = this.b.novel.chapter_name_color;
            Intrinsics.checkNotNullExpressionValue(themeColorInfo3, "data.novel.chapter_name_color");
            String c2 = zt9.c(themeColorInfo3);
            String str3 = this.b.online_users;
            Intrinsics.checkNotNullExpressionValue(str3, "data.online_users");
            wk6 wk6Var = new wk6(R.color.CAM_X0201, xk6Var, yk6Var, c, g3, a, c2, str3);
            String formatTimeForJustNowAndDate = StringHelper.getFormatTimeForJustNowAndDate(this.b.novel.chapter_time.longValue() * 1000);
            String str4 = this.b.novel._abstract;
            Intrinsics.checkNotNullExpressionValue(str4, "data.novel._abstract");
            wk6Var.f(str4);
            ThemeColorInfo themeColorInfo4 = this.b.novel.chapter_time_color;
            Intrinsics.checkNotNullExpressionValue(themeColorInfo4, "data.novel.chapter_time_color");
            wk6Var.C(zt9.c(themeColorInfo4));
            String string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f07a9, new Object[]{formatTimeForJustNowAndDate});
            Intrinsics.checkNotNullExpressionValue(string, "pageContext.pageActivity…le_view_time_update, day)");
            wk6Var.B(string);
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                String str5 = this.b.bjimg_light_big;
                Intrinsics.checkNotNullExpressionValue(str5, "data.bjimg_light_big");
                wk6Var.E(str5);
            } else {
                String str6 = this.b.bjimg_dark_big;
                Intrinsics.checkNotNullExpressionValue(str6, "data.bjimg_dark_big");
                wk6Var.E(str6);
            }
            String str7 = this.b.bjimg_light_big;
            Intrinsics.checkNotNullExpressionValue(str7, "data.bjimg_light_big");
            wk6Var.E(str7);
            f().a(wk6Var);
            f().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lc7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        HeaderComponentNoHeaderController.i(HeaderComponentNoHeaderController.this, view2);
                    }
                }
            });
        }
    }
}

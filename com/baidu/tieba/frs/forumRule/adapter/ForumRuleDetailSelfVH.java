package com.baidu.tieba.frs.forumRule.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.s.u.c;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class ForumRuleDetailSelfVH extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f15684a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f15685b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15686c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15687d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15688e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15689f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15690g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f15691h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f15692i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public final int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRuleDetailSelfVH(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
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
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.f15684a = view;
        b(view);
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.forum_rules_head_view_info_item);
            this.f15685b = headImageView;
            headImageView.setRadius(R.dimen.tbds47);
            this.f15685b.setConrers(15);
            this.f15686c = (TextView) view.findViewById(R.id.forum_rules_user_name_info_item);
            this.f15687d = (TextView) view.findViewById(R.id.forum_rules_user_identity_info_item);
            this.f15688e = (ImageView) view.findViewById(R.id.forum_rules_user_forum_level_info_item);
            this.f15689f = (TextView) view.findViewById(R.id.forum_rules_bjh_author_auth_info_item);
            this.f15690g = (TextView) view.findViewById(R.id.forum_rules_revise);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) view.findViewById(R.id.forum_rules_edit_status);
            this.f15691h = tBSpecificationBtn;
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_compile));
            EMTextView eMTextView = (EMTextView) view.findViewById(R.id.forum_rules_check_status);
            this.l = eMTextView;
            eMTextView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.forum_rules_review));
            this.f15692i = (LinearLayout) view.findViewById(R.id.forum_rules_preface_layout);
            this.j = (EMTextView) view.findViewById(R.id.forum_rules_preface_title);
            this.k = (EMTextView) view.findViewById(R.id.forum_rules_preface);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 <= 0) {
            return;
        }
        SkinManager.setImageResource(this.f15688e, BitmapHelper.getGradeResourceIdInEnterForum(i2));
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.k == null || this.f15692i == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            this.f15692i.setVisibility(8);
            return;
        }
        this.k.setText(str);
        this.f15692i.setVisibility(0);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            c d2 = c.d(this.f15686c);
            d2.y(R.string.F_X01);
            d2.t(R.color.CAM_X0105);
            c d3 = c.d(this.f15690g);
            d3.y(R.string.F_X01);
            d3.t(R.color.CAM_X0109);
            c d4 = c.d(this.l);
            d4.y(R.string.F_X01);
            d4.t(R.color.CAM_X0107);
            c.d(this.k).t(R.color.CAM_X0105);
            c d5 = c.d(this.j);
            d5.y(R.string.F_X02);
            d5.t(R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f15689f, R.color.CAM_X0109);
            if (i2 != 1 && i2 != 4) {
                this.f15685b.setIsNight(false);
            } else {
                this.f15685b.setIsNight(true);
            }
            this.f15691h.setTextSize(R.dimen.T_X08);
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 == 1) {
                this.f15691h.setVisibility(8);
                this.l.setVisibility(0);
                return;
            }
            this.l.setVisibility(8);
            this.f15691h.setVisibility(0);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
                this.f15690g.setText(i(str));
            } else {
                this.f15690g.setVisibility(8);
            }
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if ("manager".equals(str) || PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(str)) {
                DrawableSelector radius = DrawableSelector.make().setShape(0).radius(this.m);
                int i2 = R.color.CAM_X0303;
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{radius.gradientLinear(DrawableSelector.TL_BR, i2, i2).build(), DrawableSelector.make().setShape(0).radius(this.m).defaultColor("#4D000000").build()});
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    if (layerDrawable.getDrawable(1) != null) {
                        layerDrawable.getDrawable(1).setAlpha(255);
                    }
                } else if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(0);
                }
                this.f15687d.setBackgroundDrawable(layerDrawable);
                SkinManager.setViewTextColor(this.f15687d, R.color.CAM_X0101);
            }
        }
    }

    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
        }
        return (String) invokeL.objValue;
    }
}

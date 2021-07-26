package com.baidu.tieba.frs.forumRule.adapter;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
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
public class ForumRuleDetailBottomVH extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f15670a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f15671b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f15672c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f15673d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f15674e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f15675f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f15676g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f15677h;

    /* renamed from: i  reason: collision with root package name */
    public View f15678i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRuleDetailBottomVH(View view) {
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
        this.f15670a = view;
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_rules_bar_management_head_view);
        this.f15671b = barImageView;
        barImageView.setShowOval(true);
        this.f15671b.setShowOuterBorder(false);
        this.f15671b.setShowInnerBorder(true);
        this.f15671b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f15671b.setStrokeColorResId(R.color.CAM_X0401);
        this.f15672c = (ImageView) view.findViewById(R.id.forum_rules_bar_management_index);
        this.f15673d = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_title);
        this.f15674e = (EMTextView) view.findViewById(R.id.forum_rules_bar_management_time_revise);
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.forum_rules_charger_of_bar_head_view);
        this.f15675f = headImageView;
        headImageView.setBorderWidth(R.dimen.L_X01);
        this.f15675f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f15675f.setRadius(R.dimen.tbds42);
        this.f15675f.setConrers(15);
        this.f15676g = (EMTextView) view.findViewById(R.id.forum_rules_charger_of_bar_title);
        this.f15677h = (EMTextView) view.findViewById(R.id.forum_rules_time_revise);
        this.f15678i = view.findViewById(R.id.cross_line);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
                this.f15677h.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), d(str)));
                this.f15674e.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), d(str)));
                return;
            }
            this.f15677h.setVisibility(8);
            this.f15674e.setVisibility(8);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f15670a, R.color.CAM_X0205);
            c d2 = c.d(this.f15673d);
            d2.y(R.string.F_X01);
            d2.t(R.color.CAM_X0105);
            c d3 = c.d(this.f15674e);
            d3.y(R.string.F_X01);
            d3.t(R.color.CAM_X0109);
            c d4 = c.d(this.f15676g);
            d4.y(R.string.F_X01);
            d4.t(R.color.CAM_X0105);
            c d5 = c.d(this.f15677h);
            d5.y(R.string.F_X01);
            d5.t(R.color.CAM_X0109);
            this.f15672c.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_pb_barservice14, WebPManager.ResourceStateType.NORMAL));
            if (i2 != 4 && i2 != 1) {
                this.f15675f.setIsNight(false);
            } else {
                this.f15675f.setIsNight(true);
            }
            SkinManager.setBackgroundColor(this.f15678i, R.color.CAM_X0111);
        }
    }

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
        }
        return (String) invokeL.objValue;
    }
}

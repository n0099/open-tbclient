package com.baidu.tieba.frs.forumRule.adapter;

import android.view.View;
import android.widget.ImageView;
import c.a.d.f.p.n;
import c.a.s0.s.u.c;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.i1;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes12.dex */
public class ForumRuleDetailBottomVH extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public BarImageView mBarManagementHeadView;
    public EMTextView mBarManagementRevise;
    public EMTextView mBarManagementTitle;
    public HeadImageView mChargerOfBarHeadView;
    public EMTextView mChargerOfBarTitle;
    public View mCrossLine;
    public ImageView mHeadViewIndex;
    public EMTextView mTimeRevise;

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
        this.a = view;
        BarImageView barImageView = (BarImageView) view.findViewById(f1.forum_rules_bar_management_head_view);
        this.mBarManagementHeadView = barImageView;
        barImageView.setShowOval(true);
        this.mBarManagementHeadView.setShowOuterBorder(false);
        this.mBarManagementHeadView.setShowInnerBorder(true);
        this.mBarManagementHeadView.setStrokeWith(n.f(TbadkCoreApplication.getInst(), d1.tbds1));
        this.mBarManagementHeadView.setStrokeColorResId(c1.CAM_X0401);
        this.mHeadViewIndex = (ImageView) view.findViewById(f1.forum_rules_bar_management_index);
        this.mBarManagementTitle = (EMTextView) view.findViewById(f1.forum_rules_bar_management_title);
        this.mBarManagementRevise = (EMTextView) view.findViewById(f1.forum_rules_bar_management_time_revise);
        HeadImageView headImageView = (HeadImageView) view.findViewById(f1.forum_rules_charger_of_bar_head_view);
        this.mChargerOfBarHeadView = headImageView;
        headImageView.setBorderWidth(d1.L_X01);
        this.mChargerOfBarHeadView.setBorderColor(SkinManager.getColor(c1.CAM_X0401));
        this.mChargerOfBarHeadView.setRadius(d1.tbds42);
        this.mChargerOfBarHeadView.setConrers(15);
        this.mChargerOfBarTitle = (EMTextView) view.findViewById(f1.forum_rules_charger_of_bar_title);
        this.mTimeRevise = (EMTextView) view.findViewById(f1.forum_rules_time_revise);
        this.mCrossLine = view.findViewById(f1.cross_line);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeReviseTimeSkinType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
                this.mTimeRevise.setText(String.format(TbadkApplication.getInst().getString(i1.forum_rules_revise_time), timeStamp2Date(str)));
                this.mBarManagementRevise.setText(String.format(TbadkApplication.getInst().getString(i1.forum_rules_revise_time), timeStamp2Date(str)));
                return;
            }
            this.mTimeRevise.setVisibility(8);
            this.mBarManagementRevise.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setBackgroundColor(this.a, c1.CAM_X0205);
            c d2 = c.d(this.mBarManagementTitle);
            d2.A(i1.F_X01);
            d2.v(c1.CAM_X0105);
            c d3 = c.d(this.mBarManagementRevise);
            d3.A(i1.F_X01);
            d3.v(c1.CAM_X0109);
            c d4 = c.d(this.mChargerOfBarTitle);
            d4.A(i1.F_X01);
            d4.v(c1.CAM_X0105);
            c d5 = c.d(this.mTimeRevise);
            d5.A(i1.F_X01);
            d5.v(c1.CAM_X0109);
            this.mHeadViewIndex.setImageDrawable(WebPManager.getMaskDrawable(e1.icon_mask_pb_barservice14, WebPManager.ResourceStateType.NORMAL));
            this.mChargerOfBarHeadView.setSkinType(i2);
            SkinManager.setBackgroundColor(this.mCrossLine, c1.CAM_X0111);
        }
    }

    public String timeStamp2Date(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
        }
        return (String) invokeL.objValue;
    }
}

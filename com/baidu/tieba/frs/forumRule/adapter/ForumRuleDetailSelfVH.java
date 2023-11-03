package com.baidu.tieba.frs.forumRule.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.level.TbLevelView;
import com.baidu.tieba.R;
import com.baidu.tieba.mu5;
import com.baidu.tieba.ou5;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes6.dex */
public class ForumRuleDetailSelfVH extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public HeadImageView b;
    public TextView c;
    public TextView d;
    public TbLevelView e;
    public TextView f;
    public TextView g;
    public TBSpecificationBtn h;
    public LinearLayout i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ BawuRoleInfoPub b;
        public final /* synthetic */ List c;
        public final /* synthetic */ ForumRuleDetailSelfVH d;

        public a(ForumRuleDetailSelfVH forumRuleDetailSelfVH, int i, BawuRoleInfoPub bawuRoleInfoPub, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRuleDetailSelfVH, Integer.valueOf(i), bawuRoleInfoPub, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = forumRuleDetailSelfVH;
            this.a = i;
            this.b = bawuRoleInfoPub;
            this.c = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mu5 mu5Var = mu5.a;
                int i = this.a;
                String str = this.b.name_show;
                ForumRuleDetailSelfVH forumRuleDetailSelfVH = this.d;
                mu5.c(i, str, forumRuleDetailSelfVH.c, forumRuleDetailSelfVH.e, this.c, null);
                ForumRuleDetailSelfVH forumRuleDetailSelfVH2 = this.d;
                ou5.a(forumRuleDetailSelfVH2.c, null, null, forumRuleDetailSelfVH2.e, null, 4);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRuleDetailSelfVH(View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.n = UtilHelper.getDimenPixelSize(R.dimen.tbds217);
        this.o = UtilHelper.getDimenPixelSize(R.dimen.tbds177);
        this.p = UtilHelper.getDimenPixelSize(R.dimen.tbds102);
        this.a = view2;
        a(view2);
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(BawuRoleInfoPub bawuRoleInfoPub) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bawuRoleInfoPub) == null) && this.a != null && bawuRoleInfoPub != null) {
            this.e.setLevel(bawuRoleInfoPub.user_level.intValue(), bawuRoleInfoPub.level_name);
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.a.getContext()) - this.n;
            if (this.h.getVisibility() == 0) {
                i = this.o;
            } else {
                if (this.l.getVisibility() == 0) {
                    i = this.p;
                }
                if (equipmentWidth > 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.d);
                arrayList.add(this.e);
                arrayList.add(this.f);
                this.a.post(new a(this, equipmentWidth, bawuRoleInfoPub, arrayList));
                return;
            }
            equipmentWidth -= i;
            if (equipmentWidth > 0) {
            }
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            EMManager.from(this.c).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.g).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.l).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0107);
            EMManager.from(this.k).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.j).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
            this.b.setSkinType(i);
            this.h.setTextSize(R.dimen.T_X08);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (!"manager".equals(str) && !PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(str)) {
                return;
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{DrawableSelector.make().setShape(0).radius(this.m).gradientLinear(DrawableSelector.TL_BR, R.color.CAM_X0303, R.color.CAM_X0303).build(), DrawableSelector.make().setShape(0).radius(this.m).defaultColor("#4D000000").build()});
            if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(0);
            }
            this.d.setBackgroundDrawable(layerDrawable);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0101);
        }
    }

    public final void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090c54);
            this.b = headImageView;
            headImageView.setRadius(R.dimen.tbds47);
            this.b.setConrers(15);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c61);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c5f);
            this.e = (TbLevelView) view2.findViewById(R.id.obfuscated_res_0x7f090c5e);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c4f);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c5b);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090c53);
            this.h = tBSpecificationBtn;
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f07df));
            EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090c52);
            this.l = eMTextView;
            eMTextView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f07e4));
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c59);
            this.j = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090c5a);
            this.k = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090c58);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.k != null && this.i != null) {
            if (StringUtils.isNull(str)) {
                this.i.setVisibility(8);
                return;
            }
            this.k.setText(str);
            this.i.setVisibility(0);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i == 1) {
                this.h.setVisibility(8);
                this.l.setVisibility(0);
                return;
            }
            this.l.setVisibility(8);
            this.h.setVisibility(0);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
                this.g.setText(h(str));
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
        }
        return (String) invokeL.objValue;
    }
}

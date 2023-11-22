package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.toolbar.CommonToolbarStatisticConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cl6 extends zk6<au6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public RelativeLayout j;
    public TbImageView k;
    public ImageView l;
    public TextView m;
    public TextView n;
    public ClickableHeaderImageView o;
    public TextView p;
    public TextView q;
    public View r;
    public au6 s;

    @Override // com.baidu.tieba.zk6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b6 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cl6(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p(i());
    }

    public final void B(ThreadData threadData) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && (textView = this.p) != null && threadData != null) {
            textView.setVisibility(0);
            if (!StringUtils.isNull(threadData.getAuthor().getName_show())) {
                this.p.setText(x(threadData.getAuthor().getName_show()));
            }
        }
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.o.setVisibility(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && f() != null) {
            f().a(i(), this.s);
        }
    }

    public String x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            return StringHelper.cutChineseAndEnglishWithSuffix(str, 14, "...");
        }
        return (String) invokeL.objValue;
    }

    public void y(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (view2 = this.r) != null) {
            view2.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.zk6
    public void l(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(i(), R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.r, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0101, 1);
                zsa readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                if (readThreadHistory != null && readThreadHistory.d(this.s.getThreadData().getId())) {
                    SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0108);
                } else {
                    SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
                }
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0109, 1);
            }
            this.a = i;
        }
    }

    public final void p(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090600);
            this.j = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0905ff);
            this.k = (TbImageView) view2.findViewById(R.id.img_thumbnail);
            this.l = (ImageView) view2.findViewById(R.id.img_play);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090608);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090609);
            this.o = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f090606);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905e8);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905e7);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f0905e0);
            this.k.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080a89);
            int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.tbds326);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = (dimensionPixelSize * 9) / 16;
            this.j.setLayoutParams(layoutParams);
            this.o.setDefaultResource(17170445);
            this.o.setDefaultBgResource(R.color.CAM_X0205);
            this.o.setIsRound(true);
            this.o.setDrawBorder(true);
            this.o.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.o.setBorderWidth(this.c.getResources().getDimensionPixelSize(R.dimen.tbds1));
            i().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zk6
    /* renamed from: r */
    public void k(au6 au6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, au6Var) == null) && au6Var != null && au6Var.getThreadData() != null) {
            this.s = au6Var;
            String str = null;
            if (au6Var.getThreadData().isVideoThreadType()) {
                this.l.setVisibility(0);
                this.m.setVisibility(0);
                if (au6Var.getThreadData().getThreadVideoInfo() != null) {
                    this.m.setText(StringHelper.stringForVideoTime(au6Var.getThreadData().getThreadVideoInfo().video_duration.intValue() * 1000));
                    str = au6Var.getThreadData().getThreadVideoInfo().thumbnail_url;
                }
            } else {
                this.l.setVisibility(8);
                this.m.setVisibility(8);
                if (au6Var.getThreadData().getMedias() != null && au6Var.getThreadData().getMedias().size() >= 1) {
                    str = au6Var.getThreadData().getMedias().get(0).origin_pic;
                }
            }
            this.k.startLoad(str, 10, false);
            this.n.setText(au6Var.getThreadData().getTitle());
            zsa readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.d(au6Var.getThreadData().getId())) {
                SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0108);
            } else {
                SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
            }
            this.o.setData(au6Var.getThreadData(), false);
            this.q.setText(StringHelper.getFormatTimeShort(au6Var.getThreadData().getAuditTime()));
            if (CommonToolbarStatisticConstants.TOOLBAR_MENU_NEW_DETAIL_BROWSER.equals(au6Var.getThreadData().getGameInformationSource())) {
                this.o.setVisibility(8);
                this.p.setText(this.b.getPageActivity().getResources().getString(R.string.person_view_num, StringHelper.numberUniformFormat(au6Var.getThreadData().getView_num())));
                return;
            }
            this.o.setVisibility(0);
            B(au6Var.getThreadData());
        }
    }

    public void z(int i, int i2, int i3, int i4) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048586, this, i, i2, i3, i4) == null) && (linearLayout = this.i) != null) {
            linearLayout.setPadding(i, i2, i3, i4);
        }
    }
}

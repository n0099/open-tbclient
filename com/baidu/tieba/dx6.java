package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes4.dex */
public class dx6 extends ea5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TextView b;
    public BdListView c;
    public a d;
    public r9 e;
    public View f;
    public TextView g;
    public TextView h;

    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<RecmForumInfo> a;
        public final /* synthetic */ dx6 b;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        /* renamed from: com.baidu.tieba.dx6$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0258a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ a b;

            public View$OnClickListenerC0258a(a aVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !StringUtils.isNull(this.b.getItem(this.a).forum_name)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.b.b.e.getContext()).createNormalCfg(this.b.getItem(this.a).forum_name, null)));
                }
            }
        }

        public a(dx6 dx6Var, List<RecmForumInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dx6Var;
            this.a = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return this.a.get(i);
            }
            return (RecmForumInfo) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    view2 = LayoutInflater.from(this.b.e.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07a7, (ViewGroup) null);
                    bVar = new b();
                    bVar.f = view2.findViewById(R.id.obfuscated_res_0x7f091d41);
                    bVar.a = (TextView) view2.findViewById(R.id.forum_name);
                    bVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a6e);
                    bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09227d);
                    bVar.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902cf);
                    bVar.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090deb);
                    bVar.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a6d);
                    bVar.h = (TextView) view2.findViewById(R.id.thread_title);
                    bVar.i = view2.findViewById(R.id.obfuscated_res_0x7f090840);
                    bVar.j = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09071a);
                    view2.setTag(bVar);
                } else {
                    bVar = (b) view2.getTag();
                }
                if (getItem(i) != null) {
                    bVar.a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                    bVar.e.K(getItem(i).avatar, 10, false);
                    bVar.c.setText(StringHelper.numberUniformFormat(getItem(i).member_count.intValue()));
                    bVar.b.setText(StringHelper.numberUniformFormat(getItem(i).post_num.intValue()));
                    bVar.f.setOnClickListener(new View$OnClickListenerC0258a(this, i));
                    SkinManager.setViewTextColor(bVar.a, (int) R.color.CAM_X0105);
                    SkinManager.setViewTextColor(bVar.c, (int) R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.b, (int) R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.h, (int) R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.g, (int) R.color.CAM_X0109);
                    SkinManager.setBackgroundResource(bVar.i, R.color.CAM_X0204);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                    SkinManager.setBackgroundResource(view2, R.drawable.addresslist_item_bg);
                    SkinManager.setBackgroundResource(bVar.j, R.drawable.picture_content_frame);
                }
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public TextView c;
        public ImageView d;
        public TbImageView e;
        public View f;
        public TextView g;
        public TextView h;
        public View i;
        public ImageView j;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dx6(r9 r9Var, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(r9Var.getContext()).inflate(R.layout.obfuscated_res_0x7f0d02a3, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r9Var, onClickListener};
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
        this.e = r9Var;
        this.a = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f = this.attachedView.findViewById(R.id.obfuscated_res_0x7f09082d);
        this.c = (BdListView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f091c44);
        this.attachedView.setOnClickListener(null);
        this.g = (TextView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f090723);
        this.h = (TextView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f0914c8);
    }

    public void b(List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || list == null) {
            return;
        }
        a aVar = new a(this, list);
        this.d = aVar;
        this.c.setAdapter((ListAdapter) aVar);
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str == null) {
                this.b.setVisibility(8);
                return;
            }
            this.b.setVisibility(0);
            this.b.setText(str);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.a, R.drawable.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0106, 1, skinType);
            a aVar = this.d;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tieba.ea5
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.ea5
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onViewDettached();
            this.a.setImageResource(0);
        }
    }
}

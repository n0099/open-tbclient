package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.square.forumlist.SquareForumListActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tbclient.GetForumsFromForumClass.ForumSpaceForumInfo;
/* loaded from: classes4.dex */
public class e99 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Long, Integer> a;
    public TbPageContext<SquareForumListActivity> b;
    public int c;
    public List<ForumSpaceForumInfo> d;
    public LikeModel e;
    public View.OnClickListener f;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes4.dex */
    public class a extends z8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e99 a;

        public a(e99 e99Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e99Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e99Var;
        }

        @Override // com.baidu.tieba.z8
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && AntiHelper.m(this.a.e.getErrorCode(), this.a.e.getErrorString())) {
                AntiHelper.u(this.a.b.getPageActivity(), this.a.e.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e99 a;

        public b(e99 e99Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e99Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e99Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String valueOf;
            String valueOf2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str = "";
                if (view2.getId() == R.id.obfuscated_res_0x7f090b7d) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.b.showToast(R.string.obfuscated_res_0x7f0f0d1f);
                    } else if (!ViewHelper.checkUpIsLogin(this.a.b.getPageActivity())) {
                    } else {
                        if (view2.getTag(R.id.obfuscated_res_0x7f090bb7) == null) {
                            valueOf2 = "";
                        } else {
                            valueOf2 = String.valueOf(view2.getTag(R.id.obfuscated_res_0x7f090bb7));
                        }
                        if (view2.getTag(R.id.obfuscated_res_0x7f090b54) != null) {
                            str = String.valueOf(view2.getTag(R.id.obfuscated_res_0x7f090b54));
                        }
                        this.a.e.j0(valueOf2, str);
                        if (this.a.c == 1) {
                            TiebaStatic.log(new StatisticItem("c10566").param("fid", str));
                        } else if (this.a.c == 2) {
                            TiebaStatic.log(new StatisticItem("c10587").param("fid", str));
                        }
                    }
                } else if (view2.getId() != R.id.obfuscated_res_0x7f092122) {
                    if (view2.getTag(R.id.obfuscated_res_0x7f090bb7) == null) {
                        valueOf = "";
                    } else {
                        valueOf = String.valueOf(view2.getTag(R.id.obfuscated_res_0x7f090bb7));
                    }
                    if (view2.getTag(R.id.obfuscated_res_0x7f090b54) != null) {
                        str = String.valueOf(view2.getTag(R.id.obfuscated_res_0x7f090b54));
                    }
                    this.a.b.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.b.getContext()).createNormalCfg(valueOf, null)));
                    if (this.a.c == 1) {
                        TiebaStatic.log(new StatisticItem("c10565").param("obj_type", 1).param("fid", str));
                    } else if (this.a.c == 2) {
                        TiebaStatic.log(new StatisticItem("c10586").param("obj_type", 1).param("fid", str));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public BarImageView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;

        public c(e99 e99Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e99Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(e99 e99Var, a aVar) {
            this(e99Var);
        }
    }

    public e99(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.b = tbPageContext;
        this.c = i;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.e = likeModel;
        likeModel.setLoadDataCallBack(new a(this));
        this.f = new b(this);
    }

    public void f(Long l, boolean z) {
        int i;
        Integer valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, l, z) == null) {
            if (this.a.containsKey(l)) {
                Integer num = this.a.get(l);
                if (z) {
                    valueOf = Integer.valueOf(num.intValue() + 1);
                } else {
                    valueOf = Integer.valueOf(num.intValue() - 1);
                }
                this.a.put(l, valueOf);
            } else if (!this.a.containsKey(l)) {
                Map<Long, Integer> map = this.a;
                if (z) {
                    i = 1;
                } else {
                    i = -1;
                }
                map.put(l, i);
            }
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public ForumSpaceForumInfo getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (getCount() <= 1 || i == 0) {
                return null;
            }
            return (ForumSpaceForumInfo) ListUtils.getItem(this.d, i - 1);
        }
        return (ForumSpaceForumInfo) invokeI.objValue;
    }

    public void e(List<ForumSpaceForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.d = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (ListUtils.getCount(this.d) > 0) {
                return ListUtils.getCount(this.d) + 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        int intValue;
        int intValue2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (i == 0) {
                if (view2 == null || !(view2 instanceof TbImageView)) {
                    view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d085e, (ViewGroup) null);
                }
                if (this.c == 1) {
                    i2 = R.drawable.pic_batuijian_bg_red;
                } else {
                    i2 = R.drawable.pic_batuijian_bg_yellow;
                }
                SkinManager.setImageResource((TbImageView) view2, i2);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                return view2;
            }
            ForumSpaceForumInfo item = getItem(i);
            if (item == null) {
                return null;
            }
            if (view2 == null || !(view2.getTag(R.id.obfuscated_res_0x7f090b93) instanceof c)) {
                view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d085f, (ViewGroup) null);
                c cVar = new c(this, null);
                cVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b93);
                cVar.b = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b78);
                cVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b7d);
                cVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090bb7);
                cVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b54);
                cVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090bc1);
                hi.b(this.b.getPageActivity(), cVar.f, 20, 20, 20, 20);
                cVar.f.setOnClickListener(this.f);
                view2.setOnClickListener(this.f);
                view2.setTag(R.id.obfuscated_res_0x7f090b93, cVar);
            }
            SkinManager.setBackgroundResource(view2, R.drawable.square_list_item_bg_selector);
            c cVar2 = (c) view2.getTag(R.id.obfuscated_res_0x7f090b93);
            if (i == 1) {
                cVar2.a.setText("");
                SkinManager.setBackgroundResource(cVar2.a, R.drawable.icon_grade_shaitu1);
            } else if (i == 2) {
                cVar2.a.setText("");
                SkinManager.setBackgroundResource(cVar2.a, R.drawable.icon_grade_shaitu2);
            } else if (i == 3) {
                cVar2.a.setText("");
                SkinManager.setBackgroundResource(cVar2.a, R.drawable.icon_grade_shaitu3);
            } else if (i < 10) {
                TextView textView = cVar2.a;
                textView.setText("0" + i);
                cVar2.a.setBackgroundResource(0);
            } else {
                TextView textView2 = cVar2.a;
                textView2.setText("" + i);
                cVar2.a.setBackgroundResource(0);
            }
            SkinManager.setViewTextColor(cVar2.a, (int) R.color.CAM_X0108);
            cVar2.b.M(item.avatar, 10, false);
            cVar2.c.setText(item.forum_name + this.b.getString(R.string.obfuscated_res_0x7f0f06bd));
            SkinManager.setViewTextColor(cVar2.c, (int) R.color.CAM_X0105);
            Integer num = this.a.get(item.forum_id);
            int intValue3 = item.like_num.intValue();
            if (num == null) {
                intValue = 0;
            } else {
                intValue = num.intValue();
            }
            int i3 = intValue3 + intValue;
            cVar2.d.setText(this.b.getString(R.string.obfuscated_res_0x7f0f02ba) + ":" + StringHelper.numberUniformFormat(i3) + GlideException.IndentedAppendable.INDENT + this.b.getString(R.string.text_post) + ":" + StringHelper.numberUniformFormat(item.post_num.intValue()));
            SkinManager.setViewTextColor(cVar2.d, (int) R.color.CAM_X0109);
            cVar2.e.setText(item._abstract);
            SkinManager.setViewTextColor(cVar2.e, (int) R.color.CAM_X0109);
            cVar2.f.setTag(R.id.obfuscated_res_0x7f090bb7, item.forum_name);
            cVar2.f.setTag(R.id.obfuscated_res_0x7f090b54, item.forum_id);
            if (this.a.get(item.forum_id) == null) {
                intValue2 = 0;
            } else {
                intValue2 = this.a.get(item.forum_id).intValue();
            }
            if ((item.is_like.intValue() == 0 && intValue2 > 0) || (item.is_like.intValue() == 1 && intValue2 >= 0)) {
                cVar2.f.setText(R.string.relate_forum_is_followed);
                cVar2.f.setBackgroundResource(0);
                SkinManager.setViewTextColor(cVar2.f, (int) R.color.CAM_X0109);
            } else {
                cVar2.f.setText(R.string.obfuscated_res_0x7f0f02ba);
                cVar2.f.setBackgroundResource(R.drawable.btn_blue_bg);
                SkinManager.setViewTextColor(cVar2.f, (int) R.color.CAM_X0101);
            }
            view2.setTag(R.id.obfuscated_res_0x7f090bb7, item.forum_name);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}

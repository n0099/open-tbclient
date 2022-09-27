package com.baidu.tieba.faceshop.forumpackage.adapter;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.de6;
import com.baidu.tieba.ee6;
import com.baidu.tieba.ej;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.nr7;
import com.baidu.tieba.rc6;
import com.baidu.tieba.wj;
import com.baidu.tieba.yd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ForumEmotionViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumEmotionItemView a;
    public TbPageContext b;
    public ee6 c;
    public NewFaceGroupDownloadModel d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de6 a;
        public final /* synthetic */ yd6 b;

        public a(ForumEmotionViewHolder forumEmotionViewHolder, de6 de6Var, yd6 yd6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, de6Var, yd6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de6Var;
            this.b = yd6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                de6 de6Var = this.a;
                de6Var.c(!de6Var.b());
                yd6 yd6Var = this.b;
                if (yd6Var != null) {
                    yd6Var.b();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de6 a;
        public final /* synthetic */ yd6 b;

        public b(ForumEmotionViewHolder forumEmotionViewHolder, de6 de6Var, yd6 yd6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, de6Var, yd6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de6Var;
            this.b = yd6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c(false);
                this.a.d(0);
                yd6 yd6Var = this.b;
                if (yd6Var != null) {
                    yd6Var.a(this.a.a());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de6 a;
        public final /* synthetic */ yd6 b;

        public c(ForumEmotionViewHolder forumEmotionViewHolder, de6 de6Var, yd6 yd6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, de6Var, yd6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de6Var;
            this.b = yd6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c(false);
                this.a.d(1);
                yd6 yd6Var = this.b;
                if (yd6Var != null) {
                    yd6Var.a(this.a.a());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumEmotionPackageData a;
        public final /* synthetic */ ForumEmotionViewHolder b;

        public d(ForumEmotionViewHolder forumEmotionViewHolder, ForumEmotionPackageData forumEmotionPackageData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, forumEmotionPackageData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = forumEmotionViewHolder;
            this.a = forumEmotionPackageData;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.b.b.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.b.b.getPageActivity(), this.a.id, 0)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumEmotionPackageData a;
        public final /* synthetic */ ForumEmotionViewHolder b;

        public e(ForumEmotionViewHolder forumEmotionViewHolder, ForumEmotionPackageData forumEmotionPackageData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, forumEmotionPackageData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = forumEmotionViewHolder;
            this.a = forumEmotionPackageData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.k(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements nr7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumEmotionPackageData a;
        public final /* synthetic */ ForumEmotionViewHolder b;

        public f(ForumEmotionViewHolder forumEmotionViewHolder, ForumEmotionPackageData forumEmotionPackageData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, forumEmotionPackageData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = forumEmotionViewHolder;
            this.a = forumEmotionPackageData;
        }

        @Override // com.baidu.tieba.nr7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ej.M(this.b.b.getPageActivity(), R.string.obfuscated_res_0x7f0f050d);
                this.b.a.getDownLoadView().setEnabled(true);
            }
        }

        @Override // com.baidu.tieba.nr7
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i > 0 && i < 100) {
                    ej.K(this.b.b.getPageActivity(), wj.a(R.string.obfuscated_res_0x7f0f0d49));
                } else if (i >= 100) {
                    ej.J(this.b.b.getPageActivity(), R.string.obfuscated_res_0x7f0f0508);
                }
            }
        }

        @Override // com.baidu.tieba.nr7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                ej.M(this.b.b.getPageActivity(), R.string.obfuscated_res_0x7f0f0508);
                this.b.a.getDownLoadView().setText(R.string.obfuscated_res_0x7f0f027e);
                SkinManager.setViewTextColor(this.b.a.getDownLoadView(), (int) R.color.CAM_X0109);
                this.b.a.getDownLoadView().setBackgroundDrawable(null);
                this.b.a.getDownLoadView().setEnabled(false);
                this.a.download++;
                if (this.b.c != null) {
                    ForumEmotionPackageData forumEmotionPackageData = this.b.c.a;
                    ForumEmotionPackageData forumEmotionPackageData2 = this.a;
                    if (forumEmotionPackageData == forumEmotionPackageData2) {
                        this.b.i(forumEmotionPackageData2);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionViewHolder(TbPageContext tbPageContext, View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
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
        this.a = (ForumEmotionItemView) view2;
        this.b = tbPageContext;
    }

    public final void f(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumEmotionPackageData) == null) {
            TextView downLoadView = this.a.getDownLoadView();
            if (forumEmotionPackageData == null) {
                downLoadView.setVisibility(4);
                return;
            }
            downLoadView.setVisibility(0);
            downLoadView.setOnClickListener(new e(this, forumEmotionPackageData));
            rc6 c2 = rc6.c();
            if (c2.e("" + forumEmotionPackageData.id)) {
                downLoadView.setText(R.string.obfuscated_res_0x7f0f027e);
                downLoadView.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(downLoadView, (int) R.color.CAM_X0109);
                downLoadView.setBackgroundDrawable(null);
                downLoadView.setEnabled(false);
                return;
            }
            int i = forumEmotionPackageData.status;
            if (i != 0) {
                if (i == 1) {
                    downLoadView.setText(R.string.obfuscated_res_0x7f0f0509);
                    SkinManager.setViewTextColor(downLoadView, (int) R.color.CAM_X0302);
                    SkinManager.setBackgroundResource(downLoadView, R.drawable.bg_emotion_download);
                    downLoadView.setEnabled(true);
                    return;
                } else if (i == 2) {
                    downLoadView.setBackgroundDrawable(null);
                    SkinManager.setViewTextColor(downLoadView, (int) R.color.CAM_X0109);
                    downLoadView.setEnabled(false);
                    return;
                } else if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                    downLoadView.setBackgroundDrawable(null);
                    SkinManager.setViewTextColor(downLoadView, (int) R.color.CAM_X0109);
                    downLoadView.setText(R.string.obfuscated_res_0x7f0f0606);
                    downLoadView.setEnabled(false);
                    return;
                }
            }
            downLoadView.setText(R.string.obfuscated_res_0x7f0f0509);
            SkinManager.setViewTextColor(downLoadView, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundResource(downLoadView, R.drawable.bg_emotion_download);
            downLoadView.setEnabled(true);
        }
    }

    public final void g(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumEmotionPackageData) == null) {
            if (forumEmotionPackageData != null) {
                this.a.getListView().setVisibility(0);
                this.a.getListView().setAdapter((ListAdapter) this.a.getAdapter());
                this.a.getAdapter().a(forumEmotionPackageData.pics, forumEmotionPackageData.forum_id > 0);
                this.a.getListView().setOnItemClickListener(new d(this, forumEmotionPackageData));
                return;
            }
            this.a.getListView().setVisibility(4);
        }
    }

    public final void h(de6 de6Var, yd6 yd6Var, int i) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, de6Var, yd6Var, i) == null) {
            ViewGroup filterDropDownView = this.a.getFilterDropDownView();
            if (i == 0 && de6Var != null) {
                Resources resources = this.a.getResources();
                TextView filterView = this.a.getFilterView();
                this.a.getHeaderView().setVisibility(0);
                filterDropDownView.setVisibility(0);
                if (de6Var.a() == 0) {
                    string = resources.getString(R.string.obfuscated_res_0x7f0f0687);
                } else {
                    string = resources.getString(R.string.obfuscated_res_0x7f0f0688);
                }
                filterView.setText(string);
                if (de6Var.b()) {
                    filterDropDownView.setVisibility(0);
                } else {
                    filterDropDownView.setVisibility(8);
                }
                filterView.setOnClickListener(new a(this, de6Var, yd6Var));
                if (filterDropDownView.getChildCount() >= 2) {
                    filterDropDownView.getChildAt(0).setOnClickListener(new b(this, de6Var, yd6Var));
                    filterDropDownView.getChildAt(1).setOnClickListener(new c(this, de6Var, yd6Var));
                    return;
                }
                return;
            }
            this.a.getHeaderView().setVisibility(8);
            filterDropDownView.setVisibility(8);
        }
    }

    public final void i(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, forumEmotionPackageData) == null) {
            if (forumEmotionPackageData != null) {
                this.a.getDownloadNumView().setVisibility(0);
                this.a.getShareNumView().setVisibility(0);
                this.a.getTitleView().setVisibility(0);
                if (!TextUtils.isEmpty(forumEmotionPackageData.forum_name)) {
                    TextView titleView = this.a.getTitleView();
                    titleView.setText(forumEmotionPackageData.forum_name + "吧·" + forumEmotionPackageData.name);
                } else {
                    this.a.getTitleView().setText(forumEmotionPackageData.name);
                }
                this.a.getDownloadNumView().setText(String.format(wj.a(R.string.obfuscated_res_0x7f0f0686), StringHelper.numberUniform(forumEmotionPackageData.download)));
                this.a.getShareNumView().setText(String.format(wj.a(R.string.obfuscated_res_0x7f0f0689), StringHelper.numberUniform(forumEmotionPackageData.share)));
            } else {
                this.a.getTitleView().setVisibility(4);
                this.a.getDownloadNumView().setVisibility(4);
                this.a.getShareNumView().setVisibility(4);
            }
            this.a.getLineView().setVisibility(forumEmotionPackageData != null ? 0 : 4);
            if (forumEmotionPackageData == null) {
                SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            } else {
                this.a.setBackgroundColor(0);
            }
        }
    }

    public final void j(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forumEmotionPackageData) == null) {
            TextView rankView = this.a.getRankView();
            if (forumEmotionPackageData != null) {
                rankView.setVisibility(0);
                long j = forumEmotionPackageData.rank_num;
                if (j > 20) {
                    rankView.setVisibility(8);
                    return;
                } else if (j > 3) {
                    rankView.setVisibility(0);
                    rankView.setText(String.valueOf(forumEmotionPackageData.rank_num));
                    SkinManager.setBackgroundResource(rankView, R.drawable.bg_emotion_rank);
                    return;
                } else {
                    rankView.setVisibility(0);
                    rankView.setText("");
                    long j2 = forumEmotionPackageData.rank_num;
                    if (j2 == 3) {
                        SkinManager.setBackgroundResource(rankView, R.drawable.icon_grade_vote_num3);
                        return;
                    } else if (j2 == 2) {
                        SkinManager.setBackgroundResource(rankView, R.drawable.icon_grade_vote_num2);
                        return;
                    } else {
                        SkinManager.setBackgroundResource(rankView, R.drawable.icon_grade_vote_num1);
                        return;
                    }
                }
            }
            rankView.setVisibility(4);
        }
    }

    public final void k(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, forumEmotionPackageData) == null) || !ViewHelper.checkUpIsLogin(this.b.getPageActivity()) || forumEmotionPackageData == null || forumEmotionPackageData.id < 0) {
            return;
        }
        if (this.d == null) {
            this.d = new NewFaceGroupDownloadModel();
        }
        this.a.getDownLoadView().setEnabled(false);
        this.d.z(Integer.toString(forumEmotionPackageData.id), Boolean.TRUE, new f(this, forumEmotionPackageData));
    }

    public void l(ee6 ee6Var, de6 de6Var, yd6 yd6Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048582, this, ee6Var, de6Var, yd6Var, i) == null) {
            this.c = ee6Var;
            if (this.a == null || ee6Var == null) {
                return;
            }
            if (ee6Var.a != null || i == 0) {
                h(de6Var, yd6Var, i);
                g(ee6Var.a);
                j(ee6Var.a);
                i(ee6Var.a);
                f(ee6Var.a);
            }
        }
    }
}

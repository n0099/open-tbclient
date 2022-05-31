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
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a86;
import com.repackage.cj;
import com.repackage.f86;
import com.repackage.g86;
import com.repackage.li;
import com.repackage.ml7;
import com.repackage.t66;
/* loaded from: classes3.dex */
public class ForumEmotionViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumEmotionItemView a;
    public TbPageContext b;
    public g86 c;
    public NewFaceGroupDownloadModel d;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f86 a;
        public final /* synthetic */ a86 b;

        public a(ForumEmotionViewHolder forumEmotionViewHolder, f86 f86Var, a86 a86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, f86Var, a86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f86Var;
            this.b = a86Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                f86 f86Var = this.a;
                f86Var.c(!f86Var.b());
                a86 a86Var = this.b;
                if (a86Var != null) {
                    a86Var.b();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f86 a;
        public final /* synthetic */ a86 b;

        public b(ForumEmotionViewHolder forumEmotionViewHolder, f86 f86Var, a86 a86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, f86Var, a86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f86Var;
            this.b = a86Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c(false);
                this.a.d(0);
                a86 a86Var = this.b;
                if (a86Var != null) {
                    a86Var.a(this.a.a());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f86 a;
        public final /* synthetic */ a86 b;

        public c(ForumEmotionViewHolder forumEmotionViewHolder, f86 f86Var, a86 a86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, f86Var, a86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f86Var;
            this.b = a86Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c(false);
                this.a.d(1);
                a86 a86Var = this.b;
                if (a86Var != null) {
                    a86Var.a(this.a.a());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                this.b.m(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ml7 {
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

        @Override // com.repackage.ml7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                li.N(this.b.b.getPageActivity(), R.string.obfuscated_res_0x7f0f04fb);
                this.b.a.getDownLoadView().setEnabled(true);
            }
        }

        @Override // com.repackage.ml7
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i > 0 && i < 100) {
                    li.L(this.b.b.getPageActivity(), cj.a(R.string.obfuscated_res_0x7f0f0d20));
                } else if (i >= 100) {
                    li.K(this.b.b.getPageActivity(), R.string.obfuscated_res_0x7f0f04f6);
                }
            }
        }

        @Override // com.repackage.ml7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                li.N(this.b.b.getPageActivity(), R.string.obfuscated_res_0x7f0f04f6);
                this.b.a.getDownLoadView().setText(R.string.obfuscated_res_0x7f0f0273);
                SkinManager.setViewTextColor(this.b.a.getDownLoadView(), (int) R.color.CAM_X0109);
                this.b.a.getDownLoadView().setBackgroundDrawable(null);
                this.b.a.getDownLoadView().setEnabled(false);
                this.a.download++;
                if (this.b.c != null) {
                    ForumEmotionPackageData forumEmotionPackageData = this.b.c.a;
                    ForumEmotionPackageData forumEmotionPackageData2 = this.a;
                    if (forumEmotionPackageData == forumEmotionPackageData2) {
                        this.b.k(forumEmotionPackageData2);
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

    public final void h(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumEmotionPackageData) == null) {
            TextView downLoadView = this.a.getDownLoadView();
            if (forumEmotionPackageData == null) {
                downLoadView.setVisibility(4);
                return;
            }
            downLoadView.setVisibility(0);
            downLoadView.setOnClickListener(new e(this, forumEmotionPackageData));
            t66 c2 = t66.c();
            if (c2.e("" + forumEmotionPackageData.id)) {
                downLoadView.setText(R.string.obfuscated_res_0x7f0f0273);
                downLoadView.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(downLoadView, (int) R.color.CAM_X0109);
                downLoadView.setBackgroundDrawable(null);
                downLoadView.setEnabled(false);
                return;
            }
            int i = forumEmotionPackageData.status;
            if (i != 0) {
                if (i == 1) {
                    downLoadView.setText(R.string.obfuscated_res_0x7f0f04f7);
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
                    downLoadView.setText(R.string.obfuscated_res_0x7f0f05f0);
                    downLoadView.setEnabled(false);
                    return;
                }
            }
            downLoadView.setText(R.string.obfuscated_res_0x7f0f04f7);
            SkinManager.setViewTextColor(downLoadView, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundResource(downLoadView, R.drawable.bg_emotion_download);
            downLoadView.setEnabled(true);
        }
    }

    public final void i(ForumEmotionPackageData forumEmotionPackageData) {
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

    public final void j(f86 f86Var, a86 a86Var, int i) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, f86Var, a86Var, i) == null) {
            ViewGroup filterDropDownView = this.a.getFilterDropDownView();
            if (i == 0 && f86Var != null) {
                Resources resources = this.a.getResources();
                TextView filterView = this.a.getFilterView();
                this.a.getHeaderView().setVisibility(0);
                filterDropDownView.setVisibility(0);
                if (f86Var.a() == 0) {
                    string = resources.getString(R.string.obfuscated_res_0x7f0f066b);
                } else {
                    string = resources.getString(R.string.obfuscated_res_0x7f0f066c);
                }
                filterView.setText(string);
                if (f86Var.b()) {
                    filterDropDownView.setVisibility(0);
                } else {
                    filterDropDownView.setVisibility(8);
                }
                filterView.setOnClickListener(new a(this, f86Var, a86Var));
                if (filterDropDownView.getChildCount() >= 2) {
                    filterDropDownView.getChildAt(0).setOnClickListener(new b(this, f86Var, a86Var));
                    filterDropDownView.getChildAt(1).setOnClickListener(new c(this, f86Var, a86Var));
                    return;
                }
                return;
            }
            this.a.getHeaderView().setVisibility(8);
            filterDropDownView.setVisibility(8);
        }
    }

    public final void k(ForumEmotionPackageData forumEmotionPackageData) {
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
                this.a.getDownloadNumView().setText(String.format(cj.a(R.string.obfuscated_res_0x7f0f066a), StringHelper.numberUniform(forumEmotionPackageData.download)));
                this.a.getShareNumView().setText(String.format(cj.a(R.string.obfuscated_res_0x7f0f066d), StringHelper.numberUniform(forumEmotionPackageData.share)));
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

    public final void l(ForumEmotionPackageData forumEmotionPackageData) {
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

    public final void m(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, forumEmotionPackageData) == null) || !ViewHelper.checkUpIsLogin(this.b.getPageActivity()) || forumEmotionPackageData == null || forumEmotionPackageData.id < 0) {
            return;
        }
        if (this.d == null) {
            this.d = new NewFaceGroupDownloadModel();
        }
        this.a.getDownLoadView().setEnabled(false);
        this.d.y(Integer.toString(forumEmotionPackageData.id), Boolean.TRUE, new f(this, forumEmotionPackageData));
    }

    public void n(g86 g86Var, f86 f86Var, a86 a86Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048582, this, g86Var, f86Var, a86Var, i) == null) {
            this.c = g86Var;
            if (this.a == null || g86Var == null) {
                return;
            }
            if (g86Var.a != null || i == 0) {
                j(f86Var, a86Var, i);
                i(g86Var.a);
                l(g86Var.a);
                k(g86Var.a);
                h(g86Var.a);
            }
        }
    }
}

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
import com.baidu.tieba.ej;
import com.baidu.tieba.f68;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.jn6;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.qo6;
import com.baidu.tieba.vo6;
import com.baidu.tieba.wj;
import com.baidu.tieba.wo6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ForumEmotionViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumEmotionItemView a;
    public TbPageContext b;
    public wo6 c;
    public NewFaceGroupDownloadModel d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vo6 a;
        public final /* synthetic */ qo6 b;

        public a(ForumEmotionViewHolder forumEmotionViewHolder, vo6 vo6Var, qo6 qo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, vo6Var, qo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vo6Var;
            this.b = qo6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                vo6 vo6Var = this.a;
                vo6Var.c(!vo6Var.b());
                qo6 qo6Var = this.b;
                if (qo6Var != null) {
                    qo6Var.b();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vo6 a;
        public final /* synthetic */ qo6 b;

        public b(ForumEmotionViewHolder forumEmotionViewHolder, vo6 vo6Var, qo6 qo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, vo6Var, qo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vo6Var;
            this.b = qo6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c(false);
                this.a.d(0);
                qo6 qo6Var = this.b;
                if (qo6Var != null) {
                    qo6Var.a(this.a.a());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vo6 a;
        public final /* synthetic */ qo6 b;

        public c(ForumEmotionViewHolder forumEmotionViewHolder, vo6 vo6Var, qo6 qo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, vo6Var, qo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vo6Var;
            this.b = qo6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c(false);
                this.a.d(1);
                qo6 qo6Var = this.b;
                if (qo6Var != null) {
                    qo6Var.a(this.a.a());
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.b.k(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements f68 {
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

        @Override // com.baidu.tieba.f68
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ej.P(this.b.b.getPageActivity(), R.string.download_error);
                this.b.a.getDownLoadView().setEnabled(true);
            }
        }

        @Override // com.baidu.tieba.f68
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i > 0 && i < 100) {
                    ej.N(this.b.b.getPageActivity(), wj.a(R.string.obfuscated_res_0x7f0f0dee));
                } else if (i >= 100) {
                    ej.M(this.b.b.getPageActivity(), R.string.down_state_success);
                }
            }
        }

        @Override // com.baidu.tieba.f68
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                ej.P(this.b.b.getPageActivity(), R.string.down_state_success);
                this.b.a.getDownLoadView().setText(R.string.already_downloaded);
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
            jn6 c2 = jn6.c();
            if (c2.e("" + forumEmotionPackageData.id)) {
                downLoadView.setText(R.string.already_downloaded);
                downLoadView.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(downLoadView, (int) R.color.CAM_X0109);
                downLoadView.setBackgroundDrawable(null);
                downLoadView.setEnabled(false);
                return;
            }
            int i = forumEmotionPackageData.status;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                downLoadView.setBackgroundDrawable(null);
                                SkinManager.setViewTextColor(downLoadView, (int) R.color.CAM_X0109);
                                downLoadView.setText(R.string.obfuscated_res_0x7f0f0644);
                                downLoadView.setEnabled(false);
                                return;
                            }
                            return;
                        }
                    } else {
                        downLoadView.setBackgroundDrawable(null);
                        SkinManager.setViewTextColor(downLoadView, (int) R.color.CAM_X0109);
                        downLoadView.setEnabled(false);
                        return;
                    }
                } else {
                    downLoadView.setText(R.string.obfuscated_res_0x7f0f0530);
                    SkinManager.setViewTextColor(downLoadView, (int) R.color.CAM_X0302);
                    SkinManager.setBackgroundResource(downLoadView, R.drawable.bg_emotion_download);
                    downLoadView.setEnabled(true);
                    return;
                }
            }
            downLoadView.setText(R.string.obfuscated_res_0x7f0f0530);
            SkinManager.setViewTextColor(downLoadView, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundResource(downLoadView, R.drawable.bg_emotion_download);
            downLoadView.setEnabled(true);
        }
    }

    public final void g(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumEmotionPackageData) == null) {
            if (forumEmotionPackageData != null) {
                boolean z = false;
                this.a.getListView().setVisibility(0);
                this.a.getListView().setAdapter((ListAdapter) this.a.getAdapter());
                ForumEmotionItemView.a adapter = this.a.getAdapter();
                ArrayList<EmotionPackageData.SingleEmotionData> arrayList = forumEmotionPackageData.pics;
                if (forumEmotionPackageData.forum_id > 0) {
                    z = true;
                }
                adapter.a(arrayList, z);
                this.a.getListView().setOnItemClickListener(new d(this, forumEmotionPackageData));
                return;
            }
            this.a.getListView().setVisibility(4);
        }
    }

    public final void k(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, forumEmotionPackageData) == null) && ViewHelper.checkUpIsLogin(this.b.getPageActivity()) && forumEmotionPackageData != null && forumEmotionPackageData.id >= 0) {
            if (this.d == null) {
                this.d = new NewFaceGroupDownloadModel();
            }
            this.a.getDownLoadView().setEnabled(false);
            this.d.G(Integer.toString(forumEmotionPackageData.id), Boolean.TRUE, new f(this, forumEmotionPackageData));
        }
    }

    public final void h(vo6 vo6Var, qo6 qo6Var, int i) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, vo6Var, qo6Var, i) == null) {
            ViewGroup filterDropDownView = this.a.getFilterDropDownView();
            if (i == 0 && vo6Var != null) {
                Resources resources = this.a.getResources();
                TextView filterView = this.a.getFilterView();
                this.a.getHeaderView().setVisibility(0);
                filterDropDownView.setVisibility(0);
                if (vo6Var.a() == 0) {
                    string = resources.getString(R.string.obfuscated_res_0x7f0f06c6);
                } else {
                    string = resources.getString(R.string.obfuscated_res_0x7f0f06c7);
                }
                filterView.setText(string);
                if (vo6Var.b()) {
                    filterDropDownView.setVisibility(0);
                } else {
                    filterDropDownView.setVisibility(8);
                }
                filterView.setOnClickListener(new a(this, vo6Var, qo6Var));
                if (filterDropDownView.getChildCount() >= 2) {
                    filterDropDownView.getChildAt(0).setOnClickListener(new b(this, vo6Var, qo6Var));
                    filterDropDownView.getChildAt(1).setOnClickListener(new c(this, vo6Var, qo6Var));
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
            int i = 4;
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
                this.a.getDownloadNumView().setText(String.format(wj.a(R.string.obfuscated_res_0x7f0f06c5), StringHelper.numberUniform(forumEmotionPackageData.download)));
                this.a.getShareNumView().setText(String.format(wj.a(R.string.obfuscated_res_0x7f0f06c8), StringHelper.numberUniform(forumEmotionPackageData.share)));
            } else {
                this.a.getTitleView().setVisibility(4);
                this.a.getDownloadNumView().setVisibility(4);
                this.a.getShareNumView().setVisibility(4);
            }
            View lineView = this.a.getLineView();
            if (forumEmotionPackageData != null) {
                i = 0;
            }
            lineView.setVisibility(i);
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

    public void l(wo6 wo6Var, vo6 vo6Var, qo6 qo6Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048582, this, wo6Var, vo6Var, qo6Var, i) == null) {
            this.c = wo6Var;
            if (this.a != null && wo6Var != null) {
                if (wo6Var.a != null || i == 0) {
                    h(vo6Var, qo6Var, i);
                    g(wo6Var.a);
                    j(wo6Var.a);
                    i(wo6Var.a);
                    f(wo6Var.a);
                }
            }
        }
    }
}

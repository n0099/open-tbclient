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
import d.a.c.e.p.l;
import d.a.c.e.q.h;
/* loaded from: classes5.dex */
public class ForumEmotionViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ForumEmotionItemView f15112a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f15113b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.p0.z.b.c f15114c;

    /* renamed from: d  reason: collision with root package name */
    public NewFaceGroupDownloadModel f15115d;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.p0.z.b.b f15116e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.p0.z.a.a f15117f;

        public a(ForumEmotionViewHolder forumEmotionViewHolder, d.a.s0.p0.z.b.b bVar, d.a.s0.p0.z.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15116e = bVar;
            this.f15117f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.s0.p0.z.b.b bVar = this.f15116e;
                bVar.c(!bVar.b());
                d.a.s0.p0.z.a.a aVar = this.f15117f;
                if (aVar != null) {
                    aVar.b();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.p0.z.b.b f15118e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.p0.z.a.a f15119f;

        public b(ForumEmotionViewHolder forumEmotionViewHolder, d.a.s0.p0.z.b.b bVar, d.a.s0.p0.z.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15118e = bVar;
            this.f15119f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15118e.c(false);
                this.f15118e.d(0);
                d.a.s0.p0.z.a.a aVar = this.f15119f;
                if (aVar != null) {
                    aVar.a(this.f15118e.a());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.p0.z.b.b f15120e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.p0.z.a.a f15121f;

        public c(ForumEmotionViewHolder forumEmotionViewHolder, d.a.s0.p0.z.b.b bVar, d.a.s0.p0.z.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15120e = bVar;
            this.f15121f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15120e.c(false);
                this.f15120e.d(1);
                d.a.s0.p0.z.a.a aVar = this.f15121f;
                if (aVar != null) {
                    aVar.a(this.f15120e.a());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f15122a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionViewHolder f15123b;

        public d(ForumEmotionViewHolder forumEmotionViewHolder, ForumEmotionPackageData forumEmotionPackageData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, forumEmotionPackageData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15123b = forumEmotionViewHolder;
            this.f15122a = forumEmotionPackageData;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f15123b.f15113b.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.f15123b.f15113b.getPageActivity(), this.f15122a.id, 0)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f15124e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionViewHolder f15125f;

        public e(ForumEmotionViewHolder forumEmotionViewHolder, ForumEmotionPackageData forumEmotionPackageData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, forumEmotionPackageData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15125f = forumEmotionViewHolder;
            this.f15124e = forumEmotionPackageData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15125f.l(this.f15124e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements d.a.s0.c2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f15126a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionViewHolder f15127b;

        public f(ForumEmotionViewHolder forumEmotionViewHolder, ForumEmotionPackageData forumEmotionPackageData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionViewHolder, forumEmotionPackageData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15127b = forumEmotionViewHolder;
            this.f15126a = forumEmotionPackageData;
        }

        @Override // d.a.s0.c2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.L(this.f15127b.f15113b.getPageActivity(), R.string.download_error);
                this.f15127b.f15112a.getDownLoadView().setEnabled(true);
            }
        }

        @Override // d.a.s0.c2.e.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (i2 > 0 && i2 < 100) {
                    l.J(this.f15127b.f15113b.getPageActivity(), h.a(R.string.package_downloading_progress));
                } else if (i2 >= 100) {
                    l.I(this.f15127b.f15113b.getPageActivity(), R.string.down_state_success);
                }
            }
        }

        @Override // d.a.s0.c2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                l.L(this.f15127b.f15113b.getPageActivity(), R.string.down_state_success);
                this.f15127b.f15112a.getDownLoadView().setText(R.string.already_downloaded);
                SkinManager.setViewTextColor(this.f15127b.f15112a.getDownLoadView(), R.color.CAM_X0109);
                this.f15127b.f15112a.getDownLoadView().setBackgroundDrawable(null);
                this.f15127b.f15112a.getDownLoadView().setEnabled(false);
                this.f15126a.download++;
                if (this.f15127b.f15114c != null) {
                    ForumEmotionPackageData forumEmotionPackageData = this.f15127b.f15114c.f64604e;
                    ForumEmotionPackageData forumEmotionPackageData2 = this.f15126a;
                    if (forumEmotionPackageData == forumEmotionPackageData2) {
                        this.f15127b.j(forumEmotionPackageData2);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
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
        this.f15112a = (ForumEmotionItemView) view;
        this.f15113b = tbPageContext;
    }

    public final void g(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumEmotionPackageData) == null) {
            TextView downLoadView = this.f15112a.getDownLoadView();
            if (forumEmotionPackageData == null) {
                downLoadView.setVisibility(4);
                return;
            }
            downLoadView.setVisibility(0);
            downLoadView.setOnClickListener(new e(this, forumEmotionPackageData));
            d.a.s0.p0.a c2 = d.a.s0.p0.a.c();
            if (c2.e("" + forumEmotionPackageData.id)) {
                downLoadView.setText(R.string.already_downloaded);
                downLoadView.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(downLoadView, R.color.CAM_X0109);
                downLoadView.setBackgroundDrawable(null);
                downLoadView.setEnabled(false);
                return;
            }
            int i2 = forumEmotionPackageData.status;
            if (i2 != 0) {
                if (i2 == 1) {
                    downLoadView.setText(R.string.download);
                    SkinManager.setViewTextColor(downLoadView, R.color.CAM_X0302);
                    SkinManager.setBackgroundResource(downLoadView, R.drawable.bg_emotion_download);
                    downLoadView.setEnabled(true);
                    return;
                } else if (i2 == 2) {
                    downLoadView.setBackgroundDrawable(null);
                    SkinManager.setViewTextColor(downLoadView, R.color.CAM_X0109);
                    downLoadView.setEnabled(false);
                    return;
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        return;
                    }
                    downLoadView.setBackgroundDrawable(null);
                    SkinManager.setViewTextColor(downLoadView, R.color.CAM_X0109);
                    downLoadView.setText(R.string.face_package_has_delete);
                    downLoadView.setEnabled(false);
                    return;
                }
            }
            downLoadView.setText(R.string.download);
            SkinManager.setViewTextColor(downLoadView, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(downLoadView, R.drawable.bg_emotion_download);
            downLoadView.setEnabled(true);
        }
    }

    public final void h(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumEmotionPackageData) == null) {
            if (forumEmotionPackageData != null) {
                this.f15112a.getListView().setVisibility(0);
                this.f15112a.getListView().setAdapter((ListAdapter) this.f15112a.getAdapter());
                this.f15112a.getAdapter().a(forumEmotionPackageData.pics, forumEmotionPackageData.forum_id > 0);
                this.f15112a.getListView().setOnItemClickListener(new d(this, forumEmotionPackageData));
                return;
            }
            this.f15112a.getListView().setVisibility(4);
        }
    }

    public final void i(d.a.s0.p0.z.b.b bVar, d.a.s0.p0.z.a.a aVar, int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, bVar, aVar, i2) == null) {
            ViewGroup filterDropDownView = this.f15112a.getFilterDropDownView();
            if (i2 == 0 && bVar != null) {
                Resources resources = this.f15112a.getResources();
                TextView filterView = this.f15112a.getFilterView();
                this.f15112a.getHeaderView().setVisibility(0);
                filterDropDownView.setVisibility(0);
                if (bVar.a() == 0) {
                    string = resources.getString(R.string.forum_emotion_filter_all_bar);
                } else {
                    string = resources.getString(R.string.forum_emotion_filter_my_bar);
                }
                filterView.setText(string);
                if (bVar.b()) {
                    filterDropDownView.setVisibility(0);
                } else {
                    filterDropDownView.setVisibility(8);
                }
                filterView.setOnClickListener(new a(this, bVar, aVar));
                if (filterDropDownView.getChildCount() >= 2) {
                    filterDropDownView.getChildAt(0).setOnClickListener(new b(this, bVar, aVar));
                    filterDropDownView.getChildAt(1).setOnClickListener(new c(this, bVar, aVar));
                    return;
                }
                return;
            }
            this.f15112a.getHeaderView().setVisibility(8);
            filterDropDownView.setVisibility(8);
        }
    }

    public final void j(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, forumEmotionPackageData) == null) {
            if (forumEmotionPackageData != null) {
                this.f15112a.getDownloadNumView().setVisibility(0);
                this.f15112a.getShareNumView().setVisibility(0);
                this.f15112a.getTitleView().setVisibility(0);
                if (!TextUtils.isEmpty(forumEmotionPackageData.forum_name)) {
                    TextView titleView = this.f15112a.getTitleView();
                    titleView.setText(forumEmotionPackageData.forum_name + "吧·" + forumEmotionPackageData.name);
                } else {
                    this.f15112a.getTitleView().setText(forumEmotionPackageData.name);
                }
                this.f15112a.getDownloadNumView().setText(String.format(h.a(R.string.forum_emotion_down_num), StringHelper.numberUniform(forumEmotionPackageData.download)));
                this.f15112a.getShareNumView().setText(String.format(h.a(R.string.forum_emotion_share_num), StringHelper.numberUniform(forumEmotionPackageData.share)));
            } else {
                this.f15112a.getTitleView().setVisibility(4);
                this.f15112a.getDownloadNumView().setVisibility(4);
                this.f15112a.getShareNumView().setVisibility(4);
            }
            this.f15112a.getLineView().setVisibility(forumEmotionPackageData != null ? 0 : 4);
            if (forumEmotionPackageData == null) {
                SkinManager.setBackgroundColor(this.f15112a, R.color.CAM_X0201);
            } else {
                this.f15112a.setBackgroundColor(0);
            }
        }
    }

    public final void k(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forumEmotionPackageData) == null) {
            TextView rankView = this.f15112a.getRankView();
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

    public final void l(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, forumEmotionPackageData) == null) || !ViewHelper.checkUpIsLogin(this.f15113b.getPageActivity()) || forumEmotionPackageData == null || forumEmotionPackageData.id < 0) {
            return;
        }
        if (this.f15115d == null) {
            this.f15115d = new NewFaceGroupDownloadModel();
        }
        this.f15112a.getDownLoadView().setEnabled(false);
        this.f15115d.w(Integer.toString(forumEmotionPackageData.id), Boolean.TRUE, new f(this, forumEmotionPackageData));
    }

    public void m(d.a.s0.p0.z.b.c cVar, d.a.s0.p0.z.b.b bVar, d.a.s0.p0.z.a.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048582, this, cVar, bVar, aVar, i2) == null) {
            this.f15114c = cVar;
            if (this.f15112a == null || cVar == null) {
                return;
            }
            if (cVar.f64604e != null || i2 == 0) {
                i(bVar, aVar, i2);
                h(cVar.f64604e);
                k(cVar.f64604e);
                j(cVar.f64604e);
                g(cVar.f64604e);
            }
        }
    }
}

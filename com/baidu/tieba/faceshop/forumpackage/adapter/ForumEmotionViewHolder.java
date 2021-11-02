package com.baidu.tieba.faceshop.forumpackage.adapter;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import b.a.e.e.p.l;
import b.a.e.e.q.h;
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
/* loaded from: classes9.dex */
public class ForumEmotionViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ForumEmotionItemView f48098a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f48099b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.s0.y.b.c f48100c;

    /* renamed from: d  reason: collision with root package name */
    public NewFaceGroupDownloadModel f48101d;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.s0.y.b.b f48102e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.s0.y.a.a f48103f;

        public a(ForumEmotionViewHolder forumEmotionViewHolder, b.a.r0.s0.y.b.b bVar, b.a.r0.s0.y.a.a aVar) {
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
            this.f48102e = bVar;
            this.f48103f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.r0.s0.y.b.b bVar = this.f48102e;
                bVar.c(!bVar.b());
                b.a.r0.s0.y.a.a aVar = this.f48103f;
                if (aVar != null) {
                    aVar.b();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.s0.y.b.b f48104e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.s0.y.a.a f48105f;

        public b(ForumEmotionViewHolder forumEmotionViewHolder, b.a.r0.s0.y.b.b bVar, b.a.r0.s0.y.a.a aVar) {
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
            this.f48104e = bVar;
            this.f48105f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48104e.c(false);
                this.f48104e.d(0);
                b.a.r0.s0.y.a.a aVar = this.f48105f;
                if (aVar != null) {
                    aVar.a(this.f48104e.a());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.s0.y.b.b f48106e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.s0.y.a.a f48107f;

        public c(ForumEmotionViewHolder forumEmotionViewHolder, b.a.r0.s0.y.b.b bVar, b.a.r0.s0.y.a.a aVar) {
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
            this.f48106e = bVar;
            this.f48107f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48106e.c(false);
                this.f48106e.d(1);
                b.a.r0.s0.y.a.a aVar = this.f48107f;
                if (aVar != null) {
                    aVar.a(this.f48106e.a());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f48108a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionViewHolder f48109b;

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
            this.f48109b = forumEmotionViewHolder;
            this.f48108a = forumEmotionPackageData;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f48109b.f48099b.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.f48109b.f48099b.getPageActivity(), this.f48108a.id, 0)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f48110e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionViewHolder f48111f;

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
            this.f48111f = forumEmotionViewHolder;
            this.f48110e = forumEmotionPackageData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48111f.k(this.f48110e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements b.a.r0.f2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f48112a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionViewHolder f48113b;

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
            this.f48113b = forumEmotionViewHolder;
            this.f48112a = forumEmotionPackageData;
        }

        @Override // b.a.r0.f2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.L(this.f48113b.f48099b.getPageActivity(), R.string.download_error);
                this.f48113b.f48098a.getDownLoadView().setEnabled(true);
            }
        }

        @Override // b.a.r0.f2.e.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (i2 > 0 && i2 < 100) {
                    l.J(this.f48113b.f48099b.getPageActivity(), h.a(R.string.package_downloading_progress));
                } else if (i2 >= 100) {
                    l.I(this.f48113b.f48099b.getPageActivity(), R.string.down_state_success);
                }
            }
        }

        @Override // b.a.r0.f2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                l.L(this.f48113b.f48099b.getPageActivity(), R.string.down_state_success);
                this.f48113b.f48098a.getDownLoadView().setText(R.string.already_downloaded);
                SkinManager.setViewTextColor(this.f48113b.f48098a.getDownLoadView(), R.color.CAM_X0109);
                this.f48113b.f48098a.getDownLoadView().setBackgroundDrawable(null);
                this.f48113b.f48098a.getDownLoadView().setEnabled(false);
                this.f48112a.download++;
                if (this.f48113b.f48100c != null) {
                    ForumEmotionPackageData forumEmotionPackageData = this.f48113b.f48100c.f23479e;
                    ForumEmotionPackageData forumEmotionPackageData2 = this.f48112a;
                    if (forumEmotionPackageData == forumEmotionPackageData2) {
                        this.f48113b.i(forumEmotionPackageData2);
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
        this.f48098a = (ForumEmotionItemView) view;
        this.f48099b = tbPageContext;
    }

    public final void f(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumEmotionPackageData) == null) {
            TextView downLoadView = this.f48098a.getDownLoadView();
            if (forumEmotionPackageData == null) {
                downLoadView.setVisibility(4);
                return;
            }
            downLoadView.setVisibility(0);
            downLoadView.setOnClickListener(new e(this, forumEmotionPackageData));
            b.a.r0.s0.a c2 = b.a.r0.s0.a.c();
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

    public final void g(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumEmotionPackageData) == null) {
            if (forumEmotionPackageData != null) {
                this.f48098a.getListView().setVisibility(0);
                this.f48098a.getListView().setAdapter((ListAdapter) this.f48098a.getAdapter());
                this.f48098a.getAdapter().a(forumEmotionPackageData.pics, forumEmotionPackageData.forum_id > 0);
                this.f48098a.getListView().setOnItemClickListener(new d(this, forumEmotionPackageData));
                return;
            }
            this.f48098a.getListView().setVisibility(4);
        }
    }

    public final void h(b.a.r0.s0.y.b.b bVar, b.a.r0.s0.y.a.a aVar, int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, bVar, aVar, i2) == null) {
            ViewGroup filterDropDownView = this.f48098a.getFilterDropDownView();
            if (i2 == 0 && bVar != null) {
                Resources resources = this.f48098a.getResources();
                TextView filterView = this.f48098a.getFilterView();
                this.f48098a.getHeaderView().setVisibility(0);
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
            this.f48098a.getHeaderView().setVisibility(8);
            filterDropDownView.setVisibility(8);
        }
    }

    public final void i(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, forumEmotionPackageData) == null) {
            if (forumEmotionPackageData != null) {
                this.f48098a.getDownloadNumView().setVisibility(0);
                this.f48098a.getShareNumView().setVisibility(0);
                this.f48098a.getTitleView().setVisibility(0);
                if (!TextUtils.isEmpty(forumEmotionPackageData.forum_name)) {
                    TextView titleView = this.f48098a.getTitleView();
                    titleView.setText(forumEmotionPackageData.forum_name + "吧·" + forumEmotionPackageData.name);
                } else {
                    this.f48098a.getTitleView().setText(forumEmotionPackageData.name);
                }
                this.f48098a.getDownloadNumView().setText(String.format(h.a(R.string.forum_emotion_down_num), StringHelper.numberUniform(forumEmotionPackageData.download)));
                this.f48098a.getShareNumView().setText(String.format(h.a(R.string.forum_emotion_share_num), StringHelper.numberUniform(forumEmotionPackageData.share)));
            } else {
                this.f48098a.getTitleView().setVisibility(4);
                this.f48098a.getDownloadNumView().setVisibility(4);
                this.f48098a.getShareNumView().setVisibility(4);
            }
            this.f48098a.getLineView().setVisibility(forumEmotionPackageData != null ? 0 : 4);
            if (forumEmotionPackageData == null) {
                SkinManager.setBackgroundColor(this.f48098a, R.color.CAM_X0201);
            } else {
                this.f48098a.setBackgroundColor(0);
            }
        }
    }

    public final void j(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forumEmotionPackageData) == null) {
            TextView rankView = this.f48098a.getRankView();
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
        if (!(interceptable == null || interceptable.invokeL(1048581, this, forumEmotionPackageData) == null) || !ViewHelper.checkUpIsLogin(this.f48099b.getPageActivity()) || forumEmotionPackageData == null || forumEmotionPackageData.id < 0) {
            return;
        }
        if (this.f48101d == null) {
            this.f48101d = new NewFaceGroupDownloadModel();
        }
        this.f48098a.getDownLoadView().setEnabled(false);
        this.f48101d.w(Integer.toString(forumEmotionPackageData.id), Boolean.TRUE, new f(this, forumEmotionPackageData));
    }

    public void setData(b.a.r0.s0.y.b.c cVar, b.a.r0.s0.y.b.b bVar, b.a.r0.s0.y.a.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048582, this, cVar, bVar, aVar, i2) == null) {
            this.f48100c = cVar;
            if (this.f48098a == null || cVar == null) {
                return;
            }
            if (cVar.f23479e != null || i2 == 0) {
                h(bVar, aVar, i2);
                g(cVar.f23479e);
                j(cVar.f23479e);
                i(cVar.f23479e);
                f(cVar.f23479e);
            }
        }
    }
}

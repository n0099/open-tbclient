package com.baidu.tieba.faceshop.forumpackage.adapter;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.e.e.q.h;
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
/* loaded from: classes7.dex */
public class ForumEmotionViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ForumEmotionItemView f50726a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f50727b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.s0.y.b.c f50728c;

    /* renamed from: d  reason: collision with root package name */
    public NewFaceGroupDownloadModel f50729d;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s0.y.b.b f50730e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s0.y.a.a f50731f;

        public a(ForumEmotionViewHolder forumEmotionViewHolder, c.a.r0.s0.y.b.b bVar, c.a.r0.s0.y.a.a aVar) {
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
            this.f50730e = bVar;
            this.f50731f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.r0.s0.y.b.b bVar = this.f50730e;
                bVar.c(!bVar.b());
                c.a.r0.s0.y.a.a aVar = this.f50731f;
                if (aVar != null) {
                    aVar.b();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s0.y.b.b f50732e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s0.y.a.a f50733f;

        public b(ForumEmotionViewHolder forumEmotionViewHolder, c.a.r0.s0.y.b.b bVar, c.a.r0.s0.y.a.a aVar) {
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
            this.f50732e = bVar;
            this.f50733f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50732e.c(false);
                this.f50732e.d(0);
                c.a.r0.s0.y.a.a aVar = this.f50733f;
                if (aVar != null) {
                    aVar.a(this.f50732e.a());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s0.y.b.b f50734e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s0.y.a.a f50735f;

        public c(ForumEmotionViewHolder forumEmotionViewHolder, c.a.r0.s0.y.b.b bVar, c.a.r0.s0.y.a.a aVar) {
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
            this.f50734e = bVar;
            this.f50735f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50734e.c(false);
                this.f50734e.d(1);
                c.a.r0.s0.y.a.a aVar = this.f50735f;
                if (aVar != null) {
                    aVar.a(this.f50734e.a());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f50736a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionViewHolder f50737b;

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
            this.f50737b = forumEmotionViewHolder;
            this.f50736a = forumEmotionPackageData;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f50737b.f50727b.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.f50737b.f50727b.getPageActivity(), this.f50736a.id, 0)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f50738e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionViewHolder f50739f;

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
            this.f50739f = forumEmotionViewHolder;
            this.f50738e = forumEmotionPackageData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50739f.k(this.f50738e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements c.a.r0.f2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionPackageData f50740a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumEmotionViewHolder f50741b;

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
            this.f50741b = forumEmotionViewHolder;
            this.f50740a = forumEmotionPackageData;
        }

        @Override // c.a.r0.f2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.L(this.f50741b.f50727b.getPageActivity(), R.string.download_error);
                this.f50741b.f50726a.getDownLoadView().setEnabled(true);
            }
        }

        @Override // c.a.r0.f2.e.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (i2 > 0 && i2 < 100) {
                    l.J(this.f50741b.f50727b.getPageActivity(), h.a(R.string.package_downloading_progress));
                } else if (i2 >= 100) {
                    l.I(this.f50741b.f50727b.getPageActivity(), R.string.down_state_success);
                }
            }
        }

        @Override // c.a.r0.f2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                l.L(this.f50741b.f50727b.getPageActivity(), R.string.down_state_success);
                this.f50741b.f50726a.getDownLoadView().setText(R.string.already_downloaded);
                SkinManager.setViewTextColor(this.f50741b.f50726a.getDownLoadView(), R.color.CAM_X0109);
                this.f50741b.f50726a.getDownLoadView().setBackgroundDrawable(null);
                this.f50741b.f50726a.getDownLoadView().setEnabled(false);
                this.f50740a.download++;
                if (this.f50741b.f50728c != null) {
                    ForumEmotionPackageData forumEmotionPackageData = this.f50741b.f50728c.f24628e;
                    ForumEmotionPackageData forumEmotionPackageData2 = this.f50740a;
                    if (forumEmotionPackageData == forumEmotionPackageData2) {
                        this.f50741b.i(forumEmotionPackageData2);
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
        this.f50726a = (ForumEmotionItemView) view;
        this.f50727b = tbPageContext;
    }

    public final void f(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumEmotionPackageData) == null) {
            TextView downLoadView = this.f50726a.getDownLoadView();
            if (forumEmotionPackageData == null) {
                downLoadView.setVisibility(4);
                return;
            }
            downLoadView.setVisibility(0);
            downLoadView.setOnClickListener(new e(this, forumEmotionPackageData));
            c.a.r0.s0.a c2 = c.a.r0.s0.a.c();
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
                this.f50726a.getListView().setVisibility(0);
                this.f50726a.getListView().setAdapter((ListAdapter) this.f50726a.getAdapter());
                this.f50726a.getAdapter().a(forumEmotionPackageData.pics, forumEmotionPackageData.forum_id > 0);
                this.f50726a.getListView().setOnItemClickListener(new d(this, forumEmotionPackageData));
                return;
            }
            this.f50726a.getListView().setVisibility(4);
        }
    }

    public final void h(c.a.r0.s0.y.b.b bVar, c.a.r0.s0.y.a.a aVar, int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, bVar, aVar, i2) == null) {
            ViewGroup filterDropDownView = this.f50726a.getFilterDropDownView();
            if (i2 == 0 && bVar != null) {
                Resources resources = this.f50726a.getResources();
                TextView filterView = this.f50726a.getFilterView();
                this.f50726a.getHeaderView().setVisibility(0);
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
            this.f50726a.getHeaderView().setVisibility(8);
            filterDropDownView.setVisibility(8);
        }
    }

    public final void i(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, forumEmotionPackageData) == null) {
            if (forumEmotionPackageData != null) {
                this.f50726a.getDownloadNumView().setVisibility(0);
                this.f50726a.getShareNumView().setVisibility(0);
                this.f50726a.getTitleView().setVisibility(0);
                if (!TextUtils.isEmpty(forumEmotionPackageData.forum_name)) {
                    TextView titleView = this.f50726a.getTitleView();
                    titleView.setText(forumEmotionPackageData.forum_name + "吧·" + forumEmotionPackageData.name);
                } else {
                    this.f50726a.getTitleView().setText(forumEmotionPackageData.name);
                }
                this.f50726a.getDownloadNumView().setText(String.format(h.a(R.string.forum_emotion_down_num), StringHelper.numberUniform(forumEmotionPackageData.download)));
                this.f50726a.getShareNumView().setText(String.format(h.a(R.string.forum_emotion_share_num), StringHelper.numberUniform(forumEmotionPackageData.share)));
            } else {
                this.f50726a.getTitleView().setVisibility(4);
                this.f50726a.getDownloadNumView().setVisibility(4);
                this.f50726a.getShareNumView().setVisibility(4);
            }
            this.f50726a.getLineView().setVisibility(forumEmotionPackageData != null ? 0 : 4);
            if (forumEmotionPackageData == null) {
                SkinManager.setBackgroundColor(this.f50726a, R.color.CAM_X0201);
            } else {
                this.f50726a.setBackgroundColor(0);
            }
        }
    }

    public final void j(ForumEmotionPackageData forumEmotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forumEmotionPackageData) == null) {
            TextView rankView = this.f50726a.getRankView();
            if (forumEmotionPackageData != null) {
                rankView.setVisibility(0);
                long j2 = forumEmotionPackageData.rank_num;
                if (j2 > 20) {
                    rankView.setVisibility(8);
                    return;
                } else if (j2 > 3) {
                    rankView.setVisibility(0);
                    rankView.setText(String.valueOf(forumEmotionPackageData.rank_num));
                    SkinManager.setBackgroundResource(rankView, R.drawable.bg_emotion_rank);
                    return;
                } else {
                    rankView.setVisibility(0);
                    rankView.setText("");
                    long j3 = forumEmotionPackageData.rank_num;
                    if (j3 == 3) {
                        SkinManager.setBackgroundResource(rankView, R.drawable.icon_grade_vote_num3);
                        return;
                    } else if (j3 == 2) {
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
        if (!(interceptable == null || interceptable.invokeL(1048581, this, forumEmotionPackageData) == null) || !ViewHelper.checkUpIsLogin(this.f50727b.getPageActivity()) || forumEmotionPackageData == null || forumEmotionPackageData.id < 0) {
            return;
        }
        if (this.f50729d == null) {
            this.f50729d = new NewFaceGroupDownloadModel();
        }
        this.f50726a.getDownLoadView().setEnabled(false);
        this.f50729d.w(Integer.toString(forumEmotionPackageData.id), Boolean.TRUE, new f(this, forumEmotionPackageData));
    }

    public void setData(c.a.r0.s0.y.b.c cVar, c.a.r0.s0.y.b.b bVar, c.a.r0.s0.y.a.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048582, this, cVar, bVar, aVar, i2) == null) {
            this.f50728c = cVar;
            if (this.f50726a == null || cVar == null) {
                return;
            }
            if (cVar.f24628e != null || i2 == 0) {
                h(bVar, aVar, i2);
                g(cVar.f24628e);
                j(cVar.f24628e);
                i(cVar.f24628e);
                f(cVar.f24628e);
            }
        }
    }
}

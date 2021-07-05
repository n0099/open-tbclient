package com.baidu.tieba.faceshop.emotioncenter.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.e.q.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class EmotionHorizontalView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HListView f15057e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15058f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15059g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15060h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f15061i;
    public View j;
    public c k;
    public EmotionPackageData l;
    public TbPageContext m;
    public NewFaceGroupDownloadModel n;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionHorizontalView f15062a;

        public a(EmotionHorizontalView emotionHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15062a = emotionHorizontalView;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f15062a.l == null) {
                return;
            }
            this.f15062a.m.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.f15062a.m.getPageActivity(), this.f15062a.l.id, 0)));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.s0.c2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionHorizontalView f15063a;

        public b(EmotionHorizontalView emotionHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15063a = emotionHorizontalView;
        }

        @Override // d.a.s0.c2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.L(this.f15063a.m.getPageActivity(), R.string.download_error);
                this.f15063a.f15061i.setEnabled(true);
            }
        }

        @Override // d.a.s0.c2.e.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (i2 > 0 && i2 < 100) {
                    l.J(this.f15063a.m.getPageActivity(), h.a(R.string.package_downloading_progress));
                } else if (i2 >= 100) {
                    l.I(this.f15063a.m.getPageActivity(), R.string.down_state_success);
                }
            }
        }

        @Override // d.a.s0.c2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                l.L(this.f15063a.m.getPageActivity(), R.string.down_state_success);
                this.f15063a.f15061i.setText(R.string.already_downloaded);
                SkinManager.setViewTextColor(this.f15063a.f15061i, R.color.CAM_X0109);
                this.f15063a.f15061i.setBackgroundDrawable(null);
                this.f15063a.f15061i.setEnabled(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f15064e;

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext f15065f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f15066g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f15067h;

        /* loaded from: classes5.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public View f15068a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f15069b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f15070c;

            /* renamed from: d  reason: collision with root package name */
            public View f15071d;

            public a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15068a = view;
                view.setEnabled(false);
                this.f15069b = (TbImageView) this.f15068a.findViewById(R.id.emotion_img);
                this.f15070c = (TextView) this.f15068a.findViewById(R.id.emotion_single_bar_icon);
                View findViewById = this.f15068a.findViewById(R.id.emotion_cover_view);
                this.f15071d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{singleEmotionData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f15069b.setDefaultResource(R.drawable.img_default_100);
                    this.f15069b.M(singleEmotionData.thumbnail, 10, false);
                }
                if (z) {
                    this.f15070c.setVisibility(0);
                } else {
                    this.f15070c.setVisibility(8);
                }
                if (i2 == 7 && z2) {
                    this.f15071d.setVisibility(0);
                } else {
                    this.f15071d.setVisibility(8);
                }
            }
        }

        public c(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15064e = new ArrayList();
            this.f15066g = false;
            this.f15067h = false;
            this.f15065f = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f15066g = z;
            if (list.size() > 8) {
                this.f15064e = list.subList(0, 8);
                this.f15067h = true;
            } else {
                this.f15064e = list;
                this.f15067h = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.f15064e;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.f15064e;
                if (list == null) {
                    return null;
                }
                return list.get(i2);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    view = LayoutInflater.from(this.f15065f.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                    aVar = new a(view);
                    view.setTag(aVar);
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.a(this.f15064e.get(i2), i2 == 0 && this.f15066g, this.f15067h, i2);
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionHorizontalView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = tbPageContext;
        e();
    }

    public final void d() {
        EmotionPackageData emotionPackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || !ViewHelper.checkUpIsLogin(this.m.getPageActivity()) || (emotionPackageData = this.l) == null || emotionPackageData.id < 0) {
            return;
        }
        if (this.n == null) {
            this.n = new NewFaceGroupDownloadModel();
        }
        this.f15061i.setEnabled(false);
        this.n.w(Integer.toString(this.l.id), Boolean.TRUE, new b(this));
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.emotion_grid_item_layout, this);
            this.f15057e = (HListView) findViewById(R.id.emotion_item_grid);
            this.f15058f = (TextView) findViewById(R.id.emotion_title_tv);
            this.f15059g = (TextView) findViewById(R.id.emotion_download_num_tv);
            this.f15060h = (TextView) findViewById(R.id.emotion_share_num_tv);
            this.f15061i = (TextView) findViewById(R.id.emotion_download_tv);
            this.j = findViewById(R.id.line);
            this.f15061i.setOnClickListener(this);
            setOnClickListener(this);
            this.f15057e.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
            this.f15057e.setOnItemClickListener(new a(this));
            this.f15057e.setSelector(this.m.getResources().getDrawable(R.drawable.transparent_bg));
            c cVar = new c(this.m);
            this.k = cVar;
            this.f15057e.setAdapter((ListAdapter) cVar);
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setViewTextColor(this.f15058f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f15059g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f15060h, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f15061i, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EmotionPackageData emotionPackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || (emotionPackageData = this.l) == null) {
            return;
        }
        if (view == this.f15061i) {
            d();
        } else if (view == this) {
            this.m.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.m.getPageActivity(), emotionPackageData.id, 0)));
        } else {
            this.m.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.m.getPageActivity(), emotionPackageData.id, 0)));
        }
    }

    public void setData(EmotionPackageData emotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) {
            this.l = emotionPackageData;
            if (emotionPackageData == null) {
                return;
            }
            this.f15057e.setAdapter((ListAdapter) this.k);
            c cVar = this.k;
            EmotionPackageData emotionPackageData2 = this.l;
            cVar.a(emotionPackageData2.pics, emotionPackageData2.forum_id > 0);
            if (!TextUtils.isEmpty(this.l.forum_name)) {
                TextView textView = this.f15058f;
                textView.setText(this.l.forum_name + "·" + this.l.name);
            } else {
                this.f15058f.setText(this.l.name);
            }
            this.f15059g.setText(String.format(h.a(R.string.package_detail_download_num), StringHelper.numberUniform(this.l.download)));
            this.f15060h.setText(String.format(h.a(R.string.package_detail_share_num), StringHelper.numberUniform(this.l.share)));
            d.a.s0.p0.a c2 = d.a.s0.p0.a.c();
            if (c2.e("" + this.l.id)) {
                this.f15061i.setText(R.string.already_downloaded);
                this.f15061i.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(this.f15061i, R.color.CAM_X0109);
                this.f15061i.setBackgroundDrawable(null);
                this.f15061i.setEnabled(false);
                return;
            }
            int i2 = this.l.status;
            if (i2 != 0) {
                if (i2 == 1) {
                    this.f15061i.setText(R.string.download);
                    SkinManager.setViewTextColor(this.f15061i, R.color.CAM_X0302);
                    SkinManager.setBackgroundResource(this.f15061i, R.drawable.bg_emotion_download);
                    this.f15061i.setEnabled(true);
                    return;
                } else if (i2 == 2) {
                    this.f15061i.setBackgroundDrawable(null);
                    SkinManager.setViewTextColor(this.f15061i, R.color.CAM_X0109);
                    this.f15061i.setEnabled(false);
                    return;
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        return;
                    }
                    this.f15061i.setBackgroundDrawable(null);
                    SkinManager.setViewTextColor(this.f15061i, R.color.CAM_X0109);
                    this.f15061i.setText(R.string.face_package_has_delete);
                    this.f15061i.setEnabled(false);
                    return;
                }
            }
            this.f15061i.setText(R.string.download);
            SkinManager.setViewTextColor(this.f15061i, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.f15061i, R.drawable.bg_emotion_download);
            this.f15061i.setEnabled(true);
        }
    }
}

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
import c.a.d.f.p.n;
import c.a.d.f.q.h;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class EmotionHorizontalView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HListView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f32112b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32113c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32114d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f32115e;

    /* renamed from: f  reason: collision with root package name */
    public View f32116f;

    /* renamed from: g  reason: collision with root package name */
    public c f32117g;

    /* renamed from: h  reason: collision with root package name */
    public EmotionPackageData f32118h;
    public TbPageContext i;
    public NewFaceGroupDownloadModel j;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionHorizontalView a;

        public a(EmotionHorizontalView emotionHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionHorizontalView;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.f32118h == null) {
                return;
            }
            this.a.i.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.a.i.getPageActivity(), this.a.f32118h.id, 0)));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.a.p0.r2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionHorizontalView a;

        public b(EmotionHorizontalView emotionHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionHorizontalView;
        }

        @Override // c.a.p0.r2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                n.M(this.a.i.getPageActivity(), R.string.obfuscated_res_0x7f0f04e7);
                this.a.f32115e.setEnabled(true);
            }
        }

        @Override // c.a.p0.r2.e.b
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i > 0 && i < 100) {
                    n.K(this.a.i.getPageActivity(), h.a(R.string.obfuscated_res_0x7f0f0d00));
                } else if (i >= 100) {
                    n.J(this.a.i.getPageActivity(), R.string.obfuscated_res_0x7f0f04e2);
                }
            }
        }

        @Override // c.a.p0.r2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                n.M(this.a.i.getPageActivity(), R.string.obfuscated_res_0x7f0f04e2);
                this.a.f32115e.setText(R.string.obfuscated_res_0x7f0f026f);
                SkinManager.setViewTextColor(this.a.f32115e, (int) R.color.CAM_X0109);
                this.a.f32115e.setBackgroundDrawable(null);
                this.a.f32115e.setEnabled(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<EmotionPackageData.SingleEmotionData> a;

        /* renamed from: b  reason: collision with root package name */
        public TbPageContext f32119b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f32120c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f32121d;

        /* loaded from: classes5.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public View a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f32122b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f32123c;

            /* renamed from: d  reason: collision with root package name */
            public View f32124d;

            public a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = view;
                view.setEnabled(false);
                this.f32122b = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090887);
                this.f32123c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0908ab);
                View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f090874);
                this.f32124d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{singleEmotionData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) || singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f32122b.setDefaultResource(R.drawable.obfuscated_res_0x7f080b75);
                    this.f32122b.J(singleEmotionData.thumbnail, 10, false);
                }
                if (z) {
                    this.f32123c.setVisibility(0);
                } else {
                    this.f32123c.setVisibility(8);
                }
                if (i == 7 && z2) {
                    this.f32124d.setVisibility(0);
                } else {
                    this.f32124d.setVisibility(8);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ArrayList();
            this.f32120c = false;
            this.f32121d = false;
            this.f32119b = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f32120c = z;
            if (list.size() > 8) {
                this.a = list.subList(0, 8);
                this.f32121d = true;
            } else {
                this.a = list;
                this.f32121d = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.a;
                if (list == null) {
                    return null;
                }
                return list.get(i);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view, viewGroup)) == null) {
                if (view == null) {
                    view = LayoutInflater.from(this.f32119b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d025e, (ViewGroup) null);
                    aVar = new a(view);
                    view.setTag(aVar);
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.a(this.a.get(i), i == 0 && this.f32120c, this.f32121d, i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = tbPageContext;
        e();
    }

    public final void d() {
        EmotionPackageData emotionPackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || !ViewHelper.checkUpIsLogin(this.i.getPageActivity()) || (emotionPackageData = this.f32118h) == null || emotionPackageData.id < 0) {
            return;
        }
        if (this.j == null) {
            this.j = new NewFaceGroupDownloadModel();
        }
        this.f32115e.setEnabled(false);
        this.j.y(Integer.toString(this.f32118h.id), Boolean.TRUE, new b(this));
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d025d, this);
            this.a = (HListView) findViewById(R.id.obfuscated_res_0x7f090888);
            this.f32112b = (TextView) findViewById(R.id.obfuscated_res_0x7f0908b3);
            this.f32113c = (TextView) findViewById(R.id.obfuscated_res_0x7f09087c);
            this.f32114d = (TextView) findViewById(R.id.obfuscated_res_0x7f0908aa);
            this.f32115e = (TextView) findViewById(R.id.obfuscated_res_0x7f09087d);
            this.f32116f = findViewById(R.id.obfuscated_res_0x7f091255);
            this.f32115e.setOnClickListener(this);
            setOnClickListener(this);
            this.a.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5));
            this.a.setOnItemClickListener(new a(this));
            this.a.setSelector(this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081200));
            c cVar = new c(this.i);
            this.f32117g = cVar;
            this.a.setAdapter((ListAdapter) cVar);
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            SkinManager.setViewTextColor(this.f32112b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f32113c, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f32114d, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f32115e, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.f32116f, R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EmotionPackageData emotionPackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || (emotionPackageData = this.f32118h) == null) {
            return;
        }
        if (view == this.f32115e) {
            d();
        } else if (view == this) {
            this.i.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.i.getPageActivity(), emotionPackageData.id, 0)));
        } else {
            this.i.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.i.getPageActivity(), emotionPackageData.id, 0)));
        }
    }

    public void setData(EmotionPackageData emotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) {
            this.f32118h = emotionPackageData;
            if (emotionPackageData == null) {
                return;
            }
            this.a.setAdapter((ListAdapter) this.f32117g);
            c cVar = this.f32117g;
            EmotionPackageData emotionPackageData2 = this.f32118h;
            cVar.a(emotionPackageData2.pics, emotionPackageData2.forum_id > 0);
            if (!TextUtils.isEmpty(this.f32118h.forum_name)) {
                TextView textView = this.f32112b;
                textView.setText(this.f32118h.forum_name + "·" + this.f32118h.name);
            } else {
                this.f32112b.setText(this.f32118h.name);
            }
            this.f32113c.setText(String.format(h.a(R.string.obfuscated_res_0x7f0f0cf7), StringHelper.numberUniform(this.f32118h.download)));
            this.f32114d.setText(String.format(h.a(R.string.obfuscated_res_0x7f0f0cfc), StringHelper.numberUniform(this.f32118h.share)));
            c.a.p0.a1.a c2 = c.a.p0.a1.a.c();
            if (c2.e("" + this.f32118h.id)) {
                this.f32115e.setText(R.string.obfuscated_res_0x7f0f026f);
                this.f32115e.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(this.f32115e, (int) R.color.CAM_X0109);
                this.f32115e.setBackgroundDrawable(null);
                this.f32115e.setEnabled(false);
                return;
            }
            int i = this.f32118h.status;
            if (i != 0) {
                if (i == 1) {
                    this.f32115e.setText(R.string.obfuscated_res_0x7f0f04e3);
                    SkinManager.setViewTextColor(this.f32115e, (int) R.color.CAM_X0302);
                    SkinManager.setBackgroundResource(this.f32115e, R.drawable.bg_emotion_download);
                    this.f32115e.setEnabled(true);
                    return;
                } else if (i == 2) {
                    this.f32115e.setBackgroundDrawable(null);
                    SkinManager.setViewTextColor(this.f32115e, (int) R.color.CAM_X0109);
                    this.f32115e.setEnabled(false);
                    return;
                } else if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                    this.f32115e.setBackgroundDrawable(null);
                    SkinManager.setViewTextColor(this.f32115e, (int) R.color.CAM_X0109);
                    this.f32115e.setText(R.string.obfuscated_res_0x7f0f05dc);
                    this.f32115e.setEnabled(false);
                    return;
                }
            }
            this.f32115e.setText(R.string.obfuscated_res_0x7f0f04e3);
            SkinManager.setViewTextColor(this.f32115e, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.f32115e, R.drawable.bg_emotion_download);
            this.f32115e.setEnabled(true);
        }
    }
}

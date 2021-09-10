package com.baidu.tieba.faceshop.emotioncenter.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.e.e.q.h;
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
/* loaded from: classes7.dex */
public class EmotionHorizontalView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HListView f50629e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f50630f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50631g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50632h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f50633i;

    /* renamed from: j  reason: collision with root package name */
    public View f50634j;
    public c k;
    public EmotionPackageData l;
    public TbPageContext m;
    public NewFaceGroupDownloadModel n;

    /* loaded from: classes7.dex */
    public class a implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionHorizontalView f50635a;

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
            this.f50635a = emotionHorizontalView;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f50635a.l == null) {
                return;
            }
            this.f50635a.m.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.f50635a.m.getPageActivity(), this.f50635a.l.id, 0)));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.r0.e2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionHorizontalView f50636a;

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
            this.f50636a = emotionHorizontalView;
        }

        @Override // c.a.r0.e2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.L(this.f50636a.m.getPageActivity(), R.string.download_error);
                this.f50636a.f50633i.setEnabled(true);
            }
        }

        @Override // c.a.r0.e2.e.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (i2 > 0 && i2 < 100) {
                    l.J(this.f50636a.m.getPageActivity(), h.a(R.string.package_downloading_progress));
                } else if (i2 >= 100) {
                    l.I(this.f50636a.m.getPageActivity(), R.string.down_state_success);
                }
            }
        }

        @Override // c.a.r0.e2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                l.L(this.f50636a.m.getPageActivity(), R.string.down_state_success);
                this.f50636a.f50633i.setText(R.string.already_downloaded);
                SkinManager.setViewTextColor(this.f50636a.f50633i, R.color.CAM_X0109);
                this.f50636a.f50633i.setBackgroundDrawable(null);
                this.f50636a.f50633i.setEnabled(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f50637e;

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext f50638f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f50639g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f50640h;

        /* loaded from: classes7.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public View f50641a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f50642b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f50643c;

            /* renamed from: d  reason: collision with root package name */
            public View f50644d;

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
                this.f50641a = view;
                view.setEnabled(false);
                this.f50642b = (TbImageView) this.f50641a.findViewById(R.id.emotion_img);
                this.f50643c = (TextView) this.f50641a.findViewById(R.id.emotion_single_bar_icon);
                View findViewById = this.f50641a.findViewById(R.id.emotion_cover_view);
                this.f50644d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{singleEmotionData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f50642b.setDefaultResource(R.drawable.img_default_100);
                    this.f50642b.startLoad(singleEmotionData.thumbnail, 10, false);
                }
                if (z) {
                    this.f50643c.setVisibility(0);
                } else {
                    this.f50643c.setVisibility(8);
                }
                if (i2 == 7 && z2) {
                    this.f50644d.setVisibility(0);
                } else {
                    this.f50644d.setVisibility(8);
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
            this.f50637e = new ArrayList();
            this.f50639g = false;
            this.f50640h = false;
            this.f50638f = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f50639g = z;
            if (list.size() > 8) {
                this.f50637e = list.subList(0, 8);
                this.f50640h = true;
            } else {
                this.f50637e = list;
                this.f50640h = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.f50637e;
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
                List<EmotionPackageData.SingleEmotionData> list = this.f50637e;
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
                    view = LayoutInflater.from(this.f50638f.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                    aVar = new a(view);
                    view.setTag(aVar);
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.a(this.f50637e.get(i2), i2 == 0 && this.f50639g, this.f50640h, i2);
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
        this.f50633i.setEnabled(false);
        this.n.w(Integer.toString(this.l.id), Boolean.TRUE, new b(this));
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.emotion_grid_item_layout, this);
            this.f50629e = (HListView) findViewById(R.id.emotion_item_grid);
            this.f50630f = (TextView) findViewById(R.id.emotion_title_tv);
            this.f50631g = (TextView) findViewById(R.id.emotion_download_num_tv);
            this.f50632h = (TextView) findViewById(R.id.emotion_share_num_tv);
            this.f50633i = (TextView) findViewById(R.id.emotion_download_tv);
            this.f50634j = findViewById(R.id.line);
            this.f50633i.setOnClickListener(this);
            setOnClickListener(this);
            this.f50629e.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
            this.f50629e.setOnItemClickListener(new a(this));
            this.f50629e.setSelector(this.m.getResources().getDrawable(R.drawable.transparent_bg));
            c cVar = new c(this.m);
            this.k = cVar;
            this.f50629e.setAdapter((ListAdapter) cVar);
        }
    }

    public void onChangeSkin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setViewTextColor(this.f50630f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f50631g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f50632h, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f50633i, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.f50634j, R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EmotionPackageData emotionPackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || (emotionPackageData = this.l) == null) {
            return;
        }
        if (view == this.f50633i) {
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
            this.f50629e.setAdapter((ListAdapter) this.k);
            c cVar = this.k;
            EmotionPackageData emotionPackageData2 = this.l;
            cVar.a(emotionPackageData2.pics, emotionPackageData2.forum_id > 0);
            if (!TextUtils.isEmpty(this.l.forum_name)) {
                TextView textView = this.f50630f;
                textView.setText(this.l.forum_name + "·" + this.l.name);
            } else {
                this.f50630f.setText(this.l.name);
            }
            this.f50631g.setText(String.format(h.a(R.string.package_detail_download_num), StringHelper.numberUniform(this.l.download)));
            this.f50632h.setText(String.format(h.a(R.string.package_detail_share_num), StringHelper.numberUniform(this.l.share)));
            c.a.r0.r0.a c2 = c.a.r0.r0.a.c();
            if (c2.e("" + this.l.id)) {
                this.f50633i.setText(R.string.already_downloaded);
                this.f50633i.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(this.f50633i, R.color.CAM_X0109);
                this.f50633i.setBackgroundDrawable(null);
                this.f50633i.setEnabled(false);
                return;
            }
            int i2 = this.l.status;
            if (i2 != 0) {
                if (i2 == 1) {
                    this.f50633i.setText(R.string.download);
                    SkinManager.setViewTextColor(this.f50633i, R.color.CAM_X0302);
                    SkinManager.setBackgroundResource(this.f50633i, R.drawable.bg_emotion_download);
                    this.f50633i.setEnabled(true);
                    return;
                } else if (i2 == 2) {
                    this.f50633i.setBackgroundDrawable(null);
                    SkinManager.setViewTextColor(this.f50633i, R.color.CAM_X0109);
                    this.f50633i.setEnabled(false);
                    return;
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        return;
                    }
                    this.f50633i.setBackgroundDrawable(null);
                    SkinManager.setViewTextColor(this.f50633i, R.color.CAM_X0109);
                    this.f50633i.setText(R.string.face_package_has_delete);
                    this.f50633i.setEnabled(false);
                    return;
                }
            }
            this.f50633i.setText(R.string.download);
            SkinManager.setViewTextColor(this.f50633i, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.f50633i, R.drawable.bg_emotion_download);
            this.f50633i.setEnabled(true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionHorizontalView(TbPageContext tbPageContext, AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionHorizontalView(TbPageContext tbPageContext, AttributeSet attributeSet, int i2) {
        super(tbPageContext.getPageActivity(), attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        e();
    }
}

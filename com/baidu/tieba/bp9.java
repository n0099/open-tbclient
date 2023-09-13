package com.baidu.tieba;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tieba.ap9;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class bp9 implements QueryMatchEmotionModel.b, ap9.b, EmotionView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext a;
    public List<String> b;
    public HListView c;
    public ap9 d;
    public QueryMatchEmotionModel e;
    public String f;
    public Handler g;
    public ViewGroup h;
    public ViewGroup.LayoutParams i;
    public EditorTools j;
    public GetEmotionPidModel k;
    public Runnable l;

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.b
    public void onFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bp9 a;

        public a(bp9 bp9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bp9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bp9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f = "";
                this.a.c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AbsHListView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bp9 a;

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void a(AbsHListView absHListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absHListView, i, i2, i3) == null) {
            }
        }

        public b(bp9 bp9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bp9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bp9Var;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void b(AbsHListView absHListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absHListView, i) == null) {
                if (i != 0) {
                    if (i == 1) {
                        this.a.g.removeCallbacks(this.a.l);
                        return;
                    }
                    return;
                }
                this.a.g.removeCallbacks(this.a.l);
                this.a.g.postDelayed(this.a.l, 5000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements GetEmotionPidModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionImageData a;
        public final /* synthetic */ bp9 b;

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            }
        }

        public c(bp9 bp9Var, EmotionImageData emotionImageData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bp9Var, emotionImageData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bp9Var;
            this.a = emotionImageData;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(bn5 bn5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bn5Var) == null) && bn5Var != null && !TextUtils.isEmpty(bn5Var.a)) {
                this.a.setPicId(bn5Var.a);
                this.b.n(this.a);
            }
        }
    }

    public bp9(BdPageContext bdPageContext, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, viewGroup, layoutParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.a = bdPageContext;
        this.h = viewGroup;
        this.i = layoutParams;
        this.g = new Handler();
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && !TextUtils.isEmpty(str) && !ListUtils.isEmpty(this.b) && this.b.contains(str)) {
            o(str);
        }
    }

    public void q(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.b = list;
        }
    }

    public void r(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editorTools) == null) {
            this.j = editorTools;
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.b
    public void a(String str, List<EmotionImageData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) && !TextUtils.isEmpty(str) && str.equals(this.f)) {
            if (ListUtils.isEmpty(list)) {
                this.f = "";
            } else if (this.h != null && this.i != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                HListView hListView = this.c;
                if (hListView == null || hListView.getParent() == null) {
                    HListView hListView2 = new HListView(this.a.getContext());
                    this.c = hListView2;
                    SkinManager.setBackgroundColor(hListView2, R.color.CAM_X0201);
                    this.c.setDividerWidth(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070414));
                    this.c.setClipToPadding(false);
                    int dimens = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f07035d);
                    this.c.setPadding(dimens, dimens, dimens, dimens);
                    this.c.setSelector(R.drawable.list_selector_transparent);
                    this.i.height = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070371);
                    this.h.addView(this.c, this.i);
                    if (this.d == null) {
                        ap9 ap9Var = new ap9();
                        this.d = ap9Var;
                        ap9Var.d(this);
                        this.d.c(this);
                        this.c.setAdapter((ListAdapter) this.d);
                        this.c.setOnScrollListener(new b(this));
                    }
                }
                this.c.setVisibility(0);
                this.d.b(list);
                this.d.notifyDataSetChanged();
                this.c.setSelection(0);
                this.g.removeCallbacks(this.l);
                this.g.postDelayed(this.l, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.g.removeCallbacks(this.l);
            this.g.postDelayed(this.l, 5000L);
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g.removeCallbacks(this.l);
        }
    }

    public void l() {
        QueryMatchEmotionModel queryMatchEmotionModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (queryMatchEmotionModel = this.e) != null) {
            queryMatchEmotionModel.cancelLoadData();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            HListView hListView = this.c;
            if (hListView != null) {
                hListView.setVisibility(8);
            }
            this.g.removeCallbacks(this.l);
            this.f = "";
        }
    }

    @Override // com.baidu.tieba.ap9.b
    public void f(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, emotionImageData) == null) {
            this.g.removeCallbacks(this.l);
            this.g.postDelayed(this.l, 5000L);
            if (emotionImageData == null || TextUtils.isEmpty(emotionImageData.getPicUrl()) || this.j == null) {
                return;
            }
            if (!TextUtils.isEmpty(emotionImageData.getPicId()) && !emotionImageData.getPicId().equals("0")) {
                n(emotionImageData);
                return;
            }
            if (this.k == null) {
                this.k = new GetEmotionPidModel();
            }
            this.k.N(emotionImageData.getPicUrl(), new c(this, emotionImageData));
        }
    }

    public final void n(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, emotionImageData) == null) {
            TiebaStatic.log("c12489");
            ed5 ed5Var = new ed5();
            StringBuilder sb = new StringBuilder();
            sb.append(emotionImageData.getPicId());
            sb.append(",");
            sb.append(emotionImageData.getWidth());
            sb.append(",");
            sb.append(emotionImageData.getHeight());
            sb.append(",");
            String lowerCase = ki.c(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT + sb.toString() + UploadedImageInfo.MD5_KEY).toLowerCase();
            ed5Var.n("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + "," + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX);
            ed5Var.q(EmotionGroupType.NET_SUG);
            ed5Var.s(emotionImageData.getWidth());
            ed5Var.l(emotionImageData.getHeight());
            ed5Var.r(emotionImageData.getPicUrl());
            this.j.D(new si5(24, -1, ed5Var));
        }
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && !TextUtils.isEmpty(str) && !str.equals(this.f)) {
            this.f = str;
            if (this.e == null) {
                this.e = new QueryMatchEmotionModel(this.a);
            }
            this.e.P(str, this);
        }
    }
}

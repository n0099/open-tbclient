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
import com.baidu.tieba.ej;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.iq6;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.q98;
import com.baidu.tieba.wj;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionHorizontalView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HListView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public View f;
    public c g;
    public EmotionPackageData h;
    public TbPageContext i;
    public NewFaceGroupDownloadModel j;

    /* loaded from: classes4.dex */
    public static class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<EmotionPackageData.SingleEmotionData> a;
        public TbPageContext b;
        public boolean c;
        public boolean d;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        /* loaded from: classes4.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public View a;
            public TbImageView b;
            public TextView c;
            public View d;

            public a(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = view2;
                view2.setEnabled(false);
                this.b = (TbImageView) this.a.findViewById(R.id.emotion_img);
                this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090966);
                View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f09092c);
                this.d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{singleEmotionData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) != null) || singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.b.setDefaultResource(R.drawable.img_default_100);
                    this.b.K(singleEmotionData.thumbnail, 10, false);
                }
                if (z) {
                    this.c.setVisibility(0);
                } else {
                    this.c.setVisibility(8);
                }
                if (i == 7 && z2) {
                    this.d.setVisibility(0);
                } else {
                    this.d.setVisibility(8);
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
            this.c = false;
            this.d = false;
            this.b = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLZ(1048576, this, list, z) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.c = z;
            if (list.size() > 8) {
                this.a = list.subList(0, 8);
                this.d = true;
            } else {
                this.a = list;
                this.d = false;
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
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            a aVar;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0265, (ViewGroup) null);
                    aVar = new a(view2);
                    view2.setTag(aVar);
                } else {
                    aVar = (a) view2.getTag();
                }
                EmotionPackageData.SingleEmotionData singleEmotionData = this.a.get(i);
                if (i == 0 && this.c) {
                    z = true;
                } else {
                    z = false;
                }
                aVar.a(singleEmotionData, z, this.d, i);
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
        public void a(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.h == null) {
                return;
            }
            this.a.i.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.a.i.getPageActivity(), this.a.h.id, 0)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements q98 {
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

        @Override // com.baidu.tieba.q98
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ej.P(this.a.i.getPageActivity(), R.string.download_error);
                this.a.e.setEnabled(true);
            }
        }

        @Override // com.baidu.tieba.q98
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i > 0 && i < 100) {
                    ej.N(this.a.i.getPageActivity(), wj.a(R.string.obfuscated_res_0x7f0f0e03));
                } else if (i >= 100) {
                    ej.M(this.a.i.getPageActivity(), R.string.down_state_success);
                }
            }
        }

        @Override // com.baidu.tieba.q98
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                ej.P(this.a.i.getPageActivity(), R.string.down_state_success);
                this.a.e.setText(R.string.already_downloaded);
                SkinManager.setViewTextColor(this.a.e, (int) R.color.CAM_X0109);
                this.a.e.setBackgroundDrawable(null);
                this.a.e.setEnabled(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            }
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

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
        }
    }

    public final void d() {
        EmotionPackageData emotionPackageData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && ViewHelper.checkUpIsLogin(this.i.getPageActivity()) && (emotionPackageData = this.h) != null && emotionPackageData.id >= 0) {
            if (this.j == null) {
                this.j = new NewFaceGroupDownloadModel();
            }
            this.e.setEnabled(false);
            this.j.N(Integer.toString(this.h.id), Boolean.TRUE, new b(this));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0264, this);
            this.a = (HListView) findViewById(R.id.obfuscated_res_0x7f090942);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f09096d);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090934);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090965);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f090935);
            this.f = findViewById(R.id.obfuscated_res_0x7f091441);
            this.e.setOnClickListener(this);
            setOnClickListener(this);
            this.a.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5));
            this.a.setOnItemClickListener(new a(this));
            this.a.setSelector(this.i.getResources().getDrawable(R.drawable.transparent_bg));
            c cVar = new c(this.i);
            this.g = cVar;
            this.a.setAdapter((ListAdapter) cVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        EmotionPackageData emotionPackageData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, view2) != null) || (emotionPackageData = this.h) == null) {
            return;
        }
        if (view2 == this.e) {
            d();
        } else if (view2 == this) {
            this.i.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.i.getPageActivity(), emotionPackageData.id, 0)));
        } else {
            this.i.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.i.getPageActivity(), emotionPackageData.id, 0)));
        }
    }

    public void setData(EmotionPackageData emotionPackageData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) {
            this.h = emotionPackageData;
            if (emotionPackageData == null) {
                return;
            }
            this.a.setAdapter((ListAdapter) this.g);
            c cVar = this.g;
            EmotionPackageData emotionPackageData2 = this.h;
            ArrayList<EmotionPackageData.SingleEmotionData> arrayList = emotionPackageData2.pics;
            if (emotionPackageData2.forum_id > 0) {
                z = true;
            } else {
                z = false;
            }
            cVar.a(arrayList, z);
            if (!TextUtils.isEmpty(this.h.forum_name)) {
                TextView textView = this.b;
                textView.setText(this.h.forum_name + "·" + this.h.name);
            } else {
                this.b.setText(this.h.name);
            }
            this.c.setText(String.format(wj.a(R.string.obfuscated_res_0x7f0f0dfa), StringHelper.numberUniform(this.h.download)));
            this.d.setText(String.format(wj.a(R.string.obfuscated_res_0x7f0f0dff), StringHelper.numberUniform(this.h.share)));
            iq6 c2 = iq6.c();
            if (c2.e("" + this.h.id)) {
                this.e.setText(R.string.already_downloaded);
                this.e.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
                this.e.setBackgroundDrawable(null);
                this.e.setEnabled(false);
                return;
            }
            int i = this.h.status;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                this.e.setBackgroundDrawable(null);
                                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
                                this.e.setText(R.string.obfuscated_res_0x7f0f0651);
                                this.e.setEnabled(false);
                                return;
                            }
                            return;
                        }
                    } else {
                        this.e.setBackgroundDrawable(null);
                        SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
                        this.e.setEnabled(false);
                        return;
                    }
                } else {
                    this.e.setText(R.string.obfuscated_res_0x7f0f0533);
                    SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0302);
                    SkinManager.setBackgroundResource(this.e, R.drawable.bg_emotion_download);
                    this.e.setEnabled(true);
                    return;
                }
            }
            this.e.setText(R.string.obfuscated_res_0x7f0f0533);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.e, R.drawable.bg_emotion_download);
            this.e.setEnabled(true);
        }
    }
}

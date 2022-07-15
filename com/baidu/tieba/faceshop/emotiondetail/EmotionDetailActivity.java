package com.baidu.tieba.faceshop.emotiondetail;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.emotiondetail.data.EmotionDetailData;
import com.baidu.tieba.faceshop.emotiondetail.model.EmotionDetailModel;
import com.baidu.tieba.faceshop.emotiondetail.view.EmotionDetailImageView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c9;
import com.repackage.ei;
import com.repackage.i96;
import com.repackage.j96;
import com.repackage.m45;
import com.repackage.mn7;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.p45;
import com.repackage.pi;
import com.repackage.pn7;
import com.repackage.q86;
import com.repackage.um;
import com.repackage.y86;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class EmotionDetailActivity extends BaseActivity<EmotionDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewFaceGroupDownloadModel A;
    public PermissionJudgePolicy B;
    public PopupWindow C;
    public View D;
    public View E;
    public TextView F;
    public TextView G;
    public TextView H;
    public LinearLayout I;
    public boolean J;
    public final CustomMessageListener K;
    public c9 L;
    public NavigationBar a;
    public View b;
    public NoDataView c;
    public NoNetworkView d;
    public View e;
    public View f;
    public View g;
    public TbImageView h;
    public EmotionDetailImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public ImageView n;
    public TextView o;
    public TextView p;
    public ImageView q;
    public View r;
    public View s;
    public View t;
    public View u;
    public int v;
    public long w;
    public boolean x;
    public EmotionDetailModel y;
    public EmotionDetailData z;

    /* loaded from: classes3.dex */
    public class a implements pn7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailActivity a;

        public a(EmotionDetailActivity emotionDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionDetailActivity;
        }

        @Override // com.repackage.pn7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                pi.O(this.a.getPageContext().getPageActivity(), str);
            }
        }

        @Override // com.repackage.pn7
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        @Override // com.repackage.pn7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                pi.N(this.a.getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f1096);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmotionDetailActivity emotionDetailActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && ni.z() && this.a.c != null && this.a.c.getVisibility() == 0) {
                this.a.c.setVisibility(8);
                EmotionDetailActivity emotionDetailActivity = this.a;
                emotionDetailActivity.showLoadingView(emotionDetailActivity.b, false, pi.f(this.a, R.dimen.obfuscated_res_0x7f0702bd));
                this.a.y.C(this.a.w, this.a.v);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailActivity a;

        public c(EmotionDetailActivity emotionDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailActivity a;

        public d(EmotionDetailActivity emotionDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.J) {
                return;
            }
            this.a.Z1();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ EmotionDetailActivity b;

        public e(EmotionDetailActivity emotionDetailActivity, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = emotionDetailActivity;
            this.a = view2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int top = this.a.findViewById(R.id.obfuscated_res_0x7f090def).getTop();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() == 1 && y < top) {
                    this.b.C.dismiss();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends c9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailActivity a;

        public f(EmotionDetailActivity emotionDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionDetailActivity;
        }

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                EmotionDetailActivity emotionDetailActivity = this.a;
                emotionDetailActivity.hideLoadingView(emotionDetailActivity.b);
                this.a.c.setVisibility(8);
                this.a.s.setVisibility(0);
                this.a.r.setVisibility(0);
                this.a.i.setVisibility(0);
                if (obj != null) {
                    this.a.z = (EmotionDetailData) obj;
                    if (this.a.z.pic_info != null && !TextUtils.isEmpty(this.a.z.pic_info.pic_url)) {
                        this.a.i.f(this.a.z, 33, this.a.x);
                    }
                    if (this.a.z.pck_info == null || TextUtils.isEmpty(this.a.z.pck_info.cover)) {
                        this.a.r.setVisibility(8);
                    } else {
                        this.a.h.J(this.a.z.pck_info.cover, 10, false);
                        if (this.a.z.pck_info.forum_name != null) {
                            TextView textView = this.a.k;
                            String string = this.a.getString(R.string.obfuscated_res_0x7f0f0651);
                            textView.setText(String.format(string, this.a.z.pck_info.forum_name + this.a.getString(R.string.obfuscated_res_0x7f0f0650), StringHelper.numFormatOverWan(ng.g(this.a.z.pck_info.download, 0L))));
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                            spannableStringBuilder.append((CharSequence) this.a.getString(R.string.obfuscated_res_0x7f0f053c)).append((CharSequence) " ").append((CharSequence) this.a.z.pck_info.pck_name);
                            spannableStringBuilder.setSpan(new um(this.a.getPageContext().getPageActivity(), (int) R.drawable.obfuscated_res_0x7f0804bc), 0, 2, 17);
                            this.a.j.setText(spannableStringBuilder);
                        } else {
                            this.a.j.setText(this.a.z.pck_info.pck_name);
                            this.a.k.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0651), this.a.z.pck_info.owner.user_name, StringHelper.numFormatOverWan(ng.g(this.a.z.pck_info.download, 0L))));
                        }
                    }
                    q86 c = q86.c();
                    if (c.e("" + this.a.v)) {
                        this.a.l.setText(R.string.obfuscated_res_0x7f0f0275);
                        SkinManager.setViewTextColor(this.a.l, (int) R.color.CAM_X0109);
                        this.a.l.setEnabled(false);
                        SkinManager.setBackgroundColor(this.a.l, R.color.transparent);
                    } else {
                        this.a.l.setText(R.string.obfuscated_res_0x7f0f04f3);
                        SkinManager.setViewTextColor(this.a.l, (int) R.color.CAM_X0302);
                        SkinManager.setBackgroundResource(this.a.l, R.drawable.bg_emotion_download);
                    }
                    if (j96.e().f(StringUtils.string(Long.valueOf(this.a.z.pic_info.pic_id)))) {
                        SkinManager.setImageResource(this.a.m, R.drawable.icon_bar_collectioned);
                        this.a.o.setText(R.string.obfuscated_res_0x7f0f0543);
                        SkinManager.setViewTextColor(this.a.o, (int) R.color.CAM_X0302);
                        return;
                    }
                    SkinManager.setImageResource(this.a.m, R.drawable.icon_bar_collection_emotion);
                    SkinManager.setViewTextColor(this.a.o, (int) R.color.CAM_X0302);
                    return;
                }
                pi.O(this.a.getActivity(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d12));
                this.a.c.setVisibility(0);
                this.a.s.setVisibility(8);
                this.a.r.setVisibility(8);
                this.a.i.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ EmotionDetailActivity b;

        public g(EmotionDetailActivity emotionDetailActivity, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = emotionDetailActivity;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ei.a(this.a.w);
                pi.O(this.b.getPageContext().getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f0446));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements pn7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailActivity a;

        public h(EmotionDetailActivity emotionDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionDetailActivity;
        }

        @Override // com.repackage.pn7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                pi.N(this.a.getActivity(), R.string.obfuscated_res_0x7f0f04f7);
                this.a.l.setEnabled(true);
            }
        }

        @Override // com.repackage.pn7
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i > 0 && i < 100) {
                    pi.L(this.a.getActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0d19));
                } else if (i >= 100) {
                    pi.K(this.a.getActivity(), R.string.obfuscated_res_0x7f0f04f2);
                }
            }
        }

        @Override // com.repackage.pn7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                pi.N(this.a.getActivity(), R.string.obfuscated_res_0x7f0f04f2);
                this.a.l.setText(R.string.obfuscated_res_0x7f0f0275);
                SkinManager.setViewTextColor(this.a.l, (int) R.color.CAM_X0109);
                this.a.l.setEnabled(false);
                SkinManager.setBackgroundColor(this.a.l, R.color.transparent);
                TextView textView = this.a.k;
                String string = this.a.getString(R.string.obfuscated_res_0x7f0f0651);
                textView.setText(String.format(string, this.a.z.pck_info.owner.user_name, StringHelper.numberUniform(ng.g(this.a.z.pck_info.download + 1, 0L))));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921063));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends BdAsyncTask<Void, Void, List<CollectEmotionData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailActivity a;

        /* loaded from: classes3.dex */
        public class a implements i96.l {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            @Override // com.repackage.i96.l
            public void onResult(int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                    if (i2 > 0 && i == 1) {
                        SkinManager.setImageResource(this.a.a.m, R.drawable.icon_bar_collection_emotion);
                        this.a.a.o.setText(R.string.obfuscated_res_0x7f0f0542);
                        pi.N(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f04ad);
                        return;
                    }
                    pi.N(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f04a4);
                }
            }
        }

        public i(EmotionDetailActivity emotionDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<CollectEmotionData> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                List<CollectEmotionData> q = y86.o().q(TbadkCoreApplication.getCurrentAccount());
                if (q == null || q.size() < 1) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<CollectEmotionData> it = q.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CollectEmotionData next = it.next();
                    if (!m45.f.equals(next.getSharpText()) && !TextUtils.isEmpty(next.pid)) {
                        String str = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.collect/" + m45.d() + "/" + next.pid + "_s.jpg";
                        ImageFileInfo imageFileInfo = new ImageFileInfo();
                        imageFileInfo.setFilePath(str);
                        File file = new File(str);
                        if (file.exists() && file.length() > 0 && next.pid.equals(StringUtils.string(Long.valueOf(this.a.w)))) {
                            imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(file.lastModified()));
                            next.imageFileInfo = imageFileInfo;
                            arrayList.add(next);
                            break;
                        }
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<CollectEmotionData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null || list.size() == 0) {
                return;
            }
            i96.t().m(list, true, new a(this));
        }
    }

    /* loaded from: classes3.dex */
    public class j implements i96.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailActivity a;

        public j(EmotionDetailActivity emotionDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionDetailActivity;
        }

        @Override // com.repackage.i96.l
        public void onResult(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) && i == 4) {
                if (i2 == 1) {
                    SkinManager.setImageResource(this.a.m, R.drawable.icon_bar_collectioned);
                    this.a.o.setText(R.string.obfuscated_res_0x7f0f0543);
                    pi.N(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f00d2);
                    return;
                }
                pi.N(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f1091);
            }
        }
    }

    public EmotionDetailActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.K = new b(this, 2000994);
        this.L = new f(this);
    }

    public final void U1() {
        EmotionDetailData.PicInfo picInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (picInfo = this.z.pic_info) == null || TextUtils.isEmpty(picInfo.pic_url)) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 25031)));
        } else if (j96.e().f(StringUtils.string(Long.valueOf(this.z.pic_info.pic_id)))) {
            if (this.C != null) {
                Rect rect = new Rect();
                getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.C.showAtLocation(this.b, 81, 0, getPageContext().getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
            }
        } else {
            EmotionDetailData emotionDetailData = this.z;
            String str = emotionDetailData.pic_info.pic_url;
            EmotionDetailData.PckInfo pckInfo = emotionDetailData.pck_info;
            int i2 = pckInfo == null ? 0 : pckInfo.pck_id;
            p45 p45Var = new p45();
            p45Var.d = str;
            p45Var.f = StringUtils.string(Integer.valueOf(i2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(p45Var);
            i96.t().i(arrayList, true, new j(this));
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            new i(this).execute(new Void[0]);
        }
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity()) && this.v >= 0) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            if (this.A == null) {
                this.A = new NewFaceGroupDownloadModel();
            }
            this.l.setEnabled(false);
            this.A.A(StringUtils.string(Integer.valueOf(this.v)), Boolean.TRUE, new h(this));
        }
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.C = new PopupWindow(getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d024a, (ViewGroup) null);
            this.I = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090def);
            this.D = inflate.findViewById(R.id.obfuscated_res_0x7f0912b2);
            this.E = inflate.findViewById(R.id.obfuscated_res_0x7f0912b3);
            this.F = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09221e);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09221f);
            this.G = textView;
            textView.setOnClickListener(this);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09220d);
            this.H = textView2;
            textView2.setOnClickListener(this);
            this.C.setContentView(inflate);
            this.C.setWidth(-1);
            this.C.setHeight(pi.i(getPageContext().getPageActivity()) - ei.b(getPageContext().getPageActivity()));
            this.C.setFocusable(true);
            this.C.setBackgroundDrawable(new ColorDrawable(this.C.getContentView().getResources().getColor(R.color.black_alpha50)));
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mLayoutInScreen");
                    declaredField.setAccessible(true);
                    declaredField.set(this.C, Boolean.TRUE);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (NoSuchFieldException e3) {
                    e3.printStackTrace();
                }
            }
            inflate.setOnTouchListener(new e(this, inflate));
        }
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = findViewById(R.id.obfuscated_res_0x7f090851);
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, pi.f(this, R.dimen.obfuscated_res_0x7f07026e)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c4c), null);
            this.c = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09158d);
            this.a = navigationBar;
            SkinManager.setViewTextColor(navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0541)), (int) R.color.CAM_X0105);
            this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
            this.d = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f091607);
            if (ni.A()) {
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(0);
            }
            this.d.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.q = new ImageView(getPageContext().getPageActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.q.setPadding(0, pi.f(this, R.dimen.obfuscated_res_0x7f0701d5), pi.f(this, R.dimen.obfuscated_res_0x7f07029d), pi.f(this, R.dimen.obfuscated_res_0x7f0701d5));
            this.q.setLayoutParams(layoutParams);
            this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.q, this);
            this.i = (EmotionDetailImageView) findViewById(R.id.obfuscated_res_0x7f090852);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f090855);
            this.r = findViewById;
            findViewById.setOnClickListener(new d(this));
            this.s = findViewById(R.id.obfuscated_res_0x7f090850);
            this.e = findViewById(R.id.obfuscated_res_0x7f0907b7);
            this.f = findViewById(R.id.obfuscated_res_0x7f0907b9);
            this.g = findViewById(R.id.obfuscated_res_0x7f0906c8);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09087e);
            this.h = tbImageView;
            tbImageView.setGifIconSupport(false);
            this.t = findViewById(R.id.obfuscated_res_0x7f091b34);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f09127a);
            this.u = findViewById2;
            findViewById2.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f090102);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f090105);
            this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f091c74);
            this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f091c75);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090853);
            this.k = textView;
            textView.setOnClickListener(null);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f090880);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f090857);
            this.l = textView2;
            textView2.setOnClickListener(this);
            X1();
        }
    }

    public final void Z1() {
        EmotionDetailData emotionDetailData;
        EmotionDetailData.PckInfo pckInfo;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (emotionDetailData = this.z) == null || (pckInfo = emotionDetailData.pck_info) == null || (i2 = pckInfo.pck_id) <= 0) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this, i2, 25024)));
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.B == null) {
                this.B = new PermissionJudgePolicy();
            }
            this.B.clearRequestPermissionList();
            this.B.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.B.startRequestPermission(pageActivity)) {
                return;
            }
            String str = this.z.pic_info.pic_url;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            mn7.i().d(str, new a(this));
        }
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
            if (this.z == null) {
                return;
            }
            ShareItem shareItem = new ShareItem();
            EmotionDetailData.PicInfo picInfo = this.z.pic_info;
            if (picInfo != null && !StringUtils.isNull(picInfo.pic_url)) {
                shareItem.y = Uri.parse(this.z.pic_info.pic_url);
            }
            EmotionDetailData.PckInfo pckInfo = this.z.pck_info;
            if (pckInfo != null && !StringUtils.isNull(pckInfo.pck_name)) {
                shareItem.u = this.z.pck_info.pck_name;
            } else {
                shareItem.u = getString(R.string.obfuscated_res_0x7f0f13f6);
            }
            shareItem.v = getString(R.string.obfuscated_res_0x7f0f0d1a);
            shareItem.w = "https://tieba.baidu.com/n/interact/emoticon/" + this.v + "/" + this.z.pic_info.pic_id;
            shareItem.g0 = 2;
            shareItem.o = true;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new g(this, shareItem));
            sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.changeSkinType(i2);
            this.mSkinType = i2;
            this.c.f(getPageContext(), i2);
            this.d.d(getPageContext(), i2);
            SkinManager.setImageResource(this.n, R.drawable.icon_bar_download);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.I, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.D, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.E, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.G, (int) R.color.cp_cont_r);
            SkinManager.setViewTextColor(this.H, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.F, (int) R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.obfuscated_res_0x7f0809e6, R.color.CAM_X0105, null);
            if (i2 != 1 && i2 != 4) {
                SkinManager.setBackgroundColor(this.s, R.color.white_alpha100, i2);
            } else {
                SkinManager.setBackgroundColor(this.s, R.color.common_color_10311, i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            setResult(-1);
            super.finish();
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.y == null) {
                this.y = new EmotionDetailModel();
            }
            this.y.setLoadDataCallBack(this.L);
            this.y.C(this.w, this.v);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048587, this, i2, i3, intent) == null) && i3 == -1 && i2 == 25031) {
            U1();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            super.onClick(view2);
            if (ni.z()) {
                if (view2 == this.t) {
                    a2();
                } else if (view2 == this.u) {
                    U1();
                } else if (view2 == this.l) {
                    W1();
                } else if (view2 == this.H) {
                    this.C.dismiss();
                } else if (view2 == this.G) {
                    V1();
                    this.C.dismiss();
                } else if (view2 == this.q) {
                    b2();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            this.w = getIntent().getLongExtra(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, -1L);
            this.v = getIntent().getIntExtra("pck_id", -1);
            this.x = getIntent().getBooleanExtra(EmotionDetailActivityConfig.EMOTION_IS_GIF_KEY, false);
            this.J = getIntent().getBooleanExtra(EmotionDetailActivityConfig.EMOTION_FROM_PACKAGE, false);
            if (this.w < 0 && this.v < 0) {
                finish();
            }
            setContentView(R.layout.obfuscated_res_0x7f0d0249);
            Y1();
            showLoadingView(this.b, false, pi.f(this, R.dimen.obfuscated_res_0x7f0702bd));
            initData();
            registerListener(this.K);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            EmotionDetailModel emotionDetailModel = this.y;
            if (emotionDetailModel != null) {
                emotionDetailModel.cancelLoadData();
            }
            NewFaceGroupDownloadModel newFaceGroupDownloadModel = this.A;
            if (newFaceGroupDownloadModel != null) {
                newFaceGroupDownloadModel.cancelLoadData();
            }
        }
    }
}

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
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tieba.dh;
import com.baidu.tieba.ej;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.emotiondetail.data.EmotionDetailData;
import com.baidu.tieba.faceshop.emotiondetail.model.EmotionDetailModel;
import com.baidu.tieba.faceshop.emotiondetail.view.EmotionDetailImageView;
import com.baidu.tieba.i85;
import com.baidu.tieba.jd6;
import com.baidu.tieba.kd6;
import com.baidu.tieba.kn;
import com.baidu.tieba.kr7;
import com.baidu.tieba.l85;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.nr7;
import com.baidu.tieba.q9;
import com.baidu.tieba.rc6;
import com.baidu.tieba.ui;
import com.baidu.tieba.zc6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionDetailActivity extends BaseActivity<EmotionDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EmotionDetailData A;
    public NewFaceGroupDownloadModel B;
    public PermissionJudgePolicy C;
    public PopupWindow D;
    public View E;
    public View F;
    public TextView G;
    public TextView H;
    public TextView I;
    public LinearLayout J;
    public boolean K;
    public final CustomMessageListener L;
    public q9 M;
    public final String a;
    public NavigationBar b;
    public View c;
    public NoDataView d;
    public NoNetworkView e;
    public View f;
    public View g;
    public View h;
    public TbImageView i;
    public EmotionDetailImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public ImageView n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public ImageView r;
    public View s;
    public View t;
    public View u;
    public View v;
    public int w;
    public long x;
    public boolean y;
    public EmotionDetailModel z;

    /* loaded from: classes4.dex */
    public class a implements nr7 {
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

        @Override // com.baidu.tieba.nr7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ej.N(this.a.getPageContext().getPageActivity(), str);
            }
        }

        @Override // com.baidu.tieba.nr7
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.nr7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                ej.M(this.a.getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f10ac);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && BdNetTypeUtil.isNetWorkAvailable() && this.a.d != null && this.a.d.getVisibility() == 0) {
                this.a.d.setVisibility(8);
                EmotionDetailActivity emotionDetailActivity = this.a;
                emotionDetailActivity.showLoadingView(emotionDetailActivity.c, false, ej.f(this.a, R.dimen.obfuscated_res_0x7f0702bb));
                this.a.z.B(this.a.x, this.a.w);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.K) {
                return;
            }
            this.a.Y1();
        }
    }

    /* loaded from: classes4.dex */
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
                int top = this.a.findViewById(R.id.obfuscated_res_0x7f090e4e).getTop();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() == 1 && y < top) {
                    this.b.D.dismiss();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f extends q9 {
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

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                EmotionDetailActivity emotionDetailActivity = this.a;
                emotionDetailActivity.hideLoadingView(emotionDetailActivity.c);
                this.a.d.setVisibility(8);
                this.a.t.setVisibility(0);
                this.a.s.setVisibility(0);
                this.a.j.setVisibility(0);
                if (obj != null) {
                    this.a.A = (EmotionDetailData) obj;
                    if (this.a.A.pic_info != null && !TextUtils.isEmpty(this.a.A.pic_info.pic_url)) {
                        this.a.j.f(this.a.A, 33, this.a.y);
                    }
                    if (this.a.A.pck_info == null || TextUtils.isEmpty(this.a.A.pck_info.cover)) {
                        this.a.s.setVisibility(8);
                    } else {
                        this.a.i.K(this.a.A.pck_info.cover, 10, false);
                        if (this.a.A.pck_info.forum_name != null) {
                            TextView textView = this.a.l;
                            String string = this.a.getString(R.string.obfuscated_res_0x7f0f066f);
                            textView.setText(String.format(string, this.a.A.pck_info.forum_name + this.a.getString(R.string.obfuscated_res_0x7f0f066e), StringHelper.numFormatOverWan(dh.g(this.a.A.pck_info.download, 0L))));
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                            spannableStringBuilder.append((CharSequence) this.a.getString(R.string.obfuscated_res_0x7f0f0553)).append((CharSequence) " ").append((CharSequence) this.a.A.pck_info.pck_name);
                            spannableStringBuilder.setSpan(new kn(this.a.getPageContext().getPageActivity(), (int) R.drawable.obfuscated_res_0x7f0804d2), 0, 2, 17);
                            this.a.k.setText(spannableStringBuilder);
                        } else {
                            this.a.k.setText(this.a.A.pck_info.pck_name);
                            this.a.l.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f066f), this.a.A.pck_info.owner.user_name, StringHelper.numFormatOverWan(dh.g(this.a.A.pck_info.download, 0L))));
                        }
                    }
                    rc6 c = rc6.c();
                    if (c.e("" + this.a.w)) {
                        this.a.m.setText(R.string.obfuscated_res_0x7f0f027e);
                        SkinManager.setViewTextColor(this.a.m, (int) R.color.CAM_X0109);
                        this.a.m.setEnabled(false);
                        SkinManager.setBackgroundColor(this.a.m, R.color.transparent);
                    } else {
                        this.a.m.setText(R.string.obfuscated_res_0x7f0f0509);
                        SkinManager.setViewTextColor(this.a.m, (int) R.color.CAM_X0302);
                        SkinManager.setBackgroundResource(this.a.m, R.drawable.bg_emotion_download);
                    }
                    if (kd6.e().f(StringUtils.string(Long.valueOf(this.a.A.pic_info.pic_id)))) {
                        SkinManager.setImageResource(this.a.n, R.drawable.icon_bar_collectioned);
                        this.a.p.setText(R.string.obfuscated_res_0x7f0f055a);
                        SkinManager.setViewTextColor(this.a.p, (int) R.color.CAM_X0302);
                        return;
                    }
                    SkinManager.setImageResource(this.a.n, R.drawable.icon_bar_collection_emotion);
                    SkinManager.setViewTextColor(this.a.p, (int) R.color.CAM_X0302);
                    return;
                }
                ej.N(this.a.getActivity(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d42));
                this.a.d.setVisibility(0);
                this.a.t.setVisibility(8);
                this.a.s.setVisibility(8);
                this.a.j.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                ui.a(this.a.x);
                ej.N(this.b.getPageContext().getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f0455));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements nr7 {
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

        @Override // com.baidu.tieba.nr7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ej.M(this.a.getActivity(), R.string.obfuscated_res_0x7f0f050d);
                this.a.m.setEnabled(true);
            }
        }

        @Override // com.baidu.tieba.nr7
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i > 0 && i < 100) {
                    ej.K(this.a.getActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0d49));
                } else if (i >= 100) {
                    ej.J(this.a.getActivity(), R.string.obfuscated_res_0x7f0f0508);
                }
            }
        }

        @Override // com.baidu.tieba.nr7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                ej.M(this.a.getActivity(), R.string.obfuscated_res_0x7f0f0508);
                this.a.m.setText(R.string.obfuscated_res_0x7f0f027e);
                SkinManager.setViewTextColor(this.a.m, (int) R.color.CAM_X0109);
                this.a.m.setEnabled(false);
                SkinManager.setBackgroundColor(this.a.m, R.color.transparent);
                TextView textView = this.a.l;
                String string = this.a.getString(R.string.obfuscated_res_0x7f0f066f);
                textView.setText(String.format(string, this.a.A.pck_info.owner.user_name, StringHelper.numberUniform(dh.g(this.a.A.pck_info.download + 1, 0L))));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921063));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends BdAsyncTask<Void, Void, List<CollectEmotionData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailActivity a;

        /* loaded from: classes4.dex */
        public class a implements jd6.l {
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

            @Override // com.baidu.tieba.jd6.l
            public void onResult(int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                    if (i2 > 0 && i == 1) {
                        SkinManager.setImageResource(this.a.a.n, R.drawable.icon_bar_collection_emotion);
                        this.a.a.p.setText(R.string.obfuscated_res_0x7f0f0559);
                        ej.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f04be);
                        return;
                    }
                    ej.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f04b5);
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
                List<CollectEmotionData> q = zc6.o().q(TbadkCoreApplication.getCurrentAccount());
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
                    if (!i85.f.equals(next.getSharpText()) && !TextUtils.isEmpty(next.pid)) {
                        String str = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.collect/" + i85.d() + "/" + next.pid + "_s.jpg";
                        ImageFileInfo imageFileInfo = new ImageFileInfo();
                        imageFileInfo.setFilePath(str);
                        File file = new File(str);
                        if (file.exists() && file.length() > 0 && next.pid.equals(StringUtils.string(Long.valueOf(this.a.x)))) {
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
            jd6.t().m(list, true, new a(this));
        }
    }

    /* loaded from: classes4.dex */
    public class j implements jd6.l {
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

        @Override // com.baidu.tieba.jd6.l
        public void onResult(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) && i == 4) {
                if (i2 == 1) {
                    SkinManager.setImageResource(this.a.n, R.drawable.icon_bar_collectioned);
                    this.a.p.setText(R.string.obfuscated_res_0x7f0f055a);
                    ej.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f00d4);
                    return;
                }
                ej.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f10a6);
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
        this.a = TbConfig.TIEBA_ADDRESS + "n/interact/emoticon/";
        this.L = new b(this, 2000994);
        this.M = new f(this);
    }

    public final void T1() {
        EmotionDetailData.PicInfo picInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (picInfo = this.A.pic_info) == null || TextUtils.isEmpty(picInfo.pic_url)) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 25031)));
        } else if (kd6.e().f(StringUtils.string(Long.valueOf(this.A.pic_info.pic_id)))) {
            if (this.D != null) {
                Rect rect = new Rect();
                getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.D.showAtLocation(this.c, 81, 0, getPageContext().getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
            }
        } else {
            EmotionDetailData emotionDetailData = this.A;
            String str = emotionDetailData.pic_info.pic_url;
            EmotionDetailData.PckInfo pckInfo = emotionDetailData.pck_info;
            int i2 = pckInfo == null ? 0 : pckInfo.pck_id;
            l85 l85Var = new l85();
            l85Var.d = str;
            l85Var.f = StringUtils.string(Integer.valueOf(i2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(l85Var);
            jd6.t().i(arrayList, true, new j(this));
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            new i(this).execute(new Void[0]);
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity()) && this.w >= 0) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            if (this.B == null) {
                this.B = new NewFaceGroupDownloadModel();
            }
            this.m.setEnabled(false);
            this.B.z(StringUtils.string(Integer.valueOf(this.w)), Boolean.TRUE, new h(this));
        }
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.D = new PopupWindow(getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0251, (ViewGroup) null);
            this.J = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090e4e);
            this.E = inflate.findViewById(R.id.obfuscated_res_0x7f091308);
            this.F = inflate.findViewById(R.id.obfuscated_res_0x7f091309);
            this.G = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092386);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092387);
            this.H = textView;
            textView.setOnClickListener(this);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092375);
            this.I = textView2;
            textView2.setOnClickListener(this);
            this.D.setContentView(inflate);
            this.D.setWidth(-1);
            this.D.setHeight(ej.i(getPageContext().getPageActivity()) - ui.b(getPageContext().getPageActivity()));
            this.D.setFocusable(true);
            this.D.setBackgroundDrawable(new ColorDrawable(this.D.getContentView().getResources().getColor(R.color.black_alpha50)));
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mLayoutInScreen");
                    declaredField.setAccessible(true);
                    declaredField.set(this.D, Boolean.TRUE);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (NoSuchFieldException e3) {
                    e3.printStackTrace();
                }
            }
            inflate.setOnTouchListener(new e(this, inflate));
        }
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = findViewById(R.id.obfuscated_res_0x7f09089c);
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, ej.f(this, R.dimen.obfuscated_res_0x7f07026c)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c7a), null);
            this.d = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091657);
            this.b = navigationBar;
            SkinManager.setViewTextColor(navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0558)), (int) R.color.CAM_X0105);
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
            this.e = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f0916dc);
            if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
            }
            this.e.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.r = new ImageView(getPageContext().getPageActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.r.setPadding(0, ej.f(this, R.dimen.obfuscated_res_0x7f0701d5), ej.f(this, R.dimen.obfuscated_res_0x7f07029b), ej.f(this, R.dimen.obfuscated_res_0x7f0701d5));
            this.r.setLayoutParams(layoutParams);
            this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.r, this);
            this.j = (EmotionDetailImageView) findViewById(R.id.obfuscated_res_0x7f09089d);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0908a0);
            this.s = findViewById;
            findViewById.setOnClickListener(new d(this));
            this.t = findViewById(R.id.obfuscated_res_0x7f09089b);
            this.f = findViewById(R.id.obfuscated_res_0x7f0907f9);
            this.g = findViewById(R.id.obfuscated_res_0x7f0907fb);
            this.h = findViewById(R.id.obfuscated_res_0x7f0906fc);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0908c9);
            this.i = tbImageView;
            tbImageView.setGifIconSupport(false);
            this.u = findViewById(R.id.obfuscated_res_0x7f091c3a);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f0912d0);
            this.v = findViewById2;
            findViewById2.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f09010b);
            this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f09010e);
            this.o = (ImageView) findViewById(R.id.obfuscated_res_0x7f091db4);
            this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f091db5);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09089e);
            this.l = textView;
            textView.setOnClickListener(null);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f0908cb);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f0908a2);
            this.m = textView2;
            textView2.setOnClickListener(this);
            W1();
        }
    }

    public final void Y1() {
        EmotionDetailData emotionDetailData;
        EmotionDetailData.PckInfo pckInfo;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (emotionDetailData = this.A) == null || (pckInfo = emotionDetailData.pck_info) == null || (i2 = pckInfo.pck_id) <= 0) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this, i2, 25024)));
    }

    public final void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.C == null) {
                this.C = new PermissionJudgePolicy();
            }
            this.C.clearRequestPermissionList();
            this.C.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.C.startRequestPermission(pageActivity)) {
                return;
            }
            String str = this.A.pic_info.pic_url;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            kr7.i().d(str, new a(this));
        }
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
            if (this.A == null) {
                return;
            }
            ShareItem shareItem = new ShareItem();
            EmotionDetailData.PicInfo picInfo = this.A.pic_info;
            if (picInfo != null && !StringUtils.isNull(picInfo.pic_url)) {
                shareItem.z = Uri.parse(this.A.pic_info.pic_url);
            }
            EmotionDetailData.PckInfo pckInfo = this.A.pck_info;
            if (pckInfo != null && !StringUtils.isNull(pckInfo.pck_name)) {
                shareItem.v = this.A.pck_info.pck_name;
            } else {
                shareItem.v = getString(R.string.obfuscated_res_0x7f0f1406);
            }
            shareItem.w = getString(R.string.obfuscated_res_0x7f0f0d4a);
            shareItem.x = this.a + this.w + "/" + this.A.pic_info.pic_id;
            shareItem.h0 = 2;
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
            this.d.f(getPageContext(), i2);
            this.e.d(getPageContext(), i2);
            SkinManager.setImageResource(this.o, R.drawable.icon_bar_download);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.J, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.E, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.F, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.H, (int) R.color.cp_cont_r);
            SkinManager.setViewTextColor(this.I, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.G, (int) R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, R.drawable.obfuscated_res_0x7f080a27, R.color.CAM_X0105, null);
            if (i2 != 1 && i2 != 4) {
                SkinManager.setBackgroundColor(this.t, R.color.white_alpha100, i2);
            } else {
                SkinManager.setBackgroundColor(this.t, R.color.common_color_10311, i2);
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
            if (this.z == null) {
                this.z = new EmotionDetailModel();
            }
            this.z.setLoadDataCallBack(this.M);
            this.z.B(this.x, this.w);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048587, this, i2, i3, intent) == null) && i3 == -1 && i2 == 25031) {
            T1();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            super.onClick(view2);
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                if (view2 == this.u) {
                    Z1();
                } else if (view2 == this.v) {
                    T1();
                } else if (view2 == this.m) {
                    V1();
                } else if (view2 == this.I) {
                    this.D.dismiss();
                } else if (view2 == this.H) {
                    U1();
                    this.D.dismiss();
                } else if (view2 == this.r) {
                    a2();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            this.x = getIntent().getLongExtra(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, -1L);
            this.w = getIntent().getIntExtra("pck_id", -1);
            this.y = getIntent().getBooleanExtra(EmotionDetailActivityConfig.EMOTION_IS_GIF_KEY, false);
            this.K = getIntent().getBooleanExtra(EmotionDetailActivityConfig.EMOTION_FROM_PACKAGE, false);
            if (this.x < 0 && this.w < 0) {
                finish();
            }
            setContentView(R.layout.obfuscated_res_0x7f0d0250);
            X1();
            showLoadingView(this.c, false, ej.f(this, R.dimen.obfuscated_res_0x7f0702bb));
            initData();
            registerListener(this.L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            EmotionDetailModel emotionDetailModel = this.z;
            if (emotionDetailModel != null) {
                emotionDetailModel.cancelLoadData();
            }
            NewFaceGroupDownloadModel newFaceGroupDownloadModel = this.B;
            if (newFaceGroupDownloadModel != null) {
                newFaceGroupDownloadModel.cancelLoadData();
            }
        }
    }
}

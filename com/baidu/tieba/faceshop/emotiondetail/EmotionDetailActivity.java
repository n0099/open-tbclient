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
import com.baidu.tieba.eh;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.emotiondetail.data.EmotionDetailData;
import com.baidu.tieba.faceshop.emotiondetail.model.EmotionDetailModel;
import com.baidu.tieba.faceshop.emotiondetail.view.EmotionDetailImageView;
import com.baidu.tieba.fj;
import com.baidu.tieba.gd6;
import com.baidu.tieba.ln;
import com.baidu.tieba.m85;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.p85;
import com.baidu.tieba.q9;
import com.baidu.tieba.qd6;
import com.baidu.tieba.rd6;
import com.baidu.tieba.vi;
import com.baidu.tieba.vr7;
import com.baidu.tieba.yc6;
import com.baidu.tieba.yr7;
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
public class EmotionDetailActivity extends BaseActivity {
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
    public class i extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailActivity a;

        /* loaded from: classes4.dex */
        public class a implements qd6.l {
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

            @Override // com.baidu.tieba.qd6.l
            public void onResult(int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                    if (i2 > 0 && i == 1) {
                        SkinManager.setImageResource(this.a.a.n, R.drawable.icon_bar_collection_emotion);
                        this.a.a.p.setText(R.string.obfuscated_res_0x7f0f0561);
                        fj.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f04c6);
                        return;
                    }
                    fj.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f04bd);
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
        /* renamed from: c */
        public void onPostExecute(List list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && list != null && list.size() != 0) {
                qd6.t().m(list, true, new a(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                List q = gd6.o().q(TbadkCoreApplication.getCurrentAccount());
                if (q != null && q.size() >= 1) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = q.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        CollectEmotionData collectEmotionData = (CollectEmotionData) it.next();
                        if (!m85.f.equals(collectEmotionData.getSharpText()) && !TextUtils.isEmpty(collectEmotionData.pid)) {
                            String str = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.collect/" + m85.d() + "/" + collectEmotionData.pid + "_s.jpg";
                            ImageFileInfo imageFileInfo = new ImageFileInfo();
                            imageFileInfo.setFilePath(str);
                            File file = new File(str);
                            if (file.exists() && file.length() > 0 && collectEmotionData.pid.equals(StringUtils.string(Long.valueOf(this.a.x)))) {
                                imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(file.lastModified()));
                                collectEmotionData.imageFileInfo = imageFileInfo;
                                arrayList.add(collectEmotionData);
                                break;
                            }
                        }
                    }
                    return arrayList;
                }
                return null;
            }
            return (List) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements yr7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailActivity a;

        @Override // com.baidu.tieba.yr7
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

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

        @Override // com.baidu.tieba.yr7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                fj.N(this.a.getPageContext().getPageActivity(), str);
            }
        }

        @Override // com.baidu.tieba.yr7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                fj.M(this.a.getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f10bf);
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && BdNetTypeUtil.isNetWorkAvailable() && this.a.d != null && this.a.d.getVisibility() == 0) {
                this.a.d.setVisibility(8);
                EmotionDetailActivity emotionDetailActivity = this.a;
                emotionDetailActivity.showLoadingView(emotionDetailActivity.c, false, fj.f(this.a, R.dimen.obfuscated_res_0x7f0702bb));
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.K) {
                return;
            }
            this.a.X1();
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
                int top = this.a.findViewById(R.id.obfuscated_res_0x7f090e42).getTop();
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
                if (obj == null) {
                    fj.N(this.a.getActivity(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d53));
                    this.a.d.setVisibility(0);
                    this.a.t.setVisibility(8);
                    this.a.s.setVisibility(8);
                    this.a.j.setVisibility(8);
                    return;
                }
                this.a.A = (EmotionDetailData) obj;
                if (this.a.A.pic_info != null && !TextUtils.isEmpty(this.a.A.pic_info.pic_url)) {
                    this.a.j.f(this.a.A, 33, this.a.y);
                }
                if (this.a.A.pck_info != null && !TextUtils.isEmpty(this.a.A.pck_info.cover)) {
                    this.a.i.L(this.a.A.pck_info.cover, 10, false);
                    if (this.a.A.pck_info.forum_name != null) {
                        TextView textView = this.a.l;
                        String string = this.a.getString(R.string.obfuscated_res_0x7f0f0678);
                        textView.setText(String.format(string, this.a.A.pck_info.forum_name + this.a.getString(R.string.obfuscated_res_0x7f0f0677), StringHelper.numFormatOverWan(eh.g(this.a.A.pck_info.download, 0L))));
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append((CharSequence) this.a.getString(R.string.obfuscated_res_0x7f0f055b)).append((CharSequence) " ").append((CharSequence) this.a.A.pck_info.pck_name);
                        spannableStringBuilder.setSpan(new ln(this.a.getPageContext().getPageActivity(), (int) R.drawable.obfuscated_res_0x7f0804d2), 0, 2, 17);
                        this.a.k.setText(spannableStringBuilder);
                    } else {
                        this.a.k.setText(this.a.A.pck_info.pck_name);
                        this.a.l.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0678), this.a.A.pck_info.owner.user_name, StringHelper.numFormatOverWan(eh.g(this.a.A.pck_info.download, 0L))));
                    }
                } else {
                    this.a.s.setVisibility(8);
                }
                yc6 c = yc6.c();
                if (c.e("" + this.a.w)) {
                    this.a.m.setText(R.string.obfuscated_res_0x7f0f027e);
                    SkinManager.setViewTextColor(this.a.m, (int) R.color.CAM_X0109);
                    this.a.m.setEnabled(false);
                    SkinManager.setBackgroundColor(this.a.m, R.color.transparent);
                } else {
                    this.a.m.setText(R.string.obfuscated_res_0x7f0f0511);
                    SkinManager.setViewTextColor(this.a.m, (int) R.color.CAM_X0302);
                    SkinManager.setBackgroundResource(this.a.m, R.drawable.bg_emotion_download);
                }
                if (rd6.e().f(StringUtils.string(Long.valueOf(this.a.A.pic_info.pic_id)))) {
                    SkinManager.setImageResource(this.a.n, R.drawable.icon_bar_collectioned);
                    this.a.p.setText(R.string.obfuscated_res_0x7f0f0562);
                    SkinManager.setViewTextColor(this.a.p, (int) R.color.CAM_X0302);
                    return;
                }
                SkinManager.setImageResource(this.a.n, R.drawable.icon_bar_collection_emotion);
                SkinManager.setViewTextColor(this.a.p, (int) R.color.CAM_X0302);
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
                vi.a(this.a.x);
                fj.N(this.b.getPageContext().getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f045c));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements yr7 {
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

        @Override // com.baidu.tieba.yr7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                fj.M(this.a.getActivity(), R.string.obfuscated_res_0x7f0f0515);
                this.a.m.setEnabled(true);
            }
        }

        @Override // com.baidu.tieba.yr7
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i > 0 && i < 100) {
                    fj.K(this.a.getActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0d5a));
                } else if (i >= 100) {
                    fj.J(this.a.getActivity(), R.string.obfuscated_res_0x7f0f0510);
                }
            }
        }

        @Override // com.baidu.tieba.yr7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                fj.M(this.a.getActivity(), R.string.obfuscated_res_0x7f0f0510);
                this.a.m.setText(R.string.obfuscated_res_0x7f0f027e);
                SkinManager.setViewTextColor(this.a.m, (int) R.color.CAM_X0109);
                this.a.m.setEnabled(false);
                SkinManager.setBackgroundColor(this.a.m, R.color.transparent);
                TextView textView = this.a.l;
                String string = this.a.getString(R.string.obfuscated_res_0x7f0f0678);
                textView.setText(String.format(string, this.a.A.pck_info.owner.user_name, StringHelper.numberUniform(eh.g(this.a.A.pck_info.download + 1, 0L))));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921063));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements qd6.l {
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

        @Override // com.baidu.tieba.qd6.l
        public void onResult(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) && i == 4) {
                if (i2 == 1) {
                    SkinManager.setImageResource(this.a.n, R.drawable.icon_bar_collectioned);
                    this.a.p.setText(R.string.obfuscated_res_0x7f0f0562);
                    fj.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f00d4);
                    return;
                }
                fj.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f10b9);
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

    public final void U1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity()) || this.w < 0) {
            return;
        }
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
        if (this.B == null) {
            this.B = new NewFaceGroupDownloadModel();
        }
        this.m.setEnabled(false);
        this.B.z(StringUtils.string(Integer.valueOf(this.w)), Boolean.TRUE, new h(this));
    }

    public final void Y1() {
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
            if (!TextUtils.isEmpty(str)) {
                vr7.i().d(str, new a(this));
            }
        }
    }

    public final void S1() {
        EmotionDetailData.PicInfo picInfo;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (picInfo = this.A.pic_info) != null && !TextUtils.isEmpty(picInfo.pic_url)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (rd6.e().f(StringUtils.string(Long.valueOf(this.A.pic_info.pic_id)))) {
                    if (this.D != null) {
                        Rect rect = new Rect();
                        getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                        this.D.showAtLocation(this.c, 81, 0, getPageContext().getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                        return;
                    }
                    return;
                }
                EmotionDetailData emotionDetailData = this.A;
                String str = emotionDetailData.pic_info.pic_url;
                EmotionDetailData.PckInfo pckInfo = emotionDetailData.pck_info;
                if (pckInfo == null) {
                    i2 = 0;
                } else {
                    i2 = pckInfo.pck_id;
                }
                p85 p85Var = new p85();
                p85Var.d = str;
                p85Var.f = StringUtils.string(Integer.valueOf(i2));
                ArrayList arrayList = new ArrayList();
                arrayList.add(p85Var);
                qd6.t().i(arrayList, true, new j(this));
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 25031)));
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.D = new PopupWindow(getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0250, (ViewGroup) null);
            this.J = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090e42);
            this.E = inflate.findViewById(R.id.obfuscated_res_0x7f0912fe);
            this.F = inflate.findViewById(R.id.obfuscated_res_0x7f0912ff);
            this.G = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092372);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092373);
            this.H = textView;
            textView.setOnClickListener(this);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092361);
            this.I = textView2;
            textView2.setOnClickListener(this);
            this.D.setContentView(inflate);
            this.D.setWidth(-1);
            this.D.setHeight(fj.i(getPageContext().getPageActivity()) - vi.b(getPageContext().getPageActivity()));
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

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            new i(this).execute(new Void[0]);
        }
    }

    public final void X1() {
        EmotionDetailData emotionDetailData;
        EmotionDetailData.PckInfo pckInfo;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (emotionDetailData = this.A) != null && (pckInfo = emotionDetailData.pck_info) != null && (i2 = pckInfo.pck_id) > 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this, i2, 25024)));
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

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = findViewById(R.id.obfuscated_res_0x7f0908a5);
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, fj.f(this, R.dimen.obfuscated_res_0x7f07026c)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c8b), null);
            this.d = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091649);
            this.b = navigationBar;
            SkinManager.setViewTextColor(navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0560)), (int) R.color.CAM_X0105);
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
            this.e = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f0916ce);
            if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
            }
            this.e.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.r = new ImageView(getPageContext().getPageActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.r.setPadding(0, fj.f(this, R.dimen.obfuscated_res_0x7f0701d5), fj.f(this, R.dimen.obfuscated_res_0x7f07029b), fj.f(this, R.dimen.obfuscated_res_0x7f0701d5));
            this.r.setLayoutParams(layoutParams);
            this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.r, this);
            this.j = (EmotionDetailImageView) findViewById(R.id.obfuscated_res_0x7f0908a6);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0908a9);
            this.s = findViewById;
            findViewById.setOnClickListener(new d(this));
            this.t = findViewById(R.id.obfuscated_res_0x7f0908a4);
            this.f = findViewById(R.id.obfuscated_res_0x7f090802);
            this.g = findViewById(R.id.obfuscated_res_0x7f090804);
            this.h = findViewById(R.id.obfuscated_res_0x7f090705);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0908d3);
            this.i = tbImageView;
            tbImageView.setGifIconSupport(false);
            this.u = findViewById(R.id.obfuscated_res_0x7f091c37);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f0912c4);
            this.v = findViewById2;
            findViewById2.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f09010b);
            this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f09010e);
            this.o = (ImageView) findViewById(R.id.obfuscated_res_0x7f091db1);
            this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f091db2);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0908a7);
            this.l = textView;
            textView.setOnClickListener(null);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f0908d5);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f0908ab);
            this.m = textView2;
            textView2.setOnClickListener(this);
            V1();
        }
    }

    public final void Z1() {
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
                shareItem.v = getString(R.string.obfuscated_res_0x7f0f141b);
            }
            shareItem.w = getString(R.string.obfuscated_res_0x7f0f0d5b);
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
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, R.drawable.obfuscated_res_0x7f080a29, R.color.CAM_X0105, null);
            if (i2 != 1 && i2 != 4) {
                SkinManager.setBackgroundColor(this.t, R.color.white_alpha100, i2);
            } else {
                SkinManager.setBackgroundColor(this.t, R.color.common_color_10311, i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048587, this, i2, i3, intent) == null) && i3 == -1 && i2 == 25031) {
            S1();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            super.onClick(view2);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                return;
            }
            if (view2 == this.u) {
                Y1();
            } else if (view2 == this.v) {
                S1();
            } else if (view2 == this.m) {
                U1();
            } else if (view2 == this.I) {
                this.D.dismiss();
            } else if (view2 == this.H) {
                T1();
                this.D.dismiss();
            } else if (view2 == this.r) {
                Z1();
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
            setContentView(R.layout.obfuscated_res_0x7f0d024f);
            W1();
            showLoadingView(this.c, false, fj.f(this, R.dimen.obfuscated_res_0x7f0702bb));
            initData();
            registerListener(this.L);
        }
    }
}

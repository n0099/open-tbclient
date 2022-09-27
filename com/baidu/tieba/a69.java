package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.nm8;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a69 implements u49, o49, i55, nm8.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    @NonNull
    public TbPageContext<?> a;
    @NonNull
    public NavigationBar b;
    @NonNull
    public LinearLayout c;
    @NonNull
    public EditorTools d;
    @NonNull
    public r49 e;
    @Nullable
    public m59 f;
    @NonNull
    public l59 g;
    public View h;
    public TextView i;
    public View j;
    public ImageView k;
    public TextView l;
    public SaveDraftDialogView m;
    public wu4 n;
    @NonNull
    public final List<s49<?>> o;
    @NonNull
    public WriteData p;
    public boolean q;
    public Handler r;
    public m39 s;
    public w59 t;
    public o59 u;
    public l39 v;
    public q39 w;
    public final CustomMessageListener x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(a69 a69Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var, Integer.valueOf(i)};
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
            this.a = a69Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.a.showToast((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public b(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ a69 b;

        public c(a69 a69Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a69Var;
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091daf) {
                this.b.i();
                if (this.a) {
                    this.b.X();
                }
                this.b.e.setResult(100);
                this.b.e.finish();
            } else if (id == R.id.obfuscated_res_0x7f091db0) {
                this.b.c0();
                if (this.a) {
                    this.b.X();
                }
                this.b.e.setResult(100);
                this.b.e.finish();
            }
            this.b.n.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public d(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.A) {
                    this.a.A = false;
                    return;
                }
                for (s49<?> s49Var : this.a.o) {
                    if (s49Var instanceof t49) {
                        t49 t49Var = (t49) s49Var;
                        if (t49Var.e() == 2) {
                            t49Var.j();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public e(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a69 a69Var = this.a;
                if (a69Var.d.a == null) {
                    return;
                }
                if (a69Var.v == null) {
                    a69 a69Var2 = this.a;
                    a69Var2.v = new l39(a69Var2.a);
                }
                this.a.v.b(this.a.d.a.s(2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public f(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null || !customMessage.getData().booleanValue()) {
                    return null;
                }
                a69 a69Var = this.a;
                a69Var.d(a69Var.a.getString(R.string.obfuscated_res_0x7f0f14fd));
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public g(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.getPageActivity() == null || this.a.a.getPageActivity().isFinishing()) {
                return;
            }
            ej.L(this.a.a.getPageActivity(), this.a.a.getPageActivity().getCurrentFocus());
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public h(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.getPageActivity() == null || this.a.a.getPageActivity().isFinishing()) {
                return;
            }
            ej.x(this.a.a.getPageActivity(), this.a.a.getPageActivity().getCurrentFocus());
        }
    }

    public a69(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull r49 r49Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, r49Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new ArrayList();
        this.r = new Handler(Looper.getMainLooper());
        this.s = new m39();
        this.x = new a(this, 2016554);
        this.a = tbPageContext;
        this.b = navigationBar;
        this.c = linearLayout;
        this.d = editorTools;
        this.e = r49Var;
        this.z = z;
        this.p = new WriteData();
        this.f = V();
        this.g = new l59(this.d);
        this.p.setNewWritePage(true);
    }

    @Override // com.baidu.tieba.u49
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.A = true;
        }
    }

    @Override // com.baidu.tieba.i55
    public void B(h55 h55Var) {
        m59 m59Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h55Var) == null) || (m59Var = this.f) == null) {
            return;
        }
        m59Var.B(h55Var);
    }

    @Override // com.baidu.tieba.u49
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.q();
        }
    }

    @Override // com.baidu.tieba.u49
    public void D(h55 h55Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, h55Var) == null) || h55Var == null) {
            return;
        }
        this.d.A(h55Var);
    }

    @Override // com.baidu.tieba.u49
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.u49
    public LinkedList<iz4> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (LinkedList) invokeV.objValue;
    }

    @CallSuper
    public void L(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) || this.a.getPageActivity() == null) {
            return;
        }
        Intent intent = this.a.getPageActivity().getIntent();
        for (s49<?> s49Var : this.o) {
            if (s49Var != null) {
                s49Var.l(bundle, intent, this.p);
                LinearLayout linearLayout = this.c;
                linearLayout.addView(s49Var.q(linearLayout));
                s49Var.h(this);
            }
        }
        this.c.setDrawingCacheEnabled(false);
        this.c.setOnClickListener(new d(this));
        h();
    }

    public abstract void M(@NonNull List<s49<?>> list);

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.registerListener(this.x);
            if (this.y) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921583));
            }
            b0();
            h0();
        }
    }

    public abstract void O(@NonNull EditorTools editorTools);

    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, navigationBar) == null) {
            this.i = navigationBar.getCenterText();
            this.k = (ImageView) navigationBar.getCenterImgBox();
            this.j = navigationBar.getCenterImgBoxLayout();
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.h = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new b(this));
            String string = this.a.getString(R.string.obfuscated_res_0x7f0f112c);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                string = this.a.getString(R.string.obfuscated_res_0x7f0f1146);
            }
            TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
            this.l = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = ej.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0701b2);
            this.l.setLayoutParams(layoutParams);
            h();
        }
    }

    public final void Q() {
        l39 l39Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (l39Var = this.v) == null) {
            return;
        }
        l39Var.a();
    }

    public void R() {
        q39 q39Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (q39Var = this.w) == null) {
            return;
        }
        q39Var.b();
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.r.postDelayed(new h(this), 150L);
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            o59 o59Var = new o59(this.a, this.d);
            this.u = o59Var;
            o59Var.g();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x02af  */
    @CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void U(Bundle bundle) {
        Intent intent;
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) || this.a.getPageActivity() == null) {
            return;
        }
        Intent intent2 = this.a.getPageActivity().getIntent();
        if (bundle != null) {
            this.p.setType(bundle.getInt("type", 9));
            this.p.setForumId(bundle.getString("forum_id"));
            this.p.setForumName(bundle.getString("forum_name"));
            this.p.setFirstDir(bundle.getString(IntentConfig.FORUM_FIRST_DIR));
            this.p.setSecondDir(bundle.getString(IntentConfig.FORUM_SECOND_DIR));
            this.p.setThreadId(bundle.getString("thread_id"));
            this.p.setTitle(bundle.getString(BaseWriteConfig.TITLE));
            this.p.setContent(bundle.getString(BaseWriteConfig.CONTENT));
            this.p.setCallFrom(bundle.getString(BaseWriteConfig.KEY_CALL_FROM));
            String string = bundle.getString("prefix_data");
            this.p.setPrefixData(StringUtils.isNull(string) ? null : (PostPrefixData) OrmObject.objectWithJsonStr(string, PostPrefixData.class));
            this.p.setFrom(bundle.getString("from"));
            this.p.setTopicId(bundle.getString(WriteActivityConfig.HOT_TOPIC_ID));
            this.p.setStatisticFrom(bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.p.setPrivateThread(bundle.getInt(BaseWriteConfig.PRIVATE_THREAD));
            this.p.setFrsTabInfoData((FrsTabInfoData) bundle.getSerializable("tab_list"));
            this.p.setCanGoods(bundle.getBoolean(WriteActivityConfig.CAN_GOODS));
            this.y = bundle.getBoolean(WriteActivityConfig.NEED_CLOSE_PRE_PAGE);
            this.q = bundle.getBoolean(WriteActivityConfig.RICH_MODE_ENABLE, false);
        } else if (intent2 != null) {
            intent = intent2;
            this.p.setType(intent.getIntExtra("type", 9));
            this.p.setForumId(intent.getStringExtra("forum_id"));
            this.p.setForumName(intent.getStringExtra("forum_name"));
            this.p.setFirstDir(intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR));
            this.p.setSecondDir(intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR));
            this.p.setThreadId(intent.getStringExtra("thread_id"));
            this.p.setTitle(intent.getStringExtra(BaseWriteConfig.TITLE));
            this.p.setContent(intent.getStringExtra(BaseWriteConfig.CONTENT));
            this.p.setCallFrom(intent.getStringExtra(BaseWriteConfig.KEY_CALL_FROM));
            this.p.setFrom(intent.getStringExtra("from"));
            this.p.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.p.setTopicId(intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID));
            this.p.setStatisticFrom(intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.p.setPrivateThread(intent.getIntExtra(BaseWriteConfig.PRIVATE_THREAD, 0));
            this.p.setFrsTabInfoData((FrsTabInfoData) intent.getSerializableExtra("tab_list"));
            this.p.setVoiceEnable(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            this.p.setDisableAudioMessage(intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE));
            this.p.setCanGoods(intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false));
            this.y = intent.getBooleanExtra(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, false);
            PostPrefixData postPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                postPrefixData.getPrefixs().add(this.a.getString(R.string.obfuscated_res_0x7f0f15f7));
            }
            this.p.setPrefixData(postPrefixData);
            this.p.setWriteVoteData((WriteVoteData) intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA));
            this.p.setFromItemDetail(intent.getBooleanExtra(IntentConfig.IS_ITEM_DETAIL, false));
            this.p.setIntentStarCount(intent.getIntExtra(WriteActivityConfig.STAR_COUNT, 0));
            Serializable serializableExtra = intent.getSerializableExtra(WriteActivityConfig.ITEM_INFO);
            if (serializableExtra instanceof SerializableItemInfo) {
                SerializableItemInfo serializableItemInfo = (SerializableItemInfo) serializableExtra;
                this.p.setIntentItemInfo(serializableItemInfo);
                this.p.setItem_id(String.valueOf(serializableItemInfo.id));
            }
            this.p.setSaveDraft(intent.getBooleanExtra(BaseWriteConfig.IS_SAVE_DRAFTE, true));
            this.p.setMoreForumImg(intent.getStringExtra("more_forum_img"));
            this.p.setMoreForumTitle(intent.getStringExtra("more_forum_title"));
            this.p.setMoreForumUrl(intent.getStringExtra("more_forum_url"));
            if (UbsABTestHelper.isMainTabShowA()) {
                this.p.setIsArticle(intent.getStringExtra(WriteActivityConfig.IS_ARTICLE));
            }
            this.q = intent.getBooleanExtra(WriteActivityConfig.RICH_MODE_ENABLE, false);
            if (this.p.getType() != 10) {
                this.p.setEntranceType(2);
                this.p.setType(9);
            } else {
                this.p.setEntranceType(1);
            }
            if (bundle == null && intent != null) {
                this.p.setFromErrorDialog(intent.getBooleanExtra(WriteActivityConfig.IS_FROM_ERROR_DIALOG, false));
            }
            if (this.p.isFromErrorDialog() && (writeData = gp8.f) != null) {
                this.p = writeData;
                writeData.setFromErrorDialog(true);
                WriteData writeData2 = this.p;
                writeData2.setContent(writeData2.getContentString());
            }
            w();
        }
        intent = intent2;
        if (this.p.getType() != 10) {
        }
        if (bundle == null) {
            this.p.setFromErrorDialog(intent.getBooleanExtra(WriteActivityConfig.IS_FROM_ERROR_DIALOG, false));
        }
        if (this.p.isFromErrorDialog()) {
            this.p = writeData;
            writeData.setFromErrorDialog(true);
            WriteData writeData22 = this.p;
            writeData22.setContent(writeData22.getContentString());
        }
        w();
    }

    public abstract m59 V();

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.t = new w59(this.a, this.s);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumId(TextUtils.isEmpty(this.p.getForumId()) ? "0" : this.p.getForumId()).setForumName(this.p.getForumName()).setEnableAudio(this.p.isVoiceEnable()).setAudioMsg(this.p.getDisableAudioMessage()).setCanGoods(false).setPrefixData(this.p.getPrefixData()).setPrivateThread(this.p.getPrivateThread()).setForumDir(this.p.getFirstDir(), this.p.getSecondDir()).setProfessionZone(this.p.getProZone()).setFrsTabInfo(this.p.getFrsTabInfoData()).setCallFrom(this.p.getCallFrom()).setStatisticFrom(this.p.getStatisticFrom()).setIsEvaluate(true).setScoreItemInfo(this.p.getIntentItemInfo()).setStarCount(this.p.getIntentStarCount()).setFrom(this.p.getFrom()).send();
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
        statisticItem.param("obj_locate", "main_tab".equals(this.p.getFrom()) ? 8 : 2);
        statisticItem.param("obj_type", 6);
        TiebaStatic.log(statisticItem);
    }

    public abstract void Y();

    public final void Z() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            switch (this.p.getType()) {
                case 9:
                case 13:
                    i = 1;
                    break;
                case 10:
                default:
                    i = -1;
                    break;
                case 11:
                    i = 2;
                    break;
                case 12:
                    i = 4;
                    break;
                case 14:
                    i = 5;
                    break;
            }
            v39.a(i);
        }
    }

    @Override // com.baidu.tieba.u49
    @CallSuper
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (this.v != null && !z) {
                Q();
            }
            if (z) {
                C();
            }
            for (s49<?> s49Var : this.o) {
                if (s49Var instanceof t49) {
                    ((t49) s49Var).a(z);
                }
            }
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            onBackPressed();
        }
    }

    @Override // com.baidu.tieba.u49
    public void b(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new f(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    @Override // com.baidu.tieba.u49
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.e.c();
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.B = true;
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                this.e.finish();
                return;
            }
            for (s49<?> s49Var : this.o) {
                s49Var.d(this.p);
            }
        }
    }

    @Override // com.baidu.tieba.u49
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.e.d(str);
        }
    }

    public void d0(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || (textView = this.l) == null) {
            return;
        }
        textView.setEnabled(z);
    }

    @Override // com.baidu.tieba.u49
    public void e() {
        s55 n;
        t55 t55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (n = this.d.n(6)) == null || (t55Var = n.m) == null) {
            return;
        }
        t55Var.B(new h55(52, 0, null));
    }

    public abstract boolean e0();

    @Override // com.baidu.tieba.u49
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.d.post(new e(this));
        }
    }

    @Override // com.baidu.tieba.u49
    public void g() {
        o59 o59Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (o59Var = this.u) == null) {
            return;
        }
        o59Var.f();
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048610, this, z) == null) || this.a.getPageActivity() == null || this.a.getPageActivity().isFinishing()) {
            return;
        }
        if (this.m == null) {
            this.m = new SaveDraftDialogView(this.a.getPageActivity());
            this.m.setOnClickListener(new c(this, z));
        }
        if (this.n == null) {
            wu4 wu4Var = new wu4(this.a);
            this.n = wu4Var;
            wu4Var.setContentView(this.m);
        }
        this.m.setText(this.a.getString(R.string.obfuscated_res_0x7f0f15fc), this.a.getString(R.string.obfuscated_res_0x7f0f10a2));
        this.n.k();
    }

    @Override // com.baidu.tieba.u49
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            int l = ox4.k().l("write_associate_item_hint_tip_key", 0);
            if (ox4.k().l("commodity_tip_show_controller", 0) == 0 && this.p.isCanGoods()) {
                if (l > 0) {
                    f0();
                    return;
                } else {
                    ox4.k().w("commodity_tip_show_controller", ox4.k().l("commodity_tip_show_controller", 0) + 1);
                    return;
                }
            }
            i0();
            o59 o59Var = this.u;
            if (o59Var != null) {
                o59Var.e();
            }
        }
    }

    @Override // com.baidu.tieba.u49
    @CallSuper
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.B = true;
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (this.w == null) {
                this.w = new q39(this.a);
            }
            this.w.c(this.d);
        }
    }

    @Override // com.baidu.tieba.u49
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.p.setPrivacy(z);
        }
    }

    @Override // com.baidu.tieba.nm8.g
    public void k(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, writeData) == null) || writeData == null) {
            return;
        }
        if (this.q) {
            if (writeData.isRichTextEditorMode() && 11 != this.p.getType()) {
                this.e.w0(11, true);
                return;
            } else if (!writeData.isRichTextEditorMode() && 9 != this.p.getType()) {
                this.e.w0(9, true);
                return;
            }
        }
        for (s49<?> s49Var : this.o) {
            s49Var.k(writeData);
        }
        h();
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.r.postDelayed(new g(this), 150L);
        }
    }

    @Override // com.baidu.tieba.o49
    public void l(@NonNull t49 t49Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, t49Var) == null) || this.t == null) {
            return;
        }
        if (t49Var.e() == 1) {
            this.t.j(t49Var.o());
        } else if (t49Var.e() == 2) {
            this.t.i(t49Var.o());
        }
    }

    @Override // com.baidu.tieba.u49
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.a.getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            hotSelectActivityConfig.setForumExtra(dh.g(this.p.getForumId(), 0L), this.p.getFirstDir(), this.p.getSecondDir());
            this.a.sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    @Override // com.baidu.tieba.u49
    public void n(@Nullable ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, arrayList) == null) {
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getPageActivity(), 12004, true);
            atListActivityConfig.setSelectedAtList(arrayList);
            this.a.sendMessage(new CustomMessage(2002001, atListActivityConfig));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.u49
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            if (z) {
                k0();
            } else {
                ej.L(this.a.getPageActivity(), this.a.getPageActivity().getCurrentFocus());
            }
        }
    }

    @Override // com.baidu.tieba.u49
    @CallSuper
    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048622, this, i, i2, intent) == null) {
            if (i2 == -1) {
                if (i == 12002) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.FINISH_SELF, false)) {
                        this.a.getPageActivity().setResult(-1, intent);
                        this.a.getPageActivity().finish();
                        return;
                    }
                } else if (i == 25064) {
                    u59.a(this.a, this.p);
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                }
            } else if (i2 == 0 && i == 12006 && intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                this.a.showToast(postWriteCallBackData.getErrorString());
                this.s.n(postWriteCallBackData.getErrorString());
                this.s.m(postWriteCallBackData.getSensitiveWords());
                for (s49<?> s49Var : this.o) {
                    if (s49Var instanceof t49) {
                        ((t49) s49Var).m();
                    }
                }
            }
            for (s49<?> s49Var2 : this.o) {
                s49Var2.onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tieba.u49
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            for (s49<?> s49Var : this.o) {
                if (s49Var.f()) {
                    return true;
                }
            }
            if (this.d.u()) {
                C();
                return true;
            } else if (e0()) {
                i();
                this.e.setResult(100);
                this.e.finish();
                return false;
            } else {
                g0(false);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u49
    @CallSuper
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.b.onChangeSkinType(this.a, i);
            WebPManager.setPureDrawable(this.b.getBackImageView(), R.drawable.obfuscated_res_0x7f080a10, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.l.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i));
            this.d.w(i);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0205);
            for (s49<?> s49Var : this.o) {
                s49Var.onChangeSkinType(i);
            }
            h();
            w();
        }
    }

    @Override // com.baidu.tieba.u49
    @CallSuper
    public void onCreate(Bundle bundle) {
        w59 w59Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bundle) == null) {
            U(bundle);
            P(this.b);
            O(this.d);
            M(this.o);
            L(bundle);
            W();
            T();
            N();
            if (this.z) {
                Y();
            }
            if (this.p.isFromErrorDialog() && (w59Var = this.t) != null) {
                w59Var.h();
            }
            Z();
        }
    }

    @Override // com.baidu.tieba.u49
    @CallSuper
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (!this.B) {
                c0();
            }
            for (s49<?> s49Var : this.o) {
                s49Var.c();
            }
            w59 w59Var = this.t;
            if (w59Var != null) {
                w59Var.g();
            }
            this.r.removeCallbacksAndMessages(null);
            TiebaPrepareImageService.StopService();
            R();
            Q();
            ih.b(this.n, this.a);
            vm8.d();
            MessageManager.getInstance().unRegisterTask(2921500);
        }
    }

    @Override // com.baidu.tieba.u49
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, intent) == null) {
        }
    }

    @Override // com.baidu.tieba.u49
    @CallSuper
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            C();
            for (s49<?> s49Var : this.o) {
                s49Var.onPause();
            }
        }
    }

    @Override // com.baidu.tieba.u49
    @CallSuper
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            for (s49<?> s49Var : this.o) {
                s49Var.onResume();
            }
        }
    }

    @Override // com.baidu.tieba.u49
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, bundle) == null) || bundle == null) {
            return;
        }
        bundle.putInt("type", this.p.getType());
        bundle.putString("forum_id", this.p.getForumId());
        bundle.putString("forum_name", this.p.getForumName());
        bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.p.getFirstDir());
        bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.p.getSecondDir());
        bundle.putString("thread_id", this.p.getThreadId());
        bundle.putString(BaseWriteConfig.KEY_CALL_FROM, this.p.getCallFrom());
        bundle.putInt(BaseWriteConfig.PRIVATE_THREAD, this.p.getPrivateThread());
        bundle.putString("from", this.p.getFrom());
        bundle.putSerializable("tab_list", this.p.getFrsTabInfoData());
        bundle.putBoolean(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, this.y);
        PostPrefixData prefixData = this.p.getPrefixData();
        if (prefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(prefixData));
        }
        for (s49<?> s49Var : this.o) {
            s49Var.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tieba.u49
    @CallSuper
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
        }
    }

    @Override // com.baidu.tieba.u49
    @CallSuper
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
        }
    }

    @Override // com.baidu.tieba.u49
    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            if (z) {
                S();
            } else {
                ej.x(this.a.getPageActivity(), this.a.getPageActivity().getCurrentFocus());
            }
        }
    }

    @Override // com.baidu.tieba.o49
    @CallSuper
    public void q(@NonNull t49 t49Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048634, this, t49Var, z) == null) {
            if (z) {
                o(true);
                this.d.q();
            }
            w();
        }
    }

    @Override // com.baidu.tieba.u49
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            C();
            if (this.p.getWriteImagesInfo() == null) {
                return;
            }
            TbPageContext<?> tbPageContext = this.a;
            WriteData writeData = this.p;
            u59.b(tbPageContext, writeData, writeData.getWriteImagesInfo(), this.p.getFrom(), this.p.getDisableAudioMessage(), this.p.isVoiceEnable(), this.p.getPrefixData());
        }
    }

    @Override // com.baidu.tieba.u49
    @NonNull
    public PermissionJudgePolicy t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            TbPageContext<?> tbPageContext = this.a;
            if (tbPageContext instanceof BaseActivity) {
                return ((BaseActivity) tbPageContext).getCurrentPermissionJudgePolicy();
            }
            if (tbPageContext instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) tbPageContext).getCurrentPermissionJudgePolicy();
            }
            return new PermissionJudgePolicy();
        }
        return (PermissionJudgePolicy) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u49
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            C();
            if (this.p.getWriteImagesInfo() == null) {
                return;
            }
            u59.d(this.a, this.p);
        }
    }

    @Override // com.baidu.tieba.u49
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
        }
    }

    @Override // com.baidu.tieba.u49
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.g.a();
        }
    }

    @Override // com.baidu.tieba.u49
    public void x(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, iArr) == null) {
        }
    }

    @Override // com.baidu.tieba.u49
    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.p.setShowCustomFigure(z);
        }
    }

    @Override // com.baidu.tieba.u49
    public void z(h55 h55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, h55Var) == null) {
            for (s49<?> s49Var : this.o) {
                s49Var.p(h55Var);
            }
        }
    }
}

package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.publisher.PublishParams;
import com.baidu.swan.apps.publisher.draft.DraftData;
import com.baidu.swan.apps.publisher.emoji.EmojiEditText;
import com.baidu.swan.apps.publisher.view.PhotoChooseView;
import com.baidu.swan.apps.publisher.view.SPSwitchPanelLinearLayout;
import com.baidu.tieba.db3;
import com.baidu.tieba.ib2;
import com.baidu.tieba.v93;
import com.baidu.tieba.y93;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d93 extends fb2 implements View.OnClickListener, uz2<MediaModel>, y93.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b1;
    public transient /* synthetic */ FieldHolder $fh;
    public SPSwitchPanelLinearLayout G0;
    public EmojiEditText H0;
    public EmojiEditText I0;
    public TextView J0;
    public ImageView K0;
    public PhotoChooseView L0;
    public ImageView M0;
    public TextView N0;
    public TextView O0;
    public ImageView P0;
    public View Q0;
    public PublishParams R0;
    public boolean S0;
    public DraftData T0;
    public b93 U0;
    public boolean V0;
    public int W0;
    public int X0;
    public int Y0;
    public EmojiEditText.e Z0;
    public EmojiEditText.e a1;

    @Override // com.baidu.tieba.uz2
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.fb2
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fb2
    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fb2
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ViewGroup d;
        public final /* synthetic */ d93 e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    hb3.d(this.a.d);
                }
            }
        }

        public l(d93 d93Var, List list, String str, String str2, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d93Var, list, str, str2, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = d93Var;
            this.a = list;
            this.b = str;
            this.c = str2;
            this.d = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject a2 = u93.a(this.a, this.e.R0.getImageRatio());
                    if (a2 == null) {
                        if (d93.b1) {
                            Log.d("SwanAppPublisher", "图片解析失败");
                        }
                        a2 = new JSONObject();
                    }
                    if (!this.b.isEmpty()) {
                        a2.put("title", this.e.H0.getText().toString());
                    }
                    if (!this.c.isEmpty()) {
                        a2.put("content", this.e.I0.getText().toString());
                    }
                    if (d93.b1) {
                        Log.d("SwanAppPublisher", "publish result " + a2.toString());
                    }
                    this.d.post(new a(this));
                    k93.a();
                    this.e.U0.a(a2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements EmojiEditText.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d93 a;

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        public a(d93 d93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d93Var;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.X0 = i;
            int i2 = i - 4999;
            this.a.N0.setVisibility(0);
            if (i2 < 999) {
                this.a.N0.setText(String.format("超%d字", Integer.valueOf(i2)));
            } else {
                this.a.N0.setText("超999+");
            }
            this.a.N0.setTextColor(-65536);
            this.a.r3();
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) {
                return;
            }
            this.a.X0 = i;
            if (i > 4979) {
                this.a.N0.setText(String.format("剩%d字", Integer.valueOf(4999 - i)));
                this.a.N0.setVisibility(0);
                this.a.N0.setTextColor(this.a.Y0);
            } else {
                this.a.N0.setVisibility(8);
            }
            this.a.r3();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d93 a;

        public b(d93 d93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d93Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLI(1048576, this, dialogInterface, i) != null) {
                return;
            }
            this.a.x3();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d93 a;

        public c(d93 d93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d93Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                w93.onEvent("draft_save");
                this.a.T0.setTimeStamp(System.currentTimeMillis());
                this.a.T0.setTitle(this.a.H0.getText().toString());
                this.a.T0.setContent(this.a.I0.getText().toString());
                this.a.T0.setImages(this.a.y3());
                k93.d(this.a.T0);
                this.a.s3();
                if (this.a.U0 != null) {
                    this.a.U0.onCancel();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d93 a;

        public d(d93 d93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d93Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                w93.onEvent("draft_quit");
                k93.a();
                this.a.s3();
                if (this.a.U0 != null) {
                    this.a.U0.onCancel();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements v93.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d93 a;

        public e(d93 d93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d93Var;
        }

        @Override // com.baidu.tieba.v93.c
        public void onClickSwitch(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLZ(1048576, this, view2, z) != null) {
                return;
            }
            this.a.p3(z);
            w93.onEvent("emoji_clk");
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d93 a;

        public f(d93 d93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d93Var;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLZ(1048576, this, view2, z) != null) || !z) {
                return;
            }
            this.a.t3();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d93 a;

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view2, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view2, i, keyEvent)) == null) {
                return false;
            }
            return invokeLIL.booleanValue;
        }

        public g(d93 d93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d93Var;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d93 a;

        public h(d93 d93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d93Var;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLZ(1048576, this, view2, z) != null) || !z) {
                return;
            }
            this.a.v3();
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d93 a;

        public i(d93 d93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d93Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                this.a.q3();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d93 a;

        public j(d93 d93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d93Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) != null) {
                return invokeLL.booleanValue;
            }
            this.a.G3(view2, motionEvent);
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements PhotoChooseView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d93 a;

        public k(d93 d93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d93Var;
        }

        @Override // com.baidu.swan.apps.publisher.view.PhotoChooseView.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.a.r3();
                }
                if (i != this.a.R0.getMaxImageNum() - 1) {
                    return;
                }
                this.a.w3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements EmojiEditText.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d93 a;

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        public m(d93 d93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d93Var;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) {
                return;
            }
            this.a.W0 = i;
            if (i == 0) {
                this.a.P0.setVisibility(8);
            } else {
                this.a.P0.setVisibility(0);
            }
            this.a.r3();
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.W0 = i;
            this.a.H0.setText(this.a.H0.getText().toString().substring(0, 20));
            this.a.H0.setSelection(20);
            aa3.h(this.a.getContext(), R.string.obfuscated_res_0x7f0f1518);
            this.a.r3();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947659339, "Lcom/baidu/tieba/d93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947659339, "Lcom/baidu/tieba/d93;");
                return;
            }
        }
        b1 = js1.a;
    }

    public final void E3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (D3()) {
                I3();
                return;
            }
            s3();
            b93 b93Var = this.U0;
            if (b93Var != null) {
                b93Var.onCancel();
            }
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            v93.d(this.G0, this.I0);
            ImageView imageView = this.K0;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f081431);
            }
        }
    }

    public void s3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            y93.k(this.I0);
            this.I0.d();
            this.H0.d();
            x3();
        }
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.K0.setImageResource(R.drawable.obfuscated_res_0x7f081430);
            this.K0.setClickable(false);
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.M0.setImageResource(R.drawable.obfuscated_res_0x7f08142a);
            this.M0.setClickable(false);
        }
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.K0.setImageResource(R.drawable.obfuscated_res_0x7f081431);
            this.K0.setClickable(true);
        }
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.M0.setImageResource(R.drawable.obfuscated_res_0x7f081415);
            this.M0.setClickable(true);
        }
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            ib2.b i2 = mx2.T().U().i("navigateBack");
            i2.n(ib2.i, ib2.h);
            i2.g();
            i2.a();
        }
    }

    public final List<String> y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.R0.supportImage().booleanValue()) {
                return this.L0.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public d93() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.S0 = false;
        this.V0 = false;
        this.W0 = 0;
        this.X0 = 0;
        this.Z0 = new m(this);
        this.a1 = new a(this);
    }

    @Override // com.baidu.tieba.fb2
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.V0) {
                if (b1) {
                    Log.d("SwanAppPublisher", "backPress: hide soft");
                }
                y93.k(this.I0);
                this.V0 = false;
                return true;
            } else if (!D3()) {
                return false;
            } else {
                if (b1) {
                    Log.d("SwanAppPublisher", "backPress: show draft dialog");
                }
                I3();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public final void H3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            db3.a aVar = new db3.a(getContext());
            aVar.m(false);
            aVar.U(R.string.obfuscated_res_0x7f0f150f);
            aVar.v(R.string.obfuscated_res_0x7f0f1513);
            aVar.O(R.string.obfuscated_res_0x7f0f0144, new b(this));
            aVar.X();
        }
    }

    public final void I3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            db3.a aVar = new db3.a(getActivity());
            aVar.U(R.string.obfuscated_res_0x7f0f1523);
            aVar.B(R.string.obfuscated_res_0x7f0f1520, new d(this));
            aVar.v(R.string.obfuscated_res_0x7f0f1522);
            aVar.O(R.string.obfuscated_res_0x7f0f1521, new c(this));
            aVar.X();
        }
    }

    public final void G3(View view2, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 2) {
                    if (view2 != null) {
                        view2.setAlpha(1.0f);
                    }
                } else if (view2 != null) {
                    view2.setAlpha(0.2f);
                }
            } else if (view2 != null) {
                view2.setAlpha(0.2f);
            }
        }
    }

    public void F3(b93 b93Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, b93Var) == null) {
            this.U0 = b93Var;
        }
    }

    @Override // com.baidu.tieba.y93.b
    public void onSoftInputShowing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (b1) {
                Log.d("SwanAppPublisher", "soft input is showing ? " + z);
            }
            this.V0 = z;
        }
    }

    public final void p3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                this.K0.setImageResource(R.drawable.obfuscated_res_0x7f08142e);
            } else {
                this.K0.setImageResource(R.drawable.obfuscated_res_0x7f081431);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.v0(bundle);
            Bundle o = o();
            if (o != null) {
                PublishParams publishParams = (PublishParams) o.getParcelable("params");
                this.R0 = publishParams;
                if (publishParams == null) {
                    this.S0 = true;
                    return;
                }
                return;
            }
            this.S0 = true;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, layoutInflater, viewGroup, bundle)) == null) {
            super.y0(layoutInflater, viewGroup, bundle);
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d08f3, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public final void A3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            DraftData c2 = k93.c();
            this.T0 = c2;
            if (c2 != null) {
                if (b1) {
                    Log.d("SwanAppPublisher", "update view from draft data");
                }
                String title = this.T0.getTitle();
                if (this.R0.supportTitle().booleanValue() && !TextUtils.isEmpty(title)) {
                    this.H0.setText(title);
                    this.H0.setSelection(title.length());
                    this.Q0 = this.H0;
                }
                String content = this.T0.getContent();
                if (!TextUtils.isEmpty(content)) {
                    this.I0.setText(content);
                    if (this.R0.supportEmoji().booleanValue() && m93.c().e()) {
                        this.I0.c();
                    }
                    EmojiEditText emojiEditText = this.I0;
                    emojiEditText.setSelection(emojiEditText.getText().length());
                    this.Q0 = this.I0;
                }
                if (this.R0.supportImage().booleanValue()) {
                    this.L0.update(this.T0.getImages());
                    if (this.L0.getLeftCount() == 0) {
                        u3();
                        return;
                    }
                    return;
                }
                return;
            }
            this.T0 = new DraftData(0L, "", "", null);
        }
    }

    public final boolean D3() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.R0.supportTitle().booleanValue()) {
                str = this.H0.getText().toString().trim();
            } else {
                str = "";
            }
            String trim = this.I0.getText().toString().trim();
            List<String> y3 = y3();
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(trim) && y3 == null) {
                k93.a();
                return false;
            }
            if (TextUtils.equals(str, this.T0.getTitle()) && TextUtils.equals(trim, this.T0.getContent())) {
                List<String> images = this.T0.getImages();
                if (images == null && y3 == null) {
                    return false;
                }
                if (images != null && y3 != null && images.size() == y3.size()) {
                    for (int i2 = 0; i2 < y3.size(); i2++) {
                        if (!TextUtils.equals(images.get(i2), y3.get(i2))) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            y93.c(getActivity(), (ViewGroup) getActivity().findViewById(16908290), this.G0, this);
            v93.b(this.G0, this.K0, this.I0, new e(this));
            o93.b().c(getActivity(), this.G0, this.I0, this.R0.getEmojiPath(), this.R0.getAppId(), this.R0.getAppVersion());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void C3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (b1) {
                Log.d("SwanAppPublisher", "init view");
            }
            this.H0 = (EmojiEditText) view2.findViewById(R.id.obfuscated_res_0x7f091c7f);
            if (this.R0.supportTitle().booleanValue()) {
                view2.findViewById(R.id.obfuscated_res_0x7f091c80).setVisibility(0);
                this.H0.setHint(this.R0.getTitleHint());
                this.H0.setListener(this.Z0);
                this.H0.setMaxSize(20);
                this.H0.setOnFocusChangeListener(new f(this));
            } else {
                view2.findViewById(R.id.obfuscated_res_0x7f091c80).setVisibility(8);
            }
            this.K0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090125);
            if (this.R0.supportEmoji().booleanValue() && !TextUtils.isEmpty(this.R0.getEmojiPath().trim())) {
                this.K0.setVisibility(0);
            } else {
                this.K0.setVisibility(8);
            }
            this.G0 = (SPSwitchPanelLinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09097e);
            view2.findViewById(R.id.obfuscated_res_0x7f09182f).setBackgroundColor(this.R0.getNavBarBgColor());
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091d07);
            textView.setText(this.R0.getNavBarTitle());
            textView.setTextColor(this.R0.getNavBarTextColor());
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09070a);
            this.P0 = imageView;
            imageView.setOnClickListener(this);
            this.J0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c7b);
            if (this.R0.supportTarget().booleanValue() && !TextUtils.isEmpty(this.R0.getTarget().trim())) {
                TextView textView2 = this.J0;
                textView2.setText("发布到 " + this.R0.getTarget());
            } else {
                view2.findViewById(R.id.obfuscated_res_0x7f091c7c).setVisibility(8);
            }
            this.N0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923d4);
            EmojiEditText emojiEditText = (EmojiEditText) view2.findViewById(R.id.obfuscated_res_0x7f091c61);
            this.I0 = emojiEditText;
            emojiEditText.setOnKeyListener(new g(this));
            this.I0.setHint(this.R0.getContentHint());
            this.I0.setListener(this.a1);
            this.I0.setMaxSize(4999);
            this.I0.setOnFocusChangeListener(new h(this));
            view2.findViewById(R.id.obfuscated_res_0x7f0907bf).setOnTouchListener(new i(this));
            TextView textView3 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cf9);
            this.O0 = textView3;
            textView3.setText(this.R0.getPublishText());
            this.O0.setOnClickListener(this);
            this.O0.setClickable(false);
            TextView textView4 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09052b);
            textView4.setText(this.R0.getCancelText());
            textView4.setTextColor(this.R0.getCancelTextColor());
            textView4.setOnClickListener(this);
            textView4.setOnTouchListener(new j(this));
            this.M0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09013a);
            this.L0 = (PhotoChooseView) view2.findViewById(R.id.obfuscated_res_0x7f091be8);
            if (this.R0.supportImage().booleanValue()) {
                this.M0.setVisibility(0);
                this.M0.setOnClickListener(this);
                this.L0.setVisibility(0);
                this.L0.d(getActivity());
                this.L0.setMaxCount(this.R0.getMaxImageNum());
                this.L0.setCallback(this);
                this.L0.setDeleteListener(new k(this));
            } else {
                this.M0.setVisibility(8);
                this.L0.setVisibility(8);
            }
            this.Y0 = getResources().getColor(R.color.obfuscated_res_0x7f060b06);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void N0(View view2, Bundle bundle) {
        EmojiEditText emojiEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, view2, bundle) == null) {
            super.N0(view2, bundle);
            if (this.S0) {
                H3();
                return;
            }
            C3(view2);
            if (this.R0.supportEmoji().booleanValue() && !TextUtils.isEmpty(this.R0.getEmojiPath().trim())) {
                B3();
            }
            A3();
            if (this.Q0 == null) {
                if (this.R0.supportTitle().booleanValue()) {
                    emojiEditText = this.H0;
                } else {
                    emojiEditText = this.I0;
                }
                this.Q0 = emojiEditText;
            }
            y93.n(this.Q0, 300L);
            w93.onEvent("show");
            r3();
        }
    }

    @Override // com.baidu.tieba.uz2
    public void f(List<MediaModel> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (MediaModel mediaModel : list) {
                arrayList.add(mediaModel.getPath());
            }
            this.L0.update(arrayList);
            if (this.R0.supportTitle().booleanValue() && this.W0 == 0 && this.X0 == 0) {
                y93.n(this.H0, 300L);
            } else {
                y93.n(this.I0, 300L);
            }
            r3();
            if (this.L0.getLeftCount() == 0) {
                u3();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091cf9) {
                w93.onEvent("pub_clk");
                z3();
            } else if (id == R.id.obfuscated_res_0x7f09052b) {
                w93.onEvent("cancel_clk");
                E3();
            } else if (id == R.id.obfuscated_res_0x7f09013a) {
                w93.onEvent("pic_clk_bar");
                aa3.i(this.L0.getLeftCount(), this);
            } else if (id == R.id.obfuscated_res_0x7f09070a) {
                this.H0.setText("");
            }
        }
    }

    public final void r3() {
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            List<String> y3 = y3();
            if (!this.R0.supportTitle().booleanValue() ? !(((i2 = this.X0) <= 0 || i2 > 4999) && (y3 == null || y3.size() <= 0)) : !(this.W0 <= 0 || (this.X0 <= 0 && (y3 == null || y3.size() <= 0)))) {
                z = true;
            } else {
                z = false;
            }
            if (z && !this.O0.isClickable()) {
                this.O0.setClickable(true);
                this.O0.setTextColor(this.R0.getPublishTextColor());
            } else if (!z && this.O0.isClickable()) {
                this.O0.setClickable(false);
                this.O0.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060b07));
            }
        }
    }

    public final void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (b1) {
                Log.d("SwanAppPublisher", "go publish");
            }
            if (!SwanAppNetworkUtils.i(getContext())) {
                aa3.h(getContext(), R.string.obfuscated_res_0x7f0f1511);
            } else if (this.U0 == null) {
            } else {
                String obj = this.H0.getText().toString();
                String obj2 = this.I0.getText().toString();
                List<String> y3 = y3();
                if (this.R0.supportTitle().booleanValue() && TextUtils.isEmpty(obj.trim())) {
                    aa3.h(getContext(), R.string.obfuscated_res_0x7f0f150e);
                } else if (TextUtils.isEmpty(obj2.trim()) && (y3 == null || y3.size() == 0)) {
                    aa3.h(getContext(), R.string.obfuscated_res_0x7f0f150e);
                } else if (y3 != null && y3.size() > 0) {
                    ViewGroup viewGroup = (ViewGroup) getActivity().findViewById(16908290);
                    hb3.h(getContext(), viewGroup, getResources().getString(R.string.obfuscated_res_0x7f0f1510));
                    this.O0.setClickable(false);
                    this.O0.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060b07));
                    to3.f().execute(new l(this, y3, obj, obj2, viewGroup));
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (!obj.isEmpty()) {
                            jSONObject.put("title", this.H0.getText().toString());
                        }
                        if (!obj2.isEmpty()) {
                            jSONObject.put("content", this.I0.getText().toString());
                        }
                        if (b1) {
                            Log.d("SwanAppPublisher", "publish result " + jSONObject.toString());
                        }
                        k93.a();
                        this.U0.a(jSONObject);
                    } catch (JSONException e2) {
                        if (b1) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

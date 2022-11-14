package com.baidu.tieba.im.chat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AbsMsgImageActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.kd7;
import com.baidu.tieba.lv4;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public abstract class AbsMsgImageActivity extends BaseActivity<AbsMsgImageActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedHashMap<String, String> a;
    public int b;
    public g c;
    public View d;
    public FrameLayout e;
    public TextView f;
    public NavigationBar g;
    public MultiImageView h;
    public View.OnClickListener i;
    public BaseViewPager.a j;
    public ViewPager.OnPageChangeListener k;
    public AlphaAnimation l;
    public boolean m;
    public boolean n;
    public int o;
    public String p;
    public String q;
    public String r;
    public String s;
    public long t;
    public HashMap<String, Boolean> u;
    public int v;
    public boolean w;
    public PermissionJudgePolicy x;

    public abstract void h2(String str, kd7 kd7Var);

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsMsgImageActivity a;

        /* renamed from: com.baidu.tieba.im.chat.AbsMsgImageActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class animation.Animation$AnimationListenerC0301a implements Animation.AnimationListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                }
            }

            public animation.Animation$AnimationListenerC0301a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, animation) != null) {
                    return;
                }
                this.a.a.m = true;
                if (!this.a.a.n) {
                    return;
                }
                this.a.a.n = false;
                this.a.a.g.setVisibility(8);
            }
        }

        public a(AbsMsgImageActivity absMsgImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsgImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absMsgImageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.d) {
                    if (this.a.g.getVisibility() == 8) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("index", this.a.b);
                    this.a.setResult(-1, intent);
                    this.a.finish();
                } else if (view2 == this.a.e) {
                    if (this.a.g.getVisibility() == 8) {
                        return;
                    }
                    Activity pageActivity = this.a.getPageContext().getPageActivity();
                    if (this.a.x == null) {
                        this.a.x = new PermissionJudgePolicy();
                    }
                    this.a.x.clearRequestPermissionList();
                    this.a.x.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.x.startRequestPermission(pageActivity)) {
                        return;
                    }
                    try {
                        byte[] currentImageData = this.a.h.getCurrentImageData();
                        if (currentImageData != null) {
                            String currentImageUrl = this.a.h.getCurrentImageUrl();
                            this.a.c = new g(this.a, currentImageUrl, currentImageData);
                            this.a.c.execute(new String[0]);
                            this.a.e.setClickable(false);
                        } else {
                            this.a.showToast(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c9b));
                        }
                    } catch (Exception unused) {
                    }
                } else if (!this.a.m) {
                } else {
                    if (this.a.g.getVisibility() != 0) {
                        this.a.g.setVisibility(0);
                        this.a.h.D();
                        this.a.l = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        this.a.l = new AlphaAnimation(1.0f, 0.0f);
                        this.a.n = true;
                        this.a.h.p();
                    }
                    this.a.l.setDuration(300L);
                    this.a.l.setFillAfter(true);
                    this.a.l.setAnimationListener(new animation.Animation$AnimationListenerC0301a(this));
                    this.a.m = false;
                    this.a.g.startAnimation(this.a.l);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsMsgImageActivity a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        public b(AbsMsgImageActivity absMsgImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsgImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absMsgImageActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                AbsMsgImageActivity absMsgImageActivity = this.a;
                absMsgImageActivity.e2(absMsgImageActivity.b, i);
                this.a.b = i;
                this.a.i2();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 1 && System.nanoTime() - this.a.t > 300000000 && this.a.a != null && this.a.b < this.a.a.size()) {
                HashMap hashMap = this.a.u;
                LinkedHashMap linkedHashMap = this.a.a;
                hashMap.put(linkedHashMap.get("" + this.a.b), Boolean.TRUE);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BaseViewPager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsMsgImageActivity a;

        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public c(AbsMsgImageActivity absMsgImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsgImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absMsgImageActivity;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements lv4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsMsgImageActivity a;

        public d(AbsMsgImageActivity absMsgImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsgImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absMsgImageActivity;
        }

        @Override // com.baidu.tieba.lv4.c
        public void a(lv4 lv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, lv4Var, i, view2) == null) && lv4Var == this.a.getListMenu()) {
                if (i == 0) {
                    try {
                        Activity pageActivity = this.a.getPageContext().getPageActivity();
                        if (this.a.x == null) {
                            this.a.x = new PermissionJudgePolicy();
                        }
                        this.a.x.clearRequestPermissionList();
                        this.a.x.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.x.startRequestPermission(pageActivity)) {
                            return;
                        }
                        byte[] currentImageData = this.a.h.getCurrentImageData();
                        if (currentImageData != null) {
                            String currentImageUrl = this.a.h.getCurrentImageUrl();
                            this.a.c = new g(this.a, currentImageUrl, currentImageData);
                            this.a.c.execute(new String[0]);
                            this.a.e.setClickable(false);
                        } else {
                            this.a.showToast(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c9b));
                        }
                    } catch (Exception unused) {
                    }
                }
                lv4Var.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv4.c a;
        public final /* synthetic */ AbsMsgImageActivity b;

        public e(AbsMsgImageActivity absMsgImageActivity, lv4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsgImageActivity, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = absMsgImageActivity;
            this.a = cVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            this.b.createListMenu(new String[]{this.b.getPageContext().getString(R.string.obfuscated_res_0x7f0f10d6)}, this.a);
            this.b.showListMenu();
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements kd7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsMsgImageActivity a;

        public f(AbsMsgImageActivity absMsgImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsgImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absMsgImageActivity;
        }

        @Override // com.baidu.tieba.kd7
        public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, linkedHashMap, hashMap) == null) {
                if (linkedHashMap == null || this.a.w) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                if (linkedHashMap.isEmpty() && !TextUtils.isEmpty(this.a.p)) {
                    linkedHashMap.put(this.a.s, this.a.p);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = this.a.q;
                    imageUrlData.urlType = 10;
                    hashMap.put(this.a.p, imageUrlData);
                }
                if (linkedHashMap.size() != 0) {
                    String str = this.a.s;
                    Iterator<String> it = linkedHashMap.keySet().iterator();
                    int i = 0;
                    while (true) {
                        if (it.hasNext()) {
                            String next = it.next();
                            if (TextUtils.isEmpty(next) || TextUtils.isEmpty(str) || TextUtils.isEmpty(next) || !next.equals(str)) {
                                i++;
                            } else {
                                this.a.b = i;
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    this.a.o = linkedHashMap.size();
                    if (!z) {
                        AbsMsgImageActivity absMsgImageActivity = this.a;
                        absMsgImageActivity.b = absMsgImageActivity.o - 1;
                    }
                    this.a.f.setVisibility(0);
                    this.a.i2();
                    this.a.h.setIsFromCDN(true);
                    this.a.h.setAllowLocalUrl(true);
                    this.a.h.setAssistUrls(hashMap);
                    this.a.h.setUrlData(new ArrayList<>(linkedHashMap.values()));
                    this.a.h.setCurrentItem(this.a.b, false);
                    return;
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public byte[] b;
        public final /* synthetic */ AbsMsgImageActivity c;

        public g(AbsMsgImageActivity absMsgImageActivity, String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsgImageActivity, str, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absMsgImageActivity;
            this.a = null;
            this.b = null;
            this.a = str;
            this.b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.c = null;
            this.c.e.setClickable(true);
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onCancelled();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                int saveImageFileByUser = FileHelper.saveImageFileByUser(this.a, this.b, this.c.getPageContext().getPageActivity());
                if (saveImageFileByUser != -2) {
                    if (saveImageFileByUser != 0) {
                        return this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f10dd);
                    }
                    return this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f10de);
                }
                return FileHelper.getSdErrorString();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                super.onPostExecute((g) str);
                this.c.c = null;
                this.c.e.setClickable(true);
                this.c.showToast(str);
            }
        }
    }

    public AbsMsgImageActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = true;
        this.n = false;
        this.p = "";
        this.r = "";
        this.s = "";
        this.t = 0L;
        this.u = null;
        this.v = 0;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.h.setCurrentItem(this.b, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            setContentView(R.layout.obfuscated_res_0x7f0d03ca);
            f2(bundle);
            g2();
            d2();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, intent) == null) {
            super.onNewIntent(intent);
            setIntent(intent);
            d2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i, keyEvent)) == null) {
            if (i == 4) {
                Intent intent = new Intent();
                intent.putExtra("index", this.b);
                setResult(-1, intent);
                finish();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final int c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinkedHashMap<String, String> linkedHashMap = this.a;
            if (linkedHashMap != null && linkedHashMap.size() > 0) {
                int size = this.a.size();
                if (this.b >= size) {
                    this.b = size - 1;
                }
                if (this.b < 0) {
                    this.b = 0;
                }
            } else {
                this.b = 0;
            }
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        }
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (TextUtils.isEmpty(this.r)) {
                finish();
            }
            h2(this.r, new f(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            this.h.x();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            this.h.y();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStop();
            int i = this.b;
            e2(i, i);
            this.h.w();
            g gVar = this.c;
            if (gVar != null) {
                gVar.cancel();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.h.w();
        }
    }

    public final void e2(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            synchronized (this.u) {
                if (System.nanoTime() - this.t > 300000000 && this.a != null && i < this.a.size()) {
                    HashMap<String, Boolean> hashMap = this.u;
                    LinkedHashMap<String, String> linkedHashMap = this.a;
                    hashMap.put(linkedHashMap.get("" + i), Boolean.TRUE);
                }
                this.t = System.nanoTime();
            }
        }
    }

    public final void f2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.p = intent.getStringExtra(AbsMsgImageActivityConfig.CURRENT_URL);
                this.q = intent.getStringExtra(AbsMsgImageActivityConfig.ASSIST_URL);
                this.r = intent.getStringExtra("id");
                this.s = intent.getStringExtra(AbsMsgImageActivityConfig.ID_UNIQUE);
                this.w = intent.getBooleanExtra("isSingle", false);
                if (this.s == null) {
                    this.s = "";
                }
                if (this.r == null) {
                    this.r = "";
                }
                if (this.p == null) {
                    this.p = "";
                }
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                this.a = linkedHashMap;
                linkedHashMap.put(this.s, this.p);
                this.v = intent.getIntExtra(TbEnum.ParamKey.CHAT_MODE, 0);
                this.b = 0;
            } else if (bundle != null) {
                this.a = (LinkedHashMap) bundle.getSerializable("url");
                this.b = bundle.getInt("index", -1);
                this.r = bundle.getString("id");
                this.s = bundle.getString(AbsMsgImageActivityConfig.ID_UNIQUE);
                this.v = bundle.getInt(TbEnum.ParamKey.CHAT_MODE, 0);
                this.w = bundle.getBoolean("isSingle", false);
                if (this.s == null) {
                    this.s = "";
                }
                if (this.r == null) {
                    this.r = "";
                }
            }
            this.u = new HashMap<>();
        }
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.i = new a(this);
            this.k = new b(this);
            this.j = new c(this);
            e eVar = new e(this, new d(this));
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09168f);
            this.g = navigationBar;
            FrameLayout frameLayout = (FrameLayout) navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d03cc, this.i);
            this.e = frameLayout;
            if (this.w) {
                frameLayout.setVisibility(8);
            }
            this.d = this.g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.i);
            SkinManager.setImageResource(this.g.getBackImageView(), R.drawable.icon_return_bg);
            this.f = this.g.setTitleText("");
            MultiImageView multiImageView = (MultiImageView) findViewById(R.id.obfuscated_res_0x7f092628);
            this.h = multiImageView;
            multiImageView.setPageMargin(yi.d(getPageContext().getContext(), 8.0f));
            this.h.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
            this.h.setOnPageChangeListener(this.k);
            this.h.setItemOnclickListener(this.i);
            this.h.setCurrentItem(c2(), false);
            this.h.setOnScrollOutListener(this.j);
            this.h.setItemOnLongClickListener(eVar);
            this.h.setHasNext(false);
            this.h.setNextTitle("mNextTitle");
            this.h.setIsFromCDN(true);
            this.h.setAllowLocalUrl(true);
            int i = this.b;
            e2(i, i);
            this.f.setVisibility(4);
        }
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a != null) {
            String valueOf = String.valueOf(this.b + 1);
            if (this.o > 0) {
                valueOf = (valueOf + "/") + this.o;
            }
            if (this.h.getHasNext() && this.b == this.h.getItemNum() - 1) {
                this.f.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0904));
                this.e.setClickable(false);
                return;
            }
            this.f.setText(valueOf);
            this.e.setClickable(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBackgroundColor(this.h, R.color.black_alpha100);
            SkinManager.setBackgroundColor(this.g, R.color.common_color_10222);
            getLayoutMode().k(this.d);
            getLayoutMode().k(this.f);
            getLayoutMode().k(this.e);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putSerializable("url", this.a);
            bundle.putInt("index", this.b);
            bundle.putString("id", this.r);
            bundle.putString(AbsMsgImageActivityConfig.ID_UNIQUE, this.s);
            bundle.putInt(TbEnum.ParamKey.CHAT_MODE, this.v);
            bundle.putBoolean("isSingle", this.w);
        }
    }
}

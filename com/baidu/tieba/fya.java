package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fya {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public TbPageContext<?> a;
    @NonNull
    public NavigationBar b;
    @NonNull
    public LinearLayout c;
    @NonNull
    public LinearLayout d;
    @NonNull
    public vwa e;
    public EditorTools f;

    public fya(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull vwa vwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, linearLayout2, vwaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = navigationBar;
        this.c = linearLayout;
        this.d = linearLayout2;
        this.e = vwaVar;
    }

    @Nullable
    public ywa a(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return c(i, z);
        }
        return (ywa) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
        if (r6.getBooleanExtra(com.baidu.tbadk.core.atomData.WriteActivityConfig.KEY_NOT_USE_DRAFT, false) != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r6.getBoolean(com.baidu.tbadk.core.atomData.WriteActivityConfig.KEY_NOT_USE_DRAFT, false) != false) goto L8;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ywa b(Bundle bundle) {
        InterceptResult invokeL;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            int i = 9;
            boolean z = false;
            if (bundle != null) {
                i = bundle.getInt("type", 9);
            } else {
                if (this.a.getPageActivity() != null && (intent = this.a.getPageActivity().getIntent()) != null) {
                    i = intent.getIntExtra("type", 9);
                }
                z = true;
                return c(i, z);
            }
        } else {
            return (ywa) invokeL.objValue;
        }
    }

    public final ywa c(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (this.a.getPageActivity() == null) {
                return null;
            }
            this.b.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
            this.b.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
            this.c.removeAllViews();
            this.d.removeAllViews();
            EditorTools editorTools = new EditorTools(this.a.getPageActivity());
            this.f = editorTools;
            this.d.addView(editorTools);
            switch (i) {
                case 11:
                    return new qya(this.a, this.b, this.c, this.f, this.e, z);
                case 12:
                    return new mya(this.a, this.b, this.c, this.f, this.e, z);
                case 13:
                    return new nya(this.a, this.b, this.c, this.f, this.e, z);
                case 14:
                    return new pya(this.a, this.b, this.c, this.f, this.e, z);
                case 15:
                    return new lya(this.a, this.b, this.c, this.f, this.e, z);
                default:
                    return new oya(this.a, this.b, this.c, this.f, this.e, z);
            }
        }
        return (ywa) invokeCommon.objValue;
    }
}

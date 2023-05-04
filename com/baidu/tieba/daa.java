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
/* loaded from: classes4.dex */
public class daa {
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
    public t8a e;
    public EditorTools f;

    public daa(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull t8a t8aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, linearLayout2, t8aVar};
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
        this.e = t8aVar;
    }

    @Nullable
    public w8a a(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return c(i, z);
        }
        return (w8a) invokeCommon.objValue;
    }

    @Nullable
    public w8a b(Bundle bundle) {
        InterceptResult invokeL;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            int i = 9;
            if (bundle != null) {
                i = bundle.getInt("type", 9);
            } else if (this.a.getPageActivity() != null && (intent = this.a.getPageActivity().getIntent()) != null) {
                i = intent.getIntExtra("type", 9);
            }
            return c(i, true);
        }
        return (w8a) invokeL.objValue;
    }

    public final w8a c(int i, boolean z) {
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
                    return new oaa(this.a, this.b, this.c, this.f, this.e, z);
                case 12:
                    return new kaa(this.a, this.b, this.c, this.f, this.e, z);
                case 13:
                    return new laa(this.a, this.b, this.c, this.f, this.e, z);
                case 14:
                    return new naa(this.a, this.b, this.c, this.f, this.e, z);
                case 15:
                    return new jaa(this.a, this.b, this.c, this.f, this.e, z);
                default:
                    return new maa(this.a, this.b, this.c, this.f, this.e, z);
            }
        }
        return (w8a) invokeCommon.objValue;
    }
}

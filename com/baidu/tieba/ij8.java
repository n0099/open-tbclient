package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ij8 extends fj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ij8(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    @Override // com.baidu.tieba.lj8
    public void a(ShareEntity shareEntity, mj8 mj8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, shareEntity, mj8Var) == null) {
            if (shareEntity != null && !TextUtils.isEmpty(shareEntity.getContent())) {
                if (TextUtils.isEmpty(shareEntity.getContent())) {
                    str = shareEntity.getTitle() + shareEntity.getLinkUrl();
                } else {
                    str = shareEntity.getContent() + shareEntity.getLinkUrl();
                }
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", str);
                intent.setType("text/plain");
                Context context = this.b;
                if (nj8.startActivity(context, Intent.createChooser(intent, context.getString(R.string.share_to)))) {
                    if (mj8Var != null) {
                        mj8Var.b1(0, 1);
                        return;
                    }
                    return;
                } else if (mj8Var != null) {
                    mj8Var.b1(0, 2);
                    return;
                } else {
                    return;
                }
            }
            xi.O(d(), R.string.obfuscated_res_0x7f0f1184);
            if (mj8Var != null) {
                mj8Var.b1(0, 2);
            }
        }
    }
}

package com.baidu.tieba.enterForum.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class LikeForumCreateViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public ImageView c;
    public TextView d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LikeForumCreateViewHolder(@NonNull View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091f6b);
        this.a = findViewById;
        this.b = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091881);
        this.c = (ImageView) this.a.findViewById(R.id.forum_avatar);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090bd3);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            WebPManager.setMaskDrawable(this.c, R.drawable.obfuscated_res_0x7f080998, WebPManager.ResourceStateType.NORMAL);
        }
    }
}

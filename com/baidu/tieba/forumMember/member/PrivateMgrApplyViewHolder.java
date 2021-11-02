package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PrivateMgrApplyViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout mAssistApplyLayout;
    public TextView mAssistRemainNum;
    public View mLineView;
    public LinearLayout mRootLayout;
    public int mSkinType;
    public TextView mTipAssistLeft;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateMgrApplyViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSkinType = 3;
        this.mRootLayout = (LinearLayout) view.findViewById(R.id.root_private_member_apply);
        this.mLineView = view.findViewById(R.id.private_apply_line);
        this.mTipAssistLeft = (TextView) view.findViewById(R.id.private_apply_tip);
        this.mAssistRemainNum = (TextView) view.findViewById(R.id.private_left_tv);
        this.mAssistApplyLayout = (RelativeLayout) view.findViewById(R.id.private_apply_layout);
    }
}

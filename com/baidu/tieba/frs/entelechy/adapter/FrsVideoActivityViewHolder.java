package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.r0.x0.f1;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class FrsVideoActivityViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View bottomDivider;
    public ImageView mMoreImageView;
    public ImageView mTipImageView;
    public TextView mTitleTv;
    public TextView mTypeTv;
    public View topDivider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsVideoActivityViewHolder(View view) {
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
        if (view != null) {
            this.mTitleTv = (TextView) view.findViewById(f1.video_activity_item_title);
            this.mTipImageView = (ImageView) view.findViewById(f1.video_activity_item_tip);
            this.mTypeTv = (TextView) view.findViewById(f1.video_activity_item_type);
            this.mMoreImageView = (ImageView) view.findViewById(f1.video_activity_item_more);
            this.topDivider = view.findViewById(f1.top_divider_line);
            this.bottomDivider = view.findViewById(f1.bottom_divider_line);
        }
    }
}

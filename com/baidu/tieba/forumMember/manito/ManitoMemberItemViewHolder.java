package com.baidu.tieba.forumMember.manito;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ManitoMemberItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View dividerLine;
    public TextView fans;
    public GodHeadImageView head;
    public TextView intro;
    public int mSkinType;
    public TextView name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManitoMemberItemViewHolder(View view) {
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
        GodHeadImageView godHeadImageView = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.head = godHeadImageView;
        godHeadImageView.setShapeType(0);
        this.head.setShowType(1);
        this.head.setRadius(14);
        this.name = (TextView) view.findViewById(R.id.item_manito_name);
        this.intro = (TextView) view.findViewById(R.id.item_manito_intro);
        this.fans = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}

package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.r0.j1.e;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class HotRankListManualItemHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View dividerLineBottom;
    public View dividerLineTop;
    public int skinType;
    public TextView topicDesc;
    public LinearLayout topicManualItem;
    public TextView topicModule;
    public TextView topicNeme;
    public TbImageView topicPic;
    public TextView topicTagPic;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotRankListManualItemHolder(View view) {
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
        this.skinType = 3;
        this.topicModule = null;
        this.topicNeme = null;
        this.topicDesc = null;
        this.topicTagPic = null;
        this.dividerLineTop = null;
        this.dividerLineBottom = null;
        this.topicPic = null;
        this.topicManualItem = null;
        this.topicModule = (TextView) view.findViewById(e.topic_module);
        this.topicDesc = (TextView) view.findViewById(e.topic_desc);
        this.topicNeme = (TextView) view.findViewById(e.topic_title);
        this.topicPic = (TbImageView) view.findViewById(e.topic_pic);
        this.dividerLineTop = view.findViewById(e.devide_line_top);
        this.dividerLineBottom = view.findViewById(e.devide_line_bottom);
        this.topicManualItem = (LinearLayout) view.findViewById(e.topic_manual_item);
    }
}

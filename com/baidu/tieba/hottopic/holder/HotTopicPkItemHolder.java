package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import c.a.t0.r1.e;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class HotTopicPkItemHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView moduleName;
    public TextView pkOpposing;
    public TextView pkPositive;
    public TextView pkQuesDesc;
    public HotTopicPkView pkView;
    public int skinType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicPkItemHolder(View view) {
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
        a(view);
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
            return;
        }
        this.moduleName = (TextView) view.findViewById(e.pk_item_theme_title);
        this.pkQuesDesc = (TextView) view.findViewById(e.pk_topic_title);
        this.pkView = (HotTopicPkView) view.findViewById(e.pk_topic_view);
        this.pkPositive = (TextView) view.findViewById(e.pk_topic_positive);
        this.pkOpposing = (TextView) view.findViewById(e.pk_topic_opposing);
    }
}

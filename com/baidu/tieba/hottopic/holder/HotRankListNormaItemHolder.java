package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.r0.p1.e;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class HotRankListNormaItemHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View dividerLineBottom;
    public View dividerLineTop;
    public int skinType;
    public LinearLayout tipInfoItem;
    public TextView tipRule;
    public LinearLayout tipRuleContainer;
    public TextView tipTitle;
    public TextView topicDiscussNum;
    public TextView topicNeme;
    public LinearLayout topicNormalItem;
    public TextView topicRanking;
    public ImageView topicTagPic;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotRankListNormaItemHolder(View view) {
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
        this.topicRanking = null;
        this.topicNeme = null;
        this.topicDiscussNum = null;
        this.dividerLineTop = null;
        this.dividerLineBottom = null;
        this.topicTagPic = null;
        this.tipInfoItem = null;
        this.tipTitle = null;
        this.tipRule = null;
        this.topicNormalItem = null;
        this.tipRuleContainer = null;
        this.topicRanking = (TextView) view.findViewById(e.hot_topic_rank);
        this.topicNeme = (TextView) view.findViewById(e.hot_topic_title);
        this.topicDiscussNum = (TextView) view.findViewById(e.hot_topic_num);
        this.dividerLineTop = view.findViewById(e.devide_line_top);
        this.dividerLineBottom = view.findViewById(e.topic_devide_line_bottom);
        this.topicTagPic = (ImageView) view.findViewById(e.hot_topic_pic);
        this.tipInfoItem = (LinearLayout) view.findViewById(e.tip_info_item);
        this.tipTitle = (TextView) view.findViewById(e.tip_info_title);
        this.tipRule = (TextView) view.findViewById(e.tip_info_rule);
        this.topicNormalItem = (LinearLayout) view.findViewById(e.topic_normal_item);
        this.tipRuleContainer = (LinearLayout) view.findViewById(e.tip_rule_container);
    }
}

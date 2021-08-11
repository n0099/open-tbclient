package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class QualityThreadItemHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View contentDividerLine;
    public TextView descView;
    public TextView frsNameView;
    public TextView moduleTheme;
    public TextView replyTextView;
    public View rootView;
    public int skinType;
    public TbImageView threadImg;
    public RelativeLayout threadView;
    public TextView titleView;
    public View topDivilerLine;
    public TextView zanTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QualityThreadItemHolder(View view) {
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
        this.rootView = null;
        this.topDivilerLine = null;
        this.moduleTheme = null;
        this.threadView = null;
        this.contentDividerLine = null;
        this.threadImg = null;
        this.rootView = view;
        a(view);
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
            return;
        }
        this.topDivilerLine = view.findViewById(R.id.top_divider_line);
        this.moduleTheme = (TextView) view.findViewById(R.id.quality_item_theme_title);
        this.contentDividerLine = view.findViewById(R.id.divider_line);
        this.threadView = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
        this.threadImg = (TbImageView) view.findViewById(R.id.img);
        this.titleView = (TextView) view.findViewById(R.id.title);
        this.descView = (TextView) view.findViewById(R.id.desc);
        this.frsNameView = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
        this.zanTextView = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
        this.replyTextView = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
    }
}

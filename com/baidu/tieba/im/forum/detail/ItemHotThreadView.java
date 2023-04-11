package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.hi;
import com.baidu.tieba.hv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import tbclient.Abstract;
import tbclient.SimpleThreadInfo;
/* loaded from: classes4.dex */
public class ItemHotThreadView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public HashMap<String, View> b;
    public List<SimpleThreadInfo> c;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ItemHotThreadView b;

        public a(ItemHotThreadView itemHotThreadView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemHotThreadView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = itemHotThreadView;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.eventStat(this.b.a, "detail_hot_thread", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.b.a).createNormalCfg(this.a, "", "")));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemHotThreadView(Context context) {
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
        this.b = new HashMap<>();
        c(context);
    }

    public void setData(List<SimpleThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.c = list;
            if (list != null && list.size() != 0) {
                setVisibility(0);
                for (int i = 0; i < list.size(); i++) {
                    boolean z = true;
                    if (i == list.size() - 1) {
                        z = false;
                    }
                    b(list.get(i), z);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        c(context);
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.a = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02c5, (ViewGroup) this, true);
            setVisibility(8);
        }
    }

    public final void b(SimpleThreadInfo simpleThreadInfo, boolean z) {
        View view2;
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, simpleThreadInfo, z) != null) || simpleThreadInfo == null) {
            return;
        }
        if (!this.b.containsKey(String.valueOf(simpleThreadInfo.tid))) {
            view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d02c6, (ViewGroup) this, false);
            bVar = new b(null);
            bVar.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f092389);
            bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f5b);
            bVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f59);
            bVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f5a);
            bVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f58);
            view2.setTag(bVar);
            this.b.put(String.valueOf(simpleThreadInfo.tid), view2);
            addView(view2);
        } else {
            view2 = this.b.get(String.valueOf(simpleThreadInfo.tid));
            bVar = (b) view2.getTag();
        }
        bVar.b.setText(simpleThreadInfo.title);
        StringBuilder sb = new StringBuilder();
        List<Abstract> list = simpleThreadInfo._abstract;
        if (list != null && list.size() != 0) {
            int size = simpleThreadInfo._abstract.size();
            for (int i = 0; i < size; i++) {
                if (simpleThreadInfo._abstract.get(i) != null && simpleThreadInfo._abstract.get(i).type.intValue() == 0) {
                    sb.append(simpleThreadInfo._abstract.get(i).text);
                }
            }
        }
        if (!hi.isEmpty(sb.toString().trim())) {
            bVar.c.setText(sb.toString());
            bVar.c.setVisibility(0);
        } else {
            bVar.c.setVisibility(8);
        }
        bVar.d.setText(String.valueOf(simpleThreadInfo.reply_num));
        SkinManager.setBackgroundResource(bVar.a, R.drawable.live_frs_list_item_bg);
        SkinManager.setViewTextColor(bVar.b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(bVar.c, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(bVar.d, R.color.CAM_X0304, 1);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_ba_comment);
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        bVar.d.setCompoundDrawables(bitmapDrawable, null, null, null);
        SkinManager.setBackgroundResource(bVar.e, R.color.CAM_X0204);
        if (z) {
            bVar.e.setVisibility(0);
        } else {
            bVar.e.setVisibility(8);
        }
        view2.setOnClickListener(new a(this, String.valueOf(simpleThreadInfo.tid)));
    }

    public void d(ForumDetailActivity forumDetailActivity, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, forumDetailActivity, i) == null) {
            hv4 layoutMode = forumDetailActivity.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            forumDetailActivity.getLayoutMode().k(this);
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setData(this.c);
        }
    }
}

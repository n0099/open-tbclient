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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import java.util.HashMap;
import java.util.List;
import tbclient.Abstract;
import tbclient.SimpleThreadInfo;
/* loaded from: classes4.dex */
public class ItemHotThreadView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f17589e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, View> f17590f;

    /* renamed from: g  reason: collision with root package name */
    public List<SimpleThreadInfo> f17591g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17592e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ItemHotThreadView f17593f;

        public a(ItemHotThreadView itemHotThreadView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemHotThreadView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17593f = itemHotThreadView;
            this.f17592e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f17593f.f17589e, "detail_hot_thread", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f17593f.f17589e).createNormalCfg(this.f17592e, "", "")));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f17594a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17595b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17596c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17597d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17598e;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17590f = new HashMap<>();
        c(context);
    }

    public final void b(SimpleThreadInfo simpleThreadInfo, boolean z) {
        View view;
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, simpleThreadInfo, z) == null) || simpleThreadInfo == null) {
            return;
        }
        if (!this.f17590f.containsKey(String.valueOf(simpleThreadInfo.tid))) {
            view = LayoutInflater.from(this.f17589e).inflate(R.layout.forum_detail_hot_thread_item, (ViewGroup) this, false);
            bVar = new b(null);
            bVar.f17594a = (LinearLayout) view.findViewById(R.id.thread_item_ll);
            bVar.f17595b = (TextView) view.findViewById(R.id.ht_item_title);
            bVar.f17596c = (TextView) view.findViewById(R.id.ht_item_content);
            bVar.f17597d = (TextView) view.findViewById(R.id.ht_item_reply);
            bVar.f17598e = (TextView) view.findViewById(R.id.ht_divider_line);
            view.setTag(bVar);
            this.f17590f.put(String.valueOf(simpleThreadInfo.tid), view);
            addView(view);
        } else {
            view = this.f17590f.get(String.valueOf(simpleThreadInfo.tid));
            bVar = (b) view.getTag();
        }
        bVar.f17595b.setText(simpleThreadInfo.title);
        StringBuilder sb = new StringBuilder();
        List<Abstract> list = simpleThreadInfo._abstract;
        if (list != null && list.size() != 0) {
            int size = simpleThreadInfo._abstract.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (simpleThreadInfo._abstract.get(i2) != null && simpleThreadInfo._abstract.get(i2).type.intValue() == 0) {
                    sb.append(simpleThreadInfo._abstract.get(i2).text);
                }
            }
        }
        if (!k.isEmpty(sb.toString().trim())) {
            bVar.f17596c.setText(sb.toString());
            bVar.f17596c.setVisibility(0);
        } else {
            bVar.f17596c.setVisibility(8);
        }
        bVar.f17597d.setText(String.valueOf(simpleThreadInfo.reply_num));
        SkinManager.setBackgroundResource(bVar.f17594a, R.drawable.live_frs_list_item_bg);
        SkinManager.setViewTextColor(bVar.f17595b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(bVar.f17596c, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(bVar.f17597d, R.color.CAM_X0304, 1);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_ba_comment);
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        bVar.f17597d.setCompoundDrawables(bitmapDrawable, null, null, null);
        SkinManager.setBackgroundResource(bVar.f17598e, R.color.CAM_X0204);
        if (z) {
            bVar.f17598e.setVisibility(0);
        } else {
            bVar.f17598e.setVisibility(8);
        }
        view.setOnClickListener(new a(this, String.valueOf(simpleThreadInfo.tid)));
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f17589e = context;
            LayoutInflater.from(context).inflate(R.layout.forum_detail_hot_thread, (ViewGroup) this, true);
            setVisibility(8);
        }
    }

    public void d(ForumDetailActivity forumDetailActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, forumDetailActivity, i2) == null) {
            forumDetailActivity.getLayoutMode().k(i2 == 1);
            forumDetailActivity.getLayoutMode().j(this);
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setData(this.f17591g);
        }
    }

    public void setData(List<SimpleThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f17591g = list;
            if (list == null || list.size() == 0) {
                return;
            }
            setVisibility(0);
            for (int i2 = 0; i2 < list.size(); i2++) {
                boolean z = true;
                if (i2 == list.size() - 1) {
                    z = false;
                }
                b(list.get(i2), z);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f17590f = new HashMap<>();
        c(context);
    }
}

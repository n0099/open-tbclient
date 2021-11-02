package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.e.p.k;
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
import java.util.HashMap;
import java.util.List;
import tbclient.Abstract;
import tbclient.SimpleThreadInfo;
/* loaded from: classes9.dex */
public class ItemHotThreadView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f50417e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, View> f50418f;

    /* renamed from: g  reason: collision with root package name */
    public List<SimpleThreadInfo> f50419g;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50420e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ItemHotThreadView f50421f;

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
            this.f50421f = itemHotThreadView;
            this.f50420e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f50421f.f50417e, "detail_hot_thread", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f50421f.f50417e).createNormalCfg(this.f50420e, "", "")));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f50422a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f50423b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f50424c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f50425d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f50426e;

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
        this.f50418f = new HashMap<>();
        init(context);
    }

    public final void b(SimpleThreadInfo simpleThreadInfo, boolean z) {
        View view;
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, simpleThreadInfo, z) == null) || simpleThreadInfo == null) {
            return;
        }
        if (!this.f50418f.containsKey(String.valueOf(simpleThreadInfo.tid))) {
            view = LayoutInflater.from(this.f50417e).inflate(R.layout.forum_detail_hot_thread_item, (ViewGroup) this, false);
            bVar = new b(null);
            bVar.f50422a = (LinearLayout) view.findViewById(R.id.thread_item_ll);
            bVar.f50423b = (TextView) view.findViewById(R.id.ht_item_title);
            bVar.f50424c = (TextView) view.findViewById(R.id.ht_item_content);
            bVar.f50425d = (TextView) view.findViewById(R.id.ht_item_reply);
            bVar.f50426e = (TextView) view.findViewById(R.id.ht_divider_line);
            view.setTag(bVar);
            this.f50418f.put(String.valueOf(simpleThreadInfo.tid), view);
            addView(view);
        } else {
            view = this.f50418f.get(String.valueOf(simpleThreadInfo.tid));
            bVar = (b) view.getTag();
        }
        bVar.f50423b.setText(simpleThreadInfo.title);
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
            bVar.f50424c.setText(sb.toString());
            bVar.f50424c.setVisibility(0);
        } else {
            bVar.f50424c.setVisibility(8);
        }
        bVar.f50425d.setText(String.valueOf(simpleThreadInfo.reply_num));
        SkinManager.setBackgroundResource(bVar.f50422a, R.drawable.live_frs_list_item_bg);
        SkinManager.setViewTextColor(bVar.f50423b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(bVar.f50424c, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(bVar.f50425d, R.color.CAM_X0304, 1);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_ba_comment);
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        bVar.f50425d.setCompoundDrawables(bitmapDrawable, null, null, null);
        SkinManager.setBackgroundResource(bVar.f50426e, R.color.CAM_X0204);
        if (z) {
            bVar.f50426e.setVisibility(0);
        } else {
            bVar.f50426e.setVisibility(8);
        }
        view.setOnClickListener(new a(this, String.valueOf(simpleThreadInfo.tid)));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setData(this.f50419g);
        }
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f50417e = context;
            LayoutInflater.from(context).inflate(R.layout.forum_detail_hot_thread, (ViewGroup) this, true);
            setVisibility(8);
        }
    }

    public void onChangeSkinType(ForumDetailActivity forumDetailActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, forumDetailActivity, i2) == null) {
            forumDetailActivity.getLayoutMode().k(i2 == 1);
            forumDetailActivity.getLayoutMode().j(this);
            c();
        }
    }

    public void setData(List<SimpleThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f50419g = list;
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
        this.f50418f = new HashMap<>();
        init(context);
    }
}

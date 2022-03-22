package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import c.a.p0.u1.f.h;
import c.a.p0.u1.w.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.OfficialHistoryImageActivityConfig;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class OfficialBarHistoryAdapter extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f33728b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f33729c;

    /* renamed from: d  reason: collision with root package name */
    public List<ResponseHistoryMessage.a> f33730d;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarHistoryAdapter a;

        public a(OfficialBarHistoryAdapter officialBarHistoryAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarHistoryAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarHistoryAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (intValue = ((Integer) view.getTag()).intValue()) < 0 || intValue >= this.a.f33730d.size()) {
                return;
            }
            ResponseHistoryMessage.a aVar = (ResponseHistoryMessage.a) this.a.f33730d.get(intValue);
            String f2 = c.f(PreferencesUtil.LEFT_MOUNT + aVar.f33756c + PreferencesUtil.RIGHT_MOUNT, true);
            if (f2 == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialHistoryImageActivityConfig(this.a.a, f2, String.valueOf(aVar.f33757d))));
        }
    }

    public OfficialBarHistoryAdapter(BaseActivity baseActivity, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33729c = new a(this);
        this.a = context;
        this.f33728b = baseActivity;
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i, view, viewGroup)) == null) {
            ResponseHistoryMessage.a aVar = (ResponseHistoryMessage.a) getItem(i);
            if (aVar != null && aVar.f33756c != null) {
                int itemViewType = getItemViewType(i);
                if (itemViewType == 0) {
                    if (view == null) {
                        view = new HistoryItemView(this.a);
                    }
                    HistoryItemView historyItemView = (HistoryItemView) view;
                    historyItemView.setClickable(false);
                    historyItemView.setTime(aVar.a);
                    ChatMessage chatMessage = new ChatMessage(this, 501126) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ OfficialBarHistoryAdapter this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r8);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(r8)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
                        public Object encode() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                                return null;
                            }
                            return invokeV.objValue;
                        }
                    };
                    chatMessage.setContent(aVar.f33756c);
                    chatMessage.setMsgType(aVar.f33755b);
                    h.e(historyItemView.getRichTextView(), chatMessage, "official_history_adapter", 0);
                } else if (itemViewType == 1) {
                    if (view == null) {
                        view = new HistoryItemView(this.a);
                    }
                    HistoryItemView historyItemView2 = (HistoryItemView) view;
                    historyItemView2.setClickable(false);
                    historyItemView2.setTime(aVar.a);
                    ChatMessage chatMessage2 = new ChatMessage(this, 501126) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ OfficialBarHistoryAdapter this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r8);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(r8)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
                        public Object encode() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                                return null;
                            }
                            return invokeV.objValue;
                        }
                    };
                    chatMessage2.setContent(PreferencesUtil.LEFT_MOUNT + aVar.f33756c + PreferencesUtil.RIGHT_MOUNT);
                    chatMessage2.setMsgType(aVar.f33755b);
                    h.d(this.a, view, historyItemView2.getImageView(), chatMessage2, 0L, "official_history_adapter");
                    historyItemView2.getImageView().setTag(Integer.valueOf(i));
                    historyItemView2.getImageView().setOnClickListener(this.f33729c);
                } else if (itemViewType == 2) {
                    if (view == null) {
                        view = new HistoryItemView(this.a);
                    }
                    MultiContentView multiContentView = new MultiContentView(this.a);
                    multiContentView.setNeedNightMode(true);
                    multiContentView.setTime(aVar.a);
                    multiContentView.setData(this.f33728b.getPageContext(), c.a.p0.u1.l.c.a.a(aVar.f33756c, "", 0L, 0L), viewGroup);
                    ((HistoryItemView) view).a(multiContentView);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void c(List<ResponseHistoryMessage.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f33730d = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<ResponseHistoryMessage.a> list = this.f33730d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (this.f33730d == null || i >= getCount()) {
                return null;
            }
            return this.f33730d.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            List<ResponseHistoryMessage.a> list = this.f33730d;
            if (list == null || i >= list.size()) {
                return 0L;
            }
            return i;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            List<ResponseHistoryMessage.a> list = this.f33730d;
            if (list == null || i >= list.size()) {
                return 0;
            }
            int i2 = this.f33730d.get(i).f33755b;
            if (i2 != 2) {
                return i2 != 7 ? 0 : 2;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view, viewGroup)) == null) ? b(i, view, viewGroup) : (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }
}

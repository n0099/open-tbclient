package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import c.a.p0.j1.f.h;
import c.a.p0.j1.w.c;
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
/* loaded from: classes7.dex */
public class OfficialBarHistoryAdapter extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f52664e;

    /* renamed from: f  reason: collision with root package name */
    public BaseActivity f52665f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f52666g;

    /* renamed from: h  reason: collision with root package name */
    public List<ResponseHistoryMessage.a> f52667h;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarHistoryAdapter f52668e;

        public a(OfficialBarHistoryAdapter officialBarHistoryAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarHistoryAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52668e = officialBarHistoryAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (intValue = ((Integer) view.getTag()).intValue()) < 0 || intValue >= this.f52668e.f52667h.size()) {
                return;
            }
            ResponseHistoryMessage.a aVar = (ResponseHistoryMessage.a) this.f52668e.f52667h.get(intValue);
            String f2 = c.f(PreferencesUtil.LEFT_MOUNT + aVar.f52707c + PreferencesUtil.RIGHT_MOUNT, true);
            if (f2 == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialHistoryImageActivityConfig(this.f52668e.f52664e, f2, String.valueOf(aVar.f52708d))));
        }
    }

    public OfficialBarHistoryAdapter(BaseActivity baseActivity, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52666g = new a(this);
        this.f52664e = context;
        this.f52665f = baseActivity;
    }

    public final View b(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
            ResponseHistoryMessage.a aVar = (ResponseHistoryMessage.a) getItem(i2);
            if (aVar != null && aVar.f52707c != null) {
                int itemViewType = getItemViewType(i2);
                if (itemViewType == 0) {
                    if (view == null) {
                        view = new HistoryItemView(this.f52664e);
                    }
                    HistoryItemView historyItemView = (HistoryItemView) view;
                    historyItemView.setClickable(false);
                    historyItemView.setTime(aVar.f52705a);
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
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
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
                    chatMessage.setContent(aVar.f52707c);
                    chatMessage.setMsgType(aVar.f52706b);
                    h.e(this.f52664e, historyItemView.getRichTextView(), chatMessage, "official_history_adapter", 0);
                } else if (itemViewType == 1) {
                    if (view == null) {
                        view = new HistoryItemView(this.f52664e);
                    }
                    HistoryItemView historyItemView2 = (HistoryItemView) view;
                    historyItemView2.setClickable(false);
                    historyItemView2.setTime(aVar.f52705a);
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
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
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
                    chatMessage2.setContent(PreferencesUtil.LEFT_MOUNT + aVar.f52707c + PreferencesUtil.RIGHT_MOUNT);
                    chatMessage2.setMsgType(aVar.f52706b);
                    h.d(this.f52664e, view, historyItemView2.getImageView(), chatMessage2, 0L, "official_history_adapter");
                    historyItemView2.getImageView().setTag(Integer.valueOf(i2));
                    historyItemView2.getImageView().setOnClickListener(this.f52666g);
                } else if (itemViewType == 2) {
                    if (view == null) {
                        view = new HistoryItemView(this.f52664e);
                    }
                    MultiContentView multiContentView = new MultiContentView(this.f52664e);
                    multiContentView.setNeedNightMode(true);
                    multiContentView.setTime(aVar.f52705a);
                    multiContentView.setData(this.f52665f.getPageContext(), c.a.p0.j1.l.c.a.a(aVar.f52707c, "", 0L, 0L), viewGroup);
                    ((HistoryItemView) view).addMultiView(multiContentView);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void c(List<ResponseHistoryMessage.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f52667h = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<ResponseHistoryMessage.a> list = this.f52667h;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (this.f52667h == null || i2 >= getCount()) {
                return null;
            }
            return this.f52667h.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<ResponseHistoryMessage.a> list = this.f52667h;
            if (list == null || i2 >= list.size()) {
                return 0L;
            }
            return i2;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            List<ResponseHistoryMessage.a> list = this.f52667h;
            if (list == null || i2 >= list.size()) {
                return 0;
            }
            int i3 = this.f52667h.get(i2).f52706b;
            if (i3 != 2) {
                return i3 != 7 ? 0 : 2;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) ? b(i2, view, viewGroup) : (View) invokeILL.objValue;
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

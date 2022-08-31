package com.baidu.tieba;

import android.widget.ListView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class ib7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<hb7> a;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ListView a;
        public final /* synthetic */ List b;
        public final /* synthetic */ hb7 c;
        public final /* synthetic */ ChatMessage d;
        public final /* synthetic */ ChatMessage e;

        public a(ib7 ib7Var, ListView listView, List list, hb7 hb7Var, ChatMessage chatMessage, ChatMessage chatMessage2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib7Var, listView, list, hb7Var, chatMessage, chatMessage2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = listView;
            this.b = list;
            this.c = hb7Var;
            this.d = chatMessage;
            this.e = chatMessage2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.getLastVisiblePosition() == this.b.size() - 1) {
                this.c.b(this.a, this.d, this.e);
            }
        }
    }

    public ib7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList<hb7> arrayList = new ArrayList<>(2);
        this.a = arrayList;
        arrayList.add(new gb7());
        this.a.add(new jb7());
    }

    public void a(MsglistModel msglistModel, ListView listView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, msglistModel, listView) == null) || msglistModel == null || msglistModel.getData() == null) {
            return;
        }
        List<ChatMessage> chatMessages = msglistModel.getData().getChatMessages();
        if (ListUtils.isEmpty(chatMessages)) {
            return;
        }
        ChatMessage chatMessage = (ChatMessage) ListUtils.getItem(chatMessages, ListUtils.getCount(chatMessages) - 1);
        ChatMessage chatMessage2 = (ChatMessage) ListUtils.getItem(chatMessages, ListUtils.getCount(chatMessages) - 2);
        Iterator<hb7> it = this.a.iterator();
        while (it.hasNext()) {
            hb7 next = it.next();
            if (next.a(chatMessage, chatMessage2)) {
                listView.postDelayed(new a(this, listView, chatMessages, next, chatMessage, chatMessage2), 200L);
                return;
            }
        }
    }
}

package com.baidu.tieba.im.chat.notify;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.view.ShutDownValidateTipView;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.core.d {
    private ShutDownValidateTipView i;
    private DialogInterface.OnClickListener j;
    private com.baidu.tbadk.core.view.o k;
    private com.baidu.tbadk.core.view.c l;
    private int m;
    private NoNetworkView n;
    private RelativeLayout p;
    private com.baidu.tieba.im.model.p c = null;
    private FragmentActivity d = null;
    private ImMessageCenterShowItemData e = null;
    private BdListView f = null;
    private n g = null;
    private p h = null;
    AlertDialog b = null;
    private boolean o = true;
    private final AdapterView.OnItemClickListener q = new f(this);
    private final AdapterView.OnItemLongClickListener r = new h(this);
    private final com.baidu.adp.widget.ListView.d s = new i(this);
    private final CustomMessageListener t = new j(this, 0);
    private a u = new k(this);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.m = -1;
        this.d = getActivity();
        View inflate = layoutInflater.inflate(v.chat_list_activity, viewGroup, false);
        a(inflate);
        TiebaStatic.eventStat(this.d, "enter_chatlist", "chatlistclick", 1, new Object[0]);
        f();
        return inflate;
    }

    private void f() {
        a(2016003, this.t);
        a(2016000, this.t);
        a(2016010, this.t);
        a(2016006, this.t);
        a(2016011, this.t);
        a(2016001, this.t);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.g != null) {
            this.g.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.t);
    }

    private void g() {
        this.c = new com.baidu.tieba.im.model.p(this.d);
        d(com.baidu.tbadk.core.sharedPref.b.a().a("is_shut_down_validate", false) ? false : true);
    }

    private void a(View view) {
        this.p = (RelativeLayout) view.findViewById(u.chat_list);
        this.k = new com.baidu.tbadk.core.view.o(view, t.pic_emotion05, t.pic_emotion05_1, u.no_data_container, u.no_data_image, u.no_data_image_text);
        this.i = (ShutDownValidateTipView) view.findViewById(u.view_no_validate);
        this.i.setVisibility(8);
        this.i.setShutDownClickListener(new l(this));
        this.f = (BdListView) view.findViewById(u.chat_list_content);
        this.f.setDividerHeight(0);
        this.h = new p(this.d);
        this.h.a(this.s);
        this.f.setPullRefresh(this.h);
        this.g = new n(this.d);
        this.g.a(this);
        this.f.setAdapter((ListAdapter) this.g);
        this.f.setOnItemClickListener(this.q);
        this.f.setOnItemLongClickListener(this.r);
        this.f.e();
        this.n = (NoNetworkView) this.p.findViewById(u.view_no_network);
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        if (isAdded() && this.m != i) {
            this.m = i;
            if (this.k != null) {
                this.k.a(i);
            }
            if (this.i != null) {
                this.i.a(i);
            }
            if (this.h != null) {
                this.h.a(i);
            }
            if (this.l != null) {
                this.l.b(i);
            }
            if (this.g != null) {
                this.g.notifyDataSetChanged();
            }
            if (this.d != null && (this.d instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.d).c().a(i == 1);
                ((BaseFragmentActivity) this.d).c().a((View) this.p);
            }
            if (this.n != null) {
                this.n.a(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.k.a();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.k.b();
        if (this.l != null) {
            this.l.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.j = new m(this, imMessageCenterShowItemData);
        String string = this.d.getString(x.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(x.operation);
        builder.setItems(new String[]{string}, this.j);
        this.b = builder.create();
        this.b.setCanceledOnTouchOutside(true);
    }

    public void a(boolean z) {
        if (z) {
            if (a() && this.i.getVisibility() != 0) {
                this.i.setVisibility(0);
            }
        } else if (this.i.getVisibility() != 8) {
            this.i.setVisibility(8);
        }
    }

    public void c(boolean z) {
        if (z) {
            this.k.b(0);
        } else {
            this.k.b(8);
        }
        if (!isAdded()) {
        }
    }

    public boolean a() {
        return this.o;
    }

    public void d(boolean z) {
        this.o = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            a(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.c != null) {
                    this.c.a(data, this.u);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.c != null) {
                this.c.b(data, this.u);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.c != null) {
                this.c.a(data, this.u);
            }
        }
    }
}

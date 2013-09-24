package com.baidu.tieba.chat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
/* loaded from: classes.dex */
public class ChatListFragment extends BaseFragment implements com.baidu.tbadk.a.d {
    private DialogInterface.OnClickListener ab;
    private LinearLayout ac;
    private com.baidu.tieba.ae ad;
    private com.baidu.tieba.home.l ae;
    private com.baidu.tieba.model.e b = null;
    private Activity c = null;
    private int d = 1;
    private Handler e = null;
    private Runnable f = null;
    private com.baidu.tieba.data.a.g g = null;
    private int h = 3;
    private RelativeLayout i = null;
    private BdListView Y = null;
    private l Z = null;
    private com.baidu.tieba.view.ab aa = null;

    /* renamed from: a  reason: collision with root package name */
    AlertDialog f952a = null;
    private View.OnClickListener af = new n(this);
    private AdapterView.OnItemClickListener ag = new o(this);
    private AdapterView.OnItemLongClickListener ah = new p(this);
    private com.baidu.adp.widget.ListView.b ai = new q(this);
    private AbsListView.OnScrollListener aj = new r(this);

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = h();
        View inflate = layoutInflater.inflate(R.layout.chat_list_activity, viewGroup, false);
        a(inflate);
        C();
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.c, "enter_chatlist", "chatlistclick", 1);
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (i >= 1) {
            this.d = i;
            this.h = i2;
            if (this.h == 1) {
                this.Z.a(true);
            } else if (this.h == 2) {
                this.Z.b(true);
            }
            this.Z.notifyDataSetChanged();
            this.b.a(TiebaApplication.C(), String.valueOf(this.d));
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void o() {
        super.o();
        if (TiebaApplication.D()) {
            this.Y.setVisibility(0);
            this.ac.setVisibility(8);
            a(this.d, 3);
            this.f.run();
            return;
        }
        if (this.ae == null) {
            this.ae = new com.baidu.tieba.home.l(this.c, this.c.getString(R.string.login_msg_tab), this.c.getString(R.string.login_msg_form), 3);
            this.ac.addView(this.ae.c());
            this.ae.b(TiebaApplication.g().ap());
        } else {
            ((ViewGroup) this.ae.c().getParent()).removeAllViews();
            this.ac.addView(this.ae.c());
            this.ae.b(TiebaApplication.g().ap());
        }
        this.Y.setVisibility(8);
        this.ac.setVisibility(0);
    }

    @Override // android.support.v4.app.Fragment
    public void q() {
        if (this.Z.a() != null) {
            this.Z.a().b();
            this.Z.b();
        }
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
        }
        super.q();
    }

    private void C() {
        this.b = new com.baidu.tieba.model.e();
        this.b.setLoadDataCallBack(new s(this));
        this.Z.a(this.b.c(TiebaApplication.C()));
        a();
    }

    private void a(View view) {
        this.i = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.ad = new com.baidu.tieba.ae(view, (int) R.drawable.individual_center_news, (int) R.drawable.individual_center_news_1);
        this.ac = (LinearLayout) view.findViewById(R.id.bodyNotLogin);
        this.Y = (BdListView) view.findViewById(R.id.chat_list_content);
        this.Y.setDivider(null);
        this.aa = new com.baidu.tieba.view.ab(this.c);
        this.aa.a(this.ai);
        this.Y.setPullRefresh(this.aa);
        this.Z = new l(this.c);
        this.Y.setAdapter((ListAdapter) this.Z);
        this.Z.a(this.af);
        this.Y.setOnItemClickListener(this.ag);
        this.Y.setOnScrollListener(this.aj);
        this.Y.setOnItemLongClickListener(this.ah);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        String c;
        UtilHelper.NetworkStateInfo i = UtilHelper.i(this.c);
        this.Z.a().a();
        boolean z = i == UtilHelper.NetworkStateInfo.WIFI || i == UtilHelper.NetworkStateInfo.ThreeG;
        this.Z.a().a(z);
        int lastVisiblePosition = this.Y.getLastVisiblePosition();
        this.Z.a().a();
        int i2 = 0;
        for (int firstVisiblePosition = this.Y.getFirstVisiblePosition(); firstVisiblePosition < this.Z.getCount(); firstVisiblePosition++) {
            if (z || firstVisiblePosition <= lastVisiblePosition) {
                if ((this.Z.getItem(firstVisiblePosition) instanceof com.baidu.tieba.data.a.g) && i2 < 13 && (c = ((com.baidu.tieba.data.a.g) this.Z.getItem(firstVisiblePosition)).c()) != null && !c.equals("")) {
                    i2++;
                    this.Z.a().b(c, this);
                }
                if (i2 >= 30) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.BaseFragment
    public void b(int i) {
        if (this.ad != null) {
            this.ad.a(i);
        }
        if (this.aa != null) {
            this.aa.a(i);
        }
        if (this.ae != null) {
            this.ae.b(i);
        }
        if (i == 1) {
            this.i.setBackgroundColor(-13618114);
            if (this.ad.c()) {
                this.Y.setDivider(this.c.getResources().getDrawable(17170445));
                return;
            } else {
                this.Y.setDivider(this.c.getResources().getDrawable(R.drawable.list_divider_1));
                return;
            }
        }
        this.i.setBackgroundColor(-197380);
        if (this.ad.c()) {
            this.Y.setDivider(this.c.getResources().getDrawable(17170445));
        } else {
            this.Y.setDivider(this.c.getResources().getDrawable(R.drawable.list_divider));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void c() {
        super.c();
        this.ad.a();
    }

    @Override // android.support.v4.app.Fragment
    public void d() {
        super.d();
        this.ad.b();
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12011:
                    String stringExtra = intent.getStringExtra(LocaleUtil.INDONESIAN);
                    String stringExtra2 = intent.getStringExtra("name");
                    String stringExtra3 = intent.getStringExtra("portrait");
                    if (stringExtra2 != null && stringExtra != null) {
                        ChatActivity.a(this.c, stringExtra, stringExtra2, stringExtra3, null, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.data.a.g gVar) {
        this.ab = new t(this);
        String string = this.c.getString(R.string.delete_user_chat);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.c);
        builder.setTitle(R.string.operation);
        builder.setItems(new String[]{string}, this.ab);
        this.f952a = builder.create();
        this.f952a.setCanceledOnTouchOutside(true);
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        ImageView imageView;
        if (cVar != null && this.Y != null && (imageView = (ImageView) this.Y.findViewWithTag(str)) != null) {
            cVar.a(imageView);
            imageView.invalidate();
        }
    }

    public void a() {
        this.e = new Handler();
        this.f = new u(this);
    }
}

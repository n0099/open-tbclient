package com.baidu.tieba.friendfeed;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.editortool.w;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.f {
    public PbEditor a;
    private FriendFeedActivity b;
    private l c;
    private ViewGroup d;
    private NavigationBar e;
    private NoNetworkView f;
    private ViewGroup g;
    private ViewGroup h;
    private BdListView i;
    private Handler j;
    private dh k;

    public t(FriendFeedActivity friendFeedActivity) {
        super(friendFeedActivity);
        this.j = null;
        this.k = null;
        this.b = friendFeedActivity;
        friendFeedActivity.setContentView(v.friend_feed_view);
        this.j = new Handler();
        a(friendFeedActivity);
        b(friendFeedActivity);
    }

    private void a(FriendFeedActivity friendFeedActivity) {
        this.d = (ViewGroup) this.b.findViewById(com.baidu.tieba.u.content);
        this.e = (NavigationBar) this.b.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.e.a(this.b.getString(x.friendfeed_title));
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void b(FriendFeedActivity friendFeedActivity) {
        this.f = (NoNetworkView) this.b.findViewById(com.baidu.tieba.u.view_no_network);
        this.h = (ViewGroup) this.b.findViewById(com.baidu.tieba.u.content_with_data);
        this.g = (ViewGroup) this.b.findViewById(com.baidu.tieba.u.no_data_container);
        this.i = (BdListView) friendFeedActivity.findViewById(com.baidu.tieba.u.friend_feed_list);
        this.c = new l(this.b, com.baidu.adp.lib.util.j.b(this.b), bb.a().b());
        this.i.setAdapter((ListAdapter) this.c);
        this.a = (PbEditor) this.b.findViewById(com.baidu.tieba.u.friendfeed_editor);
        this.a.setHideBaobao(true);
    }

    public void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a((View) this.d);
        this.e.c(i);
        this.f.a(i);
        if (this.a != null) {
            this.a.c(i);
        }
    }

    public void a() {
        this.a.b(this.a.getEditText());
        this.a.o();
    }

    public void a(int i, FriendFeedThreadData friendFeedThreadData, int i2) {
        this.a.n();
        this.a.u();
        if (this.a.h()) {
            this.a.k();
        } else {
            this.a.getEditText().requestFocus();
            this.a.a(this.a.getEditText());
        }
        a(i, i2);
    }

    protected void a(int i, int i2) {
        this.k = new dh(this.b, i, i2, this.a, this.i, this.e.getHeight());
        this.j.postDelayed(this.k, 300L);
    }

    public void b() {
        this.i.d();
    }

    public l c() {
        return this.c;
    }

    public void a(boolean z) {
        if (z) {
            this.h.setVisibility(8);
            this.g.setVisibility(0);
            return;
        }
        this.h.setVisibility(0);
        this.g.setVisibility(8);
    }

    public BdListView d() {
        return this.i;
    }

    public boolean e() {
        return this.a.l();
    }

    public void f() {
        if (this.c != null) {
            this.c.notifyDataSetChanged();
        }
    }

    public void b(boolean z) {
        this.b.hideProgressBar();
        if (z) {
            this.a.getEditText().setText("");
            this.a.b();
            this.a.m();
        }
    }

    public void a(String str) {
        this.a.setContent(str);
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.a.c.a(writeImagesInfo, z);
    }

    public void g() {
        this.b.showProgressBar();
    }

    public void a(ArrayList<String> arrayList) {
        this.a.a(arrayList);
    }

    public String h() {
        return this.a.getContent();
    }

    public VoiceData.VoiceModel i() {
        return this.a.getAudioData();
    }

    public void j() {
        this.a.t();
    }

    public void k() {
        this.a.s();
    }

    public void a(w wVar) {
        if (wVar != null) {
            this.a.setOnActionListener(new u(this, wVar));
        }
    }
}

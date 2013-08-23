package com.baidu.tieba.flist;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.util.aq;
import java.util.ArrayList;
/* loaded from: classes.dex */
class h implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1043a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ForumListActivity forumListActivity) {
        this.f1043a = forumListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        ForumListModel.RequestParams requestParams3;
        ForumListModel.RequestParams requestParams4;
        t tVar;
        ForumListModel.RequestParams requestParams5;
        t tVar2;
        ForumListModel.RequestParams requestParams6;
        ForumListModel.RequestParams requestParams7;
        ForumListModel.RequestParams requestParams8;
        ForumListModel.RequestParams requestParams9;
        ForumListModel.RequestParams requestParams10;
        ForumListModel.RequestParams requestParams11;
        ForumListModel.RequestParams requestParams12;
        ForumListModel.RequestParams requestParams13;
        if (TiebaApplication.g().u()) {
            StatService.onEvent(this.f1043a, "forumlist_\tcatalog", "catalogclick", 1);
        }
        this.f1043a.c.t.dismiss();
        this.f1043a.s = i;
        ArrayList arrayList = this.f1043a.c.x.a().e;
        try {
            requestParams6 = this.f1043a.x;
            requestParams6.menu_id = Integer.valueOf(((com.baidu.tieba.square.s) arrayList.get(i)).c).intValue();
            requestParams7 = this.f1043a.x;
            requestParams7.menu_name = ((com.baidu.tieba.square.s) arrayList.get(i)).b;
            requestParams8 = this.f1043a.x;
            requestParams8.menu_type = Integer.valueOf(((com.baidu.tieba.square.s) arrayList.get(i)).f1754a).intValue();
            requestParams9 = this.f1043a.x;
            requestParams9.parent_menu_id = Integer.valueOf(this.f1043a.getIntent().getStringExtra("parent_menu_id")).intValue();
            requestParams10 = this.f1043a.x;
            requestParams10.parent_menu_name = this.f1043a.getIntent().getStringExtra("parent_menu_name");
            requestParams11 = this.f1043a.x;
            requestParams11.offset = 0;
            requestParams12 = this.f1043a.x;
            requestParams12.rn = 10;
            requestParams13 = this.f1043a.x;
            aq.e("ForumListActivity", "onCreate", requestParams13.toString());
        } catch (NullPointerException e) {
            this.f1043a.finish();
        }
        ForumListActivity forumListActivity = this.f1043a;
        requestParams = this.f1043a.x;
        forumListActivity.u = requestParams.recommend_type;
        ForumListActivity forumListActivity2 = this.f1043a;
        requestParams2 = this.f1043a.x;
        forumListActivity2.v = requestParams2.rn;
        requestParams3 = this.f1043a.x;
        requestParams3.recommend_type = 0;
        requestParams4 = this.f1043a.x;
        requestParams4.rn = 10;
        this.f1043a.t = true;
        tVar = this.f1043a.D;
        requestParams5 = this.f1043a.x;
        tVar.a(requestParams5);
        tVar2 = this.f1043a.D;
        tVar2.LoadData();
    }
}

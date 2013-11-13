package com.baidu.tieba.im.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.RequestFrsGroupsMessage;
import com.baidu.tieba.im.message.RequestUserPermissionMessage;
import com.baidu.tieba.util.UtilHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private String f1745a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private int g;
    private int h;
    private GroupPermData i;
    private Map<String, Boolean> j = new HashMap();

    public void a(String str) {
        this.j.put(str, true);
    }

    public boolean b(String str) {
        Boolean bool = this.j.get(str);
        return bool != null && bool.booleanValue();
    }

    public boolean a() {
        return this.b;
    }

    public int b() {
        return this.g;
    }

    public int c() {
        return this.h;
    }

    public GroupPermData d() {
        return this.i;
    }

    public void a(GroupPermData groupPermData) {
        this.i = groupPermData;
    }

    public boolean e() {
        return this.f;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void f() {
        this.i = null;
    }

    public void a(Activity activity) {
        this.g = UtilHelper.a((Context) activity, 70.0f);
        this.h = UtilHelper.a((Context) activity, 70.0f);
    }

    public int g() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public boolean h() {
        return l() == 50;
    }

    public boolean i() {
        return g() == 2;
    }

    public int j() {
        return this.c;
    }

    public int k() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public void c(int i) {
        this.d += i;
    }

    public int l() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }

    public String m() {
        return this.f1745a;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public void a(Intent intent) {
        this.f1745a = intent.getStringExtra("forum_id");
        this.b = intent.getBooleanExtra("show_recommend", true);
        this.c = this.b ? 1 : 2;
    }

    public void a(Bundle bundle) {
        this.f1745a = bundle.getString("forum_id");
        this.b = bundle.getBoolean("show_recommend");
        this.c = bundle.getInt("card_type");
        this.d = bundle.getInt("start_position");
        this.e = bundle.getInt("end_position");
        this.i = (GroupPermData) bundle.getSerializable("group_perm");
    }

    private RequestFrsGroupsMessage c(String str, int i, int i2, int i3, int i4, int i5) {
        RequestFrsGroupsMessage requestFrsGroupsMessage = new RequestFrsGroupsMessage();
        requestFrsGroupsMessage.setForumId(str);
        requestFrsGroupsMessage.setType(String.valueOf(i));
        requestFrsGroupsMessage.setOffset(String.valueOf(i2));
        requestFrsGroupsMessage.setRn(String.valueOf(i3));
        requestFrsGroupsMessage.setWidth(i4);
        requestFrsGroupsMessage.setHeight(i5);
        return requestFrsGroupsMessage;
    }

    public void a(String str, int i, int i2, int i3, int i4, int i5) {
        com.baidu.tieba.im.messageCenter.f.a().a(c(str, i, i2, i3, i4, i5));
    }

    public void a(com.baidu.tieba.im.messageCenter.h hVar) {
        com.baidu.tieba.im.messageCenter.f.a().a(103002, hVar);
        com.baidu.tieba.im.messageCenter.f.a().a(-201, hVar);
    }

    public void b(com.baidu.tieba.im.messageCenter.h hVar) {
        com.baidu.tieba.im.messageCenter.f.a().a(hVar);
    }

    public void b(String str, int i, int i2, int i3, int i4, int i5) {
        RequestFrsGroupsMessage c = c(str, i, i2, i3, i4, i5);
        c.setCmd(-201);
        com.baidu.tieba.im.messageCenter.f.a().a(c);
    }

    private RequestUserPermissionMessage d(String str) {
        long j = 0;
        try {
            j = Long.parseLong(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        RequestUserPermissionMessage requestUserPermissionMessage = new RequestUserPermissionMessage();
        requestUserPermissionMessage.setForumId(j);
        return requestUserPermissionMessage;
    }

    public void c(String str) {
        com.baidu.tieba.im.messageCenter.f.a().a(d(str));
    }

    public void c(com.baidu.tieba.im.messageCenter.h hVar) {
        com.baidu.tieba.im.messageCenter.f.a().a(103008, hVar);
    }

    public void d(com.baidu.tieba.im.messageCenter.h hVar) {
        com.baidu.tieba.im.messageCenter.f.a().a(hVar);
    }

    public void b(Bundle bundle) {
        bundle.putString("forum_id", this.f1745a);
        bundle.putBoolean("show_recommend", this.b);
        bundle.putInt("card_type", this.c);
        bundle.putInt("start_position", this.d);
        bundle.putInt("end_position", this.e);
        bundle.putSerializable("group_perm", this.i);
    }
}

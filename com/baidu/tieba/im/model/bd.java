package com.baidu.tieba.im.model;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.message.GroupsByLocationLocalMessage;
import com.baidu.tieba.im.message.RequestNearbyGroupsMessage;
import com.baidu.tieba.im.message.RequestUserPermissionMessage;
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.base.e {
    private String b;
    private String c;
    private int d;
    private boolean g;
    private RequestNearbyGroupsMessage j;
    private RequestUserPermissionMessage k;
    private GroupsByLocationLocalMessage l;
    private int a = 0;
    private boolean h = false;
    private boolean i = false;
    private int f = com.baidu.adp.lib.util.j.a(TbadkApplication.m252getInst().getContext(), 70.0f);
    private int e = com.baidu.adp.lib.util.j.a(TbadkApplication.m252getInst().getContext(), 70.0f);

    public boolean a() {
        return this.i;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public boolean b() {
        return this.g;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public void b(String str) {
        this.c = str;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public boolean c() {
        return this.h;
    }

    public void c(boolean z) {
        this.h = z;
    }

    private RequestNearbyGroupsMessage b(int i) {
        RequestNearbyGroupsMessage requestNearbyGroupsMessage = new RequestNearbyGroupsMessage();
        requestNearbyGroupsMessage.setHeight(this.e);
        requestNearbyGroupsMessage.setWidth(this.f);
        requestNearbyGroupsMessage.setLat(this.c);
        requestNearbyGroupsMessage.setLng(this.b);
        requestNearbyGroupsMessage.setOffset(i * 30);
        requestNearbyGroupsMessage.setRn(30);
        requestNearbyGroupsMessage.setGeo(this.d);
        return requestNearbyGroupsMessage;
    }

    private RequestUserPermissionMessage b(long j) {
        RequestUserPermissionMessage requestUserPermissionMessage = new RequestUserPermissionMessage();
        requestUserPermissionMessage.setForumId(j);
        return requestUserPermissionMessage;
    }

    public void d() {
        this.a = 0;
        this.d = 0;
        this.j = b(this.a);
        super.sendMessage(this.j);
    }

    public void e() {
        g();
        this.j = b(this.a);
        super.sendMessage(this.j);
    }

    public void a(long j) {
        this.k = b(j);
        super.sendMessage(this.k);
    }

    public void f() {
        this.h = true;
        this.l = new GroupsByLocationLocalMessage();
        super.sendMessage(this.l);
    }

    public void g() {
        this.a++;
    }

    public boolean h() {
        if (this.h) {
            if (UtilHelper.isNetOk()) {
                d();
                return true;
            }
            return false;
        }
        f();
        return true;
    }

    @Override // com.baidu.adp.base.e
    public void cancelMessage() {
        super.cancelMessage();
        this.j = null;
        this.k = null;
        this.l = null;
    }
}

package com.baidu.tieba.im.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.RequestFrsGroupsLocalMessage;
import com.baidu.tieba.im.message.RequestFrsGroupsMessage;
import com.baidu.tieba.im.message.RequestUserPermissionMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.b {
    private String a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private int g;
    private int h;
    private GroupPermData i;
    private final Map<String, Boolean> j = new HashMap();
    private BaseFragmentActivity k;

    public k(BaseFragmentActivity baseFragmentActivity) {
        this.k = baseFragmentActivity;
    }

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
        this.g = com.baidu.adp.lib.util.k.a((Context) activity, 70.0f);
        this.h = com.baidu.adp.lib.util.k.a((Context) activity, 70.0f);
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
        return this.a;
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        return false;
    }

    public void a(Intent intent) {
        this.a = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID);
        this.b = intent.getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.SHOW_RECOMMEND, true);
        this.c = this.b ? 1 : 2;
    }

    public void a(Bundle bundle) {
        this.a = bundle.getString(com.baidu.tbadk.core.frameworkData.a.FORUM_ID);
        this.b = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.SHOW_RECOMMEND);
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

    private RequestFrsGroupsLocalMessage d(String str, int i, int i2, int i3, int i4, int i5) {
        RequestFrsGroupsLocalMessage requestFrsGroupsLocalMessage = new RequestFrsGroupsLocalMessage();
        requestFrsGroupsLocalMessage.setForumId(str);
        requestFrsGroupsLocalMessage.setType(String.valueOf(i));
        requestFrsGroupsLocalMessage.setOffset(String.valueOf(i2));
        requestFrsGroupsLocalMessage.setRn(String.valueOf(i3));
        requestFrsGroupsLocalMessage.setWidth(i4);
        requestFrsGroupsLocalMessage.setHeight(i5);
        return requestFrsGroupsLocalMessage;
    }

    public void a(String str, int i, int i2, int i3, int i4, int i5) {
        this.k.a(c(str, i, i2, i3, i4, i5));
    }

    @Override // com.baidu.adp.base.b
    public void registerListener(MessageListener<?> messageListener) {
        this.k.a(messageListener);
    }

    public void a(MessageListener<?> messageListener) {
        MessageManager.getInstance().unRegisterListener(messageListener);
    }

    public void b(String str, int i, int i2, int i3, int i4, int i5) {
        this.k.a(d(str, i, i2, i3, i4, i5));
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
        this.k.a(d(str));
    }

    public void b(MessageListener<?> messageListener) {
        this.k.a(messageListener);
    }

    public void b(Bundle bundle) {
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, this.a);
        bundle.putBoolean(com.baidu.tbadk.core.frameworkData.a.SHOW_RECOMMEND, this.b);
        bundle.putInt("card_type", this.c);
        bundle.putInt("start_position", this.d);
        bundle.putInt("end_position", this.e);
        bundle.putSerializable("group_perm", this.i);
    }
}

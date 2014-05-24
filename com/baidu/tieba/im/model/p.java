package com.baidu.tieba.im.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.im.message.RequestHotLiveListLocalMessage;
import com.baidu.tieba.im.message.RequestHotLiveListMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.b {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private final Map<String, Boolean> f = new HashMap();
    private final Map<String, Boolean> g = new HashMap();
    private BaseFragmentActivity h;

    public p(BaseFragmentActivity baseFragmentActivity) {
        this.h = baseFragmentActivity;
    }

    public void a(String str, boolean z) {
        this.f.put(str, true);
    }

    public boolean a(String str) {
        Boolean bool = this.f.get(str);
        return bool != null && bool.booleanValue();
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public boolean b(String str) {
        Boolean bool = this.g.get(str);
        return bool != null && bool.booleanValue();
    }

    public void c(String str) {
        this.g.put(str, true);
    }

    public void a(Activity activity) {
        this.d = com.baidu.adp.lib.util.k.a((Context) activity, 70.0f);
        this.e = com.baidu.adp.lib.util.k.a((Context) activity, 70.0f);
    }

    public int c() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public boolean d() {
        return this.c == 0;
    }

    public int e() {
        return this.a;
    }

    public int f() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public void c(int i) {
        this.b += i;
    }

    public int g() {
        return this.c;
    }

    public void d(int i) {
        this.c = i;
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
        this.a = 1;
    }

    public void a(Bundle bundle) {
        this.a = bundle.getInt("card_type");
        this.b = bundle.getInt("start_position");
        this.c = bundle.getInt("page_num");
    }

    private RequestHotLiveListMessage c(int i, int i2, int i3, int i4, int i5) {
        RequestHotLiveListMessage requestHotLiveListMessage = new RequestHotLiveListMessage();
        requestHotLiveListMessage.setType(i);
        requestHotLiveListMessage.setOffset(i2);
        requestHotLiveListMessage.setRn(i3);
        requestHotLiveListMessage.setWidth(i4);
        requestHotLiveListMessage.setHeight(i5);
        return requestHotLiveListMessage;
    }

    private RequestHotLiveListLocalMessage d(int i, int i2, int i3, int i4, int i5) {
        RequestHotLiveListLocalMessage requestHotLiveListLocalMessage = new RequestHotLiveListLocalMessage();
        requestHotLiveListLocalMessage.setType(i);
        requestHotLiveListLocalMessage.setOffset(i2);
        requestHotLiveListLocalMessage.setRn(i3);
        requestHotLiveListLocalMessage.setWidth(i4);
        requestHotLiveListLocalMessage.setHeight(i5);
        return requestHotLiveListLocalMessage;
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        this.h.a(c(i, i2, i3, i4, i5));
    }

    @Override // com.baidu.adp.base.b
    public void registerListener(MessageListener<?> messageListener) {
        this.h.a(messageListener);
    }

    public void a(MessageListener<?> messageListener) {
        MessageManager.getInstance().unRegisterListener(messageListener);
    }

    public void b(int i, int i2, int i3, int i4, int i5) {
        this.h.a(d(i, i2, i3, i4, i5));
    }

    public void b(Bundle bundle) {
        bundle.putInt("card_type", this.a);
        bundle.putInt("start_position", this.b);
        bundle.putInt("page_num", this.c);
    }
}

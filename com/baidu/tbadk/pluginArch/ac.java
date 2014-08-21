package com.baidu.tbadk.pluginArch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tbadk.pluginArch.service.RemoteSynchronousDataService;
/* loaded from: classes.dex */
public class ac {
    private static ac h;
    private Messenger a;
    private Messenger b = new Messenger(new ae(this, null));
    private ad c = new ad(this, null);
    private Context d = TbadkApplication.m252getInst().getApplicationContext();
    private int e;
    private String f;
    private ConfigInfos g;

    private ac() {
    }

    public static synchronized ac a() {
        ac acVar;
        synchronized (ac.class) {
            if (h == null) {
                h = new ac();
            }
            acVar = h;
        }
        return acVar;
    }

    public void e() {
        Message obtain = Message.obtain((Handler) null, 0);
        if (obtain != null) {
            try {
                obtain.replyTo = this.b;
                this.a.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }

    private void f() {
        if (this.a != null) {
            Message obtain = Message.obtain((Handler) null, 1);
            try {
                obtain.replyTo = this.b;
                this.a.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }

    public void b() {
        this.d.bindService(new Intent(this.d, RemoteSynchronousDataService.class), this.c, 1);
    }

    public void c() {
        f();
        BdLog.i("close");
        if (this.a != null) {
            this.d.unbindService(this.c);
        }
    }

    public void a(String str) {
        if (str != null) {
            this.e = 2;
            this.f = str;
            b();
        }
    }

    public void b(String str) {
        Message obtain = Message.obtain((Handler) null, 2);
        if (obtain != null) {
            try {
                obtain.replyTo = this.b;
                Bundle bundle = new Bundle();
                bundle.putString("pluginName", str);
                obtain.setData(bundle);
                this.a.send(obtain);
                BdLog.i("send-WHAT_OPERATE_FORBIDDEN");
            } catch (RemoteException e) {
            }
        }
    }

    public void d() {
        this.e = 3;
        b();
    }

    public void g() {
        Message obtain = Message.obtain((Handler) null, 3);
        if (obtain != null) {
            try {
                obtain.replyTo = this.b;
                this.a.send(obtain);
                BdLog.i("send-WHAT_INSTALL_PLUGIN");
            } catch (RemoteException e) {
            }
        }
    }

    public void a(ConfigInfos configInfos) {
        if (configInfos != null) {
            this.e = 4;
            this.g = configInfos;
            b();
        }
    }

    public void b(ConfigInfos configInfos) {
        Message obtain = Message.obtain((Handler) null, 4);
        if (obtain != null) {
            try {
                obtain.replyTo = this.b;
                Bundle bundle = new Bundle();
                bundle.putSerializable("configinfos", configInfos);
                obtain.setData(bundle);
                this.a.send(obtain);
                BdLog.i("send-WHAT_NET_CONFIG");
            } catch (RemoteException e) {
            }
        }
    }
}

package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class di {
    private ForumData a;
    private ArrayList<com.baidu.tieba.data.at> b;
    private ArrayList<String> c;
    private int d;
    private int e;
    private int f;
    private AntiData g;
    private com.baidu.tieba.data.ad h;
    private String i = null;
    private String j = null;
    private cp k = null;
    private cp l = null;
    private int m = com.baidu.adp.framework.d.a().b();
    private HttpMessageListener n = new dj(this, CmdConfig.FRS_WATER_FALL_PHOTO_HTTP_CMD);
    private HttpMessageListener o = new dk(this, CmdConfig.FRS_WATER_FALL_LIST_HTTP_CMD);

    public di() {
        i();
        g();
    }

    private void i() {
        this.a = new ForumData();
        this.b = new ArrayList<>();
        this.c = new ArrayList<>();
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = new AntiData();
        this.h = new com.baidu.tieba.data.ad();
    }

    public com.baidu.tieba.data.ad a() {
        return this.h;
    }

    public ForumData b() {
        return this.a;
    }

    public ArrayList<com.baidu.tieba.data.at> c() {
        return this.b;
    }

    public ArrayList<String> d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }

    public AntiData f() {
        return this.g;
    }

    public void g() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfig.FRS_WATER_FALL_LIST_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/photolist");
        tbHttpMessageTask.setResponsedClass(ImageForumListResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.o);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfig.FRS_WATER_FALL_PHOTO_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/photo");
        tbHttpMessageTask2.setResponsedClass(ImageForumResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask2);
        messageManager.registerListener(this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(HttpResponsedMessage httpResponsedMessage) {
        Object extra = httpResponsedMessage.getOrginalMessage().getExtra();
        if (extra != null) {
            return com.baidu.adp.lib.f.b.a(extra.toString(), 0);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public dl a(HttpResponsedMessage httpResponsedMessage, int i, int i2) {
        dl dlVar = new dl(this);
        dlVar.a = true;
        dlVar.b = i == 200;
        dlVar.c = i2;
        dlVar.d = httpResponsedMessage.getErrorString();
        dlVar.e = com.baidu.adp.lib.f.b.a(httpResponsedMessage.getContentLength(), 0L);
        return dlVar;
    }

    public void a(int i, int i2, int i3) {
        if (MessageManager.getInstance().findMessage(CmdConfig.FRS_WATER_FALL_LIST_HTTP_CMD, this.m).size() <= 0) {
            HttpMessage httpMessage = new HttpMessage(CmdConfig.FRS_WATER_FALL_LIST_HTTP_CMD);
            if (this.i != null) {
                httpMessage.addParam(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.i);
            }
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addParam("kw", this.j);
            httpMessage.addParam("bs", String.valueOf(i));
            httpMessage.addParam("be", String.valueOf((i + 240) - 1));
            httpMessage.addParam("an", String.valueOf(30));
            httpMessage.addParam("scr_w", String.valueOf(i2));
            httpMessage.addParam("scr_h", String.valueOf(i3));
            httpMessage.setTag(this.m);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(int i) {
        if (MessageManager.getInstance().findMessage(CmdConfig.FRS_WATER_FALL_PHOTO_HTTP_CMD, this.m).size() <= 0) {
            if (i < 0) {
                i = 0;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfig.FRS_WATER_FALL_PHOTO_HTTP_CMD);
            httpMessage.setExtra(Integer.valueOf(i));
            StringBuilder sb = new StringBuilder();
            int size = d().size();
            for (int i2 = i; i2 < size && i2 < i + 30; i2++) {
                sb.append(d().get(i2));
                sb.append(",");
            }
            int length = sb.length();
            if (length > 1 && sb.charAt(length - 1) == ',') {
                sb.deleteCharAt(length - 1);
            }
            httpMessage.addParam("alb_ids", sb.toString());
            httpMessage.addParam("kw", this.j);
            httpMessage.setTag(this.m);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void h() {
        MessageManager.getInstance().removeMessage(CmdConfig.FRS_WATER_FALL_LIST_HTTP_CMD, this.m);
        MessageManager.getInstance().removeMessage(CmdConfig.FRS_WATER_FALL_PHOTO_HTTP_CMD, this.m);
    }

    public void a(String str, String str2) {
        this.i = str;
        this.j = str2;
    }

    public void a(cp cpVar) {
        this.k = cpVar;
    }

    public void b(cp cpVar) {
        this.l = cpVar;
    }
}

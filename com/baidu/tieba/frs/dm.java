package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dm {
    private ForumData a;
    private ArrayList<com.baidu.tieba.data.ay> b;
    private ArrayList<String> c;
    private int d;
    private int e;
    private int f;
    private AntiData g;
    private com.baidu.tieba.data.ah h;
    private String i = null;
    private String j = null;
    private cq k = null;
    private cq l = null;
    private final BdUniqueId m = BdUniqueId.gen();
    private final HttpMessageListener n = new dn(this, CmdConfigHttp.FRS_WATER_FALL_PHOTO_HTTP_CMD);
    private final HttpMessageListener o = new Cdo(this, CmdConfigHttp.FRS_WATER_FALL_LIST_HTTP_CMD);

    public dm() {
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
        this.h = new com.baidu.tieba.data.ah();
    }

    public com.baidu.tieba.data.ah a() {
        return this.h;
    }

    public ForumData b() {
        return this.a;
    }

    public ArrayList<com.baidu.tieba.data.ay> c() {
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
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_WATER_FALL_LIST_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/photolist");
        tbHttpMessageTask.setResponsedClass(ImageForumListResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.o);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.FRS_WATER_FALL_PHOTO_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/photo");
        tbHttpMessageTask2.setResponsedClass(ImageForumResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask2);
        messageManager.registerListener(this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(HttpResponsedMessage httpResponsedMessage) {
        Object extra = httpResponsedMessage.getOrginalMessage().getExtra();
        if (extra != null) {
            return com.baidu.adp.lib.e.b.a(extra.toString(), 0);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public dp a(HttpResponsedMessage httpResponsedMessage, int i, int i2) {
        dp dpVar = new dp(this);
        dpVar.a = true;
        dpVar.b = i == 200;
        dpVar.c = i2;
        dpVar.d = httpResponsedMessage.getErrorString();
        dpVar.e = com.baidu.adp.lib.e.b.a(httpResponsedMessage.getContentLength(), 0L);
        return dpVar;
    }

    public void a(int i, int i2, int i3) {
        if (MessageManager.getInstance().findMessage(CmdConfigHttp.FRS_WATER_FALL_LIST_HTTP_CMD, this.m).size() <= 0) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_WATER_FALL_LIST_HTTP_CMD);
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
        if (MessageManager.getInstance().findMessage(CmdConfigHttp.FRS_WATER_FALL_PHOTO_HTTP_CMD, this.m).size() <= 0) {
            if (i < 0) {
                i = 0;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_WATER_FALL_PHOTO_HTTP_CMD);
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
        MessageManager.getInstance().removeMessage(CmdConfigHttp.FRS_WATER_FALL_LIST_HTTP_CMD, this.m);
        MessageManager.getInstance().removeMessage(CmdConfigHttp.FRS_WATER_FALL_PHOTO_HTTP_CMD, this.m);
    }

    public void a(String str, String str2) {
        this.i = str;
        this.j = str2;
    }

    public void a(cq cqVar) {
        this.k = cqVar;
    }

    public void b(cq cqVar) {
        this.l = cqVar;
    }
}

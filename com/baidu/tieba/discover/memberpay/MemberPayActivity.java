package com.baidu.tieba.discover.memberpay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PayActivityConfig;
import com.baidu.tbadk.core.atomData.au;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.u;
import com.baidu.tieba.x;
import java.util.List;
/* loaded from: classes.dex */
public class MemberPayActivity extends BaseActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {
    private int b;
    private String c;
    private l d;
    private int f;
    private int e = 1;
    private HttpMessageListener g = new a(this, CmdConfigHttp.GETPAYINFO_CMD);
    public HttpMessageListener a = new b(this, CmdConfigHttp.MEMBER_PAY_CMD);

    static {
        TbadkApplication.m252getInst().RegisterIntent(au.class, MemberPayActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        if (dVar != null) {
            this.d.setMemberPayData(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.b = getIntent().getExtras().getInt("member_type");
            this.c = getIntent().getExtras().getString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
        }
        c();
        registerListener(this.a);
        registerListener(this.g);
        showLoadingDialog(getString(x.flist_loading));
        b();
        a();
    }

    private void b() {
        this.d = new l(this, this.b);
    }

    private void c() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MEMBER_PAY_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MEMBER_PAY);
        tbHttpMessageTask.setResponsedClass(ResponseMemberPayMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void a() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MEMBER_PAY_CMD);
        if (this.c != null) {
            httpMessage.addParam(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.c);
        }
        sendMessage(httpMessage);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.d.a(i);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (this.d != null) {
            this.d.d();
            if (i == u.btn_price1) {
                this.e = 0;
            }
            if (i == u.btn_price2) {
                this.e = 1;
            }
            if (i == u.btn_price3) {
                this.e = 2;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int showType;
        h hVar;
        String valueOf;
        String valueOf2;
        String valueOf3;
        h hVar2;
        String valueOf4;
        String valueOf5;
        String valueOf6;
        super.onClick(view);
        if (view.getId() == u.buy_btn) {
            if (this.d != null && (showType = this.d.getShowType()) >= 0 && showType <= 2) {
                g gVar = this.d.f;
                e eVar = this.d.g;
                Intent intent = new Intent(this, DealIntentService.class);
                if (showType == 2) {
                    if (eVar != null && eVar.a != null) {
                        List<h> list = eVar.a;
                        if (list.size() <= 3 && list.size() >= 0 && this.e <= 2 && this.e >= 0 && this.e < list.size() && (hVar2 = list.get(this.e)) != null) {
                            long j = hVar2.g;
                            if (j >= 0 && j != 0 && (valueOf4 = String.valueOf(j)) != null) {
                                long j2 = hVar2.e;
                                if (j2 >= 0 && (valueOf5 = String.valueOf(j2 / 100)) != null) {
                                    long j3 = hVar2.d;
                                    if (j3 >= 0 && j3 != 0 && (valueOf6 = String.valueOf(j3)) != null) {
                                        intent.putExtra("class", 15);
                                        intent.putExtra(PayActivityConfig.PAY_TYPE, TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                                        intent.putExtra(PayActivityConfig.PROPS_ID, valueOf6);
                                        intent.putExtra(PayActivityConfig.QUAN_NUM, valueOf5);
                                        intent.putExtra(PayActivityConfig.IS_LEFT, "0");
                                        intent.putExtra(PayActivityConfig.PROPS_MON, valueOf4);
                                        UtilHelper.commenDealIntent(this, intent);
                                        this.f = showType;
                                    }
                                }
                            }
                        }
                    }
                } else if ((showType == 0 || showType == 1) && gVar != null && gVar.a != null) {
                    List<h> list2 = gVar.a;
                    if (list2.size() <= 3 && list2.size() >= 0 && this.e <= 2 && this.e >= 0 && this.e < list2.size() && (hVar = list2.get(this.e)) != null) {
                        long j4 = hVar.g;
                        if (j4 >= 0 && j4 != 0 && (valueOf = String.valueOf(j4)) != null) {
                            long j5 = hVar.e;
                            if (j5 >= 0 && (valueOf2 = String.valueOf(j5 / 100)) != null) {
                                long j6 = hVar.d;
                                if (j6 >= 0 && j6 != 0 && (valueOf3 = String.valueOf(j6)) != null) {
                                    intent.putExtra("class", 15);
                                    intent.putExtra(PayActivityConfig.PAY_TYPE, TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                                    intent.putExtra(PayActivityConfig.PROPS_ID, valueOf3);
                                    intent.putExtra(PayActivityConfig.QUAN_NUM, valueOf2);
                                    intent.putExtra(PayActivityConfig.IS_LEFT, "0");
                                    intent.putExtra(PayActivityConfig.PROPS_MON, valueOf);
                                    UtilHelper.commenDealIntent(this, intent);
                                    this.f = showType;
                                }
                            }
                        }
                    }
                }
            }
        } else if (view.getId() == u.arrowadv) {
            if (this.d != null && this.d.a != null) {
                this.d.a.setCurrentItem(1);
                this.d.h = 1;
                this.d.e();
                this.d.f();
                this.d.c();
                this.d.d();
            }
        } else if (view.getId() == u.arrowcommon && this.d != null && this.d.a != null) {
            this.d.a.setCurrentItem(0);
            this.d.h = 2;
            this.d.e();
            this.d.f();
            this.d.c();
            this.d.d();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.d != null) {
            if (1 == i) {
                this.d.h = 1;
                this.d.e();
                this.d.f();
                this.d.c();
                this.d.d();
                return;
            }
            this.d.h = 2;
            this.d.e();
            this.d.f();
            this.d.c();
            this.d.d();
        }
    }
}

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
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class MemberPayActivity extends BaseActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {
    private int aoj;
    private String aok;
    private l aol;
    private int aon;
    private int aom = 1;
    private HttpMessageListener aoo = new a(this, CmdConfigHttp.GETPAYINFO_CMD);
    public HttpMessageListener aop = new b(this, CmdConfigHttp.MEMBER_PAY_CMD);

    static {
        TbadkApplication.m251getInst().RegisterIntent(MemberPayActivityConfig.class, MemberPayActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        if (dVar != null) {
            this.aol.setMemberPayData(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.aoj = getIntent().getExtras().getInt(MemberPayActivityConfig.MEMBER_TYPE);
            this.aok = getIntent().getExtras().getString("st_type");
        }
        AP();
        registerListener(this.aop);
        registerListener(this.aoo);
        showLoadingDialog(getString(y.flist_loading));
        rY();
        AQ();
    }

    private void rY() {
        this.aol = new l(this, this.aoj);
    }

    private void AP() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MEMBER_PAY_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MEMBER_PAY);
        tbHttpMessageTask.setResponsedClass(ResponseMemberPayMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void AQ() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MEMBER_PAY_CMD);
        if (this.aok != null) {
            httpMessage.addParam("st_type", this.aok);
        }
        sendMessage(httpMessage);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aol.onChangeSkinType(i);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (this.aol != null) {
            this.aol.AT();
            if (i == v.btn_price1) {
                this.aom = 0;
            }
            if (i == v.btn_price2) {
                this.aom = 1;
            }
            if (i == v.btn_price3) {
                this.aom = 2;
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
        if (view.getId() == v.buy_btn) {
            if (this.aol != null && (showType = this.aol.getShowType()) >= 0 && showType <= 2) {
                g gVar = this.aol.aoW;
                e eVar = this.aol.aoX;
                Intent intent = new Intent(this, DealIntentService.class);
                if (showType == 2) {
                    if (eVar != null && eVar.aou != null) {
                        List<h> list = eVar.aou;
                        if (list.size() <= 3 && list.size() >= 0 && this.aom <= 2 && this.aom >= 0 && this.aom < list.size() && (hVar2 = list.get(this.aom)) != null) {
                            long j = hVar2.aoC;
                            if (j >= 0 && j != 0 && (valueOf4 = String.valueOf(j)) != null) {
                                long j2 = hVar2.aoA;
                                if (j2 >= 0 && (valueOf5 = String.valueOf(j2 / 100)) != null) {
                                    long j3 = hVar2.aoz;
                                    if (j3 >= 0 && j3 != 0 && (valueOf6 = String.valueOf(j3)) != null) {
                                        intent.putExtra("class", 15);
                                        intent.putExtra("pay_type", "1");
                                        intent.putExtra(PayActivityConfig.PROPS_ID, valueOf6);
                                        intent.putExtra("quan_num", valueOf5);
                                        intent.putExtra(PayActivityConfig.IS_LEFT, "0");
                                        intent.putExtra(PayActivityConfig.PROPS_MON, valueOf4);
                                        UtilHelper.commenDealIntent(this, intent);
                                        this.aon = showType;
                                    }
                                }
                            }
                        }
                    }
                } else if ((showType == 0 || showType == 1) && gVar != null && gVar.aou != null) {
                    List<h> list2 = gVar.aou;
                    if (list2.size() <= 3 && list2.size() >= 0 && this.aom <= 2 && this.aom >= 0 && this.aom < list2.size() && (hVar = list2.get(this.aom)) != null) {
                        long j4 = hVar.aoC;
                        if (j4 >= 0 && j4 != 0 && (valueOf = String.valueOf(j4)) != null) {
                            long j5 = hVar.aoA;
                            if (j5 >= 0 && (valueOf2 = String.valueOf(j5 / 100)) != null) {
                                long j6 = hVar.aoz;
                                if (j6 >= 0 && j6 != 0 && (valueOf3 = String.valueOf(j6)) != null) {
                                    intent.putExtra("class", 15);
                                    intent.putExtra("pay_type", "1");
                                    intent.putExtra(PayActivityConfig.PROPS_ID, valueOf3);
                                    intent.putExtra("quan_num", valueOf2);
                                    intent.putExtra(PayActivityConfig.IS_LEFT, "0");
                                    intent.putExtra(PayActivityConfig.PROPS_MON, valueOf);
                                    UtilHelper.commenDealIntent(this, intent);
                                    this.aon = showType;
                                }
                            }
                        }
                    }
                }
            }
        } else if (view.getId() == v.arrowadv) {
            if (this.aol != null && this.aol.Ct != null) {
                this.aol.Ct.setCurrentItem(1);
                this.aol.apa = 1;
                this.aol.AU();
                this.aol.AV();
                this.aol.AS();
                this.aol.AT();
            }
        } else if (view.getId() == v.arrowcommon && this.aol != null && this.aol.Ct != null) {
            this.aol.Ct.setCurrentItem(0);
            this.aol.apa = 2;
            this.aol.AU();
            this.aol.AV();
            this.aol.AS();
            this.aol.AT();
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
        if (this.aol != null) {
            if (1 == i) {
                this.aol.apa = 1;
                this.aol.AU();
                this.aol.AV();
                this.aol.AS();
                this.aol.AT();
                return;
            }
            this.aol.apa = 2;
            this.aol.AU();
            this.aol.AV();
            this.aol.AS();
            this.aol.AT();
        }
    }
}

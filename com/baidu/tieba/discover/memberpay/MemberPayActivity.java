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
    private int aos;
    private String aot;
    private l aou;
    private int aow;
    private int aov = 1;
    private HttpMessageListener aox = new a(this, CmdConfigHttp.GETPAYINFO_CMD);
    public HttpMessageListener aoy = new b(this, CmdConfigHttp.MEMBER_PAY_CMD);

    static {
        TbadkApplication.m251getInst().RegisterIntent(MemberPayActivityConfig.class, MemberPayActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        if (dVar != null) {
            this.aou.setMemberPayData(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.aos = getIntent().getExtras().getInt(MemberPayActivityConfig.MEMBER_TYPE);
            this.aot = getIntent().getExtras().getString("st_type");
        }
        AR();
        registerListener(this.aoy);
        registerListener(this.aox);
        showLoadingDialog(getString(y.flist_loading));
        sa();
        AS();
    }

    private void sa() {
        this.aou = new l(this, this.aos);
    }

    private void AR() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MEMBER_PAY_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MEMBER_PAY);
        tbHttpMessageTask.setResponsedClass(ResponseMemberPayMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void AS() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MEMBER_PAY_CMD);
        if (this.aot != null) {
            httpMessage.addParam("st_type", this.aot);
        }
        sendMessage(httpMessage);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aou.onChangeSkinType(i);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (this.aou != null) {
            this.aou.AV();
            if (i == v.btn_price1) {
                this.aov = 0;
            }
            if (i == v.btn_price2) {
                this.aov = 1;
            }
            if (i == v.btn_price3) {
                this.aov = 2;
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
            if (this.aou != null && (showType = this.aou.getShowType()) >= 0 && showType <= 2) {
                g gVar = this.aou.apf;
                e eVar = this.aou.apg;
                Intent intent = new Intent(this, DealIntentService.class);
                if (showType == 2) {
                    if (eVar != null && eVar.aoD != null) {
                        List<h> list = eVar.aoD;
                        if (list.size() <= 3 && list.size() >= 0 && this.aov <= 2 && this.aov >= 0 && this.aov < list.size() && (hVar2 = list.get(this.aov)) != null) {
                            long j = hVar2.aoL;
                            if (j >= 0 && j != 0 && (valueOf4 = String.valueOf(j)) != null) {
                                long j2 = hVar2.aoJ;
                                if (j2 >= 0 && (valueOf5 = String.valueOf(j2 / 100)) != null) {
                                    long j3 = hVar2.aoI;
                                    if (j3 >= 0 && j3 != 0 && (valueOf6 = String.valueOf(j3)) != null) {
                                        intent.putExtra("class", 15);
                                        intent.putExtra("pay_type", "1");
                                        intent.putExtra(PayActivityConfig.PROPS_ID, valueOf6);
                                        intent.putExtra("quan_num", valueOf5);
                                        intent.putExtra(PayActivityConfig.IS_LEFT, "0");
                                        intent.putExtra(PayActivityConfig.PROPS_MON, valueOf4);
                                        UtilHelper.commenDealIntent(this, intent);
                                        this.aow = showType;
                                    }
                                }
                            }
                        }
                    }
                } else if ((showType == 0 || showType == 1) && gVar != null && gVar.aoD != null) {
                    List<h> list2 = gVar.aoD;
                    if (list2.size() <= 3 && list2.size() >= 0 && this.aov <= 2 && this.aov >= 0 && this.aov < list2.size() && (hVar = list2.get(this.aov)) != null) {
                        long j4 = hVar.aoL;
                        if (j4 >= 0 && j4 != 0 && (valueOf = String.valueOf(j4)) != null) {
                            long j5 = hVar.aoJ;
                            if (j5 >= 0 && (valueOf2 = String.valueOf(j5 / 100)) != null) {
                                long j6 = hVar.aoI;
                                if (j6 >= 0 && j6 != 0 && (valueOf3 = String.valueOf(j6)) != null) {
                                    intent.putExtra("class", 15);
                                    intent.putExtra("pay_type", "1");
                                    intent.putExtra(PayActivityConfig.PROPS_ID, valueOf3);
                                    intent.putExtra("quan_num", valueOf2);
                                    intent.putExtra(PayActivityConfig.IS_LEFT, "0");
                                    intent.putExtra(PayActivityConfig.PROPS_MON, valueOf);
                                    UtilHelper.commenDealIntent(this, intent);
                                    this.aow = showType;
                                }
                            }
                        }
                    }
                }
            }
        } else if (view.getId() == v.arrowadv) {
            if (this.aou != null && this.aou.Cu != null) {
                this.aou.Cu.setCurrentItem(1);
                this.aou.apj = 1;
                this.aou.AW();
                this.aou.AX();
                this.aou.AU();
                this.aou.AV();
            }
        } else if (view.getId() == v.arrowcommon && this.aou != null && this.aou.Cu != null) {
            this.aou.Cu.setCurrentItem(0);
            this.aou.apj = 2;
            this.aou.AW();
            this.aou.AX();
            this.aou.AU();
            this.aou.AV();
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
        if (this.aou != null) {
            if (1 == i) {
                this.aou.apj = 1;
                this.aou.AW();
                this.aou.AX();
                this.aou.AU();
                this.aou.AV();
                return;
            }
            this.aou.apj = 2;
            this.aou.AW();
            this.aou.AX();
            this.aou.AU();
            this.aou.AV();
        }
    }
}

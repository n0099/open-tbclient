package com.baidu.tieba.callfans;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class a {
    private TbPageContext efr;
    private TextView fRM;
    private ImageView hhd;
    private TextView hhe;
    boolean hhf = false;
    private String mThreadId;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        this.efr = tbPageContext;
        registerTask();
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void cbu() {
        if (!TbSingleton.getInstance().mCanCallFans) {
            this.efr.showToast(R.string.have_used_call_fans_this_week);
        } else if (b.bik().getBoolean("key_call_fans_no_tip_again", false)) {
            cbv();
        } else {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efr.getPageActivity());
            aVar.nw(1);
            View inflate = LayoutInflater.from(this.efr.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitle = (TextView) inflate.findViewById(R.id.title);
            this.fRM = (TextView) inflate.findViewById(R.id.call_fans_intro);
            this.hhe = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            this.hhd = (ImageView) inflate.findViewById(R.id.checkbox);
            bhd();
            this.hhd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.callfans.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hhf = !a.this.hhf;
                    a.this.bhd();
                    b.bik().putBoolean("key_call_fans_no_tip_again", a.this.hhf);
                }
            });
            onChangeSkinType();
            aVar.aX(inflate);
            aVar.a(this.efr.getString(R.string.call_fans), new a.b() { // from class: com.baidu.tieba.callfans.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    a.this.cbv();
                    aVar.dismiss();
                }
            });
            aVar.b(this.efr.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.callfans.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.bik().putBoolean("key_call_fans_no_tip_again", false);
                    aVar.dismiss();
                }
            });
            aVar.b(this.efr).bhg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhd() {
        Drawable a;
        if (this.hhd != null) {
            ImageView imageView = this.hhd;
            if (this.hhf) {
                a = SvgManager.bjq().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a = SvgManager.bjq().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ap.setViewTextColor(this.fRM, R.color.cp_cont_j);
        bhd();
        ap.setViewTextColor(this.hhe, R.color.cp_cont_j);
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CALL_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_CALL_FANS);
        tbHttpMessageTask.setResponsedClass(CallFansResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbv() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CALL_FANS);
        httpMessage.addParam("thread_id", this.mThreadId);
        MessageManager.getInstance().sendMessage(httpMessage);
        this.efr.showToast(R.string.your_thread_is_recommended_to_fans);
        TbSingleton.getInstance().mCallFansTid = this.mThreadId;
        TbSingleton.getInstance().mCanCallFans = false;
    }

    public void i(int i, int i2, String str) {
        TiebaStatic.log(new aq("c13847").ai("obj_source", i).ai("obj_type", i2).dD("tid", str).dD("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

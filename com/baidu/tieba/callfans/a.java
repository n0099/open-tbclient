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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a {
    private TbPageContext eXu;
    private TextView gRm;
    private ImageView ito;
    private TextView itp;
    boolean itq = false;
    private String mThreadId;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        this.eXu = tbPageContext;
        registerTask();
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void cux() {
        if (!TbSingleton.getInstance().mCanCallFans) {
            this.eXu.showToast(R.string.have_used_call_fans_this_week);
        } else if (b.bvr().getBoolean("key_call_fans_no_tip_again", false)) {
            cuy();
        } else {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXu.getPageActivity());
            aVar.pd(1);
            View inflate = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitle = (TextView) inflate.findViewById(R.id.title);
            this.gRm = (TextView) inflate.findViewById(R.id.call_fans_intro);
            this.itp = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            this.ito = (ImageView) inflate.findViewById(R.id.checkbox);
            btV();
            this.ito.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.callfans.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.itq = !a.this.itq;
                    a.this.btV();
                    b.bvr().putBoolean("key_call_fans_no_tip_again", a.this.itq);
                }
            });
            onChangeSkinType();
            aVar.br(inflate);
            aVar.a(this.eXu.getString(R.string.call_fans), new a.b() { // from class: com.baidu.tieba.callfans.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    a.this.cuy();
                    aVar.dismiss();
                }
            });
            aVar.b(this.eXu.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.callfans.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.bvr().putBoolean("key_call_fans_no_tip_again", false);
                    aVar.dismiss();
                }
            });
            aVar.b(this.eXu).btY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btV() {
        Drawable a2;
        if (this.ito != null) {
            ImageView imageView = this.ito;
            if (this.itq) {
                a2 = SvgManager.bwr().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bwr().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ao.setViewTextColor(this.gRm, R.color.CAM_X0107);
        btV();
        ao.setViewTextColor(this.itp, R.color.CAM_X0107);
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CALL_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_CALL_FANS);
        tbHttpMessageTask.setResponsedClass(CallFansResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuy() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CALL_FANS);
        httpMessage.addParam("thread_id", this.mThreadId);
        MessageManager.getInstance().sendMessage(httpMessage);
        this.eXu.showToast(R.string.your_thread_is_recommended_to_fans);
        TbSingleton.getInstance().mCallFansTid = this.mThreadId;
        TbSingleton.getInstance().mCanCallFans = false;
    }

    public void l(int i, int i2, String str) {
        TiebaStatic.log(new aq("c13847").an("obj_source", i).an("obj_type", i2).dX("tid", str).dX("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

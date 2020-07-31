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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class a {
    private TbPageContext dVN;
    private TextView fGr;
    private ImageView gUg;
    private TextView gUh;
    boolean gUi = false;
    private String mThreadId;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        this.dVN = tbPageContext;
        registerTask();
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void bRh() {
        if (!TbSingleton.getInstance().mCanCallFans) {
            this.dVN.showToast(R.string.have_used_call_fans_this_week);
        } else if (b.aZP().getBoolean("key_call_fans_no_tip_again", false)) {
            bRi();
        } else {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dVN.getPageActivity());
            aVar.lq(1);
            View inflate = LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitle = (TextView) inflate.findViewById(R.id.title);
            this.fGr = (TextView) inflate.findViewById(R.id.call_fans_intro);
            this.gUh = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            this.gUg = (ImageView) inflate.findViewById(R.id.checkbox);
            aYI();
            this.gUg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.callfans.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gUi = !a.this.gUi;
                    a.this.aYI();
                    b.aZP().putBoolean("key_call_fans_no_tip_again", a.this.gUi);
                }
            });
            onChangeSkinType();
            aVar.aV(inflate);
            aVar.a(this.dVN.getString(R.string.call_fans), new a.b() { // from class: com.baidu.tieba.callfans.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    a.this.bRi();
                    aVar.dismiss();
                }
            });
            aVar.b(this.dVN.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.callfans.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.aZP().putBoolean("key_call_fans_no_tip_again", false);
                    aVar.dismiss();
                }
            });
            aVar.b(this.dVN).aYL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYI() {
        Drawable a;
        if (this.gUg != null) {
            ImageView imageView = this.gUg;
            if (this.gUi) {
                a = SvgManager.baR().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a = SvgManager.baR().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a);
        }
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ao.setViewTextColor(this.fGr, R.color.cp_cont_j);
        aYI();
        ao.setViewTextColor(this.gUh, R.color.cp_cont_j);
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CALL_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_CALL_FANS);
        tbHttpMessageTask.setResponsedClass(CallFansResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRi() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CALL_FANS);
        httpMessage.addParam("thread_id", this.mThreadId);
        MessageManager.getInstance().sendMessage(httpMessage);
        this.dVN.showToast(R.string.your_thread_is_recommended_to_fans);
        TbSingleton.getInstance().mCallFansTid = this.mThreadId;
        TbSingleton.getInstance().mCanCallFans = false;
    }

    public void j(int i, int i2, String str) {
        TiebaStatic.log(new ap("c13847").ah("obj_source", i).ah("obj_type", i2).dn("tid", str).dn("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

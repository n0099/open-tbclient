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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class a {
    private TbPageContext eGu;
    private TextView gwO;
    private ImageView hVU;
    private TextView hVV;
    boolean hVW = false;
    private String mThreadId;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        this.eGu = tbPageContext;
        registerTask();
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void cnp() {
        if (!TbSingleton.getInstance().mCanCallFans) {
            this.eGu.showToast(R.string.have_used_call_fans_this_week);
        } else if (b.bpu().getBoolean("key_call_fans_no_tip_again", false)) {
            cnq();
        } else {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGu.getPageActivity());
            aVar.ov(1);
            View inflate = LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitle = (TextView) inflate.findViewById(R.id.title);
            this.gwO = (TextView) inflate.findViewById(R.id.call_fans_intro);
            this.hVV = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            this.hVU = (ImageView) inflate.findViewById(R.id.checkbox);
            bod();
            this.hVU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.callfans.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hVW = !a.this.hVW;
                    a.this.bod();
                    b.bpu().putBoolean("key_call_fans_no_tip_again", a.this.hVW);
                }
            });
            onChangeSkinType();
            aVar.bg(inflate);
            aVar.a(this.eGu.getString(R.string.call_fans), new a.b() { // from class: com.baidu.tieba.callfans.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    a.this.cnq();
                    aVar.dismiss();
                }
            });
            aVar.b(this.eGu.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.callfans.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.bpu().putBoolean("key_call_fans_no_tip_again", false);
                    aVar.dismiss();
                }
            });
            aVar.b(this.eGu).bog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bod() {
        Drawable a2;
        if (this.hVU != null) {
            ImageView imageView = this.hVU;
            if (this.hVW) {
                a2 = SvgManager.bqB().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bqB().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.gwO, R.color.CAM_X0107);
        bod();
        ap.setViewTextColor(this.hVV, R.color.CAM_X0107);
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CALL_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_CALL_FANS);
        tbHttpMessageTask.setResponsedClass(CallFansResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnq() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CALL_FANS);
        httpMessage.addParam("thread_id", this.mThreadId);
        MessageManager.getInstance().sendMessage(httpMessage);
        this.eGu.showToast(R.string.your_thread_is_recommended_to_fans);
        TbSingleton.getInstance().mCallFansTid = this.mThreadId;
        TbSingleton.getInstance().mCanCallFans = false;
    }

    public void k(int i, int i2, String str) {
        TiebaStatic.log(new ar("c13847").ak("obj_source", i).ak("obj_type", i2).dR("tid", str).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

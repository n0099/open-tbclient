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
    private TbPageContext efn;
    private TextView fRI;
    private ImageView hgZ;
    private TextView hha;
    boolean hhb = false;
    private String mThreadId;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        this.efn = tbPageContext;
        registerTask();
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void cbt() {
        if (!TbSingleton.getInstance().mCanCallFans) {
            this.efn.showToast(R.string.have_used_call_fans_this_week);
        } else if (b.bik().getBoolean("key_call_fans_no_tip_again", false)) {
            cbu();
        } else {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efn.getPageActivity());
            aVar.nw(1);
            View inflate = LayoutInflater.from(this.efn.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitle = (TextView) inflate.findViewById(R.id.title);
            this.fRI = (TextView) inflate.findViewById(R.id.call_fans_intro);
            this.hha = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            this.hgZ = (ImageView) inflate.findViewById(R.id.checkbox);
            bhd();
            this.hgZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.callfans.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hhb = !a.this.hhb;
                    a.this.bhd();
                    b.bik().putBoolean("key_call_fans_no_tip_again", a.this.hhb);
                }
            });
            onChangeSkinType();
            aVar.aX(inflate);
            aVar.a(this.efn.getString(R.string.call_fans), new a.b() { // from class: com.baidu.tieba.callfans.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    a.this.cbu();
                    aVar.dismiss();
                }
            });
            aVar.b(this.efn.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.callfans.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.bik().putBoolean("key_call_fans_no_tip_again", false);
                    aVar.dismiss();
                }
            });
            aVar.b(this.efn).bhg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhd() {
        Drawable a;
        if (this.hgZ != null) {
            ImageView imageView = this.hgZ;
            if (this.hhb) {
                a = SvgManager.bjq().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a = SvgManager.bjq().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ap.setViewTextColor(this.fRI, R.color.cp_cont_j);
        bhd();
        ap.setViewTextColor(this.hha, R.color.cp_cont_j);
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CALL_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_CALL_FANS);
        tbHttpMessageTask.setResponsedClass(CallFansResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbu() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CALL_FANS);
        httpMessage.addParam("thread_id", this.mThreadId);
        MessageManager.getInstance().sendMessage(httpMessage);
        this.efn.showToast(R.string.your_thread_is_recommended_to_fans);
        TbSingleton.getInstance().mCallFansTid = this.mThreadId;
        TbSingleton.getInstance().mCanCallFans = false;
    }

    public void i(int i, int i2, String str) {
        TiebaStatic.log(new aq("c13847").ai("obj_source", i).ai("obj_type", i2).dD("tid", str).dD("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

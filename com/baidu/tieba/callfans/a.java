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
/* loaded from: classes20.dex */
public class a {
    private TbPageContext ehG;
    private TextView fUX;
    private ImageView hoh;
    private TextView hoi;
    boolean hoj = false;
    private String mThreadId;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        this.ehG = tbPageContext;
        registerTask();
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void ceJ() {
        if (!TbSingleton.getInstance().mCanCallFans) {
            this.ehG.showToast(R.string.have_used_call_fans_this_week);
        } else if (b.bjf().getBoolean("key_call_fans_no_tip_again", false)) {
            ceK();
        } else {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ehG.getPageActivity());
            aVar.nH(1);
            View inflate = LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitle = (TextView) inflate.findViewById(R.id.title);
            this.fUX = (TextView) inflate.findViewById(R.id.call_fans_intro);
            this.hoi = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            this.hoh = (ImageView) inflate.findViewById(R.id.checkbox);
            bhX();
            this.hoh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.callfans.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hoj = !a.this.hoj;
                    a.this.bhX();
                    b.bjf().putBoolean("key_call_fans_no_tip_again", a.this.hoj);
                }
            });
            onChangeSkinType();
            aVar.aZ(inflate);
            aVar.a(this.ehG.getString(R.string.call_fans), new a.b() { // from class: com.baidu.tieba.callfans.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    a.this.ceK();
                    aVar.dismiss();
                }
            });
            aVar.b(this.ehG.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.callfans.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.bjf().putBoolean("key_call_fans_no_tip_again", false);
                    aVar.dismiss();
                }
            });
            aVar.b(this.ehG).bia();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhX() {
        Drawable a;
        if (this.hoh != null) {
            ImageView imageView = this.hoh;
            if (this.hoj) {
                a = SvgManager.bkl().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a = SvgManager.bkl().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ap.setViewTextColor(this.fUX, R.color.cp_cont_j);
        bhX();
        ap.setViewTextColor(this.hoi, R.color.cp_cont_j);
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CALL_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_CALL_FANS);
        tbHttpMessageTask.setResponsedClass(CallFansResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceK() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CALL_FANS);
        httpMessage.addParam("thread_id", this.mThreadId);
        MessageManager.getInstance().sendMessage(httpMessage);
        this.ehG.showToast(R.string.your_thread_is_recommended_to_fans);
        TbSingleton.getInstance().mCallFansTid = this.mThreadId;
        TbSingleton.getInstance().mCanCallFans = false;
    }

    public void j(int i, int i2, String str) {
        TiebaStatic.log(new aq("c13847").ai("obj_source", i).ai("obj_type", i2).dF("tid", str).dF("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

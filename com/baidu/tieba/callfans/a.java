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
/* loaded from: classes21.dex */
public class a {
    private TbPageContext eIc;
    private TextView gxh;
    private ImageView hVu;
    private TextView hVv;
    boolean hVw = false;
    private String mThreadId;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        this.eIc = tbPageContext;
        registerTask();
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void cnN() {
        if (!TbSingleton.getInstance().mCanCallFans) {
            this.eIc.showToast(R.string.have_used_call_fans_this_week);
        } else if (b.bqh().getBoolean("key_call_fans_no_tip_again", false)) {
            cnO();
        } else {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIc.getPageActivity());
            aVar.oz(1);
            View inflate = LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitle = (TextView) inflate.findViewById(R.id.title);
            this.gxh = (TextView) inflate.findViewById(R.id.call_fans_intro);
            this.hVv = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            this.hVu = (ImageView) inflate.findViewById(R.id.checkbox);
            boZ();
            this.hVu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.callfans.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hVw = !a.this.hVw;
                    a.this.boZ();
                    b.bqh().putBoolean("key_call_fans_no_tip_again", a.this.hVw);
                }
            });
            onChangeSkinType();
            aVar.bf(inflate);
            aVar.a(this.eIc.getString(R.string.call_fans), new a.b() { // from class: com.baidu.tieba.callfans.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    a.this.cnO();
                    aVar.dismiss();
                }
            });
            aVar.b(this.eIc.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.callfans.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.bqh().putBoolean("key_call_fans_no_tip_again", false);
                    aVar.dismiss();
                }
            });
            aVar.b(this.eIc).bpc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boZ() {
        Drawable a2;
        if (this.hVu != null) {
            ImageView imageView = this.hVu;
            if (this.hVw) {
                a2 = SvgManager.brn().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.brn().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ap.setViewTextColor(this.gxh, R.color.cp_cont_j);
        boZ();
        ap.setViewTextColor(this.hVv, R.color.cp_cont_j);
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CALL_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_CALL_FANS);
        tbHttpMessageTask.setResponsedClass(CallFansResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnO() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CALL_FANS);
        httpMessage.addParam("thread_id", this.mThreadId);
        MessageManager.getInstance().sendMessage(httpMessage);
        this.eIc.showToast(R.string.your_thread_is_recommended_to_fans);
        TbSingleton.getInstance().mCallFansTid = this.mThreadId;
        TbSingleton.getInstance().mCanCallFans = false;
    }

    public void l(int i, int i2, String str) {
        TiebaStatic.log(new aq("c13847").al("obj_source", i).al("obj_type", i2).dR("tid", str).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

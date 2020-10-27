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
    private TbPageContext eCn;
    private TextView grt;
    private ImageView hPx;
    private TextView hPy;
    boolean hPz = false;
    private String mThreadId;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        this.eCn = tbPageContext;
        registerTask();
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void clm() {
        if (!TbSingleton.getInstance().mCanCallFans) {
            this.eCn.showToast(R.string.have_used_call_fans_this_week);
        } else if (b.bnH().getBoolean("key_call_fans_no_tip_again", false)) {
            cln();
        } else {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCn.getPageActivity());
            aVar.op(1);
            View inflate = LayoutInflater.from(this.eCn.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitle = (TextView) inflate.findViewById(R.id.title);
            this.grt = (TextView) inflate.findViewById(R.id.call_fans_intro);
            this.hPy = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            this.hPx = (ImageView) inflate.findViewById(R.id.checkbox);
            bmz();
            this.hPx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.callfans.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hPz = !a.this.hPz;
                    a.this.bmz();
                    b.bnH().putBoolean("key_call_fans_no_tip_again", a.this.hPz);
                }
            });
            onChangeSkinType();
            aVar.bb(inflate);
            aVar.a(this.eCn.getString(R.string.call_fans), new a.b() { // from class: com.baidu.tieba.callfans.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    a.this.cln();
                    aVar.dismiss();
                }
            });
            aVar.b(this.eCn.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.callfans.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.bnH().putBoolean("key_call_fans_no_tip_again", false);
                    aVar.dismiss();
                }
            });
            aVar.b(this.eCn).bmC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmz() {
        Drawable a2;
        if (this.hPx != null) {
            ImageView imageView = this.hPx;
            if (this.hPz) {
                a2 = SvgManager.boN().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.boN().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ap.setViewTextColor(this.grt, R.color.cp_cont_j);
        bmz();
        ap.setViewTextColor(this.hPy, R.color.cp_cont_j);
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CALL_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_CALL_FANS);
        tbHttpMessageTask.setResponsedClass(CallFansResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cln() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CALL_FANS);
        httpMessage.addParam("thread_id", this.mThreadId);
        MessageManager.getInstance().sendMessage(httpMessage);
        this.eCn.showToast(R.string.your_thread_is_recommended_to_fans);
        TbSingleton.getInstance().mCallFansTid = this.mThreadId;
        TbSingleton.getInstance().mCanCallFans = false;
    }

    public void l(int i, int i2, String str) {
        TiebaStatic.log(new aq("c13847").aj("obj_source", i).aj("obj_type", i2).dR("tid", str).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

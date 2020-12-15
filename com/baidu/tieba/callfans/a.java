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
/* loaded from: classes21.dex */
public class a {
    private TbPageContext eNx;
    private TextView gFB;
    private ImageView igT;
    private TextView igU;
    boolean igV = false;
    private String mThreadId;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        this.eNx = tbPageContext;
        registerTask();
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void crD() {
        if (!TbSingleton.getInstance().mCanCallFans) {
            this.eNx.showToast(R.string.have_used_call_fans_this_week);
        } else if (b.bsO().getBoolean("key_call_fans_no_tip_again", false)) {
            crE();
        } else {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNx.getPageActivity());
            aVar.oT(1);
            View inflate = LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitle = (TextView) inflate.findViewById(R.id.title);
            this.gFB = (TextView) inflate.findViewById(R.id.call_fans_intro);
            this.igU = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            this.igT = (ImageView) inflate.findViewById(R.id.checkbox);
            brs();
            this.igT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.callfans.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.igV = !a.this.igV;
                    a.this.brs();
                    b.bsO().putBoolean("key_call_fans_no_tip_again", a.this.igV);
                }
            });
            onChangeSkinType();
            aVar.bi(inflate);
            aVar.a(this.eNx.getString(R.string.call_fans), new a.b() { // from class: com.baidu.tieba.callfans.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    a.this.crE();
                    aVar.dismiss();
                }
            });
            aVar.b(this.eNx.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.callfans.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.bsO().putBoolean("key_call_fans_no_tip_again", false);
                    aVar.dismiss();
                }
            });
            aVar.b(this.eNx).brv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brs() {
        Drawable a2;
        if (this.igT != null) {
            ImageView imageView = this.igT;
            if (this.igV) {
                a2 = SvgManager.btW().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.btW().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.gFB, R.color.CAM_X0107);
        brs();
        ap.setViewTextColor(this.igU, R.color.CAM_X0107);
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CALL_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_CALL_FANS);
        tbHttpMessageTask.setResponsedClass(CallFansResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crE() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CALL_FANS);
        httpMessage.addParam("thread_id", this.mThreadId);
        MessageManager.getInstance().sendMessage(httpMessage);
        this.eNx.showToast(R.string.your_thread_is_recommended_to_fans);
        TbSingleton.getInstance().mCallFansTid = this.mThreadId;
        TbSingleton.getInstance().mCanCallFans = false;
    }

    public void l(int i, int i2, String str) {
        TiebaStatic.log(new ar("c13847").al("obj_source", i).al("obj_type", i2).dY("tid", str).dY("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

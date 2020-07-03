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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a {
    private TbPageContext dPv;
    private TextView fBh;
    private ImageView gOA;
    private TextView gOB;
    boolean gOC = false;
    private String mThreadId;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        this.dPv = tbPageContext;
        xp();
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void bNV() {
        if (!TbSingleton.getInstance().mCanCallFans) {
            this.dPv.showToast(R.string.have_used_call_fans_this_week);
        } else if (b.aVP().getBoolean("key_call_fans_no_tip_again", false)) {
            bNX();
        } else {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPv.getPageActivity());
            aVar.kW(1);
            View inflate = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitle = (TextView) inflate.findViewById(R.id.title);
            this.fBh = (TextView) inflate.findViewById(R.id.call_fans_intro);
            this.gOB = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            this.gOA = (ImageView) inflate.findViewById(R.id.checkbox);
            bNW();
            this.gOA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.callfans.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gOC = !a.this.gOC;
                    a.this.bNW();
                    b.aVP().putBoolean("key_call_fans_no_tip_again", a.this.gOC);
                }
            });
            onChangeSkinType();
            aVar.aP(inflate);
            aVar.a(this.dPv.getString(R.string.call_fans), new a.b() { // from class: com.baidu.tieba.callfans.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    a.this.bNX();
                    aVar.dismiss();
                }
            });
            aVar.b(this.dPv.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.callfans.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.aVP().putBoolean("key_call_fans_no_tip_again", false);
                    aVar.dismiss();
                }
            });
            aVar.b(this.dPv).aUN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNW() {
        Drawable a;
        if (this.gOA != null) {
            ImageView imageView = this.gOA;
            if (this.gOC) {
                a = SvgManager.aWQ().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a = SvgManager.aWQ().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a);
        }
    }

    public void onChangeSkinType() {
        an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.fBh, (int) R.color.cp_cont_j);
        bNW();
        an.setViewTextColor(this.gOB, (int) R.color.cp_cont_j);
    }

    private void xp() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CALL_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_CALL_FANS);
        tbHttpMessageTask.setResponsedClass(CallFansResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNX() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CALL_FANS);
        httpMessage.addParam("thread_id", this.mThreadId);
        MessageManager.getInstance().sendMessage(httpMessage);
        this.dPv.showToast(R.string.your_thread_is_recommended_to_fans);
        TbSingleton.getInstance().mCallFansTid = this.mThreadId;
        TbSingleton.getInstance().mCanCallFans = false;
    }
}

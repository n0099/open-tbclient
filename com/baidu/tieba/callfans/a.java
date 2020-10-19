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
    private TbPageContext etO;
    private TextView ghq;
    private ImageView hDb;
    private TextView hDc;
    boolean hDd = false;
    private String mThreadId;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        this.etO = tbPageContext;
        registerTask();
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void cif() {
        if (!TbSingleton.getInstance().mCanCallFans) {
            this.etO.showToast(R.string.have_used_call_fans_this_week);
        } else if (b.blO().getBoolean("key_call_fans_no_tip_again", false)) {
            cig();
        } else {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.etO.getPageActivity());
            aVar.oe(1);
            View inflate = LayoutInflater.from(this.etO.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.mTitle = (TextView) inflate.findViewById(R.id.title);
            this.ghq = (TextView) inflate.findViewById(R.id.call_fans_intro);
            this.hDc = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            this.hDb = (ImageView) inflate.findViewById(R.id.checkbox);
            bkG();
            this.hDb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.callfans.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hDd = !a.this.hDd;
                    a.this.bkG();
                    b.blO().putBoolean("key_call_fans_no_tip_again", a.this.hDd);
                }
            });
            onChangeSkinType();
            aVar.ba(inflate);
            aVar.a(this.etO.getString(R.string.call_fans), new a.b() { // from class: com.baidu.tieba.callfans.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    a.this.cig();
                    aVar.dismiss();
                }
            });
            aVar.b(this.etO.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.callfans.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.blO().putBoolean("key_call_fans_no_tip_again", false);
                    aVar.dismiss();
                }
            });
            aVar.b(this.etO).bkJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkG() {
        Drawable a2;
        if (this.hDb != null) {
            ImageView imageView = this.hDb;
            if (this.hDd) {
                a2 = SvgManager.bmU().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bmU().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ap.setViewTextColor(this.ghq, R.color.cp_cont_j);
        bkG();
        ap.setViewTextColor(this.hDc, R.color.cp_cont_j);
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CALL_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_CALL_FANS);
        tbHttpMessageTask.setResponsedClass(CallFansResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cig() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CALL_FANS);
        httpMessage.addParam("thread_id", this.mThreadId);
        MessageManager.getInstance().sendMessage(httpMessage);
        this.etO.showToast(R.string.your_thread_is_recommended_to_fans);
        TbSingleton.getInstance().mCallFansTid = this.mThreadId;
        TbSingleton.getInstance().mCanCallFans = false;
    }

    public void k(int i, int i2, String str) {
        TiebaStatic.log(new aq("c13847").aj("obj_source", i).aj("obj_type", i2).dK("tid", str).dK("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

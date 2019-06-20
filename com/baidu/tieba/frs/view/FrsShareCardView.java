package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsShareCardView extends LinearLayout {
    private LinearLayout bNa;
    private TextView bmf;
    private Context context;
    private EditText fQL;
    private HeadImageView fQM;
    private TextView fQN;
    private TextView fQO;
    private ShareFromFrsMsgData fQP;

    public EditText getChatMsgView() {
        return this.fQL;
    }

    public void ai(String str, boolean z) {
        if (this.fQM != null) {
            this.fQM.startLoad(str, 15, false);
        }
    }

    public FrsShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        ap(context);
    }

    public FrsShareCardView(Context context) {
        super(context);
        this.context = context;
        ap(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.fQM.setPageId(bdUniqueId);
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.bNa = (LinearLayout) findViewById(R.id.share_content);
        this.bmf = (TextView) findViewById(R.id.frs_card_name);
        this.fQL = (EditText) findViewById(R.id.chat_msg);
        this.fQM = (HeadImageView) findViewById(R.id.frs_card_img);
        this.fQO = (TextView) findViewById(R.id.frs_card_member_num);
        this.fQN = (TextView) findViewById(R.id.frs_card_post_num);
        al.f(this.bmf, R.color.cp_cont_b, 1);
        al.f(this.fQL, R.color.cp_cont_b, 2);
        this.fQL.setHintTextColor(al.getColor(R.color.cp_cont_e));
        this.fQL.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        brC();
    }

    public void brC() {
        this.bNa.setFocusable(true);
        this.bNa.setFocusableInTouchMode(true);
        this.bNa.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fQL != null) {
            return k.a(this.fQL.getText(), null);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.fQP = shareFromFrsMsgData;
        Jf();
    }

    private void Jf() {
        this.bmf.setText(nU(this.fQP.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.fQP.getImageUrl());
        this.fQM.startLoad(this.fQP.getImageUrl(), 15, false);
        this.fQO.setText(ap.aL(this.fQP.getMemberNum()));
        this.fQN.setText(ap.aL(this.fQP.getPostNum()));
    }

    private String nU(String str) {
        return ap.i(str, 18) + this.context.getString(R.string.forum);
    }
}

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
    private LinearLayout bMZ;
    private TextView bmf;
    private Context context;
    private EditText fQI;
    private HeadImageView fQJ;
    private TextView fQK;
    private TextView fQL;
    private ShareFromFrsMsgData fQM;

    public EditText getChatMsgView() {
        return this.fQI;
    }

    public void ai(String str, boolean z) {
        if (this.fQJ != null) {
            this.fQJ.startLoad(str, 15, false);
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
        this.fQJ.setPageId(bdUniqueId);
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.bMZ = (LinearLayout) findViewById(R.id.share_content);
        this.bmf = (TextView) findViewById(R.id.frs_card_name);
        this.fQI = (EditText) findViewById(R.id.chat_msg);
        this.fQJ = (HeadImageView) findViewById(R.id.frs_card_img);
        this.fQL = (TextView) findViewById(R.id.frs_card_member_num);
        this.fQK = (TextView) findViewById(R.id.frs_card_post_num);
        al.f(this.bmf, R.color.cp_cont_b, 1);
        al.f(this.fQI, R.color.cp_cont_b, 2);
        this.fQI.setHintTextColor(al.getColor(R.color.cp_cont_e));
        this.fQI.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        brx();
    }

    public void brx() {
        this.bMZ.setFocusable(true);
        this.bMZ.setFocusableInTouchMode(true);
        this.bMZ.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fQI != null) {
            return k.a(this.fQI.getText(), null);
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
        this.fQM = shareFromFrsMsgData;
        Jf();
    }

    private void Jf() {
        this.bmf.setText(nV(this.fQM.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.fQM.getImageUrl());
        this.fQJ.startLoad(this.fQM.getImageUrl(), 15, false);
        this.fQL.setText(ap.aL(this.fQM.getMemberNum()));
        this.fQK.setText(ap.aL(this.fQM.getPostNum()));
    }

    private String nV(String str) {
        return ap.i(str, 18) + this.context.getString(R.string.forum);
    }
}

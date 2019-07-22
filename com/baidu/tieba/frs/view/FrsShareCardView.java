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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsShareCardView extends LinearLayout {
    private LinearLayout bOb;
    private TextView bmT;
    private Context context;
    private EditText fVI;
    private HeadImageView fVJ;
    private TextView fVK;
    private TextView fVL;
    private ShareFromFrsMsgData fVM;

    public EditText getChatMsgView() {
        return this.fVI;
    }

    public void am(String str, boolean z) {
        if (this.fVJ != null) {
            this.fVJ.startLoad(str, 15, false);
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
        this.fVJ.setPageId(bdUniqueId);
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.bOb = (LinearLayout) findViewById(R.id.share_content);
        this.bmT = (TextView) findViewById(R.id.frs_card_name);
        this.fVI = (EditText) findViewById(R.id.chat_msg);
        this.fVJ = (HeadImageView) findViewById(R.id.frs_card_img);
        this.fVL = (TextView) findViewById(R.id.frs_card_member_num);
        this.fVK = (TextView) findViewById(R.id.frs_card_post_num);
        am.f(this.bmT, R.color.cp_cont_b, 1);
        am.f(this.fVI, R.color.cp_cont_b, 2);
        this.fVI.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.fVI.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        btD();
    }

    public void btD() {
        this.bOb.setFocusable(true);
        this.bOb.setFocusableInTouchMode(true);
        this.bOb.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fVI != null) {
            return k.a(this.fVI.getText(), null);
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
        this.fVM = shareFromFrsMsgData;
        JS();
    }

    private void JS() {
        this.bmT.setText(om(this.fVM.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.fVM.getImageUrl());
        this.fVJ.startLoad(this.fVM.getImageUrl(), 15, false);
        this.fVL.setText(aq.aM(this.fVM.getMemberNum()));
        this.fVK.setText(aq.aM(this.fVM.getPostNum()));
    }

    private String om(String str) {
        return aq.i(str, 18) + this.context.getString(R.string.forum);
    }
}

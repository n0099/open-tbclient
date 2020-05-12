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
/* loaded from: classes9.dex */
public class FrsShareCardView extends LinearLayout {
    private TextView cTw;
    private Context context;
    private EditText hCk;
    private HeadImageView hCl;
    private TextView hCm;
    private TextView hCn;
    private ShareFromFrsMsgData hCo;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.hCk;
    }

    public void as(String str, boolean z) {
        if (this.hCl != null) {
            this.hCl.startLoad(str, 15, false);
        }
    }

    public FrsShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        initUI(context);
    }

    public FrsShareCardView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.hCl.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.cTw = (TextView) findViewById(R.id.frs_card_name);
        this.hCk = (EditText) findViewById(R.id.chat_msg);
        this.hCl = (HeadImageView) findViewById(R.id.frs_card_img);
        this.hCn = (TextView) findViewById(R.id.frs_card_member_num);
        this.hCm = (TextView) findViewById(R.id.frs_card_post_num);
        am.setViewTextColor(this.cTw, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.hCk, R.color.cp_cont_b, 2);
        this.hCk.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.hCk.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        bWG();
    }

    public void bWG() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.hCk != null) {
            return k.charSequence2String(this.hCk.getText(), null);
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
        this.hCo = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.cTw.setText(getShortName(this.hCo.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.hCo.getImageUrl());
        this.hCl.startLoad(this.hCo.getImageUrl(), 15, false);
        this.hCn.setText(aq.numFormatOver10000(this.hCo.getMemberNum()));
        this.hCm.setText(aq.numFormatOver10000(this.hCo.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
